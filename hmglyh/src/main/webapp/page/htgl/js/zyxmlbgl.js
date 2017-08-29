/*
 * 作业项目类别管理Js
 */
var node;//声明一个参数（用于向子页面传递被点击的节点信息：id，text）
var currentAction = "add";

$(function () {
	YMLib.UI.MaskShow("数据加载中...");
    $("#yhlxTree").tree({
        animate: true,
        lines: true,
        url: YMLib.url + "htglZyxmlbgl/createYhlxbTree.do",
		//需要增加默认关闭节点，限制高度
		onLoadSuccess : function(){
			YMLib.UI.MaskHide();
	    },
        onClick: function (_node) {
        	node = _node;
        	//alert("node.id="+node.id+"，node.text="+node.text);
            $("#rightContent").attr("src", "yhlxGrid.jsp");
        },
	    //为树上的节点添加右键菜单
		onContextMenu: function(e, _node){
			node=_node;
			e.preventDefault();
			$('#addYhlxOfRightButton').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}
    });
    YMLib.Tools.ShowPage();
});

/**
 * 添加“养护类型”信息
 */
function addYhlx(){
	YMLib.UI.createWindow("add", "添加", "addYhlx.jsp", "box-add",634,349);
}