<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.hdsx.hmglyh.util.MD5Util"%>
<%@ include file="../public/head.jsp"%>
 <link href="${pageContext.request.contextPath}/css/uploadify.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.uploadify.js"></script>
<title></title>
</head>
<body>
	<s:if test="bhjl.zps != null ">
			<s:iterator value="bhjl.zps" id="zp" status="status">
				<img style="width:880px;" src="<s:property value="#zp.picUrl" />/<s:property value="#zp.zpdz" />" />
				<h5><s:property value="#zp.zpms" /></h5>
			</s:iterator>
	</s:if>
	<s:else>
		<h5>暂无照片信息</h5>
	</s:else>
</body>
</html>