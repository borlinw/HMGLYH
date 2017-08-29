
var xdColumn = [[
    {field:'cc',title:'操作',width:80,align:'center',formatter:function(value,rowData,rowIndex){
    	return "<a href='javascript:void(0);' onclick=xdxq('"+rowData.xcid+"')>详情</a>&nbsp;&nbsp;"+
    	"<a href='javascript:void(0);' onclick=exportXdjl('"+rowData.xcid+"')>导出</a>";
    }},
	{field:'bmcode',title:'部门编码',width:100,align:'center'},
    {field:'username',title:'用户名',width:100,align:'center'},
    {field:'stime',title:'开始时间',width:140,align:'center'},
    {field:'etime',title:'结束时间',width:140,align:'center'},
    {field:'xsld',title:'所属路段',width:160,align:'center'},
    {field:'tq',title:'天气',width:100,align:'center'},
    {field:'jlr',title:'记录人',width:100,align:'center'},
    {field:'fzr',title:'负责人',width:100,align:'center'},
    {field:'bz',title:'备注',width:200,align:'center'}
]];

var initGrid = function(){
	$("#xd").datagrid({
		columns : xdColumn,
		pageNumber : 1,
		pageSize : 10,
		pageList : [10,20,30],
		pagination : true,
		fit : true,
		rownumbers : true,
		toolbar : "#toolbar"
	});
};

var initCombo = function(){
	$("#bmCode").combobox({
		url : YMLib.url + "bm/getBmForXd.do?bmcode=" + $("#bmcode").val(),
		valueField : "id",
		textField : "text",
		panelHeight : "auto",
		width : 150
	});
};

var loadData = function(){
	$("#xd").datagrid({
		url: YMLib.url + 'rcyh/xdjl_getXdsjForXdcx.do',
		queryParams:getParam("fm")	
	});
};

var gisui = new GisUI({
	isShowToolBar : false
});

var xdxq = function(xcid){
	gisui.createWindow({
		title : "巡道详细信息",
		iconCls : "icon-page",
		modal : true,
		width : 950,
		height : 400,
		src : YMLib.url + "rcyh/xdjl_showXdjl.do?xcsj.xcid="+xcid
	});
};

var exportXdjl = function(xcid){
	location.href = YMLib.url + 'rcyh/xdjl_exportXcjlDetail.do?xcsj.xcid='+xcid;
};



$(function(){
	initCombo();
	initGrid();
});

