<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/gouzaowu/GouzaowuColumns.js"></script>
<title>桥隧涵构造物 桥梁列表</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(QiaoliangColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(QiaoliangColumns);
		var params = getParam('fm');
		
		var condition = "where 1=1";
		if(params['ql.roadcode'] != null && params['ql.roadcode'] != ""){
			condition += " and roadcode='" + params['ql.roadcode']+"'";
		}
		if(params['ql.name'] != null && params['ql.name'] != ""){
			condition += " and name like '%" + params['ql.name']+"%'";
		}
		if(params['ql.qlxz'] != null && params['ql.qlxz'] != ""){
			condition += " and qlxz like '%" + params['ql.qlxz']+"%'";
		}
		if(params['ql.qlkjfl'] != null && params['ql.qlkjfl'] != ""){
			condition += " and qlkjfl like '%" + params['ql.qlkjfl']+"%'";
		}
		if(params['ql.startzh'] != null && params['ql.startzh'] != ""){
			condition += " and pos >= " + params['ql.startzh'];
		}
		if(params['ql.endzh'] != null && params['ql.endzh'] != ""){
			condition += " and " + params['ql.endzh'] + "> pos";
		}
		
		condition += "order by roadcode,roadpos";
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=QIAOLIANG";

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
			        	 text:'桥梁卡片',
			        	 attr:{
			        		 kplx:'1',
			        		 dyid:rowData.roadcode+rowData.xzqh+rowData.code,
			        	 },
			        	 eventHandler:function(obj){
			        		 var kplx = $(obj).attr('kplx');
			        		 var dyid = $(obj).attr('dyid');
			        		 gisui.createWindow({
				        			id:'qshgzw_qlkp',
				      				title:'桥梁卡片信息',
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
			        		 roadcode:rowData.roadcode
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		 var roadcode = $(obj).attr('roadcode');
			        		
			        		 gisui.createWindow({
				        			id:'qshgzw_qiaoliangDMT',
				      				title:name+'-多媒体信息',
				      				height:600,
				      				width:900,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_showPicAndUpload.do?code='+(roadcode+xzqh+code)
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
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_bhs.do?ql.code='+code+'&fromQl=true'
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
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_wxs.do?ql.code='+code+'&fromQl=true'
				      		});
			        	 }
			         },
			         {
	    	        	 text:"历史维修记录",
	    	        	 attr:{
	    	        		 qlname : rowData.name,
	    	        		 roadcode : rowData.roadcode,
	    	        		 qlcode : rowData.roadcode+rowData.xzqh+rowData.code,
	    	        		 qzzh : rowData.pos
	    	        	 },
	    	        	 eventHandler:function(obj){
	    	        		 var qlname = $(obj).attr('qlname');
			        		 var roadcode = $(obj).attr('roadcode');
			        		 var qlcode = $(obj).attr('qlcode');
			        		 var qzzh = $(obj).attr('qzzh');
			        		 var lx = 'ql';
	    	        		 gisui.createWindow({
	    	        			 id:'qllswxjl',
	    	        			 title:name+'-历史维修记录',
		    	        		 width:500,
		    	        		 height:450,
		    	        		 src:YMLib.url + 'page/gis/page/lswxjl.jsp?roadcode='+roadcode+'&lx='+lx+'&zh='+qzzh+'&qlcode='+qlcode+'&qlname='+encodeURI(qlname)
	    	        		 });
	    	        	 }
	    	         },
			         {
	    	        	 text:"定期检查",
	    	        	 attr:{
			        		 dyid:rowData.roadcode+rowData.xzqh+rowData.code,
			        	 },
	    	        	 eventHandler:function(obj){
	    	        		 var dyid = $(obj).attr('dyid');
	    	        		 gisui.createWindow({
	    	        			 id:'qldqjc',
	    	        			 title:'定期检查',
		    	        		 width:680,
		    	        		 height:450,
		    	        		 src:YMLib.url + 'page/gis/page/qhjc/qldqjc.jsp?qlcode='+dyid
	    	        		 });
	    	        	 }
	    	         },
			         {
	    	        	 text:"经常性检查",
	    	        	 attr:{
			        		 dyid:rowData.roadcode+rowData.xzqh+rowData.code,
			        	 },
	    	        	 eventHandler:function(obj){
	    	        		 var dyid = $(obj).attr('dyid');
	    	        		 gisui.createWindow({
	    	        			 id:'qljcxjc',
	    	        			 title:'经常性检查',
		    	        		 width:600,
		    	        		 height:450,
		    	        		 src:YMLib.url + 'page/gis/page/qhjc/qljcxjc.jsp?qlcode='+dyid
	    	        		 });
	    	        	 }
	    	         }
			         ];
		};
		
		function onClickRow(rowIndex,rowData){
				top.Apoint([rowData],"gouzaowu","ql.png",QiaoliangColumns,"桥梁详细信息",false,getButton);
		}
		
		function onLoadSuccess(data){
				top.Apoint(data.rows,"gouzaowu","ql.png",QiaoliangColumns,"桥梁详细信息",true,getButton);
		}
		
	</script>

	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/gouzaowu_qiaoliangRows.do",
		columns:QiaoliangColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		<s:if test="fromBm">
		queryParams:{
			"ql.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"ql.roadcode":"<s:property value='ql.roadcode' />"
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
						editable:'true',
						<s:if test="fromLx">
					  	value:'<s:property value="ql.roadcode" />',
					  	disabled:'disabled',
					    </s:if>
						width:120,
						panelWidth:120,
						url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
						"
						name='ql.roadcode' 
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="ql.bmcode" />',
						onSelect:function(record){
							$('#ql_roadcode').val(record.lxcode);
							$('#ql_startzhh').val(record.szhh);
							$('#ql_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="ql_roadcode" type="hidden" name="ql.roadcode" />
					</s:else>
				
					<!-- <input id="ql_startzhh" type="hidden" name="ql.startzhh" />
					<input id="ql_endzh" type="hidden" name="ql.endzhh" />  -->
					
				</td>
				<td><span>桥梁名称：</span>
					<input class="combo myCombo" type="text" name="ql.name" style="width:120px;">
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<span>性质：</span>
					<input type="text" name="ql.qlxz" class="easyui-combobox" data-options="
						width:120,
						panelHeight:'auto',
						data:[
							{
								text:'永久性',
								value:'永久性'
							}
						]
					"/>
				</td>
				<td>
					<span>跨径分类：</span>
					<input type="text" name="ql.qlkjfl" class="easyui-combobox" data-options="
						width:120,
						panelHeight:'auto',
						data:[
							{
								text:'特大桥',
								value:'特大桥'
							},
							{
								text:'大桥',
								value:'大桥'
							},
							{
								text:'中桥',
								value:'中桥'
							},
							{
								text:'小桥',
								value:'小桥'
							}
						]
					"/>
				</td>
				<td>
					<a class="easyui-linkbutton" id="export">导出</a>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<span>桩号：</span>
					<input id="ql_startzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')"  class="combo myCombo" name="ql.startzh" style="width:60px;">
						-
					<input id="ql_endzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')"  class="combo myCombo" name="ql.endzh" style="width:60px" />
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