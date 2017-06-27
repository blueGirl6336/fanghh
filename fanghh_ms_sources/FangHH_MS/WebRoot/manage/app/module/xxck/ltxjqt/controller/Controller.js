Ext.define('HRMS.module.rsgl.rsjbxx.ltxjqt.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	
	// 设置单一页面显示
	setView : function(panel, record) {
		// 判断是否有页面需要显示
		if (record.raw.hasFunction) {
			var path = record.raw.path;
			var title = record.raw.text;
			if (!panel.hasThisPage(title)) {
				var code = record.raw.url;
				var pageToOpen = 'HRMS.module.rsgl.rsjbxx.ltxjqt.view.ltxjqt';
//				var page = Ext.create(pageToOpen);
				var store = Ext.create('HRMS.store.personnel.OtherPersonInfoStore');
				var page = Ext.create(pageToOpen,{store: store});

				page.workStates.length = 0;
				if(code == 'ltx'){
					//离退休人员
					page.workStates.push('2030003');
				}else if(code == 'qt'){
					//其他人员
					page.workStates.push('2030002');
					page.workStates.push('2030004');
				}else{
					page.workStates.push('2030002');
					page.workStates.push('2030003');
					page.workStates.push('2030004');
				}
				var store = page.getStore();
		        store.proxy.extraParams = {
		        	workStates : page.workStates,
		            name:''
		        };
				store.load({
					callback: function(records, options, success){ 
					//alert(records.length);
					Ext.getCmp('id_ltxjqt_resultCount')
						.setText(records.length);
					}});
				page.setTitle(title);
				panel.addView(page);
			}
		}
	}
});