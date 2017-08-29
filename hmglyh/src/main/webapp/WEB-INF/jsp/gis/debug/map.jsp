<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="../public/head.jsp"%>
<title>地图API</title>
</head>
<body style="width:100%;height:100%;overflow-y:auto;overflow-x:hidden;padding:0px;margin:0px;">	
	<div id="debugboxContainer">
		<div id="mydemo" style="overflow-y:auto;font-size:10px;">
		<h4>清空地图</h4><br>
		<span>窗口ID：</span><input type="text" style="width:80px;" id="mapwindowid">  <input type="button" value="清除" onClick="clearMapByWinId()"></input>
		<span>窗口ID：</span><input type="text" style="width:80px;" id="cenWindowid">  <input type="button" value="raiseLayer" onClick="raiseLayer()"></input>
		<br><input type="button" value="清空地图" onclick="clearMap()"><br>
		<form id="addLineForm">
		<h4>根据路线编码起点桩号（可选），止点桩号（可选） ，弹窗内容（可选） 定线</h4><br>
			<span>路线编码：</span><input name="roadcode" type="text" id="roadcode" value="G45" style=""><br>
			<span>起点桩号：</span><input name="startzh" type="text" id="startzh" value="3000" style=""><br>
			<span>止点桩号：</span><input name="endzh" type="text" id="endzh" value="3100" style=""><br>
			<span>颜色：</span><input name="strokeColor" type="text" id="endzh" value="#ff0000" style=""><br>
			<textarea name="popup" id="textarea">
				Hello World
			</textarea>
			<input type="button" value="定线" onclick="addLineToMap()"><br><br>
		 </form>
		<h4>根据路线编码 桩号 定点</h4>
			<form id="addPiontByZhForm">
			<span>路线编码：</span><input name="roadcode" type="text" id="zhroadcode" value="G45" style=""><br>
			<span>起点桩号：</span><input name="zh" type="text" id="zhuangh" value="3000" style=""><br>
			<span>图片路径：</span><input name="imgpath" type="text" id="zhmgpath" value="img/sd.png" style=""><br>
			<textarea name="popup" id="zhpointHtml"></textarea>
			<input type="button" value="定点" onclick="addPointByZh()">
			</form><br>
			
		<h4>根据经度 ， 纬度  定点</h4><br>
			<form id="addPointByJwForm">
			<span>经度：</span><input name="ptx" type="text" id="jingdu" value="114.88472" style=""><br>
			<span>纬度：</span><input name="pty" type="text" id="weidu" value="24.901075" style=""><br>
			<span>图片：</span><input name="imgpath" type="text" value="img/sd.png" id="jwimgpath" style=""><br>
			<textarea name="popup" id="zhpointHtml">popup内容</textarea>
			<input type="button" value="定点" onclick="addPointByJw()">
			</form>
		<h4>选择 feature map.selectFeature</h4><br>
			<form id="selectFeature">
			<span>windowid：</span><input name="windowid" type="text" value="luxian" style=""><br>
			<span>featureid：</span><input name="featureid" type="text" value="" style=""><br>
			<span>method：</span><input name="method" type="text" value="getFeatureByFid" style=""><br>
			<input type="button" value="选中Feature" onclick="selectFeature()">
			</form>
		<h4>hideLayer(windowid)</h4><br>
			<form id="hideLayer">
			<span>windowid：</span><input name="windowid" type="text" value="luxian" style=""><br>
			<input type="button" value="隐藏图层" onclick="hideLayer()">
			</form>
		</div>
		<h4>showLayer(windowid)</h4><br>
			<form id="showLayer">
			<span>windowid：</span><input name="windowid" type="text" value="luxian" style=""><br>
			<input type="button" value="显示图层" onclick="showLayer()">
			</form>
		</div>
	</div>
	
	
	<script>
	
		function raiseLayer(){
			var windowid = $("#cenWindowid").val();
			var layer = top.map.map.getLayersByName(windowid+"_layer")[0];
			top.map.map.raiseLayer(layer);
		}
		
		// 根据路线编码 和  桩号 定点 
		function addPointByZh(){
			top.map.addPointByZh([getParam("addPiontByZhForm")]);
		}
		
		// 根据经纬度去定点
		function addPointByJw(){
			console.log(getParam("addPointByJwForm"));
			top.map.addPointByJw([getParam("addPointByJwForm")]);
		}
		
		// 定线
		function addLineToMap(){
			top.map.addLineToMap(getParam("addLineForm"));
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
		
		// select feature
		function selectFeature(){
			var windowid = document.forms["selectFeature"]["windowid"].value;
			var featureid = document.forms["selectFeature"]["featureid"].value;
			var method = document.forms["selectFeature"]["method"].value;
			top.map.selectFeature(windowid,featureid,method);
		}
		
		
		// 隐藏图层
		function hideLayer(){
			var windowid = document.forms["hideLayer"]["windowid"].value;
			top.map.hideLayer(windowid);
		}
		
		// 显示 图层
		function showLayer(){
			var windowid = document.forms["showLayer"]["windowid"].value;
			top.map.showLayer(windowid);
		}
		
	</script>
</body>
</html>