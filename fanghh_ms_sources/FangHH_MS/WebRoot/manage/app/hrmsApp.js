if (Ext.isIE) {
	Ext.enableGarbageCollector = false;
}
//解决store中的中文排序问题  
Ext.override(Ext.data.Store, {
	sort : function(params) {
		var dir = params ? params.direction : 'ASC';
		var prop = params ? params.property : 'name';

		this.callParent(arguments); // UPDATE 2

		this.doSort(function(rec1, rec2) {

			var result = 1;

			var v1 = rec1.get(prop);
			var v2 = rec2.get(prop);

			if (v1 == null) {
				v1 = '';
			}

			if (v2 == null) {
				v2 = '';
			}

			if (typeof (v1) == "string") {
				result = v1.localeCompare(v2);
			}
			else {
				result = (v1 > v2 ? 1 : (v1 < v2 ? -1 : 0));
			}

			return result * (dir == 'ASC' ? 1 : -1);
		});
	}

});

Ext.Loader.setConfig({
	enabled : true
});
Ext.Loader.setPath('Ext.ux', '../ext-4.2/ux');
Ext.application({
	controllers : [ 'ModuleController' ],

	autoCreateViewport : true,

	requires : [ 'HRMS.view.OperationPanel', 'HRMS.view.Header' ],

	views : [ 'HRMS.customize.GridColumn' ],

	name : 'HRMS'
});

var keepLogin = function() {
	Ext.Ajax.request({
		url : 'system/continueLogin',
		timeout : 60000
	});

};

var runner = new Ext.util.TaskRunner();
var task = runner.start({
	run : keepLogin,
	interval : 1200000
});

/**
 * 页面移动到某个地方
 */
function jumpToSomeTable(id) {

	var obj = Ext.getCmp(id);
	obj.focus();
}

// javascript:jumpToSomeTable(''id_table2_2'')
