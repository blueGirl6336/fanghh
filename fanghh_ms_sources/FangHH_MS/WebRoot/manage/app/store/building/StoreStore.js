Ext.define('HRMS.store.building.StoreStore', {
		model : 'HRMS.model.Store',
		extend : 'Ext.data.Store',
		autoLoad :  true,
		storeId : 'store',
		proxy : {
			type : 'ajax',
			api : {
				read : 'storemanage/getAll',
//				create : 'broker/add',
//				update : 'broker/update',
//				destroy : 'broker/delete'
			},
			actionMethods : {
				read : 'POST',
//				create : 'POST',
//				update : 'POST',
//				destroy : 'POST'
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
						msg : total,
						icon : Ext.MessageBox.ERROR,
						buttons : Ext.Msg.OK
					});
				}
			}
		}

	});