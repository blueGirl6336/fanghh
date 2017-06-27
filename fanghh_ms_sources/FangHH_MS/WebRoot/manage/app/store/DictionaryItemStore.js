Ext.define('HRMS.store.DictionaryItemStore', {
    extend: 'Ext.data.Store',
    model: 'HRMS.model.Dictionary',
    autoLoad: false,
    proxy : {
		type : 'ajax',
		api : {
			read : 'dictionary/getItemsByGroupCode',
			create : 'dictionary/add',
			update : 'dictionary/update',
			destroy : 'dictionary/delete'
		},
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
		},
		actionMethods:{read:'POST'},
	    extraParams: {
			groupName:''
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