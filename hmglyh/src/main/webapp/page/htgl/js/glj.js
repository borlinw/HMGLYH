/*
 * 工料机Js
 */
var node;//声明一个参数（用于向子页面传递被点击的节点信息：id，text）
var currentAction = "add";
var loginUserBmcode = window.top.getLoginUserObject.bmcode;
//var queryDataBmcode = window.top.getLoginUserObject.bmcode;//用于查询数据的部门编码
var queryDataBmcode = "";//用于查询数据的部门编码
var queryDataBmname = "";

var initNum = 0;//控制工料机树的加载时候的遮罩层

$(function () {
	YMLib.UI.MaskShow("正在加载数据...");
	//加载用与查询DataGrid数据的Bmcode，以及添加“工料机价格”时的部门名称选择
	if(loginUserBmcode.length > 6){
		//截取Bmcode前六位
		//alert("部门名称的获取需要请求后台数据");
		queryDataBmcode = loginUserBmcode.substr(0, 6);
		//queryDataBmname = "需要请求后台数据";
		//alert("queryDataBmcode="+queryDataBmcode);
		$.ajax({
    		url: YMLib.url + "htglbm/queryBmnameByBmcode.do?bmcode="+queryDataBmcode,
    		type:"post",
    		dataType: "text",
    		success: function(result) {
    			queryDataBmname = result;
    			//alert("请求回来的queryDataBmname="+queryDataBmname);
    			if(initNum == 0){
    				initNum++;
    			}else{
    				YMLib.UI.MaskHide();
    			}
    		},
    		error:function(result){
    			alert("ajax请求“部门名称”失败!");
	 			YMLib.UI.MaskHide();
    		}
    	});
	}else if(loginUserBmcode.length < 5){
		//显示选择部门Div
		$("#chooseBmcodeDiv").show();
		//加载部门选择下拉框
		$("#chooseBmcode").combobox({
			url : YMLib.url +"htglbm/queryBmToGlj.do?bmcode="+loginUserBmcode,
			valueField : 'id',
			textField : 'text',
			panelHeight : '150',
			editable : false,//在这里加显示combobox不能编辑的属性
			onLoadSuccess : function(){
				$("#chooseBmcode").combobox("setValue","-请选择部门-");
				if(initNum == 0){
    				initNum++;
    			}else{
    				YMLib.UI.MaskHide();
    			}
			},
			onSelect : function(record){
				choosedJsid = record.id;
				queryDataBmcode = record.id;//用于查询数据的部门编码
				queryDataBmname = record.text;//用于查询数据的部门名称
			}
		});
	}else if(loginUserBmcode.length == 6){
		queryDataBmcode = loginUserBmcode;//被查询的部门code
		queryDataBmname = window.top.getLoginUserObject.bmname;//被查询的部门名称
		YMLib.UI.MaskHide();
	}
	//initRightButtonMnue();//加载右键菜单//2015-06-16更新Bmcode查询方式（此方法废弃，相关后台代码被更改）
	$("#gljTree").tree({
		animate: true,
		lines: true,
		url: YMLib.url + "htglglj/createGljTree.do?lxid=",
		onLoadSuccess : function(node,data){
			if(initNum == 0){
				initNum++;
			}else{
				YMLib.UI.MaskHide();
			}
	    },
		onClick: function (_node) {
			node = _node;
			//alert("node.id="+node.id+"，node.text="+node.text);
			if(loginUserBmcode == null){
				YMLib.UI.Show("获取用户部门信息出错，请刷新后重试。",1500);
			}else if(loginUserBmcode.length < 6){
				if(queryDataBmcode != "" && queryDataBmcode.length == 6){
					$("#rightContent").attr("src", "gljGrid.jsp");
				}else{
					YMLib.UI.Show("请先选择部门再查询数据。",1500);
				}
			}else{
				if(queryDataBmcode != "" && queryDataBmcode.length == 6){
					$("#rightContent").attr("src", "gljGrid.jsp");
				}else{
					YMLib.UI.Show("部门数据加载出错。bmcode.length>6",1500);
				}
				//$("#rightContent").attr("src", "gljGrid.jsp");
			}
		},
	    //为树上的节点添加右键菜单
		onContextMenu: function(e, _node){
			node=_node;
			e.preventDefault();
			$('#addGljOfRightButton').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}
	});
});

/**
 * 加载右键菜单的相关数据（根据部门）
 * 2015-06-16更新Bmcode查询方式（此方法废弃，相关后台代码被更改）
 */
function initRightButtonMnue(){
	//var divStrToAppende = "<div><span>选择部门</span><div>";
	var divStrToAppende = "";
	if(loginUserBmcode != null && loginUserBmcode != "" && loginUserBmcode.length < 6){
		//调用后台方法，查询其下的bmcode.length=6的部门并append到右键菜单中。
		$.ajax({
    		url: YMLib.url + "htglbm/queryBmToGlj.do?bmcode="+loginUserBmcode,
    		type:"post",
    		dataType: "text",
    		success: function(result) {
    			var bmData = result.split(";");
    			for(var i = 0; i < bmData.length; i++){
    				var data = bmData[i].split(",");
    				//alert("当前数据 ==> bmcode="+data[0]+"，bmname="+data[1]);
    				divStrToAppende = divStrToAppende + "<div onclick=jumpPage('"+data[0]+"','"+data[1]+"') >"+data[1]+"</div>";
    			}
    			//divStrToAppende = divStrToAppende+"</div></div>";
    			$("#toDepart").append(divStrToAppende);
    			$("#addGljOfRightButton").menu();
    			$("#departMenu").show();//显示Div
    		},
    		error:function(result){
    			alert("“Tree”右键菜单的“部门数据”请求失败!");
    		}
    	});
	}
	YMLib.UI.MaskHide();
}

/**
 * 跳转页面
 * 被废弃的方法的调用方法（2015-06-16废弃）
 */
function jumpPage(_bmcodeToJumpPage,_bmnameToJumpPage){
	//alert("被选中的部门编码为："+_bmcodeToJumpPage+"，被选中的部门名称为："+_bmnameToJumpPage);
	queryDataBmcode = _bmcodeToJumpPage;
	queryDataBmname = _bmnameToJumpPage;
	$("#rightContent").attr("src", "gljGrid.jsp");
}

/**
 * 添加“工料机”信息
 */
function addGlj(){
	YMLib.UI.createWindow("add", "添加", "addGljlx.jsp", "box-add",634,349);
}