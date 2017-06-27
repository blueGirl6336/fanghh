Ext.define('HRMS.module.hdgl.tghdgl.jbxxgl.view.BaseInfo',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.baseInfoPanel',
			layout : 'fit',
			title : '团购基本信息管理',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.GroupPurchaseInfoStore'),
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
					dataIndex : 'gpId',
					text : '活动ID',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
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
					dataIndex : 'activityId',
					text : '活动编号',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'activityPic',
					text : '活动图片',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'personNumInFavor',
					text : '意向人数',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : false
					})		
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'minPersonNumStandard',
					text : '最低人数标准',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : false
					})	
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'startTime',
					text : '活动开始时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
					
				}, {
					xtype : 'mycolumn',
					hidden : false,
					dataIndex : 'endTime',
					text : '活动结束时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
				}, {
					xtype : 'mycolumn',
					editable:false,
					align : 'center',
					dataIndex : 'totalOfferNum',
					text : '团购房屋数',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : false
					})	
				
				}, {
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'currentPurchasedNum',
					text : '已认购房屋数',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : false
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'orginalPricePerSquareMeter',
					text : '每平方米原价',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'orginalHousePrice',
					text : '团购房屋总原价',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'currentPricePerSquareMetre',
					text : '每平方米现价',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'currentHouse',
					text : '团购房屋总现价',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'purchaseNote',
					text : '购房须知',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'isSuccess',
					text : '是否成功',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}];
				me.dockedItems = [ {
					xtype : 'toolbar',
					dock : 'top',
					defaults:{
						labelWidth:30,
						padding:'0 4 1 4'
					},
					items : [ {
						xtype : 'datefield',
						format : 'Y-m-d',
						renderer:new Ext.util.Format.dateRenderer("Y-m-d"),
						name : 'startTime',
						id :'startTime',
						autoSelect : true,
						fieldLabel : '开始时间',
						width : 150,
	    				allowBlank : false
					}, {
						xtype : 'datefield',
						format : 'Y-m-d',
						renderer:new Ext.util.Format.dateRenderer("Y-m-d"),
						name : 'endTime',
						id :'endTime',
						autoSelect : true,
						fieldLabel : '结束时间',				
						width : 150,
	    				allowBlank : false
					}, {
						xtype : 'combobox',
						fieldLabel : '楼盘名称',
						labelWidth : 60,
						autoSelect : true,
						width : 160,
						name : 'building',
						id : 'building',
						queryModel : 'local',
						store : Ext.getStore('building'),
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
								fn : me.searchGroupPurchaseInfo,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新团购信息',
						action: 'addNew'
					},'|' , {
						xtype : 'button',
						text : '删除团购信息',
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
			searchGroupPurchaseInfo : function() {
				var startTime = this.down('textfield[name=startTime]').getValue();
				var buildingValue = this.down('textfield[name=building]').getValue();
				var endTime = this.down('textfield[name=endTime]').getValue();
				var store = this.store;
				store.proxy.api.read = "groupPurchaseInfo/search";
				store.proxy.actionMethods = {
					read : 'GET'
				};
				/*if ((buildingNameValue != null && buildingNameValue != '')) {*/
				store.proxy.extraParams = {
					building : buildingValue,
					startTime : startTime,
					endTime : endTime 
				};
				store.load();
				/*} else {
					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
				}*/

			},
			deleteChosenItem : function() {
				var record = this.getSelectionModel().getSelection()[0];
				
				var gpId = record.data.gpId;
				Ext.Ajax.request({
					url : 'groupPurchaseInfo/delete',
					method : 'POST',
					params : {
						gpId : gpId
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