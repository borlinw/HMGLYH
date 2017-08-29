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
<script type="text/javascript" src="./js/bbk.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:78px;border-left:0px;border-right:0px;border-top:0px;">
		<!-- <div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;基础信息&nbsp;&gt;&nbsp;版本库管理" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px"> -->
		<div>
			<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="jcxxHome" style="cursor:pointer;" >基础信息</font>&nbsp;&gt;&nbsp;版本库管理</div>
			<table style="padding-top: 7px" >
				<tr>
					<td>&nbsp;版本库类型：
					<select id="bblx" class="easyui-combobox" panelHeight="auto">
						<option value="0201">路况调查</option>
						<option value="0202">路面检测</option>
						<option value="0203">路况评定</option>
						<option value="0204">千米路段划分</option>
						<option value="0205">区域区段划分</option>
					</select></td>
					<td>
						&nbsp;&nbsp;
						<!-- <img id="query" src="../images/button_search.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a>
					</td>
					<td>
						<%-- <img id="addBbk" src="${pageContext.request.contextPath}/images/button_add.png"  style="cursor: pointer;"/> --%>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addBbk">添加</a>
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