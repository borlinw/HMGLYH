
var currentGridRows = null;
var initGrid = function(){
	$("#myGrid").datagrid({
		border : false,
		fit : true,
		fitColumns : false,
 		loadMsg : '正在加载请稍候...',
		url: YMLib.url + "bbkzb/queryBb.do",
		queryParams : {
			bblx : '0201'
		},
		pageNumber : 1,
		pageSize : 10,
		pageList:[10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : [[ {
			field : 'a',  
			title : '操作' ,
			width : 160,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				return "<font onClick='Update("+rowIndex+")' style='cursor: pointer;'><img src='"+YMLib.url+"images/edit.png'/></font>&nbsp;&nbsp;<font onClick='Delete("+rowData.bbid+")' style='cursor: pointer;'><img src='"+YMLib.url+"images/shanchu.png'/></font>";
			}
 		} ,{
			field : 'bbid',
			title : '版本编码' ,
			width : 90,
			align : "center"	
 		},{
			field : 'bbmc',
			title : '版本名称' ,
			width : 130,
			align : "center"	
 		},{
			field : 'bbsj',
			title : '版本时间' ,
			width : 90,
			align : "center"
		},{
			field : 'bblx',
			title : '版本类型 ' ,
			width : 90,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				switch(value){
				case "0201":
					return "路况调查";
				case "0202":
					return "路面检测";
				case "0203":
					return "路况评定";
				case "0204":
					return "千米路段划分";
				case "0205":
					return "区域区段划分";
				}
			}
		},{
			field : 'zjczr',
			title : '最近操作人' ,
			width : 90,
			align : "center"
		}
		]]	 	
	});
};

var Update = function(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("edit","版本库修改","addBbk.jsp","box-edit",320,200);
};
var Delete = function(_bbid){
	$.messager.confirm('确认', '是否删除该条版本库？', function(r){
		if(r){
			YMLib.Ajax.POST("bbkzb/dropBb.do?bbid="+_bbid,"","json",function(data){
				if(data.result == -1)
					YMLib.UI.Show("版本库已经被使用，不能删除！",2000);
				else if(data.result == 1){
					YMLib.UI.Show("删除成功！",2000);
					$("#myGrid").datagrid("reload");
				}else
					YMLib.UI.Show("删除失败！",2000);
			});
		}
	});
};

var initButton = function(){
	$("#query").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			bblx : $("#bblx").combobox("getValue")
		};
		$("#myGrid").datagrid("load");
	});
	$("#addBbk").click(function(){
		currentGridRows = null;
		YMLib.UI.createWindow("add","版本库添加","addBbk.jsp","box-add",320,200);
	});
};

$(function(){
	initButton();
	initGrid();
});


















