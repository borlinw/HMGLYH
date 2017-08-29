/*
 * 人员Grid脚本
 * Author : lir
 */
var currentAction = "";//标识操作类型“添加/编辑”
var currentGridRows;//用于传输DataGrid中的数据
var loginUserBmcode = window.top.getLoginUserObject.bmcode;//当前登录用户的部门编码
var loginUserBmcodeToQuery = window.top.getLoginUserObject.bmcode;//当前登录用户的部门编码
var rzsjYearToQuery = "";

/*
 * 初始化按钮、Combobox
 */
var initButtons = function(){
	//添加
	$("#addOneRy").click(function(){
		currentAction = "add";
		YMLib.UI.createWindow("add", "添加", "addRy.jsp", "box-add",634,320);
	});
	//查询
	$("#queryRy").click(function(){
		var rynameStr = $("#toQueryRyname").val();
		//alert("被查询的人员名称为："+rynameStr);
		$("#myGrid").datagrid("options").queryParams = {
			bmcode : loginUserBmcodeToQuery,
			ryname : rynameStr,
			year : rzsjYearToQuery
		};
		$("#myGrid").datagrid("load");
	});
	//加载部门Combotree
	$("#chooseBmcode").combotree({
		url : YMLib.url + "htglbm/createDapartTree.do?bmcode="+loginUserBmcode,
		panelHeight : 170,
		value : loginUserBmcode,
	    onSelect : function(record){
	    	loginUserBmcodeToQuery = record.id;
	    	//alert("当前选中的部门编码为："+loginUserBmcodeToQuery);
		}
	});
	//加载入职日期列表
	$("#chooseRzsj").combotree({
		url : YMLib.url + "htglry/queryYear.do",
		panelHeight : 170,
		value : "",
	    onSelect : function(record){
	    	rzsjYearToQuery = record.id;
		}
	});
	YMLib.UI.MaskHide();
};

function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addRy.jsp", "box-edit",634,320);
}

var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridRyid = $("#myGrid").datagrid("getRows")[_index].ryid;
			$.post(YMLib.url +'htglry/deleteOneRy.do',"ryid="+gridRyid,function(result){
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
		url: YMLib.url + "htglry/queryAllRy.do",
		queryParams: {
			bmcode : loginUserBmcodeToQuery,
			ryname : "",
			year : ""
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
		if(rowData.username == "" || rowData.username == null){
			return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
		}else{
			return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>";
		}
	}
},{
	title : "启用状态",
	field : "qyzt",
	align : "center",
	width : 80,
	formatter : function(value,rowData,rowIndex){
		return value==1?"<font onclick=ChangeState('"+rowIndex+"') color=green style=cursor:pointer>启用</font>":"<font onclick=ChangeState('"+rowIndex+"') color=red style=cursor:pointer>禁用</font>";
	}
},{
	title : "人员姓名",
	field : "ryname",
	align : "center",
	width : 80
},{
	title : "性别",
	field : "ryxb",
	align : "center",
	width : 50,
	formatter : function(value,rowData,rowIndex){
		if(value == "1"){
			return "女";
		}else if(value == "0"){
			return "男";
		}
	}
},{
	title : "所属部门",
	field : "bmname",
	align : "center",
	width : 150
},{
	title : "职务",
	field : "zw",
	align : "center",
	width : 80
},{
	title : "入职日期",
	field : "rzsj",
	align : "center",
	width : 100
},{
	title : "联系电话",
	field : "lxdh",
	align : "center",
	width : 150
},{
	title : "E-mail",
	field : "email",
	align : "center",
	width : 120
},{
	title : "QQ",
	field : "qq",
	align : "center",
	width : 110
}];

var ChangeState = function(_index){
	$.messager.confirm('确认更改', '确认更改启用状态吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var ryid = $("#myGrid").datagrid("getRows")[_index].ryid;
			var gridQyzt = (Number($("#myGrid").datagrid("getRows")[_index].qyzt)+1)%2;
			$.post(YMLib.url +'htglry/changeState.do',"ryid="+ryid+"&qyzt="+gridQyzt,function(result){
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
 * 页面运行时运行的方法
 */
$(function(){
	YMLib.UI.MaskShow("加载中...");
	//alert("loginUserBmcodeToQuery="+loginUserBmcodeToQuery);
	initButtons();
	initGrid();
	YMLib.Tools.ShowPage();
});