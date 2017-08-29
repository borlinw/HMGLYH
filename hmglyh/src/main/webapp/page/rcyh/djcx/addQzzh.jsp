<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" src="../js/addQzzh.js"></script>
</head>
<body class="easyui-layout" fit="true" style="visibility: hidden" >
	<div data-options="region:'south',border:false" style="height:25px;padding-top:0px;text-align: center;">
		<input id="btnSave" type="button" value="保存" />
	</div>
	<div data-options="region:'center',border:false" style="padding-top:10px;">
	<!-- <div style="margin-top:12px;" > -->
		<form id="addQzzhForm">
			<table id="addQzzh" class="tableform" border="0" cellspacing="0" cellpadding="0" align="center" width="90%" >
				<tbody id="addQzzhTbody">
					<tr>
						<td>
							K<input name="startZhOne" class="easyui-validatebox" style="width:45px" maxlength="4" data-options="required:true,validType:'number'" autofocus />+<input name="startZhTwo" class="easyui-validatebox" style="width:45px" maxlength="3" data-options="required:false,validType:'number'" />
							-
							K<input name="endZhOne" class="easyui-validatebox" style="width:45px" maxlength="4" data-options="required:true,validType:'number'" />+<input name="endZhTwo" class="easyui-validatebox" style="width:45px" maxlength="3" data-options="required:false,validType:'number'" />
						</td>
						<td>
							<a href="javascript:void(0);" onclick="insertRow()" >增</a>
							<a href="javascript:void(0);" onclick="deleteRow(this)" >删</a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>