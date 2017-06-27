Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.ManagementPosition', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '管理职务',
	border : 0,
	store : Ext.create('HRMS.store.personnel.ManagementPositionStore'),
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
			width : 200,
			align : 'center',
			dataIndex : 'employer',
			text : '聘任单位',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'mp_department',
			text : '部门',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'mp_class',
			text : '级别',
			renderer : this.classRenders,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'managementClass',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'title',
			text : '职务',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'title_from',
			text : '职务任命日期',
			//renderer: me.dateRender,
			editor : {
				 xtype: 'textfield',//datefield
                 //format: 'Y/m/d'
			}
		},{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'title_to',
			text : '职务解除日期',
			//renderer: me.dateRender,
			editor : {
				 xtype: 'textfield',//datefield
                 //format: 'Y/m/d'
			}
		},{
			xtype : 'mycolumn',
			width : 80,
			align : 'center',
			dataIndex : 'upToPresent',
			text : '是否至今',
			renderer : me.presentRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 
					Ext.create('Ext.data.Store', {
					    fields: ['name','code'],
					    data : [{'name': '是','code':true},
							    {'name': '否','code':false}]
					}),
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		},  {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'manag_grade',
			text : '职员职级',
			renderer:  me.managementRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'managementLevel',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'manag_grade_date',
			text : '职员职级任命日期',
			renderer: me.dateRender,
			editor : {
				 xtype: 'datefield',
                 format: 'Y/m/d'
			}
		},  
		{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			hidden : true,
			dataIndex : 'emp_type',
			text : '人员类型',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 80,
			align : 'center',
			dataIndex : 'title_attribute',
			text : '是否兼职',
			renderer : me.attriRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 
					Ext.create('Ext.data.Store', {
					    fields: ['name','code'],
					    data : [{'name': '是','code':true},
							    {'name': '否','code':false}]
					}),
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		},{
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
			return Ext.util.Format.date(val, 'Y/m/d');
	},
	refreshData : function() {
		if (this.baseInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			empNo : this.baseInfo.empNo
		};
		store.load();
	},
	managementRender:function(val) {
		if (val == 0)
			return '';
		crstore = Ext.getStore('managementLevel');
		record = crstore.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	classRenders : function(val) {
		if (val == 0)
			return '';
		crstore = Ext.getStore('managementClass');
		record = crstore.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	attriRender : function(val){

		if (val)
			return '是';
		else
			return '否';
	},
	presentRender: function(val){

		if (val)
			return '是';
		else
			return '否';
	},
	titleRender : function(val) {
		if (val == 0)
			return '';
		trstore = Ext.getStore('professionalPost');
		record = trstore.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	departmentTypeRender : function(val) {
		store = Ext.getStore('department');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	teacherTypeRender : function(val) {
		if (val == 0)
			return '';
		trstore = Ext.getStore('teacherType');
		record = trstore.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	addNewItem : function() {

		var empNo = this.baseInfo.empNo;
		// Create a model instance
		// 需要设置baseinfo属性 要不然传入后台时 为null会出错
		var rec = new HRMS.model.ManagementPosition({
			baseinfo : this.baseInfo
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