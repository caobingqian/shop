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
	
	
	
  
  
  
		
		
		
		
	      
	      
  <div class="J_f J_sk need_ani sk" id="seckill" style="margin-top:10px;">
	<div class="grid_c1 box sk_inner" style="width:1000px;">
		<div class="box_bd clearfix"style="margin:0px;padding:0px;width:1000px;">
			<div class="J_sk_list_wrapper sk_list_wrapper goodshead"style="margin:0px;padding:0px;text-align: left;width:950px;">
			
			<div class="xl4"><img src="upload_image/${goods.img }" width="300px"/></div>
			<div class="xl8">
			<div class="xl12"> <div class="xl2 titname">商品名称：</div><div class="xl9 titcontent"> ${goods.name } </div> </div>
			<div class="xl12"> <div class="xl2 titname">简介：</div><div class="xl9 titcontent"> ${goods.descp } </div> </div>
			<div class="xl12"> <div class="xl2 titname">类别：</div><div class="xl9 titcontent"> ${goods.goodsClassify.name } </div> </div>
			<div class="xl12"> <div class="xl2 titpricename">价格：</div><div class="xl9 titprice">￥${goods.price }元</div> </div>
			<div class="xl12"> <div class="xl2 titname">上架时间：</div><div class="xl9 titcontent"> ${goods.settime } </div> </div>
			<div class="xl12">
				<a href="javascript:shoppingAdd('${goods.id}',1,0)"  class="btn-special1 btn-lg" style="color:#fff;" >加入购物车</a>
 			</div>
			</div>
			</div>
		</div>
	</div>
</div>



  <div class="J_f J_sk need_ani sk" id="seckill" style="margin-top:10px;">
	<div class="grid_c1 box sk_inner" style="width:1000px;">
		<div class="box_hd clearfix" style="height:40px;width:1000px;">
			<div class="box_hd_col1"><i class="box_hd_dec"></i>
				<h3 class="" style="font:100 16px/40px yahei;">商品详情       Goods detail</h3>
			</div>
			<div class="box_hd_col2">
			</div>
		</div>
		<div class="box_bd clearfix">
${goods.content}
		</div>
	</div>
</div>
  <div class="J_f J_sk need_ani sk" id="seckill" style="margin-top:10px;">
	<div class="grid_c1 box sk_inner" style="width:1000px;">
		<div class="box_hd clearfix" style="height:40px;width:1000px;">
			<div class="box_hd_col1"><i class="box_hd_dec"></i>
				<h3 class="" style="font:100 16px/40px yahei;">商品评价  User reputation</h3>
			</div>
			<div class="box_hd_col2">
			</div>
		</div>
		<div class="box_bd clearfix"style="padding:20px;">

				<form method="post" action="comments!add1" class="goodsadd"> 
				 <input type="hidden" name="goods" value="${goods.id }"/>
				 <input type="hidden" name="url" value=""/>
				  <div class="form-group"> 
					<div class="label">
					 <label for="content"style="font:600 25px/40px yahei;">发布评价</label>
					</div> 
					<div class="field"> 
					 <textarea  class="input" name="content" rows="5" cols="50" placeholder=""></textarea> 
				   <div class="imginsert" >
				   </div> 
					</div> 
				   </div> 
				   
				   <div class="form-button">
				    <c:if test="${ login_user.username eq null}">
		                 <a  style="float:right;color:#fff;"class="btn-special1 btn-lg"  href="javascript:window.location.href='login.jsp?url='+document.URL" >提交</a>
					</c:if>
					<c:if test="${ login_user.username ne null}">
					<span  style="float:right;color:#fff;"class="btn-special1 btn-lg"  onclick="$('form[class=goodsadd]').submit()">提交</span>
					</c:if>
				   </div> 
				  </form>

		      </div>
		<div class="box_bd clearfix"style="padding:20px;">
		       <c:forEach items="${goods.comments}" var="s">
		      <div class=" xl12 " style="padding:20px;width:930px ">
		      <div class=" xl2 " style="margin:10px ;font:100 16px/40px yahei;">${s.member.name }(评价人)：</div>
		      <div class=" xl8 " style="margin:10px;padding:20px;min-height:60px;background-color:#f6f6f6">	${s.content }</div>
		      <div class=" xl11 " style="padding:0 50px;text-align:right">	${s.settime }</div>
		      
		      	<span style="clear:both"></span>
			      <div class="  " style="float:right"><br>
			      	
			      </div>
		      </div>
		       </c:forEach>
		</div>
	</div>
</div>
	      
		
  
  
  
  
  
  
 


<%@include file="/common/foot.jsp"%>
	</body>
</html>
