<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><atitle></atitle></title>
    <link rel="shortcut icon" href="style/img/logo.png" />
	 <script src="style/js/jquery.js"></script>
    <script src="style/js/jquery.lazyload.min.js"></script>
	<script src="style/js/jquery.easing.min.js"></script>
    <script src="style/js/pintuer.js"></script>


    <script src="style/js/respond.js"></script>
	<link href="style/css/login.css" rel="stylesheet" type="text/css" />
	<link href="style/css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<div id="form-header" class="header">
			<div class="logo-con w clearfix">
				<a href="/" class="logo"><img src="style/img/logo.png" width="100px"/>
				</a>
				<div class="logo-title">欢迎注册</div>
				<div class="have-account">已经有账号了？
					<a href="login.jsp">去登录</a>
				</div>
			</div>

		</div>
		<div class="container w">

			<div class="main clearfix" id="form-main">
				<div class="reg-form ">
				
				
				<div class="loginsuccess" style="color:#ee2222;">注册成功！
				<br/>
				<br/>
				<br/>
				<br/>
<button type="submit" class="btn-register" onclick="window.location.href='login.jsp'">去登录</button>
</div>
				
				
				</div>
			</div>
		</div>
		<div id="form-footer" class="footer w">
			<div class="links">
				
				<a href="#" class=" ">首页</a>
				<span class="mod_copyright_split">|</span>
				
					<c:if test="${ login_user.username eq null}">
		             <a  class="   "style=""  href="login.jsp" >会员中心</a>
					</c:if>
					<c:if test="${ login_user.username ne null}">
           				 <a href="member!info"class=" ">会员中心</a>
					</c:if>

				<span class="mod_copyright_split">|</span>

				 <a href="/houtai" target="_blank" class=" ">后台管理</a>
				
				
				
			</div>
			<div class="copyright">
				毕业设计 &copy; <a href="#" target="_blank"><atitle></atitle>的设计与实现</a> All Rights Reserved
			</div>
		</div>

		<script type="text/javascript">
			$(function() {
				getJdEid(function(eid, fpid) {
					$("#eid").val(eid);
					$("#sessionId").val(fpid);
				});
			});
		</script>

	</body>

</html>