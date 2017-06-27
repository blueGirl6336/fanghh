Ext.define('HRMS.module.gzgl.ptgzgl.djyjfgz.view.IntegralLevel',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.integralLevelPanel',
			layout : 'fit',
			title : '规则一览',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.building.IntegralLevelStore'),
			initComponent : function() {
				var me = this;
				var store =  this.store;
				store.proxy.api.read = "integralLevel/getAll";
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
					dataIndex : 'userLevel',
					text : '用户等级',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : false
					})	
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'lowestStandard',
					text : '最低积分',
					editor : new Ext.form.NumberField({
						allowBlank : true,
						allowNegative : true,
						allowDecimals : false,
					})	
				},{
					xtype : 'mycolumn',
					editable : false,
					align : 'center',
					dataIndex : 'highestStandard',
					text : '最高积分',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
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
						listeners : {
							click : {
								fn : me.refreshData,
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
					},'|',{
						xtype : 'button',
						text : '删除规则',
						listeners : {
							click : {
								fn : me.deleteItem,
								scope : me
							}
						}
					},'|' ,{
						xtype : 'button',
						text : '添加规则',
						action : 'addNewRule'
					}]
				}];
				this.plugins = [ this.cellEditing ];
				this.callParent(arguments);
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
				var store = this.store;
				store.proxy.api.read = "integralLevel/getAll";
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