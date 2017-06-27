// 组合查询条件store
Ext.define('HRMS.store.personnel.CombinedQueryStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.CombinedQuery',
	autoLoad : true,
	proxy : {
		type : 'ajax',
		api : {
			read : 'cmbquery/getAll',
			create : 'cmbquery/add',
			update : 'cmbquery/update',
			destroy : 'cmbquery/delete'
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