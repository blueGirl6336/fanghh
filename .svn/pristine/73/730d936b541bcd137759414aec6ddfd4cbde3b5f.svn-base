// 基础store
Ext.define('HRMS.store.BaseStore', {
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
		},
		writer : {
			type : 'json',
			writeAllFields : true,
			encode : false
		},
		listeners : {
			exception : function(proxy, response, operation) {
				Ext.MessageBox.show( {
					title : '错误',
					msg: proxy.reader.rawData.message,
					icon : Ext.MessageBox.ERROR,
					buttons : Ext.Msg.OK
				});
			}
		}
	}

});