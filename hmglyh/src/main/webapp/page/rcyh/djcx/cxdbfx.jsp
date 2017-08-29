<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>除雪对比分析</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
<script type="text/javascript">
$(function(){
	//获取用户信息
	$.ajax({
		url:"/hmglyh/login/userLoginAuthor.do",
		async:false,
		dataType:"json",
		success:function(data){
			var bmcodeToQuery = data.bmcode;
			//alert("部门编码长度为："+bmcodeToQuery.length);
			if(bmcodeToQuery.length > 6){
				bmcodeToQuery = bmcodeToQuery.substr(0,6);
			}
			//alert("处理后的部门编码为："+bmcodeToQuery);
			$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=NEWcxfydbfx.cpt&bmcodeToChoose="+bmcodeToQuery+"&__bypagesize__=false");
			//$("#reportFrame").attr("src","http://localhost:8075/WebReport/ReportServer?reportlet=NEWcxfydbfx.cpt&bmcodeToChoose="+bmcodeToQuery+"&__bypagesize__=false");
		}
	});
});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:false" style="height:31px;border-left:0px;border-right:0px;border-top:0px">
		<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="djcxHome" style="cursor:pointer;" >冬季除雪</font>&nbsp;&gt;&nbsp;除雪对比分析</div>		
	</div>
	<div data-options="region:'center',border:false" style="border-left:0px;border-right:0px;border-button:0px;overflow:hidden;">
		<!-- <iframe id="reportFrame" style="width:100%;height:100%;border:0px" src="/hmglyh/ReportServer?reportlet=cxfyfx2.cpt&op=view" ></iframe> -->
		<iframe id="reportFrame" style="width:100%;height:100%;border:0px" src="" ></iframe>
	</div>
</body>
</html>