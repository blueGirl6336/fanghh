Ext.define('HRMS.module.lpgl.lpxxgl.view.BaseInfo',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.baseInfoPanel',
			layout : 'fit',
			title : '选择楼盘基本信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.BuildingStore'),
			initComponent : function() {
				var me = this;
				var boolStore = Ext.create("Ext.data.Store", {
				    fields: ["Name", "Value"],
				    data: [
				        { Name: "是", Value: 1 },
				        { Name: "否", Value: 0 }
				    ]
				});
			
				me.columns = [ {
					xtype : 'rownumberer',
					wdith : 120,
					text : '序号'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'buildingName',
					text : '楼盘名称',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'openingTime',
					text : '开盘时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'averagePrice',
					text : '均价',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'launchTime',
					text : '交房时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'buildingAddr',
					text : '楼盘地址',
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'buildingLocation',
					text : '楼盘位置',
					editor : {
						xtype : 'textfield'
					}
					
				}, {
					xtype : 'mycolumn',
					hidden : false,
					dataIndex : 'saleSiteLocation',
					text : '售楼部位置',
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					editable:false,
					align : 'center',
					dataIndex : 'highestCommission',
					text : '最高佣金',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
				
				}, {
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'cautionMoney',
					text : '保证金',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'duration',
					text : '保护期',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'planArea',
					text : '规划面积',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'constructionArea',
					text : '建筑面积',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'constructionKind',
					text : '建筑分类',
					renderer: me.constructionKindRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : Ext.getStore('constructionKind'),
						valueField : 'dictCode',
						displayField : 'dictName',
						editable : false,
						allowBlank : false
					}) 
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'constructionUse',
					text : '建筑用途',
					renderer : me.constructionUseRender,
					editor :  new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : Ext.getStore('constructionUse'),
						valueField : 'dictCode',
						displayField : 'dictName',
						editable : false,
						allowBlank : false
					}) 
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'plotRate',
					text : '容积率',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true,
						maxValue : 1
					})	
				},{
					xtype : 'mycolumn',
					editable:false,
					align : 'center',
					dataIndex : 'greeningRate',
					text : '绿化率',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true,
						maxValue : 1
					})
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'householdNum',
					text : '户数',
				}, {
					xtype : 'mycolumn',
					editable:false,
					align : 'center',
					dataIndex : 'parkingspaceNum',
					text : '车位数',
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'createTime',
					text : '创建时间'
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'purchaseNote',
					hidden : true,
					text : '创建时间'
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'isCopartner',
					text : '是否为合作楼盘',
					renderer : me.boolRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : boolStore,
						valueField : 'Value',
						displayField : 'Name',
						editable : false,
						allowBlank : false
					}) 
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'isActivited',
					text : '是否启用',
					renderer : me.boolRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : boolStore,
						valueField : 'Value',
						displayField : 'Name',
						editable : false,
						allowBlank : false
					}) 
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'sellingHotlabel',
					text : '是否为热销楼盘',
						
				},{
						xtype : 'mycolumn',
						editable : false,
						align : 'center',
						dataIndex : 'buildingType',
						text : '楼盘种类',
						
					
				},{
						xtype : 'mycolumn',
						editable : false,
						align : 'center',
						dataIndex : 'sellingHotSort',
						text : '热销排序',
				
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
	    						region.clearValue();
	    						region.setValue();
	    						var store = region.getStore();
								store.proxy.url = "region/search"
								store.proxy.extraParams = 
									{cityId:combo.getValue()};
								store.load();
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
	    					}
	    					
	    				}
					}, {
						xtype : 'textfield',
						fieldLabel : '楼盘名称',
						labelWidth : 60,
						hideLabel : false,
						width : 160,
						name : 'buildingName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchBuilding,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新楼盘',
						action: 'addNew'
					},{
						xtype : 'button',
						text : '上传楼盘LOGO',
						action: 'uploadImage'
					},'|' , {
						xtype : 'button',
						text : '删除楼盘信息',
						listeners : {
							click : {
								fn : me.deleteChosenItem,
								scope : me
							}
						}
					}
					]
				} ];
				this.callParent(arguments);
			},
			dateRender : function(val) {
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y-m-d');
			},
			searchBuilding : function() {
				var regionValue = this.down('textfield[name=region]').getValue();
				var buildingNameValue = this.down('textfield[name=buildingName]').getValue();
				var cityValue = this.down('textfield[name=city]').getValue();
				var store = this.store;
				store.proxy.api.read = "building/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if ((regionValue != null && regionValue != '')
						|| (buildingNameValue != null && buildingNameValue != '')
						||(cityValue != null && cityValue != '')) {
					store.proxy.extraParams = {
						buildingName : buildingNameValue,
						region : regionValue,
						city : cityValue 
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
				}

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
			boolRender: function(val){

				if(val)return '是';
				else return '否';
			},
			constructionKindRender : function(val) {
				store = Ext.getStore('constructionKind'); 
				record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
			},
			constructionUseRender : function(val) {
				store  = Ext.getStore('constructionUse');
				record = store.findRecord('dictCode', val);
				if(record == null)
					return val;
				name  = record.data.dictName;
				return name;
			},
			addToUser : function() {
				var record = this.getSelectionModel().getSelection()[0];
				if (record == null) {
					Ext.Msg.alert('操作错误', '请选择要添加的用户！');
					return;
				}
				var empNo = record.data.empNo;
				Ext.Ajax.request({
					url : 'baseinfo/addToSystemUser',
					method : 'GET',
					params : {
						empNo : empNo
					},
					success : function(response) {
						var obj=Ext.decode(response.responseText);  
		                if(obj.success == true) {//如果你处理的JSON串中true不是字符串，就obj.success == true
		                	Ext.Msg.alert('成功消息', obj.message);
		                } else {
		                	Ext.Msg.alert('失败消息', obj.message);
		                }
					}
				});

			}
		});