<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加/编辑/查看“除雪版本表”信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/page/rcyh/js/addCxbb.js"></script>
</head>
<body>

<div class="easyui-layout" data-options="fit:true" >
	<div data-options="region:'south',border:false" style="height:30px;padding-top:0px;text-align: center;">
		<s:if test="toAdd"><input id="btnSave" type="button" value="确定" /></s:if>
		<s:if test="toEdit"><input id="btnSave" type="button" value="确定" /></s:if>
		<input id="close" type="button" value="取消" onclick="parent.$('#add,#view').window('close')"/>
	</div>
	<div data-options="region:'center',border:false" style="padding-top:10px;">
		<form id="form">
			<table class="tableform3" border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
				<tr>
					<td style="text-align:center" >版本名称</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input name="bbmc" class="easyui-validatebox" maxlength="50" style="width:150px" data-options="required:true" /></s:if>
						<%-- <s:if test="toEdit"><input name="bbmc" class="easyui-validatebox" maxlength="50" style="width:98%" data-options="required:true" value="<s:property value='model.bbmc' />" /></s:if> --%>
						<s:if test="toView"><s:property value='model.bbmc' /></s:if>
					</td>
				</tr>
				<tr>
					<td style="text-align:center" >开始时间</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input name="ssj" class="easyui-datebox" data-options="required:true" style="width:150px" /></s:if>
						<%-- <s:if test="toEdit"><input name="ssj" class="easyui-datebox" data-options="required:true" style="width:120px" /></s:if> --%>
						<s:if test="toView"><s:property value='model.ssjStr' /></s:if>
					</td>
				</tr>
				<tr>
					<td style="text-align:center" >结束时间</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input name="esj" class="easyui-datebox" data-options="required:true" style="width:150px" /></s:if>
						<s:if test="toView"><s:property value='model.esjStr' /></s:if>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>