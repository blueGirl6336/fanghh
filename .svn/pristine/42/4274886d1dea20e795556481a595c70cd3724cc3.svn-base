Ext.define('HRMS.module.hdgl.thhdgl.jbxxgl.view.PerferentialHouseInfo',{
			extend : 'Ext.grid.Panel',
			alias : 'widget.perferentialHouseInfoPanel',
			layout : 'fit',
			title : '选择特惠基本信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.PerferentialHouseInfoStore'),
			initComponent : function() {
				var me = this;
				me.columns = [ {
					xtype : 'rownumberer',
					width : 80,
					text : '序号'
				},{
					xtype : 'mycolumn',
					dataIndex : 'phiId',
					width : 120,
					hidden:true,
					text : '特惠ID'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'buildingName',
					text : '特惠楼盘名称',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				},{
					xtype : 'mycolumn',
					dataIndex : 'activityId',
					text : '特惠活动ID',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				},{
					xtype : 'mycolumn',
					dataIndex : 'activityPic',
					text : '特惠活动图片',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'startTime',
					text : '特惠开始时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'endTime',
					text : '特惠结束时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'purchaseNote',
					text : '购买须知',
					editor : {
						xtype : 'textfield'
					}
					
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'remark',
					text : '备注',
					editor : {
						xtype : 'textfield'
					}
				}];
				me.dockedItems = [ {
					xtype : 'toolbar',
					dock : 'top',
					defaults:{
						labelWidth:100,
						padding:'0 4 1 4'
					},
					items : [ {
						xtype : 'datefield',
						fieldLabel : '活动开始时间',
						name : 'cstartTime',
						format : 'Y-m-d'
					},{
						xtype : 'datefield',		
						fieldLabel : '活动结束时间',
						name : 'cendTime',
						format : 'Y-m-d'
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
								fn : me.searchPerferentialHouseInfo,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新特惠活动',
						action: 'addNewPerferentialHouseInfo'
					},'|' , {
						xtype : 'button',
						text : '删除特惠活动信息',
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
			searchPerferentialHouseInfo : function() {
				var startTimeValue = this.down('datefield[name=cstartTime]').getValue();
				var endTimeValue = this.down('datefield[name=cendTime]').getValue();
				var buildingValue = this.down('textfield[name=building]').getValue();
				var store = this.store;
				store.proxy.api.read = "perferentialHouseInfo/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if ((startTimeValue != null && startTimeValue != '')
						|| (endTimeValue != null && endTimeValue != '')
						||(buildingValue != null && buildingValue != '')) {
					store.proxy.extraParams = {
						building : buildingValue,
						startTime : startTimeValue,
						endTime : endTimeValue 
					};
					store.load();
				} else {
					//Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
					store.proxy.extraParams = {
							building : buildingValue,
							startTime : startTimeValue,
							endTime : endTimeValue 
					};
					store.load();
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
			refreshData : function() {
				
				var store = this.getStore();
				store.proxy.api.read = "perferentialHouseInfo/getAll";
				store.proxy.actionMethods = {
						read : 'POST'
					};
				store.proxy.extraParams = {
				};
				store.load();
			},
			boolRender: function(val){

				if(val)return '是';
				else return '否';
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