<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>交通量观测站</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(JiaotonglianggczColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(JiaotonglianggczColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['gcz.name'] != null && params['gcz.name'] != ""){
			condition += " and name like '%" + params['gcz.name'] + "%'";
		}
		if(params['gcz.roadcode'] != null && params['gcz.roadcode'] != ""){
			condition += " and roadcode='" + params['gcz.roadcode'] + "'";
		}
		if(params['gcz.startzh'] != null && params['gcz.startzh'] != ""){
			condition += " and pos >= " + params['gcz.startzh'];
		}
		if(params['gcz.endzh'] != null && params['gcz.endzh'] != ""){
			condition += " and " + params['gcz.endzh'] + "> pos";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=JIAOTONG";
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
				        			id:'jiaotongDMT',
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
				top.APointByZh([rowData],"yanxianss","gcz.png",JiaotonglianggczColumns,"交通量观测站详细信息",false,getButton);
		}
		function onLoadSuccess(data){
				top.APointByZh(data.rows,"yanxianss","gcz.png",JiaotonglianggczColumns,"交通量观测站详细信息",true,getButton);
		}
	</script>
	
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yanxianss_jiaotonglianggczRows.do",	
		columns:JiaotonglianggczColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		<s:if test="fromLx">
		queryParams : {
			"gcz.roadcode":"<s:property value='gcz.roadcode'/>"
		}
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
					<span>路线：</span>
						<input class="easyui-combobox" data-options="
										valueField:'valueField',
										textField:'textField',
										mode:'remote',
										width:120,
										<s:if test="fromLx">
									  	value:'<s:property value="gcz.roadcode" />',
									  	disabled:'disabled',
									    </s:if>
										panelWidth:120,
										url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
										"
										name='gcz.roadcode'
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
							url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="gcz.bmcode" />',
							onSelect:function(record){
								$('#roadcode').val(record.lxcode);
								$('#startzhh').val(record.szhh);
								$('#endzhh').val(record.ezhh);
							}
							"
							>
							<input id="roadcode" type="hidden" name="gcz.roadcode" />
					</s:else>
				</td>
				<td><span>名称：</span><input style="width:120px;" class="combo myCombo" type="text" name="gcz.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
				    <span>桩号：</span>
				    <input id="startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="gcz.startzh" />
					-
					<input id="endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="gcz.endzh" />
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