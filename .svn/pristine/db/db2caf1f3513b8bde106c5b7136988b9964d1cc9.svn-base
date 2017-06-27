Ext.define('HRMS.module.hdgl.tghdgl.jbxxgl.view.GroupPurchaseHouseList', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '房源列表',
	border : 0,
	buildingInfo: 0,
	store : Ext.create('HRMS.store.building.GroupPurchaseHouseListStore'),
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
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'gphId'
		},{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'houseName',
			text : '房屋编号',
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'childOrderId',
			text : '子订单编号',
		},{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'isPurchased',
			text : '是否已认购',
			renderer : me.isPurchasedRender
		},{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'childOrderStatus',
			text : '子订单状态',
			renderer : me.childOrderStatusRender
		},{
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'activityId',
			text : '活动编号',
		}];
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
		if(this.builddingInfo == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
			activityId: this.buildingInfo.activityId
		};
		store.load();
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
	addNewItem : function() {
		var me = this;
		var addPersonWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新捡漏房屋",
			// window的id，根据ID可以取得窗口对象
			id : 'addGroupPurchaseHouseListWin',
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
				id : 'id_addGroupPurchaseHouseListForm',
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
						name : 'roof',
						id :'add_roof',
						autoSelect : true,
						fieldLabel : '楼栋',
						width : 150,
						queryMode : 'local',
						store : Ext.getStore('roofbeamStore'),
						valueField : 'roofId',
						displayField : 'roofName',
	                    listeners : {
	                    	expand  : function(combo,records,eOpts){	                    		
	                    		 var buildingId = me.buildingInfo.building.buildingId;
	                    		 var store = this.store;
	                    		store.proxy.extraParams = 
									{buildingId:buildingId};
	                    		store.proxy.actionMethods = 'GET';
	                    		store.load();
	                    	},
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					},
	    					select : function(combo,records,eOpts){
	    						var unit = Ext.getCmp('add_unit');
	    						unit.clearValue();
	    						//unit.setValue();
	    						//house.setValue();
	    						var unitStore = unit.getStore();
	    						unitStore.proxy.url = "unit/search";
	    						unitStore.proxy.extraParams = 
									{roofId : combo.getValue()};
	    						unitStore.load();
	    					}
	    				},
	    				allowBlank : false
					}, {
						xtype : 'combobox',
						name : 'unit',
						id : 'add_unit',
						autoSelect : true,
						fieldLabel : '单元',
						width : 150,
						queryMode : 'local',
						store : Ext.getStore('unitStore'),
						valueField : 'unitId',
						displayField : 'unitCode',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					},
					select : function(combo,records,eOpts){
						var house = Ext.getCmp('add_house');						
						house.setValue();
						var houseStore = house.getStore();
						houseStore.proxy.url = "house/search";
						houseStore.proxy.extraParams = 
							{unitId : combo.getValue()};
						houseStore.proxy.actionMethods = 'POST';
						houseStore.load();
					}
	    				},	    				
					}, {
						xtype : 'combobox',
						fieldLabel : '房屋编号',
						autoSelect : true,
						width : 150,
						name : 'house',
						id : 'add_house',
						queryMode : 'local',
						store : Ext.getStore('houseStore'),
						valueField : 'houseId',
						displayField : 'houseNum',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchBuilding();
	    						}
	    					}
	    				}					
					},{
						fieldLabel : '活动编号',
						name : 'activityId',
						value : this.buildingInfo.activityId,
						readOnly : true
					},{
						fieldLabel : '子订单编号',
						name : 'childOrderId'
					},{
						xtype : 'combobox',
						fieldLabel : '是否已认购',
						name : 'isPurchased',
						displayField : 'text',
						valueField : 'value',					
						store : new Ext.data.SimpleStore({  
			                 fields : ['value', 'text'],  
			                 data : [['0', '是'],  
			                         ['1', '否'] ] 
			             })
					},{
						xtype : 'combobox',
						fieldLabel : '子订单状态',
						name : 'childOrderStatus',
						displayField : 'text',
						valueField : 'value',					
						store : new Ext.data.SimpleStore({  
			                 fields : ['value', 'text'],  
			                 data : [['02010200', '有效'],  
			                         ['02010200', '无效'] ] 
			             })
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addGroupPurchaseHouseListForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'groupPurchaseHouseList/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);								
						       addPersonWin.close();
						       me.store.load();
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
		var roof = Ext.getCmp('add_roof');
		roof.clearValue();
		//unit.setValue();
		//house.setValue();
		var roofStore = roof.getStore();
		var buildingId = me.buildingInfo.building.buildingId;
		roofStore.proxy.extraParams = 
			{buildingId:buildingId};
		roofStore.proxy.actionMethods = 'GET';
		roofStore.load();
	},
	childOrderStatusRender : function(val){

		if(val == '02010200')return '有效';
		else return '无效';
	},
	isPurchasedRender : function(val){

		if(val)return '是';
		else return '否';
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
	commit: function(){
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