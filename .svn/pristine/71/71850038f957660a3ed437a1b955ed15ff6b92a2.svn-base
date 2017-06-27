Ext.define('HRMS.module.gzgl.ptgzgl.djyjfgz.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	
	refs : [ {
		ref : 'integralLevelPanel',
		selector : 'integralLevelPanel'
	}],

	views : 'HRMS.module.gzgl.ptgzgl.djyjfgz.view.*',
	
	chosenBaseInfo: 0,

// stores : ['HRMS.store.DictionaryItemStore'],
			
	init : function() {
		this.control({
			'integralLevelPanel dataview' : {
				itemclick : this.setEmpNoAndLoadData
			},
			'integralLevelPanel button[action=addNewRule]' : {
				click : this.addNewRule
			}
		});
		
	},
	addNewRule : function() {
		var me = this;
//		var panel=this.getShareInfoPanel();
		var addRuleWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新规则",
			// window的id，根据ID可以取得窗口对象
			id : 'addRuleWin',
			width : 400,
			height : 220,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addRuleForm',
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
						fieldLabel : '用户等级',
						name : 'userLevel',
						xtype : 'numberfield'
					},{
						fieldLabel : '最低积分',
						name : 'lowestStandard',
						xtype : 'numberfield'
					},{
						fieldLabel : '最高积分',
						name : 'highestStandard',
						xtype : 'numberfield'
					}]
				}]
			}],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addRuleForm').getForm();
//					var values = form.getValues();
					if(form.isValid()){
						form.submit({
							clientValidation: false,
							url: 'integralLevel/add',
							success: function(form, action) {
								Ext.Msg.alert('Success', action.result.message);						
								addRuleWin.close();
							},
							failure: function(form, action) {
								Ext.Msg.alert('Failure',action.result.message);
							}
						});
					}else{
						Ext.Msg.alert('注意','表单有未填项目！');
					}
				}
			},{
				text : '取消',
				width : 80,
				height : 30,
				handler : function() {
					// 点击取消，关闭窗口
					addRuleWin.close();
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
		addRuleWin.show();
	},
	setEmpNoAndLoadData: function(grid, record, item, index){

	}

});