<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/RcyhGlxcsjbColumns.js"></script>
</head>
<body>
<%-- 	<s:debug></s:debug> --%>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:GlcxsjbColumns,
		url:'${pageContext.request.contextPath}/rcyh/xdjl_xundaojlRows.do',
		pageNumber:1,
		pageSize:10,
		queryParams:{
			'xcsj.bmcode':'<s:property value="user.bmcode" />'
		},
		pageList:[10,20,30],
		pagination:true,
		singleSelect:true,
		fit:true,
		toolbar:'#toolbar'
	">
	</table>
	
	<div id="toolbar" style="padding:10px;">
		<a class="easyui-linkbutton" onclick="xqXdjl()" data-options="plain:true">详情</a>
		<a class="easyui-linkbutton" onclick="editXdjl()" data-options="plain:true">修改</a>
		<a class="easyui-linkbutton" onclick="addXdjl()" href="javascript:void(0)"  data-options="plain:true">添加</a>
		<a class="easyui-linkbutton" onclick="delXdjl()" data-options="plain:true">删除</a>
		<a class="easyui-linkbutton" onclick="exportXdjl()" data-options="plain:true">导出</a>
		<a id="searchButton" onclick="openSearch(this)" class="easyui-linkbutton" data-options="plain:true">查询</a>
		<span class="myformsearch" style="display:none;">
			<form id="fm" class="search-form">
			  日期： <input name="xcsj.stime" class="easyui-datebox" /> - <input name="xcsj.etime" class="easyui-datebox" />
			 &nbsp;
			 路段： <input name="xcsj.xsld" class="combo" style="width:150px" > <input type="hidden" name="xcsj.bmcode" value='<s:property value="user.bmcode" />'/>		
			  		<a onclick="$('#dg').datagrid('load',getParam('fm'))" class="easyui-linkbutton" data-options="plain:true">查询</a>
			</form>
		</span>
		<!-- <a>批量删除</a>
		<a>修改</a> -->
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
		
		// 添加一条巡道记录
		function addXdjl(){
			gisui.createWindow({
				title:"添加巡道记录",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:400,
				src:"${pageContext.request.contextPath}/rcyh/xdjl_addXundaojl.do",
				onDestroy:function(){
					$("#dg").datagrid("reload");
				}
			});
		}
		
		// 寻道记录详情
		function xqXdjl(){
			var row = $("#dg").datagrid("getSelected");
			if( row == null ) {
				$.messager.alert("警告","您未选择任何数据","warning");
				return;
			}
			parent.gisui.createWindow({
				title:"巡道记录详细信息",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:450,
				tabs:{
					tabs:[
					      {
					    	  title:"巡道记录",
					    	  id:"tab_xdjl",
					    	  src:"${pageContext.request.contextPath}/rcyh/xdjl_showXdjl.do?xcsj.xcid="+row.xcid
					    	
					      },
					      {
					    	  title:"关联病害信息",
					    	  id:"tab_bhxx",
					    	  disabled:true,
					    	  src:"${pageContext.request.contextPath}/rcyh/bh_index.do?bhjl.xcid="+row.xcid+"&fromXd=true&isShow=true"
					      }
					      ]
				}
			});
		}
		
		// 添加病害
		function addBh(xcid){
			parent.gisui.createWindow({
				title:"添加病害",
				iconCls:"add",
				modal:true,
				width:950,
				height:450,
				left:50,
				top:50,
				src:"${pageContext.request.contextPath}/rcyh/bh_addBh.do?bhjl.xcid="+xcid
			});
		}
		
		// 病害列表
		function listBh(xcid) {
			parent.gisui.createWindow({
				title:"病害列表",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:450,
				src:"${pageContext.request.contextPath}/rcyh/bh_index.do?bhjl.xcid="+xcid+"&fromXd=true"
			});
		}
		
		// 添加一条巡道记录
		/* function addXdjl(){
			parent.gisui.createWindow({
				title:"添加巡道记录",
				iconCls:"icon-page",
				modal:true,
				width:1100,
				height:400,
				src:"${pageContext.request.contextPath}/rcyh/xdjl_addXundaojl.do"
			});
		} */
		
		// 修改巡道记录
		function editXdjl(){
			var row = $("#dg").datagrid("getSelected");
			if( row == null ) {
				$.messager.alert("警告","您未选择任何数据","warning");
				return;
			}
		//	location.href="${pageContext.request.contextPath}/rcyh/xdjl_updateXdjl.do?xcsj.xcid="+row.xcid;
		    gisui.createWindow({
				title:"修改巡道记录",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:400,
				src:"${pageContext.request.contextPath}/rcyh/xdjl_updateXdjl.do?xcsj.xcid="+row.xcid,
				onDestroy:function(){
					$("#dg").datagrid("reload");
				}
			});	
		}
		
	
		// 使用ajax 删除 一条 巡道记录
		function delXdjl(){
			var row = $("#dg").datagrid("getSelected");
			if( row == null ) {
				$.messager.alert("警告","您未选择任何数据","warning");
				return;
			}
			$.messager.confirm("确认","确认删除?",function(r){
			    if (r){
			    	$.messager.progress({
						title:"请稍后...",
						text:'请稍后',
						msg:'正在删除该寻道记录'
					}); 
			    	$.ajax({
						url:"${pageContext.request.contextPath}/rcyh/xdjl_delXdjl.do",
						data:{
							'xcsj.xcid':row.xcid
						},
						dataType:"json",
						success:function(r){
							$.messager.progress("close");
							if(r.isSuccess) {
								$.messager.alert("提示","删除成功!","warning");
								$("#dg").datagrid("reload");
							}else{
								$.messager.alert("提示",r.info,"warning");
							}
						},
						error:function(e){
							$.messager.progress("close");
							console.error(e);
						}
					});	
			    }
			});
		}
		
		function exportXdjl(){
			var row = $("#dg").datagrid("getSelected");
			if( row == null ) {
				$.messager.alert("警告","您未选择任何数据","warning");
				return;
			}
			location.href = '${pageContext.request.contextPath}/rcyh/xdjl_exportXcjlDetail.do?xcsj.xcid='+row.xcid;
			
		}
		
		
		
	</script>
	
</body>
</html>