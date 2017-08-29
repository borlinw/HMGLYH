<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("哈密公路管理局辖区路网区段划分汇总表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区段划分导出</title>
<style type="text/css">
	table td{
		text-align:center;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="2" style="font-size:23px;height:55;"><strong>哈密公路管理局辖区路网区段划分汇总表</strong></td>
		</tr>
		<tr>
			<td style="text-align:left;"><strong>调查单位：${qdhfb.bmName }</strong></td>
			<td style="text-align:right;"><strong>表3-10&nbsp;&nbsp;</strong></td>
		</tr>
		<tr>
			<td colspan="2">
				<table border='1' cellpadding="0" cellspacing="0">
					<tr>
						<td style="width:22px;" rowspan="3"><strong>序号</strong></td>
						<td style="width:57px;" rowspan="3"><strong>路线编号</strong></td>
						<td style="width:124px;" rowspan="3"><strong>区域桩号</strong></td>
						<td colspan="6"><strong>路况分类指标</strong></td>
						<td style="width:79px;" rowspan="3"><strong>区段类型</strong></td>
						<td style="width:61px;" rowspan="3"><strong>备注</strong></td>
					</tr>
					<tr>
						<td style="width:141px;" rowspan="2"><strong>区段桩号</strong></td>
						<td rowspan="2"><strong>里程</strong></td>
						<td><strong>主指标（PCI）</strong></td>
						<td colspan="3"><strong>辅助控制指标</strong></td>
					</tr>
					<tr>
						<td style="width:79px;"><strong>PCI平均值</strong></td>
						<td style="width:79px;"><strong>IRI平均值</strong></td>
						<td style="width:79px;"><strong>危涵（道）</strong></td>
						<td style="width:79px;"><strong>其他指标</strong></td>
					</tr>
					${qdhfStr }
				</table>
			</td>
		</tr>
	</table>
</body>
</html>