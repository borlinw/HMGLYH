<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>后台管理 - 病害类型</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="js/bhgl.js"></script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'west',title:'<center>病害类别管理</center>',split:true,border:false" style="width:220px;">
            <ul id="bhglTree"></ul>
    </div>  
    <div data-options="region:'center',border:false" style="padding:0px;margin:0px; overflow:hidden;">
        <iframe id="rightContent" name="rightContent" src="${pageContext.request.contextPath}/page/htgl/htgl-welcome.jsp" frameborder='0' height='100%' width='100%'></iframe>
    </div>
	<!-- Tree上的右键菜单（只有“添加”） -->
	<div id="addBhOfRightButton" class="easyui-menu" style="width:100px;">
		<div onclick="javascript:addBh()" data-options="iconCls:'icon-add'">在此项下添加“病害”</div>
	</div>
</body>

</html>