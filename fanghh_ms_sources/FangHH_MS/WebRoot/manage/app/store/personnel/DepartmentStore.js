// 部门store
Ext.define('HRMS.store.personnel.DepartmentStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.Department',
	storeId:'departmentInfo',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'department/getAll',
			create : 'department/add',
			update : 'department/update',
			destroy : 'department/delete'
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