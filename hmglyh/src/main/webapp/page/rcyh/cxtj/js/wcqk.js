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

			var src1 = YMLib.reportUrl + cjkEncode("reportlet=hmglyh/养护作业单位个人生产任务完成情况（按单位）.cpt&op=write&bmCode="+loginUserObject.bmcode);
			var src2 = YMLib.reportUrl + cjkEncode("reportlet=hmglyh/养护作业单位个人生产任务完成情况（按个人）.cpt&op=write&bmCode="+loginUserObject.bmcode);
			$("#reportFrame1").attr("src",src1);
			$("#reportFrame2").attr("src",src2);
		}
	});

});














