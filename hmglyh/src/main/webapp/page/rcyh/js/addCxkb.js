/*
 * “添加”/“查看”除雪快报表信息（Js）
 */

//下面两个用于去掉第一次进入页面时异常提示“除雪时间”应小于XXX的提示
var mark1 = "a";
var mark2 = "a";

var action = parent.currentAction;//接收父页面传来的操作类型
var cxflStrOfCombobox = "";//降雪（除雪）分类Combobox的选中值（为了验证保存时是否被选中）
var nowBmcode = "";//当前登陆用户所属的部门编码
var lxnameOfJsp = "";//页面中被险种加载的路线名称：用于验证是否已经选择路线
var qzzhOfJSP = "";//起止桩号（用于判断起止桩号是否已经填充）
var qzzhStrOfJSP = "";//起止桩号（用于向“添加起止桩号”页面传输数据：当已经填充时优先遍历）
var jxlxStrToCombobox = "-请选择降雪类型-";//用于添加/编辑加载默认值（降雪类型）
var ldnameStrToCombobox = "-请选择路段-";//用于添加/编辑加载默认值（路段名称）

var AA = function(e){
	alert("Post提交请求错误！错误方法：PostAjaxRequest()");
};

var A = function(_result){
	if(_result){
		YMLib.UI.MaskHide();
		//window.top.YMLib.UI.Show("数据操作成功！",1500);
		parent.YMLib.UI.Show("数据操作成功！",1500);
		parent.$("#myGrid").datagrid("reload");
		parent.$("#add,#view,#edit").window("close");
	}else{
		YMLib.UI.Show("数据操作失败！",1500);
	}
};

//处理除雪量的平均厚度cm*除雪面积㎡
function countCxl(){
	var pjhdFloat = parseFloat($("#pjhd").val());//平均厚度
	var cxmjFloat = parseFloat($("#cxmj").val());//除雪面积
	if(pjhdFloat > 0 && cxmjFloat > 0){
		$("#cxl").val((pjhdFloat/100*cxmjFloat)/1000);
	}else if(pjhdFloat == 0 || cxmjFloat == 0){
		$("#cxl").val(0);
	}
};

//处理除雪用盐的单价*数量=费用
function countCxyy(){
	var cxyydjFloat = parseFloat($("#cxyydj").val());//单价
	var cxyyslFloat = parseFloat($("#cxyysl").val());//数量
	if(cxyydjFloat > 0 && cxyyslFloat > 0){
		$("#cxyyfy").val((cxyydjFloat*cxyyslFloat).toFixed(2));
	}else if(cxyydjFloat == 0 || cxyyslFloat == 0){
		$("#cxyyfy").val(0);
	}
	countFyhj();
};

//处理融雪剂的单价*数量=费用
function countRxj(){
	var rxjdjFloat = parseFloat($("#rxjdj").val());//单价
	var rxjslFloat = parseFloat($("#rxjsl").val());//数量
	//alert("rxjdjFloat="+rxjdjFloat+"，rxjslFloat="+rxjslFloat);
	if(rxjdjFloat > 0 && rxjslFloat > 0){
		$("#rxjfy").val((rxjslFloat*rxjdjFloat).toFixed(2));
	}else if(rxjdjFloat == 0 || rxjslFloat == 0){
		$("#rxjfy").val(0);
	}
	countFyhj();
};

//处理滚刷的单价*数量=费用
function countGs(){
	var gsdjFloat = parseFloat($("#gsdj").val());//单价
	var gsslFloat = parseFloat($("#gssl").val());//数量
	if(gsdjFloat > 0 && gsslFloat > 0){
		$("#gsfy").val((gsdjFloat*gsslFloat).toFixed(2));
	}else if(gsdjFloat == 0 || gsslFloat == 0){
		$("#gsfy").val(0);
	}
	countFyhj();
};

//处理刀片的单价*数量=费用
function countDp(){
	var dpdjFloat = parseFloat($("#dpdj").val());//单价
	var dpslFloat = parseFloat($("#dpsl").val());//数量
	if(dpdjFloat > 0 && dpslFloat > 0){
		$("#dpfy").val((dpdjFloat*dpslFloat).toFixed(2));
	}else if(dpdjFloat == 0 || dpslFloat == 0){
		$("#dpfy").val(0);
	}
	countFyhj();
};

