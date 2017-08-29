<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加工料机类型信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript" src="js/addGljlx.js"></script>
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
					<td style="text-align:right" >编号：</td>
					<td class="left">&nbsp;<input id="bm" name="bm" onblur="VerifyBm()" class="easyui-validatebox" maxlength="15" data-options="required:true,validType:'number'" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >工料机类型：</td>
					<td class="left">&nbsp;<input id="lxname" name="lxname" class="easyui-validatebox" maxlength="30" data-options="required:true" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >规格：</td>
					<td class="left">&nbsp;<input id="gg" name="gg" class="easyui-validatebox" maxlength="30" data-options="required:false" /></td>
				</tr>
				<tr>
					<td style="text-align:right" >单位：</td>
					<td class="left">&nbsp;<input id="dw" name="dw" class="easyui-validatebox" maxlength="20" data-options="required:false" /></td>
				</tr>
				<tr id="qyztTr" >
					<td style="text-align:right" >启用状态：</td>
					<td class="left">
						<span>
							<input id="r1" type="radio" name="qyzt" style="border:none" value="1" checked /><label for="r1">启用</label>
							<input id="r2" type="radio" name="qyzt" style="border:none" value="0" /><label for="r2">禁用</label>
						</span>
					</td>
				</tr>
				<tr>
					<td style="text-align:right" >备注：</td>
					<td class="left" colspan="2">&nbsp;<textarea onkeyup="this.value = this.value.substring(0, 100)" rows="3" cols="30" name="bz"></textarea></td>
				</tr>
			</table>
		</form>
    </div>
</div>
</body>
</html>