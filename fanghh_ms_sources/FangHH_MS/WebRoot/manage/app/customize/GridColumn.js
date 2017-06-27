/*因为Ext 4.2自带的column控件许多的默认config不合适，
 *所以此处对一些默认字段进行重新配置
 */

Ext.define('HRMS.customize.GridColumn', {
	 extend: 'Ext.grid.column.Column',
	 alias: 'widget.mycolumn',
	 
	 //不能进行隐藏
	 hideable:false,
	 //不能进行拖拽
	 draggable:false,
	 //不出现头部菜单
	 menuDisabled: true,
	 //内容居中
	 align: 'center',
	 
	 renderer: function(val){
		 if(val == null)
			 return '';
		 else
			 return val;
	 }
});