Ext.define('HRMS.store.building.CommissionRuleStore', {
	model : 'HRMS.model.CommissionRule',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'commissionRuleStore',
	proxy : {
		type : 'ajax',
		api : {
			read : 'commissionRule/search',
			create : 'commissionRule/add',
			update : 'commissionRule/update',
			destroy : 'commissionRule/delete'
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