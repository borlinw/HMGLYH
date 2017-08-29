/*
 * “添加/编辑”人员信息（Js）
 */
var grandfatherNode = parent.parent.treeNode;
var action = parent.currentAction;
var checkedBmcode = parent.loginUserBmcode;//被选中的部门编码

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

//加载按钮和Combotree
function initbutton(){
	//下拉框选中查询
	$("#chooseBmcode").combotree({
		url : YMLib.url + "htglbm/createDapartTree.do?bmcode="+parent.loginUserBmcode,
		panelHeight : 170,
		value : checkedBmcode,
	    onSelect : function(record){
	    	var bmnameStr = record.text;
	    	var type = bmnameStr.substring(bmnameStr.length-5, bmnameStr.length-1);
	    	if(type=="font"){
	    		YMLib.UI.Show("不允许选择被禁用部门，请重新选择。",1500);
	    		$("#chooseBmcode").combotree("setValue", checkedBmcode);
	    		checkedBmcode = "";
	    	}else{
	    		checkedBmcode = record.id;
	    	}
	    	//alert("当前选中的部门编码为："+checkedBmcode+"，当前选中的部门名称为："+record.text+"，type："+type);
		}
	});
}

$(function(){
	if(action == "edit"){
		$("#form").form("load",parent.currentGridRows);
		checkedBmcode = parent.currentGridRows.bmcode;
		$("#ryname").attr("readonly","readonly");
	}else if(action == "add"){
		//添加
	}else{
		YMLib.UI.Show("数据传输错误。",1500);
	}
	initbutton();//加载Combotree
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			if(checkedBmcode = ""){
				YMLib.UI.Show("请选择部门。",1500);
			}else{
				var pams = $("#form").serialize();
				if(action == "add"){
					//alert("“人员”添加pams="+pams);
					YMLib.Ajax.POST("htglry/insertOneRy.do",pams,"json",A,AA);
				}else if(action == "edit"){
					pams = pams + "&ryid="+parent.currentGridRows.ryid;
					YMLib.Ajax.POST("htglry/updateOneRy.do",pams,"json",A,AA);
				}
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});