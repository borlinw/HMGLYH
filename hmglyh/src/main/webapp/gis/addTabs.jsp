<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../page/gis/js/easyui-1.3.2/themes/hdstyle/easyui.css">
<link type="text/css" rel="stylesheet" href="../page/gis/js/easyui-1.3.2/themes/icon.css">
<script type="text/javascript" src="../page/gis/js/easyui-1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="../page/gis/js/easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../page/gis/js/easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
<title>Insert title here</title>
</head>
<body style="overflow:hidden">
	<%
	
	  String winid = request.getParameter("winid");
	  Cookie[] cookies = request.getCookies();
	  
	  String tabsall = "";
	  String tabssel = "";
	  
	  for( Cookie c : cookies){
		  if( (winid+"_tabsall").equals(c.getName())){
			  tabsall = (String)c.getValue();
		  }
		  if( (winid+"_tabssel").equals(c.getName())){
			  tabssel = (String)c.getValue();
		  }
	  }
	  
	  
	  request.setAttribute("tabsall", tabsall);
	  request.setAttribute("tabssel", tabssel);
	  request.setAttribute("winid", winid);
	  
	  
	%>
	
	<input type="hidden" id="tabsall" value="${tabsall}">
	<input type="hidden" id="tabssel" value="${tabssel}">
	<input type="hidden" id="winid" value="${winid}">
	
	<h2>请选择</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>将左边框中拖拽到右边的框中， 将会在tabs页签中显示</div>
	</div>
	<div style="margin:10px 0;"></div>
	<div id="source" style="border:1px solid #ccc;width:300px;height:420px;float:left;margin:5px;">
		未显示
		<!-- <div id="d1" class="drag">Drag 1</div>
		<div id="d2" class="drag">Drag 2</div>
		<div id="d3" class="drag">Drag 3</div> -->
	</div>
	<div id="target" style="border:1px solid #ccc;width:300px;height:420px;float:left;margin:5px;">
		显示
	</div>
	<div style="clear:both"></div>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="save()">保存</a>
	<style type="text/css">
		.drag{
			width:180px;
			padding:3px;
			margin:5px;
			border:1px solid #ccc;
			background:#AACCFF;
		}
		.dp{
			opacity:0.5;
			filter:alpha(opacity=50);
		}
		.over{
			background:#FBEC88;
		}
	</style>
	<script>
	
		// 保存用户筛选好的结果
		function save(){
			var children = $("#target").children("div");
			var winid = $("#winid").val();
			var tabssel = "";
			$.each(children,function(i,d){
				tabssel +=  $(d).text() + "|";
			});
			
			top.setCookie(winid+"_tabssel",tabssel,30);
			
			alert("保存成功");
		}
	
		$(function(){
			
			var tabsselStr = unescape($("#tabssel").val());
			var tabsallStr = unescape($("#tabsall").val());
			var tabssel = tabsselStr.split("|");
			var tabsall = tabsallStr.split("|");
			
			tabssel.length = tabssel.length - 1;
			tabsall.length = tabsall.length - 1;
			
			for(var i = 0 ; i < tabssel.length; i ++ ) {
				$("#target").append("<div class='drag'>"+tabssel[i]+"</div>");
			}
			
			for(var i = 0 ; i < tabsall.length; i ++ ) {
				if( tabsselStr.indexOf(tabsall[i]) == -1 ) {
					$("#source").append("<div class='drag'>"+tabsall[i]+"</div>");
				}
			}
			
			
			$('.drag').draggable({
				proxy:'clone',
				revert:true,
				cursor:'auto',
				onStartDrag:function(){
					$(this).draggable('options').cursor='pointer';
					$(this).draggable('proxy').addClass('dp');
				},
				onStopDrag:function(){
					$(this).draggable('options').cursor='auto';
				}
			});
			$('#target').droppable({
				onDragEnter:function(e,source){
					$(source).draggable('options').cursor='pointer';
					$(source).draggable('proxy').css('border','1px solid red');
					$(this).addClass('over');
				},
				onDragLeave:function(e,source){
					$(source).draggable('options').cursor='pointer';
					$(source).draggable('proxy').css('border','1px solid #ccc');
					$(this).removeClass('over');
				},
				onDrop:function(e,source){
					$(this).append(source)
					$(this).removeClass('over');
				}
			});
			
			$('#source').droppable({
				onDragEnter:function(e,source){
					$(source).draggable('options').cursor='pointer';
					$(source).draggable('proxy').css('border','1px solid red');
					$(this).addClass('over');
				},
				onDragLeave:function(e,source){
					$(source).draggable('options').cursor='pointer';
					$(source).draggable('proxy').css('border','1px solid #ccc');
					$(this).removeClass('over');
				},
				onDrop:function(e,source){
					$(this).append(source);
					$(this).removeClass('over');
				}
			});
		});
	</script>

</body>
</html>