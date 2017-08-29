<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<title>成功操作</title>
</head>
<body>
	<h4><s:property value="GlobleResultMap.info" /></h4>
	<%-- <s:if test="GlobleResultPage.stayPage == null">
		<a href="<s:property value='GlobleResultMap.rPage' />" ><s:property value='GlobleResultMap.rPageName' /> <span id="num" style="font-weight:bold;color:red"></span></a>
	</s:if>
	
	
	<script>
	
	<s:if test="GlobleResultPage.stayPage == null">
		var t = 3;
		
		var b = setInterval(function(){
			
			$("#num").html(t);
			
			--t;
			
			if( t == 0 ) {
				clearInterval(b);
				document.location.href="<s:property value='GlobleResultMap.rPage' />";
			}
			
		},1000);
	</s:if>
	
		
	
	</script>
	 --%>
</body>
</html>