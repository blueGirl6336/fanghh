// 楼盘卖点Store
Ext.define('HRMS.store.building.ShareInfoStore', {
	model : 'HRMS.model.ShareInfo',
	extend : 'Ext.data.Store',
	storeId : 'shareInfo',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'shareInfo/search',
			create : 'shareInfo/add',
			update : 'shareInfo/update',
//			destroy : 'shareInfo/delete'			
		},
		/*actionMethods : {
			read : 'POST',
			create : 'POST',
			update : 'POST',
			destroy : 'POST'
		},*/
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