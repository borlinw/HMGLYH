/*
 * 添加病害信息（Js）
 */
var grandfatherNode = parent.parent.treeNode;
var action = parent.currentAction;

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		window.top.YMLib.UI.Show("数据操作成功！",1500);
		if(parent.currentAction == "addOfTree"){
			parent.window.location.reload();
		}else{
			parent.$("#myGrid").datagrid("reload");
			parent.parent.$("#bhglTree").tree("reload");
		}
		//reloadFont();//刷新病害数量并关闭添加窗口（功能预留）
		parent.$("#add,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};

/*
 * 统计数量并关闭添加窗口。
 */
/*var reloadFont = function(){
	$.get(YMLib.url+"ryclxx/countNumber.do?bcodec="+bcodec,"_=" + Math.random(),function(data){
		parent.$("#countRenYuan").text("【"+data[0]+"】");
		parent.$("#add1").window("close");
	},"json");
};*/

$(function(){
	if(action == "edit"){
		$("#sslbmc").css({"display":"none"});//隐藏病害所属类别
		$("#qyztOfTr").css({"display":"none"});//隐藏病害的启用状态
		$("#form").form("load",parent.currentGridRows);
	}else if(action == "add"){
		$("#bhlxname").html(grandfatherNode.text);
	}else if(action == "addOfTree"){
		//Tree上的右键菜单“添加”
		grandfatherNode = parent.treeNode;
		//alert("Tree==>grandfatherNode.id="+grandfatherNode.id+"，grandfatherNode.text="+grandfatherNode.text);
		action = "add";
		$("#bhlxname").html(grandfatherNode.text);
	}
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			//var pams = $("#form").serialize()+"&xxx="+xxx+"&xxx="+xxx;
			var pams = $("#form").serialize();
			if(action == "add"){
				pams = pams + "&bhid="+grandfatherNode.id;
				YMLib.Ajax.POST("htglbhlx/insertOneBh.do",pams,"json",A,AA);
			}else if(action == "edit"){
				pams = pams + "&bhid="+parent.currentGridRows.bhid;
				YMLib.Ajax.POST("htglbhlx/updateOneBh.do",pams,"json",A,AA);
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});