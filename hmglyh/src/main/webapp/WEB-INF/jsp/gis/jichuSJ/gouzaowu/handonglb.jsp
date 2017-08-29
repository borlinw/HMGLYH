<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/gouzaowu/GouzaowuColumns.js"></script>
<title>涵洞列表</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(HandongColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(HandongColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['hd.roadcode'] != null && params['hd.roadcode'] != ""){
			condition += " and roadcode='" + params['hd.roadcode']+"'";
		}
		if(params['hd.name'] != null && params['hd.name'] != ""){
			condition += " and name like '%" + params['hd.name']+"%'";
		}
		if(params['hd.hdlx'] != null && params['hd.hdlx'] != ""){
			condition += " and hdlx like '%" + params['hd.hdlx']+"%'";
		}
		if(params['hd.dsmc'] != null && params['hd.dsmc'] != ""){
			condition += " and dsmc like '%" + params['hd.dsmc']+"%'";
		}
		if(params['hd.startzh'] != null && params['hd.startzh'] != ""){
			condition += " and pos >= " + params['hd.startzh'];
		}
		if(params['hd.endzh'] != null && params['hd.endzh'] != ""){
			condition += " and " + params['hd.endzh'] + "> pos";
		}
		
		
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=HANDONG";

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
			        	 text:'涵洞卡片',
			        	 attr:{
			        		 kplx:'3',
			        		 dyid:rowData.roadcode+rowData.xzqh+rowData.code,
			        	 },
			        	 eventHandler:function(obj){
			        		 var kplx = $(obj).attr('kplx');
			        		 var dyid = $(obj).attr('dyid');
			        		 gisui.createWindow({
				        			id:'qshgzw_hdkp',
				      				title:'涵洞卡片信息',
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
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var name = $(obj).attr('name');
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 gisui.createWindow({
				        			id:'qshgzw_handongDMT',
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
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_bhs.do?hd.code='+code+'&fromHd=true'
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
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_wxs.do?hd.code='+code+'&fromHd=true'
				      		});
			        	 }
			         },
			         {
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
		    	        		 src:YMLib.url + 'page/gis/page/lswxjl.jsp?roadcode='+roadcode+'&lx='+lx+'&qzzh='+qzzh+'&wxlx='+encodeURI('涵洞')
	    	        		 });
	    	        	 }
	    	         }
			         ];
		};
	</script>
	 
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/gouzaowu_handongRows.do",
		columns:HandongColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		<s:if test="fromBm">
		queryParams:{
			"hd.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"hd.roadcode":"<s:property value='hd.roadcode' />"
		},
		</s:if>
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:function(rowIndex,rowData){top.APointByZh([rowData],"gouzaowu","hd.png",HandongColumns,"涵洞详细信息",false,getButton)},
		onLoadSuccess:function(data){top.APointByZh(data.rows,"gouzaowu","hd.png",HandongColumns,"涵洞详细信息",true,getButton)}
	'>
	</table>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				
				<td>
				<s:if test="!fromBm">
						<span>路线：</span>
						<input value="<s:property value='hd.roadcode'/>" class="easyui-combobox" data-options="
							valueField:'valueField',
							textField:'textField',
							mode:'remote',
							width:120,
							panelWidth:120,
							<s:if test="fromLx">
						  	value:'<s:property value="hd.roadcode" />',
						  	disabled:'disabled',
						    </s:if>
							url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
							" 
							name='hd.roadcode' 
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="hd.bmcode" />',
						onSelect:function(record){
							$('#hd_roadcode').val(record.lxcode);
							$('#hd_startzhh').val(record.szhh);
							$('#hd_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="hd_roadcode" type="hidden" name="hd.roadcode" />
				</s:else>
				</td>
				<td><span>名称：</span><input style="width:120px;" class="combo myCombo" type="text" name="hd.name" ></td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td>
					<span>类型：</span>
					<%--   <input class="easyui-combobox" data-options="
						valueField:'ldname',
						textField:'ldname',
						editable:'false',
						width:120,
						panelWidth:120,
						panelHeight:130,
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="hd.bmcode" />',
						onSelect:function(record){
							$('#hd_roadcode').val(record.roadcode);
							$('#hd_startzhh').val(record.szhh);
							$('#hd_endzhh').val(record.ezhh);
						}
						"
						> --%>
					<input class="easyui-combobox" data-options="
										width:120,
										panelWidth:120,
										panelHeight:130,
										data:[
											{
												text:'暗涵',
												value:'暗涵'
											},
											{
												text:'盖板暗涵',
												value:'盖板暗涵'
											},
											{
												text:'砼盖板涵',
												value:'砼盖板涵'
											},
											{
												text:'管涵',
												value:'管涵'
											},
											{
												text:'钢波形管涵',
												value:'钢波形管涵'
											},
											{
												text:'混凝土盖板暗涵',
												value:'混凝土盖板暗涵'
											},
											{
												text:'盖板明涵',
												value:'盖板明涵'
											},
											{
												text:'拱涵',
												value:'拱涵'
											},
											{
												text:'石拱涵',
												value:'石拱涵'
											},
											{
												text:'铸铁管',
												value:'铸铁管'
											},
											{
												text:'箱涵',
												value:'箱涵'
											},
											{
												text:'明涵',
												value:'明涵'
											},
											{
												text:'圆管涵',
												value:'圆管涵'
											},
											{
												text:'钢波纹管',
												value:'钢波纹管'
											},
											{
												text:'整体现浇',
												value:'整体现浇'
											},
											{
												text:'钢波纹管涵',
												value:'钢波纹管涵'
											},
											{
												text:'盖板涵',
												value:'盖板涵'
											},
											{
												text:'拱涵',
												value:'拱涵'
											},
											{
												text:'双管涵',
												value:'双管涵'
											},
											{
												text:'离心球墨铸铁管涵',
												value:'离心球墨铸铁管涵'
											},
											{
												text:'混凝土盖板明涵',
												value:'混凝土盖板明涵'
											},
											{
												text:'混凝土圆管涵',
												value:'混凝土圆管涵'
											},
											{
												text:'现浇盖板涵',
												value:'现浇盖板涵'
											},
											{
												text:'钢筋混凝土板涵',
												value:'钢筋混凝土板涵'
											}
										]" name='hd.hdlx'>
				</td>
				<td>
				<span>地市：</span><input style="width:120px;" class="easyui-combobox" data-options="
										panelHeight:'auto',
										data:[
											{
												text:'塔城市',
												value:'塔城市'
											},
											{
												text:'伊犁市',
												value:'伊犁市'
											},
											{
												text:'哈密市',
												value:'哈密市'
											},
											{
												text:'克拉玛依市',
												value:'克拉玛依'
											},
											{
												text:'乌苏市',
												value:'乌苏市'
											}
										]
										" type="text" name="hd.dsmc" >
										</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<span>桩号：</span>
				 	<input id="hd_startzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" name="hd.startzh" style="width:70px">
				 	-
				 	<input id="hd_endzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" name="hd.endzh" style="width:70px">
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