Ext.define('HRMS.store.building.CityStore', {
	model : 'HRMS.model.City',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'city',
	proxy : {
		type : 'ajax',
		api : {
			read : 'city/search',
			create : 'city/add',
			update : 'city/update',
			destroy : 'city/delete'
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