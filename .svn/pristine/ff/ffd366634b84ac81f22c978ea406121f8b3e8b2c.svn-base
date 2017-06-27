Ext.define('HRMS.module.lpgl.ldxxgl.view.OperationFormPanel', {
	extend : 'Ext.grid.Panel',
	alias: 'widget.stafftransferform',
	layout : 'fit',
	title : '单元信息',
	border : 0,
	frame:true,
	roofBeam:0,	
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	store : Ext.create('HRMS.store.building.UnitStore'),
	initComponent : function() {
		var me = this;
		//me.store = Ext.create('HRMS.store.building.UnitStore');
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40,
			align : 'center',
			text : '序号',
			hidden:true
		},{
			xtype : 'mycolumn',
			hidden:true,
			width : 40,
			dataIndex : 'unitId',
			align : 'center',
		}, {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'unitCode',
			text : '单元号',
			editor : {
				xtype : 'textfield',
				allowBlank : false
			}
		}];
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
			},{
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
	refreshData : function() {
		var me = this;
		if (this.roofBeam == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
				roofId : this.roofBeam.roofId
		};
		store.load({
			callback : function( records, successful) {
				Ext.each(records, function(rec) {
					rec.stripeRows = true;
				});
			}
		});
	},
	addNewItem : function() {
		var rec = new HRMS.model.Unit({
			roofBeam : this.roofBeam
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
	commit : function() {
		var me = this;
		this.store.sync({
			'success' : function(a, b) {
				Ext.MessageBox.show({
					title : '操作成功',
					msg : a.proxy.reader.rawData.message,
					icon : Ext.MessageBox.OK,
					buttons : Ext.Msg.OK
				});
				me.refreshData();
			}
		});
	}
});