Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.AbroadAndVisiting', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '海外经历',
	border : 0,
	baseInfo: 0,
	store : Ext.create('HRMS.store.personnel.AbroadAndVisitingStore'),
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
//	selModel : {
//		selType : 'cellmodel'
//	},
	initComponent : function() {
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});

		var me = this;
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'aav_from',
			text : '开始日期',
			renderer:  me.dateRender,
			editor : {
				 xtype: 'datefield',
                 format: 'Y/m'
			}
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'aav_to',
			text : '结束日期',
			renderer:  me.dateRender,
			editor : {
				 xtype: 'datefield',
                 format: 'Y/m'
			}
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'country',
			text : '留学国家/地区',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'university',
			text : '院校/企业',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'sub_unit',
			text : '院系/部门',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'post',
			text : '身份/职务',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'study_type',
			text : '留学身份',
			renderer: me.studyTypeRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'studyType',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'dispatch_type',
			text : '派遣方式',
			renderer: me.dispatchTypeRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'dispatchType',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'remark',
			text : '备注',
			flex: 2,
			editor : {
				xtype : 'textfield'
			}
		} ];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : '添加新项',
				listeners : {
					click : {
						fn : me.addNewItem,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '删除选中行',
				listeners : {
					click : {
						fn : me.deleteChosenItem,
						scope : me
					}
				}

			}, {
				xtype : 'button',
				text : '刷新',
				listeners : {
					click : {
						fn : me.refreshData,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '保存修改',
				listeners : {
					click : {
						fn : me.commit,
						scope : me
					}
				}
			} ]
		} ];
		this.plugins = [ this.cellEditing ];
		this.callParent(arguments);
	},
	refreshData: function(){
		if(this.baseInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			empNo : this.baseInfo.empNo
		};
		store.load();
	},
	dateRender: function(val){
		if(val == null || val == '')
			return '';
		if(val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m');
	},
	abroadTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('abroadType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	studyTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('studyType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	dispatchTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('dispatchType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	addNewItem : function() {
		
		var empNo = this.baseInfo.empNo;
		// Create a model instance
		// 需要设置baseinfo属性 要不然传入后台时 为null会出错
		var rec = new HRMS.model.AbroadAndVisiting({
			baseinfo : this.baseInfo,
			throughAudit:true,
			// 留学类别
			aav_type : 0,

			// 学习类别
			study_type : 0,

			// 派遣方式
			dispatch_type : 0
		});

		this.getStore().insert(0, rec);
		this.cellEditing.startEditByPosition({
			row : 0,
			column : 1
		});

	},
	deleteChosenItem : function() {
		
		var position = this.getSelectionModel().getCurrentPosition();
		if (position == null) {
			return;
		}
		
		var me = this;
		Ext.MessageBox.confirm("确认", "是否确认删除？", function (btn) {
            if(btn == 'yes'){
            	me.store.removeAt(position.row);
            	me.commit();
            }
        });
	},
	commit: function(){
		this.store.sync({
			'success' : function(a, b) {
				Ext.MessageBox.show({
					title : '操作成功',
					msg : a.proxy.reader.rawData.message,
					icon : Ext.MessageBox.OK,
					buttons : Ext.Msg.OK
				});
				this.load();
			}
		});
		
		
	}
});