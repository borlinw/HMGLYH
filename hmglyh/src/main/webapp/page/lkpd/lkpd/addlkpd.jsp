<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>千米路段划分</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/addlkpd.js"></script>
</head>
<body>
	<form id="myForm">
	<table cellpadding="10" align="center" cellspacing="5" class="tableform">
		<tr>
			<td style="text-align: right;">管辖路段：</td>
			<td><span id="gxld"></span></td>
		</tr>
		<tr>
			<td style="text-align: right;">路况评定版本：</td>
			<td><span id="pdbbid"></span></td>
		</tr>
		<tr>
			<td style="text-align: right;">路况调查版本：</td>
			<td><select id="dcbbid" class="easyui-combobox" style="width:130px" required="true"></select></td>
		</tr>
		<tr>
			<td style="text-align: right;">路面检测版本：</td>
			<td><select id="jcbbid" class="easyui-combobox" style="width:130px" required="true"></select></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"><input type="button" class="save_button" value="生  成" id="create" /></td>
		</tr>
	</table>
	</form>
</body>
</html>