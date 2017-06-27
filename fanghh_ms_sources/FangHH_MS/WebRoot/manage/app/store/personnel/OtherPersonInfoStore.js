//退休
Ext.define('HRMS.store.personnel.OtherPersonInfoStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.PersonBaseInfo',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		actionMethods : 'POST',
		api : {
			read : 'otherBaseInfo/getByNameAndWorkStates'
		},
		extraParams : {
			departmentCode : '1',
			workStates : ''
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