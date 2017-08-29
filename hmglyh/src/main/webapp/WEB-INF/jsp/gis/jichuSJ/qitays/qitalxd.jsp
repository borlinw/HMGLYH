<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/qitays/QitaysColumns.js"></script>
<title>其他类型点</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(QitalxdColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(QitalxdColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['qtlxd.name'] != null && params['qtlxd.name'] != ""){
			condition += " and name like '%" + params['qtlxd.name'] + "%'";
		}
		if(params['qtlxd.roadcode'] != null && params['qtlxd.roadcode'] != ""){
			condition += " and roadcode='" + params['qtlxd.roadcode'] + "'";
		}

		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=otherpoint";
		location.href = YMLib.url + "pb/pub_export.do?" + param;
	});
});
</script>
</head>
<body>
	<script>
		var getButton = function(rowData) {
			return [
			         {
			        	 text:"多媒体",
			        	 attr:{
			        		 name:rowData.name,
			        		 code:rowData.code,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		
			        		 gisui.createWindow({
				        			id:'qitalxDMT',
				      				title:name+'-多媒体信息',
				      				height:600,
				      				width:900,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_showPicAndUpload.do?code='+code+'&xzqh='+xzqh
				      			});
			        	 }
			         }
			         ];
		};
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/qitays_qitalxdRows.do",
		columns:QitalxdColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.Apoint([rowData],"qitays","qtlxd.png",QitalxdColumns,"其他类型详细信息",false,getButton)},
		onLoadSuccess:function(data){top.Apoint(data.rows,"qitays","qtlxd.png",QitalxdColumns,"其他类型详细信息",true,getButton)}
	'>
	</table>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				<td><span>名称:</span><input class="combo myCombo" type="text" name="qtlxd.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
				<td><a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>