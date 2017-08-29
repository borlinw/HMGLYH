<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("区域路段基础信息调查表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区域导出</title>
<style type="text/css">
	table td{
		text-align:center;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" style="font-size:23px;height:55;"><strong>区域路段基础信息调查表</strong></td>
		</tr>
		<tr>
			<td style="text-align:left;"><strong>调查单位：${qyhfb.bmName }</strong></td>
			<td style="text-align:right;"><strong>表3-8&nbsp;&nbsp;</strong></td>
		</tr>
		<tr>
			<td colspan="2">
				<table border="1" cellpadding="0" cellspacing="0">
					<tr>
						<td style="width:22px;" rowspan="2"><strong>序号</strong></td>
						<td style="width:55px;" rowspan="2"><strong>路线编号</strong></td>
						<td style="width:112px;" rowspan="2"><strong>区域桩号</strong></td>
						<td style="width:62px;" rowspan="2"><strong>公路等级</strong></td>
						<td style="width:180px;" rowspan="2"><strong>路面/桥梁/隧道结构类型</strong></td>
						<td style="width:41px;" rowspan="2"><strong>使用年限</strong></td>
						<td style="width:70px;" rowspan="2"><strong>交通量</strong></td>
						<td style="width:110px;" rowspan="2"><strong>交通组成</strong></td>
						<td style="width:77px;" rowspan="2"><strong>地形特点</strong></td>
						<td colspan="3"><strong>气候特点</strong></td>
						<td style="width:110px;" rowspan="2"><strong>穿越（城市/景区/过境/其他）</strong></td>
						<td style="width:71px;" rowspan="2"><strong>地址特征</strong></td>
						<td style="width:80px;" rowspan="2"><strong>其他需要采集的信息</strong></td>
					</tr>
					<tr>
						<td style="width:71px;"><strong>降雨（mm）</strong></td>
						<td style="width:73px;"><strong>高温（℃）</strong></td>
						<td style="width:71px;"><strong>低温（℃）</strong></td>
					</tr>
					<c:forEach items="${qyhfList }" var="qy">
						<tr>
							<td>${qy.rn }</td>
							<td>${qy.lxCode }线</td>
							<td>K${qy.szhh }-K${qy.ezhh }</td>
							<td>${qy.description }</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>









