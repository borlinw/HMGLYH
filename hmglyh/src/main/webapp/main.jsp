<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>哈密公路养护综合管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script language="javascript">
var getLoginUserObject = new Object();//用于存储登陆用户的信息
var loginUserStr = "";//用户信息String
var encodeLoginUserStr = "";//转码后的用户信息String
$(function(){
	YMLib.UI.MaskShow("请求用户信息...");
	YMLib.Ajax.GET("login/userLoginAuthor.do?_="+Math.random(),"","json",function(msg){
		if(msg.state === false){
			document.location.href = "index.jsp";
		}else{
			getLoginUserObject = msg;
			loginUserStr = JSON.stringify(getLoginUserObject);
			encodeLoginUserStr = encodeURIComponent(encodeURIComponent(loginUserStr));
			//alert("loginUserStr="+loginUserStr+"，encodeLoginUserStr="+encodeLoginUserStr);
			YMLib.UI.MaskHide();
			YMLib.UI.Show("登录成功！",3000);
		}
	},function(e){
		alert("验证登陆与请求权限 login/userLoginAuthor.do 出错");
		YMLib.UI.MaskHide();
	});
});
</script>
</head>
<body>
<div class="top"></div>
<!-- 头部 开始 -->
<div class="logo"><img src="images/index_logo_hm.png" width="440" height="77" border="0"></div>
<!-- 头部 结束 -->

<!-- 内容 开始 -->
<div class="main">
	<ul>
		<li><a href="${pageContext.request.contextPath}/rcyh/home_index.do" target="_blank"><img src="images/index_006.png" onmouseover="this.src='images/index_006hover.png'" onmouseout="this.src='images/index_006.png'" width="248" height="200" border="0"/></a></li>
		<li><img src="images/index_002.png" width="248" height="200" border="0"/></li>
		<li><a href="${pageContext.request.contextPath}/gis/index.do" target="_blank"><img src="images/index_001.png" onmouseover="this.src='images/index_001hover.png'" onmouseout="this.src='images/index_001.png'" width="248" height="200" border="0"/></a></li>
		<li style="margin-right:0;"><img src="images/index_004.png" width="248" height="200" border="0"/></li>
		<li><img src="images/index_005.png" width="248" height="200" border="0"/></li>
		<li><a href="page/lkpd/index.jsp" target="_blank"><img src="images/index_003.png" onmouseover="this.src='images/index_003hover.png'" onmouseout="this.src='images/index_003.png'" width="248" height="200" border="0"/></a></li>
		<li><img src="images/index_007.png" width="248" height="200" border="0"/></li>
		<li style="margin-right:0;"><a href="${pageContext.request.contextPath}/htgl/index.do" target="_blank"><img src="images/index_008.png" onmouseover="this.src='images/index_008hover.png'" onmouseout="this.src='images/index_008.png'" width="248" height="200" border="0"/></a></li>
	</ul>
</div>
<!-- 内容 结束 -->

<!-- 版权 开始 -->
<div class="foot">
	<!-- 版权所有：哈密公路管理局 　　　　技术支持：北京恒达时讯科技开发有限责任公司 -->
	<!-- <center><font style="font-size:12px;color:#FFF;">哈密公路管理局　版权所有　　　技术支持：北京恒达时讯科技开发有限责任公司</font></center> -->
	哈密公路管理局　版权所有　　　技术支持：北京恒达时讯科技股份有限公司
</div>

<!-- 版权 结束 -->

<script type="text/javascript">
	$(".top").css("height",(document.documentElement.clientHeight-536)/2+"px");//计算总屏的高度
</script>
	<%-- <div id="hrefDiv">
		<h1><a href="${pageContext.request.contextPath}/rcyh/home_index.do" >日常养护管理系统</a><br/></h1>
		<h1><a href="${pageContext.request.contextPath}/gis/index.do" >GIS查询系统</a><br/></h1>
		<h1><a href="page/lkpd/index.jsp" >路况评定管理系统</a><br/></h1>
		<!-- <h1><a href="page/htgl/index.jsp" >统一权限管理系统</a></h1> -->
		<h1><a href="${pageContext.request.contextPath}/htgl/index.do" >统一权限管理系统</a></h1>
	</div> --%>
</body>
</html>
