Ext.define('HRMS.module.gzgl.fxfxgzgl.view.ShareInfo',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.shareInfoPanel',
			layout : 'fit',
			title : '选择分享返现规则信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.ActivityStore'),
			initComponent : function() {
				var me = this;
				var store =  this.store;
				store.proxy.api.read = "activity/getAll";
				store.proxy.actionMethods = {
						read : 'POST'
					};
				store.proxy.extraParams = {
				};
				store.load();
				me.columns = [ {
					xtype : 'rownumberer',
					width : 40,
					text:'序号'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'activityName',
					text : '规则名称',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'picture',
					text : '规则图片',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'url',
					text : '规则网址',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				}, {
					editable:false,
					xtype : 'mycolumn',
					dataIndex : 'buildingId',
					text : '楼盘',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					},
					renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){ 
//						var store = new Ext.data.Store({
//							autoLoad : true, 
//					        proxy: {
//					            type: 'ajax',
//					            url: 'building/getById',
//					            
//					            //url: 'city/getAll',
//					            reader: {
//					                type: 'json',
//					                root: 'data',
//					                totalProperty: 'total',
//					                successProperty : 'success'
//					            },
//					            fields:[{name:'id'},{name:'name'}]
//					        }
//					    });
//						store.proxy.extraParams = {
//								buildingId : value
//						};
//						store.load({
//							          params: {
//							         },
//							        callback: function(records, operation, success) {
//							            // do something after the load finishes
//							        	
//							        	value = store.get('name');
//							       },
//							        scope: this
//							    });
						Ext.Ajax.request({
							async:false,
							url:'building/getNameById',
							params:{buildingId : value},
							method: 'GET',
							success: function(response){
									var responseJson = Ext.JSON.decode(response.responseText);
							        // process server response here
									console.warn(responseJson.data);
									value = responseJson.data;
							    }

						}); 
						
						return value;
					} 
				}, {
					xtype : 'mycolumn',
					dataIndex : 'totalCash',
					text : '总金额',
					editor : {
						xtype : 'numberfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'totalTimes',
					text : '总次数',
					editor : {
						xtype : 'numberfield',
						allowBlank : false
					}
					
				}, {
					xtype : 'mycolumn',
					dataIndex : 'limitTimes',
					text : '次数限制',
					editor : {
						xtype : 'numberfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'startDate',
					text : '开始时间',
					editor : {
						xtype : 'datefield',
						allowBlank : false
					}
				
				}, {
					xtype : 'mycolumn',
					dataIndex : 'endDate',
					text : '结束时间',
					editor : {
						xtype : 'datefield',
						allowBlank : false
					}
					
				},{
					xtype : 'mycolumn',
					dataIndex : 'currentTimes',
					text : '当前次数',
					editor : {
						xtype : 'numberfield',
						minValue: 0,
						allowBlank : false,
					}
					
				},{
					xtype : 'mycolumn',
					dataIndex : 'leftCash',
					text : '剩余金额',
					editor : {
						xtype : 'numberfield',
						allowBlank : false
					}
				},{
					xtype : 'mycolumn',
					dataIndex : 'state',
					text : '状态',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					},
					renderer:function(val)
					{
						var value = '';
						switch(val)
						{
						case '19010100':
							value = '未上架';
							break;
						case '19010200':
							value = '已上架';
							break;
						case '19010300':
							value = '已下架但未结算';
							break;
						}
						
						return value;	
					}
				}
				];
				me.dockedItems = [ {
					xtype : 'toolbar',
					dock : 'top',
					defaults:{
						labelWidth:80,
						padding:'0 4 1 4'
					},
					items : [   {
						xtype : 'textfield',
						fieldLabel : '楼盘名称',
						labelWidth : 75,
						hideLabel : false,
						width : 195,
						name : 'buildingName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    						}
	    					}
	    				}
					},{
						xtype : 'textfield',
						fieldLabel : '规则名称',
						labelWidth : 75,
						hideLabel : false,
						width : 195,
						name : 'activityName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchActivity ,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加规则',
						action: 'addNew'
					},'|' , {
						xtype : 'button',
						text : '修改规则',
						action:'editEmpNo'
					},'|' , {
						xtype : 'button',
						text : '删除规则',
						listeners : {
							click : {
								fn : me.deleteChosenItem,
								scope : me
							}
						}
					},'|' , {
						xtype : 'button',
						text : '全部',
						listeners : {
							click : {
								fn : me.refreshData,
								scope : me
							}
						}
					},'|' , {
						xtype : 'button',
						text : '上传图片',
						action:'upload'
					}
					]
				} ];
				this.callParent(arguments);
			},
			searchActivity : function() {
				var buildingNameValue = this.down('textfield[name=buildingName]').getValue();
				var activityNameValue = this.down('textfield[name=activityName]').getValue();
				var store = this.store;
				store.proxy.api.read = "activity/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if ((buildingNameValue != null && buildingNameValue != '')
						|| (activityNameValue != null && activityNameValue != '')
						) {
					store.proxy.extraParams = {
							buildingName : buildingNameValue,
							activityName : activityNameValue,
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
				}

			},
			refreshData: function(){
				var store = this.getStore();
				store.proxy.api.read = "activity/getAll";
				store.proxy.actionMethods = {
						read : 'GET'
					};
				store.proxy.extraParams = {
				};
				store.load();
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
						/*me.refreshData();*/
					}
				});
			},
			
			///////////////////////////////////////////////
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