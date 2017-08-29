<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/qitays/QitaysColumns.js"></script>
<title>避险车道</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(BixiancdColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(BixiancdColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['bxcd.name'] != null && params['bxcd.name'] != ""){
			condition += " and name like '%" + params['bxcd.name'] + "%'";
		}
		if(params['bxcd.roadcode'] != null && params['bxcd.roadcode'] != ""){
			condition += " and roadcode='" + params['bxcd.roadcode'] + "'";
		}
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=putonggonglubixianchedao";
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
			        		 name:'普通公路避险车道',
			        		 code:rowData.id,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		
			        		 gisui.createWindow({
				        			id:'bixianDMT',
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
		url:"${pageContext.request.contextPath}/gis/qitays_bixiancdRows.do",
		columns:BixiancdColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.Apoint([rowData],"qitays","bxcd.png",BixiancdColumns,"避险车道详细信息",false,getButton)},
		onLoadSuccess:function(data){top.Apoint(data.rows,"qitays","bxcd.png",BixiancdColumns,"避险车道详细信息",true,getButton)}
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
				width:80,
				panelWidth:120,
				url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
				" name='bxcd.roadcode'></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td><span>名称:</span><input class="combo myCombo" type="text" name="bxcd.name" ></td>
				<td><a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>