Ext.define('HRMS.module.lpgl.wygl.view.BuildingSellingPoint', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '楼盘卖点',
	border : 0,
	buildingInfo : 0,
	store : Ext.create('HRMS.store.building.BuildingSellingPointStore'),
	closable : false,
	autoScroll:true,
	collapsible: true,
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
			dataIndex : 'bspId'
		},{
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'title',
			text : '卖点标题',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'issueTime',
			text : '发布日期',
			renderer:  me.dateRender
			
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
		else
			return Ext.util.Format.date(val, 'Y-m-d');
	},
	refreshData : function() {
		if (this.baseInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			buildingId: this.buildingInfo.buildingId
		};
		store.load();
	},
	addNewItem : function() {

		var rec = new HRMS.model.BuildingSellingPoint({
			building : this.buildingInfo
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