//处理汽油的单价*数量=费用
function countQy(){
	var qydjFloat = parseFloat($("#qydj").val());//单价
	var qyslFloat = parseFloat($("#qysl").val());//数量
	if(qydjFloat > 0 && qyslFloat > 0){
		$("#qyfy").val((qydjFloat*qyslFloat).toFixed(2));
	}else if(qydjFloat == 0 || qyslFloat == 0){
		$("#qyfy").val(0);
	}
	countFyhj();
};

//处理柴油的单价*数量=费用
function countCy(){
	var cydjFloat = parseFloat($("#cydj").val());//单价
	var cyslFloat = parseFloat($("#cysl").val());//数量
	if(cydjFloat > 0 && cyslFloat > 0){
		$("#cyfy").val((cydjFloat*cyslFloat).toFixed(2));
	}else if(cydjFloat == 0 || cyslFloat == 0){
		$("#cyfy").val(0);
	}
	countFyhj();
};

//处理其他的单价*数量=费用
function countQt(){
	var qtdjFloat = parseFloat($("#qtdj").val());//单价
	var qtslFloat = parseFloat($("#qtsl").val());//数量
	if(qtdjFloat > 0 && qtslFloat > 0){
		$("#qtfy").val((qtdjFloat*qtslFloat).toFixed(2));
	}else if(qtdjFloat == 0 || qtslFloat == 0){
		$("#qtfy").val(0);
	}
	countFyhj();
};

