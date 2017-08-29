<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/page.js"></script>
<title>维修作业首页 </title>
<script>
var WxzyColumns = [[
                    {field:"ck",checkbox:true},
                    {field:'aaa',title:'操作',formatter:function(value,rowData,rowIndex) {
                    	return "<a href='javascript:void(0);' onclick=wxzyXq(\""+rowData.zyid+"\")>查看</a>" 
                    }},
                    {field:'wgtime',title:'完工时间',width:100},
                    {field:'zysbzt',title:'作业上报状态',width:100},
	                {field:'sbtime',title:'上报时间',width:100},
	 				{field:'yszt',title:'验收状态',width:100},
				    {field:'jlusername',title:'记录人',width:100},
				    {field:'bmcode',title:'部门编码',width:100},
				    {field:'hdname',title:'涵洞名称',width:100},
				    {field:'yhname',title:'养护类型',width:100},
				    {field:'sl',title:'数量',width:100,formatter:function(value,rowData){
				    	return value + rowData.dw;
				    }},
				    {field:'ldname',title:'路段',width:200},
				    {field:'tq',title:'方向',width:100},
				    {field:"bbb",title:"桩号",formatter:function(value,rowData){
                     	return "K"+rowData.szhhkm + "+" + rowData.szhhm ;
                    }},
				    {field:'wzbc',title:'位置补充',width:100},
				    {field:'qlcode',title:'桥梁编码',width:100},
				    {field:'qlname',title:'桥梁名称',width:100},
				    {field:'sdcode',title:'隧道编码',width:100},
				    {field:'sdname',title:'隧道名称',width:100},
				    {field:'hdcode',title:'涵洞编码',width:100},
				    {field:'bz',title:'备注',width:100},
				    {field:'grde',title:'工日定额',width:100},
				    {field:'jhgr',title:'计划工日',width:100},
				    {field:'rgf',title:'人工费',width:100},
				    {field:'clf',title:'材料费',width:100},
				    {field:'jxf',title:'机械费',width:100},
				    {field:'sbusername',title:'上报用户名',width:100}
]];
</script>
</head>
<body>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:WxzyColumns,
		<%-- url:'${pageContext.request.contextPath}/rcyh/wxzy_listWxzycx.do', --%>
		pageNumber:1,
		pageSize:10,
		pageList:[10,20,30],
		pagination:true,
		fit:true,
		rownumbers:true,
		toolbar:'#toolbar',
		singleSelect:false
	">
	</table>
	
	<div id="toolbar" style="padding:0px;">
		<div data-options="region:'north',border:true,split:false" style="height:30px;border-left:0px;border-right:0px;border-top:0px">
			<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="cxtjHome" style="cursor:pointer;" >查询统计</font>&nbsp;&gt;&nbsp;维修作业信息查询</div>
		</div>
		<div style="padding:10px;">
			<span class="myformsearch">
				<form id="fm" class="search-form">
				  部门：<input name="wxzy.bmcode" class="easyui-combotree" data-options="
				  		url:'${pageContext.request.contextPath}/gis/guanyangdw_bmtree.do',
				  		width:80,
				  		value:'<s:property value="user.bmcode" />',
				  		panelWidth:140
				  ">&nbsp;
				 养护类型：<input name="wxzy.yhid" class="easyui-combotree" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/wxzy_getYhlxTree.do', 
	            	idField:'yhid', 
	                textField:'yhname',
	                clickNodeForSpan:true
				 ">
				  时间：<input name="wxzy.starttime" class="easyui-datebox" />-<input  name="wxzy.endtime" class="easyui-datebox">&nbsp;
				 作业上报状态：<input name="wxzy.zysbzt" class="easyui-combobox" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/wxzy_zysbztCombobox.do',
				 	width:60,
				 	panelHeight:'auto'
				 ">&nbsp;
				 作业验收状态: <input name="wxzy.yszt" class="easyui-combobox" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/wxzy_wxysztCombobox.do',
				 	width:60,
				 	panelHeight:'auto'
				 ">&nbsp;
				  <a class="easyui-linkbutton" onclick='loadData()' data-options="plain:true,iconCls:'query'">筛选</a>
				  <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'check',plain:true" onclick="showMap()">定位</a>
				</form>
			</span>
		</div>
	</div>
	<script>
	
		function loadData(){
			$("#dg").datagrid({
				url:'${pageContext.request.contextPath}/rcyh/wxzy_listWxzycx.do',
				queryParams:getParam("fm")
			});
		}
	
		// gisui
		var gisui = new GisUI({
			isShowToolBar:false
		});
	
		
		function wxzyXq(zyid){
			gisui.createWindow({
				title:"维修详细信息",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:400,
				tabs:{
					selected:1,
					tabs:[
					      {
					    	  title:"相关病害",
					    	  src:"${pageContext.request.contextPath}/rcyh/bh_index.do?fromWx=true&wxzy.zyid="+zyid
					      },
					      {
					    	  title:"维修详情",
					    	  src:"${pageContext.request.contextPath}/rcyh/wxzy_wxzyXq.do?wxzy.zyid="+zyid
					      },
					      {
					    	  title:"图片信息",
					    	  src:"${pageContext.request.contextPath}/rcyh/wxzy_wxzyzps.do?wxzy.zyid="+zyid
					      }
					      ]
				}
			});
		}
		
	//  将 病害 在 地图显示
		function showMap(){
			gisui.createWindow({
				title:"维修定位",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:400,
				left:50,
				top:50,
				src:"${pageContext.request.contextPath}/gis/index_rcyhMap.do"
			});
		}
		
	</script>
</body>
</html>