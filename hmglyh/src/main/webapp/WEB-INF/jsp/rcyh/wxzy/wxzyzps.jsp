<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<title></title>
<body>
	<s:if test="wxzy.zps != null and wxzy.zps.size > 0 ">
			<s:iterator value="wxzy.zps" id="zp" status="status">
				<img style="width:880px;" src="<s:property value="#zp.picUrl" />/<s:property value="#zp.zpdz" />" />
				<h5><s:property value="#zp.zpms" /></h5>
				<s:if test="#zp.ryid == 1">
					维修前
				</s:if>
				<s:if test="#zp.ryid == 2">
					维修中
				</s:if>
				<s:if test="#zp.ryid == 1">
					维修后
				</s:if>
			</s:iterator>
	</s:if>
	<s:else>
		<h5>暂无照片信息</h5>
	</s:else>
</body>
</html>