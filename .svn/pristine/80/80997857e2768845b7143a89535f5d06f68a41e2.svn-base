/**
 * 这个控件用来打印简历
 */
Ext.define("Ext.ux.grid.ResumePrinter", {
    requires: 'Ext.XTemplate',
    statics: {
        print: function (records) {
            var content = '<div id="allInfoTable">';
            var length = records.length;
            for (var i = 0; i < length; i++) {
                var tableContent = '<div id="infoTable'+i+'">';
                var record = records[i];
                var baseInfo = Ext.create('Ext.XTemplate',
                    this.baseInfoTpl).apply(record.raw.baseInfo);
                tableContent += baseInfo;
                var contactInfo=Ext.create('Ext.XTemplate',
                        this.contactTpl).apply(record.raw.contact);
                tableContent += contactInfo;
                
                var empObjData = {};
                
                //家庭成员
                var fa = this.familyHeader;
                if (record.raw.familyMemebers != null) {
                    for (var j = 0; j < record.raw.familyMemebers.length; j++) {
                        fa += Ext.create('Ext.XTemplate',this.familyTpl).apply(record.raw.familyMemebers[j]);
                    }
                }else{
                	fa += Ext.create('Ext.XTemplate',this.familyTpl).apply(empObjData);
                }
                fa+="</table>";
                tableContent += fa;
                
                //教育经历
                var eb = this.educationBackgroundHeader;
                if (record.raw.educationBackgrounds != null) {
                    for (var j = 0; j < record.raw.educationBackgrounds.length; j++) {
                        eb += Ext.create('Ext.XTemplate',this.educationBackgroundTpl).apply(record.raw.educationBackgrounds[j]);
                    }
                }else{
                	eb += Ext.create('Ext.XTemplate',this.educationBackgroundTpl).apply(empObjData);
                }
                eb+="</table>";
                tableContent += eb;
                
                
                //工作经历
                var we = this.workExpHeader;
                if (record.raw.workExperiences != null) {
                    for (var j = 0; j < record.raw.workExperiences.length; j++) {
                        we += Ext.create('Ext.XTemplate',
                            this.workExpTpl).apply(
                            record.raw.workExperiences[j]);
                    }
                }else{
                	we += Ext.create('Ext.XTemplate',this.workExpTpl).apply(empObjData);
                }
                we+="</table>";
                tableContent += we;
                
                //tableContent+='<div class="pageBreak"></div>';
                
                //专业技术职务信息
                var prf = this.techPostHeader;
                if (record.raw.professionals != null) {
                    for (var j = 0; j < record.raw.professionals.length; j++) {
                        prf += Ext.create('Ext.XTemplate', this.techPostTpl).apply(record.raw.professionals[j]);
                    }
                }else{
                	 prf += Ext.create('Ext.XTemplate', this.techPostTpl).apply(empObjData);
                }
                prf+="</table>";
                tableContent += prf;
                
                //管理职务信息
                var mg = this.managePostHeader;
                if (record.raw.managements != null) {
                    for (var j = 0; j < record.raw.managements.length; j++) {
                        mg += Ext.create('Ext.XTemplate',this.managePostTpl).apply(record.raw.managements[j]);
                    }
                }else{
                	mg += Ext.create('Ext.XTemplate',this.managePostTpl).apply(empObjData);
                }
                mg+="</table>";
                tableContent += mg;
                
                //技术等级信息
                var service = this.servicePostHeader;
                if (record.raw.servicePosts != null) {
                    for (var j = 0; j < record.raw.servicePosts.length; j++) {
                    	service += Ext.create('Ext.XTemplate',this.servicePostTpl).apply(record.raw.servicePosts[j]);
                    }
                }else{
                	service += Ext.create('Ext.XTemplate',this.servicePostTpl).apply(empObjData);
                }
                service+="</table>";
                tableContent += service;
                
              //海外经历
                var abroad = this.abroadHeader;
                if (record.raw.abroadexp != null) {
                    for (var j = 0; j < record.raw.abroadexp.length; j++) {
                    	abroad += Ext.create('Ext.XTemplate',this.abroadTpl).apply(record.raw.abroadexp[j]);
                    }
                }else{
                	abroad += Ext.create('Ext.XTemplate',this.abroadTpl).apply(empObjData);
                }
                abroad+="</table>";
                tableContent += abroad;
                
              //获奖信息
                var award = this.awardHeader;
                if (record.raw.awards != null) {
                    for (var j = 0; j < record.raw.awards.length; j++) {
                    	award += Ext.create('Ext.XTemplate',this.awardTpl).apply(record.raw.awards[j]);
                    }
                }else{
                	award += Ext.create('Ext.XTemplate',this.awardTpl).apply(empObjData);
                }
                award+="</table>";
                tableContent += award;
                
              //优秀人才
                var talent = this.talentHeader;
                if (record.raw.talentInfo != null) {
                    for (var j = 0; j < record.raw.talentInfo.length; j++) {
                    	talent += Ext.create('Ext.XTemplate',this.talentTpl).apply(record.raw.talentInfo[j]);
                    }
                }else{
                	talent += Ext.create('Ext.XTemplate',this.talentTpl).apply(empObjData);
                }
                talent+="</table>";
                tableContent += talent;
                
                
                
                tableContent += '<p>&nbsp;</p>';
                tableContent += '</div>';
                tableContent += '<div style="width:100%; height: 50px;"></div>';
                //如果不是最后一项  现价强制打印分页
                if(length - i - 1 > 0)
                	tableContent += '<div class="pageBreak"></div>';
                content += tableContent;
            }
            content += '</div>';
            var htmlHead = '<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">' +
                '<html xmlns="http://www.w3.org/1999/xhtml">' + '<head>' + '<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />' +
                '<link href="css/resume.css" rel="stylesheet" type="text/css" />' + '<link href="./css/print.css" rel="stylesheet" type="text/css"/>' +
                '<title>个人简历</title>' + '<script language="javascript" src="../ext-4.2/ux/grid/LodopFuncs.js"></script>' + 
                '</head>';
            var htmlBodyTpl = [
                '<body class="' + Ext.baseCSSPrefix + 'ux-grid-printer-body">',
                '<div class="' + Ext.baseCSSPrefix + 'ux-grid-printer-noprint ' + Ext.baseCSSPrefix + 'ux-grid-printer-links">',
                '<input class="button"  type="button" onclick="window.print();" name="name" value=' + this.printLinkText + ' />',
                //'<input class="button"  type="button" onclick="javascript:SaveAsWord(\'UTF-8\',document.getElementById(\'allInfoTable\').innerHTML);" value=' + this.exportWord + ' />',
                '</div>', content, '</body>', '</html>'
            ];
            data = {};
            var htmlBody = Ext.create('Ext.XTemplate',
                htmlBodyTpl).apply(data);
            var html = htmlHead + htmlBody;
            // open up a new printing window, write to it, print
            // it and close
            var win = window.open('', 'printgrid');
            // document must be open and closed
            win.document.open();
            win.document.write(html);
            win.focus();
            // win.document.close();
            if (this.printAutomatically) {
                win.print();
            }
            // Another way to set the closing of the main
            if (this.closeAutomaticallyAfterPrint) {
                if (Ext.isIE) {
                    window.close();
                }
                else {
                    win.close();
                }
            }
        },
        /**
         * @property stylesheetPath
         * @type String The path at which the print stylesheet
         *       can be found (defaults to
         *       'ux/grid/gridPrinterCss/print.css')
         */
        stylesheetPath: null,
        /**
         * @property printAutomatically
         * @type Boolean True to open the print dialog
         *       automatically and close the window after
         *       printing. False to simply open the print
         *       version of the grid (defaults to false)
         */
        printAutomatically: false,
        /**
         * @property closeAutomaticallyAfterPrint
         * @type Boolean True to close the window automatically
         *       after printing. (defaults to false)
         */
        closeAutomaticallyAfterPrint: false,
        /**
         * @property mainTitle
         * @type String Title to be used on top of the table
         *       (defaults to empty)
         */
        mainTitle: '',
        /**
         * Text show on close link
         *
         * @type String
         */
        printLinkText: '打印',
        /**
         * Text show on export to Excel
         *
         * @type String
         */
        exportExcel: '导出Excel',
        /**
         * Text show on export to Word
         *
         * @type String
         */
        exportWord: '导出Word',
        /**
         * Text show on close link
         *
         * @type String
         */
        closeLinkText: '关闭',
        /**
         * object
         *
         * @type String
         */
        objectString: '<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> ' + '<embed id="LODOP_EM" TYPE="application/x-print-lodop" width=0 height=0 PLUGINSPAGE="install_lodop32.exe"></embed>' + '</object>',
        /**
         * print table javascript
         *
         * @type String
         */
        printScript: '<script language="javascript" type="text/javascript">' 
        	+ 'var LODOP; /*声明为全局变量*/' 
        	+ 'function printTable(){' 
        	+ 'LODOP=getLodop(document.getElementById(\'LODOP_OB\'),document.getElementById(\'LODOP_EM\'));' 
        	+ 'LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_自定义纸张");' 
        	+ 'LODOP.ADD_PRINT_TABLE(10,10,"100%","100%",document.getElementById("infoTable").innerHTML);' 
        	+ 'LODOP.PREVIEW();};'
        	+ 'function SaveAsWord(intWriteMode,strText) {'
			+ 'LODOP=getLodop(document.getElementById(\'LODOP_OB\'),document.getElementById(\'LODOP_EM\')); '
			+ 'var strFilename = prompt("请输入文件名","file1");if(strFilename==""||strFilename==null)return;'
			+ 'strFilename="C:/"+strFilename;if(strFilename.indexOf(".doc") == -1)strFilename+=".doc";'
			+ 'var strResult=LODOP.WRITE_FILE_TEXT(intWriteMode,strFilename,strText);'
			+ '	if (strResult=="ok") alert("导出成功！\\n文件为:"+strFilename);else alert("导出失败");'
			+ '};'
			+ '</script>',
			
        /**
         * @property headerTpl
         * @type {Object/Array} values The markup used to create
         *       the headings row. By default this just uses
         *       <th> elements, override to provide your own
         */
        headerTpl: ['<tpl for=".">', '<th>{text}</th>',
            '</tpl>'
        ],
        //基本信息
        baseInfoTpl: [
            '<table style="border-top:1px solid black;">',
			'<tr>',
			'<th colspan="8" class="columnHeader">一、基本信息</th>',
			'</tr>',
            '<tr align="center">',
            '<th width="47">姓名</th>',
            '<td width="148">{name}</td>',
            '<th width="53">性别</th>',
            '<td width="106">{sex}</td>',
            '<th width="52">民族</th>',
			'<td width="118">{ethnic}</td>',
			'<th width="67">出生日期</th>',
			'<td width="201">{dob}</td>',
            '</tr>',
            '</table>',
            '<table>',
    		'<tr align="center">',
    		'<th width="87">工号</th>',
    		'<td width="314">{empNo}</td>',
    		'<th width="142">身份证号码</th>',
    		'<td width="337">{idCard}</td>',
    		'</tr>',
    		'<tr align="center">',
    		'<th width="88">最高学历</th>',
    		'<td width="313">{lastEducation}</td>',
    		'<th width="142">最高学历获得机构</th>',
    		'<td width="337">{lastGraduateUnivercity}</td>',
    		'</tr>',
    		'<tr align="center">',
    		'<th width="87">最高学位</th>',
    		'<td width="312">{lastDegree}</td>',
    		'<th width="146">最高学位获得机构</th>',
    		'<td width="335">{lastDegreeOrg}</td>',
    		'</tr>',
    		'</table>',
    		'<table>',
    		'<tr align="center">',
    		'<th width="87">中共党员</th>',
    		'<td width="74"><tpl if="cpc == true">是</tpl>'+
    		'<tpl if="cpc == false">否</tpl></td>',
    		'<th width="77">入党日期</th>',
    		'<td width="152">{cpc_join_date}</td>',
    		'<th width="73">民主党派</th>',
    		'<td width="78">{democraticPartie}</td>',
    		'<th width="66">加入日期</th>',
    		'<td width="185">{dp_join_date}</td>',
    		'</tr>',
    		'</table>',
    		'<table>',
    		'<tr align="center">',
    		'<th width="101">参加工作年月</th>',
    		'<td width="159">{dateOfStartWork}</td>',
    		'<th width="96">本校入职日期</th>',
    		'<td width="128">{dateOfEntry}</td>',
    		'<th width="91">编制属性</th>',
    		'<td width="261" align="center">{quota_type}</td>',
    		'</tr>',
    		'</table>',
    		'<table>',
    		'<tr align="center">',
    		'<th width="80">所属部门</th>',
    		'<td width="307" align="center">{department}</td>',
    		'<th width="87">二级单位</th>',
    		'<td width="406" align="center">{sub_unit}</td>',
    		'</tr>',
    		'</table>',
    		'<table>',
    		'<tr align="center">',
    		'<th width="79">岗位类型</th>',
    		'<td width="167" align="center">{job_type}</td>',
    		'<th width="79">教师类型</th>',
    		'<td width="175" align="center">{teacher_type}</td>',
    		'<th width="120">专业技术职务</th>',
    		'<td width="209">{tech_post}</td>',
    		'</tr>',
    		'</table>',
    		'<table>',
    		'<tr align="center">',
    		'<th width="79">技术级别</th>',
    		'<td width="64">{tech_grade}</td>',
    		'<th width="70">管理职务</th>',
    		'<td width="183">{manage_post}</td>',
    		'<th width="62">职员职级</th>',
    		'<td width="102">{manage_grade}</td>',
    		'<th width="125">工勤技术等级</th>',
    		'<td width="107">{service_grade}</td>',
    		'</tr>',
    		'</table>'
        ],
        //联系方式
        contactTpl:[
			'<table>',
			'<tr>',
			'<th colspan="6" align="left">2、联系方式</th>',
			'</tr>',
			'<tr align="center">',
			'<th width="79">办公电话</th>',
			'<td width="240">{office_phone}</td>',
			'<th width="77">家庭电话</th>',
			'<td width="240">{home_phone}</td>',
			'<th width="76">移动电话</th>',
			'<td width="240">{mobile}</td>',
			'</tr>',
			'</table>',
			'<table>',
			'<tr align="center">',
			'<th width="138">紧急联系人及电话</th>',
			'<td width="366">{emergency_contact}&nbsp;{emergency_phone}</td>',
			'<th width="56">E-mail</th>',
			'<td width="320">{email}</td>',
			'</tr>',
			'</table>',
			'<table>',
			'<tr align="center">',
			'<th width="79">办公地址</th>',
			'<td width="845">{office_addr}</td>',
			'</tr>',
			'</table>',
			'<table>',
			'<tr align="center">',
			'<th width="80">家庭住址</th>',
			'<td width="844">{home_addr}</td>',
			'</tr>',
			'</table>'
        ],
        //教育背景
        familyHeader: '<table><tr><th colspan="6" class="columnHeader">二、主要家庭成员<span class="columnRemark">（包括配偶、子女、父母等）</span></th></tr>'
        	+'<tr align="center"><th width="67">姓名</th><th width="82">关系</th>'
        	+'<th width="126">出生年月</th><th width="284">工作单位</th>'
        	+'<th width="204">管理/技术职务</th><th width="73">学历</th></tr>',
        familyTpl: [
	        '<tr align="center">',
			'<td>{name}</td>',
			'<td>{relationship}</td>',
			'<td>{dateOfBirth}</td>',
			'<td>{employer}</td>',
			'<td>{post}</td>',
			'<td>{education}</td>',
			'</tr>'
        ],
        //教育背景
        educationBackgroundHeader:
        	'<table><tr><th colspan="9" class="columnHeader">三、学习经历<span class="columnRemark">（从大专开始填写，包括海外留学经历）</span></th></tr>'+
        	'<tr align="center"><th>起止年月</th><th>学校</th><th>院系</th><th>专业</th>'+
			'<th>学历</th><th>学位</th><th>学位日期</th><th>培养方式</th>'+
			'<th>备注</th></tr>',
        educationBackgroundTpl: [
			'<tr align="center">',
			'<td>{eb_from}-{eb_to}</td>',
			'<td>{university}</td>',
			'<td>{school}</td>',
			'<td>{major}</td>',
			'<td>{education}</td>',
			'<td>{degree}</td>',
			'<td>{issue_date}</td>',
			'<td>{train_type}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ],
        //工作经历
        workExpHeader: '<table><tr><th colspan="4" class="columnHeader">四、工作经历<span class="columnRemark">（包括博士后）</span></th>'+
        	'</tr><tr align="center"><th>起止年月</th><th>工作单位</th><th>管理/技术职务</th>'+
        	'<th>备注</th></tr>',
        workExpTpl: ['<tr align="center">',
			'<td>{we_from}-{we_to}</td>',
			'<td>{employer}</td>',
			'<td>{manage_post}/{tech_post}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ],
        //专业技术职务信息
        techPostHeader: '<table><tr><th colspan="5" class="columnHeader">五、专业技术职务信息<span class="columnRemark">（专业技术岗位人员填写）</span>'+
        	'</td></tr><tr><th align="center">专业技术职务</th><th align="center">技术级别</th><th align="center">聘任日期</th><th align="center">聘任单位</th>'+
        	'<th align="center">备注</th></tr>',
        techPostTpl: ['<tr align="center">',
			'<td>{post}</td>',
			'<td>{pat_class}</td>',
			'<td>{employDate}</td>',
			'<td>{employer}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ],
        //管理职务信息
        managePostHeader: '<table><tr><th colspan="6" class="columnHeader">六、管理职务信息<span class="columnRemark">（管理岗位人员填写）</span>'+
			'</th></tr><tr><th width="100" align="center">管理职务</th><th width="100" align="center">聘任日期</th><th width="100" align="center">职员级别</th>'+
			'<th width="150" align="center">级别聘任日期</th><th width="255" align="center">聘任单位</th><th width="131" align="center">备注</th></tr>',
        managePostTpl: ['<tr align="center">',
			'<td>{post}</td>',
			'<td>{postEmpDate}</td>',
			'<th align="center">{mng_grade}</th>',
			'<td>{gradeEmpDate}</td>',
			'<td>{employer}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ],
        //技术等级信息
        servicePostHeader: '<table><tr><th colspan="6" class="columnHeader">七、技术等级信息<span class="columnRemark">（工勤岗位人员填写）</span></th>'+
        	'</tr><tr><th width="100" align="center">岗位分类</th><th width="100" align="center">技术职务</th><th width="100" align="center">技术级别</th>'+
        	'<th width="150" align="center">聘任日期</th><th width="256" align="center">聘任单位</th><th width="130" align="center">备注</th></tr>',
        servicePostTpl: ['<tr align="center">',
			'<th align="center">{jobType}</th>',
			'<td>{techPost}</td>',
			'<td>{techGrade}</td>',
			'<td>{empDate}</td>',
			'<td>{employer}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ],

        //海外经历
        abroadHeader: '<table><tr><th colspan="6" class="columnHeader">八、海外经历</th></tr><tr>'+
			'<th width="140" align="center">留学起止年月</th><th width="109" align="center">留学国家</th>'+
        	'<th width="224" align="center">留学院校</th><th width="117" align="center">留学身份</th>'+
			'<th width="117" align="center">留学类别</th><th width="129" align="center">备注</th></tr>',
        abroadTpl: ['<tr align="center">',
			'<td>{ae_from}-{ae_to}</td>',
			'<td>{country}</td>',
			'<td>{university}</td>',
			'<td>{abroad_identity}</td>',
			'<td>{dispatch_type}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ],
        //获奖信息
        awardHeader: '<table><tr><th colspan="5" class="columnHeader">九、获奖信息</th>'+
        	'</tr><tr align="center"><th width="115">获奖日期</th><th width="441">奖项名称</th>'+
        	'<th width="161">奖项性质及等级</th><th width="131">奖项类别</th><th width="100">本人排名</th></tr>',
        awardTpl: ['<tr align="center">',
			'<td>{award_date}</td>',
			'<td>{award_name}</td>',
			'<td>{award_class}</td>',
			'<td>{award_order}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ],
        //优秀人才
        talentHeader: '<table><tr><th colspan="4" class="columnHeader">十一、优秀人才<span class="columnRemark">（包括导师信息、长江学者、宝钢奖获得者、政府特别津贴等）</span></th>'
        	+'</tr><tr align="center"><th width="219">起止日期</th><th width="217">学术名称</th>'
        	+'<th width="433">聘任单位</th><th width="83">备注</th></tr>',
        talentTpl: ['<tr align="center">',
			'<th>{rt_from}-{rt_to}</th>',
			'<td>{talentType}</td>',
			'<td>{grant_unit}</td>',
			'<td>{remark}</td>',
			'</tr>'
        ]
    }
});