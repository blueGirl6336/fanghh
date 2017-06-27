// 用户信息store
Ext.define('HRMS.store.UserStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.User',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		api : {
			read : 'user/getAll',
			create : 'user/add',
			update : 'user/update',
			destroy : 'user/delete'
		},
		actionMethods :{
			read: 'POST'
		},
		extraParams : {
			realName : ''
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