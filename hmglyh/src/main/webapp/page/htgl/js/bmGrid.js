/*
 * 部门Grid脚本
 * Author : lir
 */

/*
 * 声明一些东西
 */

var node = parent.node;//父节点的node（来自于部门树）
var currentAction = "";//操作类型（“添加”/“编辑”）
var currentGridRows = "";//某行的数据（用于“编辑”按钮）

function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addBm.jsp", "box-edit",634,320);
}

var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridBmcode = $("#myGrid").datagrid("getRows")[_index].bmcode;
			$.post(YMLib.url +'htglbm/deleteOneBm.do',"bmcode="+gridBmcode,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("删除成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#bmTree").tree("reload");
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
			var gridBmcode = $("#myGrid").datagrid("getRows")[_index].bmcode;
			var gridQyzt = $("#myGrid").datagrid("getRows")[_index].qyzt;
			$.post(YMLib.url +'htglbm/updateOneBmQyzt.do',"bmcode="+gridBmcode+"&qyzt="+gridQyzt,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#bmTree").tree("reload");
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
		url: YMLib.url + "htglbm/queryAllByBmcode.do",
		queryParams: {
			bmcode : node.id
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
	title : "部门名称",
	field : "bmname",
	align : "center",
	width : 130
},{
	title : "部门编码",
	field : "bmzscode",
	align : "center",
	width : 80
},{
	title : "负责人",
	field : "fzr",
	align : "center",
	width : 50
},{
	title : "联系电话",
	field : "lxdh",
	align : "center",
	width : 70
},{
	title : "部门描述",
	field : "bmms",
	align : "center",
	width : 150
},{
	title : "部门类型",
	field : "bmlxStr",
	align : "center",
	width : 80
}];
/*
 * 页面运行时运行的方法
 */
$(function(){
	//alert("node.id="+node.id+"，node.text="+node.text);
	initGrid();
	YMLib.Tools.ShowPage();
});