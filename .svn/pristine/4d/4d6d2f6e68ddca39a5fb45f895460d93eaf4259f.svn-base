// 楼盘卖点Store
Ext.define('HRMS.store.building.BrokerCommentFromConsultantStore', {
	model : 'HRMS.model.BrokerCommentFromConsultant',
	extend : 'Ext.data.Store',
	storeId : 'brokerCommentFromConsultant',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'brokerCommentFromConsultant/search',
			create : 'brokerCommentFromConsultant/add',
			update : 'brokerCommentFromConsultant/update',
			destroy : 'brokerCommentFromConsultant/delete'			
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