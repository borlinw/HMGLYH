<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/yanxianss/YanxianssColumns.js"></script>
<title>交通标志</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(JiaotongbzColumns);
		var data = YMLib.Columns.getDataWithoutFormatter(JiaotongbzColumns);
		var params = getParam('fm');
		
		var condition = "1=1";
		if(params['jtbz.gydw'] != null && params['jtbz.gydw'] != ""){
			condition += " and gydw like '%" + params['jtbz.gydw'] + "%'";
		}
		if(params['jtbz.roadcode'] != null && params['jtbz.roadcode'] != ""){
			condition += " and roadcode='" + params['jtbz.roadcode'] + "'";
		}
		if(params['jtbz.bzlb'] != null && params['jtbz.bzlb'] != ""){
			condition += " and bzlb='" + params['jtbz.bzlb'] + "'";
		}
		if(params['jtbz.startzh'] != null && params['jtbz.startzh'] != ""){
			condition += " and to_number(case when instr(pos,'-') > '0' then substr(pos,0,instr(pos,'-')-1) else pos  end) >= " + params['jtbz.startzh'];
		}
		if(params['jtbz.endzh'] != null && params['jtbz.endzh'] != ""){
			condition += " and " + params['jtbz.endzh'] + "> to_number(case when instr(pos,'-') > '0' then substr(pos,0,instr(pos,'-')-1) else pos  end)";
		}
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=JIAOTONGBIAOZHI";
		location.href = YMLib.url + "pb/pub_export.do?" + param;
	});
});
</script>
</head>
<body>
	<table id="dg" class='easyui-datagrid' data-options='
		url:"${pageContext.request.contextPath}/gis/yanxianss_jiaotongbzRows.do",	
		columns:JiaotongbzColumns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		<s:if test="fromBm">
		queryParams:{
			"jtbz.roadcode":"-1"
		},
		</s:if>
		<s:if test="fromLx">
		queryParams:{
			"jtbz.roadcode":"<s:property value='jtbz.roadcode'/>"
		},
		</s:if>
		fit:true,
		rownumbers:true,
		toolbar:"#tb",
		onClickRow:onClickRow,
		onLoadSuccess:onLoadSuccess
	'>
	</table>
	
	<script>
		var getButton = function(rowData) {
			return [
			        {
			        	 text:'交通标志卡片',
			        	 attr:{
			        		 kplx:'4',
			        		 dyid:rowData.id,
			        	 },
			        	 eventHandler:function(obj){
			        		 var kplx = $(obj).attr('kplx');
			        		 var dyid = $(obj).attr('dyid');
			        		 gisui.createWindow({
				        			id:'qshgzw_hdkp',
				      				title:'交通标志卡片信息',
				      				height:600,
				      				width:900,
				      				src:'/hmglyh/page/gis/page/card.jsp?kplx='+kplx+'&dyid='+dyid
				      		});
			        	 }
			         },
			         {
			        	 text:"多媒体",
			        	 attr:{
			        		 name:rowData.bzlb,
			        		 code:rowData.id,
			        		 xzqh:rowData.xzqh
			        	 },
			        	 eventHandler:function(obj){
			        		 var code = $(obj).attr('code');
			        		 var xzqh = $(obj).attr('xzqh');
			        		 var name = $(obj).attr('name');
			        		
			        		 gisui.createWindow({
				        			id:'jabzDMT',
				      				title:name+'-多媒体信息',
				      				height:600,
				      				width:900,
				      				src:'${pageContext.request.contextPath}/gis/gouzaowu_showPicAndUpload.do?code='+code+'&xzqh='+xzqh
				      			});
			        	 }
			         }
			         ];
		};
		function onLoadSuccess(data){
			top.APointByZh(data.rows,"yanxianss","jtbz.png",JiaotongbzColumns,"交通标志详细信息",true,getButton);
		}
		function onClickRow(rowIndex,rowData){
			top.APointByZh([rowData],"yanxianss","jtbz.png",JiaotongbzColumns,"交通标志详细信息",false,getButton);
		}
	</script>
	
	<div id="tb" style="padding:10px;height:auto">
		<form id="fm">
		<table class='mySearchTable'>
			<tr>
				<td>
				
				<s:if test="!fromBm">
						<span>路线：
							</span><input class="easyui-combobox" data-options="
							valueField:'valueField',
							textField:'textField',
							mode:'remote',
							panelWidth:120,
							panelHeight:'auto',
							width:120,
							<s:if test="fromLx">
								  	value:'<s:property value="jtbz.roadcode" />',
								  	disabled:'disabled',
							</s:if>
							url:'${pageContext.request.contextPath}/gis/luxian_luxianCombobox.do'
							" 
								name='jtbz.roadcode'
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
						url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="jtbz.bmcode" />',
						onSelect:function(record){
							$('#jtbz_roadcode').val(record.lxcode);
							$('#jtbz_startzhh').val(record.szhh);
							$('#jtbz_endzhh').val(record.ezhh);
						}
						"
						>
						<input id="jtbz_roadcode" type="hidden" name="jtbz.roadcode" />
					</s:else>
				</td>
				<td>
				    <span>桩号：</span><input id="jtbz_startzhh" onkeyup="value=value.replace(/[^\d.]/g,'')" style="width:85px;" class="combo myCombo" type="text" name="jtbz.startzh" />
					-
					<input id="jtbz_endzhh" style="width:85px;" onkeyup="value=value.replace(/[^\d.]/g,'')" class="combo myCombo" type="text" name="jtbz.endzh" />
				</td>
				<td>
					<a class="easyui-linkbutton" id="export">导出</a>
				</td>
			</tr>
			<tr>
				<td>
				<span>类别：</span>
				<input class="easyui-combobox" data-options="
				panelWidth:120,
				width:120,
				panelHeight:130,
				data:[
				{
					text:'提示标志',
					value:'提示标志'
				},
				{
					text:'指路标志',
					value:'指路标志'	
				},
				{
					text:'可变信息标注',
					value:'可变信息标注'
				},
				{
					text:'广角透镜',
					value:'广角透镜'
				},
				{
					text:'测速',
					value:'测速'
				},
				{
					text:'辅助标注',
					value:'辅助标注'
				},
				{
					text:'指示标志',
					value:'指示标志'
				},
				{
					text:'警示标志',
					value:'警示标志'
				},
				{
					text:'道路确认标志',
					value:'道路确认标志'
				},
				{
					text:'警告标志',
					value:'警告标志'
				},
				{
					text:'指路标志',
					value:'指路标志'
				}
				]
				" name='jtbz.bzlb'>
				</td>
				<td><span>单位：</span><input class="combo myCombo" type="text" name="jtbz.gydw" ></td>
				<td>
					<a class="easyui-linkbutton" onclick="$('#dg').datagrid('load',getParam('fm'));">查询</a>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>