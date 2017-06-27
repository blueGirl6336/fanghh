Ext.define('HRMS.module.rsgl.rygl.glzwbd.view.glzwbd', {
	extend : 'Ext.panel.Panel',
	autoScroll:false,
	initComponent : function() {

		Ext.apply(this, {
			closable : false,
			layout : 'border',
			title : '管理职务变动',
			autoScroll:false,
			items :[
			
			{
					region: 'center',
                	flex: 1,
                	closable: false,
               		border: 1,
                	layout: 'fit',
                	//height:350,
                	//autoScroll:true,
					items: Ext.create('HRMS.module.rsgl.rygl.glzwbd.view.PersonLlist')
				},{
					region: 'south',
	                flex: 1,
	                border: 0,
	                header: false,
	                title: null,
	                //collapseMode : 'mini',
	                layout: 'fit',
	                //collapsible: true,
	                split:true,
	                //height:200,
	                //autoScroll:true,
					items: Ext.create('HRMS.module.rsgl.rygl.glzwbd.view.ManagementPosition')
				}
			
			] 
		});
		this.callParent(arguments);
	}
});
