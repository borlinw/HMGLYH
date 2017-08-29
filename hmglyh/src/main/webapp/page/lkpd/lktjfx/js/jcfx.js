/*function autoLoad(){   
	var bmCode=window.top.loginUserObject.bmcode;
    //使用获取的参数值拼接出最终的url  
    var reportURL ="/hmglyh/ReportServer?reportlet=%5B516c%5D%5B8def%5D%5B8def%5D%5B9762%5D%5B76d1%5D%5B6d4b%5D%5B5206%5D%5B6790%5D%2F%5B516c%5D%5B8def%5D%5B8def%5D%5B9762%5D+_%5B7236%5D%5B8868%5D.cpt&bmcode="+bmCode+"";   
    //将新的报表路径赋给报表所在iframe的src   
    document.getElementById("reportFrame").src = reportURL;    
}   
//加载网页时调用autoLoad方法   
window.onload = autoLoad;  */

var bmcode=window.top.loginUserObject.bmcode;

var szhh='';
var ezhh='';
var lxCode_ls='';

var lxCacheData = null;
var roadCode = [];
var szhhList = [];
var ezhhList = [];


var initCombo = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+"0203",
		dataType:'json',
		success:function(msg){
			if(msg != null){
				$("#bb,#bb1").combobox({
					editable:false,
					data :msg,
					value : msg[0].bbid,
					valueField : "bbid",
					textField : "bbmc"
				});
			}else{
				YMLib.UI.Show("没有路况评定的版本，请先创建路况评定版本",2000);
			}
		}
	});

	$.ajax({
		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
		dataType:'json',
		success:function(msg){
			if(msg != null){
				lxCacheData = msg;
				initLx("ld",0);
				initLx("ld1",1);
			}
			
		}
	});
	
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx=0205",
		dataType:'json',
		success:function(msg){
			if(msg != null){
				$("#qdbb,#qdbb1").combobox({
					editable:false,
					data :msg,
					value : msg[0].bbid,
					valueField : "bbid",
					textField : "bbmc"
				});
			}else{
				YMLib.UI.Show("没有区段划分的版本",2000);
			}
		}
	});
};

var initLx = function(_id,_index){
	$("#"+_id).combobox({
		editable : false,
		data : lxCacheData,
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
		}
	});
	
	$("#"+_id).combobox("select",lxCacheData[0].id);
};



var initButton = function(){
	$("#query").click(function(){
		var recording = $("#lmjc_recording").combobox("getValue");
		var jczs=$("#jczs").combobox("getValue");
		var bb=$("#bb").combobox("getValue");
		if(recording == 1){
			if(jczs=="PCI"){//PCI
				document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=jcfx%2Fgllm_PCI.cpt&bb="+bb+
				"&lxcode="+roadCode[0]+"&szhh="+$("#ld_start").numberbox("getValue")+"&ezhh="+$("#ld_end").numberbox("getValue");
			}else if(jczs=="RQI"){//RQI
				document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=jcfx%2Fgllm_RQI.cpt&bb="+bb+
				"&lxcode="+roadCode[0]+"&szhh="+$("#ld_start").numberbox("getValue")+"&ezhh="+$("#ld_end").numberbox("getValue");
			}else if(jczs=="SRI"){//SRI
				document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=jcfx%2Fgllm_SRI.cpt&bb="+bb+
				"&lxcode="+roadCode[0]+"&szhh="+$("#ld_start").numberbox("getValue")+"&ezhh="+$("#ld_end").numberbox("getValue");
			}else if(jczs=="RDI"){//RDI
				document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=jcfx%2Fgllm_RDI.cpt&bb="+bb+
				"&lxcode="+roadCode[0]+"&szhh="+$("#ld_start").numberbox("getValue")+"&ezhh="+$("#ld_end").numberbox("getValue");
			}else if(jczs=="PSSI"){//PSSI
				document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=jcfx%2Fgllm_PSSI.cpt&bb="+bb+
				"&lxcode="+roadCode[0]+"&szhh="+$("#ld_start").numberbox("getValue")+"&ezhh="+$("#ld_end").numberbox("getValue");
			}
		}else{
			var qdbb = $("#qdbb").combobox("getValue");
			document.getElementById("reportFrame").src=YMLib.reportUrl + "reportlet=jcfx%2FlmjcfxForQd.cpt&pdbb="+bb+
				"&qdbb="+qdbb+"&sel="+jczs+"&lxcode="+roadCode[0]+"&szhh="+szhhList[0]+"&ezhh="+ezhhList[0];
		}
	});
	
	$("#query1").click(function(){
		var recording = $("#lmxs_recording").combobox("getValue");
		var bb = $("#bb1").combobox("getValue");
		if(recording == 1){
			document.getElementById("report_xszl").src=YMLib.reportUrl+"reportlet=jcfx%2Flmxszlzs.cpt&bb="+bb+
			"&lxcode="+roadCode[1]+"&szhh="+$("#ld1_start").numberbox("getValue")+"&ezhh="+$("#ld1_end").numberbox("getValue");
		}else{
			var qdbb = $("#qdbb").combobox("getValue");
			document.getElementById("report_xszl").src=YMLib.reportUrl + "reportlet=jcfx%2FlmxszlzsForQd.cpt&pdbb="+bb+
				"&qdbb="+qdbb+"&lxcode="+roadCode[0]+"&szhh="+szhhList[0]+"&ezhh="+ezhhList[0];
		}
	});
};

var initShow = function(){
	initRecording("lmjc");
	initRecording("lmxs");
	$("td[kid=1]").hide();
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


$(function(){
	initShow();
	initCombo();
	initButton();
});



