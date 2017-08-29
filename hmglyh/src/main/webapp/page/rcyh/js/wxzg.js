/* 
 * “维修整改”的Js脚本 
 * Author : lir 
 */

//var bmcode = window.top.getLoginUserObject.bmcode; 

var bmcode = "";
var currentAction = "";//标识操作类型“添加/编辑/其他” 
var currentGridRows;//用于传输DataGrid中的数据 

var datagridFieldstzd = [
		{
			title : "状态",
			field : "tzdzt",
			align : "center",
			width : 130,
			formatter : function(value, rowData, rowIndex) {
				//通知单状态（已送出 0，已送达 1，已回复 2，整改不合格 3，返工已回复 4，整改合格 5） 
				if (value == 0) {
					return "<font color=blue >已送出</font>";
				} else if (value == 1) {
					return "<font color=green >已送达</font>";
				} else if (value == 2) {
					return "<font onclick=HfdSh('" + rowIndex
							+ "') color=green style=cursor:pointer>已回复</font>";
				} else if (value == 3) {
					return "<font color=red >整改不合格</font>";
				} else if (value == 4) {
					return "<font onclick=HfdSh('"
							+ rowIndex
							+ "') color=green style=cursor:pointer>返工已回复</font>";
				} else if (value == 5) {
					//return "<font onclick=ViewHfdOfTzd('"+rowIndex+"') color=green style=cursor:pointer>整改合格</font>"; 
					return "<font color=green >整改合格</font>";
				}
			}
		},{
			/*title : "查看",
			field : "aaaaa",
			align : "center",
			width : 75,
			formatter : function(value, rowData, rowIndex) {
				//通知单状态（已送出 0，已送达 1，已回复 2，整改不合格 3，返工已回复 4，整改合格 5） 
				if (rowData.tzdzt != 0 && rowData.tzdzt != 1) {
					return "<font onclick=ViewHfdOfTzd('" + rowIndex
							+ "') color=blue style=cursor:pointer>查看回复单</font>";
				} else {
					return "<font color='#888' >查看</font>";
				}
			}
		}, {*/
			//title : "查看2（两单通用）",
			title : "查看",
			field : "vvvv",
			align : "center",
			width : 75,
			formatter : function(value, rowData, rowIndex) {
				return "<font onclick=ViewTzdAndHfd('" + rowIndex + "') color=blue style=cursor:pointer>查看</font>";
			}
		}, {
			title : "通知单序列号",
			field : "tzdxlj",
			align : "center",
			width : 75
		}, {
			title : "填表单位",
			field : "tbbmname",
			align : "center",
			width : 75
		}, {
			title : "送表单位",
			field : "sbbmname",
			align : "center",
			width : 75
		}, {
			title : "位置",
			field : "wz",
			align : "center",
			width : 130
		}, {
			title : "要求",
			field : "yq",
			align : "center",
			width : 60
		}, {
			title : "要求完成时间",
			field : "sxtime",
			align : "center",
			width : 88
		}, {
			title : "检查人姓名",
			field : "tbrxm",
			align : "center",
			width : 80
		}, {
			title : "送单时间",
			field : "sdtime",
			align : "center",
			width : 88
		}, {
			title : "存在问题",
			field : "czwt",
			align : "center",
			width : 150
		}, {
			title : "整改要求",
			field : "zgyq",
			align : "center",
			width : 150
		}, {
			title : "接单人姓名",
			field : "jdrxm",
			align : "center",
			width : 88
		}, {
			title : "接单时间",
			field : "jdtime",
			align : "center",
			width : 88
		} ];

