<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>人员信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="js/ryGrid.js"></script>
</head>
<body class="easyui-layout" style="visibility: hidden;">
	<div data-options="region:'north',split:true,border:false" style="height:76px;border-top:1px solid #95b8e7;border-bottom:1px solid #95b8e7">
		<div class="easyui-panel" title="人员信息" data-options="iconCls:'titleimage',border:false,fit:true"  style="padding:8px 0px 0px 10px">
			<table>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;部门：</td>
					<td><select class="easyui-combotree" id="chooseBmcode" style="width:150px"></select></td>
					<td>&nbsp;&nbsp;&nbsp;入职日期：</td>
					<td><select class="easyui-combotree" id="chooseRzsj" style="width:150px"></select></td>
					<td>&nbsp;&nbsp;&nbsp;人员姓名：</td>
					<td><input id="toQueryRyname" class="easyui-validatebox" data-options="required:false" /></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="queryRy">查询</a></td>
					<td>&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addOneRy">添加</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:false" style="padding:0px;border-top:0px solid #95b8e7">
		<table id="myGrid"></table>
	</div>
</body>
</html>