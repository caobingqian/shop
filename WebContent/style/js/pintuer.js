(function(jQuery){ 
	
	jQuery.fn.zoomImgRollover = function(options) {

		var defaults = {
			percent:10,
			duration:200
		}; 

		var opts = jQuery.extend(defaults, options);
		
		// static zoom function
		function imageZoomStep(jZoomImage, x, origWidth, origHeight)
		{
			var width = Math.round(origWidth * (.5 + ((x * opts.percent) / 200))) * 2;
			var height = Math.round(origHeight * (.5 + ((x * opts.percent) / 200))) * 2;
				
			var left = (width - origWidth) / 2;
			var top = (height - origHeight) / 2;
		
			jZoomImage.css({width:width, height:height, top:-top, left:-left});
		}

		return this.each(function()
		{
			var jZoomImage = jQuery(this);
			var origWidth = jZoomImage.width();
			var origHeight = jZoomImage.height();
			
			// add css ness. to allow zoom
			jZoomImage.css({position: "relative"});
			jZoomImage.parent().css({overflow: "hidden", display:"block", position: "relative", width: origWidth, height: origHeight});
			
			jZoomImage.mouseover(function()
			{
				jZoomImage.stop().animate({dummy:1},{duration:opts.duration, step:function(x)
				{
					imageZoomStep(jZoomImage, x, origWidth, origHeight)
				}});
			});

			jZoomImage.mouseout(function()
			{
				jZoomImage.stop().animate({dummy:0},{duration:opts.duration, step:function(x)
				{
					imageZoomStep(jZoomImage, x, origWidth, origHeight)
				}});
			});
		});
	};

})(jQuery);



//=====================ȫ�ֺ���========================

//==================ͼƬ��ϸҳ����=====================
//��꾭��Ԥ��ͼƬ����
function preview(img){
	$("#preview .jqzoom img").attr("src",$(img).attr("src"));
	$("#preview .jqzoom img").attr("jqimg",$(img).attr("bimg"));
}

function login(win,url){
	$.ajax({
    type: "POST",
    url: 'login!loginf',
    cache: false,
    async: false,
    data:{
     	username:$(win).closest("form").find('#username').val(),
     	password:$(win).closest("form").find('#password').val()
    },
    success: function(data){
    		if(data=="true") {
    			window.location.href=url;
    		}
    		else {
    			$(win).parent().parent().find('.form-agreen .login_error').html(data);
    		}
    }
 });
}


function formcheck(win){
	$(win).find('textarea, input, select').blur();
	if($(win).find('.input-help').html()==undefined)return true;
	else return false;
}
function formcheckcart(win){
	$(win).parent().parent().find('textarea, input, select').blur();
	if($(win).parent().parent().find('.input-help').html()==undefined)return true;
	else return false;
}
function orderformcheck(){
	$(".orderformcheck").find('textarea, input, select').blur();
	if($(".orderformcheck").find('.input-help').html()==undefined)return true;
	else return false;
}



//ͼƬԤ��Сͼ�ƶ�Ч��,ҳ�����ʱ����
$(function(){
	var tempLength = 0; //��ʱ����,��ǰ�ƶ��ĳ���
	var viewNum = 5; //����ÿ����ʾͼƬ�ĸ�����
	var moveNum = 2; //ÿ���ƶ�������
	var moveTime = 300; //�ƶ��ٶ�,����
	var scrollDiv = $(".spec-scroll .items ul"); //�����ƶ�����������
	var scrollItems = $(".spec-scroll .items ul li"); //�ƶ�������ļ���
	var moveLength = scrollItems.eq(0).width() * moveNum; //����ÿ���ƶ��ĳ���
	var countLength = (scrollItems.length - viewNum) * scrollItems.eq(0).width(); //�����ܳ���,�ܸ���*��������
	  
	//��һ��
	$(".spec-scroll .next").bind("click",function(){
		if(tempLength < countLength){
			if((countLength - tempLength) > moveLength){
				scrollDiv.animate({left:"-=" + moveLength + "px"}, moveTime);
				tempLength += moveLength;
			}else{
				scrollDiv.animate({left:"-=" + (countLength - tempLength) + "px"}, moveTime);
				tempLength += (countLength - tempLength);
			}
		}
	});
	//��һ��
	$(".spec-scroll .prev").bind("click",function(){
		if(tempLength > 0){
			if(tempLength > moveLength){
				scrollDiv.animate({left: "+=" + moveLength + "px"}, moveTime);
				tempLength -= moveLength;
			}else{
				scrollDiv.animate({left: "+=" + tempLength + "px"}, moveTime);
				tempLength = 0;
			}
		}
	});
});

