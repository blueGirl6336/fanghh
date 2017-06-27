<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=utf-8"
	import="java.util.ResourceBundle"%>
<%
	ResourceBundle res = ResourceBundle.getBundle("staticServer");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String filePath = res.getString("server") + "/fanghh_ms";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>manage/" />
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>/favicon.ico" media="screen" />
<title>房合汇后台管理系统</title>

<!-- Ext JS Files -->
<script type="text/javascript" src="<%=filePath%>/ext-4.2/ext-all.js"></script>

<script type="text/javascript">
	
</script>
<script type="text/javascript" src="<%=filePath%>/js/jquery-1.7.1.min.js"></script>


<!-- Ext Language File -->
<script type="text/javascript"
	src="<%=filePath%>/ext-4.2/locale/ext-lang-zh_CN.js"></script>

<!-- Using Naptune Theme  -->
<script src="../ext-4.2/ext-theme-neptune.js"></script>
<link rel="stylesheet"
	href="../ext-4.2/resources/ext-theme-neptune/ext-theme-neptune-all.css" />
<%-- <link rel="stylesheet"
	href="<%=filePath%>/ext-4.2/resources/ext-theme-classic/ext-theme-classic-all.css" /> --%>


<link rel="stylesheet" href="css/manage.css" />
<link rel="stylesheet" href="css/reportTable.css" />
<!-- App Files -->
<script type="text/javascript" src="app/hrmsApp.js"></script>

</head>
<body>
	<input type="hidden" id="loginUserName" value="${user.username}" />
	<%-- <input type="hidden" id="loginUserRealName" value="${user.realName}" />
	<input type="hidden" id="loginUserRoleName" value="${user.roleName}" /> --%>
	<input type="hidden" id="loginUserEmpNo" value="${user.phoneNo}" />

</body>

</html>