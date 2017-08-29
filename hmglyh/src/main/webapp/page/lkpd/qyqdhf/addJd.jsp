<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加节点</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript">
var Delete = function(_obj){
	$(_obj).parent().parent().remove();
};
$(function(){
	if(parent.jd != null && parent.jd != ""){
		var list = parent.jd.split('-');
		for(var i=0;i<list.length;i++){
			var html = "<tr><td><input type='hidden' name='jd' value='"+list[i]+"'/>"+list[i]+"</td>"+
					"<td><a href='javascript:void(0)' class='easyui-linkbutton' plain='true' onClick='Delete(this)'>删除</a></td></tr>";
			$("#button").before(html);
		}
	}
	$("#pos").numberbox({
		max : parent.jdEnd,
		min : parent.jdStart,
		precision : 3
	});
	$("#add").click(function(){
		if($("#pos").numberbox("getValue") != ""){
			var html = "<tr><td><input type='hidden' name='jd' value='"+$("#pos").numberbox("getValue")+"'/>"+$("#pos").numberbox("getValue")+"</td>"+
					"<td><a href='javascript:void(0)' class='easyui-linkbutton' plain='true' onClick='Delete(this)'>删除</a></td></tr>";
			$("#button").before(html);
		}else{
			YMLib.UI.Show("请输入桩号",2000);
		}
	});
	$("#cancle").click(function(){
		parent.$("#addJd").window("close");
	});
	$("#ok").click(function(){
		parent.jd = $("#myForm").serialize().replace(/&/g,'-').replace(/jd=/g,'');
		parent.jdState = true;
		parent.$("#addJd").window("close");
	});
});
</script>
</head>
<body>
	<form id="myForm">
		<table width="100%">
			<tr>
				<td><input class="easyui-numberbox" id="pos" style="width:50px;"/></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="add">添加</a></td>
			</tr>
			<tr id="button">
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="ok">确定</a></td>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="cancle">取消</a></td>
			</tr>
		</table>
	</form>
</body>
</html>