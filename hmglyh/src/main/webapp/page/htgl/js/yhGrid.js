/*
 * 用户Grid脚本
 * Author : lir
 */
var currentAction = "";//标识操作类型“添加/编辑”
var currentGridRows;//用于传输DataGrid中的数据
var loginUserBmcode = window.top.getLoginUserObject.bmcode;//当前登录用户的部门编码
var loginUserBmcodeToQuery = window.top.getLoginUserObject.bmcode;//当前登录用户的部门编码

/*
 * 初始化按钮、Combobox
 */
var initButtons = function(){
	//添加
	$("#addOneYh").click(function(){
		currentAction = "add";
		YMLib.UI.createWindow("add", "添加", "addYh.jsp", "box-add",530,300);
	});
	//加载部门Combotree
	$("#chooseBmcode").combotree({
		url : YMLib.url + "htglbm/createDapartTree.do?bmcode="+loginUserBmcode,
		panelHeight : 170,
		value : loginUserBmcode,
	    onSelect : function(record){
	    	loginUserBmcodeToQuery = record.id;
	    	$("#myGrid").datagrid("options").queryParams = {
				bmcode : loginUserBmcodeToQuery
			};
			$("#myGrid").datagrid("load");
		}
	});
	YMLib.UI.MaskHide();
};

function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addYh.jsp", "box-edit",421,203);
}

var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridUsername = $("#myGrid").datagrid("getRows")[_index].username;
			$.post(YMLib.url +'htglyh/deleteOneYh.do',"username="+gridUsername,function(result){
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

var UpdateSfqy = function(_index){
	$.messager.confirm('确认更改', '确认更改使用状态吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridUsername = $("#myGrid").datagrid("getRows")[_index].username;
			var gridQyzt = $("#myGrid").datagrid("getRows")[_index].qyzt;
			$.post(YMLib.url +'htglyh/updateOneYhQyzt.do',"username="+gridUsername+"&qyzt="+gridQyzt,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
				}else{
					YMLib.UI.Show("更改失败",1500);
				}
			},"json");
		}
	});
};

/*
 * 初始化Grid
 */
var initGrid = function(){
	$('#myGrid').datagrid({
		border : false,
		fit : true,
		fitColumns : false,
		loadMsg : '正在加载请稍候...',
		url: YMLib.url + "htglyh/queryAll.do",
		queryParams: {
			bmcode : loginUserBmcodeToQuery
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
		columns:[datagridFields]
	});
};
/*
 * 处理json数据
 */
var datagridFields =[{
	title : "操作",
	field : "cz",
	align : "center",
	width : 80,
	formatter : function(value,rowData,rowIndex){
		return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
	}
},{
	title : "启用状态",
	field : "qyzt",
	align : "center",
	width : 75,
	formatter : function(value,rowData,rowIndex){
		if(rowData.childNum > 1){
			return "--";
		}else{
			return value===1?"<font onclick=UpdateSfqy('"+rowIndex+"') color=green style=cursor:pointer>启用</font>":"<font onclick=UpdateSfqy('"+rowIndex+"') color=red style=cursor:pointer>禁用</font>";
		}
	}
},{
	title : "用户名",
	field : "username",
	align : "center",
	width : 100
},{
	title : "人员名称",
	field : "ryname",
	align : "center",
	width : 80
},{
	title : "所属部门",
	field : "bmname",
	align : "center",
	width : 300
},{
	title : "角色",
	field : "jsname",
	align : "center",
	width : 150
}];
/*
 * 页面运行时运行的方法
 */
$(function(){
	YMLib.UI.MaskShow("加载中...");
	initButtons();
	initGrid();
	YMLib.Tools.ShowPage();
});