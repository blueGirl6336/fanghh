// 楼盘卖点Store
Ext.define('HRMS.store.building.BuildingCommentStore', {
	model : 'HRMS.model.BuildingComment',
	extend : 'Ext.data.Store',
	storeId : 'buildingCommentStore',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'buildingComment/search',
			create : 'buildingComment/add',
			update : 'buildingComment/update',
			destroy : 'buildingComment/delete'			
		},
		/*actionMethods : {
			read : 'POST',
			create : 'POST',
			update : 'POST',
			destroy : 'POST'
		},*/
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