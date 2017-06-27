Ext.define('HRMS.module.xxgl.xtxx.view.PushNews',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.pushNewsInfoPanel',
			layout : 'fit',
			title : '消息一览',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.building.PushNewsStore'),
			initComponent : function() {
				var me = this;
				var store =  this.store;
				store.proxy.api.read = "pushNews/getAll";
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
					dataIndex : 'broker',
					text : '经纪人',
					renderer : me.brokerRender,
					editable:false
				}, {
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'newsTitle',
					text : '消息标题',
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					width : 150,
					dataIndex : 'newsContent',
					text : '消息详情',
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					width : 150,
					dataIndex : 'sendTime',
					text : '发送时间',
					editable : false,
					renderer : me.dateRender,
				}, {
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'newsType',
					text : '消息类型',
					renderer : me.newsTypeRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : Ext.getStore('pushNewsType'),
						valueField : 'dictCode',
						displayField : 'dictName',
						queryMode: "local",
						forceSelection: true,
						editable : false,
						allowBlank : false,
					})
				}, {
					xtype : 'mycolumn',
					width : 120,
					dataIndex : 'newsStatus',
					text : '消息状态',
					renderer : me.newsStatusRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : Ext.getStore('pushNewsStatus'),
						valueField : 'dictCode',
						displayField : 'dictName',
						queryMode: "local",
						forceSelection: true,
						editable : false,
						allowBlank : false,
					})
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
						fieldLabel : '经纪人姓名',
						minValue : 1,
						hideLabel : false,
						width : 100,
						name : 'brokerName',
						labelWidth : 80,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchNews();
	    						}
	    					}
	    				}
					},{
						xtype : 'textfield',
						fieldLabel : '消息标题',
						hideLabel : false,
						width : 100,
						name : 'newsTitle',
						labelWidth : 60,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchNews();
	    						}
	    					}
	    				}
					},{
						xtype : 'textfield',
						fieldLabel : '消息内容',
						hideLabel : false,
						width : 100,
						name : 'newsContent',
						labelWidth : 60,
						hideLabel : false,
						width : 150,
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchNews();
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchNews,
								scope : me
							}
						}
					},'|' ,{
						xtype : 'button',
						text : '添加消息',
						action: 'addNew',
					},'|' ,{
						xtype : 'button',
						text : '删除消息',
						listeners : {
							click : {
								fn : me.deleteChosenItem,
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
				} ];
				this.plugins = [ this.cellEditing ];
				this.callParent(arguments);
			},
			searchNews : function() {
				var brokerName = this.down('textfield[name=brokerName]').getValue();
				var newsTitle = this.down('textfield[name=newsTitle]').getValue();
				var newsContent = this.down('textfield[name=newsContent]').getValue();
				var store = this.store;
				store.proxy.api.read = "pushNews/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if ((null !=brokerName && ''!=brokerName)|| 
					(null !=newsTitle && ''!=newsTitle)||
					(null !=newsContent && ''!=newsContent)	){
					store.proxy.extraParams = {
							brokerName : brokerName,
							title  :  newsTitle,
							content :  newsContent
					};
					store.load();
				} else {
//					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
					this.refreshData();
				}

			},
			addNewItem : function() {
				
				var rec = new HRMS.model.City({
					throughAudit : true
					
				});

				this.getStore().insert(0, rec);
				this.cellEditing.startEditByPosition({
					row : 0,
					column : 1
				});

			},
			refreshData : function() {
				var brokerName = this.down('textfield[name=brokerName]').getValue();
				var newsTitle = this.down('textfield[name=newsTitle]').getValue();
				var newsContent = this.down('textfield[name=newsContent]').getValue();
				var store = this.store;
				store.proxy.api.read = "pushNews/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				store.proxy.extraParams = {
						brokerName : brokerName,
						title  :  newsTitle,
						content :  newsContent
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
			},
			dateRender : function(val) {
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y-m-d H:m:s');
			},
			
			brokerRender : function(val) {
				return val.brokerId+" | "+val.brokerName;
			},
			
			//dictionary query
			newsTypeRender : function(val) {
				store  = Ext.getStore('pushNewsType');
				record = store.findRecord('dictCode', val);
				if(record == null)
					return val;
				name  = record.data.dictName;
				return name;
			},			
			newsStatusRender : function(val) {
				store  = Ext.getStore('pushNewsStatus');
				record = store.findRecord('dictCode', val);
				if(record == null)
					return val;
				name  = record.data.dictName;
				return name;
			}

		});