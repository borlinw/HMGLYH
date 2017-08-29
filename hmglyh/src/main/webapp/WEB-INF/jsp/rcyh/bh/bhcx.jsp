<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/page.js"></script>
<title>病害记录</title>
</head>
<body>
<script type="text/javascript">
	var BhjlbColumns = [[
						 {field:"ck",checkbox:true},
	                     {field:'aaa',title:'操作',width:80,'align':'center',formatter:function(value,rowData,rowIndex){
	                     	var returnString = "<a href='javascript:void(0)' onclick=bhxq(\'"+rowData.xcid+"\',\'"+rowData.bhjlid+"\',\'"+rowData.bmcode+"\',\'"+rowData.jlusername+"\') >详情</a>";
	                     	return returnString;
	                     }},
	                     {field:'bhsbzt',title:'病害上报状态',width:100},
	                     {field:'pgzt',title:'派工状态',width:100}, 
	                     {field:'bhwxzt',title:'病害维修状态',width:100},
	                     {field:'bhlxname',title:'病害类型',width:100},
	                     {field:'jltime',title:'记录时间',width:140},
	                     {field:'jlusername',title:'记录人用户名',width:100},
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
	                     {field:'sl',title:'数量',width:100,formatter:function(value,rowData,rowIndex){
	                    	// console.log(rowData);
	                    	/* if( rowData.dw != null && rowData.dw != "" ) {
	                    		return value + rowData.dw;
	                    	}else{
	                    		return value;
	                    	} */
	                    	return parseFloat(value).toFixed(3)+rowData.dw;
	                     }},
	                     {field:'bz',title:'备注',width:100},
	                     {field:'sbusername',title:'上报用户名',width:100},
	                     {field:'sbtime',title:'上报时间',width:100},
	                     {field:'sbbmcode',title:'上报部门编码',width:100},
	                     {field:'pgusename',title:'派工用户名',width:100},
	                     {field:'pgtime',title:'派工时间',width:100},
	                     {field:'ycpgtime',title:'延期派工时间',width:100}
	                 ]];
	</script>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:BhjlbColumns,
	<%-- 	url:'${pageContext.request.contextPath}/rcyh/bh_bhcxList.do', --%>
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
			<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="cxtjHome" style="cursor:pointer;" >查询统计</font>&nbsp;&gt;&nbsp;巡道病害信息查询</div>
		</div>
		<div style="padding:10px;">
			<span class="myformsearch">
				<form id="fm" class="search-form">
				  部门：<input name="bhjl.bmcode" class="easyui-combotree" data-options="
				  		url:'${pageContext.request.contextPath}/gis/guanyangdw_bmtree.do',
				  		width:80,
				  		value:'<s:property value="user.bmcode" />',
				  		panelWidth:140
				  ">&nbsp;
				  类型：<input name="bhjl.bhid" class="easyui-combotree" data-options="
				  		url:'${pageContext.request.contextPath}/rcyh/bh_bhlxCombotree.do',
				  		width:80,
				  		clickNodeForSpan:true,
				  		panelWidth:140
				  ">&nbsp;
				  时间：<input name="bhjl.starttime" class="easyui-datebox" />-<input  name="bhjl.endtime" class="easyui-datebox">&nbsp;
				 上报状态：<input name="bhjl.bhsbzt" class="easyui-combobox" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/bh_sbztCombobox.do',
				 	width:60,
				 	panelHeight:'auto'
				 ">&nbsp;
				 派工状态: <input name="bhjl.pgzt" class="easyui-combobox" data-options="
				 	url:'${pageContext.request.contextPath}/rcyh/bh_pgztCombobox.do',
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
	
		function loadData() {
			$("#dg").datagrid({
				url:'${pageContext.request.contextPath}/rcyh/bh_bhcxList.do',
				queryParams:getParam("fm")	
			});
		}
		// gisui
		var gisui = new GisUI({
			isShowToolBar:false
		});
	
		// 打开病害详情页 
		function bhxq(xcid,bhjlid){
		  gisui.createWindow({
				title:"病害详细信息",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:400,
				tabs:{
					selected:1,
					tabs:[
					      {
					    	  title:"巡道记录",
					    	  id:"tab_xdjl",
					    	  src:"${pageContext.request.contextPath}/rcyh/xdjl_showXdjl.do?xcsj.xcid="+xcid
					      },
					      {
					    	  title:"病害信息",
					    	  id:"tab_bhxx",
					    	  src:"${pageContext.request.contextPath}/rcyh/bh_showBh.do?bhjl.bhjlid="+bhjlid
					      },
					      {
					    	  title:"图片信息",
					    	  id:"tab_bhxx",
					    	  src:"${pageContext.request.contextPath}/rcyh/bh_bhzps.do?bhjl.bhjlid="+bhjlid
					      }
					      ]
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