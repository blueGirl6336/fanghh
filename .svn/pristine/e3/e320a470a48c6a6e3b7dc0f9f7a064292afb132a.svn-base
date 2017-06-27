Ext.define('HRMS.module.hdgl.thhdgl.jbxxgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'tghdxxController',
	refs : [ {
		ref : 'perferentialHouseInfoPanel',
		selector : 'perferentialHouseInfoPanel'
	},{
		ref : 'otherInfoTabPanel',
		selector : 'otherInfoTabPanel'
	}],
	requires:'HRMS.customize.DateTimeField',
	views : 'HRMS.module.hdgl.thhdgl.jbxxgl.view.*',
	buildingId: 0,
	chosenBuildingInfo: 0,
// stores : ['HRMS.store.DictionaryItemStore'],
	init : function() {
		this.control({
			'perferentialHouseInfoPanel dataview' : {
				itemclick : this.setEmpNoAndLoadData,
				itemdblclick : this.editPerferentialHouseInfo
			},
			'perferentialHouseInfoPanel button[action=editPerferentialHouseInfo]' : {
				click : this.editPerferentialHouseInfo
			},
			'perferentialHouseInfoPanel button[action=addNewPerferentialHouseInfo]' : {
				click : this.addNewPerferentialHouseInfo
			},
			'perferentialHouseInfoPanel button[action=uploadImage]' : {
				click : this.uploadImage
			},
			'otherInfoTabPanel' : {
				tabchange : this.changePanel
			}
		});
		
	},
	
	setEmpNoAndLoadData: function(grid, record, item, index){
		// 获取人员信息对象 PerferentialHouseInfo
		var chosenPerferentialHouseInfo = grid.getStore().getAt(index).getData();
		// 获取标签页母页
		var tabPanel = this.getOtherInfoTabPanel();
		
		this.initTabPanel(tabPanel, chosenPerferentialHouseInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
				activityId : chosenPerferentialHouseInfo.activityId
		};
		store.proxy.actionMethods = {
				read : 'POST'
		};
		store.load();
	},
	initTabPanel: function(tabPanel, chosenPerferentialHouseInfo){
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i < length; i++){
			tabPanel.items.items[i].chosenPerferentialHouseInfo = chosenPerferentialHouseInfo;
		}
	},
	changePanel:function(grid, newCard){
		
		var tabPanel = this.getOtherInfoTabPanel();
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
				activityId : page.chosenPerferentialHouseInfo.activityId
		};
		store.load();
		
	},
	editPerferentialHouseInfo : function(){
		var me = this;
		var panel = this.getPerferentialHouseInfoPanel();
		var store = panel.getStore();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改的用户！');
			return;
		}
		var searchWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改特惠活动基本信息",
			// window的id，根据ID可以取得窗口对象
			id : 'searchWin',
			width : 700,
			height : 550,
			bodyPadding : 20,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_updatePerferentialHouseForm',
