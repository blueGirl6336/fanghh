Ext.define('HRMS.module.rsgl.rygl.rybmbd.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	refs : [ {
		ref : 'stafftransferform',
		selector : 'stafftransferform'
	},{
		ref : 'tansferpersonlist',
		selector : 'tansferpersonlist'
	},{
		ref : 'otherinfopanel' ,
		selector : 'otherinfopanel'
	}],

	views : 'HRMS.module.rsgl.rygl.rybmbd.view.*',
	
	empNo : 0,
	chosenBaseInfo: 0,
	init : function() {
		this.control({
			'tansferpersonlist dataview' : {
				itemclick : this.setPersonInfo	
			},
			'stafftransferform button[action=submit]' : {
				click : this.submitForm	
			},
			'otherinfopanel' : {
				tabchange : this.changePanel
			}
		});
		this.clearTabPanel(this.getOtherinfopanel());
	},
	
	setPersonInfo:function(grid, record,item,index){
		var form = this.getStafftransferform().getForm();
		form.findField('name').setValue(record.data.name);
		form.findField('empNo').setValue(record.data.empNo);
		//对日期进行格式化
		form.findField('dob').setValue(Ext.util.Format.date(record.data.dob, 'Y/m/d'));
		form.findField('department').setValue(item.cells[3].innerText);
		form.findField('sub_unit').setValue(item.cells[4].innerText);
		form.findField('aim_department').select(record.data.department);
		this.empNo = record.data.empNo;
		var chosenBaseInfo = grid.getStore().getAt(index).getData();
		var tabPanel = this.getOtherinfopanel();
		this.initTabPanel(tabPanel,chosenBaseInfo);
		var page = tabPanel.getActiveTab();
		var store = form.findField('subunit').store;
		var tabStore = page.getStore();
		tabStore.proxy.extraParams = {
				empNo : this.empNo
		};
		store.proxy.extraParams={department:record.data.department};
		tabStore.load();
		store.load();
	},
	initTabPanel: function(tabPanel, baseInfo){
		if(tabPanel == null)
			return;
		var length = tabPanel.items.length;
		for(var i = 0; i <length; i++){
			tabPanel.items.items[i].baseInfo = baseInfo;
		}
	},
	changePanel: function(grid,newCard){
		if(this.empNo == 0)
			return;
		var tabPanel = this.getOtherinfopanel();
		var page = tabPanel.getActiveTab();
		var store = page.getStore();
		store.proxy.extraParams = {
				empNo : this.empNo
		};
		store.load();
	},
	clearTabPanel: function(tabPanel){
		if(tabPanel == null)
			return;
		for(var i = 0; i<length; i++){
			tabPanel.items.items[i].baseInfo = null;
		}
	},
	submitForm:function(){
		var me = this;
		var form = this.getStafftransferform().getForm();
		var values = form.getValues();
		var su = values.subunit;
		var store1=Ext.getStore('department'),
			store2=Ext.getStore('allsubunit');
		var department=store1.findRecord('code', values.aim_department).data.name;
		var subunit=store2.findRecord('code', su);
		if(subunit==null)subunit='';
		else subunit=subunit.data.name;
		form.submit({
		    clientValidation: false,
		    url: 'department/transfer',
		    success: function(form, action) {
		    	Ext.Msg.alert('成功', action.result.message);
				form.setValues({
					empNo: values.empNo,
					department:department,
					sub_unit:subunit
				});
				var store = me.getTansferpersonlist().getStore();
				store.load();
		    },
		    failure: function(form, action) {
		    	Ext.Msg.alert('失败', action.result.message);			    //form.reset();
		    }
		});
		
	}		
});