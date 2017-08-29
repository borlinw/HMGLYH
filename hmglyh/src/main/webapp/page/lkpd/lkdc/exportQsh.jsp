<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("桥隧涵构造物损坏调查汇总表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>路面调查汇总</title>
<style type="text/css">
	table td{
		text-align:center;
		font-size:13px;
	}
</style>
</head>
<body>
	<table cellspacing="1" cellpadding="0" align="center" width="1030">
		<tr>
			<td colspan="2" style="font-size:25px"><strong>桥隧涵构造物损坏调查汇总表</strong></td>
			<td style="text-align:right;">表 A-13</td>
		</tr>
		<tr>
			<td style="text-align:left;height:25px;">路线名称：${qmldb.lxCode }线</td>
			<td>方向：${qmldb.fxName }</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3">
				<table cellspacing="0" cellpadding="0" align="center" border="1">
					<tr>
						<td rowspan="2">起点桩号</td>
						<td rowspan="2">路段长度（m）</td>
						<td rowspan="2">BCI</td>
						<td colspan="4" style="height:25px;">桥梁（座）</td>
						<td colspan="3">隧道（座）</td>
						<td colspan="4">涵洞（道）</td>
					</tr>
					<tr>
						<td style="height:25px;">一、二</td>
						<td>三</td>
						<td>四</td>
						<td>五</td>
						<td>S：无异常</td>
						<td>B：有异常</td>
						<td>A：有危险</td>
						<td>好、较好</td>
						<td>较差</td>
						<td>差</td>
						<td>危险</td>
					</tr>
					<c:forEach items="${qmldList}" var="qm">
						<tr>
							<td nowrap="nowrap" style="height:25px;">${qm.ldName }</td>
							<td style="width:50px">${qm.cd }</td>
							<td style="width:40px">${qm.bci }</td>
							<c:forEach var="i" begin="0" end="10" step="1">
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




























