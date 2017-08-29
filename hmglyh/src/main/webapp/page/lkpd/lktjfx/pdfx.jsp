<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公路技术状况评定分析</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/pdfx.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body style="overflow:hidden" class="easyui-layout">
	<div data-options="region:'north',split:false" style="height:32px;">
		<div class="top_div_lr">路况评定管理&nbsp;&gt;&nbsp;<font id="lktjfxHome" style="cursor:pointer;overflow: hidden;" >路况统计分析</font>&nbsp;&gt;&nbsp;公路技术状况评定分析</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" data-options="fit:true" >
			<div title="按路段" style="overflow:hidden;height:50px;padding-top:10px">
			<table>
			<tr>
				<td>&nbsp;版本：</td>
				<td><select class="easyui-combobox" id="bb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="ld" panelHeight="auto" style="width: 160px;"></select></td>
				<td><input class="easyui-numberbox" id="qd" panelHeight="auto" style="width: 60px;"></input></td>
				<td>—</td>
				<td><input class="easyui-numberbox" id="zd" panelHeight="auto" style="width: 60px;"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a></td>
			</tr>
			</table>
				<iframe id="report1" style="width:100%;height:100%;border:0;padding-top:10px;"> </iframe>
			</div>
			<div title="按单位" style="overflow:hidden;height:50px;padding-top:10px">
			<table>
			<tr>
				<td>&nbsp;版本：</td>
				<td><select class="easyui-combobox" id="bb1" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;管养单位：</td>
				<td><select class="easyui-combotree" id="gydw1" panelHeight="auto" style="width: 160px;"></select></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query1">查询</a></td>
			</tr>
			</table>
				<iframe id="report2" style="width:100%;height:100%;border:0;padding-top:10px"> </iframe>
			</div>
			<div title="按技术等级" style="overflow:hidden;height:50px;padding-top:10px">
			<table>
			<tr>
				<td>&nbsp;版本：</td>
				<td><select class="easyui-combobox" id="bb2" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;管养单位：</td>
				<td><select class="easyui-combobox" id="gydw2" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;技术等级：</td>
				<td>
					<select class="easyui-combobox" editable="false" id="jsdj2" panelHeight="auto" style="width: 120px;">
						<option value="0">高速或一级公路</option>
						<option value="1">普通公路</option>
					</select>
				</td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query2">查询</a></td>
			</tr>
			</table>
				<iframe id="report3" style="width:100%;height:100%;border:0;padding-top:10px"> </iframe>
			</div> 
			 
			<div title="路线信息汇总表" style="overflow:hidden;height:50px;padding-top:10px">
			<table>
			<tr>
				<td>&nbsp;路况评定版本：</td>
				<td><select class="easyui-combobox" id="bb3" panelHeight="auto" style="width: 150px;"></select></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query3">查询</a></td>
			</tr>
			</table>
				<iframe id="report4" style="width:100%;height:100%;border:0;padding-top:10px"> </iframe>
			</div>
		</div>
	</div>
</body>
</html>
