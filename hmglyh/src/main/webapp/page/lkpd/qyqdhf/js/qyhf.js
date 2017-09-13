var lxCode = null;
var szhh = null;
var ezhh = null;
var bmCode = window.top.loginUserObject.bmcode;
var ldState = false;
var bbState = false;
var src = null;
var chartParam = null;

var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qyhfb/queryQyhfb.do",
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
	$("#ldCode").combobox({
		url : YMLib.url + "lxld/getLxldCombo.do?bmCode="+window.top.loginUserObject.bmcode,
		valueField : "id",
		textField : "text",
		onSelect : function(data){
			lxCode = data.lxCode;
			szhh = data.szhh;
			ezhh = data.ezhh;
		},
		onLoadSuccess : function(){
			var data = $("#ldCode").combobox("getData");
			$("#ldCode").combobox("select",data[0].id);
			ldState = true;
			if(bbState)
				initGrid();
		}
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
				$("#bbid").combobox("setValue",data[0].bbid);
				bbState = true;
				if(ldState)
					initGrid();
			}
		}
	});
};

var initButton = function(){
	$("#query").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			lxCode : lxCode,
			bbid : $("#bbid").combobox("getValue"),
			szhh : szhh,
			ezhh : ezhh,
			bmCode : bmCode
		};
		$("#myGrid").datagrid("load");
	});
	$("#qyhf").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的区域区段划分的版本，请先创建版本",2000);
		}else{
			var params = "lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&bmCode="+bmCode+"&bbid="+$("#bbid").combobox("getValue");
			YMLib.Ajax.POST("qyhfb/isUsed.do",params,"json",function(result){
				if(result){
					YMLib.UI.Show("区域划分已经被使用，不能重新划分",2000);
				}else{
					YMLib.UI.createWindow("qyhfWindow","区域划分","addQyhf2.jsp","box-qyhf",450,250,function(){
						$("#myGrid").datagrid("load");
					});
				}
			},function(){
				YMLib.UI.Show("后台发生错误",2000);
			});
		}
	});
	$("#showChart").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的区域区段划分的版本，请先创建版本",2000);
		}else{
			chartParam = "lxCode="+lxCode+"&bmCode="+window.top.loginUserObject.bmcode
			+"&bbid="+$("#bbid").combobox("getValue")+"&szhh="+szhh+"&ezhh="+ezhh;
			YMLib.UI.createWindow("chartWindow","图形视图","showQyhfChart.jsp","box-qyhf",650,400);
		}
	});
	
	$("#clear").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的区域区段划分的版本，请先创建版本",2000);
		}else{
			var params = "lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&bmCode="+bmCode+"&bbid="+$("#bbid").combobox("getValue");
			$.messager.confirm('确认', '是否清空该路段的区域划分？', function(r){
				if(r){
					YMLib.Ajax.POST("qyhfb/clearQyhfb.do",params,"json",function(result){
						if(result.result > 0){
							$("#myGrid").datagrid("reload");
							YMLib.UI.Show("清空成功",2000);
						}else if(result.result == -2){
							YMLib.UI.Show("区域划分已经被使用，不能清空",2000);
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
	$("#export").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的区域区段划分的版本，请先创建版本",2000);
		}else{
//			location.href = YMLib.url + "qyhfb/exportQyhf.do?bmCode="+window.top.loginUserObject.bmcode+"&bbid="+$("#bbid").combobox("getValue")+"&bmName="+window.top.loginUserObject.bmname;
			var params = 'bmName=' + window.top.loginUserObject.bmname + "&bmCode=" + window.top.loginUserObject.bmcode + "&bbid=" + $("#bbid").combobox("getValue");
			src = YMLib.reportUrl + "reportlet=hmglyh%2F"+YMLib.cjkEncode('区域划分导出')+".cpt&"+YMLib.cjkEncode(params);
			YMLib.UI.createWindow("ljdc","区域划分导出","../lkdc/report.jsp","",800,450);
		}
	});
	
	$("#copy").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的区域区段划分的版本，请先创建版本",2000);
			return;
		}
		bbid = $("#bbid").combobox("getValue");
		YMLib.UI.createWindow("copyData","沿用之前数据","copy.jsp","",400,200,function(){
			$("#myGrid").datagrid("options").queryParams = {
				lxCode : lxCode,
				bbid : $("#bbid").combobox("getValue"),
				szhh : szhh,
				ezhh : ezhh,
				bmCode : bmCode
			};
			$("#myGrid").datagrid("load");
		});
	});
};

$(function(){
	initCombo();
	initButton();
	initGrid();
});


