var setAmount = {
		min: 1,
		max: 199,
		count: 1,
		countEl: $('#buy-num'),
		buyLink: $("#choose-btn-append .btn-append"),
		targetLink: $("#choose-btn-append .btn-append"),
		matchCountKey: ["pcount", "pCount", "num"],
		add: function() {
			
			return this.count >= this.max ? !1 : (this.count++, $('#buy-num').val(this.count), this.setBuyLink(), void 0)
		},
		reduce: function() {
			return this.count <= this.min ? !1 : (this.count--, $('#buy-num').val(this.count), this.setBuyLink(), void 0)
		},
		modify: function() {
			var t = parseInt($('#buy-num').val(), 10);
			return "" == $('#buy-num').val() ? !1 : isNaN(t) || this.min > t || t > this.max ? ($('#buy-num').val(this.count), !1) : (this.count = t, this.setBuyLink(), void 0)
		},
		setBuyLink: function() {
			
		}
};
function cartAdd(id){
	$.ajax({
        type: "POST",
        dataType: "json",
        url: 'GoodsServlet',
        cache: false,
        async: false,
        data:{
      	 method:"cartAdd",
      	 id:id
        },
        success: function(data){
      	  if(data.back=="success"){
      		  location.reload();
      	  }
        }
     });
}
function cartDel(id){
	$.ajax({
		type: "POST",
		dataType: "json",
		url: 'GoodsServlet',
		cache: false,
		async: false,
		data:{
			method:"cartDel",
			id:id
		},
		success: function(data){
			if(data.back=="success"){
				location.reload();
			}
		}
	});
}
function cartMod(id,num){
	$.ajax({
		type: "POST",
		dataType: "json",
		url: 'GoodsServlet',
		cache: false,
		async: false,
		data:{
			method:"cartMod",
			num:num,
			id:id
		},
		success: function(data){
			if(data.back=="success"){
				location.reload();
			}
		}
	});
}
var setCartAmount = {
		min: 1,
		max: 199,
		count: 1,
		countEl: $('#buy-num'),
		buyLink: $("#choose-btn-append .btn-append"),
		targetLink: $("#choose-btn-append .btn-append"),
		matchCountKey: ["pcount", "pCount", "num"],
		add: function(id) {
			this.count = $('#buy-num').val();
			return this.count >= this.max ? !1 : (this.count++, $('#buy-num').val(this.count),cartAdd(id), void 0)
		},
		reduce: function(id) {
			this.count = $('#buy-num').val();
			return this.count <= this.min ? !1 : (this.count--, $('#buy-num').val(this.count),cartDel(id), void 0)
		},
		modify: function(id) {
			var t = parseInt($('#buy-num').val(), 10);
			return "" == $('#buy-num').val() ? !1 : isNaN(t) || this.min > t || t > this.max ? ($('#buy-num').val(this.count), !1) : (this.count = t,cartMod(id,t),  void 0)
		}
};

		//The change event of language dropdown-list
         var eDropLangChangeinit = function(){
            //The selected value of the language dropdown-list.
            var selectedValue =  $("#cantonIds").val();
             
             //show all options.
             $("#streetIds").children("span").each(function(){
                 $(this).children().clone().replaceAll($(this));         //use the content of the <span> replace the <span>
             });
             
             //Filter the data through selected value of language dropdown-list except <Please Select>.
             //If the option is <Please Select>, it only needs to show all and hide nothing.
             if(parseInt(selectedValue) != 0){        
                 //hide the option whose parentid is not equal with selected value of language dropdown-list.
                 //The <Please Select> option should not be hidden.
                 $("#streetIds").children("option[parentid!='" + selectedValue + "'][value!='0']").each(function(){
                     $(this).wrap("<span style='display:none'></span>");     //add a <span> around the <option> and hide the <span>.
                 });
             }
         };
         var eDropLangChange = function(){
        	 //The selected value of the language dropdown-list.
        	 var selectedValue = $(this).val();
        	 
        	 //show all options.
        	 $("#streetIds").children("span").each(function(){
        		 $(this).children().clone().replaceAll($(this));         //use the content of the <span> replace the <span>
        	 });
        	 
        	 //Filter the data through selected value of language dropdown-list except <Please Select>.
        	 //If the option is <Please Select>, it only needs to show all and hide nothing.
        	 if(parseInt(selectedValue) != 0){        
        		 //hide the option whose parentid is not equal with selected value of language dropdown-list.
        		 //The <Please Select> option should not be hidden.
        		 $("#streetIds").children("option[parentid!='" + selectedValue + "'][value!='0']").each(function(){
        			 $(this).wrap("<span style='display:none'></span>");     //add a <span> around the <option> and hide the <span>.
        		 });
        	 }
         };
         
         //The change event of frame dropdown-list.
         var eDropFrameChange = function(){
             //Find the selected option of frame dropdown-list. set the value of language dropdown-list by selected parentid.
             $("#cantonIds").val($(this).children("option:selected").attr("parentid"));
         };
         
         //The change event of language dropdown-list
         var eDropLangChange1init = function(){
        	 //The selected value of the language dropdown-list.
        	 var selectedValue = $("#storeClassifyIds").val();
        	 
        	 //show all options.
        	 $("#storeClassifySecondIds").children("span").each(function(){
        		 $(this).children().clone().replaceAll($(this));         //use the content of the <span> replace the <span>
        	 });
        	 
        	 //Filter the data through selected value of language dropdown-list except <Please Select>.
        	 //If the option is <Please Select>, it only needs to show all and hide nothing.
        	 if(parseInt(selectedValue) != 0){        
        		 //hide the option whose parentid is not equal with selected value of language dropdown-list.
        		 //The <Please Select> option should not be hidden.
        		 $("#storeClassifySecondIds").children("option[parentid!='" + selectedValue + "'][value!='0']").each(function(){
        			 $(this).wrap("<span style='display:none'></span>");     //add a <span> around the <option> and hide the <span>.
        		 });
        	 }
         };
         var eDropLangChange1 = function(){
        	 //The selected value of the language dropdown-list.
        	 var selectedValue = $(this).val();
        	 
        	 //show all options.
        	 $("#storeClassifySecondIds").children("span").each(function(){
        		 $(this).children().clone().replaceAll($(this));         //use the content of the <span> replace the <span>
        	 });
        	 
        	 //Filter the data through selected value of language dropdown-list except <Please Select>.
        	 //If the option is <Please Select>, it only needs to show all and hide nothing.
        	 if(parseInt(selectedValue) != 0){        
        		 //hide the option whose parentid is not equal with selected value of language dropdown-list.
        		 //The <Please Select> option should not be hidden.
        		 $("#storeClassifySecondIds").children("option[parentid!='" + selectedValue + "'][value!='0']").each(function(){
        			 $(this).wrap("<span style='display:none'></span>");     //add a <span> around the <option> and hide the <span>.
        		 });
        	 }
         };
         
         //The change event of frame dropdown-list.
         var eDropFrameChange1 = function(){
        	 //Find the selected option of frame dropdown-list. set the value of language dropdown-list by selected parentid.
        	 $("#storeClassifyIds").val($(this).children("option:selected").attr("parentid"));
         };
         
function delGoodsType(){
	var goodsTypeId = $(".addtype .selected ").find("img").attr("data-img");
	$.ajax({
        type: "POST",
        dataType: "json",
        url: 'GoodsTypeServlet',
        cache: false,
        async: false,
        data:{
      	 method:"delete",
      	 id:goodsTypeId
        },
        success: function(data){
      	  if(data.back=="success"){
      		$(".addtype .selected ").replaceWith("");
			$(".box"+goodsTypeId).replaceWith("");
      	  }
        }
     });
	return false;
}
function delGoodsTypeImg(id){
	var goodsTypeId = $(".addtype .selected ").find("img").attr("data-img");
	$.ajax({
		type: "POST",
		dataType: "json",
		url: 'GoodsTypeImgServlet',
		cache: false,
		async: false,
		data:{
			method:"delete",
			id:id
		},
		success: function(data){
			if(data.back=="success"){
				$(".box"+goodsTypeId+" .goodsTypeImgDiv"+id).replaceWith("");
			}
		}
	});
	return false;
	
}

function mobileSearch(id,mark){
	if($(".channel-flag-on").length > 0){
		$(".channel-flag-on").css({"border-left":"0px","background":"#fff"});
		$(".channel-flag-descp-on").css("display","none");
	}
	$("#channel-"+mark+"-"+id).css({"border-left":"3px solid #08d0a8","background":"#ebebeb"});
	$("#channel-"+mark+"-"+id+"-descp").css("display","block");
	$("#channel-"+mark+"-"+id).addClass("channel-flag-on");
	$("#channel-"+mark+"-"+id+"-descp").addClass("channel-flag-descp-on");
}

