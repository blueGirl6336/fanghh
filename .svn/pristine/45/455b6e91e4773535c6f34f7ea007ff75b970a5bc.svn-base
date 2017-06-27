//联系方式 store
Ext.define('HRMS.store.personnel.ContactStore', {
	model : 'HRMS.model.Contact',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'contact/getByEmpNo',
			create : 'contact/add',
			update : 'contact/update',
			destroy : 'contact/delete'
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
					title : '错误代码:'+response.status,
					msg : response.statusText,
					icon : Ext.MessageBox.ERROR,
					buttons : Ext.Msg.OK
				});
			}
		}
	}

});