Ext.define('HRMS.module.lpgl.yjgzgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'yjgzController',
	refs : [ {
		ref : 'commissionRuleInfoPanel',
		selector : 'commissionRuleInfoPanel'
	}],

	views : 'HRMS.module.lpgl.yjgzgl.view.*',

// stores : ['HRMS.store.CommissionRuleStore'],
			
	init : function() {
		this.control({
			'commissionRuleInfoPanel dataview' : {
				itemdblclick : this.editCommissionRule
			},
			'commissionRuleInfoPanel button[action=editCommissionRule]' : {
				click : this.editCommissionRule
			},
			'commissionRuleInfoPanel button[action=addNew]' : {
				click : this.addNew
			}
		});
		
	},
	editCommissionRule : function(){
		var me = this;
		var panel = this.getCommissionRuleInfoPanel();
		var store = panel.getStore();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改的用户！');
			return;
		}
		var searchCommissionRuleWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改佣金规则",
			// window的id，根据ID可以取得窗口对象
			id : 'searchCommissionRuleWin',
			width : 700,
			height : 550,
			bodyPadding : 20,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_updateCommissionRuleForm',
//				title : '佣金规则信息',
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
						fieldLabel : '平台比例',
						name : 'plateProportional',
						xtype : 'numberfield',
						value : record.data.plateProportional,
					},{
						fieldLabel : '团长比例',
						name : 'teamLeaderProportion',
						xtype : 'numberfield',
						value : record.data.teamLeaderProportion,
					},{
						fieldLabel : '经纪人队长比例',
						name : 'brokerLeaderProportional',
						xtype : 'numberfield',
						value : record.data.brokerLeaderProportional,
					},{
						fieldLabel : '门店店长比例',
						name : 'storeLeaderProportion',
						xtype : 'numberfield',
						value : record.data.storeLeaderProportion,
					},{
						fieldLabel : '比例规则',
						name : 'corporateRule',
						value : record.data.corporateRule,
					},{
						fieldLabel : '地区比例',
						name : 'regionProportional',
						xtype : 'numberfield',
						value : record.data.regionProportional,
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '分佣类别',
						store : Ext.getStore('ruleType'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'ruleType',
						value : record.data.ruleType,
						typeAhead : true,
						queryMode : 'local',
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '规则状态',
						store : Ext.getStore('ruleStatus'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'ruleStatus',
						value : record.data.status,
						typeAhead : true,
						queryMode : 'local',
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
						editable:false,
						fieldLabel : '城市',
						id : 'citytest',
						store : Ext.getStore('city'),
						valueField : 'cityId',
						displayField : 'cityName',
						name : 'city',
						//value : record.data.building.region.city.cityId,
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
						//value : record.data.building.region.regionId,
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
						//value : record.data.building.buildingId,
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
				}
				]
			} ],
			buttons : [ {
				text : '确定修改',
				width : 80,
				height : 30,
				handler : function() {
					var me = this;
					var form = Ext.getCmp('id_updateCommissionRuleForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'commissionRule/update',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	panel.getStore().load();
						    	searchCommissionRuleWin.close();
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
					searchCommissionRuleWin.close();
				}
			} ],
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
		searchCommissionRuleWin.show();
	},
	addNew : function() {
		var me = this;
		var panel=this.getCommissionRuleInfoPanel();
		var addCommissionRuleWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新佣金规则",
			// window的id，根据ID可以取得窗口对象
			id : 'addCommissionRuleWin',
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
				id : 'id_addCommissionRuleForm',
//				title : '佣金规则信息',
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
						fieldLabel : '平台比例',
						name : 'plateProportional',
						xtype : 'numberfield',
					},{
						fieldLabel : '团长比例',
						name : 'teamLeaderProportion',
						xtype : 'numberfield',
					},{
						fieldLabel : '经纪人队长比例',
						name : 'brokerLeaderProportional',
						xtype : 'numberfield',
					},{
						fieldLabel : '门店店长比例',
						name : 'storeLeaderProportion',
						xtype : 'numberfield',
					},{
						fieldLabel : '比例规则',
						name : 'corporateRule',
					},{
						fieldLabel : '地区比例',
						name : 'regionProportional',
						xtype : 'numberfield',
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '分佣类别',
						store : Ext.getStore('ruleType'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'ruleType',
						typeAhead : true,
						queryMode : 'local',
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '规则状态',
						store : Ext.getStore('ruleStatus'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'ruleStatus',
						typeAhead : true,
						queryMode : 'local',
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
						editable:false,
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
					var form = Ext.getCmp('id_addCommissionRuleForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'commissionRule/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	addCommissionRuleWin.close();
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
					addCommissionRuleWin.close();
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
		addCommissionRuleWin.show();
	}
});