function strsearch(){
	$("#str").val($("#searchstr").val());
	document.getElementById("storeSearch").submit();
}
function strmsearch(){
	$("#str").val($("#searchstrm").val());
	document.getElementById("storeSearch").submit();
}
function setsearch(str,id,value){
	document.getElementById(str).value=id;
	$("#search_bar2 .searchvalue").text(value);
	$(".drop-menu").parent().removeClass("open");
}
function search(str,id){
	
	document.getElementById(str).value=id;
	document.getElementById("storeSearch").submit();
}
function search2(str,id,str2,id2){
	document.getElementById(str).value=id;
	document.getElementById(str2).value=id2;
	document.getElementById("storeSearch").submit();
}
function search3(str,id,str2,id2,str3,id3){
	document.getElementById(str).value=id;
	document.getElementById(str2).value=id2;
	document.getElementById(str3).value=id3;
	document.getElementById("storeSearch").submit();
}
function searchsubmit(str,id){
	document.getElementById("storeSearch").submit();
}
function shoppingAdd(id,nums,kind){
	var num;
	if(nums=="buy-num"){num=$('#buy-num').val();}
	else {num=nums;}
	$.ajax({
        type: "POST",
        dataType: "json",
        url: 'goods!shoppingCart',
        cache: false,
        async: false,
        data:{
      	 num:num,
      	 id:id,
      	 kind:kind
        },
        success: function(data){
      	  if(data.back=="success"){
      		location.reload();
      	  }else if(data.back=="fail"){
      		alert("已达到限购份数，不能购买更多此产品了！");
      		  location.reload();
      	  }
        }
     });
}
function shoppingdelete(id){
	$.ajax({
		type: "POST",
		dataType: "json",
		url: 'goods!shoppingdelete',
		cache: false,
		async: false,
		data:{
			id:id
		},
		success: function(data){
			if(data.back=="success"){
				$(this).parent().parent().remove();
				location.reload();
			}
		}
	});
}
function shoppingConsigneeMod(win){
	if(formcheckcart(win)){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: 'ConsigneeServlet',
			cache: false,
			async: false,
			data:{
				method:"consignee",
				id:$(".consigneeMod #id").val(),
				del:$(".consigneeMod #del").val(),
				name:$(".consigneeMod #name").val(),
				tel:$(".consigneeMod #tel").val(),
				address:$(".consigneeMod #address").val(),
				email:$(".consigneeMod #email").val()
			},
			success: function(data){
				if(data.back=="success"){
					location.reload();
				}
			}
		});
	}
	return false;
}
function shoppingPayway(win){
	if(formcheckcart(win)){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: 'BuyerServlet',
			cache: false,
			async: false,
			data:{
				method:"payway",
				payway:$("input[name='payway']:checked").val()
			},
			success: function(data){
				if(data.back=="success"){
					location.reload();
				}
			}
		});
	}
	return false;
}
function shoppingInvoice(win){
	if(formcheckcart(win)){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: 'BuyerServlet',
			cache: false,
			async: false,
			data:{
				method:"invoice",
				invoiceHead:$("#invoiceHead").val(),
				invoiceContent:$("input[name='invoiceContent']:checked").val()
			},
			success: function(data){
				if(data.back=="success"){
					location.reload();
				}
			}
		});
	}
	return false;
}
function shoppingConsigneeMod1(win){
	if(formcheckcart(win)){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: 'ConsigneeServlet',
			cache: false,
			async: false,
			data:{
				method:"consignee",
				id:$(".consigneeMod #id1").val(),
				del:$(".consigneeMod #del1").val(),
				name:$(".consigneeMod #name1").val(),
				tel:$(".consigneeMod #tel1").val(),
				address:$(".consigneeMod #address1").val(),
				email:$(".consigneeMod #email1").val()
			},
			success: function(data){
				if(data.back=="success"){
					location.reload();
				}
			}
		});
	}
	return false;
}
function shoppingInvoice1(win){
	if(formcheckcart(win)){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: 'BuyerServlet',
			cache: false,
			async: false,
			data:{
				method:"invoice",
				invoiceHead:$("#invoiceHead1").val(),
				invoiceContent:$("input[name='invoiceContent']:checked").val()
			},
			success: function(data){
				if(data.back=="success"){
					location.reload();
				}
			}
		});
	}
	return false;
}
function shoppingOrderSubmit(){
	if(orderformcheck()){
		$.ajax({
			type: "POST",
			dataType: "json",
			url: 'OrderServlet',
			cache: false,
			async: false,
			data:{
				method:"add"
			},
			success: function(data){
				if(data.back=="success"){
					window.location.href=data.url;
				}
			}
		});
	}
	return false;
}

