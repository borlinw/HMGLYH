<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/luxianjc/LuxianjcColumns.js"></script>
<title>平交道口</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(PingjiaodkColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(PingjiaodkColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['pjdk.roadcode'] != null && params['pjdk.roadcode'] != ""){
			condition += " and roadcode='" + params['pjdk.roadcode']+"'";
		}
		if(params['pjdk.startzh'] != null && params['pjdk.startzh'] != ""){
			condition += " and pos >= " + params['pjdk.startzh'];
		}
		if(params['pjdk.endzh'] != null && params['pjdk.endzh'] != ""){
			condition += " and " + params['pjdk.endzh'] + "> pos";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=PINGJIAODAOKOU";
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
						 text:'平交道口卡片',
						 attr:{
							 kplx:'5',
							 dyid:rowData.id,
						 },
						 eventHandler:function(obj){
							 var kplx = $(obj).attr('kplx');
							 var dyid = $(obj).attr('dyid');
							 gisui.createWindow({
					   			id:'qshgzw_hdkp',
					 				title:'平交道口卡片信息',
					 				height:600,
					 				width:900,
					 				src:'/hmglyh/page/gis/page/card.jsp?kplx='+kplx+'&dyid='+dyid
					 		});
						 }
					 },
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
				        			id:'pingjiaodkDMT',
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
				top.APointByZh([rowData],"luxianjc","pjdk.png",PingjiaodkColumns,"平面交叉详细信息",false,getButton);
		}
		
		function onLoadSuccess(data){
				top.APointByZh(data.rows,"luxianjc","pjdk.png",PingjiaodkColumns,"平面交叉详细信息",true,getButton);
		}
		
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/luxianjc_pingjiaodkRows.do",
		columns:PingjiaodkColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		<s:if test="fromBm">
		queryParams:{
			"pjdk.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"pjdk.roadcode":"<s:property value='pjdk.roadcode' />"
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
				<td>
				<s:if test="!fromBm">
							<span>路线：</span><input class="easyui-combobox" data-options="
							valueField:'valueField',
							textField:'textField',
							mode:'remote',
							width:120,
							panelWidth:120,
							<s:if test="fromLx">
						  	value:'<s:property value="pjdk.roadcode" />',
						  	disabled:'disabled',
						    </s:if>
							url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
							" 
						  		name='pjdk.roadcode'
							>
				</s:if>
				<s:else>
					<span>路段：</span>
					<input class="easyui-combobox" data-options="
						valueField:'ldname',
						textField:'ldname',
						editable:'false',
						width:120,
						panelWidth:120,
						panelHeight:130,
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="pjdk.bmcode" />',
						onSelect:function(record){
							$('#roadcode').val(record.lxcode);
							$('#startzhh').val(record.szhh);
							$('#endzhh').val(record.ezhh);
						}
						"
						>
						<input id="roadcode" type="hidden" name="pjdk.roadcode" />
				</s:else>
				</td>
				<td></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
				    <span>桩号：</span>
				    <input id="startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="pjdk.startzh" />
					-
					<input id="endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="pjdk.endzh" />
				</td>
				<td>
					<a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>