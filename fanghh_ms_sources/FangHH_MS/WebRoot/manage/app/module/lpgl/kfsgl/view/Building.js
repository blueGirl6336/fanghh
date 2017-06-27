Ext.define('HRMS.module.lpgl.kfsgl.view.Building', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '楼盘',
	border : 0,
	developerInfo : 0,
	store : Ext.create('HRMS.store.building.BuildingStore'),
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	// selModel : {
	// selType : 'cellmodel'
	// },
	initComponent : function() {
		var me = this;
		me.columns = [
				{
					xtype : 'rownumberer',
					text : '序号',
					width : 40
				}
				,{
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'buildingName',
					text : '楼盘名称',
					editor : {
						xtype : 'textfield'
					}
				}];
		this.callParent(arguments);
	},
	refreshData : function() {
		if (this.developerInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			buildingId : this.developerInfo.buildingId
		};
		store.load();
	}
});