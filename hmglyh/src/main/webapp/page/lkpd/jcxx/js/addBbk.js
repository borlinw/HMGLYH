var currentAction = null;

$(function(){
	$("input[name=zjczr]").val(window.top.loginUserObject.username);
	$("#bblx").combobox({
		onSelect : function(record){
			if(record.value == "0204" || record.value == "0205"){
				$("#qmbb").hide();
				$("input[name=qmbbid]").val(0);
			}else{
				loadQmbb();
				$("#qmbb").show();
			}
		}
	});
	
	if(parent.currentGridRows == null){
		currentAction = "add";
		$("#bblx").combobox("enable");
		$("#qmld").combobox("enable");
	}else{
		currentAction = "edit";
		$("#bblx").combobox("disable");
		$("#qmld").combobox("disable");
	}
	
	switch(currentAction){
	case "add":
		loadQmbb();
		$("#btnSave").click(function(){
			if($("#myForm").form("validate")){
				YMLib.UI.MaskShow();
				var params = $("#myForm").serialize();
				YMLib.Ajax.POST("bbkzb/addBbkzb.do",params,"json",function(result){
					YMLib.UI.MaskHide();
					if(result){
						YMLib.UI.Show("添加成功！",2000);
						parent.$("#myGrid").datagrid("reload");
						parent.$("#add").window("close");
					}else
						YMLib.UI.Show("添加失败！",2000);
				},function(){
					YMLib.UI.MaskHide();
					YMLib.UI.Show("添加失败！",2000);
				});
			}else{
				YMLib.UI.Show("表单输入不完整！",2000);
			}
		});
		break;
	case "edit":
		$("#myForm").form("load",parent.currentGridRows);
		$("#bblx").combobox("select",parent.currentGridRows.bblx);
		$("#btnSave").click(function(){
			if($("#myForm").form("validate")){
				YMLib.UI.MaskShow();
				var params = $("#myForm").serialize()+"&bbid="+parent.currentGridRows.bbid;
				YMLib.Ajax.POST("bbkzb/changeBbkzb.do",params,"json",function(result){
					YMLib.UI.MaskHide();
					if(result.result == 1){
						YMLib.UI.Show("修改成功！",2000);
						parent.$("#myGrid").datagrid("reload");
						parent.$("#edit").window("close");
					}else if(result.result == -1){
						YMLib.UI.Show("版本库已经被使用，不能修改！",2000);
						parent.$("#edit").window("close");
					}else
						YMLib.UI.Show("修改失败！",2000);
				},function(){
					YMLib.UI.MaskHide();
					YMLib.UI.Show("修改失败！",2000);
				});
			}else{
				YMLib.UI.Show("表单输入不完整！",2000);
			}
		});
		break;
	};
});

var loadQmbb = function(){
	$("#qmld").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0204",
		valueField : "bbid",
		textField : "bbmc",
		onLoadSuccess : function(){
			if(currentAction == "add"){
				$("#qmld").combobox("select",$("#qmld").combobox("getData")[0].bbid);
			}
			else
				$("#qmld").combobox("select",parent.currentGridRows.qmbbid);
		},
		onSelect : function(record){
			$("input[name=qmbbid]").val($("#qmld").combobox("getValue"));
		}
	});
};