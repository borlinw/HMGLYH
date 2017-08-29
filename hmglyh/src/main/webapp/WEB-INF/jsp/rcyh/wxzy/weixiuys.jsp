<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/RcyhBhjlbColumns.js"></script> --%>
<title>维修作业首页 </title>
<script>
var WxzyColumns = [[
   {field:'yhname',title:'作业项目',width:120},
   {field:'bmname',title:'单位',width:120},
   {field:'sl',title:'数量',width:100},
   {field:'jhgr',title:'工日',width:100},
   {field:'szhh',title:'起点桩号',width:120,align:'center'},
   {field:'ezhh',title:'止点桩号',width:120,align:'center',formatter:function(value){
	   if( value < 0 ) {
		   return "--";
	   }else{
		   return value;
	   }
   }}
]];

function loadData(ldcode) {
	$("#dg").datagrid({
		url:'/hmglyh/rcyh/wxzy_listWxzyHz.do',
		queryParams:getParam("fm")
	});
}

//url:'',
</script>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:WxzyColumns,
		pageNumber:1,
		pageSize:10,
		queryParams:{
			'wxzy.fromYs':true
		},
		pageList:[10,20,30],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:'#toolbar',
		fitColumns:true,
		singleSelect:true
	">
	</table>
	
	<div id="toolbar" style="padding:10px;">
		<form id="fm">
		<a href="javascript:void(0);" onclick="zyys()"  class="easyui-linkbutton" data-options="iconCls:'check',plain:true">验收</a>
		养护站 ：<input id="yhzCombobox" name="wxzy.bmcode" type="text" class="easyui-combobox" data-options="
			url:'${pageContext.request.contextPath}/rcyh/wxzy_getYhzs.do?bmcode=<s:property value="user.bmcode" />',
			textField:'bmname',
			valueField:'bmcode',
			onSelect:function(data) {
				if(data.sftsbm == 1 ) {
					$('#yhzluduan').combobox('reload','/hmglyh/lxld/getTsbmLxldCombo.do?bmCode='+data.bmcode); 
				}else{
					$('#yhzluduan').combobox('reload','/hmglyh/lxld/getLxldCombo2.do?bmCode='+data.bmcode); 
				}
				$('#yhzluduan').combobox('setValue','');
			},
			onLoadSuccess:function(data){
				if( data.length > 0 ) {
					if(data.sftsbm == 1 ) {
						$('#yhzluduan').combobox('reload','/hmglyh/lxld/getTsbmLxldCombo.do?bmCode=data.bmcode'); 
					}else{
						$('#yhzluduan').combobox('reload','/hmglyh/lxld/getLxldCombo2.do?bmCode='+data[0].bmcode); 
					}
				}
			}
		">
		&nbsp;&nbsp;
		所管辖路段 ：
		<input id="yhzluduan" name="wxzy.ldcode" class="easyui-combobox" data-options="
			textField:'text',
			valueField:'id',
			onSelect:function(record){
				loadData(record.id);
				$('#ssny').combobox('reload','/hmglyh/nyb/getZyysNy.do?bmcode='+$('#yhzCombobox').combobox('getValue')+'&ldcode='+record.id); 
			},
			onLoadSuccess:function(data){
				if( data.length > 0 ) {
					$('#yhzluduan').combobox('setValue',data[0].id);
					$('#ssny').combobox('reload','/hmglyh/nyb/getZyysNy.do?bmcode='+$('#yhzCombobox').combobox('getValue')+'&ldcode='+data[0].id); 
				}else{
					$('#yhzluduan').combobox('setValue','');
				//	$('#ssny').combobox('setValue','');
				}
			}
		"> 
		&nbsp;
		月份选择:<input id="ssny" name="wxzy.ssny" class="easyui-combobox" data-options="
					valueField : 'yname',
					textField : 'yname',
					editable:false,
					onLoadSuccess:function(data){
						if( data.length > 0 ) {
							$('#ssny').combobox('setValue',data[0].yname);
						}else{
							$('#ssny').combobox('setValue','');
						}
					}
				" />
		<a id="searchButton" onclick='loadData()' class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'">查询</a>
		</form>
	</div>
	<script>
		// gisui
		var gisui = new GisUI({
			isShowToolBar:false
		});
	
		function openSearch(obj) {
			if( $(obj).text() == "查询" ) {
				$(obj).linkbutton({
					text:"返回",
					iconCls:"back"
				});
				$(".myformsearch").show();
			}else{
				$(obj).linkbutton({
					text:"查询",
					iconCls:"icon-search"
				});
				$(".myformsearch").hide();
			}
		}
		
		//添加 作业上报
		function zyys(){
			var row = $("#dg").datagrid("getSelected");
			//  养护路段编码
			var ldcode = $("#yhzluduan").combobox("getValue");
			if( row == null ) {
				 $.messager.alert('警告','您未选择任何数据!','warning');
				 return;
			}
			var zyidstr = "zyys.ldcode="+ldcode;
				zyidstr += "&zyys.yhid="+row.yhid;
				zyidstr += "&zyys.sbsl="+row.sl;
				zyidstr += "&zyys.sbgr="+row.jhgr;
				zyidstr += "&zyys.bmcode="+row.bmcode;
				
				if(row.zyid && row.zyid != null && row.zyid != '') {
					zyidstr += "&wxzy.zyid="+row.zyid;
				}
				
				if(row.szhh >= 0) {
					zyidstr += "&zyys.ldzh="+row.szhh;
				}
				if(row.ezhh >= 0 ) {
					zyidstr += '-'+row.ezhh;
				}
				
			
				var ssny = $("#ssny").combobox("getValue");
				
				zyidstr += "&zyys.ssny="+encodeURI(ssny);
				
				var width,height,left = 0;
			
				if(row.zyid && row.zyid != null && row.zyid != '' ){
					width = 400;
					height = 220;
					left = ($("body").width() - 300 ) / 2 ;
				}else{
					width = 950;
					height = 350;
					left = 50;
				}
			
				
			parent.gisui.createWindow({
				title:"作业验收",
				iconCls:"icon-page",
				modal:true,
				left:left,
				top:100,
				width:width,
				height:height,
				src:"${pageContext.request.contextPath}/rcyh/wxzy_ys.do?"+zyidstr,
				onDestroy:function(){
					loadData($("#yhzluduan").combobox("getValue"));
				},
				onBeforeLoad:function(){
					loadData($("#yhzluduan").combobox("getValue"));
				}
			});
		}
	</script>
</body>
</html>