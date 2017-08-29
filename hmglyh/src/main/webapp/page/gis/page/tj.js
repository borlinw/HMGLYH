

var initCombo = function(){
	$("#sel").combobox({
		width : 220,
		panelHeight : "auto",
		onSelect : function(record){
			if(record.value=='按跨径及桥长分类' || record.value=='按桥梁技术状况等级进行分类' || record.value=='按跨径及技术等级进行分类' || record.value=='按桥型及技术等级进行分类'){
				$("#showDj").show();
			}else{
				$("#showDj").hide();
			}
		}
	});
	
	$("#lxjsdj").combobox({
		multiple : true,
		panelHeight : "auto",
		separator : ","
	});
};

var initButton = function(){
	$("#query").click(function(){
		var sel = $("#sel").combobox("getValue");
		var params = "reportlet=gzw/桥梁/"+sel+".cpt&__bypagesize__=false";
		if(sel=='按跨径及桥长分类' || sel=='按桥梁技术状况等级进行分类' || sel=='按跨径及技术等级进行分类' || sel=='按桥型及技术等级进行分类'){
			var jsdj = $("#lxjsdj").combobox("getText");
			var lxjsdj = 0;
			if(jsdj != ""){
				lxjsdj = jsdj;
			}
			params += "&lxjsdj="+lxjsdj;
		}
		$("#showTj").attr("src",YMLib.reportUrl + cjkEncode(params));
	});
	
};

$(function(){
	initCombo();
	initButton();
});










