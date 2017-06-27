Ext.define('HRMS.module.bbtj.gdbzgk.glgwgk.view.glgwgk', {
	extend : 'Ext.panel.Panel',
padding: '0 20 10 20',
layout : {
	type : 'table',
	columns : 2
},
border : 0,
closable : false,
defaults : {
	border : 1,
	bodyStyle : 'background:white;padding:10px',
	frame : true,
	width : 800
},
items : [ {
	xtype : 'table3_5',
	tableUrl : 'report/table/getDataTable/3-5',
	layout : 'fit',
	colspan: 2,
	width: 1400,
	title : '管理岗位人员职务分布'
}]
});
