Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryBeanInCombined', {
	extend : 'Ext.grid.Panel',
	alias: 'widget.combinequerybeanList',
	layout : 'fit',
	title : '对应检索条件',
	titleAlign: 'center',
	border : 1,
	width: 500,
	flex:1,
	margin: '0 0 0 5',
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	needRender : false,
	enableLocking : false,
	store: Ext.create('HRMS.store.personnel.QueryBeanStore',{autoLoad: false}),
	initComponent : function() {
		var me = this;
		me.store.proxy.api.read = 'query/getByGroupId';
		
		me.columns = [ {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			width : 200,
			dataIndex : 'name',
			text : '字段名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 120,
			dataIndex : 'relativities',
			text : '符号'
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			hidden: true,
			dataIndex : 'entityName',
			text : '对应类名'
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'propertyName',
			text : '对应属性名',
			hidden: true
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			hidden: true,
			dataIndex : 'input_type',
			text : '目标值录入方式'
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'dic_code',
			hidden: true,
			text : '对应数据字典'
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			flex: 1,
			dataIndex : 'value',
			text : '取值',
			renderer: this.dictionaryRender
		}];
		me.dockedItems = [ {
			xtype : 'toolbar',
			items : [ {
				xtype : 'button',
				text : '刷新',
				handler : me.refresh,
				scope: me
			}]
		} ];
		this.callParent(arguments);
	},
	refresh: function(){
		var store = this.getStore();
		store.load();
	},
	dictionaryRender: function(val){
		store = Ext.getStore('personnelDictionary');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	}
});
