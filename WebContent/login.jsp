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
	</head>

	<body>

		<div id="form-header" class="header">
			<div class="logo-con w clearfix">
				<a href="/" class="logo"><img src="style/img/logo.png" width="100px"/>
				</a>
				<div class="logo-title">欢迎登录</div>
				<div class="have-account">还没有账号？
					<a href="regist.jsp">请注册</a>
				</div>
			</div>

		</div>
		<div class="container w">

			<div class="main clearfix" id="form-main">
				<div class="reg-form ">
					<form action="" id="register-form" method="post" novalidate="novalidate">
						<input name="new" value="new_person_reg" type="hidden">
						
						<!--chrome autocomplete off bug hack-->
						<input style="display:none" name="hack">
						<input style="display:none" name="hack1" type="password">

						<div class="form-item form-item-account" id="form-item-account">
							<label>用　户　名</label>
							<input id="username" name="username" class="field" maxlength="20" placeholder="" type="text">
							<i class="i-status"></i>
						</div>
						<div class="input-tip">
							<span></span>
						</div>
						<div class="form-item">
							<label>设 置 密 码</label>

							<input name="password" id="password" class="field" maxlength="20" placeholder=" " default="<i class=i-def></i>建议使用字母、数字和符号两种及以上的组合，6-20个字符" type="password">
							<i class="i-status"></i>
							<div class="capslock-tip tips">大写已开启<b class="arrow"></b><b class="arrow-inner"></b></div>
							<div class="capslock-tip tips">大写已开启<b class="arrow"></b><b class="arrow-inner"></b></div>
						</div>
						<div class="input-tip">
							<span></span>
						</div>
						<div class="form-agreen">
							<div class="login_error">
								

							</div>
							<div class="input-tip">
								<span></span>
							</div>
						</div>
						<div>
							<button type="button" class="btn-register" onclick="login(this,'${param.url }')">登录</button>
						</div>

					</form>
				</div>
			</div>
		</div>
		<div id="form-footer" class="footer w">
			<div class="links">
				
				<a href="#" class=" ">首页</a>
				<span class="mod_copyright_split">|</span>
				
					<c:if test="${ login_user.username eq null}">
		             <a  class="   "style=""  href="javascript:window.location.href='login.jsp?url=member!info'" >会员中心</a>
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