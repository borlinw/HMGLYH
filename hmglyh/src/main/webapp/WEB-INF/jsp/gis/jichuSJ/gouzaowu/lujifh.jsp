<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<title>路基防护</title>
</head>
<body>
	<script>
	function changeTabs(obj,num) {
		$(".tabs_tab").removeClass("tabs_tab_selected");
		$(obj).addClass("tabs_tab_selected");
		$(".tabs_item").hide();
		$(".tabs_item"+num).show();
		var roadcode = getQuery("roadcode");
		
		if(num == 1) {
			var lb = $("#liebiao");
			lb.attr("src",lb.attr("mysrc"));
		}
		
		if( num == 2 ) {
			var c = $("#chart1");
			c.attr("src",c.attr("mysrc"));
		}		
	}
	</script>
	<div class='paddingbar'></div>
	<div class="tabs_container"> 
			<div class="tabs_menu">				
				<a href="#" onclick='changeTabs(this,1)' class="myeasyui-linkbutton tabs_tab1 tabs_tab tabs_tab_selected" data-options="plain:true,toggle:true,selected:true">路基防护列表</a>
		  		<a href="#" onclick='changeTabs(this,2)' class="myeasyui-linkbutton tabs_tab2 tabs_tab" data-options="plain:true,toggle:true">路基防护类型</a>
			</div>
			<div class="tabs_content">
				<div  class="tabs_item1 tabs_item tabs_item_selected">
					<iframe id="liebiao" style="border:none;padding:0px;margin:0px;" height=100%  width=100% mysrc="${pageContext.request.contextPath}/gis/gouzaowu_lujifhlb.do?lj.bmcode=<s:property value="lj.bmcode" />&lj.roadcode=<s:property value='lj.roadcode'/>&fromLx=<s:property value="fromLx" />&fromLj=<s:property value="fromLj" />&fromBm=<s:property value="fromBm" />" ></iframe>
				</div>
				<div  class="tabs_item2 tabs_item">
					<iframe id="chart1" style="border:none;padding:0px;margin:0px;" height=100%  width=100% mysrc="${pageContext.request.contextPath}/gis/gouzaowu_ljfhlx_pre.do?roadcodes=<s:property value='lj.roadcode'/>&fromLx=<s:property value="fromLx" />&fromLj=<s:property value="fromLj" />"></iframe>
				</div>
			</div>
	</div>
	<%@ include file="../../public/bottom.jsp"%>
</body>
</html>