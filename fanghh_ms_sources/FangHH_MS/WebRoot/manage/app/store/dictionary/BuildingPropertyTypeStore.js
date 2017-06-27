Ext.define('HRMS.store.dictionary.BuildingPropertyTypeStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'buildingPropertyType',
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'01050000'};
	}

});