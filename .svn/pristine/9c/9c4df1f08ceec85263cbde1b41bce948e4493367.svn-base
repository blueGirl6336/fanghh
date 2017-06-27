Ext.define('HRMS.module.lpgl.csqygl.view.City',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.cityInfoPanel',
			layout : 'fit',
			title : '选择城市',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.building.CityStore'),
			initComponent : function() {
				var me = this;
				this.on('itemdblclick',me.editItem);
				var store =  this.store;
				store.proxy.api.read = "city/getAll";
				store.proxy.actionMethods = {
						read : 'POST'
					};
				store.proxy.extraParams = {
				};
				store.load();
				//this.cellEditing = new Ext.grid.plugin.CellEditing({
					//clicksToEdit : 2
				//});

				me.columns = [ {
					xtype : 'rownumberer',
					width : 40,
					align : 'center',
					text : '序号'
				}, {
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'cityName',
					text : '城市 名称',
					editor : {
						xtype : 'textfield'
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
						fieldLabel : '城市名称',
						hideLabel : false,
						width : 100,
						name : 'cityName',
						labelWidth : 60,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchCity();
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						action : 'refreshTabBtn',
						listeners : {
							click : {
								fn : me.searchCity,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加城市',
						listeners : {
							click : {
								fn : me.addNewItem,
								scope : me
							}
						}
					},/*{
						xtype : 'button',
						text : '删除城市',
						listeners : {
							click : {
								fn : me.deleteChosenItem,
								scope : me
							}
						}
					},*/
					{
						xtype : 'button',
						text : '编辑城市',
						listeners : {
							click : {
								fn : me.editItem,
								scope : me
							}
						}
					},{
						xtype : 'button',
						text : '刷新',
						//disabled : true,
						listeners : {
							click : {
								fn : me.refreshData,
								scope : me
							}
						}
					}
					]
				} ];
				//this.plugins = [ this.cellEditing ];
				this.callParent(arguments);
			},
			searchCity : function() {
				var cityValue = this.down('textfield[name=cityName]').getValue();
				var store = this.store;
				store.proxy.api.read = "city/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if (cityValue != null && cityValue != '') {
					store.proxy.extraParams = {
						cityName : cityValue,
						
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
				}

			},
			addNewItem : function() {
				var me = this;
				var addCityWin = Ext.create('Ext.window.Window', {
					// window标题
					title : "添加城市",
					// window的id，根据ID可以取得窗口对象
					id : 'addCityWin',
					width : 400,
					height : 180,
					bodyPadding : 20,
					frame : false,
					buttonAlign:'center',
					bodyMargin : 10,
					closable : true,
					// window包含的元素
					items : [{
						xtype : 'form',
						id : 'id_addCityForm',
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
								fieldLabel : '城市名称',
								name : 'cityName'
							}]
						}
						]
					} ],
					buttons : [ {
						text : '确定添加',
						width : 80,
						height : 30,
						handler : function() {
							var form = Ext.getCmp('id_addCityForm').getForm();
							if(form.isValid()){
								var cityName = form.findField('cityName').value;
								var rec = new HRMS.model.City({
									cityName:cityName,
									throughAudit : true
									
								});
								me.store.insert(0, rec);
								me.submitUpdate();
								addCityWin.close();
								
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
							addCityWin.close();
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
				addCityWin.show();
			},
			editItem :function(grid,rowIndex,event) {
				
				var position = this.getSelectionModel().getCurrentPosition();
				if (position == null) {
					return;
				}
				var record = this.store.getAt(position.row);
				
				var me = this;
				var editCityWin = Ext.create('Ext.window.Window', {
					// window标题
					title : "修改城市",
					// window的id，根据ID可以取得窗口对象
					id : 'editCityWin',
					width : 400,
					height : 180,
					bodyPadding : 20,
					frame : false,
					buttonAlign:'center',
					bodyMargin : 10,
					closable : true,
					// window包含的元素
					items : [{
						xtype : 'form',
						id : 'id_editCityForm',
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
								fieldLabel : '区域名称',
								name : 'cityName',
								value:	record.data.cityName,
							}]
						}
						]
					} ],
					buttons : [ {
						text : '确定修改',
						width : 80,
						height : 30,
						handler : function() {
							var form = Ext.getCmp('id_editCityForm').getForm();
							if(form.isValid()){
								var cityName = form.findField('cityName').value;
								var rec = new HRMS.model.Region({
									cityName:cityName,
									throughAudit : true
									
								});
								me.store.insert(0, rec);
								me.commit();
								editCityWin.close();
								
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
							editCityWin.close();
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
				editCityWin.show();
			},
			refreshData : function() {
				var store = this.getStore();
				store.proxy.api.read = "city/getAll";
				store.proxy.actionMethods = {
						read : 'POST'
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
		            	me.submitUpdate();
		            }
		        });
			},
			submitUpdate : function() {
				var me = this;
				this.getStore().sync({
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