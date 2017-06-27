//专业技术职务 store
Ext.define('HRMS.store.personnel.ProfessionalAndTechnicalStore_add_modify', {
	model : 'HRMS.model.ProfessionalAndTechnical',
	extend : 'Ext.data.Store',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'professional/getByEmpNo',
			create : 'professional/addOne',
			update : 'professional/updateOne',
			destroy : 'professional/delete'
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