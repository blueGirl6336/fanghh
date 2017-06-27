Ext.define('HRMS.model.IntegralLevel', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'ilId',
		type : 'int'
	}, {
		name : 'userLevel',
		type : 'int'
	}, {
		name : 'lowestStandard',
		type : 'int'
	}, {
		name : 'highestStandard',
		type : 'int'
	}]
});
