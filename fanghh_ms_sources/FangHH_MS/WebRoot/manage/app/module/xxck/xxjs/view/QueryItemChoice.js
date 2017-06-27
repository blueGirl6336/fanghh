Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryItemChoice', {
	extend : 'Ext.grid.Panel',
	alias:'widget.itemChoice',
	layout : 'fit',
//	title : '查询字段选择',
	border : 0,
	baseInfo: 0,
	width: 200,
	store : Ext.create('HRMS.store.personnel.QueryBeanStore'),
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	initComponent : function() {

		var me = this;
		me.columns = [ {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			flex:1,
			align : 'center',
			dataIndex : 'name',
			text : '字段名'
		}, 
		{
			xtype : 'mycolumn',
			width : 150,
			hidden : true,
			dataIndex : 'relativities'
		},{
			xtype : 'mycolumn',
			width : 150,
			hidden : true,
			dataIndex : 'entityName'
		},{
			xtype : 'mycolumn',
			width : 150,
			hidden : true,
			dataIndex : 'input_type'
		},{
			xtype : 'mycolumn',
			width : 150,
			hidden : true,
			dataIndex : 'dic_code'
		}];
		this.callParent(arguments);
	}
});