Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryValueChoice', {
	extend : 'Ext.grid.Panel',
	alias:'widget.valueChoice',
	layout : 'fit',
	border : 0,
	baseInfo : 0,
	width : 200,
	margin : '0 0 0 1',
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	initComponent : function() {
		var me = this;
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit :2
		});
		me.columns = [ {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			flex:1,
			align : 'center',
			dataIndex : 'name',
			text : '目标值输入',
			editor : {
				xtype : 'textfield'
			}
		} ];
		this.plugins = [ this.cellEditing ];
		this.store = Ext.create('HRMS.store.DictionaryItemStore',{id:'xxjs-value-choice-dictionaryItem'});
		this.store.proxy.api.read = "dictionary/getItemsByGroupCode";
		this.callParent(arguments);	
	}
});