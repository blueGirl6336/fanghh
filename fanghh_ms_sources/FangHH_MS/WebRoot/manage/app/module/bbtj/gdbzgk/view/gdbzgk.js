Ext.define('HRMS.module.bbtj.gdbzgk.view.gdbzgk', {
	extend : 'Ext.panel.Panel',
	padding: '0 20 10 20',
	layout : {
		type : 'table',
		columns : 2
	},
	title : '固定编制岗位结构概况',
	border : 0,
	closable : false,
	defaults : {
		border : 1,
		bodyStyle : 'background:white;padding:10px',
		frame : true,
		width : 800
	},
	items : [ {
		xtype : 'table3_1',
		id : 'id_table3_1',
		tableUrl : 'report/table/getDataTable/3-1',
		layout : 'fit',
		colspan: 2,
		width: 1500,
		title : '固定编制人员岗位结构概况'
	}, {
		xtype : 'table3_2',
		id : 'id_table3_2',
		tableUrl : 'report/table/getDataTable/3-2',
		layout : 'fit',
		colspan: 2,
		width: 1500,
		title : '机关部处固定编制人员岗位结构概况'
	}, {
		xtype : 'table3_3',
		id : 'id_table3_3',
		tableUrl : 'report/table/getDataTable/3-3',
		layout : 'fit',
		colspan: 2,
		width: 1500,
		title : '直属单位固定编制人员岗位结构概况'
	}, {
		xtype : 'table3_4',
		id : 'id_table3_4',
		tableUrl : 'report/table/getDataTable/3-4',
		layout : 'fit',
		colspan: 2,
		width: 1500,
		title : '教学单位固定编制人员岗位结构概况'
	}
	]
});
