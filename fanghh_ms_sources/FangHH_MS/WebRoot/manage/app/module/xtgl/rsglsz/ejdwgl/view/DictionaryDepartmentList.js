Ext.define('HRMS.module.xtgl.rsglsz.ejdwgl.view.DictionaryDepartmentList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.dictionarygrouplist',
	layout : 'fit',

	title : '选择部门',

	border : 0,

	module : 2,

	store : 'departmentClass',

	rowEditing : Ext.create('HRMS.customize.GridRowEditing'),

	initComponent : function() {
		var me = this;
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40,
			align : 'center'
		}, {
			text : "组名",
			flex : 2,
			dataIndex : 'name',
			editor : {
				allowBlank : true
			}
		} ];

		me.tbar = [ {
			text : '添加新组',
			action : 'addDictionaryGroup',
			handler : this.addGroup,
			scope : me
		}, {
			itemId : 'removeGroup',
			text : '删除选中组',
			action : 'delete',
			disabled : true,
			scope : me,
			handler : function() {
				var record = me.getSelectionModel().getSelection()[0];
				if (record == null) {
					Ext.MessageBox.alert('警告：', '请选择要删除的数据字典组！');
					return;
				};
				Ext.Ajax.request({
					url : 'dictionary/deleteGroup',
					method : "GET",
					params : {
						groupCode : record.data.code
					},
					success : function(response) {
						var text = response.responseText;
						var header = '"message":"';
						var a = text.indexOf(header);
						a = a + header.length;
						text = text.substring(a);
						a = text.indexOf('"');
						text = text.substring(0, a);
						Ext.MessageBox.show({
							title : '操作成功',
							msg : text,
							icon : Ext.MessageBox.OK,
							buttons : Ext.Msg.OK
						});
						me.store.load();
					}
				});
			}
		}, {
			text : '刷新列表',
			action : 'refresh',
			handler : function() {
				me.store.load();
			}
		} ];

		me.plugins = [ me.rowEditing ];
		me.callParent(arguments);

//		me.store.proxy.extraParams = {
//			moduleCode : this.module
//		};
//		me.store.load();
	},

	addGroup : function() {
		var me = this;
		me.rowEditing.cancelEdit();
		var store = me.getStore();
		var newCode = 0;
		for ( var i in store.data.items) {
			if (newCode < store.data.items[i].data.code) {
				newCode = store.data.items[i].data.code;
			}
		}
		newCode = parseInt(newCode) + 1000;
		var r = Ext.create('HRMS.model.Dictionary', {
			code : newCode,
			name : '',
			module : this.module,
			adminVisible : true,
			detailGgroup:0
		});

		store.add(r);

		var count = store.getTotalCount();
		me.rowEditing.startEdit(count, 0);
	}

});