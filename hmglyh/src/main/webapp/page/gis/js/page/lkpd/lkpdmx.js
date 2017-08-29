var lxCode = null;
var szhh = null;
var ezhh = null;
var fxState = false;
var ldState = false;
var bbState = false;


var initButton = function(){
	$("#getLkpd").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			lxCode : lxCode,
			szhh : szhh,
			ezhh : ezhh,
			pdbbid : $("#bbid").combobox("getValue"),
			fx : $("#fx").combobox("getValue"),
			isgs : $("#isgs").combobox("getValue"),
			lmlx : $("#lmlx").combobox("getValue")
		};
		$("#myGrid").datagrid("load");
	});
};

var column = [[
{field:"ck",checkbox:true,rowspan:2},
{
	field : "lxCode",
	title : "路线编码",
	align : "center",
	rowspan : 2,
	width : 90
},{
	field : "1",
	title : "桩号",
	align : "center",
	rowspan : 2,
	width : 130,
	formatter : function(value,rowData,rowIndex){
		var zh = "K"+rowData.szhh+"-K"+rowData.ezhh;
		return zh;
	}
},{
	field : "cd",
	title : "长度",
	align : "center",
	rowspan : 2,
	width : 130
},{
	field : "mqi",
	title : "MQI",
	align : "center",
	rowspan : 2,
	width : 90
},{
	field : "pqi",
	title : "路面PQI",
	align : "center",
	rowspan : 2,
	width : 90
},{
	title : "路面分项指标",
	colspan : 5
},{
	field : "sci",
	title : "路基SCI",
	align : "center",
	rowspan : 2,
	width : 90
},{
	field : "bci",
	title : "桥隧构造物BCI",
	align : "center",
	rowspan : 2,
	width : 90
},{
	field : "tci",
	title : "沿线设施TCI",
	align : "center",
	rowspan : 2,
	width : 90
}],[{
	field : "pci",
	title : "PCI",
	align : "center",
	rowspan : 2,
	width : 90
},{
	field : "rqi",
	title : "RQI",
	align : "center",
	rowspan : 2,
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(value == 0)
			return "";
		else
			return value;
	}
},{
	field : "rdi",
	title : "RDI",
	align : "center",
	rowspan : 2,
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(value == 0)
			return "";
		else
			return value;
	}
},{
	field : "sri",
	title : "SRI",
	align : "center",
	rowspan : 2,
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(value == 0)
			return "";
		else
			return value;
	}
},{
	field : "pssi",
	title : "PSSI",
	align : "center",
	rowspan : 2,
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(value == 0)
			return "";
		else
			return value;
	}
}]];

var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qmldb/getMxb.do",
		queryParams : {
			lxCode : lxCode,
			szhh : szhh,
			ezhh : ezhh,
			pdbbid : $("#bbid").combobox("getValue"),
			fx : $("#fx").combobox("getValue"),
			isgs : 1,
			lmlx : 1
		},
		border : false,
		fit : true,
		fitColumns : false,
 		loadMsg : '正在加载请稍候...',
		pageNumber : 1,
		pageSize : 10,
		pageList:[10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : false,
		rownumbers : true,
		pagination : true, //分页
		columns : column,
		toolbar:'#toolbar'
	});
};

$(function(){
	initCombo();
	initButton();
});












