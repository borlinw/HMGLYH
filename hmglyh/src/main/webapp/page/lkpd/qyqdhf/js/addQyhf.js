

var initButton = function(){
	$("#add").click(function(){
		if($("#point").validatebox("isValid")){
			var point = $("#point").val();
			if(point>parent.ezhh||point<parent.szhh){
				YMLib.UI.Show("点超出了路段范围",2000);
				$("#point").val("");
			}else{
				var append = "<tr><td>"+$("#lx").combobox("getText")+"&nbsp;&nbsp;<span>"+$("#point").val()+"</span><input type='hidden' name='points' value='"+$("#point").val()+"'/></td><td><img src='../images/shanchu.png' style='cursor: pointer;' onclick='Delete(this)'/></td></tr>";
				$("#append").append(append);
			}
		}else{
			YMLib.UI.Show("请输入桩号",2000);
		}
	});
	$("#btnSave").click(function(){
		var params = $("#myForm").serialize()+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh+"&bmCode="+window.top.loginUserObject.bmcode+
					 "&lxCode="+parent.lxCode+"&bbid="+parent.$("#bbid").combobox("getValue");
		YMLib.UI.MaskShow();
		YMLib.Ajax.POST("qyhfb/addQyhfb.do",params,"json",function(result){
			YMLib.UI.MaskHide();
			if(result){
				YMLib.UI.Show("区域划分成功",2000);
				parent.$("#myGrid").datagrid("reload");
				parent.$("#qyhfWindow").window("close");
			}else
				YMLib.UI.Show("区域划分失败",2000);
		},function(){
			YMLib.UI.MaskHide();
			YMLib.UI.Show("区域划分失败",2000);
		});
	});
};

var Delete = function(_this){
	$(_this).parent().parent().remove();
};

$(function(){
	$("#ldCode").text(parent.$("#ldCode").combobox("getText"));
	$("#bbid").text(parent.$("#bbid").combobox("getText"));
	initButton();
});