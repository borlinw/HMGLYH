var bmcode=window.top.loginUserObject.bmcode;

var szhh='';
var ezhh='';
var lxCode_ls='';
var initCombo = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+"0203",
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			$("#bb").combobox({
				editable:false,
				data :data,
				valueField : "bbid",
				textField : "bbmc"
			});
		}
		});

	$.ajax({
		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			lxCode_ls=data[0].lxCode;
			szhh = data[0].szhh;
			ezhh = data[0].ezhh;
			$("#ld").combobox({
				editable:false,
				data:data,
				valueField : "id",
				textField : "text",
				onSelect : function(node){
					lxCode_ls=node.lxCode;
					szhh=node.szhh;
					ezhh=node.ezhh;
					initComboQzd();
					}
			});
		}
		});
	setTimeout(function(){
		initComboQzd();
	},1000); 
};

var initComboQzd = function(){
	$("#qd").numberbox({
		precision:3,
		value:szhh,
		min:szhh,
		max:ezhh,
		onChange: function(newValue,oldValue){
			szhh =newValue;
		}
	});
	$("#zd").numberbox({
		precision:3,
		value:ezhh,
		min:szhh,
		max:ezhh,
		onChange: function(newValue,oldValue){
			ezhh= newValue;
		}
	});
};
var initButton = function(){
	$("#query").click(function(){
		var bb=$("#bb").combobox("getValue");
		document.getElementById("report1").src=YMLib.reportUrl+"reportlet=hmglyh%2Fpdfx%2Fpdfx_ld.cpt&__bypagesize__=false&bb="+bb+
		"&lxcode1="+lxCode_ls+"&qdzh="+szhh+"&zdzh="+ezhh;
	});
};

$(function(){
	initCombo();
	initButton();
});
//=======================================按单位==========================================
var initCombo1 = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+"0203",
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			$("#bb1").combobox({
				editable:false,
				data :data,
				valueField : "bbid",
				textField : "bbmc"
			});
		}
		});

	$.ajax({
		url: YMLib.url + "bm1/getBmCombotree1.do?bmcode="+bmcode,
		dataType:'json',
		success:function(msg){
			var data = msg;
			$("#gydw1").combotree({
				editable:false,
				data:data,
				valueField : "id",
				textField : "text",
			});
			$('#gydw1').combotree('setValue',data[0].id);
			
		}
	});
	
};

var initButton1 = function(){
	$("#query1").click(function(){
		var bb1=$("#bb1").combobox("getValue");
		var gydw1=$("#gydw1").combobox("getValue");
			document.getElementById("report2").src=YMLib.reportUrl+"reportlet=hmglyh%2Fpdfx%2Fpdfx_dw.cpt&bb="+bb1+
			"&bmcode="+gydw1;
	});
};

$(function(){
	initCombo1();
	initButton1();
});

//===========================================按技术等级=====================================

var initCombo2 = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+"0203",
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			$("#bb2").combobox({
				editable:false,
				data :data,
				valueField : "bbid",
				textField : "bbmc"
			});
		}
		});

	$.ajax({
		url: YMLib.url + "bm1/getBmCombotree1.do?bmcode="+bmcode,
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			$("#gydw2").combotree({
				editable:false,
				data:data,
				valueField : "id",
				textField : "text"
			});
			$('#gydw2').combotree('setValue',data[0].id);
		}
	});
	
};

var initButton2 = function(){
	$("#query2").click(function(){
		var bb2=$("#bb2").combobox("getValue");
		var gydw2=$("#gydw2").combobox("getValue");
		var jsdj2=$("#jsdj2").combobox("getValue");
		if(jsdj2=="0"){
			document.getElementById("report3").src=YMLib.reportUrl+"reportlet=hmglyh%2Fpdfx%2Fpdfx_gs.cpt&__bypagesize__=false&bb="+bb2+
			"&bmcode="+gydw2;
		}else{
			document.getElementById("report3").src=YMLib.reportUrl+"reportlet=hmglyh%2Fpdfx%2Fpdfx_pt.cpt&__bypagesize__=false&bb="+bb2+
			"&bmcode="+gydw2;
		}
			
	});
};
//===========================================路线信息汇总表=====================================
var initCombo3 = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+"0203",
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			$("#bb3").combobox({
				editable:false,
				data :data,
				valueField : "bbid",
				textField : "bbmc"
			});
		}
	});

};

var initButton3 = function(){
	$("#query3").click(function(){
		var bb3=$("#bb3").combobox("getValue");
		document.getElementById("report4").src=YMLib.reportUrl+"reportlet=hmglyh%2Fpdfx%2Flxxxhzb.cpt&bb="+bb3+
			"&bmcode="+bmcode;
	});
};











$(function(){
//	$("#report1").css("height",($(document).height()-112)+"px");
//	$("#report2").css("height",($(document).height()-112)+"px");
//	$("#report3").css("height",($(document).height()-112)+"px");
//	$("#report4").css("height",($(document).height()-112)+"px");
	initCombo2();
	initButton2();
	initCombo3();
	initButton3();
});
