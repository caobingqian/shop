
function cambiar_login() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               

setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  }

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  


}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }
function register(){
   var user=$('#user').val();
   var psd=$('#psd1').val();
   var psd1=$('#psd2').val();
  $.ajax({
		type:"get",
		url:"http://datainfo.duapp.com/shopdata/userinfo.php",
		data:{status:'register',userID:user,password:psd},
       dataType:'json',
		success:function(data){
			console.log(data);
			if (psd==psd1) {
				if(data == 0){alert('此用户名已被注册');}
				if(data == 1){window.location.href="login.html";}
				}
			else{
				alert('两次输入密码不一致');
			}					
		}
	});
}
function login(){
    var txt=$('#name').val();
    var pho=$('#psd').val();
   $.ajax({
		type:"get",
		url:"http://datainfo.duapp.com/shopdata/userinfo.php",
		data:{status:'login',userID:txt,password:pho},
		dataType:'json',
		success:function(data){
			console.log(data);
			if(data == 0){
				alert('此用户名未被注册');
			}
			else if(data == 2)
			{
				alert('密码与用户名不匹配');
			}
			else{
				window.location.href="login.html"
			}
		}
	});
}
