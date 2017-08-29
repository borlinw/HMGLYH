
window.moveTo(0,0);
window.resizeTo(window.screen.width,window.screen.height);

var checkedMenuid = "";//记载被选中的标签的id：方便重置上一个被选中的菜单  ^ LR

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

var ShowLi = function(){
	var list = loginUserObject.role.auths;
	for(var i=0;i<list.length;i++){
		$("li[kid="+list[i].mkid+"]").show();
	}
};

$(function(){
	//查询登录用户信息
	YMLib.Ajax.GET("login/userLoginAuthor.do?_="+Math.random(),"","json",function(msg){
		if(msg.state === false){
			document.location.href = "../../index.jsp";
		}else{
			loginUserObject = msg;
			YMLib.UI.MaskHide();
			ShowLi();
			$("#userName").text(loginUserObject.ryname);
		}
	},function(e){
		alert("验证登陆与请求权限 login/userLoginAuthor.do 出错");
		YMLib.UI.MaskHide();
	});

	
	YMLib.Tools.ShowPage();
	
	shangeIndexMenu();//加载鼠标点击的时候mnue颜色背景图的变化
	
	//退出登录
	$("#logout").click(function(){
		$.messager.confirm('确认', '确认退出系统？', function(r){
		if(r){
			$.post(YMLib.url+"login/logout.do",function(data) {
				if(data){
					document.location.href = YMLib.url + "index.jsp";
				}
			},'json');
		}
		});
	});
	
	//修改密码
	$("#changePassword").click(function(){
		YMLib.UI.createWindow("edit", "修改密码", YMLib.url+"changePassword.jsp", "box-edit",421,177);
	});
	
});

//定义index列表的鼠标滑过、点击（固定颜色和背景图）方法
function shangeIndexMenu(){
	$("#lkpdLkdc").click(function(){
		$("#lkpdLkdc").removeClass("lkdc");
		$("#lkpdLkdc").addClass("lkdc2");
		restoreMenu("lkpdLkdc");//参数为当前点击的menu的id
	});
	$("#lkpdLmjc").click(function(){
		$("#lkpdLmjc").removeClass("lmjc");
		$("#lkpdLmjc").addClass("lmjc2");
		restoreMenu("lkpdLmjc");//参数为当前点击的menu的id
	});
	$("#lkpdLkpd").click(function(){
		$("#lkpdLkpd").removeClass("lkpd");
		$("#lkpdLkpd").addClass("lkpd2");
		restoreMenu("lkpdLkpd");//参数为当前点击的menu的id
	});
	$("#lkpdLktjfx").click(function(){
		$("#lkpdLktjfx").removeClass("lktjfx");
		$("#lkpdLktjfx").addClass("lktjfx2");
		restoreMenu("lkpdLktjfx");//参数为当前点击的menu的id
	});
	$("#lkpdQyqdhf").click(function(){
		$("#lkpdQyqdhf").removeClass("qyqdhf");
		$("#lkpdQyqdhf").addClass("qyqdhf2");
		restoreMenu("lkpdQyqdhf");//参数为当前点击的menu的id
	});
	$("#lkpdQdhfsh").click(function(){
		$("#lkpdQdhfsh").removeClass("qyqdhf");
		$("#lkpdQdhfsh").addClass("qyqdhf2");
		restoreMenu("lkpdQdhfsh");//参数为当前点击的menu的id
	});
	$("#lkpdJcxx").click(function(){
		$("#lkpdJcxx").removeClass("jcxx");
		$("#lkpdJcxx").addClass("jcxx2");
		restoreMenu("lkpdJcxx");//参数为当前点击的menu的id
	});
}

//还原某被选中的menu（参数为此次被选中的id）
function restoreMenu(_menuId){
	//alert("当前被选中的menu ID 为："+checkedMenuid+"，当前被点击的menu ID 为："+_menuId);
	if(checkedMenuid != "" && checkedMenuid != _menuId){
		//alert("已经有按钮被选中。");
		if(checkedMenuid == "lkpdLkdc"){
			$("#lkpdLkdc").removeClass("lkdc2");
			$("#lkpdLkdc").addClass("lkdc");
		}else if(checkedMenuid == "lkpdLmjc"){
			$("#lkpdLmjc").removeClass("lmjc2");
			$("#lkpdLmjc").addClass("lmjc");
		}else if(checkedMenuid == "lkpdLkpd"){
			$("#lkpdLkpd").removeClass("lkpd2");
			$("#lkpdLkpd").addClass("lkpd");
		}else if(checkedMenuid == "lkpdLktjfx"){
			$("#lkpdLktjfx").removeClass("lktjfx2");
			$("#lkpdLktjfx").addClass("lktjfx");
		}else if(checkedMenuid == "lkpdQyqdhf"){
			$("#lkpdQyqdhf").removeClass("qyqdhf2");
			$("#lkpdQyqdhf").addClass("qyqdhf");
		}else if(checkedMenuid == "lkpdJcxx"){
			$("#lkpdJcxx").removeClass("jcxx2");
			$("#lkpdJcxx").addClass("jcxx");
		}else if(checkedMenuid == "lkpdQdhfsh"){
			$("#lkpdQdhfsh").removeClass("qyqdhf2");
			$("#lkpdQdhfsh").addClass("qyqdhf");
		}
	}
	checkedMenuid = _menuId;
}
