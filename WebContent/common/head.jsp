<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



	<!--顶部-->
<link rel="shortcut icon" href="style/img/logo.png" />

	
	<link  href="style/css/pintuer.css" rel="stylesheet" type="text/css"/>
	<link  href="style/css/main.css" rel="stylesheet" type="text/css"/>
	<link  href="style/css/new_file.css" rel="stylesheet" type="text/css"/>

<link  href="style/css/shoppingcart.css" rel="stylesheet" type="text/css"/>
<link  href="style/css/style.css" rel="stylesheet" type="text/css"/>
    
 <script src="style/js/jquery.js"></script>
    <script src="style/js/jquery.lazyload.min.js"></script>
	<script src="style/js/jquery.easing.min.js"></script>
    <script src="style/js/pintuer.js"></script>


    <script src="style/js/respond.js"></script>



				<form action="site!search" method="post" name="store_search" id="storeSearch" onSubmit="" >
				<input type="hidden" name="searchid" id="searchid" value=""/>
				<input type="hidden" name="str" id="str" value=""/>
				</form>





<%--头行--%>
<div id="shortcut">
<div class="w">
	<ul class="fl" >
		<li class="dorpdown" id="ttbar-mycity">
			<div class="dt cw-icon ui-areamini-text-wrap" style=""><i class="iconfont"></i> <i class="ci-right"><s>◇</s></i> <i class="ci-left"></i> <span class="ui-areamini-text" data-id="1" title="北京">北京</span> </div>
			<div class="dd dorpdown-layer">
				<div class="dd-spacer"></div>
				<div class="ui-areamini-content-wrap" style="left: auto;">
					<div class="ui-areamini-content">
						<div class="ui-areamini-content-list">
							<div class="item">
								<a data-id="1" href="javascript:void(0)" class="selected">北京</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</li>
	</ul>

	<ul class="fr">
	    <c:if test="${ login_user.username eq null}">
		<li class="fore1 icon-plus-state0" id="ttbar-login" >
			<a href="javascript:window.location.href='login.jsp?url='+document.URL" class="link-login style-red">你好，请登录</a>
		</li>
			<li class="spacer"></li>
		<li class="fore2 icon-plus-state0" id="ttbar-login" >
			&nbsp;&nbsp;<a href="regist.jsp" class="link-regist">免费注册</a>
		</li>
		  </c:if>
		  <c:if test="${ login_user.username ne null}">
			<li class="fore1 icon-plus-state0" id="ttbar-login" >
				<a href="javascript:void(0);" class="link-login style-red">欢迎你，${ login_user.username }</a>&nbsp;&nbsp;
			</li>
			<li class="spacer"></li>
			<li class="fore2" >
				<div class="dt">
					<a target="_self" href="login!loginOutf">退出</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore3" >
				<div class="dt">
					<a target="_blank" href="member!info">个人中心</a>
				</div>
			</li>
		  </c:if>
	</ul>
</div>
</div>
  
			



<%--logo 搜索  类目  购物车--%>  
<div id="header">
<div class="w">
	<div id="logo" class="logo" >
		<h1 class="logo_tit"><a href="/" class="logo_tit_lk" style="background-image: url(style/img/logo.png) ;width:190px"></a></h1>
		<h2 class="logo_subtit">多快好省</h2>
		<div class="logo_extend"></div>
	</div>

	<div id="search" class="">
		<div class="search-m">
			<div class="form">
				<input   autocomplete="off" id="searchstr"class="text" type="text" style="height:35px;width:500px;padding:5px 10px;"value="${str }" name="keywords"  >
				<button  onclick="strsearch()" class="button"><i class="iconfont"></i></button>
			</div>
		</div>
	</div>


	<div id="settleup" class="dorpdown" >
		<div id="shoppingcart" class="shoppingcart">
						<dl class="">
							<dt class="ld">
								<s> </s>
								<span class="shopping"> <span class="shopping-amount"> <c:if test="${not empty shoppingCarts }">${count }</c:if><c:if test="${ empty shoppingCarts }">0</c:if> </span> </span>
								<a href="javascript:window.location.href='/shopingCart.jsp';" class="settleup-url"> 去购物车结算 </a> <b> </b>
							</dt>
							<dd>
							<c:if test="${ empty shoppingCarts }">
							<div class="prompt"><div class="nogoods"><b></b>购物车中还没有商品，赶紧选购吧！</div></div>
							</c:if>
							<c:if test="${ not empty shoppingCarts }">
								<div id="" class="settleup-content">
									<div class="smt"> <span class=""> 最新加入的商品 </span> </div>
									<div class="smc">
										<ul class="mcart-sigle">
										<c:forEach items="${shoppingCarts}" var="s">
											<li>
												<div class="p-img fl">
													<a href="InsuranceServlet?method=content&id=${s.goods.id }" target="_blank">
														<img src="upload_image/${s.goods.img }" alt="" height="48" width="48" />
													</a>
												</div>
												<div class="p-name fl">
													<a href="InsuranceServlet?method=content&id=${s.goods.id }" title="${s.goods.name }" target="_blank"> ${s.goods.name } 
													</a>
													
												</div>
												<div class="p-detail fr ar">
													<span class="p-price"> <strong>
													 ￥${s.goods.price }
													 </strong> &times;${s.num } </span> 
													<a class="delete" data-id="1102181" data-type="RemoveProduct" href="javascript:shoppingdelete('${s.goods.id }')"> 删除 </a>
												</div>
											</li>
											</c:forEach>
										</ul>
										
									</div>
									<div class="smb ar">
										共 <b> ${count } </b> 件商品　共计 <strong> ￥ ${prices } </strong> <br />
										<a href="javascript:window.location.href='/shopingCart.jsp';" title="去购物车结算" class="btn-payforgoods"style="color:#fff;"> 去购物车结算 </a>
									</div>
								</div>
							</c:if>
							</dd>
						</dl>
					</div>
	</div>

	<div id="hotwords" >
			<c:forEach items="${goodsClassifyList}" var="s"varStatus="i">
			<a target="_self" href="site!goodsClassify?id=${s.id }"<c:if test="${ i.index eq 0}">class="style-red"</c:if>><span>${s.name }</span></a>
			</c:forEach>
	</div>

	<div id="navitems">

		<ul id="navitems-group1">
			<c:forEach items="${goodsClassifyList}" var="s" varStatus="i">
			  <c:if test="${ i.index ne 0}">
			<div class="spacer"></div>
			</c:if>
			<li class="fore1">
				<a target="_self" href="site!goodsClassify?id=${s.id }">${s.name }</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	<!--index_ok-->

	<div id="treasure" ></div>
</div>
</div>












