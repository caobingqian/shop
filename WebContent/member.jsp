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
	
	
	
  
  
  
		
		
		
		
	      
	

		<div class="fs">
			<div class="grid_c1 fs_inner"style="height:700px">

				<div class="fs_col1"style="height:700px">
					<div class="J_cate cate">
						<ul class="JS_navCtn cate_menu" style="padding:0px;height:700px">
<iframe height="100%" width="100%" frameborder="0" frameborder="0" src="/backend/left2.jsp" name="leftFrame" id="rightFrame" title="rightFrame"></iframe>
							<li class="cate_menu_item" data-index="2" >
							</li>
						</ul>
					</div>
				</div>
				<!--index_ok-->

				<div class="fs_col2"style="height:700px">
<iframe height="100%" width="100%" frameborder="0" frameborder="0" src="member.do" name="rightFrame" id="rightFrame" title="rightFrame"></iframe>
				</div>
			</div>
			<div id="J_fs_act" class="fs_act"></div>
		</div>

		
		
  
  
  
  
  
  
 


<%@include file="/common/foot.jsp"%>
	</body>
</html>
