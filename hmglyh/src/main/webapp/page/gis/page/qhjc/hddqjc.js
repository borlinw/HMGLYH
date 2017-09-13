var hddqjcColumns = [[
	{title:'操作',rowspan:4,field:'1',formatter:function(value,row,index){
		return "<a href='javascript:void(0)' onclick=Change('"+row.hddqjcid+"')>修改</a>";
	}},
	{title:'检查日期',field:'jcsj',width:100},
	{title:'负责人',field:'jcr',width:100}]];


var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qhjc/getHddqjc.do",
		border : false,
		fit : true,
		fitColumns : false,
		queryParams : {
			'hdcode':getQuery("hdcode")
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
		columns : hddqjcColumns
	});
};

var initButton = function(){
	$("#add").click(function(){
		if($("#jcrq").val()){
			var params = "jcsj="+$("#jcrq").val()+"&hdcode="+getQuery("hdcode");
			YMLib.Ajax.POST("qhjc/addHddqjc.do",params,"json",function(msg){
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
	var params = "hddqjcid="+_id+"&hdcode="+getQuery("hdcode");
	location.href = YMLib.url + "page/gis/page/qhjc/addHddqjc.jsp?"+params;
};


$(function(){
	$("#jcrq").val(YMLib.DateTime.getDateFormat("yy-MM-dd"));
	
	initButton();
	initGrid();
});





