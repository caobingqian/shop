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
	<title>编辑前台</title>
<link rel="STYLESHEET" type="text/css" href="codebase/dhtmlxcalendar.css">
<script  src="codebase/dhtmlxcommon.js"></script>
<script  src="codebase/dhtmlxcalendar.js"></script>
<script src="js/jquery-1.9.1.min.js" language="javascript" /></script>
	<script src="js/js.js" language="javascript" /></script>
	<script src="ckeditor/ckeditor.js"></script>
	<link href="css/style_add.css" rel="stylesheet">
<script>
		function initCKEditor(){
		}

var 
mCal,
mDCal,
newStyleSheet;
var dateFrom = null;
var dateTo = null;
window.onload = function() {
    initCKEditor();
}
</script>
<script>
 function image(str){
	var ret = window.showModalDialog("upload.jsp",window,"dialogWidth=400px;dialogHeight=200px");
	if(ret!=null&&ret!=""){
		filename=ret.split("::")[0];
		contentType=ret.split("::")[1];
		var url="";
		if(contentType.indexOf("image")>-1){
			if($("#"+str+"_image").size()>0){
			$("#"+str+"_image").attr("src","upload_image/"+filename+"");
			}else{
			$("#"+str).after("<img id='"+str+"_image' max-width='100%' src='upload_image/"+filename+"'>");
			}
		}else{
			if($("#"+str+"_file").size()>0){
			$("#"+str+"_file").attr("href","upload_file/"+filename+"");
			}else{
			$("#"+str).after("<a id='"+str+"_file'  href='upload_file/"+filename+"'>下载文件</a>");
			}
		}
		document.getElementById(str).value = filename;
		
	}
}

function InsertHTML(value){
	var editor = CKEDITOR.instances.content;
	// Check the active editing mode.
	if ( editor.mode == 'wysiwyg' )
	{
		// Insert HTML code.
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-insertHtml
		editor.insertHtml( value );
	}
	else
		alert( 'You must be in WYSIWYG mode!' );
}
</script>
<style type="text/css">
</style>
</head>
<body>
<div id="formwrapper">
	<h3 class="add_title1">查看前台</h3>
	<form action="site!update?pageNo=${page.pageNo }&pageSize=${page.pageSize }" method="post">
	<input type="hidden" name="id" value="${site.id }">

	<fieldset>
		<legend class="add_title2">前台信息</legend>
		<div>
			<label for="ordersIds">订单</label>
				<c:forEach items="${ordersList }" var="s" >
				<c:if test="${s.id eq site.orders.id }">${s.name}</c:if>
				</c:forEach>
		</div>
		<div>
			<label for="goodsIds">商品</label>
				<c:forEach items="${goodsList }" var="s" >
				<c:if test="${s.id eq site.goods.id }">${s.name}</c:if>
				</c:forEach>
		</div>
		<div>
			<label for="goodsClassifyIds">商品分类</label>
				<c:forEach items="${goodsClassifyList }" var="s" >
				<c:if test="${s.id eq site.goodsClassify.id }">${s.name}</c:if>
				</c:forEach>
		</div>
		<div>
			<label for="newsIds">新闻公告</label>
				<c:forEach items="${newsList }" var="s" >
				<c:if test="${s.id eq site.news.id }">${s.name}</c:if>
				</c:forEach>
		</div>
		<div>
			<label for="memberIds">会员</label>
				<c:forEach items="${memberList }" var="s" >
				<c:if test="${s.id eq site.member.id }">${s.name}</c:if>
				</c:forEach>
		</div>
		<div>
			<label for="commentsIds">评论</label>
				<c:forEach items="${commentsList }" var="s" >
				<c:if test="${s.id eq site.comments.id }">${s.name}</c:if>
				</c:forEach>
		</div>
		<div class="enter">
		    <input name="return" type="button" class="button_add_modify"  value="返回" onclick="window.history.go(-1)"/>
		</div>
	</fieldset>
	</form>
</div>

</body>
</html>

