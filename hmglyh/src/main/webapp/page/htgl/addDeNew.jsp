<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加/编辑定额</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript" src="js/addDeNew.js"></script>
</head>
<body class="easyui-layout" >

<!-- <div class="easyui-layout" data-options="fit:true"> -->

	<div data-options="region:'west',split:true,border:false" style="width:220px;">
		<ul id="chooseGlj" ></ul>
	</div>
	<div data-options="region:'center',border:false" style="padding:0px;margin:0px;">
	    <div data-options="region:'center',border:false" style="padding-top:10px;height:245px;overflow-y:scroll;">
	    	<form id="form">
				<table class="tableform2" border="0" cellspacing="0" cellpadding="0" align="center" width="90%" >
					<tr>
						<td style="text-align:right" >所属养护类型名称：</td>
						<td class="left">&nbsp;<input id="yhname" style="color:#888;width:220px;" readonly="readonly"/></td>
					</tr>
				</table>
				<br/>
				<table class="tableform" border="0" cellspacing="0" cellpadding="0" align="center" width="90%" height="70%" >
					<tbody id="gljValueTbody">
						<tr>
							<td style="display:none" >工料机ID</td>
							<td>工料机名称</td>
							<td>数量</td>
							<td>单位</td>
							<!-- <td>操作</td> -->
						</tr>
					</tbody>
				</table>
			</form>
	    </div>
	    <div data-options="region:'south',border:false" style="height:30px;padding-top:0px;text-align: center;">
			<a id="btnSave" href="javascript:void(0)" class="easyui-linkbutton" plain="true" >保存</a>
			<a id="close" href="javascript:void(0)" class="easyui-linkbutton" onclick="parent.$('#add,#edit,#view').window('close')" plain="true" >取消</a>
		</div>
	</div>
</body>
</html>