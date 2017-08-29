<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yingjiqx/YingjiqxColumns.js"></script>
<title>应急保障点</title>

<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(YingjibzdColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(YingjibzdColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['yjbzd.roadcode'] != null && params['yjbzd.roadcode'] != ""){
			condition += " and roadcode='" + params['yjbzd.roadcode'] + "'";
		}
		if(params['yjbzd.startzh'] != null && params['yjbzd.startzh'] != ""){
			condition += " and startzh >= " + params['yjbzd.startzh'];
		}
		if(params['yjbzd.endzh'] != null && params['yjbzd.endzh'] != ""){
			condition += " and " + params['yjbzd.endzh'] + ">= endzh";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=yingjibaozhangdian";
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
			        		 name:'应急保障点',
			        		 code:rowData.id,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		
			        		 gisui.createWindow({
				        			id:'yijibzdDMT',
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
		url:"${pageContext.request.contextPath}/gis/yingjiqx_yingjibzdRows.do",
		columns:YingjibzdColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		<s:if test="fromBm">
		queryParams:{
			"yjbzd.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"yjbzd.roadcode":"-1<s:property value='yjbzd.roadcode' />"
		},
		</s:if>
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.Apoint([rowData],"yingjiqx","yjbzd.png",YingjibzdColumns,"应急保障点详细信息",false,getButton)},
		onLoadSuccess:function(data){top.Apoint(data.rows,"yingjiqx","yjbzd.png",YingjibzdColumns,"应急保障点详细信息",true,getButton)}
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
										  	value:'<s:property value="yjbzd.roadcode" />',
										  	disabled:'disabled',
										    </s:if>
											url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
											" 
											name='yjbzd.roadcode'
											>
				</s:if>
				<s:else>
					<span>路段：</span>
					<input class="easyui-combobox" data-options="
							valueField:'ldname',
							textField:'ldname',
							editable:'false',
							width:100,
							panelWidth:100,
							panelHeight:130,
							url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="yjbzd.bmcode" />',
							onSelect:function(record){
								$('#roadcode').val(record.lxcode);
								$('#startzhh').val(record.szhh);
								$('#endzhh').val(record.ezhh);
							}
							"
							>
						<input id="roadcode" type="hidden" name="yjbzd.roadcode" />	
				</s:else>
				</td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td>
				    <span>桩号：</span>
				    <input id="startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:50px;" class="combo myCombo" type="text" name="yjbzd.startzh" />
					-
					<input id="endzhh" style="width:50px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="yjbzd.endzh" />
				</td>
				<td><a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>