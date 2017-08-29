<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加人员信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" language="javascript" src="js/addRy.js"></script>
</head>
<body>

<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'south',border:false" style="height:30px;padding-top:0px;text-align: center;">
		<!-- <input id="btnSave" type="button" value="确定" />
		<input id="close" type="button" value="取消" onclick="parent.$('#add,#edit').window('close')"/> -->
		<a id="btnSave" href="javascript:void(0)" class="easyui-linkbutton" plain="true" >保存</a>
		<a id="close" href="javascript:void(0)" class="easyui-linkbutton" onclick="parent.$('#add,#edit,#view').window('close')" plain="true" >取消</a>
	</div>
	<div data-options="region:'center',border:false" style="padding-top:10px;">
		<form id="form">
			<table class="tableform2" border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
				<tr>
					<td style="text-align:right" >人员姓名：</td>
					<td class="left">&nbsp;<input id="ryname" name="ryname" class="easyui-validatebox" maxlength="30" data-options="required:true" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >选择部门：</td>
					<td class="left">&nbsp;<select class="easyui-combotree" name="bmcode" id="chooseBmcode" style="width:150px"></select></td>
				</tr>
				<tr>
					<td style="text-align:right" >职务：</td>
					<td class="left">&nbsp;<input id="zw" name="zw" class="easyui-validatebox" maxlength="20" data-options="required:false" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >联系电话：</td>
					<td class="left">&nbsp;<input id="lxdh" name="lxdh" class="easyui-validatebox" maxlength="20" data-options="required:false,validType:'mobile'" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >入职日期：</td>
					<td class="left">
					&nbsp;<input name="rzsj" id="rzsj" class="easyui-validatebox" data-options="required:true" readonly="readonly" />
					<img onclick="WdatePicker({el:'rzsj'})" src="${pageContext.request.contextPath}/js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle" >
					<!-- <input id="rzsj" name="rzsj" class="easyui-datebox" data-options="required:true,panelHeight:200" /> -->
					</td>
				</tr>
				<tr>
					<td style="text-align:right" >E-Mail：</td>
					<td class="left">&nbsp;<input id="email" name="email" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'email'" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >QQ：</td>
					<td class="left">&nbsp;<input id="qq" name="qq" class="easyui-validatebox" maxlength="20" data-options="required:false,validType:'QQ'" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >性别：</td>
					<td class="left">
						<span>
							<input id="r1" type="radio" name="ryxb" style="border:none" value="0" checked /><label for="r1">男</label>
							<input id="r2" type="radio" name="ryxb" style="border:none" value="1" /><label for="r2">女</label>
						</span>
					</td>
				</tr>
				<tr>
					<td style="text-align:right" >启用状态：</td>
					<td class="left">
						<span>
							<input id="q1" type="radio" name="qyzt" style="border:none" value="1" checked /><label for="q1">启用</label>
							<input id="q2" type="radio" name="qyzt" style="border:none" value="0" /><label for="q2">禁用</label>
						</span>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>