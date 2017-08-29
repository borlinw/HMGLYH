/*
 * 病害Grid脚本
 * Author : lir
 */

/*
 * 声明一些东西
 */

var fatherNode = parent.treeNode;//父节点的node（来自于病害树）
var currentAction = "";//操作类型（“添加”/“编辑”）
var currentGridRows = "";//某行的数据（用于“编辑”按钮）

/*
 * 初始化按钮
 */
var initButtons = function(){
	//添加
	$("#addOneBh").click(function(){
		currentAction = "add";
		YMLib.UI.createWindow("add", "添加", "addBh.jsp", "box-add",503,278);
	});
	//查询全部
	$("#queryAllToGrid").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			bhid : '',
			qyztStr : ''
		};
		$("#myGrid").datagrid("load");
	});
	//查询状态为“启用”的全部信息
	$("#queryUseing").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			bhid : fatherNode.id,
			qyztStr : 'a'
		};
		$("#myGrid").datagrid("load");
	});
	//查询状态为“禁用”的全部信息
	$("#queryDisable").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			bhid : fatherNode.id,
			qyztStr : 'b'
		};
		$("#myGrid").datagrid("load");
	});
};

function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addBh.jsp", "box-edit",503,278);
}

var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridBhid = $("#myGrid").datagrid("getRows")[_index].bhid;
			$.post(YMLib.url +'htglbhlx/deleteOneBh.do',"bhid="+gridBhid,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("删除成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#bhglTree").tree("reload");
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
			var gridBhid = $("#myGrid").datagrid("getRows")[_index].bhid;
			var gridQyzt = $("#myGrid").datagrid("getRows")[_index].qyzt;
			$.post(YMLib.url +'htglbhlx/updateOneBhQyzt.do',"bhid="+gridBhid+"&qyzt="+gridQyzt,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#bhglTree").tree("reload");
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
		url: YMLib.url + "htglbhlx/queryAllByBhid.do",
		queryParams: {
			bhid : fatherNode.id,
			qyztStr : ''
		},
		pageNumber : 1,
		pageSize : 15,
		//toolbar : "#count",//Grid上的信息栏
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
		if(value == 1){
			return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
		}else if(value > 1){
			return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>";
		}else{
			return "<font color=red style=cursor:pointer>ERROR</font>";
		}
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
	title : "病害名称",
	field : "bhname",
	align : "center",
	width : 180
},{
	title : "单位",
	field : "dw",
	align : "center",
	width : 80,
	formatter : function(value,rowData,rowIndex){
		if(value == null || value == ""){
			return "--";
		}else{
			return value;
		}
	}
},{
	title : "维修时限",
	field : "wxsx",
	align : "center",
	width : 60
},{
	title : "病害描述",
	field : "bhms",
	align : "center",
	width : 200
/*},{
	title : "序号",
	field : "px",
	align : "center",
	width : 30*/
}];
/*
 * 页面运行时运行的方法
 */
$(function(){
	//alert("fatherNode.id="+fatherNode.id+"，fatherNode.text="+fatherNode.text);
	initButtons();
	initGrid();
	//reloadFont();//统计Grid上方的标题栏
	YMLib.Tools.ShowPage();
});