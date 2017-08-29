<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>日常养护作业任务通知单</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/rcyh_zyrwtzd.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
</head>
<body class="easyui-layout">
	 <div data-options="region:'north',border:true,split:true"
		style="height: 78px; border-left: 0px; border-right: 0px; border-top: 0px;">
		<div id="righttop">
			<div id="p_top" class="top_div_lr" >&nbsp;当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="cxtjHome" style="cursor:pointer;" >查询统计</font>&nbsp;&gt;&nbsp;日常养护作业任务通知单</div>
		</div>
		<table style="padding-top: 7px;" >
			<tr>
				<td style="font-size:12px;" >&nbsp;养护作业单位：</td>
				<td><select class="easyui-combotree" id="yhdw" panelHeight="300px" style="width: 150px;"></select></td>
				<td style="font-size:12px;" >&nbsp;养护区段：</td>
				<td><select class="easyui-combobox" id="yhqd" panelHeight="auto" style="width: 100px;"></select></td>
				<td style="font-size:12px;" >&nbsp;任务来源：</td>
				<td>
					<select class="easyui-combobox" id="rwly"panelHeight="auto">
						<option value="0901">计划</option>
						<option value="0902">巡道</option>
						<option value="0903">补充</option>
					</select>
				</td>
				<td id="xd" style="display:none;">
					&nbsp;
					<select class="easyui-combobox" id="condition" panelHeight="auto">
						<option value="0">按月份</option>
						<option value="1">按时间</option>
					</select>
				</td>
				<td id="month" style="font-size:12px;" >
					&nbsp;
					月份：
					<select class="easyui-combobox" id="yf" panelHeight="300px" style="width: 100px;"></select>
				</td>
				<td id="date" style="display:none;" style="font-size:12px;" >
					&nbsp;日期:<input type="text" id="day" onClick="WdatePicker()"/>
				</td>
				<td>
					&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<iframe id="reportFrame" style="width:100%;height:100%;border:0"> </iframe>
	</div>
</body>
</html>