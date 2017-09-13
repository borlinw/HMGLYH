var bmcode=window.top.loginUserObject.bmcode;
var lxCode_ls = '';
var szhh='';
var ezhh='';
var initCombo = function(){
	
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+"0203",
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			bbsj =  data[0].bbsj.substr(0,10);
			$("#bb").combobox({
				editable:false,
				data :data,
				valueField : "bbid",
				textField : "bbmc",
				onSelect : function(node){
					sj=node.bbsj;
					bbsj=sj.substr(0,10);
					initCombo2();
					initComboQzd();
				}
			
			});
		}
		});

	$.ajax({
		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			lxCode_ls = data[0].lxCode;
			szhh = data[0].szhh;
			ezhh = data[0].ezhh;
			$("#ld").combobox({
				editable:false,
				data:data,
				valueField : "id",
				textField : "text",
				onSelect : function(node){
					lxCode_ls= node.lxCode;
					szhh=node.szhh;
					ezhh=node.ezhh;
					initCombo2();
					initComboQzd();
					}
			});
		}
		});
	setTimeout(function(){
		initCombo2();
		initComboQzd();
	},1000); 
};
var initCombo2 = function(){
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
			

	};

	var initComboQzd = function(){
		$("#qd").numberbox({
			precision:3,
			value:szhh,
			min:szhh,
			max:ezhh,
			onChange: function(newValue,oldValue){
				szhh =newValue;
				initCombo2();
			}
		});
		$("#zd").numberbox({
			precision:3,
			value:ezhh,
			min:szhh,
			max:ezhh,
			onChange: function(newValue,oldValue){
				ezhh= newValue;
				initCombo2();
			}
		});
	};
	
	
var initButton = function(){
	$("#query").click(function(){
		var bb=$("#bb").combobox("getValue");
	//	var ld=$("#ld").combobox("getValue");
		var lmlx=$("#lmlx").combobox("getValue");
		var	jsdj = $("#jsdj").combobox("getValue");
		if(jsdj=="1"){
			document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=hmglyh%2Fpdhz%2Fpdhz_gs.cpt&bb="+bb+
			"&lxcode1="+lxCode_ls+"&QDZH="+szhh+"&ZDZH="+ezhh+"&lmlx="+lmlx+"&jsdj="+jsdj+"&bbsj="+bbsj+"&bmcode="+bmcode;
		}else{
			document.getElementById("reportFrame").src=YMLib.reportUrl+"reportlet=hmglyh%2Fpdhz%2Fpdhz_pt.cpt&bb="+bb+
			"&lxcode1="+lxCode_ls+"&QDZH="+szhh+"&ZDZH="+ezhh+"&lmlx="+lmlx+"&jsdj="+jsdj+"&bbsj="+bbsj+"&bmcode="+bmcode;
		}
	});
};



$(function(){
//	$("#reportFrame").css("height",($(document).height()-80)+"px");
	initCombo();
	initButton();
});

