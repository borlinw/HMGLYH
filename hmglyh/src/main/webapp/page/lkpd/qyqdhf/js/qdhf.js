var lxCode = null;
var szhh = null;
var ezhh = null;
var bmCode = window.top.loginUserObject.bmcode;
var currentGridRows = null;
var issb = false;
var src = null;
//上报时区域分析用
var sbBmCode = null;
var sbBbid = null;
var sbBmName = window.top.loginUserObject.bmname;

var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qdhfb/queryQdhfb.do",
		queryParams : {
			lxCode : lxCode,
			bbid : $("#bbid").combobox("getValue"),
			szhh : szhh,
			ezhh : ezhh,
			bmCode : bmCode
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
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : [[{
			field : 'lxCode',
			title : '路线编码' ,
			width : 90,
			align : "center"	
 		},{
			field : 'szhh',
			title : '起点桩号' ,
			width : 130,
			align : "center"	
 		},{
			field : 'ezhh',
			title : '止点桩号' ,
			width : 90,
			align : "center"
		},{
			field : 'cd',
			title : '长度（m） ' ,
			width : 90,
			align : "center"
		},{
			field : 'bbid',
			title : '版本' ,
			width : 90,
			align : "center"
		}
		]]	 	
	});
};

var initCombo = function(){
	$("#bbid").combobox({
		url : YMLib.url + "bbkzb/getBbForQdhf.do?bmCode="+bmCode,
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(record){
			if(record.issb == 0)
				issb = false;
			else
				issb = true;
			YMLib.Ajax.POST("qyhfb/queryQyhfb.do","bmCode="+bmCode+"&bbid="+record.bbid,"json",function(data){
				if(data.rows == null || data.rows.length == 0){
					YMLib.UI.Show("没有对应的区域划分，请先进行区域划分",2000);
				}else{
					$("#ldCode").combobox({
						valueField : "qyid",
						textField : "qyName",
						onSelect : function(data){
							lxCode = data.lxCode;
							szhh = data.szhh;
							ezhh = data.ezhh;
						}
					}).combobox("loadData",data.rows);
					$("#ldCode").combobox("select",data.rows[0].qyid);
					initGrid();
				}
			});
		},
		onLoadSuccess : function(){
			var data = $("#bbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有对应的区域区段划分的版本，请先创建版本",2000);
			}else{
				$("#bbid").combobox("select",data[0].bbid);
			}
		}
	});
};

var initButton = function(){
	$("#query").click(function(){
		if($("#ldCode").combobox("getValue") == "")
			YMLib.UI.Show("请选择区域",1000);
		else if($("#bbid").combobox("getValue") == ""){
			YMLib.UI.Show("请选择版本",1000);
		}else{
			$("#myGrid").datagrid("options").queryParams = {
				lxCode : lxCode,
				bbid : $("#bbid").combobox("getValue"),
				szhh : szhh,
				ezhh : ezhh,
				bmCode : bmCode
			};
			$("#myGrid").datagrid("load");
		}
	});
	$("#qdhf").click(function(){
		if($("#ldCode").combobox("getValue") == "")
			YMLib.UI.Show("请选择区域",1000);
		else if($("#bbid").combobox("getValue") == ""){
			YMLib.UI.Show("请选择版本",1000);
		}else{
			if(!issb){
				YMLib.UI.createWindow("qdhfWindow","区段划分","addQdhf.jsp","box-qdhf",900,465);
			}else{
				YMLib.UI.Show("该版本已经上报，不能修改",1000);
			}
		}
	});
	$("#bh").click(function(){
		if($("#ldCode").combobox("getValue") == "")
			YMLib.UI.Show("请选择区域",1000);
		else if($("#bbid").combobox("getValue") == ""){
			YMLib.UI.Show("请选择版本",1000);
		}else{
			YMLib.UI.createWindow("bhShow","病害图表","showChart.jsp","box-qdhf",900,465);
		}
	});
	$("#clear").click(function(){
		if($("#ldCode").combobox("getValue") == "")
			YMLib.UI.Show("请选择区域",1000);
		else if($("#bbid").combobox("getValue") == ""){
			YMLib.UI.Show("请选择版本",1000);
		}else if(issb){
			YMLib.UI.Show("该版本已经上报，不能清空",1000);
		}
		else{
			var params = "lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&bmCode="+bmCode+"&bbid="+$("#bbid").combobox("getValue");
			$.messager.confirm('确认', '是否清空该区域的区段划分？', function(r){
				if(r){
					YMLib.Ajax.POST("qdhfb/clearQdhfb.do",params,"json",function(result){
						if(result){
							YMLib.UI.Show("清空成功",2000);
							$("#myGrid").datagrid("reload");
						}else{
							YMLib.UI.Show("清空失败",2000);
						}
					},function(){
						YMLib.UI.Show("清空失败",2000);
					});
				}
			});
		}
	});
};

