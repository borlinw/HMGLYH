var doubleFixed = 3;
var moneyFixed = 2;
/**
 * 任务单页面 关于计算的 初始化
 */
function rwdCalculate(bmcode,yhid){
		if( !bmcode || bmcode == "" || bmcode == null ) {
			$.messager.alert('警告','请选择派工部门','warning');
			return;
		}
		if( !yhid || yhid == "" || yhid == null ) {
			$.messager.alert('警告','请选择作业类型','warning');
			return;	
		}
		
		$.ajax({
			url : '/hmglyh/rcyh/wxzy_rwdCalculate.do',
			dataType : 'json',
			data : {
				'rwd.bmcode' : bmcode,
				'rwd.yhid' : yhid
			},
			success : function(data) {
				
				
				$("#dwSpan").html(data.dw); // 初始化 单位 
				$("#rgdj").val(parseFloat(data.rgdj).toFixed(moneyFixed)); // 初始化人工单价
				$("#grde").val(data.grde);  // 初始化工日定额
				$("#clfTotal").val(parseFloat(data.clfTotal).toFixed(moneyFixed)); //初始化 材料费
				$("#jxfTotal").val(parseFloat(data.jxfTotal).toFixed(moneyFixed)); // 初始化 机械费
				$("#dejs").val(data.dejs);  // 定额基数
				var srz = $("#srz").val();
				if(!isNaN(srz) && srz > 0 ) {
					var xsz = (parseFloat(srz) / parseFloat(data.dejs)).toFixed(doubleFixed);
					$("#pgsl").val(xsz);
					$("#xsz").val(xsz);
				}
				// 材料
				$("#jhclxhTable").find(".data-row").remove();
				var clHtml = createHtml(data.cls);
				$("#jhclxhTable").append(clHtml);
				
				$("#jhjxxhTable").find(".data-row").remove();
				var jxHtml = createHtml(data.jxs);
				$("#jhjxxhTable").append(jxHtml);
				
				
				reCalculate1(); // 重新计算人工费 和 总工日
			},
			error : function(e) {
				console.error(e);
			}
		});
}

//删除一行数据
function delRows(obj){
	var trE = $(obj).parentsUntil(".data-row").parent();
	trE.find(".gljdj").val(0);
	trE.remove();
	reCalculate1();
}

var length = 0;

//添加 计划 材料消耗
 function addJhclxh(){
	 
	 var yhlxid = "";
	 var cls = $("#xmmcid").attr("class");
	 if(cls && cls.indexOf("easyui-combotree") >= 0 ) {
		yhlxid = $("#xmmcid").combotree("getValue");
	 }else{
		 yhlxid = $("#xmmcid").val();
	 }
	
	var bmcode = "";
	cls  = $("#rwdbmcodeid").attr("class");
	if(cls && cls.indexOf("easyui-combobox") >= 0 ) {
		bmcode = $("#rwdbmcodeid").combobox("getValue");
	}else{
		bmcode = $("#rwdbmcodeid").val();
	}
		
	var nodes = $("#jhclxh").combotree("tree").tree("getChecked");
	if((!yhlxid) || (yhlxid == '')) {
		 $.messager.alert('警告','请您先选择项目的名称','warning');
		 return;
	}
	
	if((!bmcode) || (bmcode == '')) {
		 $.messager.alert('警告','请您先选择派工部门','warning');
		 return;
	}
	var ids = [];
	var nodeArr = getNodeArr(nodes);
	$.each(nodeArr,function(i,d){
		ids.push(d.id);
	});
	if( ids.length <= 0 ) {
		$.messager.alert('警告','您没有选择任何材料','warning');
		return;
	}
	
	length += ids.length;
	
	$("#jhclxhTable").find(".data-row").remove();
	// 获取价格列表
	getGljdjs(ids,bmcode,function(data,html){
		$("#jhclxhTable").append(html);
		var total = 0;
		$.each(data,function(i,d){
			if( d != null ) {
				total += parseFloat(d.dj)*parseFloat(d.sl);
			}
		});
		$("#clfTotal").val(parseFloat(total).toFixed(moneyFixed));
	});
 }


