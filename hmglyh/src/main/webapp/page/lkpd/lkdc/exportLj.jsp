<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("路基损坏调查汇总表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
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
			<td colspan="2" style="font-size:23px"><strong>路基损坏调查汇总表</strong></td>
			<td style="text-align:right;">表 A-12</td>
		</tr>
		<tr>
			<td style="text-align:left" style="height:25px;">路线名称：${qmldb.lxCode }线</td>
			<td colspan="2">方向：${qmldb.fxName }</td>
		</tr>
		<tr>
			<td colspan="3">
				<table cellspacing="0" cellpadding="0" align="center" border="1">
					<tr>
						<td rowspan="2">起点桩号</td>
						<td rowspan="2">路段<br/>长度<br/>(m)</td>
						<td rowspan="2">SCI</td>
						<td rowspan="2">路肩边<br/>沟不洁<br/>(m)</td>
						<td colspan="2">路肩损坏<br/>(㎡)</td>
						<td colspan="3">边坡坍塌(处)</td>
						<td colspan="3">水毁冲沟(处)</td>
						<td colspan="3">路基构造物损坏(处)</td>
						<td rowspan="2">路缘石<br/>缺损<br/>(m)</td>
						<td colspan="3">路基沉降(处)</td>
						<td colspan="2">排水系统<br/>淤塞</td>
					</tr>
					<tr>
						<td style="height:25px;">轻</td>
						<td>重</td>
						<td>轻</td>
						<td>中</td>
						<td>重</td>
						<td>轻</td>
						<td>中</td>
						<td>重</td>
						<td>轻</td>
						<td>中</td>
						<td>重</td>
						<td>轻</td>
						<td>中</td>
						<td>重</td>
						<td>轻(m)</td>
						<td>重(处)</td>
					</tr>
					<c:forEach items="${qmldList}" var="qm">
						<tr>
							<td nowrap="nowrap" style="height:25px;">${qm.ldName }</td>
							<td>${qm.cd }</td>
							<td>${qm.sci }</td>
							<c:forEach var="i" begin="0" end="17" step="1">
								<td style="width:52px;">${qm.lkdcfb[i].ljsj }</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>




























