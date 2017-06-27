Ext.define('HRMS.module.lpgl.ldxxgl.view.ldxxgl', {
	extend : 'Ext.panel.Panel',
	autoScroll:false,
	initComponent : function() {

		Ext.apply(this, {
			closable : false,
			layout : 'border',
			title : '楼栋',
			items :[{
				region:'west',
				flex:7,
				border : 0,
				layout: 'fit',
				margins : '0 0 0 5',
                minWidth:650,
				items: Ext.create('HRMS.module.lpgl.ldxxgl.view.RoofBeamList')
			},
			{
				region:'center',
				flex:3,
				border:0,
				layout: 'fit',
				margins : '0 0 0 5',
				items: Ext.create('HRMS.module.lpgl.ldxxgl.view.OperationFormPanel')
			},{
				region: 'south',
				flex: 3,
				border: 0,
				header: false,
				title: null,
				collapseMode : 'mini',
				layout:'fit',
				collapsible: true,
				split: true,
				items: Ext.create('HRMS.module.lpgl.ldxxgl.view.OtherInfoTabPanel')
			}] 
		});
		this.callParent(arguments);
	}
});
