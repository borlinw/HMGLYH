var lswxjlColumns = [[{title:'操作',field:'1',formatter:function(value,row,index){
		return "<a href='javascript:void(0)' onclick=Change('"+row.id+"')>修改</a>";
	}},{title:'路线编号',field:'roadcode',width:100},
	{title:'桥（涵）桩号',field:'zh',width:100},
	{title:'桥（涵）名称',field:'2',width:100,formatter:function(value,row,index){
		if(row.lx == "ql")
			return row.qlname;
		else if(row.lx == 'hd')
			return row.hdcode;
		return '';
	}},
	{title:'维修类型',field:'wxlx',width:100},
	{title:'维修部位',field:'wxbw',width:100},
	{title:'开工时间',field:'kgsj',width:100},
	{title:'完工时间',field:'wgsj',width:100},
	{title:'使用材料',field:'sycl',width:100},
	{title:'维修工程量',field:'wxgcl',width:100},
	{title:'维修金额',field:'wxje',width:100}]];


var initGrid = function(){
	var queryParams = {};
	if(getQuery("lx") == "ql"){
		queryParams.qlcode = getQuery("qlcode");
	}else if(getQuery("lx") == "hd"){
		queryParams.hdcode = getQuery("hdcode");
	}else{
		queryParams.roadcode = getQuery("roadcode");
	}
	$("#myGrid").datagrid({
		url : YMLib.url + "lswxjl/getMxb.do",
		border : false,
		fit : true,
		fitColumns : false,
		queryParams : queryParams,
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
		var params = "roadcode="+getQuery("roadcode")+"&lx="+getQuery("lx")+"&zh="+getQuery("zh");
		if(getQuery("lx") == "ql"){
			params += "&qlcode="+getQuery("qlcode") + "&qlname=" + getQueryByName("qlname");
		}else if(getQuery("lx") == "hd"){
			params += "&hdcode="+getQuery("hdcode");
		}
		location.href = YMLib.url + "lswxjl/getMxbById.do?"+params;
	});
};

var Change = function(_id){
	var params = "id="+_id + "&roadcode="+getQuery("roadcode")+"&lx="+getQuery("lx")+"&zh="+getQuery("zh");
	if(getQuery("lx") == "ql"){
		params += "&qlcode="+getQuery("qlcode") + "&qlname=" + getQueryByName("qlname");
	}else if(getQuery("lx") == "hd"){
		params += "&hdcode="+getQuery("hdcode");
	}
	location.href = YMLib.url + "lswxjl/getMxbById.do?"+params;
};


$(function(){
	initButton();
	initGrid();
});





