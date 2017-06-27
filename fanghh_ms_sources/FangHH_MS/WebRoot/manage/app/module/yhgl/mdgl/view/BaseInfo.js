Ext.define('HRMS.module.yhgl.mdgl.view.BaseInfo',
{
			extend : 'Ext.grid.Panel',
			alias : 'widget.baseInfoPanel',
			layout : 'fit',
			title : '门店管理',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create('HRMS.store.building.StoreStore'),
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
					width : 50,
					text : '序号'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'storeId',
					text : '门店编号',
					hidden:true
				}, {
					xtype : 'mycolumn',
					dataIndex : 'storeName',
					text : '门店名称',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'brokerName',
					width : 200,
					text : '门店负责人姓名',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				},{
					xtype : 'mycolumn',
					dataIndex : 'invitationCode',
					text : '门店码',
					hidden:true
				}, {
					xtype : 'mycolumn',
					width : 350,
					align : 'center',
					text : '操作',
					renderer : function() {
						return "<span style='color:orange;'>双击查看</span>";
					}
				} ];
				me.addListener('itemdblclick', itemdblclick);
				function itemdblclick(dv, record, item, index, e) {
					var me = this;
					//var panel=this.getBaseInfoPanel();
					var invitationCode = record.get("invitationCode");
					var brokerName = record.get('brokerName');
					var storeId = record.get("storeId");
					
					var picture1 = '';
					var picture2 = '';
					Ext.Ajax.request({
						url : 'storemanage/getStorePortrait',
						method : 'POST',
						async: false, 
						params : {
							storeId : record.get("storeId")
						},
						success : function(response) {
							var str = Ext.decode(response.responseText);
							picture1 = str.data[0];
							picture2 = str.data[1];
						}
					});
					
					var addPersonWin = Ext.create('Ext.window.Window', {
						// window标题
						title : "门店审核窗口",
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
								width : 250,
								border : false,
								defaultType : 'textfield',
								items : [{
									fieldLabel : '门店负责人',
									id:"brokerName",
									name:"brokerName",
									allowBlank : false,
									editable:false,
								},{
									fieldLabel : '门店码',
									id:"invitationCode",
									name:"invitationCode",
									allowBlank : false,
									locked : true,
								},{
									fieldLabel : '认证不通过原因',
									name:"failedReason",
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
						buttons : [{
							text : '审核通过',
							width : 100,
							height : 30,
							handler : function() {
								var form = Ext.getCmp('id_addPersonForm').getForm();
								var values = form.getValues();
								if(form.isValid()){
									form.submit({
									    clientValidation: false,
									    url: 'storemanage/auditStore',
									    params:{
									    	typeId:1,
									    	storeId : record.get("storeId")
									    },
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
							text : '不通过',
							width : 100,
							height : 30,
							handler : function() {
								var form = Ext.getCmp('id_addPersonForm').getForm();
								var values = form.getValues();
								if(form.isValid()){
									form.submit({
									    clientValidation: false,
									    url: 'storemanage/auditStore',
									    params:{
									    	typeId:2,
									    	storeId : record.get("storeId")
									    },
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
					Ext.getCmp("invitationCode").setValue(invitationCode);
					Ext.getCmp("brokerName").setValue(brokerName);
					Ext.getCmp("storeId").setValue(storeId);
					Ext.getCmp("picture1").getEl().dom.src = picture1;
					Ext.getCmp("picture2").getEl().dom.src = picture2;
				}
//				me.dockedItems = [ {
//					xtype : 'toolbar',
//					dock : 'top',
//					defaults:{
//						labelWidth:30,
//						padding:'0 4 1 4'
//					},
//					items : [{
//						xtype : 'button',
//						text : '刷新',
//						listeners : {
//							click : {
//								fn : me.refreshData,
//								scope : me
//							}
//						}
//					}]
//				} ];
				this.callParent(arguments);
			},
			refreshData: function(){
				var me = this;
				var store = me.store;
				store.proxy.extraParams = {
				};
				store.load();
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
			}
		});