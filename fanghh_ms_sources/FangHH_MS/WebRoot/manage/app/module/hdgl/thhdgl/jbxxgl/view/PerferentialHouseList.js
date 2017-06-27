Ext.define('HRMS.module.hdgl.thhdgl.jbxxgl.view.PerferentialHouseList', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '特惠房屋列表',
	border : 0,
	PerferentialHouseInfo: 0,
	store : Ext.create('HRMS.store.building.PerferentialHouseListStore'),
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
		var boolStore = Ext.create("Ext.data.Store", {
		    fields: ["Name", "Value"],
		    data: [
		        { Name: "是", Value: 1 },
		        { Name: "否", Value: 0 }
		    ]
		});
		this.on('itemdblclick',me.editPerferentialHouseList);
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'phlId'
		},{
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'activityId',
			text : '活动编号'
		},{
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'childOrderId',
			text : '子订单编号'
		},{
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'isPurchased',
			text : '是否已认购',
			renderer : me.boolRender
		},
		{
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'houseNum',
			text : '房屋编号'
		},{
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'childOrderStatus',
			text : '子订单状态',
			renderer : me.childOrderStatusRender
		}/*, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'propertyType',
			text : '物业类型',
			renderer: me.buildingPropertyTypeRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'buildingPropertyType',
				valueField : 'dictCode',
				displayField : 'dictName',
				editable : false,
				allowBlank : false
			})
		}*/];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : '添加新特惠活动',
				listeners : {
					click : {
						fn : me.addNewPerferentialHouseList,
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
			}]
		} ];
		this.plugins = [ this.cellEditing ];
		this.callParent(arguments);
	},
	editPerferentialHouseList : function(){
		var position = this.getSelectionModel().getCurrentPosition();
		if (position == null) {
			return;
		}
		var record = this.store.getAt(position.row);
		
		var me = this;
		var searchWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改特惠活动房屋信息",
			// window的id，根据ID可以取得窗口对象
			id : 'searchWin',
			width : 420,
			height : 300,
			bodyPadding : 20,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_updatePerferentialHouseForm',
//				title : '特惠活动基本信息',
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
				items : [
						{
							layout : 'form',
							width : 300,
							border : false,
							defaultType : 'textfield',
							defaults : {
								allowBlank : false
							},
							items : [{
								xtype : 'textfield',
								fieldLabel : '编号',
								name : 'phlId',
								value : record.data.phlId,
								hidden : true,
							},{
								xtype : 'combobox',
								fieldLabel : '房屋Id',
								name : 'houseId',
								value : record.data.houseId,
								autoSelect : true,
								width : 150,
								id : 'addHouse',
								queryMode : 'local',
								store : Ext.getStore('house'),
								valueField : 'houseId',
								displayField : 'houseId',
								value : record.data.houseId,
							    listeners : {
									specialKey : function(field, e) {
										if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
										}
									}
								}
							},{
								xtype : 'textfield',
								fieldLabel : '活动编号',
								name : 'activityId',
								value : record.data.activityId
							},{
								xtype : 'textfield',
								fieldLabel : '子订单编号',
								name : 'childOrderId',
								value : record.data.childOrderId
							},{
								xtype : 'combobox',
								editable : false,
								fieldLabel : '是否已认购',
								name : 'isPurchased',
								value : record.data.isPurchased,
								store : 
									Ext.create('Ext.data.Store', {
									    fields: ['name','code'],
									    data : [{'name': '是','code':true},
											    {'name': '否','code':false}]
									}),
								valueField : 'code',
								displayField : 'name'
							},{
								xtype : 'combobox',
								editable:false,
								fieldLabel : '子订单状态',
								store : Ext.getStore('childOrderStatus'),
								valueField : 'dictCode',
								displayField : 'dictName',
								name : 'childOrderStatus',
								value : record.data.childOrderStatus,
								typeAhead : true,
								queryMode : 'local',
							}]
						}
					]
			} ],
			buttons : [ {
				text : '确定修改',
				width : 80,
				height : 30,
				handler : function() {
					var me = this;
					var form = Ext.getCmp('id_updatePerferentialHouseForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'perferentialHouseList/update',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	searchWin.close();
						    },
						    failure: function(form, action) {
						        Ext.Msg.alert('Failure',action.result.message);
						    }
						});
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
					searchWin.close();
				}
			} ],
			dateRender : function(val) {
				alert('1');
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y-m-d');
			},
			// 自适应滚动条
			autoScroll : true,
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding:'10'
			}
		});
		// 显示窗口
		searchWin.show();
	},
	addNewPerferentialHouseList : function() {
		var me = this;
		var addPerferentialHouseWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新活动",
			// window的id，根据ID可以取得窗口对象
			id : 'addPerferentialHouseWin',
			width : 700,
			height : 300,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addPerferentialForm',
//				title : '人员基本信息',
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
				items : [
					{
					layout : 'form',
					width : 300,
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						xtype : 'combobox',
						fieldLabel : '房屋Id',
						name : 'houseId',
						autoSelect : true,
						width : 150,
						id : 'addHouse',
						queryMode : 'local',
						store : Ext.getStore('house'),
						valueField : 'houseId',
						displayField : 'houseId',
				        listeners : {
							specialKey : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
								}
							}
						}
					
					},{
						xtype : 'textfield',
						fieldLabel : '活动编号',
						name : 'activityId'
					},{
						xtype : 'textfield',
						fieldLabel : '子订单编号',
						name : 'childOrderId'
					},{
						xtype : 'combobox',
						editable : false,
						fieldLabel : '是否已认购',
						name : 'isPurchased',
						store : 
							Ext.create('Ext.data.Store', {
							    fields: ['name','code'],
							    data : [{'name': '是','code':true},
									    {'name': '否','code':false}]
							}),
						valueField : 'code',
						displayField : 'name'
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '子订单状态',
						store : Ext.getStore('childOrderStatus'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'childOrderStatus',
						typeAhead : true,
						queryMode : 'local',
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addPerferentialForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'perferentialHouseList/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	addPerferentialHouseWin.close();
						    },
						    failure: function(form, action) {
						        Ext.Msg.alert('Failure',action.result.message);
						    }
						});
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
					addPerferentialHouseWin.close();
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
		addPerferentialHouseWin.show();
	},
	buildingPropertyTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('buildingPropertyType');
		record = store.findRecord('dictCode', val);
		if (record == null)
			return val;
		name = record.data.dictName;
		return name;
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
	boolRender: function(val){

		if(val)return '是';
		else return '否';
	},
	childOrderStatusRender : function(val) {
		store = Ext.getStore('childOrderStatus'); 
		record = store.findRecord('dictCode', val);
		if (record == null)
			return val;
		name = record.data.dictName;
		return name;
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
	},
	refreshData: function(){
		if(this.PerferentialHouseInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.actionMethods = {
				read : 'POST'
		};
		store.proxy.extraParams = {
				activityId : this.PerferentialHouseInfo.activityId
		};
		store.load();
	},
});