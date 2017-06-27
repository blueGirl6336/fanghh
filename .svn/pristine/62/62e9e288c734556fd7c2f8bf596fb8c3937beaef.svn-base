Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.Tutor', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '导师信息',
	border : 0,
	baseInfo : 0,
	store : Ext.create('HRMS.store.personnel.TutorStore'),
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
		},  {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'tutorType',
			text : '导师类型',
			renderer : this.tutorTypeRenders,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'tutorType',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'assessment_time',
			text : '评定时间',
			renderer: me.dateRender,
			editor : {
				 xtype: 'datefield',
                 format: 'Y/m/d'
			}
		},  {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'grant_unit',
			text : '聘任单位',
			editor : {
				xtype : 'textfield'
			}
		},  {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'major',
			text : '所在学科',
			editor : {
				xtype : 'textfield'
			}
		},{
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
		},  {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'remark',
			text : '备注',
			flex: 2,
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

			},{
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
	tutorTypeRenders : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('tutorType');
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
		var rec = new HRMS.model.Tutor({
			baseinfo: this.baseInfo,
			type:0,
			throughAudit:true
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
			}
		});

	}
});