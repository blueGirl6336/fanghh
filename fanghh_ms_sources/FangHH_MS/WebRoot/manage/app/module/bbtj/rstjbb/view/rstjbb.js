Ext.define('HRMS.module.bbtj.rstjbb.view.rstjbb', {
	extend : 'Ext.panel.Panel',
	id : 'common_statements',
	bodyCls : 'commonTable',
	layout : {
        type : 'table',
        columns : 2,
        tableAttrs: {
            style: {
                width: 800
            }
        }
   },
	bodyStyle: 'padding:20px',
	title : '人事变动报表',
	border : 0,
	closable : false, 
    defaults: { 
        // applied to each contained panel
        border:1,
    	bodyStyle: 'background:white;padding:20px;padding-top:0;',
	    frame:true,
    	width:500,
    	height:200
    },
	items: [{
		xtype:   'panel' ,
		title: '干部任免类',
		width:500,
        html: '提示：此页面查询仅针对2014年1月1日 至 2014年12月31日期间的变化数据 '+
        '<p><a href="report/table/commonUseTable/5_8_1" target="_blank">1、干部任职变化人员名单</a></p>' +
        '<p><a href="report/table/commonUseTable/5_8_2" target="_blank">2、干部免职变化人员名单</a></p>'
    },{
    	xtype:   'panel' ,
		title: '新增人员类',
		width:500,
		html:   '<p><a href="report/table/commonUseTable/5_7_1" target="_blank">1、新增固定编制人员名单</a></p>' + 
        '<p><a href="report/table/commonUseTable/5_7_2" target="_blank">2、新增流动编制人员名单</a></p>'
    },{
    	xtype:   'panel' ,
		title: '人员调动类',
	    height: 300,
	    rowspan:3,
        html:  '<p><a href="report/table/commonUseTable/5_9_1" target="_blank">1、部门变化人员名单</a></p>' + 
        '<p><a href="report/table/commonUseTable/5_9_2" target="_blank">2、离职人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_9_3" target="_blank">3、退休人员名单</a></p>'+
        '<p><a href="report/table/commonUseTable/5_9_4" target="_blank">4、职称晋升人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_9_5" target="_blank">5、教师分级人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_9_6" target="_blank">6、职员分级人员名单</a></p>'//+ 
        //'<p>7、转正定级人员名单</p>'//<a href="report/table/commonUseTable/5_9_7" target="_blank"></a>
        
    },{
    	xtype:   'panel' ,
		title: '职级统计类',
		height: 300,
        html:   '<p><a href="report/table/commonUseTable/5_10_1" target="_blank">1、三级职员名单</a></p>'+
        '<p><a href="report/table/commonUseTable/5_10_2" target="_blank">2、四级职员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_10_3" target="_blank">3、五级职员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_10_4" target="_blank">4、六级职员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_10_5" target="_blank">5、七级职员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_10_6" target="_blank">6、八级职员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_10_7" target="_blank">7、九级职员名单</a></p>'
    }/*,{
    	xtype:   'panel' ,
		title: '离退休类',
		height: 130,
        html:    '<p><a href="report/table/commonUseTable/5_5_1" target="_blank">1、离退休人员名单</a></p>' + 
        '<p><a href="report/table/commonUseTable/5_5_2" target="_blank">2、近五年退休人员名单</a></p>'
    },{
    	xtype:   'panel' ,
		title: '其他类',
		height: 160,
        html:    '<p><a href="report/table/commonUseTable/5_6_1" target="_blank">1、其他人员名单(离职、去世)</a></p>' + 
        '<p><a href="report/table/commonUseTable/5_6_2" target="_blank">2、双职工情况统计表</a></p>'+
        '<p><a href="report/table/commonUseTable/5_6_3" target="_blank">3、教职工联系方式表</a></p>'
    }*/]
});
