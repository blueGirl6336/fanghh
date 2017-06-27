Ext.define('HRMS.model.BuildingSellingPoint', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'bspId',
		type : 'int'
	}, {
		name : 'building'
	}, {
		name : 'title'
	}, {
		name : 'issueTime',
		type : 'time'
	}]
});
