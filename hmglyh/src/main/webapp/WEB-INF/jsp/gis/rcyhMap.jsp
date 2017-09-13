<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="public/head.jsp"></jsp:include>
<link rel="stylesheet" href="${pageContext.request.contextPath}/page/gis/map/olapi/popupCss.css" type="text/css">  
<link rel="stylesheet" href="${pageContext.request.contextPath}/page/gis/map/olapi/theme/default/style.css" type="text/css">  
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/olapi/lib/OpenLayers.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/olapi/CSSFramedCloud.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/js/mapUtils.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/map/js/map.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/mapHelp.js"></script>
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
		
		
		.menuContainer {
			position:absolute;
			left:30px;
			top:40px;
			z-index:1000
		}
		
		.olHandlerBoxZoomBox{
			background-color:#000;
			border:2px solid #F00;
		}
		
</style>
<title>哈密GIS系统</title>
</head>
<body>
	<div id="map"></div>
	<div class="right_menu">
 			<div title="平移" onClick="dragPan(this)" class="right_menu_con right_menu_pingyi"></div>
 			
 			<div title="拉框放大" onClick="zoomInBox(this)" class="right_menu_con right_menu_fangda"></div>
 			
 			<div title="拉框缩小" onClick="zoomOutBox(this)" class="right_menu_con right_menu_suoxiao"></div>
 			
 			<div title="测距" onClick="measureLine(this)" class="right_menu_con right_menu_ceju"></div>
 		
 			<div title="全屏" onClick="zoomToMaxExtent(this)" class="right_menu_con right_menu_quanping"></div>
 			
 			<div title="删除" onClick="clearMap()" class="right_menu_con right_menu_delete"></div>
 	</div>	
	<script type="text/javascript">
	 var map;
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
		 addPointFromParent();
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
		
		/* var columns = [[
							{field:'jlusername',title:'记录人用户名',width:100},
							{field:'bmcode',title:'部门编码',width:100},
							{field:'ldcode',title:'路段编码',width:100},
							{field:'tq',title:'方向',width:100},
							{field:'szhhkm',title:'起点桩号（千米）',width:100},
							{field:'szhhm',title:'起点桩号（米）',width:100},
							{field:'ezhhkm',title:'止点桩号（千米）',width:100},
							{field:'ezhhm',title:'止点桩号（米）',width:100},
							{field:'wzbc',title:'位置补充',width:100},
							{field:'sl',title:'数量',width:100},
							{field:'bz',title:'备注',width:100}
		                ]]; */
		
		function getBhImg(rowData){
			if( rowData.bhwxzt == "已维修" ){
				return "/hmglyh/page/gis/mapimg/bh1.png";
			}else{
				return "/hmglyh/page/gis/mapimg/bh2.png";
			}
		}
		
		function getWxzyImg(rowData){
			if(rowData.yszt == "未验收" ) {
				return "/hmglyh/page/gis/mapimg/wxzy1.png";
			}else if(rowData.yszt == "已验收" ) {
				return "/hmglyh/page/gis/mapimg/wxzy2.png";
			}else{
				return "/hmglyh/page/gis/mapimg/wxzy3.png";
			}
		}
	
		function addPointFromParent(){
			
			var p = null;
			
			if(parent.$(".mapParentWindow") && parent.$(".mapParentWindow")[0]) {
				p = parent.$(".mapParentWindow")[0].contentWindow;
			}else{
				p = parent;
			}
			
			var imgfuc;
			
			if(getQuery("isBh") == true){
				imgfuc = getBhImg;
			}else{
				imgfuc = getWxzyImg;
			}
			
			var rows =p.$("#dg").datagrid("getSelections");
			var columns = p.$("#dg").datagrid("options").columns;
			if( rows.length  == 0 ) return;
			var points = [];
			$.each(rows,function(i,d){
				points.push({
					roadcode:d.ldcode,
					zh:d.szhhkm + d.szhhm / 1000,
					imgpath:imgfuc(d),
					popup:{
						title:"详情",
						rowData:d,
						columns:columns
					}
				});
			});
		//	console.log(points);
			map.addPointByZh(points);
		}
		
	</script>
</body>
</html>