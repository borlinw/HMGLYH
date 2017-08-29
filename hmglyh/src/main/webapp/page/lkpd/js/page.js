
$(function(){
	
	//路况调查下的页面
	$("#lkdcHome").click(function(){
		document.location.href = YMLib.url + "page/lkpd/lkdc/index.jsp";
	});
	//路况统计分析下的页面
	$("#lktjfxHome").click(function(){
		document.location.href = YMLib.url + "page/lkpd/lktjfx/index.jsp";
	});
	//区域区段划分下的页面
	$("#qyqdhfHome").click(function(){
		document.location.href = YMLib.url + "page/lkpd/qyqdhf/index.jsp";
	});
	//基础信息下的页面
	$("#jcxxHome").click(function(){
		document.location.href = YMLib.url + "page/lkpd/jcxx/index.jsp";
	});

});

