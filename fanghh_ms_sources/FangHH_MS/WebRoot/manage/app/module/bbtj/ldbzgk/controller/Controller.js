Ext.define('HRMS.module.bbtj.ldbzgk.controller.Controller', {
	extend : 'HRMS.customize.CommonController',

	// views : 'HRMS.module.bbtj.qxzzgk.view.*'
	views : [ 'HRMS.module.bbtj.ldbzgk.view.ldbzgk',
			'HRMS.module.bbtj.ldbzgk.view.table4_1',
			'HRMS.module.bbtj.ldbzgk.view.table4_2',
			'HRMS.module.bbtj.ldbzgk.view.table4_3',
			'HRMS.module.bbtj.ldbzgk.view.table4_4',
			'HRMS.module.bbtj.ldbzgk.view.table4_5' ],
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

				var tableIdToFocus = '#id_table4_1';
				if (record.raw.text == '机关部处') {
					tableIdToFocus = '#id_table4_2';
				} else if (record.raw.text == '直属单位') {
					tableIdToFocus = '#id_table4_3';
				} else if (record.raw.text == '教学单位') {
					tableIdToFocus = '#id_table4_4';
				} else if (record.raw.text == '各单位用工方式概况') {
					tableIdToFocus = '#id_table4_5';
				} else {
					tableIdToFocus = null;
				}
				if (tableIdToFocus != null) {
					var task = new Ext.util.DelayedTask(function() {
						var table = page.down(tableIdToFocus);
						if (table != null) {
							table.focus();
						}
					});
					task.delay(400);
				}
			}

		}
	}

});