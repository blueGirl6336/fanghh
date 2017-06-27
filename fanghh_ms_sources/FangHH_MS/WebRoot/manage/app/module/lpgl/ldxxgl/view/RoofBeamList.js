Ext.define('HRMS.module.lpgl.ldxxgl.view.RoofBeamList',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.tansferpersonlist',
			layout : 'fit',
			title : '选择楼栋基本信息',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			//forceFit : true,
			store : Ext.create(
					'HRMS.store.building.RoofBeamStore'),
			initComponent : function() {
				var me = this;
				var boolStore = Ext.create("Ext.data.Store", {
				    fields: ["Name", "Value"],
				    data: [
				        { Name: "是", Value: 1 },
				        { Name: "否", Value: 0 }
				    ]
				});
				this.cellEditing = new Ext.grid.plugin.CellEditing({
					clicksToEdit : 2
				});

				me.columns = [ {
					xtype : 'rownumberer',
					wdith : 120,
					text : '序号'
				}, {
					xtype : 'mycolumn',
					hidden:true,
					dataIndex : 'roofId',
					text : '楼栋ID'
				}, {
					xtype : 'mycolumn',
					dataIndex : 'roofName',
					text : '楼栋名称',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'propertyType',
					text : '物业类型',
					renderer: me.propertyTypeRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'propertyType',
						valueField : 'dictCode',
						displayField : 'dictName',
						editable : false,
						allowBlank : false
					})
				}, {
					xtype : 'mycolumn',
					dataIndex : 'roofStructer',
					text : '楼栋结构',
					renderer: me.roofStructerRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'roofStructer',
						valueField : 'dictCode',
						displayField : 'dictName',
						editable : false,
						allowBlank : false
					})
				}, {
					xtype : 'mycolumn',
					dataIndex : 'roofHeight',
					text : '楼层总数',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					dataIndex : 'roofFace',
					text : '朝向',
					renderer: me.roofFaceRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'face',
						valueField : 'dictCode',
						displayField : 'dictName',
						editable : false,
						allowBlank : false
					})
				}, {
					xtype : 'mycolumn',
					editable:false,
					align : 'center',
					dataIndex : 'airFloors',
					text : '最高层',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true,
						minValue : 0
					})	
				
				}, {
					xtype : 'mycolumn',
					editable:false,
					align : 'center',
					dataIndex : 'earthFloors',
					text : '最低层',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true,
						minValue : 0
					})	
				
				}, {
					xtype : 'mycolumn',
					editable:false,
					align : 'center',
					dataIndex : 'roofNum',
					text : '楼栋总户数',
					editor : new Ext.form.NumberField({
						allowBlank : false,
						allowNegative : false,
						allowDecimals : true,
						minValue : 0
					})					
				}];
				me.dockedItems = [ {
					xtype : 'toolbar',
					dock : 'top',
					defaults:{
						labelWidth:30,
						padding:'0 4 1 4'
					},
					items : [ {
						xtype : 'combobox',
						name : 'city',
						id :'city',
						autoSelect : true,
						fieldLabel : '城市',
						width : 150,
						queryMode : 'local',
						store : Ext.getStore('city'),
						valueField : 'cityId',
						displayField : 'cityName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					},
	    					select : function(combo,records,eOpts){
	    						var region = Ext.getCmp('region');
	    						var building = Ext.getCmp('building');
	    						region.clearValue();
	    						building.clearValue();
	    						region.setValue();
	    						building.setValue();
	    						var regionStore = region.getStore();
	    						var buildingStore = building.getStore();
								regionStore.proxy.url = "region/search";
								regionStore.proxy.extraParams = 
									{cityId:combo.getValue()};
								regionStore.load();
								buildingStore.proxy.url = "building/search";
								buildingStore.proxy.extraParams = 
									{
										city : combo.getValue(),
										region : region.getValue(),
										buildingName : building.getValue()
									};
								buildingStore.proxy.actionMethods = 'POST';
								buildingStore.load();
	    					}
	    				},
	    				allowBlank : true
					}, {
						xtype : 'combobox',
						name : 'region',
						id : 'region',
						autoSelect : true,
						fieldLabel : '区域',
						width : 150,
						queryMode : 'local',
						store : Ext.getStore('region'),
						valueField : 'regionId',
						displayField : 'regionName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					},
					
					select : function(combo,records,eOpts){
						var building = Ext.getCmp('building');
						building.clearValue();
						building.setValue();
						var store = building.getStore();
						store.filterBy(function(records){
							return records.get('region').regionId== combo.getValue();
						});
						
					}
	    					
	    				}
					}, {
						xtype : 'combobox',
						fieldLabel : '楼盘名称',
						labelWidth : 60,
						autoSelect : true,
						width : 160,
						name : 'building',
						id : 'building',
						queryModel : 'local',
						store : Ext.create(
						'HRMS.store.building.BuildingStore'),
						valueField : 'buildingId',
						displayField : 'buildingName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchBuilding();
	    						}
	    					}
					
					
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchBuilding,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新楼栋',
						action: 'addNew'
					},{
						xtype : 'button',
						text : '确认修改',
						listeners : {
							click : {
								fn : me.submitUpdate,
								scope : me
							}
						}
					}
					]
				} ];
				this.plugins = [ this.cellEditing ];
				this.callParent(arguments);
			},
			dateRender : function(val) {
				if (val == null || val == '')
					return '';
				if (val == '至今')
					return val;
				else
					return Ext.util.Format.date(val, 'Y/m/d');
			},
			propertyTypeRender : function(val) {
				if (val == 0)
					return '';
				store = Ext.getStore('propertyType');
				record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
			},
			roofStructerRender : function(val) {
				if (val == 0)
					return '';
				store = Ext.getStore('roofStructer');
				record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
			},
			roofFaceRender : function(val) {
				if (val == 0)
					return '';
				store = Ext.getStore('face');
				record = store.findRecord('dictCode', val);
				if (record == null)
					return val;
				name = record.data.dictName;
				return name;
			},
			searchBuilding : function() {
				//var regionValue = this.down('textfield[name=region]').getValue();
				//var buildingNameValue = this.down('textfield[name=buildingName]').getValue();
				//var cityValue = this.down('textfield[name=city]').getValue();
				var buildingId = Ext.getCmp('building').getValue();
				var store = this.store;
				store.proxy.api.read = "roofBeam/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if (buildingId != null && buildingId != '') {
					store.proxy.extraParams = {
						buildingId : buildingId
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
				}

			},
			submitUpdate : function() {
				this.store.sync({
					'success' : function(a, b) {
						Ext.MessageBox.show({
							title : '操作成功',
							msg : a.proxy.reader.rawData.message,
							icon : Ext.MessageBox.OK,
							buttons : Ext.Msg.OK
						});
						this.load();
					}
				});
			},
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