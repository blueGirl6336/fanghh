Ext.define('HRMS.module.xtgl.rsglsz.ejdwgl.view.ejdwgl', {
	extend : 'Ext.panel.Panel',
	initComponent : function() {

		Ext.apply(this, {
			closable : false,
			layout : 'border',
			title : '数据字典管理',
			items :[{
				region:'west',
				flex:4,
				layout: 'fit',
				items: Ext.create('HRMS.module.xtgl.rsglsz.ejdwgl.view.DictionaryDepartmentList')
			},
			{
				region:'center',
				flex:6,
				layout: 'fit',
				margins : '0 0 0 5',
				items: Ext.create('HRMS.module.xtgl.rsglsz.ejdwgl.view.DictionarySubunitList')
			}
			
			] 
		});
		this.callParent(arguments);
	}
});
