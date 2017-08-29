
var getLoginUserObject = new Object();//用于存储登陆用户的信息

var checkedMenuid = "";//记载被选中的标签的id：方便重置上一个被选中的菜单

window.moveTo(0,0);
window.resizeTo(window.screen.width,window.screen.height);

var c1 = true;		//病害类别管理
var c2 = true;		//作业项目类别管理
var c3 = true;		//工料机管理
var c4 = true;		//部门管理
var c5 = true;		//路段管理
var c6 = true;		//人员管理
var c7 = true;		//用户管理
var c8 = true;		//角色权限管理


$(function(){
	//getLoginUserObject = YMLib.Tools.getParameter("getLoginUserObject");//记录当前登陆用户的信息
	//alert("Js中如何将Object转换为Json或者其他字符串以便于传输");
	//alert("a标签回传的String ==> "+getLoginUserJson);
	//getLoginUserObject = eval("("+getLoginUserJson+")");
	//alert("getLoginUserObject.bmcode="+getLoginUserObject.bmcode);
	//获取、验证用户登录信息
	/**Strat**/
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
	/**End**/
	YMLib.Tools.ShowPage();
	$("li").show();

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
	$("#bhlx").click(function(){
		$("#bhlx").removeClass("htglindexbhlx");
		$("#bhlx").addClass("htglindexbhlx2");
		restoreMenu("bhlx");//参数为当前点击的menu的id
	});
	$("#yhlb").click(function(){
		$("#yhlb").removeClass("htglindexyhlbgl");
		$("#yhlb").addClass("htglindexyhlbgl2");
		restoreMenu("yhlb");//参数为当前点击的menu的id
	});
	$("#gljgl").click(function(){
		$("#gljgl").removeClass("htglindexgljgl");
		$("#gljgl").addClass("htglindexgljgl2");
		restoreMenu("gljgl");//参数为当前点击的menu的id
	});
	$("#bmgl").click(function(){
		$("#bmgl").removeClass("htglindexbmgl");
		$("#bmgl").addClass("htglindexbmgl2");
		restoreMenu("bmgl");//参数为当前点击的menu的id
	});
	$("#ldgl").click(function(){
		$("#ldgl").removeClass("htglindexldgl");
		$("#ldgl").addClass("htglindexldgl2");
		restoreMenu("ldgl");//参数为当前点击的menu的id
	});
	$("#rygl").click(function(){
		$("#rygl").removeClass("htglindexrygl");
		$("#rygl").addClass("htglindexrygl2");
		restoreMenu("rygl");//参数为当前点击的menu的id
	});
	$("#yhgl").click(function(){
		$("#yhgl").removeClass("htglindexyhgl");
		$("#yhgl").addClass("htglindexyhgl2");
		restoreMenu("yhgl");//参数为当前点击的menu的id
	});
	$("#jsgl").click(function(){
		$("#jsgl").removeClass("htglindexjsqxgl");
		$("#jsgl").addClass("htglindexjsqxgl2");
		restoreMenu("jsgl");//参数为当前点击的menu的id
	});
	/*bhlx
	yhlb
	gljgl
	bmgl
	ldgl
	rygl
	yhgl
	jsgl*/
}

//还原某被选中的menu（参数为此次被选中的id）
function restoreMenu(_menuId){
	//alert("当前被选中的menu ID 为："+checkedMenuid+"，当前被点击的menu ID 为："+_menuId);
	if(checkedMenuid != "" && checkedMenuid != _menuId){
		//alert("已经有按钮被选中。");
		if(checkedMenuid == "bhlx"){
			$("#bhlx").removeClass("htglindexbhlx2");
			$("#bhlx").addClass("htglindexbhlx");
		}else if(checkedMenuid == "yhlb"){
			$("#yhlb").removeClass("htglindexyhlbgl2");
			$("#yhlb").addClass("htglindexyhlbgl");
		}else if(checkedMenuid == "gljgl"){
			$("#gljgl").removeClass("htglindexgljgl2");
			$("#gljgl").addClass("htglindexgljgl");
		}else if(checkedMenuid == "bmgl"){
			$("#bmgl").removeClass("htglindexbmgl2");
			$("#bmgl").addClass("htglindexbmgl");
		}else if(checkedMenuid == "ldgl"){
			$("#ldgl").removeClass("htglindexldgl2");
			$("#ldgl").addClass("htglindexldgl");
		}else if(checkedMenuid == "rygl"){
			$("#rygl").removeClass("htglindexrygl2");
			$("#rygl").addClass("htglindexrygl");
		}else if(checkedMenuid == "yhgl"){
			$("#yhgl").removeClass("htglindexyhgl2");
			$("#yhgl").addClass("htglindexyhgl");
		}else if(checkedMenuid == "jsgl"){
			$("#jsgl").removeClass("htglindexjsqxgl2");
			$("#jsgl").addClass("htglindexjsqxgl");
		}
	}
	checkedMenuid = _menuId;
}

