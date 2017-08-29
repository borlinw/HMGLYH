<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/calculate.js"></script>
<title>维修作业验收</title>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<div style="height:30px;"></div>
	<form id="fmm" action="${pageContext.request.contextPath}/rcyh/ydjhsh_shenhe.do" method="post">
		<div>		
			<s:token />
			<input type="hidden" name="ydjhsh.bmcode" value="<s:property value="ydjhsh.bmcode" />">
			<input type="hidden" name="ydjhsh.ldcode" value="<s:property value="ydjhsh.ldcode" />">
			<input type="hidden" name="ydjhsh.ssny" value="<s:property value="ydjhsh.ssny" />">
			
			<table id="mytable" style="width:100%;" cellpadding=0 cellspacing=0 >
				<tr>
					<td>
						<div style='height:auto;text-align:center'>
							<input name="ydjhsh.shzt" class="easyui-combobox" data-options="data:[
								{
									text:'审核通过',
									value:'1',
									selected:true
								},
								{
									text:'打回修改',
									value:'2'
								}
							],
							panelHeight:'auto'
							">
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<center style="margin-top:5px;"><a class="easyui-linkbutton" onclick="$('#fmm').submit()" data-options="plain:false">确认</a></center>
	
	<script>
		$("#fmm").form({
			success:function(d){
				var data = eval( "("+d+")");
				if(data.isError){
					parent.$.messager.alert("错误",data.info,"error");
				}
				if(data.isSuccess) {
					parent.$.messager.alert("提示",data.info,"ok");
					parent.gisui.destroyAllWindows();
				}else{
					parent.$.messager.alert("错误",data.info,"error");
				}
			}
		});
	</script>

</body>
</html>