Ext.define('HRMS.module.rsgl.rygl.rydl.view.OperationFormPanel', {
	extend : 'Ext.form.Panel',
	alias : 'widget.stafftransferform',
	frame : true,
	title : '人员调动操作',
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
			items : [ {
				readOnly : true,
				fieldLabel : '工号',
				name : 'empNo'
			}, {
				readOnly : true,
				fieldLabel : '姓名',
				name : 'name'
			}, {
				readOnly : true,
				fieldLabel : '出生日期',
				name : 'dob'
			}, {
				readOnly : true,
				fieldLabel : '部门',
				name : 'department'
			} , {
				readOnly : true,
				fieldLabel : '人员状态',
				name : 'workState',
				renderer: this.workStateRender
			}]
		}, {
			xtype : 'fieldset',
			title : '变动信息',
			defaultType : 'textfield',
			items : [ {
				xtype : 'combobox',
				allowBlank:false,
				fieldLabel : '变动类型',
				name : 'transfer_type',
				store : Ext.getStore('transferType'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true,
				queryMode : 'local',
				listeners : {
					'beforequery' : function(e) {
						var combo = e.combo;
						// 过滤为调出的选项
						combo.store.filterBy(function(record) {
							var mode = record.get('value');
							if (mode == 'out') {
								return true;
							}
							return false;
						});
						// 展开
						combo.expand();
						return false;
					}
				}
			}, {
				fieldLabel : '目标单位',
				emptyText : '调离或离职填写',
				name : 'to_unit'
			}, {
				xtype : 'datefield',
				fieldLabel : '变动日期',
				name : 'transfer_date',
				format : 'Y/m/d',
				value : new Date(),
				allowBlank : false
			}, {
				fieldLabel : '备注',
				name : 'remark'
			}]
		} ];

		this.callParent();
	},
	buttons : [ {
		text : '确定',
		action : 'submit',
		disabled : true,
		formBind : true
	} ]
});