$(function(){
	YMLib.UI.MaskShow("正在加载页面...");
	nowBmcode = $("#nowBmcode").val();
	if(action == "add"){
		initCombobox();//加载各种Combobox
		var nowDate = new Date();
		var nowYear = nowDate.getFullYear();
		var nowMonth = nowDate.getMonth()+1;
		var nowDay = nowDate.getDate();
		var nowDateStr = nowYear+"-"+nowMonth+"-"+nowDay;
		$('#tbdateOfInput').datebox('setValue', nowDateStr);
		$('#jxsj').datetimebox({onChange : function(){countCxsj();}});//加载“降雪时间”的选择日期事件
		$('#txsj').datetimebox({onChange : function(){countCxsj();}});//加载“停雪时间”的选择日期事件
		$('#stime').datetimebox({onChange : function(){countChuxsj();}});//加载“除雪开始时间”的选择日期事件
		$('#etime').datetimebox({onChange : function(){countChuxsj();}});//加载“除雪结束时间”的选择日期事件
		YMLib.UI.MaskHide();
	}else if(action == "view"){
		YMLib.UI.MaskHide();
	}else if(action == "edit"){
		jxlxStrToCombobox = parent.currentGridRows.cxfl;
		//ldnameStrToCombobox = parent.currentGridRows.lxname;//路段名称Str
		ldnameStrToCombobox = parent.currentGridRows.ldcode;//路段编码：2016-03-07LR改
		initCombobox();//加载各种Combobox
		$("#form").form("load",parent.currentGridRows);
		$("#toAddQzzhStr").val($("#qzzhStrToViewInJsp").val());//加载起止桩号Str（用于添加和编辑“起止桩号”）
		$('#jxsj').datetimebox({onChange : function(){countCxsj();}});//加载“降雪时间”的选择日期事件
		$('#jxsj').datetimebox("setValue", parent.currentGridRows.jxsj);
		$('#txsj').datetimebox({onChange : function(){countCxsj();}});//加载“停雪时间”的选择日期事件
		$('#txsj').datetimebox("setValue", parent.currentGridRows.txsj);
		$('#stime').datetimebox({onChange : function(){countChuxsj();}});//加载“除雪开始时间”的选择日期事件
		$('#stime').datetimebox("setValue", parent.currentGridRows.stime);
		$('#etime').datetimebox({onChange : function(){countChuxsj();}});//加载“除雪结束时间”的选择日期事件
		$('#etime').datetimebox("setValue", parent.currentGridRows.etime);
		YMLib.UI.MaskHide();
	}else{
		alert("action参数传递错误，请刷新重试。");
		YMLib.UI.MaskHide();
	}
	//保存按钮
	$("#btnSave").click(function(){
		if ($("#form").form("validate")) {
			if(action == "add"){
				lxnameOfJsp = $("#chooseLxname").val();
				qzzhStrOfJSP = $("#toAddQzzhStr").val();
				var tbdateStr = $('#tbdateOfInput').datebox('getValue');
				//alert("当前被选中的路线名称是："+lxnameOfJsp);
				if(tbdateStr == "" || tbdateStr == null){
					YMLib.UI.Show("填报日期不能为空。",1500);
				}else if(cxflStrOfCombobox == ""){
					YMLib.UI.Show("请选择降雪分类。",1500);
				}else if(lxnameOfJsp == null || lxnameOfJsp == ""){
					YMLib.UI.Show("请选择路线。",1500);
				}else if(qzzhStrOfJSP == null || qzzhStrOfJSP == ""){
					YMLib.UI.Show("请填写“起止桩号”。",1500);
				}else{
					var pams = $("#form").serialize();
					var jxsjStrToEdit = $("#jxsj").datetimebox("getValue");		//降雪时间
					var txsjStrToEdit = $("#txsj").datetimebox("getValue");		//停雪时间
					var stimeStrToEdit = $("#stime").datetimebox("getValue");	//除雪开始时间
					var etimeStrToEdit = $("#etime").datetimebox("getValue");	//除雪结束时间
					var nzCxrsStr = $("#nzCxrs").text();
					var nzCxclStr = $("#nzCxcl").text();
					var nzCxmjStr = $("#nzCxmj").text();
					var nzCxlStr = $("#nzCxl").text();
					
					console.log(pams);
					var nzStrToExport = nzCxrsStr+"###"+nzCxclStr+"###"+nzCxmjStr+"###"+nzCxlStr+"###";
//					console.log(nzStrToExport);
					nzStrToExport = nzStrToExport.replace(/\+/g,"xxxxx");
					var ldcodeStr = $("#chooseLd").combobox("getValue");//获取路线编码
					pams = pams+"&tbdate="+tbdateStr+"&nz="+nzStrToExport+"&jxsjStr="+jxsjStrToEdit+"&txsjStr="+txsjStrToEdit+"&stimeStr="+stimeStrToEdit+"&etimeStr="+etimeStrToEdit+"&ldcode="+ldcodeStr;
					//alert("add -> pams="+pams);
					YMLib.Ajax.POST("/rcyh/djcx_addOneCxkb.do",pams,"json",A,AA);
				}
			}else if(action == "edit"){
				var pams = $("#form").serialize();
				var jxsjStrToEdit = $("#jxsj").datetimebox("getValue");		//降雪时间
				var txsjStrToEdit = $("#txsj").datetimebox("getValue");		//停雪时间
				var stimeStrToEdit = $("#stime").datetimebox("getValue");	//除雪开始时间
				var etimeStrToEdit = $("#etime").datetimebox("getValue");	//除雪结束时间
				var nzCxrsStr = $("#nzCxrs").text();
				var nzCxclStr = $("#nzCxcl").text();
				var nzCxmjStr = $("#nzCxmj").text();
				var nzCxlStr = $("#nzCxl").text();
				console.log(pams);
//				var bz = document.getElementById("bz").value
				var nzStrToExport = nzCxrsStr+"###"+nzCxclStr+"###"+nzCxmjStr+"###"+nzCxlStr+"###";
				
				nzStrToExport = nzStrToExport.replace(/\+/g,"xxxxx");
				var ldcodeStr = $("#chooseLd").combobox("getValue");//获取路线编码
				pams = pams+"&nz="+nzStrToExport+"&kbid="+parent.currentGridRows.kbid+"&jxsjStr="+jxsjStrToEdit+"&txsjStr="+txsjStrToEdit+"&stimeStr="+stimeStrToEdit+"&etimeStr="+etimeStrToEdit+"&ldcode="+ldcodeStr;
				//alert("edit -> pams="+pams);
				YMLib.Ajax.POST("/rcyh/djcx_editOneCxkb.do",pams,"json",A,AA);
			}else{
				YMLib.UI.Show("类型参数传递出错。",1500);
			}
		}else{
			YMLib.UI.Show("表单不完整。",1500);
		}
	});
});


