Ext.define('HRMS.store.building.IntegralRecordStore', {
	model : 'HRMS.model.IntegralRecord',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'integralRecord',
	proxy : {
		type : 'ajax',
		api : {
			read : 'integralRecord/search',
			create : 'integralRecord/add',
			update : 'integralRecord/update',
			destroy : 'integralRecord/delete'
		},
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
		},
		actionMethods : {
			read : 'POST',
			create : 'POST',
			update : 'POST',
			destroy : 'POST'
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