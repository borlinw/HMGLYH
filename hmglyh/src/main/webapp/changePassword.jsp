<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>哈密公路养护综合管理系统 - 修改密码</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript">
$(function(){
	$("#initBtnSave").click(function () {
		var oldpassword = $("#oldpassword").val();
		var newpassword = $("#pwd").val();
		if ($("#changePassword").form("validate")) {
			$.ajax({
	    		url: YMLib.url + "login/changePassword.do?pw="+oldpassword+"&newpw="+newpassword,
	    		type:"post",
	    		dataType: "text",
	    		success: function(result) {
	    			//alert("请求成功，返回值为：result="+result);
	    			if(result == "ok"){
	    				YMLib.UI.MaskHide();
	    				window.top.YMLib.UI.Show("修改密码成功。",1500);
	    				parent.$("#edit").window("close");
	    			}else if(result == "no"){
	    				window.top.YMLib.UI.Show("原始密码错误。",1500);
	    			}else{
	    				window.top.YMLib.UI.Show("修改密码失败，请重新登录后再试。",1500);
	    			}
	    		},
	    		error:function(result){
	    			alert("ajax请求失败，请重新登录后再试！");
	    		}
	    	});
		}else{
			YMLib.UI.Show("两次密码不一致。",1000);
		}
	});
});
var A = function(_result){
	 if(_result){
			YMLib.UI.MaskHide();
			window.top.YMLib.UI.Show("修改密码成功。",1500);
			parent.$("#edit").window("close");
		}else{
			YMLib.UI.Show("修改密码失败！",1500);
		}
};
</script>
</head>
<body>
    <div id="passPwd" title="修改密码" style="padding:0px;margin:0px; overflow:hidden;"  data-options="closed:true,iconCls:'check'">
        <form id="changePassword">
	        <table class="tableform" border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
	            <tr>
					<td style="text-align:right">原始密码：</td>
					<td class="left">&nbsp;<input id="oldpassword" type="password" class="easyui-validatebox" data-options="required:true" /></td>
				</tr>
	            <tr>
					<td style="text-align:right">新的密码：</td>
					<td class="left">&nbsp;<input id="pwd" type="password" class="easyui-validatebox" validType="length[6,12]" data-options="required:true" /></td>
				</tr>
				<tr>
					<td style="text-align:right">重复密码：</td>
					<td class="left">&nbsp;<input id="rpwd" type="password" class="easyui-validatebox" required="required" validType="equalTo['#pwd']" /> </td>
				</tr>
	        </table>
        </form>
        <div style="margin-top:15px;text-align: center;"><a id='initBtnSave' class='easyui-linkbutton' plain='true' >修改密码</a></div>
    </div>
</body>
</html>