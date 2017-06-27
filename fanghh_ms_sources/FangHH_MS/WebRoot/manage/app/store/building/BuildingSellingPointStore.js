// 楼盘卖点Store
Ext.define('HRMS.store.building.BuildingSellingPointStore', {
	model : 'HRMS.model.BuildingSellingPoint',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'buildingSellingPoint/search',
			create : 'buildingSellingPoint/add',
			update : 'buildingSellingPoint/update',
			destroy : 'buildingSellingPoint/delete'
		},
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
		},
		writer : {
			type : 'json',
			writeAllFields : true,
			encode : false,
			allowSingle : false
		},
		listeners : {
			exception : function(proxy, response, operation) {
				Ext.MessageBox.show({
					title : '错误',
					msg : proxy.reader.rawData.message,
					icon : Ext.MessageBox.ERROR,
					buttons : Ext.Msg.OK
				});
			}
		}
	}

});