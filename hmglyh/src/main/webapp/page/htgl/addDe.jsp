<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看定额</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript" src="js/addDe.js"></script>
</head>
<body>

<div class="easyui-layout" data-options="fit:true">
	<div data-options="region:'south',border:false" style="height:30px;padding-top:0px;text-align: center;">
		<a id="close" href="javascript:void(0)" class="easyui-linkbutton" onclick="parent.$('#add,#edit,#view').window('close')" plain="true" >关闭</a>
	</div>
    <div data-options="region:'center',border:false" style="padding-top:10px;">
    	<form id="form">
			<table class="tableform2" border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
				<tr>
					<td style="text-align:right" >所属养护类型名称：</td>
					<td class="left">&nbsp;<input id="yhname" style="color:#888;width:220px;" readonly="readonly"/></td>
				</tr>
				<tr id="chooseOfTr" style='display:none' >
					<td style="text-align:right" >选择工料机：</td>
					<td class="left">&nbsp;<select class="easyui-combotree" id="chooseGlj" style="width:220px;"></select></td>
				</tr>
			</table>
			<br/>
			<table class="tableform" border="0" cellspacing="0" cellpadding="0" align="center" width="90%" >
				<tbody id="gljValueTbody">
					<tr>
						<td style="display:none" >工料机ID</td>
						<td>工料机名称</td>
						<td>数量</td>
						<td>单位</td>
					</tr>
				</tbody>
			</table>
		</form>
    </div>
</div>
</body>
</html>