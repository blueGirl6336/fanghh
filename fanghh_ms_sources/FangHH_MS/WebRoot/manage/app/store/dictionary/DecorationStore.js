Ext.define('HRMS.store.dictionary.DecorationStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'decoration',
	
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'01100000'};
	}

});