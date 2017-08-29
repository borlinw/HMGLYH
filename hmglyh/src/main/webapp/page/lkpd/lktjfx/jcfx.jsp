<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公路路面检测分析</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/jcfx.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body style="overflow:hidden" class="easyui-layout">
	<!-- <div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;路况统计分析&nbsp;&gt;&nbsp;公路路面检测分析" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px; overflow: hidden;"> -->
	<div data-options="region:'north',split:false" style="height:32px;">
		<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="lktjfxHome" style="cursor:pointer;" >路况统计分析</font>&nbsp;&gt;&nbsp;公路路面检测分析</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" data-options="fit:true">
			<div title="路面检测分析" style="overflow:hidden;height:50px;padding-top:10px">
				<table id="lmjc">
				<tr>
					<td>&nbsp;<select class="easyui-combobox" id="lmjc_recording" panelHeight="auto">
						<option value="0">按区段</option>
						<option value="1">按路段</option>
					</select></td>
					<td kid="0">&nbsp;区段划分版本：</td>
					<td kid="0"><select class="easyui-combobox" id="qdbb" panelHeight="auto" style="width: 150px;"></select></td>
					<td>&nbsp;路况评定版本：</td>
					<td><select class="easyui-combobox" id="bb" panelHeight="auto" style="width: 150px;"></select></td>
					<td>&nbsp;路段：</td>
					<td><select class="easyui-combobox" id="ld" panelHeight="auto" style="width: 160px;"></select></td>
					<td kid="1"><input class="easyui-numberbox" id="ld_start" panelHeight="auto" style="width: 60px;"></input>—
					    <input class="easyui-numberbox" id="ld_end" panelHeight="auto" style="width: 60px;"></input></td>
					<td>&nbsp;检测指数：</td>
					<td>
						<select class="easyui-combobox" editable="false" id="jczs"panelHeight="auto" style="width: 120px;">
							<option value="PCI">路面损坏(PCI)</option>
							<option value="RQI">路面平整度(RQI)</option>
							<option value="SRI">抗滑性能(SRI)</option>
							<option value="RDI">路面车辙(RDI)</option>
							<option value="PSSI">结构强度(PSSI)</option>
						</select>
					</td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a></td>
				</tr>
				</table>
			<iframe id="reportFrame" style="width:100%;height:100%;border:0;padding-top:10px" > </iframe>
			</div>
			<div title="路面行驶质量指数" style="overflow:hidden;height:50px;padding-top:10px">
				<form id="lmxszl">
				<table id="lmxs">
				<tr>
					<td>&nbsp;<select class="easyui-combobox" id="lmxs_recording" panelHeight="auto">
						<option value="0">按区段</option>
						<option value="1">按路段</option>
					</select></td>
					<td kid="0">&nbsp;区段划分版本：</td>
					<td kid="0"><select class="easyui-combobox" id="qdbb1" panelHeight="auto" style="width: 150px;"></select></td>
					<td>&nbsp;路况评定版本：</td>
					<td><select class="easyui-combobox" name="bb" id="bb1" panelHeight="auto" style="width: 150px;"></select></td>
					<td>&nbsp;路段：</td>
					<td><select class="easyui-combobox" id="ld1" panelHeight="auto" style="width: 160px;"></select></td>
					<td kid="1"><input class="easyui-numberbox" name="szhh" id="ld1_start" style="width: 60px;" data-options="required:true,precision:3"></input>
					—
					<input class="easyui-numberbox" name="ezhh" id="ld1_end" style="width: 60px;" data-options="required:true,precision:3"></input></td>
					<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query1">查询</a></td>
				</tr>
				</table>
				</form>
				<iframe id="report_xszl" style="width:100%;height:100%;border:0;padding-top:10px"> </iframe>
			</div>
		</div>
	</div>
</body>
</html>
