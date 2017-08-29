<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加版本库</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<link rel="stylesheet" type="text/css" href="../css/lkpd.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/addBbk.js"></script>
</head>
<body>
<form id="myForm">
	<table>
		<tr><td style="text-align: right;">版本名称：</td><td><input type="text" class="easyui-validatebox" required="true" name="bbmc"/></td></tr>
		<tr><td style="text-align: right;">版本类型：</td><td>
			<select id="bblx" name="bblx" class="easyui-combobox" panelHeight="auto">
				<option value="0201">路况调查</option>
				<option value="0202">路面检测</option>
				<option value="0203">路况评定</option>
				<option value="0204">千米路段划分</option>
				<option value="0205">区域区段划分</option>
			</select>
		</td></tr>
		<tr><td style="text-align: right;">最近操作人：</td><td><input type="text" style="border:0px" readonly name="zjczr"/></td></tr>
		<tr id="qmbb"><td style="text-align: right;">对应千米路段版本：</td><td>
			<select id="qmld" class="easyui-combobox" style="width:130px"></select>
			<input type="hidden" name="qmbbid" />
		</td></tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<!-- <input type="button" class="save_button" value="保  存" id="btnSave" /> -->
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="btnSave">保存</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>