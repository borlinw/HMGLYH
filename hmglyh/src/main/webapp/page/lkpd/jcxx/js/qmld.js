var lxState = false;
var bbState = false;

var initGrid = function(){
	$("#myGrid").datagrid({
		url : YMLib.url + "qmldb/getQmld.do",
		queryParams : {
			bbid : $("#bbid").combobox("getValue"),
			lxCode : $("#lxCode").combobox("getValue")
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
			field : 'lxCode',
			title : '路线编码' ,
			width : 90,
			align : "center"
		},{
			field : 'szhh',
			title : '起点桩号 ' ,
			width : 90,
			align : "center"
		},{
			field : 'ezhh',
			title : '止点桩号' ,
			width : 90,
			align : "center"
		},{
			field : 'cd',
			title : '长度' ,
			width : 90,
			align : "center"
		},{
			field : 'lmkd',
			title : '路面宽度' ,
			width : 90,
			align : "center"
		},{
			field : 'bbid',
			title : '版本编号' ,
			width : 90,
			align : "center"
		},{
			field : 'lmlx',
			title : '路面类型' ,
			width : 90,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				if(value == 1)
					return "沥青路面";
				else if(value == 2)
					return "水泥路面";
				else 
					return "砂石路面";
			}
		},{
			field : 'fxName',
			title : '方向' ,
			width : 90,
			align : "center"
		}
		]]	 	
	});
};

var initButton = function(){
	$("#getQmld").click(function(){
		$("#myGrid").datagrid("options").queryParams = {
			bbid : $("#bbid").combobox("getValue"),
			lxCode : $("#lxCode").combobox("getValue")
		};
		$("#myGrid").datagrid("load");
	});
	$("#addQmld").click(function(){
		$.messager.confirm('确认', '是否生成该版本的千米路段？', function(r){
			if(r){
				YMLib.UI.MaskShow();
				YMLib.Ajax.POST("qmldb/createQmldb.do?bbid="+$("#bbid").combobox("getValue"),"","json",function(data){
					YMLib.UI.MaskHide();
					if(data.result == 1){
						YMLib.UI.Show("生成成功！",2000);
						$("#myGrid").datagrid("reload");
					}
					else if(data.result == -1)
						YMLib.UI.Show("千米路段已经被使用，不能重新生成！",2000);
					else
						YMLib.UI.Show("生成失败！",2000);
				});
			}	
		});
	});
	$("#dropQmld").click(function(){
		$.messager.confirm('确认', '是否清空该版本的千米路段？', function(r){
			if(r){
				YMLib.UI.MaskShow();
				YMLib.Ajax.POST("qmldb/dropQmld.do?bbid="+$("#bbid").combobox("getValue"),"","json",function(data){
					YMLib.UI.MaskHide();
					if(data.result >= 1){
						YMLib.UI.Show("清空成功！",2000);
						$("#myGrid").datagrid("reload");
					}
					else if(data.result == -1)
						YMLib.UI.Show("千米路段已经被使用，不能清空！",2000);
					else if(data.result == -1)
						YMLib.UI.Show("清空失败！",2000);
					else
						YMLib.UI.Show("没有数据需要清空！",2000);
				});
			}
		});
	});
};

$(function(){
	$("#bbid").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0204",
		valueField : "bbid",
		textField : "bbmc",
		onLoadSuccess : function(){
			var data = $("#bbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有对应的千米路段的版本，请先创建版本",2000);
			}else{
				$("#bbid").combobox("setValue",data[0].bbid);
				bbState = true;
				if(lxState)
					initGrid();
			}
		}
	});
	$("#lxCode").combobox({
		url : YMLib.url + "lxld/getLxCombo.do",
		valueField : "id",
		textField : "text",
		onLoadSuccess : function(){
			var data = $("#lxCode").combobox("getData");
			$("#lxCode").combobox("select",data[0].id);
			lxState = true;
			if(bbState)
				initGrid();
		}
	});
	initButton();
});