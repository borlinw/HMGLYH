<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>收费站</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(ShoufeizhanColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(ShoufeizhanColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['sfz.name'] != null && params['sfz.name'] != ""){
			condition += " and name like '%" + params['sfz.name'] + "%'";
		}
		if(params['sfz.roadcode'] != null && params['sfz.roadcode'] != ""){
			condition += " and roadcode='" + params['sfz.roadcode'] + "'";
		}
		if(params['sfz.startzh'] != null && params['sfz.startzh'] != ""){
			condition += " and pos >= " + params['sfz.startzh'];
		}
		if(params['sfz.endzh'] != null && params['sfz.endzh'] != ""){
			condition += " and " + params['sfz.endzh'] + "> pos";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=SHOWFEIZHAN";
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
				        			id:'shoufeizhanDMT',
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
				top.Apoint([rowData],"yanxianss","sfz.png",ShoufeizhanColumns,"收费站详细信息",false,getButton);
		}
		function onLoadSuccess(data){
			top.Apoint(data.rows,"yanxianss","sfz.png",ShoufeizhanColumns,"收费站详细信息",true,getButton);
		}
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yanxianss_shoufeizhanRows.do",	
		columns:ShoufeizhanColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		<s:if test="fromLx">
		queryParams : {
			"sfz.roadcode":"<s:property value='sfz.roadcode'/>"
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
					<span>路线:</span><input class="easyui-combobox" data-options="
						valueField:'valueField',
						textField:'textField',
						mode:'remote',
						width:120,
						width:120,
						<s:if test="fromLx">
					  	value:'<s:property value="sfz.roadcode" />',
					  	disabled:'disabled',
					    </s:if>
						panelWidth:120,
						url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
						"
						name='sfz.roadcode'
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
							url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="sfz.bmcode" />',
							onSelect:function(record){
								$('#roadcode').val(record.lxcode);
								$('#startzhh').val(record.szhh);
								$('#endzhh').val(record.ezhh);
							}
							"
							>
							<input id="roadcode" type="hidden" name="sfz.roadcode" />
				</s:else>
				</td>
				<td>&nbsp;<span>名称:</span><input class="combo myCombo" type="text" name="sfz.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
				    <span>桩号:</span>
				    <input id="startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="sfz.startzh" />
					-
					<input id="endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="sfz.endzh" />
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