<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="public/head.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/page/gis/map/olapi/popupCss.css" type="text/css">  
<link rel="stylesheet" href="${pageContext.request.contextPath}/page/gis/map/olapi/theme/default/style.css" type="text/css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/page/gis/css/gis.css" type="text/css"> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/olapi/lib/OpenLayers.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/olapi/CSSFramedCloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/js/mapUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/js/map.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/uuid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/gisui2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/mapHelp.js"></script>
<script type="text/javascript">
	var ip = document.location.protocol+"//"+document.location.host + "/hmglyh";
	function switchSysBar(){
		if (document.all("left").style.display!="none"){
			document.all("left").style.display="none";
			document.getElementById("img1").src = ip + "/page/gis/images/side_002.png";
			document.all("expend").style.left="0px";
		}
		else{
			document.all("left").style.display="block";
			document.getElementById("img1").src = ip + "/page/gis/images/side_001.png";
			document.all("expend").style.left="210px";
		}
	}
	function showList(){
		if (document.getElementById("showYxss").src == ip + "/page/gis/images/arrow_001.png"){
			document.all("yxssList").style.display="none";
			document.getElementById("showYxss").src = ip + "/page/gis/images/arrow_002.png";
			document.all("yxssLi").style.height="36px";
		}
		else{
			document.all("yxssList").style.display="block";
			document.getElementById("showYxss").src = ip + "/page/gis/images/arrow_001.png";
			document.all("yxssLi").style.height="148px";
		}
	}
	$(function(){
		$("#jcxxTitle").click(function(){
			$("#jcxx").show();
			$("#ywsj").hide();
			$("#jcxxTitle").removeClass().addClass("libg1");
			$("#ywsjTitle").removeClass().addClass("libg2");
		});
		$("#ywsjTitle").click(function(){
			$("#ywsj").show();
			$("#jcxx").hide();
			$("#ywsjTitle").removeClass().addClass("libg1");
			$("#jcxxTitle").removeClass().addClass("libg2");
		});
		$("#logout").click(function(){
			$.messager.confirm('确认', '确认退出系统？', function(r){
				if(r){
					$.post(ip+"/login/logout.do",function(data) {
						if(data){
							document.location.href = ip + "/index.jsp";
						}
					},'json');
				}
				});
		});
	});
</script>
<style>
        .olPopupContent {
		    overflow: visible !important;
		    padding: 0 !important;
		}
		.olPopup {
		    z-index: 1005 !important;
		}
		.olwidgetPopupContent {
		    background: none repeat scroll 0 0 #FFFFFF;
		    background: rgba(255, 255,255 , 0.80);
		    border-radius:0px;
		    box-shadow: 0 3px 14px rgba(0, 0, 0, 0.35);
		    overflow: auto;
		   /*  padding: 10px 8px 8px; */
		   padding:0px;
		}
		.olwidgetPopupCloseBox {
		    background: url("img/popup_icons.png") no-repeat scroll -80px 0 #FFFFFF;
		    cursor: pointer;
		    height: 0;
		    overflow: hidden;
		    padding-top: 16px;
		    position: absolute;
		    right: 10px;
		    top: 10px;
		    width: 16px;
		}
		.olwidgetPopupCloseBox:hover {
		    background-position: -64px 0;
		}
		
		
		.olHandlerBoxZoomBox{
			background-color:#000;
			border:2px solid #F00;
		}
		
