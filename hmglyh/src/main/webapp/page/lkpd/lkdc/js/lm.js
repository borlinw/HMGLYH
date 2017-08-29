
var lxCode = null;			//路线
var szhh = 0;				//起点桩号
var ezhh = 0;				//止点桩号
var dcbbid = null;			//调查版本
var fx = null;				//方向
var fxState = false;		//方向下拉框是否加载完成
var ldState = false;		//路段下拉框是否加载完成
var bbState = false;		//版本下拉框是否加载完成
var src = null;				//报表用地址
//修改，用于微调
var Edit = function(_index,gridName,_title,_lxid){
	var rowData = $("#"+gridName).datagrid("getRows")[_index];
	var params = "lxid="+_lxid+"&ldid="+rowData.ldid+"&dcry="+window.top.loginUserObject.ryname+"&bbid="+dcbbid;
	if(rowData.dcid == null || rowData.dcid == "")
		params += "&dcid="+window.top.createUUID();
	else
		params += "&dcid="+rowData.dcid;
	src = YMLib.reportUrl + "reportlet=lkdc.cpt&op=write&"+YMLib.cjkEncode(params);
	YMLib.UI.createWindow("lqlmdc",_title,"report.jsp","",734,500,function(){
		$("#"+gridName).datagrid("reload");
	});
};
//查看单条信息，用于导出
var View = function(_index,gridName,_title){
	var rowData = $("#"+gridName).datagrid("getRows")[_index];
	if(rowData.dcid == null || rowData.dcid == ""){
		YMLib.UI.Show("还未填报数据",2000);
	}else{
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=路面调查.cpt&__bypagesize__=false&dcid="+rowData.dcid);
		YMLib.UI.createWindow("lqlmdc",_title,"report.jsp","",734,500);
	}
};

var lqlmColumn = [[{
	field : 'a',
	title : '操作',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		return "<img onclick='View("+rowIndex+",\"lqlm\",\"沥青路面调查\")' style='cursor:pointer' src='../images/icon-view.png'/>&nbsp;" +
				"<img onclick='Edit("+rowIndex+",\"lqlm\",\"沥青路面调查\",\"0101\")' style='cursor:pointer;' src='../images/edit.png'/>";
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
	field : 'pci',
	title : 'PCI',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	title : '龟裂',
	colspan : 3
},{
	title : '块状裂缝',
	colspan : 2
},{
	title : '纵向裂缝',
	colspan : 2
},{
	title : '横向裂缝',
	colspan : 2
},{
	title : '坑槽',
	colspan : 2
},{
	title : '松散',
	colspan : 2
},{
	title : '沉陷',
	colspan : 2
},{
	title : '车辙',
	colspan : 2
},{
	title : '波浪拥包',
	colspan : 2
},{
	field : '20',
	title : '泛油',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[19].ljsj;
		return "";
	}
},{
	field : '21',
	title : '修补',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[20].ljsj;
		return "";
	}
}],[{
	field : '1',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[0].ljsj;
		return "";
	}
},{
	field : '2',
	title : '中',
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
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[4].ljsj;
		return "";
	}
},{
	field : '6',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[5].ljsj;
		return "";
	}
},{
	field : '7',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[6].ljsj;
		return "";
	}
},{
	field : '8',
	title : '轻',
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
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[10].ljsj;
		return "";
	}
},{
	field : '12',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[11].ljsj;
		return "";
	}
},{
	field : '13',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[12].ljsj;
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
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[14].ljsj;
		return "";
	}
},{
	field : '16',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[15].ljsj;
		return "";
	}
},{
	field : '17',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[16].ljsj;
		return "";
	}
},{
	field : '18',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[17].ljsj;
		return "";
	}
},{
	field : '19',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[18].ljsj;
		return "";
	}
}
]];

