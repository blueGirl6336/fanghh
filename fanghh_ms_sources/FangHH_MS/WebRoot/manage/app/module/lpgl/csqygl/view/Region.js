Ext.define('HRMS.module.lpgl.csqygl.view.Region', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '区域',
	border : 0,
	cityInfo: 0,
	store : Ext.create('HRMS.store.building.RegionStore'),
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
//	selModel : {
//		selType : 'cellmodel'
//	},
	initComponent : function() {
		//this.cellEditing = new Ext.grid.plugin.CellEditing({
			//clicksToEdit : 2
		//}); {
		var me = this;
		this.on('itemdblclick',me.editItem);
		
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			width : 110,
			dataIndex : 'regionId',
			hidden : true
			
		}, {
			xtype : 'mycolumn',
			width : 110,
			align : 'center',
			dataIndex : 'regionName',
			text : '区域名称',
			editor : {
				xtype : 'textfield',
				allowBlank : false
			}
			
		}];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : '添加新项',
				//disabled : true,
				listeners : {
					click : {
						fn : me.addNewItem,
						scope : me
					}
				}
			}, /*{
				xtype : 'button',
				text : '删除选中行',
				//disabled : true,
				listeners : {
					click : {
						fn : me.deleteChosenItem,
						scope : me
					}
				}

			},*/{
				xtype : 'button',
				text : '编辑选中行',
				//disabled : true,
				listeners : {
					click : {
						fn : me.editItem,
						scope : me
					}
				}

			},{
				xtype : 'button',
				text : '刷新',
				//disabled : true,
				listeners : {
					click : {
						fn : me.refreshData,
						scope : me
					}
				}
			}]
		} ];
		//this.plugins = [ this.cellEditing ];
		this.callParent(arguments);
	},
	refreshData: function(){
		if(this.cityInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			cityId : this.cityInfo.cityId
		};
		store.load();
	},
	
	addNewItem : function() {
		var me = this;
		if(this.cityInfo == 0)
			return;
		var addRegionWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加区域",
			// window的id，根据ID可以取得窗口对象
			id : 'addRegionWin',
			width : 400,
			height : 180,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addRegionForm',
				layout : {
	                type: 'table',
	                columns: 1
	            },
				labelSeparator : ':',
				frame : false,
				//height : 290,
				fieldDefaults : {
					labelAlign : 'right',
					labelWidth : 100,
					msgTarget : 'side'
				},
				defaults : {
					allowBlank : false,
					frame : false
				},
				items : [{
					layout : 'form',
					width : 300,
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						fieldLabel : '区域名称',
						name : 'regionName'
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addRegionForm').getForm();
					if(form.isValid()){
						var regionName = form.findField('regionName').value;
						var rec = new HRMS.model.Region({
							city : me.cityInfo,
							regionName:regionName,
							throughAudit : true
							
						});
						me.store.insert(0, rec);
						me.commit();
						addRegionWin.close();
						
					}else{
						Ext.Msg.alert('注意','表单有未填项目！');
					}
				}
			}, {
				text : '取消',
				width : 80,
				height : 30,
				handler : function() {
					// 点击取消，关闭窗口
					addRegionWin.close();
				}
			} ],
			// 自适应滚动条
			autoScroll : true,
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding: '10'
			}
		});
		// 显示窗口
		addRegionWin.show();
	},
	editItem :function(grid,rowIndex,event) {
		
		var position = this.getSelectionModel().getCurrentPosition();
		if (position == null) {
			return;
		}
		var record = this.store.getAt(position.row);
		
		var me = this;
		var editRegionWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改区域",
			// window的id，根据ID可以取得窗口对象
			id : 'editRegionWin',
			width : 400,
			height : 180,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_editRegionForm',
				layout : {
	                type: 'table',
	                columns: 1
	            },
				labelSeparator : ':',
				frame : false,
				//height : 290,
				fieldDefaults : {
					labelAlign : 'right',
					labelWidth : 100,
					msgTarget : 'side'
				},
				defaults : {
					allowBlank : false,
					frame : false
				},
				items : [{
					layout : 'form',
					width : 300,
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						fieldLabel : '区域名称',
						name : 'regionName',
						value:	record.data.regionName,
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定修改',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_editRegionForm').getForm();
					if(form.isValid()){
						var regionName = form.findField('regionName').value;
						var rec = new HRMS.model.Region({
							city : me.cityInfo,
							regionName:regionName,
							throughAudit : true
							
						});
						me.store.insert(0, rec);
						me.commit();
						editRegionWin.close();
						
					}else{
						Ext.Msg.alert('注意','表单有未填项目！');
					}
				}
			}, {
				text : '取消',
				width : 80,
				height : 30,
				handler : function() {
					// 点击取消，关闭窗口
					editRegionWin.close();
				}
			} ],
			// 自适应滚动条
			autoScroll : true,
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding: '10'
			}
		});
		// 显示窗口
		editRegionWin.show();
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
		var me  = this;
		this.store.sync({
			'success' : function(a, b) {
				Ext.MessageBox.show({
					title : '操作成功',
					msg : a.proxy.reader.rawData.message,
					icon : Ext.MessageBox.OK,
					buttons : Ext.Msg.OK
				});
				me.refreshData();
			}
		});
	}
});