<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<title>维修作业首页 </title>
<script>
var WxzyColumns = [[
                    {field:"ck",checkbox:true},
                    {field:'aaa',title:'操作',formatter:function(value,rowData,rowIndex) {
                    	return "<a href='javascript:void(0);' onclick=wxzyXq(\""+rowData.zyid+"\")>查看</a>|" + 
                    			"<a href='javascript:void(0);' onclick=editWxzy(\""+rowData.zyid+"\")>编辑</a>|" + 
                    			"<a href='javascript:void(0);' onclick=delWxzy(\""+rowData.zyid+"\")>删除</a>";
                    }},
				   {field:'wgtime',title:'完工时间',width:100},
				   {field:'jlusername',title:'记录人',width:100},
				   {field:'bmcode',title:'部门',width:100},
				   {field:'ldname',title:'路段',width:200},
				   {field:'zysbzt',title:'作业上报状态',width:100},
				   {field:'yszt',title:'验收状态',width:100},
				   {field:'yhname',title:'养护类型',width:100},
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
                     },width:120},
                   {field:'grde',title:'工日定额',width:100},
  				   {field:'jhgr',title:'计划工日',width:100},
  				   {field:'rgf',title:'人工费',width:100},
  				   {field:'clf',title:'材料费',width:100},
  				   {field:'jxf',title:'机械费',width:100},
				   {field:'wzbc',title:'位置补充',width:100},
				   {field:'qlcode',title:'桥梁编码',width:100},
				   {field:'qlname',title:'桥梁名称',width:100},
				   {field:'sdcode',title:'隧道编码',width:100},
				   {field:'sdname',title:'隧道名称',width:100},
				   {field:'hdcode',title:'涵洞编码',width:100},
				   {field:'hdname',title:'涵洞名称',width:100},
				   {field:'sl',title:'数量',width:100,formatter:function(value,rowData){
					   return value + rowData.dw;
				   }},
				   {field:'bz',title:'备注',width:100}
]];
</script>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:WxzyColumns,
		url:'${pageContext.request.contextPath}/rcyh/wxzy_listWxzy.do',
		pageNumber:1,
		pageSize:10,
		queryParams:{
			'wxzy.bmcode':'<s:property value="user.bmcode" />',
			'wxzy.zysbzt':'0',
			'wxzy.yszt':'0'
		},
		pageList:[10,20,30],
		pagination:true,
		singleSelect:true,
		fit:true,
		rownumbers:true,
		toolbar:'#toolbar',
		singleSelect:false
	">
	</table>
	
	
	<div id="toolbar" style="padding:10px;">
		<a href="javascript:void(0);" onclick="zysb()"  class="easyui-linkbutton" data-options="iconCls:'check',plain:true">作业上报</a>
		<a href="javascript:void(0);" onclick="showMap()"  class="easyui-linkbutton" data-options="iconCls:'check',plain:true">定位</a>
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
		
		function wxzyXq(zyid){
			parent.gisui.createWindow({
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
		
		//添加 作业上报
		function zysb(){
			
			var left = ($("body").width() - 500) / 2;
			var top = ( $("body").height() - 270 ) / 2;
			
			var rows = $("#dg").datagrid("getSelections");
			var zyids = [];
			var zyidstr = "";
			$.each(rows,function(i,d){
				if( d.zysbzt == "未上报") {
					zyids.push(d.zyid);
					zyidstr += "&wxzys["+i+"].zyid="+d.zyid;
				}
			});
			if( zyids.length == 0 ) {
				 $.messager.alert('警告','您未选择任何数据!','warning');
				 return;
			}
			
			parent.gisui.createWindow({
				title:"作业上报",
				iconCls:"icon-page",
				modal:true,
				width:500,
				height:230,
				left:left,
				top:top,
				src:"${pageContext.request.contextPath}/rcyh/wxzy_zysb.do?"+zyidstr,
				onDestroy:function(){
					$("#dg").datagrid("reload");
				}
			});
		}
		
		// 编辑维修作业
		function editWxzy(zyid){
			var left = 20;
			var top = 50;
			parent.gisui.createWindow({
				title:"作业编辑",
				iconCls:"icon-page",
				id:"addWxzy",
				modal:true,
				width:950,
				height:450,
				left:left,
				top:top,
				src:"${pageContext.request.contextPath}/rcyh/wxzy_updateWxzy.do?wxzy.zyid="+zyid,
				onDestroy:function(){
					$("#dg").datagrid("reload");
				}
			});
		}
		
		// 删除维修作业
		function delWxzy(zyid){
			$.messager.confirm('确认','会删除该维修作业关联的人员作业记录，机械材料消耗，照片信息 \n确认删除?',function(r){
					$.messager.progress({
						title:"请稍后...",
						text:"请稍后...",
						msg:'正在删除该条维修作业'
					}); 
				    if (r){
				    	$.ajax({
							url:'${pageContext.request.contextPath}/rcyh/wxzy_delWxzy.do',
							data:{
								"wxzy.zyid":zyid
							},
							dataType:"json",
							success:function(re){
								$.messager.progress('close');
								if(re.isSuccess) {
									$.messager.alert("提示",re.info,"ok",function(r){
										$("#dg").datagrid("reload");
									});
								}else{
									$.messager.alert("警告","病害删除失败，原因："+re.info,"warning");
								}
							},
							error:function(){
								$.messager.progress('close');
							}
						});
				    }else{
				    	$.messager.progress('close');
				    }
			});
		}
		
	//  将 病害 在 地图显示
		function showMap(){
			parent.gisui.createWindow({
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