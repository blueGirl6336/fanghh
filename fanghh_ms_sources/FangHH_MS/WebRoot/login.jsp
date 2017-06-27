<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>房合汇后台管理系统登陆</title>
   <!-- <link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>/favicon.ico" media="screen" /> -->
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/root.css">
	<script type="text/javascript">
		//刷新验证码
		function reloadImage(url){
			document.getElementById("codeImg").src= url+"?"+Math.random();
		}
	</script>
  </head>
  
  <body>	
    <div class="loginform">
    	<div class="title" style="z-index: 560;"></div>
        <div class="body" style="z-index: 550;">
       	  <form id="form1" name="form1" method="post" action="login">
          	<div class="log-lab">账&nbsp;&nbsp;&nbsp;&nbsp;号</div>
            <input name="user" type="text" class="login-input-user" id="user"  value="${username }">  <!-- ${username } -->
            <script type="text/javascript">
				document.getElementById("user").focus();
			</script>
          	<div class="log-lab">密&nbsp;&nbsp;&nbsp;&nbsp;码</div>
            <input name="pass" type="password" class="login-input-pass" id="pass"  value="${password}"> <!-- ${password} -->
<!--           	<div class="log-lab">验证码</div> -->
<!--             <input name="code" type="text" class="login-input-code"  id="code"/> -->
<!--             <a href="javascript:void();" onclick="reloadImage('verificationCode/randomImage.jsp')"> -->
<!--             	<img name="codeImg" id="codeImg" src="verificationCode/randomImage.jsp" -->
<!--             	style="border:none;margin:5px 0px;" align="top"/> -->
<!--             </a> -->
            <p class="error">${errorMessage}</p>
            <input type="submit" name="button" id="button" value="用户登录" class="button">
       	  </form>
        </div>
    </div>
</body>
</html>
