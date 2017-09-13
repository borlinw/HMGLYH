var lswxjlColumns = [[
	{title:'操作',rowspan:4,field:'1',formatter:function(value,row,index){
    	return "<a href='javascript:void(0)' onclick=Change('"+row.qljcxjcid+"')>修改</a>";
    }},
    {title:'检查日期',field:'jcrq',width:100},
    {title:'负责人',field:'fzr',width:100}]];


var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qhjc/getQljcxjc.do",
		border : false,
		fit : true,
		fitColumns : false,
		queryParams : {
			'qlcode':getQuery("qlcode")
		},
		loadMsg : '正在加载请稍候...',
		pageNumber : 1,
		pageSize : 10,
		pageList : [10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : lswxjlColumns
	});
};

var initButton = function(){
	$("#add").click(function(){
		if($("#jcrq").val()){
			var params = "jcsj="+$("#jcrq").val()+"&qlcode="+getQuery("qlcode");
			YMLib.Ajax.POST("qhjc/addQljcxjc.do",params,"json",function(msg){
				if(msg){
					YMLib.UI.Show("签到成功",2000);
					$("#myGrid").datagrid("reload");
				}else{
					YMLib.UI.Show("签到失败",2000);
				}
			},function(){
				YMLib.UI.Show("签到失败",2000);
			});
			
		}else{
			YMLib.UI.Show("请选择日期",2000);
		}
	});
};

var Change = function(_id){
	var params = "qljcxjcid="+_id+"&qlcode="+getQuery("qlcode");
	location.href = YMLib.url + "page/gis/page/qhjc/addQljcxjc.jsp?"+params;
};


$(function(){
	$("#jcrq").val(YMLib.DateTime.getDateFormat("yy-MM-dd"));
	
	initButton();
	initGrid();
});





