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
<!-- 头部 开始 -->
<div class="top" data-options="region:'north',border:false" style="height: 70px;overflow: hidden;text-align:left;font-size:13px;">
	<div class="logo"><img src="${pageContext.request.contextPath }/images/logo-htgl.png" width="338" height="70px" border="0"></div>
	<div class="top_right">
		<table width="300" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="236" align="right" style="padding-right:20px;"><s:property value="user.ryname" />，您好</td>
				<td width="42"><img id="changePassword" src="${pageContext.request.contextPath }/images/password.png" onmouseover="this.src='${pageContext.request.contextPath }/images/password_hover.png'" onmouseout="this.src='${pageContext.request.contextPath }/images/password.png'" width="22" height="22" border="0" style="cursor:pointer;" ></td>
				<td width="42"><img src="${pageContext.request.contextPath }/images/help.png" onmouseover="this.src='${pageContext.request.contextPath }/images/help_hover.png'" onmouseout="this.src='${pageContext.request.contextPath }/images/help.png'" width="22" height="22" border="0" style="cursor:pointer;" ></td>
				<td width="22"><img id="logout" src="${pageContext.request.contextPath }/images/exit.png" onmouseover="this.src='${pageContext.request.contextPath }/images/exit_hover.png'" onmouseout="this.src='${pageContext.request.contextPath }/images/exit.png'" width="22" height="22" border="0" style="cursor:pointer;" ></td>
			</tr>
		</table>
	</div>
</div>
<!-- 头部 结束 -->
	<div data-options="region:'west',border:'false'" style="overflow: hidden; width: 180px; background-color:#d7f3f7;" >
		<ul id="menu1">
			<s:iterator id="m" value="menus">
				<li>
					<s:if test='#m.mkname=="病害类别管理"'>
						<div id="bhlx" class="htglindexbhlx" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
					<s:if test='#m.mkname=="养护类别管理"'>
						<div id="yhlb" class="htglindexyhlbgl" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
					<s:if test='#m.mkname=="工料机管理"'>
						<div id="gljgl" class="htglindexgljgl" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
					<s:if test='#m.mkname=="部门管理"'>
						<div id="bmgl" class="htglindexbmgl" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
					<s:if test='#m.mkname=="路段管理"'>
						<div id="ldgl" class="htglindexldgl" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
					<s:if test='#m.mkname=="人员管理"'>
						<div id="rygl" class="htglindexrygl" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
					<s:if test='#m.mkname=="用户管理"'>
						<div id="yhgl" class="htglindexyhgl" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
					<s:if test='#m.mkname=="角色权限管理"'>
						<div id="jsgl" class="htglindexjsqxgl" onclick="$('#myiframe').attr('src','${pageContext.request.contextPath}<s:property value="#m.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#m.mkname" /></div>
					</s:if>
				</li>
			</s:iterator>
		</ul>
	</div>
	<div id="show" data-options="region:'center',border:'false'" style="margin: 0px; padding: 0px;overflow: hidden;height:99%;width:100%;">
		<iframe src="${pageContext.request.contextPath}/page/htgl/htgl-welcome.jsp" id="myiframe"  frameborder='0' style="height: 100%;width: 100%;" ></iframe>
	</div>
	<!-- 版权 开始 -->
	<div data-options="region:'south',border:false,split:false" style="width:100%; height:32px; background-color:#0791a8; color:#FFF; line-height:32px; text-align:center;">
		<center><font style="font-size:12px;color:#FFF;">哈密公路管理局　版权所有　　　技术支持：北京恒达时讯科技股份有限公司</font></center>
		<!-- 版权所有：哈密公路管理局 　　　　技术支持：北京恒达时讯科技开发有限责任公司 -->
	</div>
	<!-- 版权 结束 -->
</body>
</html>