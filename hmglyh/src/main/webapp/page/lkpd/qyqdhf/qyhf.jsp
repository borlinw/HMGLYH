<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>版本库管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/qyhf.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:78px;border-left:0px;border-right:0px;border-top:0px;">
		<!-- <div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;区域区段划分&nbsp;&gt;&nbsp;区域划分" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px"> -->
		<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="qyqdhfHome" style="cursor:pointer;" >区域区段划分</font>&nbsp;&gt;&nbsp;区域划分</div>
		<div>
			<table style="padding-top: 7px" >
				<tr>
					<td>&nbsp;管养路段：<select id="ldCode" class="easyui-combobox" style="width:130px;"></select></td>
					<td>&nbsp;版本：<select id="bbid" class="easyui-combobox" style="width:130px"></select></td>
					<td>
						&nbsp;&nbsp;
						<!-- <img id="query" src="../images/button_search.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a>
					</td>
					<td>
						<!-- <img id="clear" src="../images/button_clear.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="clear">清空</a>
					</td>
					<td>
						<!-- <img id="qyhf" src="../images/button_qyhf.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="qyhf">区域划分</a>
					</td>
					<td>
						<!-- <img id="qyhf" src="../images/button_qyhf.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="copy">沿用之前数据</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="export">导出</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="showChart">图形视图</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
 		<table  id="myGrid"></table>
    </div>		
</body>
</html>