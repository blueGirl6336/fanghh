Ext.define('HRMS.module.lpgl.yjgzgl.view.CommissionRuleInfo',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.commissionRuleInfoPanel',
			layout : 'fit',
			title : '选择佣金规则信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.building.CommissionRuleStore'),
			initComponent : function() {
				var me = this;
				
				me.columns = [ {
					xtype : 'rownumberer',
					width : 40,
					text:'序号'
				}, {
					xtype : 'mycolumn',
					editable : false,
					dataIndex : 'createTime',
					align : 'center',
					width : 160,
					text : '创建时间',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'plateProportional',
					text : '平台比例(%)',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'teamLeaderProportion',
					text : '团长比例(%)',
					
				}, {
					xtype : 'mycolumn',
					dataIndex : 'brokerLeaderProportional',
					width : 140,
					text : '经纪人队长比例(%)',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'storeLeaderProportion',
					width : 140,
					text : '门店店长比例(%)',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'corporateRule',
					width : 300,
					text : '比例规则',
					
				}, {
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					width : 130,
					dataIndex : 'ruleType',
					text : '分佣类别',
					renderer : me.ruleTypeRender
				}, {
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'status',
					text : '规则状态',
					renderer : me.ruleStatusRender
				}, {
					xtype : 'mycolumn',
					dataIndex : 'regionProportional',
					text : '地区比例(%)',
				}];
				me.dockedItems = [ {
					xtype : 'toolbar',
					dock : 'top',
					defaults:{
						labelWidth:30,
						padding:'0 4 1 4'
					},
					items : [ {
						xtype : 'combobox',
						name : 'city',
						id :'city',
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
	    						var region = Ext.getCmp('region');
	    						var building = Ext.getCmp('building');
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
						id : 'region',
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
						var building = Ext.getCmp('building');
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
						id : 'building',
						queryModel : 'local',
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
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchCommissionRule ,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新佣金规则',
						action: 'addNew'
					},'|' , {
						xtype : 'button',
						text : '删除佣金规则',
						listeners : {
							click : {
								fn : me.deleteCommissionRule,
								scope : me
							}
						}
					}
					]
				} ];
				this.callParent(arguments);
			},
			searchCommissionRule : function() {
				var buildingId = Ext.getCmp('building').getValue();
				var store = this.store;
				store.proxy.api.read = "commissionRule/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if (buildingId != null && buildingId != '') {
					store.proxy.extraParams = {
							buildingId : buildingId
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '楼盘未输入！');
				}
			},
			deleteCommissionRule : function() {
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
				var me = this;
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
			refreshData : function() {
				
				var store = this.getStore();
				store.proxy.api.read = "commissionRule/getAll";
				store.proxy.actionMethods = {
						read : 'POST'
					};
				store.proxy.extraParams = {
				};
				store.load();
			},
			ruleTypeRender : function(val) {
				store = Ext.getStore('ruleType'); 
				record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
			},
			ruleStatusRender : function(val) {
				store  = Ext.getStore('ruleStatus');
				record = store.findRecord('dictCode', val);
				if(record == null)
					return val;
				name  = record.data.dictName;
				return name;
			},
		});