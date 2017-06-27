//教育背景 store
Ext.define('HRMS.store.personnel.WorkingExperienceStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.WorkingExperience',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'workexp/getByEmpNo',
			create : 'workexp/add',
			update : 'workexp/update',
			destroy : 'workexp/delete'
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