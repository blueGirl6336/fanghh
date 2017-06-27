Ext.define('HRMS.store.dictionary.HouseStatusStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'houseStatus',
	
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'01080000'};
	}

});