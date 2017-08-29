/*
 * 添加起止桩号（Js）
 */

var qzzhStr = parent.qzzhStrOfJSP;//接收父页面传来的起止桩号数据
var zhNum = 1;//记录桩号数量
var zhNumToID = 1;//用于生成input的id

$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	YMLib.Tools.ShowPage();
	YMLib.UI.MaskHide();
	if(qzzhStr != "" && qzzhStr != null){
		$("#addQzzhTbody").html("");
		appendData(qzzhStr);//初始化桩号信息
	}else{
		YMLib.Tools.ShowPage();
		YMLib.UI.MaskHide();
	}
	//保存按钮
	$("#btnSave").click(function(){
		if($("#addQzzhForm").form("validate")){
			keepButton();//调用方法处理数据
		}else{
			YMLib.UI.Show("请填写正确的数据。",1500);
		}
	});
});

//删除Tbody中的一行
function deleteRow(_this){
	$(_this).parent().parent().remove();//移除一行
	zhNum--;//表中行数减一
}

//Tbody中添加一行
function insertRow(){
	if(zhNum >= 5){
		YMLib.UI.Show("最多只能添加五段路。",1500);
	}else{
		$("#addQzzhTbody").append(
			"<tr><td>"+
				"K<input id='s1"+zhNumToID+"' name='startZhOne' style='width:45px' maxlength='5' />"+
				"+<input id='s2"+zhNumToID+"'  name='startZhTwo' style='width:45px' maxlength='3' />"+
				"&nbsp;-&nbsp;K"+
				"<input id='e1"+zhNumToID+"'  name='endZhOne' style='width:45px' maxlength='5' />"+
				"+<input id='e2"+zhNumToID+"'  name='endZhTwo' style='width:45px' maxlength='3' />"+
			"</td>"+
			"<td>"+
				"<a href='javascript:void(0);' onclick='insertRow()' >增</a>"+
				"&nbsp;<a href='javascript:void(0);' onclick='deleteRow(this)' >删</a>"+
			"</td></tr>"
		);
		//增加validatebox的验证
		var one = "s1"+zhNumToID;
		var two = "s2"+zhNumToID;
		var three = "e1"+zhNumToID;
		var four = "e2"+zhNumToID;
		$("#"+one).validatebox({required: true,validType: 'number'});
		$("#"+two).validatebox({required: false,validType: 'number'});
		$("#"+three).validatebox({required: true,validType: 'number'});
		$("#"+four).validatebox({required: false,validType: 'number'});
		zhNumToID++;//ID编号
		zhNum++;//表中行数加一
	}
}

