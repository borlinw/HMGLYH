var currentGridRows = null;
var initGrid = function(url){
	$("#myGrid").datagrid({
		border : false,
		fit : true,
		fitColumns : false,
 		loadMsg : '正在加载请稍候...',//?url:YMLib.url + "xxjlb/queryXxjl.do?bmcode="+loginUserObject.bmcode+"&time",
		url:url?url:YMLib.url + "xxjlb/queryXxjl.do?bmcode="+loginUserObject.bmcode+"&nf="+(new Date()).getFullYear(),
		pageNumber : 1,
		pageSize : 10,
		pageList:[10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : false,
		rownumbers : true,
		pagination : true, //分页
		columns : [[{
			field : 'b',
			title : '序号',
			width : 40,
			align : "center",
			formatter: function(value,row,index){
				return index+1;
			}
		},/*{
			field : 'jlid',
			title : '记录ID' ,
			width : 120,
			align : "center",
			hidden:true
		},{
			field : 'bmname',
			title : '部门名称' ,
			width : 120,
			align : "center",
			hidden:true
		},{
			field : 'jldate',
			title : '记录时间' ,
			width : 120,
			align : "center",
			hidden:true
		},{
			field : 'nf',
			title : '年份' ,
			width : 120,
			align : "center",
			hidden:true
		},*/{
			field : 'xxnr',
			title : '学习内容',
			width : 300,
			align : "center"
		},{
			field : 'xxry',
			title : '人员',
			width : 200,
			align : "center"
		},{
			field : 'xxdd',
			title : '学习地点 ',
			width : 120,
			align : "center"
		},{
			field : 'xxdate',
			title : '学习时间 ' ,
			width : 120,
			align : "center"
		},{
			field : 'bz',
			title : '备注' ,
			width : 300,
			align : "center"
		},{
			field : 'a',  
			title : '操作' ,
			width : 100,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				return "<font onClick='Update("+rowIndex+")'color=blue style=cursor:pointer><img src='" + YMLib.url + "images/edit.png' /></font>&nbsp;<font onClick='Delete(\""+rowData.jlid+"\")'color=blue style=cursor:pointer><img src='" + YMLib.url + "images/shanchu.png' /></font>";
			}
 		}
		]]
	});
};

var loginUserObject = null;
$.ajax({
	url:"/hmglyh/rcyh/bh_getUserInfo.do",
	async:false,
	dataType:"json",
	success:function(data){
		loginUserObject = data;
	}
});

var initCombo = function(){
	$.ajax({
		url: YMLib.url + "bm/getBmCombotree.do?bmcode="+loginUserObject.bmcode,
		dataType:'json',
		success:function(msg){
			var data = msg;
			$("#bmcode").combotree({
				editable:false,
				data:data,
				valueField : "id",
				textField : "text"
			});
			$('#bmcode').combotree('setValue',data[0].id);
			
		}
	});
	$("#time").combobox({
		url : YMLib.url + "year/getYearCombo.do",
		editable:false,
		valueField : "id",
		textField : "text",
		onLoadSuccess : function(){
			$("#time").combobox("setValue",(new Date()).getFullYear());
		}
	});
			
	/*$.ajax({
		url: YMLib.url + "xxjlb/getNf.do",
		dataType:'json',
		success:function(msg){
			var data = msg;
			data[0].selected=true;
			$("#time").combobox({
				editable:false,
				data:data,
				valueField : "nf",
				textField : "nf"
			});
			
		}
	});*/
	
};

var initButton = function(){
	$("#query").click(function(){
		var bmcode = $("#bmcode").combotree("getValue");
		var time = $("#time").combobox("getValue");
		var url = YMLib.url + "xxjlb/queryXxjl.do?bmcode="+bmcode+"&nf="+time;
		initGrid(url);
	});
	
	$("#addNdxxjl").click(function(){
		if($("#bmcode").combotree("getValue")==null||$("#bmcode").combotree("getValue")==""){
			$.messager.alert("警告!","请先选择养护作业单位!","warning");
	}else{
		currentGridRows=null;
		YMLib.UI.createWindow("Ndxxjl","添加年度学习记录","addNdxxjl.jsp","box-add",550,480);
	}
		
	});
};
var Update = function(_index){
	currentGridRows = $("#myGrid").datagrid("getRows")[_index];
	YMLib.UI.createWindow("xg","学习记录修改","addNdxxjl.jsp","box-edit",550,480);
};


var Delete = function(jlid){
	$.messager.confirm('确认', '是否删除该条学习记录？', function(r){
		if(r){
			YMLib.Ajax.POST("xxjlb/drop.do?jlid="+jlid,"","json",function(data){
				if(data.result == 1){
					YMLib.UI.Show("删除成功！",2000);
					$("#myGrid").datagrid("reload");
				}else
					YMLib.UI.Show("删除失败！",2000);
			});
		}
	});
};

function hdcx(){
	var bmcode = $("#bmcode").combotree("getValue");
	var time = $("#time").combobox("getValue");
	var url = YMLib.url + "xxjlb/queryXxjl.do?bmcode="+bmcode+"&nf="+time;
	initGrid(url);
}




$(function(){
	initCombo();
	initButton();
	initGrid();
	//导出
	$("#Export1").click(function(){
		var bmcode = $("#bmcode").combotree("getValue");
		var time = $("#time").combobox("getValue");
		$("#ExportXxjlbForm").attr("action",YMLib.url + "xxjlb/exportXxjl.do?bmcode="+bmcode+"&nf="+time);
		$("#xxjlidToExportOfJsp").val("");
		$("#ExportXxjlbForm").submit();
	});
});





















