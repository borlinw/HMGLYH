<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/lkpd/lkpdmx.js"></script>
</head>
<body>
	<script>
		var initCombo = function(){
			$("#ldCode").combobox({
				url : YMLib.url + "lxld/getLxldCombo.do?bmCode=<s:property value="user.bmcode" />",
				valueField : "id",
				textField : "text",
				onSelect : function(data){
					lxCode = data.lxCode;
					szhh = data.szhh;
					ezhh = data.ezhh;
				},
				onLoadSuccess : function(){
					var data = $("#ldCode").combobox("getData");
					$("#ldCode").combobox("select",data[0].id);
					ldState = true;
					if(bbState&&fxState)
						initGrid();
				}
			});
			$("#bbid").combobox({
				url : YMLib.url + "bbkzb/getQmbb.do?bblx=0203",
				valueField : "bbid",
				textField : "bbmc",
				onLoadSuccess : function(){
					var data = $("#bbid").combobox("getData");
					if(data == null || data.length == 0){
						YMLib.UI.Show("没有对应的路况评定的版本，请先创建版本",2000);
					}else{
						$("#bbid").combobox("setValue",data[0].bbid);
						bbState = true;
						if(ldState&&fxState)
							initGrid();
					}
				}
			});
			$("#fx").combobox({
				url : YMLib.url + "htglmjlx/createCombobox.do?typecodeStr=03",
				valueField : "id",
				textField : "text",
				onLoadSuccess : function(){
					var data = $("#fx").combobox("getData");
					$("#fx").combobox("setValue",data[0].id);
					fxState = true;
					fx = data[0].id;
					if(ldState&&bbState)
						initGrid();
				}
			});
		};
		$(function(){
			initCombo();
		});
	</script>
 	<div id="toolbar" style="padding:10px;">
		<span class="myformsearch">
			<form id="fm" class="search-form">
					<table>
						<tr>
							<td>
								&nbsp;路段：
								<select name="lxCode" id="ldCode" class="easyui-combobox" panelHeight="auto" style="width:100px;"></select>
							</td>
							<td>&nbsp;版本：
							<select name="pdbbid" id="bbid" class="easyui-combobox" panelHeight="auto" style="width:130px">
							</select>
							</td>
							<td style="display:hidden;">
								&nbsp;技术等级：
								<select name="isgs" id="isgs" class="easyui-combobox">
									<option value="1">高速或一级公路</option>
									<option value="0">二级及以下公路</option>
								</select>
							</td>
						<tr>
						</tr>
							<td style="display:hidden;">
								&nbsp;路面类型：
								<select name="lmlx" id="lmlx" class="easyui-combobox">
									<option value="1">沥青路面</option>
									<option value="2">水泥路面</option>
									<option value="3">砂石路面</option>
								</select>
							</td>
							<td>
								&nbsp;方向
								<select name="fx" id="fx" class="easyui-combobox" style="width:70px;"></select>
							
								 &nbsp;标准：
			                     <input id="pdbz" class="easyui-combobox" data-options="
			                           width:'60',
			                           data:[
			                               {
			                                   text:'MQI',
			                                   value:'MQI',
			                                   selected:true
			                               },
			                               {
			                                   text:'路面PQI',
			                                   value:'PQI'
			                               },
			                               {
			                                   text:'PCI',
			                                   value:'PCI'
			                               },
			                               {
			                                   text:'路基SCI',
			                                   value:'SCI'
			                               },
			                               {
			                                   text:'桥隧涵构造物BCI',
			                                   value:'BCI'
			                               },
			                               {
			                                   text:'沿线设施TCI',
			                                   value:'TCI'
			                               }
			                           ]
			                       ">
							</td>
							<td>
								&nbsp;&nbsp;
								<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="getLkpd">查询</a>
								<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dingwei()">定位</a>
								<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dingweiAll()">全部</a>
							</td>
						</tr>
			</table>
			</form>
		</span>
	</div>
 	<table id="myGrid" class="easyui-datagrid" data-options="
		columns:column,
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
	<script>
		
		
		function onLoadSuccess(rows){
			parent.map.clearLayerByWindowId("yhxx_lukuang1");
			parent.map.clearLayerByWindowId("yhxx_lukuang2");
			parent.map.clearLayerByWindowId("yhxx_lukuang3");
			parent.map.clearLayerByWindowId("yhxx_lukuang4");
			parent.map.clearLayerByWindowId("yhxx_lukuang5");
			var pdbz = $("#pdbz").combobox("getValue");
			var windowid = "default";
			$.each(rows,function(i,d){
				var tempValue = 0;
				if( pdbz == "MQI") {
					tempValue = d.mqi;	
				}else if( pdbz == "PQI") {
					tempValue = d.pqi;
				}else if( pdbz == "PCI") {
					tempValue = d.pci;
				}else if( pdbz == "SCI") {
					tempValue = d.sci;
				}else if( pdbz == "BCI") {
					tempValue = d.bci;
				}else if( pdbz == "TCI") {
					tempValue = d.tci;
				}
				
				var color = "#000000";
				if( 90 <= tempValue && tempValue <= 100) {
					color = "#00ff00";
					windowid = "yhxx_lukuang1";
				}else if( 80 <= tempValue && tempValue < 90 ){
					color = "#0000ff";
					windowid = "yhxx_lukuang2";
				}else if( 70 <= tempValue && tempValue < 80 ) {
					color = "#000000";
					windowid = "yhxx_lukuang3";
				}else if( 60 <= tempValue && tempValue < 70 ) {
					color = "#cccccc";
					windowid = "yhxx_lukuang4";
				}else if( tempValue < 60 ) {
					color = "#ff0000";
					windowid = "yhxx_lukuang5";
				}
				var lineJson = {
						windowid:windowid,
						roadcode:d.lxCode,
						startzh:d.szhh,
						endzh:d.ezhh,
						nopopup:false,
						strokeColor:color
				};
				
				console.log(d.lxCode+"--"+d.szhh + "-" + d.ezhh+":" + tempValue + ",pdbz"+pdbz);
				parent.map.addLineToMap(lineJson);
				
			});
		}
		
		function dingwei(){
			var rows = $("#myGrid").datagrid("getSelections");
			onLoadSuccess(rows);
		}
		
		

		// 路况 定位 all
		function dingweiAll() {
			
			parent.$.messager.progress({
				title:"请稍后...",
				text:"请稍后...",
				msg:'正在执行全部定位操作，此过程较慢，请稍候'
			}); 
			
			var total = $("#myGrid").datagrid("getData").total;
			var url = $("#myGrid").datagrid("options").url;
			var param = $("#myGrid").datagrid("options").queryParams;
			param.page = 1;
			param.rows = total;
			$.ajax({
				url:url,
				data:param,
				dataType:"json",
				success:function(data){
					parent.map.clearLayerByWindowId("yhxx_lukuang1");
					parent.map.clearLayerByWindowId("yhxx_lukuang2");
					parent.map.clearLayerByWindowId("yhxx_lukuang3");
					parent.map.clearLayerByWindowId("yhxx_lukuang4");
					parent.map.clearLayerByWindowId("yhxx_lukuang5");
					onLoadSuccess(data.rows);
					parent.$.messager.progress("close");
				},
				error:function(e){
					console.error(e);
				}
			});
			
		}

		
	</script>
</body>
</html>