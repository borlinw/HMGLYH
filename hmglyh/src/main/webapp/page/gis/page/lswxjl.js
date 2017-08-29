var lswxjlColumns = [[
    {title:'操作',rowspan:4,field:'1',formatter:function(value,row,index){
    	return "<a href='javascript:void(0)' onclick=Change('"+row.id+"')>修改</a>";
    }},
    {title:'维修类型',rowspan:3},
    {title:'线路',rowspan:3},
    {title:'桩号',rowspan:3},
    {title:'年份',rowspan:3},
    {title:'工程名称',rowspan:3},
    {title:'工程概况及方案',rowspan:3},
    {title:'项目实施方案',colspan:2},
    {title:'工期',colspan:2},
    {title:'参建单位',colspan:8},
    {title:'预算批复',rowspan:3},
    {title:'决算金额',rowspan:3},
    {title:'备注',rowspan:3}],[
    {title:'实施前',rowspan:2},
    {title:'实施后',rowspan:2},
    {title:'合同'},
    {title:'实际'},
    {title:'建设单位',rowspan:2},
    {title:'项目执行机构',rowspan:2},
    {title:'招标代理单位',rowspan:2},
    {title:'勘察设计单位',rowspan:2},
    {title:'监理单位',rowspan:2},
    {title:'施工单位',rowspan:2},
    {title:'第三方检测单位',rowspan:2},
    {title:'审计单位',rowspan:2},
    {title:'批复',rowspan:2}],[
    {title:'开工完工日期'},{title:'开工完工日期'},{title:'文件名称'},{title:'文号'}],[
    {title:'1',field:'wxlx',width:80},
    {title:'2',field:'roadcode',width:100},
    {title:'3',field:'qzzh',width:100},
    {title:'4',field:'nf',width:50},
    {title:'5',field:'gcmc',width:150},
    {title:'6',field:'gkjfa',width:150},
    {title:'7',field:'ssq',width:150},
    {title:'8',field:'ssh',width:150},
    {title:'9',field:'htrq',width:150},
    {title:'10',field:'sjrq',width:150},
    {title:'11',field:'jsdw',width:100},
    {title:'12',field:'xmzxjg',width:100},
    {title:'13',field:'zbdldw',width:100},
    {title:'14',field:'kcsjdw',width:100},
    {title:'15',field:'jldw',width:100},
    {title:'16',field:'sgdw',width:100},
    {title:'17',field:'dsfjcdw',width:100},
    {title:'18',field:'sjdw',width:100},
    {title:'19',field:'null',width:100,formatter : function(value,row,index){
    	var v = "";
    	for(var i=0;i<row.attachment.length;i++){
    		v += row.attachment[i].name +" ";
    	}
    	return v;
    }},
    {title:'20',field:'wh',width:100},
    {title:'21',field:'jsje',width:100},
    {title:'22',field:'bz',width:100}]];


var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "lswxjl/getMxb.do",
		border : false,
		fit : true,
		fitColumns : false,
		queryParams : {
			'roadcode':getQuery("roadcode"),
			'lx':getQuery("lx"),
			'wxlx':decodeURI(getQueryByName("wxlx")),
			'qzzh':getQuery("qzzh")
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
		var params = "roadcode="+getQuery("roadcode")+"&lx="+getQuery("lx")+"&wxlx="+getQueryByName("wxlx")+"&qzzh="+getQuery("qzzh");
		location.href = YMLib.url + "lswxjl/getMxbById.do?"+params;
	});
};

var Change = function(_id){
	var params = "id="+_id+"&lx="+getQuery("lx")+"&roadcode="+getQuery("roadcode")+"&wxlx="+getQueryByName("wxlx")+"&qzzh="+getQuery("qzzh");
	location.href = YMLib.url + "lswxjl/getMxbById.do?"+params;
};


$(function(){
	initButton();
	initGrid();
});





