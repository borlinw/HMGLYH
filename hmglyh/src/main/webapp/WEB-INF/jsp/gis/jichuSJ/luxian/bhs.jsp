<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../public/head.jsp"%>
<title>病害养护数据</title>
</head>
<body>
<script type="text/javascript">
	var BhjlbColumns = [[
	                     {field:'bhsbzt',title:'病害上报状态',width:100},
	                     {field:'pgzt',title:'派工状态',width:100}, 
	                     {field:'bhwxzt',title:'病害维修状态',width:100},
	                     {field:'bhlxname',title:'病害类型',width:100},
	                     {field:'jltime',title:'记录时间',width:140},
	                     {field:'jlusername',title:'记录人用户名',width:100},
	                     {field:'bmcode',title:'部门',width:100},
	                     {field:'ldname',title:'路段',width:100},
	                     {field:'tq',title:'方向',width:100},
	                     {field:"bbb",title:"桩号",formatter:function(value,rowData){
	                     	return "K"+rowData.szhhkm + "+" + rowData.szhhm 
	                     			+"K" + rowData.ezhhkm + "+"+ rowData.ezhhm;
	                     }},
	                     {field:'wzbc',title:'位置补充',width:100},
	                     {field:'qlcode',title:'桥梁编码',width:100},
	                     {field:'qlname',title:'桥梁名称',width:100},
	                     {field:'sdcode',title:'隧道编码',width:100},
	                     {field:'sdname',title:'隧道名称',width:100},
	                     {field:'hdcode',title:'涵洞编码',width:100},
	                     {field:'hdname',title:'涵洞名称',width:100},
	                     {field:'sl',title:'数量',width:100},
	                     {field:'bz',title:'备注',width:100},
	                     {field:'sbusername',title:'上报用户名',width:100},
	                     {field:'sbtime',title:'上报时间',width:100},
	                     {field:'sbbmname',title:'上报部门',width:100},
	                     {field:'pgusename',title:'派工用户名',width:100},
	                     {field:'pgtime',title:'派工时间',width:100},
	                     {field:'ycpgtime',title:'延期派工时间',width:100}
	                 ]];
	
	function getBhImg(rowData){
		if( rowData.bhwxzt == "已维修" ){
			return "/hmglyh/page/gis/mapimg/bh1.png";
		}else{
			return "/hmglyh/page/gis/mapimg/bh2.png";
		}
	}
	
	
	function onLoadSuccess(data){
		parent.map.clearLayerByWindowId('binghaiyhsj');
		var rows =data.rows;
		if( rows.length  == 0 ) return;
		var points = [];
		$.each(rows,function(i,d){
			points.push({
				roadcode:d.ldcode,
				zh:d.szhhkm + d.szhhm / 1000,
				imgpath:getBhImg(d),
				popup:{
					title:"详情",
					rowData:d,
					columns:BhjlbColumns,
					buttons:[
								{
									 text:'详情',
									 attr:{
										 xcid:d.xcid,
										 bhjlid:d.bhjlid
									 },
									 eventHandler:function(obj){
										 var xcid = $(obj).attr('xcid');
										 var bhjlid = $(obj).attr('bhjlid');
										 bhxq(xcid,bhjlid);
									 }
								}
					         ]
					
				}
			});
		});
		parent.map.addPointByZh(points,"binghaiyhsj");
	}
	
	function onClickRow(rowIndex,rowData){
		var rows =[rowData];
		if( rows.length  == 0 ) return;
		var points = [];
		$.each(rows,function(i,d){
			points.push({
				roadcode:d.ldcode,
				zh:d.szhhkm + d.szhhm / 1000,
				imgpath:getBhImg(d),
				popup:{
					title:"详情",
					rowData:d,
					columns:BhjlbColumns,
					buttons: [
							{
								 text:'详情',
								 attr:{
									 xcid:d.xcid,
									 bhjlid:d.bhjlid
								 },
								 eventHandler:function(obj){
									 var xcid = $(obj).attr('xcid');
									 var bhjlid = $(obj).attr('bhjlid');
									 bhxq(xcid,bhjlid);
								 }
							}
				         ]
				}
			});
		});
		parent.map.addPointByZh(points,"binghaiyhsj");
	}
	
	
	</script>
	<table id="dg" class="easyui-datagrid" data-options="
		columns:BhjlbColumns,
		<s:if test="fromLx">
		url:'${pageContext.request.contextPath}/rcyh/bh_bhcxList.do?bhjl.lxcode=<s:property value="roadcode" />',
		</s:if>
		<s:if test="fromBm">
		url:'${pageContext.request.contextPath}/rcyh/bh_bhcxList.do?bhjl.bmcode=<s:property value="bmcode" />',
		</s:if>
		pageNumber:1,
		pageSize:10,
		pageList:[10,20,30],
		pagination:true,
		fit:true,
		rownumbers:true,
		toolbar:'#toolbar',
		onLoadSuccess:onLoadSuccess,
		onClickRow:onClickRow,
		singleSelect:true
	">
	</table>
	
	<div id="toolbar" style="padding:10px;">
		<span class="myformsearch">
			<form id="fm" class="search-form">
				 构造物：<input name="bhjl.select" id="gzwlx" class="easyui-combobox" data-options="
			 	width:80,
			 	panelHeight:'auto',
			 	data:[
			 		{
			 			text:'不限',
			 			value:'0'
			 		},
			 		{
			 			text:'桥梁',
			 			value:'1'
			 		},{
			 			text:'隧道',
			 			value:'2'
			 		},{
			 			text:'涵洞',
			 			value:'3'
			 		}
			 	],
			 	onSelect:function(record){
			 		$('.qshspan').hide();
			 		$('.qshspaninput').combobox('setValue','');
			 		if(record.value == 1 ){
			 			$('.qlspan').show();
			 		}
			 		if(record.value == 2 ) {
			 			$('.sdspan').show();
			 		}
			 		if(record.value == 3 ) {
			 			$('.hdspan').show();
			 		}
			 	}
			 ">&nbsp;
			 <s:if test="fromLx">
			  部门：<input class="easyui-combotree" data-options="
			  		url:'${pageContext.request.contextPath}/gis/guanyangdw_bmtree.do',
			  		width:80,
			  		panelWidth:120,
			  		onSelect:function(data) {
						$('#yhzluduan').combobox('reload','/hmglyh/rcyh/xdjl_ldsList.do?xcsj.bmcode='+data.id); 
					}
			  ">&nbsp;
			 路段：<input id="yhzluduan" name="bhjl.ldcode" class="easyui-combobox notnull" data-options="
				textField:'ldname',
				valueField:'ldcode',
				width:80,
				panelWidth:120,
				onSelect:function(record){
					var gzw = $('#gzwlx').combobox('getValue');
					$('.qshspaninput').combobox('setValue','');
					if( gzw == 1 ) { // 桥梁
							var startzh = record.szhh;
							var endzh = record.ezhh
							var roadcode = record.lxcode;
							$('#qlCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?ql.roadcode='+roadcode+'&ql.startzh='+startzh+'&ql.endzh='+endzh);
					}
					if( gzw == 2 ) { // 隧道
							var startzh = record.szhh;
							var endzh = record.ezhh;
							var roadcode = record.lxcode;
							$('#sdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_sdComboboxByld.do?sd.roadcode='+roadcode+'&sd.startzh='+startzh+'&sd.endzh='+endzh);
					}
					if( gzw == 3 ) { // 涵洞
							var startzh = record.szhh;
							var endzh = record.ezhh
							var roadcode = record.lxcode;
							$('#hdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?hd.roadcode='+roadcode+'&hd.startzh='+startzh+'&hd.endzh='+endzh);
					}
				}
				,
				onLoadSuccess:function(data){
					//console.log(data);
					if( data.length > 0 ) {
							var gzw = $('#gzwlx').combobox('getValue');
							$('.qshspaninput').combobox('setValue','');
							var record = data[0];
							if( gzw == 1 ) { // 桥梁
									var startzh = record.szhh;
									var endzh = record.ezhh
									var roadcode = record.lxcode;
									$('#qlCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?ql.roadcode='+roadcode+'&ql.startzh='+startzh+'&ql.endzh='+endzh);
							}
							if( gzw == 2 ) { // 隧道
									var startzh = record.szhh;
									var endzh = record.ezhh;
									var roadcode = record.lxcode;
									$('#sdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_sdComboboxByld.do?sd.roadcode='+roadcode+'&sd.startzh='+startzh+'&sd.endzh='+endzh);
							}
							if( gzw == 3 ) { // 涵洞
									var startzh = record.szhh;
									var endzh = record.ezhh
									var roadcode = record.lxcode;
									$('#hdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?hd.roadcode='+roadcode+'&hd.startzh='+startzh+'&hd.endzh='+endzh);
							}
					}
				}
			">
			</s:if>
			<s:if test="fromBm">
			  部门：<input class="easyui-combotree" data-options="
			  		url:'${pageContext.request.contextPath}/gis/guanyangdw_bmtree.do',
			  		width:80,
			  		panelWidth:120,
			  		value:'<s:property value="bmcode" />',
			  		disabled:'disabled'
			  		
			  ">&nbsp;
			 路段：<input id="yhzluduan" name="bhjl.ldcode" class="easyui-combobox notnull" data-options="
					url:'${pageContext.request.contextPath}/gis/luxian_luduanCombobox.do?bmcode=<s:property value="bmcode" />',
					textField:'ldname',
					valueField:'ldcode',
					width:80,
					panelWidth:120,
					onSelect:function(record){
					
						var gzw = $('#gzwlx').combobox('getValue');
						$('.qshspaninput').combobox('setValue','');
						if( gzw == 1 ) { // 桥梁
								var startzh = record.szhh;
								var endzh = record.ezhh
								var roadcode = record.lxcode;
								$('#qlCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?ql.roadcode='+roadcode+'&ql.startzh='+startzh+'&ql.endzh='+endzh);
						}
						if( gzw == 2 ) { // 隧道
								var startzh = record.szhh;
								var endzh = record.ezhh;
								var roadcode = record.lxcode;
								$('#sdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_sdComboboxByld.do?sd.roadcode='+roadcode+'&sd.startzh='+startzh+'&sd.endzh='+endzh);
						}
						if( gzw == 3 ) { // 涵洞
								var startzh = record.szhh;
								var endzh = record.ezhh
								var roadcode = record.lxcode;
								$('#hdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?hd.roadcode='+roadcode+'&hd.startzh='+startzh+'&hd.endzh='+endzh);
						}
					
					},
					onLoadSuccess:function(data){
					//console.log(data);
					if( data.length > 0 ) {
							var gzw = $('#gzwlx').combobox('getValue');
							$('.qshspaninput').combobox('setValue','');
							var record = data[0];
							if( gzw == 1 ) { // 桥梁
									var startzh = record.szhh;
									var endzh = record.ezhh
									var roadcode = record.lxcode;
									$('#qlCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?ql.roadcode='+roadcode+'&ql.startzh='+startzh+'&ql.endzh='+endzh);
							}
							if( gzw == 2 ) { // 隧道
									var startzh = record.szhh;
									var endzh = record.ezhh;
									var roadcode = record.lxcode;
									$('#sdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_sdComboboxByld.do?sd.roadcode='+roadcode+'&sd.startzh='+startzh+'&sd.endzh='+endzh);
							}
							if( gzw == 3 ) { // 涵洞
									var startzh = record.szhh;
									var endzh = record.ezhh
									var roadcode = record.lxcode;
									$('#hdCombobox').combobox('reload','/hmglyh/gis/gouzaowu_qlComboboxByld.do?hd.roadcode='+roadcode+'&hd.startzh='+startzh+'&hd.endzh='+endzh);
							}
						}
					}
				">
				
			</s:if>
			&nbsp;
			<br>
			  类&nbsp;型：<input name="bhjl.bhid" class="easyui-combotree" data-options="
			  		width:80,
			  		panelWidth:120,
			  		url:'${pageContext.request.contextPath}/rcyh/bh_bhlxCombotree.do',
			  		clickNodeForSpan:true,
			  ">&nbsp;
			  开始：<input name="bhjl.starttime" class="easyui-datebox" data-options="
			  		width:80
			  " />&nbsp;
			  结束：<input  name="bhjl.endtime" class="easyui-datebox" data-options="
			  		width:80
			  ">&nbsp;
			<!--   <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'check',plain:true" onclick="showMap()">定位</a> -->
		
			   <a class="easyui-linkbutton" onclick='$("#dg").datagrid("load",getParam("fm"))' data-options="plain:true">查询</a>
			 <br>
			 <span class="qshspan qlspan" style="display:none;">
				桥&nbsp;梁：<input id="qlCombobox" name="bhjl.qlcode" class="easyui-combobox qshspaninput" data-options="
						width:80,
						panelWidth:120
					 " >
			 </span>
			 <span class="qshspan sdspan" style="display:none;">
			 	隧&nbsp;道：<input id="sdCombobox" name="bhjl.sdcode" class="easyui-combobox qshspaninput" data-options="
			 			width:80,
			 			panelWidth:120
			 	">
			 </span>
			  <span class="qshspan hdspan" style="display:none;">
			 	涵&nbsp;洞：<input id="hdCombobox" name="bhjl.hdcode" class="easyui-combobox qshspaninput" data-options="
			 			width:80,
			 			panelWidth:120
			 	">
			 </span>
			</form>
		</span>
	</div>
</body>
</html>