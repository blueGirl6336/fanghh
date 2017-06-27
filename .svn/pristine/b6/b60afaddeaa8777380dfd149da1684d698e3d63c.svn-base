Ext.define('HRMS.module.xtgl.xtglsz.yhgl.view.yhgl', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '用户管理',
	border : 0,
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	store : Ext.create('HRMS.store.UserStore'),
	initComponent : function() {
		var me = this;
		this.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			hidden : true,
			dataIndex : 'id'
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'username',
			text : '用户名'
		// editor : {
		// xtype : 'textfield',
		// allowBlank: false
		// }
		}, {
			xtype : 'mycolumn',
			width : 200,
			dataIndex : 'password',
			hidden : true,
			text : '密码',
			editor : {
				xtype : 'textfield',
				vtype:'alphanum'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'realName',
			text : '真实姓名',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'empNo',
			text : '工号',
			editor : {
				xtype : 'textfield',
				vtype:'alphanum'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'idNumber',
			text : '身份证号码',
			editor : {
				xtype : 'textfield',
				vtype:'alphanum'
			}
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'department',
			text : '部门',
			renderer : me.departmentClassRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				editable : false,
				store : 'departmentClass',
				valueField : 'code',
				displayField : 'name',
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'role',
			text : '角色',
			renderer : me.roleTypeRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : 'roles',
				valueField : 'code',
				displayField : 'name',
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'status',
			text : '用户状态',
			renderer : me.statusRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : Ext.create('Ext.data.Store', {
					fields : [ 'code', 'name' ],
					data : [ {
						"code" : 0,
						"name" : "停用"
					}, {
						"code" : 1,
						"name" : "启用"
					} ]
				}),
				valueField : 'code',
				displayField : 'name',
				allowBlank : false
			})
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'startTime',
			text : '启用时间',
			renderer : me.dateRender,
			editor : {
				xtype : 'datefield',
				format : 'Y/m/d'
			}
		} ];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			defaults:{
				padding:'0 4 1 4'
			},
			items : [
//			         {
//				xtype : 'button',
//				text : '添加新用户',
//				listeners : {
//					click : {
//						fn : me.addNewItem,
//						scope : me
//					}
//				}
//			},
			{
				xtype : 'button',
				text : '删除用户',
				listeners : {
					click : {
						fn : me.deleteChosenItem,
						scope : me
					}
				}

			}, {
				xtype : 'button',
				text : '刷新',
				listeners : {
					click : {
						fn : me.refreshData,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '保存修改',
				listeners : {
					click : {
						fn : me.commit,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '修改密码',
				listeners : {
					click : {
						fn : me.editPassword,
						scope : me
					}
				}

			}, {
				xtype : 'textfield',
				fieldLabel : '真实姓名',
				hideLabel : false,
				labelWidth : 60,
				name : 'realname',
				emptyText : '真实姓名',
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
				listeners : {
					click : {
						fn : me.searchUser,
						scope : me
					}
				}
			} ]
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
	refreshData : function() {
		var store = this.getStore();
		store.load();
	},
	departmentClassRender : function(val) {
		if (val == 0)
			return '';
		crstore = Ext.getStore('departmentClass');
		record = crstore.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	roleTypeRender : function(val) {
		if (val == 0)
			return '';
		crstore = Ext.getStore('roles');
		record = crstore.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	statusRender : function(val) {
		if (val > 0) {
			return '<span style="color: green;">启用</span>';
		} else
			return '<span style="color: red;">停用</span>';
	},
	addNewItem : function() {
//		var rec = new HRMS.model.User({
//			department : 0,
//			role : 0,
//			status : 1
//		});
//
//		this.getStore().insert(0, rec);
//		this.cellEditing.startEditByPosition({
//			row : 0,
//			column : 1
//		});
		// 换成弹出窗口添加人员
		var store = this.getStore();
		//正则表达式，匹配数字
		var re=new RegExp('\\d+');
		var searchWin = Ext.create('Ext.window.Window', {
			// window标题
			title : '添加新用户',
			// window的id，根据ID可以取得窗口对象
			id : 'searchWin',
			width : 400,
			height : 400,
			bodyPadding : 20,
			//设置组件默认属性
			defaults:{
				width:300
			},
			// window包含的元素
			items : [ {
				xtype : 'textfield',
				fieldLabel : '用户名',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '密码',
				vtype:'alphanum',
				allowBlank : false
			}, {
				xtype : 'textfield',
				fieldLabel : '真实姓名'
			}, {
				xtype : 'textfield',
				fieldLabel : '工号',
				vtype:'alphanum'
			}, {
				xtype : 'textfield',
				fieldLabel : '身份证号',
				vtype:'alphanum'
			}, {
				xtype : 'combobox',
				fieldLabel : '部门',
				typeAhead : true,
				triggerAction : 'all',
				store : 'departmentClass',
				editable : false,
				valueField : 'code',
				displayField : 'name'
				//下拉列表宽度
//				matchFieldWidth:false,
//				listConfig:{
//					width:200
//				}
			}, {
				xtype : 'combobox',
				fieldLabel : '角色',
				editable : false,
				typeAhead : true,
				triggerAction : 'all',
				store : 'roles',
				valueField : 'code',
				displayField : 'name',
				allowBlank : false
				//下拉列表宽度
//				matchFieldWidth:false,
//				listConfig:{
//					width:200
//				}
			}, {
				xtype : 'combobox',
				fieldLabel : '状态',
				editable : false,
                typeAhead : true,
				triggerAction : 'all',
				store : Ext.create('Ext.data.Store', {
					fields : [ 'code', 'name' ],
					data : [ {
						"code" : 0,
						"name" : "停用"
					}, {
						"code" : 1,
						"name" : "启用"
					}]
				}),
				valueField : 'code',
				displayField : 'name',
				allowBlank : false
	                
			}, {
				xtype : 'datefield',
				fieldLabel : '启用时间',
				editable:false,
				format : 'Y/m/d'
			} ],
			buttons : [ {
				text : '添加用户',
				width : 80,
				height : 30,
				handler : function() {

					var array=new Array();
					var user={};
					user.username = searchWin.items.items[0].getValue();
					user.password = searchWin.items.items[1].getValue();
					user.realName = searchWin.items.items[2].getValue();
					user.empNo = searchWin.items.items[3].getValue();
					user.idNumber = searchWin.items.items[4].getValue();
					user.department = searchWin.items.items[5].getValue();
					user.role = searchWin.items.items[6].getValue();
					user.status = searchWin.items.items[7].getValue();
					var date=searchWin.items.items[8].getValue();
					user.startTime = Ext.Date.format(new Date(date),'Y/m/d');
					//Ext.Msg.alert('',user.startTime);
					if (user.username == null || user.username == ''
						||user.password == null || user.password == ''
						||user.role == null || user.role == ''
						||user.status === null || user.status === '') {
						Ext.Msg.alert('错误', '用户名、密码、角色或状态字段不能为空！');
						return;
					}
					array.push(user);
					Ext.Ajax.request({
						url : 'user/add',
						method : 'POST',
						jsonData : JSON.stringify(array),
						success : function(response) {
							var obj = Ext.decode(response.responseText);
							if (obj.success == true) {
								// 如果你处理的JSON串中true不是字符串
								// 就obj.success== true
								Ext.Msg.alert('成功消息', obj.message);
								store.load();

							} else {
								Ext.Msg.alert('失败消息', obj.message);
							}
							searchWin.close();
						},
						failure : function(response) {
							Ext.Msg.alert('出现错误', '未知错误');
						}
					});
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
			// 自适应滚动条
			autoScroll : true,
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding : '10'
			}
		}).show();
		//使得第一个文本框获取焦点
		searchWin.items.items[0].focus();

	},
	deleteChosenItem : function() {
		var position = this.getSelectionModel().getCurrentPosition();
		if (position == null) {
			return;
		}
		this.store.removeAt(position.row);
		this.commit();
	},
	commit : function() {
		var m=this.store.getModifiedRecords();
		if(m.length>0){
			Ext.Msg.wait('正在保存……','稍等');
			this.store.sync({
				'success' : function(a, b) {
					Ext.Msg.hide();
					Ext.MessageBox.show({
						title : '操作成功',
						msg : a.proxy.reader.rawData.message,
						icon : Ext.MessageBox.OK,
						buttons : Ext.Msg.OK
					});
	//				this.load();
				}
			});
		}

	},
	editPassword : function() {
		var store = this.getStore();
		var record = this.getSelectionModel().getSelection()[0];
		if (record == null) {
			Ext.Msg.alert('操作错误', '请选择要修改密码的用户！');
			return;
		}
		var searchWin = Ext.create('Ext.window.Window', {
			// window标题
			title : "修改用户密码",
			// window的id，根据ID可以取得窗口对象
			id : 'searchWin',
			width : 440,
			height : 200,
			bodyPadding : 20,
			// window包含的元素
			items : [ {
				xtype : 'textfield',
				fieldLabel : '用户名',
				value : record.data.username,
				readOnly : true
			}, {
				xtype : 'textfield',
				fieldLabel : '新密码',
				vtype:'alphanum',
				allowBlank : false
			} ],
			buttons : [ {
				text : '确定修改',
				width : 80,
				height : 30,
				handler : function() {

					var username = searchWin.items.items[0].getValue();
					var password = searchWin.items.items[1].getValue();
					if (password == null || password == '') {
						Ext.Msg.alert('错误', '密码不能为空！');
						return;
					}
					// Ext.Msg.alert('值', oldEmpNo+' '+newEmpNo);
					Ext.Ajax.request({
						url : 'user/resetpassword',
						method : 'POST',
						params : {
							username : username,
							password : password
						},
						success : function(response) {
							var obj = Ext.decode(response.responseText);
							if (obj.success == true) {// 如果你处理的JSON串中true不是字符串，就obj.success
														// == true
								Ext.Msg.alert('成功消息', obj.message);
								store.load();

							} else {
								Ext.Msg.alert('失败消息', obj.message);
							}
							searchWin.close();
						},
						failure : function(response) {
							Ext.Msg.alert('出现错误', '未知错误');
						}
					});
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
			// 自适应滚动条
			autoScroll : true,
			// 当弹出窗口时，背景变灰，为不可操作状态
			modal : true,
			// 设置窗口样式
			bodyStyle : {
				margin : '10',
				padding : '10'
			}
		}).show();
		searchWin.items.items[1].focus();

	},
	searchUser : function() {
		var realnameValue = this.down('textfield[name=realname]').getValue();

		var store = this.store;
		store.proxy.api.read = "user/searchByRealName";
		store.proxy.actionMethods = {
			read : 'POST'
		};
		store.proxy.extraParams = {
			realName : realnameValue
		};
		store.load();

	}
});
