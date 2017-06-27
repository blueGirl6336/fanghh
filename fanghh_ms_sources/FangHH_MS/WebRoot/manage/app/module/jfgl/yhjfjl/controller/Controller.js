Ext.define('HRMS.module.jfgl.yhjfjl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	
	refs : [ {
		ref : 'integralRecordPanel',
		selector : 'integralRecordPanel'
//	},{
//		ref : 'otherinfopanel',
//		selector : 'otherinfopanel'
	}],

	views : 'HRMS.module.jfgl.yhjfjl.view.*',
	
	chosenBaseInfo: 0,

// stores : ['HRMS.store.DictionaryItemStore'],
			
	init : function() {
		this.control({
//			'cityInfoPanel dataview' : {
//				itemclick : this.setEmpNoAndLoadData
//			},
//			'cityInfoPanel button[action=refreshTabBtn]' : {
//				click : this.refreshTabBtn
//			},
//			'cityInfoPanel button[action=addNew]' : {
//				click : this.addNew
//			},
//			'cityInfoPanel button[action=uploadImage]' : {
//				click : this.uploadImage
//			},
//			'otherinfopanel' : {
//				tabchange : this.changePanel
//			}
		});
		
	},
	
//	setEmpNoAndLoadData: function(grid, record, item, index){
//
//		var chosenBaseInfo = grid.getStore().getAt(index).getData();
//		var tabPanel = this.getOtherinfopanel();
//		var page = tabPanel.getActiveTab();		
//		var store = page.getStore();
//		this.initTabPanel(tabPanel, chosenBaseInfo)
//		store.proxy.extraParams = {
//			cityId: chosenBaseInfo.cityId
//		};
//		store.proxy.actionMethods = {
//				read : 'POST'
//			};
//		store.load();
//	},
//	initTabPanel: function(tabPanel, baseInfo){
//		if(tabPanel == null)
//			return;
//		var length = tabPanel.items.length;
//		for(var i = 0; i < length; i++){
//			var tabItem = tabPanel.items.items[i];
//			tabItem.cityInfo = baseInfo;
//			
//		}
//	},
//	
//	refreshTabBtn: function(){
//		
//		var tabPanel = this.getOtherinfopanel();
//		if(tabPanel == null)
//			return;
//		var length = tabPanel.items.length;
//		for(var i = 0; i < length; i++){
//			var tabItem = tabPanel.items.items[i];
//			tabItem.getStore().removeAll();
//		
//		}
//	},
//	changePanel:function(grid, newCard){
//		if(this.empNo == 0 )
//			return;
//		var tabPanel = this.getOtherinfopanel();
//		var page = tabPanel.getActiveTab();
//		var store = page.getStore();
//		store.proxy.extraParams = {
//			cityId : page.cityInfo.cityId
//		};
//		store.load();
//		
//	},
//	
//	selectAndLoadData : function(empNoValue){
//		var panel=this.getBaseInfoPanel();
//		panel.getSelectionModel().select(0);
//		//获取需要查询的工号
//		this.empNo = empNoValue;
//		// 获取人员信息对象 PersonBaseInfo
//		var chosenBaseInfo = panel.getStore().getAt(0).getData();
//		// 获取标签页母页
//		var tabPanel = this.getOtherinfopanel();
//		
//		this.initTabPanel(tabPanel, chosenBaseInfo);
//		// 获取当前选中标签页
//		var page = tabPanel.getActiveTab();
//		// 更新数据
//		var store = page.getStore();
//		store.proxy.extraParams = {
//			empNo : this.empNo
//		};
//		store.load();
//	},	
});