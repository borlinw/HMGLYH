<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("沥青路面损坏调查汇总表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>路面调查汇总</title>
<style type="text/css">
	table td{
		text-align:center;
		font-size:12px;
	}
</style>
</head>
<body>
	<table cellspacing="1" cellpadding="0" align="center" width="1030">
		<tr>
			<td colspan="2" style="font-size:25px"><strong>沥青路面损坏调查汇总表</strong></td>
			<td style="text-align:right;">表 A-11</td>
		</tr>
		<tr>
			<td style="text-align:left">路线名称：${qmldb.lxCode }线</td>
			<td colspan="2">方向：${qmldb.fxName }</td>
		</tr>
		<tr>
			<td colspan="3">
				<table cellspacing="0" cellpadding="0" align="center" border="1">
					<tr>
						<td rowspan="2">起点桩号</td>
						<td rowspan="2">路段<br/>长度<br/>(m)</td>
						<td rowspan="2">PCI</td>
						<td colspan="3">龟裂(㎡)</td>
						<td colspan="2">块状裂缝<br/>(㎡)</td>
						<td colspan="2">纵向裂缝<br/>(m)</td>
						<td colspan="2">横向裂缝<br/>(m)</td>
						<td colspan="2">坑槽(㎡)</td>
						<td colspan="2">松散(㎡)</td>
						<td colspan="2">沉陷(㎡)</td>
						<td colspan="2">车辙(m)</td>
						<td colspan="2">波浪拥抱<br/>（㎡）</td>
						<td rowspan="2">泛油<br/>(㎡)</td>
						<td rowspan="2">修补<br/>(㎡)</td>
					</tr>
					<tr>
						<td style="height:25px;">轻</td>
						<td>中</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
						<td>轻</td>
						<td>重</td>
					</tr>
					<c:forEach items="${qmldList}" var="qm">
						<tr>
							<td style="height:25px;">${qm.ldName }</td>
							<td>${qm.cd }</td>
							<td>${qm.pci }</td>
							<c:forEach var="i" begin="0" end="20" step="1">
								<td>${qm.lkdcfb[i].ljsj }</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>




























