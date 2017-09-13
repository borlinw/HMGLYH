
var loginUserObject = null;
$.ajax({
	url:"/hmglyh/rcyh/bh_getUserInfo.do",
	async:false,
	dataType:"json",
	success:function(data){
		console.log(data);
		loginUserObject = data;
	}
});

var initCombo = function(){
	$("#yhdw").combotree({
		url : YMLib.url + "bm/getBmCombotree.do?bmcode="+loginUserObject.bmcode,
		valueField : "id",
		textField : "text",
		
		onSelect : function(node){
			initLd(node.id);
		}
	});
	$("#rwly").combobox('setValue','');
	$("#rwly").combobox({
		onSelect : function(record){
			if(record.value == "0902"){
				$("#condition").combobox("select","0");
				$("#xd").show();
				$("#date").hide();
				$("#month").show();
			}else{
				$("#xd").hide();
				$("#date").hide();
				$("#month").show();
			}
		}
	});
	$("#condition").combobox({
		onSelect : function(record){
			if(record.value == "0"){
				$("#date").hide();
				$("#month").show();
			}else{
				$("#date").show();
				$("#month").hide();
			}
		}
	});
	$("#yf").combobox({
		url : YMLib.url + "nyb/getNy.do",
		valueField : "yname",
		textField : "yname"
	});
};

var initLd = function(_bmCode){
	$("#yhqd").combobox({
		url : YMLib.url + "lxld/getLxldCombo.do?bmCode="+_bmCode,
		valueField : "id",
		textField : "text"
	});
};

var initButton = function(){
	$("#query").click(function(){
		var	yhdw = $("#yhdw").combotree("getValue");
		var	yhqd = $("#yhqd").combobox("getValue");
		var	rwly = $("#rwly").combobox("getValue");
		var	yf = $("#yf").combobox("getValue");
		var	condition=$("#condition").combobox("getValue");
		var	day = $("#day").val();
		if(rwly=="0902"&&condition=="1"){
			document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=hmglyh%2Frcyhrwtzd_xd.cpt&bmcode="+yhdw+"&cjtime="+day+"&ldcode="+yhqd+"&rwdlx="+rwly;
		}else if(rwly=="0902"&&condition=="0"){
			document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=hmglyh%2Frcyhrwtzd_xd_yf.cpt&bmcode="+yhdw+"&ssny="+cjkEncode(yf)+"&ldcode="+yhqd+"&rwdlx="+rwly;
		}else{
			document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=hmglyh%2Frcyhrwtzd_bj.cpt&bmcode="+yhdw+"&ssny="+cjkEncode(yf)+"&ldcode="+yhqd+"&rwdlx="+rwly;
		};
		
	});
};

$(function(){
	initCombo();
	initButton();
});
















