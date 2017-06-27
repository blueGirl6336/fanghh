Ext.define('HRMS.store.dictionary.PushNewsTypeStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'pushNewsType',
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = { groupCode:'05020000' };
	}

});