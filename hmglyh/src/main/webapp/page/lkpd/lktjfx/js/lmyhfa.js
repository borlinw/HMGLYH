var bmcode=window.top.loginUserObject.bmcode;

var lxCode_ls = '';
var szhh='';
var ezhh='';
var qdState = false;
var dcState = false;
var jcState = false;

//var initCombo = function(){
//	var getData = function(bbid,bblx,qmbbid){
//		var data_ = null;
//		$.ajax({
//			url: YMLib.url + "bbkzb/getBb.do?bblx="+bblx+"&qmbbid="+qmbbid+"&bbid="+bbid,
//			dataType:'json',
//			async:false,
//			success:function(msg){
//				data_ = msg;
//			}
//			});
//		return data_;
//	};
//	
//	var data = getData('','0205','');
//	data[0].selected=true;
//	$("#qdbb").combobox({
//		editable:false,
//		data :data,
//		valueField : "bbid",
//		textField : "bbmc",
//		onSelect : function(node){
//			var data2 = getData(node.qmbbid,'0203','');
//			var data3 = getData('','0201',data2[0].qmbbid);
//			data3[0].selected=true;
//			$("#dcbb").combobox({
//			editable:false,
//			data :data3,
//			valueField : "bbid",
//			textField : "bbmc"
//	
//		});
//		}
//
//	});
//
//	var data2 = getData($("#qdbb").combobox('options').data[0].bbid,'0203','');
//	var data3 = getData('','0201',data2[0].qmbbid);
//	data3[0].selected=true;
//	$("#dcbb").combobox({
//	editable:false,
//	data :data3,
//	valueField : "bbid",
//	textField : "bbmc"
//
//});
//	
//	$.ajax({
//		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
//		dataType:'json',
//		success:function(msg){
//			var data = msg;
//			data[0].selected=true;
//			lxCode_ls = data[0].lxCode;
//			szhh = data[0].szhh;
//			ezhh = data[0].ezhh;
//			$("#ld").combobox({
//				editable:false,
//				data:data,
//				valueField : "id",
//				textField : "text",
//				onSelect : function(node){
//					lxCode_ls= node.lxCode;
//					szhh=node.szhh;
//					ezhh=node.ezhh;
//					}
//			});
//		}
//		});
//};

var initCombo = function(){
	$("#qdbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0205",
		textField : "bbmc",
		valueField : "bbid",
//		onSelect : function(record){
//			initCombo2(record.qmbbid);
//		},
		onLoadSuccess : function(){
			qdState = true;
			var data = $("#qdbb").combobox("getData");
			if(data == null || data.length == 0){
				qdState = false;
				YMLib.UI.Show("没有区段划分的版本，请先创建区段划分版本",2000);
			}else{
				$("#qdbb").combobox("select",data[0].bbid);
			}
		}
	});
	$("#ld").combobox({
		url : YMLib.url + "lxld/getLxldCombo.do?bmCode=" + bmcode,
		editable : false,
		valueField : "id",
		textField : "text",
		onSelect : function(node){
			lxCode_ls = node.lxCode;
			ezhh = node.ezhh;
			szhh = node.szhh;
		},
		onLoadSuccess : function(){
			var data = $("#ld").combobox("getData");
			$("#ld").combobox("select",data[0].id);
		}
	});
	$("#dcbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0201",
		textField : "bbmc",
		valueField : "bbid",
		onLoadSuccess : function(){
			dcState = true;
			var data = $("#dcbb").combobox("getData");
			if(data == null || data.length == 0){
				dcState = false;
				YMLib.UI.Show("没有对应的路况调查的版本，请重新选择区段划分版本",2000);
			}else
				$("#dcbb").combobox("select",data[0].bbid);
		},
		onSelect : function(record){
			initCombo2(record.qmbbid);
		}
	});
};

var initCombo2 = function(_qmbbid){
	$("#jcbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0202&qmbbid="+_qmbbid,
		textField : "bbmc",
		valueField : "bbid",
		onLoadSuccess : function(){
			jcState = true;
			var data = $("#jcbb").combobox("getData");
			if(data == null || data.length == 0){
				jcState = false;
				YMLib.UI.Show("没有对应的路面检测的版本，请重新选择区段划分版本",2000);
			}else
				$("#jcbb").combobox("select",data[0].bbid);
		}
	});
};



var initButton = function(){
	$("#query").click(function(){
		if(qdState&&dcState&&jcState){
			var dcbb=$("#dcbb").combobox("getValue");
			var qdbb=$("#qdbb").combobox("getValue");
			var jcbb = $("#jcbb").combobox("getValue");
//			var ld=$("#ld").combobox("getValue");
				document.getElementById("report_yj").src=YMLib.reportUrl+"reportlet=lmyhfa%2Fyjzbpd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&qdbb="+qdbb+"&jcbb="+jcbb;
				document.getElementById("report_ej").src=YMLib.reportUrl+"reportlet=lmyhfa%2Fejzbpd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&qdbb="+qdbb+"&jcbb="+jcbb;
				document.getElementById("report_fa").src=YMLib.reportUrl+"reportlet=lmyhfa%2Fyhfa.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&qdbb="+qdbb+"&jcbb="+jcbb;
		}else{
			YMLib.UI.Show("查询条件不完全，请选择",2000);
		}
	});
};

$(function(){
//	$("#report_yj").css("height",($(document).height()-100)+"px");
//	$("#report_ej").css("height",($(document).height()-100)+"px");
//	$("#report_fa").css("height",($(document).height()-100)+"px");
	initCombo();
	initButton();
	
});