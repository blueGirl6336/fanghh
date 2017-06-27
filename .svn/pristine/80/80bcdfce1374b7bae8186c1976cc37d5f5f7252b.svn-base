Ext.define('HRMS.module.hdgl.jlhdgl.jbxxgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'jlhdxxController',
	refs : [ {
		ref : 'baseInfoPanel',
		selector : 'baseInfoPanel'
	},{
		ref : 'otherinfopanel',
		selector : 'otherinfopanel'
	}],
	views : 'HRMS.module.hdgl.jlhdgl.jbxxgl.view.*',
	buildingId: 0,
	activityId : 0,
	chosenBuildingInfo: 0,
// stores : ['HRMS.store.DictionaryItemStore'],
	init : function() {
		this.control({
			'baseInfoPanel dataview' : {
				itemclick : this.setEmpNoAndLoadData,
				itemdblclick : this.editClearanceHouseInfo
			},
			'baseInfoPanel button[action=addNew]' : {
				click : this.addNew
			},
			'baseInfoPanel button[action=uploadImage]' : {
				click : this.uploadImage
			},
			'otherinfopanel' : {
				tabchange : this.changePanel
			}
		});
		
	},
	
	setEmpNoAndLoadData: function(grid, record, item, index){
//		alert('itemclick');
		 //获取需要查询的工号
		// 获取人员信息对象 PersonBaseInfo
		var chosenBuildingInfo = grid.getStore().getAt(index).getData();
		// 获取标签页母页
		var tabPanel = this.getOtherinfopanel();
		
		this.initTabPanel(tabPanel,  chosenBuildingInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		var roofBeamStore = Ext.getStore('roofbeamStore');
		roofBeamStore.proxy.extraParams = 
		{buildingId:chosenBuildingInfo.buildingId};
		roofBeamStore.proxy.actionMethods = 'GET';
		roofBeamStore.load();
		store.proxy.extraParams = {
			buildingId :  chosenBuildingInfo.buildingId,
			activityId :  chosenBuildingInfo.activityId
		};
		store.load();
	},
	initTabPanel: function(tabPanel, buildingInfo){
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i < length; i++){
			tabPanel.items.items[i].buildingInfo = buildingInfo;
		}
	},
	changePanel:function(grid, newCard){
		
		var tabPanel = this.getOtherinfopanel();
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			buildingId : page.buildingInfo.buildingId
		};
		store.load();
		
	},
	editClearanceHouseInfo : function(){
		var me = this;
		var panel = this.getBaseInfoPanel();
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
				id : 'id_updateBaseInfoForm',
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
						xtype : 'combobox',
						editable:false,
						hidden : true,
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
						value : record.data.house.houseId,
					    listeners : {
							specialKey : function(field, e) {
								if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
								}
							}
						}
					},{
						xtype : 'textfield',
						hidden : true,
						fieldLabel : '活动编号',
						name : 'activityId',
						value : record.data.activityId,
					},{
						xtype : 'textfield',
						fieldLabel : '活动图片',
						name : 'activityPic',
						value : record.data.activityPic,
					},{
						xtype : 'textfield',
						fieldLabel : '楼盘名称',
						name : 'buildingName',
						value : record.data.buildingName,
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
					var form = Ext.getCmp('id_updateBaseInfoForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'clearanceHouseInfo/update',
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
	addNew : function() {
		var me = this;
		var panel=this.getBaseInfoPanel();
		var addPersonWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新捡漏信息",
			// window的id，根据ID可以取得窗口对象
			id : 'addClearanceHouseInfoWin',
			width : 700,
			height : 550,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addClearanceHouseInfoForm',
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
					},{
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
						fieldLabel : '活动编号',
						name : 'activityId'
					},{
						fieldLabel : '活动图片',
						name : 'activityPic'
					},{
						xtype : 'datefield',
						fieldLabel : '开始时间',
						name : 'startTime',
						format : 'Y-m-d'
					},{
						xtype : 'datefield',
						fieldLabel : '结束时间',
						name : 'endTime',
						format : 'Y-m-d'
					},{
						fieldLabel : '购房须知',
						name : 'purchaseNote',
						xtype : 'textarea',
						height : 100
					},{
						fieldLabel : '备注',
						name : 'remark',
						xtype : 'textarea',
						height : 70
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addClearanceHouseInfoForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'clearanceHouseInfo/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);								
						       addPersonWin.close();
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
					addPersonWin.close();
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
		addPersonWin.show();
	},
	selectAndLoadData : function(empNoValue){
		var panel=this.getBaseInfoPanel();
		panel.getSelectionModel().select(0);
		//获取需要查询的工号
		this.empNo = empNoValue;
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
			empNo : this.empNo
		};
		store.load();
	}
});