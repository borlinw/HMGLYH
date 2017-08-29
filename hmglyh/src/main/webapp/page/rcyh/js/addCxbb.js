/*
 * “添加”/“查看”/除雪版本表信息（Js）
 */

var action = parent.currentAction;//接收父页面传来的操作类型

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		//window.top.YMLib.UI.Show("数据操作成功！",1500);
		parent.YMLib.UI.Show("数据操作成功！",1500);
		parent.$("#myGrid").datagrid("reload");
		parent.$("#add,#view,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};


$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	if(action == "add"){
		YMLib.UI.MaskHide();
	}else if(action == "view"){
		YMLib.UI.MaskHide();
	}else if(action == "edit"){
		alert("编辑：暂未实现");
		YMLib.UI.MaskHide();
	}else{
		alert("action参数传递错误，请刷新重试。");
		YMLib.UI.MaskHide();
	}
	//保存按钮
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			var pams = $("#form").serialize();
			if(action == "add"){
				//alert("add -> pams="+pams);
				YMLib.Ajax.POST("/rcyh/cxbbb_addOneCxbbb.do",pams,"json",A,AA);
			}else{
				YMLib.UI.Show("类型参数传递出错。",1500);
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});
