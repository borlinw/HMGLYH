<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" src="../js/cxkbGrid.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
</head>
<body class="easyui-layout" style="visibility: hidden" >
	<div data-options="region:'north',border:true,split:true" style="height: 78px; border-left: 0px; border-right: 0px; border-top: 0px;">
		<div id="righttop">
			<div id="p_top" class="top_div_lr" >&nbsp;当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="djcxHome" style="cursor:pointer;" >冬季除雪</font>&nbsp;&gt;&nbsp;除雪快报表</div>
			<table style="margin-top: 7px;" >
				<tr><td>&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addCxkbb">添加</a></td></tr>
			</table>
		</div>
	</div>
	<div border="false" data-options="region:'center'" style="border-top:0px">
		<!-- <input id="addCxkbb" type="button" value="添加" />
		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addCxkbb">添加</a>
		<form id="ExportCxkbForm" method="post" action="" enctype="multipart/form-data">
			<input id="kbidToExportOfJsp" name="kbid" style="display:none"/>
		</form> -->
		<table class="easyui-datagrid"
			data-options="
			url:'${pageContext.request.contextPath}/rcyh/djcx_queryAllCxkbBySome.do',
			queryParams:{},
			columns:[datagridFields],
			pageNumber : 1,
			pageSize : 15,
			pageList : [ 15, 25, 35 ],
			rownumbers : true,
			pagination : true,
			fit:true"
			id="myGrid">
		</table>
	</div>
	<div style="display:none">
		<form id="ExportCxkbForm" method="post" action="" enctype="multipart/form-data" >
			<input id="kbidToExportOfJsp" name="kbid" style="display:none"/>
		</form>
	</div>
		
</body>
</html>