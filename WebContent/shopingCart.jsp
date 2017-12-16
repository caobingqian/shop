<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="Expires" CONTENT="-1">           
<meta http-equiv="Cache-Control" CONTENT="no-cache">           
<meta http-equiv="Pragma" CONTENT="no-cache">           
<title></title>
<meta name="description" content="">
<meta name="Keywords" content="">


</head>

<body>

<%@include file="/common/head.jsp"%>



	<!--内容-->
<div id="navx3" class="" >
<div class="container">
     
      <div class="line-middle bg-white">
      <div class="shoppingcartc ">
       	<div class="xl12 xs12 xm10 xm1-left">
        <div class="xl12 " style="margin:25px 0 0px;">
			我的购物车
		</div>
        <div class="xl12 " style="margin:40px auto 30px;font-size:13px;">
			<div class="step"> 
			<div class="step-bar active" style="width:33%;"><span class="step-point">1</span><span class="step-text">1.我的购物车</span></div>
			 <div class="step-bar " style="width:33%;"><span class="step-point">2</span><span class="step-text">2.填写核对订单信息</span></div> 
			 <div class="step-bar" style="width:33%;"><span class="step-point">3</span><span class="step-text">3.成功提交订单</span></div> 
		    </div>
		</div>
		</div>
		<c:if test="${ empty shoppingCarts }">
        <div class="xl12" style="margin:0;padding:0px;font-size:13px;">
			<div class="cart-inner cart-empty">
		    <div class="message">
		        <p>购物车内暂时没有商品!<br/>您可以<a href="/">去首页</a>挑选喜欢的商品</p>
		    </div>
			</div>
		</div>
		</c:if>
		<c:if test="${ not empty shoppingCarts }">
        <div class="xl12 xs12 xm10 xm1-left  shoppinghead" style="margin:0;padding:0px;font-size:13px;">
			<div class="xl5 " style="padding-left:0px;padding-right:0px;"><span class="shoppingcheck"><input type="checkbox" name="">全选</span>商品 </div> 
			<div class="xl2 "  style="padding-left:0px;padding-right:0px;"> 价格 </div> 
			<div class="xl3 "  style="padding-left:0px;padding-right:0px;"> 数量 </div>
			 <div class="xl2 "  style="padding-left:0px;padding-right:0px;"> 操作 </div>
		</div>
		<c:forEach items="${shoppingCarts}" var="s">
        <div class="xl12 xs12 xm10 xm1-left shoppingbody" style="padding:10px 0px">
			<div class="xl5 "  style="padding-left:0px;padding-right:0px;">
			<span class="shoppingbodycheck"><input type="checkbox" name=""></span>
			<img src="upload_image/${s.goods.img }" style="float:left" width="50"height="50" border="0" alt="">
			${s.goods.name }
			<span class="clr"></span>
			</div>
			 <div class="xl2 shoppingprice" style="padding-left:0;padding-right:0;"> ￥${s.goods.price } </div> 
			 <div class="xl3 " style="padding-left:0;padding-right:0;padding-bottom:0;">
			 	<div id="choose-amount" > 
				 <div class="wrap-input"> 
				  ${s.num }
				</div> 
			 </div> 
			 </div> <div class="xl2 "  style="padding-left:0px;padding-right:0px;"><a href="javascript:shoppingdelete('${s.goods.id }')">[删除]</a></div>
			 <span class="clr"></span>
		</div>
		</c:forEach>
		<div class="xl12 xs12 xm10 xm1-left shoppingbody" style="padding:0px;border-bottom:0;">
		<div class="" style="width:150px;float:right;padding:10px 10px">
			<div class=""  style="float:left">
			总计：
			</div>
			<div class="" style="float:right" >
			 ￥ ${prices } 
			</div>
		</div>
		<div class=" " style="width:80px;float:right">
			<div class=""  style="float:right">
				<span style="color:#E4393C"> ${count } </span>件商品 
			</div>
		</div>
		</div>
		<div class="xl12 xs12 xm10 xm1-left shoppingfoot" style="padding:0px">
		<div class="" style="width:135px;float:right;padding:0">
			<c:if test="${ login_user.username eq null}">
			<div class="cart-button"style="padding:0">
			<a href="javascript:window.location.href='login.jsp?url='+document.URL" class=""></a>
			</div>
			</c:if>
			<c:if test="${ login_user.username ne null}">
			<div class="cart-button"style="padding:0">
                 <a  href="orders!add1" ></a>
			</div>
			</c:if>
		</div>
		<div class=" " style="float:right;padding:5px 10px 0 0">
			<div class=""  style="float:right;line-height:20px">
				总计：<span style="color:#E4393C;font-size:20px;"> ￥ ${prices } </span>
			</div>
		</div>
		</div>
		</c:if>
		<span class="clr"></span>
	</div>
	
	</div>
</div>

</div>

<%@include file="/common/foot.jsp"%>
</body>
</html>
<!--index_ok-->
