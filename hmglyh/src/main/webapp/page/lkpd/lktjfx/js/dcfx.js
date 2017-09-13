var bmcode=window.top.loginUserObject.bmcode;

var getData = function(bbid,bblx,qmbbid){
	var data_ = null;
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+bblx+"&qmbbid="+qmbbid+"&bbid="+bbid,
		dataType:'json',
		async:false,
		success:function(msg){
			data_ = msg;
		}
		});
	return data_;
};

//获取管辖路段
var lxCacheData = null;
var roadCode = [];
var szhh = [];
var ezhh = [];
var getLx = function(){
	$.ajax({
		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
		dataType:'json',
		success:function(msg){
			lxCacheData = msg;
			if(msg != null && msg.length != 0){
				$("[kid=ld]").each(function(i){
					$(this).combobox({
						editable:false,
						data:lxCacheData,
						valueField : "id",
						textField : "text",
						onSelect : function(node){
							roadCode[i] = node.lxCode;
							szhh[i] = node.szhh;
							ezhh[i] = node.ezhh;
							$("[kid=ld]").eq(i).parent().next().find("[name=start]").numberbox({
								precision:3,
								value:node.szhh,
								min:node.szhh,
								max:node.ezhh
							});
							$("[kid=ld]").eq(i).parent().next().find("[name=start]").numberbox({
								precision:3,
								value:node.ezhh,
								min:node.szhh,
								max:node.ezhh
							});
							if(i == 0){
								lxCode_ls= node.lxCode;
								szhh=node.szhh;
								ezhh=node.ezhh;
								initCombo2();
							}
						}
					});
					$("[kid=ld]").combobox("select",lxCacheData[0].id);
				});
			}
			
			
			
			
		}
	});
};


var lxCode_ls = '';
var szhh='';
var ezhh='';
var initCombo = function(){
	//bbid,bblx,qmbbid
	var lmdata = getData('','0205','');
	lmdata[0].selected=true;
	$("#qdbb").combobox({
		editable:false,
		data :lmdata,
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(node){
			var lmdata2 = getData(node.qmbbid,'0203','');
			var lmdata3 = getData('','0201',lmdata2[0].qmbbid);
			lmdata3[0].selected=true;
			$("#dcbb").combobox({
			editable:false,
			data :lmdata3,
			valueField : "bbid",
			textField : "bbmc"
	
		});
		}

	});

	var lmdata2 = getData($("#qdbb").combobox('options').data[0].bbid,'0203','');
	var lmdata3 = getData('','0201',lmdata2[0].qmbbid);
	lmdata3[0].selected=true;
	$("#dcbb").combobox({
	editable:false,
	data :lmdata3,
	valueField : "bbid",
	textField : "bbmc"

});
	

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
//					initCombo2();
//					}
//			});
//		}
//		});
//	setTimeout(function(){
//		initCombo2();
//	},1000); 
	
};


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
//		var ld=$("#ld").combobox("getValue");
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

$(function(){
	getLx();
	initCombo();
	initButton();
});

















//================================================路基破损=============================================
var lxCode_ls1 = '';
var szhh1='';
var ezhh1='';
var initCombo1 = function(){
	var ljdata = getData('','0205','');
	ljdata[0].selected=true;
	$("#qdbb1").combobox({
		editable:false,
		data :ljdata,
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(node){
			var ljdata2 = getData(node.qmbbid,'0203','');
			var ljdata3 = getData('','0201',ljdata2[0].qmbbid);
			ljdata3[0].selected=true;
			$("#dcbb1").combobox({
			editable:false,
			data :ljdata3,
			valueField : "bbid",
			textField : "bbmc"
	
		});
		}

	});

	var ljdata2 = getData($("#qdbb1").combobox('options').data[0].bbid,'0203','');
	var ljdata3 = getData('','0201',ljdata2[0].qmbbid);
	ljdata3[0].selected=true;
	$("#dcbb1").combobox({
	editable:false,
	data :ljdata3,
	valueField : "bbid",
	textField : "bbmc"

});
	
//	$.ajax({
//		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
//		dataType:'json',
//		success:function(msg){
//			var data = msg;
//			data[0].selected=true;
//			lxCode_ls1 = data[0].lxCode;
//			szhh1 = data[0].szhh;
//			ezhh1 = data[0].ezhh;
//			$("#ld1").combobox({
//				editable:false,
//				data:data,
//				valueField : "id",
//				textField : "text",
//				onSelect : function(node){
//					lxCode_ls1= node.lxCode;
//					szhh1=node.szhh;
//					ezhh1=node.ezhh;
//					}
//			});
//		}
//
//	});

};


