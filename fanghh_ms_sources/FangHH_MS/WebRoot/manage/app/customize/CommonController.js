Ext.define('HRMS.customize.CommonController', {
	extend : 'Ext.app.Controller',

	// 设置单一页面显示
	setView : function(panel, record) {
		// 判断是否有页面需要显示
		if (record.raw.hasFunction) {
			var path = record.raw.path;
			var title = record.raw.text;

			if (!panel.hasThisPage(title)) {

				var pageToOpen = 'HRMS.module.' + path + '.view.'
						+ record.raw.url;
				var page = Ext.create(pageToOpen);
				page.setTitle(record.raw.text);
				panel.addView(page);
			}
		}
	}

});
