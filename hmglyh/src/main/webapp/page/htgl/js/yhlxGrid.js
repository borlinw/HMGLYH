/*
 * 养护类型Grid脚本
 * Author : lir
 */

var fatherNode = parent.node;//父节点的node（来自于“养护类型”树）
var currentAction = "";//操作类型（“添加”/“编辑”）
var currentGridRows = "";//某行的数据（用于“编辑”按钮）
var deidOfStr = "";//编辑时所需要默认选中的工料机ID。

function Edit(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	YMLib.UI.createWindow("edit", "编辑", "addYhlx.jsp", "box-edit",634,320);
}
//从DataGrid中删除一行数据
var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridYhid = $("#myGrid").datagrid("getRows")[_index].yhid;
			$.post(YMLib.url +'htglZyxmlbgl/deleteOneYhlx.do',"yhid="+gridYhid,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("删除成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#yhlxTree").tree("reload");
				}else{
					YMLib.UI.Show("删除失败",1500);
				}
			},"json");
		}
	});
};
//修改“启用状态”
var UpdateSfqy = function(_index){
	$.messager.confirm('确认更改', '确认更改使用状态吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridYhid = $("#myGrid").datagrid("getRows")[_index].yhid;
			var gridQyzt = $("#myGrid").datagrid("getRows")[_index].qyzt;
			$.post(YMLib.url +'htglZyxmlbgl/updateOneYhlxQyzt.do',"yhid="+gridYhid+"&qyzt="+gridQyzt,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#yhlxlTree").tree("reload");
				}else{
					YMLib.UI.Show("更改失败",1500);
				}
			},"json");
		}
	});
};
//删除“定额”，并修改“定额状态”
var DeleteDe = function(_index){
	$.messager.confirm('确认删除', '确认删除该养护类型下的所有定额吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridYhid = $("#myGrid").datagrid("getRows")[_index].yhid;
			$.post(YMLib.url +'htglZyxmlbgl/deleteDe.do',"yhid="+gridYhid,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#yhlxlTree").tree("reload");
				}else{
					YMLib.UI.Show("更改失败",1500);
				}
			},"json");
		}
	});
};
//查看定额
function ViewDe(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "view";
	YMLib.UI.createWindow("view", "查看定额", "addDe.jsp", "",634,320);
}
//添加定额
function AddDe(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "add";
	YMLib.UI.createWindow("add", "添加", "addDeNew.jsp", "box-add",634,320);
}
//编辑定额
function EditDe(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	currentAction = "edit";
	$.ajax({
		url: YMLib.url + "htglZyxmlbgl/queryAllDeByYhid.do?yhid="+currentGridRows.yhid,
		type:"post",
		dataType: "text",
		success: function(result) {
			deidOfStr = result;
			YMLib.UI.createWindow("edit", "编辑", "addDeNew.jsp", "box-edit",634,320);
		},
		error:function(result){
			alert("“定额数据”请求失败!");
		}
	});
}
//修改“定额启动状态”
var UpdateDeqdzt = function(_index){
	$.messager.confirm('确认更改', '确认更改“定额启动”状态吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridYhid = $("#myGrid").datagrid("getRows")[_index].yhid;
			var gridDeqdzt = $("#myGrid").datagrid("getRows")[_index].deqdzt;
			$.post(YMLib.url +'htglZyxmlbgl/updateOneYhlxbDeqdzt.do',"yhid="+gridYhid+"&deqdzt="+gridDeqdzt,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#yhlxlTree").tree("reload");
				}else{
					YMLib.UI.Show("更改失败",1500);
				}
			},"json");
		}
	});
};
//修改“是否裂缝修补”
var UpdateIslfxb = function(_index){
	$.messager.confirm('确认更改', '确认更改“是否裂缝修补”状态吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridYhid = $("#myGrid").datagrid("getRows")[_index].yhid;
			var gridIslfxb = $("#myGrid").datagrid("getRows")[_index].islfxb;
			$.post(YMLib.url +'htglZyxmlbgl/updateOneYhlxbIslfxb.do',"yhid="+gridYhid+"&islfxb="+gridIslfxb,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#yhlxlTree").tree("reload");
				}else{
					YMLib.UI.Show("更改失败",1500);
				}
			},"json");
		}
	});
};
//修改“是否沥青路面修补”
var UpdateIslqlmxb = function(_index){
	$.messager.confirm('确认更改', '确认更改“是否沥青路面修补”状态吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridYhid = $("#myGrid").datagrid("getRows")[_index].yhid;
			var gridIslqlmxb = $("#myGrid").datagrid("getRows")[_index].islqlmxb;
			$.post(YMLib.url +'htglZyxmlbgl/updateOneYhlxbIslqlmxb.do',"yhid="+gridYhid+"&islqlmxb="+gridIslqlmxb,function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("更改成功",1500);
					$("#myGrid").datagrid("reload");
					parent.$("#yhlxlTree").tree("reload");
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
		url: YMLib.url + "htglZyxmlbgl/queryAllByYhid.do",
		queryParams: {
			yhid : fatherNode.id
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
		if(value == 1 && rowData.denum == 0){
			return "<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
		}else if(value > 1 || rowData.denum > 0){
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
	title : "养护类型名称",
	field : "yhname",
	align : "center",
	width : 210
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
	title : "单价",
	field : "dj",
	align : "center",
	width : 60
},{
	title : "工日定额",
	field : "grde",
	align : "center",
	width : 60
},{
	title : "定额基数",
	field : "dejs",
	align : "center",
	width : 60
},{
	title : "定额状态",
	field : "dezt",
	align : "center",
	width : 60,
	formatter : function(value,rowData,rowIndex){
		if(rowData.childNum > 1){
			return "--";
		}else{
			if(rowData.deqdzt == 1){
				//“定额启动状态”==1的时候不允许删除，不允许编辑
				return value===1?"<font onclick=ViewDe('"+rowIndex+"') color=green style=cursor:pointer>查</font>&nbsp;<font color=#888 style=cursor:pointer>改</font>&nbsp;<font color=#888 style=cursor:pointer>删</font>":"<font onclick=AddDe('"+rowIndex+"') color=red style=cursor:pointer>待添加</font>";
			}else{
				return value===1?"<font onclick=ViewDe('"+rowIndex+"') color=green style=cursor:pointer>查</font>&nbsp;<font onclick=EditDe('"+rowIndex+"') color=green style=cursor:pointer>改</font>&nbsp;<font onclick=DeleteDe('"+rowIndex+"') color=green style=cursor:pointer>删</font>":"<font onclick=AddDe('"+rowIndex+"') color=red style=cursor:pointer>待添加</font>";
			}
		}
	}
},{
	title : "定额启动状态",
	field : "deqdzt",
	align : "center",
	width : 88,
	formatter : function(value,rowData,rowIndex){
		if(rowData.childNum > 1){
			return "--";
		}else{
			 if(rowData.dezt == 1){
				 return value===1?"<font onclick=UpdateDeqdzt('"+rowIndex+"') color=green style=cursor:pointer>已启动</font>":"<font onclick=UpdateDeqdzt('"+rowIndex+"') color=red style=cursor:pointer>未启动</font>";
			 }else{
				 return "<font color='#888' >暂无定额</font>";
			 }
		}
	}
},{
	title : "是否裂缝修补",
	field : "islfxb",
	align : "center",
	width : 88,
	formatter : function(value,rowData,rowIndex){
		if(rowData.childNum > 1){
			return "--";
		}else{
			return value===1?"<font onclick=UpdateIslfxb('"+rowIndex+"') color=green style=cursor:pointer>是</font>":"<font onclick=UpdateIslfxb('"+rowIndex+"') color=red style=cursor:pointer>否</font>";
		}
	}
},{
	title : "是否沥青路面修补",
	field : "islqlmxb",
	align : "center",
	width : 110,
	formatter : function(value,rowData,rowIndex){
		if(rowData.childNum > 1){
			return "--";
		}else{
			return value===1?"<font onclick=UpdateIslqlmxb('"+rowIndex+"') color=green style=cursor:pointer>是</font>":"<font onclick=UpdateIslqlmxb('"+rowIndex+"') color=red style=cursor:pointer>否</font>";
		}
	}
},{
	title : "养护项目描述",
	field : "yhxmms",
	align : "center",
	width : 300
}];
/*
 * 页面运行时运行的方法
 */
$(function(){
	//alert("fatherNode.id="+fatherNode.id+"，fatherNode.text="+fatherNode.text);
	initGrid();
	YMLib.Tools.ShowPage();
});