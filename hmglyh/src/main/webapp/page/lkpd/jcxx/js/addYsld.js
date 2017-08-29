var currentAction = null;

$(function(){
	if(parent.currentGridRows == null){
		currentAction = "add";
	}else{
		currentAction = "edit";
	}
	
	switch(currentAction){
	case "add":
		$("#lxname").val(parent.$("#lxCode").combotree("getText"));
		$("#roadcode").val(parent.$("#lxCode").combotree("getValue"));
		$("#btnSave").click(function(){
			if($("#myForm").form("validate")){
				YMLib.UI.MaskShow();
				var params = $("#myForm").serialize();
				YMLib.Ajax.POST("lkldhfb/addYsld.do",params,"json",function(result){
					YMLib.UI.MaskHide();
					if(result){
						YMLib.UI.Show("添加成功！",2000);
						parent.$("#myGrid").datagrid("reload");
						parent.$("#addYsld12").window("close");
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
		$("#lxname").val(parent.currentGridRows.lxname);
		$("#roadcode").val(parent.currentGridRows.roadcode);
		$("#roadstart").numberbox('setValue',parent.currentGridRows.roadstart);
		$("#roadends").numberbox('setValue',parent.currentGridRows.roadends);
		$("#jsdj").get(0).value = parent.currentGridRows.jsdj;
		$("#lmlx").get(0).value = parent.currentGridRows.lmlx;
		$("#lmkd").numberbox('setValue',parent.currentGridRows.lmkd);
		$("#btnSave").click(function(){
			if($("#myForm").form("validate")){
				YMLib.UI.MaskShow();
				var params = $("#myForm").serialize()+"&id="+parent.currentGridRows.id;
				YMLib.Ajax.POST("lkldhfb/change.do",params,"json",function(result){
					YMLib.UI.MaskHide();
					if(result.result == 1){
						YMLib.UI.Show("修改成功！",2000);
						parent.$("#myGrid").datagrid("reload");
						parent.$("#xgaddYsld12").window("close");
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

