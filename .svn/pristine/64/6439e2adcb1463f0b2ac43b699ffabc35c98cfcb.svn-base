Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.Quota', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '编制信息',
	border : 0,
	baseInfo : 0,
	store : Ext.create('HRMS.store.personnel.QuotaStore'),
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
		},  {
			xtype : 'mycolumn',
			width : 200,
			dataIndex : 'quota_type',
			text : '编制类型',
			renderer : me.quotaTypeRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'quotaType',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'since',
			text : '聘任日期',
			renderer: me.dateRender,
			editor : {
				 xtype: 'datefield',
                 format: 'Y/m/d'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'quotaConvertDate',
			text : '编制转换日期',
			renderer: me.dateRender,
			editor : {
				 xtype: 'datefield',
                 format: 'Y/m/d'
			}
		},  {
			xtype : 'mycolumn',
			width : 200,
			dataIndex : 'employment_mode',
			text : '聘任方式',
			renderer : me.employTypeRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'employType',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 150,
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
	dateRender: function(val){
		if(val == null || val == '')
			return '';
		if(val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m/d');
	},
	refreshData : function() {
		if (this.baseInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			empNo : this.baseInfo.empNo
		};
		store.load();
	},
	quotaTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('quotaType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	employTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('employType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	addNewItem : function() {
		
		if(this.getStore().getCount( ) >= 1){
			Ext.Msg.alert('操作错误', '不能添加，只能有一条编制信息！');
			this.cellEditing.startEditByPosition({
				row : 0,
				column : 1
			});
			return;
		}

		var empNo = this.baseInfo.empNo;
		// Create a model instance
		// 需要设置baseinfo属性 要不然传入后台时 为null会出错
		var rec = new HRMS.model.Quota({
			baseinfo: this.baseInfo,
			quota_type:0,
			employment_mode:0
		});

		this.getStore().insert(0, rec);
		this.cellEditing.startEditByPosition({
			row : 0,
			column : 1
		});

	},
	commit : function() {
		this.store.sync({
			'success' : function(a, b) {
				Ext.MessageBox.show({
					title : '操作成功',
					msg : a.proxy.reader.rawData.message,
					icon : Ext.MessageBox.OK,
					buttons : Ext.Msg.OK
				});
			}
		});

	}
});