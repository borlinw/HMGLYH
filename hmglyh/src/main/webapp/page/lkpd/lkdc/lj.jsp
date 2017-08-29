<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>路基损坏调查</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/lj.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:78px;border-left:0px;border-right:0px;border-top:0px;">
		<!-- <div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;路况调查&nbsp;&gt;&nbsp;路基" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px"> -->
		<div>
			<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="lkdcHome" style="cursor:pointer;" >路况调查</font>&nbsp;&gt;&nbsp;路基</div>
			<table style="padding-top: 7px" >
				<tr>
					<td>
						&nbsp;部门：
						<select id="bmCode" class="easyui-combotree" panelHeight="auto" style="width:100px;">
						</select>
					</td>
					<td>
						&nbsp;路段：
						<select id="ldCode" class="easyui-combobox" panelHeight="auto" style="width:100px;"></select>
					</td>
					<td>
						&nbsp;方向：
						<select id="fx" class="easyui-combobox" panelHeight="auto" style="width:50px;"></select>
					</td>
					<td>
						&nbsp;版本：
						<select id="bbid" class="easyui-combobox" panelHeight="auto" style="width:100px;"></select>
					</td>
					<td>
						&nbsp;&nbsp;
						<!-- <img id="queryQmld" src="../images/button_search.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="queryQmld">查询</a>
					</td>
					<td>
						&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="import">导入数据</a>
					</td>
					<td>
						&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="export">导出数据</a>
					</td>
					<td>
						&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="exportHz">导出汇总数据</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
 		<table id="lj"></table>
    </div>		
</body>
</html>