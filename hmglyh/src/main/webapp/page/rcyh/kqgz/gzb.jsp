<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工资表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="./js/gzb.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:78px;border-left:0px;border-right:0px;border-top:0px;">
		<div id="righttop">
			<div id="p_top" class="top_div_lr" >&nbsp;当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="kqzgHome" style="cursor:pointer;" >考勤工资</font>&nbsp;&gt;&nbsp;工资兑现表</div>
		</div>
		<div id="yssj" style='padding-top:4px;padding-left:11px;text-align:left;display: block;'>
			<table>
				<tr>
					<td>
						&nbsp;管养单位：
						<select id="depart" class="easyui-combotree" panelHeight="auto" style="width:200px;"></select>
					</td>
					<td>
						&nbsp;月份：
						<select id="yf" class="easyui-combobox" panelHeight="auto" style="width:200px;"></select>
					</td>
					<td>
						&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<iframe id="reportFrame" style="width:100%;height:100%;border:0px"></iframe>
    </div>		
</body>
</html>