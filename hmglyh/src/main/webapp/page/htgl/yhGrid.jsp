<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="js/yhGrid.js"></script>
</head>
<body class="easyui-layout" style="visibility: hidden;">
	<div data-options="region:'north',split:true,border:false" style="height:76px;border-top:1px solid #95b8e7;border-bottom:1px solid #95b8e7">
		<div class="easyui-panel" title="用户信息" data-options="iconCls:'titleimage',border:false,fit:true"  style="padding:8px 0px 0px 10px">
			<table>
				<tr>
					<td>部门：</td>
					<td><select class="easyui-combotree" id="chooseBmcode" style="width:150px"></select></td>
					<!-- <td>&nbsp;&nbsp;<input id="addOneYh" type="button" value="添加" /></td> -->
					<%-- <td>&nbsp;&nbsp;<img id="addOneYh" src="${pageContext.request.contextPath}/images/button_add.png" /></td> --%>
					<!-- <td>&nbsp;&nbsp;<input id="addOneYh" type="button" class="button_font2" value="添加" /></td> -->
					<td>&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addOneYh" >添加</a></td>
					<!-- 背景色为蓝、红 -->
					<!-- <td>&nbsp;&nbsp;<input type="button" class="button_font2" value="两字" /></td>
					<td>&nbsp;&nbsp;<input type="button" class="button_font4" value="四个字啊" /></td>
					<td>&nbsp;&nbsp;<input type="button" class="button_font6" value="这就是六个字" /></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="" >测试按钮</a></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="" >点咯</a></td> -->
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:false" style="padding:0px;border-top:0px solid #95b8e7">
		<table id="myGrid"></table>
	</div>
</body>
</html>