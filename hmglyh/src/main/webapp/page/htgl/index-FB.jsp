<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统一权限管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/qxgl.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/htgl/js/index.js"></script>
</head>
<body id="index_layout" class="easyui-layout" >
	<div data-options="region:'north',border:false" style="height: 38px;overflow: hidden;text-align:left;font-size:13px;padding-top:5px">
		哈密公路管理局公路养护综合管理系统-统一权限管理系统
	</div>
	<div data-options="region:'west',border:'false'" style="overflow: hidden; width: 130px">
		
		<ul id="menu1">
			<s:iterator id="m" value="menus">
				<li><a onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" href="javascript:void(0)"><s:property value="#m.mkname" /></a></li> 
			</s:iterator>
		</ul>
	</div>
	<div id="show" data-options="region:'center',border:'false'" style="margin: 0px; padding: 0px;overflow: hidden">
		<iframe src="" id="myiframe"  frameborder='0' height='99%' width='100%'></iframe>
	</div>
	<div data-options="region:'south',border:false,split:false" style="height: 28px;text-align: center;overflow: hidden;padding-top:5px">
	新疆哈密公路管理局 &nbsp;&nbsp;版权所有&nbsp;&nbsp;&nbsp;&nbsp; 技术支持：恒达时讯科技（北京）有限公司
	</div>
</body>
</html>