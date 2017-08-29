var loginUserObject = null;

function cjkEncode(text) {                                                                           
	if (text == null) {          
		return "";          
	}          
	var newText = "";          
	for (var i = 0; i < text.length; i++) {          
		var code = text.charCodeAt (i);           
		if (code >= 128 || code == 91 || code == 93) {  //91 is "[", 93 is "]".          
			newText += "[" + code.toString(16) + "]";          
		} else {          
			newText += text.charAt(i);          
		}          
	}          
	return newText;          
};

var initCombo = function(){
	$("#depart").combotree({
		url : YMLib.url + "bm/getBmCombotree.do?bmcode="+loginUserObject.bmcode,
		panelHeight : 300,
		onSelect : function(node){
			if(!$("#depart").combotree("tree").tree("isLeaf",node.target)){
				YMLib.UI.Show("请选择养护队或者养护站！",1000);
				$("#depart").combotree("clear");
			}
		}
	});
	$("#yf").combobox({
		url : YMLib.url + "nyb/getYf.do",
		panelHeight : 300,
		textField : "yname",
		valueField : "yname",
		onLoadSuccess : function(){
			var data = $("#yf").combobox("getData");
			$("#yf").combobox("setValue",data[0].yname);
		}
	});
};

var initQuery = function(){
	$("#query").click(function(){
		if($("#depart").combobox("getValue") == ""){
			YMLib.UI.Show("请选择管养单位",2000);
			return;
		}
		var params = "bmCode="+$("#depart").combotree("getValue")+"&ssny="+$("#yf").combobox("getValue")+"&tbUserName="+loginUserObject.username
					+"&tbrxm="+loginUserObject.ryname+"&fzrxm="+loginUserObject.fzr+"&bmlx="+loginUserObject.bmlx;
		YMLib.Ajax.POST("kqzb/getZbid.do",params,"json",function(result){
			if($("#count").val()==""){
				if(!result.saved){
					YMLib.UI.Show("请输入全勤天数",2000);
					return;
				}else{
					$("#reportFrame").attr("src",YMLib.reportUrl + cjkEncode("reportlet=考勤表.cpt&kqid="+result.kqid+"&count=0&__bypagesize__=false"));
				}
			}else if(!$("#count").validatebox("isValid")||$("#count").val()==0){
				YMLib.UI.Show("全勤天数格式不对",2000);
				return;
			}else{
				var src = YMLib.reportUrl + cjkEncode("reportlet=考勤表.cpt&op=write&kqid="+result.kqid+"&count="+$("#count").val());
				$("#reportFrame").attr("src",src);
			}
		},function(){
			YMLib.UI.Show("查询失败",2000);
		});
	});
};

$(function(){
	YMLib.UI.MaskShow();
	YMLib.Ajax.GET("login/userLoginAuthor.do?_="+Math.random(),"","json",function(msg){
		if(msg.state === false){
			document.location.href = "../../index.jsp";
		}else{
			loginUserObject = msg;
			YMLib.UI.MaskHide();
			initCombo();
		}
	},function(e){
		alert("验证登陆与请求权限 login/userLoginAuthor.do 出错");
		YMLib.UI.MaskHide();
	});
	
	initQuery();
	
});