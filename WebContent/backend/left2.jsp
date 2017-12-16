<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title></title>

<link href="css/style_nav.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/left.js"></script>
<style type="text/css">
<!--

-->
</style>
</head>
<body>
<div  style="height:100%;">
  <ul id="navigation">

	<li> <a class="head"><i class="mb-head-icon"></i>账户中心</a>
      <ul>
        <li><a href="member.do" target="rightFrame"><i class="mb-list-icon"></i>我的个人信息</a></li>
        <li><a href="sys/update_password.jsp" target="rightFrame"><i class="mb-list-icon"></i>修改个人密码</a></li>
      </ul>
    </li>




	<li> <a class="head"><i class="mb-head-icon"></i>我的订单</a>
      <ul>
        <li><a href="orders.do" target="rightFrame"><i class="mb-list-icon"></i>查看订单信息</a></li>
      </ul>
    </li>

	<li> <a class="head"><i class="mb-head-icon"></i>我的评论</a>
      <ul>
        <li><a href="comments.do" target="rightFrame"><i class="mb-list-icon"></i>查看评论信息</a></li>
      </ul>
    </li>


  </ul>
</div>
</body>
</html>

