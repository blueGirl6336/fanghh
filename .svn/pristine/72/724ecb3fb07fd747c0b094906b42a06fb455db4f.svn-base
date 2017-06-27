Ext.define('HRMS.module.rsgl.rygl.rybmbd.view.rybmbd', {
	extend : 'Ext.panel.Panel',
	autoScroll:false,
	initComponent : function() {

		Ext.apply(this, {
			closable : false,
			layout : 'border',
			title : '人员部门变动',
			items :[{
				region:'west',
				flex:5,
				border : 0,
				layout: 'fit',
				margins : '0 0 0 5',
                minWidth:650,
				items: Ext.create('HRMS.module.rsgl.rygl.rybmbd.view.PersonLlist')
			},
			{
				region:'center',
				flex:5,
				border:0,
				layout: 'fit',
				margins : '0 0 0 5',
				items: Ext.create('HRMS.module.rsgl.rygl.rybmbd.view.OperationFormPanel')
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
				items: Ext.create('HRMS.module.rsgl.rygl.rybmbd.view.OtherInfoTabPanel')
			}] 
		});
		this.callParent(arguments);
	}
});
