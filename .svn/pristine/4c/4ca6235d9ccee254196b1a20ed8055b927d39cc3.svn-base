Ext.define('HRMS.store.building.BuildingNameWithIdStore', {
	model : 'HRMS.model.BuildingName',
	extend : 'Ext.data.Store',
	storeId : 'buildNameWithId',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		api : {
			read : 'building/getAll',
//			create : 'building/add',
//			update : 'building/update',
//			destroy : 'building/delete'			
		},
		actionMethods : {
			read : 'POST',
     		//create : 'POST',
			//update : 'POST',
			//destroy : 'POST'
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