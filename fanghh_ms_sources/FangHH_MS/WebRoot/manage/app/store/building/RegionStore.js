Ext.define('HRMS.store.building.RegionStore', {
	model : 'HRMS.model.Region',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'region',
	proxy : {
		type : 'ajax',
		api : {
			read : 'region/search',
			create : 'region/add',
			update : 'region/update',
			destroy : 'region/delete'
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