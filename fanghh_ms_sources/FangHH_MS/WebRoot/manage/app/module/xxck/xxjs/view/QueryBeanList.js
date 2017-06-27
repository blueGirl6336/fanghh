Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryBeanList', {
	extend : 'Ext.grid.Panel',
	alias: 'widget.queryList',
	layout : 'fit',
	title : '检索条件汇总',
	titleAlign: 'center',
	border : 0,
	width: 500,
	//来暂存store
	privateStore: 0,
	flex:1,
//	margin: '0 0 0 5',
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	needRender : true,
	enableLocking : false,
	store : Ext.create('HRMS.store.personnel.QueryBeanStore',{autoLoad: false}),
	initComponent : function() {
		var me = this;
		me.privateStore = me.store;
		
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
		this.store.proxy.api.read = '';
		this.callParent(arguments);
	},
	refreshData: function(){
		var store = this.getStore();
		store.load();
	},
	dictionaryRender: function(val){
		if(!this.needRender)
			return val;
		store = Ext.getStore('personnelDictionary');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	addNewItem : function() {

		var rec = new HRMS.model.QueryBean({
			input_type: 0,
			dic_code: 0
		});

		this.getStore().insert(0, rec);
		this.cellEditing.startEditByPosition({
			row : 0,
			column : 1
		});

	},
	deleteChosenItem : function() {
		var position = this.getSelectionModel().getCurrentPosition();
		if (position == null) {
			return;
		}
		this.store.removeAt(position.row);
	},
	commit : function() {
		this.store.sync({
			'success' : function(a, b) {
				Ext.MessageBox.show({
					title : '操作成功',
					msg : a.proxy.reader.rawData.message,
					icon : Ext.MessageBox.OK,
					buttons : Ext.Msg.OK
				});
				this.load();
			}
		});

	}
});
