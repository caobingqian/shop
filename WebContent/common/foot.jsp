<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>








 <div class="J_f mod_footer" id="footer" >

	<div class="mod_service">
		<div class="grid_c1 mod_service_inner">
			<ul class="mod_service_list"style="margin:0px;padding:0px;">
				<li class="mod_service_item" >
					<div class="mod_service_unit">
						<h5 class="mod_service_tit mod_service_duo">多</h5>
						<p class="mod_service_txt">品类齐全，轻松购物</p>
					</div>
				</li>
				<li class="mod_service_item">
					<div class="mod_service_unit">
						<h5 class="mod_service_tit mod_service_kuai">快</h5>
						<p class="mod_service_txt">多仓直发，极速配送</p>
					</div>
				</li>
				<li class="mod_service_item">
					<div class="mod_service_unit">
						<h5 class="mod_service_tit mod_service_hao">好</h5>
						<p class="mod_service_txt">正品行货，精致服务</p>
					</div>
				</li>
				<li class="mod_service_item">
					<div class="mod_service_unit">
						<h5 class="mod_service_tit mod_service_sheng">省</h5>
						<p class="mod_service_txt">天天低价，畅选无忧</p>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="mod_help">
		<div class="grid_c1 mod_help_inner">
			<div class="mod_help_list">
				<div style="background-color:#fff;border-radius:22px;width:150px;margin:0 auto;">
	            <img class="" src="style/img/logo_big.png" height="150px" border="0" alt=""><br></div>
				</div>
				<div class="mod_help_nav">
			</div>
		</div>
	</div>
	<div class="mod_copyright">
		<div class="grid_c1 mod_copyright_inner">
			<p class="mod_copyright_links">
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
			</p>
			<div class="mod_copyright_info">
				<p><span>  毕业设计 &copy; <a href="#" target="_blank"><atitle></atitle>的设计与实现</a> All Rights Reserved</span>
				</p>
			</div>
		</div>
	</div>
</div>







