<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<title>路线专题图</title>
</head>
<body>
	<script>
	function changeTabs(obj,num) {
		$(".tabs_tab").removeClass("tabs_tab_selected");
		$(obj).addClass("tabs_tab_selected");
		$(".tabs_item").hide();
		$(".tabs_item"+num).show();
		
		if( num == 1 ) {
			$("#chart1").find("iframe").attr("src","${pageContext.request.contextPath}/gis/gouzaowu_hdkjfl.do");
		}
		
		if(num == 2 ) {
			$("#chart2").find("iframe").attr("src","${pageContext.request.contextPath}/gis/gouzaowu_hdkjfl2.do");
		}
		
	}
	
	window.onload = function(){
		$("#chart1").find("iframe").attr("src","${pageContext.request.contextPath}/gis/gouzaowu_hdkjfl.do");
	}
	
	</script>
	<div class='paddingbar'></div>
	<div class="tabs_container"> 
			<div class="tabs_menu">				
				<a href="#" onclick='changeTabs(this,1)' class="myeasyui-linkbutton tabs_tab1 tabs_tab tabs_tab_selected" data-options="plain:true,toggle:true,selected:true">涵洞跨径分类(全部路线)</a>
		  		<a href="#" onclick='changeTabs(this,2)' class="myeasyui-linkbutton tabs_tab2 tabs_tab" data-options="plain:true,toggle:true">涵洞跨径分类(每条路线)</a>
			</div>
			<div class="tabs_content">
				<div id="chart1" class="tabs_item1 tabs_item tabs_item_selected">
					<iframe style="border:none;padding:0px;margin:0px;" height=100%  width=100% ></iframe>
				</div>
				<div id="chart2" class="tabs_item2 tabs_item">
					<iframe style="border:none;padding:0px;margin:0px;" height=100%  width=100% ></iframe>
				</div>
				
			</div>
	</div>
</body>
</html>