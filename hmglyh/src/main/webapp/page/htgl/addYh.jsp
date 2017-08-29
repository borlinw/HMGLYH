<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript" src="js/addYh.js"></script>
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
					<td style="text-align:right" >用户名：</td>
					<td class="left">&nbsp;<input id="username" name="username" onblur="VerifyUsername()" class="easyui-validatebox" maxlength="30" data-options="required:true" /></td>
				</tr>
				<tr id="pwTr" style="display:none" >
					<td style="text-align:right">密码：</td>
					<td class="left">&nbsp;<input id="pw" name="pw" type="password" class="easyui-validatebox" validType="length[6,12]" data-options="required:true" /></td>
				</tr>
				<tr id="rpwTr" style="display:none" >
					<td style="text-align:right">重复密码：</td>
					<td class="left">&nbsp;<input id="rpw" name="" type="password" class="easyui-validatebox" required="required" validType="equalTo['#pw']" /> </td>
				</tr>
				<tr id="viewRyname" style="display:none">
					<td style="text-align:right" >人员名称：</td>
					<td class="left">&nbsp;<input id="toViewRyname" style="color:#888;" readonly="readonly" /></td>
				</tr>
				<tr id="bm" style="display:none">
					<td style="text-align:right" >部　　门：</td>
					<td class="left">&nbsp;<select class="easyui-combobox" id="bmCode" style="width:150px"></select></td>
				</tr>
				<tr id="chooseRyTr" style="display:none" >
					<td style="text-align:right" >选择人员：</td>
					<td class="left">&nbsp;<select class="easyui-combobox" name="ryid" id="chooseRy" style="width:150px"></select></td>
				</tr>
				<tr>
					<td style="text-align:right" >选择角色：</td>
					<td class="left">&nbsp;<select class="easyui-combobox" name="jsid" id="chooseJs" style="width:150px"></select></td>
				</tr>
				<tr>
					<td style="text-align:right" >启用状态：</td>
					<td class="left">
						<span>
							<input id="r1" type="radio" name="qyzt" style="border:none" value="1" checked /><label for="r1">启用</label>
							<input id="r2" type="radio" name="qyzt" style="border:none" value="0" /><label for="r2">禁用</label>
						</span>
					</td>
				</tr>
			</table>
		</form>
    </div>
</div>
</body>
</html>