<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>路况评定管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/lkpd/css/lkpd.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" src="./js/index.js"></script>
</head>
<body id="index_layout" class="easyui-layout" style="visibility: hidden">
	<div data-options="region:'north',border:false" style="height: 70px;overflow: hidden;text-align:left;font-size:13px;padding-top:0px">
		<div class="top">
			<div class="logo"><img src="images/logo.png" width="338" height="70" border="0"></div>
			<div class="top_right">
				<table width="300" border="0" cellspacing="0" cellpadding="0">
					<tr>
					    <td width="236" align="right" style="padding-right:20px;"><span id="userName"></span> ，您好</td>
					    <td width="42"><img id="changePassword" src="${pageContext.request.contextPath }/images/password.png" onmouseover="this.src='${pageContext.request.contextPath }/images/password_hover.png'" onmouseout="this.src='${pageContext.request.contextPath }/images/password.png'" width="22" height="22" border="0" style="cursor:pointer;" ></td>
						<td width="42"><a href="javascript:void(0);"><img src="images/help.png" onmouseover="this.src='images/help_hover.png'" onmouseout="this.src='images/help.png'" width="22" height="22" border="0"></a></td>
						<td width="22"><a href="javascript:void(0);"><img src="images/exit.png" onmouseover="this.src='images/exit_hover.png'" onmouseout="this.src='images/exit.png'" width="22" height="22" border="0" id="logout"></a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div data-options="region:'west',border:'false'" class="left_nav">
		<ul id="left">
			<li kid="0301" style="display: none;">
				<div id="lkpdLkdc" class="lkdc" onclick="$('#frame').attr('src','lkdc/index.jsp')">路况调查</div>
			</li>
			<li kid="0302" style="display: none;">
				<div id="lkpdLmjc" class="lmjc" onclick="$('#frame').attr('src','lkjc/lkjc.jsp')">路面检测</div>
			</li>
			<li kid="0303" style="display: none;">
				<div id="lkpdLkpd" class="lkpd" onclick="$('#frame').attr('src','lkpd/lkpdmx.jsp')">路况评定</div>
			</li>
			<li kid="0304" style="display: none;">
				<div id="lkpdLktjfx" class="lktjfx" onclick="$('#frame').attr('src','lktjfx/index.jsp')">路况统计分析</div>
			</li>
			<li kid="0305" style="display: none;">
				<div id="lkpdQyqdhf" class="qyqdhf" onclick="$('#frame').attr('src','qyqdhf/index.jsp')">区域区段划分</div>
			</li>
			<li kid="0307" style="display:none;">
				<div id="lkpdQdhfsh" class="qyqdhf" onclick="$('#frame').attr('src','qyqdhf/qdhfsh.jsp')">区段划分审核</div>
			</li>
			<li kid="0306" style="display: none;">
				<div id="lkpdJcxx" class="jcxx" onclick="$('#frame').attr('src','jcxx/index.jsp')">基础信息</div>
			</li>
		</ul>
	</div>
	<div data-options="region:'center',border:'false'" style="margin: 0px; padding: 0px;overflow: hidden">
		<iframe id="frame" marginwidth="0" marginheight="0" frameborder="0" style="width:100%; height:100%;border:none;" scrolling="auto" src="${pageContext.request.contextPath}/page/lkpd/lkpd-welcome.jsp" ></iframe>
	</div>
	<div data-options="region:'south',border:false,split:false" style="height: 32px;text-align: center;overflow: hidden;padding-top:0px">
		<div class="foot">哈密公路管理局　版权所有　　　技术支持：北京恒达时讯科技开发有限责任公司</div>
	</div>
</body>
</html>
