<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>路线多媒体点</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(LuxiandmtdColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(LuxiandmtdColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['dmtd.roadcode'] != null && params['dmtd.roadcode'] != ""){
			condition += " and roadcode='" + params['dmtd.roadcode'] + "'";
		}
		if(params['dmtd.dmtddlx'] != null && params['dmtd.dmtddlx'] != ""){
			condition += " and dmtddlx like '%" + params['dmtd.dmtddlx'] + "%'";
		}
		if(params['dmtd.startzh'] != null && params['dmtd.startzh'] != ""){
			condition += " and startzh >= " + params['dmtd.startzh'];
		}
		if(params['dmtd.endzh'] != null && params['dmtd.endzh'] != ""){
			condition += " and " + params['dmtd.endzh'] + ">= endzh";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=ROADMEDIA";
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
				        			id:'RoadDMT',
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
				top.Apoint([rowData],"yanxianss","lxdmtd.png",LuxiandmtdColumns,"路线多媒体点详细信息",false,getButton);
		}
		
		function onLoadSuccess(data){
				top.Apoint(data.rows,"yanxianss","lxdmtd.png",LuxiandmtdColumns,"路线多媒体点详细信息",true,getButton);
		}
		
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		<s:if test="dmtd.roadcode != null ">
		url:"${pageContext.request.contextPath}/gis/yanxianss_luxiandmtdRows.do?dmtd.roadcode=<s:property value='dmtd.roadcode'/>",
		</s:if>
		<s:else>
		url:"${pageContext.request.contextPath}/gis/yanxianss_luxiandmtdRows.do",
		</s:else>
		columns:LuxiandmtdColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
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
					<span>路线:</span><input class="easyui-combobox" data-options="
					valueField:'valueField',
					textField:'textField',
					width:130,
					panelWidth:130,
					mode:'remote',
					<s:if test="fromLx">
				  	value:'<s:property value="dmtd.roadcode" />',
				  	disabled:'disabled',
				    </s:if>
					url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
					" 
					<s:if test="!fromLx">
					name='dmtd.roadcode'
					</s:if>
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
							url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="dmtd.bmcode" />',
							onSelect:function(record){
								$('#roadcode').val(record.lxcode);
								$('#startzhh').val(record.szhh);
								$('#endzhh').val(record.ezhh);
							}
							"
							>
							<input id="roadcode" type="hidden" name="dmtd.roadcode" />
				</s:else>
				
				</td>
				<td><span>类型:</span>
					<input class="easyui-combobox" data-options="
						width:130,
						panelWidth:130,
						data:[
							{
								text:'LED灯',
								value:'LED灯'
							},
							{
								text:'测速点',
								value:'测速仪'
							},
							{
								text:'测速',
								value:'抓拍'
							},
							{
								text:'固定测速',
								value:'固定测速'
							},
							{
								text:'区段测速仪',
								value:'区段测速仪'
							},
							{
								text:'LED显示屏',
								value:'LED显示屏'
							}
						]
					" type="text" name="dmtd.dmtddlx" >
				</td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
				    <span>桩号:</span>
				    <input id="startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="dmtd.startzh" />
					-
					<input id="endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="dmtd.endzh" />
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