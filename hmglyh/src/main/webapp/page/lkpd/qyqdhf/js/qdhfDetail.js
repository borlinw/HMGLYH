

var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qdhfshb/getQdhf.do",
		queryParams : {
			bmCode : parent.currentGridRows.bmCode1,
			bbid : parent.currentGridRows.bbid1
		},
		border : false,
		fit : true,
		fitColumns : false,
 		loadMsg : '正在加载请稍候...',
		pageNumber : 1,
		pageSize : 10,
		pageList:[10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : [[{
			field : 'lxCode',
			title : '路线编码' ,
			width : 90,
			align : "center"	
 		},{
			field : 'szhh',
			title : '起点桩号' ,
			width : 130,
			align : "center"	
 		},{
			field : 'ezhh',
			title : '止点桩号' ,
			width : 90,
			align : "center"
		},{
			field : 'cd',
			title : '长度（m） ' ,
			width : 90,
			align : "center"
		},{
			field : 'bbid',
			title : '版本' ,
			width : 90,
			align : "center"
		}
		]]	 	
	});
};

$(function(){
	initGrid();
});


















