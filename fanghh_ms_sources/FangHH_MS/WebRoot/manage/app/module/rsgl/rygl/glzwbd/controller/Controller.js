Ext.define('HRMS.module.rsgl.rygl.glzwbd.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	refs : [ {
		ref : 'personlist_glzwbd',
		selector : 'personlist_glzwbd'
	},{
		ref : 'details_glzwbd',
		selector : 'details_glzwbd'
	}/*,{
		ref : 'new_form_glzwbd',
		selector : 'new_form_glzwbd'
	}*/],

	views : 'HRMS.module.rsgl.rygl.glzwbd.view.*',
	
	init : function() {
		this.control({
			'personlist_glzwbd dataview' : {
				itemclick : this.setGLZWAndRightForm	
			}/*,
			
			'details_glzwbd dataview' : {
				itemclick : this.setRightForm
			}*/,
			'new_form_glzwbd button[action=add]' : {
				click : this.addNewItem
			},
			'new_form_glzwbd button[action=cancel]' : {
				click : this.cancelAdd
			}
			,'new_modify_glzwbd button[action=modify]' : {
				click : this.modifySelectedItem
			}
			,'new_modify_glzwbd button[action=cancel_modify]' : {
				click : this.cancelModify
			}/*,
			'new_form_glzwbd button[action=modify]' : {
				click : this.modifySelectedItem	
			}*/
		});
	},
	
