Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.CombinedQueryList', {
	extend : 'Ext.grid.Panel',
	alias:'widget.combinedQueryList',
	layout : 'fit',
	border : 1,
	baseInfo: 0,
	title : '组合查询列表',
	titleAlign: 'center',
	width: 500,
	
	store : Ext.create('HRMS.store.personnel.CombinedQueryStore'),
	
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	
	rowEditing : Ext.create('HRMS.customize.GridRowEditing'),
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
		me.dockedItems = [ {
			xtype : 'toolbar',
			items : [ {
				xtype : 'button',
				text : '添加新组合',
				handler : me.addGroup,
				scope: me
			}, {
				itemId : 'removeItem',
				text : '删除选中组合',
				action : 'delete',
				handler : me.deleteItem,
				scope: me

			}, {
				xtype : 'button',
				text : '刷新列表',
				action : 'refresh',
				handler : function() {
					me.store.load();
				}

			},'|' , {
				xtype : 'button',
				text : '编辑查询条件',
				action : 'editCombinedQuery'
			},'|' , {
				xtype : 'button',
				text : '查询',
				action : 'doCombinedQuery'
			} ]
		} ];
		this.plugins = [ this.rowEditing ];
		this.callParent(arguments);
	},
	addGroup : function() {
		var me = this;
		me.rowEditing.cancelEdit();
		var store = me.getStore();
		var count = store.getCount();
		var newGroupId = 1;
		if(count != 0){
			var record = store.getAt(store.getCount() - 1);
			newGroupId =  record.data.groupId + 1;
		}
		var r = Ext.create('HRMS.model.CombinedQuery', {
			groupId : newGroupId,
			name : '',
			remark:''
		});

		store.add(r);
		var count = store.getTotalCount();
		me.rowEditing.startEdit(count, 0);
	},
	deleteItem : function() {
		if(this.getSelectionModel().getSelection().length == 0){
			Ext.MessageBox.alert('警告：', '请先选择要删除的项！');
			return;
		}
		record = this.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.MessageBox.alert('警告：', '请先选择要删除的项！');
			return;
		}
		Ext.MessageBox.confirm('确认', '是否确认删除', function(btn){
		    if (btn == 'yes'){
				this.store.remove(record);
				this.store.sync();
		    }
		},this);
	}
});