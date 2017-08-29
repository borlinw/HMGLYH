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
<script type="text/javascript" src="./js/jassbhcdd.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
</head>
<body class="easyui-layout">
	 <div data-options="region:'north',border:true,split:true" style="height: 78px; border-left: 0px; border-right: 0px; border-top: 0px;">
		<div id="righttop">
			<%-- <div id="p_top" style="height:30px;background-color: #70D2E0;line-height:30px;background:#70D2E0 url(${pageContext.request.contextPath}/images/position.png) 13px center no-repeat;padding-left:30px;" >&nbsp;当前位置：&nbsp;日常养护&nbsp;&gt;&gt;&nbsp;月度计划</div> --%>
			<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="cxtjHome" style="cursor:pointer;" >查询统计</font>&nbsp;&gt;&nbsp;交安设施维修传递单</div>		
		</div>
		<table style="padding-top: 7px;" >
			<tr>
				<td>
				&nbsp;月份：<select class="easyui-combobox" id="yf"
					panelHeight="300px" style="width: 200px;"></select>
				</td>
				<td>
					&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<table id="myGrid" class=""></table>
	</div>
</body>
</html>