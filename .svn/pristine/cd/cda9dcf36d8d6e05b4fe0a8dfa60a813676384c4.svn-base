Ext.define('HRMS.store.ModuleStore', {
	extend : 'Ext.data.TreeStore',
	alias: 'widget.moduleStore',

	constructor : function() {
		config = Ext.apply(this, {
			autoLoad : true,
			proxy : {
				type : 'ajax',
				url : 'module/getMenu',
				reader: {
		             type: 'json'
		        }
			},
			root : {
				expanded : true
			},
			listeners: {
		        load: function(sender, node, records, success) {
		        	var controller = HRMS.app.getController('ModuleController');
		        	if(success){
		        		controller.initMenuPanel(node);
		        	}
		        }
		    }
		});
		this.callParent(arguments);
	}
});