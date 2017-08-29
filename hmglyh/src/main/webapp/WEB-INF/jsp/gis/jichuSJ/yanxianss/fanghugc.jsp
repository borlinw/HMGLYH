<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>防护工程</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(fanghugcColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(fanghugcColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['fanghugc.roadcode'] != null && params['fanghugc.roadcode'] != ""){
			condition += " and roadcode='" + params['fanghugc.roadcode'] + "'";
		}
		if(params['fanghugc.startzh'] != null && params['fanghugc.startzh'] != ""){
			condition += " and spos >= " + params['fanghugc.startzh'];
		}
		if(params['fanghugc.endzh'] != null && params['fanghugc.endzh'] != ""){
			condition += " and " + params['fanghugc.endzh'] + ">= epos";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=FANGHUGC";
		location.href = YMLib.url + "pb/pub_export.do?" + param;
	});
});
</script>
</head>
<body>
	<script>
		function onClickRow(rowIndex,rowData){
			var lineJson = {
					windowid:"fanghugc",
					strokeColor:"#00ff00",
					roadcode:rowData.roadcode,
					startzh:rowData.spos,
					endzh:rowData.epos,
					popup:{
						title:"防护工程详情",
						rowData:rowData,
						columns:[[{field:'roadcode',title:'路线编码'},{field:'wz',title:'桩号'}]]
					}
				};
			
			parent.map.addLineToMap(lineJson);
		}
		
		
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yanxianss_fanghugcRows.do",
		columns:fanghugcColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		<s:if test="fromBm">
		queryParams:{
			"fanghugc.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"fanghugc.roadcode":"<s:property value='fanghugc.roadcode'/>"
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
				  	value:'<s:property value="fanghugc.roadcode" />',
				  	disabled:'disabled',
				    </s:if>
					panelWidth:150,
					url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
					" 
				  	name='fanghugc.roadcode'
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="fanghugc.bmcode" />',
						onSelect:function(record){
							$('#tianqiao_roadcode').val(record.lxcode);
							$('#tianqiao_startzhh').val(record.szhh);
							$('#tianqiao_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="tianqiao_roadcode" type="hidden" name="fanghugc.roadcode" />
				 </s:else>
				</td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td>
				    <span>桩号：</span>
				    <input id="tianqiao_startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="fanghugc.startzh" />
					-
					<input id="tianqiao_endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="fanghugc.endzh" />
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