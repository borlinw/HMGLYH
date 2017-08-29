
/*var getLoginUserObject = new Object();//用于存储登陆用户的信息
*/
window.moveTo(0,0);
window.resizeTo(window.screen.width,window.screen.height);

var loginUserObject = new Object();//用于存储登陆用户的信息

var createUUID = (function (uuidRegEx, uuidReplacer) {  
    return function () {  
        return "xxxxxxxxxxxx4xxxyxxxxxxxxxxxxxxx".replace(uuidRegEx, uuidReplacer).toUpperCase();  
    };  
})(/[xy]/g, function (c) {  
    var r = Math.random() * 16 | 0,  
        v = c == "x" ? r : (r & 3 | 8);  
    return v.toString(16);  
});



var c1 = true;		//首页
var c2 = true;		//月度计划
var c3 = true;		//巡道记录
var c4 = true;		//病害录入
var c5 = true;		//病害上报
var c6 = true;		//任务派工
var c7 = true;		//维修作业
var c8 = true;		//作业上报
var c9 = true;		//维修验收
var c10 = true;		//冬季除雪
//var c11 = true;		//查询统计
var c11 = true;		//维修整改
var c12 = true;		//查询统计

$(function(){
	//查询登录用户信息 
	YMLib.Ajax.GET("login/userLoginAuthor.do?_="+Math.random(),"","json",function(msg){
		if(msg.state === false){
			document.location.href = "../../index.jsp";
		}else{
			getLoginUserObject = msg;
			YMLib.UI.MaskHide();
			//YMLib.UI.Show("登陆成功！",2000);
		}
	},function(e){
		alert("验证登陆与请求权限 login/userLoginAuthor.do 出错");
		YMLib.UI.MaskHide();
	});
	YMLib.Tools.ShowPage();
	$("li").show();
	//首页
	$("#Menu_1").click(function(){
		$("#show").children("div").hide();
		$("#c1").show();
		if(c1){
			$("#c1f").attr("src", "");
            c1 = false;
		}
	});
	//月度计划
	$("#Menu_2").click(function(){
		$("#show").children("div").hide();
		$("#c2").show();
		if(c2){
			$("#c2f").attr("src", "ydjh/rcyh_ydjh.jsp");
            c2 = false;
		}
	});
	//巡道记录
	$("#Menu_3").click(function(){
		$("#show").children("div").hide();
		$("#c3").show();
		if(c3){
			$("#c3f").attr("src", "");
            c3 = false;
		}
	});
	//病害录入
	$("#Menu_4").click(function(){
		$("#show").children("div").hide();
		$("#c4").show();
		if(c4){
			$("#c4f").attr("src", "");
            c4 = false;
		}
	});
	//病害上报
	$("#Menu_5").click(function(){
		$("#show").children("div").hide();
		$("#c5").show();
		if(c5){
			$("#c5f").attr("src", "");
            c5 = false;
		}
	});
	//任务派工
	$("#Menu_6").click(function(){
		$("#show").children("div").hide();
		$("#c6").show();
		if(c6){
			$("#c6f").attr("src", "");
            c6 = false;
		}
	});
	//维修作业
	$("#Menu_7").click(function(){
		$("#show").children("div").hide();
		$("#c7").show();
		if(c7){
			$("#c7f").attr("src", "");
            c7 = false;
		}
	});
	//作业上报
	$("#Menu_8").click(function(){
		$("#show").children("div").hide();
		$("#c8").show();
		if(c8){
			$("#c8f").attr("src", "");
            c8 = false;
		}
	});
	//维修验收
	$("#Menu_9").click(function(){
		$("#show").children("div").hide();
		$("#c9").show();
		if(c9){
			$("#c9f").attr("src", "");
            c9 = false;
		}
	});
	//冬季除雪
	$("#Menu_10").click(function(){
		$("#show").children("div").hide();
		$("#c10").show();
		if(c10){
			$("#c10f").attr("src", "");
            c10 = false;
		}
	});
	//维修整改（ LR - 改 ）
	$("#Menu_11").click(function(){
		$("#show").children("div").hide();
		$("#c11").show();
		if(c11){
			$("#c11f").attr("src", "wxzg.jsp");
            c11 = false;
		}
	});
	//查询统计（原编码为11 - LR改）
	$("#Menu_12").click(function(){
		$("#show").children("div").hide();
		$("#c12").show();
		if(c12){
			$("#c12f").attr("src", "cxtj/index.jsp");
		}
	});
});
	
