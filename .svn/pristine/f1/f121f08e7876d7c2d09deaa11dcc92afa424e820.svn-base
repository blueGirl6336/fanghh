// 系统配置store
Ext.define('HRMS.store.ConfigBeanStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.ConfigBean',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		api : {
			read : 'config/getAll',
			update : 'config/update'
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