var snlmColumn = [[{
	field : 'a',
	title : '操作',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		return "<img onclick='View("+rowIndex+",\"snlm\",\"水泥路面调查\")' style='cursor:pointer' src='../images/icon-view.png'/>&nbsp;" +
		"<img onclick='Edit("+rowIndex+",\"snlm\",\"水泥路面调查\",\"0102\")' style='cursor:pointer;' src='../images/edit.png'/>";
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
	field : 'pci',
	title : 'PCI',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	title : '破碎板',
	colspan : 2
},{
	title : '裂缝',
	colspan : 3
},{
	title : '板角断裂',
	colspan : 3
},{
	title : '错台',
	colspan : 2
},{
	field : '11',
	title : '唧泥',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[10].ljsj;
		return "";
	}
},{
	title : '边角剥落',
	colspan : 3
},{
	title : '接缝料损坏',
	colspan : 2
},{
	field : '17',
	title : '坑洞',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[16].ljsj;
		return "";
	}
},{
	field : '18',
	title : '拱起',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[17].ljsj;
		return "";
	}
},{
	field : '19',
	title : '露骨',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[18].ljsj;
		return "";
	}
},{
	field : '20',
	title : '修补',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[19].ljsj;
		return "";
	}
}],[{
	field : '1',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[0].ljsj;
		return "";
	}
},{
	field : '2',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[1].ljsj;
		return "";
	}
},{
	field : '3',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[2].ljsj;
		return "";
	}
},{
	field : '4',
	title : '中',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[3].ljsj;
		return "";
	}
},{
	field : '5',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[4].ljsj;
		return "";
	}
},{
	field : '6',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[5].ljsj;
		return "";
	}
},{
	field : '7',
	title : '中',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[6].ljsj;
		return "";
	}
},{
	field : '8',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[7].ljsj;
		return "";
	}
},{
	field : '9',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[8].ljsj;
		return "";
	}
},{
	field : '10',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[9].ljsj;
		return "";
	}
},{
	field : '11',
	title : '轻',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[10].ljsj;
		return "";
	}
},{
	field : '12',
	title : '中',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[11].ljsj;
		return "";
	}
},{
	field : '13',
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[12].ljsj;
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
	title : '重',
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[14].ljsj;
		return "";
	}
}
]];

var sslmColumn = [[{
	field : 'a',
	title : '操作',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		return "<img onclick='View("+rowIndex+"\"sslm\",\"砂石路面调查\")' style='cursor:pointer' src='../images/icon-view.png'/>&nbsp;" +
		"<img onclick='Edit("+rowIndex+",\"sslm\",\"砂石路面调查\",\"0103\")' style='cursor:pointer;' src='../images/edit.png'/>";
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
	field : 'pci',
	title : 'PCI',
	rowspan : 2,
	align : 'center',
	width : 90
},{
	field : '1',
	title : '路拱不适',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[0].ljsj;
		return "";
	}
},{
	field : '2',
	title : '沉陷',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[1].ljsj;
		return "";
	}
},{
	field : '3',
	title : '波浪搓板',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[2].ljsj;
		return "";
	}
},{
	field : '4',
	title : '车辙',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[3].ljsj;
		return "";
	}
},{
	field : '5',
	title : '坑槽',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[4].ljsj;
		return "";
	}
},{
	field : '6',
	title : '露骨',
	rowspan : 2,
	align : 'center',
	width : 90,
	formatter : function(value,rowData,rowIndex){
		if(rowData.lkdcfb.length != 0)
			return rowData.lkdcfb[5].ljsj;
		return "";
	}
}]];

