<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CMS 后台管理工作平台</title>
	<link href="css/style_list.css" rel="stylesheet">
<style type="text/css">
</style>

</head>
<body class="listbg">
<table class="list_content">
  <tr>
    <td class="list_content2">
    <table width="100%" >
      <tr>
        <td height="24" class="list_head">
        <table width="100%">
          <tr>
            <td>
            <table width="100%">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" class="list_title_img" /></div></td>
                <td width="94%" valign="bottom"><span class="list_title"> 商品分类信息列表</span></td>
              </tr>
            </table></td>
            <script>
            	function checkAll(item){
            		var chk = document.getElementsByName("goodsClassifyCheckbox");
            		for ( var i = 0; i < chk.length; i++) {
						chk[i].checked = item.checked;
					}
            	}
            	function del(){
					document.getElementById("form_goodsClassify_betch").action="goodsClassify!deleteBetch?pageNo=${page.pageNo }&pageSize=${page.pageSize }";
            		document.getElementById("form_goodsClassify_betch").submit();
            	}
            </script>
            <td><div align="right">
            <span>
<c:if test="${login_user.role.id eq '1'}">
             &nbsp;&nbsp;<img src="images/add.gif" width="10" height="10"  class="add_button_img"/> <a href="goodsClassify!addInput" class="button_list ">添加</a>   
             &nbsp; <img src="images/del.gif" width="10" height="10"  class="add_button_img"/> <a href="javascript:del()" class="button_list ">批量删除</a>   
</c:if>
             </span><span> &nbsp;</span></div></td>
          </tr>
<!--
          <tr><td colspan="2"> 
           <div align="left"  class="list_search" > 
 				<form action="goodsClassify.do" method="post"> 
 					<input type="hidden" name="pageNo" value="${page.pageNo }"  /> 
 					<input type="hidden" name="pageSize" value="${page.pageSize }"/> 
 					<input type="hidden" name="type" value="xxx"/> 
 					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;按名称查询：<input type="text" name="string" value="${param.string}"><input type="submit" class="button_list2 " value="查询"> 
 				</form> 
 		  </div> 
           </td><td></td></tr> 
-->
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <table  class="table table-bordered table-list">
    <thead>
      <tr>
        <th width="4%" height="20" ><div align="center">
          <input type="checkbox"  onclick="checkAll(this)"/>
        </div></th>
        <th width="200" height="20"><div align="center"><span>分类名称</span></div></th>
        <th width="200" height="20"><div align="center"><span>备注</span></div></th>
        <th width="200" height="20"><div align="center"><span>基本操作</span></div></th>
      </tr>
      </thead>
      <tbody>
      <c:if test="${not empty goodsClassifyList}">
      <form id="form_goodsClassify_betch" method="post">
      <c:forEach items="${goodsClassifyList}" var="goodsClassify">
<tr>
        <td height="20"><div align="center">
          <input type="checkbox" name="goodsClassifyCheckbox" value="${goodsClassify.id }"/>
        </div></td>
        <td height="20"><div align="center">${goodsClassify.name }</div></td>
        <td height="20"><div align="center">${goodsClassify.descp }</div></td>
        <td height="20"><div align="center">
        <script>
        	function delconfirm(str){
        		var c = confirm("确认要删除此项吗？");
				if(c){
        		document.getElementById("opera").action=str;
        		document.getElementById("opera").submit();
				}else{
				
				}
        	}
        	function opera(str){
        		document.getElementById("opera").action=str;
        		document.getElementById("opera").submit();
        	}
        </script>
<c:if test="${login_user.role.id eq '1'}">
        <a href="javascript:delconfirm('goodsClassify!delete?id=${goodsClassify.id }')" class="button_list2 " title="点击删除项目信息">删除</a><span class="shuxian"> |</span>
        <a href="javascript:opera('goodsClassify!modify?id=${goodsClassify.id }')" class="button_list2 " title="点击编辑项目信息">编辑</a>
<br></c:if>
        </div></td>
      </tr>
      </c:forEach>
      </form>
      </c:if>
      <c:if test="${ empty goodsClassifyList }">
      <tr>
          <td height="20" colspan="90" class="noinfo"><div align="center">没有商品分类信息可以显示</div></td>
      </tr>
      </c:if>
      </tbody>
      
    </table></td>
  </tr>
<form id="form_page" action="goodsClassify.do" method="post">
	<input type="hidden" name="pageNo" value="${page.pageNo }" id="pageNo" />
	<input type="hidden" name="pageSize" value="${page.pageSize }" id="pageSize"/>
</form>  
<%--   <%@include file="/backend/commons/page.jsp" %> --%>
<%@include file="/backend/commons/page.jsp" %>
</table>
 				<form action="GoodsClassify.do" method="post" id="opera" style="display:none"> 
 					<input type="hidden" name="pageNo" value="${page.pageNo }"  /> 
 					<input type="hidden" name="pageSize" value="${page.pageSize }"/> 
 					<input type="hidden" name="type" value="xxx"/> 
 				</form> 
</body>
</html>

