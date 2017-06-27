Ext.define('HRMS.module.yhgl.jjrjtd.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	refs : [ {
		ref : 'brokerAndGroupPanel',
		selector : 'brokerAndGroupPanel'
	}],

	views : 'HRMS.module.yhgl.jjrjtd.view.*',
	
	chosenBaseInfo: 0,

// stores : ['HRMS.store.DictionaryItemStore'],
			
	init : function() {
		this.control({
		});
		
	},
	

});