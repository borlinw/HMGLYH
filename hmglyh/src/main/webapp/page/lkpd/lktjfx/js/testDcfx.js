var bmcode=window.top.loginUserObject.bmcode;

var dcbbCacheData = null;

var qdCacheData = null;

//获取管辖路段
var lxCacheData = null;
var roadCode = [];
var szhhList = [];
var ezhhList = [];
//路段下拉框数据获取
var getLx = function(){
	$.ajax({
		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
		dataType:'json',
		success:function(msg){
			if(msg != null && msg.length != 0){
				lxCacheData = msg;
				initLxCombo();
			}
		}
	});
};
//路段下拉框设置
var initLxCombo = function(){
		initLx("ld",0);
		initLx("ld1",1);
		initLx("ld2",2);
		initLx("yxld",3);
		initLx("ldbhld",4);
		initLx("lqlmld",5);
		
		$("[kid=ld]").combobox("select",lxCacheData[0].id);
};
//路段下拉框设置
var initLx = function(_id,_index){
	$("#"+_id).combobox({
		editable:false,
		data:lxCacheData,
		valueField : "id",
		textField : "text",
		onSelect : function(node){
			roadCode[_index] = node.lxCode;
			szhhList[_index] = node.szhh;
			ezhhList[_index] = node.ezhh;
			$("#"+_id+"_start").numberbox({
				precision:3,
				value:node.szhh,
				min:node.szhh,
				max:node.ezhh
			});
			$("#"+_id+"_end").numberbox({
				precision:3,
				value:node.ezhh,
				min:node.szhh,
				max:node.ezhh
			});
			if(_id=="ld"){
				lxCode_ls= node.lxCode;
				szhh=node.szhh;
				ezhh=node.ezhh;
				initCombo2();
			}
		}
	});
};
//路况调查数据获取
var loadDcbb = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx=0201",
		dataType:'json',
		success:function(msg){
			if(msg != null){
				dcbbCacheData = msg;
				initDcbbCombobox();
			}
		}
	});
};
//路况调查版本下拉框设置
var initDcbbCombobox = function(){
	$("#dcbb").combobox({
		editable:false,
		data :dcbbCacheData,
		value : dcbbCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	
	$("#dcbb1").combobox({
		editable:false,
		data :dcbbCacheData,
		value : dcbbCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#bb2").combobox({
		editable:false,
		data :dcbbCacheData,
		value : dcbbCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#yxdcbb").combobox({
		editable:false,
		data :dcbbCacheData,
		value : dcbbCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#ldbhdcbb").combobox({
		editable:false,
		data :dcbbCacheData,
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(record){
			$("#ldbhjcbb").combobox({
				url : YMLib.url + "bbkzb/getBb.do?bblx=0202&qmbbid="+record.qmbbid,
				textField : "bbmc",
				valueField : "bbid",
				onLoadSuccess : function(){
					jcState = true;
					var data = $("#ldbhjcbb").combobox("getData");
					if(data == null || data.length == 0){
						jcState = false;
						YMLib.UI.Show("没有对应的路面检测的版本，请重新路况调查版本",2000);
					}else
						$("#ldbhjcbb").combobox("select",data[0].bbid);
				}
			});
		}
	});
	$("#ldbhdcbb").combobox("select",dcbbCacheData[0].bbid);
	
	$("#lqlmdcbb").combobox({
		editable:false,
		data :dcbbCacheData,
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(record){
			$("#lqlmjcbb").combobox({
				url : YMLib.url + "bbkzb/getBb.do?bblx=0202&qmbbid="+record.qmbbid,
				textField : "bbmc",
				valueField : "bbid",
				onLoadSuccess : function(){
					jcState = true;
					var data = $("#lqlmjcbb").combobox("getData");
					if(data == null || data.length == 0){
						jcState = false;
						YMLib.UI.Show("没有对应的路面检测的版本，请重新选择路况调查版本",2000);
					}else
						$("#lqlmjcbb").combobox("select",data[0].bbid);
				}
			});
		}
	});
	$("#lqlmdcbb").combobox("select",dcbbCacheData[0].bbid);
};
//显示设置
var initShow = function(){
	initRecording("lmps");
	initRecording("ljps");
	initRecording("yxss");
	initRecording("ldbh");
	initRecording("xqfx");
};
//按区段还是按路段进行统计相应的显示设置
var initRecording = function(_id){
	$("#"+_id+"_recording").combobox({
		onSelect : function(node){
			if(node.value == 0){
				$("#"+_id+" td[kid=0]").show();
				$("#"+_id+" td[kid=1]").hide();
			}else{
				$("#"+_id+" td[kid=0]").hide();
				$("#"+_id+" td[kid=1]").show();
			}
		}
	});
};
//区段划分下拉框数据获取
var loadQd = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx=0205",
		dataType:'json',
		success:function(msg){
			if(msg != null){
				qdCacheData = msg;
				initQdCombobox();
			}else{
				YMLib.UI.Show("没有区段划分的版本",2000);
			}
		}
	});
};
//区段划分下拉框设置
var initQdCombobox = function(){
	$("#qdbb").combobox({
		editable:false,
		data :qdCacheData,
		value : qdCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#qdbb1").combobox({
		editable:false,
		data :qdCacheData,
		value : qdCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#yxqdbb").combobox({
		editable:false,
		data :qdCacheData,
		value : qdCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#ldbhqdbb").combobox({
		editable:false,
		data :qdCacheData,
		value : qdCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#lqlmqdbb").combobox({
		editable:false,
		data :qdCacheData,
		value : qdCacheData[0].bbid,
		valueField : "bbid",
		textField : "bbmc"
	});
};