//				title : '特惠活动基本信息',
				layout : {
	                type: 'table',
	                columns: 2
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
						width : 300,
						layout : 'form',
						border : false,
						defaultType : 'textfield',
						defaults : {
							allowBlank : false
						},
						items : [{
							xtype : 'combobox',
							editable:false,
							fieldLabel : '城市',
							id : 'citytest',
							store : Ext.getStore('city'),
							valueField : 'cityId',
							displayField : 'cityName',
							name : 'city',
							value : record.data.building.region.city.cityId,
							typeAhead : true,
							queryMode : 'local',
					        listeners : {
								specialKey : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
										me.searchPerson();
									}
								},
								select : function(combo,records,eOpts){
			    					var region = Ext.getCmp('regiontest');
			    					var building = Ext.getCmp('buildingtest');
			    					region.clearValue();
			    					building.clearValue();
			    					region.setValue();
			    					building.setValue();
			    					var regionStore = region.getStore();
			    					var buildingStore = building.getStore();
									regionStore.proxy.url = "region/search";
									regionStore.proxy.extraParams = 
										{cityId:combo.getValue()};
									regionStore.load();
									buildingStore.proxy.url = "building/search";
									buildingStore.proxy.extraParams = 
										{
											city : combo.getValue(),
											region : region.getValue(),
											buildingName : building.getValue()
										};								
									buildingStore.proxy.actionMethods = 'POST';
									buildingStore.load();
			    				}
							},
							allowBlank : true
						}, {
							xtype : 'combobox',
							editable:false,
							fieldLabel : '区域',
							id : 'regiontest',
							store : Ext.getStore('region'),
							valueField : 'regionId',
							displayField : 'regionName',
							name : 'regionId',
							value : record.data.building.region.regionId,
							typeAhead : true,
							queryMode : 'local',
					        listeners : {
								specialKey : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
										me.searchPerson();
									}
								},
								select : function(combo,records,eOpts){
			    					var building = Ext.getCmp('buildingtest');
			    					building.clearValue();
			    					building.setValue();
			    					var store = building.getStore();
			    					store.filterBy(function(records){
			    						return records.get('region').regionId== combo.getValue();
			    					});						
			    				}	    					
							}
						}, {
							xtype : 'combobox',
							editable:false,
							fieldLabel : '楼盘名称',
							id : 'buildingtest',
							store : Ext.getStore('building'),
							valueField : 'buildingId',
							displayField : 'buildingName',
							name : 'building',
							value : record.data.building.buildingId,
							typeAhead : true,
							queryMode : 'local',
					        listeners : {
								specialKey : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
										me.searchBuilding();
									}
								}
							}
						
						}]
					},{
					layout : 'form',
					width : 300,
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						xtype : 'textfield',
						hidden : true,
						fieldLabel : '特惠活动名称',
						name : 'activityId',
						value : record.data.activityId,
					},{
						xtype : 'datefield',
						fieldLabel : '活动开始时间',
						//endDateField:'etime',
						//vtype:'daterange',
						name : 'startTime',
						format: 'Y-m-d H:i:s ',
						value : record.data.startTime,
					},{
						xtype : 'datefield',//
						fieldLabel : '活动结束时间',
						//endDateField:'etime',
						//vtype:'daterange',
						name : 'endTime',
						format: 'Y-m-d H:i:s ',
						value : record.data.endTime,
					},{
						xtype : 'textfield',
						fieldLabel : '活动图片',
						name : 'activityPic',
						value : record.data.activityPic,
					},{
						xtype : 'textfield',
						fieldLabel : '购房须知',
						name : 'purchaseNote',
						value : record.data.purchaseNote,
					},{
						xtype : 'textfield',
						fieldLabel : '备注',
						name : 'remark',
						value : record.data.remark,
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
						    url: 'perferentialHouseInfo/update',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	panel.getStore().load();
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
	
	addNewPerferentialHouseInfo : function() {
		var me = this;
		var panel=this.getPerferentialHouseInfoPanel();
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
	                columns: 2
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
						width : 300,
						layout : 'form',
						border : false,
						defaultType : 'textfield',
						defaults : {
							allowBlank : false
						},
						items : [{
							xtype : 'combobox',
							name : 'city',
							id :'add_city',
							autoSelect : true,
							fieldLabel : '城市',
							width : 150,
							queryMode : 'local',
							store : Ext.getStore('city'),
							valueField : 'cityId',
							displayField : 'cityName',
					        listeners : {
								specialKey : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
										me.searchPerson();
									}
								},
								select : function(combo,records,eOpts){
									var region = Ext.getCmp('add_region');
									var building = Ext.getCmp('add_building');
									region.clearValue();
									building.clearValue();
									region.setValue();
									building.setValue();
									var regionStore = region.getStore();
									var buildingStore = building.getStore();
									regionStore.proxy.url = "region/search";
									regionStore.proxy.extraParams = 
										{cityId:combo.getValue()};
									regionStore.load();
									buildingStore.proxy.url = "building/search";
									buildingStore.proxy.extraParams = 
										{
											city : combo.getValue(),
											region : region.getValue(),
											buildingName : building.getValue()
										};								
									buildingStore.proxy.actionMethods = 'POST';
									buildingStore.load();
								}
							},
							allowBlank : true
						}, {
							xtype : 'combobox',
							name : 'region',
							id : 'add_region',
							autoSelect : true,
							fieldLabel : '区域',
							width : 150,
							queryMode : 'local',
							store : Ext.getStore('region'),
							valueField : 'regionId',
							displayField : 'regionName',
					        listeners : {
								specialKey : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
										me.searchPerson();
									}
								},
						
						select : function(combo,records,eOpts){
							var building = Ext.getCmp('add_building');
							building.clearValue();
							building.setValue();
							var store = building.getStore();
							store.filterBy(function(records){
								return records.get('region').regionId== combo.getValue();
							});						
						}	    					
							}
						}, {
							xtype : 'combobox',
							fieldLabel : '楼盘名称',
							autoSelect : true,
							width : 150,
							name : 'building',
							id : 'add_building',
							queryMode : 'local',
							store : Ext.create('HRMS.store.building.BuildingStore'),
							valueField : 'buildingId',
							displayField : 'buildingName',
					        listeners : {
								specialKey : function(field, e) {
									if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
										me.searchBuilding();
									}
								}
							}
						
						}]
					},{
					layout : 'form',
					width : 300,
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						xtype : 'textfield',
						fieldLabel : '特惠活动名称',
						name : 'activityId'
					},{
						xtype : 'datefield',
						fieldLabel : '活动开始时间',
						//endDateField:'etime',
						//vtype:'daterange',
						name : 'startTime',
						format: 'Y-m-d H:i:s '
					},{
						xtype : 'datefield',//
						fieldLabel : '活动结束时间',
						//endDateField:'etime',
						//vtype:'daterange',
						name : 'endTime',
						format: 'Y-m-d H:i:s '
					},{
						xtype : 'textfield',
						fieldLabel : '活动图片',
						name : 'activityPic'
						
					},{
						xtype : 'textfield',
						fieldLabel : '购房须知',
						name : 'purchaseNote'
						
					},{
						xtype : 'textfield',
						fieldLabel : '备注',
						name : 'remark'
						
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
						    url: 'perferentialHouseInfo/add',
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
	
	selectAndLoadData : function(empNoValue){
		var panel=this.getBaseInfoPanel();
		panel.getSelectionModel().select(0);
		//获取需要查询的工号
		this.activityId = activityId;
		// 获取人员信息对象 PersonBaseInfo
		var chosenBaseInfo = panel.getStore().getAt(0).getData();
		// 获取标签页母页
		var tabPanel = this.getOtherinfopanel();
		
		this.initTabPanel(tabPanel, chosenBaseInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
				activityId : this.activityId
		};
		store.load();
	}
});