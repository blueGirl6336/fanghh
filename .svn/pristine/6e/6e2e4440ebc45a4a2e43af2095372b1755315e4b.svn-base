Ext.define('HRMS.module.gzgl.ptgzgl.czjfjlgz.view.IntegralRule',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.integralRulePanel',
			layout : 'fit',
			title : '规则一览',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.building.IntegralRuleStore'),
			initComponent : function() {
				var me = this;
				var store =  this.store;
				store.proxy.api.read = "integralRule/getAll";
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
					dataIndex : 'operationType',
					text : '操作类型',
					renderer : me.operationKindRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : Ext.getStore('integralRuleDictionary'),
						valueField : 'dictCode',
						displayField : 'dictName',
						queryMode: "local",
						forceSelection: true,
						editable : false,
						allowBlank : false,
						value: "0"
					})

				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'integralGained',
					text : '可得积分',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : true,
						allowDecimals : false,
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
						xtype : 'button',
						text : '刷新',
						action : 'searchBtn',
						listeners : {
							click : {
								fn : me.refreshData,
								scope : me
							}
						}
//					},'|',{
//						xtype : 'button',
//						text : '删除规则',
//						listeners : {
//							click : {
//								fn : me.deleteItem,
//								scope : me
//							}
//						}
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
			operationKindRender : function(val) {
				var store = Ext.getStore('integralRuleDictionary');
				var record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
			},
//			searchRule : function() {
//				var brokerValue = this.down('textfield[name=brokerName]').getValue();
//				var consultantValue = this.down('textfield[name=consultantName]').getValue();
//				var store = this.store;
//				store.proxy.api.read = "brokerCommentFromConsultant/search";
//				store.proxy.actionMethods = {
//					read : 'POST'
//				};
//				if ((null !=brokerValue && ''!=brokerValue)|| 
//					(null !=consultantValue && ''!=consultantValue)){
//					store.proxy.extraParams = {
//						brokerName : brokerValue,
//						consultantName : consultantValue
//					};
//					store.load();
//				} else {
////					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
//					this.refreshData();
//				}
//			},
//			deleteItem : function() {
//				
//				var position = this.getSelectionModel().getCurrentPosition();
//				if (position == null) {
//					return;
//				}
//				
//				var me = this;
//				Ext.MessageBox.confirm("确认", "是否确认删除？", function (btn) {
//		            if(btn == 'yes'){
//		            	me.store.removeAt(position.row);
//		            	me.commit();
//		            }
//		        });
//			},
			refreshData : function() {
				var store = this.store;
				store.proxy.api.read = "integralRule/getAll";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				store.proxy.extraParams = {};
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