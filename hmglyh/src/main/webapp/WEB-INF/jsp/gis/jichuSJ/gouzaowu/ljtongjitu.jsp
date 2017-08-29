<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/gouzaowu/suidao.js"></script>
<title>路基防护</title>
</head>
<body>
	<div class='paddingbar'></div>
	<div class="tabs_container"> 
			<div class="tabs_menu">				
		  		<a href="#" onclick='changeTabs(this,1)' class="myeasyui-linkbutton tabs_tab2 tabs_tab" data-options="plain:true,toggle:true">按防护类型统计</a>
				<a href="#" onclick='changeTabs(this,2)' class="myeasyui-linkbutton tabs_tab2 tabs_tab" data-options="plain:true,toggle:true">按防护类型(每条路线)</a>
			</div>
			<div class="tabs_content">
				<div id="chart1" class="tabs_item1 tabs_item">
					<iframe style="border:none;padding:0px;margin:0px;" height=100%  width=100% src="${pageContext.request.contextPath}/gis/gouzaowu_ljfhlx.do" ></iframe>
				</div>
				<div id="chart2" class="tabs_item2 tabs_item">
					<iframe style="border:none;padding:0px;margin:0px;" height=100%  width=100% src="${pageContext.request.contextPath}/gis/gouzaowu_ljfhlx2.do" ></iframe>
				</div>
			</div>
	</div>
</body>
</html>