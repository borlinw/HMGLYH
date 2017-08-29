var lxCode = null;
var szhh = null;
var ezhh = null;
var fxState = false;
var ldState = false;
var bbState = false;

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
			if(bbState&&fxState)
				initGrid();
		}
	});
	$("#bbid").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0203",
		valueField : "bbid",
		textField : "bbmc",
		onLoadSuccess : function(){
			var data = $("#bbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有对应的路况评定的版本，请先创建版本",2000);
			}else{
				$("#bbid").combobox("setValue",data[0].bbid);
				bbState = true;
				if(ldState&&fxState)
					initGrid();
			}
		}
	});
	$("#fx").combobox({
		url : YMLib.url + "htglmjlx/createCombobox.do?typecodeStr=03",
		valueField : "id",
		textField : "text",
		onLoadSuccess : function(){
			var data = $("#fx").combobox("getData");
			$("#fx").combobox("setValue",data[0].id);
			fxState = true;
			fx = data[0].id;
			if(ldState&&bbState)
				initGrid();
		}
	});
};

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
	$("#addLkpd").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路况评定的版本，请先创建版本",2000);
			return;
		}
		YMLib.UI.createWindow("createWindow","生成路况评定明细","addlkpd.jsp","box-add",330,250);
	});
	$("#exportMxb").click(function(){
		var params = "lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&pdbbid="+$("#bbid").combobox("getValue")+"&fx="+$("#fx").combobox("getValue")+
		"&isgs="+$("#isgs").combobox("getValue")+"&lmlx="+$("#lmlx").combobox("getValue")+"&fxName="+encodeURI($("#fx").combobox("getText"));
//		alert(params);
		location.href=YMLib.url+"qmldb/exportMxb.do?"+params;
	});
};

var column = [[{
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
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : column
	});
};

$(function(){
	initCombo();
	initButton();
});












