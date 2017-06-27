// 楼盘卖点Store
Ext.define('HRMS.store.building.ConsultantCommentFromBrokerStore', {
	model : 'HRMS.model.ConsultantCommentFromBroker',
	extend : 'Ext.data.Store',
	storeId : 'consultantCommentFromBroker',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'consultantCommentFromBroker/search',
			create : 'consultantCommentFromBroker/add',
			update : 'consultantCommentFromBroker/update',
			destroy : 'consultantCommentFromBroker/delete'			
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