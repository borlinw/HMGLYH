
//用于点击title上的“冬季除雪”时跳转回冬季除雪页面

$(function(){
	$("#djcxHome").click(function(){
		document.location.href = YMLib.url + "rcyh/djcx_index.do";
	});
});