// 添加 计划 机械消耗
function addJhjxxh(){
	 var yhlxid = "";
	 var cls = $("#xmmcid").attr("class");
	 if(cls && cls.indexOf("easyui-combotree") >= 0 ) {
		yhlxid = $("#xmmcid").combotree("getValue");
	 }else{
		 yhlxid = $("#xmmcid").val();
	 }
	
	var bmcode = "";
	cls  = $("#rwdbmcodeid").attr("class");
	if(cls && cls.indexOf("easyui-combobox") >= 0 ) {
		bmcode = $("#rwdbmcodeid").combobox("getValue");
	}else{
		bmcode = $("#rwdbmcodeid").val();
	}
	
	var nodes = $("#jhjxxh").combotree("tree").tree("getChecked");
	
	if((!yhlxid) || (yhlxid == '')) {
		 $.messager.alert('警告','请您先选择项目的名称','warning');
		 return;
	}
	
	if((!bmcode) || (bmcode == '')) {
		 $.messager.alert('警告','请您先选择派工部门','warning');
		 return;
	}
	
	var ids = [];
	var nodeArr = getNodeArr(nodes);
	$.each(nodeArr,function(i,d){
		ids.push(d.id);
	});
	if( ids.length <= 0 ) {
		$.messager.alert('警告','您没有选择任何机械','warning');
		return;
	}
	
	length += ids.length;
	
	$("#jhjxxhTable").find(".data-row").remove();	
	// 获取价格列表
	getGljdjs(ids,bmcode,function(data,html){
		$("#jhjxxhTable").append(html);
		var total = 0;
		$.each(data,function(i,d){
			if( d != null ) {
				total += parseFloat(d.dj)*parseFloat(d.sl);
			}
		});
		$("#jxfTotal").val(parseFloat(total).toFixed(MoneyFixed));
	});
} 

//根据部门编码 和 工料机的 ID 查询 工料机的 单价
function getGljdjs(ids,bmcode,callback){
	
	 var yhlxid = "";
	 var cls = $("#xmmcid").attr("class");
	 if(cls && cls.indexOf("easyui-combotree") >= 0 ) {
		yhlxid = $("#xmmcid").combotree("getValue");
	 }else{
		 yhlxid = $("#xmmcid").val();
	 }
	
	if((!yhlxid) || (yhlxid == '')) {
		 $.messager.alert('警告','请您先选择项目的名称','warning');
		 return;
	}
	
	$.ajax({
		url:"/hmglyh/rcyh/wxzy_getGljdj.do",
		dataType:"json",
		traditional:true,
		data:{
			ids:ids,
			bmcode:bmcode,
			yhlxid:yhlxid
		},
		success:function(data){
			if( data.isError) {
				$.messager.alert("出错了!","服务器返回的信息:"+data.info,"warning");
			}else{
					var html = createHtml(data);
					if(callback){
						callback(data,html);
					}
				}
			}
	});
}

function createHtml(data){
	if( data && data.length > 0 ){
		var html = "";
		var nameStr;
		if(data[0].lxid.match("^002")) {
			nameStr = "rwd.cls";
		}else{
			nameStr = "rwd.jxs";
		}
		$.each(data,function(i,d){
			
			var zhenshiLdname = d.lxname;
			var shortLdname = d.lxname;
			
			if( shortLdname.length > 12 ) {
				shortLdname = zhenshiLdname.substring(0,12)+"...";
			}
			
			html += "<tr class='datagrid-row data-row'>" +
						"<td>" +
							"<div style='height:auto;text-align:center' class='datagrid-cell'>" +
								/*"<input value='"+d.lxname+"' />" +*/
								"<a title='"+zhenshiLdname+"'>"+shortLdname+"</a>"+
								"<input type='hidden' name='"+nameStr+"["+i+"].lxid' value='"+d.lxid+"' />" +
							"</div>" +
						"</td>" +
						"<td>" +
							"<div style='height:auto;text-align:center' class='datagrid-cell'>"+d.bm+"</div>" +
						"</td>" +
						"<td>" +
							"<div style='height:auto;text-align:center' class='datagrid-cell'>" +
								"<input readonly='readonly' class='gljdj' name='"+nameStr+"["+i+"].dj'  value="+(d.dj).toFixed(moneyFixed)+" type='text'>" +
							"</div>" +
						"</td>" +
						"<td>" +
							"<div style='height:auto;text-align:center;width:200px;white-space:normal;' class='datagrid-cell'>"+d.gg+"</div>" +
						"</td>" +
						"<td>" +
							"<div style='height:auto;text-align:center' class='datagrid-cell'>" +
								"<input name='"+nameStr+"["+i+"].sl' class='gljsl' onblur='gljslblur(this,\""+d.lxid+"\")' type='text' value='"+(d.sl).toFixed(doubleFixed)+"' desl='"+(d.sl).toFixed(doubleFixed)+"' style='width:50px;'>"+d.dw+"" +
							"</div>" +
						"</td>" +
						"<td>" +
							"<div style='height:auto;text-align:center' class='datagrid-cell'>" +
								"<a href='javascript:void(0);' onclick='delRows(this,\""+d.lxid+"\")'>删除</a>" +
							"</div>" +
						"</td>'" +
					"</tr>";
		});
		return html;
	}
	return "";
}

