<?xml version="1.0" encoding="UTF-8" ?> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/page/rcyh/js/cxbbbIndex.js"></script>
</head>
<body class="easyui-layout" fit="true" style="visibility: hidden;">
	<div data-options="region:'north',split:true,border:false" style="height:76px;border-top:1px solid #95b8e7;border-bottom:1px solid #95b8e7">
		<div class="easyui-panel" title="当前位置：&nbsp;日常养护管理系统&nbsp;>&nbsp;除雪版本" data-options="iconCls:'titleimage',border:false,fit:true"  style="padding:8px 0px 0px 10px">
			<table>
				<tr>
					<td>&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addOneCxbb">添加</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:false" style="padding:0px;border-top:0px solid #95b8e7">
		<table id="myGrid" class="easyui-datagrid" 
			data-options="
			url:'${pageContext.request.contextPath}/rcyh/cxbbb_queryAll.do',
			columns:[datagridFields],
			pageNumber : 1,
			pageSize : 15,
			pageList : [ 15, 25, 35 ],
			rownumbers : true,
			pagination : true,
			fit:true" >
		</table>
	</div>
</body>
</html>
