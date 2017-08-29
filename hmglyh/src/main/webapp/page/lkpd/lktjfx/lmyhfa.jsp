<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公路路况调查分析</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/testLmyhfa.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body style="overflow:hidden" class="easyui-layout">
	<div data-options="region:'north',split:false" style="height:64px;">
		<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="lktjfxHome" style="cursor:pointer;" >路况统计分析</font>&nbsp;&gt;&nbsp;路面指标评定及养护方案</div>
		<table id="myTable">
			<tr>
				<td>&nbsp;<select class="easyui-combobox" id="recording" panelHeight="auto">
					<option value="0">按区段</option>
					<option value="1">按路段</option>
				</select></td>
				<td kid="0">&nbsp;区段划分版本：</td>
				<td kid="0"><select class="easyui-combobox" id="qdbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路况调查版本：</td>
				<td><select class="easyui-combobox" id="dcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路面检测版本：</td>
				<td><select class="easyui-combobox" id="jcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="ld" panelHeight="auto" style="width: 160px;"></select></td>
				<td kid="1" style="display:none;"><input class="easyui-numberbox" id="start" panelHeight="auto" style="width: 60px;"></input> - 
				<input class="easyui-numberbox" id="end" panelHeight="auto" style="width: 60px;"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query">查询</a></td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" fit="true">
			<div title="一级指标评定" style="overflow:hidden;" >
			
				<iframe id="report_yj" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
			<div title="二级指标评定" style="overflow:hidden;">
				<iframe id="report_ej" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
			<div title="路面养护方案" style="overflow:hidden;">
				<iframe id="report_fa" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
		</div> 
	</div>
</body>
</html>
