<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rcyh.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/left.js"></script>
<script>
/* var checkedMenuid = "rcyhYhbg";//记录被点击的div的ID

$(function(){
	//养护办公
	$("#rcyhYhbg").click(function(){
		$("#rcyhYhbg").removeClass("rcyhyhbg");
		$("#rcyhYhbg").addClass("rcyhyhbg2");
		restoreMenu("rcyhYhbg");//参数为当前点击的menu的id
	});
	//月度计划
	$("#rcyhYdjh").click(function(){
		$("#rcyhYdjh").removeClass("rcyhydjh");
		$("#rcyhYdjh").addClass("rcyhydjh2");
		restoreMenu("rcyhYdjh");//参数为当前点击的menu的id
	});
	//冬季除雪
	$("#rcyhDjcx").click(function(){
		$("#rcyhDjcx").removeClass("rcyhdjcx");
		$("#rcyhDjcx").addClass("rcyhdjcx2");
		restoreMenu("rcyhDjcx");//参数为当前点击的menu的id
	});
	//查询统计
	$("#rcyhCxtj").click(function(){
		$("#rcyhCxtj").removeClass("rcyhcxtj");
		$("#rcyhCxtj").addClass("rcyhcxtj2");
		restoreMenu("rcyhCxtj");//参数为当前点击的menu的id
	});
	//维修整改
	$("#rcyhWxzg").click(function(){
		$("#rcyhWxzg").removeClass("rcyhwxzg");
		$("#rcyhWxzg").addClass("rcyhwxzg2");
		restoreMenu("rcyhWxzg");//参数为当前点击的menu的id
	});
	//考勤工资
	$("#rcyhKqzg").click(function(){
		$("#rcyhKqzg").removeClass("rcyhkqgz");
		$("#rcyhKqzg").addClass("rcyhkqgz2");
		restoreMenu("rcyhKqzg");//参数为当前点击的menu的id
	});
	//年度学习
	$("#rcyhNdxx").click(function(){
		$("#rcyhNdxx").removeClass("rcyhndxx");
		$("#rcyhNdxx").addClass("rcyhndxx2");
		restoreMenu("rcyhNdxx");//参数为当前点击的menu的id
	});
});

//还原某被选中的menu（参数为此次被选中的id）
function restoreMenu(_menuId){
	if(checkedMenuid != ""){
		if(checkedMenuid == "rcyhYhbg"){//养护办公
			$("#rcyhYhbg").removeClass("rcyhyhbg2");
			$("#rcyhYhbg").addClass("rcyhyhbg");
		}else if(checkedMenuid == "rcyhYdjh"){//月度计划
			$("#rcyhYdjh").removeClass("rcyhydjh2");
			$("#rcyhYdjh").addClass("rcyhydjh");
		}else if(checkedMenuid == "rcyhDjcx"){//冬季除雪
			$("#rcyhDjcx").removeClass("rcyhdjcx2");
			$("#rcyhDjcx").addClass("rcyhdjcx");
		}else if(checkedMenuid == "rcyhCxtj"){//查询统计
			$("#rcyhCxtj").removeClass("rcyhcxtj2");
			$("#rcyhCxtj").addClass("rcyhcxtj");
		}else if(checkedMenuid == "rcyhWxzg"){//维修整改
			$("#rcyhWxzg").removeClass("rcyhwxzg2");
			$("#rcyhWxzg").addClass("rcyhwxzg");
		}else if(checkedMenuid == "rcyhKqzg"){//考勤工资
			$("#rcyhKqzg").removeClass("rcyhkqgz2");
			$("#rcyhKqzg").addClass("rcyhkqgz");
		}else if(checkedMenuid == "rcyhNdxx"){//年度学习
			$("#rcyhNdxx").removeClass("rcyhndxx2");
			$("#rcyhNdxx").addClass("rcyhndxx");
		}
	}
	checkedMenuid = _menuId;
} */

</script>
</head>
<body style="background-color:#D7F3F7;border-right: 2px solid #70d2e0;overflow-x: hidden;float: right;" >
	<ul>
		<s:iterator value="menus" id="auth" status="status" >
			<li style="list-style-type:none;" >
				<a href="${pageContext.request.contextPath}<s:property value="#auth.url" />" target="mainFrame">
					<s:if test='#auth.mkname=="养护办公"'>
						<div id="rcyhYhbg" class="rcyhyhbg2" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
					<s:if test='#auth.mkname=="月度计划"'>
						<div id="rcyhYdjh" class="rcyhydjh" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
					<s:if test='#auth.mkname=="冬季除雪"'>
						<div id="rcyhDjcx" class="rcyhdjcx" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
					<s:if test='#auth.mkname=="查询统计"'>
						<div id="rcyhCxtj" class="rcyhcxtj" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
					<s:if test='#auth.mkname=="维修整改"'>
						<div id="rcyhWxzg" class="rcyhwxzg" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
					<s:if test='#auth.mkname=="考勤工资"'>
						<div id="rcyhKqzg" class="rcyhkqgz" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
					<s:if test='#auth.mkname=="年度学习"'>
						<div id="rcyhNdxx" class="rcyhndxx" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
					<s:if test='#auth.mkname=="除雪版本"'>
						<div id="rcyhCxbb" class="rcyhcxbb" onclick="$('mainFrame').attr('src','${pageContext.request.contextPath}<s:property value="#auth.url" />')" style="cursor:pointer;padding-left:60px" ><s:property value="#auth.mkname" /></div>
					</s:if>
				</a>
				<%-- <a href="${pageContext.request.contextPath}<s:property value="#auth.url" />" target="mainFrame">
					<s:property value="#auth.mkname" />
				</a> --%>
			</li>
		</s:iterator>
	</ul>
</body>
</html>
