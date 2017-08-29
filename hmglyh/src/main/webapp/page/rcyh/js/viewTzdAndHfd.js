/* 
 * 查看“通知单/回复单”的Js脚本 
 * Author : lir 
 */

var currentGridRow = parent.currentGridRows;//用于传输DataGrid中的数据 
var tzdObj;//用于存储“通知单”的信息
var hfdObj;//用于存储“回复单”的信息

$(function() {
	YMLib.UI.MaskShow("正在加载...");
	var tzdid = currentGridRow.tzdid;
	//$("#tzdid").val(tzdid);
	$("#ExportTzdForm").form("load",currentGridRow);
	$("#ExportHfdForm").form("load",currentGridRow);
	
	//请求通知单信息
	$.ajax({
		url: YMLib.url + "rcyh/wxzg_queryTzdDataToView.do?tzdid=" + tzdid,
		type:"post",
		dataType: "text",
		success: function(result) {
			tzdObj = eval("("+result+")");
			//alert("请求成功：tzdid="+tzdObj.tzdid);
			$("#tzdForm").form("load",tzdObj);
			$("#bigText").text("经巡查、检查发现你单位 "+tzdObj.sbbmname+" 在 "+tzdObj.wz+" 等处，从事的养护作业存在以下问题，请务必"+tzdObj.yq+"按本单要求进行整改，并于"+tzdObj.sxtimeStr+"前报送整改结果，特此通知。");
			$("#czwt").text(tzdObj.czwt);
			$("#zgyq").text(tzdObj.zgyq);
			//请求回复单信息
			$.ajax({
				url: YMLib.url + "rcyh/wxzg_queryHfdDataToView.do?tzdid=" + tzdid,
				type:"post",
				dataType: "text",
				success: function(result1) {
					//alert("result1 ^=^ "+result1);
					if(result1 == "a"){
						//alert("没有相关回复单，需要将此标签关闭");
						$('#ma').tabs("close","整改回复单");
						YMLib.Tools.ShowPage();
						YMLib.UI.MaskHide();
					}else{
						hfdObj = eval("("+result1+")");
						$("#hfdForm").form("load",hfdObj);
						$("#zgcs").text(hfdObj.zgcs);
						$("#zgjg").text(hfdObj.zgjg);
						$("#jcryj").text(hfdObj.jcryj);
						YMLib.Tools.ShowPage();
						YMLib.UI.MaskHide();
					}
				},
				error:function(result){
					alert("ajax请求失败（回复单信息）!");
				}
			});
		},
		error:function(result){
			alert("ajax请求失败（通知单信息）!");
		}
	});
	//导出
	$("#ExportTzd").click(function(){
		//alert("需要导出的通知单的tzdid为:"+tzdObj.tzdid);
		$("#ExportTzdForm").attr("action",YMLib.url + "export/exportTzd.do");
		$("#ExportTzdForm").submit();
	});
	$("#ExportHfd").click(function(){
		//alert("需要导出的回复单的tzdid为:"+hfdObj.tzdid);
		$("#ExportHfdForm").attr("action",YMLib.url + "export/exportHfd.do");
		$("#ExportHfdForm").submit();
	});
});
