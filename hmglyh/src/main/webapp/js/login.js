//js

//拿值

$(function(){
	$("#userLogin").click(function(){
		toLogin();
	});
	$("body").keydown(function(e){
		if(e.keyCode === 13){
			toLogin();//登陆事件
		}
	});
});

//登陆事件
function toLogin(){
	$("#prompt1").hide();
	$("#prompt2").hide();
	YMLib.UI.MaskShow("正在登录系统...");
	var username = $("#username").val();
	var pw = $("#pw").val();
	if(pw == "" || pw == null){
		$("#prompt1").show();
		YMLib.UI.MaskHide();
	}else{
		//alert("username="+username+"，pw="+pw);
		var pams = "username="+username+"&pw="+pw;
		YMLib.Ajax.POST("login/userlogin.do",pams,"json",function(msg){
			YMLib.UI.MaskHide();
			if(msg.state){
				$.cookie("username",$("#username").val(),{expires:999,path:'/'});
				document.location.href = "main.jsp";
			}else{
				$("#prompt2").show();
				//YMLib.UI.LoginShow(YMLib.Enum.Login[msg.code],3000);
				$("#username").focus();
			}
		},function(error){
			alert("登录后台方法出现错误：login/userlogin.do");
			YMLib.UI.MaskHide();
		});
	}
};

function change(){
		$("#random").attr("src",YMLib.url+"login/random.do?_=" + Math.random());
	}

function tj(){
	 var huser_user= $("#huser_user").val();
	 var huser_pwd= $("#huser_pwd").val();
	 var code =$("#code").val();
	 $.ajax({
		 type : "POST",
		 url : YMLib.url+"login/login.do",
		 dataType : 'json',
		 async : false,
         data :{
        	 huser_user:huser_user,
        	 huser_pwd:huser_pwd,
        	 code:code
         },
		 success: function(msg){
			 alert("aaaa"+msg);
			 if(msg.state == true && msg.code == true){
				 alert("登陆成功");
				 window.location.href = YMLib.url+'page/ht/main.jsp';
			 }else if(msg.state == false && msg.code == true){
				 alert("账号密码错误，请重新输入！");
			 }else{
				 alert("验证码错误");
			 }
		 },
		 error : function(msg){
			 alert(msg);
		}
	 });
}
