//管理职务职务 store
Ext.define('HRMS.store.personnel.ManagementPositionStore', {
	model : 'HRMS.model.ManagementPosition',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'managementposition/getByEmpNo',
			create : 'managementposition/add',
			update : 'managementposition/update',
			destroy : 'managementposition/delete'
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