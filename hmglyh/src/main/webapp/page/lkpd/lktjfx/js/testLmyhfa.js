var bmcode=window.top.loginUserObject.bmcode;

var lxCode_ls = '';
var szhh='';
var ezhh='';
var qdState = false;
var dcState = false;
var jcState = false;


var initCombo = function(){
	$("#recording").combobox({
		onSelect : function(node){
			if(node.value == 0){
				$("#myTable td[kid=0]").show();
				$("#myTable td[kid=1]").hide();
			}else{
				$("#myTable td[kid=0]").hide();
				$("#myTable td[kid=1]").show();
			}
		}
	});
	$("#qdbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0205",
		textField : "bbmc",
		valueField : "bbid",
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
			$("#start").numberbox({
				precision:3,
				value:node.szhh,
				min:node.szhh,
				max:node.ezhh
			});
			$("#end").numberbox({
				precision:3,
				value:node.ezhh,
				min:node.szhh,
				max:node.ezhh
			});
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
		if(dcState&&jcState){
			var recording = $("#recording").combobox("getValue");
			var dcbb=$("#dcbb").combobox("getValue");
			var jcbb = $("#jcbb").combobox("getValue");
			if(recording=="0" && qdState){
				var qdbb=$("#qdbb").combobox("getValue");
				document.getElementById("report_yj").src=YMLib.reportUrl+"reportlet=hmglyh%2Flmyhfa%2Fyjzbpd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&qdbb="+qdbb+"&jcbb="+jcbb;
				document.getElementById("report_ej").src=YMLib.reportUrl+"reportlet=hmglyh%2Flmyhfa%2Fejzbpd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&qdbb="+qdbb+"&jcbb="+jcbb;
				document.getElementById("report_fa").src=YMLib.reportUrl+"reportlet=hmglyh%2Flmyhfa%2Fyhfa.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&qdbb="+qdbb+"&jcbb="+jcbb;
			}else if(recording == "1"){
				var start = $("#start").numberbox("getValue");
				var end = $("#end").numberbox("getValue");
				document.getElementById("report_yj").src=YMLib.reportUrl+"reportlet=hmglyh%2Flmyhfa%2FyjzbpdForLd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+start+"&ezhh="+end+"&jcbb="+jcbb;
				document.getElementById("report_ej").src=YMLib.reportUrl+"reportlet=hmglyh%2Flmyhfa%2FejzbpdForLd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+start+"&ezhh="+end+"&jcbb="+jcbb;
				document.getElementById("report_fa").src=YMLib.reportUrl+"reportlet=hmglyh%2Flmyhfa%2FyhfaForLd.cpt&__bypagesize__=false&dcbb="+dcbb+
				"&lxcode="+lxCode_ls+"&szhh="+start+"&ezhh="+end+"&jcbb="+jcbb;
			}else{
				YMLib.UI.Show("查询条件不完全，请选择",2000);
			}
				
		}else{
			YMLib.UI.Show("查询条件不完全，请选择",2000);
		}
	});
};

$(function(){
	initCombo();
	initButton();
	
});