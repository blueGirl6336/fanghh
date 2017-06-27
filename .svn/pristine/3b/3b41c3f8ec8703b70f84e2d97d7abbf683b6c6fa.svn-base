// 楼盘卖点Store
Ext.define('HRMS.store.building.IntegralRuleStore', {
	model : 'HRMS.model.IntegralRule',
	extend : 'Ext.data.Store',
	storeId : 'integralRule',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'integralRule/search',
			create : 'integralRule/add',
			update : 'integralRule/update',
			destroy : 'integralRule/delete'			
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