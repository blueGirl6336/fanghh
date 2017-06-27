Ext.define('HRMS.module.bbtj.gdbzgk.gqjngwgk.view.gqjngwgk', {
	extend : 'Ext.panel.Panel',
	padding: '0 20 10 20',
	layout : {
		type : 'table',
		columns : 2
	},
	title : '工勤技能岗位人员分布情况',
	border : 0,
	closable : false,
	defaults : {
		border : 1,
		bodyStyle : 'background:white;padding:10px',
		frame : true,
		width : 800
	},
	items : [ {
		xtype : 'table3_13',
		tableUrl : 'report/table/getDataTable/3-13',
		layout : 'fit',
		colspan: 2,
		width: 700,
		title : '工勤技能岗位人员分布情况'
	}]
});
