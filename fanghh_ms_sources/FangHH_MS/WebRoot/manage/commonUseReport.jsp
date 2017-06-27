<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	ResourceBundle res = ResourceBundle.getBundle("staticServer");
	String filePath = res.getString("server") + "/hrms";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">


<title>${report.reportName}</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">



<!-- Ext JS Files -->
<script type="text/javascript"
	src="<%=filePath%>/ext-4.2/examples/shared/include-ext.js"></script>


<!-- Ext Language File -->
<script type="text/javascript"
	src="<%=filePath%>/ext-4.2/locale/ext-lang-zh_CN.js"></script>
	
<script type="text/javascript"
	src="<%=basePath%>/manage/app/customize/CommonUseTabelGridColumn.js"></script>
	
<script type="text/javascript"
	src="<%=basePath%>manage/js/HashMap.js"></script>
	<script type="text/javascript"
	src="<%=basePath%>manage/js/InitSortMap.js"></script>

<style type="text/css">

#commonUseTableContainer {
	margin-left: auto;
	margin-right: auto;
	width: 100%;
	height:100%;
	position: absolute;
	bottom:0px;
}	
</style>

<script type="text/javascript">

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
			
			if(constantMap.containsKey(v1)){
				v1 = constantMap.get(v1);
			}
			if(constantMap.containsKey(v2)){
				v2 = constantMap.get(v2);
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

</script>

</head>

<body>

	<div id="commonUseTableContainer"></div>


	<script type="text/javascript" charset="utf-8">
	Ext.Loader.setConfig({
	    enabled: true
	});

	Ext.Loader.setPath('Ext.ux', '<%=filePath%>/ext-4.2/ux/');

	Ext.require(['Ext.data.*', 'Ext.grid.*', 'Ext.util.*',
	    'Ext.toolbar.*', 'Ext.ux.BoxReorderer'
	]);

// 	function showPersonDetail() {
// 	    var records = this.getSelectionModel().getSelection();
// 	    var length = records.length;
// 	    if (length == 0)
// 	        return;
// 	    var empNoArrary = new Array(length);
// 	    for (var i = 0; i < length; i++) {
// 	        empNoArrary[i] = records[i].data.empNo;
// 	    }
// 	    var form = document.createElement("form");
// 	    form.setAttribute("method", "post");
// 	    form.setAttribute("action", "<%=basePath%>manage/report/resume/personDetailInfo");
// 	    form.setAttribute("target", "_blank");

// 	    for (var i = 0; i < length; i++) {
// 	        var input = document.createElement('input');
// 	        input.type = 'hidden';
// 	        input.name = 'empNoArr';
// 	        input.value = records[i].data.empNo;
// 	        form.appendChild(input);
// 	    }
// 	    document.body.appendChild(form);
// 	    window.open('about:blank', name);
// 	    form.submit();
// 	    document.body.removeChild(form);
// 	}

	Ext.onReady(function () {

	    // create the data store
	    Ext.define('reportTableModel', {
	        extend: 'Ext.data.Model',
	        fields: [ 
	        	<c:forEach 	var = "column"  items = "${columns}"   varStatus = "status" > 
	        	{
	                name: '${column.dataIndex}'
	            } <c:if test = "${!status.last}" > , </c:if>
				</c:forEach >
	        ]
	    });

	    var store = Ext.create('Ext.data.Store', {
	        model: 'reportTableModel',
	        proxy: {
	            type: 'ajax',
	            url: 'manage/report/table/commonUseTable/data/${report.reportCode}',
	            reader: {
	                type: 'json',
	                root: 'data',
	                successProperty: 'success'
	            }
	        },
	        autoLoad: true
	    });

	    // create the Grid
	    var grid = Ext.create('Ext.grid.Panel', {
	        store: store,
	        title: '<font style=\'font-size:19px\'>${report.reportName}</font>',
	        titleAlign: 'center',
	        scroll: true,
	        layout: 'fit',
	        height: '100%',
	        padding: 0,
	        width: '100%',
	        columns: [{
	                xtype: 'rownumberer',
	                width: 60,
	                align: 'center',
	                text: '序号'
	            }, 
	            <c:forEach var = "column"  items = "${columns}" varStatus="status"> {
	                xtype: 'tableColumn',
	                dataIndex: '${column.dataIndex}',
	                <c:if test = "${column.lock != null}">
	                locked: true,
	                </c:if>
						<c:if test="${column.width != null}">
						width : ${column.width},
						</c:if >
	                text: '${column.name}'
	            } <c:if test = "${!status.last}" > , </c:if>
				</c:forEach>
	        ],
	        dockedItems: [{
	            xtype: 'toolbar',
	            dock: 'top',
	            defaults: {
	                labelWidth: 30,
	                padding: '0 4 1 4'
	            },
	            items: [{
	                xtype: 'button',
	                text: '导出成Excel',
	                listeners: {
	                    click: {
	                        fn: function () {
	                            location.href = '<%=basePath %>manage/report/table/commonUseTable/download/${report.reportCode}';
	                        }
	                    }
	                }
	            }]
	        }],
	        renderTo: 'commonUseTableContainer'
	    });
 			//this.addListener('itemdblclick', this.showPersonDetail, this);
 	    grid.addListener('itemdblclick', showPersonDetail, grid);
 	    
 	    function showPersonDetail(){
	       	var records = this.getSelectionModel().getSelection();
	        var length = records.length;
	        if (length == 0)
	            return;
	        var empNoArrary = new Array(length);
	        for (var i = 0; i < length; i++) {
	            empNoArrary[i] = records[i].data.ext1;
	        }
	        var form = document.createElement("form");
	        form.setAttribute("method", "post");
	        form.setAttribute("action", "<%=basePath %>report/resume/personDetailInfo");
	        form.setAttribute("target", "_blank");
	
	        for (var i = 0; i < length; i++) {
	            var input = document.createElement('input');
	            input.type = 'hidden';
	            input.name = 'empNoArr';
	            input.value = records[i].data.ext1;
	            form.appendChild(input);
	        }
	        document.body.appendChild(form);
	        //window.open('about:blank', name);
	        form.submit();
	        document.body.removeChild(form);	
  		};
	});
		
	</script>


</body>
</html>
