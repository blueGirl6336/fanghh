Ext.define('HRMS.store.building.ClearanceHouseInfoStore', {
	model : 'HRMS.model.ClearanceHouseInfo',
	extend : 'Ext.data.Store',
	storeId : 'clearanceHouseInfoStore',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'clearanceHouseInfo/search',
			create : 'clearanceHouseInfo/add',
			update : 'clearanceHouseInfo/update',
			destroy : 'clearanceHouseInfo/delete'			
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