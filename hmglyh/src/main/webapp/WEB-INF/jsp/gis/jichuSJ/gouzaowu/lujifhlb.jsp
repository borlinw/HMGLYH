<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/gouzaowu/GouzaowuColumns.js"></script>
<title>路基防护</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(LujifhColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(LujifhColumns);
		var params = getParam('fm');
		
		var condition = "where 1=1";
		if(params['lj.roadcode'] != null && params['lj.roadcode'] != ""){
			condition += " and roadcode='" + params['lj.roadcode']+"'";
		}
		if(params['lj.fhlx'] != null && params['lj.fhlx'] != ""){
			condition += " and fhlx like '%" + params['lj.fhlx']+"%'";
		}
		if(params['lj.startzh'] != null && params['lj.startzh'] != ""){
			condition += " and spos >= " + params['lj.startzh'];
		}
		if(params['lj.endzh'] != null && params['lj.endzh'] != ""){
			condition += " and " + params['lj.endzh'] + ">= epos";
		}
		
		condition += "order by roadcode,spos";
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=LUJIFANGHUGZW";

		YMLib.Ajax.POST("pb/getHtml.do",param,"json",function(result){
			location.href = YMLib.url + "page/gis/page/export.jsp";
		},function(){
			
		});
	});
});
</script>

</head>
<body>
	<script>
		var getButton = function(rowData) {
			return [/* {
			        	 text:'路基卡片',
			        	 attr:{
			        		 kplx:'4',
			        		 dyid:rowData.roadcode+rowData.xzqh+rowData.code,
			        	 },
			        	 eventHandler:function(obj){
			        		 var kplx = $(obj).attr('kplx');
			        		 var dyid = $(obj).attr('dyid');
			        		 gisui.createWindow({
				        			id:'qshgzw_hdkp',
				      				title:'路基卡片信息',
				      				height:600,
				      				width:900,
				      				src:'/hmglyh/page/gis/page/card.jsp?kplx='+kplx+'&dyid='+dyid
				      		});
			        	 }
			         }, */
			         {
			        	 text:"多媒体",
			        	 attr:{
			        		 name:'路基防护',
			        		 code:rowData.id,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var name = $(obj).attr('name');
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 gisui.createWindow({
				        			id:'lujifanghuDMT',
				      				title:name+'-多媒体信息',
				      				height:600,
				      				width:900,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_showPicAndUpload.do?code='+code
				      			});
			        	 }
			         }
			         ];
		};
		
		function onLoadSuccess(data){
			parent.parent.map.clearLayerByWindowId('gouzaowu');
			var rows =data.rows;
			if( rows.length  == 0 ) return;
			var points = [];
			$.each(rows,function(i,d){
				points.push({
					roadcode:d.roadcode,
					zh:d.spos,
					imgpath:"/hmglyh/page/gis/mapimg/lujifh.png",
					popup:{
						title:"详情",
						rowData:d,
						columns:LujifhColumns,
						buttons:getButton(d)
						
					}
				});
			});
			parent.parent.map.addPointByZh(points,"gouzaowu");
		}
		
		function onClickRow(rowIndex,rowData){
			var rows =[rowData];
			if( rows.length  == 0 ) return;
			var points = [];
			$.each(rows,function(i,d){
				points.push({
					roadcode:d.roadcode,
					zh:d.spos,
					imgpath:"/hmglyh/page/gis/mapimg/lujifh.png",
					popup:{
						title:"详情",
						rowData:d,
						columns:LujifhColumns,
						buttons:getButton(d)
					}
				});
			});
			parent.parent.map.addPointByZh(points,"gouzaowu");
		}
		
	</script>
	 
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/gouzaowu_lujifhRows.do",
		columns:LujifhColumns,
		pageNumber:1,
		pageSize:6,
		<s:if test="fromBm">
		queryParams:{
		 "lj.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
		 "lj.roadcode":"<s:property value="lj.roadcode" />"
		},
		</s:if>
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
	    <%--onClickRow:function(rowIndex,rowData){top.Apoint([rowData],"gouzaowu","lujifh.png",LujifhColumns,"路基防护详细信息",false,getButton)},
		onLoadSuccess:function(data){top.Apoint(data.rows,"gouzaowu","lujifh.png",LujifhColumns,"路基防护详细信息",true,getButton)} --%>
		onLoadSuccess:onLoadSuccess,
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
					width:120,
					panelHeight:120,
					<s:if test="fromLx">
				  	value:'<s:property value="lj.roadcode" />',
				  	disabled:'disabled',
				    </s:if>
					url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
					"
					name='lj.roadcode'
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="lj.bmcode" />',
						onSelect:function(record){
							$('#lj_roadcode').val(record.lxcode);
							$('#lj_startzhh').val(record.szhh);
							$('#lj_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="lj_roadcode" type="hidden" name="lj.roadcode" />
				</s:else>
			
				
				</td>
				<td>
					<span>防护类型：</span>
					<input type="text" class="easyui-combobox" data-options="
						width:120,
						panelHeight:130,
						data:[
							{
								text:'砼护坡',
								value:'砼护坡'
							},
							{
								text:'下挡墙',
								value:'下挡墙'
							},
							{
								text:'边沟',
								value:'边沟'
							}
							,
							{
								text:'下护坡',
								value:'下护坡'
							}
							,
							{
								text:'上护坡',
								value:'上护坡'
							}
							,
							{
								text:'混凝土防撞墙',
								value:'混凝土防撞墙'
							}
							,
							{
								text:'截水墙',
								value:'截水墙'
							}
							,
							{
								text:'方格网',
								value:'方格网'
							}
							,
							{
								text:'浆砌边沟',
								value:'浆砌边沟'
							}
							,
							{
								text:'水泥边沟',
								value:'水泥边沟'
							}
							,
							{
								text:'护坡',
								value:'护坡'
							}
							,
							{
								text:'浆砌挡墙',
								value:'浆砌挡墙'
							}
							,
							{
								text:'砼格网护坡',
								value:'砼格网护坡'
							}
							,
							{
								text:'水泥混泥土护坡',
								value:'水泥混泥土护坡'
							}
						]
					" name="lj.fhlx" />
				</td>
				<td><a class="easyui-linkbutton" id="export">导出</a></td>
			</tr>
			<tr>
				<td colspan="2">
					<span>桩号：</span>
					
					<input id="lj_startzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')"  class="combo myCombo" name="lj.startzh" style="width:60px;">
						-
					<input id="lj_endzhh" type="text" onkeyup="value=value.replace(/[^\d.]/g,'')"  class="combo myCombo" name="lj.endzh" style="width:60px" />
										
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