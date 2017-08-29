/*
 * “添加/编辑”角色信息（Js）
 */
var ymArray = "";
var ymString = "";
var first = null;
var action = parent.currentAction;
var flag = false;

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		window.top.YMLib.UI.Show("数据操作成功！",1500);
		parent.$("#myGrid").datagrid("reload");
		parent.$("#add,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};

//加载页面树
var initTree = function(){
	//选择所管理页面
	$('#chooseYm').tree({
		url: YMLib.url +'htgljs/createMkCombotree.do',
		checkbox : true,
		cascadeCheck : false,
		lines : true,
		//需要增加默认关闭节点，限制高度
		onLoadSuccess : function(){
			if(action == "edit"){
				//alert("修改");
				var jsmkStr = parent.currentGridRows.jsmkStr;
				if(jsmkStr !=null && jsmkStr != ""){
					var aa = jsmkStr.split(",");
					for(var i = 0;i<aa.length;i++){
						$('#chooseYm').tree('check', $('#chooseYm').tree('find', aa[i]).target);
					}
					flag = true;
				}
			}else if(action == "add"){
				//alert("添加");
				flag = true;
			}
			YMLib.UI.MaskHide();
	    },
	    onCheck : function(node,checked){
	    	if(flag){
		    	//获取父节点
				var v = $("#chooseYm").tree("getParent",node.target);
				//获取子节点
				var children = $("#chooseYm").tree("getChildren",node.target);
				if(first == null){
					first = node;
					//如果为选中
					if(checked){
						//若子节点不为空，则子节点选中
						if(children != null){
							for(var i=0 ; i < children.length ; i++){
								$("#chooseYm").tree("check",children[i].target);
							}
						}
						//若父节点不为空，则父节点选中
						if(v != null)
							$("#chooseYm").tree("check",v.target);
					}else{
						//若子节点不为空则子节点不选中
						if(children != null){
							for(var z=0 ; z < children.length ; z++){
								$("#chooseYm").tree("uncheck",children[z].target);
							}
						}
						//若父节点不为空
						if(v != null){
							//查询父节点的子节点是否有被选中的
							var sibling = $("#tt").tree("getChildren",v.target);
							var isChecked = false;
							for(var x=0 ; x < sibling.length ; x++){
								if(sibling[x].checked)
									isChecked = true;
							}
							//父节点的子节点没有被选中的
							if(!isChecked)
								$("#chooseYm").tree("uncheck",v.target);
							else
								$("#chooseYm").tree("check",v.target);
						}
					}
					//若点击选中或不选中的节点为根节点时
					if(v == null)
						first = null;
				}else{
					//判断当前节点是点击的节点的祖辈还是子节点
					var sibling2 = $("#chooseYm").tree("getChildren",first.target);
					var isChild = false;
					if(sibling2 == null || sibling2.length == 0)
						isChild = false;
					else{
						for(var m=0 ; m < sibling2.length ; m ++){
							if(sibling2[m].id == node.id){
								isChild = true;
							}
						}
					}
					//alert(first.text+"=="+node.text + "=="+isChild);
					if(!isChild){
						var parent = $("#chooseYm").tree("getParent",node.target);
						if(parent != null)
						{
							if(checked){
								$("#chooseYm").tree("check",parent.target);
							}else{
								var sibling3 = $("#tt").tree("getChildren",parent.target);
								var isChecked2 = false;
								for(var y=0 ; y < sibling3.length ; y++){
									if(sibling3[y].checked)
										isChecked2 = true;
								}
								if(!isChecked2)
									$("#chooseYm").tree("uncheck",parent.target);
								else
									$("#chooseYm").tree("check",parent.target);
							}
						}
					}
					if(first != node && v == null){
						first = null;
					}	
				}
	    	}
	    }
	});
};

$(function(){
	YMLib.UI.MaskShow("加载中...");
	if(action == "edit"){
		$("#form").form("load",parent.currentGridRows);
	}else if(action == "add"){
		//添加
	}else{
		YMLib.UI.Show("数据传输错误。",1500);
	}
	initTree();//加载Tree
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		//得到所有选中的节点的数据集合
		ymArray = $("#chooseYm").tree('getChecked');
		ymString = "";//清空下
		for(var i=0;i<ymArray.length;i++){
			if(i+1 == ymArray.length){
				ymString = ymString+ymArray[i].id;
			}else{
				ymString = ymString+ymArray[i].id+",";
			}
		}
		//alert("ymString.length:"+ymString.length);
		//alert("该角色对管辖的页面为："+ymString);
		if(ymString.length == 0 || ymString == ""){
			YMLib.UI.Show("请先为该角色分配权限。",800);
		}else {
			if ($("#form").form("validate")) {
				var pams = $("#form").serialize()+"&jsmkStr="+ymString;
				if(action == "add"){
					YMLib.Ajax.POST("htgljs/addOneJs.do",pams,"json",A,AA);
				}else if(action == "edit"){
					pams = pams + "&jsid="+parent.currentGridRows.jsid;
					YMLib.Ajax.POST("htgljs/updateOneJs.do",pams,"json",A,AA);
				}
			}else{
				YMLib.UI.Show("表单不完整。",800);
			}
		}
	});
});