
var jcState = false;

$(function(){
	$("#jcbbid").combobox({
		url : YMLib.url + "bbkzb/getBbForLmjc.do?bbid="+parent.bbid,
		valueField : "bbid",
		textField : "bbmc",
		panelHeight : 100,
		onLoadSuccess : function(){
			var data = $("#jcbbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有千米路段相同的路面检测的版本",2000);
			}else{
				$("#jcbbid").combobox("setValue",data[0].bbid);
				jcState = true;
			}
		}
	});
	$("#copy").click(function(){
		if(jcState){
			var params = "bbid="+parent.bbid+"&jcbbid="+$("#jcbbid").combobox("getValue")+"&lxCode="+parent.lxCode+"&szhh="+parent.szhh+
						 "&ezhh="+parent.ezhh+"&fx="+parent.fx;
			YMLib.Ajax.POST("lmjcb/copy.do",params,"json",function(result){
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
			YMLib.UI.Show("没有千米路段相同的路面检测的版本",2000);
		}
	});
});