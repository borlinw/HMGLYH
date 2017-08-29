var lxCode = null;
var szhh = null;
var ezhh = null;

var initCombo = function(){
	$("#dcbbid").combobox({
		url : YMLib.url + "bbkzb/getBbid.do?bblx=0201&bbid="+parent.$("#bbid").combobox("getValue"),
		valueField : "bbid",
		textField : "bbmc"
	});
	$("#jcbbid").combobox({
		url : YMLib.url + "bbkzb/getBbid.do?bblx=0202&bbid="+parent.$("#bbid").combobox("getValue"),
		valueField : "bbid",
		textField : "bbmc"
	});
};

var initButton = function(){
	$("#create").click(function(){
		if(!$("#myForm").form("validate")){
			YMLib.UI.Show("数据不完全",2000);
			return;
		}
		var params = "pdbbid="+parent.$("#bbid").combobox("getValue")+"&lxCode="+parent.lxCode+"&szhh="+parent.szhh
					 +"&ezhh="+parent.ezhh+"&dcbbid="+$("#dcbbid").combobox("getValue")
					 +"&jcbbid="+$("#jcbbid").combobox("getValue");
		YMLib.UI.MaskShow();
		YMLib.Ajax.POST("qmldb/createMxb.do",params,"json",function(result){
			YMLib.UI.MaskHide();
			if(result){
				YMLib.UI.Show("生成成功",2000);
				parent.$("#myGrid").datagrid("reload");
				parent.$("#createWindow").window("close");
			}else{
				YMLib.UI.Show("生成失败",2000);
			}
		},function(){
			YMLib.UI.MaskHide();
		});
	});
};

$(function(){
	initCombo();
	initButton();
	$("#gxld").text(parent.$("#ldCode").combobox("getText"));
	$("#pdbbid").text(parent.$("#bbid").combobox("getText"));
});














