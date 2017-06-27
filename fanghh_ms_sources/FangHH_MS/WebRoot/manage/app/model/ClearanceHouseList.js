Ext.define('HRMS.model.ClearanceHouseList', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'chlId',
		type : 'number'
	}, {
		name : 'house'
	}, {
		name : 'activityId'
	},  {
		name : 'houseNum'
	}, {
		name : 'childOrderId'
	},{
		name : 'isPurchased',
		type : 'boolean'
	},{
		name : 'childOrderStatus'
	}]
});
