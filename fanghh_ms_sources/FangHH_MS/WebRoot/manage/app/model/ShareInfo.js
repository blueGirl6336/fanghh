Ext.define('HRMS.model.ShareInfo', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'shareId',
		type : 'int'
	}, {
		name : 'building'
	}, {
		name : 'title'
	}, {
		name : 'issueTime',
		type : 'date'
	}, {
		name : 'cashBack',
		type : 'number'
	}, {
		name : 'totalCash',
		type : 'number'
	}, {
		name : 'remainCash',
		type : 'number'
	}]
});
