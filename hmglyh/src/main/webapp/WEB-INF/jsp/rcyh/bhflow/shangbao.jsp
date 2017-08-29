<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
<title>病害上报</title>
</head>
<body>
	<form id="fm" action="${pageContext.request.contextPath}/rcyh/bhflow_sbBH.do">
		<%-- <s:debug></s:debug> --%>
		<s:iterator value="bhjls" id="bh" status="status" >
			<input type="hidden" name="bhjls[<s:property value="#status.index" />].bhjlid" value="<s:property value="#bh.bhjlid" />" />
			<input type="hidden" name="bhjls[<s:property value="#status.index" />].sbtime" value="<s:property value="bhjl.sbtime" />" />
		</s:iterator>
		<div class="datagrid-body">
		<table class="form_table datagrid-btable">
			<tr class="datagrid-row">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>上报时间：</span>
					</div>		
				</td>
				<td style="text-align:center">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input readonly="readonly" class="notnull" type="text" value="<s:property value="bhjl.sbtime" />"  >
					</div>
				</td>
			</tr>
			<tr class="datagrid-row">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>上报人：</span>
					</div>		
				</td>
				<td style="text-align:center">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input class="notnull" readonly="readonly" type="text" value="<s:property value="user.ryname" />"  >
					</div>
				</td>
			</tr>
			<tr class="datagrid-row">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>上报单位：</span>
					</div>		
				</td>
				<td style="text-align:center">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input class="notnull" readonly="readonly" type="text" value="<s:property value="user.bmname" />"  >
					</div>
				</td>
			</tr>
			<tr class="datagrid-row">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>上报状态：</span>
					</div>		
				</td>
				<td style="text-align:center">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input  name="bhjl.bhsbzt" class="easyui-combobox notnull" data-options="
							panelHeight:'auto',
							data:[{
								text:'确认上报',
								value:'1',
								selected:true
							},{
								text:'取消上报',
								value:'2'
							}],
							onSelect:function(record){
								if(record.value == '2' ) {
									$('#sbdxCombobox').combobox('disable');
								}else{
									$('#sbdxCombobox').combobox('enable');
								}
							}
						"  />
					</div>
				</td>
			</tr>
			<tr class="datagrid-row">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>上报对象单位：</span>
					</div>		
				</td>
				<td style="text-align:center">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					    <input id="sbdxCombobox" name="bhjl.sbbmcode" type="text" class="easyui-combobox notnull" data-options="
					    	textField:'bmname',
					    	valueField:'bmcode',
					    	panelHeight:'auto',
					    	url:'${pageContext.request.contextPath}/rcyh/bh_getSbdxs.do?bhjl.bmcode=<s:property value="user.bmcode" />'
					    " />
					</div>
				</td>
			</tr>
			<!-- <tr class="datagrid-row">
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
							
					</div>		
				</td>
			</tr> -->
		</table>
		</div>
	</form>
	<center style="padding-top:5px;"><a onclick="$('#fm').submit()" class="easyui-linkbutton" data-options="plain:true">确认</a></center>
</body>
</html>