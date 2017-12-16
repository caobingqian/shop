<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
request.setAttribute("isSupportCheckCode",config.getServletContext().getInitParameter("isSupportCheckCode").equals("1")?true:false);
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="#" type="image/png">

     <!-- CSS -->
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/supersized.css">
        <link rel="stylesheet" href="css/login.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="js/html5.js"></script>
        <![endif]-->

    <script  src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	if(window.parent!=window){
		window.parent.location=window.location;
	}
			$(document).ready(function(){
			    $(".sysName").load("sysName.txt",function(data,x){
			    	document.title=data;
			    });	
			});
	</script>
    </head>

    <body>

        <div class="page-container">
            <h1> <b class="sysName loginsysname"></b>   登录(Login)</h1>
            <form id="login" class="form-signin" action="login.do"  method="post">
                
                
            <input type="text" class="form-control" placeholder="用户名"name="username" >
            <input type="password" class="form-control" placeholder="密码" name="password" >
            
			  <c:if test="${isSupportCheckCode}">
			      <div class="chknumber">
			        <label>验证码：
			        <input name="code" type="text" id="chknumber" maxlength="4" class="chknumber_input" />
			        </label>
			  <script>
			  	function reloadImg(){
			  		document.getElementById("safecode").src="CheckCode.jpg?x="+Math.random();
			  	}
			  </script>
		        <img src="CheckCode.jpg" id="safecode" onclick="reloadImg();"/>
		      </div>
		      </c:if>
              <button type="submit" class="btn-register">登录</button>
		      
		      
		      
            </form>
            <div class="connect">
                <p>${login_error}</p>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="js/jquery-1.8.2.min.js" ></script>
        <script src="js/supersized.3.2.7.min.js" ></script>
        <script src="js/supersized-init.js" ></script>
        <script src="js/loginscripts.js" ></script>

    </body>
<div style="text-align:center;">
</div>
</html>
