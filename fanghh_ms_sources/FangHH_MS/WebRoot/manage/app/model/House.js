Ext.define('HRMS.model.House', {
	extend : 'Ext.data.Model',

	fields : [ {
		name : 'houseId',
		type : 'int'
	}, {
		name : 'building'
	},{
		name : 'unit'
	}, {
		name : 'houseType'
	},{
		name : 'houseStyleCode',
	},{
		name : 'floor'
	}, {
		name : 'houseStyle',
	},{
		name : 'houseNum'
	}, {
		name : 'houseStatus'
	}, {
		name : 'face'
	}, {
		name : 'decoration'
	}, {
		name : 'remark'
	}, {
		name : 'highestCommission',
		type : 'number'
	}, {
		name : 'area',
		type : 'number'
	}, {
		name : 'orginalPricePerSquare',
		type : 'number'
	}, {
		name : 'currentPricePerSquare',
		type : 'number'
	}, {
		name : 'orginalPrice',
		type : 'number'
	}, {
		name : 'currentPrice',
		type : 'number'
	},{ 
		name : 'haveBasement', 
		type:'boolean' 
	}, { 
		name : 'basementSquare',
		type : 'number'
	},{ 
		name : 'basementPrice',
		type : 'number'
	}, { 
		name : 'hasParkingPlace',
		type : 'boolean'
	}, {
		name : 'otherFacility'
	}, {
		name : 'attachedHouseDescription'
	},{
		name : 'masterBedroomFace'
	}]
});