var initButton1 = function(){
	$("#query1").click(function(){
		var dcbb1=$("#dcbb1").combobox("getValue");
	//	var ld1=$("#ld1").combobox("getValue");
		var qdbb1=$("#qdbb1").combobox("getValue");
	/*	alert(dcbb1);
		alert(qdbb1);
		alert(ld1);*/
		
		document.getElementById("report_lj").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fljps.cpt&__bypagesize__=false&dcbb="+dcbb1+
		"&lxcode="+lxCode_ls1+"&szhh="+szhh1+"&ezhh="+ezhh1+"&qdbb="+qdbb1;
	});
	
};

$(function(){
	initCombo1();
	initButton1();
});

//================================================桥涵构造物=============================================
var szhh2='';
var ezhh2='';
var lxCode_ls2='';

var initCombo9 = function(){
	$.ajax({
		url: YMLib.url + "bbkzb/getBb.do?bblx="+"0201",
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			$("#bb2").combobox({
				editable:false,
				data :data,
				valueField : "bbid",
				textField : "bbmc",
			});
		}
		});

//	$.ajax({
//		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
//		dataType:'json',
//		success:function(msg){
//			var data = msg;
//			data[0].selected=true;
//			lxCode_ls2 = data[0].lxCode;
//			szhh2 = data[0].szhh;
//			ezhh2 = data[0].ezhh;
//			$("#ld2").combobox({
//				editable:false,
//				data:data,
//				valueField : "id",
//				textField : "text",
//				onSelect : function(node){
//					lxCode_ls2= node.lxCode;
//					szhh2=node.szhh;
//					ezhh2=node.ezhh;
////					alert(lxCode_ls2);
//					initComboQzd3();
//					}
//			});
//		}
//		});
//	setTimeout(function(){
//		initComboQzd3();
//	},1000); 
};
//var initComboQzd3 = function(){
//	$("#qd3").numberbox({
//		precision:3,
//		value:szhh2,
//		min:szhh2,
//		max:ezhh2,
//		onChange: function(newValue,oldValue){
//			szhh2 =newValue;
//		}
//	});
//	$("#zd3").numberbox({
//		precision:3,
//		value:ezhh2,
//		min:szhh2,
//		max:ezhh2,
//		onChange: function(newValue,oldValue){
//			ezhh2= newValue;
//		}
//	});
//};

var initButton2 = function(){
	$("#query2").click(function(){
		var bb2=$("#bb2").combobox("getValue");
//		var ld2=$("#ld2").combobox("getValue");
		document.getElementById("report_qh").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fqshgzw.cpt&__bypagesize__=false&bb="+bb2+
		"&lxcode="+lxCode_ls2+"&szhh="+szhh2+"&ezhh="+ezhh2;
	});
};

$(function(){
	initCombo9();
	initButton2();
});

//================================================沿线设施=============================================
var lxCode_ls3 = '';
var szhh3='';
var ezhh3='';
var initCombo6 = function(){
	var yxdata = getData('','0205','');
	yxdata[0].selected=true;
	$("#yxqdbb").combobox({
		editable:false,
		data :yxdata,
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(node){
			var yxdata2 = getData(node.qmbbid,'0203','');
			var yxdata3 = getData('','0201',yxdata2[0].qmbbid);
			yxdata3[0].selected=true;
			$("#yxdcbb").combobox({
			editable:false,
			data :yxdata3,
			valueField : "bbid",
			textField : "bbmc"
	
		});
		}

	});

	var yxdata2 = getData($("#yxqdbb").combobox('options').data[0].bbid,'0203','');
	var yxdata3 = getData('','0201',yxdata2[0].qmbbid);
	yxdata3[0].selected=true;
	$("#yxdcbb").combobox({
	editable:false,
	data :yxdata3,
	valueField : "bbid",
	textField : "bbmc"

});

//	$.ajax({
//		url: YMLib.url + "lxld/getLxldCombo.do?bmCode="+bmcode,
//		dataType:'json',
//		success:function(msg){
//			var data = msg;
//			data[0].selected=true;
//			lxCode_ls3 = data[0].lxCode;
//			szhh3 = data[0].szhh;
//			ezhh3 = data[0].ezhh;
//			$("#yxld").combobox({
//				editable:false,
//				data:data,
//				valueField : "id",
//				textField : "text",
//				onSelect : function(node){
//					lxCode_ls3= node.lxCode;
//					szhh3=node.szhh;
//					ezhh3=node.ezhh;
//					}
//			});
//		}
//		});
	};