//处理费用合计
function countFyhj(){
	var allFy = 0;//费用合计
	var num1 = parseFloat($("#cxyyfy").val());//除雪用盐
	var num2 = parseFloat($("#rxjfy").val());//融雪剂
	var num3 = parseFloat($("#gsfy").val());//滚刷
	var num4 = parseFloat($("#dpfy").val());//刀片
	var num5 = parseFloat($("#qyfy").val());//汽油
	var num6 = parseFloat($("#cyfy").val());//柴油
	var num7 = parseFloat($("#qtfy").val());//其他
	if(num1 > 0 ){
		allFy = allFy + num1;
	}
	if(num2 > 0 ){
		allFy = allFy + num2;
	}
	if(num3 > 0 ){
		allFy = allFy + num3;
	}
	if(num4 > 0 ){
		allFy = allFy + num4;
	}
	if(num5 > 0 ){
		allFy = allFy + num5;
	}
	if(num6 > 0 ){
		allFy = allFy + num6;
	}
	if(num7 > 0 ){
		allFy = allFy + num7;
	}
	$("#fyhj").val((allFy).toFixed(2));
};

//降雪时间与停雪时间之间的差是持续时间（计算持续时间）
function countCxsj(){
	if(mark1 != "a"){
		var jxsjStr = $('#jxsj').datetimebox('getValue');//降雪时间
		var txsjStr = $('#txsj').datetimebox('getValue');//停雪时间
		//将降雪时间转化为日期
		jxsjStr = jxsjStr.replace(/-/g,"/");
		var jxsjTime = new Date(jxsjStr).getTime();
		//将停雪时间转化为日期
		txsjStr = txsjStr.replace(/-/g,"/");
		var txsjTime = new Date(txsjStr).getTime();
		//计算器相差的小时数
		//var hours = Math.abs((txsjTime - jxsjTime))/(1000*60*60);//取绝对值的计算
		var hours = (txsjTime - jxsjTime)/(1000*60*60);
		if(!(hours<0)){
			$("#cxsj").val(parseFloat(hours).toFixed(2));
		}else{
			$("#cxsj").val("0.00");
			YMLib.UI.Show("停雪时间必须小于降雪时间。",1500);
		}
	}else{
		mark1 = "b";
	}
}

//除雪开始时间与除雪结束时间之间的差是除雪时间（计算除雪时间）
function countChuxsj(){
	if(mark2 != "a"){
		var stimeStr = $('#stime').datetimebox('getValue');//除雪开始时间
		var etimeStr = $('#etime').datetimebox('getValue');//除雪结束时间
		var stimeStrTime = new Date(stimeStr.replace(/-/g,"/")).getTime();
		var etimeStrTime = new Date(etimeStr.replace(/-/g,"/")).getTime();
		//计算器相差的小时数
		//var hours = Math.abs((etimeStrTime - stimeStrTime))/(1000*60*60);//取绝对值的计算
		var hours = (etimeStrTime - stimeStrTime)/(1000*60*60);
		if(!(hours<0)){
			$("#chuxsj").val(parseFloat(hours).toFixed(2));
		}else{
			$("#chuxsj").val("0.00");
			YMLib.UI.Show("除雪结束时间必须小于除雪开始时间。",1500);
		}
		countRggrAndJxtb();//除雪时间改变调用修改“人工工日”和“机械台班”的方法同步数据。
	}else{
		mark2 = "b";
	}
}

//“除雪时间”的改变事件
function countRggrAndJxtb(){
	countRggr();//人工工日
	countJxtb();//机械台班
};

//根据“备注 - 除雪人数”和“除雪时间”改变“人工工日”
function countRggr(){
	var cxrsFloat = parseFloat($("#cxrs").val());//除雪人数
	var chuxsjFloat = parseFloat($("#chuxsj").val());//除雪时间
	if(chuxsjFloat > 0 && cxrsFloat > 0){
		$("#rggr").val(((cxrsFloat*chuxsjFloat)/8).toFixed(2));
	}else if(chuxsjFloat == 0 || cxrsFloat == 0){
		$("#rggr").val(0);
	}
};

