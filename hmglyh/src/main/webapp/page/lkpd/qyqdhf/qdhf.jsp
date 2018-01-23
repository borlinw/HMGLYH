<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区段划分</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/qdhf.js"></script>
<script type="text/javascript" src="../js/page.js"></script>
</head>
<body>
<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="qyqdhfHome" style="cursor:pointer;" >区域区段划分</font>&nbsp;&gt;&nbsp;区段划分</div>
<div class="easyui-tabs" fit="true">
<div title="区段划分">
	<div class="easyui-layout" fit="true">
	<div data-options="region:'north',border:true,split:true" style="height:45px;border-left:0px;border-right:0px;border-top:0px;">
		<!-- <div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;区域区段划分&nbsp;&gt;&nbsp;区段划分" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px">	 -->
		<div>
			<!-- <div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="qyqdhfHome" style="cursor:pointer;" >区域区段划分</font>&nbsp;&gt;&nbsp;区段划分</div> -->
			<table style="padding-top: 7px" >
				<tr>
					<td>&nbsp;版本：<select id="bbid" class="easyui-combobox" style="width:130px"></select></td>
					<td>&nbsp;区域：<select id="ldCode" class="easyui-combobox" style="width:130px;"></select></td>
					<td id="fxTd">
						&nbsp;方向：<select id="fx" class="easyui-combobox">
							<option value="0301">上行</option>
							<option value="0302">下行</option>
							<option value="0303">全幅</option>
						</select>
					</td>
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
						<!-- &nbsp;&nbsp;<img id="qdhf" src="../images/button_qdhf.png"  style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="qdhf">区段划分</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="bh">病害图表</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
 		<table  id="myGrid"></table>
    </div>
    </div>
</div>
<div title="区段划分上报" style="overflow:auto;">
	<div class="easyui-layout" fit="true">
	<!-- <div data-options="region:'north',border:true,split:true" style="height:30px;border-left:0px;border-right:0px;border-top:0px;">
		<div>
			<div class="top_div_lr" >路况评定管理&nbsp;&gt;&nbsp;<font id="qyqdhfHome" style="cursor:pointer;" >区域区段划分</font>&nbsp;&gt;&nbsp;区段划分上报</div>
		</div>
	</div> -->
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
 		<table id="reportGrid"></table>
    </div>
    </div>
</div>	
</div>
</body>
</html>