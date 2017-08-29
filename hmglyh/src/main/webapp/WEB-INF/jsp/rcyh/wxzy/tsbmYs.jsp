<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/calculate.js"></script>
<title>维修作业验收</title>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<form id="fm" action="${pageContext.request.contextPath}/rcyh/wxzy_saveTsbmys.do" method="post">
		<div class="datagrid-body">		
			<s:token />
			<input type="hidden" name="zyys.bmcode" value="<s:property value="zyys.bmcode" />" />
			<input type="hidden" name="zyys.ysusername" value="<s:property value="user.username" />" />
			<input type="hidden" name="zyys.ldcode" value="<s:property value="zyys.ldcode" />" />
			<input type="hidden" name="zyys.yhid" value="<s:property value="zyys.yhid" />" />
			<input type="hidden" id="zyyszt" name="zyys.zyyszt" value="<s:property value="zyys.zyyszt" />" />
			<input type="hidden" id="bufenYs" name="bufenYs" value="false" />
			<input type="hidden" name="zyys.ssny" value="<s:property value="zyys.ssny" />" />
			<input type="hidden" name="wxzy.zyid" value="<s:property value="wxzy.zyid" />" />
			<input  type="hidden" id="dejs" value="<s:property value="zyys.dejs" />" /><!-- 定额基数 -->
			<input  type="hidden" id="srz" value="" /><!-- 用户输入值 -->
			<input  type="hidden" id="xsz" value="" /><!-- 当前显示值 -->
			<table id="mytable" class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
				<tr class="datagrid-row">
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input name="wxzy.yszt" class="easyui-combobox" data-options="data:[
								{
									text:'确认验收',
									value:'1',
									selected:true
								},
								{
									text:'打回返工',
									value:'0'
								}
							],
							onSelect:function(record){
								if(record.value== 0 ) {
									$('.hgsl-row').hide();
									$('#hgslInput').val(0)
								}else{
									$('.hgsl-row').show();
									$('#hgslInput').val('');
								}
							},
							panelHeight:'auto'
							">
							<span class="hgsl-row">
								&nbsp;	&nbsp;	&nbsp;	&nbsp;
								合格数量	&nbsp;<input name="wxzy.hgsl" id="hgslInput" errorInfo="合格数量填写有误" class="combo notnull int"  onfocus="pgslFocus(this)" onblur="pgslBlur(this)"  style="width:100px;height:14px;border:1px solid #95B8E7" type="text" name="wxzy.hgsl" >
								<s:property value="zyys.dw" />
							</span>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<center style="margin-top:5px;"><a class="easyui-linkbutton" onclick="$('#fm').submit()" data-options="plain:true">确认</a></center>
</body>
</html>