/* 
 * “整改回复单”的Js脚本 
 * Author : lir 
 */

//var loginUser = window.top.getLoginUserObject;//当前登陆用户的用户信息 

//var bmcode = window.top.getLoginUserObject.bmcode; 

var action = parent.currentAction;//调用页面的操作类型 

var currentGridRow = parent.currentGridRows;//传出的DataGrid中的数据 

$(function() {

	//如果是“添加”回复单 

	if ($("#action").val() == "true") {

		$("#tzdxlj").text(currentGridRow.tzdxlj);

		$("#sdtimeStr").text(currentGridRow.sdtimeStr);

		$("#sxtimeStr").text(currentGridRow.sxtimeStr);

	}

	//if(action == "add")系列已废除（2015-07-07，后台权限更改配合） 

	/*if(action == "add"){ 
	

	     $("#btnSave").show(); 
	

	     //如果是“添加” 
	

	    $("#zybmname").val(loginUser.bmname); 
	

	     $("#zybmcode").val(loginUser.bmcode); 
	

	     //日期（仅仅用来显示） 
	

	    var rqstr = ""; 
	

	     var theDate = new Date(); 
	

	     rqstr += theDate.getYear()+"年"; 
	

	     rqstr += (theDate.getMonth() + 1) + "月"; 
	

	     rqstr += theDate.getDate()+"日"; 
	

	     $("#rq").text(rqstr); 
	

	     $("#tzdxlj").text(currentGridRow.tzdxlj); 
	

	     $("#sdtimeStr").text(currentGridRow.sdtimeStr); 
	

	     $("#sxtimeStr").text(currentGridRow.sxtimeStr); 
	

	     YMLib.Tools.ShowPage(); 
	

	 }else if(action == "sh"){ 
	

	     //alert("审核"); 
	

	     $("#tzdno").show(); 
	

	     $("#tzdok").show(); 
	

	     $("#sjwctimeInputOfSpan").hide(); 
	

	     $("#sjwcsjStrOfSpan").show(); 
	

	     //查询数据 
	

	    $.ajax({ 
	

	         url: YMLib.url + "rcyh/wxzg_queryZghfdByTzdid.do?tzdid=" + currentGridRow.tzdid, 
	

	         type:"post", 
	

	         dataType: "text", 
	

	         success: function(result) { 
	

	             currentGridRow = eval("("+result+")"); 
	

	             $("#zybmname").val(currentGridRow.zybmname); 
	

	             $("#rq").text(currentGridRow.hfdateStr); 
	

	             $("#tzdxlj").text(currentGridRow.tzdxlj); 
	

	             $("#sdtimeStr").text(currentGridRow.sdtimeStr); 
	

	             $("#sxtimeStr").text(currentGridRow.sxtimeStr); 
	

	             $("#zgcs").text(currentGridRow.zgcs); 
	

	             $("#zgjg").text(currentGridRow.zgjg); 
	

	             $("#jcryj").text(currentGridRow.jcryj); 
	

	             $("#sjwcsjStrOfSpan").text(currentGridRow.sjwctimeStr); 
	

	             if($("#jcrxm").val() == ""){ 
	

	                 if(currentGridRow.jcrxm == "" || currentGridRow.jcrxm == null){ 
	

	                     $("#jcrxm").val(loginUser.ryname); 
	

	                 }else{ 
	

	                     $("#jcrxm").val(currentGridRow.jcrxm); 
	

	                 } 
	

	             } 
	

	         }, 
	

	         error:function(result){ 
	

	             YMLib.UI.Show("数据查询错误，请刷新后重试。",1500); 
	

	         } 
	

	     }); 
	

	     YMLib.Tools.ShowPage(); 
	

	 }else if(action == "edit"){ 
	

	     //alert("审核未通过，返工重做。"); 
	

	     $("#btnSave").show(); 
	

	     //查询数据 
	

	    $.ajax({ 
	

	         url: YMLib.url + "rcyh/wxzg_queryZghfdByTzdid.do?tzdid=" + currentGridRow.tzdid, 
	

	         type:"post", 
	

	         dataType: "text", 
	

	         success: function(result) { 
	

	             currentGridRow = eval("("+result+")"); 
	

	             $("#zybmname").val(currentGridRow.zybmname); 
	

	             $("#rq").text(currentGridRow.hfdateStr); 
	

	             $("#tzdxlj").text(currentGridRow.tzdxlj); 
	

	             $("#sdtimeStr").text(currentGridRow.sdtimeStr); 
	

	             $("#sxtimeStr").text(currentGridRow.sxtimeStr); 
	

	             $("#zgcs").text(currentGridRow.zgcs); 
	

	             $("#zgjg").text(currentGridRow.zgjg); 
	

	             $("#jcryj").text(currentGridRow.jcryj); 
	

	             $("#jcrxm").val(currentGridRow.jcrxm); 
	

	             $("#jcryj").contenteditable=false; 
	

	             $("#jcrxm").attr("readonly","readonly"); 
	

	         }, 
	

	         error:function(result){ 
	

	             YMLib.UI.Show("数据查询错误，请刷新后重试。",1500); 
	

	         } 
	

	     }); 
	

	     YMLib.Tools.ShowPage(); 
	

	 }else if(action == "viewOfTzd"){ 
	

	     //alert("审核"); 
	

	     $("#sjwctimeInputOfSpan").hide(); 
	

	     $("#sjwcsjStrOfSpan").show(); 
	

	     //查询数据 
	

	    $.ajax({ 
	

	         url: YMLib.url + "rcyh/wxzg_queryZghfdByTzdid.do?tzdid=" + currentGridRow.tzdid, 
	

	         type:"post", 
	

	         dataType: "text", 
	

	         success: function(result) { 
	

	             currentGridRow = eval("("+result+")"); 
	

	             $("#zybmname").val(currentGridRow.zybmname); 
	

	             $("#rq").text(currentGridRow.hfdateStr); 
	

	             $("#tzdxlj").text(currentGridRow.tzdxlj); 
	

	             $("#sdtimeStr").text(currentGridRow.sdtimeStr); 
	

	             $("#sxtimeStr").text(currentGridRow.sxtimeStr); 
	

	             $("#zgcs").text(currentGridRow.zgcs); 
	

	             $("#zgjg").text(currentGridRow.zgjg); 
	

	             $("#jcryj").text(currentGridRow.jcryj); 
	

	             $("#sjwcsjStrOfSpan").text(currentGridRow.sjwctimeStr); 
	

	             $("#jcrxm").val(currentGridRow.jcrxm); 
	

	             $("#jcrxm").attr("readonly","readonly"); 
	

	         }, 
	

	         error:function(result){ 
	

	             YMLib.UI.Show("数据查询错误，请刷新后重试。",1500); 
	

	         } 
	

	     }); 
	

	     YMLib.Tools.ShowPage(); 
	

	 }*/

	//“保存”按钮的点击事件 

	$("#btnSave").click(
			function() {

				if ($("#form").form("validate")) {

					var pams = $("#form").serialize();

					//if(action == "add"){ 

					if ($("#action").val() == "true") {

						var zgcsDiv = $("#zgcs").text();

						var zgjgDiv = $("#zgjg").text();

						//pams = pams+"&tzdid="+currentGridRow.tzdid+"&zybmcode="+loginUser.bmcode+"&zgcs="+zgcsDiv+"&zgjg="+zgjgDiv+"&tbusername="+loginUser.username; 

						pams = pams + "&tzdid=" + currentGridRow.tzdid
								+ "&zgcs=" + zgcsDiv + "&zgjg=" + zgjgDiv;

						//alert("添加回复单pams="+pams); 

						YMLib.Ajax.POST("/rcyh/wxzg_insertOneHfd.do", pams,
								"json", A, AA);

					} else if ($("#fg").val() == "true") {

						//alert("回复单返工。"); 

						var zgcsDiv = $("#zgcs").text();

						var zgjgDiv = $("#zgjg").text();

						pams = pams + "&tzdid=" + currentGridRow.tzdid
								+ "&zgcs=" + zgcsDiv + "&zgjg=" + zgjgDiv
								+ "&hfdid=" + currentGridRow.hfdid;

						//alert("返工 - 回复单pams="+pams); 

						YMLib.Ajax.POST("rcyh/wxzg_fgOfHfd.do", pams, "json",
								A, AA);

					} else {

						alert("操作类型出错。");

					}

				} else {

					YMLib.UI.Show("表单不完整。", 1500);

				}

			});

	//“整改不合格”的点击事件 

	$("#tzdno")
			.click(
					function() {

						var jcrxmStr = $("#jcrxm").val();

						var jcryjStr = $("#jcryj").text();

						if (jcrxmStr == "" || jcrxmStr == null
								|| jcryjStr == "" || jcryjStr == null) {

							YMLib.UI.Show("请填写“检查人审核意见”并签名。", 1500);

						} else {

							var hfdidToUpdate = $("#hfdid").val();

							var tzdidToUpdate = $("#tzdid").val();

							var pams = $("#form").serialize();

							pams = pams + "&jcryj=" + jcryjStr
									+ "&tzdzt=3&hfdid=" + hfdidToUpdate
									+ "&tzdid=" + tzdidToUpdate;

							//alert("整改不合格pams="+pams); 

							YMLib.Ajax.POST("/rcyh/wxzg_shHfd.do", pams,
									"json", A, AA);

						}

					});

	//“整改合格”的点击事件 

	$("#tzdok")
			.click(
					function() {

						var jcrxmStr = $("#jcrxm").val();

						var jcryjStr = $("#jcryj").text();

						if ($("#form").form("validate")) {

							var hfdidToUpdate = $("#hfdid").val();

							var tzdidToUpdate = $("#tzdid").val();

							var pams = $("#form").serialize();

							pams = pams + "&jcryj=" + jcryjStr
									+ "&tzdzt=5&hfdid=" + hfdidToUpdate
									+ "&tzdid=" + tzdidToUpdate;

							//alert("整改合格pams="+pams); 

							YMLib.Ajax.POST("/rcyh/wxzg_shHfd.do", pams,
									"json", A, AA);

						} else {

							YMLib.UI.Show("表单不完整。", 1500);

						}

					});

});

var AA = function(e) {

	alert("Post提交请求错误！错误方法：PostAjaxRequest()");

};

var A = function(_result) {

	if (_result) {

		YMLib.UI.MaskHide();

		//window.top.YMLib.UI.Show("数据操作成功！",1500); 

		parent.YMLib.UI.Show("数据操作成功！", 1500);

		parent.$("#zgtzdGrid").datagrid("reload");

		parent.$("#zghfdGrid").datagrid("reload");

		parent.$("#add,#edit,#view").window("close");

	} else {

		YMLib.UI.Show("数据操作失败！", 1500);

	}

};
