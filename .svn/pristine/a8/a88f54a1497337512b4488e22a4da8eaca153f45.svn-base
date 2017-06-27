Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.xxjs', {
	extend : 'Ext.tab.Panel',
	alias : 'widget.xxjspanle',
	activeTab : 0,
	border : 0,
	closable : false,
	layout : 'fit',
	padding:0,

	initComponent : function() {
		Ext.applyIf(this, {
			items : [ 
			    Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryEdit'),
			    Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.ResultList'),
			    Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.CombinedQueryView')
			]
		});
		this.callParent(arguments);
	}
});