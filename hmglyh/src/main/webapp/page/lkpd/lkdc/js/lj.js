var lxCode = null;			//路线
var szhh = 0;				//起点桩号
var ezhh = 0;				//止点桩号
var dcbbid = null;			//调查版本
var fx = null;				//方向
var fxState = false;		//方向下拉框是否加载完成
var ldState = false;		//路段下拉框是否加载完成
var bbState = false;		//版本下拉框是否加载完成
var src = null;				//报表用地址

var Edit = function(_index){
	var rowData = $("#lj").datagrid("getRows")[_index];
	var params = "lxid=02&ldid="+rowData.ldid+"&dcry="+window.top.loginUserObject.ryname+"&bbid="+dcbbid;
	if(rowData.dcid == null || rowData.dcid == "")
		params += "&dcid="+window.top.createUUID();
	else
		params += "&dcid="+rowData.dcid;
	
	src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=hmglyh/lkdc.cpt&op=write&"+params);
	YMLib.UI.createWindow("ljdc","路基调查","report.jsp","",734,500,function(){
		$("#lj").datagrid("reload");
	});
};

var View = function(_index){
	var rowData = $("#lj").datagrid("getRows")[_index];
	if(rowData.dcid == null || rowData.dcid == "")
		YMLib.UI.Show("还未填报数据",2000);
	else{
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=hmglyh/路基调查.cpt&__bypagesize__=false&dcid="+rowData.dcid);
		YMLib.UI.createWindow("ljdc","路基调查","report.jsp","",734,500);
	}
};

var ljColumn = [[{
	field : 'a',
	title : '操作',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		return "<img onclick='View("+rowIndex+")' style='cursor:pointer' src='../images/icon-view.png'/>&nbsp;" +
		"<img onclick='Edit("+rowIndex+")' style='cursor:pointer;' src='../images/edit.png'/>";
	}
},{
	field : 'lxCode',
	title : '路线编码',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	field : 'lxName',
	title : '路线名称',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	field : 'fxName',
	title : '方向',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	field : 'szhh',
	title : '起点桩号',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	field : 'ezhh',
	title : '止点桩号',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	field : 'sci',
	title : 'SCI',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	field : '1',
	title : '路肩边沟不洁',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[0].ljsj;
		return "";
	}
},{
	title : '路肩损坏',
	colspan : 2
},{
	title : '边坡坍塌',
	colspan : 3
},{
	title : '水毁冲沟',
	colspan : 3
},{
	title : '路基构造物损坏',
	colspan : 3
},{
	field : '13',
	title : '路缘石缺损',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[12].ljsj;
		return "";
	}
},{
	title : '路基沉降',
	colspan : 3
},{
	title : '排水系统淤塞',
	colspan : 2
}],[{
	field : '2',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[1].ljsj;
		return "";
	}
},{
	field : '3',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[2].ljsj;
		return "";
	}
},{
	field : '4',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[3].ljsj;
		return "";
	}
},{
	field : '5',
	title : '中',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[4].ljsj;
		return "";
	}
},{
	field : '6',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[5].ljsj;
		return "";
	}
},{
	field : '7',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[6].ljsj;
		return "";
	}
},{
	field : '8',
	title : '中',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[7].ljsj;
		return "";
	}
},{
	field : '9',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[8].ljsj;
		return "";
	}
},{
	field : '10',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[9].ljsj;
		return "";
	}
},{
	field : '11',
	title : '中',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[10].ljsj;
		return "";
	}
},{
	field : '12',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[11].ljsj;
		return "";
	}
},{
	field : '14',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[13].ljsj;
		return "";
	}
},{
	field : '15',
	title : '中',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[14].ljsj;
		return "";
	}
},{
	field : '16',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[15].ljsj;
		return "";
	}
},{
	field : '17',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[16].ljsj;
		return "";
	}
},{
	field : '18',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[17].ljsj;
		return "";
	}
}]];

