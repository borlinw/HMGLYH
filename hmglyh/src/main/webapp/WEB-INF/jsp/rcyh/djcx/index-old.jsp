<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
</head>
<!-- <body class="easyui-layout" fit="true" style="visibility: hidden;"> -->
<body class="easyui-layout" fit="true" >
	<div data-options="region:'center',border:false,title:'日常养护&nbsp;>>&nbsp;冬季除雪',iconCls:'home'" style="padding:0px">
		<div class="easyui-tabs" fit="true" border="false">
			<div title="冬季除雪快报" border="false" style="padding:0px">
				<%-- <iframe src="/hmglyh/ReportServer?reportlet=hmglyh%2Fdjcxkb.cpt&bmcode=<s:property value='user.bmcode' />&username=<s:property value='user.username' />&op=write" frameborder="0" width="100%" height="98%"  ></iframe> --%>
				<iframe src="${pageContext.request.contextPath }/page/rcyh/djcx/cxkbGrid.jsp" frameborder="0" width="100%" height="98%"  ></iframe>
			</div>
			<div title="除雪一览表" border="false" style="padding:0px">
				<iframe src="/hmglyh/ReportServer?reportlet=hmglyh%2Fdjcxylb.cpt" frameborder="0" width="100%" height="98%"  ></iframe>
			</div>
			<div title="除雪年度汇总表" border="false" style="padding:0px">
				<iframe src="/hmglyh/ReportServer?reportlet=hmglyh%2Fcxhzb.cpt&bmcode=<s:property value='user.bmcode' />&username=<s:property value='user.username' />&op=write" frameborder="0" width="100%" height="98%"  ></iframe>
			</div>
			<div title="除雪费用分析（一）" border="false" style="padding:0px">
				<iframe src="/hmglyh/ReportServer?reportlet=hmglyh%2Fcxfyfx1.cpt&op=view" frameborder="0" width="100%" height="98%"  ></iframe>
			</div>
			<div title="除雪费用分析（二）" border="false" style="padding:0px">
				<iframe src="/hmglyh/ReportServer?reportlet=hmglyh%2Fcxfyfx2.cpt&op=view" frameborder="0" width="100%" height="98%"  ></iframe>
			</div>
		</div>
	</div>
</body>
</html>