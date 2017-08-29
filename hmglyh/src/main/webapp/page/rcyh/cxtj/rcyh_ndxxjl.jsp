<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>养护作业单位年度学习记录表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/rcyh_ndxxjl.js"></script>
</head>
<body class="easyui-layout">
	 <div data-options="region:'north',border:true,split:true" style="height: 78px; border-left: 0px; border-right: 0px; border-top: 0px;">
		<div id="righttop">
			<div id="p_top"  class="top_div_lr" >&nbsp;当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;养护作业单位年度学习记录表</div>
		</div>
		<table>
			<tr align="center" height="40px" >
				<td>
				&nbsp;<font size="2" >养护作业单位：</font><select class="easyui-combotree" id="bmcode"
					panelHeight="300" style="width: 150px;">
					</select>
				</td>
				<td>
				&nbsp;<font size="2" >年份：</font><select class="easyui-combobox" id="time"
					panelHeight="auto" style="width: 100px;">
					  <option value ="2015">2015</option>
					  <option value ="2014">2014</option>
					  <option value ="2013">2013</option>
					  <option value ="2012">2012</option>
					  <option value ="2011">2011</option>
					</select>
				</td>
				<td>&nbsp;&nbsp;
					<%-- <img id="query" src="${pageContext.request.contextPath}/images/button_search.png" /> --%>
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a>
				</td>
				<td>
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addNdxxjl">添加</a>
				<%-- <td>&nbsp;&nbsp;<img id="addNdxxjl" src="${pageContext.request.contextPath}/images/button_add.png" /></td> --%>
				</td>
				<td>
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="Export1">导出全部</a>
				</td>
			</tr>
		</table>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<div style="display:none" align="center" >
		<form id="ExportXxjlbForm" method="post" action="" display="hidden" enctype="multipart/form-data" >
			<input id="xxjlidToExportOfJsp" name="jlid" style="display:none"/>
		</form>
		</div>
		<table id="myGrid" class=""></table>
	</div>
</body>
</html>
