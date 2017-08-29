/*
 * “添加/编辑”用户信息（Js）
 */
var action = parent.currentAction;
var checkedBmcode = parent.loginUserBmcode;//被选中的部门编码
var choosedJsid = "";//被选中的角色ID（用于限制）
var choosedRyid = "";//被选中的人员ID（用于限制）

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

//加载按钮和Combobox
function initbutton(){
	//选择角色
	$("#chooseJs").combobox({
		url : YMLib.url +'htgljs/createJsCombobox.do',
		valueField : 'id',
		textField : 'text',
		panelHeight : '70',
		editable : false,//在这里加显示combobox不能编辑的属性
		onLoadSuccess : function(){
			if(action == "edit"){
				$("#chooseJs").combobox("setValue",parent.currentGridRows.jsid);
			}else if(action == "add"){
				$("#chooseJs").combobox("setValue","-请选择角色-");
			}
			YMLib.UI.MaskHide();
		},
		onSelect : function(record){
			choosedJsid = record.id;
		}
	});
	//部门 loginUserBmcode
	$("#bmCode").combotree({
		url : YMLib.url + "bm/getBmCombotree.do?bmcode="+parent.loginUserBmcode,
		panelHeight : 150,
		onLoadSuccess : function(){
			var node = $("#bmCode").combotree("tree").tree("find",parent.loginUserBmcode);
			$("#bmCode").combotree("tree").tree("select",node.target);
			$("#bmCode").combotree("setValue",parent.loginUserBmcode);
		},
		onSelect : function(node){
			//选择人员
			$("#chooseRy").combobox({
				url : YMLib.url +'htglry/createRyComboboxWithNoUsername.do?bmcode='+node.id,
				valueField : 'id',
				textField : 'text',
				panelHeight : '100',
				delay : 1,
				//editable : false,//在这里加显示combobox不能编辑的属性
				onLoadSuccess : function(){
					if(action == "edit"){
						$("#chooseRy").combobox("setValue",parent.currentGridRows.ryid);
					}else if(action == "add"){
						$("#chooseRy").combobox("setValue","-请选择人员-");
					}
					YMLib.UI.MaskHide();
				},
				onSelect : function(record){
					choosedRyid = record.id;
				}
			});
		}
	});
}

//验证用户名是否存在。
function VerifyUsername(){
	if(action == "add"){
		var username1 = $('#username').val();
		//alert("username1：" + username1);
		$.ajax({
			url: YMLib.url + "htglyh/verifyUsername.do?username=" + username1,
			type:"post",
			dataType: "text",
			success: function(result) {
				if(result == "aa"){
					window.top.YMLib.UI.Show("用户名不允许重复。",1000);
					$('#username').val("");
				}
			},
			error:function(result){
				alert("ajax请求验证用户名失败!");
			}
		});
	}
};

$(function(){
	if(action == "edit"){
		//alert("编辑：当前人员为："+parent.currentGridRows.ryname);
		$("#username").attr("readonly","readonly").css({color:'#888'});
		$("#toViewRyname").val(parent.currentGridRows.ryname);
		$("#viewRyname").show();
		$("#form").form("load",parent.currentGridRows);
		$("#rpw").val("123456");
		$("#pw").val("123456");
	}else if(action == "add"){
		//添加
		$("#pwTr").show();
		$("#rpwTr").show();
		$("#chooseRyTr").show();
		$("#bm").show();
	}else{
		YMLib.UI.Show("数据传输错误。",2000);
	}
	initbutton();//加载Combotree，Combobox
	YMLib.Tools.ShowPage();
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			var pams = $("#form").serialize();
			if(action == "add"){
				//alert("“人员”添加pams="+pams);
				if(choosedJsid == ""){
					YMLib.UI.Show("请选择角色。",2000);
				}else if(choosedRyid == ""){
					YMLib.UI.Show("请选择人员。",2000);
				}else{
					YMLib.Ajax.POST("htglyh/insertOneYh.do",pams,"json",A,AA);
				}
			}else if(action == "edit"){
				//pams = pams + "&username="+parent.currentGridRows.username;
				YMLib.Ajax.POST("htglyh/updateOneYh.do",pams,"json",A,AA);
			}
		}else{
			YMLib.UI.Show("表单不完整。",2000);
		}
	});
});