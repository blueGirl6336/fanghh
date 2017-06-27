// 楼盘卖点Store
Ext.define('HRMS.store.building.SalesDirectorStore', {
	model : 'HRMS.model.SalesDirector',
	extend : 'Ext.data.Store',
	storeId : 'salesDirector',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'salesDirector/getAll',
			create : 'salesDirector/add',
			update : 'salesDirector/update',
			destroy : 'salesDirector/delete'			
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