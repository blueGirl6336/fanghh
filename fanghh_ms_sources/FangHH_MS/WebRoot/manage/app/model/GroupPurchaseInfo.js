Ext.define('HRMS.model.GroupPurchaseInfo', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'gpId',
		type : 'int'
	}, {
		name : 'building'
	}, {
		name : 'buildingName'
	}, {
		name : 'activityId'
	}, {
		name : 'activityPic'
	},{
		name : 'personNumInFavor',
		type : 'number'
	},{
		name : 'minPersonNumStandard',
		type : 'number'
	},{
		name : 'startTime',
		type : 'date'
	},{
		name : 'endTime',
		type : 'date'
	},{
		name : 'totalOfferNum',
		type : 'number'
	},{
		name : 'currentPurchasedNum',
		type : 'number'
	},{
		name : 'orginalPricePerSquareMeter',
		type : 'number'
	},{
		name : 'orginalHousePrice',
		type : 'number'
	},{
		name : 'currentPricePerSquareMetre',
		type : 'number'
	},{
		name : 'currentHouse',
		type : 'number'
	},{
		name : 'purchaseNote'
	},{
		name : 'isSuccess',
		type : 'boolean'
	},]
});
