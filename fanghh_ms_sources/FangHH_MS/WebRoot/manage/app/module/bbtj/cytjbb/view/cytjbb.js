Ext.define('HRMS.module.bbtj.cytjbb.view.cytjbb', {
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
	title : '常用报表',
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
		title: '总体情况类',
        html:   '<p>提示：由于数据量较大，首次查询需要一定的时间，请耐心等待</p>'+
        	'<p><a href="report/table/commonUseTable/5_1_1" target="_blank">1、固定编制人员名单</a></p>' + 
        '<p><a href="report/table/commonUseTable/5_1_2" target="_blank">2、流动编制人员名单</a></p>'
    },{
    	xtype:   'panel' ,
		title: '管理岗位类',
		html:   '<p><a href="report/table/commonUseTable/5_2_1" target="_blank">1、管理岗位人员名单</a></p>' + 
        '<p><a href="report/table/commonUseTable/5_2_2" target="_blank">2、副处级及以上人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_2_3" target="_blank">3、重要岗人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_2_4" target="_blank">4、双肩挑人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_2_5" target="_blank">5、辅导员人员名单</a></p>'
    },{
    	xtype:   'panel' ,
		title: '专业技术岗类',
	    height: 440,
	    rowspan:3,
        html:  '<p><a href="report/table/commonUseTable/5_3_1" target="_blank">1、专业技术岗位人员名单</a></p>' + 
        '<p><a href="report/table/commonUseTable/5_3_2" target="_blank">2、专任教师岗位人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_3_8" target="_blank">3、其它专业技术岗位人员名单</a></p>'+
        '<p><a href="report/table/commonUseTable/5_3_3" target="_blank">4、教授/副教授名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_3_5" target="_blank">5、双基地人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_3_7" target="_blank">6、博士生导师名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_3_6" target="_blank">7、硕士生导师名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_3_10" target="_blank">8、具有海外经历人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_3_13" target="_blank">9、海外取得学位人员名单</a></p>'+
        '<p><a href="report/table/commonUseTable/5_3_11" target="_blank">10、所有学位均取得于哈工大人员名单</a></p>'+ 
        '<p><a href="report/table/commonUseTable/5_3_12" target="_blank">11、所有学位均取得于哈工大以外院校人员名单</a></p>'
        
        
    },{
    	xtype:   'panel' ,
		title: '工勤技能岗类',
		height: 100,
        html:   '<p><a href="report/table/commonUseTable/5_4_1" target="_blank">1、工勤技能岗位人员名单</a></p>'
    },{
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
    }]
});
