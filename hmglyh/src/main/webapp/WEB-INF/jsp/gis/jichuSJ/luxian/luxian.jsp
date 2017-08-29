<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/luxian/luxian.js"></script>
<title>路线</title>
<style type="text/css">
	 .subtotal { font-weight: bold; }/*合计单元格样式*/
</style>
</head>
<body>
	<tabel id="dg" class="easyui-datagrid" data-options="
		url:'${pageContext.request.contextPath}/gis/luxian_luxianRows.do',
		columns:columns,
		fitColumns:true,
		pageNumber:1,
		pageSize:10,
		pageList:[10,15,20],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:'#tb',
		onClickRow:onClickRow,
		onLoadSuccess : onLoadSuccess
	"></tabel>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<div>
			<span>路线:</span>
			<input class='easyui-combobox' data-options="
				valueField:'valueField',
				textField:'textField',
				mode:'remote',
				url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'" name="lxb.lxcode"/>
			<a class="easyui-linkbutton" onclick='gridSubmit()'>查询</a>
		</div>
		</form>
	</div>
	
</body>
</html>