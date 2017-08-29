/*
 * 2015-06-16将定额下拉框换成下拉书（原Js下拉框）
 * “添加/查看”定额信息（Js）
 */
var action = parent.currentAction;//操作类型（add，view）
var currentGridRow = parent.currentGridRows;//传回来的某行Grid的数据
var yhid = parent.currentGridRows.yhid;//所属Yhid
var tbodyValueStr = "";//用于记录当前Tbody中的数据

//innerText(获取td中的纯字符数据)

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		window.top.YMLib.UI.Show("定额添加成功！",3000);
		parent.$("#myGrid").datagrid("reload");
		parent.$("#add,#view").window("close");
	}else{
		YMLib.UI.Show("定额添加失败！",3000);
	}
};

//加载按钮和Combobox
function initCombobox(){
	$("#chooseGlj").combobox({
	    url : YMLib.url +'htglglj/createGljCombobox.do',
	    panelHeight : 'auto',
	    valueField : 'id',
	    textField : 'text',
	    editable : false,//在这里加显示combobox不能编辑的属性
	    onLoadSuccess : function(){
	    	YMLib.UI.MaskHide();
	    },
	    onSelect : function(record){
	    	//alert("record.id="+record.id+",record.text="+record.text);
	    	$("#gljValueTbody").append("<tr><td style='display:none' ><div name='lxid' >"+record.id+"</div></td><td>"+record.text+"</td><td><div name='sl' contenteditable='true' style='width: 90%;' >"+1+"</div></td><td><a href='javascript:void(0);' onclick='deleteRow(this)' ><font color=blue style=cursor:pointer>删除</font></a></td></tr>");
		}
	});
}

//删除Tbody中的一行
function deleteRow(_this){
	//删除某行
	$(_this).parent().parent().remove();
}

//循环遍历Tbody获取当前数据
function eachTbody(){
	var num = 1;//用于记录行数
	tbodyValueStr = "";//清空模板数据临时存储的数据
	$("#gljValueTbody tr td div").parent().parent().each(function(){//循环div
		var divLxid = $(this).find("div[name='lxid']").text();
		var divSl = $(this).find("div[name='sl']").text();
		if(tbodyValueStr == ""){
			tbodyValueStr = divLxid+","+divSl;
		}else{
			tbodyValueStr = tbodyValueStr+"##"+divLxid+","+divSl;
		}
	});
	//alert("循环完毕，整合出的tbody的数据为："+tbodyValueStr);
}

$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	$("#yhname").val(currentGridRow.yhname);
	if(action == "view"){
		$.ajax({
    		url: YMLib.url + "htglZyxmlbgl/queryAllDeByYhid.do?yhid="+yhid,
    		type:"post",
    		dataType: "text",
    		success: function(result) {
    			//alert("返回值为："+result);
    			var deData = result.split("##");
    			for(var i = 0; i < deData.length;i++){
    				//$("#gljValueTbody").text("");//先清空tbady
    				var de = deData[i].split(",");
    				$("#gljValueTbody").append("<tr><td style='display:none' ><div name='lxid' >"+de[0]+"</div></td><td>"+de[1]+"</td><td><div name='sl' style='width: 90%;' >"+de[2]+"</div></td><td><a href='javascript:void(0);' ><font color='#888' >删除</font></a></td></tr>");
    			}
    			YMLib.UI.MaskHide();
    		},
    		error:function(result){
    			alert("“定额数据”请求失败!");
    		}
    	});
	}else if(action == "add"){
		//添加
		$("#chooseOfTr").show();
		initCombobox();//加载Combobox
	}else{
		YMLib.UI.Show("数据传输错误。",2000);
	}
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if(action == "add"){
			eachTbody();
			var pams = "yhid="+currentGridRow.yhid+"&deStrToAdd="+tbodyValueStr;
			//alert(pams);
			YMLib.Ajax.POST("htglZyxmlbgl/insertDe.do",pams,"json",A,AA);
		}else{
			parent.$("#view").window("close");
		}
	});
});