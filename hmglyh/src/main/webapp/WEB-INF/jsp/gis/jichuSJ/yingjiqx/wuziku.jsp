<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yingjiqx/YingjiqxColumns.js"></script>
<title>拌合场</title>

<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(WuzikuColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(WuzikuColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['wzk.name'] != null && params['wzk.name'] != ""){
			condition += " and name like '%" + params['wzk.name'] + "%'";
		}
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=WUZI";
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
				        			id:'wuzikuDMT',
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
		url:"${pageContext.request.contextPath}/gis/yingjiqx_wuzikuRows.do",
		columns:WuzikuColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.Apoint([rowData],"yingjiqx","wzk.png",WuzikuColumns,"拌合场详细信息",false,getButton)},
		onLoadSuccess:function(data){top.Apoint(data.rows,"yingjiqx","wzk.png",WuzikuColumns,"拌合场详细信息",true,getButton)}
	'>
	</table>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				<%-- <td><span>路线:</span><input class="easyui-combobox" data-options="
				valueField:'valueField',
				textField:'textField',
				mode:'remote',
				width:80,
				panelWidth:120,
				<s:if test="fromLx">
			  	value:'<s:property value="wzk.roadcode" />',
			  	disabled:'disabled',
			    </s:if>
				url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
				"
				<s:if test="fromLx">
			  	 name='wzk.roadcode'
			    </s:if>
				>
				</td> --%>
				<td><span>名称:</span><input class="combo myCombo" type="text" name="wzk.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
				<td><a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>