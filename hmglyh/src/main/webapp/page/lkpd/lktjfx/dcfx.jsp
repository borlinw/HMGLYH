<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公路路况调查分析</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/testDcfx.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body style="overflow:hidden" class="easyui-layout">
	<div data-options="region:'north',split:false" style="height:32px;">
		<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="lktjfxHome" style="cursor:pointer;" >路况统计分析</font>&nbsp;&gt;&nbsp;公路路况调查分析</div>
	</div>
	<div data-options="region:'center'">
		<div class="easyui-tabs" data-options="fit:true">
			<div title="路面破损" style="overflow:hidden;height:50px;padding-top:10px" >
			<table id="lmps">
			<tr>
				<td>&nbsp;<select class="easyui-combobox" id="lmps_recording" panelHeight="auto">
					<option value="0">按区段</option>
					<option value="1">按路段</option>
				</select></td>
				<td kid="0">&nbsp;区段划分版本：</td>
				<td kid="0"><select class="easyui-combobox" id="qdbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路况调查版本：</td>
				<td><select class="easyui-combobox" id="dcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="ld" panelHeight="auto" kid="ld" style="width: 160px;"></select></td>
				<td kid="1" style="display:none;"><input class="easyui-numberbox" id="ld_start" panelHeight="auto" style="width: 60px;"></input> - 
				<input class="easyui-numberbox" id="ld_end" panelHeight="auto" style="width: 60px;"></input></td>
				<td>&nbsp;路面类型：</td>
				<td><select class="easyui-combobox" id="lmlx" panelHeight="auto" style="width: 100px;"></select></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query">查询</a></td>
			</tr>
			</table>
				<iframe id="report_lm" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
			<div title="路基破损" style="overflow:hidden;height:50px;padding-top:10px">
			<table id="ljps">
			<tr>
				<td>&nbsp;<select class="easyui-combobox" id="ljps_recording" panelHeight="auto">
					<option value="0">按区段</option>
					<option value="1">按路段</option>
				</select></td>
				<td kid="0">&nbsp;区段划分版本：</td>
				<td kid="0"><select class="easyui-combobox" id="qdbb1" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路况调查版本：</td>
				<td><select class="easyui-combobox" id="dcbb1" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="ld1" panelHeight="auto" kid="ld" style="width: 160px;"></select></td>
				<td kid="1" style="display:none;"><input class="easyui-numberbox" id="ld1_start" panelHeight="auto" style="width: 60px;"></input> - 
				<input class="easyui-numberbox" id="ld1_end" panelHeight="auto" style="width: 60px;"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query1">查询</a></td>
			</tr>
			</table>
				<iframe id="report_lj" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
			<div title="桥涵构造物" style="overflow:hidden;height:50px;padding-top:10px">
			<table>
			<tr>
				<td>&nbsp;版本：</td>
				<td><select class="easyui-combobox" id="bb2" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="ld2" panelHeight="auto" kid="ld" style="width: 160px;"></select></td>
				<td><input class="easyui-numberbox" id="ld2_start" panelHeight="auto" style="width: 60px;"></input>—
				<input class="easyui-numberbox" id="ld2_end" panelHeight="auto" style="width: 60px;"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query2">查询</a></td>
			</tr>
			</table>
				<iframe id="report_qh" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
			<div title="沿线设施" style="overflow:hidden;height:50px;padding-top:10px">
				<table id="yxss">
			<tr>
				<td>&nbsp;<select class="easyui-combobox" id="yxss_recording" panelHeight="auto">
					<option value="0">按区段</option>
					<option value="1">按路段</option>
				</select></td>
				<td kid="0">&nbsp;区段划分版本：</td>
				<td kid="0"><select class="easyui-combobox" id="yxqdbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路况调查版本：</td>
				<td><select class="easyui-combobox" id="yxdcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="yxld" panelHeight="auto" kid="ld" style="width: 160px;"></select></td>
				<td kid="1" style="display:none;"><input class="easyui-numberbox" id="yxld_start" panelHeight="auto" style="width: 60px;"></input> - 
				<input class="easyui-numberbox" id="yxld_end" panelHeight="auto" style="width: 60px;"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query3">查询</a></td>
			</tr>
			</table>
				<iframe id="report_yx" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
			<div title="路段病害情况汇总" style="overflow:hidden;height:50px;padding-top:10px">
			<table id="ldbh">
			<tr>
				<td>&nbsp;<select class="easyui-combobox" id="ldbh_recording" panelHeight="auto">
					<option value="0">按区段</option>
					<option value="1">按路段</option>
				</select></td>
				<td kid="0">&nbsp;区段划分版本：</td>
				<td kid="0"><select class="easyui-combobox" id="ldbhqdbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路况调查版本：</td>
				<td><select class="easyui-combobox" id="ldbhdcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路面检测版本：</td>
				<td><select class="easyui-combobox" id="ldbhjcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="ldbhld" panelHeight="auto" kid="ld" style="width: 160px;"></select></td>
				<td kid="1" style="display:none;"><input class="easyui-numberbox" id="ldbhld_start" panelHeight="auto" style="width: 60px;"></input> - 
				<input class="easyui-numberbox" id="ldbhld_end" panelHeight="auto" style="width: 60px;"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query4">查询</a></td>
			</tr>
			</table>
				<iframe id="report_ldhz" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
			<div title="沥青路面养护需求分析汇总表" style="overflow:hidden;height:50px;padding-top:10px">
			<table id="xqfx">
			<tr>
				<td>&nbsp;<select class="easyui-combobox" id="xqfx_recording" panelHeight="auto">
					<option value="0">按区段</option>
					<option value="1">按路段</option>
				</select></td>
				<td kid="0">&nbsp;区段划分版本：</td>
				<td kid="0"><select class="easyui-combobox" id="lqlmqdbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路况调查版本：</td>
				<td><select class="easyui-combobox" id="lqlmdcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路面检测版本：</td>
				<td><select class="easyui-combobox" id="lqlmjcbb" panelHeight="auto" style="width: 150px;"></select></td>
				<td>&nbsp;路段：</td>
				<td><select class="easyui-combobox" id="lqlmld" panelHeight="auto" kid="ld" style="width: 160px;"></select></td>
				<td kid="1" style="display:none;"><input class="easyui-numberbox" id="lqlmld_start" panelHeight="auto" style="width: 60px;"></input> - 
				<input class="easyui-numberbox" id="lqlmld_end" panelHeight="auto" style="width: 60px;"></input></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="query" id="query5">查询</a></td>
			</tr>
			</table>
				<iframe id="report_lqhz" style="width:100%;border:0;height:100%;"> </iframe>
			</div>
		</div>  
	</div>
</body>
</html>
