Ext.define('HRMS.module.yhgl.bddh.view.BaseInfo',
{
			extend : 'Ext.grid.Panel',
			alias : 'widget.baseInfoPanel',
			layout : 'fit',
			title : '绑定400电话',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create('HRMS.store.building.FourDoubleZeroPhoneStore'),
			initComponent : function() {
				var me = this;
				me.columns = [ {
					xtype : 'rownumberer',
					width : 50,
					text : '序号'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'brokerId',
					text : '经纪人编号',
					hidden:true
				}, {
					xtype : 'mycolumn',
					dataIndex : 'brokerName',
					text : '经纪人姓名',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'brokerIdcard',
					width : 200,
					text : '经纪人身份证号',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'username',
					width : 150,
					text : '用户名',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'phoneNo',
					width : 150,
					text : '手机号',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'brokerType',
					width : 150,
					text : '经纪人类型',
					hidden:true,
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'invitationCode',
					width : 150,
					hidden:true,
					text : '激活码',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				},{
					xtype : 'mycolumn',
					width : 350,
					align : 'center',
					text : '操作',
					renderer : function() {
						return "<span style='color:orange;'>双击审核</span>";
					}
				} ];
				me.addListener('itemdblclick', itemdblclick);
				function itemdblclick(dv, record, item, index, e) {
					var me = this;
					var brokerName = record.get("brokerName");
					var brokerCard = record.get("brokerIdcard");
					var phoneno = record.get("phoneNo");
					var brokerId = record.get("brokerId");
					
					var fourZeroPhone = '';
					Ext.Ajax.request({
						url : 'realNameAuthentication/getFourDoublephone',
						method : 'POST',
						async: false, 
						params : {
							phoneNo : record.get("phoneNo")
						},
						success : function(response) {
							var str = Ext.decode(response.responseText);
							fourZeroPhone = str.data[0];
						}
					});
					var picture1 = '';
					var picture2 = '';
					Ext.Ajax.request({
						url : 'realNameAuthentication/getIdCardPic',
						method : 'POST',
						async: false, 
						params : {
							brokerId : record.get("brokerId")
						},
						success : function(response) {
							var str = Ext.decode(response.responseText);
							picture1 = str.data[0];
							picture2 = str.data[1];
						}
					});
					
					var addPersonWin = Ext.create('Ext.window.Window', {
						// window标题
						title : "绑定400电话窗口",
						// window的id，根据ID可以取得窗口对象
						id : 'addPersonWin',
						width : 700,
						height : 450,
						bodyPadding : 20,
						frame : false,
						buttonAlign:'center',
						bodyMargin : 10,
						closable : true,
						// window包含的元素
						items : [{
							xtype : 'form',
							id : 'id_addPersonForm',
							layout : {
				                type: 'table',
				                columns: 3
				            },
							labelSeparator : ':',
							frame : false,
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
								width : 250,
								border : false,
								defaultType : 'textfield',
								items : [{
									fieldLabel : '经纪人编号',
									hidden:true,
									id:"brokerId",
									name:"brokerId"
								},
								 {
									fieldLabel : '经纪人姓名',
									id:"brokerName",
									name:"brokerName",
									allowBlank : false,
									editable:false,
								},{
									fieldLabel : '经纪人身份证号',
									id:"brokerIdcard",
									name:"brokerIdcard",
									allowBlank : false,
									locked : true,
								},{
									fieldLabel : '经纪人手机号',
									id:"phoneNo",
									name:"phoneNo",
									allowBlank : false,
									editable:false,
								},{
									xtype : 'tbtext',
									text :  '绑定400电话：',								
								},{
									fieldLabel : '4006316161, +',
									id:"fourZeroPhone",
									name:"fourZeroPhone",									
								}]
							},{
								layout : 'form',
								width : 50,
								border : false,
								defaultType : 'textfield',
								items : []
							},
							{
								layout : 'form',
								border : false,
								defaultType : 'textfield',
								items : [{
									 xtype: 'box', //或者xtype: 'component',
									 id:"picture1",
									 name:"picture1",
									 width: 300, //图片宽度  
									 height: 200, //图片高度  
									 autoEl: {  
									      tag: 'img',    //指定为img标签  
									      src: picture1,    //指定url路径 
									      
									 } ,
								     listeners:{
					                       el:{
					                        click:function(){					                        	
					                        	window.open(picture1);
					                        }}
					                 } 
								},{
									 xtype: 'box', //或者xtype: 'component',
									 id:"picture2",
									 name:"picture2",
									 width: 300, //图片宽度  
									 height: 200, //图片高度  
									 autoEl: {  
									     tag: 'img',    //指定为img标签  
									     src: picture2,    //指定url路径  
									     
									 },
								      listeners:{
				                       el:{
				                        click:function(){
				                        	window.open(picture2);
				                        }}
				                     }
								}]
							}]
						}],
						buttons : [ {
							text : '暂存400电话',
							width : 100,
							height : 30,
							handler : function() {
								var form = Ext.getCmp('id_addPersonForm').getForm();
								var values = form.getValues();
								if(form.isValid()){
									form.submit({
									    clientValidation: false,
									    url: 'fourDoubleZeroPhone/bindFourDoubleZeroPhone',
									    params:{
									    	typeId:2
									    },
									    method: 'GET',
									    success: function(form, action) {
									    	Ext.Msg.alert('Success', action.result.message);
									        addPersonWin.close();
									        me.refreshData();
									    },
									    failure: function(form, action) {
									        Ext.Msg.alert('Failure',action.result.message);
									        me.refreshData();
									    }
									});
								}else{
									Ext.Msg.alert('注意','表单有未填项目！');
								}
							}
						},{
							text : '绑定400电话',
							width : 100,
							height : 30,
							handler : function() {
								var form = Ext.getCmp('id_addPersonForm').getForm();
								var values = form.getValues();
								if(form.isValid()){
									form.submit({
									    clientValidation: false,
									    url: 'fourDoubleZeroPhone/bindFourDoubleZeroPhone',
									    params:{typeId:1},
									    method: 'GET',
									    success: function(form, action) {
									    	Ext.Msg.alert('Success', action.result.message);
									        addPersonWin.close();
									        me.refreshData();
									    },
									    failure: function(form, action) {
									        Ext.Msg.alert('Failure',action.result.message);
									        me.refreshData();
									    }
									});
								}else{
									Ext.Msg.alert('注意','表单有未填项目！');
								}
							}
						}, {
							text : '审核不通过',
							width : 100,
							height : 30,
							handler : function() {
								var form = Ext.getCmp('id_addPersonForm').getForm();
								
								var values = form.getValues();
								if(form.isValid()){
									form.submit({
									    clientValidation: false,
									    url: 'fourDoubleZeroPhone/bindFourDoubleZeroPhone',
									    params:{typeId:3},
									    method: 'GET',
									    success: function(form, action) {
									    	Ext.Msg.alert('Success', action.result.message);
									        addPersonWin.close();
									        me.refreshData();
									    },
									    failure: function(form, action) {
									        Ext.Msg.alert('Failure',action.result.message);
									        me.refreshData();
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
					Ext.getCmp("brokerName").setValue(brokerName);
					Ext.getCmp("brokerIdcard").setValue(brokerCard);
					Ext.getCmp("phoneNo").setValue(phoneno);
					Ext.getCmp("brokerId").setValue(brokerId);
					Ext.getCmp("fourZeroPhone").setValue(fourZeroPhone);
					Ext.getCmp("picture1").getEl().dom.src = picture1;
					Ext.getCmp("picture2").getEl().dom.src = picture2;
				}
				/*me.dockedItems = [ {
					xtype : 'toolbar',
					dock : 'top',
					defaults:{
						labelWidth:30,
						padding:'0 4 1 4'
					},
					items : [ {
						xtype : 'textfield',
						fieldLabel : '手机号码',
						labelWidth : 60,
						hideLabel : false,
						width : 160,
						name : 'phoneNo',
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
								fn : me.searchPerson,
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
					}]
				} ];*/
				this.callParent(arguments);
			},
			refreshData: function(){
				var store = this.store;
				store.proxy.api.read = "fourDoubleZeroPhone/getAllPhone";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				store.proxy.extraParams = {
					
				};
				store.load();
			},
			dateRender : function(val) {
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y-m-d');
			},
			searchPerson : function() {
				var phoneNo = this.down('textfield[name=phoneNo]').getValue();
				var store = this.store;
				store.proxy.api.read = "realNameAuthentication/getByPhoneNo";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if (phoneNo != null && phoneNo != '') {
					store.proxy.extraParams = {
							phoneNo : phoneNo,
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '请输入查询条件！');
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