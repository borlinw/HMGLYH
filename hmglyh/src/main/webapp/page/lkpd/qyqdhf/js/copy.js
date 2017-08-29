
var qyState = false;

$(function(){
	$("#qybbid").combobox({
		url : YMLib.url + "qyhfb/getQybb.do?bbid="+parent.bbid+"&lxCode="+parent.lxCode+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh+"&bmCode="+window.top.loginUserObject.bmcode,
		valueField : "bbid",
		textField : "bbmc",
		panelHeight : 100,
		onLoadSuccess : function(){
			var data = $("#qybbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有已经划分的区域划分的版本",2000);
			}else{
				$("#qybbid").combobox("setValue",data[0].bbid);
				qyState = true;
			}
		}
	});
	$("#copy").click(function(){
		if(qyState){
			var params = "bbid="+parent.bbid+"&qybbid="+$("#qybbid").combobox("getValue")+"&lxCode="+parent.lxCode+
						 "&szhh="+parent.szhh+"&ezhh="+parent.ezhh+"&bmCode="+window.top.loginUserObject.bmcode;
			YMLib.Ajax.POST("qyhfb/copy.do",params,"json",function(result){
				if(result){
					YMLib.UI.Show("生成成功",2000);
					parent.$("#copyData").window("close");
				}else{
					YMLib.UI.Show("生成失败",2000);
				}
			},function(){
				YMLib.UI.Show("生成失败",2000);
			});
		}else{
			YMLib.UI.Show("没有已经划分的区域划分的版本",2000);
		}
	});
});