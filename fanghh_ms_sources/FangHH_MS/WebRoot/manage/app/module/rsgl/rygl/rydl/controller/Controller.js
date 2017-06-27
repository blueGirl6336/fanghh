Ext.define('HRMS.module.rsgl.rygl.rydl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	refs : [ {
		ref : 'stafftransferform',
		selector : 'stafftransferform'
	},{
		ref : 'tansferpersonlist',
		selector : 'tansferpersonlist'
	}],

	views : 'HRMS.module.rsgl.rygl.rydl.view.*',
	
	init : function() {
		this.control({
			'tansferpersonlist dataview' : {
				itemclick : this.setPersonInfo	
			},
			'stafftransferform button[action=submit]' : {
				click : this.submitForm	
			}
		});
	},
	setPersonInfo:function(grid, record,item){
		var form = this.getStafftransferform().getForm();
		form.findField('name').setValue(record.data.name);
		form.findField('empNo').setValue(record.data.empNo);
		var dob=Ext.util.Format.date(record.data.dob, 'Y/m/d');
		form.findField('dob').setValue(dob);
		form.findField('department').setValue(item.cells[4].innerText);
		form.findField('workState').setValue(this.workStateRender(record.data.workState));
		
	},
	submitForm:function(){
		var form = this.getStafftransferform().getForm();
		form.submit({
		    clientValidation: false,
		    url: 'transfer/out/add',
		    success: function(form, action) {
		    	var msg = action.response.responseText;
		    	var jsonMsg = Ext.decode(msg);
		    	if(jsonMsg.success)
		    		Ext.Msg.alert('操作成功', jsonMsg.message);
		    	else
		    		Ext.Msg.alert('操作失败', jsonMsg.message);
		    },
		    failure: function(form, action) {
		        switch (action.failureType) {
		            case Ext.form.action.Action.CLIENT_INVALID:
		                Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
		                break;
		            case Ext.form.action.Action.CONNECT_FAILURE:
		                Ext.Msg.alert('失败', '请勿重复操作');
		                break;
		            case Ext.form.action.Action.SERVER_INVALID:
		               Ext.Msg.alert('Failure', action.result.msg);
		       }
		    }
		});
	},
	workStateRender : function(val) {
		if(val == 0)
			return '';
		store = Ext.getStore('workState');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	}
});