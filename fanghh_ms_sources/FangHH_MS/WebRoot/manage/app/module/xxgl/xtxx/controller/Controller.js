Ext.define('HRMS.module.xxgl.xtxx.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	
	refs : [ {
		ref : 'pushNewsInfoPanel',
		selector : 'pushNewsInfoPanel'
	}],

	views : 'HRMS.module.xxgl.xtxx.view.*',
	
	chosenBaseInfo: 0,

			
	init : function() {
		this.control({
			'pushNewsInfoPanel button[action=addNew]' : {
				click : this.addNew
			},
		});
		
	},
	

	
	addNew : function() {
		var me = this;
		var panel = this.getPushNewsInfoPanel();
		var addNewsWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新消息",
			// window的id，根据ID可以取得窗口对象
			id : 'addNewsWin',
			width : 400,
			height : 300,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addNewsForm',
				layout : {
	                type: 'table',
	                columns: 2
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
					width : 300,
					border : false,
					defaultType : 'textfield',
					defaults : {
						allowBlank : false
					},
					items : [{
						xtype : 'combobox',
						fieldLabel : '经纪人',
						autoSelect : true,
						editable : false,
						width : 150,
						name : 'brokerId',
						id : 'brokerId',
						queryModel : 'local',
						store : Ext.create('HRMS.store.building.BrokerStore'),
						valueField : 'brokerId',
						displayField : 'brokerName'
					},{
						fieldLabel : '标题',
						name : 'title',
					},{
						fieldLabel : '内容',
						name : 'content',
						height : 60
					},{
						xtype : 'combobox',
						fieldLabel : '消息类型',
						autoSelect : true,
						editable : false,
						width : 150,
						name : 'newsType',
						id : 'newsType',
						queryModel : 'local',
						store : Ext.getStore('pushNewsType'),
						valueField : 'dictCode',
						displayField : 'dictName'
					}]
				}]
			}],
			buttons : [{
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addNewsForm').getForm();
//					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'pushNews/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	panel.refreshData();
						    	addNewsWin.close();
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
					addNewsWin.close();
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
		addNewsWin.show();
	}
});