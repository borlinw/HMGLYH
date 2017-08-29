<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("路况评定明细表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table td{
		text-align:center;
		font-size : 12px;
	}
</style>
</head>
<body>
	<table border="1" cellspacing="1" cellpadding="0" align="center" width="700">
		<tr>
			<td colspan="12" style="text-align:center;font-size:23px;height:45px;"><strong>表A-7 公路技术状况评定明细表</strong></td>
		</tr>
		<tr>
			<td style="height:25px;">路线名称：</td>
			<td>${qmldb.lxCode }</td>
			<td colspan="3">技术等级：<c:if test="${qmldb.isgs==1 }">
				高速或一级公路
			</c:if>
			<c:if test="${qmldb.isgs==0 }">二级及以上公路</c:if>
			</td>
			<td colspan="4">路面类型：
				<c:if test="${qmldb.lmlx==1 }">沥青路面</c:if>
				<c:if test="${qmldb.lmlx==2 }">水泥路面</c:if>
				<c:if test="${qmldb.lmlx==3 }">砂石路面</c:if>
			</td>
			<td colspan="3">检测方向：${qmldb.fxName }</td>
		</tr>
		<tr>
			<td rowspan="2">路段桩号</td>
			<td rowspan="2">长度（m）</td>
			<td rowspan="2">MQI</td>
			<td rowspan="2">路面PQI</td>
			<td colspan="5" style="height:25px;">路面分项指标</td>
			<td rowspan="2">路基SCI</td>
			<td rowspan="2">桥隧构造物<br/>BCI</td>
			<td rowspan="2">沿线设施<br/>TCI</td>
		</tr>
		<tr>
			<td style="height:25px;">PCI</td>
			<td>RQI</td>
			<td>RDI</td>
			<td>SRI</td>
			<td>PSSI</td>
		</tr>
		<c:forEach items="${qmldb.mxbList}" var="qm">
		<tr>
			<td style="height:25px;">K${qm.szhh }-K${qm.ezhh }</td>
			<td>${qm.cd }</td>
			<td>${qm.mqi }</td>
			<td>${qm.pqi }</td>
			<td>${qm.pci }</td>
			<td>${qm.rqi }</td>
			<td>${qm.rdi }</td>
			<td>${qm.sri }</td>
			<td>${qm.pssi }</td>
			<td>${qm.sci }</td>
			<td>${qm.bci }</td>
			<td>${qm.tci }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>