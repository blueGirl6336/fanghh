// 楼盘卖点Store
Ext.define('HRMS.store.building.SurroundFacilityStore', {
	model : 'HRMS.model.SurroundFacility',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'surroundFacility/search',
			create : 'surroundFacility/add',
			update : 'surroundFacility/update',
			destroy : 'surroundFacility/delete'
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