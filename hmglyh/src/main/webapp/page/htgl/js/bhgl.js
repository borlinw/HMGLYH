
var treeNode;//声明一个参数（用于向子页面传递被点击的节点信息：id，text）
var currentAction = "addOfTree";

$(function () {
    $("#bhglTree").tree({
        animate: true,
        lines: true,
        url: YMLib.url + "htglbhlx/createBhlxTree.do?bhid=&length=6",
        onClick: function (node) {
        	treeNode = node;
        	//alert("treeNode.id="+treeNode.id+"，treeNode.text="+treeNode.text);
            $("#rightContent").attr("src", "bhGrid.jsp");
        },
	    //为树上的节点添加右键菜单
		onContextMenu: function(e, node){
			treeNode=node;
			e.preventDefault();
			$('#addBhOfRightButton').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		}
    });
});

/**
 * 添加“病害”
 * Tree上的右键菜单
 */
function addBh(){
	YMLib.UI.createWindow("add", "添加", "addBh.jsp", YMLib.url + "images/add.png",634,349);
}