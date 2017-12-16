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
                <td width="94%" valign="bottom"><span class="list_title"> 商品信息列表</span></td>
              </tr>
            </table></td>
            <script>
            	function checkAll(item){
            		var chk = document.getElementsByName("goodsCheckbox");
            		for ( var i = 0; i < chk.length; i++) {
						chk[i].checked = item.checked;
					}
            	}
            	function del(){
					document.getElementById("form_goods_betch").action="goods!deleteBetch?pageNo=${page.pageNo }&pageSize=${page.pageSize }";
            		document.getElementById("form_goods_betch").submit();
            	}
            </script>
            <td><div align="right">
            <span>
<c:if test="${login_user.role.id eq '1'}">
</c:if>
             &nbsp;&nbsp;<img src="images/add.gif" width="10" height="10"  class="add_button_img"/> <a href="goods!addInput" class="button_list ">添加</a>   
             &nbsp; <img src="images/del.gif" width="10" height="10"  class="add_button_img"/> <a href="javascript:del()" class="button_list ">批量删除</a>   
             </span><span> &nbsp;</span></div></td>
          </tr>
           <tr><td colspan="2"> 
           <div align="left" class="list_search" > 
 				<form action="goods.do" method="post"> 
 					<input type="hidden" name="pageNo" value="${page.pageNo }"  /> 
 					<input type="hidden" name="pageSize" value="${page.pageSize }"/> 
 					<input type="hidden" name="type" value="backend"/> 
			
 				</form> 
 		  </div> 
           </td><td></td></tr> 
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
        <th width="200" height="20"><div align="center"><span>展示图片</span></div></th>
        <th width="200" height="20"><div align="center"><span>商品名称</span></div></th>
        <th width="200" height="20"><div align="center"><span>商品分类</span></div></th>
        <th width="200" height="20"><div align="center"><span>价格</span></div></th>
        <th width="200" height="20"><div align="center"><span>上架时间</span></div></th>
        <th width="200" height="20"><div align="center"><span>简介</span></div></th>
        <th style="display:none;" width="200" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">商品详情</span></div></th>
        <th width="200" height="20"><div align="center"><span>上传人</span></div></th>
        <th width="200" height="20"><div align="center"><span>销量</span></div></th>
        <th width="200" height="20"><div align="center"><span>基本操作</span></div></th>
      </tr>
      </thead>
      <tbody>
      <c:if test="${not empty goodsList}">
      <form id="form_goods_betch" method="post">
      <c:forEach items="${goodsList}" var="goods">
<tr>
        <td height="20"><div align="center">
          <input type="checkbox" name="goodsCheckbox" value="${goods.id }"/>
        </div></td>
        <td height="20"><div align="center"><img src='upload_image/${goods.img }' style='max-width:150px'/></div></td>
        <td height="20"><div align="center">${goods.name }</div></td>
        <td height="20"><div align="center">${goods.goodsClassify.name }</div></td>
        <td height="20"><div align="center">${goods.price }</div></td>
        <td height="20"><div align="center">${goods.settime }</div></td>
        <td height="20"><div align="center">${goods.descp }</div></td>
        <td style="display:none;"  height="20"><div align="center">${goods.content }</div></td>
        <td height="20"><div align="center">${goods.member.name }</div></td>
        <td height="20"><div align="center">${goods.nums }</div></td>
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
<br></c:if>
        <a href="javascript:delconfirm('goods!delete?id=${goods.id }')" class="button_list2 " title="点击删除项目信息">删除</a><span class="shuxian"> |</span>
        <a href="javascript:opera('goods!modify?id=${goods.id }')" class="button_list2 " title="点击编辑项目信息">编辑</a>
        </div></td>
      </tr>
      </c:forEach>
      </form>
      </c:if>
      <c:if test="${ empty goodsList }">
      <tr>
          <td height="20" colspan="90" class="noinfo"><div align="center">没有商品信息可以显示</div></td>
      </tr>
      </c:if>
      </tbody>
      
    </table></td>
  </tr>
<form id="form_page" action="goods.do" method="post">
	<input type="hidden" name="pageNo" value="${page.pageNo }" id="pageNo" />
	<input type="hidden" name="pageSize" value="${page.pageSize }" id="pageSize"/>
</form>  
<%--   <%@include file="/backend/commons/page.jsp" %> --%>
<%@include file="/backend/commons/page.jsp" %>
</table>
 				<form action="goods.do" method="post"  id="opera" style="display:none"> 
 					<input type="hidden" name="pageNo" value="${page.pageNo }"  /> 
 					<input type="hidden" name="pageSize" value="${page.pageSize }"/> 
 					<input type="hidden" name="type" value="backend"/> 
 					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品名称：<input type="text" name="namesearch" value="${search.namesearch}">
			
			&nbsp;&nbsp;商品分类：&nbsp;&nbsp;
			<select name="goodsClassifysearch" id="goodsClassifysearchIds" >
				<option value=""  <c:if test="${'' eq search.goodsClassifysearch }">selected="selected"</c:if>>选择商品分类</option>
				<c:forEach items="${goodsClassifyList }" var="s" >
				<option value="${s.id }"  <c:if test="${s.id eq search.goodsClassifysearch }">selected="selected"</c:if>
				>${s.name}</option>
				</c:forEach>
			</select> 
			
 				</form> 
</body>
</html>

