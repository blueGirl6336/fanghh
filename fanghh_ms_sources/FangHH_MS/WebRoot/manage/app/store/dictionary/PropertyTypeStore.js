Ext.define('HRMS.store.dictionary.PropertyTypeStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'propertyType',
	
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'01050000'};
	}

});