var initGrid = function(){
	$("#lqlm").datagrid({
		url : YMLib.url + "qmldb/getQmldForLkdc.do",
		queryParams : {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : dcbbid,
			lmlx : 1,
			lxid : '0101',
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
		columns : lqlmColumn
	});
	$("#snlm").datagrid({
		url : YMLib.url + "qmldb/getQmldForLkdc.do",
		queryParams : {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : $("#bbid").combobox("getValue"),
			lmlx : 2,
			lxid : '0102',
			fx : fx
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
		columns : snlmColumn
	});
	$("#sslm").datagrid({
		url : YMLib.url + "qmldb/getQmldForLkdc.do",
		queryParams : {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : $("#bbid").combobox("getValue"),
			lmlx : 3,
			lxid : '0103',
			fx : fx
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
		columns : sslmColumn
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
	//查询
	$("#queryQmld").click(function(){
		dcbbid = $("#bbid").combobox("getValue");
		fx = $("#fx").combobox("getValue");
		//沥青路面
		$("#lqlm").datagrid("options").queryParams = {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : dcbbid,
			lmlx : 1,
			lxid : '0101',
			fx : fx
		};
		$("#lqlm").datagrid("load");
		//水泥路面
		$("#snlm").datagrid("options").queryParams = {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : $("#bbid").combobox("getValue"),
			lmlx : 2,
			lxid : '0102',
			fx : fx
		};
		$("#snlm").datagrid("load");
		//砂石路面
		$("#sslm").datagrid("options").queryParams = {
			bmCode : $("#bmCode").combotree("getValue"),
			ldCode : $("#ldCode").combobox("getValue"),
			dcbbid : $("#bbid").combobox("getValue"),
			lmlx : 3,
			lxid : '0103',
			fx : fx
		};
		$("#sslm").datagrid("load");
	});
	//导入数据
	$("#import").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路况调查的版本，请先创建版本",2000);
			return;
		}
		if($("#ldCode").combobox("getValue") == ""){
			YMLib.UI.Show("请选择具体路段",2000);
			return;
		}
		var params = "dcry="+window.top.loginUserObject.ryname+"&bbid="+$("#bbid").combobox("getValue")+
					 "&lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&fx="+$("#fx").combobox("getValue");
		var index = $("#myTabs").tabs("getTabIndex",$("#myTabs").tabs("getSelected"));
		switch(index){
		case 0: params += "&lxid=0101&condition=and qm.lmlx=1";
				break;
		case 1: params += "&lxid=0102&condition=and qm.lmlx=2";
				break;
		case 2: params += "&lxid=0103&condition=and qm.lmlx=3";
				break;
		}
		
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=路况调查模板.cpt&op=write&"+params);
		YMLib.UI.createWindow("lmdc","路面调查","report.jsp","",734,500,function(){
			switch(index){
			case 0: $("#lqlm").datagrid("reload");
					break;
			case 1: $("#snlm").datagrid("reload");
					break;
			case 2: $("#sslm").datagrid("reload");
					break;
			}
		});
	});
	//导出数据
	$("#export").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路况调查的版本，请先创建版本",2000);
			return;
		}
		if($("#ldCode").combobox("getValue") == ""){
			YMLib.UI.Show("请选择具体路段",2000);
			return;
		}
		var params = "bbid="+$("#bbid").combobox("getValue")+"&lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&fx="+$("#fx").combobox("getValue");
		var index = $("#myTabs").tabs("getTabIndex",$("#myTabs").tabs("getSelected"));
		switch(index){
		case 0: params += "&lxid=0101&lmlx=1";
				break;
		case 1: params += "&lxid=0102&lmlx=2";
				break;
		case 2: params += "&lxid=0103&lmlx=3";
				break;
		}
		
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=路面调查数据.cpt&__bypagesize__=false&"+params);
		YMLib.UI.createWindow("lmdc","路面调查数据","report.jsp","",734,500);
		
	});
	//导出汇总数据
	$("#exportHz").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路况调查的版本，请先创建版本",2000);
			return;
		}
		if($("#ldCode").combobox("getValue") == ""){
			YMLib.UI.Show("请选择具体路段",2000);
			return;
		}
		var params = "dcbbid="+$("#bbid").combobox("getValue")+"&ldCode="+$("#ldCode").combobox("getValue")+"&lxCode="+lxCode+"&bmCode="+$("#bmCode").combotree("getValue")+"&fx="+$("#fx").combobox("getValue")+"&fxName="+$("#fx").combobox("getText");
		var index = $("#myTabs").tabs("getTabIndex",$("#myTabs").tabs("getSelected"));
		switch(index){
		case 0: params += "&lxid=0101&lmlx=1";
				break;
		case 1: params += "&lxid=0102&lmlx=2";
				break;
		case 2: params += "&lxid=0103&lmlx=3";
				break;
		}
		
		location.href = YMLib.url + "qmldb/getLmdcForExport.do?" + encodeURI(params);
	});
};

$(function(){
	initCombo();
	initQuery();
});




























