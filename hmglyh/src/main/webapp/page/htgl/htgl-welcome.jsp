<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>后台管理 - 欢迎页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script language="javascript" >
window.onload = function(){
	$("#table_img").css("height",document.documentElement.clientHeight+"px");
	$("#table_img").css("width",document.documentElement.clientWidth+"px");
	//alert("宽度为："+document.documentElement.clientWidth+"，高度为："+document.documentElement.clientHeight);
};
</script>
</head>
<body style="overflow: hidden; text-align: center; vertical-align: middle; ">
	<table id="table_img" border="0" cellpadding="0" cellspacing="0"><tr><td><img src="${pageContext.request.contextPath}/images/htgl-welcome.png"  alt=""  /></td></tr></table>
</body>
</html>