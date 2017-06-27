Ext.define('HRMS.module.pjgl.lppjgl.view.BuildingComment',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.buildingCommentPanel',
			layout : 'fit',
			title : '评价一览',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.building.BuildingCommentStore'),
			initComponent : function() {
				var me = this;
				Ext.define("CheckModel", {
	                extend: "Ext.data.Model",
	                fields: [
	                    { name: "id" },
	                    { name: "status" }
	                ]
	            });
				Ext.define("BooleanModel", {
	                extend: "Ext.data.Model",
	                fields: [
	                    { name: "value" },
	                    { name: "display" }
	                ]
	            });
				var checkStore = Ext.create("Ext.data.Store", {
	                model: "CheckModel",
	                data: [
	                       { "id": 1, "status": "<span style='color:green;'>审核通过</span>"},
	                       { "id": -1, "status": "<span style='color:red;'>审核未通过</span>"},
	                       { "id": 0, "status": "待审核"}
	                      ]
				});
				var booleanStore = Ext.create("Ext.data.Store", {
	                model: "BooleanModel",
	                data: [
	                       { "value": true, "display": "<span style='color:green;'>是</span>"},
	                       { "value": false, "display": "否"}
	                      ]
				});
				var store =  this.store;
				store.proxy.api.read = "buildingComment/getAll";
				store.proxy.actionMethods = {
						read : 'POST'
					};
				store.proxy.extraParams = {
				};
				store.load();
				this.cellEditing = new Ext.grid.plugin.CellEditing({
					clicksToEdit : 0
				});

				me.columns = [ {
					xtype : 'rownumberer',
					width : 40,
					align : 'center',
					text : '序号'
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'user',
					text : '用户',
					renderer : me.userRender,
//					editor : {
//						xtype : 'textfield'
//					}
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'building',
					text : '楼盘',
					renderer : me.buildingRender,
//					editor : {
//						xtype : 'textfield'
//					}
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'homeConsultant',
					text : '置业顾问',
					renderer : me.consultantRender,
//					editor : {
//						xtype : 'textfield'
//					}
				},{
					xtype : 'mycolumn',
					width : 150,
					dataIndex : 'commentTime',
					text : '评论时间',
					renderer : me.dateRender,
//					editor : {
//						xtype : 'datefield',
//						format : 'Y-m-d'
//					}
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'commentWriting',
					text : '评论内容',
//					editor : {
//						xtype : 'textfield'
//					}
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'commentCheckStatus',
					renderer : me.checkRender,
					text : '评论审核状态',
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : checkStore,
						valueField : 'id',
						displayField : 'status',
						queryMode: "local",
						forceSelection: true,
						editable : false,
						allowBlank : false,
						value: "0"
					})
				},{
					xtype : 'mycolumn',
					width : 150,
					dataIndex : 'replyTime',
					text : '回复时间',
					renderer : me.dateRender,
//					editor : {
//						xtype : 'datefield',
//						format : 'Y-m-d'
//					}
				}, {
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'replyContent',
					text : '回复内容',
//					editor : {
//						xtype : 'textfield'
//					}
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'replyCheckStatus',
					renderer : me.checkRender,
					text : '回复审核状态',
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : checkStore,
						valueField : 'id',
						displayField : 'status',
						queryMode: "local",
						forceSelection: true,
						editable : false,
						allowBlank : false,
						value: "0"
					})
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'isEssence',
					renderer : me.boolRender,
					text : '是否精华',
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : booleanStore,
						valueField : 'value',
						displayField : 'display',
						queryMode: "local",
						forceSelection: true,
						editable : false,
						allowBlank : false
					})
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'entireComment',
					text : '整体评价',
//					editor : new Ext.form.NumberField({
//						allowBlank : false,
//						allowNegative : false,
//						allowDecimals : true,
//						minValue : 0
//					})	
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'priceComment',
					text : '价格评价',
//					editor : new Ext.form.NumberField({
//						allowBlank : false,
//						allowNegative : false,
//						allowDecimals : true,
//						minValue : 0
//					})	
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'locationComment',
					text : '地域评价',