function getNodeArr(nodes){
	var nodeArr = [];
	$.each(nodes,function(i,d){
		if( d.id.length > 3 ) {
			var obj = {};
			obj.lxname = d.text;
			obj.gg = d.attributes.gg;
			obj.dw = d.attributes.dw;
			obj.id = d.id;
			nodeArr.push(obj);
		}
	});
	return nodeArr;
}

/**
 * 计算 人工费，总工日
 */
function reCalculate1(){
	
	var pgsl = $("#pgsl").val();
	var rgdj = $("#rgdj").val();
	var grde = $("#grde").val();
	
	if(isNaN(pgsl) || pgsl == ""){
		return;
	}
	
	if(isNaN(rgdj) || rgdj == ""){
		return;
	}
	
	if(isNaN(grde) || grde == ""){
		return;
	}
	
	$("#jhgr").val(parseFloat(pgsl*grde).toFixed(doubleFixed)); // 计算计划工日
	$("#jhrgf").val(parseFloat(pgsl*grde*rgdj).toFixed(moneyFixed)); // 计算计划人工费
	
	// 计算计划消耗材料费
	var trEs = $("#jhclxhTable").find(".data-row");
	var clfTotal = 0;
	var i = 0; 
	for( i ; i < trEs.length ; i++ ) {
		var dj = $(trEs[i]).find(".gljdj").val();
		var sl = $(trEs[i]).find(".gljsl").attr("desl");
		sl = sl*pgsl;
		$(trEs[i]).find(".gljsl").val(sl.toFixed(doubleFixed));
		clfTotal += parseFloat(dj) * parseFloat(sl);
	}
	$("#clfTotal").val(parseFloat(clfTotal).toFixed(moneyFixed));
	// 计算计划消耗机械费
	var trEs = $("#jhjxxhTable").find(".data-row");
	var jxfTotal = 0;
	var i = 0; 
	for( i ; i < trEs.length ; i++ ) {
		var dj = $(trEs[i]).find(".gljdj").val();
		var sl = $(trEs[i]).find(".gljsl").attr("desl");
		sl = sl*pgsl;
		$(trEs[i]).find(".gljsl").val(sl.toFixed(doubleFixed));
		jxfTotal += parseFloat(dj) * parseFloat(sl);
	}
	$("#jxfTotal").val(parseFloat(jxfTotal).toFixed(moneyFixed));
}

// 计算1 人员工日 2 总工作量 3 总人工费
function reCalculate2(){
	
	var grde = $("#grde").val();
	var rgdj = $("#rgdj").val();

	if( grde == "" || rgdj == "" ) {
		return;
	}
	
	if(isNaN(grde) || isNaN(rgdj)) {
		return;
	}
	
	var trs = $("#rytable").find("tr");
	var grTotal = 0;
	var zyslTotal = 0;
	var rgfTotal = 0;
	$.each(trs,function(i,d){
		var wcgcl = $(d).find(".rygclCls").val();
		if( wcgcl != "" && (!isNaN(wcgcl))) {
			var rygr = parseFloat(wcgcl)*parseFloat(grde);
			grTotal += rygr;
			zyslTotal += parseFloat(wcgcl);
			/*rgfTotal += rygr*parseFloat(rgdj);*/
			$(d).find(".rygrCls").val(rygr);
		}
	});
	
	$("#zysl").val(zyslTotal.toFixed(doubleFixed));
	$("#zgr").val(grTotal.toFixed(doubleFixed));
	/*$("#rgf").val(parseFloat(rgfTotal).toFixed(moneyFixed));*/
	$("#rgf").val((grTotal*rgdj).toFixed(moneyFixed));
	
	
	
	// 计算计划消耗材料费
	var trEs = $("#jhclxhTable").find(".data-row");
	var clfTotal = 0;
	var i = 0; 
	for( i ; i < trEs.length ; i++ ) {
		var dj = $(trEs[i]).find(".gljdj").val();
		var sl = $(trEs[i]).find(".gljsl").attr("desl");
		sl = sl*parseFloat(zyslTotal);
		$(trEs[i]).find(".gljsl").val(sl.toFixed(doubleFixed));
		clfTotal += parseFloat(dj) * parseFloat(sl);
	}
	$("#clfTotal").val((parseFloat(clfTotal)).toFixed(moneyFixed(2)));
	// 计算计划消耗机械费
	var trEs = $("#jhjxxhTable").find(".data-row");
	var jxfTotal = 0;
	var i = 0; 
	for( i ; i < trEs.length ; i++ ) {
		var dj = $(trEs[i]).find(".gljdj").val();
		var sl = $(trEs[i]).find(".gljsl").attr("desl");
		sl = sl*parseFloat(zyslTotal);
		$(trEs[i]).find(".gljsl").val(sl);
		jxfTotal += parseFloat(dj) * parseFloat(sl);
	}
	$("#jxfTotal").val(parseFloat(jxfTotal).toFixed(moneyFixed));
	
}

