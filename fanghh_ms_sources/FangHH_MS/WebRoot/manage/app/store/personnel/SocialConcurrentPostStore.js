//社会兼职 store
Ext.define('HRMS.store.personnel.SocialConcurrentPostStore', {
	model : 'HRMS.model.SocialConcurrentPost',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'socialpost/getByEmpNo',
			create : 'socialpost/add',
			update : 'socialpost/update',
			destroy : 'socialpost/delete'
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