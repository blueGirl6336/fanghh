Ext.define('HRMS.store.building.ClearanceHouseListStore', {
	model : 'HRMS.model.ClearanceHouseList',
	extend : 'Ext.data.Store',
	storeId : 'clearanceHouseListStore',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'clearanceHouseList/search',
			create : 'clearanceHouseList/add',
			update : 'clearanceHouseList/update',
			destroy : 'clearanceHouseList/delete'			
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