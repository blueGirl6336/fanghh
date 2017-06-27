//家庭成员 store
Ext.define('HRMS.store.personnel.FamilyMembersStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.FamilyMembers',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		api : {
			read : 'family/getByEmpNo',
			create : 'family/add',
			update : 'family/update',
			destroy : 'family/delete'
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