
var lxCode = null;			//路线
var szhh = 0;				//起点桩号
var ezhh = 0;				//止点桩号
var bbid = null;			//检测版本
var fx = null;				//方向
var fxState = false;		//方向下拉框是否加载完成
var ldState = false;		//路段下拉框是否加载完成
var bbState = false;		//版本下拉框是否加载完成
var src = null;				//报表用地址

var column = [{
	field : 'lxCode',
	title : '路线编码',
	align : 'center',
	width : 90
},{
	field : 'qmName',
	title : '桩号',
	align : 'center',
	width : 90
},{
	field : 'fxName',
	title : '方向',
	align : 'center',
	width : 90
},{
	field : 'jcd1',
	title : '检查点1',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd2',
	title : '检查点2',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd3',
	title : '检查点3',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd4',
	title : '检查点4',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd5',
	title : '检查点5',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd6',
	title : '检查点6',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd7',
	title : '检查点7',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd8',
	title : '检查点8',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd9',
	title : '检查点9',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'jcd10',
	title : '检查点10',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'zhi',
	title : '值',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
},{
	field : 'pjz',
	title : '平均值',
	align : 'center',
	width : 55,
	formatter : function(value,rowData,rowIndex){
		if(value == -1)
			return "";
		return value;
	}
}];

var initGrid = function(){
	$("#rqi").datagrid({
		url : YMLib.url + "lmjcb/getLmjc.do",
		queryParams : {
			lxCode : lxCode,
			szhh : szhh,
			ezhh : ezhh,
			bbid : bbid,
			jclx : "0401",
			fx : fx
		},
		border : false,
		fit : true,
		fitColumns : false,
		loadMsg : '正在加载请稍候...',
		pageNumber : 1,
		pageSize : 10,
		pageList : [10,20,30],
		striped : true,
 		showFooter : false,
		singleSelect : true,
		rownumbers : true,
		pagination : true, //分页
		columns : [column]
	});
	$("#rdi").datagrid({
		url : YMLib.url + "lmjcb/getLmjc.do",
		queryParams : {
			lxCode : lxCode,
			szhh : szhh,
			ezhh : ezhh,
			bbid : bbid,
			jclx : "0402",
			fx : fx
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
		columns : [column]
	});
	$("#sri").datagrid({
		url : YMLib.url + "lmjcb/getLmjc.do",
		queryParams : {
			lxCode : lxCode,
			szhh : szhh,
			ezhh : ezhh,
			bbid : bbid,
			jclx : "0403",
			fx : fx
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
		columns : [column]
	});
	$("#pssi").datagrid({
		url : YMLib.url + "lmjcb/getLmjc.do",
		queryParams : {
			lxCode : lxCode,
			szhh : szhh,
			ezhh : ezhh,
			bbid : bbid,
			jclx : "0404",
			fx : fx
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
		columns : [column]
	});
};

var initCombo = function(){
	$("#ldCode").combobox({
		url : YMLib.url + "lxld/getLxldCombo.do?bmCode="+window.top.loginUserObject.bmcode,
		valueField : "id",
		textField : "text",
		onSelect : function(data){
			lxCode = data.lxCode;
			szhh = data.szhh;
			ezhh = data.ezhh;
		},
		onLoadSuccess : function(){
			var data = $("#ldCode").combobox("getData");
			$("#ldCode").combobox("select",data[0].id);
			ldState = true;
			if(bbState&&fxState)
				initGrid();
		}
	});
	$("#bbid").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0202",
		valueField : "bbid",
		textField : "bbmc",
		onLoadSuccess : function(){
			var data = $("#bbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有对应的路面检测的版本，请先创建版本",2000);
			}else{
				$("#bbid").combobox("setValue",data[0].bbid);
				bbState = true;
				bbid = $("#bbid").combobox("getValue");
				if(ldState&&fxState)
					initGrid();
			}
		}
	});
	$("#fx").combobox({
		url : YMLib.url + "htglmjlx/createCombobox.do?typecodeStr=03",
		valueField : "id",
		textField : "text",
		onLoadSuccess : function(){
			var data = $("#fx").combobox("getData");
			$("#fx").combobox("setValue",data[0].id);
			fxState = true;
			fx = data[0].id;
			if(ldState&&bbState)
				initGrid();
		}
	});
};

var initQuery = function(){
	$("#queryLmjc").click(function(){
		loadGrid();
	});
	$("#import").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路面检测的版本，请先创建版本",2000);
			return;
		}
		bbid = $("#bbid").combobox("getValue");
		fx = $("#fx").combobox("getValue");
		var params = "lxCode="+lxCode+"&bbid="+bbid+"&szhh="+szhh+"&ezhh="+ezhh+"&fx="+fx;
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=hmglyh/lmjc.cpt&op=write&"+params);
		YMLib.UI.createWindow("lmjcWindow","路面检测","../lkdc/report.jsp","",734,500,function(){
			loadGrid();
		});
	});
	$("#copy").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路面检测的版本，请先创建版本",2000);
			return;
		}
		bbid = $("#bbid").combobox("getValue");
		fx = $("#fx").combobox("getValue");
		YMLib.UI.createWindow("copyData","沿用之前数据","copy.jsp","",400,200,function(){
			loadGrid();
		});
	});
	$("#edit").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有对应的路面检测的版本，请先创建版本",2000);
			return;
		}
		bbid = $("#bbid").combobox("getValue");
		fx = $("#fx").combobox("getValue");
		var params = "lxCode="+lxCode+"&bbid="+bbid+"&szhh="+szhh+"&ezhh="+ezhh+"&fx="+fx;
		src = YMLib.reportUrl + YMLib.cjkEncode("reportlet=hmglyh/lmjc-edit.cpt&op=write&"+params);
		YMLib.UI.createWindow("lmjcWindow","路面检测","../lkdc/report.jsp","",734,500,function(){
			loadGrid();
		});
	});
};

var loadGrid = function(){
	bbid = $("#bbid").combobox("getValue");
	fx = $("#fx").combobox("getValue");
	//rqi
	$("#rqi").datagrid("options").queryParams = {
		lxCode : lxCode,
		szhh : szhh,
		ezhh : ezhh,
		bbid : bbid,
		jclx : "0401",
		fx : fx
	};
	$("#rqi").datagrid("load");
	//rdi
	$("#rdi").datagrid("options").queryParams = {
		lxCode : lxCode,
		szhh : szhh,
		ezhh : ezhh,
		bbid : bbid,
		jclx : "0402",
		fx : fx
	};
	$("#rdi").datagrid("load");
	//rqi
	$("#sri").datagrid("options").queryParams = {
		lxCode : lxCode,
		szhh : szhh,
		ezhh : ezhh,
		bbid : bbid,
		jclx : "0403",
		fx : fx
	};
	$("#sri").datagrid("load");
	//rqi
	$("#pssi").datagrid("options").queryParams = {
		lxCode : lxCode,
		szhh : szhh,
		ezhh : ezhh,
		bbid : bbid,
		jclx : "0404",
		fx : fx
	};
	$("#pssi").datagrid("load");
};

$(function(){
	initCombo();
	initQuery();
});




























