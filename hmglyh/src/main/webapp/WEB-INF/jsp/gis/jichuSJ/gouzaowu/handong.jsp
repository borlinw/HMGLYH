<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<title>涵洞</title>
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
		
		if( num == 3 ) {
			var c = $("#chart2");
			c.attr("src",c.attr("mysrc"));
		}
		
		
		
	}
	</script>
	<div class='paddingbar'></div>
	<div class="tabs_container"> 
			<div class="tabs_menu">				
				<a href="#" onclick='changeTabs(this,1)' class="myeasyui-linkbutton tabs_tab1 tabs_tab tabs_tab_selected" data-options="plain:true,toggle:true,selected:true">涵洞列表</a>
		  		<!-- <a href="#" onclick='changeTabs(this,2)' class="myeasyui-linkbutton tabs_tab2 tabs_tab" data-options="plain:true,toggle:true">涵洞类型</a> -->
<!-- 		  		<a href="#" onclick='changeTabs(this,3)' class="easyui-linkbutton tabs_tab2 tabs_tab" data-options="plain:true,toggle:true">涵洞跨径分类</a> -->
			</div>
			<div class="tabs_content">
				<div  class="tabs_item1 tabs_item tabs_item_selected">
					<iframe id="liebiao" style="border:none;padding:0px;margin:0px;" height=100%  width=100% mysrc="${pageContext.request.contextPath}/gis/gouzaowu_handonglb.do?hd.roadcode=<s:property value='hd.roadcode'/>&hd.bmcode=<s:property value="hd.bmcode" />&fromHd=<s:property value="fromHd" />&fromLx=<s:property value="fromLx" />&fromBm=<s:property value="fromBm" />" ></iframe>
				</div>
				<div  class="tabs_item2 tabs_item">
					<iframe id="chart1" style="border:none;padding:0px;margin:0px;" height=100%  width=100% mysrc="${pageContext.request.contextPath}/gis/gouzaowu_hdlx_pre.do?roadcodes=<s:property value='hd.roadcode'/>&fromHd=<s:property value="fromHd" />&fromLx=<s:property value="fromLx" />"></iframe>
				</div>
				<div class="tabs_item3 tabs_item">
					<iframe id="chart2"  style="border:none;padding:0px;margin:0px;" height=100%  width=100% mysrc="${pageContext.request.contextPath}/gis/gouzaowu_hdkjfl_pre.do?roadcodes=<s:property value='hd.roadcode'/>&fromHd=<s:property value="fromHd" />&fromLx=<s:property value="fromLx" />"></iframe>
				</div>
			</div>
	</div>
	<%@ include file="../../public/bottom.jsp"%>
</body>
</html>