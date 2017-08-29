/* 
 * “除雪版本”insex.jsp的Js脚本 
 * Author : lir 
 */

var currentAction = "";//用于标识操作类型
var currentGridRows;//用于传递DataGrid中的数据

/*
 * 处理json数据
 */
var datagridFields =[{
	title : "操作",
	field : "cz",
	align : "center",
	width : 120,
	formatter : function(value,rowData,rowIndex){
		//return "<font onclick=View('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/view.png' title='查看' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' title='删除' /></font>&nbsp;<font onclick=Edit('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' title='编辑' /></font>";
		//没有“编辑”
		return "<font onclick=View('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/view.png' title='查看' /></font>&nbsp;<font onclick=Delete('"+rowIndex+"') color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' title='删除' /></font>";
	}
},{
	title : "版本编号",
	field : "bbid",
	align : "center",
	width : 75
},{
	title : "版本名称",
	field : "bbmc",
	align : "center",
	width : 150
},{
	title : "开始时间",
	field : "ssj",
	align : "center",
	width : 80
},{
	title : "结束时间",
	field : "esj",
	align : "center",
	width : 80
},{
	title : "创建人",
	field : "zjczr",
	align : "center",
	width : 80
}];

/*
 * 删除
 */
var Delete = function(_index){
	$.messager.confirm('确认删除', '确认删除该条信息吗？', function(r){
		if(r){
			YMLib.UI.MaskShow();
			var gridBbid = $("#myGrid").datagrid("getRows")[_index].bbid;
			$.post(YMLib.url +'rcyh/cxbbb_deleteOneCxbbb.do',"bbid="+gridBbid,function(result){
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

//查看“除雪版本表”
function View(_index){
	currentAction = "view";
	var gridBbid = $("#myGrid").datagrid("getRows")[_index].bbid;
	YMLib.UI.createWindow("view", "查看", "/hmglyh/rcyh/cxbbb_addCxbb.do?toAdd=false&toView=true&toEdit=false&bbid="+gridBbid, "box-view",288,170);
}

//编辑“除雪版本表”
function Edit(_index){
	currentAction = "edit";
	var gridBbid = $("#myGrid").datagrid("getRows")[_index].bbid;
	YMLib.UI.createWindow("view", "编辑", "/hmglyh/rcyh/cxbbb_addCxbb.do?toAdd=false&toView=false&toEdit=true&bbid="+gridBbid, "box-edit",320,300);
}

$(function() {
	YMLib.UI.MaskShow("正在加载...");
	//添加按钮
	$("#addOneCxbb").click(function(){
		currentAction = "add";
		YMLib.UI.createWindow("add", "添加", "/hmglyh/rcyh/cxbbb_addCxbb.do?toAdd=true&toView=false&toEdit=false", "box-add",320,300);
	});
	YMLib.Tools.ShowPage();
	YMLib.UI.MaskHide();
});
