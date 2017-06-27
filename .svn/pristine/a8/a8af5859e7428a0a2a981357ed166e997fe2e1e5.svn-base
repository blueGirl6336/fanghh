Ext.define('HRMS.store.dictionary.PersonnelDictionaryItemStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'personnelDictionary',
	
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.url =  'dictionary/getItemsByModule';
		me.proxy.extraParams = {moduleCode:2};
	}

});