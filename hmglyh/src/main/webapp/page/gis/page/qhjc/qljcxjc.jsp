<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>桥梁经常性检查</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="qljcxjc.js"></script>
</head>
<body>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:30px;border-left:0px;border-right:0px;border-top:0px;">
		<input type="text"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="jcrq" id="jcrq"/>
		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="add">签到</a>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<table id="myGrid"></table>
    </div>		
</body>
</body>
</html>







