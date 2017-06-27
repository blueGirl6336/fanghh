//退休
Ext.define('HRMS.store.personnel.RetirementStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.Retirement',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'retirement/getAll',
			create : 'retirement/add',
			update : 'retirement/update',
			destroy : 'retirement/delete'
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