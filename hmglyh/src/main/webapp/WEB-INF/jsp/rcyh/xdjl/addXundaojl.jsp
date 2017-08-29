<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
<title></title>
</head>
<body>
	
	<form id="fm"
		<s:if test="add">
						action="/hmglyh/rcyh/xdjl_saveXdjl.do"
				  </s:if>
		<s:if test="update">
						action="/hmglyh/rcyh/xdjl_saveUpdateXdjl.do"
				 </s:if>
		method="post">
		<div class="datagrid-body">
			<input type="hidden" name="xcsj.bmcode"
				value="<s:property value='xcsj.bmcode' />"> <input
				type="hidden" name="xcsj.xcid"
				value="<s:property value='xcsj.xcid' />"> <input
				type="hidden" name="xcsj.username"
				value="<s:property value='xcsj.username' />">
			<table class="form_table datagrid-btable" cellpadding=0 cellspacing=0>
				<tr class="datagrid-row">
					<td><div style='height: auto; text-align: center'
							class='datagrid-cell'>巡查时间</div></td>
					<td><div style='height: auto; text-align: center'
							class='datagrid-cell'>
							<s:if test="!show">
								<input class="easyui-datetimebox"
								data-options="value:'<s:property value="xcsj.stime" />'"
								name="xcsj.stime" />
							</s:if>
							<s:else>
								<s:property value="xcsj.stime" />
							</s:else>
							-
							<s:if test="!show">
								<input class="easyui-datetimebox"
								data-options="value:'<s:property value="xcsj.etime" />' "
								name="xcsj.etime" />
							</s:if>
							<s:else>
								<s:property value="xcsj.etime" />
							</s:else>
						</div></td>
					<td><div style='height: auto; text-align: center'
							class='datagrid-cell'>巡查路段</div></td>
					<td>
						<div style='height: auto; text-align: center'
							class='datagrid-cell'>
							<s:if test="show">
								<s:property value="xcsj.xsld" />
							</s:if>
							<s:else>
								<input id="xcld" errorInfo="请选择巡查路段" class="easyui-combobox notnull" name="xcsj.xsld"
									data-options="
											valueField:'text',
											textField:'text',
											editable:true,
											<s:if test="update">
											onLoadSuccess:function(){
												$('#xcld').combobox('setValue','<s:property value="xcsj.xsld" />')
											},
											</s:if>
											url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlLds.do'
										" />
							</s:else>
						</div>
					</td>
					<td><div style='height: auto; text-align: center'
							class='datagrid-cell'>天气</div></td>
					<td>
						<div style='height: auto; text-align: center'  class='datagrid-cell'>
							
							<s:if test="!show">
								<input id="xctq" errorInfo="请选择天气" class="easyui-combobox notnull" name="xcsj.tq"
									data-options="
									textField:'value',
									valueField:'key',
									<s:if test="update">
										onLoadSuccess:function(){
											$('#xctq').combobox('setValue','<s:property value="xcsj.tq" />')
										},
									</s:if>
									panelHeight:'auto',
									url:'${pageContext.request.contextPath}/rcyh/xdjl_tqList.do'
							   		">
							</s:if>
							<s:else>
								<s:property value="xcsj.tq" />
							</s:else>
							
						
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td><div style='height: auto; text-align: center'
							class='datagrid-cell'>项目</div></td>
					<td colspan="5"><div style='height: auto; text-align: center'
							class='datagrid-cell'>路段、存在问题及数量</div></td>
				</tr>
				<tr class="datagrid-row">
					<td>
						<div style='height: auto; text-align: center'  class='datagrid-cell'>路面</div>
					</td>
					<td colspan="5">
						<div style='height: auto;  font-weight: normal; font-size: 12px;padding:2px 2px'>
									<s:property value="xcsj.lm" />
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td><div style='height: auto; text-align: center'  class='datagrid-cell'>路基</div>
					</td>
					<td colspan="5">
						<div class='' style='height: auto;  font-weight: normal; font-size: 12px;padding:2px 2px' >
								<s:property value="xcsj.lj" />
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td>
						<div style='height: auto; text-align: center' class='datagrid-cell'>桥隧涵构造物</div>
					</td>
					<td colspan="5">
						<div  style='height:auto; font-weight: normal; font-size: 12px;padding:2px 2px'>
								<s:property value="xcsj.qsh" />
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td>
						<div style='height: auto; text-align:center'  class='datagrid-cell'>沿线设施</div></td>
					<td colspan="5">
						<div style='height: auto;  font-weight: normal; font-size: 12px;padding:2px 2px'>
									<s:property value="xcsj.yxss" />
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td><div readonly="readonly" style='height: auto; text-align: center'
							class='datagrid-cell'>备注</div></td>
					<td colspan="5">
						<s:if test="show">
							<div  style='height:auto; font-weight: normal; font-size: 12px;padding:2px 2px'>
								<s:property value="xcsj.bz" />
							</div>
						</s:if>
						<s:else>
								<input style="width:100%" name="xcsj.bz" value="<s:property value="xcsj.bz" />" />
						</s:else>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td><div style='height: auto; text-align: center'
							class='datagrid-cell'>记录人</div></td>
					<td colspan="2">
						<div style='height: auto; text-align: center'
							class='datagrid-cell'>
							<s:if test="!show">
								<input errorInfo="请选择记录人" name="xcsj.jlr" class="easyui-combobox notnull"
								data-options="
								<s:if test="xcsj.jlr != null" >
								value:'<s:property value="xcsj.jlr"/>',
								</s:if>
								panelHeight:'auto',
								url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlYhs.do'
							" />
							</s:if>
							<s:else>
								<s:property value="xcsj.jlr"/>
							</s:else>
						</div>
					</td>
					<td><div style='height: auto; text-align: center'
							class='datagrid-cell'>负责人</div></td>
					<td colspan="2">
						<div style='height: auto; text-align: center' class='datagrid-cell'>
							<s:if test="!show">
								<input name="xcsj.fzr" errorInfo="请选择负责人"
									value="<s:property value="user.username" />"
									class="easyui-combobox notnull"
									data-options="
									<s:if test="xcsj.fzr != null" >
									value:'<s:property value="xcsj.fzr"/>',
									</s:if>
									panelHeight:'auto',
									url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlYhs.do'
								" />
							</s:if>
							<s:else>
								<s:property value="xcsj.fzr"/>
							</s:else>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<s:if test="add">
		<center style="padding-top: 5px;">
			<a class="easyui-linkbutton" data-options="plain:true"
				onclick="$('#fm').submit()">保存</a>
		</center>
	</s:if>
	<s:if test="update">
		<center style="padding-top: 5px;">
			<a class="easyui-linkbutton" data-options="plain:true"
				onclick="$('#fm').submit()">更新</a>
		</center>
	</s:if>
	<s:if test="show">
		<center style="padding-top: 5px;">
			<a class="easyui-linkbutton" data-options="plain:true"
				href='${pageContext.request.contextPath}/rcyh/xdjl_exportXdjl.do?xcsj.xcid=<s:property value="xcsj.xcid"/>'>导出</a>
		</center>
	</s:if>
	<script>
	<s:if test="show" >
		$("input").attr("readonly","readonly");
	</s:if>
	</script>
</body>
</html>