Ext.define('HRMS.store.personnel.ContractResumeStore',{
	model : 'HRMS.model.ContractResume',
	extend: 'Ext.data.Store',
	autoLoad : false,
	proxy: {
		type : 'ajax',
		api : {
			read: 'contract/getByEmpNo',
			create : 'contract/addByBaseInfo',
			update : 'contract/update',
			destroy : 'contract/delete'
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
			exception : function(proxy, response, operation){
				Ext.MessageBox.show({
					title : '错误 ',
					msg : proxy.reader.rawData.message,
					icon : Ext.MessageBox.ERROR,
					buttons : Ext.Msg.OK
					
				});
			}
		}
	}
});