//循环获取Tbody中的数据（2015.08.15废弃，转为下方新版方法）
function keepButton_old(){
	//parent.$("#toAddQzzh").val("AAAAA");//已经测试：可以正确的加载数据
	var i = 0;//用于标识是第几次循环
	var qzzhStrToView = "";//页面上展示的那个起止桩号
	var qzzhStrToCountZslc = "";//页面上隐藏的那个起止桩号，用于传递向后台计算折算里程（折算成二级公路之后的里程）
	//遍历tbody数据
	$("#addQzzhTbody tr td input").parent().parent().each(function(){//循环div
		//获取一行tbody的数据
		var startZhOne = $(this).find("input[name='startZhOne']").val();
		var startZhTwo = $(this).find("input[name='startZhTwo']").val();
		var endZhOne = $(this).find("input[name='endZhOne']").val();
		var endZhTwo = $(this).find("input[name='endZhTwo']").val();
		//alert("当前行的数据：startZhOne="+startZhOne+"，startZhTwo="+startZhTwo+"，endZhOne="+endZhOne+",endZhTwo="+endZhTwo);
		var start2;//起点桩号的后半段
		var end2;//止点桩号的后半段
		//alert("当次循环：startZhTwo="+startZhTwo+"，endZhTwo="+endZhTwo);
		if(startZhTwo == null || startZhTwo == ""){
			start2 = 0;//起点桩号的后半段
		}else{
			start2 = (parseFloat(startZhTwo))/1000;//起点桩号的后半段（三位小数）
			if(startZhTwo.length == 1){
				startZhTwo = "00"+startZhTwo;
			}else if(startZhTwo.length == 2){
				startZhTwo = "0"+startZhTwo;
			}
		}
		if(endZhTwo == null || endZhTwo == ""){
			end2 = 0;//止点桩号的后半段
		}else{
			end2 = parseFloat((parseInt(endZhTwo))/1000);//止点桩号的后半段（三位小数）
			if(endZhTwo.length == 1){
				endZhTwo = "00"+endZhTwo;
			}else if(endZhTwo.length == 2){
				endZhTwo = "0"+endZhTwo;
			}
		}
		//alert("start2="+start2+"^^ end2="+end2);
		//第二段桩号*100000去前三位：为了排除位数不组三位以及末位为0的特殊bug
		
		//以下数字计算废除（显示值），采用字符串补位计算，此代码仅用于判断桩号是否存在第二段
		var start2Str = ((start2*100000)+"").substr(0,3);//Bug位置。乘多了之后首位的一个或者多个0将被舍掉
		var end2Str = ((end2*100000)+"").substr(0,3);//Bug位置。乘多了之后首位的一个或者多个0将被舍掉
		//alert("start2Str="+start2Str+"^^ end2Str="+end2Str);
		
		//组织显示值
		if(i == 0){
			if(start2Str == "000" || start2Str == "0" || start2Str == 0){
				qzzhStrToView = "K"+startZhOne;
			}else{
				qzzhStrToView = "K"+startZhOne+"+"+startZhTwo;
			}
			if(end2Str == "000" || end2Str == "0" || end2Str == 0){
				qzzhStrToView = qzzhStrToView+"-K"+endZhOne;
			}else{
				qzzhStrToView = qzzhStrToView+"-K"+endZhOne+"+"+endZhTwo;
			}
			qzzhStrToCountZslc = (parseInt(startZhOne)+parseFloat(start2))+"-"+(parseInt(endZhOne)+parseFloat(end2));//用于计算“折算里程”
		}else{
			if(start2Str == "000" || start2Str == "0" || start2Str == 0){
				qzzhStrToView = qzzhStrToView+"、"+"K"+startZhOne;
			}else{
				qzzhStrToView = qzzhStrToView+"、"+"K"+startZhOne+"+"+start2Str;
			}
			if(end2Str == "000" || end2Str == "0" || end2Str == 0){
				qzzhStrToView = qzzhStrToView+"-K"+endZhOne;
			}else{
				qzzhStrToView = qzzhStrToView+"-K"+endZhOne+"+"+endZhTwo;
			}
			qzzhStrToCountZslc = qzzhStrToCountZslc+"###"+(parseInt(startZhOne)+parseFloat(start2))+"-"+(parseInt(endZhOne)+parseFloat(end2));//用于计算“折算里程”
		}
		i++;//循环次数+1
		//alert("当前计算折算里程的数据为："+qzzhStrToCountZslc);
	});
	parent.$("#toAddQzzh").val(qzzhStrToView);//将数据放入
	parent.$("#toAddQzzhStr").val(qzzhStrToCountZslc);//将数据放入
	parent.$("#add").window("close");
};

