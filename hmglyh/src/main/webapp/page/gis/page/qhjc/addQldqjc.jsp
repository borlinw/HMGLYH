<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>桥梁定期检查</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/uploadify/uploadify2.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/gis/js/tools.js"></script>
<script type="text/javascript">
$(function(){
	$("#cancle").click(function(){
		location.href = YMLib.url + 'page/gis/page/qhjc/qldqjc.jsp?qlcode='+getQuery("qlcode");
	});
	
	var params = "reportlet=hmglyh/qhjc/桥梁定期检查.cpt&op=write&qlcode="+getQuery("qlcode")+"&qldqjcid="+getQuery("qldqjcid");
	
	$("#reportFrame").attr("src",YMLib.reportUrl + YMLib.cjkEncode(params));
});


</script>
</head>
<body>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:25px;border-left:0px;border-right:0px;border-top:0px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="cancle">返回</a>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<iframe id="reportFrame" style="width:100%;height:100%;border:0px;"></iframe>
	</div>
</body>
</body>
</html>







