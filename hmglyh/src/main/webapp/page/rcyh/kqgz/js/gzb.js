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
		valueField : "yname"
	});
};

var initQuery = function(){
	$("#query").click(function(){
		var params = "bmCode="+$("#depart").combotree("getValue")+"&ssny="+$("#yf").combobox("getValue")+"&tbUserName="+loginUserObject.username
					+"&tbrxm="+loginUserObject.ryname+"&fzrxm="+loginUserObject.fzr;
		YMLib.Ajax.POST("gzdxzb/getZbid.do",params,"json",function(result){
			var src = YMLib.reportUrl + cjkEncode("reportlet=hmglyh/工资表.cpt&op=write&gzid="+result.gzid);
			$("#reportFrame").attr("src",src);
		},function(){});
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