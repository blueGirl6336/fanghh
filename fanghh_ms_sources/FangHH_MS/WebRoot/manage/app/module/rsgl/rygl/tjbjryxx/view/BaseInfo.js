Ext.define('HRMS.module.rsgl.rygl.tjbjryxx.view.BaseInfo',
		{
			extend : 'Ext.grid.Panel',
			alias : 'widget.baseInfoPanel',
			layout : 'fit',
			requires : [ 'HRMS.store.dictionary.SubUnitStore'],
			title : '选择员工',
			border : 0,
			frame : true,
			closable : false,
			enableColumnHide : false,
			enableColumnMove : false,
			enableLocking : false,
			store : Ext.create(
					'HRMS.store.personnel.PersonBaseInfoStore', {
						id : 'store-HRMS.module.rsgl.rygl.tjbjryxx'
					}),
			initComponent : function() {
				var me = this;

				this.cellEditing = new Ext.grid.plugin.CellEditing({
					clicksToEdit : 2
				});

				me.columns = [ {
					xtype : 'rownumberer',
					width : 30,
					text : '序号'
				}, {
					xtype : 'mycolumn',
					width : 80,
					dataIndex : 'empNo',
					text : '工号'
				}, {
					xtype : 'mycolumn',
					width : 70,
					dataIndex : 'name',
					text : '姓名',
					editor : {
						xtype : 'textfield',
						allowBlank : false
					}
				}, {
					xtype : 'mycolumn',
					width : 40,
					align : 'center',
					dataIndex : 'sex',
					text : '性别',
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
//						width : 40,
						triggerAction : 'all',
						store : Ext.create('Ext.data.Store', {
							fields : [ 'text' ],
							data : [ {
								"text" : "女"
							}, {
								"text" : "男"
							} ]
						}),
						valueField : 'text',
						displayField : 'text',
						editable : false,
						allowBlank : false
					})
				}, {
					xtype : 'mycolumn',
					width : 50,
					align : 'center',
					dataIndex : 'ethnic',
					text : '民族',
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					width : 90,
					align : 'center',
					dataIndex : 'dob',
					text : '出生日期',
					renderer : me.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m/d'
					}
				}, {
					xtype : 'mycolumn',
					width : 160,
					hidden : false,
					dataIndex : 'idCard',
					text : '身份证号',
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					editable:false,
					width : 190,
					align : 'center',
					dataIndex : 'department',
					text : '所属部门',
					renderer : me.departmentTypeRender/*,
					editor : new Ext.form.field.ComboBox({//
						id:'department_id',
						typeAhead : true,
						triggerAction : 'all',
						store : 'department',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false,
						listeners : {
							select:function(){
								var depart=Ext.getCmp('department_id');
								var code=depart.getValue();
								var sub=Ext.getCmp('subunit_id');
								var store = sub.store;
//								store = Ext.create('HRMS.store.dictionary.SubUnitStore');
								store.proxy.extraParams = {
									department : code
								};
								store.load();
								sub.store = store;
								sub.setValue('');
							}
						}
					})*/
				}, {
					xtype : 'mycolumn',
					editable:false,
					width : 140,
					align : 'center',
					dataIndex : 'sub_unit',
					text : '二级单位',
					renderer : me.subUnitTypeRender /*,//code 转换 name
					editor : new Ext.form.field.ComboBox({//
						id:'subunit_id',
						typeAhead : true,
						triggerAction : 'all',
						store : 'subunit',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false,
						listeners : {
							expand: function() {
								var depart=Ext.getCmp('department_id');
								var code=depart.getValue();
								var sub=Ext.getCmp('subunit_id');
								var store = sub.store;
								//store = Ext.create('HRMS.store.dictionary.SubUnitStore');
								store.proxy.extraParams = {
									department : code
								};
								store.load();
								sub.store = store;
								sub.setValue('');
	    					}
						}
					})*/
				}, {
					xtype : 'mycolumn',
					width : 180,
					align : 'center',
					dataIndex : 'jobType',
					text : '岗位类型',
					renderer : me.jobTypeRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'jobType',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false
					})
				},{
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'hometown',
					text : '籍贯',
					hidden:true,
					editor : {
						xtype : 'textfield'
					}
				},{
					xtype : 'mycolumn',
					width : 100,
					align : 'center',
					dataIndex : 'birthPlace',
					text : '出生地',
					hidden:true,
					editor : {
						xtype : 'textfield'
					}
				}, {
					xtype : 'mycolumn',
					width : 110,
					align : 'center',
					dataIndex : 'teacher_type',
					text : '教师类型',
					renderer : me.teacherTypeRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 'teacherType',
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false
					})
				}, {
					xtype : 'mycolumn',
					width : 90,
					align : 'center',
					dataIndex : 'dateOfStartWork',
					text : '参加工作日期',
					renderer : me.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m/d'
					}
				}, {
					xtype : 'mycolumn',
					width : 90,
					align : 'center',
					dataIndex : 'dateOfEntry',
					text : '本校入职日期',
					renderer : me.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m/d'
					}
				},{
					xtype : 'mycolumn',
					width : 60,
					align : 'center',
					dataIndex : 'doubleEmp',
					text : '双基地',
					renderer : me.doubleEmpRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 
							Ext.create('Ext.data.Store', {
							    fields: ['name','code'],
							    data : [{'name': '是','code':true},
									    {'name': '否','code':false}]
							}),
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false
					})
				},{
					xtype : 'mycolumn',
					width : 80,
					align : 'center',
					dataIndex : 'retirement',
					text : '退休',
					hidden:true ,
					renderer : me.retirementRender,
					editor : new Ext.form.field.ComboBox({
						typeAhead : true,
						triggerAction : 'all',
						store : 
							Ext.create('Ext.data.Store', {
							    fields: ['name','code'],
							    data : [{'name': '是','code':true},
									    {'name': '否','code':false}]
							}),
						valueField : 'code',
						displayField : 'name',
						editable : false,
						allowBlank : false
					})
				},{
					xtype : 'mycolumn',
					width : 90,
					align : 'center',
					dataIndex : 'retirementDate',
					text : '退休日期',
					hidden:true,
					renderer : me.dateRender,
					editor : {
						xtype : 'datefield',
						format : 'Y/m/d'
					}
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
						name : 'department',
						autoSelect : true,
						fieldLabel : '部门',
						emptyText : '部门',
						width : 230,
						queryMode : 'local',
						store : Ext.getStore('department'),
						valueField : 'dictCode',
						displayField : 'dictName',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					}
	    				}
					}, {
						xtype : 'textfield',
						fieldLabel : '工号',
						name : 'empNo',
						width : 130,
						hideLabel : false,
						emptyText : '工号(优先查询)',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					}
	    				}
					}, {
						xtype : 'textfield',
						fieldLabel : '姓名',
						hideLabel : false,
						width : 100,
						name : 'name',
						emptyText : '姓名',
	                    listeners : {
	    					specialKey : function(field, e) {
	    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
	    							me.searchPerson();
	    						}
	    					}
	    				}
					}, {
						xtype : 'button',
						text : '查询',
						listeners : {
							click : {
								fn : me.searchPerson,
								scope : me
							}
						}
					},'|' , 
					{
						xtype : 'button',
						text : '添加新员工',
						action: 'addNew'
					},{
						xtype : 'button',
						text : '上传头像',
						action: 'uploadImage'
					}, {
						xtype : 'button',
						text : '修改工号',
						action: 'editEmpNo'
					},'|' ,{
						xtype : 'button',
						text : '确认修改',
						listeners : {
							click : {
								fn : me.submitUpdate,
								scope : me
							}
						}
					}
