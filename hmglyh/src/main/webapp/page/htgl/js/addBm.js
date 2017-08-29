/*
 * “添加”/“编辑”部门信息（Js）
 */
var fatherNode = parent.node;
var action = parent.currentAction;
var bmlxStr = "";

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		window.top.YMLib.UI.Show("数据操作成功！",1500);
		if(parent.currentAction == "addOfTree"){
			alert("树上的添加。");
			parent.window.location.reload();
		}else{
			parent.$("#myGrid").datagrid("reload");
			parent.$("#bmTree").tree("reload");
			parent.parent.$("#bmTree").tree("reload");
		}
		parent.$("#add,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};

$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	initCombobox();
	if(action == "edit"){
		//编辑
		$("#qyztTr").css({"display":"none"});
		$("#form").form("load",parent.currentGridRows);
		bmlxStr = parent.currentGridRows.bmlx;//设置“部门类型”数据
	}else if(action == "add"){
		//添加
	}else{
		alert("数据传输错误，请刷新后重试。");
	}
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			if(bmlxStr == ""){
				YMLib.UI.Show("请选择部门类型。",1500);
			}else{
				var pams = $("#form").serialize();
				if(action == "add"){
					pams = pams + "&bmcode=" + fatherNode.id;
					YMLib.Ajax.POST("htglbm/insertOneBm.do",pams,"json",A,AA);
				}else if(action == "edit"){
					pams = pams + "&bmcode="+parent.currentGridRows.bmcode;
					YMLib.Ajax.POST("htglbm/updateOneBm.do",pams,"json",A,AA);
				}
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});

//初始化Combobox（部门类型）
function initCombobox(){
	$("#bmlx").combobox({
		url : YMLib.url +'htglmjlx/createCombobox.do?typecodeStr=01', 
		valueField : 'id',
		textField : 'text',
		editable : false,//在这里加显示combobox不能编辑的属性
		//给Combobox一个默认值
		onLoadSuccess : function(){
			//$("#bmlx").combobox("setValue",bmlxStr);
			if(bmlxStr == ""){
				$("#bmlx").combobox("setValue","-请选择部门类型-");
			}else{
				$("#bmlx").combobox("setValue",bmlxStr);
			}
			YMLib.UI.MaskHide();
		},
		onSelect : function(record){
			//alert(record.id);
			bmlxStr = record.id;
		}
	});
}