Ext.define('HRMS.module.rsgl.rsjbxx.controller.Controller', {
	extend : 'HRMS.customize.CommonController',

	stores : [ 'HRMS.store.report.ResumeStore' ],

	lastPageMilsec : -1,
	

	// 设置单一页面显示
	setView : function(panel, record) {
		var myDate = new Date();
		var milnow = myDate.getTime();
		if (this.lastPageMilsec != -1) {
			if(milnow - this.lastPageMilsec < 500){
				return;
			}
		}
		this.lastPageMilsec = milnow;
			
		// 判断是否有页面需要显示
		if (record.raw.hasFunction) {
			var path = record.raw.path;
			var title = record.raw.text;
			if (!panel.hasThisPage(title)) {
				var code = record.raw.url;
				if (code == 'rsjbxx')
					code = '1';
				var pageToOpen = 'HRMS.module.rsgl.rsjbxx.view.rsjbxx';
				// var page = Ext.create(pageToOpen);
				var store = Ext.create(
						'HRMS.store.personnel.PersonBaseInfoForShowStore', {
							id : 'baseinfostore-' + code
						});
				var page = Ext.create(pageToOpen, {
					store : store
				});
				store.proxy.actionMethods = {
					read : 'POST'
				};
				store.proxy.extraParams = {
					quota : '2',
					name : '',
					doe : '',
					empNo : null,
					department : code
				};
				page.departmentCode = code;
				store.load({
					callback : function(records, options, success) {
						// alert(records.length);
						Ext.getCmp('id_jbxx_resultCount').setText(
								records.length);
					}
				});
				page.setTitle(record.raw.text);
				panel.addView(page);
			}
		}
	}
});