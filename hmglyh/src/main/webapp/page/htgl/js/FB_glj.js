/*
 * 工料机Js
 */
var node;//声明一个参数（用于向子页面传递被点击的节点信息：id，text）
var currentAction = "add";
var loginUserBmcode = window.top.getLoginUserObject.bmcode;
var queryDataBmcode = window.top.getLoginUserObject.bmcode;//用于查询数据的部门编码
var queryDataBmname = "";

$(function () {
	YMLib.UI.MaskShow("正在加载数据...");
	initRightButtonMnue();//加载右键菜单
	$("#gljTree").tree({
		animate: true,
		lines: true,
		url: YMLib.url + "htglglj/createGljTree.do?lxid=",
		onClick: function (_node) {
			node = _node;
			//alert("node.id="+node.id+"，node.text="+node.text);
			if(loginUserBmcode == null){
				YMLib.UI.Show("获取用户部门信息出错，请刷新后重试。",3000);
			}else if(loginUserBmcode.length < 6){
				YMLib.UI.Show("请右键选择部门查询数据。",3000);
			}else{
				$("#rightContent").attr("src", "gljGrid.jsp");
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
	YMLib.UI.createWindow("add", "添加", "addGljlx.jsp", "",634,349);
}