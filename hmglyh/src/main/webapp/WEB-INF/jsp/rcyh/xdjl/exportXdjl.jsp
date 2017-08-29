<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("巡道记录表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导出巡道记录</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" align="center" width="670">
		<tr>
			<td colspan="6" style='text-align:center;font-size:25px;height:70'><strong>巡道记录表</strong></td>
		</tr>
		<tr>
			<td style="height:40;width:60" nowrap="true">巡视时间</td>
			<td style="text-align:left;width:293;" nowrap="true">${xcsj.stime}至${xcsj.etime}</td>
			<td nowrap="true">巡道路段</td>
			<td nowrap="true" style="width:175">${xcsj.xsld}</td>
			<td nowrap="true">天气</td>
			<td style="width:40;" nowrap="true">${xcsj.tq}</td>
		</tr>
		<tr>
			<td style="height:40">项目</td>
			<td colspan="5" style="text-align:center;">路段、存在问题及数量</td>
		</tr>
		<tr>
			<td style="height:120;">路面</td>
			<td colspan="5" style="word-break:break-all; word-wrap:break-word;text-align:left;">${xcsj.lm}</td>
		</tr>
		<tr>
			<td style="height:120;">路基</td>
			<td colspan="5" style="word-break:break-all; word-wrap:break-word;text-align:left;">${xcsj.lj}</td>
		</tr>
		<tr>
			<td style="height:120;">桥隧涵构造物</td>
			<td colspan="5" style="word-break:break-all; word-wrap:break-word;text-align:left;">${xcsj.qsh}</td>
		</tr>
		<tr>
			<td style="height:120;">沿线设施</td>
			<td colspan="5" style="word-break:break-all; word-wrap:break-word;text-align:left;">${xcsj.yxss}</td>
		</tr>
		<tr>
			<td style="height:120;">备注</td>
			<td colspan="5" style="word-break:break-all; word-wrap:break-word;text-align:left;">${xcsj.bz}</td>
		</tr>
		<tr>
			<td style="height:40">记录人</td>
			<td>${xcsj.jlr}</td>
			<td>负责人</td>
			<td colspan="3">${xcsj.fzr}</td>
		</tr>
	</table>
</body>
</html>