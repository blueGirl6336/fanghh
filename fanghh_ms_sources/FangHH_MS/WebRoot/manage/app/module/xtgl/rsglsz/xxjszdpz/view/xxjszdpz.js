Ext.define('HRMS.module.xtgl.rsglsz.xxjszdpz.view.xxjszdpz', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '信息检索字段配置',
	border : 0,
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	store : Ext.create('HRMS.store.personnel.QueryBeanStore'),
	initComponent : function() {
		var me = this;
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});
		me.columns = [ {
			xtype : 'rownumberer'
		}, {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'name',
			text : '字段名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			dataIndex : 'relativities',
			text : '对比符号（以,分割）',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'entityName',
			text : '对应类名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'propertyName',
			text : '对应属性名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'input_type',
			text : '目标值录入方式',
			renderer : me.inputTypeInput,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : Ext.create('Ext.data.Store', {
					fields : [ 'input_type', 'text' ],
					data : [ {
						"input_type" : 0,
						"text" : "数据字典"
					}, {
						"input_type" : 1,
						"text" : "手动输入（数字）"
					}, {
						"input_type" : 2,
						"text" : "手动输入（字符串）"
					} ]
				}),
				valueField : 'input_type',
				displayField : 'text',
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'dic_code',
			text : '对应数据字典',
			renderer: me.dictionaryGroupRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'personnelGroupDictionary',
				valueField : 'code',
				displayField : 'name',
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 50,
			hidden:true,
			align : 'center',
			dataIndex : 'orderInShow',
			text : '序号',
			sortable:true
		}, {
			xtype : 'actioncolumn',
			width : 50,
			align : 'center',
			text : '排序',
			items: [{
				icon: '../images/icon/Actions-go-up-icon.png',
	            tooltip: '向上移动',
	            handler: function(grid, rowIndex, colIndex, item, e, record) {
	            	if(rowIndex == 0)
	            		record.data.orderInShow = 1;
	            	
	            	if(rowIndex > 0){
	            		record.data.orderInShow = rowIndex;
	            		lastRecord = grid.getStore().getAt(rowIndex - 1);
	            		lastRecord.data.orderInShow = rowIndex+1;
	            		lastRecord.setDirty();
	            	}
	            	record.setDirty();
	            	grid.getStore().sort([{
	            		property : 'orderInShow',
	            		direction: 'ASC'
	            	}]);
	            	
	            }
	        }]
		} 
		];
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
	refreshData: function(){
		var store = this.getStore();
		store.load();
	},
	inputTypeInput : function(val) {
		if (val == null)
			return;
		var store = Ext.create('Ext.data.Store', {
			fields : [ 'input_type', 'text' ],
			data : [ {
				"input_type" : 0,
				"text" : "数据字典"
			}, {
				"input_type" : 1,
				"text" : "手动输入（数字）"
			}, {
				"input_type" : 2,
				"text" : "手动输入（字符串）"
			} ]
		});
		record = store.findRecord('input_type', val);
		name = record.data.text;
		return name;
	},
	dictionaryGroupRender : function(val) {
		if (val == 0)
			return '';
		var store = Ext.getStore('personnelGroupDictionary');
		var record = store.findRecord('code', val);
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
