Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.QuerySymbolChoice', {
	extend : 'Ext.grid.Panel',
	alias:'widget.symbolChoice',
	layout : 'fit',
	// title : '对比符号选择',
	border : 0,
	baseInfo : 0,
	width : 110,
	margin : '0 0 0 1',
	store : Ext.create('Ext.data.Store', {
		model : 'SymbolModel',
		data : [ {
			"id" : 1,
			"symbol" : '>'
		}, {
			"id" : 2,
			"symbol" : '>='
		}, {
			"id" : 3,
			"symbol" : '='
		}, {
			"id" : 4,
			"symbol" : '<'
		}, {
			"id" : 5,
			"symbol" : '<='
		}
		]
	}),
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
			dataIndex : 'symbol',
			text : '比较符'
		} ];
		this.callParent(arguments);
	}
});