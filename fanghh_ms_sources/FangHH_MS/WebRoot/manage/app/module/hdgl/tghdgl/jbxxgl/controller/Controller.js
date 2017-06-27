Ext.define('HRMS.module.hdgl.tghdgl.jbxxgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'tghdxxController',
	refs : [ {
		ref : 'baseInfoPanel',
		selector : 'baseInfoPanel'
	},{
		ref : 'otherinfopanel',
		selector : 'otherinfopanel'
	}],
	views : 'HRMS.module.hdgl.tghdgl.jbxxgl.view.*',
	buildingId: 0,
	chosenBuildingInfo: 0,
// stores : ['HRMS.store.DictionaryItemStore'],
	init : function() {
		this.control({
			'baseInfoPanel dataview' : {
				itemclick : this.setEmpNoAndLoadData,
				itemdblclick : this.editEmpNo
			},
			'baseInfoPanel button[action=editEmpNo]' : {
				click : this.editEmpNo
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
		
		this.initTabPanel(tabPanel, chosenBuildingInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			activityId : chosenBuildingInfo.activityId
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
	editEmpNo : function(){
		var me = this;
		var panel = this.getBaseInfoPanel();
		var store = panel.getStore();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改工号的用户！');
			return;
		}
		var searchWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改团购活动基本信息",
			// window的id，根据ID可以取得窗口对象
			id : 'searchWin',
			width : 700,
			height : 550,
			bodyPadding : 20,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_updateGroupPurchaseInfoForm',
//				title : '团购活动基本信息',
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
					width : 300,
					layout : 'form',
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						xtype : 'textfield',
						fieldLabel : '特惠活动名称',
						name : 'activityId',
						value : record.data.activityId,
						hidden : true,
					},{						
						fieldLabel : '意向人数',
						name : 'personNumInFavor',
						xtype : 'numberfield',
						value : record.data.personNumInFavor,
					},{
						fieldLabel : '最低人数标准',
						name : 'minPersonNumStandard',
						xtype : 'numberfield',
						value : record.data.minPersonNumStandard,
					},{
						xtype : 'datefield',
						fieldLabel : '活动开始时间',
						name : 'startTime',
						format : 'Y-m-d',
						value : record.data.startTime,
					},{
						xtype : 'datefield',		
						fieldLabel : '活动结束时间',
						name : 'endTime',
						format : 'Y-m-d',
						value : record.data.endTime,
					},{
						fieldLabel : '团购房屋数',
						name : 'totalOfferNum',
						xtype : 'numberfield',
						value : record.data.totalOfferNum,
					},{
						fieldLabel : '已认购房屋数',
						name : 'currentPurchasedNum',
						xtype : 'numberfield',
						value : record.data.currentPurchasedNum,
					},{
						fieldLabel : '每平方米原价',
						name : 'orginalPricePerSquareMeter',
						xtype : 'numberfield',
						value : record.data.orginalPricePerSquareMeter,
					},{
						fieldLabel : '团购房屋总原价',
						name : 'orginalHousePrice',
						xtype : 'numberfield',
						value : record.data.orginalHousePrice,
					},{
						fieldLabel : '每平方米现价',
						name : 'currentPricePerSquareMetre',
						xtype : 'numberfield',
						value : record.data.currentPricePerSquareMetre,
					},{
						fieldLabel : '团购房屋总现价',
						name : 'currentHouse',
						xtype : 'numberfield',
						value : record.data.currentHouse,
					},{
						fieldLabel : '购房须知',
						name : 'purchaseNote',
						xtype : 'textfield',
						value : record.data.purchaseNote,
					},{
						fieldLabel : '是否成功',
						name : 'isSuccess',
						xtype : 'textfield',
						value : record.data.isSuccess,
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
					var form = Ext.getCmp('id_updateGroupPurchaseInfoForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'groupPurchaseInfo/update',
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
			title : "添加新团购活动",
			// window的id，根据ID可以取得窗口对象
			id : 'addBuildingWin',
			width : 700,
			height : 370,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addBuildingForm',
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
				items : [{
					layout : 'form',
					width : 300,
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
						labelWidth : 60,
						autoSelect : true,
						width : 160,
						name : 'building',
						id : 'add_building',
						queryMode : 'local',
						store : Ext.create(
						'HRMS.store.building.BuildingStore'),
						valueField : 'buildingId',
						displayField : 'buildingName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchBuilding();
	    						}
	    					}
	    				}
					,click : function(combo,records,eOpts){
						var building = this.getStore();
						var a = Ext.getCmp('add_region').getValue();
						building.filterBy(function(records){
							if(a != null || "" != a) {
								return a== combo.getValue();
							}							
						});	
					}
					},{
						fieldLabel : '活动编号',
						name : 'activityId',
					},{
						fieldLabel : '意向人数',
						name : 'personNumInFavor',
						xtype : 'numberfield',
					},{
						fieldLabel : '最低人数标准',
						name : 'minPersonNumStandard',
						xtype : 'numberfield',
					},{
						xtype : 'datefield',
						fieldLabel : '活动开始时间',
						name : 'startTime',
						format : 'Y-m-d'
					},{
						xtype : 'datefield',		
						fieldLabel : '活动结束时间',
						name : 'endTime',
						format : 'Y-m-d'
					}]
				},
				{
					width : 300,
					layout : 'form',
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						fieldLabel : '团购房屋数',
						name : 'totalOfferNum',
						xtype : 'numberfield',
					},{
						fieldLabel : '已认购房屋数',
						name : 'currentPurchasedNum',
						xtype : 'numberfield',
					},{
						fieldLabel : '每平方米原价',
						name : 'orginalPricePerSquareMeter',
						xtype : 'numberfield',
					},{
						fieldLabel : '团购房屋总原价',
						name : 'orginalHousePrice',
						xtype : 'numberfield',
					},{
						fieldLabel : '每平方米现价',
						name : 'currentPricePerSquareMetre',
						xtype : 'numberfield',
					},{
						fieldLabel : '团购房屋总现价',
						name : 'currentHouse',
						xtype : 'numberfield',
					},{
						fieldLabel : '购房须知',
						name : 'purchaseNote',
						xtype : 'textfield',
					},{
						fieldLabel : '是否成功',
						name : 'isSuccess',
						xtype : 'textfield'
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addBuildingForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'groupPurchaseInfo/add',
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
	},
	uploadImage : function(){
		// 上传头像
		var panel=this.getBaseInfoPanel();
		var store = panel.getStore();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要上传头像的用户！');
			return;
		}
		var empNo = record.data.empNo;
		// Ext.Msg.alert('工号', empNo);
		var uploadImageWin = Ext.create('Ext.window.Window', {
			// window标题
			title : '上传头像',
			// window的id，根据ID可以取得窗口对象
			id : 'uploadImageWin',
			width : 440,
			height : 290,
		    frame : true,
			bodyPadding : 20,
			// window包含的元素
			items : [{
			    xtype : 'panel',
			    frame : false,
			    style:{'text-align':'center'},
			    border : 0,
			    items:[{
				    xtype: 'component', //或者xtype: 'component', 
				    id : 'personPhoto',
				    width: 100, //图片宽度     
				    height: 133, //图片高度
				    autoEl: {
				        tag: 'img',    //指定为img标签     
				        src: ''    //指定url路径     
				    }
			    }]
			},{
				xtype : 'form',
				border : 0,
			    frame : false,
				id : 'imageFilePanel',
				layout: {
                    type: 'table',
                    columns: 2
                },
				defaults : {
					padding : '0 5px 0 0',
					margin : '5px 0 0 0'
				},
				items:[{
					xtype : 'filefield',
                    id : 'id_fileField',  
                    name : 'file',  
                    fieldLabel : '头像图片文件',  
                    buttonText : '选择文件',
                    allowBlank: true
				},{
					xtype : 'button',
					height : 22,
					name : 'confirmUpload',
					text : '确认上传',
                    margins:'0',
			        handler: function(){
			            var form = Ext.getCmp('imageFilePanel').getForm();
			            var pic=Ext.getCmp('personPhoto');
			            //var empNo=Ext.getCmp('id_empNo').getValue();
			            if(form.isValid()){
		                    form.submit({
		                        url: 'transfer/uploadImage', 
		                        params :{
		                        	empNo : empNo
		                        },
		                        waitMsg: '正在上传文件...',
		                        method:'POST',
		                        success: function(fp, o) {
		                        	var task = new Ext.util.DelayedTask(function(){
			                        	Ext.Ajax.request({
											url : 'transfer/getImage',
											method : 'POST',
											params : {
												empNo : empNo
											},
											success : function(response) {
												var pic=Ext.getCmp('personPhoto');
												var obj=Ext.decode(response.responseText);

												pic.getEl().dom.src = obj.filename+'?id=' + Math.random();
											}
										});
		                        	});
		                        	task.delay(1000);
		                        }
		                    }); 
		                }
			        }
				}]
			},{
				border : 0,
			    style:{'text-align':'center'},
				html : '建议尺寸：300px*400px'
			}],
			buttons : [{
				text : '刷新',
				width : 80,
				height : 30,
				handler : function() {
					Ext.Ajax.request({
						url : 'transfer/getImage',
						method : 'POST',
						params : {
							empNo : empNo
						},
						success : function(response) {
							var pic=Ext.getCmp('personPhoto');
							var obj=Ext.decode(response.responseText);

							pic.getEl().dom.src = obj.filename+'?id=' + Math.random();
						}
					});
				}
			} ,{
				text : '取消',
				width : 80,
				height : 30,
				handler : function() {
					// 点击取消，关闭窗口
					uploadImageWin.close();
				}
			}],
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
		uploadImageWin.show();
		
		//获取指定empNo的人员头像
		Ext.Ajax.request({
			url : 'transfer/getImage',
			method : 'POST',
			params : {
				empNo : empNo
			},
			success : function(response) {
				var pic=Ext.getCmp('personPhoto');
				var obj=Ext.decode(response.responseText);

				pic.getEl().dom.src = obj.filename;
			}
		});
		
	},
	//二级单位部门级联
	changeSubUnit:function(){

		var depart=Ext.getCmp('id_department');
		var code=depart.getValue();
		var sub=Ext.getCmp('id_sub_unit');
		var store = sub.store;
//		store = Ext.create('HRMS.store.dictionary.SubUnitStore');
		store.proxy.extraParams = {
			department : code
		};
		store.load();
		sub.store = store;
		sub.setValue('');
	}
});