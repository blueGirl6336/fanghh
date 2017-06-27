Ext.define('HRMS.module.gzgl.fxfxgzgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'fxfxController',
	refs : [ {
		ref : 'shareInfoPanel',
		selector : 'shareInfoPanel'
	}],
	views : 'HRMS.module.gzgl.fxfxgzgl.view.*',
	activityId: 0,
	chosenActivity: 0,
// stores : ['HRMS.store.DictionaryItemStore'],
	init : function() {
		this.control({
			'shareInfoPanel dataview' : {
				//itemclick : this.setEmpNoAndLoadData,
				itemdblclick : this.editEmpNo
			},
			'shareInfoPanel button[action=editEmpNo]' : {
				click : this.editEmpNo
			},
			'shareInfoPanel button[action=addNew]' : {
				click : this.addNew
			},
			'shareInfoPanel button[action=upload]' : {
				click : this.uploadPic
			},
			'shareInfoPanel' : {
			}
		});
		
	},
	
//	setEmpNoAndLoadData: function(grid, record, item, index){
////		alert('itemclick');
//		 //获取需要查询的工号
//		// 获取人员信息对象 PersonBaseInfo
//		chosenActivity = grid.getStore().getAt(index).getData();
//		activityId = chosenActivity.activityId;
//		// 获取标签页母页
//		var tabPanel = this.getDeveloperTabPanel();
//		
//		this.initTabPanel(tabPanel, chosenDeveloperInfo);
//		// 获取当前选中标签页
//		var page = tabPanel.getActiveTab();
//		// 更新数据
//		var store = page.getStore();
//		store.proxy.extraParams = {
//			developerId : developerId
//		};
//		store.proxy.api.read = "building/searchByDeveloper";
//		store.proxy.actionMethods = {
//			read : 'GET'
//		};
//		store.load();
//		
//	},
//	initTabPanel: function(tabPanel, developerInfo){
//		if(tabPanel == null)
//			return;
//		var length = tabPanel.items.length;
//		for(var i = 0; i < length; i++){
//			tabPanel.items.items[i].developerInfo = developerInfo;
//		}
//	},
	editEmpNo : function(){
		var panel = this.getShareInfoPanel();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改的记录！');
			return;
		}
		var buildingName ='';
		Ext.Ajax.request({
			async:false,
			url:'building/getNameById',
			params:{buildingId : record.data.buildingId},
			method: 'GET',
			success: function(response){
					var responseJson = Ext.JSON.decode(response.responseText);
			        // process server response here
					console.warn(responseJson.data);
					buildingName = responseJson.data;
			    }

		}); 
		var editActivityWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改分享返现规则信息",
			// window的id，根据ID可以取得窗口对象
			id : 'editActivityWin',
			width : 400,
			height :460,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_updateActivityForm',
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
						fieldLabel : '分享返现规则Id',
						name : 'activityId',
						hidden : true,
						value : record.data.activityId,
					},{
						fieldLabel : '楼盘Id',
						name : 'buildingId',
						hidden : true,
						value : record.data.buildingId,
					},
					{
						fieldLabel : '规则名称',
						name : 'activityName',
						value : record.data.activityName,
					},{
						fieldLabel : '规则图片',
						name : 'picture',
						value : record.data.picture,
						hidden:true,
					},{	
						fieldLabel : '规则网址',
						name : 'url',
						value : record.data.url,
						hidden:true,
					},{
						disabled:true,
						xtype:'textfield',
						fieldLabel : '楼盘',
						value:buildingName
					},{ 
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '总金额',
						name : 'totalCash',
						value : record.data.totalCash,
						hidden : true,
					},{ 
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '单次金额',
						name : 'perClickCash',
						value : record.data.totalCash/record.data.totalTimes ,
					}
					,{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '总次数',
						name : 'totalTimes',
						value : record.data.totalTimes,
					},{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '次数限制',
						name : 'limitTimes',
						value : record.data.limitTimes,
					},{
						editable:false,
						fieldLabel : '开始时间',
						name : 'startDate',
						value : record.data.startDate,
						xtype : 'datefield',		
						format : 'Y-m-d',
						listeners:{
							change:function(me, newValue, oldValue, eOpts)
							{
								
								var today = new Date();
								today=Ext.Date.clearTime(today);
								var start = new Date(newValue);
								if(start - today < 0)
								{
									Ext.Msg.alert('Warning','开始日期应该从今天开始');
								}
								
							}
						}
					},{
						editable:false,
						fieldLabel : '结束时间',
						name : 'endDate',
						value : record.data.endDate,
						xtype : 'datefield',		
						format : 'Y-m-d',
						listeners:{
							change:function(me, newValue, oldValue, eOpts)
							{
								
								var today = new Date();
								today=Ext.Date.clearTime(today);
								var start = new Date(newValue);
								if(start - today < 0)
								{
									Ext.Msg.alert('Warning','结束日期应该从今天开始');
								}
								
							}
						}
					},{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '当前次数',
						name : 'currentTimes',
						value : record.data.currentTimes,
					},{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '剩余金额',
						name : 'leftCash',
						value : record.data.leftCash,
					},{
						editable:false,
						xtype:'combo',
						store: new Ext.data.SimpleStore({
					        fields:['text','value'],
					        data: [
					               ['未上架','19010100'],['已上架','19010200'],['已下架未结算','19010300']         
					        ]
							
						}),
						displayField : 'text',
						valueField:'value',
						fieldLabel : '状态',
						emptyText : '选择状态',
						name : 'state', 
						mode: 'local',
						triggerAction: 'all',
						selectOnFocus:true,
						value : record.data.state,
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
					var form = Ext.getCmp('id_updateActivityForm').getForm();
					if(form.isValid()){
						
						var start = new Date(form.findField('startDate').value);
						var end = new Date(form.findField('endDate').value);
						var today = new Date();
						today=Ext.Date.clearTime(today);
						if(start - today < 0)
						{
							Ext.Msg.alert('Warning','开始日期应该从今天开始');
							return;
						}
						if(end - today < 0)
						{
							Ext.Msg.alert('Warning','结束日期应该从今天开始');
							return;
						}
						if(end - start < 0)
						{
							Ext.Msg.alert('Warning','结束日期应该晚于开始日期');
							return;
						}
						
						var totalcash = form.findField('perClickCash').value * form.findField('totalTimes').value;
						form.findField('leftCash').setValue(totalcash);
						form.findField('totalCash').setValue(totalcash);
						
						form.submit({
						    clientValidation: false,
						    url: 'activity/update',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	panel.getStore().load();
						    	editActivityWin.close();
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
					editActivityWin.close();
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
		editActivityWin.show();
	},
	addNew : function() {
		var addActivityWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "添加新分享返现规则",
			// window的id，根据ID可以取得窗口对象
			id : 'addActivityWin',
			width : 400,
			height : 380,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_addActivityForm',
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
					items : [
					         {
						fieldLabel : '规则名称',
						name : 'activityName',
					},{
						fieldLabel : '规则图片',
						name : 'picture',
						value:'http://localhost:8080/FangHH_MS/upload/default.jpg',
						hidden:true,
					},{	
						fieldLabel : '规则网址',
						name : 'url',
						value:'http://www.fanghh.com:8000',
						hidden:true,
					},{
						fieldLabel : '楼盘',
						name : 'buildingId',
						editable:false,
						xtype:'combo',
						emptyText : '选择楼盘',
						forceSelection : true,
						store:new Ext.data.Store({
							autoLoad : true, 
					        proxy: {
					            type: 'ajax',
					            url: 'building/getAllForCom',
					            
					            //url: 'city/getAll',
					            reader: {
					                type: 'json',
					                totalProperty: 'total',
					                root: 'data',
					                successProperty : 'success'
					            }
					        },
					        fields: [{
					            name: 'name'
					        }, {
					            name: 'id'

					        }]
					    }),
						displayField:'name',
						valueField:'id',
						triggerAction: 'all',
						selectOnFocus:true,
				        queryMode: 'remote'
					},{ 
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '总金额',
						name : 'totalCash',
						hidden:true,
						allowBlank : true,
					},
					{ 
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '单次金额',
						name : 'perClickCash',
					}
					,{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '总次数',
						name : 'totalTimes',
					},{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '次数限制',
						name : 'limitTimes'
					},{
						editable:false,
						fieldLabel : '开始时间',
						name : 'startDate',
						xtype : 'datefield',		
						format : 'Y-m-d',
						listeners:{
							change:function(me, newValue, oldValue, eOpts)
							{
								
								var today = new Date();
								today=Ext.Date.clearTime(today);
								var start = new Date(newValue);
								if(start - today < 0)
								{
									Ext.Msg.alert('Warning','开始日期应该从今天开始');
								}
								
							}
						}
						
					},{
						editable:false,
						fieldLabel : '结束时间',
						name : 'endDate',
						xtype : 'datefield',		
						format : 'Y-m-d',
						listeners:{
							change:function(me, newValue, oldValue, eOpts)
							{
								
								var today = new Date();
								today=Ext.Date.clearTime(today);
								var start = new Date(newValue);
								if(start - today < 0)
								{
									Ext.Msg.alert('Warning','结束日期应该从今天开始');
								}
								
							}
						}
						
					},{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '当前次数',
						name : 'currentTimes',
						hidden:true,
						value:0,
					},{
						xtype:'numberfield',
						minValue:0,
						fieldLabel : '剩余金额',
						name : 'leftCash',
						hidden:true,
						allowBlank : true,
					},{
						fieldLabel : '状态',
						name : 'state',
						hidden:true,
						value:'19010100'
					}]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					
					
					var form = Ext.getCmp('id_addActivityForm').getForm();
					if(form.isValid()){
						
						
						var start = new Date(form.findField('startDate').value);
						var end = new Date(form.findField('endDate').value);
						var today = new Date();
						today=Ext.Date.clearTime(today);
						if(start - today < 0)
						{
							Ext.Msg.alert('Warning','开始日期应该从今天开始');
							return;
						}
						if(end - today < 0)
						{
							Ext.Msg.alert('Warning','结束日期应该从今天开始');
							return;
						}
						if(end - start < 0)
						{
							Ext.Msg.alert('Warning','结束日期应该晚于开始日期');
							return;
						}
						
						var totalcash = form.findField('perClickCash').value * form.findField('totalTimes').value;
						form.findField('leftCash').setValue(totalcash);
						form.findField('totalCash').setValue(totalcash);
						form.submit({
						    clientValidation: false,
						    url: 'activity/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	addActivityWin.close();
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
					addActivityWin.close();
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
		addActivityWin.show();
	},
	uploadPic : function() {
		
		var panel = this.getShareInfoPanel();
		var record = panel.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改的记录！');
			return;
		}
		
		var activityId = record.data.activityId;
		var uploadWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改分享返现图片",
			// window的id，根据ID可以取得窗口对象
			id : 'uploadWin',
			width : 360,
			height:450,
			bodyPadding : 20,
			frame : false,
			buttonAlign:'center',
			bodyMargin : 10,
			closable : true,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_uploadForm',
				labelSeparator : ':',
				layout: {
	                 type: 'vbox',
	                 align: 'center'
	             },
				frame : false,
				items : [{
					id : 'upload',
					name : 'file',
					fieldLabel : '选择图片',
					xtype : 'filefield',
					width:300,
					buttonText : '浏览',
	                allowBlank: true,
					listeners : {
						'render' : function(f) {
								Ext.get('upload').on('change',
								function(field, newValue, oldValue) {
									// 上传图片类型
									var img_reg = /\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/;
											//得到选择的图片路径
									var url = 'file://'+ newValue.value;
													
									//alert("url = " +url );
											//是否是规定的图片类型
											if (img_reg.test(url)) {

												if (Ext.isIE) {
													var image = Ext.get('browseImage').dom;
													image.src = Ext.BLANK_IMAGE_URL;// 覆盖原来的图片
													image.filters
															.item("DXImageTransform.Microsoft.AlphaImageLoader").src = url;
													
												}// 支持FF
												else {
												    	Ext.get('browseImage').dom.src = window.URL.createObjectURL(newValue.files[0]);
												}
											}
											else
											{
												Ext.Msg.alert('操作错误', '图片格式错误！');
											}
											
										}, this);
						}
					},

				}, {
					
					xtype : 'component',
					id : 'browseImage',
					fieldLabel : "预览图片",
					autoEl : {
						width : 200,
						tag : 'img',
						src : record.data.picture,
						style : 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale);',
						complete : 'off',
						id : 'imageBrowse',
						align : 'center',
					}
				}	         
				]
			} ],
			
			buttons : [ {
				text : "提交",
				name : "submit",
				handler : function(){
					var form = Ext.getCmp('id_uploadForm').getForm();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'activity/upload',
						    params :{
	                        	activityId : activityId
	                        },
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	uploadWin.close();
						    },
						    failure: function(form, action) {
						        Ext.Msg.alert('Failure',action.result.message);
						    }
						});
					}else{
						Ext.Msg.alert('注意','请选择图片！');
					}
		}

			} ],
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding: '10'
			}
		});
		// 显示窗口
		uploadWin.show();
	},
	
	
});