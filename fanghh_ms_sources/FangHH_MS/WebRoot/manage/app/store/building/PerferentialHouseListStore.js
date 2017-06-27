// 楼盘卖点Store
Ext.define('HRMS.store.building.PerferentialHouseListStore', {
	model : 'HRMS.model.PerferentialHouseList',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'perferentialHouseList/search',
			create : 'perferentialHouseList/add',
			update : 'perferentialHouseList/update',
			destroy : 'perferentialHouseList/delete'
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