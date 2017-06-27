// 单元Store
Ext.define('HRMS.store.building.UnitStore', {
	model : 'HRMS.model.Unit',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'unitStore',
	proxy : {
		type : 'ajax',
		api : {
			read : 'unit/search',
			create : 'unit/add',
			update : 'unit/update',
			destroy : 'unit/delete'
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