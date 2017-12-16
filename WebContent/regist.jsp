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
	<link href="style/css/pintuer.css" rel="stylesheet" type="text/css" />
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
					
					
					
					
					
<form id="registform" class="registform" method="post" action="member!add3" onsubmit="return formcheck(this)">
<input class="input" id="role" value="2" name="roles" size="30"  type="hidden">
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-user"></span>
      <input class="input" id="username" name="username" size="30"  data-validate="required:必填,length#>=4:4-20位字符,length#<=20:4-20位字符,username:英文字母开头的字母、下划线、数字组合,ajax#user!approvalusername?username=:用户已注册" placeholder="请输入账号" type="text">

      <div class="input-note ">4-20位字符，英文字母开头的字母、下划线、数字组合</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-key"></span>
      <input class="input" id="password1" name="password" size="30"  data-validate-id="regist-password" data-validate="required:必填,length#>=6:6-20位字符,length#<=20:4-20位字符" placeholder="请设置密码" type="password">

      <div class="input-note">6-20位字符，可使用字母数字或符号的组合，不建议使用纯数字，纯字母，纯符号</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-key"></span>
      <input class="input" id="repassword" name="repassword" size="30" data-validate="required:必填,repeat#password1:两次输入的密码不一致" placeholder="请确认密码" type="password">
      <div class="input-note">请再次输入密码。</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-user"></span>
      <input class="input" id="name" name="name" size="30" data-validate="required:必填" placeholder="姓名" type="text">
      <div class="input-note">姓名</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-user"></span>
      <input class="input" id="sex" name="sex" size="30" data-validate="required:必填" placeholder="性别" type="text">
      <div class="input-note">性别</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-mobile-phone"></span>
      <input class="input" id="tel" name="tel" size="30" data-validate="required:必填" placeholder="验证手机" type="text">
      <div class="input-note">完成验证后您可使用手机号找回密码</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-map-marker"></span>
      <input class="input" id="address" name="address" size="30" data-validate="required:必填" placeholder="地址" type="text">
      <div class="input-note">地址</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-envelope"></span>
      <input class="input" id="email" name="email" size="30" data-validate="required:必填" placeholder="邮箱" type="text">
      <div class="input-note">邮箱</div>
    </div>
  </div>
  
  <div id="" class="xl12"style="margin:0;float:right">
	<a href="#" style="margin:0 10px;float:right"></a>
  </div>
  <span class="clr"></span>


<button type="submit" class="btn-register"onclick="$('form[class=registform]').submit()" >立即注册</button>
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