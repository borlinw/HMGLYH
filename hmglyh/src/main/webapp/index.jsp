<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新疆维吾尔自治区哈密公路局公路养护综合管理系统--登录</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" language="javascript" src="js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="js/login.js"></script>
</head>
<body>
<div class="top"></div>
<div class="bk">
	<div class="main">
		<!-- 左侧 开始 -->
		<div class="left">
			<div class="left_con"><img src="images/login_logo_hm.png" width="502" height="88" border="0"></div>
		</div>
		<!-- 左侧 结束 -->
		
		<!-- 右侧 开始 -->
		<div class="right">
			<div class="right_con">
				<ul>
					</br>
					<li><input type="text" id="username" style="color:black;" class="name" autofocus /></li>
					<li><input type="password" id="pw" style="color:black;" class="password" /></li>
					<li id="prompt1" style="display:none" ><span class="ts">请填写密码！</span></li>
					<li id="prompt2" style="display:none" ><span class="ts">用户名/密码错误！</span></li>
					<li>
					<input id="userLogin" type="submit" name="button" value="登录" class="login_button" />
					</li>
				</ul>
			</div>
		</div>
		<!-- 右侧 结束 -->
	</div>
</div>

<script type="text/javascript">
	$(".top").css("height",(document.documentElement.clientHeight-400)/2+"px");//计算总屏的高度
</script>

</body>
</html>