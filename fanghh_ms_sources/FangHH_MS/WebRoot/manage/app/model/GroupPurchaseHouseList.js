Ext.define('HRMS.model.GroupPurchaseHouseList', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'gphId',
		type : 'int'
	}, {
		name : 'house'
	}, {
		name : 'houseName'
	},{
		name : 'childOrderId'
	}, {
		name : 'isPurchased'
	}, {
		name : 'childOrderStatus'
	},{
		name : 'activityId'
	}]
});
