Ext.define('HRMS.module.rsgl.rygl.rydl.view.rydl', {
	extend : 'Ext.panel.Panel',
	autoScroll:false,
	closable : false,
	initComponent : function() {

		Ext.apply(this, {
			closable : false,
			layout : 'border',
			title : '人员调离',
			items :[{
				region:'west',
				flex:5,
				border : 0,
				layout: 'fit',
				margins : '0 0 0 5',
                minWidth:545,
				items: Ext.create('HRMS.module.rsgl.rygl.rydl.view.PersonLlist')
			},
			{
				region:'center',
				flex:5,
				border:0,
				layout: 'fit',
				margins : '0 0 0 5',
				items: Ext.create('HRMS.module.rsgl.rygl.rydl.view.OperationFormPanel')
			}
			
			] 
		});
		this.callParent(arguments);
	}
});
