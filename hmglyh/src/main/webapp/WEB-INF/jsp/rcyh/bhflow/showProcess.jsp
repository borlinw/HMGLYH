<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../public/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程追踪</title>
</head>
<body style="padding:0px;margin:0px;">
	<s:if test="gmap.isSuccess">
		<img style="" src="${pageContext.request.contextPath}/rcyh/bhflow_getProcessPic.do?definitionKey=<s:property value="definitionKey" />">
		<div style="position:absolute;left:<s:property value = "gmap.x"/>px;top:<s:property value = "gmap.y"/>px;height:<s:property value = "gmap.height"/>px;width:<s:property value = "gmap.width"/>px;border:2px solid red;border-radius:5px;">
		</div>
	</s:if>
	<s:else>
		该流程已经完成或没有对应的流程图
	</s:else>
	
</body>
</html>