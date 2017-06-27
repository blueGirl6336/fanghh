Ext.define('HRMS.module.lpgl.wygl.view.SurroundFacility', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '周边设施',
	border : 0,
	buildingInfo: 0,
	store : Ext.create('HRMS.store.building.SurroundFacilityStore'),
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
			dataIndex : 'sfId'
		}, {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'busStation',
			text : '公交站',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'school',
			text : '学校',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'hospital',
			text : '医院',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'bank',
			text : '银行',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'entertainment',
			text : '娱乐',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'shopping',
			text : '商场',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'repast',
			text : '餐饮',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'exercise',
			text : '运动健身',
			editor : {
				xtype : 'textfield'
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
		if(this.buildingInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			buildingId : this.buildingInfo.buildingId
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
		
		var rec = new HRMS.model.SurroundFacility({
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