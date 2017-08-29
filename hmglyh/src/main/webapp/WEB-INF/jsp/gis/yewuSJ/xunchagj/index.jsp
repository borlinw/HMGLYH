<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <jsp:include page="../../public/head.jsp"></jsp:include> --%>
<%@ include file="../../public/head.jsp"%>
<title>查询轨迹</title>
</head>
<body>
	<script>
		var columns = [[
	                       {field:'bmcode',title:'部门编码',width:100},
	                       {field:'username',title:'用户名',width:100},
	                       {field:'stime',title:'开始时间',width:140},
	                       {field:'etime',title:'结束时间',width:140},
	                       {field:'xsld',title:'所属路段',width:160},
	                       {field:'tq',title:'天气',width:100},
	                       {field:'jlr',title:'记录人',width:100},
	                       {field:'fzr',title:'负责人',width:100},
	                       {field:'bz',title:'备注',width:200}
	                   ]];
	</script>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:columns,
		url:'${pageContext.request.contextPath}/rcyh/xdjl_xundaojlRows.do',
		pageNumber:1,
		pageSize:10,
		queryParams:{
			'xcsj.bmcode':'<s:property value="user.bmcode" />'
		},
		pageList:[10,20,30],
		pagination:true,
		singleSelect:true,
		fit:true,
		onClickRow:function(rowIndex,rowData){
			clearInterval(parent.map.intervalHandler);
			parent.map.clearLayerByWindowId('xunchagj');
		
			var xcid = rowData.xcid;
			parent.map.addXdgjLineToMap({xcid:xcid,windowid:'xunchagj'});
		},
		toolbar:'#toolbar'
	">
	</table>
	<div id="toolbar" style="padding:10px;">
		<form id="fm" class="search-form">
		   部门：<input name="xcsj.bmcode" class="easyui-combotree" data-options="
			  		url:'${pageContext.request.contextPath}/gis/guanyangdw_bmtree.do',
			  		width:80,
			  		panelWidth:120
			  ">&nbsp;
		  日期： <input name="xcsj.stime" class="easyui-datebox" data-options="width:80" /> - <input data-options="width:80" name="xcsj.etime" class="easyui-datebox" />
		  <a onclick="$('#dg').datagrid('load',getParam('fm'))" class="easyui-linkbutton" data-options="plain:true">查询</a>
		</form>
	</div>
	
</body>
</html>