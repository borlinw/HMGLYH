<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>路面检测</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/lkjc.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:78px;border-left:0px;border-right:0px;border-top:0px;">
		<div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;路面检测" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px">
			<table>
				<tr>
					<td>
						&nbsp;路段：
						<select id="ldCode" class="easyui-combobox" panelHeight="auto" style="width:100px;"></select>
					</td>
					<td>
						&nbsp;版本：
						<select id="bbid" class="easyui-combobox" panelHeight="auto" style="width:100px;"></select>
					</td>
					<td>
						&nbsp;方向：
						<select id="fx" class="easyui-combobox" panelHeight="auto" style="width:100px">
							<option value="0301">上行</option>
							<option value="0302">下行</option>
							<option value="0303">双向</option>
						</select>
					</td>
					<td>
						&nbsp;&nbsp;
						<!-- <img id="queryLmjc" src="../images/button_search.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="queryLmjc">查询</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="" id="import">导入数据</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="" id="copy">沿用之前数据</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" iconCls="" id="edit">修改数据</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
 		<div class="easyui-tabs" id="myTabs" fit="true" style="width:500px;height:250px;">
 			<div title="行驶质量RQI">
 				<table id="rqi"></table>
 			</div>
 			<div title="车辙深度RDI">
 				<table id="rdi"></table>
 			</div>
 			<div title="抗滑性能SRI">
 				<table id="sri"></table>
 			</div>
 			<div title="结构强度PSSI">
 				<table id="pssi"></table>
 			</div>
 		</div>
    </div>		
</body>
</html>