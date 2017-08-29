
var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "lkldhfb/getYsld.do",
		queryParams : {
			roadcode : $("#lxCode").combobox("getValue")
		},
		border : false,
		fit : true,
		fitColumns : false,
		pageNumber : 1,
		pageSize : 10,
		pageList:[10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : [[{
			field : 'a',  
			title : '操作' ,
			width : 150,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				return "<font onClick='Update("+rowIndex+")'color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onClick='Delete(\""+rowData.id+"\")'color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
			}
 		},{
			field : 'roadcode',
			title : '路线编码' ,
			width : 120,
			align : "center"
		},
		{
			field : 'roadstart',
			title : '起点桩号 ' ,
			width : 120,
			align : "center"
		},{
			field : 'roadends',
			title : '止点桩号' ,
			width : 120,
			align : "center"
		},{
			field : 'jsdj',
			title : '技术等级' ,
			width : 120,
			align : "center"
		},{
			field : 'lmlx',
			title : '路面类型' ,
			width : 120,
			align : "center"
		},{
			field : 'lmkd',
			title : '路面宽度' ,
			width : 120,
			align : "center"
		}]]
	});
};

var initButton = function(){
	$("#getYsld").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			roadcode : $("#lxCode").combobox("getValue")
		};
		$("#myGrid").datagrid("load");
	});
	$("#addYsld").click(function(){
		currentGridRows=null;
		YMLib.UI.createWindow("addYsld12","添加原始路段","addYsld.jsp","box-add",400,300);
	});
};
var Update = function(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("xgaddYsld12","原始路段修改","addYsld.jsp","box-edit",400,300);
};

var Delete = function(id){
	$.messager.confirm('确认', '是否删除该条原始路段记录？', function(r){
		if(r){
			YMLib.Ajax.POST("lkldhfb/dropYsld.do?id="+id,"","json",function(data){
				if(data.result == 1){
					YMLib.UI.Show("删除成功！",2000);
					$("#myGrid").datagrid("reload");
				}else
					YMLib.UI.Show("删除失败！",2000);
			});
		}
	});
};

$(function(){
	$("#lxCode").combobox({
		url : YMLib.url + "lxld/getLxCombo.do",
		valueField : "id",
		textField : "text",
		onLoadSuccess : function(){
			var data = $("#lxCode").combobox("getData");
			$("#lxCode").combobox("select",data[0].id);
				initGrid();
		}
	});
	initButton();
});
