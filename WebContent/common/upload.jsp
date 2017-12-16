<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script type="text/javascript">
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
function InsertHTML1(value){
	var editor = CKEDITOR.instances.announcement;
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
function InsertHTML2(value){
	var editor = CKEDITOR.instances.special;
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
function InsertHTML3(value){
	var editor = CKEDITOR.instances.evolm;
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
function InsertHTML4(value){
	var editor = CKEDITOR.instances.contect;
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
	function ajaxFileUpload()
	{
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'attachment',
				dataType:'json',
				success: function (data, status)
				{
				if(data.contentType.indexOf("image")>-1){
					url="<img src=\"upload_image/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}else{
					url="<img src=\"upload_file/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}
				InsertHTML(url);
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function ajaxFileUploada()
	{
	
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'attachmenta',
				dataType:'json',
				success: function (data, status)
				{
				if(data.contentType.indexOf("image")>-1){
					url="<img src=\"upload_image/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}else{
					url="<img src=\"upload_file/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}
				InsertHTML1(url);
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function ajaxFileUploads()
	{
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'attachments',
				dataType:'json',
				success: function (data, status)
				{
				if(data.contentType.indexOf("image")>-1){
					url="<img src=\"upload_image/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}else{
					url="<img src=\"upload_file/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}
				InsertHTML2(url);
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function ajaxFileUploade()
	{
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'attachmente',
				dataType:'json',
				success: function (data, status)
				{
				if(data.contentType.indexOf("image")>-1){
					url="<img src=\"upload_image/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}else{
					url="<img src=\"upload_file/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}
				InsertHTML3(url);
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function ajaxFileUploadc()
	{
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'attachmentc',
				dataType:'json',
				success: function (data, status)
				{
				if(data.contentType.indexOf("image")>-1){
					url="<img src=\"upload_image/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}else{
					url="<img src=\"upload_file/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />";
				}
				InsertHTML4(url);
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function uploadfile1()
	{
	
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'uploadfile',
				dataType:'json',
				success: function (data, status)
				{
				document.getElementById("img").value = data.filename;
				if(!$(".addimg").length > 0){
					$("#img").parent().after("<img class=\"addimg\" src=\"upload_image/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />");
				}else{
					$(".addimg").attr("src","upload_image/"+$("#login_username").val()+"/"+data.filename);
				};
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function uploadfile2()
	{
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'uploadfile2',
				dataType:'json',
				success: function (data, status)
				{
				$("#map").val(data.filename);
				if(!$(".mapimg").length > 0){
					$("#map").parent().after("<img class=\"mapimg\" src=\"upload_image/"+$("#login_username").val()+"/"+data.filename+"\" style=\"width:100%;\" />");
				}else{
					$(".mapimg").attr("src","upload_image/"+$("#login_username").val()+"/"+data.filename);
				};
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function addtype()
	{
	var  addtypevalue = $("#addtypename").val();
	var addtypename = $("#addtypename").val();
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

	
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'addtypevalue',
				dataType:'json',
				success: function (data, status)
				{
				var imgsrc = data.filename;
				 $.ajax({
			          type: "POST",
			          dataType: "json",
			          url: 'GoodsTypeServlet',
			          cache: false,
			          async: false,
			          data:{
			        	 method:"add",
			           	 goods:$("#goods").val(),
			           	 shape:addtypename,
			           	 simg:imgsrc
			          },
			          success: function(data){
			        	  if(data.back=="success"){
			        	  	if($(".invisibles").length > 0){
								$("#choose .addtype").append("<div class=\"item\"><b></b><a href=\"javascript:;\" title=\"\"><img data-img=\""+data.goodsType+"\" src=\"upload_image/"+$("#login_username").val()+"/"+imgsrc+"\" width=\"25\" height=\"25\" alt=\" \" /><i>"+addtypevalue+"</i></a></div>");
								$(".addtypeimg").append("<div class=\"box"+data.goodsType+" invisibles\"> </div>");
							}else{
								$("#choose .addtype").append("<div class=\"item selected\"><b></b><a href=\"javascript:;\" title=\"\"><img data-img=\""+data.goodsType+"\" src=\"upload_image/"+$("#login_username").val()+"/"+imgsrc+"\" width=\"25\" height=\"25\" alt=\" \" /><i>"+addtypevalue+"</i></a></div>");
								$(".addtypeimg").append("<div class=\"box"+data.goodsType+" invisibles addtypeimgvisibles\"> </div>");
							}
							$(".addtype .item a").bind("click",function(event){   
					        //阻止事件冒泡   
					           event.stopPropagation();             
					        	$(".addtype .item ").removeClass("selected");
								$(this).parent().addClass("selected");
								$(".addtypeimgvisibles").removeClass("addtypeimgvisibles");
								$(".box"+$(this).find("img").attr("data-img")).addClass("addtypeimgvisibles");
					       });  
			        	  }
			          }
			       });
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		);
		})(jQuery);
		
		return false;

	}
	function addtypeimg()
	{
	var goodsTypeId = $(".addtype .selected ").find("img").attr("data-img");
	var  addtypevalue = $("#addtypename").val();
		(function ($) {
        $(".loading")
		.ajaxStart(function(){
			$(this).css("display","inline-block");
		})
		.ajaxComplete(function(){
			$(this).css("display","none");
		});

		
		$.ajaxFileUpload
		(
			{
				url:'UploadServlet?method=uploadfile',
				secureuri:false,
				fileElementId:'addtypeimg',
				dataType:'json',
				success: function (data, status)
				{
				var imgsrc = data.filename;
				$.ajax({
			          type: "POST",
			          dataType: "json",
			          url: 'GoodsTypeImgServlet',
			          cache: false,
			          async: false,
			          data:{
			        	 method:"add",
			        	 goods:$("#goods").val(),
			           	 goodsType:goodsTypeId,
			           	 img:imgsrc
			          },
			          success: function(data){
			        	  if(data.back=="success"){
								$(".box"+goodsTypeId).append("<div class=\"goodsTypeImgpo goodsTypeImgDiv"+data.id+"\" style=\"width:100px;margin:10px;\"><img  src=\"upload_image/"+$("#login_username").val()+"/"+imgsrc+"\" style=\"width:100px;\" /><span  class=\"button asksubmit goodsTypeImgDel\" onclick=\"return delGoodsTypeImg("+data.id+")\">删 除</span></div>");
			        	  }
			          }
			       });
				},
				error: function (data, status, e)
				{
					alert(e);
				} 
			}
		);
		})(jQuery);
		
		return false;

	}
	
	</script>	

<input type="hidden" id="login_username" value="${login_user.username }"/>
<div id="upload"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传文件<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="attachment"  type="file" name="attachment" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return ajaxFileUpload();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
<div id="uploada"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传文件<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="attachmenta"  type="file" name="attachmenta" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return ajaxFileUploada();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
<div id="uploads"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传文件<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="attachments"  type="file" name="attachments" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return ajaxFileUploads();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
<div id="uploade"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传文件<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="attachmente"  type="file" name="attachmente" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return ajaxFileUploade();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
<div id="uploadc"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传文件<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="attachmentc"  type="file" name="attachmentc" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return ajaxFileUploadc();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
 
 
<div id="upload2"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传文件<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="uploadfile"  type="file" name="uploadfile" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return uploadfile1();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
 
 
<div id="upload3"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传文件<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="uploadfile2"  type="file" name="uploadfile2" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return uploadfile2();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>

<div id="upload4"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>添加对应型号商品图片</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择上传图片<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="uploadfile2"  type="file" name="uploadfile2" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green buttonUpload"  onclick="return uploadfile2();">上传</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
 
<div id="addtype"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>添加商品型号</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
					<div class="form-group"> 
					<div class="label">
					 <label for="name">型号名称</label>
					</div> 
					<div class="field"> 
					 <input type="text" class="input" id="addtypename" name="name" size="50"  placeholder="你的店铺名称" value=""/> 
					</div> 
				   </div> 
  <div class="form-group "> 
  <div class="label"><label for="face">请选择型号缩略图<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="addtypevalue"  type="file" name="addtypevalue" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green dialog-close"  onclick="return addtype()">添加</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
 
<div id="addtypeimgdialog"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>添加商品图片</strong> </div>
<div class="dialog-body"> 
<form name="form" action="" method="POST" enctype="multipart/form-data">  
  <div class="form-group text-center"> 
  <div class="label"><label for="face">请选择商品图片<img class="loading" src="style/images/loading.gif" style="display:none;width:20px;"></label></div> 

  <div class="field files"> 
	<a class="button input-file asksubmit " href="javascript:void(0);">+ 浏览文件<input id="addtypeimg"  type="file" name="addtypeimg" /></a>
	
  </div> 
  
  </div>
  <span class="clr"></span>
 </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green dialog-close"  onclick="return addtypeimg()">添加</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>


<div id="uploadsuccess"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>上传文件</strong> </div>
<div class="dialog-body"> 
<div class="loginsuccess">
文件上传成功！<br/>
</div>
</div> 
<div class="dialog-foot">
 <button class="button bg-green dialog-close" >确定</button> 
 </div> </div> </div>
 
 
<div id="loginsuccess"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>登陆</strong> </div>
<div class="dialog-body"> 
<div class="loginsuccess">
登陆成功！<br/>
</div>
</div> 
<div class="dialog-foot">
 <button class="button bg-green dialog-close" >确定</button> 
 </div> </div> </div>
 
 
<div id="consigneeMod"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>修改收货人信息</strong> </div>
<div class="dialog-body scroll-dialog-body"> 
<div class="form-group"> 
					<div class="label" >
					 <label for="">收货人信息</label>
					</div> 
					<div class="field"> 
					
<div class="consigneeLists consigneeListRadio">
<form action="">
<c:forEach items="${consigneeList}" var="s">
<div class="consigneeList  <c:if test="${ buyer.consignee.id eq s.id}">hover</c:if>">
<input type="radio" name="consigneeradio" data-validate="radio:请选择收货人信息" class="consigneeradio" <c:if test="${ buyer.consignee.id eq s.id}">checked="checked"</c:if>>
<span class="id invisibles">${ s.id}</span>
<span class="email invisibles">${ s.email}</span>
<span class="name">${ s.name}</span>
<span class="address">${ s.address}</span>
<span class="tel">${ s.tel}</span>
<a href="javascript:void(0)"class=" consigneeDel">[删除]</a>
<a href="javascript:void(0)"class=" consigneeFormVis">[编辑]</a>
</div>
</c:forEach>
<div class="consigneeList consigneeFormVis">
<input type="radio" name="consigneeradio" data-validate="radio:请选择收货人信息"  class="consigneeradio">
<span> 使用新地址</span>
<span class="id invisibles">0</span>
<span class="email invisibles"></span>
<span class="name invisibles"></span>
<span class="address invisibles"></span>
<span class="tel invisibles"></span>
</div>

</form>
</div>
					
					
					</div> 
				   </div> 

<form method="post" class="consigneeMod invisibles" action=""  > 
					 <input type="hidden" class="input" id="id" name="id" value="${ buyer.consignee.id}"/> 
					 <input type="hidden" class="input" id="del" name="del" value="0"/> 
				   <div class="form-group"> 
					<div class="label"  style="padding-top:20px" >
					 <label for="name">收货人</label>
					</div> 
					<div class="field"> 
					 <input type="text" class="input" id="name1" name="name"  data-validate="required:必填"size="50"  placeholder="收货人" value="${ buyer.consignee.name}"/> 
					</div> 
				   </div> 
				   <div class="form-group"> 
					<div class="label">
					 <label for="address">详细地址</label>
					</div> 
					<div class="field"> 
					 <input type="text" class="input" id="address1" name="address" size="50" data-validate="required:必填" placeholder="详细地址" value="${ buyer.consignee.address}"/> 
					</div> 
				   </div> 
				   <div class="form-group"> 
					<div class="label">
					 <label for="tel">电话号码</label>
					</div> 
					<div class="field"> 
					 <input type="text" class="input" id="tel1" name="tel" size="50" data-validate="required:必填,mobile:手机号码不正确" placeholder="电话号码" value="${ buyer.consignee.tel}"/> 
					</div> 
				   </div> 
				   <div class="form-group"> 
					<div class="label">
					 <label for="email">邮箱</label>
					</div> 
					<div class="field"> 
					 <input type="text" class="input" id="email1" name="email" size="50" data-validate="required:必填,email:邮箱格式不正确" placeholder="邮箱" value="${ buyer.consignee.email}"/> 
					</div> 
				   </div> 
				 
				  <br/>
				   
				   
				  </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green "  onclick="return shoppingConsigneeMod1(this)">保存收货人信息</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
 
 
 
<div id="payway"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>修改支付方式</strong> </div>
<div class="dialog-body "> 

<form method="post" class=" " action=""  > 
				   <div class="form-group text-center"> 
					<div class="label"  >
					 <label for="payway">支付方式</label>
					</div> 
					<div class="field "> 
						<input type="radio" style="margin:10px 0 0 10px" <c:if test="${ buyer.payway eq '在线支付'}">checked="checked"</c:if>  name="payway" data-validate="radio:请选择支付方式"   value="在线支付">&nbsp;&nbsp;在线支付<br/>
						<input type="radio" style="margin:10px 0 0 10px" <c:if test="${ buyer.payway eq '货到付款'}">checked="checked"</c:if> name="payway" data-validate="radio:请选择支付方式"   value="货到付款">&nbsp;&nbsp;货到付款<br/>
						<input type="radio" style="margin:10px 0 0 10px" <c:if test="${ buyer.payway eq '上门自提'}">checked="checked"</c:if> name="payway" data-validate="radio:请选择支付方式"   value="上门自提">&nbsp;&nbsp;上门自提<br/>
					</div> 
				   </div> 
				 
				  <br/>
				   
				   
				  </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green "  onclick="return shoppingPayway(this)">保存支付及配送方式</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
 
 
<div id="invoice"> 
<div class="dialog"> <div class="dialog-head"> <span class="close rotate-hover"></span>
<strong>修改发票信息</strong> </div>
<div class="dialog-body "> 

<form method="post" class=" " action=""  > 
					<div class="form-group"> 
					<div class="label">
					 <label for="invoiceHead">类型和抬头</label>
					</div> 
					<div class="field"> 
					 <input type="text" class="input" id="invoiceHead" name="invoiceHead" size="50" data-validate="required:必填" placeholder="发票抬头" value="${ buyer.invoiceHead}"/> 
					</div> 
				   </div> 
				   <div class="form-group "> 
					<div class="label"  >
					 <label for="invoiceContent">发票内容 </label>
					</div> 
					<div class="field "> 
						<input type="radio" style="margin:10px 0 0 10px" <c:if test="${ buyer.invoiceContent eq '明细'}">checked="checked"</c:if>  name="invoiceContent" data-validate="radio:请选择发票内容"   value="明细">&nbsp;&nbsp;明细<br/>
						<input type="radio" style="margin:10px 0 0 10px" <c:if test="${ buyer.invoiceContent eq '办公用品'}">checked="checked"</c:if> name="invoiceContent" data-validate="radio:请选择发票内容"   value="办公用品">&nbsp;&nbsp;办公用品<br/>
						<input type="radio" style="margin:10px 0 0 10px" <c:if test="${ buyer.invoiceContent eq '电脑配件'}">checked="checked"</c:if> name="invoiceContent" data-validate="radio:请选择发票内容"   value="电脑配件">&nbsp;&nbsp;电脑配件<br/>
						<input type="radio" style="margin:10px 0 0 10px" <c:if test="${ buyer.invoiceContent eq '耗材'}">checked="checked"</c:if> name="invoiceContent" data-validate="radio:请选择发票内容"   value="耗材">&nbsp;&nbsp;耗材<br/>
					</div> 
				   </div> 
				 
				  <br/>
				   
				   
				  </form>
</div> 
<div class="dialog-foot">
 <button class="button bg-green "  onclick="return shoppingInvoice1(this)">保存发票信息</button> 
 <button class="button dialog-close" >取消</button> 
 </div> </div> </div>
 
 





