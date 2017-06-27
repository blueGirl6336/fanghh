Ext.define('HRMS.store.dictionary.RoofStructerStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'roofStructer',
	
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'01060000'};
	}

});