var datagridFieldshfd = [
		{
			title : "状态",
			field : "tzdzt",
			align : "center",
			width : 130,
			formatter : function(value, rowData, rowIndex) {
				if (rowData.hfdid == null || rowData.hfdid == "") {
					return "<font onclick=AddHfd('" + rowIndex
							+ "') color=red style=cursor:pointer >待回复</font>";
				} else {
					//通知单状态（已送出 0，已送达 1，已回复 2，整改不合格 3，返工已回复 4，整改合格 5） 
					if (value == 3) {
						return "<font onclick=EditHfd('"
								+ rowIndex
								+ "') color=red style=cursor:pointer>整改不合格</font>";
					} else if (value == 5) {
						return "<font onclick=ViewHfdOfHfd('"
								+ rowIndex
								+ "') color=green style=cursor:pointer>整改合格</font>";
					} else {
						return "<font color=blue style=cursor:pointer>待检验</font>";
					}
				}
			}
		},{
			/*title : "操作",
			field : "cz",
			align : "center",
			width : 130,
			formatter : function(value, rowData, rowIndex) {
				return "<font onclick=ViewZgtzd('" + rowIndex
						+ "') color=blue style=cursor:pointer>查看</font>";
			}
		},{*/
			//title : "查看2（两单通用）",
			title : "查看",
			field : "vvvv",
			align : "center",
			width : 75,
			formatter : function(value, rowData, rowIndex) {
				//之所以用两种方式（与通知单的查看不同），是因为这个的查看需要一个对所属通知单修改的操作
				return "<font onclick=ViewTzdAndHfdOfHfd('" + rowIndex + "') color=blue style=cursor:pointer>查看</font>";
			}
		}, {
			title : "通知单编号",
			field : "tzdxlj",
			align : "center",
			width : 100
		}, {
			title : "填报人",
			field : "tbrxm",
			align : "center",
			width : 60
		}, {
			title : "要求",
			field : "yq",
			align : "center",
			width : 50
		}, {
			title : "位置",
			field : "wz",
			align : "center",
			width : 150
		}, {
			title : "存在问题",
			field : "czwt",
			align : "center",
			width : 200
		}, {
			title : "整改要求",
			field : "zgyq",
			align : "center",
			width : 200
		} ];

//“整改通知单”中的添加 
var initButtons = function() {
	$("#addWxzgtzd").click(
			function() {
				//    currentAction = "add"; 
				YMLib.UI.createWindow("add", "整改通知单",
						"/hmglyh/rcyh/wxzg_zgtzd.do?add=true", "", 673, 392);
			});
};

//添加回复单（整改回复单DataGrid中的“待回复”的点击事件） 
function AddHfd(_index) {
	//currentAction = "add"; 
	currentGridRows = $("#zghfdGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("add", "编写维修整改回复单",
			"/hmglyh/rcyh/wxzg_zghfd.do?add=true", "", 673, 392);
}

//修改回复单（整改不合格之后的返工） 
function EditHfd(_index) {
	currentAction = "edit";
	var tzdidOfGrid = currentGridRows = $("#zghfdGrid").datagrid("getRows")[_index].tzdid;
	currentGridRows = $("#zghfdGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("edit", "返工 - 整改回复单",
			"/hmglyh/rcyh/wxzg_zghfd.do?fg=true&add=false&sh=false&tzdid="
					+ tzdidOfGrid, "", 673, 392);
};

//审核回复单 
function HfdSh(_index) {
	//currentAction = "sh"; 
	var tzdidOfGrid = currentGridRows = $("#zgtzdGrid").datagrid("getRows")[_index].tzdid;
	currentGridRows = $("#zgtzdGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("add", "审核 - 回复单",
			"/hmglyh/rcyh/wxzg_zghfd.do?sh=true&tzdid=" + tzdidOfGrid, "", 673,
			392);
};

//通知单中“审核通过”后的点击事件 
function ViewHfdOfTzd(_index) {
	var tzdidOfGrid = currentGridRows = $("#zgtzdGrid").datagrid("getRows")[_index].tzdid;
	currentGridRows = $("#zgtzdGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("view", "查看 - 回复单",
			"/hmglyh/rcyh/wxzg_zghfd.do?view=true&tzdid=" + tzdidOfGrid, "",
			673, 392);
};

//回复单中“审核通过”后的点击事件 
function ViewHfdOfHfd(_index) {
	var tzdidOfGrid = currentGridRows = $("#zghfdGrid").datagrid("getRows")[_index].tzdid;
	currentGridRows = $("#zghfdGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("view", "查看 - 回复单",
			"/hmglyh/rcyh/wxzg_zghfd.do?view=true&tzdid=" + tzdidOfGrid, "",
			673, 392);
};

/*
 * “通知单”中的新版查看按钮
 */
