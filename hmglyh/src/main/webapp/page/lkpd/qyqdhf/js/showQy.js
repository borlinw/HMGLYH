

var chartParam = null;
var lxCode = null;
var szhh = null;
var ezhh = null;

var initCombo = function(){
	$("#gyld").combobox({
		url : YMLib.url + "lxld/getLxldCombo.do?bmCode="+parent.sbBmCode,
		valueField : "id",
		textField : "text",
		panelHeight : "auto",
		onSelect : function(data){
			lxCode = data.lxCode;
			szhh = data.szhh;
			ezhh = data.ezhh;
			chartParam = "lxCode="+data.lxCode+"&bmCode="+parent.sbBmCode
			+"&bbid="+parent.sbBbid+"&szhh="+data.szhh+"&ezhh="+data.ezhh;
			$("#showChart").attr("src","showQyhfChart.jsp");
		},
		onLoadSuccess : function(){
			var data = $("#gyld").combobox("getData");
			$("#gyld").combobox("select",data[0].id);
		}
	});
};

$(function(){
	initCombo();
	
	var params = 'bmName=' + parent.sbBmName + "&bmCode=" + parent.sbBmCode + "&bbid=" + parent.sbBbid;
	src = YMLib.reportUrl + "reportlet="+YMLib.cjkEncode('区域划分导出')+".cpt&"+YMLib.cjkEncode(params);
	$("#table").attr("src",src);
});