//根据“备注 - 除雪车辆”和“除雪时间”改变“人工工日”
function countJxtb(){
	var jxclFloat = parseFloat($("#jxcl").val());//除雪人数
	var chuxsjFloat = parseFloat($("#chuxsj").val());//除雪时间
	if(chuxsjFloat > 0 && jxclFloat > 0){
		$("#jxtb").val(((jxclFloat*chuxsjFloat)/8).toFixed(2));
	}else if(chuxsjFloat == 0 || jxclFloat == 0){
		$("#jxtb").val(0);
	}
};

/**
 * 除雪厚度的级联（影响降雪分类）
 * 键盘抬起事件
 */
function changeJxfl(){
	//微雪   h<=1
	//小雪   1<h<=5
	//中雪   5<h<=10
	//大雪   10<h<=20
	//暴雪   h>20
	var pjhdFloat = parseFloat($("#pjhd").val());//平均厚度
	if(pjhdFloat <= 1){
		//alert("小于等于1 <微雪>");
		$("#chooseCxfl").combobox("select","0607");
	}else if(pjhdFloat <= 5){
		//alert("大于1小于等于5 <小雪>");
		$("#chooseCxfl").combobox("select","0602");
	}else if(pjhdFloat <= 10){
		//alert("大于5小于等于10 <中雪>");
		$("#chooseCxfl").combobox("select","0603");
	}else if(pjhdFloat <= 20){
		//alert("大于10小于等于20 <大雪>");
		$("#chooseCxfl").combobox("select","0604");
	}else{
		//alert("<暴雪>");
		$("#chooseCxfl").combobox("select","0605");
	}
};



//初始化Combobox（部门类型）
function initCombobox(){
	//加载“起止桩号”的编辑事件
	$("#insertQzhhTD").click(function(){
		lxnameOfJsp = $("#chooseLxname").val();
		if(lxnameOfJsp == null || lxnameOfJsp == ""){
			YMLib.UI.Show("请选择路线后在添加桩号信息。",1500);
		}else{
			qzzhStrOfJSP = $("#toAddQzzhStr").val();
			YMLib.UI.createWindow("add", "添加", YMLib.url+"page/rcyh/djcx/addQzzh.jsp", "box-add",320,230);
		}
	});
	//除雪（降雪）分类：枚举表
	$("#chooseCxfl").combobox({
		url : YMLib.url +'htglmjlx/createCombobox.do?typecodeStr=06',
		valueField : 'id',
		textField : 'text',
		editable : false,//在这里加显示combobox不能编辑的属性
		//给Combobox一个默认值
		onLoadSuccess : function(){
			//$("#chooseCxfl").combobox("setValue","-请选择降雪类型-");
			$("#chooseCxfl").combobox("setValue",jxlxStrToCombobox);
			YMLib.UI.MaskHide();
		},
		onSelect : function(record){
			cxflStrOfCombobox = record.id;
		}
	});
	//选择路段
	$("#chooseLd").combobox({
		url : YMLib.url +'htglld/createLdCombobox.do?bmcode='+nowBmcode,
		valueField : 'id',
		textField : 'text',
		editable : false,//在这里加显示combobox不能编辑的属性
		//给Combobox一个默认值
		onLoadSuccess : function(){
			//$("#chooseLd").combobox("setValue","-请选择路段-");
			$("#chooseLd").combobox("setValue",ldnameStrToCombobox);
			YMLib.UI.MaskHide();
		},
		onSelect : function(record){
			if(ldnameStrToCombobox == "-请选择路段-"){
				ldnameStrToCombobox = "路线已选择";
			}else{
				$("#cxmj").val("");//清空“除雪面积”菜单
				YMLib.UI.Show("路线更改，请注意确认“起止桩号”以便于重新计算除雪面积。",1500);
			}
			$("#lxbm").val(record.lxcode);
			$("#chooseLxname").val(record.text);
			//alert(record.szhh+"^^^"+record.ezhh);
		}
	});
}