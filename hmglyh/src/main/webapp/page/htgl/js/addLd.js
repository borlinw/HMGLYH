/*
 * “添加/编辑”路段信息（Js）
 */
var grandfatherNode = parent.parent.treeNode;
var action = parent.currentAction;
var nowLxnameStrToVerify = "";//用于验证路线选了没。

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

//加载按钮和Combobox
function initbutton(){
	//下拉框选中查询
	$("#chooseLxcode").combobox({
	    url : YMLib.url +'htglld/createLxCombobox.do?lxQueryType=',
	    valueField : 'id',
	    textField : 'text',
	    editable : false,//在这里加显示combobox不能编辑的属性
	    onLoadSuccess : function(){
	    	if(action == "edit"){
	    		$("#chooseLxcode").combobox("setValue",parent.currentGridRows.lxcode);
	    		nowLxnameStrToVerify = parent.currentGridRows.lxcode;
	    	}else if(action == "add"){
	    		$("#chooseLxcode").combobox("setValue","-请选择一条路线-");
	    	}
	    	YMLib.UI.MaskHide();
	    },
	    onSelect : function(record){
	    	//alert(record.id+"^^"+record.text+"^^^"+record.szhh+"^^^"+record.ezhh);
	    	lxcode = record.id;
	    	$("#lxname").val(record.text);
	    	nowLxnameStrToVerify =  record.id;
		}
	});
}

$(function(){
	if(action == "edit"){
		$("#form").form("load",parent.currentGridRows);
	}else if(action == "add"){
		//将部门信息赋值
		$("#bmname").val(window.top.getLoginUserObject.bmname);
		$("#bmcode").val(window.top.getLoginUserObject.bmcode);
	}else{
		YMLib.UI.Show("数据传输错误。",1500);
	}
	initbutton();//加载Combobox
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			//var pams = $("#form").serialize()+"&xxx="+xxx+"&xxx="+xxx;
			var pams = $("#form").serialize();
			if(nowLxnameStrToVerify == ""){
				YMLib.UI.Show("请选择路线。",1500);
			}else{
				if(action == "add"){
					//alert("“路段”添加pams="+pams);
					YMLib.Ajax.POST("htglld/addOneLd.do",pams,"json",A,AA);
				}else if(action == "edit"){
					pams = pams + "&ldcode="+parent.currentGridRows.ldcode;
					YMLib.Ajax.POST("htglld/updateOneLd.do",pams,"json",A,AA);
				}
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});