var lxCode_ls = '';
var szhh='';
var ezhh='';

//根据选定的路段查询改路段上的路面类型
var initCombo2 = function(){
	if(lxCode_ls!=""){
		$.ajax({
			url: YMLib.url + "qmldb/getLmlx.do?lxCode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh,
			dataType:'json',
			success:function(msg){
				var data = msg;
				data[0].selected=true;
				$("#lmlx").combobox({
					editable:false,
					data : data,
					valueField : "lmlx",
					textField : "fx"
				});
			}
		
		});
	}
			
};
var initButton = function(){
	$("#query").click(function(){
		var dcbb=$("#dcbb").combobox("getValue");
		var qdbb=$("#qdbb").combobox("getValue");
		var lmlx=$("#lmlx").combobox("getValue");
		if(lmlx=="1"){//沥青路面
			document.getElementById("report_lm").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Flqlmps_gs.cpt&__bypagesize__=false&dcbb="+dcbb+
			"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&lmlx="+lmlx+"&qdbb="+qdbb;
		}else{//沙石路面
			document.getElementById("report_lm").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fsslmps_gs.cpt&__bypagesize__=false&dcbb="+dcbb+
			"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&lmlx="+lmlx+"&qdbb="+qdbb;
		};
	});
};

var initQuery = function(){
	//路面破损查询
	$("#query").click(function(){
		var recording = $("#lmps_recording").combobox("getValue");
		var dcbb=$("#dcbb").combobox("getValue");
		var lmlx=$("#lmlx").combobox("getValue");
		if(recording == "0"){//按区段
			var qdbb=$("#qdbb").combobox("getValue");
			if(lmlx=="1"){//沥青路面
				document.getElementById("report_lm").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Flqlmps_gs.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+roadCode[0]+"&szhh="+szhhList[0]+"&ezhh="+ezhhList[0]+"&lmlx="+lmlx+"&qdbb="+qdbb;
			}else{//沙石路面
				document.getElementById("report_lm").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fsslmps_gs.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+roadCode[0]+"&szhh="+szhhList[0]+"&ezhh="+ezhhList[0]+"&lmlx="+lmlx+"&qdbb="+qdbb;
			};
		}else{//按路段
			var start = $("#ld_start").numberbox("getValue");
			var end = $("#ld_end").numberbox("getValue");
			if(lmlx=="1"){//沥青路面
				document.getElementById("report_lm").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2FlqlmpsForLd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+roadCode[0]+"&szhh="+start+"&ezhh="+end+"&lmlx="+lmlx;
			}else{//沙石路面
				document.getElementById("report_lm").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2FsslmpsForLd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+roadCode[0]+"&szhh="+start+"&ezhh="+end+"&lmlx="+lmlx;
			};
		}
	});
	//路基破损
	$("#query1").click(function(){
		var recording = $("#ljps_recording").combobox("getValue");
		var dcbb1=$("#dcbb1").combobox("getValue");
		if(recording == "0"){
			var qdbb1=$("#qdbb1").combobox("getValue");
			document.getElementById("report_lj").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fljps.cpt&__bypagesize__=false&dcbb="+dcbb1+
			"&lxcode="+roadCode[1]+"&szhh="+szhhList[1]+"&ezhh="+ezhhList[1]+"&qdbb="+qdbb1;
		}else{
			var start = $("#ld1_start").numberbox("getValue");
			var end = $("#ld1_end").numberbox("getValue");
			document.getElementById("report_lj").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2FljpsForLd.cpt&__bypagesize__=false&dcbb="+dcbb1+
			"&lxcode="+roadCode[1]+"&szhh="+start+"&ezhh="+end;
		}
	});
	//桥隧构造物
	$("#query2").click(function(){
		var bb2=$("#bb2").combobox("getValue");
		var start = $("#ld2_start").numberbox("getValue");
		var end = $("#ld2_end").numberbox("getValue");
		document.getElementById("report_qh").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fqshgzw.cpt&__bypagesize__=false&bb="+bb2+
		"&lxcode="+roadCode[2]+"&szhh="+start+"&ezhh="+end;
	});
	//沿线设施
	$("#query3").click(function(){
		var recording = $("#yxss_recording").combobox("getValue");
		var dcbb3=$("#yxdcbb").combobox("getValue");
		if(recording == "0"){
			var	qdbb3 = $("#yxqdbb").combobox("getValue");
			document.getElementById("report_yx").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fyxss_gs.cpt&__bypagesize__=false&dcbb="+dcbb3+
			"&lxcode="+roadCode[3]+"&szhh="+szhhList[3]+"&ezhh="+ezhhList[3]+"&qdbb="+qdbb3;
		}else{
			var start = $("#yxld_start").numberbox("getValue");
			var end = $("#yxld_end").numberbox("getValue");
			document.getElementById("report_yx").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2FyxsspsForLd.cpt&__bypagesize__=false&dcbb="+dcbb3+
			"&lxcode="+roadCode[3]+"&szhh="+start+"&ezhh="+end;
		}
	});
	//路段病害情况汇总
	$("#query4").click(function(){
		var recording = $("#ldbh_recording").combobox("getValue");
		var dcbb4=$("#ldbhdcbb").combobox("getValue");
		var jcbb = $("#ldbhjcbb").combobox("getValue");
		if(recording == "0"){
			var	qdbb4 = $("#ldbhqdbb").combobox("getValue");
			document.getElementById("report_ldhz").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fldbhqkhz.cpt&__bypagesize__=false&dcbb="+dcbb4+
			"&lxcode="+roadCode[4]+"&szhh="+szhhList[4]+"&ezhh="+ezhhList[4]+"&qdbb="+qdbb4+"&jcbb="+jcbb;
		}else{
			var start = $("#ldbhld_start").numberbox("getValue");
			var end = $("#ldbhld_end").numberbox("getValue");
			document.getElementById("report_ldhz").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2FldbhqkhzForLd.cpt&__bypagesize__=false&dcbb="+dcbb4+
			"&lxcode="+roadCode[4]+"&szhh="+start+"&ezhh="+end+"&jcbb="+jcbb;
		}
	});
	//沥青路面养护需求分析汇总
	$("#query5").click(function(){
		var recording = $("#xqfx_recording").combobox("getValue");
		var dcbb5=$("#lqlmdcbb").combobox("getValue");
		var lqlmjcbb = $("#lqlmjcbb").combobox("getValue");
		if(recording == "0"){
			var	qdbb5 = $("#lqlmqdbb").combobox("getValue");
			document.getElementById("report_lqhz").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Flqlmyhxqfxhz.cpt&__bypagesize__=false&dcbb="+dcbb5+
			"&lxcode="+roadCode[5]+"&szhh="+szhhList[5]+"&ezhh="+ezhhList[5]+"&qdbb="+qdbb5+"&jcbb="+lqlmjcbb;
		}else{
			var start = $("#lqlmld_start").numberbox("getValue");
			var end = $("#lqlmld_end").numberbox("getValue");
			document.getElementById("report_lqhz").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2FlqlmyhxqfxhzForLd.cpt&__bypagesize__=false&dcbb="+dcbb5+
			"&lxcode="+roadCode[5]+"&szhh="+start+"&ezhh="+end+"&jcbb="+lqlmjcbb;
		}
	});
};

$(function(){
	getLx();
	initShow();
	loadDcbb();
	loadQd();
	initQuery();
});







