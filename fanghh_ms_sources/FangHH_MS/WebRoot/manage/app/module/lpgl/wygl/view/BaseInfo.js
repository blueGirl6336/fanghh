Ext.define('HRMS.module.lpgl.wygl.view.BaseInfo',
		{
			extend : 'Ext.grid.Panel',
			layout : 'fit',
			title : '物业基本信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.PropertyStore'),
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
					text : '序号',
					width: 80
				}, {
					xtype : 'mycolumn',
					dataIndex : 'propertyName',
					text : '物业名称',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'propertyLeader',
					text : '物业领导 ',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'propertyPrice',
					text : '物业价格',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true
					})	
					
				}, {
					xtype : 'mycolumn',
					align : 'center',
					dataIndex : 'propertyAddr',
					text : '地址 ', 
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
					items : [{
						xtype : 'textfield',
						fieldLabel : '物业名称',
						labelWidth : 60,
						hideLabel : false,
						width : 160,
						name : 'propertyName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchProperty();
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchProperty,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新物业',
						listeners : {
							click : {
								fn : me.addNewProperty,
								scope : me
							}
						}
					},'|' , {
						xtype : 'button',
						text : '删除物业信息',
						listeners : {
							click : {
								fn : me.deleteChosenItem,
								scope : me
							}
						}
					}]
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
			addNewProperty : function() {
				var addPropertyWin = Ext.create('Ext.window.Window', {
					// window标题
					title : "添加新物业",
					// window的id，根据ID可以取得窗口对象
					id : 'addPropertyWin',
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
						id : 'id_addPropertyForm',
//						title : '人员基本信息',
						layout : {
			                type: 'table',
			                columns: 1
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
								fieldLabel : '物业名称',
								name : 'propertyName',
							},{
								fieldLabel : '物业领导',
								name : 'propertyLeader',
							},{
								fieldLabel : '价格',
								name : 'propertyPrice',
								xtype : 'numberfield',
							},{
								fieldLabel : '地址',
								name : 'propertyAddr',
							}]
						}]
					} ],
					buttons : [ {
						text : '确定添加',
						width : 80,
						height : 30,
						handler : function() {
							var form = Ext.getCmp('id_addPropertyForm').getForm();
								var values = form.getValues();
							console.log(values);
							if(form.isValid()){
								form.submit({
								    clientValidation: false,
								    url: 'Property/add',
								    success: function(form, action) {
								    Ext.Msg.alert('Success', action.result.message);

								    addPropertyWin.close();
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
							addPropertyWin.close();
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
				addPropertyWin.show();
			},
			searchProperty : function() {
				var nameValue = this.down('textfield[name=propertyName]').getValue();
				var store = this.store;
				store.proxy.api.read = "Property/searchByName";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if (nameValue != null && nameValue != '') {
					store.proxy.extraParams = {
							propertyName : nameValue
					};
					store.load();
					store.proxy.extraParams = {
							
					};
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