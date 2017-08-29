<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>日常养护管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script>
function changePassword(){
	/* alert("sssssss");
	YMLib.UI.createWindow("edit", "修改密码", "../changePassword.jsp", "edit",634,320);
	alert("AAAAAAA"); */
}
</script>
</head>
<!-- <FRAMESET style="border-top:1px solid #70d2e0;" frameSpacing=0 rows="70,*,30" frameBorder=1 id="mainparent"> -->
<FRAMESET border="1" frameSpacing=0 rows="70,*,30" frameborder=0 id="mainparent">
	<FRAME name=topFrame src="${pageContext.request.contextPath }/rcyh/home_top.do" noresize frameborder= "no">
	<FRAMESET id="main" border="0" frameSpacing="0" frameBorder="0" cols="153,*" >
		<FRAME name="leftFrame" src="${pageContext.request.contextPath }/rcyh/home_left.do" noResize frameborder= "no">
		<FRAME name="mainFrame" src="${pageContext.request.contextPath }/rcyh/home_main.do" noResize frameborder= "no">
	</FRAMESET>
	<FRAME name=bottomFrame src="${pageContext.request.contextPath }/rcyh/home_bottom.do" noResize scrolling=no frameborder= "no">
</FRAMESET>
</html>
