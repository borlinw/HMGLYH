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



$(function(){
	//获取用户信息
	$.ajax({
		url:"/hmglyh/login/userLoginAuthor.do",
		async:false,
		dataType:"json",
		success:function(data){
			console.log(data);
			loginUserObject = data;

			var src = YMLib.reportUrl + cjkEncode("reportlet=hmglyh/沥青路面修补.cpt&__bypagesize__=false&bmCode="+loginUserObject.bmcode);
			$("#reportFrame").attr("src",src);
		}
	});

});














