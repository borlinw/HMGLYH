<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/page.js"></script>
<title>任务单列表</title>
<script>
var RwdColumns = [[
                    {field:"ck",checkbox:true},
                    {field:'aaa',align:'center',title:'操作',width:140,formatter:function(value,rowData,rowIndex){
                    	return "<a href='javascript:void(0)' onclick='rwdXq(\""+rowData.rwdid+"\")'>详情</a>"+
                    		   "|<a target='_blank' href='/hmglyh/rcyh/bhflow_showProcess.do?bhjl.bhjlid="+rowData.rwdid+"&definitionKey=wxProcess'>流程图</a>";
                    }},
                    {field:'rwdzt',title:'任务单状态',width:100},
                    {field:'rwdlx',title:'任务单类型',width:100},
                    {field:'rwdckzt',title:'任务单查看状态',width:100},
                    {field:'ssny',title:'所属年月',width:150},
                    {field:'cjtime',title:'创建时间',width:140},
                    {field:'cjusername',title:'创建用户名',width:100},
                    {field:'bmcode',title:'部门编码',width:100},
                    {field:'ldname',title:'路段',width:100},
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
                    {field:'hdname',title:'涵洞名称',width:100},
                    {field:'bhid',title:'病害名称',width:100},
                    {field:'yhid',title:'养护类型',width:100},
                    {field:'sl',title:'数量',width:100,formatter:function(value,rowData){
                    	return value + rowData.dw;
                    }},
                    {field:'bz',title:'备注',width:100},
                    {field:'grde',title:'工日定额',width:100},
                    {field:'jhgr',title:'计划工日',width:100},
                    {field:'rgf',title:'人工费',width:100},
                    {field:'clf',title:'材料费',width:100},
                    {field:'jxf',title:'机械费',width:100},
                    {field:'xfsx',title:'修复时限',width:100}
                ]];
                
</script>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:RwdColumns,
	<%-- 	url:'${pageContext.request.contextPath}/rcyh/wxzy_listRwdcx.do', --%>
		pageNumber:1,
		pageSize:10,
		pageList:[10,20,30],
		pagination:true,
		fit:true,
		rownumbers:true,
		toolbar:'#toolbar'
	">
	</table>
	
	<div id="toolbar" style="padding:0px;">
		<div data-options="region:'north',border:true,split:false" style="height:30px;border-left:0px;border-right:0px;border-top:0px">
			<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="cxtjHome" style="cursor:pointer;" >查询统计</font>&nbsp;&gt;&nbsp;任务单信息查询</div>
		</div>
		<div style="padding:10px;">
			<span class="myformsearch">
				<form id="fm" class="search-form">
				  部门：<input name="rwd.bmcode" class="easyui-combotree" data-options="
				  		url:'${pageContext.request.contextPath}/gis/guanyangdw_bmtree.do',
				  		width:80,
				  		panelWidth:140,
				  		value:'<s:property value="user.bmcode" />'
				  ">&nbsp;
				 养护类型：<input name="rwd.yhid" class="easyui-combotree" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/wxzy_getYhlxTree.do', 
	            	idField:'yhid', 
	                textField:'yhname',
				 ">
				  时间：<input name="rwd.starttime" class="easyui-datebox" />-<input  name="rwd.endtime" class="easyui-datebox">&nbsp;
				 任务单状态：<input name="rwd.rwdzt" class="easyui-combobox" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/wxzy_rwdztCombobox.do',
				 	width:60,
				 	panelHeight:'auto'
				 ">&nbsp;
				 任务单类型: <input name="rwd.rwdlx" class="easyui-combobox" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/wxzy_rwdlxCombobox.do',
				 	width:60,
				 	panelHeight:'auto',
				 	textField:'value',
				 	valueField:'key'
				 ">&nbsp;
				 任务单查看状态：<input name="rwd.rwdckzt" class="easyui-combobox" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/wxzy_rwdckztCombobox.do',
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
				url:'${pageContext.request.contextPath}/rcyh/wxzy_listRwdcx.do',
				queryParams:getParam("fm")
			});
		}
	
		// gisui
		var gisui = new GisUI({
			isShowToolBar:false
		});
		
		function rwdXq(rwdid){
			gisui.createWindow({
				title:"任务单详情",
				iconCls:"icon-page",
				modal:true,
				top:20,
				width:950,
				height:450,
				src:"${pageContext.request.contextPath}/rcyh/bhflow_showRwd.do?rwd.rwdid="+rwdid
			});
		}
	
		
		//  将 病害 在 地图显示
		function showMap(){
			var rows = $("#dg").datagrid("getSelections");
			if(rows.length == 0 ) {
				$.messager.alert("警告","您没有选择任何数据","warning");
				return;
			}
			gisui.createWindow({
				title:"病害定位",
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