/*
 * “添加/编辑”人员信息（Js）
 */
var fatherNode = parent.node;
var action = parent.currentAction;

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		window.top.YMLib.UI.Show("数据操作成功！",1500);
		if(parent.currentAction == "add"){
			parent.window.location.reload();
		}else{
			parent.$("#myGrid").datagrid("reload");
			parent.parent.$("#yhlxTree").tree("reload");
		}
		parent.$("#add,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};

$(function(){
	if(action == "edit"){
		YMLib.UI.MaskShow("数据加载中...");
		$("#qyztOfTr").css({"display":"none"});//隐藏启用状态
		$("#form").form("load",parent.currentGridRows);
		YMLib.UI.MaskHide();
	}else if(action == "add"){
		//添加
	}else{
		YMLib.UI.Show("数据传输错误。",1500);
	}
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			var pams = $("#form").serialize();
			if(action == "add"){
				pams = pams + "&yhid="+fatherNode.id;
				YMLib.Ajax.POST("htglZyxmlbgl/addOneYhlx.do",pams,"json",A,AA);
			}else if(action == "edit"){
				pams = pams + "&yhid="+parent.currentGridRows.yhid;
				YMLib.Ajax.POST("htglZyxmlbgl/updateOneYhlx.do",pams,"json",A,AA);
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});