<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>除雪汇总表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" src="./js/page.js"></script>
<script>
$(function(){
	var username = "";
	var bmcode = "";
	var bbid = "";
	var ssj = "";//版本中的起始时间
	var esj = "";//版本中的结束时间
	var wd = "";//起始时间-结束时间
	//获取用户信息
	$.ajax({
		url:"/hmglyh/login/userLoginAuthor.do",
		async:false,
		dataType:"json",
		success:function(data){
			bmcode = data.bmcode;
			username = data.username;
			//$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=cxhzb.cpt&bmcode="+data.bmcode+"&username="+data.username+"&op=write");
		}
	});
	//查询
	$("#query").click(function(){
		//alert("bmcode="+bmcode+"，bbid="+bbid);
		if(bbid != ""){
			if(bmcode.length == 6){//分局单位，具有填报权限，需要验证下是否已经填报
				//alert("分局部门：具有填报权限");
				$.ajax({
					url:"/hmglyh/rcyh/cxbbb_queryCxnbByBBIDAndBmcode.do?bbid="+bbid,
					async:false,
					dataType:"json",
					success:function(result){
						/* alert("请求是否已存在除雪年报数据result="+result); */
						if(result){
							$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=NEWcxhzbView.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj);
							$("#edit").show();
							//$("#reportFrame").attr("src","http://localhost:8075/WebReport/ReportServer?reportlet=NEWcxhzbView.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj+"&op=write");
							//$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=NEWcxhzbEdit.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj+"&op=write");
						}else if(!result){
							$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=NEWcxhzb.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj+"&op=write");
							//$("#reportFrame").attr("src","http://localhost:8075/WebReport/ReportServer?reportlet=NEWcxhzb.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj+"&op=write");
						}else{
							YMLib.UI.Show("数据请求错误（cxbbb_queryCxnbByBBIDAndBmcode.do），请刷新后重试。",1500);
						}
					}
				});
			}else{
				if(bmcode.length > 6){
					//alert("分局下部门：具有查看权限。");
					bmcode = bmcode.substr(0 , 6);
				} 
				$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=NEWcxhzbView.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj);
				//$("#reportFrame").attr("src","http://localhost:8075/WebReport/ReportServer?reportlet=NEWcxhzbView.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj);
			}
		}else{
			YMLib.UI.Show("请选择版本。",1500);
		}
	});
	$("#edit").click(function(){
		$("#reportFrame").attr("src",YMLib.reportUrl+"reportlet=NEWcxhzbEdit.cpt&bmcode="+bmcode+"&bbid="+bbid+"&username="+username+"&ssj="+ssj+"&esj="+esj+"&op=write");
	});
	//加载“除雪版本”Combotree
	$("#chooseCxbb").combobox({
		url : YMLib.url + "rcyh/cxbbb_createCxbbCombobox.do",
		valueField : 'id',
		textField : 'text',
		editable : false,//在这里加显示combobox不能编辑的属性
		panelHeight : 170,
		value : "-请选择版本-",
	    onSelect : function(record){
	    	//alert("record.id="+record.id);
	    	bbid = record.id;
	    	ssj = record.ssjStr;
	    	esj = record.esjStr;
	    	wd = record.ssjStr+"-"+record.esjStr;
	    	$("#edit").hide();
	    	//alert("record.ssjStr="+record.ssjStr+"，record.esjStr="+record.esjStr+"，整合之后：wd="+wd);
		}
	});
});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:false" style="height:68px;border-left:0px;border-right:0px;border-top:0px">
		<div class="top_div_lr" >当前位置：&nbsp;日常养护管理系统&nbsp;&gt;&nbsp;<font id="djcxHome" style="cursor:pointer;" >冬季除雪</font>&nbsp;&gt;&nbsp;除雪汇总表</div>		
		<div>
			<table>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;版本：</td>
					<td><select class="easyui-combobox" id="chooseCxbb" style="width:150px"></select></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查询</a>
					&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="edit" style="display:none;">编辑</a></td>
				</tr>
			</table>
		</div>
	</div>
	<div data-options="region:'center',border:false" style="border-left:0px;border-right:0px;border-button:0px;overflow:hidden;">
		<iframe id="reportFrame" style="width:100%;height:100%;border:0px" ></iframe>
	</div>
</body>
</html>