function ViewTzdAndHfd(_index) {
	currentGridRows = $("#zgtzdGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("view", "查看",YMLib.url+ "/page/rcyh/viewTzdAndHfd.jsp", "",673, 392);
};


//“回复单”中的查看按钮 （老版，预备废弃）
function ViewZgtzd(_index) {
	currentAction = "view";
	currentGridRows = $("#zghfdGrid").datagrid("getRows")[_index];
	//alert("currentGridRows.tzdzt="+currentGridRows.tzdzt); 
	//通知单状态（已送出 0，已送达 1，已回复 2，整改不合格 3，返工已回复 4，整改合格 5） 
	if (currentGridRows.tzdzt == 0 || currentGridRows.tzdzt == "0") {
		//如果其所对应的“整改通知单”未被查看（接单人和接单时间未添加） 
		$.ajax({
			url : YMLib.url + "rcyhwxzg/UpdateTzdOfJd.do?tzdid="
					+ currentGridRows.tzdid + "&jdusername="
					+ window.top.getLoginUserObject.username,
			type : "post",
			dataType : "text",
			success : function(result) {
				//alert("resule="+result); 
				YMLib.UI.createWindow("view", "查看 - 维修整改通知单",
						"/hmglyh/rcyh/wxzg_zgtzd.do?view=true&tzdid="
								+ currentGridRows.tzdid, "", 673, 392);
			},
			error : function(result) {
				YMLib.UI.Show("数据操作错误,请刷新后重试。", 1500);
			}
		});
	} else {
		//如果其所对应的“整改通知单”已被查看（接单人和接单时间被添加） 
		YMLib.UI.createWindow("view", "查看 - 维修整改通知单",
				"/hmglyh/rcyh/wxzg_zgtzd.do?view=true&tzdid="
						+ currentGridRows.tzdid, "", 673, 392);
	}
};

//“回复单”中的查看按钮
function ViewTzdAndHfdOfHfd(_index) {
	currentGridRows = $("#zghfdGrid").datagrid("getRows")[_index];
	//通知单状态（已送出 0，已送达 1，已回复 2，整改不合格 3，返工已回复 4，整改合格 5） 
	if (currentGridRows.tzdzt == 0 || currentGridRows.tzdzt == "0") {
		//如果其所对应的“整改通知单”未被查看（接单人和接单时间未添加） 
		$.ajax({
			url : YMLib.url + "rcyhwxzg/UpdateTzdOfJd.do?tzdid="
					+ currentGridRows.tzdid,
			type : "post",
			dataType : "text",
			success : function(result) {
				//alert("resule="+result); 
				YMLib.UI.createWindow("view", "查看 - 维修整改通知单",
						"/hmglyh/rcyh/wxzg_zgtzd.do?view=true&tzdid="
								+ currentGridRows.tzdid, "", 673, 392);
			},
			error : function(result) {
				YMLib.UI.Show("数据操作错误,请刷新后重试。", 1500);
			}
		});
	} else {
		//如果其所对应的“整改通知单”已被查看（接单人和接单时间被添加） 
		YMLib.UI.createWindow("view", "查看",YMLib.url+ "/page/rcyh/viewTzdAndHfd.jsp", "",673, 392);
		//YMLib.UI.createWindow("view", "查看 - 维修整改通知单","/hmglyh/rcyh/wxzg_zgtzd.do?view=true&tzdid=" + currentGridRows.tzdid, "", 673, 392);
	}
};

var initGrid = function() {

	/*$('#zgtzdGrid').datagrid({ 

	

	    border : false, 

	

	    fit : true, 

	

	    fitColumns : false, 

	

	    loadMsg : '正在加载请稍候...', 

	

	    url : YMLib.url +'rcyh/wxzg_queryAllOfTzd.do', 

	

	    queryParams: { 

	

	        //tbbmcode: bmcode 

	

	        tbbmcode : $("#bmcode").val() 

	

	    }, 

	

	    pageNumber : 1, 

	

	    pageSize : 15, 

	

	    pageList : [ 15, 25, 35 ], 

	

	    striped : true, 

	

	    showFooter : false, 

	

	    singleSelect : true, 

	

	    rownumbers : true, 

	

	    pagination : true, 

	

	    selectOnCheck : false, 

	

	    checkOnSelect : false, 

	

	    columns:[datagridFieldstzd] 

	

	});*/

	/*$('#zghfdGrid').datagrid({ 

	

	    border : false, 

	

	    fit : true, 

	

	    fitColumns : false, 

	

	    loadMsg : '正在加载请稍候...', 

	

	    url : YMLib.url +'rcyh/wxzg_queryAllOfHfd.do', 

	

	    queryParams: { 

	

	        //sbbmcode : bmcode 

	

	        sbbmcode : $("#bmcode").val() 

	

	    }, 

	

	    pageNumber : 1, 

	

	    pageSize : 15, 

	

	    pageList : [ 15, 25, 35 ], 

	

	    striped : true, 

	

	    showFooter : false, 

	

	    singleSelect : true, 

	

	    rownumbers : true, 

	

	    pagination : true, 

	

	    selectOnCheck : false, 

	

	    checkOnSelect : false, 

	

	    columns:[datagridFieldshfd] 

	

	});*/

};

$(function() {

	bmcode = $("#bmcode").val();

	//alert("当前登录用户的部门编码为："+bmcode); 

	initButtons();

	initGrid();

	YMLib.Tools.ShowPage();

});
