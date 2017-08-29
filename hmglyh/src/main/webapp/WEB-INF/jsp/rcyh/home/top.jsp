<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ include file="../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rcyh.css" />
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script>

function imgClick(){
	$("[name=mainFrame]",parent.document).attr("src","../changePassword.jsp");
	//$("[name=mainFrame]",parent.document).changePassword();
	//parent.changePassword();
}

function logout(){
	if(confirm("确认退出系统？")){
		$.post(YMLib.url+"login/logout.do",function(data) {
			if(data){
				parent.document.location.href = YMLib.url + "index.jsp";
			}
		},'json');
	}
}

</script>
</head>
<body>
	<!-- <center><h1>哈密公路管理局公路养护综合管理系统-日常养护管理系统</h1></center> -->
	<div class="top" data-options="region:'north',border:false" style="height: 70px;overflow: hidden;text-align:left;font-size:13px;">
	<div class="logo"><img src="${pageContext.request.contextPath }/images/logo-rcyh.png" width="338" height="70px" border="0"></div>
	<div class="top_right">
		<table width="300" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="236" align="right" style="padding-right:20px;"><s:property value="user.ryname" />，您好</td>
				<td width="42"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath }/images/password.png" onmouseover="this.src='${pageContext.request.contextPath }/images/password_hover.png'" onmouseout="this.src='${pageContext.request.contextPath }/images/password.png'" width="22" height="22" border="0" onClick="imgClick()" ></a></td>
				<td width="42"><a href="javascript:void(0)"><img src="${pageContext.request.contextPath }/images/help.png" onmouseover="this.src='${pageContext.request.contextPath }/images/help_hover.png'" onmouseout="this.src='${pageContext.request.contextPath }/images/help.png'" width="22" height="22" border="0"></a></td>
				<td width="22"><img src="${pageContext.request.contextPath }/images/exit.png" onmouseover="this.src='${pageContext.request.contextPath }/images/exit_hover.png'" onmouseout="this.src='${pageContext.request.contextPath }/images/exit.png'" width="22" height="22" border="0" style="cursor:pointer;" onClick="logout()" ></td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>