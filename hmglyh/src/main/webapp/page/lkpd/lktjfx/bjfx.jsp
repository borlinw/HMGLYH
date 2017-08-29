<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公路技术状况比较分析</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/bjfx.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',split:false" style="height:32px;">
		<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="lktjfxHome" style="cursor:pointer;overflow: hidden;" >路况统计分析</font>&nbsp;&gt;&nbsp;公路技术状况比较分析</div>
	</div>
	<div data-options="region:'center'">
	<div class="easyui-tabs" data-options="fit:true">
		<div title="按路段" style="overflow:hidden;height:50px;padding-top:10px" >
			<table id="lmps">
				<tr>
					<td>&nbsp;版本：</td>
					<td><select class="easyui-combotree" id="bb" panelHeight="auto" style="width: 150px;"></select></td>
					<td>&nbsp;路段：</td>
					<td><select class="easyui-combobox" id="ld" panelHeight="auto" style="width: 160px;"></select></td>
					<td><input class="easyui-numberbox" name="szhh" id="start" style="width: 60px;" data-options="required:true,precision:3"></input></td>
					<td>—</td>
					<td><input class="easyui-numberbox" name="ezhh" id="end" style="width: 60px;" data-options="required:true,precision:3"></input></td>
					<td>&nbsp;技术等级：</td>
					<td><select class="easyui-combobox" id="jsdj" panelHeight="auto" style="width: 120px;"></select></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a></td>
				</tr>
			</table>
			<iframe id="report_ld" style="width:100%;border:0;height:100%;"> </iframe>
		</div>
		<div title="按单位" style="overflow:hidden;height:50px;padding-top:10px">
			<table id="ljps">
				<tr>
					<td>&nbsp;版本：</td>
					<td><select class="easyui-combotree" id="bb1" panelHeight="auto" style="width: 150px;"></select></td>
					<td>&nbsp;部门：</td>
					<td><select class="easyui-combotree" id="bm" style="width: 160px;"></select></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query1">查询</a></td>
				</tr>
			</table>
			<iframe id="report_dw" style="width:100%;border:0;height:100%;"></iframe>
		</div>
	</div>
	</div>
</body>
</html>
