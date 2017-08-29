<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link href="${pageContext.request.contextPath}/favicon.icon"	rel="SHORTCUT ICON" />
<%@ include file="../public/head.jsp"%>
<title>debug</title>
</head>
<body style="width:100%;height:100%;overflow-y:auto;overflow-x:hidden;padding:0px;margin:0px;">	
	<div id="debugboxContainer">
		<div id='debugbox' style="position:absolute;left:0px;top:0px;overflow-y:auto;font-size:10px;">
				
		</div>
	</div>
	<script>
		//清空 控制台
		function cleardebug(){
			$("#debugbox").html("");
		}	
	</script>
</body>
</html>