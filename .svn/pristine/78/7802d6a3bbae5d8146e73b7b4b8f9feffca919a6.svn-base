Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.WorkExperience', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '工作经历',
	border : 0,
	closable : false,
	store : Ext.create('HRMS.store.personnel.WorkingExperienceStore'),
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	initComponent : function() {
		var me = this;
		me.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'we_from',
			text : '开始日期',
			renderer : me.dateRender,
			editor : {
				xtype : 'datefield',
				format : 'Y/m'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'we_to',
			text : '结束日期',
			renderer : me.dateRender,
			editor : {
				xtype : 'datefield',
				format : 'Y/m'
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
			dataIndex : 'work_place',
			renderer : me.workPlaceRender,
			text : '工作地点',
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'workPlaceType',
				valueField : 'code',
				displayField : 'name',
				editable : false,
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'sub_unit',
			text : '院系/部门',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'techPost',
			text : '技术职务',
			editor : {
				xtype : 'textfield'
			}
		},{
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'managePost',
			text : '管理职务',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
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
	workPlaceRender:function(val){
		if (val == 0)
			return '';
		store = Ext.getStore('workPlaceType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	refreshData : function() {
		var me = this;
		if (this.baseInfo == 0)
			return;
		var store = this	.getStore();
		store.proxy.extraParams = {
			empNo : this.baseInfo.empNo
		};
		store.load({
			// store loading is asynchronous, use a load listener or callback to
			// handle results
			callback : function( records, successful) {
				Ext.each(records, function(rec) {
//					var tr = grid.getView().getNode(rec.index);
//					el = Ext.get(tr).select('td');
//					el.removeCls('red-back yellow-back');
//					if (rec.data.data == 'data2') {
//						el.addCls('red-back');
//					} else {
//						el.addCls('yellow-back');
//					}
					rec.stripeRows = true;
				});
			}
		});
	},
	addNewItem : function() {

		var empNo = this.baseInfo.empNo;
		// Create a model instance
		// 需要设置baseinfo属性 要不然传入后台时 为null会出错
		var rec = new HRMS.model.WorkingExperience({
			baseinfo : this.baseInfo,
			throughAudit : true
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