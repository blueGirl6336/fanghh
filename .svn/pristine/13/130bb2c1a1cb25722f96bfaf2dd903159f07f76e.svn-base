Ext.define('HRMS.module.lpgl.ldxxgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	refs : [ {
		ref : 'stafftransferform',
		selector : 'stafftransferform'
	},{
		ref : 'tansferpersonlist',
		selector : 'tansferpersonlist'
	},{
		ref : 'otherinfopanel' ,
		selector : 'otherinfopanel'
	},{
		ref:'researchAchvView',
		selector:'researchAchvView'
	}
	],

	views : 'HRMS.module.lpgl.ldxxgl.view.*',
	
	roofId : 0,
	init : function() {
		this.control({
			'tansferpersonlist dataview' : {
				itemclick : this.setEmpNoAndLoadData
			}/*,
			'tansferpersonlist button[action=refreshTabBtn]' : {
				click : this.refreshTabBtn
			}*/,
			'tansferpersonlist button[action=addNew]' : {
				click : this.addNew
			},
			'stafftransferform dataview' : {
				itemclick : this.setProjEmpNoAndLoadData
			},
			'otherinfopanel' : {
				tabchange : this.changePanel
			},
			'researchAchvView dataview':{
				//itemclick : this.setProjEmpNoAndLoadData
			}
		});
		this.clearTabPanel(this.getOtherinfopanel());
	},
	
	setEmpNoAndLoadData: function(grid, record, item, index){
		 //获取需要查询的工号
		this.roofId = record.data.roofId;
		// 获取人员信息对象 PersonBaseInfo
		var chosenBaseInfo = grid.getStore().getAt(index).getData();
		// 获取标签页母页
		var tabPanel = this.getStafftransferform();
		// 获取当前选中标签页
		//var page = tabPanel.getActiveTab();
		//if( chosenBaseInfo.empNo == page.personBaseInfo.empNo) return;
		//this.initTabPanel(tabPanel, chosenBaseInfo);
		// 更新数据
		tabPanel.roofBeam = chosenBaseInfo;
		var store = tabPanel.getStore();
		store.proxy.extraParams = {
				roofId : this.roofId
		};
		store.load();
	},
	initTabPanel: function(tabPanel, roofBeam){
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i < length; i++){
			var tabItem = tabPanel.items.items[i];
			tabItem.personBaseInfo = roofBeam;
			var tb = tabItem.dockedItems.items;
			var btns =tb[1].items;
			var bLen = btns.length;
			for (var b = 0; b < bLen; b++) {
			var btn = btns.items[b];
			btn.enable();
			}
		}
	},
	refreshTabBtn: function(){
		var tabPanel = this.getOtherinfopanel();
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i < length; i++){
			var tabItem = tabPanel.items.items[i];
			var tb = tabItem.dockedItems.items;
			var btns =tb[1].items;
			var bLen = btns.length;
			for (var b = 0; b < bLen; b++) {
			var btn = btns.items[b];
			btn.disable();
			}
		}
	},
	setProjEmpNoAndLoadData: function(grid, record, item, index){
		var chosenResearchAchv = grid.getStore().getAt(index).getData();
		var tabPanel = this.getOtherinfopanel();
		var page = tabPanel.getActiveTab();		
		page.unit = chosenResearchAchv;
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
				unitId :record.data.unitId
		};
		store.load();
	},
	changePanel: function(grid,newCard){
		if(this.empNo == 0)
			return;
		var tabPanel = this.getOtherinfopanel();
		var page = tabPanel.getActiveTab();
		var store = page.getStore();
		store.proxy.extraParams = {
				empNo : this.empNo
		};
		store.load();
	},
	clearTabPanel: function(tabPanel){
		if(tabPanel == null)
			return;
		for(var i = 0; i<length; i++){
			tabPanel.items.items[i].personBaseInfo = null;
		}
	},
	addNew : function() {
		var me = this;
		var panel=this.getTansferpersonlist();
		var addPersonWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新楼栋",
			// window的id，根据ID可以取得窗口对象
			id : 'addRoofBeamWin',
			width : 700,
			height : 400,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addRoofBeamForm',
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
						fieldLabel : '楼栋名称',
						name : 'roofName',
					},{
						xtype : 'combobox',
						fieldLabel : '物业类型',
						id : 'propertyType',
						name : 'propertyType',
						autoSelect : true,
						queryMode : 'local',
						store : Ext.getStore('propertyType'),
						valueField : 'dictCode',
						displayField : 'dictName',
						listeners : {
		    					specialKey : function(field, e) {
		    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
		    							me.searchPerson();
		    						}
		    					}
		    				}
					},{
						xtype : 'combobox',
						fieldLabel : '楼栋结构',
						name : 'roofStructer',
						id : 'roofStructer',
						autoSelect : true,
						queryMode : 'local',
						store : Ext.getStore('roofStructer'),
						valueField : 'dictCode',
						displayField : 'dictName',
						listeners : {
		    					specialKey : function(field, e) {
		    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
		    							me.searchPerson();
		    						}
		    					}
		    				}
					},{
						fieldLabel : '楼层总数',
						name : 'roofHeight'
					},{
						xtype : 'combobox',
						fieldLabel : '朝向',
						name : 'roofFace',
						id : 'roofFace',
						autoSelect : true,
						queryMode : 'local',
						store : Ext.getStore('face'),
						valueField : 'dictCode',
						displayField : 'dictName',
						listeners : {
		    					specialKey : function(field, e) {
		    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
		    							me.searchPerson();
		    						}
		    					}
		    				}
					},{
						fieldLabel : '最高层',
						name : 'airFloors',
						xtype : 'numberfield',
						minValue : 0
					},{
						fieldLabel : '最低层',
						name : 'earthFloors',
						xtype : 'numberfield',
						minValue : 0
					},{
						fieldLabel : '楼栋总户数',
						name : 'roofNum',
						xtype : 'numberfield',
						minValue : 0
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
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addRoofBeamForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'roofBeam/add',
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
	}
});