var initButton3 = function(){
	$("#query4").click(function(){
		var dcbb3=$("#yxdcbb").combobox("getValue");
//		var ld4=$("#yxld").combobox("getValue");
		var	qdbb3 = $("#yxqdbb").combobox("getValue");
		document.getElementById("report_yx").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fyxss_gs.cpt&__bypagesize__=false&dcbb="+dcbb3+
		"&lxcode="+lxCode_ls3+"&szhh="+szhh3+"&ezhh="+ezhh3+"&qdbb="+qdbb3;
	});
};
//================================================路段病害情况汇总=============================================
var lxCode_ls4 = '';
var szhh4='';
var ezhh4='';
//var initCombo7 = function(){
//	var ldbhdata = getData('','0205','');
//	ldbhdata[0].selected=true;
//	$("#ldbhqdbb").combobox({
//		editable:false,
//		data :ldbhdata,
//		valueField : "bbid",
//		textField : "bbmc",
//		onSelect : function(node){
//			var ldbhdata2 = getData(node.qmbbid,'0203','');
//			var ldbhdata3 = getData('','0201',ldbhdata2[0].qmbbid);
//			ldbhdata3[0].selected=true;
//			$("#ldbhdcbb").combobox({
//			editable:false,
//			data :ldbhdata3,
//			valueField : "bbid",
//			textField : "bbmc"
//	
//		});
//		}
//
//	});
//
//	var ldbhdata2 = getData($("#ldbhqdbb").combobox('options').data[0].bbid,'0203','');
//	var ldbhdata3 = getData('','0201',ldbhdata2[0].qmbbid);
//	ldbhdata3[0].selected=true;
//	$("#ldbhdcbb").combobox({
//	editable:false,
//	data :ldbhdata3,
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
//			lxCode_ls4 = data[0].lxCode;
//			szhh4 = data[0].szhh;
//			ezhh4 = data[0].ezhh;
//			$("#ldbhld").combobox({
//				editable:false,
//				data:data,
//				valueField : "id",
//				textField : "text",
//				onSelect : function(node){
//					lxCode_ls4= node.lxCode;
//					szhh4=node.szhh;
//					ezhh4=node.ezhh;
//				}
//			});
//		}
//	});
//};

var initCombo7 = function(){
	$("#ldbhqdbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0205",
		textField : "bbmc",
		valueField : "bbid",
		onLoadSuccess : function(){
			qdState = true;
			var data = $("#ldbhqdbb").combobox("getData");
			if(data == null || data.length == 0){
				qdState = false;
				YMLib.UI.Show("没有区段划分的版本，请先创建区段划分版本",2000);
			}else{
				$("#ldbhqdbb").combobox("select",data[0].bbid);
			}
		}
	});
//	$("#ldbhld").combobox({
//		url : YMLib.url + "lxld/getLxldCombo.do?bmCode=" + bmcode,
//		editable : false,
//		valueField : "id",
//		textField : "text",
//		onSelect : function(node){
//			lxCode_ls4 = node.lxCode;
//			ezhh4 = node.ezhh;
//			szhh4 = node.szhh;
//		},
//		onLoadSuccess : function(){
//			var data = $("#ldbhld").combobox("getData");
//			$("#ldbhld").combobox("select",data[0].id);
//		}
//	});
	$("#ldbhdcbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0201",
		textField : "bbmc",
		valueField : "bbid",
		onLoadSuccess : function(){
			dcState = true;
			var data = $("#ldbhdcbb").combobox("getData");
			if(data == null || data.length == 0){
				dcState = false;
				YMLib.UI.Show("没有对应的路况调查的版本，请重新选择区段划分版本",2000);
			}else
				$("#ldbhdcbb").combobox("select",data[0].bbid);
		},
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
						YMLib.UI.Show("没有对应的路面检测的版本，请重新选择区段划分版本",2000);
					}else
						$("#ldbhjcbb").combobox("select",data[0].bbid);
				}
			});
		}
	});
};

var initButton4 = function(){
	$("#query5").click(function(){
		var dcbb4=$("#ldbhdcbb").combobox("getValue");
//		var ld5=$("#ldbhld").combobox("getValue");
		var	qdbb4 = $("#ldbhqdbb").combobox("getValue");
		var jcbb = $("#ldbhjcbb").combobox("getValue");
		document.getElementById("report_ldhz").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Fldbhqkhz.cpt&__bypagesize__=false&dcbb="+dcbb4+
		"&lxcode="+lxCode_ls4+"&szhh="+szhh4+"&ezhh="+ezhh4+"&qdbb="+qdbb4+"&jcbb="+jcbb;
	});
};


//================================================沥青路面养护需求分析汇总表=============================================

