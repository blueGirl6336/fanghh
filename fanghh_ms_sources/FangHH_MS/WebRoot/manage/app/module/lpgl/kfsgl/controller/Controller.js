Ext.define('HRMS.module.lpgl.kfsgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'kfsController',
	refs : [ {
		ref : 'developerInfoPanel',
		selector : 'developerInfoPanel'
	},{
		ref : 'developerTabPanel',
		selector : 'developerTabPanel'
	}],
	views : 'HRMS.module.lpgl.kfsgl.view.*',
	developerId: 0,
	chosenDeveloperInfo: 0,
// stores : ['HRMS.store.DictionaryItemStore'],
	init : function() {
		this.control({
			'developerInfoPanel dataview' : {
				itemclick : this.setEmpNoAndLoadData,
				itemdblclick : this.editEmpNo
			},
			'developerInfoPanel button[action=editEmpNo]' : {
				click : this.editEmpNo
			},
			'developerInfoPanel button[action=addNew]' : {
				click : this.addNew
			},
			'developerTabPanel' : {
			}
		});
		
	},
	
	setEmpNoAndLoadData: function(grid, record, item, index){
//		alert('itemclick');
		 //获取需要查询的工号
		// 获取人员信息对象 PersonBaseInfo
		chosenDeveloperInfo = grid.getStore().getAt(index).getData();
		developerId = chosenDeveloperInfo.developerId;
		// 获取标签页母页
		var tabPanel = this.getDeveloperTabPanel();
		
		this.initTabPanel(tabPanel, chosenDeveloperInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			developerId : developerId
		};
		store.proxy.api.read = "building/searchByDeveloper";
		store.proxy.actionMethods = {
			read : 'GET'
		};
		store.load();
		
	},
	initTabPanel: function(tabPanel, developerInfo){
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i < length; i++){
			tabPanel.items.items[i].developerInfo = developerInfo;
		}
	},
	editEmpNo : function(){
		var panel = this.getDeveloperInfoPanel();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改的记录！');
			return;
		}
		var editDeveloperWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改开发商信息",
			// window的id，根据ID可以取得窗口对象
			id : 'editDeveloperWin',
			width : 400,
			height :440,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_updateDeveloperForm',
//				title : '人员基本信息',
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
						fieldLabel : '开发商Id',
						name : 'developerId',
						hidden : true,
						value : record.data.developerId,
					},
					         {
						fieldLabel : '开发商名称',
						name : 'developName',
						value : record.data.developName,
					},{
						fieldLabel : '开发商地址',
						name : 'developAddr',
						value : record.data.developAddr,
					},{	
						fieldLabel : '营业执照',
						name : 'businessLicense',
						value : record.data.businessLicense,
					},{
						fieldLabel : '资质等级',
						name : 'qualLevel',
						value : record.data.qualLevel,
					},{
						fieldLabel : '法人',
						name : 'legalPerson',
						value : record.data.legalPerson,
					},{
						fieldLabel : '法人职务',
						name : 'personPosition',
						value : record.data.personPosition,
					},{
						fieldLabel : '身份证号',
						name : 'brokerIdcard',
						value : record.data.brokerIdcard,
					},{
						fieldLabel : '联系电话',
						name : 'relationPhone',
						value : record.data.relationPhone,
					},{
						fieldLabel : '邮编',
						name : 'zipCode',
						value : record.data.zipCode,
					},{
						fieldLabel : 'email',
						name : 'email',
						value : record.data.email,
					},{
						fieldLabel : '备注',
						name : 'remark',
						value : record.data.remark,
						allowBlank : true
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定修改',
				width : 80,
				height : 30,
				handler : function() {
					var me = this;
					var form = Ext.getCmp('id_updateDeveloperForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'developer/update',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	panel.getStore().load();
						    	editDeveloperWin.close();
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
					editDeveloperWin.close();
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
		editDeveloperWin.show();
	},
	addNew : function() {
		var addDeveloperWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新开发商",
			// window的id，根据ID可以取得窗口对象
			id : 'addDeveloperWin',
			width : 400,
			height : 440,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addDeveloperForm',
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
						fieldLabel : '开发商名称',
						name : 'developName'
					},{
						fieldLabel : '开发商地址',
						name : 'developAddr'
					},{	
						fieldLabel : '营业执照',
						name : 'businessLicense',
						allowBlank : true
					},{
						fieldLabel : '资质等级',
						name : 'qualLevel',
						allowBlank : true
					},{
						fieldLabel : '法人',
						name : 'legalPerson',
						allowBlank : true
					},{
						fieldLabel : '法人职务',
						name : 'personPosition',
						allowBlank : true
					},{
						fieldLabel : '身份证号',
						name : 'brokerIdcard',
						allowBlank : true
					},{
						fieldLabel : '联系电话',
						name : 'relationPhone',
						allowBlank : true
					},{
						fieldLabel : '邮编',
						name : 'zipCode',
						allowBlank : true
					},{
						fieldLabel : 'email',
						name : 'email',
						allowBlank : true
					},{
						fieldLabel : '备注',
						allowBlank : true,
						name : 'remark'
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addDeveloperForm').getForm();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'developer/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	addDeveloperWin.close();
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
					addDeveloperWin.close();
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
		addDeveloperWin.show();
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