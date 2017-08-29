/*
 * 工料机Grid脚本
 * Author : lir
 */

var node = parent.node;//父节点的node（来自于“工料机”树）
var currentAction = "";//操作类型（“添加”/“编辑”）
var currentGridRows = "";//某行的数据（用于“编辑”按钮，“工料机”价格的“添加/编辑”）
var bmcodeToQueryData = parent.queryDataBmcode;//用于查询数据的“部门编码”

//编辑“工料机类型”
function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addGljlx.jsp", "box-edit",634,320);
}
//添加“工料机价格”
function InsertGljjg(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "add";
	YMLib.UI.createWindow("add", "添加", "addGljjg.jsp", "box-add",425,188);
}
//编辑“工料机价格”
function UpdateGljjg(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addGljjg.jsp", "box-edit",425,188);
}
//删除“工料机类型”
var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridlxid = $("#myGrid").datagrid("getRows")[_index].lxid;
			$.post(YMLib.url +'htglglj/gljlxDeleteOne.do',"lxid="+gridlxid+"&bmcode="+bmcodeToQueryData,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("删除成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#gljTree").tree("reload");
				}else{
					YMLib.UI.Show("删除失败",1500);
				}
			},"json");
		}
	});
};
//更改“工料机”的启用状态
var UpdateSfqy = function(_index){
	$.messager.confirm('确认更改', '确认更改使用状态吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridlxid = $("#myGrid").datagrid("getRows")[_index].lxid;
			var gridQyzt = $("#myGrid").datagrid("getRows")[_index].qyzt;
			$.post(YMLib.url +'htglglj/gljlxUpdateOneQyzt.do',"lxid="+gridlxid+"&qyzt="+gridQyzt,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#gljTree").tree("reload");
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
		url: YMLib.url + "htglglj/queryAllBySome.do",
		queryParams: {
			bmcode : bmcodeToQueryData,
			lxid : node.id
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
	title : "编号",
	field : "bm",
	align : "center",
	width : 100
},{
	title : "工料机类型",
	field : "lxname",
	align : "center",
	width : 180
},{
	title : "规格",
	field : "gg",
	align : "center",
	width : 80
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
	title : "价格",
	field : "dj",
	align : "center",
	width : 60,
	formatter : function(value,rowData,rowIndex){
		if(rowData.childNum > 1){
			return "--";
		}else{
			if(value == null || value == ""){
				return "<font onclick=InsertGljjg('"+rowIndex+"') color=red style=cursor:pointer><img src='" + YMLib.url + "images/add.png' /></font>";
			}else{
				return "<font onclick=UpdateGljjg('"+rowIndex+"') color=blue style=cursor:pointer>"+value+"</font>";
			}
		}
	}
},{
	title : "备注",
	field : "bz",
	align : "center",
	width : 220
}];
/*
 * 页面运行时运行的方法
 */
$(function(){
	initGrid();
	YMLib.Tools.ShowPage();
});