// 楼盘卖点Store
Ext.define('HRMS.store.building.BuildingPropertyTypeStore', {
	model : 'HRMS.model.BuildingPropertyType',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'buildingPropertyType/search',
			create : 'buildingPropertyType/add',
			update : 'buildingPropertyType/update',
			destroy : 'buildingPropertyType/delete'
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