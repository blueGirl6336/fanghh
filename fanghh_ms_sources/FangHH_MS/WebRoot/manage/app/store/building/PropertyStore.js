// 物业信息store
Ext.define('HRMS.store.building.PropertyStore', {
	model : 'HRMS.model.Property',
	extend : 'Ext.data.Store',
	storeId : 'property',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'Property/search',
			create : 'Property/add',
			update : 'Property/update',
			destroy : 'Property/delete'			
		},
//		actionMethods : {
//			read : 'POST',
//			create : 'POST',
//			update : 'POST',
//			destroy : 'POST'
//		},
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