//					editor : new Ext.form.NumberField({
//						allowBlank : false,
//						allowNegative : false,
//						allowDecimals : true,
//						minValue : 0
//					})	
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'facilitiesComment',
					text : '设施评价',
//					editor : new Ext.form.NumberField({
//						allowBlank : false,
//						allowNegative : false,
//						allowDecimals : true,
//						minValue : 0
//					})	
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'trafficComment',
					text : '交通评价',
//					editor : new Ext.form.NumberField({
//						allowBlank : false,
//						allowNegative : false,
//						allowDecimals : true,
//						minValue : 0
//					})	
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'environmentComment',
					text : '环境评价',
//					editor : new Ext.form.NumberField({
//						allowBlank : false,
//						allowNegative : false,
//						allowDecimals : true,
//						minValue : 0
//					})	
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
						fieldLabel : '用户名',
						minValue : 1,
						hideLabel : false,
						width : 100,
						name : 'userName',
						labelWidth : 60,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchComment();
	    						}
	    					}
	    				}
					},{
						xtype : 'textfield',
						fieldLabel : '楼盘名',
						minValue : 1,
						hideLabel : false,
						width : 100,
						name : 'buildingName',
						labelWidth : 60,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchComment();
	    						}
	    					}
	    				}
					},{
						xtype : 'textfield',
						fieldLabel : '置业顾问姓名',
						minValue : 1,
						hideLabel : false,
						width : 120,
						name : 'consultantName',
						labelWidth : 100,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchComment();
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						action : 'searchBtn',
						listeners : {
							click : {
								fn : me.searchComment,
								scope : me
							}
						}
					},'|',{
						xtype : 'button',
						text : '删除评论',
						listeners : {
							click : {
								fn : me.deleteItem,
								scope : me
							}
						}
					},'|' ,{
						xtype : 'button',
						text : '保存修改',
						listeners : {
							click : {
								fn : me.commit,
								scope : me
							}
						}
					}]
				}];
				this.plugins = [ this.cellEditing ];
				this.callParent(arguments);
			},
			checkRender: function(val){
				if("1"==val)return "<span style='color:green;'>审核通过</span>";
				if("-1"==val)return "<span style='color:red;'>审核未通过</span>";
				if("0"==val)return "待审核";
				else return "<span style='color:red;'>异常</span>";
			},
			dateRender : function(val) {
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y-m-d H:m:s');
			},
			boolRender: function(val){
				if(val)return "<span style='color:green;'>是</span>";
				else return "否";
			},
			buildingRender : function(val) {
				return val.buildingName;
			},
			userRender : function(val) {
				return val.id+' | '+val.username;
			},
			consultantRender : function(val) {
				return val.consultantId+' | '+val.consultantName;
			},
			searchComment : function() {
				var userValue = this.down('textfield[name=userName]').getValue();
				var consultantValue = this.down('textfield[name=consultantName]').getValue();
				var buildingValue = this.down('textfield[name=buildingName]').getValue();
				var store = this.store;
				store.proxy.api.read = "buildingComment/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if ((null !=userValue && '' != userValue)|| 
					(null !=consultantValue && '' != consultantValue)||
					(null !=buildingValue && '' != buildingValue)) {
					store.proxy.extraParams = {
							userName : userValue,
							consultantName : consultantValue,
							buildingName : buildingValue
					};
					store.load();
				} else {
//					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
					this.refreshData();
				}
			},
			deleteItem : function() {
				
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
			refreshData : function() {
				var userValue = this.down('textfield[name=userName]').getValue();
				var consultantValue = this.down('textfield[name=consultantName]').getValue();
				var buildingValue = this.down('textfield[name=buildingName]').getValue();
				var store = this.store;
				store.proxy.api.read = "buildingComment/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				store.proxy.extraParams = {
						userName : userValue,
						consultantName : consultantValue,
						buildingName : buildingValue
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
			}
		});