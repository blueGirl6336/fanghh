Ext.define('HRMS.module.pjgl.lppjgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	
	refs : [ {
		ref : 'buildingCommentPanel',
		selector : 'buildingCommentPanel'
	}],

	views : 'HRMS.module.pjgl.lppjgl.view.*',
	
	chosenBaseInfo: 0,

// stores : ['HRMS.store.DictionaryItemStore'],
			
	init : function() {
		this.control({
			
		});
		
	},

});