$(function(){
	$("input[name=url]").val(document.URL);
	$("title").load("backend/sysName.txt",function(data,x){
    	document.title=data;
    });	
	$("atitle").load("backend/sysName.txt",function(data,x){
		document.title=data;
	});	
	$("#mobileselect").change(function(){
		if($("#mobileselect").val()==1){setsearch('strChannel','1','����Ʒ')}
		if($("#mobileselect").val()==2){setsearch('strChannel','2','�ѵ���')}
		if($("#mobileselect").val()==3){setsearch('strChannel','3','���ֵ�')}
	});
	
	
	$(".activity li a,.foota a,.hotstore strong,.sellerMenu a,.buyerMenu a").hover(function(){
		$(this).stop(true,false).animate({marginLeft:5},"fast");
	},function(){
		$(this).animate({marginLeft:0},"fast");
	});
	
	//
	$(".case .x4,.caselist .x3").hover(function(){
		$("p",this).stop().animate({bottom:"40px"},300);
	},function(){
		$("p",this).stop().animate({bottom:"-1px"},300);
	})
	
	
	
	$(".pl-item").mouseenter(function(){
		$(this).addClass("hover");
	}).mouseleave(function(){
		$(this).removeClass("hover");
	});
	
	if($(".spec-preview").length > 0){
		$(".spec-preview img").attr("src",$(".addtypeimgvisibles img").attr("src"));
		$(".spec-preview img").attr("jqimg",$(".addtypeimgvisibles img").attr("src"));
	}
	
	$(".goodstype .item a").bind("click",function(event){   
		//��ֹ�¼�ð��   
		event.stopPropagation();             
		$(".goodstype .item ").removeClass("selected");
		$(this).parent().addClass("selected");
		$(".addtypeimgvisibles").removeClass("addtypeimgvisibles");
		$(".box"+$(this).find("img").attr("data-img")).addClass("addtypeimgvisibles");
	});  
	$(".addtype .item a").bind("click",function(event){   
        //��ֹ�¼�ð��   
           event.stopPropagation();             
        	$(".addtype .item ").removeClass("selected");
			$(this).parent().addClass("selected");
			$(".addtypeimgvisibles").removeClass("addtypeimgvisibles");
			$(".box"+$(this).find("img").attr("data-img")).addClass("addtypeimgvisibles");
       });  
	if($("#sellerMenuHover").length > 0){
		$("#"+$("#sellerMenuHover").val()).addClass("user-left-hover");
	}
	if($("#buyerMenuHover").length > 0){
		$("#"+$("#buyerMenuHover").val()).addClass("user-left-hover");
	}
	if($("#senderMenuHover").length > 0){
		$("#"+$("#senderMenuHover").val()).addClass("user-left-hover");
	}
	$("#imageupload1").change(function(){
		 uploadfile();
	 });
	 //Bind the change event
	$("#cantonIds").unbind("change", eDropLangChange).bind("change", eDropLangChange);
	 $("#streetIds").unbind("change", eDropFrameChange).bind("change", eDropFrameChange);
	 $("#storeClassifyIds").unbind("change", eDropLangChange1).bind("change", eDropLangChange1);
	 $("#storeClassifySecondIds").unbind("change", eDropFrameChange1).bind("change", eDropFrameChange1);
	 eDropLangChangeinit();
	 eDropLangChange1init();
	 
	 
	  //ͼƬ�ӳټ���
	  $("img.lazy").lazyload({
	      effect : "fadeIn"
	      /*
	      appear : function(elements_left, settings) {
	          console.log("appear");
	          console.log(elements_left);
	          //console.log(this, elements_left, settings);
	      },
	      load : function(elements_left, settings) {
	          console.log("load");
	          console.log(elements_left);
	          //console.log(this, elements_left, settings);
	      }
	      */
	  });
	$("#registm .dialog-body").height($(window).height()-195);
	$("#close-banner").click(function(){ 	
		$(".banner").css("display","none");
	});
	$(".amplify").zoomImgRollover();
	$("#channel-l-kind").click(function(){ 
		$('body,html').animate({scrollTop:"90px"},10);
		if($(".icon-sort-boolflag").length > 0){
			$(".channel-l").css("z-index","15");
			$(".dialog-mask").remove();
			
			$(".channel-c-sort").hide();
			$("#channel-l-area").css("color","#31282b");
			$("#channel-l-area .icon-sort-asc-diy").addClass("icon-sort-desc-diy").removeClass("icon-sort-asc-diy");
			$("#channel-l-area").removeClass("icon-sort-boolflag");
			
			$(".channel-l-sort").slideUp({
				  duration: 400,
				  easing: 'easeOutCirc'
			  });
			$("#channel-l-kind").css("color","#31282b");
			$("#channel-l-kind .icon-sort-asc-diy").addClass("icon-sort-desc-diy").removeClass("icon-sort-asc-diy");
			$("#channel-l-kind").removeClass("icon-sort-boolflag");
		}
		else{
			$(".channel-l").css("z-index","9999");
			var masklayout=$('<div class="dialog-mask"></div>');
			if($(".dialog-mask").length <= 0){
				$("body").append(masklayout);
			}
			$(".channel-l-sort").slideDown({
				  duration: 400,
				  easing: 'easeOutCirc'
			  });
			$("#channel-l-kind").css("color","#08d0a8");
			$("#channel-l-kind .icon-sort-desc-diy").addClass("icon-sort-asc-diy").removeClass("icon-sort-desc-diy");
			$("#channel-l-kind").addClass("icon-sort-boolflag");
		};	
	});
	$("#channel-l-area").click(function(){ 
		$('body,html').animate({scrollTop:"90px"},10);
		if($(".icon-sort-boolflag").length > 0){
			$(".channel-l").css("z-index","15");
			$(".dialog-mask").remove();
			
			$(".channel-l-sort").slideUp({
				  duration: 400,
				  easing: 'easeOutCirc'
			  });
			$("#channel-l-kind").css("color","#31282b");
			$("#channel-l-kind .icon-sort-asc-diy").addClass("icon-sort-desc-diy").removeClass("icon-sort-asc-diy");
			$("#channel-l-kind").removeClass("icon-sort-boolflag");
			
			$(".channel-c-sort").hide();
			$("#channel-l-area").css("color","#31282b");
			$("#channel-l-area .icon-sort-asc-diy").addClass("icon-sort-desc-diy").removeClass("icon-sort-asc-diy");
			$("#channel-l-area").removeClass("icon-sort-boolflag");
		}
		else{
			$(".channel-l").css("z-index","9999");
			var masklayout=$('<div class="dialog-mask"></div>');
			if($(".dialog-mask").length <= 0){
				$("body").append(masklayout);
			}
			$(".channel-c-sort").show();
			$("#channel-l-area").css("color","#08d0a8");
			$("#channel-l-area .icon-sort-desc-diy").addClass("icon-sort-asc-diy").removeClass("icon-sort-desc-diy");
			$("#channel-l-area").addClass("icon-sort-boolflag");
		};	
	});
	$("#store-goods-nav").click(function(){ 
			$(".store-nav-hover").addClass("store-nav-c").removeClass("store-nav-hover");
			$("#store-goods-nav").addClass("store-nav-hover").removeClass("store-nav-c");
			$("#store-goods").css("display","block");
			$("#store-comments").css("display","none");
			$("#store-details").css("display","none");
	});
	$("#store-comments-nav").click(function(){ 
			$(".store-nav-hover").addClass("store-nav-c").removeClass("store-nav-hover");
			$("#store-comments-nav").addClass("store-nav-hover").removeClass("store-nav-c");
			$("#store-goods").css("display","none");
			$("#store-comments").css("display","block");
			$("#store-details").css("display","none");
	});
	$("#store-details-nav").click(function(){ 
			$(".store-nav-hover").addClass("store-nav-c").removeClass("store-nav-hover");
			$("#store-details-nav").addClass("store-nav-hover").removeClass("store-nav-c");
			$("#store-goods").css("display","none");
			$("#store-comments").css("display","none");
			$("#store-details").css("display","block");
	});

	$(".commstar a").click(function(){ 
			$(".commstar a").removeClass("active");
			$(this).addClass("active");
			$(this).parent().find("#goodsCommentStar").val($(this).attr("_val"));
	});
	$(".commstar2 a").click(function(){ 
		$(".commstar2 a").removeClass("active");
		$(this).addClass("active");
		$(this).parent().find("#storeCommentStar").val($(this).attr("_val"));
	});
	$(".user-comment-do-triger").click(function(){ 
			if($(".user-comment-do-triger-flag").length > 0){
				$(".user-comment-do").css("display","none");
				$(this).removeClass("user-comment-do-triger-flag");
			}else{
				$(".user-comment-do").css("display","none");
				$(this).next().find(".user-comment-do").css("display","block");;
				$(this).addClass("user-comment-do-triger-flag");
			}
	});
	$(".user-comment-do-triger1").click(function(){ 
			if($(".user-comment-do-triger-flag1").length > 0){
				$(".user-comment-do1").css("display","none");
				$(this).removeClass("user-comment-do-triger-flag1");
			}else{
				$(".user-comment-do1").css("display","none");
				$(this).next().css("display","block");;
				$(this).addClass("user-comment-do-triger-flag1");
			}
	});
	$(".user-left1-1").click(function(){ 
		if($(".icon-sort-boolflag").length > 0){
			$(".user-left1").css("display","none");
			$(".user-left1-1").css("background","#0a8");
			$(".user-left1-1 .icon-sort-asc-diy").addClass("icon-sort-desc-diy").removeClass("icon-sort-asc-diy");
			$(".user-left1-1").removeClass("icon-sort-boolflag");
		}
		else{
			$(".user-left1").css("display","block");
			$(".user-left1-1").css("background","#08d0a8");
			$(".user-left1-1 .icon-sort-desc-diy").addClass("icon-sort-asc-diy").removeClass("icon-sort-desc-diy");
			$(".user-left1-1").addClass("icon-sort-boolflag");
		};
	});
	$(".mnav .search input").focus(function(){ 
		$(".mnav .search input").css({"width":"100%","font-size":"14px"});
		$(".mnav .search select").css({"z-index":"3","display":"block"});
		$(".mnav .search .sb").css({"z-index":"3","display":"block"});
	});
	$(".mnav .search select").click(function(){ 
		$(".mnav .search input").css({"width":"100%","font-size":"14px"});
		$(".mnav .search select").css({"z-index":"3","display":"block"});
		$(".mnav .search .sb").css({"z-index":"3","display":"block"});
	});
	$(".mnav .search select option").click(function(){ 
		$(".mnav .search select").css({"z-index":"3","display":"block"});
		$(".mnav .search .sb").css({"z-index":"3","display":"block"});
		$(".mnav .search input").css({"width":"50px","font-size":"0px"});
		$(".mnav .search input").focus();
	});
	$(".mnav  .phone-nav-sort a").click(function(){ 
		$(".mnav  .phone-nav-sort a").addClass("show");
	});
	 // �ֻ���������
	 $("#lp-topP-sort").click(function(){
	  $("#lp-topP-sort-ej").height($(window).height()-90);
	  if($("#lp-topP-sort-ej").css("display")=="none"){
		  $(this).addClass("show");
		  $(".phone-nav-sort em span").addClass("open");
		  $("#lp-topP-sort-ej").slideDown({
			  duration: 300,
			  easing: 'easeOutCirc'
		  });
	  }else{
		$(this).removeClass("show");
		$(".phone-nav-sort em span").removeClass("open");
		$("#lp-topP-sort-ej").slideUp({
			  duration: 300,
			  easing: 'easeOutCirc'
		  });
	  };
	  $("#lp-topP-sort-ej").find(".closenav").click(function(){
		  $("#lp-topP-sort").removeClass("show");
		  $("#lp-topP-sort-ej").slideUp({
				duration: 300,
				easing: 'easeOutCirc'
			});
	  });
	});
	$("#shoppingcart dt").mouseover(function(){
		  $("#shoppingcart dl").addClass("hover");
		  $("#shoppingcart dd").slideDown({
			  duration: 300,
			  easing: 'easeOutCirc'
		  });
	 });
	$("#shoppingcart dl").mouseleave(function(){
		  $("#shoppingcart dl").removeClass("hover");
		  $("#shoppingcart dd").slideUp({
			  duration: 300,
			  easing: 'easeOutCirc'
		  });
	 });
	 $("#m-shoppingcart dt").click(function(){
		 var masklayout=$('<div class="dialog-mask12"></div>');
		 if($(".m-shoppingcart-flag").length > 0){
			 $(".m-shoppingcart").css("z-index","14");
			 $("#m-shoppingcart #settleup-url").text("�ҵĹ��ﳵ");
			 $(".dialog-mask12").remove();
			 $("#m-shoppingcart dl").removeClass("hover");
			 $("#m-shoppingcart dd").slideUp({
				  duration: 200,
				  easing: 'easeOutCirc'
			  });
			 $("#m-shoppingcart").removeClass("m-shoppingcart-flag");
		 }else{ 
			 $(".m-shoppingcart").css("z-index","9999");
			 $("#m-shoppingcart #settleup-url").text("�����ﳵ");
			 $("body").append(masklayout);
			 $("#m-shoppingcart dl").addClass("hover");
			 $("#m-shoppingcart dd").slideDown({
				  duration: 200,
				  easing: 'easeOutCirc'
			  });
			 $("#m-shoppingcart").addClass("m-shoppingcart-flag");
		 }
		  
	 });
	 document.onscroll = function(){
		 if($(window).scrollTop()>90){
			$(".m-shoppingcart").css("display","block");
		 }else{
			$(".m-shoppingcart").css("display","none");
		 }
	 };
	 $("#m-shoppingcart .settleup-content,#m-shoppingcart dd").width($(window).width());
	 
	 $("#comments-list .mt li").click(function(){
		 $("#comments-list .mt li").removeClass("curr");
		 $(this).addClass("curr");
		 $(".comments-list ").css("display","none");
		 $("#"+$(this).attr("data-widget")).css("display","block");
		 
	 });
	 
	 


	$(".win-homepage").click(function(){ 
        if(document.all){
        document.body.style.behavior = 'url(#default#homepage)'; 
        document.body.setHomePage(document.URL); 
        }else{alert("������ҳʧ�ܣ����ֶ����ã�");} 
	});
	$(".win-favorite").click(function(){
		var sURL=document.URL; 
		var sTitle=document.title; 
		try {window.external.addFavorite(sURL, sTitle);} 
		catch(e){ 
			try{window.sidebar.addPanel(sTitle, sURL, "");} 
			catch(e){alert("�����ղ�ʧ�ܣ���ʹ��Ctrl+D�������");} 
		}
	});
	$(".win-forward").click(function(){
		window.history.forward(1);
	});
	$(".win-back").click(function(){
		window.history.back(-1);
	});
	$(".win-backtop").click(function(){$('body,html').animate({scrollTop:0},1000);return false;});
	$(".win-refresh").click(function(){
		window.location.reload();
	});
	$(".win-print").click(function(){
		window.print();
	});
	$(".win-close").click(function(){
		window.close();
	});
	$('.checkall').click(function(){
		var e=$(this);
		var name=e.attr("name");
		var checkfor=e.attr("checkfor");
		var type;
		if (checkfor!='' && checkfor!=null && checkfor!=undefined){
			type=e.closest('form').find("input[name='"+checkfor+"']");
		}else{
			type=e.closest('form').find("input[type='checkbox']");
		};
		if (name=="checkall"){
			$(type).each(function(index, element){
				element.checked=true;
			});
			e.attr("name","ok");
		}else{
			$(type).each(function(index, element){
				element.checked=false;
			});
			e.attr("name","checkall");
		}	
	});
	$('.dropdown-toggle').click(function(){
		$(this).closest('.button-group, .drop').addClass("open");
	});
	 $(document).bind("click",function(e){
		 if($(e.target).closest(".button-group.open, .drop.open").length == 0){
			 $(".button-group, .drop").removeClass("open");
		 }
	});
	$checkplaceholder=function(){
		var input = document.createElement('input');
		return 'placeholder' in input;
	};
	$emptyplaceholder=function(element){
		var $content=$(element).val();
		return ($content.length === 0) || $content == $(element).attr("placeholder");
	};
	$showplaceholder=function(element){
		//��Ϊ�ռ������
		if( ($(element).val().length ===0 || $(element).val()==$(element).attr("placeholder")) && $(element).attr("type")!="password"){
			$(element).val($(element).attr("placeholder"));
			$(element).data("pintuerholder",$(element).css("color"));
			$(element).css("color","rgb(169,169,169)");
		}
	};
	var $hideplaceholder=function(element){
		if($(element).data("pintuerholder")){
			$(element).val("");
			$(element).css("color", $(element).data("pintuerholder"));		
			$(element).removeData("pintuerholder");
		}
	};
	if(!$checkplaceholder()){
		$("textarea[placeholder], input[placeholder]").each(function(index, element){
			if($(element).attr("placeholder") || $emptyplaceholder(element)){
				$(element).val($(element).attr("placeholder"));
				$(element).data("pintuerholder",$(element).css("color"));
				$(element).css("color","rgb(169,169,169)");
				$(element).focus(function(){$hideplaceholder($(this));});
				$(element).blur(function(){$showplaceholder($(this));});
			};
		});
	};
	$('textarea, input, select').blur(function(){
		var e=$(this);
		if(e.attr("data-validate")){
			e.closest('.field').find(".input-help").remove();
			var $checkdata=e.attr("data-validate").split(',');
			var $checkvalue=e.val();
			var $checkstate=true;
			var $checktext="";
			if(e.attr("placeholder")==$checkvalue){$checkvalue="";}
			if($checkvalue!="" || e.attr("data-validate").indexOf("required")>=0){
				for(var i=0;i<$checkdata.length;i++){
					var $checktype=$checkdata[i].split(':');
					if(! $pintuercheck(e,$checktype[0],$checkvalue)){
						$checkstate=false;
						$checktext=$checktext+"<li>"+$checktype[1]+"</li>";
					}
				}
			};
			if($checkstate){
				e.closest('.form-group').removeClass("check-error");
				e.parent().find(".input-help").remove();
				e.closest('.form-group').addClass("check-success");
			}else{
				e.closest('.form-group').removeClass("check-success");
				e.closest('.form-group').addClass("check-error");
				e.closest('.field').append('<div class="input-help"><ul>'+$checktext+'</ul></div>');
			}
		}
	});
	$pintuercheck=function(element,type,value){
		$pintu=value.replace(/(^\s*)|(\s*$)/g, "");
		switch(type){
			case "required":return /[^(^\s*)|(\s*$)]/.test($pintu);break;
			case "chinese":return /^[\u0391-\uFFE5]+$/.test($pintu);break;
			case "number":return /^\d+$/.test($pintu);break;
			case "integer":return /^[-\+]?\d+$/.test($pintu);break;
			case "plusinteger":return /^[+]?\d+$/.test($pintu);break;
			case "double":return /^[-\+]?\d+(\.\d+)?$/.test($pintu);break;
			case "plusdouble":return /^[+]?\d+(\.\d+)?$/.test($pintu);break;
			case "english":return /^[A-Za-z]+$/.test($pintu);break;
			case "username":return /^[a-z]\w{3,}$/i.test($pintu);break;
			case "mobile":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/.test($pintu);break;
			case "phone":return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "tel":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/.test($pintu) || /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "email":return /^[^@]+@[^@]+\.[^@]+$/.test($pintu);break;
			case "url":return /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/.test($pintu);break;
			case "ip":return /^[\d\.]{7,15}$/.test($pintu);break;
			case "qq":return /^[1-9]\d{4,10}$/.test($pintu);break;
			case "currency":return /^\d+(\.\d+)?$/.test($pintu);break;
			case "zip":return /^[1-9]\d{5}$/.test($pintu);break;
			case "radio":
				var radio=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
				return eval(radio==1);
				break;
			default:
				var $test=type.split('#');
				if($test.length>1){
					switch($test[0]){
						case "compare":
							return eval(Number($pintu)+$test[1]);
							break;
						case "regexp":
							return new RegExp($test[1],"gi").test($pintu);
							break;
						case "length":
							var $length;
							if(element.attr("type")=="checkbox"){
								$length=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
							}else{
								$length=$pintu.replace(/[\u4e00-\u9fa5]/g,"***").length;
							}
							return eval($length+$test[1]);
							break;
						case "ajax":
							var $getdata;
							var $url=$test[1]+$pintu;
							$.ajaxSetup({async:false});
							$.getJSON($url,function(data){
								$getdata=data.success;
							});
							if($getdata=="false"){return true;}
							break;
						case "repeat":
							return $pintu==jQuery('#'+$test[1]).val();
							break;
						default:return true;break;
					}
					break;
				}else{
					return true;
				}
		}
	};
	$('form').submit(function(){
		$(this).find('input[data-validate],textarea[data-validate],select[data-validate]').trigger("blur");
		$(this).find('input[placeholder],textarea[placeholder]').each(function(){$hideplaceholder($(this));});
		var numError = $(this).find('.check-error').length;
		if(numError){
			$(this).find('.check-error').first().find('input[data-validate],textarea[data-validate],select[data-validate]').first().focus().select();
			return false;
		}
	});
	$('.form-reset').click(function(){
		$(this).closest('form').find(".input-help").remove();
		$(this).closest('form').find('.form-submit').removeAttr('disabled');
		$(this).closest('form').find('.form-group').removeClass("check-error");
		$(this).closest('form').find('.form-group').removeClass("check-success");
	});
	$('.tab .tab-nav li').each(function(){
		var e=$(this);
		var trigger=e.closest('.tab').attr("data-toggle");
		if (trigger=="hover"){
			e.mouseover(function(){
				$showtabs(e);
			});
			e.click(function(){
				return false;
			});
		}else{
			e.click(function(){
				$showtabs(e);
				return false;
			});
		}
	});
	$showtabs=function(e){
		var detail=e.children("a").attr("href");
		e.closest('.tab .tab-nav').find("li").removeClass("active");
		e.closest('.tab').find(".tab-body .tab-panel").removeClass("active");
		e.addClass("active");
		$(detail).addClass("active");
	};
	$('.dialogs').each(function(){
		
		var e=$(this);
		var trigger=e.attr("data-toggle");
		if (trigger=="hover"){
			e.mouseover(function(){
				$showdialogs(e);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$showdialogs(e);
			});
		}
	});
	$showdialogs=function(e){
		var trigger=e.attr("data-toggle");
		var getid=e.attr("data-target");
		var data=e.attr("data-url");
		var mask=e.attr("data-mask");
		var width=e.attr("data-width");
		
		var detail="";
		var masklayout=$('<div class="dialog-mask"></div>');
		if(width==null){width="80%";}
		
		if (mask=="1"){
			$("body").append(masklayout);
		}

		detail='<div class="dialog-win" style="position:fixed;width:'+width+';z-index:9999;">';
		if(getid!=null){detail=detail+$(getid).html();}
		if(data!=null){detail=detail+$.ajax({url:data,async:false}).responseText;}
		detail=detail+'</div>';
		
		var olddetail = $(getid).html();
		$(getid).html(detail);
		$(getid).find(".dialog").addClass("open");
		
		var x=parseInt($(window).width()-$(getid+" .dialog-win").outerWidth())/2;
		var y=parseInt($(window).height()-$(getid+" .dialog-win").outerHeight())/2;
		if (y<=10){y="10"}
		$(getid+" .dialog-win").css({"left":x,"top":y});
		
		
		$(getid+" .dialog-win").find("textarea,input,select").blur(function(){
			var password1=$(getid+" .dialog-win").find("#password1").val();
			var password2=$(getid+" .dialog-win").find("#password2").val();
			var e=$(this);
			if(e.attr("data-validate")){
				e.closest('.field').find(".input-help").remove();
				var $checkdata=e.attr("data-validate").split(',');
				var $checkvalue=e.val();
				var $checkstate=true;
				var $checktext="";
				if(e.attr("placeholder")==$checkvalue){$checkvalue="";}
				if($checkvalue!="" || e.attr("data-validate").indexOf("required")>=0){
					for(var i=0;i<$checkdata.length;i++){
						var $checktype=$checkdata[i].split(':');
						if(! $pintuercheckdiy(e,$checktype[0],$checkvalue,password1,password2)){
							$checkstate=false;
							$checktext=$checktext+"<li>"+$checktype[1]+"</li>";
						}
					}
				};
				if($checkstate){
					e.closest('.form-group').removeClass("check-error");
					e.parent().find(".input-help").remove();
					e.closest('.form-group').addClass("check-success");
				}else{
					e.closest('.form-group').removeClass("check-success");
					e.closest('.form-group').addClass("check-error");
					e.closest('.field').append('<div class="input-help"><ul>'+$checktext+'</ul></div>');
				}
			}
		});
		
		
		var olduploadsuccess = $("#uploadsuccess .dialog").children();
		$(getid).find(".buttonUpload").click(function(){
			$(getid).children().children().html($("#uploadsuccess .dialog").children());
			
		});
		$(".dialog-close,.close").each(function(){
			$(this).click(function(){
				$('.dialog-mask').remove();
				$(getid).html(olddetail);
				$("#uploadsuccess .dialog").html(olduploadsuccess);
			});
		});
/*
 		masklayout.click(function(){
			$(getid).html(olddetail);
			$(this).remove();
			$("#uploadsuccess .dialog").html(olduploadsuccess);
		});
*/
		
		
		
		$(".consigneeFormVis").click(function(){
			$("#consigneeMod .dialog-body").height($(window).height()-170);
			$("#consigneeMod .dialog-win").css({"top":20});
			if($(".addtypeimgvisibles").length <= 0){
				$(".consigneeMod").addClass("addtypeimgvisibles");
			}
		});
		$(".consigneeList").click(function(){
			$(".consigneeLists").find(".hover").removeClass("hover");
			$(this).addClass("hover");
			$(this).parent().find("input").removeAttr("checked");
			$(this).find("input").prop("checked","checked");
			$(".consigneeMod").find("#id").val($(this).find(".id").text());
			$(".consigneeMod").find("#name").val($(this).find(".name").text());
			$(".consigneeMod").find("#address").val($(this).find(".address").text());
			$(".consigneeMod").find("#tel").val($(this).find(".tel").text());
			$(".consigneeMod").find("#email").val($(this).find(".email").text());
		});
		$(".consigneeDel").click(function(){
			$(".consigneeMod").find("#del").val($(".consigneeMod").find("#del").val()+"::"+$(this).parent().find(".id").text());
			$(this).parent().remove();
		});
		
		
		
		
		
		
		
		
		
		
		
	};
	$pintuercheckdiy=function(element,type,value,password1,password2){
		$pintu=value.replace(/(^\s*)|(\s*$)/g, "");
		switch(type){
			case "required":return /[^(^\s*)|(\s*$)]/.test($pintu);break;
			case "chinese":return /^[\u0391-\uFFE5]+$/.test($pintu);break;
			case "number":return /^\d+$/.test($pintu);break;
			case "integer":return /^[-\+]?\d+$/.test($pintu);break;
			case "plusinteger":return /^[+]?\d+$/.test($pintu);break;
			case "double":return /^[-\+]?\d+(\.\d+)?$/.test($pintu);break;
			case "plusdouble":return /^[+]?\d+(\.\d+)?$/.test($pintu);break;
			case "english":return /^[A-Za-z]+$/.test($pintu);break;
			case "username":return /^[a-z]\w{3,}$/i.test($pintu);break;
			case "mobile":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/.test($pintu);break;
			case "phone":return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "tel":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/.test($pintu) || /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "email":return /^[^@]+@[^@]+\.[^@]+$/.test($pintu);break;
			case "url":return /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/.test($pintu);break;
			case "ip":return /^[\d\.]{7,15}$/.test($pintu);break;
			case "qq":return /^[1-9]\d{4,10}$/.test($pintu);break;
			case "currency":return /^\d+(\.\d+)?$/.test($pintu);break;
			case "zip":return /^[1-9]\d{5}$/.test($pintu);break;
			case "radio":
				var radio=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
				return eval(radio==1);
				break;
			default:
				var $test=type.split('#');
				if($test.length>1){
					switch($test[0]){
						case "compare":
							return eval(Number($pintu)+$test[1]);
							break;
						case "regexp":
							return new RegExp($test[1],"gi").test($pintu);
							break;
						case "length":
							var $length;
							if(element.attr("type")=="checkbox"){
								$length=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
							}else{
								$length=$pintu.replace(/[\u4e00-\u9fa5]/g,"***").length;
							}
							return eval($length+$test[1]);
							break;
						case "ajax":
							var $getdata;
							var $url=$test[1]+$pintu;
							$.ajaxSetup({async:false});
							$.getJSON($url,function(data){
								$getdata=data.success;
							});
							if($getdata=="false"){return true;}
							break;
						case "repeat":
							if($test[1]=="password1"){
								return $pintu==password1;
							}else{
								return $pintu==password2;
							}
							break;
						default:return true;break;
					}
					break;
				}else{
					return true;
				}
		}
	};
	$('.tips').each(function(){
		var e=$(this);
		var title=e.attr("title");
		var trigger=e.attr("data-toggle");
		e.attr("title","");
		if (trigger=="" || trigger==null){trigger="hover";}
		if (trigger=="hover"){
			e.mouseover(function(){
				$showtips(e,title);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$showtips(e,title);
			});
		}else if(trigger=="show"){
			e.ready(function(){
				$showtips(e,title);
			});
		}
	});
	$showtips=function(e,title){
		var trigger=e.attr("data-toggle");
		var place=e.attr("data-place");
		var width=e.attr("data-width");
		var css=e.attr("data-style");
		var image=e.attr("data-image");
		var content=e.attr("content");
		var getid=e.attr("data-target");
		var data=e.attr("data-url");
		var x=0;
		var y=0;
		var html="";
		var detail="";
		
		if(image!=null){detail=detail+'<img class="image" src="'+image+'" />';}
		if(content!=null){detail=detail+'<p class="tip-body">'+content+'</p>';}
		if(getid!=null){detail=detail+$(getid).html();}
		if(data!=null){detail=detail+$.ajax({url:data,async:false}).responseText;}
		if(title!=null && title!=""){
			if(detail!=null && detail!=""){detail='<p class="tip-title"><strong>'+title+'</strong></p>'+detail;}else{detail='<p class="tip-line">'+title+'</p>';}
		}
		detail='<div class="tip">'+detail+'</div>';
		html=$(detail);

		$("body").append( html );
		if(width!=null){
			html.css("width",width);
		}
		if(place=="" || place==null){place="top";}
		if(place=="left"){
			x=e.offset().left - html.outerWidth()-5;
			y=e.offset().top - html.outerHeight()/2 + e.outerHeight()/2;
		}else if(place=="top"){
			x=e.offset().left - html.outerWidth()/2 + e.outerWidth()/2;
			y=e.offset().top - html.outerHeight()-5;
		}else if(place=="right"){
			x=e.offset().left + e.outerWidth()+5;
			y=e.offset().top - html.outerHeight()/2 + e.outerHeight()/2;
		}else if(place=="bottom"){
			x=e.offset().left - html.outerWidth()/2 + e.outerWidth()/2;
			y=e.offset().top + e.outerHeight()+5;
		}
		if (css!=""){html.addClass(css);}
		html.css({"left":x+"px","top":y+"px","position":"absolute"});
		if (trigger=="hover" || trigger=="click" || trigger==null){
			e.mouseout(function(){html.remove();e.attr("title",title)});
		}
	};
	
	$('.alert .close').each(function(){
		$(this).click(function(){
			$(this).closest('.alert').remove();
		});
	});
	$('.radio label').each(function(){
		var e=$(this);
		if(e.find('input').is(':checked')){
			e.addClass("active");
		}else{
			e.removeClass("active");
		};
		e.click(function(){
			e.closest('.radio').find("label").removeClass("active");
			e.addClass("active");
		});
	});
	$('.checkbox label').each(function(){
		var e=$(this);
		e.click(function(){
			if(e.find('input').is(':checked')){
				e.addClass("active");
			}else{
				e.removeClass("active");
			};
		});
	});
	$('.collapse .panel-head').each(function(){
		var e=$(this);
		e.click(function(){
			e.closest('.collapse').find(".panel").removeClass("active");
			e.closest('.panel').addClass("active");
		});
	});
	$('.icon-navicon').each(function(){
		var e=$(this);
		var target=e.attr("data-target");
		e.click(function(){
			$(target).toggleClass("nav-navicon");
		});
	});
	$('.banner').each(function(){
		var e=$(this);
		var pointer=e.attr("data-pointer");
		var interval=e.attr("data-interval");
		var style=e.attr("data-style");
		var items=e.attr("data-item");
		var items_s=e.attr("data-small");
		var items_m=e.attr("data-middle");
		var items_b=e.attr("data-big");
		var num=e.find(".carousel .item").length;
		var win=$(window).width();
		var i=1;

		if(interval==null){interval=5};
		if(items==null || items<1){items=1};
		if(items_s!=null && win>760){items=items_s};
		if(items_m!=null && win>1000){items=items_m};
		if(items_b!=null && win>1200){items=items_b};

		var itemWidth=Math.ceil(e.outerWidth()/items);
		var page=Math.ceil(num/items);
		e.find(".carousel .item").css("width",itemWidth+ "px");
		e.find(".carousel").css("width",itemWidth*num + "px");
		
		var carousel=function(){
			i++;
			if(i>page){i=1;}
			$showbanner(e,i,items,num);
		};
		var play=setInterval(carousel,interval*600);
		
		e.mouseover(function(){clearInterval(play);});
		e.mouseout(function(){play=setInterval(carousel,interval*600);});
		
		if(pointer!=0 && page>1){
			var point='<ul class="pointer"><li value="1" class="active"></li>';
			for (var j=1;j<page;j++){
				point=point+' <li value="'+(j+1)+'"></li>';
			};
			point=point+'</ul>';
			var pager=$(point);
			if(style!=null){pager.addClass(style);};
			e.append(pager);
			pager.css("left",e.outerWidth()*0.5 - pager.outerWidth()*0.5+"px");
			pager.find("li").click(function(){
				$showbanner(e,$(this).val(),items,num);
			});
			var lefter=$('<div class="pager-prev icon-angle-left"></div>');
			var righter=$('<div class="pager-next icon-angle-right"></div>');
			if(style!=null){lefter.addClass(style);righter.addClass(style);};
			e.append(lefter);
			e.append(righter);
			
			lefter.click(function(){
				i--;
				if(i<1){i=page;}
				$showbanner(e,i,items,num);
			});
			righter.click(function(){
				i++;
				if(i>page){i=1;}
				$showbanner(e,i,items,num);
			});
		};
	});	
	$showbanner=function(e,i,items,num){
		var after=0,leftx=0;
		leftx = - Math.ceil(e.outerWidth()/items)*(items)*(i-1);
		if(i*items > num){after=i*items-num;leftx= - Math.ceil(e.outerWidth()/items)*(num-items);};
		e.find(".carousel").stop(true, true).animate({"left":leftx+"px"},800);
		e.find(".pointer li").removeClass("active");
		e.find(".pointer li").eq(i-1).addClass("active");
	};
	$(".spy a").each(function(){
		var e=$(this);
		var t=e.closest(".spy");
		var target=t.attr("data-target");
		var top=t.attr("data-offset-spy");
		var thistarget="";
		var thistop="";
		if(top==null){top=0;};
		if(target==null){thistarget=$(window);}else{thistarget=$(target);};
		
		thistarget.bind("scroll",function(){
			if(target==null){
				thistop=$(e.attr("href")).offset().top - $(window).scrollTop() - parseInt(top);	
			}else{
				thistop=$(e.attr("href")).offset().top - thistarget.offset().top - parseInt(top);
			};
	
			if(thistop<0){
				t.find('li').removeClass("active");
				e.parents('li').addClass("active");
			};

		});
	});
	$(".fixed").each(function(){
		var e=$(this);
		var style=e.attr("data-style");
		var top=e.attr("data-offset-fixed");
		if(top==null){top=e.offset().top;}else{top=e.offset().top - parseInt(top);};
		if(style==null){style="fixed-top";};
		
		$(window).bind("scroll",function(){
			var thistop=top - $(window).scrollTop();
			if(style=="fixed-top" && thistop<0){
				e.addClass("fixed-top");
			}else{
				e.removeClass("fixed-top");
			};
			
			var thisdiy=top - $(window).scrollTop();
			if(style=="fixed-diy" && thisdiy<12){
				e.addClass("fixed-diy");
			}else{
				e.removeClass("fixed-diy");
			};

			var thisbottom=top - $(window).scrollTop()-$(window).height();
			if(style=="fixed-bottom" && thisbottom>0){
				e.addClass("fixed-bottom");
			}else{
				e.removeClass("fixed-bottom");
			};
		});

	});

})







