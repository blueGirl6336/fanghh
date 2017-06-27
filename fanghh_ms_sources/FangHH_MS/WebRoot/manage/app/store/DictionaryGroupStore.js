/**
 * 数据字典store
 * 此store特用来存储分组
 */
Ext.define('HRMS.store.DictionaryGroupStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.Dictionary',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'dictionary/getAllGroup',
			create : 'dictionary/add',
			update : 'dictionary/update',
			destroy : 'dictionary/deleteGroup'
		},
		actionMethods :{
			read: 'GET',
			create:'POST',
			update:'POST',
			destroy: 'GET'
		},
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