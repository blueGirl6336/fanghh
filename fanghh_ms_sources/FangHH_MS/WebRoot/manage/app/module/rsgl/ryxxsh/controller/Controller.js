Ext.define('HRMS.module.rsgl.ryxxsh.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	
	stores:['HRMS.store.report.ResumeStore'],

	// 设置单一页面显示
	setView : function(panel, record) {
		// 判断是否有页面需要显示
		if (record.raw.hasFunction) {
			var path = record.raw.path;
			var title = record.raw.text;
			if (!panel.hasThisPage(title)) {
				var code = record.raw.url;
				if (code == 'rsjbxx')
					code = '1';
				var pageToOpen = 'HRMS.module.rsgl.ryxxsh.view.rsjbxx';
//				var page = Ext.create(pageToOpen);
				var store = Ext.create('HRMS.store.personnel.PersonCheckInfoStore',{id:'baseinfocheckstore-'+code});
//				var selModel = Ext.create('Ext.selection.CheckboxModel',{id:'baseinfoselModel-'+code});
//				var page = Ext.create(pageToOpen,{store: store, selModel: selModel});
//				var store = page.getStore();
				var page = Ext.create(pageToOpen,{store: store});
				var store = page.getStore();
				store.proxy.extraParams = {
					departmentCode : code,
					quotaType:''
				};
				page.departmentCode = code;
				store.load({
					callback: function(records, options, success){ 
						//alert(records.length);
						Ext.getCmp('id_jbxxsh_resultCount')
							.setText(records.length);
						}});
				page.setTitle(record.raw.text);
				panel.addView(page);
			}
		}
	}
});