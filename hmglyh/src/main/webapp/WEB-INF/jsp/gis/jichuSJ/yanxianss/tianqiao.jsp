<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>天桥</title><script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(TianqiaoColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(TianqiaoColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['tq.name'] != null && params['tq.name'] != ""){
			condition += " and name like '%" + params['tq.name'] + "%'";
		}
		if(params['tq.roadcode'] != null && params['tq.roadcode'] != ""){
			condition += " and roadcode='" + params['tq.roadcode'] + "'";
		}
		if(params['tq.startzh'] != null && params['tq.startzh'] != ""){
			condition += " and pos >= " + params['tq.startzh'];
		}
		if(params['tq.endzh'] != null && params['tq.endzh'] != ""){
			condition += " and " + params['tq.endzh'] + "> pos";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=TIANQIAO";
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
				top.Apoint([rowData],"yanxianss","tianqiao.png",TianqiaoColumns,"天桥详细信息",false,getButton);
		}
		
		function onLoadSuccess(data){
				top.Apoint(data.rows,"yanxianss","tianqiao.png",TianqiaoColumns,"天桥详细信息",true,getButton);
		}
		
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yanxianss_tianqiaoRows.do",
		columns:TianqiaoColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		<s:if test="fromBm">
		queryParams:{
			"tq.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"tq.roadcode":"<s:property value='tq.roadcode'/>"
		},
		</s:if>
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
				  	name='tq.roadcode'
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="tq.bmcode" />',
						onSelect:function(record){
							$('#tianqiao_roadcode').val(record.lxcode);
							$('#tianqiao_startzhh').val(record.szhh);
							$('#tianqiao_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="tianqiao_roadcode" type="hidden" name="tq.roadcode" />
				 </s:else>
				</td>
				<td><span>名称：</span><input class="combo myCombo" type="text" name="tq.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
				    <span>桩号：</span>
				    <input id="tianqiao_startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="tq.startzh" />
					-
					<input id="tianqiao_endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="tq.endzh" />
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