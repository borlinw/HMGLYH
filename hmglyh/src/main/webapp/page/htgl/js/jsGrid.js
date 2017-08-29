/*
 * 角色Grid脚本
 * Author : lir
 */
var currentAction = "";//标识操作类型“添加/编辑”
var currentGridRows;//用于传输DataGrid中的数据
var loginUserBmcode = window.top.getLoginUserObject.bmcode;//当前登录用户的部门编码
var loginUserBmcodeToQuery = window.top.getLoginUserObject.bmcode;//当前登录用户的部门编码

function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addJs.jsp", "box-edit",421,300);
}

var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridJsid = $("#myGrid").datagrid("getRows")[_index].jsid;
			$.post(YMLib.url +'htgljs/deleteOneJs.do',"jsid="+gridJsid,function(result){
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
 * 初始化Grid
 */
var initGrid = function(){
	$('#myGrid').datagrid({
		border : false,
		fit : true,
		fitColumns : false,
		loadMsg : '正在加载请稍候...',
		url: YMLib.url + "htgljs/queryAllJs.do",
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
		//childNum
		if(rowData.childNum != 0){
			return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>";
		}else if(rowData.childNum == 0){
			return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
		}else{
			return "<font color=red style=cursor:pointer>数据出错</font>";
		}
	}
},{
	title : "角色名称",
	field : "jsname",
	align : "center",
	width : 120
},{
	title : "角色描述",
	field : "jsms",
	align : "center",
	width : 180
}];
/*
 * 页面运行时运行的方法
 */
$(function(){
	YMLib.UI.MaskShow("加载中...");
	//初始化“添加”按钮
	$("#addOneJs").click(function(){
		currentAction = "add";
		YMLib.UI.createWindow("add", "添加", "addJs.jsp", "box-add",530,300);
	});
	initGrid();//加载Grid信息
	YMLib.UI.MaskHide();
	YMLib.Tools.ShowPage();
});