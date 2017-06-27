Ext.define('HRMS.model.PerferentialHouseInfo', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'phiId',
		type : 'int'
	}, {
		name : 'building'
	},{
		name : 'buildingName'
	}, {
		name : 'activityId'
	}, {
		name : 'activityPic'
	},{
		name : 'startTime',
		type : 'date'
	},{
		name : 'endTime',
		type : 'date'
	},{
		name : 'purchaseNote'
	},{
		name : 'remark'
	}]
});
