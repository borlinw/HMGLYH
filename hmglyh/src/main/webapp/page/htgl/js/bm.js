/*
 * 部门Js
 */
var node;//声明一个参数（用于向子页面传递被点击的节点信息：id，text）
var currentAction = "add";

$(function () {
    $("#bmTree").tree({
        animate: true,
        lines: true,
        url: YMLib.url + "htglbm/createDapartTree.do?bmcode=",
        onClick: function (_node) {
        	node = _node;
        	//alert("node.id="+node.id+"，node.text="+node.text);
            $("#rightContent").attr("src", "bmGrid.jsp");
        },
	    //为树上的节点添加右键菜单
		onContextMenu: function(e, _node){
			node=_node;
			e.preventDefault();
			$('#addBmOfRightButton').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}
    });
});

/**
 * 添加部门信息
 */
function addBm(){
	YMLib.UI.createWindow("add", "添加", "addBm.jsp", "box-add",634,349);
}