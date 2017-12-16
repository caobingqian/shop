<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>添加商品分类成功</title>
<link href="css/style_add.css" rel="stylesheet">
<style type="text/css">
</style>
</head>
<body>
<div id="formwrapper">
<c:if test="${login_user eq null}">
	<h3 class="add_title1">注册商品分类成功</h3>
	<div class="enter">
	    <input name="addGoodsClassify" type="button" class="button_add_modify"  value="登录" onclick="window.location = 'login.jsp'"/>
</c:if>
<c:if test="${login_user ne null}">
	<h3 class="add_title1">添加商品分类成功</h3>
	<div class="enter">
	    <input name="addGoodsClassify" type="button" class="button_add_modify"  value="继续添加" onclick="window.location = 'goodsClassify!addInput'"/>
	    <input name="return" type="button" class="button_add_modify"  value="返回" onclick="window.history.go(-1)"/>
</c:if>
	</div>
</div>

</body>
</html>

