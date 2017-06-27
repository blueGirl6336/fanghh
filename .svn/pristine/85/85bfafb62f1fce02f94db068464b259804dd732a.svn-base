// 楼盘卖点Store
Ext.define('HRMS.store.building.HouseStore', {
	model : 'HRMS.model.House',
	extend : 'Ext.data.Store',
	storeId : 'houseStore',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'house/search',
			create : 'house/add',
			update : 'house/update',
			destroy : 'house/delete'
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