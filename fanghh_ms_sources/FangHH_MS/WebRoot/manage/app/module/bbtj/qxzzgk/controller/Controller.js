Ext.define('HRMS.module.bbtj.qxzzgk.controller.Controller', {
	extend : 'HRMS.customize.CommonController',

	// views : 'HRMS.module.bbtj.qxzzgk.view.*'
	views : [ 'HRMS.module.bbtj.qxzzgk.view.qxzzgk',
			'HRMS.module.bbtj.qxzzgk.view.table2_1',
			'HRMS.module.bbtj.qxzzgk.view.table2_2',
			'HRMS.module.bbtj.qxzzgk.view.table2_3',
			'HRMS.module.bbtj.qxzzgk.view.table2_4' ],

	// 在报表中，对于某些情况，需要在载入后进行定位，重写setview方法
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
				
				var tableIdToFocus = '#id_table2_1';
				if (record.raw.text == '机关部处') {
					tableIdToFocus = '#id_table2_2';
				} else if (record.raw.text == '直属单位') {
					tableIdToFocus = '#id_table2_3';
				} else if (record.raw.text == '教学单位') {
					tableIdToFocus = '#id_table2_4';
				}
				var task = new Ext.util.DelayedTask(function() {
					var table = page.down(tableIdToFocus);
					if (table != null) {
						table.focus();
					}
				});
				task.delay(600);
			}

		}
	}

});

