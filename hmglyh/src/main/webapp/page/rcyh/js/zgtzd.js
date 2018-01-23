/* “整改通知单”的Js脚本 
 * Author : lir 
 */

var bmcode = parent.bmcode;
//var bmcode = window.top.getLoginUserObject.bmcode; 
//var loginUser = window.top.getLoginUserObject;//当前登陆用户的用户信息 
var sbbmcode = "";
var action = parent.currentAction;//调用改页面的操作类型 
//加载送单单位“Combotree”等 

function initbutton() {

	//下拉框选中查询 

	$("#chooseBmcode").combotree({

		url : YMLib.url + "htglbm/createDapartTree.do?bmcode=" + parent.bmcode,

		panelHeight : 170,

		value : parent.loginUserBmcode,

		onSelect : function(record) {

			sbbmcode = record.id;

			//alert("当前选中的部门编码为（sbbmcode）："+sbbmcode); 

		}

	});

}

$(function() {

	if (action == "add") {

		//如果是“添加” 

		//alert(loginUser.bmname+"AAA"+loginUser.bmcode+"AAA"+loginUser.ryname); 

		$("#tbbmname").val(loginUser.bmname);

		$("#tbbmcode").val(loginUser.bmcode);

		$("#tbrxm").val(loginUser.ryname);

		initbutton();//加载combotree，按钮等 

		YMLib.Tools.ShowPage();

	} else if (action == "view") {
		$("#dataToView").show(); 

		/*$("#btnSave").hide(); 

		

		$("#dataToAdd").hide(); 

		

		

		

		//查看（现在仅用于“回复单”中的查看） 

		

		$.ajax({ 

		

		    url: YMLib.url + "rcyh/wxzg_queryOneTzdOfTzdid.do?tzdid=" + parent.currentGridRows.tzdid, 

		

		    type:"post", 

		

		    dataType: "text", 

		

		    success: function(result) { 

		

		        var tzdObject = eval("("+result+")"); 

		

		        $("#tbbmname").val(tzdObject.tbbmname); 

		

		        var str = "经巡查、检查发现你单位"+tzdObject.sbbmname+"在"+tzdObject.wz+"等处，从事的养护作业存在以下问题，请务必"+tzdObject.yq+"按本单要求进行整改，并于"+tzdObject.sxtimeStr+"日前报送整改结果，特此通知。"; 

		

		        $("#dataToView").html(str); 

		

		        $("#czwt").text(tzdObject.czwt); 

		

		        $("#zgyq").text(tzdObject.zgyq); 

		

		        $("#tzdxlj").attr("readonly","readonly"); 

		

		        $("#form").form("load",tzdObject); 

		

		    }, 

		

		    error:function(result){ 

		

		        YMLib.UI.Show("数据查询错误，情书信后重试。",1500); 

		

		    } 

		

		});*/

		YMLib.Tools.ShowPage();

	}

	//“保存”按钮的点击事件 

	$("#btnSave").click(
			function() {

				if (sbbmcode == "") {

					YMLib.UI.Show("请选择送表部门。", 800);

				} else {

					if ($("#form").form("validate")) {

						var pams = $("#form").serialize();

						//if(action == "add"){ 

						if ($("#action").val()) {

							//需要取Div中的值（czwt） 

							var loginUsername = $("#loginUsername").val();

							var czwtStr = $("#czwt").text();

							var zgyqStr = $("#zgyq").text();
							var bhsl = $("#jc").val();

							pams = pams + "&tbusername=" + loginUsername
									+ "&czwt=" + czwtStr + "&zgyq=" + zgyqStr+"&bhsl="+bhsl;

							alert("pams=" + pams);

							//YMLib.Ajax.POST("/hmglyh/rcyh/wxzg_insertOneTzd.do",pams,"json",A,AA); 

							YMLib.Ajax.POST("/rcyh/wxzg_insertOneTzd.do", pams,
									"json", A, AA);

						} else {

							alert("操作类型出错。");

						}

					} else {

						YMLib.UI.Show("表单不完整。", 800);

					}

				}

			});

});

var AA = function(e) {

	alert("Post提交请求错误！错误方法：PostAjaxRequest()");

};

var A = function(_result) {

	if (_result) {

		YMLib.UI.MaskHide();

		parent.YMLib.UI.Show("数据操作成功！", 1500);

		parent.$("#zgtzdGrid").datagrid("reload");

		parent.$("#zghfdGrid").datagrid("reload");

		parent.$("#add,#edit,#view").window("close");

	} else {

		YMLib.UI.Show("数据操作失败！", 1500);

	}
};
