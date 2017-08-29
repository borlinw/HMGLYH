<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/luxian/htglld.js"></script>
<title>路线</title>
</head>
<body>
	<tabel id="dg" class="easyui-datagrid" data-options="
		url:'${pageContext.request.contextPath}/gis/luxian_htglldRows.do',
		columns:columns,
		fitColumns:true,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:'#tb',
		<s:if test='ldb.bmcode != null '>
			queryParams:{
				'ldb.bmcode':'<s:property value='ldb.bmcode' />'
			},
		</s:if>
		onClickRow:onClickRow
	"></tabel>
	
	
	<div id="tb" style="padding:10px;height:auto">
		<input type="hidden" id="gydw_ptx" name="ptx" value="<s:property value='#ptx' />">
		<input type="hidden" id="gydw_pty" name="pty" value="<s:property value='#pty' />">
		<form id="fm">
		<input type="hidden" name="ldb.bmcode" value="<s:property value="ldb.bmcode" />" >
		<div>
			<span>路线:</span>
			<input class='easyui-combobox' data-options="
				valueField:'valueField',
				textField:'textField',
				url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'" name="ldb.lxcode"/>
			<a class="easyui-linkbutton" onclick='gridSubmit()'>查询</a>
		</div>
		</form>
	</div>
	
</body>
</html>