/**
 * 派工数量 焦点失去 事件
 * @param obj
 */
function pgslBlur(obj){
	var srsl = $(obj).val();
	if(srsl == "" ) return;
	if(isNaN(srsl)) return;
	if(srsl < 0 ) return;
	
	var dejs = $("#dejs").val();
	
	if(isNaN(dejs))return;
	if(dejs == "") return;
	if(dejs < 0 ) return;
	
	$("#srsl").val(srsl);
	$(obj).val((parseFloat(srsl) / parseFloat(dejs)).toFixed(doubleFixed));
	$("#xsz").val((parseFloat(srsl) / parseFloat(dejs)).toFixed(doubleFixed));
	reCalculate1(obj);
}
/**
 * 派工数量 获得焦点事件
 * @param obj
 */
function pgslFocus(obj){
	//var xsz = $("#xsz").val();
	var xsz = $(obj).val();
	var dejs = $("#dejs").val();
	if(isNaN(dejs))return;
	if(dejs == "") return;
	if(dejs < 0 ) return;
	if(isNaN(xsz) || isNaN(dejs) || xsz == "" || dejs == "") {
		return;
	}else{
		$(obj).val(( parseFloat(xsz) * parseFloat(dejs)).toFixed(doubleFixed));
	}
}

//计划 材料 数量 blur
function gljslblur(obj,id){
	if(!validation.checkInt(obj)){
		$.messager.alert("警告","请输入有效的数值","warning");
		return;
	}
	var tableE = $(obj).parentsUntil(".mytable");
	var trEs = tableE.find("tr");
	var total = 0;
	var i = 1; 
	for( i ; i < trEs.length ; i++ ) {
		var dj = $(trEs[i]).find(".gljdj").val();
		var sl = $(trEs[i]).find(".gljsl").val();
		total += parseFloat(dj) * parseFloat(sl);
	}
	if( id.indexOf("002") == 0 ) { // 材料
		$("#clfTotal").val(parseFloat(total).toFixed(moneyFixed));
	}
	
	if( id.indexOf("003") == 0 ) { // 机械
		$("#jxfTotal").val(parseFloat(total),toFixed(moneyFixed));
	}
}


/**
 * 验收 需要 计算的 状态
 */
function ysCalculate(obj){
	pgslBlur(obj);
	var cjsl = $("#cjsl").val(); // 抽检数量
	var yssl = $("#yssl").val(); // 验收数量
	var hgsl = $("#hgsl").val(); // 合格数量
	var sbsl = $("#sbsl").val(); // 上报数量
	var sbgr = $("#sbgr").val(); // 上报工日
	
	if( cjsl == "" || yssl == "" || hgsl == "" || sbsl == "" || sbgr == "") return;
	if( isNaN(cjsl) || isNaN(yssl) || isNaN(hgsl) ) {
		$.messager.alert("警告","请输入有效数字","warning");
		return;
	}
	
	if(parseFloat(hgsl) > parseFloat(yssl)){
		$.messager.alert("警告","合格数量要小于验收数量","warning");
		return;
	}
	
	if(parseFloat(cjsl) > parseFloat(sbsl)){
		$.messager.alert("警告","抽检数量要小于上报数量","warning");
		return;
	}
	
	var slfhl = yssl / cjsl; 
	var zlfhl = hgsl / yssl;
	var yssbsl = sbsl * ( hgsl / cjsl );
	var yssbgr = sbgr * ( hgsl / cjsl );
	
	if( zlfhl >= 95 && slfhl >= 95 ) {
		slfhl = 1;
		zlfhl = 1;
		yssbsl = sbsl;
		yssbgr = sbgr;
	} 
	
	$("#slfhl").val(parseFloat(slfhl).toFixed(doubleFixed)); //数量符合率
	$("#zlhgl").val( parseFloat(zlfhl).toFixed(doubleFixed)); // 质量合格率
	$("#yxsl").val(parseFloat(yssbsl).toFixed(doubleFixed)); // 有效数量
	$("#yxgr").val(parseFloat(yssbgr).toFixed(doubleFixed)); // 有效工日

	if( slfhl < 0.85 || zlfhl < 0.85 ) { // 打回返工返工
		$("#zyyszt").val(2);
		$("#bufenYs").val("false");
		$(".doYs").hide(); $(".doYs1").show();
	} else if( (zlfhl >= 0.85 && zlfhl < 0.95) || (slfhl >= 0.85 && slfhl < 0.95 )) { // 部分验收
		$("#bufenYs").val("true");
		$("#zyyszt").val(1);
		$(".doYs").hide(); $(".doYs2").show();
	} else {  // 全部验收
		$("#bufenYs").val("false");
		$("#zyyszt").val(1);
		$(".doYs").hide(); $(".doYs3").show();
	}
}

