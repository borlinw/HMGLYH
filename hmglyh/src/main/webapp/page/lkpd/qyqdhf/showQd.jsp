<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加区段划分</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/highchart/js/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/highchart/js/modules/exporting.js"></script>
<script type="text/javascript" src="./js/showQd.js"></script>
<style type="text/css">
	#qdTable,#detail{
		text-align:center;
	}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true" style="height:30px;border-left:0px;border-button:0px;border-top:0px;">
		<table>
			<tr>
				<td>路况调查版本：</td>
				<td><select id="dcbbid" class="easyui-combobox" style="width:150px;"></select></td>
				<td>区域：</td>
				<td><select id="ldCode" class="easyui-combobox" style="width:130px;"></select></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a></td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<div class="easyui-tabs" fit="true">
			<div title="图表">
				<div id="container">
				</div>
			</div>
			<div title="表格">
				<iframe style="width:100%;height:100%;border:0;" id="bhlb"></iframe>
			</div>
		</div>
	</div>
</body>
</html>





