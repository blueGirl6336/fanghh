Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.CombinedQueryView', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.combinedqueryView',
	initComponent : function() {
		Ext.apply(this, {
			closable : false,
			autoScroll : true,
			layout : {
				type : 'hbox',
				align : 'stretch'
			},
			title : '组合查询条件',
			border:0,
			
			items : [ Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.CombinedQueryList'),
			          Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryBeanInCombined')]
			
		});
		this.callParent(arguments);
	}
});