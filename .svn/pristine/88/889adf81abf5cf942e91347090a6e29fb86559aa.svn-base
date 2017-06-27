Ext.define('HRMS.view.OperationPanel', {
	extend : 'Ext.tab.Panel',
	alias : 'widget.centerpane',
	activeTab : 0,
	autoScroll:true,
	closable : false,
	initComponent : function() {
	
		var path = window.location.href.substring(0,window.location.href.lastIndexOf('/'));
		Ext.applyIf(this, {
			bodyStyle: 'padding: 0px;',
			defaults : {
				autoScroll : true,
				bodyPadding : 2
			},
			items : [ {
				title : '欢迎使用',
				layout: 'fit'
			}]

		});
		this.callParent(arguments);
	},
	
	//向主操作页面中添加标签页
	//使用多标签页模式
//	addView : function(view) {
//		var items = this.items.items;
//		if (items != null) {
//			for ( var i in items) {
//				if(items[i].title == view.title){
//					this.setActiveTab(items[i]);
//					return;
//				}
//			}
//			this.add(view);
//			this.setActiveTab(view);
//		}
//
//	},
	//使用单标签页模式
	addView : function(view) {
		
		var items = this.items.items;
		if (items != null) {
			for ( var i in items) {
				items[i].close();
			}
		}
		
		this.add(view);
		this.setActiveTab(view);

	},
	//判断是否已经有某个页面
	//如果有，直接设置为高亮
	hasThisPage:function(title){
		var items = this.items.items;
		if (items != null) {
			for ( var i in items) {
				if(items[i].title == title){
					this.setActiveTab(items[i]);
					return true;
				}
			}
		}
		return false;
	}
	
});