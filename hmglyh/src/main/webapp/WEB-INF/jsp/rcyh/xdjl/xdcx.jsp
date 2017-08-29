<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/xdcx.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/page.js"></script>
<title>巡道记录</title>
</head>
<body>
	<table id="xd" class="easyui-datagrid"></table>
	<div id="toolbar" style="padding:0px;">
		<div data-options="region:'north',border:true,split:false" style="height:30px;border-left:0px;border-right:0px;border-top:0px">
			<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="cxtjHome" style="cursor:pointer;" >查询统计</font>&nbsp;&gt;&nbsp;巡道记录信息查询</div>
		</div>
		<div style="padding:10px;">
			<span class="myformsearch">
				<form id="fm" class="search-form">
				  日期： <input name="xcsj.stime" class="easyui-datebox" /> - <input name="xcsj.etime" class="easyui-datebox" />
				 &nbsp;
				 单位：
				 <select name="xcsj.bmcode" id="bmCode" class="easyui-combobox"></select>
				 <input type="hidden" id="bmcode" value='<s:property value="user.bmcode" />'/>
				 &nbsp;
				 路段： <input name="xcsj.xsld" class="combo" style="width:150px" > 
				  <a class="easyui-linkbutton" onclick='loadData()' data-options="plain:true,iconCls:'query'">筛选</a>
				</form>
			</span>
		</div>
	</div>
</body>
</html>