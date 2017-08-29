<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/cxtj/js/page.js"></script>
<title>任务单列表</title>
<script>
var RwdColumns = [[
                   /*  {field:"ck",checkbox:true}, */
                    {field:'aaa',title:'操作',align:'center',width:140,formatter:function(value,rowData,rowIndex){
                    	
                    	return "<a href='javascript:void(0)' onclick='delRwd(\""+rowData.rwdid+"\",\""+rowData.rwdzt+"\")'>删除</a>"+
                    		   "|<a href='javascript:void(0)' onclick='rwdXq(\""+rowData.rwdid+"\")'>详情</a>"+
                    		   "|<a href='javascript:void(0)' onclick='editRwd(\""+rowData.rwdid+"\",\""+rowData.rwdzt+"\")'>修改</a>";
                    }},
                    {field:'rwdzt',align:'center',title:'任务单状态',width:100},
                    {field:'rwdlx',align:'center',title:'任务单类型',width:100},
                    {field:'ssny',title:'所属年月',width:180},
                    {field:'cjtime',title:'创建时间',width:140},
                    {field:'cjusername',title:'创建用户名',width:100},
                    {field:'bmname',title:'部门',width:100},
                    {field:'ldname',title:'路段',width:170},
                    {field:'tq',title:'方向',width:100,align:'center'},
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
		<%-- url:'${pageContext.request.contextPath}/rcyh/wxzy_listRwd.do', --%>
		pageNumber:1,
		pageSize:10,
		queryParams:{
			'rwd.rwdzt':'0',
			'rwd.bmcode':'<s:property value="user.bmcode" />'
		},
		singleSelect:false,
		pageList:[10,20,30],
		pagination:true,
		fit:true,
		rownumbers:true,
		toolbar:'#toolbar',
		onLoadSuccess:function(data){
			var rwdlx = $('#rwdlx').combobox('getValue');
			if( rwdlx == '0901' ) {
				$('#shenhezt').html('&nbsp;'+data.shzt);
				if(data.shzt == '审核中') {
					$('#shenheButton').show();
				}else{
					$('#shenheButton').hide();
				}
			}
		}
	">
	</table>
	
	<div id="toolbar" style="padding:0px;">
		<div data-options="region:'north',border:true,split:false" style="height:30px;border-left:0px;border-right:0px;border-top:0px">
			<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;月度计划</div>
		</div>
		<div style="padding:10px;">
			<form id="ydjhfm">
					单位 ：<input type="text" id="yhz" name="rwd.bmcode" class="easyui-combotree" data-options="
					url:'${pageContext.request.contextPath}/gis/guanyangdw_bmtree.do',
					value:'<s:property value="user.bmcode" />',
					clickNodeForSpan:true,
					onSelect:function(data) {
						$('#yhzluduan').combobox('reload','/hmglyh/lxld/getLxldCombo.do?bmCode='+data.id); 
						$('#yhzluduan').combobox('setValue','');
					}
				">
				&nbsp;&nbsp;
				所管辖路段 ：
				<input id="yhzluduan" name="rwd.ldcode" class="easyui-combobox notnull" data-options="
					textField:'text',
					valueField:'id',
					onSelect:function(record){
						//loadData(record.ldcode);
					},
					onLoadSuccess:function(data){
						console.log(data);
						if( data.length > 0 ) {
							//loadData(data[0].ldcode);
							$('#yhzluduan').combobox('setValue',data[0].id);
						}
					}
				"> 
				&nbsp;&nbsp;
				类型：
				<input id="rwdlx" name="rwd.rwdlx" class="easyui-combobox" data-options="
					width:80,
					data:[
						{
							text:'计划',
							value:'0901',
							selected:true	
						},
						{
							text:'巡道',
							value:'0902'
						},
						{
							text:'补充',
							value:'0903'
						}	
					],
					onSelect:function(d){
						$('.otherCondition easyui-combobox').combobox('setValue','');
						$('.otherCondition easyui-datebox').combobox('setValue','');
						$('.otherCondition').hide();
						if(d.value == '0901') {
							$('.otherCondition4').show();
						}
						if(d.value == '0901' || d.value == '0903'){
							$('.otherCondition1').show();
						}else{
							$('.otherCondition1,.otherCondition2').show();
						}
					},
					panelHeight:'auto'
				" />
				&nbsp;&nbsp;
				<span class="otherCondition otherCondition2"  style="display:none;">
					<input class="easyui-combobox" id="condition" data-options="
						data:[
							{
								text:'按月份查询',
								value:'1'
							},
							{
								text:'按时间查询',
								value:'2'
							}
						],
						onSelect:function(d){
							$('.otherCondition1,.otherCondition3').hide();
							if( d.value == '1') {
								$('.otherCondition1').show();
							}else{
								$('.otherCondition3').show();
							}
						},
						panelHeight:'auto'
					">
				</span>
				&nbsp;&nbsp;
				<span class="otherCondition otherCondition1" >
					月份	:
					<input id="rwdssny"  name="rwd.ssny" class="easyui-combobox" data-options="
						url : '/hmglyh/nyb/getNy.do',
						valueField : 'yname',
						textField : 'yname'
					" />
				</span>
				<span id="shenhezt" class="otherCondition otherCondition4" style="color:green">
					&nbsp; 
				</span>
				&nbsp;&nbsp;
				<span class="otherCondition otherCondition3" style="display:none;">
					时间 :<input name="rwd.starttime" id="time" class="easyui-datebox" data-options="">
				</span>
				&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="loadData()">查询</a>
				&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="addYdjh()" >添加</a>
				&nbsp;&nbsp;
				<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="ckxx()">查看详细</a>
				<s:if test="%{ user.bmcode.length() == 6 }">
					<a id="shenheButton" style="display:none;" href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="shenhe()">审核</a>
				</s:if>
				<s:if test="%{ user.bmcode.length() == 8 }">
					<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="tijiao_shenhe()">提交审核</a>
				</s:if>
			</form>
		</div>
	</div>
	<script>
	
		function checkSubmit(){
			
			var bmcode = $("#yhz").combobox("getValue");
			
			if( bmcode == "" || bmcode == null  ) {
				
				$.messager.alert("提示","请选择部门","info");
				
				return false;
			}
			
			var ldcode = $("#yhzluduan").combobox("getValue");
			
			if( ldcode == "" || ldcode == null ) {
				$.messager.alert("提示","请选择路段","info");
				return false;
			}
			
			var rwdssny = $("#rwdssny").combobox("getValue");
			if(rwdssny == "" || rwdssny == null ){
				$.messager.alert("提示","请选择年月","info");
				return false;
			}
			
			return true;
			
		}
		
		// gisui
		var gisui = new GisUI({
			isShowToolBar:false
		});	
		
		function loadData(){
			
			var rwdlx = $("#rwdlx").combobox("getValue");
			
			if( rwdlx == "0901" ) {
				if(!checkSubmit()){
					return;
				}
			}
			
			$("#dg").datagrid({
				url:"/hmglyh/rcyh/wxzy_listRwdForYdjh.do",
				queryParams:getParam("ydjhfm")
			});
		}
		
		function delRwd(rwdid,ztname){
			
			if(ztname == "未维修" || ztname == "--") {
				
				$.messager.confirm("确认","您确定要删除该条记录吗?",function(r){
					if(r){
						
						$.messager.progress({
							title:"请稍后...",
							text:"请稍后...",
							msg:'一会就好'
						}); 
						
						$.post("/hmglyh/rcyh/bhflow_delRwd.do?rwd.rwdid="+rwdid,function(d){
							$.messager.progress("close"); 
							if( d.isError){
								$.messager.alert("警告",d.info,"error");
								return;
							}
							
							if(d.isSuccess) {
								$.messager.alert("成功",d.info,"ok",function(){
									$("#dg").datagrid("reload");
								});
							}else{
								$.messager.alert("失败",d.info,"error");
							}
						},"json");
					}
				});
				
			}else{
				$.messager.alert("警告","该任务已经完成无法修改","warning");
				return;
			}
			
		
		}
		
		function rwdXq(rwdid){
			gisui.createWindow({
				title:"任务单详情",
				iconCls:"icon-page",
				modal:true,
				top:20,
				width:950,
				height:450,
				src:"${pageContext.request.contextPath}/rcyh/bhflow_showRwd.do?rwd.rwdid="+rwdid+"&fromYdjh=true&show=true"
			});
		}
		
		function addYdjh(rwdid){
			
			gisui.createWindow({
				title:"添加月度计划",
				iconCls:"icon-page",
				modal:true,
				top:20,
				width:950,
				height:450,
				src:"${pageContext.request.contextPath}/rcyh/bhflow_addYdjhRwd.do",
				onDestroy:function(){
					loadData();
				}
			});
		}
		
		function editRwd(rwdid,ztname){
			if(ztname == "未维修" || ztname == "--") {
				gisui.createWindow({
					title:"修改任务单",
					iconCls:"icon-page",
					modal:true,
					top:20,
					width:950,
					height:450,
					src:"${pageContext.request.contextPath}/rcyh/bhflow_editRwd.do?rwd.rwdid="+rwdid+"&fromYdjh=true",
					onDestroy:function(){
						loadData();
					}
				});
			}else{
				$.messager.alert("警告","该任务已经完成无法修改","warning");
				return;
			}
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
		
	function ckxx(){
		var yhdw = $("#yhz").combotree("getValue");
		var yhqd = $("#yhzluduan").combobox("getValue");
		var rwly = $("#rwdlx").combobox("getValue");
		var yf = $("#rwdssny").combobox("getValue");
		var condition=$("#condition").combobox("getValue");
		day = $("#time").val();
		 if(rwly=="0902"&&condition=="2"){
			 window.open(YMLib.reportUrl+"reportlet=rcyhrwtzd_xd.cpt&bmcode="+yhdw+"&cjtime="+day+"&ldcode="+yhqd+"&rwdlx="+rwly);
		 }else if(rwly=="0902"&&condition=="1"){
			 window.open(YMLib.reportUrl+"reportlet=rcyhrwtzd_xd_yf.cpt&bmcode="+yhdw+"&ssny="+cjkEncode(yf)+"&ldcode="+yhqd+"&rwdlx="+rwly);
		 }else{
			 window.open(YMLib.reportUrl+"reportlet=rcyhrwtzd_bj.cpt&bmcode="+yhdw+"&ssny="+cjkEncode(yf)+"&ldcode="+yhqd+"&rwdlx="+rwly);
		 }; 
	};
	
	// 提交审核
	function tijiao_shenhe(){
			
		var rwdlx = $("#rwdlx").combobox("getValue");
		
		if( rwdlx == "0901" ) {
			if(!checkSubmit()){
				return;
			}
		}else{
			$.messager.alert("提示","请选择计划任务","info");
		}
		$.messager.confirm("提示","提交审核之后您将无法修改，删除这条记录，确认提交?",function(r){
			if(r){
				var queryParam = {};
				var bmcode = $("#yhz").combobox("getValue");
				var ldcode = $("#yhzluduan").combobox("getValue");
				var rwdssny = $("#rwdssny").combobox("getValue");
				
				queryParam['ydjhsh.bmcode'] = bmcode;
				queryParam['ydjhsh.ldcode'] = ldcode;
				queryParam['ydjhsh.ssny'] = rwdssny;
				
				$.ajax({
					url:"/hmglyh/rcyh/ydjhsh_tijiaoShenhe.do",
					data:queryParam,
					dataType:"json",
					method:"post",
					traditional:true,
					success:function(data){
						if(data.isError) {
							$.messager.alert("错误",data.info,"error");
						}else if(data.isSuccess) {
							$.messager.alert("成功",data.info,"ok");
							$("#dg").datagrid("reload");
						}else{
							$.messager.alert("错误",data.info,"error");
						}
					}
				});
			}
		});
	}	
	
	function shenhe(){			
		
		var rwdlx = $("#rwdlx").combobox("getValue");
		
		if( rwdlx == "0901" ) {
			if(!checkSubmit()){
				return;
			}
		}else{
			$.messager.alert("提示","请选择计划任务","info");
		}
		
		var queryStr = "";
		var bmcode = $("#yhz").combobox("getValue");
		var ldcode = $("#yhzluduan").combobox("getValue");
		var rwdssny = $("#rwdssny").combobox("getValue");
		
		queryStr = "&ydjhsh.bmcode="+bmcode+"&ydjhsh.ldcode="+ldcode+"&ydjhsh.ssny="+rwdssny;
		
		var w =( $("body").width() - 500 ) / 2;
		gisui.createWindow({
			title:"审核月度计划",
			iconCls:"icon-page",
			modal:true,
			width:403,
			height:170,
			left:w,
			top:200,
			src:"${pageContext.request.contextPath}/rcyh/ydjhsh_ydjhsh.do?"+queryStr,
			onDestroy:function(){
				$("#dg").datagrid("reload");
			}
		});
	}
	</script>
</body>
</html>