var initReportGrid = function(){
	$("#reportGrid").datagrid({
		url : YMLib.url + "qdhfshb/getShbForReport.do",
		queryParams : {
			bmCode:window.top.loginUserObject.bmcode
		},
		border : false,
		fit : true,
		fitColumns : false,
 		loadMsg : '正在加载请稍候...',
// 		pageNumber : 1,
//		pageSize : 10,
//		pageList:[10,20,30],
		striped : true,
 		showFooter : false,
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
			field : '2',
			title : '状态' ,
			width : 130,
			align : "center",
			formatter : function(value,rowData,rowIndex){
//				return rowData.bmCode!=null&&rowData.bmCode != "";
				if(rowData.bmCode!=null&&rowData.bmCode != ""){
					if(rowData.shzt==0)
						return "审核中";
					else if(rowData.shzt == 1)
						return "审核通过";
					else if(rowData.shzt == 2)
						return "<font onClick='ReReport("+rowIndex+")' style='cursor: pointer;'>打回修改</font>";
				}else{
					return "<font onClick='Report("+rowIndex+")' style='cursor: pointer;'>未上报</font>";
				}
			}
 		},{
			field : 'bbname',
			title : '版本' ,
			width : 130,
			align : "center"
		}
		]]
	});
};

var showQd = function(_index){
	currentGridRows = $("#reportGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("qdfx","区段分析","showQd.jsp","",800,450);
};

var showQy = function(_index){
	currentGridRows = $("#reportGrid").datagrid("getRows")[_index];
	sbBmCode = currentGridRows.bmCode1;
	sbBbid = currentGridRows.bbid1;
	YMLib.UI.createWindow("qyfx","区域分析","showQy.jsp","",800,450);
};



var Detail = function(_index){
	currentGridRows = $("#reportGrid").datagrid("getRows")[_index];
	var params = "total=0&bbid="+currentGridRows.bbid1+"&bmCode="+currentGridRows.bmCode1;
	src = YMLib.reportUrl + "reportlet="+YMLib.cjkEncode('hmglyh/区段划分一览表-按单位')+".cpt&"+YMLib.cjkEncode(params);
	YMLib.UI.createWindow("ljdc","区域划分导出","../lkdc/report.jsp","",800,450);
};

var Report = function(_index){
	currentGridRows = $("#reportGrid").datagrid("getRows")[_index];
	$.messager.confirm('确认', '是否上报？', function(r){
		if(r){
			var params = "bbid="+currentGridRows.bbid1+"&bmCode="+currentGridRows.bmCode1+"&sqr="+window.top.loginUserObject.username+
						 "&bbid1="+currentGridRows.bbid1+"&bmCode1="+currentGridRows.bmCode1;
			YMLib.Ajax.POST("qdhfshb/report.do",params,"json",function(data){
				if(data){
					YMLib.UI.Show("上报成功",2000);
					$("#reportGrid").datagrid("reload");
				}else
					YMLib.UI.Show("还未划分完成，不能上报！",2000);
			},function(e){
				YMLib.UI.Show("上报失败！",2000);
			});
		}
	});
};
var ReReport = function(_index){
	currentGridRows = $("#reportGrid").datagrid("getRows")[_index];
	$.messager.confirm('确认', '是否上报？', function(r){
		if(r){
			var params = "bbid="+currentGridRows.bbid1+"&bmCode="+currentGridRows.bmCode1+"&sqr="+window.top.loginUserObject.username+
						 "&bbid1="+currentGridRows.bbid1+"&bmCode1="+currentGridRows.bmCode1;
			YMLib.Ajax.POST("qdhfshb/reReport.do",params,"json",function(data){
				if(data){
					YMLib.UI.Show("上报成功",2000);
					$("#reportGrid").datagrid("reload");
				}else
					YMLib.UI.Show("还未划分完成，不能上报！",2000);
			},function(e){
				YMLib.UI.Show("上报失败！",2000);
			});
		}
	});
};

$(function(){
	initCombo();
	initButton();
	initReportGrid();
});


















