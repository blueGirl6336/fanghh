Ext.define('HRMS.module.hdgl.jlhdgl.jbxxgl.view.BaseInfo',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.baseInfoPanel',
			layout : 'fit',
			title : '选择捡漏基本信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.ClearanceHouseInfoStore'),
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
					width : 100,
					text : '序号'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'activityId',
					text : '活动编号',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'activityPic',
					text : '活动图片',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'buildingName',
					text : '楼盘名称',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'startTime',
					text : '开始时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'endTime',
					text : '结束时间',
					renderer : this.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y-m-d'
					}
				},{
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'purchaseNote',
					width : 200,
					text : '购房须知'
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'remark',
					width : 200,
					text : '备注'
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
						fieldLabel : '活动开始时间',
						name : 'startTime',
						format : 'Y-m-d'
					}, {
						xtype : 'datefield',
						fieldLabel : '活动结束时间',
						name : 'endTime',
						format : 'Y-m-d'
					},{
						xtype : 'textfield',
						fieldLabel : '楼盘名称',
						name : 'buildingName',
						emptyText : '楼盘名称',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					}
	    				}
					},{
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
						text : '添加捡漏信息',
						action: 'addNew'
					},'|' , {
						xtype : 'button',
						text : '删除捡漏信息',
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
				var startTimeValue = this.down('datefield[name=startTime]').getValue();
				var endTimeValue = this.down('datefield[name=endTime]').getValue();
				var buildingNameValue = this.down('textfield[name=buildingName]').getValue();
				var store = this.store;
				store.proxy.api.read = "clearanceHouseInfo/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				/*if ((startTimeValue != null && startTimeValue != '')
						|| (endTimeValue != null && endTimeValue != '') ||
						(buildingNameValue != null & buildingNameValue != "")) {*/
					store.proxy.extraParams = {
							startTime : startTimeValue,
							endTime : endTimeValue,
							buildingName : buildingNameValue
					};
					store.load();
				/*} else {
					Ext.Msg.alert('操作错误', '请输入查询条件！');
				}*/

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
			}
		});