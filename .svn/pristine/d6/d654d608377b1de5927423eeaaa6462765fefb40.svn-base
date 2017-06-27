Ext.define('HRMS.module.yhgl.bddh.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	refs : [ {
		ref : 'baseInfoPanel',
		selector : 'baseInfoPanel'
	},{
		ref : 'otherinfopanel',
		selector : 'otherinfopanel'
	}],
	views : 'HRMS.module.yhgl.bddh.view.*',
	buildingId: 0,
	chosenBuildingInfo: 0,
	init : function() {
		this.control({
			'baseInfoPanel dataview' : {
				itemclick : this.setEmpNoAndLoadData,
				itemdblclick : this.editEmpNo
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
		// 获取人员信息对象 PersonBaseInfo
		var chosenBuildingInfo = grid.getStore().getAt(index).getData();
		// 获取标签页母页
		var tabPanel = this.getOtherinfopanel();
		
		this.initTabPanel(tabPanel, chosenBuildingInfo);
		// 获取当前选中标签页
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			buildingId : chosenBuildingInfo.buildingId
		};
		store.load();
	},
	initTabPanel: function(tabPanel, buildingInfo){
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i < length; i++){
			tabPanel.items.items[i].buildingInfo = buildingInfo;
		}
	},
	changePanel:function(grid, newCard){
		
		var tabPanel = this.getOtherinfopanel();
		var page = tabPanel.getActiveTab();
		// 更新数据
		var store = page.getStore();
		store.proxy.extraParams = {
			buildingId : page.buildingInfo.buildingId
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
			title : "修改楼盘基本信息",
			// window的id，根据ID可以取得窗口对象
			id : 'searchWin',
			width : 700,
			height : 550,
			bodyPadding : 20,
			// window包含的元素
			items : [{
				xtype : 'form',
				id : 'id_updateBuildingForm',
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
						fieldLabel : '楼盘Id',
						name : 'buildingId',
						hidden : true,
						value : record.data.buildingId,
					},
					         {
						fieldLabel : '楼盘名称',
						name : 'buildingName',
						value : record.data.buildingName,
					},{
						xtype : 'datefield',
						fieldLabel : '开盘时间',
						name : 'openingTime',
						format : 'Y-m-d',
						value : record.data.openingTime,
					},{
						xtype : 'datefield',		
						fieldLabel : '售房时间',
						name : 'launchTime',
						format : 'Y-m-d',
						value : record.data.launchTime,
					},{
						fieldLabel : '均价',
						name : 'averagePrice',
						xtype : 'numberfield',
						value : record.data.averagePrice,
					},{
						fieldLabel : '最高佣金',
						name : 'highestCommission',
						xtype : 'numberfield',
						value : record.data.highestCommission,
					},{
						fieldLabel : '保证金',
						name : 'cautionMoney',
						xtype : 'numberfield',
						value : record.data.cautionMoney,
					},{
						fieldLabel : '保护期',
						name : 'duration',
						xtype : 'numberfield',
						value : record.data.duration,
					},{
						fieldLabel : '视频路径',
						name : 'videoLink',
						value : record.data.videoLink,
					},{
						fieldLabel : '规划面积',
						name : 'planArea',
						xtype : 'numberfield',
						value : record.data.planArea,
					},{
						fieldLabel : '建筑面积',
						name : 'constructionArea',
						xtype : 'numberfield',
						value : record.data.constructionArea,
					},{
						fieldLabel : '容积率',
						name : 'plotRate',
						xtype : 'numberfield',
						value : record.data.plotRate,
					},{
						fieldLabel : '绿化率',
						name : 'greeningRate',
						xtype : 'numberfield',
						value : record.data.greeningRate,
					},{
						fieldLabel : '户数',
						name : 'householdNum',
						xtype : 'numberfield',
						value : record.data.householdNum,
					},{
						fieldLabel : '停车位数',
						name : 'parkingspaceNum',
						xtype : 'numberfield',
						value : record.data.parkingspaceNum,
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
						fieldLabel : '城市',
						id : 'citytest',
						store : Ext.getStore('city'),
						valueField : 'cityId',
						displayField : 'cityName',
						name : 'city',
						value : record.data.region.city.cityId,
						typeAhead : true,
						queryMode : 'local',
						 listeners : {
		    					specialKey : function(field, e) {
		    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
		    							me.searchPerson();
		    						}
		    					},
		    					select : function(combo,records,eOpts){
		    						var region = Ext.getCmp('regiontest');
		    						region.clearValue();
		    						region.setValue();
		    						var store = region.getStore();
									store.proxy.url = "region/search"
									store.proxy.extraParams = 
										{cityId:combo.getValue()};
									store.load();
		    					}
		    				}
						
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '区域',
						id : 'regiontest',
						store : Ext.getStore('region'),
						valueField : 'regionId',
						displayField : 'regionName',
						name : 'regionId',
						value : record.data.region.regionId,
						typeAhead : true,
						queryMode : 'local',
						
					},{
						fieldLabel : '楼盘位置',
						name : 'buildingLocation',
						value : record.data.buildingLocation,
					},{
						fieldLabel : '楼盘地址',
						name : 'buildingAddr',
						value : record.data.buildingAddr,
					},{
						fieldLabel : '售房部地址',
						name : 'saleSiteLocation',
						value : record.data.saleSiteLocation,
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '建筑类型',
						store : Ext.getStore('constructionKind'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'constructionKind',
						value : record.data.constructionKind,
						typeAhead : true,
						queryMode : 'local',
						
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '建筑用途',
						store : Ext.getStore('constructionUse'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'constructionUse',
						value : record.data.constructionUse,
						typeAhead : true,
						queryMode : 'local',
						
					},{
						xtype : 'combobox',
						editable : false,
						fieldLabel : '是否为合作楼盘',
						name : 'isCopartner',
						value : record.data.isCopartner,
						store : 
							Ext.create('Ext.data.Store', {
							    fields: ['name','code'],
							    data : [{'name': '是','code':true},
									    {'name': '否','code':false}]
							}),
						valueField : 'code',
						displayField : 'name'
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '是否启用',
						name : 'isActivited',
						value : record.data.isActivited,
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
						fieldLabel : '购房须知',
						name : 'purchaseNote',
						xtype : 'textarea',
						value : record.data.purchaseNote,
						height : 140
					},]
				}
				]
			} ],
			buttons : [ {
				text : '确定修改',
				width : 80,
				height : 30,
				handler : function() {
					var me = this;
					var form = Ext.getCmp('id_updateBuildingForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'building/update',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);
						    	panel.getStore().load();
						    	searchWin.close();
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
					searchWin.close();
				}
			} ],
			dateRender : function(val) {
				alert('1');
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y-m-d');
			},
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
			title : "添加新楼盘",
			// window的id，根据ID可以取得窗口对象
			id : 'addBuildingWin',
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
				id : 'id_addBuildingForm',
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
						fieldLabel : '楼盘名称',
						name : 'buildingName',
					},{
						xtype : 'datefield',
						fieldLabel : '开盘时间',
						name : 'openingTime',
						format : 'Y-m-d'
					},{
						xtype : 'datefield',		
						fieldLabel : '售房时间',
						name : 'launchTime',
						format : 'Y-m-d'
					},{
						fieldLabel : '均价',
						name : 'averagePrice',
						xtype : 'numberfield',
					},{
						fieldLabel : '最高佣金',
						name : 'highestCommission',
						xtype : 'numberfield',
					},{
						fieldLabel : '保证金',
						name : 'cautionMoney',
						xtype : 'numberfield',
					},{
						fieldLabel : '保护期',
						name : 'duration',
						xtype : 'numberfield',
					},{
						fieldLabel : '视频路径',
						name : 'videoLink'
					},{
						fieldLabel : '规划面积',
						name : 'planAre',
						xtype : 'numberfield',
					},{
						fieldLabel : '建筑面积',
						name : 'constructionArea',
						xtype : 'numberfield',
					},{
						fieldLabel : '容积率',
						name : 'plotRate',
						xtype : 'numberfield',
					},{
						fieldLabel : '绿化率',
						name : 'greeningRate',
						xtype : 'numberfield',
					},{
						fieldLabel : '户数',
						name : 'householdNum',
						xtype : 'numberfield',
					},{
						fieldLabel : '停车位数',
						name : 'parkingspaceNum',
						xtype : 'numberfield'
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
						fieldLabel : '城市',
						id : 'citytest',
						store : Ext.getStore('city'),
						valueField : 'cityId',
						displayField : 'cityName',
						name : 'city',
						typeAhead : true,
						queryMode : 'local',
						 listeners : {
		    					specialKey : function(field, e) {
		    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
		    							me.searchPerson();
		    						}
		    					},
		    					select : function(combo,records,eOpts){
		    						var region = Ext.getCmp('regiontest');
		    						region.clearValue();
		    						region.setValue();
		    						var store = region.getStore();
									store.proxy.url = "region/search"
									store.proxy.extraParams = 
										{cityId:combo.getValue()};
									store.load();
		    					}
		    				}
						
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '区域',
						id : 'regiontest',
						store : Ext.getStore('region'),
						valueField : 'regionId',
						displayField : 'regionName',
						name : 'regionId',
						typeAhead : true,
						queryMode : 'local',
						
					},{
						fieldLabel : '楼盘位置',
						name : 'buildingLocation'
					},{
						fieldLabel : '楼盘地址',
						name : 'buildingAddr'
					},{
						fieldLabel : '售房部地址',
						name : 'saleSiteLocation'
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '建筑类型',
						store : Ext.getStore('constructionKind'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'constructionKind',
						typeAhead : true,
						queryMode : 'local',
						
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '建筑用途',
						store : Ext.getStore('constructionUse'),
						valueField : 'dictCode',
						displayField : 'dictName',
						name : 'constructionUse',
						typeAhead : true,
						queryMode : 'local',
						
					},{
						xtype : 'combobox',
						editable : false,
						fieldLabel : '是否为合作楼盘',
						name : 'isCopartner',
						store : 
							Ext.create('Ext.data.Store', {
							    fields: ['name','code'],
							    data : [{'name': '是','code':true},
									    {'name': '否','code':false}]
							}),
						valueField : 'code',
						displayField : 'name'
					},{
						xtype : 'combobox',
						editable:false,
						fieldLabel : '是否启用',
						name : 'isActivited',
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
						fieldLabel : '购房须知',
						name : 'purchaseNote',
						xtype : 'textarea',
						height : 140
					},]
				}
				]
			} ],
			buttons : [ {
				text : '确定添加',
				width : 80,
				height : 30,
				handler : function() {
					var form = Ext.getCmp('id_addBuildingForm').getForm();
					var values = form.getValues();
					if(form.isValid()){
						form.submit({
						    clientValidation: false,
						    url: 'building/add',
						    success: function(form, action) {
						    	Ext.Msg.alert('Success', action.result.message);

								
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