Ext.define('HRMS.model.ClearanceHouseInfo', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'chiId',
		type : 'number'
	}, {
		name : 'house'
	}, {
		name : 'buildingName'
	},{
		name : 'buildingId'
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
	},{
		name : 'building'
	},{
		name : 'rule'
	}]
});
