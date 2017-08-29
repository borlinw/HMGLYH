<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/qitays/QitaysColumns.js"></script>
<title>过水路面</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(GuoshuilmColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(GuoshuilmColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['gslm.roadcode'] != null && params['gslm.roadcode'] != ""){
			condition += " and roadcode='" + params['gslm.roadcode'] + "'";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=guoshuilumian";
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
			        		 name:'过水路面',
			        		 code:rowData.id,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		
			        		 gisui.createWindow({
				        			id:'guoshuilumianDMT',
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
		url:"${pageContext.request.contextPath}/gis/qitays_guoshuilmRows.do",
		columns:GuoshuilmColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.Apoint([rowData],"qitays","gslm.png",GuoshuilmColumns,"过水路面详细信息",false,getButton)},
		onLoadSuccess:function(data){top.Apoint(data.rows,"qitays","gslm.png",GuoshuilmColumns,"过水路面详细信息",true,getButton)}
	'>
	</table>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				<td><span>路线:</span><input class="easyui-combobox" data-options="
				valueField:'valueField',
				textField:'textField',
				mode:'remote',
				url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
				" name='gslm.roadcode'></td>
				<!-- <td><span>名称:</span><input class="combo myCombo" type="text" name="gslm.name" ></td> -->
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
				<td><a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>