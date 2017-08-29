/*
 * “添加/编辑”工料机类型信息（Js）
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
			parent.parent.$("#gljTree").tree("reload");
		}
		parent.$("#add,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};

//验证“编码”是否已存在
function VerifyBm(){
	if(action == "add"){
		var bm1 = $('#bm').val();
		if(bm1 != "" && bm1 != null){
			$.ajax({
				url: YMLib.url + "htglglj/verifyBm.do?bm=" + bm1,
				type:"post",
				dataType: "text",
				success: function(result) {
					if(result == "aa"){
						window.top.YMLib.UI.Show("编号不允许重复。",1000);
						$('#bm').val("");
					}
				},
				error:function(result){
					alert("ajax请求验证用户名失败!");
				}
			});
		}
	}
};

$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	if(action == "edit"){
		//编辑
		$("#bm").attr("readonly","readonly");
		$("#qyztTr").css({"display":"none"});
		$("#form").form("load",parent.currentGridRows);
	}else if(action == "add"){
		//添加
		//alert("所属大类的LXID="+fatherNode.id);
	}else{
		alert("数据传输错误，请刷新后重试。");
	}
	YMLib.UI.MaskHide();
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			var pams = $("#form").serialize();
			if(action == "add"){
				pams = pams + "&lxid=" + fatherNode.id;
				YMLib.Ajax.POST("htglglj/gljlxAddOne.do",pams,"json",A,AA);
			}else if(action == "edit"){
				pams = pams + "&lxid="+parent.currentGridRows.lxid;
				YMLib.Ajax.POST("htglglj/gljlxUpdateOne.do",pams,"json",A,AA);
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});
