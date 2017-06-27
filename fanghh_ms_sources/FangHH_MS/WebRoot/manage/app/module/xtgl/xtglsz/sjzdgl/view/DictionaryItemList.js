Ext.define('HRMS.module.xtgl.xtglsz.sjzdgl.view.DictionaryItemList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.dictionaryitemlist',

	layout : 'fit',

	title : '对应字典项',

	border : 0,

	store : 'HRMS.store.DictionaryItemStore',

	rowEditing : Ext.create('HRMS.customize.GridRowEditing'),

	initComponent : function() {
		var me = this;
		this.columns = [ {
			xtype : 'rownumberer',
			width : 30,
			align : 'center'
		}, {
			text : "字典项名",
			flex : 3,
			dataIndex : 'name',
			editor : {
				xtype: 'textfield'
			}
		}, {
			text : "特殊值（如果有）",
			flex : 3,
			dataIndex : 'value',
			editor : {
				allowBlank : true
			}
		} ];

		this.dockedItems = [ {
			xtype : 'toolbar',
			items : [ {
				xtype : 'button',
				text : '添加新项',
				action : 'add'
			}, {
				itemId : 'removeItem',
				text : '删除选中项',
				action : 'delete',
				disabled : true,
				handler : me.deleteItem,
				scope: me

			}, {
				xtype : 'button',
				text : '刷新列表',
				action : 'refresh',
				handler : function() {
					me.store.load();
				}

			} ]
		} ];
		this.plugins = [ this.rowEditing ];
		this.callParent(arguments);
	},

	deleteItem : function() {
		record = this.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.MessageBox.alert('警告：', '请先选择右侧的字典组再添加！');
			return;
		}
		this.store.remove(record);
		this.store.sync();
	}

});