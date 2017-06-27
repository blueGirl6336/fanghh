Ext.define('HRMS.module.rsgl.rygl.rybmbd.view.OperationFormPanel', {
	extend : 'Ext.form.Panel',
	alias: 'widget.stafftransferform',
	frame : true,
	title : '部门变动操作',
	buttonAlign:'center',
	bodyPadding : 10,
	fieldDefaults : {
		labelAlign : 'right',
		labelWidth : 135,
		msgTarget : 'side'
	},
	initComponent : function() {
		var me = this;
		this.items = [ {
			xtype : 'fieldset',
			title : '人员信息',
			defaultType : 'textfield',
			defaults : {
				width : 350
			},
			items : [ {
				readOnly:true,
				fieldLabel : '工号',
				name : 'empNo'
			}, {
				readOnly:true,
				fieldLabel : '姓名',
				name : 'name'
			}, {
				readOnly:true,
				fieldLabel : '出生日期',
				name : 'dob'
			} , {
				readOnly:true,
				fieldLabel : '部门',
				name : 'department'
			}, {
				readOnly:true,
				fieldLabel : '二级单位',
				name : 'sub_unit'
			} ]
		}, {
			xtype : 'fieldset',
			title : '目标部门',
			defaultType : 'textfield',
			defaults : {
				width : 350
			},
			items : [{
				xtype : 'combobox',
				fieldLabel : '目标部门',
				name : 'aim_department',
				store: Ext.getStore('department'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true,
				queryMode : 'local',
				listeners : {
					select : function(combo, record, index) {
						try {
							var se = me.getForm().findField('subunit');
							se.clearValue();
							var store = se.getStore();
							store.proxy.extraParams={department:this.value};
							store.load();
						} catch (ex) {
							Ext.MessageBox.alert("错误", "数据加载失败。");
						}
					}
				}
			},{
				xtype : 'combobox',
				fieldLabel : '二级单位',
				name : 'subunit',
				store: Ext.create('HRMS.store.dictionary.SubUnitStore'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true
			}, {
				xtype : 'datefield',
				fieldLabel : '调动日期',
				name : 'transfer_date',
				format: 'Y/m/d',
				value:new Date(),
				allowBlank : false
			}, {
				fieldLabel : '变动后管理职务',
				name : 'managePost_title'
			},{
				fieldLabel : '变动后技术职务',
				name : 'techPost_title'
			},{
				fieldLabel : '备注',
				name : 'remark'
			}]
		}];

		this.callParent();
	},

	buttons : [ {
		text : '确定',
		action: 'submit',
		disabled : true,
		formBind : true
	} ]
});