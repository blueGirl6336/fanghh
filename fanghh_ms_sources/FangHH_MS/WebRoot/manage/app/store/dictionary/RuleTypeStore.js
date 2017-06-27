Ext.define('HRMS.store.dictionary.RuleTypeStore', {
	extend : 'HRMS.store.dictionary.BaseDictionaryStore',
	storeId: 'ruleType',
	constructor : function(cfg) {
		var me = this;
		me.callParent(cfg);
		me.proxy.extraParams = {groupCode:'18010000'};
	}
});