/*定制rowEditing插件
 *所以此处对一些默认字段进行重新配置
 */

Ext.define('HRMS.customize.GridRowEditing', {
	extend : 'Ext.grid.plugin.RowEditing',
	clicksToMoveEditor : 1,
	autoCancel : true,
	saveBtnText : '确定',
	cancelBtnText : '取消',
	errorsText : '警告',
	listeners : {
		edit : function(editor, context, eOpts) {
			var store = context.grid.getStore();
			store.sync({
				'success' : function(a, b) {
					store.load();
				},
				scope : this
			});
		},
		canceledit : function(editor, context, eOpts) {
			var store = context.grid.getStore();
			store.load();
		}
	}

});