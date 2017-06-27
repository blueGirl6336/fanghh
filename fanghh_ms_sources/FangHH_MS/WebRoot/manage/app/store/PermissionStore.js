Ext.define('HRMS.store.PermissionStore', {
    extend: 'Ext.data.Store',
    model: 'HRMS.model.Permission',
    autoLoad: false,
    proxy : {
		type : 'ajax',
		api : {
			read : 'permission/getByRole',
			create : 'permission/add',
			update : 'permission/update',
			destroy : 'permission/delete'
		},
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
		},
	   
		extraParams: {
			roleCode:''
	    },
		writer : {
			type : 'json',
			writeAllFields : true,
			encode : false,
			allowSingle : false
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