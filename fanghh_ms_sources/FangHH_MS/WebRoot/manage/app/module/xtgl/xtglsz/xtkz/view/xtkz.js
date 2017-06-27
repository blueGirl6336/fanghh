Ext.define('HRMS.module.xtgl.xtglsz.xtkz.view.xtkz', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '系统配置',
	border : 0,
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	store : Ext.create('HRMS.store.ConfigBeanStore'),
	initComponent : function() {
		var me = this;
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 1
		});
		me.columns = [ {
			xtype : 'rownumberer'
		}, {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'name',
			text : '姓名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			dataIndex : 'displayName',
			text : '显示姓名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'value',
			text : '值',
			editor : {
				xtype : 'textfield'
			}
		}
		];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			items :[ {
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
		var store = this.getStore();
		store.load();
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
