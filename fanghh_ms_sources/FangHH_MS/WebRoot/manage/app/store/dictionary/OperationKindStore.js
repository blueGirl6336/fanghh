Ext.define('HRMS.store.dictionary.OperationKindStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'operationKind',
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.url =  'dictionary/getItemsByGroupCode';
		me.proxy.extraParams = {groupCode:'08010000'};
	}
});