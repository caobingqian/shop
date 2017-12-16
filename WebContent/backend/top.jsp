<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	
	<title></title>
	
	
	<!--common-->
  <link href="css/style_top.css" rel="stylesheet">
  <link href="css/style-responsive.css" rel="stylesheet">
<style type="text/css">
<!--

-->
</style>

</head>
<body>







<div class="header-section">

            <a class="backend_logo"><b class="sysName"></b></a>
            <!--toggle button start-->
            <!--toggle button end-->


            <!--notification menu start -->
            <div class="menu-right">
                <ul class="notification-menu">
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle" style="padding-top:16px">
                             ${login_user.role.name}&nbsp;${login_user.username}
                        </a>
                    </li>
                    <li>
                        <a href="login!loginOut" target="_parent" class="btn btn-default dropdown-toggle info-number" >
                            <i class="fa fa-power-off"></i>
                        </a>
                    </li>

                </ul>
            </div>
            <!--notification menu end -->

        </div>




<!-- Placed js at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
			$(document).ready(function(){
			    $(".sysName").load("sysName.txt",function(data,x){
			    	document.title=data;
			    });	
			});
	</script>
<script src="js/jquery-ui-1.9.2.custom.min.js"></script>




</body>
</html>

