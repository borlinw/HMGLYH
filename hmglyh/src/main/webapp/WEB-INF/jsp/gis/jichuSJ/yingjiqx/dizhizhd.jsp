<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yingjiqx/YingjiqxColumns.js"></script>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(DizhizhdColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(DizhizhdColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['dzzhd.name'] != null && params['dzzhd.name'] != ""){
			condition += " and name like '%" + params['dzzhd.name'] + "%'";
		}
		if(params['dzzhd.roadcode'] != null && params['dzzhd.roadcode'] != ""){
			condition += " and roadcode='" + params['dzzhd.roadcode'] + "'";
		}
		if(params['dzzhd.startzh'] != null && params['dzzhd.startzh'] != ""){
			condition += " and pos >= " + params['dzzhd.startzh'];
		}
		if(params['dzzhd.endzh'] != null && params['dzzhd.endzh'] != ""){
			condition += " and " + params['dzzhd.endzh'] + "> pos";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=DIZHI";
		location.href = YMLib.url + "pb/pub_export.do?" + param;
	});
});
</script>
<title>地址灾害点</title>
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
				        			id:'dizhizhdDMT',
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
		url:"${pageContext.request.contextPath}/gis/yingjiqx_dizhizhdRows.do",
		columns:DizhizhdColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		<s:if test="fromBm">
		queryParams:{
			"dzzhd.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"dzzhd.roadcode":"<s:property value='dzzhd.roadcode' />"
		},
		</s:if>
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.APointByZh([rowData],"yingjiqx","dzzhd.png",DizhizhdColumns,"地质灾害点详细信息",false,getButton)},
		onLoadSuccess:function(data){top.APointByZh(data.rows,"yingjiqx","dzzhd.png",DizhizhdColumns,"地质灾害点详细信息",true,getButton)}
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
					width:80,
					panelWidth:120,
				    <s:if test="fromLx">
				  	value:'<s:property value="dzzhd.roadcode" />',
				  	disabled:'disabled',
				    </s:if>
					url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
					"
					name='dzzhd.roadcode' 
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="dzzhd.bmcode" />',
						onSelect:function(record){
							$('#roadcode').val(record.lxcode);
							$('#startzhh').val(record.szhh);
							$('#endzhh').val(record.ezhh);
						}
						"
						>
						<input id="roadcode" type="hidden" name="dzzhd.roadcode" />
				</s:else>
				</td>
				<td><span>&nbsp;名称：</span><input id="dzname" style="width:120px;" class="combo myCombo" type="text" name="dzzhd.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
				    <span>桩号：</span>
				    <input id="startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="dzzhd.startzh" />
					-
					<input id="endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="dzzhd.endzh" />
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