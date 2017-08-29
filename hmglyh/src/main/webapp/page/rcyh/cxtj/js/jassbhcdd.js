var initGrid = function(){
	$("#myGrid").datagrid({
		border : false,
		fit : true,
		fitColumns : false,
 		loadMsg : '正在加载请稍候...',
		url: YMLib.url + "ydjh/getRwdBytj.do",
		queryParams : {
			bmcode : loginUserObject.bmcode,
			pxcode : ""
		},
		pageNumber : 1,
		pageSize : 10,
		pageList:[10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : false,
		rownumbers : true,
		pagination : true, //分页
		columns : [[{
			field : 'a',  
			title : '操作' ,
			width : 100,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				return "<font onClick='Ckxx(\""+rowData.rwdid+"\")'color=blue style=cursor:pointer>查看详细</font>";
			}
 		},{
			field : 'rwdid',
			title : '任务单ID' ,
			width : 120,
			align : "center",
			hidden:true
		},{
			field : 'rwdlx',
			title : '任务单类型 ' ,
			width : 80,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				if(value == 0901)
					return "计划";
				else if(value == 0902)
					return "巡道";
				else if(value == 0903)
					return "补充";
			}
		},{
			field : 'ssny',
			title : '所属年月' ,
			width : 180,
			align : "center"
		},{
			field : 'cjtime',
			title : '创建时间 ' ,
			width : 120,
			align : "center"
		},{
			field : 'ryname',
			title : '创建用户名 ' ,
			width : 120,
			align : "center"
		},{
			field : 'bmname',
			title : '受委派单位 ' ,
			width : 120,
			align : "center",
		},{
			field : 'ldname',
			title : '所属路段' ,
			width : 150,
			align : "center"
		},{
			field : 'ssld',
			title : '实施路段 ' ,
			width : 130,
			align : "center"
		},{
			field : 'tq',
			title : '方向 ' ,
			width : 60,
			align : "center",
			formatter : function(value,rowData,rowIndex){
				if(value == '0301')
					return "上行";
				else if(value == '0302')
					return "下行";
				else if(value == '0303')
					return "全幅";
			}
		},{
			field : 'wzbc',
			title : '位置补充 ' ,
			width : 130,
			align : "center"
		},{
			field : 'qlcode',
			title : '桥梁编码 ' ,
			width : 100,
			align : "center"
		},{
			field : 'qlname',
			title : '桥梁名称 ' ,
			width : 100,
			align : "center"
		},{
			field : 'sdcode',
			title : '隧道编码 ' ,
			width : 100,
			align : "center"
		},{
			field : 'sdname',
			title : '隧道名称 ' ,
			width : 100,
			align : "center"
		},{
			field : 'hdcode',
			title : '涵洞编码 ' ,
			width : 100,
			align : "center"
		},{
			field : 'hdname',
			title : '涵洞名称 ' ,
			width : 100,
			align : "center"
		},{
			field : 'bhname',
			title : '病害名称 ' ,
			width : 90,
			align : "center"
		},{
			field : 'yhname',
			title : '养护类型 ' ,
			width : 80,
			align : "center"
		},{
			field : 'sl',
			title : '数量 ' ,
			width : 70,
			align : "center"
		},{
			field : 'dw',
			title : '计量单位 ' ,
			width : 50,
			align : "center"
		},{
			field : 'grde',
			title : '工日定额 ' ,
			width : 70,
			align : "center"
		},{
			field : 'rgf',
			title : '人工费 ' ,
			width : 70,
			align : "center"
		},{
			field : 'clf',
			title : '材料费 ' ,
			width : 70,
			align : "center"
		},{
			field : 'jxf',
			title : '机械费 ' ,
			width : 70,
			align : "center"
		},{
			field : 'xfsx',
			title : '修复时限(天) ' ,
			width : 70,
			align : "center"
		}
		]],
	});
};

var loginUserObject = null;

var yfData = null;

var initCombo = function(){
	$.ajax({
		url : YMLib.url + "nyb/getNy.do",
		async:false,
		dataType:"json",
		success:function(data){
			var obj = {};
			obj.id = "";
			obj.text = "--全部--";
			
			var array = new Array(data.length+1);
			array[0] = obj;
			for(var i=0;i<data.length;i++){
				var a = {};
				a.id=data[i].yname;
				a.text=data[i].yname;
				array[i+1] = a;
			}
			yfData = array;
			

			$("#yf").combobox({
				data : yfData,
				valueField : "id",
				textField : "text",
				onLoadSuccess : function(){
					$("#yf").combobox("setValue","");
				}
			});

		}
	});
	
};

//
var initButton = function(){
	$("#query").click(function(){
		var pxcode = $("#yf").combobox("getValue");
		$("#myGrid").datagrid("options").queryParams = {
			bmcode : loginUserObject.bmcode,
			pxcode : pxcode
		};	
		$("#myGrid").datagrid("load");
//		var url = YMLib.url + "ydjh/getRwdBytj.do?bmcode="+loginUserObject.bmcode+"&pxcode="+pxcode;
//		initGrid(url);
	});
};
//查看详细
var Ckxx = function(id){
	 window.open(YMLib.reportUrl + "reportlet=jassbhxfcdd.cpt&__bypagesize__=false&&rwdid="+cjkEncode(id));
};


$(function(){
	$.ajax({
		url:"/hmglyh/rcyh/bh_getUserInfo.do",
		async:false,
		dataType:"json",
		success:function(data){
			console.log(data);
			loginUserObject = data;
			initGrid();
			initButton();
		}
	});
	initCombo();
//	initGrid();
});





