var lxCode_ls5 = '';
var szhh5='';
var ezhh5='';
//var initCombo8 = function(){
//	var lqlmdata = getData('','0205','');
//	lqlmdata[0].selected=true;
//	$("#lqlmqdbb").combobox({
//		editable:false,
//		data :lqlmdata,
//		valueField : "bbid",
//		textField : "bbmc",
//		onSelect : function(node){
//			var lqlmdata2 = getData(node.qmbbid,'0203','');
//			var lqlmdata3 = getData('','0201',lqlmdata2[0].qmbbid);
//			lqlmdata3[0].selected=true;
//			$("#lqlmdcbb").combobox({
//			editable:false,
//			data :lqlmdata3,
//			valueField : "bbid",
//			textField : "bbmc"
//	
//		});
//		}
//
//	});
//
//	var lqlmdata2 = getData($("#lqlmqdbb").combobox('options').data[0].bbid,'0203','');
//	var lqlmdata3 = getData('','0201',lqlmdata2[0].qmbbid);
//	lqlmdata3[0].selected=true;
//	$("#lqlmdcbb").combobox({
//	editable:false,
//	data :lqlmdata3,
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
//			lxCode_ls5 = data[0].lxCode;
//			szhh5 = data[0].szhh;
//			ezhh5 = data[0].ezhh;
//			$("#lqlmld").combobox({
//				editable:false,
//				data:data,
//				valueField : "id",
//				textField : "text",
//				onSelect : function(node){
//					lxCode_ls5= node.lxCode;
//					szhh5=node.szhh;
//					ezhh5=node.ezhh;
//				}
//			});
//		}
//	});
//};

var initCombo8 = function(){
	$("#lqlmqdbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0205",
		textField : "bbmc",
		valueField : "bbid",
		onLoadSuccess : function(){
			qdState = true;
			var data = $("#lqlmqdbb").combobox("getData");
			if(data == null || data.length == 0){
				qdState = false;
				YMLib.UI.Show("没有区段划分的版本，请先创建区段划分版本",2000);
			}else{
				$("#lqlmqdbb").combobox("select",data[0].bbid);
			}
		}
	});
//	$("#lqlmld").combobox({
//		url : YMLib.url + "lxld/getLxldCombo.do?bmCode=" + bmcode,
//		editable : false,
//		valueField : "id",
//		textField : "text",
//		onSelect : function(node){
//			lxCode_ls5 = node.lxCode;
//			ezhh5 = node.ezhh;
//			szhh5 = node.szhh;
//		},
//		onLoadSuccess : function(){
//			var data = $("#lqlmld").combobox("getData");
//			$("#lqlmld").combobox("select",data[0].id);
//		}
//	});
	$("#lqlmdcbb").combobox({
		url : YMLib.url + "bbkzb/getBb.do?bblx=0201",
		textField : "bbmc",
		valueField : "bbid",
		onLoadSuccess : function(){
			dcState = true;
			var data = $("#lqlmdcbb").combobox("getData");
			if(data == null || data.length == 0){
				dcState = false;
				YMLib.UI.Show("没有对应的路况调查的版本，请重新选择区段划分版本",2000);
			}else
				$("#lqlmdcbb").combobox("select",data[0].bbid);
		},
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
						YMLib.UI.Show("没有对应的路面检测的版本，请重新选择区段划分版本",2000);
					}else
						$("#lqlmjcbb").combobox("select",data[0].bbid);
				}
			});
		}
	});
};

var initButton5 = function(){
	$("#query6").click(function(){
		var dcbb5=$("#lqlmdcbb").combobox("getValue");
//		var ld6=$("#lqlmld").combobox("getValue");
		var	qdbb5 = $("#lqlmqdbb").combobox("getValue");
		var lqlmjcbb = $("#lqlmjcbb").combobox("getValue");
		document.getElementById("report_lqhz").src=YMLib.reportUrl+"reportlet=hmglyh%2Fdcfx%2Flqlmyhxqfxhz.cpt&__bypagesize__=false&dcbb="+dcbb5+
		"&lxcode="+lxCode_ls5+"&szhh="+szhh5+"&ezhh="+ezhh5+"&qdbb="+qdbb5+"&jcbb="+lqlmjcbb;
	});
};

$(function(){
//	$("#report_lm").css("height",($(document).height()-112)+"px");
//	$("#report_lj").css("height",($(document).height()-112)+"px");
//	$("#report_qh").css("height",($(document).height()-112)+"px");
//	$("#report_yx").css("height",($(document).height()-112)+"px");
//	$("#report_ldhz").css("height",($(document).height()-112)+"px");
//	$("#report_lqhz").css("height",($(document).height()-112)+"px");
	initCombo6();
	initCombo7();
	initCombo8();
	initButton3();
	initButton4();
	initButton5();
	
});






