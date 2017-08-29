<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月任务完成情况表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="/hmglyh/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/hmglyh/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="/hmglyh/easyui/themes/style.css" />
<script type="text/javascript" src="/hmglyh/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/hmglyh/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/hmglyh/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/hmglyh/js/YMLib.js"></script>
<script type="text/javascript" src="./js/xxbywcqk.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:false" style="height:30px;border-left:0px;border-right:0px;border-top:0px">
		<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="cxtjHome" style="cursor:pointer;">查询统计</font>&nbsp;&gt;&nbsp;公路小修保养完成情况表</div>		
	</div>
	<div data-options="region:'center',border:false" style="border-left:0px;border-right:0px;border-button:0px;overflow:hidden;">
		<iframe id="reportFrame" style="width:100%;height:100%;border:0px"></iframe>	
	</div>
</body>
</html>






















