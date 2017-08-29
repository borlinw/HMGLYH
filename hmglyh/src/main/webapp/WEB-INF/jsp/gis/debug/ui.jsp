<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<title>界面调试</title>
</head>
<body style="width:100%;height:100%;overflow-y:auto;overflow-x:hidden;padding:0px;margin:0px;">	
	<div id="debugboxContainer">
		<div id="mydemo" style="overflow-y:auto;font-size:10px;">
		
			<h4>外观：</h4><br>
			<a href='${pageContext.request.contextPath}/gis/setTheme.jsp?theme=black'>黑色主题</a>
			<a href='${pageContext.request.contextPath}/gis/setTheme.jsp?theme=bootstrap'>bootstrap</a>
			<a href='${pageContext.request.contextPath}/gis/setTheme.jsp?theme=gray'>gray</a> <br>
			<a href='${pageContext.request.contextPath}/gis/setTheme.jsp?theme=metro'>metro</a>
			<a href='${pageContext.request.contextPath}/gis/setTheme.jsp?theme=default'>默认主题</a><br><br>
			<a href='${pageContext.request.contextPath}/gis/setTheme.jsp?theme=hdstyle'>江西更改</a><br><br>
			
			<h4>窗口操作：</h4><br>
			<span>窗口ID:</span><input id="minwindowbyid" style="width:80px;" /> <input type="button" value="最小化" onclick="minWindowById()" ><br>
			<span>窗口ID:</span><input id="deswindowbyid" style="width:80px;" /> <input type="button" value="销毁" onclick="desWindowById()" ><br><br>
			<input type="button" value="最小化所有" onclick="minAllWindow()" ><br>
			<input type="button" value="销毁所有" onclick="desAllWindow()" ><br>
			<input type="button" value="重新排列窗口" onclick="top.gisui.replaceTable()" /><br>
			<input type="button" value="平铺窗口" onclick="top.gisui.replaceTableH()" />
			<br>
			<span>窗口定义代码:</span><br>
			<textarea id="createid" cols="30" rows="5">
				{
				title:"你好",
				src:"https://www.baidu.com",
				width:700,
				height:400
				}
			</textarea><br>
			<input type="button" value="创建窗口" onclick="createWindowByJson()">	
		</div>
	</div>
	
	
	<script>
		
		//清空 控制台
		function cleardebug(){
			$("#debugbox").html("");
		}
		
		// 根据窗口的ID 最小化窗口
		function minWindowById(){
			var id = $("#minwindowbyid").val();
			top.gisui.minWindow(id);
		}
		
		// 根据窗口的ID 销毁 一个窗口
		function desWindowById(){
			var id = $("#deswindowbyid").val();
			top.gisui.destroyWindow(id);
		}
		
		// 最小化 所有的窗口
		function minAllWindow() {
			top.gisui.minAllWindow();
		}
		
		// 销毁 所有的窗口
		function desAllWindow(){
			top.gisui.destroyAllWindows();
		}
		
		// 根据自定的json 创建 窗口
		function createWindowByJson(){
		//	alert(1234);
			var json = eval("("+$("#createid").val()+")");
			top.gisui.createWindow(json);
		}
		
		
		// 定线
		function addLineToMap(){
			
			var roadcode = $("#roadcode").val();
			var startzh = $("#startzh").val();
			var endzh = $("#endzh").val();
			
			top.map.addLineToMap({
				roadcode:roadcode,
				startzh:startzh,
				endzh:endzh
			});
			
		}
		
		// 根据窗口的ID 清空地图
		function clearMapByWinId(){
			var id = $("#mapwindowid").val();
			top.map.clearLayerByWindowId(id);
		}
		
		// 清空地图
		function clearMap(){
			top.map.clearAllLayers();	
		}
		
		
	</script>
</body>
</html>