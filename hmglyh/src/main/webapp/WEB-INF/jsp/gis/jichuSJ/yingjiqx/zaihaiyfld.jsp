<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yingjiqx/YingjiqxColumns.js"></script>
<title>灾害易发路段</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(ZaihaiyfldColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(ZaihaiyfldColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['zhyfld.name'] != null && params['zhyfld.name'] != ""){
			condition += " and name like '%" + params['zhyfld.name'] + "%'";
		}
		if(params['zhyfld.roadcode'] != null && params['zhyfld.roadcode'] != ""){
			condition += " and roadcode='" + params['zhyfld.roadcode'] + "'";
		}
		if(params['zhyfld.startzh'] != null && params['zhyfld.startzh'] != ""){
			condition += " and startzh >= " + params['zhyfld.startzh'];
		}
		if(params['zhyfld.endzh'] != null && params['zhyfld.endzh'] != ""){
			condition += " and " + params['zhyfld.endzh'] + ">= endzh";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=zaihaiyifald";
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
			        		 name:'灾害易发路段',
			        		 code:rowData.id,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		
			        		 gisui.createWindow({
				        			id:'zaihaiyfldDMT',
				      				title:name+'-多媒体信息',
				      				height:600,
				      				width:900,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_showPicAndUpload.do?code='+code+'&xzqh='+xzqh
				      			});
			        	 }
			         }
			         ];
		};
		/**
	     *  根据 路线编码 和桩号 定线 如果 桩号 不传 定 整条线
	     *  lineJson {
	     *  	windowid:			窗口id
	     *  	roadcode:roadcode,	路线编码	必须
	     *  	startzh:startzh,	起点桩号	
	     *  	endzh:endzh			止点桩号
	     *  	strokeColor:   		标线颜色
	     *  }
	     */
		function onClickRow(rowIndex,rowData){
			var winid = "yingjiqx";
			var lineJson = {
					roadcode:rowData.roadcode,
					startzh:rowData.spos,
					endzh:rowData.epos,
					popup:{
						title:"灾害易发路段",
						rowData:rowData,
						columns:ZaihaiyfldColumns,
						buttons:getButton(rowData)
					}
			};
			parent.map.addLineToMap(lineJson);
		}
		
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yingjiqx_zaihaiyfldRows.do",
		columns:ZaihaiyfldColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		<s:if test="fromBm">
		queryParams:{
			"zhyfld.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"zhyfld.roadcode":"<s:property value='zhyfld.roadcode' />"
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
						width:80,
						panelWidth:120,
						<s:if test="fromLx">
					  	value:'<s:property value="zhyfld.roadcode" />',
					  	disabled:'disabled',
					    </s:if>
						url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
						"
						name='zhyfld.roadcode'
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
							url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="zhyfld.bmcode" />',
							onSelect:function(record){
								$('#roadcode').val(record.lxcode);
								$('#startzhh').val(record.szhh);
								$('#endzhh').val(record.ezhh);
							}
							"
							>
						<input id="roadcode" type="hidden" name="zhyfld.roadcode" />				
				</s:else>
				</td>
				<td><span>&nbsp;名称：</span><input style="width:120px;" class="combo myCombo" type="text" name="zhyfld.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
				    <span>桩号：</span>
				    <input id="startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="zhyfld.startzh" />
					-
					<input id="endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="zhyfld.endzh" />
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