//退休封装
Ext.define('HRMS.store.personnel.RetirementCapStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.RetirementCap',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'retirement/getAll',
			create : 'retirement/add',
			update : 'retirement/update',
			destroy : 'retirement/delete'
		},
		extraParams : {
			departmentCode : ''
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