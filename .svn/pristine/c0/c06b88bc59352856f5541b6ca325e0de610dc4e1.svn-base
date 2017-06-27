// 楼盘卖点Store
Ext.define('HRMS.store.building.BuildingNameStore', {
	model : 'HRMS.model.Building',
	extend : 'Ext.data.Store',
	storeId : 'buildName',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'building/getAll',
//			create : 'building/add',
//			update : 'building/update',
//			destroy : 'building/delete'			
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