Ext.define('HRMS.module.rsgl.rygl.rybmbd.view.PersonLlist', {
	extend : 'Ext.grid.Panel',
	alias: 'widget.tansferpersonlist',
	layout : 'fit',
	title : '人员选择',
	border : 0,
	frame:true,
	departmentCode : 1,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	initComponent : function() {
		var me = this;
		me.store = Ext.create('HRMS.store.personnel.PersonBaseInfoStore',{id:'transfer-baseinfostore'});
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40,
			text : '序号'
		}, {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'empNo',
			text : '工号'
		}, {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'name',
			text : '姓名'
		},{
			xtype : 'mycolumn',
			flex:1,
			align : 'center',
			dataIndex : 'department',
			text : '所属部门',
			renderer : me.departmentTypeRender
		},{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'sub_unit',
			text : '二级单位',
			renderer : me.subUnitTypeRender
		}
		];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			defaults:{
				padding:'0 4 1 4'
			},
			items : [{
				xtype : 'combobox',
				name : 'department',
				autoSelect : true,
				fieldLabel : '部门',
				emptyText : '部门',
				labelWidth : 30,
				width:200,
				labelAlign : 'right',
				queryMode : 'local',
				store : Ext.getStore('department'),
				valueField : 'code',
				displayField : 'name',
                listeners : {
					specialKey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
							me.searchPerson();
						}
					}
				}
			},{
				xtype : 'textfield',
				fieldLabel : '姓名',
				hideLabel : false,
				labelAlign : 'right',
				labelWidth : 30,
				width:150,
				name : 'name',
				emptyText : '姓名(优先查询）',
                listeners : {
					specialKey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
							me.searchPerson();
						}
					}
				}
			}, {
				xtype : 'textfield',
				fieldLabel : '工号',
				name : 'empNo',
				labelWidth : 30,
				width:120,
				labelAlign : 'right',
				hideLabel : false,
				emptyText : '工号',
                listeners : {
					specialKey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
							me.searchPerson();
						}
					}
				}
			}, {
				xtype : 'button',
				text : '查询',
				listeners : {
					click : {
						fn : me.searchPerson,
						scope : me
					}
				}
			} ]
		} ];
		this.callParent(arguments);
	},
	dateRender: function(val){
		if(val == null || val == '')
			return '';
		if(val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m/d');
	},
	departmentTypeRender : function(val) {
		if(val == 0)
			return '';
		store = Ext.getStore('department');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	subUnitTypeRender : function(val) {
		store = Ext.getStore('allsubunit');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	searchPerson : function() {
		var empNoValue = this.down('textfield[name=empNo]').getValue();
		var nameValue = this.down('textfield[name=name]').getValue();
		var departmentValue = this.down('combobox[name=department]').getValue();
		var store = this.store;

		if ((empNoValue != null && empNoValue != '')
				|| (nameValue != null && nameValue != '') || (departmentValue != null && departmentValue != '') ) {
			store.proxy.api.read = "baseinfo/search";
			store.proxy.actionMethods = {
				read : 'POST'
			};
			store.proxy.extraParams = {
				quota : 1,
				name : nameValue,
				empNo : empNoValue,
				department : departmentValue,
				doe: null
			};
			store.load();
		}else{
			Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
		}

	}

});