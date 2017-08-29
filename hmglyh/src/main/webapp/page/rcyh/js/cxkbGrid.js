/* 
 * “除雪快报表”的Js脚本 
 * Author : lir 
 */

var currentAction = "";//用于标识操作类型
var currentGridRows;//用于传递DataGrid中的数据
var bmcode = "";//获取登录用户部门编码

/*
 * 处理json数据
 */
var datagridFields =[{
	title : "操作",
	field : "cz",
	align : "center",
	width : 120,
	formatter : function(value,rowData,rowIndex){
		//alert("rowData.state="+rowData.state+"^^"+typeof rowData.state);
		if(rowData.state == "3"){
			return "<font onclick=View('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/view.png' title='查看' /></font>&nbsp;<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' title='编辑' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' title='删除' /></font>&nbsp;<font onclick=Export('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/export.png' title='导出' /></font>";
		}else{
			return "<font onclick=View('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/view.png' title='查看' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' title='删除' /></font>&nbsp;<font onclick=Export('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/export.png' title='导出' /></font>";
		}
	}
},{
	title : "状态",
	field : "state",
	align : "center",
	width : 75,
	formatter : function(value,rowData,rowIndex){
		if(value == "1"){
			return "<font onclick=RequestEdit('"+rowIndex+"') color=blue style=cursor:pointer>--</font>";
		}else if(value == "2"){
			if(bmcode.length == 4){
				return "<font onclick=AgreeEdit('"+rowIndex+"') color=blue style=cursor:pointer>申请修改中</font>";
			}else{
				return "申请修改中";
			}
		}else if(value == "3"){
			return "<font onclick=Edit('"+rowIndex+"') color=green style=cursor:pointer>允许修改</font>";
		}
	}
},{
	title : "填报单位",
	field : "bmname",
	align : "center",
	width : 75
},{
	title : "填报日期",
	field : "tbdateStr",
	align : "center",
	width : 150
},{
	title : "填报人姓名",
	field : "tbrxm",
	align : "center",
	width : 80
},{
	title : "审核人姓名",
	field : "shrxm",
	align : "center",
	width : 80
},{
	title : "路线",
	field : "sddddddd",
	align : "center",
	width : 150,
	formatter : function(value,rowData,rowIndex){
		return rowData.lxcode+"（"+rowData.lxname+"）";
	}
},{
	title : "起止桩号",
	field : "qzzh",
	align : "center",
	width : 250
},{
	title : "降雪时间",
	field : "jxsjStr",
	align : "center",
	width : 150
},{
	title : "停雪时间",
	field : "txsjStr",
	align : "center",
	width : 150
}];

/*
 * 删除
 */
var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridKbid = $("#myGrid").datagrid("getRows")[_index].kbid;
			$.post(YMLib.url +'rcyh/djcx_deleteOneCxkb.do',"kbid="+gridKbid,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("删除成功",1500);
					$("#myGrid").datagrid("reload");
				}else{
					YMLib.UI.Show("删除失败",1500);
				}
			},"json");
		}
	});
};

/*
 * 申请修改
 */
var RequestEdit = function(_index){
	$.messager.confirm('确认申请', '确认申请修改该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridKbid = $("#myGrid").datagrid("getRows")[_index].kbid;
			$.post(YMLib.url +'rcyh/djcx_updateDjcxState.do',"kbid="+gridKbid+"&state=2",function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("申请成功",1500);
					$("#myGrid").datagrid("reload");
				}else{
					YMLib.UI.Show("申请失败",1500);
				}
			},"json");
		}
	});
};

/*
 * 同意申请的修改
 */
var AgreeEdit = function(_index){
	$.messager.confirm('确认同意', '确认同意该条信息的修改申请吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridKbid = $("#myGrid").datagrid("getRows")[_index].kbid;
			$.post(YMLib.url +'rcyh/djcx_updateDjcxState.do',"kbid="+gridKbid+"&state=3",function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("已同意",1500);
					$("#myGrid").datagrid("reload");
				}else{
					YMLib.UI.Show("操作失败，请刷新后重试",1500);
				}
			},"json");
		}
	});
};

//查看“除雪快报表”
function View(_index){
	currentAction = "view";
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	var gridKbid = $("#myGrid").datagrid("getRows")[_index].kbid;
	YMLib.UI.createWindow("view", "查看", "/hmglyh/rcyh/djcx_addCxkb.do?toAdd=false&toView=true&toEdit=false&kbid="+gridKbid, "box-add",760,400);
}

//编辑“除雪快报表”
function Edit(_index){
	currentAction = "edit";
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	var gridKbid = $("#myGrid").datagrid("getRows")[_index].kbid;
	YMLib.UI.createWindow("edit", "编辑", "/hmglyh/rcyh/djcx_addCxkb.do?toAdd=false&toView=false&toEdit=true&kbid="+gridKbid, "box-add",948,400);
}

//导出Excel
function Export(_index){
	var kbidFromGrid = $("#myGrid").datagrid("getRows")[_index].kbid;
	//alert("kbidFromGrid -> "+kbidFromGrid);
	$("#kbidToExportOfJsp").val(kbidFromGrid);
	$("#ExportCxkbForm").attr("action",YMLib.url + "rcyh/djcx_exportCxkb.do");
	$("#ExportCxkbForm").submit();
	//$.post(YMLib.url +'rcyh/djcx_exportCxkb.do',"kbid="+kbidFromGrid,function(){},"json");
}

$(function() {
	YMLib.UI.MaskShow("正在加载...");
	bmcode = YMLib.Tools.getParameter("bmcode");
	//添加按钮
	$("#addCxkbb").click(function(){
		currentAction = "add";
		YMLib.UI.createWindow("add", "添加", "/hmglyh/rcyh/djcx_addCxkb.do?toAdd=true&toView=false&toEdit=false", "box-add",948,400);
	});
	YMLib.Tools.ShowPage();
	YMLib.UI.MaskHide();
});