//	addOrmodify:function(){
//		var form = this.getNew_form_glzwbd().getForm();
//		if('' == form.findField('id').getValue())
//			this.addNewItem();
//		else
//			this.modifySelectedItem();
//	},
	
	cancelAdd:function(){
		this.getDetails_glzwbd().addGLZWWin.hide();
	},
	
	cancelModify:function(){
		this.getDetails_glzwbd().modifyGLZWWin.hide();
	},
	
	setGLZWAndRightForm:function(grid, record, item, index){
//		//填充右侧上方form
//		var form = this.getNew_form_glzwbd().getForm();
//		form.findField('name').setValue(record.data.name);
//		form.findField('empNo').setValue(record.data.empNo);
//		//var dob=Ext.util.Format.date(record.data.dob, 'Y/m/d');
//		//form.findField('dob').setValue(dob);
//		form.findField('department').setValue(item.cells[4].innerText);
//		
//		
//		//清空右侧下方form
//		form.findField('id').setValue('');
//		form.findField('title').setValue('');
//		form.findField('mp_class').setValue('');
//		form.findField('manag_grade').setValue('');
//		//var manag_grade_date=Ext.util.Format.date(store.data.items[0].data.manag_grade_date, 'Y/m/d');
//		form.findField('manag_grade_date').setValue('');
//		form.findField('employer').setValue('哈尔滨工业大学（威海）');//聘任单位不修改
//		form.findField('mp_department').setValue('');
//		//var title_from=Ext.util.Format.date(store.data.items[0].data.title_from, 'Y/m/d');
//		form.findField('title_from').setValue('');
//		//var title_to=Ext.util.Format.date(store.data.items[0].data.title_to, 'Y/m/d');
//		form.findField('title_to').setValue('');
//		form.findField('emp_type').setValue('');					
//		form.findField('remark').setValue('');
		
		// 获取需要查询的工号
		this.empNo = record.data.empNo;
		// 获取被选中人员的基本信息对象 PersonBaseInfo
		var chosenBaseInfo = grid.getStore().getAt(index).getData();
		// 获取下方专业技术职务页面的引用
		var panel = this.getDetails_glzwbd();
		// 将被选中的一条基本信息传到下面标签页
		panel.baseInfo = chosenBaseInfo;
		// 更新数据
		var glzwGrid = this.getDetails_glzwbd();
		var store = panel.getStore();
		store.proxy.extraParams = {
			empNo : this.empNo
		};
		store.load(/*{
			//回调，填充右侧下方form
    		callback: function (records, operation, success) {
        	if (success) {
            	//var a = store.data.items[0].data.employer;
        		
        		if(store.data.items.length > 0){
        			glzwGrid.getSelectionModel().select(0);
        			
	        		form.findField('id').setValue(store.data.items[0].data.id);
					form.findField('title').setValue(store.data.items[0].data.title);
					form.findField('mp_class').setValue(store.data.items[0].data.mp_class);
					form.findField('manag_grade').setValue(store.data.items[0].data.manag_grade);
					var manag_grade_date=Ext.util.Format.date(store.data.items[0].data.manag_grade_date, 'Y/m/d');
					form.findField('manag_grade_date').setValue(manag_grade_date);
					form.findField('employer').setValue(store.data.items[0].data.employer);
					form.findField('mp_department').setValue(store.data.items[0].data.mp_department);
					var title_from=Ext.util.Format.date(store.data.items[0].data.title_from, 'Y/m/d');
					form.findField('title_from').setValue(title_from);
					var title_to=Ext.util.Format.date(store.data.items[0].data.title_to, 'Y/m/d');
					form.findField('title_to').setValue(title_to);
					form.findField('emp_type').setValue(store.data.items[0].data.emp_type);					
					form.findField('remark').setValue(store.data.items[0].data.remark);
        		}
            	
        	}
        }}*/);
		
		
		
	},
	
	/*setRightForm:function(grid, record, item, index){
		//填充右侧form
		var form = this.getNew_form_glzwbd().getForm();
		
		form.findField('id').setValue(record.data.id);
		form.findField('title').setValue(record.data.title);
		form.findField('mp_class').setValue(record.data.mp_class);
		form.findField('manag_grade').setValue(record.data.manag_grade);
		var manag_grade_date=Ext.util.Format.date(record.data.manag_grade_date, 'Y/m/d');
		form.findField('manag_grade_date').setValue(manag_grade_date);
		form.findField('employer').setValue(record.data.employer);
		form.findField('mp_department').setValue(record.data.mp_department);
		var title_from=Ext.util.Format.date(record.data.title_from, 'Y/m/d');
		form.findField('title_from').setValue(title_from);
		var title_to=Ext.util.Format.date(record.data.title_to, 'Y/m/d');
		form.findField('title_to').setValue(title_to);
		form.findField('emp_type').setValue(record.data.emp_type);					
		form.findField('remark').setValue(record.data.remark);
		
	},*/
	
	
	addNewItem:function(){
//		var form1 = this.getPersonlist_glzwbd();
//		var position = form1.getSelectionModel().getCurrentPosition();
//		if (position == null) {
//			Ext.MessageBox.show({
//					title : '提示',
//					msg : '请先于左侧选择要执行添加的人员!',
//					icon : Ext.MessageBox.OK,
//					buttons : Ext.Msg.OK
//				});
//			return;
//		}
		
		var form = Ext.getCmp('id_newGLZWBD_Form').getForm();//this.getNew_form_glzwbd().getForm();
		var transferperson_glzwbd_store = this.getDetails_glzwbd().getStore();
		//var _empNo = form.findField('empNo').getValue();
		var _empNo = Ext.getCmp('glzwbdPersonList').getSelectionModel().getSelection()[0].data.empNo;
		form.findField('empNo').setValue(_empNo);
		
		//必须加上这么一句，不然抛出bug 'Ajax communication failed'，不知道为啥
		//form.findField('id').setValue('-1');
		
		form.submit({
		    clientValidation: false,
		    url: 'managementposition/addOne',
		    success: function(form, action) {
		       Ext.Msg.alert('Success', '添加成功'/* + action.result.msg*/);
		       
		       //刷新下侧grid		       
		       transferperson_glzwbd_store.proxy.extraParams = {
					empNo : _empNo
				};
				transferperson_glzwbd_store.load();
		    },
		    failure: function(form, action) {
		        switch (action.failureType) {
		            case Ext.form.action.Action.CLIENT_INVALID:
		                Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
		                break;
		            case Ext.form.action.Action.CONNECT_FAILURE:
		                Ext.Msg.alert('Failure', 'Ajax communication failed');
		                break;
		            case Ext.form.action.Action.SERVER_INVALID:
		               Ext.Msg.alert('Failure', action.result.msg);
		       }
		    }
		});
		
		this.getDetails_glzwbd().addGLZWWin.hide();
	},
	modifySelectedItem: function(){
//		var form1 = this.getDetails_glzwbd();
//		var position = form1.getSelectionModel().getCurrentPosition();
//		if (position == null) {
//			Ext.MessageBox.show({
//					title : '提示',
//					msg : '请先选中左侧要修改的专业技术职务项!',
//					icon : Ext.MessageBox.OK,
//					buttons : Ext.Msg.OK
//				});
//			return;
//		}

		var form = Ext.getCmp('id_modifyGLZWBD_Form').getForm();//var form = this.getNew_form_glzwbd().getForm();
		var transferperson_glzwbd_store = this.getDetails_glzwbd().getStore();
		//var _empNo = form.findField('empNo').getValue();
		var _empNo = Ext.getCmp('glzwbdPersonList').getSelectionModel().getSelection()[0].data.empNo;
		
		form.submit({
		    clientValidation: false,
		    url: 'managementposition/updateOne',
		    success: function(form, action) {
		       Ext.Msg.alert('Success', '修改成功'/* + action.result.msg*/);
		       
		       //刷新下侧grid		       
		       transferperson_glzwbd_store.proxy.extraParams = {
					empNo : _empNo
				};
				transferperson_glzwbd_store.load();
		    },
		    failure: function(form, action) {
		        switch (action.failureType) {
		            case Ext.form.action.Action.CLIENT_INVALID:
		                Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
		                break;
		            case Ext.form.action.Action.CONNECT_FAILURE:
		                Ext.Msg.alert('Failure', 'Ajax communication failed');
		                break;
		            case Ext.form.action.Action.SERVER_INVALID:
		               Ext.Msg.alert('Failure', action.result.msg);
		       }
		    }
		});
		
		this.getDetails_glzwbd().modifyGLZWWin.hide();
	}
		
		
		
		
		
		
		
});