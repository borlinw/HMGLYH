<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公路技术状况评定汇总</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/pdhz.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:false" style="height:80px;border-left:0px;border-right:0px;border-top:0px">
	<!-- <div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;路况统计分析&nbsp;&gt;&nbsp;公路技术状况评定汇总" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px; overflow: hidden;"> -->
		<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="lktjfxHome" style="cursor:pointer;overflow: hidden;" >路况统计分析</font>&nbsp;&gt;&nbsp;公路技术状况评定汇总</div>
		<div style="height:27px;padding-top:10px">
			<tr>
				<td>&nbsp;版本：</td>
				<td><select class="easyui-combobox" id="bb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="ld" panelHeight="auto" style="width: 160px;"></select></td>
				<td><input class="easyui-numberbox" id="qd" panelHeight="auto" style="width: 60px;"></input></td>
				<td>—</td>
				<td><input class="easyui-numberbox" id="zd" panelHeight="auto" style="width: 60px;"></input></td>
				<td>&nbsp;路面类型：</td>
				<td><select class="easyui-combobox" id="lmlx" panelHeight="auto" style="width: 100px;"></select></td>
				<td>&nbsp;技术等级：</td>
				<td><select class="easyui-combobox" id="jsdj" panelHeight="auto" style="width: 120px;"></select></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a></td>
			</tr>
		</div>
	</div>
	<div data-options="region:'center',border:false" style="border-left:0px;border-right:0px;border-button:0px;overflow:hidden;">
		<iframe id="reportFrame" style="width:100%;height:100%;border:0;"> </iframe>
	</div>
</body>
</html>
