<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>路况评定明细</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/lkpdmx.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:78px;border-left:0px;border-right:0px;border-top:0px;">
		<div class="easyui-panel" title="路况评定管理&nbsp;&gt;&nbsp;路况评定明细" data-options="iconCls:'titleimage',border:false,fit:true" style="padding:8px 0px 0px 10px">
			<table>
				<tr>
					<td>
						&nbsp;管辖路段：
						<select id="ldCode" class="easyui-combobox" panelHeight="auto" style="width:100px;"></select>
					</td>
					<td>&nbsp;路况评定版本：
					<select id="bbid" class="easyui-combobox" panelHeight="auto" style="width:130px">
					</select></td>
					<td>
						&nbsp;技术等级：
						<select id="isgs" class="easyui-combobox">
							<option value="1">高速或一级公路</option>
							<option value="0">二级及以下公路</option>
						</select>
					</td>
					<td>
						&nbsp;路面类型：
						<select id="lmlx" class="easyui-combobox">
							<option value="1">沥青路面</option>
							<option value="2">水泥路面</option>
							<option value="3">砂石路面</option>
						</select>
					</td>
					<td>
						&nbsp;方向
						<select id="fx" class="easyui-combobox" style="width:70px;"></select>
					</td>
					<td>
						&nbsp;&nbsp;
						<!-- <img id="getLkpd" src="../images/button_search.png" style="cursor: pointer;"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="getLkpd">查询</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addLkpd">生成数据</a>
					</td>
					<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="exportMxb">导出数据</a>
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