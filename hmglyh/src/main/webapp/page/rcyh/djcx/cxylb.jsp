<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>除雪一览表</title>
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
			//alert(data.bmcode+"##"+data.username+"##"+data.ryname);
			var bmcodeStr = data.bmcode;
			if(bmcodeStr.length > 6){
				bmcodeStr = bmcodeStr.substr(0,6);
			}
			$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=hmglyh%2Fdjcxylb.cpt&bmcodeToChoose="+bmcodeStr+"&username="+data.username+"&ryname="+data.ryname);
			//$("#reportFrame").attr("src","http://localhost:8075/WebReport/ReportServer?reportlet=hmglyh%2F%5Bff08%5D%5B594e%5D%5B5c6f%5D%5B9879%5D%5B76ee%5D%5Bff09%5Ddjcxylb%5Bff08%5D%5B51ac%5D%5B5b63%5D%5B9664%5D%5B96ea%5D%5B4e00%5D%5B89c8%5D%5B8868%5D%5Bff09%5D.cpt&bmcodeToChoose="+bmcodeStr+"&username="+data.username+"&ryname="+data.ryname);
		}
	});
});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:false" style="height:31px;border-left:0px;border-right:0px;border-top:0px">
		<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="djcxHome" style="cursor:pointer;" >冬季除雪</font>&nbsp;&gt;&nbsp;除雪一览表</div>		
	</div>
	<div data-options="region:'center',border:false" style="border-left:0px;border-right:0px;border-button:0px;overflow:hidden;">
		<!-- <iframe id="reportFrame" style="width:100%;height:100%;border:0px" src="/hmglyh/ReportServer?reportlet=hmglyh%2Fdjcxylb.cpt" ></iframe> -->
		<iframe id="reportFrame" style="width:100%;height:100%;border:0px" src="" ></iframe>
	</div>
</body>
</html>