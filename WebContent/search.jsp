<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
	


   
	
	
	</head>
	<body class="index">
	<%@include file="/common/head.jsp"%>
	
	
	
  
  
  
		
		
		
		
	      
	      
  <div class="J_f J_sk need_ani sk" id="seckill" style="margin-top:10px">
	<div class="grid_c1 box sk_inner">
		<div class="box_hd clearfix" >
			<div class="box_hd_col1"><i class="box_hd_dec"></i><i class="box_hd_icon"></i>
				<h3 class="box_tit">搜索结果</h3>
			</div>
			<div class="box_hd_col2">
			</div>
		</div>
		<div class="box_bd clearfix">
			<div class="J_sk_list_wrapper sk_list_wrapper">
				<ul class="J_sk_list  clearfix" style="">

 <c:if test="${fn:length(goodsList) eq 0 }">
		 <center >
		 <h1 style="margin:100px 0;">没有找到相关的信息!</h1>
		 </center>
		 </c:if>

	       <%int i = 1; %>
		<c:forEach items="${goodsList}" var="s">
	      <%if(i<=4){ %>
 		  <%i++; %>
	<li class="J_sk_item sk_item ">
		<div class="sk_item_pic">
			<a href="site!goods?id=${s.id }" target="_blank" class="sk_item_pic_lk" >
			<img src="upload_image/${s.img }" alt="${s.name }" class="sk_item_img">
				<p class="sk_item_name">${s.name }</p>
			</a><span class="sk_item_shadow"></span></div>
		<p class="sk_item_price"><span class="mod_price sk_item_price_new"><i>¥</i><span>${s.price }</span></span>
		<span class="mod_price sk_item_price_origin"><i>¥</i><del>${s.price }</del></span></p>
	</li>
	       <%} %>
	      </c:forEach>
	
</ul>
			</div>
		</div>
	</div>
</div>
	      
		
		
		
  
  
  
  
  
  
 


<%@include file="/common/foot.jsp"%>
	</body>
</html>
