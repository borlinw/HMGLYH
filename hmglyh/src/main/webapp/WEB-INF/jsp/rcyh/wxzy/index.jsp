<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>

<title>任务单列表</title>
<script>
var RwdColumns = [[
                    {field:"ck",checkbox:true},
                    {field:'aaa',title:'操作',align:'center',width:140,formatter:function(value,rowData,rowIndex){
                    	return "<a href='javascript:void(0)' onclick='addWxzy(\""+rowData.rwdid+"\")'>维修作业</a>"+
                    		   "|<a href='javascript:void(0)' onclick='rwdXq(\""+rowData.rwdid+"\")'>详情</a>"+
                    		   "|<a target='_blank' href='/hmglyh/rcyh/bhflow_showProcess.do?bhjl.bhjlid="+rowData.rwdid+"&definitionKey=wxProcess'>流程图</a>";
                    }},
                    {field:'rwdzt',title:'任务单状态',width:100},
                    {field:'rwdlx',title:'任务单类型',width:100},
                    {field:'ssny',title:'所属年月',width:150},
                    {field:'cjtime',title:'创建时间',width:140},
                    {field:'cjusername',title:'创建用户名',width:100},
                    {field:'bmcode',title:'部门',width:100},
                    {field:'ldname',title:'路段',width:100},
                    {field:'tq',title:'方向',width:100},
                    {field:"bbb",title:"桩号",formatter:function(value,rowData){
                    	var zhStr = "";
                    	if( rowData.szhhkm >=0  && rowData.szhhm >= 0 ) {
                    		zhStr += "K" + rowData.szhhkm + " + " +rowData.szhhm;
                    	}
                    	
                    	if( rowData.ezhhkm >= 0 && rowData.ezhhkm >= 0 ) {
                    		zhStr += " - K" + rowData.ezhhkm + " + " + rowData.ezhhm;
                    	}
                    
                      	return zhStr;
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
                    {field:'rgf',title:'人工费',width:100,formatter:function(value){
                    	return value+"(元)";
                    }},
                    {field:'clf',title:'材料费',width:100,formatter:function(value){
                    	return value+"(元)";
                    }},
                    {field:'jxf',title:'机械费',width:100,formatter:function(value){
                    	return value+"(元)";
                    }},
                    {field:'xfsx',title:'修复时限',width:100,formatter:function(value){
                    	return value+"(天)";
                    }}
                ]];
                
</script>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:RwdColumns,
		url:'${pageContext.request.contextPath}/rcyh/wxzy_listRwd.do',
		pageNumber:1,
		pageSize:10,
		queryParams:{
			'rwd.rwdzt':'0',
			'rwd.bmcode':'<s:property value="user.bmcode" />'
		},
		pageList:[10,20,30],
		pagination:true,
		fit:true,
		rownumbers:true,
		toolbar:'#toolbar'
	">
	</table>
	
	<div id="toolbar" style="padding:10px;">
		<a data-options="plain:true,iconCls:'check'" class="easyui-linkbutton" onclick="addWxzy('')">维修作业</a>
		<a data-options="plain:true,iconCls:'check'" class="easyui-linkbutton" onclick="showMap()">定位</a>		
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
		
		function rwdXq(rwdid){
			parent.gisui.createWindow({
				title:"任务单详情",
				iconCls:"icon-page",
				modal:true,
				top:20,
				width:950,
				height:450,
				src:"${pageContext.request.contextPath}/rcyh/bhflow_showRwd.do?rwd.rwdid="+rwdid
			});
		}
		
		//添加 维修作业 
		function addWxzy(rwdid){
			parent.gisui.createWindow({
				title:"添加维修作业",
				id:"addWxzy",
				iconCls:"icon-page",
				modal:true,
				top:20,
				width:950,
				height:450,
				src:"${pageContext.request.contextPath}/rcyh/wxzy_addWxzy.do?rwd.rwdid="+rwdid,
				onDestroy:function(){
					$("#dg").datagrid("reload");
				}
			});
		}
		
		//  将 病害 在 地图显示
		function showMap(){
			var rows = $("#dg").datagrid("getSelections");
			if(rows.length == 0 ) {
				$.messager.alert("警告","您没有选择任何数据","warning");
				return;
			}
			parent.gisui.createWindow({
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