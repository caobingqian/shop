<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html ">
<html>
<head>
<base href="<%=basePath%>">
<title></title>
<meta name="description" content="">
<meta name="Keywords" content="">


</head>

<body>

<%@include file="/common/head.jsp"%>

  	
	<!--内容-->
<div id="navx3" class="" >
<div class="loginsuccess"style="color:#ee2222;">
购买成功！<br/>
<button class="btn-register" onclick="window.location.href='/'"style="width:150px;">继续购物</button>
<button class="btn-register" onclick="window.location.href='/member.jsp'"style="width:150px;">去会员中心查看</button>
</div>
</div>
<%@include file="/common/foot.jsp"%>
</body>
</html>
<!--index_ok-->
