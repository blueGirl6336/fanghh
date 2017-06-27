Ext.define('HRMS.store.CheckedMouldeTreeStore', {
	extend : 'Ext.data.TreeStore',
	storeId: 'checkedTreeStore',
	constructor : function() {

		config = Ext.apply(this, {
			autoLoad : true,
			proxy : {
				type : 'ajax',
				url : 'permission/getCheckModuleTree'
			},
			reader : {
				type : 'json'
			}
		});

		this.callParent(arguments);
	}

});