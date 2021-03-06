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
	<title>编辑商品</title>
<link rel="STYLESHEET" type="text/css" href="codebase/dhtmlxcalendar.css">
<script  src="codebase/dhtmlxcommon.js"></script>
<script  src="codebase/dhtmlxcalendar.js"></script>
<script src="js/jquery-1.9.1.min.js" language="javascript" /></script>
	<script src="js/js.js" language="javascript" /></script>
	<script src="ckeditor/ckeditor.js"></script>
	<link href="css/style_add.css" rel="stylesheet">
<script>
		function initCKEditor(){
			CKEDITOR.replace( 'content' ,
			{
				width:$("#content").parent().width(),
				height:500
			});
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
<script>
 function addcontent(){
	var ret = window.showModalDialog("upload.jsp",window,"dialogWidth=400px;dialogHeight=200px");
	if(ret!=null&&ret!=""){
		filename=ret.split("::")[0];
		contentType=ret.split("::")[1];
		var url="";
		if(contentType.indexOf("image")>-1){
			url="<img src=\"upload_image/"+filename+"\"  style='max-width:100%;' />";
		}else{
			url="<a href=\"upload_file/"+filename+"\" />下载文件</a>";
		}
		
		//向CKEDITOR插入html代码 url
		var editor = CKEDITOR.instances.content;
		// Check the active editing mode.
		if ( editor.mode == 'wysiwyg' )
		{
			// Insert HTML code.
			// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-insertHtml
			editor.insertHtml( url );
		}
		else{
			alert( 'You must be in WYSIWYG mode!' );
		}
	
	}
}
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
	<h3 class="add_title1">编辑商品</h3>
	<form action="goods!update?pageNo=${page.pageNo }&pageSize=${page.pageSize }" method="post">
	<input type="hidden" name="id" value="${goods.id }">
	<input type="hidden" name="namesearch" value="${param.namesearch }">
	<input type="hidden" name="goodsClassifysearch" value="${param.goodsClassifysearch }">

	<fieldset>
		<legend class="add_title2">商品信息</legend>
		<div>
			<label for="name">商品名称</label>
			<input type="text" name="name" id="name" value="${goods.name }" size="60" maxlength="200" /> 
			<br />	
		</div>
		<div>
			<label for="goodsClassifyIds">商品分类</label>
			<select name="goodsClassify" id="goodsClassifyIds" >
				<c:forEach items="${goodsClassifyList }" var="s" >
				<option value="${s.id }"  <c:if test="${s.id eq goods.goodsClassify.id }">selected="selected"</c:if>
				>${s.name}</option>
				</c:forEach>
			</select> 
		</div>
		<div>
			<label for="img">展示图片</label>
			<input type="button" class="button_list2 " onclick="image('img')" id="attachs" value="上传图片">
			<input type="hidden" name="img" id="img" value="${goods.img }" size="60" maxlength="200" /> 
			<img id="img_image" src="upload_image/${goods.img }">
			<br />	
		</div>
		<div>
			<label for="price">价格</label>
			<input type="text" name="price" id="price" value="${goods.price }" size="60" maxlength="200" /> 
			<br />	
		</div>
		<div>
			<label for="settime">上架时间</label>
			<input type="text" name="settime" id="settime" value="${goods.settime }" size="8" maxlength="200" /> 
			<br />	
		</div>
		<div>
			<label for="descp">简介</label>
			<input type="text" name="descp" id="descp" value="${goods.descp }" size="60" maxlength="200" /> 
			<br />	
		</div>
		<div>
			<label for="content">商品详情</label>
			<div style="margin:0px 0px 0px 130px;width:75%;">
			<textarea rows="10" cols="100" name="content" id="content" >${goods.content }</textarea>
			</div>
			<br />	
		</div>
		<div>
			<label for="attachs">插入商品详情附件或图片</label>
			<input type="button"  class="button_list2 " onclick="addcontent()" id="attachs" value="添加">
			<br />	
		</div>
<c:if test="${login_user.role.id eq '1'}">
		<div>
			<label for="memberIds">上传人</label>
			<select name="member" id="memberIds" >
				<c:forEach items="${memberList }" var="s" >
				<option value="${s.id }"  <c:if test="${s.id eq goods.member.id }">selected="selected"</c:if>
				>${s.name}</option>
				</c:forEach>
			</select> 
		</div>
</c:if>
<c:if test="${login_user.role.id eq '2'}">
		<div style="display:none;">
			<label for="memberIds">上传人</label>
			<select name="member" id="memberIds" >
				<c:forEach items="${memberList }" var="s" >
				<option value="${s.id }"  <c:if test="${s.id eq goods.member.id }">selected="selected"</c:if>
				>${s.name}</option>
				</c:forEach>
			</select> 
		</div>
</c:if>
		<div>
			<label for="nums">销量</label>
			<input type="text" name="nums" id="nums" value="${goods.nums }" size="60" maxlength="200" /> 
			<br />	
		</div>
		<div class="enter">
		    <input name="submit" type="submit" class="button_add_modify"  value="提交" />
		    <input name="reset" type="reset" class="button_add_modify"  value="重置" />
		    <input name="return" type="button" class="button_add_modify"  value="返回" onclick="window.history.go(-1)"/>
		</div>
	</fieldset>
	</form>
</div>

</body>
</html>

