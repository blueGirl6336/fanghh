Ext.define('HRMS.module.xtgl.xtglsz.qxgl.view.NavigationTree', {
	extend : 'Ext.tree.Panel',
	alias : 'widget.navigationtree',

	store : Ext.create('HRMS.store.CheckedMouldeTreeStore'),

	title : '菜单列表',
	

	initComponent : function() {

		Ext.apply(this, {
			collapsible : false,
			split : false,
			rootVisible : false
		});

		this.tbar = [ {
			text : '确认修改',
			action : 'confirmUpdate'
		}, {
			text : '刷新列表',
			action : 'refresh'
		} ];

		this.callParent(arguments);
	}
});
