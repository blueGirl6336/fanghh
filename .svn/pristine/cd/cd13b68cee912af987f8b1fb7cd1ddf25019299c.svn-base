Ext.define('HRMS.module.lpgl.kfsgl.view.DeveloperInfo',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.developerInfoPanel',
			layout : 'fit',
			title : '选择开发商信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.DeveloperStore'),
			initComponent : function() {
				var me = this;
				me.columns = [ {
					xtype : 'rownumberer',
					width : 40,
					text:'序号'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'developName',
					text : '开发商名称',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'developAddr',
					text : '开发商地址',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'businessLicense',
					text : '营业执照',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				}, {
					xtype : 'mycolumn',
					dataIndex : 'qualLevel',
					text : '资质等级',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'legalPerson',
					text : '法人',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'personPosition',
					text : '法人职务',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				}, {
					xtype : 'mycolumn',
					dataIndex : 'brokerIdcard',
					text : '身份证号',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'relationPhone',
					text : '联系电话',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				
				}, {
					xtype : 'mycolumn',
					dataIndex : 'zipCode',
					text : '邮编',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				},{
					xtype : 'mycolumn',
					dataIndex : 'email',
					text : 'email',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
					
				},{
					xtype : 'mycolumn',
					dataIndex : 'remark',
					text : '备注',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}];
				me.dockedItems = [ {
					xtype : 'toolbar',
					dock : 'top',
					defaults:{
						labelWidth:80,
						padding:'0 4 1 4'
					},
					items : [   {
						xtype : 'textfield',
						fieldLabel : '开发商地址',
						labelWidth : 75,
						hideLabel : false,
						width : 195,
						name : 'developAddr',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    						}
	    					}
	    				}
					},{
						xtype : 'textfield',
						fieldLabel : '开发商名称',
						labelWidth : 75,
						hideLabel : false,
						width : 195,
						name : 'developName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchDeveloper ,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新开发商',
						action: 'addNew'
					},'|' , {
						xtype : 'button',
						text : '修改开发商',
						action:'editEmpNo'
					},'|' , {
						xtype : 'button',
						text : '删除开发商',
						listeners : {
							click : {
								fn : me.deleteChosenItem,
								scope : me
							}
						}
					}
					]
				} ];
				this.callParent(arguments);
			},
			searchDeveloper : function() {
				var developAddrValue = this.down('textfield[name=developAddr]').getValue();
				var developNameValue = this.down('textfield[name=developName]').getValue();
				var store = this.store;
				store.proxy.api.read = "developer/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if ((developAddrValue != null && developAddrValue != '')
						|| (developNameValue != null && developNameValue != '')
						) {
					store.proxy.extraParams = {
							developAddr : developAddrValue,
							developName : developNameValue,
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
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
			},
			
			///////////////////////////////////////////////
			boolRender: function(val){

				if(val)return '是';
				else return '否';
			},
			constructionKindRender : function(val) {
				store = Ext.getStore('constructionKind'); 
				record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
			},
			constructionUseRender : function(val) {
				store  = Ext.getStore('constructionUse');
				record = store.findRecord('dictCode', val);
				if(record == null)
					return val;
				name  = record.data.dictName;
				return name;
			},
			addToUser : function() {
				var record = this.getSelectionModel().getSelection()[0];
				if (record == null) {
					Ext.Msg.alert('操作错误', '请选择要添加的用户！');
					return;
				}
				var empNo = record.data.empNo;
				Ext.Ajax.request({
					url : 'baseinfo/addToSystemUser',
					method : 'GET',
					params : {
						empNo : empNo
					},
					success : function(response) {
						var obj=Ext.decode(response.responseText);  
		                if(obj.success == true) {//如果你处理的JSON串中true不是字符串，就obj.success == true
		                	Ext.Msg.alert('成功消息', obj.message);
		                } else {
		                	Ext.Msg.alert('失败消息', obj.message);
		                }
					}
				});

			}
		});