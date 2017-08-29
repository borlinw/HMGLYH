<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>病害类别管理&nbsp;>>&nbsp;病害</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="js/bhGrid.js"></script>
</head>
<body class="easyui-layout" style="visibility: hidden;">
	<!-- <div id="count" style="padding:5px;height:auto">
		累计XXX中共<font color="red" id="countAll"></font>条数据，其中共<font color="red" id="countType"></font>种类型。
	</div> -->
	<!-- <div data-options="region:'north',split:true,border:false" style="height:76px;border-top:1px solid #95b8e7;border-bottom:1px solid #95b8e7">
		<div class="easyui-panel" title="病害类别管理&nbsp;>>&nbsp;病害" data-options="iconCls:'titleimage',border:false,fit:true"  style="padding:8px 0px 0px 10px">
			<table>
				<tr>
					<td><input id="addOneBh" type="button" value="添加" /></td>
					<td><input id="queryAllToGrid" type="button" value="全部" /></td>
					<td><input id="queryUseing" type="button" value="启用" /></td>
					<td><input id="queryDisable" type="button" value="禁用" /></td>
				</tr>
			</table>
		</div>
	</div> -->
	<div data-options="region:'center',border:false" style="padding:0px;border-top:0px solid #95b8e7">
		<div class="easyui-panel" title="病害类别管理&nbsp;>>&nbsp;病害" data-options="iconCls:'titleimage',border:false,fit:true"  style="padding:0px 0px 0px 0px">
			<table id="myGrid"></table>
		</div>
	</div>
</body>
</html>