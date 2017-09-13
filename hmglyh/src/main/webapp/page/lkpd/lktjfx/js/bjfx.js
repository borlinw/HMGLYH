var bmcode=window.top.loginUserObject.bmcode;

var lxCode_ls = '';
var szhh='';
var ezhh='';
var initCombo = function(){
	$.ajax({
		url: YMLib.url + "bbm/getBbCombotree.do",
		dataType:'json',
		success:function(msg){
			var data = msg;
			$("#bb,#bb1").combotree({
				editable:false,
				multiple : true,
				data :data,
				id : "id",
				text : "text"
			});
		}
	});
	$("#bm").combotree({
		url : YMLib.url + "bm/getBmCombotree.do?bmcode="+bmcode+"&bmlx=0101,0102",
		multiple : false,
		editable : false,
		onLoadSuccess : function(){
			$("#bm").combotree("setValue",bmcode);
		}
	});
	$.ajax({
		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			lxCode_ls = data[0].lxCode;
			$("#start").numberbox("setValue",data[0].szhh);
			$("#end").numberbox("setValue",data[0].ezhh);
			szhh = data[0].szhh;
			ezhh = data[0].ezhh;
			$("#ld").combobox({
				editable:false,
				data:data,
				valueField : "id",
				textField : "text",
				onSelect : function(node){
					lxCode_ls= node.lxCode;
					$("#start").numberbox("setValue",node.szhh);
					$("#end").numberbox("setValue",node.ezhh);
					szhh=node.szhh;
					ezhh=node.ezhh;
					initCombo2();
					}
			});
		}
	});
	setTimeout(function(){
		initCombo2();
	},1000); 
	
};

var initCombo2 = function(){
	if(lxCode_ls!=""){
			$.ajax({
				url: YMLib.url + "qmldb/getJsdj.do?lxCode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh,
				dataType:'json',
				success:function(msg){
					var data = msg;
					data[0].selected=true;
					$("#jsdj").combobox({
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
		var bb=$("#bb").combotree("getValues");
	//	var ld=$("#ld").combobox("getValue");
		var	jsdj = $("#jsdj").combobox("getValue");
		szhh = $("#start").numberbox("getValue");
		ezhh = $("#end").numberbox("getValue");
		if(jsdj=="1"){
			document.getElementById("report_ld").src=YMLib.reportUrl+"reportlet=hmglyh%2Fbjfx%2Fbjfx_gs.cpt&bb='"+bb+"'"+
			"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&jsdj="+jsdj;
		}else{
			document.getElementById("report_ld").src=YMLib.reportUrl+"reportlet=hmglyh%2Fbjfx%2Fbjfx_pt.cpt&bb='"+bb+"'"+
			"&lxcode="+lxCode_ls+"&szhh="+szhh+"&ezhh="+ezhh+"&jsdj="+jsdj;
		}
	});
	$("#query1").click(function(){
		var bb = $("#bb1").combotree("getValues");
		var bm = $("#bm").combotree("getValue");
		if(bb == null || bb == ""){
			YMLib.UI.Show("请选择需要对比的路况评定的版本",2000);
			return;
		}else{
			document.getElementById("report_dw").src=YMLib.reportUrl+"reportlet=hmglyh%2Fbjfx%2FbjfxForDw.cpt&bb="+bb+"&bmcode="+bm;
		}
		
	});
	
};

$(function(){
//	$("#reportFrame").css("height",($(document).height()-80)+"px");
	initCombo();
	initButton();
});
