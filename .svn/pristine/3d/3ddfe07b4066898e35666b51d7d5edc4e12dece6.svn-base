Ext.define('HRMS.store.dictionary.CommentKindStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'commentKind',
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.url =  'dictionary/getItemsByGroupCode';
		me.proxy.extraParams = {groupCode:'04010000'};
	}
});