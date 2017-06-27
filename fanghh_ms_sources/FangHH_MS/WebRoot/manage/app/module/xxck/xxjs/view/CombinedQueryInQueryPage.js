Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.CombinedQueryInQueryPage', {
	extend : 'Ext.grid.Panel',
	alias:'widget.combinedQueryListInQueryPage',
	layout : 'fit',
	border : 1,
	baseInfo: 0,
	titleAlign: 'center',
	
	store : Ext.create('HRMS.store.personnel.CombinedQueryStore'),
	
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	
	initComponent : function() {

		var me = this;
		me.columns = [ {
            xtype: 'rownumberer',
            width:40
        }, {
			xtype : 'mycolumn',
			width: 170,
			align : 'center',
			dataIndex : 'name',
			text : '名称',
			editor : {
				xtype: 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			flex:1,
			align : 'center',
			dataIndex : 'remark',
			text : '注释',
			editor : {
				xtype: 'textfield'
			}
		}];
		this.callParent(arguments);
	}
});