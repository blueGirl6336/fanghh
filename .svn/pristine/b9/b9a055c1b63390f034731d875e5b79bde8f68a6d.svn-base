// 楼盘卖点Store
Ext.define('HRMS.store.building.DeveloperStore', {
	model : 'HRMS.model.Developer',
	extend : 'Ext.data.Store',
	storeId : 'developer',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'developer/search',
			create : 'developer/add',
			update : 'developer/update',
			destroy : 'developer/delete'			
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