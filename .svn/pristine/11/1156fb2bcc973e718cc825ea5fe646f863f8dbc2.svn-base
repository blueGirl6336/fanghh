Ext.define('HRMS.module.jfgl.yhjfjl.view.IntegralRecord',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.integralRecordPanel',
			layout : 'fit',
			title : '记录一览',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.building.IntegralRecordStore'),
			initComponent : function() {
				var me = this;
				var store =  this.store;
				store.proxy.api.read = "integralRecord/getAll";
				store.proxy.actionMethods = {
						read : 'POST'
					};
				store.proxy.extraParams = {
				};
				store.load();
				this.cellEditing = new Ext.grid.plugin.CellEditing({
					clicksToEdit : 2
				});

				me.columns = [ {
					xtype : 'rownumberer',
					width : 40,
					align : 'center',
					text : '序号'
				}, {
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'user',
					text : '用户',
					renderer : me.userRender
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'integralNum',
					text : '积分',
//					editor : {
//						xtype : 'textfield'
//					},
				},{
					xtype : 'mycolumn',
					width : 150,
					dataIndex : 'time',
					text : '获取时间',
					renderer : me.dateRender,
				},{
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'operation',
					text : '操作类型',
					renderer: me.operationKindRender,
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
						fieldLabel : '用户名称',
						hideLabel : false,
						width : 100,
						name : 'userName',
						labelWidth : 60,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchUser();
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						action : 'refreshTabBtn',
						listeners : {
							click : {
								fn : me.searchUser,
								scope : me
							}
						}
					},'|' , 
//					{
//						xtype : 'button',
//						text : '添加城市',
//						listeners : {
//							click : {
//								fn : me.addNewItem,
//								scope : me
//							}
//						}
//					},
					{
						xtype : 'button',
						text : '删除记录',
						listeners : {
							click : {
								fn : me.deleteChosenItem,
								scope : me
							}
						}
					}
//					{
//						xtype : 'button',
//						text : '确认修改',
//						listeners : {
//							click : {
//								fn : me.submitUpdate,
//								scope : me
//							}
//						}
//					}
					]
				} ];
				this.plugins = [ this.cellEditing ];
				this.callParent(arguments);
			},
			searchUser : function() {
				var userValue = this.down('textfield[name=userName]').getValue();
				var store = this.store;
				store.proxy.api.read = "integralRecord/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if (userValue != null && userValue != '') {
					store.proxy.extraParams = {
						userName : userValue,
					};
					store.load();
				} else {
//					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
					this.refreshData();
				}

			},
			refreshData : function() {
				var store = this.getStore();
				store.proxy.api.read = "integralRecord/getAll";
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
			operationKindRender : function(val) {
				var store = Ext.getStore('operationKind');
				var record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
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
			dateRender : function(val) {
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y-m-d H:m:s');
			},
			userRender : function(val) {
				return val.id+' | '+val.username;
//				return val.username;
			}
		});