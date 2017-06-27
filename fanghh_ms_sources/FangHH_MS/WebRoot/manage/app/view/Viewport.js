Ext.define('HRMS.view.Viewport', {
	extend : 'Ext.container.Viewport',
	id : 'viewport',
	layout : 'border',

	initComponent : function() {
		Ext.apply(this, {
			padding : "5 0 5 0",
			items : [ {
				xtype : 'indexHeader',
				region : 'north'
			}, {
				xtype : 'mainmenu',
				flex : 2,
				region : 'west',
				layout: 'fit',
				title : '功能菜单',
				split:true,
				collapseMode : 'mini',
				collapsible :true
			}, {
				region : 'center',
				xtype : 'centerpane',
				flex : 8
			} ]
		});
		this.callParent(arguments);
	}
});