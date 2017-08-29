/*
 * “添加/查看”定额信息（Js）
 * 2015-08-24改版后“添加/编辑”功能放入addDeNew.jsp
 * 此页面以及js禁用作查看
 */
var action = parent.currentAction;//操作类型（add，view）
var currentGridRow = parent.currentGridRows;//传回来的某行Grid的数据
var yhid = parent.currentGridRows.yhid;//所属Yhid
var tbodyValueStr = "";//用于记录当前Tbody中的数据

$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	$("#yhname").val(currentGridRow.yhname);
	if(action == "view"){
		$.ajax({
    		url: YMLib.url + "htglZyxmlbgl/queryAllDeByYhid.do?yhid="+yhid,
    		type:"post",
    		dataType: "text",
    		success: function(result) {
    			//alert("返回值为："+result);
    			var deData = result.split("##");
    			for(var i = 0; i < deData.length;i++){
    				//$("#gljValueTbody").text("");//先清空tbady
    				var de = deData[i].split(",");
    				$("#gljValueTbody").append("<tr><td style='display:none' ><div name='lxid' >"+de[0]+"</div></td><td>"+de[1]+"</td><td><div name='sl' style='width: 90%;' >"+de[2]+"</div></td><td>"+de[3]+"</td></tr>");
    			}
    			YMLib.UI.MaskHide();
    		},
    		error:function(result){
    			alert("“定额数据”请求失败!");
    		}
    	});
	}else{
		YMLib.UI.Show("数据传输错误。",1500);
	}
	YMLib.Tools.ShowPage();
});