// 楼栋Store
Ext.define('HRMS.store.building.RoofBeamStore', {
	model : 'HRMS.model.RoofBeam',
	extend : 'Ext.data.Store',
	autoLoad : false,
	storeId : 'roofbeamStore',
	proxy : {
		type : 'ajax',
		api : {
			read : 'roofBeam/search',
			create : 'roofBeam/add',
			update : 'roofBeam/update',
			destroy : 'roofBeam/delete'
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