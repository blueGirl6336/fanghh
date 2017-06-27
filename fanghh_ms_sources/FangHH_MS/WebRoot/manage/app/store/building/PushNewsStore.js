Ext.define('HRMS.store.building.PushNewsStore', {
	model : 'HRMS.model.PushNews',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'pushNews',
	proxy : {
		type : 'ajax',
		api : {
			read : 'pushNews/search',
			create : 'pushNews/add',
			update : 'pushNews/update',
			destroy : 'pushNews/delete'
		},
		actionMethods : {
			read : 'POST',
			create : 'POST',
			update : 'POST',
			destroy : 'POST'
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