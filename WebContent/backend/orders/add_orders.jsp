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
	<title>添加订单</title>
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
settime,
mCal,
mDCal,
newStyleSheet;
var dateFrom = null;
var dateTo = null;
window.onload = function() {
    settime = new dhtmlxCalendarObject('settime');
    initCKEditor();
}

</script>
<style type="text/css">
</style>
<script type="text/javascript">
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
</head>
<body>
<div id="formwrapper">
	<h3 class="add_title1">添加订单</h3>
	<form action="orders!add"  method="post">
	<fieldset>
		<legend class="add_title2" >订单信息</legend>
<c:if test="${login_user.role.id eq '1'}">
		<div>
			<label for="memberIds">下单人</label>
			<select name="member" id="memberIds" >
				<c:forEach items="${memberList }" var="s" >
				<option value="${s.id }"  <c:if test="${s.id eq 1 }">selected="selected"</c:if>
				>${s.name}</option>
				</c:forEach>
			</select> 
		</div>
</c:if>
<c:if test="${login_user.role.id eq '2'}">
		<div style="display:none;">
			<label for="memberIds">下单人</label>
			<select name="member" id="memberIds" >
				<c:forEach items="${memberList }" var="s" >
				<option value="${s.id }"  <c:if test="${s.users.id eq login_user.id }">selected="selected"</c:if>
				>${s.name}</option>
				</c:forEach>
			</select> 
		</div>
</c:if>
		<div>
			<label for="goodsIds">商品</label>
			<select name="goods" id="goodsIds" >
				<c:forEach items="${goodsList }" var="s" >
				<option value="${s.id }"  <c:if test="${s.id eq 1 }">selected="selected"</c:if>
				>${s.name}</option>
				</c:forEach>
			</select> 
		</div>
		<div>
			<label for="settime">下单时间</label>
			<input type="text" name="settime" id="settime" value="" size="8" maxlength="200" /> 
			<br />	
		</div>
		<div class="enter">
		    <input name="submit" type="submit" class="button_add_modify"  value="提交" />
		    <input name="reset" type="reset" class="button_add_modify"  value="重置" />
<c:if test="${login_user ne null}">
		    <input name="return" type="button" class="button_add_modify"  value="返回" onclick="window.history.go(-1)"/>
</c:if>
		</div>
	</fieldset>
	</form>
</div>

</body>
</html>

