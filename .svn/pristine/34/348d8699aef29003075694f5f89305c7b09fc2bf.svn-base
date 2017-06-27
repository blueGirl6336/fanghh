Ext.define('HRMS.store.dictionary.PersonnelDictionaryGroupStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.Dictionary',
	storeId: 'personnelGroupDictionary',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		url: 'dictionary/getAllGroup',
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
		},
		extraParams:{
			moduleCode : 2
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