//					, '|', {
//						xtype : 'button',
//						text : '添加为系统用户',
//						listeners : {
//							click : {
//								fn : me.addToUser,
//								scope : me
//							}
//						}
//					}
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
			searchPerson : function() {
				var empNoValue = this.down('textfield[name=empNo]').getValue();
				var nameValue = this.down('textfield[name=name]').getValue();
				var departmentValue = this.down('combobox[name=department]')
						.getValue();
				var store = this.store;
				store.proxy.api.read = "baseinfo/search";
				store.proxy.actionMethods = {
					read : 'POST'
				};
				if ((empNoValue != null && empNoValue != '')
						|| (nameValue != null && nameValue != '')
						|| (departmentValue != null && departmentValue != '')) {
					store.proxy.extraParams = {
						quota : 1,
						empNo : empNoValue,
						name : nameValue,
						department : departmentValue,
						doe : null
					};
					store.load();
				} else {
					Ext.Msg.alert('操作错误', '请至少输入一个查询条件！');
				}

			},
			submitUpdate : function() {
				this.getStore().sync();
			},
			departmentTypeRender : function(val) {
				store = Ext.getStore('department');
				record = store.findRecord('code', val);
				if (record == null)
					return val;
				name = record.data.name;
				return name;
			},
			doubleEmpRender: function(val) {
				if (val)
					return '是';
				else
					return '否';
			},
			retirementRender: function(val){

				if (val)
					return '是';
				else
					return '否';
			},
			subUnitTypeRender : function(val) {
				store = Ext.getStore('allsubunit'); //allsubunit
				record = store.findRecord('code', val);
				if (record == null)
					return val;
				name = record.data.name;
				return name;
			},
			jobTypeRender : function(val) {
				store = Ext.getStore('jobType');
				record = store.findRecord('code', val);
				if (record == null)
					return val;
				name = record.data.name;
				return name;
			},
			teacherTypeRender : function(val) {
				store = Ext.getStore('teacherType');
				record = store.findRecord('code', val);
				if (record == null)
					return val;
				name = record.data.name;
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