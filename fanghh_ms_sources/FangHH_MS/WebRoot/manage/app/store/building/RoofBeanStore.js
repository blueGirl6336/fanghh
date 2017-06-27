// 楼盘卖点Store
Ext.define('HRMS.store.building.RoofBeanStore', {
	model : 'HRMS.model.RoofBean',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'xx/getByEmpNo',
			create : 'xx/add',
			update : 'xx/update',
			destroy : 'xx/delete'
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