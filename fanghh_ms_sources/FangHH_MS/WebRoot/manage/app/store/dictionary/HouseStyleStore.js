Ext.define('HRMS.store.dictionary.HouseStyleStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'houseStyle',
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'03010300'};
	}
});