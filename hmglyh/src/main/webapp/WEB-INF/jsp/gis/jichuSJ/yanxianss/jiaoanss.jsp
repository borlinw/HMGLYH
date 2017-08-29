<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>交安设施</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(JiaoanssColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(JiaoanssColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['jass.roadcode'] != null && params['jass.roadcode'] != ""){
			condition += " and roadcode='" + params['jass.roadcode'] + "'";
		}
		if(params['jass.sslx'] != null && params['jass.sslx'] != ""){
			condition += " and sslx like '%" + params['jass.sslx'] + "%'";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=JIAOANSHESHI";
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
			        		 name:'交安设施',
			        		 code:rowData.id,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		
			        		 gisui.createWindow({
				        			id:'jassDMT',
				      				title:name+'-多媒体信息',
				      				height:600,
				      				width:900,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_showPicAndUpload.do?code='+code+'&xzqh='+xzqh
				      			});
			        	 }
			         }
			         ];
		};
		
		function onClickRow(rowIndex,rowData){
			//top.Apoint([rowData],"yanxianss","jass.png",JiaoanssColumns,"交安设施详细信息",false,getButton);
			if( rowData.szlxlx == "主线" && rowData.fx != "下行") {
				var lineJson = {
						windowid:"yanxianss",
						roadcode:rowData.roadcode,
						startzh:rowData.spos,
						endzh:rowData.epos,
						popup:{
							title:'交安设施详情',
							columns:JiaoanssColumns,
							rowData:rowData,
							buttons:getButton(rowData)
						}
				};
				parent.map.addLineToMap(lineJson);
			}else if( rowData.szlxlx == "匝道" ) {
				var lineJson = {
						windowid:"yanxianss",
						roadcode:rowData.roadcode,
						startzh:rowData.spos,
						endzh:rowData.epos,
						ldlx:'4',
						popup:{
							title:'交安设施详情',
							columns:JiaoanssColumns,
							rowData:rowData,
							buttons:getButton(rowData)
						}
				};
				parent.map.addGpsmailroadToMap(lineJson);
			}
			else if ( rowData.fx == "下行" ) {
				var lineJson = {
						windowid:"yanxianss",
						roadcode:rowData.roadcode,
						startzh:rowData.spos,
						endzh:rowData.epos,
						ldlx:'2',
						popup:{
							title:'交安设施详情',
							columns:JiaoanssColumns,
							rowData:rowData,
							buttons:getButton(rowData)
						}
				};
				parent.map.addLineToMap(lineJson);
			} 
		}
		function onLoadSuccess(data){
			//top.Apoint(data.rows,"yanxianss","jass.png",JiaoanssColumns,"交安设施详细信息",true,getButton);
		}
		
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yanxianss_jiaoanssRows.do",	
		columns:JiaoanssColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		<s:if test="fromLx">
		queryParams : {
			"jass.roadcode":"<s:property value='jass.roadcode'/>"
		},
		</s:if>
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:onClickRow,
		onLoadSuccess:onLoadSuccess
	'>
	</table>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				<td><span>路线:</span><input value="<s:property value='jass.roadcode'/>" class="easyui-combobox" data-options="
				valueField:'valueField',
				textField:'textField',
				mode:'remote',
				url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do',
				<s:if test="fromLx" >
				value:'<s:property value="jass.roadcode" />',
				disabled:'disabled',
				</s:if>
				"
					name='jass.roadcode'
				></td>
				<td><span>设施类型</span>
					<input class="easyui-combobox" name="jass.sslx" data-options="
				panelWidth:120,
				width:120,
				panelHeight:130,
				data:[{'text':'护栏板','value':'护栏板'},
				{'text':'防撞墩','value':'防撞墩'},
				{'text':'悬臂式轮','value':'悬臂式轮 廓标'},
				{'text':'波形护栏','value':'波形护栏'},
				{'text':'轮廓标','value':'轮廓标'},
				{'text':'示警桩','value':'示警桩'},
				{'text':'防眩板','value':'防眩板'},
				{'text':'柱式轮廓标','value':'柱式轮廓标'},
				{'text':'标线','value':'标线'}]"/>
				</td>
				<!-- <td><span>名称:</span><input class="combo myCombo" type="text" name="jass.name" ></td> -->
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
				<td><a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>