Ext.define('HRMS.module.xtgl.xtglsz.qxgl.view.RoleList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.rolelist',

	iconCls : 'icon-grid',

	title : '系统角色列表',

	store : 'roles',

	initComponent : function() {
		this.columns = [ {
			xtype : 'rownumberer',
			width : 30,
			align : 'center'
		}, {
			text : "角色名",
			flex : 3,
			dataIndex : 'name'
		}
		];

		this.dockedItems = [ {
			xtype : 'toolbar',
			items : [ {
				xtype : 'button',
				text : '刷新列表',
				action : 'refresh'

			} ]
		} ];
		
		this.callParent(arguments);
	}

});
