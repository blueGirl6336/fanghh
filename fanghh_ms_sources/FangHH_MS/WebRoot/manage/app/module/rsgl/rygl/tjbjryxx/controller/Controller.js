Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'tjbjryxxController',
	
	refs : [ {
		ref : 'baseInfoPanel',
		selector : 'baseInfoPanel'
	},{
		ref : 'otherinfopanel',
		selector : 'otherinfopanel'
	}],

	views : 'HRMS.module.rsgl.rygl.tjbjryxx.view.*',
	
	empNo: 0,
	
	chosenBaseInfo: 0,

// stores : ['HRMS.store.DictionaryItemStore'],
			
	init : function() {
		this.control({
			'baseInfoPanel dataview' : {
				itemclick : this.setEmpNoAndLoadData
			},
			'baseInfoPanel button[action=editEmpNo]' : {
				click : this.editEmpNo
			},
			'baseInfoPanel button[action=addNew]' : {
				click : this.addNew
			},
			'baseInfoPanel button[action=uploadImage]' : {
				click : this.uploadImage
			},
			'otherinfopanel' : {
				tabchange : this.changePanel
			}
		});
		
	},
	
	setEmpNoAndLoadData: function(grid, record, item, index){
//		alert('itemclick');
		 //获取需要查询的工号
		this.empNo = record.data.empNo;
		// 获取人员信息对象 PersonBaseInfo
		var chosenBaseInfo = grid.getStore().getAt(index).getData();
		// 获取标签页母页
		var tabPanel = this.getOtherinfopanel();
		
		this.initTabPanel(tabPanel, chosenBaseInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			empNo : this.empNo
		};
		store.load();
	},
	initTabPanel: function(tabPanel, baseInfo){
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i < length; i++){
			tabPanel.items.items[i].baseInfo = baseInfo;
		}
	},
	changePanel:function(grid, newCard){
		if(this.empNo == 0 )
			return;
		var tabPanel = this.getOtherinfopanel();
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			empNo : this.empNo
		};
		store.load();
		
	},
	editEmpNo : function(){
		var me = this;
		var panel = this.getBaseInfoPanel();
		var store = panel.getStore();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改工号的用户！');
			return;
		}
		var name = record.data.name;
		var empNo = record.data.empNo;
		// Ext.Msg.alert('工号', empNo);
		var searchWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改员工工号",
			// window的id，根据ID可以取得窗口对象
			id : 'searchWin',
			width : 440,
			height : 200,
			bodyPadding : 20,
			// window包含的元素
			items : [ {
				xtype : 'textfield',
				fieldLabel : '姓名',
				value : record.data.name,
				readOnly:true
			}, {
				xtype : 'textfield',
				fieldLabel : '原工号',
				value : record.data.empNo,
				readOnly:true
			}, {
				xtype : 'textfield',
				fieldLabel : '新工号',
				name : 'newEmpNo',
				allowBlank : false
			} ],
			buttons : [ {
				text : '确定修改',
				width : 80,
				height : 30,
				handler : function() {
					
					this.setDisabled(true);
					var oldEmpNo=searchWin.items.items[1].getValue();
					var newEmpNo=searchWin.items.items[2].getValue();
					if(newEmpNo==null||newEmpNo==''){
						Ext.Msg.alert('错误', '新工号不能为空！');
						this.setDisabled(false);
						return;
					}
					//Ext.Msg.alert('值', oldEmpNo+' '+newEmpNo);
					Ext.Ajax.request({
						url : 'baseinfo/updateEmpNo',
						method : 'POST',
						params : {
							oldEmpNo : oldEmpNo,
							newEmpNo: newEmpNo
						},
						success : function(response) {
							 var obj=Ext.decode(response.responseText);  
				                if(obj.success == true) {//如果你处理的JSON串中true不是字符串，就obj.success == true
				                	Ext.Msg.alert('成功消息', obj.message);

				    				var departmentValue = panel.down('combobox[name=department]')
				    						.getValue();
				            		store.proxy.extraParams = {
											quota : 1,
											empNo : newEmpNo,
											name : '',
											department : '',
											doe : null
										};
				                	store.load({
										// 选择第一项，点击事件
										callback: function(records, options, success){
											me.selectAndLoadData(newEmpNo);
											} 
										});
				                	
				                } else {
				                	Ext.Msg.alert('失败消息', obj.message);
				                }
				                searchWin.close();
						},
						failure : function(response) {
							Ext.Msg.alert('出现错误', '未知错误');
						}
					});
				}
			}, {
				text : '取消',
				width : 80,
				height : 30,
				handler : function() {
					// 点击取消，关闭窗口
					searchWin.close();
				}
			} ],
			// 自适应滚动条
			autoScroll : true,
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding:'10'
			}
		});
		// 显示窗口
		searchWin.show();
	},
	addNew : function() {
		var me = this;
		var panel=this.getBaseInfoPanel();
		var addPersonWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新员工",
			// window的id，根据ID可以取得窗口对象
			id : 'addPersonWin',
			width : 700,
			height : 370,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addPersonForm',
//				title : '人员基本信息',
				layout : {
	                type: 'table',
	                columns: 2
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
						xtype : 'combobox',
						editable:false,
						fieldLabel : '调入类型',
						store : Ext.getStore('transferType'),
						valueField : 'code',
						displayField : 'name',
						name : 'transferType',
						typeAhead : true,
						queryMode : 'local',
						listeners : {
							'beforequery' : function(e) {
								var combo = e.combo;
								// 过滤为调出的选项
								combo.store.filterBy(function(record) {
									var mode = record.get('value');
									if (mode == 'in') {
										return true;
									}
									return false;
								});
								// 展开
								combo.expand();
								return false;
							}
						}
					},{
						fieldLabel : '工号',
						id : 'id_empNo',
						name : 'empNo',
						vtype: 'alphanum'
					},{
						fieldLabel : '姓名',
						name : 'name'
					},{
						xtype : 'combobox',
						fieldLabel : '性别',
						name : 'sex',
						editable : false,
						store : 
							Ext.create('Ext.data.Store', {
							    // reader configs
							    fields: ['name'],
							    data : [{'name': '男'},
									    {'name': '女'}]
							}),
						valueField : 'name',
						displayField : 'name'
					},{
						fieldLabel : '民族',
						allowBlank : true,
						name : 'ethnic'
					},{
						fieldLabel : '身份证号码',
						name : 'idCard',
						vtype: 'alphanum',     
						//maxLength:18,
						maxLengthText:'长度为18',
						//minLength:18,
						minLengthText:'长度为18'

					},{
						xtype : 'datefield',
						editable : false,
						format : 'Y/m/d',
						fieldLabel : '出生日期',
						name : 'dob'
					},{
						fieldLabel : '籍贯',
						allowBlank : true,
						name : 'hometown'
					},{
						fieldLabel : '出生地',
						allowBlank : true,
						name : 'birthPlace'
					}]
				},
				{
					width : 300,
					layout : 'form',
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '编制属性',
						store : Ext.getStore('quotaType'),
						valueField : 'code',
						displayField : 'name',
						name : 'quotaType'
					},{
							xtype : 'datefield',
							editable:false,
							format : 'Y/m/d',
							fieldLabel : '参加工作时间',
							name : 'dateOfStartWork'
						},{
							xtype : 'datefield',
							editable:false,
							format : 'Y/m/d',
							fieldLabel : '本校入职时间',
							name : 'dateOfEntry',
							value:new Date()
						},{
							xtype : 'combobox',
							editable:false,
							fieldLabel : '聘任方式',
							store : Ext.getStore('employType'),
							valueField : 'code',
							displayField : 'name',
							name : 'empType',
							typeAhead : true,
							queryMode : 'local',
							allowBlank : true
						},{
							xtype : 'combobox',
							id : 'id_department',
							editable:false,
							fieldLabel : '所属部门',
							store : Ext.getStore('department'),
							valueField : 'code',
							displayField : 'name',
							name : 'department',
							listeners : {
								select : me.changeSubUnit
							}
						},{
							xtype : 'combobox',
							id : 'id_sub_unit',
							editable:false,
							fieldLabel : '二级单位',
							allowBlank : true,
							name : 'sub_unit',
							store : Ext.create('HRMS.store.dictionary.SubUnitStore'),
							valueField : 'code',
							displayField : 'name'
						},{
							xtype : 'combobox',
							editable:false,
							fieldLabel : '岗位类别',
							store : Ext.getStore('jobType'),
							valueField : 'code',
							displayField : 'name',
							name : 'jobType'
						},{
							xtype : 'combobox',
							editable:false,
							fieldLabel : '双基地',
							name : 'doubleEmp',
							store : 
								Ext.create('Ext.data.Store', {
								    // reader configs
								    fields: ['name','code'],
								    data : [{'name': '是','code':true},
										    {'name': '否','code':false}]
								}),
							valueField : 'code',
							displayField : 'name'
						},{
							xtype : 'combobox',
							editable:false,
							fieldLabel : '教师类别',
							store : Ext.getStore('teacherType'),
							valueField : 'code',
							displayField : 'name',
							name : 'teacher_type',
							allowBlank : true
						}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addPersonForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'transfer/in/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);

								var empNoValue = Ext.getCmp('id_addPersonForm')
									.down('textfield[name=empNo]').getValue();
								var store = panel.store;
								if(store == null || store == undefined)
									store = Ext.create(
											'HRMS.store.personnel.PersonBaseInfoStore', {
												id : 'store-HRMS.module.rsgl.rygl.tjbjryxx'
											});
								store.proxy.api.read = "baseinfo/search";
								store.proxy.actionMethods = {
									read : 'POST'
								};
								if ((empNoValue != null && empNoValue != '')) {
									store.proxy.extraParams = {
										quota : 1,
										empNo : empNoValue,
										name : '',
										department : '1',
										doe : null
									};
									store.load({
										// 选择第一项，点击事件
										callback: function(records, options, success){
											me.selectAndLoadData(empNoValue);
											} 
										});
								}
						       addPersonWin.close();
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
	selectAndLoadData : function(empNoValue){
		var panel=this.getBaseInfoPanel();
		panel.getSelectionModel().select(0);
		//获取需要查询的工号
		this.empNo = empNoValue;
		// 获取人员信息对象 PersonBaseInfo
		var chosenBaseInfo = panel.getStore().getAt(0).getData();
		// 获取标签页母页
		var tabPanel = this.getOtherinfopanel();
		
		this.initTabPanel(tabPanel, chosenBaseInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			empNo : this.empNo
		};
		store.load();
	},
	uploadImage : function(){
		// 上传头像
		var panel=this.getBaseInfoPanel();
		var store = panel.getStore();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要上传头像的用户！');
			return;
		}
		var empNo = record.data.empNo;
		// Ext.Msg.alert('工号', empNo);
		var uploadImageWin = Ext.create('Ext.window.Window', {
			// window标题
			title : '上传头像',
			// window的id，根据ID可以取得窗口对象
			id : 'uploadImageWin',
			width : 440,
			height : 290,
		    frame : true,
			bodyPadding : 20,
			// window包含的元素
			items : [{
			    xtype : 'panel',
			    frame : false,
			    style:{'text-align':'center'},
			    border : 0,
			    items:[{
				    xtype: 'component', //或者xtype: 'component', 
				    id : 'personPhoto',
				    width: 100, //图片宽度     
				    height: 133, //图片高度
				    autoEl: {
				        tag: 'img',    //指定为img标签     
				        src: ''    //指定url路径     
				    }
			    }]
			},{
				xtype : 'form',
				border : 0,
			    frame : false,
				id : 'imageFilePanel',
				layout: {
                    type: 'table',
                    columns: 2
                },
				defaults : {
					padding : '0 5px 0 0',
					margin : '5px 0 0 0'
				},
				items:[{
					xtype : 'filefield',
                    id : 'id_fileField',  
                    name : 'file',  
                    fieldLabel : '头像图片文件',  
                    buttonText : '选择文件',
                    allowBlank: true
				},{
					xtype : 'button',
					height : 22,
					name : 'confirmUpload',
					text : '确认上传',
                    margins:'0',
			        handler: function(){
			            var form = Ext.getCmp('imageFilePanel').getForm();
			            var pic=Ext.getCmp('personPhoto');
			            //var empNo=Ext.getCmp('id_empNo').getValue();
			            if(form.isValid()){
		                    form.submit({
		                        url: 'transfer/uploadImage', 
		                        params :{
		                        	empNo : empNo
		                        },
		                        waitMsg: '正在上传文件...',
		                        method:'POST',
		                        success: function(fp, o) {
		                        	var task = new Ext.util.DelayedTask(function(){
			                        	Ext.Ajax.request({
											url : 'transfer/getImage',
											method : 'POST',
											params : {
												empNo : empNo
											},
											success : function(response) {
												var pic=Ext.getCmp('personPhoto');
												var obj=Ext.decode(response.responseText);

												pic.getEl().dom.src = obj.filename+'?id=' + Math.random();
											}
										});
		                        	});
		                        	task.delay(1000);
		                        }
		                    }); 
		                }
			        }
				}]
			},{
				border : 0,
			    style:{'text-align':'center'},
				html : '建议尺寸：300px*400px'
			}],
			buttons : [{
				text : '刷新',
				width : 80,
				height : 30,
				handler : function() {
					Ext.Ajax.request({
						url : 'transfer/getImage',
						method : 'POST',
						params : {
							empNo : empNo
						},
						success : function(response) {
							var pic=Ext.getCmp('personPhoto');
							var obj=Ext.decode(response.responseText);

							pic.getEl().dom.src = obj.filename+'?id=' + Math.random();
						}
					});
				}
			} ,{
				text : '取消',
				width : 80,
				height : 30,
				handler : function() {
					// 点击取消，关闭窗口
					uploadImageWin.close();
				}
			}],
			// 自适应滚动条
			autoScroll : true,
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding:'10'
			}
		});
		// 显示窗口
		uploadImageWin.show();
		
		//获取指定empNo的人员头像
		Ext.Ajax.request({
			url : 'transfer/getImage',
			method : 'POST',
			params : {
				empNo : empNo
			},
			success : function(response) {
				var pic=Ext.getCmp('personPhoto');
				var obj=Ext.decode(response.responseText);

				pic.getEl().dom.src = obj.filename;
			}
		});
		
	},
	//二级单位部门级联
	changeSubUnit:function(){

		var depart=Ext.getCmp('id_department');
		var code=depart.getValue();
		var sub=Ext.getCmp('id_sub_unit');
		var store = sub.store;
//		store = Ext.create('HRMS.store.dictionary.SubUnitStore');
		store.proxy.extraParams = {
			department : code
		};
		store.load();
		sub.store = store;
		sub.setValue('');
	}
});