var initGrid = function(){
	$("#lj").datagrid({
		url : YMLib.url + "qmldb/getQmldForLkdc.do",
		queryParams : {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : dcbbid,
			lxid : '02',
			fx : fx
		},
		border : false,
		fit : true,
		fitColumns : false,
		loadMsg : '正在加载请稍候...',
		pageNumber : 1,
		pageSize : 10,
		pageList : [10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : ljColumn
	});
};

var initCombo = function(){
	$("#bmCode").combotree({
		url : YMLib.url + "bm/getBmCombotree.do?bmlx=0101&bmcode="+window.top.loginUserObject.bmcode,
		editable : false,
		width : 150,
		onSelect : function(node){
			$("#ldCode").combobox({
				url : YMLib.url + "lxld/getLxldComboForLkdc.do?bmCode="+node.id,
				valueField : "id",
				textField : "text",
				panelHeight : "auto",
				width : 180,
				onSelect : function(data){
					if(data.id != ""){
						lxCode = data.lxCode;
						szhh = data.szhh;
						ezhh = data.ezhh;
					}
				},
				onLoadSuccess : function(){
					var data = $("#ldCode").combobox("getData");
					$("#ldCode").combobox("select",data[0].id);
					ldState = true;
					if(bbState&&fxState)
						initGrid();
				}
			});
		},
		onLoadSuccess : function(){
			var node = $("#bmCode").combotree("tree").tree("find",window.top.loginUserObject.bmcode);
			$("#bmCode").combotree("tree").tree("select",node.target);
			$("#bmCode").combotree("setValue",window.top.loginUserObject.bmcode);
		}
	});
	$("#bbid").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0201",
		valueField : "bbid",
		textField : "bbmc",
		onLoadSuccess : function(){
			var data = $("#bbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有对应的路况调查的版本，请先创建版本",2000);
			}else{
				$("#bbid").combobox("setValue",data[0].bbid);
				bbState = true;
				dcbbid = $("#bbid").combobox("getValue");
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

var initQuery = function(){
	$("#queryQmld").click(function(){
		dcbbid = $("#bbid").combobox("getValue");
		fx = $("#fx").combobox("getValue");
		$("#lj").datagrid("options").queryParams = {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : dcbbid,
			lxid : '02',
			fx : fx
		};
		$("#lj").datagrid("load");
	});
	$("#import").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路况调查的版本，请先创建版本",2000);
			return;
		}
		if($("#ldCode").combobox("getValue") == ""){
			YMLib.UI.Show("请选择具体路段",2000);
			return;
		}
		var params = "lxid=02&dcry="+window.top.loginUserObject.ryname+"&bbid="+$("#bbid").combobox("getValue")+
					 "&lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&fx="+$("#fx").combobox("getValue")+"&condition=";
		
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=hmglyh/路况调查模板.cpt&op=write&"+params);
		YMLib.UI.createWindow("ljdc","路基调查","report.jsp","",734,500,function(){
			$("#lj").datagrid("reload");
		});
	});
	$("#export").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路况调查的版本，请先创建版本",2000);
			return;
		}
		if($("#ldCode").combobox("getValue") == ""){
			YMLib.UI.Show("请选择具体路段",2000);
			return;
		}
		var params = "bbid="+$("#bbid").combobox("getValue")+"&lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+
					 "&fx="+$("#fx").combobox("getValue")+"&lxid=02";
		
		
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=hmglyh/路基调查数据.cpt&__bypagesize__=false&"+params);
		YMLib.UI.createWindow("ljdc","路基调查数据","report.jsp","",734,500);
	});
	$("#exportHz").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路况调查的版本，请先创建版本",2000);
			return;
		}
		if($("#ldCode").combobox("getValue") == ""){
			YMLib.UI.Show("请选择具体路段",2000);
			return;
		}
		var params = "dcbbid="+$("#bbid").combobox("getValue")+"&lxCode="+lxCode+"&ldCode="+$("#ldCode").combobox("getValue")+
					 "&bmCode="+$("#bmCode").combotree("getValue")+
					 "&fx="+$("#fx").combobox("getValue")+"&lxid=02"+"&fxName="+$("#fx").combobox("getText");
		
		location.href = YMLib.url + "qmldb/getLjdcForExport.do?" + encodeURI(params);
		
//		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=hmglyh/路基调查数据.cpt&__bypagesize__=false&"+params);
//		YMLib.UI.createWindow("ljdc","路基调查数据","report.jsp","",734,500);
	});
};

$(function(){
	initCombo();
	initQuery();
});






