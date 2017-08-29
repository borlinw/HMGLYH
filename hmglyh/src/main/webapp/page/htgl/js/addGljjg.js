/*
 * “添加/编辑”工料机价格信息（Js）
 */
var action = parent.currentAction;

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		window.top.YMLib.UI.Show("数据操作成功！",1500);
		parent.$("#myGrid").datagrid("reload");
		parent.$("#add,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};

$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	//alert("parent.parent.queryDataBmname="+parent.parent.queryDataBmname+"，parent.parent.queryDataBmcode="+parent.parent.queryDataBmcode);
	$("#lxname").val(parent.currentGridRows.lxname);
	$("#lxid").val(parent.currentGridRows.lxid);
	$("#bmname").val(parent.parent.queryDataBmname);
	$("#bmcode").val(parent.parent.queryDataBmcode);
	if(action == "edit"){
		$("#dj").val(parent.currentGridRows.dj);
	}else if(action == "add"){
		//添加
	}else{
		alert("数据传输错误，请刷新后重试。");
	}
	YMLib.UI.MaskHide();
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			var pams = $("#form").serialize();
			//获取档次更改的单价。
			var nowDj = parseFloat($("#dj").val());
			//alert("转化完的单件为："+nowDj+"，数据类型为："+typeof nowDj);
			if(nowDj > 0){
				if(action == "add"){
					//alert("Add ==> pams="+pams);
					YMLib.Ajax.POST("htglglj/gljjgAddOne.do",pams,"json",A,AA);
				}else if(action == "edit"){
					//alert("edit ==> pams="+pams);
					YMLib.Ajax.POST("htglglj/gljjgUpdateOne.do",pams,"json",A,AA);
				}
			}else{
				$("#dj").val(null);
				YMLib.UI.Show("请输入大于0的价格。",1500);
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});
