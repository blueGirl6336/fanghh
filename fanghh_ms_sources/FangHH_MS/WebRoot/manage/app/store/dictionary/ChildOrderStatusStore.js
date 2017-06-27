Ext.define('HRMS.store.dictionary.ChildOrderStatusStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'childOrderStatus',
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'02010000'};
	}
});