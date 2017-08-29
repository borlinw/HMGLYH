<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>区段划分审核</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript">
	$(function(){
		$("#check").click(function(){
			var params = "bmCode="+parent.currentGridRows.bmCode+"&bbid="+parent.currentGridRows.bbid+"&shzt="+$("#shzt").combobox("getValue")+"&shry="+window.top.loginUserObject.username;
			YMLib.Ajax.POST("qdhfshb/check.do",params,"json",function(result){
				if(result){
					YMLib.UI.Show("审核成功",2000);
					parent.$("#myGrid").datagrid("reload");
					parent.$("#check").window("close");
				}else{
					YMLib.UI.Show("审核失败",2000);
				}
			});
		});
	});
</script>
</head>
<body>
	<table align="center" border="0">
		<tr>
			<td>
				<select id="shzt" class="easyui-combobox" panelHeight="auto">
					<option value="1">审核通过</option>
					<option value="2">打回修改</option>
				</select>
			</td>
		</tr>
		<tr>
			<td style="text-align:center;">
				<a class="easyui-linkbutton" plain="true" id="check" href="javascript:void(0)">审核</a>
			</td>
		</tr>
	</table>
</body>
</html>