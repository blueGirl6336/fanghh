Ext.define('HRMS.module.yhgl.zygwgl.view.BaseInfo',
{
			extend : 'Ext.grid.Panel',
			alias : 'widget.baseInfoPanel',
			layout : 'fit',
			title : '置业顾问管理',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create('HRMS.store.building.HomeConsultantStore'),
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
					dataIndex : 'consultantId',
					text : '置业顾问编号',
					hidden:true
				}, {
					xtype : 'mycolumn',
					dataIndex : 'buildingName',
					text : '所属楼盘',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'consultantName',
					width : 200,
					text : '置业顾问姓名',
				}, {
					xtype : 'mycolumn',
					dataIndex : 'consultantIdcard',
					width : 150,
					text : '置业顾问身份证号',
				},  {
					xtype : 'mycolumn',
					dataIndex : 'phoneNo',
					width : 150,
					text : '手机号',
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					width : 120,
					dataIndex : 'isAgent',
					text : '是否为代理',
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
				}, {
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					width : 120,
					dataIndex : 'isStopped',
					text : '是否被暂停',
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
				}, {
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					width : 120,
					dataIndex : 'isOff',
					text : '是否被踢出楼盘',
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
				}];
				me.dockedItems = [ {
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
					}, {
						xtype : 'button',
						text : '添加',
						listeners : {
							click : {
								fn : me.addHomeConsultant,
								scope : me
							}
						}
					}, {
						xtype : 'button',
						text : '被踢出楼盘置业顾问重新绑定',
						listeners : {
							click : {
								fn : me.bindingHomeConsultant,
								scope : me
							}
						}
					}]
				} ];
				this.callParent(arguments);
			},
			addHomeConsultant : function(){
				var me = this;
				
				var addPersonWin = Ext.create('Ext.window.Window', {
					// window标题
					title : "添加置业顾问",
					// window的id，根据ID可以取得窗口对象
					id : 'addPersonWin',
					width : 450,
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
							labelWidth : 120,
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
							items : [{
								fieldLabel : '置业顾问姓名',
								name:"consultantName",
								allowBlank : false,
								maxLength: 8,
								autoCreate: {tag: 'input', type: 'text', size: '20', autocomplete: 'off', maxlength: '10'}
							},{
								xtype : "textfield",
								fieldLabel : '置业顾问身份证号',
								labelStyle : "text-align:right;width:40;",
								name:"consultantIdcard",
								allowBlank : false,
								regex : /^(\d{18,18}|\d{15,15}|\d{17,17}x)$/,
								regexText : '输入正确的身份号码'
							},{
								fieldLabel : '置业顾问手机号',
								name:"phoneNo",
								allowBlank : false,
								regex: /^1\d{10}$/,
								regexText : '输入正确的手机号码'
							},{
								xtype : 'combo',
								fieldLabel : '是否为代理',
								name:"isAgent",
								baseCls : "x-plain",
								readonly : true,
								editable : false,
								allowBlank : false,
								emptyText : '请选择',
								blankText : '该选项必选填写',
								mode: 'local',
								valueField: 'value',            //选项的 value 值，提交时传递的该值
							    displayField: 'text',           //选项的显示值
								store : new Ext.data.ArrayStore({  
			                        fields : ['value', 'text'],  
			                        data : [["true", '是'], ["false", '否']]  
			                    })
							},{
								xtype : 'combo',
								fieldLabel : '是否暂停接待',
								name:"isStopped",
								baseCls : "x-plain",
								readonly : true,
								editable : false,
								allowBlank : false,
								emptyText : '请选择',
								blankText : '该选项必选填写',
								mode: 'local',
								valueField: 'value',            //选项的 value 值，提交时传递的该值
							    displayField: 'text',           //选项的显示值
								store : new Ext.data.ArrayStore({  
			                        fields : ['value', 'text'],  
			                        data : [["true", '是'], ["false", '否']]  
			                    })
							},{
								xtype : 'combobox',
								fieldLabel : '楼盘名称',
								name:"buildingName",
								baseCls : "x-plain",
								readonly : true,
								editable : false,
								allowBlank : false,
								emptyText : '请选择',
								blankText : '该选项必选填写',
								store : Ext.getStore('buildNameWithId'),
								valueField : 'buildingId',
								displayField : 'buildingName',
							}]
						}]
					}],
					buttons : [ {
						text : '确定',
						width : 100,
						height : 30,
						handler : function() {
							var form = Ext.getCmp('id_addPersonForm').getForm();
							if(form.isValid()){
								form.submit({
								    clientValidation: false,
								    url: 'homeConsultant/add',
								    params:{},
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
			},
			bindingHomeConsultant:function(){
				var me = this;
				
				var bindingPersonWin = Ext.create('Ext.window.Window', {
					// window标题
					title : "重新绑定置业顾问",
					// window的id，根据ID可以取得窗口对象
					id : 'bindingPersonWin',
					width : 450,
					height : 450,
					bodyPadding : 20,
					frame : false,
					buttonAlign:'center',
					bodyMargin : 10,
					closable : true,
					// window包含的元素
					items : [{
						xtype : 'form',
						
						id : 'id_bindingPersonForm',
						layout : {
			                type: 'table',
			                columns: 3
			            },
						labelSeparator : ':',
						frame : false,
						//height : 290,
						fieldDefaults : {
							labelAlign : 'right',
							labelWidth : 120,
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
							items : [{
								fieldLabel : '置业顾问姓名',
								name:"consultantName",
								allowBlank : false,
								maxLength: 8,
								autoCreate: {tag: 'input', type: 'text', size: '20', autocomplete: 'off', maxlength: '10'}
							},{
								fieldLabel : '置业顾问手机号',
								name:"phoneNo",
								allowBlank : false,
								regex: /^1\d{10}$/,
								regexText : '输入正确的手机号码'
							},{
								xtype : 'combobox',
								fieldLabel : '重新绑定的楼盘名称',
								name:"buildingName",
								baseCls : "x-plain",
								readonly : true,
								editable : false,
								allowBlank : false,
								emptyText : '请选择',
								blankText : '该选项必选填写',
								store : Ext.getStore('buildNameWithId'),
								valueField : 'buildingId',
								displayField : 'buildingName',
							}]
						}]
					}],
					buttons : [ {
						text : '确定',
						width : 100,
						height : 30,
						handler : function() {
							var form = Ext.getCmp('id_bindingPersonForm').getForm();
							if(form.isValid()){
								form.submit({
								    clientValidation: false,
								    url: 'homeConsultant/binding',
								    params:{},
								    success: function(form, action) {
								    	Ext.Msg.alert('Success', action.result.message);
								    	bindingPersonWin.close();
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
							bindingPersonWin.close();
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
				bindingPersonWin.show();
			},
			refreshData: function(){
				var me = this;
				var store = me.store;
				store.proxy.extraParams = {
				};
				store.load();
			},
			boolRender: function(val){
				if(val)return '是';
				else return '否';
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
			}
		});