<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>路面标线</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(lumianbxColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(lumianbxColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['lumianbx.roadcode'] != null && params['lumianbx.roadcode'] != ""){
			condition += " and roadcode='" + params['lumianbx.roadcode'] + "'";
		}
		if(params['lumianbx.startzh'] != null && params['lumianbx.startzh'] != ""){
			condition += " and spos >= " + params['lumianbx.startzh'];
		}
		if(params['lumianbx.endzh'] != null && params['lumianbx.endzh'] != ""){
			condition += " and " + params['lumianbx.endzh'] + ">= epos";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=LUMIANBX";
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
				        			id:'tianqiaoDMT',
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
			var winid = "yanxianss";
			var lineJson = {
					roadcode:rowData.roadcode,
					startzh:rowData.spos,
					endzh:rowData.epos,
					popup:{
						title:"路面标线",
						rowData:rowData,
						columns:lumianbxColumns
					}
			};
			parent.map.addLineToMap(lineJson);
		}
		
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yanxianss_lumianbxRows.do",
		columns:lumianbxColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		<s:if test="fromBm">
		queryParams:{
			"lumianbx.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"lumianbx.roadcode":"<s:property value='lumianbx.roadcode'/>"
		},
		</s:if>
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:onClickRow
	'>
	</table>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				<td>
				
				<s:if test="!fromBm">
					<span>路线：</span>
					<input class="easyui-combobox" data-options="
					valueField:'valueField',
					textField:'textField',
					mode:'remote',
					width:150,
					<s:if test="fromLx">
				  	value:'<s:property value="tq.roadcode" />',
				  	disabled:'disabled',
				    </s:if>
					panelWidth:150,
					url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
					" 
				  	name='lumianbx.roadcode'
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="lumianbx.bmcode" />',
						onSelect:function(record){
							$('#lumianbx_roadcode').val(record.lxcode);
							$('#lumianbx_startzhh').val(record.szhh);
							$('#lumianbx_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="lumianbx_roadcode" type="hidden" name="lumianbx.roadcode" />
				 </s:else>
				</td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td>
				    <span>桩号：</span>
				    <input id="lumianbx_startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="lumianbx.startzh" />
					-
					<input id="lumianbx_endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="lumianbx.endzh" />
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