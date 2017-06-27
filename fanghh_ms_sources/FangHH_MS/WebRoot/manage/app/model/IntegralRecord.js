Ext.define('HRMS.model.IntegralRecord', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'recordId',
		type : 'int'
	}, {
		name : 'user'
	},{
		name : 'integralNum',
		type : 'int'
	},{
		name : 'time',
		type : 'date'
	},{
		name : 'operation'
	}]
});
