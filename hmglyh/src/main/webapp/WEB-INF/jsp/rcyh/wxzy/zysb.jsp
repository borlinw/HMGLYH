<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
<title>作业上报</title>
</head>
<body>
	<form id="fm" action="${pageContext.request.contextPath}/rcyh/wxzy_saveZysb.do">
		<s:iterator value="wxzys" id="zy" status="status">
			<input type="hidden" name="wxzys[<s:property value="#status.index" />].zyid" value="<s:property value="#zy.zyid" />">
		</s:iterator>
		<div class="datagrid-body">
			<table class="form_table datagrid-btable">
				<tr  class="datagrid-row">
					<td style="text-align:center">
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<span>上报时间：</span>
					    </div>
					 </td>
				     <td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input class="notnull" name="wxzy.sbtime" readonly="readonly" type="text" value="<s:property value="wxzy.sbtime" />"  >
					    </div>
					</td>
				</tr>
				<tr  class="datagrid-row">
					<td style="text-align:center">
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<span>上报人：</span>
					    </div>
					 </td>
				     <td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input class="notnull" readonly="readonly" type="text" value="<s:property value="user.ryname" />"  >
					    </div>
					</td>
				</tr>
				<tr  class="datagrid-row">
					<td style="text-align:center">
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<span>上报单位：</span>
					    </div>
				    </td>
				    <td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input cass="notnull" readonly="readonly" type="text" value="<s:property value="user.bmname" />"  >
					    </div>
					</td>
				</tr>
				<tr  class="datagrid-row">
					<td style="text-align:center">
						 <div style='height:auto;text-align:center' class='datagrid-cell'>
							<span>上报状态：</span>
					     </div>
				     </td>
				     <td>
					     <div style='height:auto;text-align:center' class='datagrid-cell'>
							<input name="wxzy.zysbzt" class="notnull easyui-combobox" data-options="
							panelHeight:'auto',
							data:[{
								text:'确认上报',
								value:'1',
								selected:true
							},{
								text:'取消上报',
								value:'2'
							}]
						"  />
					    </div>
					</td>
				</tr>
			</table>
		</div>
		<s:token/>
	</form>
	<center style="padding-top:5px;"><a onclick="$('#fm').submit()" class="easyui-linkbutton" data-options="plain:true">确认</a></center>
	<script>
			/* var values = $("input[type='hidden']");
			$.each(values,function(i,d){
				$("body").append("<span>"+$(d).attr("name")+":"+$(d).attr("value")+"</span><br>");
			});  */
	</script>
</body>
</html>