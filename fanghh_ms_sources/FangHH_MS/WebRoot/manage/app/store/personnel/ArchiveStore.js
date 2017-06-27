Ext.define('HRMS.store.personnel.ArchiveStore',{
	model : 'HRMS.model.Archive',
	extend: 'Ext.data.Store',
	autoLoad : false,
	proxy: {
		type : 'ajax',
		api : {
			read: 'archive/getByEmpNo',
			create : 'archive/addByBaseInfo',
			update : 'archive/update',
			destroy : 'archive/delete'
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
					msg : "",
					icon : Ext.MessageBox.ERROR,
					buttons : Ext.Msg.OK
					
				});
			}
		}
	}
});