<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>构造物卡片</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/uploadify/uploadify2.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/gis/js/tools.js"></script>
<script type="text/javascript" src="tj.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:30px;border-left:0px;border-right:0px;border-top:0px;">
		<table border="0">
			<tr>
				<td>
					<select id="sel" class="easyui-combobox">
						<option value='按单位、公路类型及技术状况分类'>按单位、公路类型及技术状况分类</option>
						<option value='按单位、线路及技术状况及跨径分类'>按单位、线路及技术状况及跨径分类</option>
						<option value='按桥型及技术等级进行分类'>按桥型及技术等级进行分类</option>
						<option value='按桥梁技术状况等级进行分类'>按桥梁技术状况等级进行分类</option>
						<option value='按跨径及技术等级进行分类'>按跨径及技术等级进行分类</option>
						<option value='按跨径及桥长分类'>按跨径及桥长分类</option>
						<option value='桥梁汇总'>按单位、路线分类</option>
					</select>
				</td>
				<td id="showDj" style="display:none;">
					路线技术等级：
					<select id="lxjsdj" class="easyui-combobox">
						<option value='1.高速公路'>1.高速公路</option>
						<option value='2.一级公路'>2.一级公路</option>
						<option value='3.二级公路'>3.二级公路</option>
						<option value='4.三速公路'>4.三速公路</option>
						<option value='5.四级公路'>5.四级公路</option>
					</select>
				</td>
				<td>
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">统计</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<iframe id="showTj" style="width:100%;height:100%;border:0px"></iframe>
    </div>		
</body>
</html>