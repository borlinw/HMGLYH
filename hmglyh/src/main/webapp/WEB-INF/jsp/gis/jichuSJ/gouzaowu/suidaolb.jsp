<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/gouzaowu/GouzaowuColumns.js"></script>
<title>隧道列表</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(SuidaoColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(SuidaoColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['sd.roadcode'] != null && params['sd.roadcode'] != ""){
			condition += " and roadcode='" + params['sd.roadcode']+"'";
		}
		if(params['sd.name'] != null && params['sd.name'] != ""){
			condition += " and name like '%" + params['sd.name']+"%'";
		}
		if(params['sd.sdfl'] != null && params['sd.sdfl'] != ""){
			condition += " and sdfl like '%" + params['sd.sdfl']+"%'";
		}
		if(params['sd.startzh'] != null && params['sd.startzh'] != ""){
			condition += " and pos >= " + params['sd.startzh'];
		}
		if(params['sd.endzh'] != null && params['sd.endzh'] != ""){
			condition += " and " + params['sd.endzh'] + "> pos";
		}
		
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=SUIDAO";

		YMLib.Ajax.POST("pb/getHtml.do",param,"json",function(result){
			location.href = YMLib.url + "page/gis/page/export.jsp";
		},function(){
			
		});
	});
});
</script>
</head>
<body style='width:100%;height:100%;'> 	
	<script>
		var getButton = function(rowData) {
			return [
			         {
			        	 text:'隧道卡片',
			        	 attr:{
			        		 kplx:'2',
			        		 dyid:rowData.roadcode+rowData.xzqh+rowData.code,
			        	 },
			        	 eventHandler:function(obj){
			        		 var kplx = $(obj).attr('kplx');
			        		 var dyid = $(obj).attr('dyid');
			        		 gisui.createWindow({
				        			id:'qshgzw_sdkp',
				      				title:'隧道卡片信息',
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
			        		 xzqh:rowData.xzqh,
			        	 },
			        	 eventHandler:function(obj){
			        		 var name = $(obj).attr('name');
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 gisui.createWindow({
				        			id:'qshgzw_suidaoDMT',
				      				title:name+'-多媒体信息',
				      				height:600,
				      				width:900,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_showPicAndUpload.do?code='+code+'&xzqh='+xzqh
				      			});
			        	 }
			         },
			         {
			        	 text:"病害信息",
			        	 attr:{
			        		 name:rowData.name,
			        		 code:rowData.code,
			        	 },
			        	 eventHandler:function(obj){
			        		 var name = $(obj).attr('name');
			        		 var code = $(obj).attr('code');
			        		 gisui.createWindow({
				        			id:'binghaiyhsj',
				      				title:name+'-病害信息',
				      				height:400,
				      				width:550,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_bhs.do?sd.code='+code+'&fromSd=true'
				      		});
			        	 }
			         },
			         {
			        	 text:"维修作业",
			        	 attr:{
			        		 name:rowData.name,
			        		 code:rowData.code,
			        	 },
			        	 eventHandler:function(obj){
			        		 var name = $(obj).attr('name');
			        		 var code = $(obj).attr('code');
			        		 gisui.createWindow({
				        			id:'weixiuzy',
				      				title:name+'-作业信息',
				      				height:400,
				      				width:550,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_wxs.do?sd.code='+code+'&fromSd=true'
				      		});
			        	 }
			         },{
	    	        	 text:"历史维修记录",
	    	        	 attr:rowData,
	    	        	 eventHandler:function(obj){
	    	        		 var name = $(obj).attr('name');
			        		 var roadcode = $(obj).attr('roadcode');
			        		 var qzzh = $(obj).attr('pos');
			        		 var lx = 'gzw';
	    	        		 gisui.createWindow({
	    	        			 id:'lswxjl',
	    	        			 title:name+'-历史维修记录',
		    	        		 width:500,
		    	        		 height:450,
		    	        		 src:YMLib.url + 'page/gis/page/lswxjl.jsp?roadcode='+roadcode+'&lx='+lx+'&qzzh='+qzzh+'&wxlx='+encodeURI('隧道')
	    	        		 });
	    	        	 }
	    	         }
			         ];
		};
	</script>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/gouzaowu_suidaoRows.do",
		columns:SuidaoColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		<s:if test="fromBm" >
		queryParams:{
			"sd.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx" >
		queryParams:{
			"sd.roadcode":"<s:property value='sd.roadcode' />"
		},
		</s:if>
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.Apoint([rowData],"gouzaowu","sd.png",SuidaoColumns,"隧道详细信息",false,getButton)},
		onLoadSuccess:function(data){top.Apoint(data.rows,"gouzaowu","sd.png",SuidaoColumns,"隧道详细信息",true,getButton)}
	'>
	</table>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				<td>
					<s:if test="!fromBm" >
						<span>路线：</span>
						<input value="<s:property value='sd.roadcode'/>" class="easyui-combobox" data-options="
						valueField:'valueField',
						textField:'textField',
						mode:'remote',
						width:120,
						panelWidth:120,
						<s:if test="fromLx">
					  	value:'<s:property value="sd.roadcode" />',
					  	disabled:'disabled',
					    </s:if>
						url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
						" name='sd.roadcode'>
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="sd.bmcode" />',
						onSelect:function(record){
							$('#sd_roadcode').val(record.lxcode);
							$('#sd_startzhh').val(record.szhh);
							$('#sd_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="sd_roadcode" type="hidden" name="sd.roadcode" />
					</s:else>
				</td>
				<td>
					<span>名称：</span>
					<input class="combo myCombo" type="text" name="sd.name" style="width:120px;" >
				</td>
				<td>
					<a class="easyui-linkbutton" id="export">导出</a>
				</td>
			</tr>
			<tr>
				<td>
					<span>分类：</span>
					<input type="text" name="sd.sdfl" class="easyui-combobox" data-options="
						width:120,
						panelHeight:'auto',	
						data:[
							{
								text:'短隧道',
								value:'短隧道'
							},
							{
								text:'中隧道',
								value:'中隧道'
							},
							{
								text:'长隧道',
								value:'长隧道'
							}
						]
					"/>
				</td>
				<td>
					<span>桩号：</span>
				 	<input id="sd_startzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" name="sd.startzh" style="width:50px">
				 	-
				 	<input id="sd_endzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" name="sd.endzh" style="width:50px">
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