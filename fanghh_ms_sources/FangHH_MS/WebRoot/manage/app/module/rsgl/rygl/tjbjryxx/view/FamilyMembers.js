Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.FamilyMembers', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '家庭成员',
	border : 0,
	baseInfo: 0,
	store : Ext.create('HRMS.store.personnel.FamilyMembersStore'),
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
//	selModel : {
//		selType : 'cellmodel'
//	},
	initComponent : function() {
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});

		var me = this;
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'name',
			text : '姓名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'relationship',
			text : '称谓',
			renderer: me.relationRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'relation',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'dateOfBirth',
			text : '出生年月',
			renderer: me.dateRender,
			editor : {
				 xtype: 'datefield',
                 format: 'Y/m'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'employer',
			text : '工作单位',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'department',
			text : '部门',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'post',
			text : '职务',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'title',
			text : '职称',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'education',
			text : '学历',
			renderer : me.educationRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'education',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'remark',
			text : '备注',
			editor : {
				xtype : 'textfield'
			}
		} ];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : '添加新项',
				listeners : {
					click : {
						fn : me.addNewItem,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '删除选中行',
				listeners : {
					click : {
						fn : me.deleteChosenItem,
						scope : me
					}
				}

			}, {
				xtype : 'button',
				text : '刷新',
				listeners : {
					click : {
						fn : me.refreshData,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '保存修改',
				listeners : {
					click : {
						fn : me.commit,
						scope : me
					}
				}
			} ]
		} ];
		this.plugins = [ this.cellEditing ];
		this.callParent(arguments);
	},
	dateRender: function(val){
		if(val == null || val == '')
			return '';
		if(val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m');
	},
	refreshData: function(){
		if(this.baseInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			empNo : this.baseInfo.empNo
		};
		store.load();
	},
	relationRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('relation');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	educationRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('education');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	addNewItem : function() {
		
		var empNo = this.baseInfo.empNo;
		// Create a model instance
		// 需要设置baseinfo属性 要不然传入后台时 为null会出错
		var rec = new HRMS.model.FamilyMembers({
			baseinfo: this.baseInfo
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

		var me = this;
		Ext.MessageBox.confirm("确认", "是否确认删除？", function (btn) {
            if(btn == 'yes'){
            	me.store.removeAt(position.row);
            	me.commit();
            }
        });
	},
	commit: function(){
		this.store.sync({
			'success' : function(a, b) {
				Ext.MessageBox.show({
					title : '操作成功',
					msg : a.proxy.reader.rawData.message,
					icon : Ext.MessageBox.OK,
					buttons : Ext.Msg.OK
				});
			}
		});
		
		
	}
});