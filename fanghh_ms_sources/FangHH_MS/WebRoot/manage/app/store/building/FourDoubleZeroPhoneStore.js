Ext.define('HRMS.store.building.FourDoubleZeroPhoneStore', {
		model : 'HRMS.model.Broker',
		extend : 'Ext.data.Store',
		autoLoad :  true,
		storeId : 'FourDoubleZeroPhone',
		proxy : {
			type : 'ajax',
			api : {
				read : 'fourDoubleZeroPhone/getAllPhone',
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