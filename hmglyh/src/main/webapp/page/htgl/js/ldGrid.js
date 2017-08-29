/*
 * 路段Grid脚本
 * Author : lir
 */
var currentAction = "";//标识操作类型“添加/编辑”
var currentGridRows;//用于传输DataGrid中的数据
var loginUserBmcode = window.top.getLoginUserObject.bmcode;//当前登录用户的部门编码
var loginUserBmname = window.top.getLoginUserObject.bmname;//当前登录用户的部门名称
var loginUserBmlx = window.top.getLoginUserObject.bmlx;//当前登录用户的部门类型（限制路段的相关操作）
var lxcode = "";//路线Code

/*
 * 初始化按钮、Combobox
 */
var initButtons = function(){
	//添加
	$("#addOneLd").click(function(){
		currentAction = "add";
		YMLib.UI.createWindow("add", "添加", "addLd.jsp", "box-add",634,349);
	});
	//下拉框选中查询
	$("#chooseLxcode").combobox({
	    url : YMLib.url +'htglld/createLxCombobox.do?lxQueryType=all', 
	    valueField : 'id',
	    textField : 'text',
	    editable : false,//在这里加显示combobox不能编辑的属性
	    onLoadSuccess : function(){
	    	$("#chooseType").combobox("setValue",lxcode);
	    	YMLib.UI.MaskHide();
	    },
	    onSelect : function(record){
	    	//alert(record.id+"^^"+record.text+"^^^"+record.szhh+"^^^"+record.ezhh);
	    	lxcode = record.id;
	    	$("#myGrid").datagrid("options").queryParams = {
				bmcode : loginUserBmcode,
				lxcode : record.id
			};
			$("#myGrid").datagrid("load");
		}
	});
};

function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addLd.jsp", "box-edit",634,320);
}

var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridLdcode = $("#myGrid").datagrid("getRows")[_index].ldcode;
			$.post(YMLib.url +'htglld/deleteOneLd.do',"ldcode="+gridLdcode,function(result){
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
		url: YMLib.url + "htglld/queryAllBySome.do",
		queryParams: {
			bmcode : loginUserBmcode,
			lxcode : ''
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
	field : "childNum",
	align : "center",
	width : 120,
	formatter : function(value,rowData,rowIndex){
		return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
	}
},{
	title : "路段名称",
	field : "ldname",
	align : "center",
	width : 180
},{
	title : "所属路线编码",
	field : "lxcode",
	align : "center",
	width : 80
},{
	title : "所属路线名称",
	field : "lxname",
	align : "center",
	width : 80
},{
	title : "起点桩号",
	field : "szhh",
	align : "center",
	width : 80
},{
	title : "止点桩号",
	field : "ezhh",
	align : "center",
	width : 80
},{
	title : "里程",
	field : "mileage",
	align : "center",
	width : 60,
	formatter : function(value,rowData,rowIndex){
		return value+"公里";
	}
},{
	title : "所属部门",
	field : "bmname",
	align : "center",
	width : 120
},{
	title : "备注",
	field : "bz",
	align : "center",
	width : 180
}];
/*
 * 页面运行时运行的方法
 */
$(function(){
	YMLib.UI.MaskShow("请求用户信息...");
	//alert("当前登录用户的部门类型为："+loginUserBmlx);
	if(loginUserBmlx == "0101" || loginUserBmlx == "0102" || loginUserBmlx == "0103"){
		initButtons();
		initGrid();
		YMLib.Tools.ShowPage();
	}else{
		YMLib.UI.Show("数据传输错误或您所在的部门没有相关权限。",1500);
	}
});