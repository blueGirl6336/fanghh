Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.EducationBackground', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '教育背景',
	border : 0,
	baseInfo : 0,
	store : Ext.create('HRMS.store.personnel.EducationBackgroundStore'),
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	// selModel : {
	// selType : 'cellmodel'
	// },
	initComponent : function() {
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});

		var me = this;
		me.columns = [
				{
					xtype : 'rownumberer',
					width : 40
				},
				{
					xtype : 'mycolumn',
					hidden : true,
					dataIndex : 'id'
				},
				{
					xtype : 'mycolumn',
					width : 150,
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
				},
				{
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'degree',
					text : '学位',
					renderer : me.degreeRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'degree',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false
					})
				},
				{
					xtype : 'mycolumn',
					width : 150,
					dataIndex : 'eb_from',
					text : '入学日期',
					renderer : me.dateYMRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m'
					}
				},
				{
					xtype : 'mycolumn',
					width : 150,
					align : 'center',
					dataIndex : 'eb_to',
					text : '毕业日期',
					renderer : me.dateYMRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m'
					}
				},
				{
					xtype : 'mycolumn',
					width : 200,
					align : 'center',
					dataIndex : 'university',
					text : '毕业院校',
					editor : {
						xtype : 'textfield'
					}
				},
				{
					xtype : 'mycolumn',
					width : 150,
					align : 'center',
					dataIndex : 'university_address',
					text : '学校地址',
					editor : {
						xtype : 'textfield'
					}
				},
				{
					xtype : 'mycolumn',
					width : 150,
					align : 'center',
					dataIndex : 'schoolType',
					text : '学校类型',
					renderer : me.schoolTypeRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'schoolType',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false
					})
				},
				{
					xtype : 'mycolumn',
					width : 150,
					align : 'center',
					dataIndex : 'school',
					text : '学院',
					editor : {
						xtype : 'textfield'
					}
				},
				{
					xtype : 'mycolumn',
					width : 150,
					align : 'center',
					dataIndex : 'major',
					text : '专业',
					editor : {
						xtype : 'textfield'
					}
				},
				{
					xtype : 'mycolumn',
					width : 200,
					align : 'center',
					dataIndex : 'disciplineGroup',
					text : '学科门类',
					renderer : me.disciplineRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : Ext.create('HRMS.store.dictionary.DisciplineGroupStore'),
						valueField : 'code',
						displayField : 'name',
						editable : false,
						listeners : {
							select : function(rec,index,row,col) {
								var record=me.getSelectionModel().getSelection()[0];
								record.set('firstDescipline','');
								record.set('secondDescipline','');
							}
						},
						allowBlank : true
					})
				}, {
					xtype : 'mycolumn',
					width : 200,
					align : 'center',
					dataIndex : 'firstDescipline',
					text : '一级学科',
					renderer : me.disciplineRender,
					listeners : {
						click : function(rec,index,row,col) {
							var record=me.getSelectionModel().getSelection()[0];
							var group = record.data.disciplineGroup;
							var first = Ext.getCmp('id_firstDescipline');
							first.clearValue(); 
							var store = first.store;
							store.proxy.extraParams = 
								{groupCode:group};
							store.load();
						}
					},
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						id : 'id_firstDescipline',
						store : 'discipline',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						listeners : {
							select : function(rec,index,row,col) {
								var record=me.getSelectionModel().getSelection()[0];
								record.set('secondDescipline','');
							}
						},
						allowBlank : true
					})
				}, {
					xtype : 'mycolumn',
					width : 200,
					align : 'center',
					dataIndex : 'secondDescipline',
					id : 'id_secondDesipline',
					text : '二级学科',
					renderer : me.disciplineRender,
					listeners : {
						click : function(rec,index,row,col) {
							var record=me.getSelectionModel().getSelection()[0];
							var first = record.data.firstDescipline;
							var second = Ext.getCmp('id_secondDescipline');
							second.clearValue(); 
							var store = second.store;
							store.proxy.extraParams = 
								{groupCode:first};
							store.load();
						}
					},
					editor :  new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						id : 'id_secondDescipline',
						store : 'discipline',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : true
					})
				}, {
					xtype : 'mycolumn',
					width : 200,
					align : 'center',
					dataIndex : 'diploma_no',
					text : '毕业证编号',
					hidden:true,
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					width : 150,
					align : 'center',
					dataIndex : 'edu_date',
					text : '学历日期',
					renderer : me.dateYMDRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m/d'
					}
				}, {
					xtype : 'mycolumn',
					width : 150,
					align : 'center',
					dataIndex : 'issue_date',
					text : '学位证书颁发日期',
					renderer : me.dateYMDRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m/d'
					}
				}, {
					xtype : 'mycolumn',
					width : 200,
					align : 'center',
					dataIndex : 'degree_no',
					text : '学位证编号',
					hidden:true,
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'train_type',
					text : '培养方式',
					renderer : me.trainTypeRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'trainType',
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
	dateYMRender : function(val) {
		if (val == null || val == '')
			return '';
		if (val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m');
	},
	dateYMDRender : function(val) {
		if (val == null || val == '')
			return '';
		if (val == '至今')
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
	trainTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('trainType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	degreeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('degree');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	schoolTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('schoolType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	disciplineRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('allDiscipline');
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
		var rec = new HRMS.model.EducationBackground({
			baseinfo : this.baseInfo,
			throughAudit : true/*,
			train_type : 0,
			education : 0,
			degree : 0*/
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
		Ext.MessageBox.confirm("确认", "是否确认删除？", function(btn) {
			if (btn == 'yes') {
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
				// this.load();
			}
		});

	}
});