//循环获取Tbody中的数据。
function keepButton(){
	YMLib.UI.MaskShow("正在统计并计算数据...");
	var i = 0;//用于标识是第几次循环
	var qzzhStrToView = "";//页面上展示的那个起止桩号
	var qzzhStrToCountZslc = "";//页面上隐藏的那个起止桩号，用于传递向后台计算折算里程（折算成二级公路之后的里程）
	//遍历tbody数据
	$("#addQzzhTbody tr td input").parent().parent().each(function(){//循环div
		//获取一行tbody的数据
		var startZhOne = $(this).find("input[name='startZhOne']").val();
		var startZhTwo = $(this).find("input[name='startZhTwo']").val();
		var endZhOne = $(this).find("input[name='endZhOne']").val();
		var endZhTwo = $(this).find("input[name='endZhTwo']").val();
		//alert("当前行的数据：startZhOne="+startZhOne+"，startZhTwo="+startZhTwo+"，endZhOne="+endZhOne+",endZhTwo="+endZhTwo);
		var startZHView = "";//显示值的起点桩号
		var endZHView = "";//显示值的止点桩号
		var startZHHide = "";//隐藏值的起点桩号
		var endZHHide = "";//隐藏值的止点桩号
		//处理显示、隐藏的起点桩号
		if(startZhTwo == null || startZhTwo == ""){
			startZhTwo = "000";
			startZHView = "K"+startZhOne+"+000";//显示值
			startZHHide = startZhOne+".000";//隐藏值
		}else{
			//处理起点桩号第二段位数
			if(startZhTwo.length == 1){
				startZhTwo = "00"+startZhTwo;
			}else if(startZhTwo.length == 2){
				startZhTwo = "0"+startZhTwo;
			}
			//alert("处理后的起点桩号第二段为（Str）："+startZhTwo);
			startZHView = "K"+startZhOne+"+"+startZhTwo;//显示值
			startZHHide = startZhOne+"."+startZhTwo;//隐藏值
		}
		if(endZhTwo == null || endZhTwo == ""){
			endZhTwo = "000";
			endZHView = "K"+endZhOne+"+000";//显示值
			endZHHide = endZhOne+".000";//隐藏值
		}else{
			//处理止点桩号第二段位数
			if(endZhTwo.length == 1){
				endZhTwo = "00"+endZhTwo;
			}else if(endZhTwo.length == 2){
				endZhTwo = "0"+endZhTwo;
			}
			endZHView = "K"+endZhOne+"+"+endZhTwo;//显示值
			endZHHide = endZhOne+"."+endZhTwo;//隐藏值
		}
		//组织显示值和隐藏值
		if(i == 0){
			qzzhStrToView = startZHView+"-"+endZHView;//显示值（页面展示，数据库存储）
			qzzhStrToCountZslc = startZHHide+"-"+endZHHide;//隐藏值（用于传递向后台计算折算成二级公路的里程）
		}else{
			qzzhStrToView = qzzhStrToView+"、"+startZHView+"-"+endZHView;//显示值（页面展示，数据库存储）
			qzzhStrToCountZslc = qzzhStrToCountZslc+"###"+startZHHide+"-"+endZHHide;//隐藏值（用于传递向后台计算折算成二级公路的里程）
		}
		i++;//循环次数+1
		//alert("当前计算折算里程的数据为："+qzzhStrToCountZslc);
	});
	parent.$("#toAddQzzh").val(qzzhStrToView);//将数据放入（显示值，存入数据库用作显示）
	parent.$("#toAddQzzhStr").val(qzzhStrToCountZslc);//将数据放入（隐藏值，用于后台这算二级公路里程）
	countCxlc(qzzhStrToCountZslc);//根据起止桩号计算除雪里程
	//Ajax请求除雪面积数据（包含将“除雪面积”放入父页面）
	var lxcode = parent.$("#lxbm").val();
	//因为“###”在URL中有特殊含义。在这里将###分隔符替换掉
	var newQzzhStrToCountZslc = qzzhStrToCountZslc.replace(/\###/g,"XXX");
	var pamsOfCxmj = "qzzhStr="+newQzzhStrToCountZslc+"&lxcode="+lxcode;
	//alert("pamsOfCxmj = "+pamsOfCxmj);
	$.ajax({
		url: YMLib.url + "rcyh/djcx_countCxmj.do?"+pamsOfCxmj,
		type:"post",
		dataType: "text",
		success: function(result) {
			if(result == "error"){
				YMLib.UI.Show("请求“除雪面积”数据失败（DjcxController - countCxmj）。",1500);
			}else{
				parent.$("#cxmj").val(result*1000);//将计算好的“除雪面积”放入表单
				parent.countCxl();
			}
			YMLib.UI.MaskHide();
			parent.$("#add").window("close");
		},
		error:function(result){
			YMLib.UI.MaskHide();
			YMLib.UI.Show("ajax请求失败!",1500);
		}
	});
	//parent.$("#add").window("close");
};

//根据起止桩号计算除雪里程
function countCxlc(_qzzhStr){
	var cxlcNum = 0;//除雪里程总数
	//var hours = Math.abs((txsjTime - jxsjTime))/(1000*60*60);//取绝对值的计算
	var qzzhArray = _qzzhStr.split("###");
	for(var i=0;i<qzzhArray.length;i++){
		var zh = qzzhArray[i].split("-");
		cxlcNum = cxlcNum + Math.abs((parseFloat(zh[0]) - parseFloat(zh[1])));
	}
	parent.$("#cxlc").val(parseFloat(cxlcNum).toFixed(3));//将“除雪里程”放入副页面
}

//初始化桩号信息
function appendData(_qzzhStr){
	//_qzzhStr格式：370.123-385.001###402.154-415.501
	var zhStrArray = _qzzhStr.split("###");//拆分桩号段
	for(var i = 0;i<zhStrArray.length;i++){
		//此段代码操作的数据格式为370.123-385.001
		var array = zhStrArray[i].split("-");
		var startZHArray = array[0].split(".");
		var endZHArray = array[1].split(".");
		var startZH2;//起点桩号第二段
		var endZh2;//止点桩号第二段
		if(startZHArray.length == 1 || startZHArray[1] == null){
			startZH2 = "000";
		}else{
			//startZH2 = (((parseFloat(array[0]))*1000)+"").substr(array[0].length-2,3);//起点桩号第二段（-2的意思是*1000之后小数点被去掉了。少了一位）
			//alert("startZHArray[1]="+startZHArray[1]);
			startZH2 = startZHArray[1];
		}
		if(endZHArray.length == 1 || endZHArray[1] == null){
			endZh2 = "000";
		}else{
			//endZh2 = (((parseFloat(array[1]))*1000)+"").substr(array[1].length-2,3);//起点桩号第二段（-2的意思是*1000之后小数点被去掉了。少了一位）
			//alert("endZHArray[1]="+endZHArray[1]);
			endZh2 = endZHArray[1];
		}
		$("#addQzzhTbody").append(
				"<tr><td>"+
					"K<input id='s1"+zhNumToID+"' name='startZhOne' style='width:45px' maxlength='5' value='"+startZHArray[0]+"' />"+
					"+<input id='s2"+zhNumToID+"'  name='startZhTwo' style='width:45px' maxlength='3' value='"+startZH2+"' />"+
					"&nbsp;-&nbsp;K"+
					"<input id='e1"+zhNumToID+"'  name='endZhOne' style='width:45px' maxlength='5' value='"+endZHArray[0]+"' />"+
					"+<input id='e2"+zhNumToID+"'  name='endZhTwo' style='width:45px' maxlength='3' value='"+endZh2+"' />"+
				"</td>"+
				"<td>"+
					"<a href='javascript:void(0);' onclick='insertRow()' >增</a>"+
					"&nbsp;<a href='javascript:void(0);' onclick='deleteRow(this)' >删</a>"+
				"</td></tr>"
			);
		//增加validatebox的验证
		var one = "s1"+zhNumToID;
		var two = "s2"+zhNumToID;
		var three = "e1"+zhNumToID;
		var four = "e2"+zhNumToID;
		$("#"+one).validatebox({required: true,validType: 'number'});
		$("#"+two).validatebox({required: false,validType: 'number'});
		$("#"+three).validatebox({required: true,validType: 'number'});
		$("#"+four).validatebox({required: false,validType: 'number'});
		zhNumToID++;//ID编号
		zhNum++;//表中行数加一
	}
	YMLib.Tools.ShowPage();
	YMLib.UI.MaskHide();
}
