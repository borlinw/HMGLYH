<%@ page language="java" contentType="application/msexcel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% response.setHeader("Content-disposition","inline; filename="+new String("公路日常养护巡查记录表.xls".getBytes("GBK"),"ISO-8859-1"));  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导出巡道记录</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td style='text-align:center;font-size:25px;height:70px;width:600px;'><strong>公路日常养护巡查记录表</strong></td>
		</tr>
		<tr>
			<td style="height:38px;">巡查单位：${xcsj.bmname}</td>
		</tr>
		<tr>
			<td style="height:38px;">
				路线及桩号：${xcsj.xsld}&nbsp;&nbsp;日期：${xcsj.xcrq}${xcsj.stime}时-${xcsj.etime}时
			</td>
		</tr>
		<tr>
			<td>
				<table border="1" cellpadding="0" cellspacing="0" style="word-wrap: break-word; word-break: break-all;">
					<tr>
						<td style="width:200px;height:38px;">巡查车辆：</td>
						<td style="width:400px;">巡查人员（签名）：</td>
					</tr>
					<tr>
						<td style="height:60px;">天气：${xcsj.tq}</td>
						<td><p>巡查类型：</p>
						日常巡查□&nbsp;&nbsp;特殊巡查□&nbsp;&nbsp;夜间巡查□
					</tr>
					<tr>
						<td style="height:180px;word-break:break-all; word-wrap:break-word;width:200px">发现问题情况描述、预计工程量（路线、桩号、损坏部位、病害等）</td>
						<td>路面：${xcsj.lm}<br/>
						路基：${xcsj.lj}<br/>
						桥隧涵构造物：${xcsj.qsh}<br/>
						沿线设施：${xcsj.yxss}</td>
					</tr>
					<tr>
						<td style="height:180px;">现场处置情况</td>
						<td>
							${xcsj.bz }
							<%-- <c:forEach items="${xcsj.wxqk }" var="item">
								${item}<br/>
							</c:forEach> --%>
						</td>
					</tr>
					<tr>
						<td style="height:38px;">上报情况</td>
						<td>
							<c:if test="${xcsj.sfsb == 0 }">未上报</c:if>
							<c:if test="${xcsj.sfsb == 1 }">已上报</c:if>
						</td>
					</tr>
					<tr>
						<td style="height:38px;">照片编号</td>
						<td>${xcsj.zpxx}</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				说明：1、巡道照片设置拍摄日期，妥善存储巡查照片，巡查记录中只填写照片编号。<br/>
				2、日常、特殊、夜间巡查都用此表样，按月装订成册。
			</td>
		</tr>
	</table>
</body>
</html>