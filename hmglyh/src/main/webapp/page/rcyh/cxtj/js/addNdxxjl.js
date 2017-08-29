var currentAction = null;

var loginUserObject = null;
$.ajax({
	url:"/hmglyh/rcyh/bh_getUserInfo.do",
	async:false,
	dataType:"json",
	success:function(data){
		console.log(data);
		loginUserObject = data;
	}
});



$(function(){
	$("input[name=jlusername]").val(loginUserObject.username);
	if(parent.currentGridRows == null){
		currentAction = "add";
	}else{
		currentAction = "edit";
	}
	
	switch(currentAction){
	case "add":
		$("input[name=bmname]").val(parent.$("#bmcode").combotree("getText"));
		$("input[name=bmcode]").val(parent.$("#bmcode").combotree("getValue"));
		$("#btnSave").click(function(){
			if($("#myForm").form("validate")){
				YMLib.UI.MaskShow();
				var params = $("#myForm").serialize();
				YMLib.Ajax.POST("xxjlb/add.do",params,"json",function(result){
					YMLib.UI.MaskHide();
					if(result){
						YMLib.UI.Show("添加成功！",2000);
						parent.hdcx();
						parent.$("#myGrid").datagrid("reload");
						parent.$("#Ndxxjl").window("close");
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
		$("input[name=bmname]").val(parent.currentGridRows.bmname);
		$("input[name=bmcode]").val(parent.currentGridRows.bmcode);
		$("input[name=jldate]").val(parent.currentGridRows.jldate);
		$("input[name=nf]").val(parent.currentGridRows.nf);
		$("input[name=xxdd]").val(parent.currentGridRows.xxdd);
		$("input[name=xxdate]").val(parent.currentGridRows.xxdate);
		$("textarea[name=bz]").val(parent.currentGridRows.bz);
		$("textarea[name=xxry]").val(parent.currentGridRows.xxry);
		$("textarea[name=xxnr]").val(parent.currentGridRows.xxnr);
		$("#btnSave").click(function(){
			if($("#myForm").form("validate")){
				YMLib.UI.MaskShow();
				var params = $("#myForm").serialize()+"&jlid="+parent.currentGridRows.jlid;
				YMLib.Ajax.POST("xxjlb/change.do",params,"json",function(result){
					YMLib.UI.MaskHide();
					if(result.result == 1){
						YMLib.UI.Show("修改成功！",2000);
						parent.$("#myGrid").datagrid("reload");
						parent.$("#xg").window("close");
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

