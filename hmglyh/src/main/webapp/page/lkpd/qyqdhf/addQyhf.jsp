<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加区域划分</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" src="./js/addQyhf.js"></script>
</head>
<body>
<form id="myForm">
	<table align="center">
		<tr><td style="text-align:right;">管辖路段：</td><td><span id="ldCode"></span></td></tr>
		<tr><td style="text-align:right;">版本：</td><td><span id="bbid"></span></td></tr>
		<tr><td style="text-align:right;">影响因素：</td><td>
			<select id="lx" class="easyui-combobox" panelHeight="auto">
				<option>公路使用年限</option>
				<option>公路区域特点</option>
				<option>公路结构类型</option>
				<option>公路沿线的气候、地址、地形特点</option>
				<option>交通量及交通组成</option>
				<option>与其他路段有显著差异的其他因素</option>
			</select>&nbsp;&nbsp;
			<input type="text" class="easyui-validatebox" style="width:50px;" id="point" data-options="required:true,validType:'numberFloat'"/>&nbsp;&nbsp;
			<!-- <img src="../images/add.png" style="cursor: pointer;" id="add"> -->
			<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="add">添加</a>
			<table id="append" border="0">
			</table>
		</td></tr>
		<tr>
			<td colspan="2" style="text-align:center;">
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="btnSave">划分</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>