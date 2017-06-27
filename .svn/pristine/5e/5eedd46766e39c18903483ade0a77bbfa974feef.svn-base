Ext.define('HRMS.store.building.BrokerStore', {
	model : 'HRMS.model.Broker',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'broker',
	proxy : {
		type : 'ajax',
		api : {
			read : 'broker/getAll',
//			create : 'broker/add',
//			update : 'broker/update',
//			destroy : 'broker/delete'
		},
		actionMethods : {
			read : 'POST',
//			create : 'POST',
//			update : 'POST',
//			destroy : 'POST'
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