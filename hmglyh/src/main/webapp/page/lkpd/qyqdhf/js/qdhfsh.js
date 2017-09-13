
var currentGridRows = null;
var src=null;

var Detail = function(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	var params = "total=0&bbid="+currentGridRows.bbid+"&bmCode="+currentGridRows.bmCode;
	src = YMLib.reportUrl + "reportlet=hmglyh%2F"+YMLib.cjkEncode('区段划分一览表-按单位')+".cpt&"+YMLib.cjkEncode(params);
	YMLib.UI.createWindow("ljdc","区域划分导出","../lkdc/report.jsp","",800,450);
	
//	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
//	YMLib.UI.createWindow("detail","区段划分详情","qdhfDetail.jsp","box-view",600,350);
};

var Check = function(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("check","区段划分审核","qdhfCheck.jsp","box-view",250,150);
};

var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qdhfshb/getShb.do",
		queryParams : {
			bmCode : $("#bmCode").combobox("getValue"),
			bbid : $("#bbid").combobox("getValue")
		},
		border : false,
		fit : true,
		fitColumns : false,
 		loadMsg : '正在加载请稍候...',
//		pageNumber : 1,
//		pageSize : 10,
//		pageList:[10,20,30],
		striped : true,
// 		showFooter : false,
		singleSelect : true,
		rownumbers : true,
//		pagination : true, //分页
		columns : [[{
			field : '1',
			title : '操作' ,
			width : 90,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				return "<font onClick='Detail("+rowIndex+")' style='cursor: pointer;'>详情</font>";
			}
 		},{
			field : '2',
			title : '状态' ,
			width : 130,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				if(rowData.shzt==0)
					return "<font onClick='Check("+rowIndex+")'>未审核</font>";
				else if(rowData.shzt == 1)
					return "审核通过";
			}
 		},{
 			field : '3',
 			title : "区域分析",
 			width : 90,
 			align : "center",
 			formatter : function(value,rowData,rowIndex){
 				return "<font onClick='showQy("+rowIndex+")' style='cursor: pointer;'>详情</font>";
 			}
 		},{
 			field : '4',
 			title : "区段分析",
 			width : 90,
 			align : "center",
 			formatter : function(value,rowData,rowIndex){
 				return "<font onClick='showQd("+rowIndex+")' style='cursor: pointer;'>详情</font>";
 			}
 		},{
			field : 'bmName',
			title : '部门' ,
			width : 90,
			align : "center"
		},{
			field : 'bbname',
			title : '版本',
			width : 130,
			align : "center"
		}
		]]	 	
	});
};

var initCombo = function(){
	$("#bmCode").combotree({
		url : YMLib.url + "bm/getBmCombotree.do?bmlx=0101&bmcode=0101"
	});
	$("#bbid").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0205",
		valueField : "bbid",
		textField : "bbmc",
		onLoadSuccess : function(){
			var data = $("#bbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有对应的区域区段划分的版本，请先创建版本",2000);
			}else{
				$("#bbid").combobox("select",data[0].bbid);
			}
			initGrid();
		}
	});
};

var initButton = function(){
	$("#query").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			bmCode : $("#bmCode").combobox("getValue"),
			bbid : $("#bbid").combobox("getValue")
		};
		$("#myGrid").datagrid("load");
	});
	$("#export").click(function(){
		var params = "total=1&bbid="+$("#bbid").combobox("getValue")+"&bmCode=0101";
		src = YMLib.reportUrl + "reportlet=hmglyh%2F"+YMLib.cjkEncode('区段划分一览表-按单位')+".cpt&"+YMLib.cjkEncode(params);
		YMLib.UI.createWindow("ljdc","区域划分导出","../lkdc/report.jsp","",800,450);
		
//		var params = "bmCode="+window.top.loginUserObject.bmcode+"&bmName="+window.top.loginUserObject.bmname+"&bbid="+$("#bbid").combobox("getValue");
//		location.href = YMLib.url + "qdhfb/exportQdhf.do?" + encodeURI(params);
	});
};

var showQd = function(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("qdfx","区段分析","showQd.jsp","",800,450);
};

var showQy = function(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	sbBmName = currentGridRows.bmName;
	sbBmCode = currentGridRows.bmCode;
	sbBbid = currentGridRows.bbid;
	YMLib.UI.createWindow("qyfx","区域分析","showQy.jsp","",800,450);
};






$(function(){
	initCombo();
	initButton();
});


















