<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<%-- <s:if test="fromXd">
	<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/RcyhBhjlbColumnsXd.js"></script>
</s:if>
<s:if test="fromSb">
	<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/RcyhBhjlbColumnsSb.js"></script>
</s:if>
<s:if test="fromPg">
	<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/RcyhBhjlbColumnsPg.js"></script>
</s:if>
<s:if test="fromWx">
	<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/RcyhBhjlbColumnsWx.js"></script>
</s:if> --%>
<title>病害记录</title>
</head>
<body>
	<script>
		 var BhjlbColumns = [[
		                      <s:if test="fromSb or fromPg">
		                  	    {field:"ck",checkbox:true},
		                      </s:if>
		                      {field:'aaa',title:'操作',align:'center',width:200,formatter:function(value,rowData,rowIndex){
		                    	    var xqStr = "<a href='javascript:void(0)' onclick=bhxq(\'"+rowData.xcid+"\',\'"+rowData.bhjlid+"\',\'"+rowData.bmcode+"\',\'"+rowData.jlusername+"\') >详情</a>";
			                        var xgStr = "<a href='/hmglyh/rcyh/bh_updateBh.do?bhjl.bhjlid="+rowData.bhjlid+"&fromSb=true' )>修改</a>";
			                        var scStr = "<a href='javascript:void(0)' onclick=delBh(\'"+rowData.bhjlid+"\',\'"+rowData.bhsbzt+"\')>删除</a>";
		                    	    var lcStr = "<a target='_blank' href='/hmglyh/rcyh/bhflow_showProcess.do?bhjl.bhjlid="+rowData.bhjlid+"&definitionKey=bhProcess'>流程图</a>";
			                    
		                    	    var rStr = "";
		                    	    //修改中的流程图
		                    	    <s:if test="fromXd and (!show)" >
		                    	    	rStr =  xgStr + "|" + scStr + "|"+lcStr + "|" + xqStr;
		                    	    </s:if>
		                    	    // 寻道详情中的流程图
		                    	    <s:if test="fromXd and show " >
		                    	    	rStr = lcStr;
		                    	    </s:if>
		                    	    // 上报的时候 列表
		                    	    <s:if test="fromSb and (!show)" >
		                    	    	rStr = xqStr + "|"  + xgStr + "|" + scStr + "|"+lcStr;
		                    	    </s:if>
		                    	    // 派工时候的 列表
		                    	    <s:if test="fromPg">
		                    	    	rStr = xqStr + "|" + lcStr;
		                    	    </s:if>
		                    	    
		                    	 	// 维修的时候
		                    	    <s:if test="fromWx">
		                    	    	rStr = xqStr;
		                    	    </s:if>
		                    	    
			                      	return rStr;
		                      }},
		                      {field:'bhsbzt',title:'病害上报状态',width:100},
		                      {field:'pgzt',title:'派工状态',width:100}, 
		                      {field:'bhwxzt',title:'病害维修状态',width:100},
		                      {field:'bhlxname',title:'病害类型',width:100},
		                      {field:'jltime',title:'记录时间',width:140},
		                      {field:'jlusername',title:'记录人',width:100},
		                      {field:'bmcode',title:'部门',width:100},
		                      {field:'ldname',title:'路段',width:180},
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
		                      {field:'sl',title:'数量',width:100,formatter:function(value,rowData,rowIndex){
			                    	if( rowData.dw != null && rowData.dw != "" ) {
			                    		return value + rowData.dw;
			                    	}else{
			                    		return value;
			                    	}
			                  }},
		                      {field:'bz',title:'备注',width:100},
		                      {field:'sbusername',title:'上报用户名',width:100},
		                      {field:'sbtime',title:'上报时间',width:100},
		                      {field:'sbbmname',title:'上报部门',width:100},
		                      {field:'pgusename',title:'派工用户名',width:100},
		                      {field:'pgtime',title:'派工时间',width:100},
		                      {field:'ycpgtime',title:'延期派工时间',width:100}
		                  ]];
	
	</script>
	<%-- <s:debug></s:debug> --%>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:BhjlbColumns,
		url:'${pageContext.request.contextPath}/rcyh/bh_listBh.do',
		pageNumber:1,
		pageSize:10,
		queryParams:{
			<s:if test="fromXd">
			'bhjl.xcid':'<s:property value="bhjl.xcid" />',
			'fromXd':true
			</s:if>
			<s:if test="fromSb">
			'bhjl.bhsbzt':'0',
			'fromSb':true
			</s:if>
			<s:if test="fromPg">
			'bhjl.pgzt':'0',
			'bhjl.bhsbzt':'1',
			'fromPg':true
			</s:if>
			<s:if test="fromWx">
			'fromWx':true,
			'wxzy.zyid':'<s:property value="wxzy.zyid" />'
			</s:if>
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
	
		<s:if test="fromXd and (!show)">
			<a href="${pageContext.request.contextPath}/rcyh/bh_addBh.do?bhjl.xcid=<s:property value="bhjl.xcid" />&fromXd=true" class="easyui-linkbutton" data-options="iconCls:'check',plain:true">添加病害</a>
		</s:if>
		
		<s:if test="fromSb">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'check',plain:true" onclick="qrsb()">上报</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'check',plain:true" onclick="showMap()">定位</a>
		</s:if>
		
		<s:if test="fromPg">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'check',plain:true" onclick="bhpg()">派工</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'check',plain:true" onclick="showMap()">定位</a>
		</s:if>
	
	</div>
	<script>
	
		// gisui
		var gisui = new GisUI({
			isShowToolBar:false
		});
	
	
		
		// 打开病害详情页 
		function bhxq(xcid,bhjlid){
		parent.gisui.createWindow({
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
		
		// 病害派工
		function bhpg(){
		 	var rows = $("#dg").datagrid("getSelections");
		 	
		 	if(rows.length == 0 ) {
				 $.messager.alert('警告','您没有选择任何数据!','warning');
				 return;
			}
		 	
			// 判断是否 有重复的路段
			if(isRepeatLd(rows)) {
				 $.messager.alert('警告','您只能批量派工相同路段上的病害!','warning');
				 return;
			}
			
			// 判断 构造物 编码 是否相同 唯一
			if(isReadGzwid(rows)) {
				 $.messager.alert('警告','您只能同时批量派工相同构造物的病害!','warning');
				 return;
			}
			
			var bhjlsStr = "";
			$.each(rows,function(i,d){
					bhjlsStr += "&bhjls["+i+"].bhjlid="+d.bhjlid;
					bhjlsStr += "&bhjls["+i+"].ldcode="+d.ldcode;
					bhjlsStr += "&bhjls["+i+"].xcid="+d.xcid;
					bhjlsStr += "&bhjls["+i+"].bhid="+d.bhid;
					bhjlsStr += "&bhjls["+i+"].szhhkm="+d.szhhkm;
					bhjlsStr += "&bhjls["+i+"].szhhm="+d.szhhm;
					bhjlsStr += "&bhjls["+i+"].ezhhkm="+d.ezhhkm;
					bhjlsStr += "&bhjls["+i+"].ezhhm="+d.ezhhm;
					bhjlsStr += "&bhjls["+i+"].sl="+d.sl;
					bhjlsStr += "&bhjls["+i+"].tq="+d.tq;
			});
			
			parent.gisui.createWindow({
				id:"rwpgWindow",
				title:"任务单",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:400,
				src:"${pageContext.request.contextPath}/rcyh/bhflow_addRwd.do?"+bhjlsStr,
				onBeforeDestroy:function(){
					$("#dg").datagrid("reload");
				}
			});
		}
		
		function qrsb(){
			var rows = $("#dg").datagrid("getSelections");
			// 判断是否 没有选择 任何数据
			if(rows.length == 0 ) {
				 $.messager.alert('警告','您未选择任何数据!','warning');
				 return;
			}
			var bhjlsStr = "";
			$.each(rows,function(i,d){
					bhjlsStr += "&bhjls["+i+"].bhjlid="+d.bhjlid;
			});
			
			parent.gisui.createWindow({
				title:"病害上报",
				iconCls:"icon-page",
				modal:true,
				width:500,
				height:230,
				left:300,
				top:100,
				src:"${pageContext.request.contextPath}/rcyh/bhflow_shangbao.do?"+bhjlsStr,
				onDestroy:function(){
					$("#dg").datagrid("reload");
				}
			});
		}
		
		function isRepeatLd(rows) {
			if( rows.length == 0 ) return true;
			var ldcode = rows[0].ldcode;
			var isRepeat = false;
			$.each(rows,function(i,d){
				if(d.ldcode != ldcode) {
					isRepeat = true;
					return;
				}
			});
			return isRepeat;
		};
		
		function isReadGzwid(rows){
			var result = false;
			
			if( hasQlcode(rows) ) {
				var qlcode = rows[0].qlcode;
				if(qlcode != "" && qlcode != null ) {
					$.each(rows,function(i,d){
						if( d.qlcode == qlcode ) {
							result = false;
						}else{
							result = true;
							return;
						}
					});
				}else{
					return true;
				}
			}
			// 检查隧道编码
			if( hasSdcode(rows) ) {
				var sdcode = rows[0].sdcode;
				if(sdcode != "" && sdcode != null ) {
					$.each(rows,function(i,d){
						if( d.sdcode == sdcode ) {
							result = false;
						}else{
							result = true;
							return;
						}
					});
				}else{
					return true;
				}
			}
			
			// 检查涵洞编码
			if( hasHdcode(rows) ) {
				var hdcode = rows[0].hdcode;
				if(hdcode != "" && hdcode != null ) {
					$.each(rows,function(i,d){
						if( d.hdcode == hdcode ) {
							result = false;
						}else{
							result = true;
							return;
						}
					});
				}else{
					return true;
				}
			}
			return result;
		}
		
		function hasQlcode(rows) {
			var r = false;
			$.each(rows,function(i,d){
				if(d.qlcode != "" && d.qlcode != null ) {
					r = true;
					return;
				}
			});
			return r;
		}
		function hasSdcode(rows) {
			var r = false;
			$.each(rows,function(i,d){
				if(d.sdcode != "" && d.sdcode != null ) {
					r = true;
					return;
				}
			});
			return r;
		}
		function hasHdcode(rows) {
			var r = false;
			$.each(rows,function(i,d){
				if(d.hdcode != "" && d.hdcode != null ) {
					r = true;
					return;
				}
			});
			return r;
		}
		
		//删除病害
		function delBh(bhjlid,bhsbzt) {
			if( bhsbzt == "已上报" ) {
				$.messager.alert("警告","病害已经上报，无法删除","warning");
				return;
			}
			
			$.messager.confirm('确认','确认删除?',function(r){
				    if (r){
				    	
				    	$.messager.progress({
							title:"请稍后...",
							text:"请稍后...",
							msg:'正在删除该条病害'
						}); 
				    	
				    	$.ajax({
							url:'${pageContext.request.contextPath}/rcyh/bh_delBh.do',
							data:{
								"bhjl.bhjlid":bhjlid
							},
							dataType:"json",
							success:function(re){
								$.messager.progress("close");
								
								if( re.isError){
									$.messager.alert("警告",d.info,"error");
									return;
								}
								
								if(re.isSuccess) {
									$.messager.alert("提示","成功删除","ok",function(r){
										$("#dg").datagrid("reload");
										parent.remember.ask();
									});
								}else{
									$.messager.alert("警告","病害删除失败，原因："+re.info,"warning");
								}
							},
							error:function(){
								$.messager.progress("close");
							}
						});
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
				title:"定位",
				iconCls:"icon-page",
				modal:true,
				width:950,
				height:400,
				left:50,
				top:50,
				src:"${pageContext.request.contextPath}/gis/index_rcyhMap.do?isBh=true"
			});
		}
		
	</script>
</body>
</html>