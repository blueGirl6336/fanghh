//留访学信息 store
Ext.define('HRMS.store.personnel.AbroadAndVisitingStore', {
	model : 'HRMS.model.AbroadAndVisiting',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'abroad/getByEmpNo',
			create : 'abroad/add',
			update : 'abroad/update',
			destroy : 'abroad/delete'
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
			// send by array
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