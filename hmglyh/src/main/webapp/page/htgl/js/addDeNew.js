/*
 * “添加/编辑”定额信息（Js）
 * 描述：2015-08-24新版
 */
var action = parent.currentAction;//操作类型（add，view）
var currentGridRow = parent.currentGridRows;//传回来的某行Grid的数据
var yhid = parent.currentGridRows.yhid;//所属Yhid
var tbodyValueStr = "";//用于记录当前Tbody中的数据

var isInit = false;//是否添加（用于编辑时时候添加一行）true：是编辑时的初始化，不添加；false：不是，要添加

//innerText(获取td中的纯字符数据)

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		window.top.YMLib.UI.Show("定额操作成功！",1500);
		parent.$("#myGrid").datagrid("reload");
		parent.$("#add,#edit,#view").window("close");
	}else{
		YMLib.UI.Show("定额操作失败！",1500);
	}
};

//加载按钮和Combotree
function initCombotree(){
	$("#chooseGlj").tree({
		onlyLeafCheck : true,
		checkbox : true,
        animate : true,
        lines : true,
        url : YMLib.url + "htglglj/createGljCombotreeToInsertDe.do",
		onLoadSuccess : function(node,data){
			if(action == "edit"){
				//除了保存了的“定额”数据
				var result = parent.deidOfStr;
				var deData = result.split("##");
    			for(var i = 0; i < deData.length;i++){
    				isInit = true;//标明是初始化
    				var de = deData[i].split(",");
    				var nodeOfToSelect = $("#chooseGlj").tree("find", de[0]);
					$("#chooseGlj").tree("check", nodeOfToSelect.target);
					$("#gljValueTbody").append("<tr><td style='display:none' ><div id="+de[0]+" name='lxid' >"+de[0]+"</div></td><td>"+de[1]+"</td><td><div name='sl' contenteditable='true' style='width: 90%;' >"+de[2]+"</div></td><td>"+de[3]+"</td></tr>");
    			}
			}
			YMLib.UI.MaskHide();
	    },
        onClick : function(node){
			var nodeIsLeaf = $("#chooseGlj").tree("isLeaf", node.target);//判断当前点击节点是否为叶子节点
			if(nodeIsLeaf){
				//alert(node.checked);
				if(node.checked){//若节点已被选中
					//取消其选中状态、并删除其所代表的工料机
					$("#chooseGlj").tree("uncheck", node.target);
					$("#gljValueTbody tr td div[id="+node.id+"]").parent().parent().remove();
				}else{//若节点未被选中
					//选中节点
					$("#chooseGlj").tree("check", node.target);
				}
			}
		},
		onCheck : function(node, checked){
			//alert("checked="+checked);
			var _node = node;
			if(checked){//如果是选中
				if(isInit){
					isInit = false;
				}else{
					$("#gljValueTbody").append("<tr><td style='display:none' ><div id="+node.id+" name='lxid' >"+node.id+"</div></td><td>"+node.text+"</td><td><div name='sl' contenteditable='true' style='width: 90%;' >"+1+"</div></td><td>"+_node.attributes.dw+"</td></tr>");
				}
			}else{//否则为取消选中
				$("#gljValueTbody tr td div[id="+node.id+"]").parent().parent().remove();
			}
		}
    });
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
	if(action == "add"){
		initCombotree();//加载工料机tree
	}else if(action == "edit"){
		//编辑
		initCombotree();//加载工料机tree
	}else{
		YMLib.UI.Show("数据传输错误。",1500);
	}
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if(action == "add"){
			eachTbody();
			var pams = "yhid="+currentGridRow.yhid+"&deStrToAdd="+tbodyValueStr;
			//alert(pams);
			YMLib.Ajax.POST("htglZyxmlbgl/insertDe.do",pams,"json",A,AA);
		}else if(action == "edit"){
			eachTbody();
			var pams = "yhid="+currentGridRow.yhid+"&deStrToAdd="+tbodyValueStr;
			YMLib.Ajax.POST("htglZyxmlbgl/updateDe.do",pams,"json",A,AA);
		}else{
			window.top.YMLib.UI.Show("参数传递错误。",1500);
			parent.$("#view").window("close");
		}
	});
});