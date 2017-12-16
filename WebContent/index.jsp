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
	
	
	
  
  
  
  <div class="J_f J_sk need_ani " id="seckill" >
	<div class="grid_c1 box sk_inner">
		<div class=" clearfix" >
	<!--banner-->
    <div class="banner" data-style="border-white" >
      <div class="carousel">
        <div class="item"><a href="javascript:void(0)" ><img src="/style/images/banner1.jpg" width="100%" /></a></div>
        <div class="item"><a href="javascript:void(0)" ><img src="/style/images/banner2.jpg" width="100%" /></a></div>
        <div class="item"><a href="javascript:void(0)" ><img src="/style/images/banner3.jpg" width="100%" /></a></div>
      </div>
	  <div id="close-banner" class="pager-close close border-white"></div>
    </div>
		
		</div></div></div>
		
		
		
		
   <c:forEach items="${goodsClassifyList}" var="g">
      <c:if test="${fn:length(g.goods) ne 0 }">
	      
	      
  <div class="J_f J_sk need_ani sk" id="seckill" style="margin-top:10px">
	<div class="grid_c1 box sk_inner">
		<div class="box_hd clearfix" >
			<div class="box_hd_col1"><i class="box_hd_dec"></i><i class="box_hd_icon"></i>
				<h3 class="box_tit">${g.name}</h3>
				<a href="site!goodsClassify?id=${g.id }" target="_blank" class="box_subtit">总有你想不到的<i class="box_subtit_arrow"></i></a>
			</div>
			<div class="box_hd_col2">
			</div>
		</div>
		<div class="box_bd clearfix">
			<div class="J_sk_list_wrapper sk_list_wrapper">
				<ul class="J_sk_list  clearfix" style="">



	       <%int i = 1; %>
		<c:forEach items="${g.goods}" var="s">
	      <%if(i<=400){ %>
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
				<div class="J_sk_controls sk_controls" style="display: none;">
					<a href="javascript:void(0)" clstag="h|keycount|2016|13d01" class="J_sk_control_prev sk_controls_item sk_controls_prev"><i class="iconfont"></i></a>
					<a href="javascript:void(0)" clstag="h|keycount|2016|13d02" class="J_sk_control_next sk_controls_item sk_controls_next"><i class="iconfont"></i></a>
				</div>
				<div class="sk_split"></div>
			</div>
		</div>
	</div>
</div>
	      
	  </c:if></c:forEach> 
		
		
		
  
  
  
  
  
  
 


<%@include file="/common/foot.jsp"%>
	</body>
</html>
