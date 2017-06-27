Ext.define('HRMS.module.rsgl.rygl.glzwbd.view.ManagementPosition', {
	id : 'managementPosition',
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '管理职务',
	alias : 'widget.details_glzwbd',// 被调动人的管理职务信息
	border : 1,
	baseInfo : 0,// 存储被选中的被调动人的基本信息
	store : Ext.create('HRMS.store.personnel.ManagementPositionStore_add_modify'),
	closable : false,
	// autoScroll:true,//必须
	// height:200,//必须
	// collapsible: true,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	addGLZWWin : new Ext.Window({
		id : 'addGLZWWin',
		width : 420,
		height : 415,
		modal : true,
		closeAction : 'hide',
		title : "添加管理职务",
		items : Ext
				.create('HRMS.module.rsgl.rygl.glzwbd.view.OperationFormPanel')
	}),
	modifyGLZWWin : new Ext.Window({
		id : 'modifyGLZWWin',
		width : 420,
		height : 415,
		modal : true,
		closeAction : 'hide',
		title : "修改管理职务",
		items : Ext
				.create('HRMS.module.rsgl.rygl.glzwbd.view.OperationFormPanel_modify')
	}),
	// selModel : {
	// selType : 'cellmodel'
	// },
	initComponent : function() {
		// this.cellEditing = new Ext.grid.plugin.CellEditing({
		// clicksToEdit : 1
		// });

		var me = this;

		// 清空上次的数据
		me.store = Ext.create('HRMS.store.personnel.ManagementPositionStore_add_modify');
		me.columns = [{
					xtype : 'rownumberer',
					width : 20
				}, {
					xtype : 'mycolumn',
					hidden : true,
					dataIndex : 'id'
				}, {
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'title',
					text : '职务',
					renderer : this.titleRender
					// editor : {
				// xtype : 'textfield'
				// }
			}	, {
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'mp_class',
					text : '级别',
					renderer : this.classRenders
					// ,
				// editor : new Ext.form.field.ComboBox({
				// typeAhead : true,
				// triggerAction : 'all',
				// store : 'managementClass',
				// valueField : 'code',
				// displayField : 'name',
				// editable : false,
				// allowBlank : false
				// })
			}	, {
					xtype : 'mycolumn',
					width : 110,
					dataIndex : 'manag_grade',
					text : '职员职级',
					renderer : this.managementRender
					// ,
				// editor : new Ext.form.field.ComboBox({
				// typeAhead : true,
				// triggerAction : 'all',
				// store : 'managementLevel',
				// valueField : 'code',
				// displayField : 'name',
				// editable : false,
				// allowBlank : false
				// })
			}	, {
					xtype : 'mycolumn',
					width : 180,
					align : 'center',
					dataIndex : 'manag_grade_date',
					text : '职员职级任命日期',
					renderer : me.dateRender
					// ,
				// editor : {
				// xtype: 'datefield',
				// format: 'Y/m/d'
				// }
			}	, {
					xtype : 'mycolumn',
					width : 160,
					align : 'center',
					dataIndex : 'employer',
					text : '聘任单位'// ,
					// editor : {
				// xtype : 'textfield'
				// }
			}	, {
					xtype : 'mycolumn',
					width : 120,
					align : 'center',
					dataIndex : 'mp_department',
					text : '聘任院系部门',
					renderer : me.departmentTypeRender
					// editor : {
				// xtype : 'textfield'
				// }
			}	, {
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'title_from',
					text : '职务任命日期',
					//renderer : me.otherDateRender
					// ,
				// editor : {
				// xtype: 'datefield',
				// format: 'Y/m/d'
				// }
			}	, {
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'title_to',
					text : '职务解除日期',
					//renderer : me.otherDateRender
					// ,
				// editor : {
				// xtype: 'datefield',
				// format: 'Y/m/d'
				// }
			}, {
				xtype : 'mycolumn',
				width : 80,
				align : 'center',
				dataIndex : 'upToPresent',
				text : '至今',
				renderer : me.presentRender
			}, {
					xtype : 'mycolumn',
					width : 80,
					align : 'center',
					dataIndex : 'emp_type',
					hidden : true,
					text : '人员类型'// ,
					// //TODO ComboBox
				// editor : {
				// xtype : 'textfield'
				// }
			}	, {
				xtype : 'mycolumn',
				width : 80,
				align : 'center',
				dataIndex : 'title_attribute',
				text : '兼职',
				renderer : me.attriRender
			}, {
					xtype : 'mycolumn',
					width : 120,
					align : 'center',
					dataIndex : 'remark',
					text : '备注'// ,
					// editor : {
				// xtype : 'textfield'
				// }
			}];
		me.dockedItems = [{
					xtype : 'toolbar',
					dock : 'top',
					items : [{
								xtype : 'button',
								text : '添加',
								listeners : {
									click : {
										fn : me.addNewItem,
										scope : me
									}
								}
							}, {
								xtype : 'button',
								text : '修改',
								listeners : {
									click : {
										fn : me.modifyItem,
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

							}/*
								 * , { xtype : 'button', text : '刷新', listeners : {
								 * click : { fn : me.refreshData, scope : me } } }, {
								 * xtype : 'button', text : '保存修改', listeners : {
								 * click : { fn : me.commit, scope : me } } }
								 */]
				}];
		// this.plugins = [ this.cellEditing ];
		this.callParent(arguments);
	},
	dateRender : function(val) {
		if (val == null || val == '')
			return '';
		if (val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m/d');
	},
	otherDateRender:function(val){
		if (val == null || val == '')
			return '';
		else if((Ext.util.Format.date(val, 'Y/m/d').indexOf('/'))!=-1){
			return Ext.util.Format.date(val, 'Y/m/d');
		}
		else{
			return new Date(parseInt(val.substring(6, val.length-2))).format('y/m');
		}
	},
	// refreshData : function() {
	// if (this.baseInfo == 0)
	// return;
	// var store = this.getStore();
	// store.proxy.extraParams = {
	// empNo : this.baseInfo.empNo
	// };
	// store.load();
	// },
	managementRender : function(val) {
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
	titleRender : function(val) {
		if (val == 0)
			return '';
		trstore = Ext.getStore('professionalPost');
		record = trstore.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return
		name;
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
	presentRender: function(val){
		
		if (val)
			return '是';
		else
			return '否';
	},
	attriRender : function(val){

		if (val)
			return '是';
		else
			return '否';
	}
	
	/*
	 * , addNewItem : function() {
	 * 
	 * var empNo = this.baseInfo.empNo; // Create a model instance //
	 * 需要设置baseinfo属性 要不然传入后台时 为null会出错 var rec = new
	 * HRMS.model.ProfessionalAndTechnical({ baseinfo : this.baseInfo,
	 * throughAudit:true, pat_class : 0, title : 0, school :
	 * this.baseInfo.department, tech_grade : 0, teacher_type : 0 });
	 * 
	 * this.getStore().insert(0, rec); this.cellEditing.startEditByPosition({
	 * row : 0, column : 1 }); }
	 */,

	addNewItem : function() {

		var form1 = Ext.getCmp('glzwbdPersonList');
		var position = form1.getSelectionModel().getCurrentPosition();
		if (position == null) {
			Ext.MessageBox.show({
						title : '提示',
						msg : '请先选中要执行添加的人员',
						icon : Ext.MessageBox.OK,
						buttons : Ext.Msg.OK
					});
			return;
		}
		
		//置空
		var form2 = Ext.getCmp('id_newGLZWBD_Form').getForm();
		var form3 = Ext.getCmp('managementPosition');

		//form2.findField('empNo').setValue(Ext.getCmp('glzwbdPersonList').getSelectionModel().getSelection()[0].data.empNo);
		form2.findField('id').setValue('-1');
		form2.findField('title').setValue('');
		form2.findField('mp_class').setValue('');
		form2.findField('employer').setValue('哈尔滨工业大学（威海）');
		form2.findField('mp_department').setValue('');
		form2.findField('title_from').setValue(new Date());
		form2.findField('title_to').setValue('');
		form2.findField('upToPresent').setValue('');
		form2.findField('manag_grade').setValue('');
		form2.findField('manag_grade_date').setValue('');
		form2.findField('emp_type').setValue('');
		form2.findField('title_attribute').setValue('');
		form2.findField('remark').setValue('');
		
		var store = form3.getStore();
		
		if(store.data.items.length > 0)
		{
			form2.findField('title').setValue(store.data.items[0].data.title);
			form2.findField('mp_class').setValue(store.data.items[0].data.mp_class);
			
			if(store.data.items[0].data.employer != null && store.data.items[0].data.employer != '')
				form2.findField('employer').setValue(store.data.items[0].data.employer);
				
			form2.findField('mp_department').setValue(store.data.items[0].data.mp_department);
				
			var title_from = Ext.util.Format.date(store.data.items[0].data.title_from, 'Y/m/d');
			var title_to = Ext.util.Format.date(store.data.items[0].data.title_to, 'Y/m/d');
			form2.findField('title_from').setValue(title_from);
			form2.findField('title_to').setValue(title_to);
			//form2.findField('upToPresent').setValue(store.data.items[0].data.upToPresent.getRawValue());
			form2.findField('manag_grade').setValue(store.data.items[0].data.manag_grade);
			form2.findField('emp_type').setValue(store.data.items[0].data.emp_type);
			//form2.findField('title_attribute').setValue(store.data.items[0].data.title_attribute.getRawValue());
			form2.findField('remark').setValue(store.data.items[0].data.remark);
		}

		// 显示窗口
		this.addGLZWWin.show();
	},

	modifyItem : function() {
		var form1 = Ext.getCmp('glzwbdPersonList');
		var form2 = Ext.getCmp('managementPosition');
		var position = form2.getSelectionModel().getCurrentPosition();
		if (position == null) {
			Ext.MessageBox.show({
						title : '提示',
						msg : '请先选中要修改的行',
						icon : Ext.MessageBox.OK,
						buttons : Ext.Msg.OK
					});
			return;
		}

		// 显示窗口口
		this.modifyGLZWWin.show();
		//var a = form1.getSelectionModel().getSelection()[0].data.empNo;
		//var b = form2.getSelectionModel().getSelection()[0].data.id;

		var form3 = Ext.getCmp('id_modifyGLZWBD_Form').getForm();
		form3.findField('empNo').setValue(form1.getSelectionModel()
				.getSelection()[0].data.empNo);

		form3.findField('id')
				.setValue(form2.getSelectionModel().getSelection()[0].data.id);
		form3.findField('title').setValue(form2.getSelectionModel()
				.getSelection()[0].data.title);
		form3.findField('mp_class').setValue(form2.getSelectionModel()
				.getSelection()[0].data.mp_class);
		form3.findField('employer').setValue(form2.getSelectionModel()
				.getSelection()[0].data.employer);
		form3.findField('mp_department').setValue(form2.getSelectionModel()
				.getSelection()[0].data.mp_department);
		var title_from = Ext.util.Format.date(form2.getSelectionModel()
						.getSelection()[0].data.title_from, 'Y/m/d');
		form3.findField('title_from').setValue(title_from);
		var title_to = Ext.util.Format.date(form2.getSelectionModel()
						.getSelection()[0].data.title_to, 'Y/m/d');
		form3.findField('title_to').setValue(title_to);
		var uptopresent = form2.getSelectionModel().getSelection()[0].data.upToPresent;
		form3.findField('upToPresent').setValue({upToPresent:uptopresent});
		//radiogroup 的设置setValue参数要是{name:value}形式的
		form3.findField('manag_grade').setValue(form2.getSelectionModel()
				.getSelection()[0].data.manag_grade);
		var manag_grade_date = Ext.util.Format.date(form2.getSelectionModel()
						.getSelection()[0].data.manag_grade_date, 'Y/m/d');
		form3.findField('manag_grade_date').setValue(manag_grade_date);
		form3.findField('emp_type').setValue(form2.getSelectionModel()
				.getSelection()[0].data.emp_type);
		form3.findField('title_attribute').setValue({title_attribute:form2.getSelectionModel()
			.getSelection()[0].data.title_attribute});
		form3.findField('remark').setValue(form2.getSelectionModel()
				.getSelection()[0].data.remark);

	},

	deleteChosenItem : function() {
		var position = this.getSelectionModel().getCurrentPosition();
		if (position == null) {
			Ext.MessageBox.show({
						title : '提示',
						msg : '请先选中一行!',
						icon : Ext.MessageBox.OK,
						buttons : Ext.Msg.OK
					});
			return;
		}

		var store = this.store;

		Ext.MessageBox.confirm("确认删除", "确定删除该行?", function(btn) {
			if (btn == 'no')
				return;
			else {
				store.removeAt(position.row);

				// 保存提交修改结果
				store.sync({
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

	}/*
		 * , commit : function() { this.store.sync({ 'success' : function(a, b) {
		 * Ext.MessageBox.show({ title : '操作成功', msg :
		 * a.proxy.reader.rawData.message, icon : Ext.MessageBox.OK, buttons :
		 * Ext.Msg.OK }); } }); }
		 */
});