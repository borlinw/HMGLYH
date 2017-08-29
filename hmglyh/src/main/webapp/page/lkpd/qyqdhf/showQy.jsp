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
<script type="text/javascript" src="./js/showQy.js"></script>
</head>
<body>
<div class="easyui-tabs" fit="true">
	<div title="图表">
		<div class="easyui-layout" fit="true">
			<div data-options="region:'north',border:false,split:false" style="height:35px;border-left:0px;border-right:0px;border-top:0px;">
				<table>
					<tr>
						<td>管养路段：</td>
						<td>
							<select id="gyld" class="easyui-combobox" style="width:200px;"></select>
						</td>
					</tr>
				</table>
			</div>
			<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
				<iframe style="width:100%;height:100%;border:0;" id="showChart"></iframe>
			</div>
		</div>
	</div>
	<div title="表格">
		<iframe style="width:100%;height:100%;border:0;" id="table"></iframe>
	</div>
</div>
</body>
</html>





