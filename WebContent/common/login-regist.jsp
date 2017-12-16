<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	
<div id="login"> <div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>登陆</strong> </div>
<div class="dialog-body"> 
<form id="loginform" class="loginform" method="post" action="login!loginf" >
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-user"></span>
      <input class="input" id="username" name="username"  size="30" placeholder="请输入账号" type="text">

      <div class="input-note ">登录账号包含手机、邮箱和会员号。</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-key"></span>
      <input class="input" id="password" name="password" size="30" placeholder="请输入密码" type="password">

      <div class="input-note">登录会员的密码口令。</div>
    </div>
  </div>
  <div class="login-help">
  <ul><li></li></ul>
  </div>
  <div id="" class="xl12"style="margin:0;float:right">
	<a href="#" style="margin:0 10px;float:right">还没有账号？</a><a href="#" style="margin:0;float:right">找回密码</a>
  </div>
  <span class="clr"></span>
</form>
</div> 
<div class="dialog-foot"> <button class="button bg-green buttonLogin" onclick="login(this)">登陆</button> <button class="button dialog-close">取消</button> </div> </div> </div>


<div id="regist" > <div class="dialog"> 
<div class="dialog-head"><span class="close rotate-hover"></span>
<strong>注册</strong> 
</div>
<div class="dialog-body"> 
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

</form>
</div> 
<div class="dialog-foot"> <button class="button bg-green" onclick="$('form[class=registform]').submit()" >立即注册</button> <button class="button dialog-close">取消</button> </div> </div> </div>




<div id="loginm"> <div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>登陆</strong> </div>
<div class="dialog-body"> 
<form id="loginform" class="loginform" method="post" action="login!loginf" >
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-user"></span>
      <input class="input" id="username" name="username"  size="30" placeholder="请输入账号" type="text">

      <div class="input-note ">登录账号包含手机、邮箱和会员号。</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-key"></span>
      <input class="input" id="password" name="password" size="30" placeholder="请输入密码" type="password">

      <div class="input-note">登录会员的密码口令。</div>
    </div>
  </div>
  <div class="login-help">
  <ul><li></li></ul>
  </div>
  <div id="" class="xl12"style="margin:0;float:right">
	<a href="#" style="margin:0 10px;float:right">还没有账号？</a><a href="#" style="margin:0;float:right">找回密码</a>
  </div>
  <span class="clr"></span>
</form>
</div> 
<div class="dialog-foot"> <button class="button bg-green" onclick="login(this)">登陆</button> <button class="button dialog-close">取消</button> </div> </div> </div>

<div id="registm" class="registm"> <div class="dialog"> 
<div class="dialog-head"><span class="close rotate-hover"></span>
<strong>注册</strong> 
</div>
<div class="dialog-body scroll-dialog-body"> 
<form id="registform" class="registform" method="post" action="BuyerServlet?method=add1" onsubmit="return formcheck(this)">
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
      <input class="input" id="password2" name="password" size="30"  data-validate-id="regist-password" data-validate="required:必填,length#>=6:6-20位字符,length#<=20:4-20位字符" placeholder="请设置密码" type="password">

      <div class="input-note">6-20位字符，可使用字母数字或符号的组合，不建议使用纯数字，纯字母，纯符号</div>
    </div>
  </div>
  <div class="form-group">
    <div class="field field-icon">
	  <span class="icon icon-key"></span>
      <input class="input" id="repassword" name="repassword" size="30" data-validate="required:必填,repeat#password2:两次输入的密码不一致" placeholder="请确认密码" type="password">
      <div class="input-note">请再次输入密码。</div>
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
	  <span class="icon icon-barcode"></span>
      <input class="input input-auto" id="message" name="message" size="15"  data-validate="required:必填,length#==6:请正确输入6位短信验证码" placeholder="短信验证码" type="text">
	  <span class="button asksubmit"  onclick="">获取短信验证码</span>
      <div class="input-note">登录会员的密码口令。</div>
    </div>
  </div>
  <div id="" class="xl12"style="margin:0;float:right">
	<a href="#" style="margin:0 10px;float:right"></a>
  </div>
  <span class="clr"></span>

</form>
</div> 
<div class="dialog-foot"> <button class="button bg-green" onclick="$('form[class=registform]').submit()" >立即注册</button> <button class="button dialog-close">取消</button> </div> </div> </div>
	