</style>
<title>GIS查询系统</title>
</head>
<body>
	<div id="map" style="min-height:600px;width:100%;position:absolute;top:0px;left:0px"></div>
	<div class="right_menu">
 			<div title="平移" onClick="dragPan(this)" class="right_menu_con right_menu_pingyi"></div>
 			
 			<div title="拉框放大" onClick="zoomInBox(this)" class="right_menu_con right_menu_fangda"></div>
 			
 			<div title="拉框缩小" onClick="zoomOutBox(this)" class="right_menu_con right_menu_suoxiao"></div>
 			
 			<div title="测距" onClick="measureLine(this)" class="right_menu_con right_menu_ceju"></div>
 		
 			<div title="全屏" onClick="zoomToMaxExtent(this)" class="right_menu_con right_menu_quanping"></div>
 			
 			<div title="删除" onClick="clearMap()" class="right_menu_con right_menu_delete"></div>
 	</div>
 	<div class="main_con" id="left">
	<!-- 头部 开始 -->
	<div class="logo"><img src="${pageContext.request.contextPath}/page/gis/images/logo.png" width="210" height="70" border="0"></div>
	<!-- 头部 结束 -->

	<!-- 导航 开始 -->
	<div class="nav">
		<div class="nav_tit">
			<ul>
				 <li class="libg1" id="jcxxTitle"><div class="liimg"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx.png" width="36" height="36" border="0"></div><div class="lifont">基础信息</div></li>
				 <li class="libg2" id="ywsjTitle"><div class="liimg"><img src="${pageContext.request.contextPath}/page/gis/images/nav_ywsj.png" width="36" height="36" border="0"></div><div class="lifont">业务数据</div></li>
			</ul>
		</div>
		<div class="nav_sub" id="jcxx">
			<ul>
				  <li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx_gydw.png" width="18" height="18" border="0"></span><a href="#" onclick="c_guanyangDW();" class="font_a1">管养机构</a></li>
				  <li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx_lx.png" width="18" height="18" border="0"></span><a href="#" onclick="c_luxian();" class="font_a1">路线</a></li>
				  <li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx_gzw.png" width="18" height="18" border="0"></span><a href="#" onclick="c_gouzaowu();" class="font_a1">构造物</a></li>
				  <li id="yxssLi" style="height:145px;">
					  <table width="210" border="0" cellspacing="0" cellpadding="0">
							 <tr>
								 <td style="border-bottom:1px solid #dadbde"><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx_yxss.png" width="18" height="18" border="0"></span><span class="nav_sub_arrow"><img style="cursor:pointer" id="showYxss" onclick="showList();" src="${pageContext.request.contextPath}/page/gis/images/arrow_001.png" width="9" height="9" border="0"></span>沿线设施</td>
							 </tr>
							 <tr id="yxssList">
								 <td style="padding-left:40px;">
									 <table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td><a href="#" onclick="c_jiaotongAQSS();" class="font_a2">·交通安全设施</a></td>
											</tr>
											<tr>
												<td><a href="#" onclick="c_jiaotongGLSS();" class="font_a2">·交通管理设施</a></td>
											</tr>
											<tr>
												<td><a href="#" onclick="c_fuwuSS();" class="font_a2">·服务设施</a></td>
											</tr>
									 </table>
								 </td>
							 </tr>
					  </table>
				  </li>
				  <li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx_lxjc.png" width="18" height="18" border="0"></span><a href="#" onclick="c_luxianJC();" class="font_a1">路线交叉</a></li>
				  <li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx_yjqx.png" width="18" height="18" border="0"></span><a href="#" onclick="c_yingjiQX();" class="font_a1">应急抢险</a></li>
				  <li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_jcxx_qtys.png" width="18" height="18" border="0"></span><a href="#" onclick="c_qitaYS();" class="font_a1">其他要素</a></li>
			</ul>
		</div>
		<div class="nav_sub" id="ywsj" style="display:none;">
			<ul>
				<li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_ywsj_bhyhsj.png" width="18" height="18" border="0"></span><a href="#" onclick="c_binghaiYHSJ();" class="font_a1">巡道病害</a></li>
				<li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_ywsj_wxzy.png" width="18" height="18" border="0"></span><a href="#" onclick="c_weixiuZY();" class="font_a1">维修作业</a></li>
				<li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_ywsj_xcgj.png" width="18" height="18" border="0"></span><a href="#" onclick="c_xunchaGJ();" class="font_a1">巡查轨迹</a></li>
				<li><span class="nav_sub_img"><img src="${pageContext.request.contextPath}/page/gis/images/nav_ywsj_lkzs.png" width="18" height="18" border="0"></span><a href="#" onclick="c_lukuangZS();" class="font_a1">路况评定</a></li>
			</ul>
		</div>
	</div>
	<!-- 导航 结束 -->


	<!-- 底部 开始 -->
	<div class="main_bottom">
	   <table width="210" border="0" cellspacing="0" cellpadding="0">
		   <tr>
			   <td width="122" style="padding-left:20px;"><s:property value="user.ryname" /> ，您好</td>
			   <%-- <td width="34"><a href="#"><img src="${pageContext.request.contextPath}/page/gis/images/password.png" onmouseover="this.src='${pageContext.request.contextPath}/page/gis/images/password_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/page/gis/images/password.png'" width="22" height="22" border="0"></a></td> --%>
			   <%-- <td width="34"><a href="#"><img src="${pageContext.request.contextPath}/page/gis/images/help.png" onmouseover="this.src='${pageContext.request.contextPath}/page/gis/images/help_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/page/gis/images/help.png'" width="22" height="22" border="0"></a></td> --%>
			   <td width="34"><a href="#"><img id="logout" src="${pageContext.request.contextPath}/page/gis/images/exit.png" onmouseover="this.src='${pageContext.request.contextPath}/page/gis/images/exit_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/page/gis/images/exit.png'" width="22" height="22" border="0"></a></td>
		   </tr>
	   </table>
	</div>
	<!-- 底部 结束 -->
    </div>
	<div class="main_side" id="expend"><img src="${pageContext.request.contextPath}/page/gis/images/side_001.png" width="15" height="58" border="0" onclick="switchSysBar();" id="img1" /></div>
 	
 	
 	<div id="p-tools">
		<a href="javascript:void(0)" class="icon-mini-edit" onclick="clearConsole()"></a>
	</div>
	
 	<div id="p-qlcharts">
		<a href="javascript:void(0)" class="icon-mini-edit" onclick="c_qiaoliangCharts()"></a>
	</div>
	
 	<div id="p-sdcharts">
		<a href="javascript:void(0)" class="icon-mini-edit" onclick="c_suidaoCharts()"></a>
	</div>
	
 	<div id="p-hdcharts">
		<a href="javascript:void(0)" class="icon-mini-edit" onclick="c_handongCharts()"></a>
	</div>
	
 	<div id="p-ljcharts">
		<a href="javascript:void(0)" class="icon-mini-edit" onclick="c_lujifhCharts()"></a>
	</div>
	
	<!-- <div id="tabs_tools">
		<a href="javascript:void(0)" class="icon-add" onclick="javascript:alert('add')"></a>
	</div> -->
	
	<div id="lxtools">
		<a href="javascript:void(0)" class="link-button chart" onclick="c_luxianchart()" ></a>
	</div>
	
	<script type="text/javascript">
	 var map;
	 var gisui;
	 function init() {
	     var url = "http://117.145.188.9:9218/hdmapserver/wms";
	     var bounds = new OpenLayers.Bounds(
	    		 73.44127700000004,34.33493400000003,
	    		 97.669512,49.17857400000006
	    		 
	     );
	     var layerName = "xjhmmap";
	     map = new HdMap();
	     map.initMap("map", url,bounds,layerName);
	 } 
		 
     window.onload = function() {
		 init();
		 // 添加 比例尺
		 map.addScaline();
		 gisui = new GisUI({isShowToolBar:false});
	 } 
	 
	
	 
	 function zoomInBox(obj) {
			$(".right_menu_con").removeClass("right_menu_con_selected");
			$(obj).addClass("right_menu_con_selected");
			map.dragPan();
			map.zoomInBox();
			$("#map").css({"cursor":"url('/hmglyh/page/gis/cur/img_bigger.cur'),auto"});
		}

		function zoomOutBox(obj) {
			$(".right_menu_con").removeClass("right_menu_con_selected");
			$(obj).addClass("right_menu_con_selected");
			map.dragPan();
			map.zoomOutBox();
			$("#map").css({"cursor":"url('/hmglyh/page/gis/cur/img_smaller.cur'),auto"});
		}

		function measureLine(obj) {
			$(".right_menu_con").removeClass("right_menu_con_selected");
			$(obj).addClass("right_menu_con_selected");
			map.dragPan();
			map.measureLine();
			$("#map").css({"cursor":"url('/hmglyh/page/gis/cur/img_ceju.cur'),auto"});
		}
		
		function dragPan(obj) {
			$(".right_menu_con").removeClass("right_menu_con_selected");
			map.dragPan();
			$("#map").css({"cursor":"url('http://webmap0.map.bdimg.com/image/api/openhand.cur'),auto"});
		}

		function zoomToMaxExtent(obj) {
			$(".right_menu_con").removeClass("right_menu_con_selected");
			map.dragPan();
			//map.zoomToMaxExtent();
			map.map.setCenter(new OpenLayers.LonLat(85.016870579896,44.553373664609),7);
			$("#map").css({"cursor":"url('http://webmap0.map.bdimg.com/image/api/openhand.cur'),auto"});
		}
		
		function clearMap(){
			gisui.destroyAllWindows();
			$("#map").css({"cursor":"url('http://webmap0.map.bdimg.com/image/api/openhand.cur'),auto"});
		}

		
		function openDebugbox(){
			gisui.createWindow({
				id:"debugbox",
				title:"调试窗口",
				width:300,
				height:500,
				tabs:{
					tabs:[{
								title:"窗口操作",
								src:"${pageContext.request.contextPath}/gis/debug_ui.do"
							},
							{
								title:"地图操作",
								src:"${pageContext.request.contextPath}/gis/debug_map.do"
								},
							{
							id:"console",
							title:"控制台",
							src:"${pageContext.request.contextPath}/gis/debug_console.do",
							tools:'#p-tools'
							}
						]
				}
				
			});
		}
		
		/*ddsmoothmenu.init({
			mainmenuid: "indexMenu", //Menu DIV id
			orientation: 'v', //Horizontal or vertical menu: Set to "h" or "v"
			classname: 'ddsmoothmenu-v', //class added to menu's outer DIV
		/* 	customtheme: ["#ffffff", "#000000"], */
			/*contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
		});*/
		
		
	</script>
</body>
</html>
