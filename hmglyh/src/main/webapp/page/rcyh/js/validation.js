/**
 * 表单验证
 */
$(function() {
	// 绑定 金钱 校验
	$(".money").keyup(function() {
		validation.checkMoney(this);
	});
	
	//校验小数类型的数
	$(".double").keyup(function() {
		validation.checkMoney(this);
	});
	// 绑定 整数类型 校验
	$(".int").keyup(function() {
		validation.checkInt(this);
	});
	// 绑定字符类型的校验
	$(".text").keyup(function() {
		validation.checkText(this);
	});

	$("#fm").form({
		onSubmit : function() {
			if(onBeforeSubmit()) {
				
				$.messager.progress({
					title:"请稍后...",
					text:"请稍后...",
					msg:'一会就好'
				}); 
				
				return true;
			}else{
				return false;
			}
		},
		success : function(str) {
			var r = eval('(' + str + ')');
			$.messager.progress("close"); 
			if (r.isSuccess) {
				if(r.rwd){
					if(r.bufenYs) {
						$.messager.alert('成功', r.info, 'ok', function() {
							parent.gisui.destroyAllWindows();
						});
					}else if(r.fromYdjh){
						$.messager.alert('成功', r.info, 'ok', function() {
							parent.gisui.destroyAllWindows();
						});
					}else{
						$.messager.confirm('请选择',r.info+',您是否要继续派工?',function(rr){
						    if(rr){
						    	
						    		var href = location.href;
						    		
						    		if(href.indexOf("pg2th") == -1){
						    			location.href = location.href+"&pg2th=true&rwd.rwbh="+r.rwbh;
						    		} else{
						    			location.reload();
						    		}
						    	
						    		
						    }else{
						    	parent.gisui.destroyAllWindows();
						    }
						});
					}
				}else if(r.bufenYs){
					$.messager.alert("继续派工",r.info,"继续派工",function(){
						$("#fm").attr("action","/hmglyh/rcyh/bhflow_addBfysRwd.do?bufenYs=true");
					//	$("#fm").submit();
						document.getElementById("fm").submit();
					});
				}else if(r.doNothing){
					$.messager.confirm('请选择',r.info+',您是否要继续?',function(rr){
					    if(rr){
					    }else{
					    	parent.gisui.destroyAllWindows();
					    }
					});
				}else{
					$.messager.alert('成功', r.info, 'ok', function() {
						// 返回之后继续的操作
						if(r.back) {
							history.back();
						}else if(r.doNothing){
							
						}else{
							parent.gisui.destroyAllWindows();
						}
					});
				}
			} else {
				$.messager.alert('失败', "服务器返回的消息" + r.info, 'warning');
			}
		},
		onLoadError:function(){
			$.messager.progress("close"); 
			$.messager.alert('失败', "服务器似乎除了问题" + r.info, 'warning');
		}
	});
});

var onBeforeSubmit = function() {
	var isContinue = true;
	// 非空
	$(".notnull").each(
			function(i, d) {
				if (isContinue && !validation.checkNull(d)) {
					isContinue = false;
					$.messager.alert("错误", $(d).attr("errorInfo"), "warning",
							function() {
								$(d).focus();
							});
					return false;
				}
			});
	$(".money").each(
			function(i, d) {
				if (isContinue && !validation.checkMoney(d)) {
					isContinue = false;
					$.messager.alert("错误", $(d).attr("errorInfo"), "warning",
							function() {
								$(d).focus();
							});
					return false;
				}
			});

	$(".double").each(
			function(i, d) {
				if (isContinue && !validation.checkDouble(d)) {
					isContinue = false;
					$.messager.alert("错误", $(d).attr("errorInfo"), "warning",
							function() {
								$(d).focus();
							});
					return false;
				}
			});
	
	$(".int").each(
			function(i, d) {
				if (isContinue && !validation.checkInt(d)) {
					isContinue = false;
					$.messager.alert("错误", $(d).attr("errorInfo"), "warning",
							function() {
								$(d).focus();
							});
					return false;
				}
			});
	$(".text").each(
			function(i, d) {
				if (isContinue && !validation.checkText(d)) {
					isContinue = false;
					$.messager.alert("错误", $(d).attr("errorInfo"), "warning",
							function() {
								$(d).focus();
							});
					return false;
				}
			});
	return isContinue;
};

var validation = {
	checkMoney : function(obj) { // 检查金钱类型
		
		if($(obj).val() == "" || $(obj).val() == null ) { //空值放行
			return true;
		}
		
		
		if($(obj).attr("disabled") == "disabled") {
			return true;
		}
		
		var maxValue = 99999999.99; //数据库能保存的钱最大值
		if (/^[0-9]+([.]{1}[0-9]{1,2})?$/.test($(obj).val())) {
			if (0 <= parseFloat($(obj).val())
					&& parseFloat($(obj).val()) <= maxValue) {
				$(obj).css("color", "#000");
				return true;
			} else {
				$(obj).css("color", "#f00");
				return false;
			}
		} else {
			$(obj).css("color", "red");
			return false;
		}
	},
	
	checkDouble : function(obj) { // 检查小数
		
		if($(obj).val() == "" || $(obj).val() == null ) { //空值放行
			return true;
		}
		
		
		if($(obj).attr("disabled") == "disabled") {
			return true;
		}
		
		var maxValue = 100000; //数据库能保存的钱最大值
		if (/^[0-9]+([.]{1}[0-9]{1,3})?$/.test($(obj).val())) {
			if (0 <= parseFloat($(obj).val())
					&& parseFloat($(obj).val()) <= maxValue) {
				$(obj).css("color", "#000");
				return true;
			} else {
				$(obj).css("color", "#f00");
				return false;
			}
		} else {
			$(obj).css("color", "red");
			return false;
		}
	},
	
	/*checkInt : function(obj) { // 检查整数类型
		
		if($(obj).val() == "" || $(obj).val() == null ) { //空值放行
			return true;
		}
		
		if($(obj).attr("disabled") == "disabled") {
			return true;
		}
		
		var maxValue = 100000;
		var min = $(obj).attr("min");
		if (min == "" || min == null || min == undefined)
			min = 0;
		if (isNaN($(obj).val())) {
			$(obj).css("color", "red");
			return false;
		} else {
			if (/^\d+$/.test($(obj).val())) {
				if (min <= parseFloat($(obj).val())
						&& parseFloat($(obj).val()) <= maxValue) {
					$(obj).css("color", "#000");
					return true;
				} else {
					$(obj).css("color", "red");
					return false;
				}
			} else {
				$(obj).css("color", "red");
				return false;
			}
		}
	},*/
	checkInt:function(obj){
		if($(obj).val() == "" || $(obj).val() == null ) { //空值放行
			return true;
		}
		
		
		if($(obj).attr("disabled") == "disabled") {
			return true;
		}
		
		var maxValue = 10000000; //数据库能保存的钱最大值
		if (!isNaN($(obj).val())) {
			if (0 <= parseFloat($(obj).val())
					&& parseFloat($(obj).val()) < maxValue) {
				$(obj).css("color", "#000");
				return true;
			} else {
				$(obj).css("color", "#f00");
				return false;
			}
		} else {
			$(obj).css("color", "red");
			return false;
		}
	},
	checkText : function(obj) { // 检查字符类型
		
		if($(obj).val() == "" || $(obj).val() == null ) { //空值放行
			return true;
		}
		
		
		if($(obj).attr("disabled") == "disabled") {
			return true;
		}
		
		if ($(obj).val().length >= 200) {
			$(obj).css("color", "red");
			return false;
		} else {
			$(obj).css("color", "#000");
			return true;
		}
	},
	checkNull : function(obj) { // 检查非空类型
		
		if($(obj).attr("disabled") == "disabled") {
			return true;
		}
			
		// easyui 的类型
		if ($(obj).attr("class").indexOf("easyui-combobox") != -1) {
			var v = $(obj).combobox("getValue");
			if (v == "" || v == null) {
				return false;
			} else {
				return true;
			}
		}

		if ($(obj).attr("class").indexOf("easyui-combotree") != -1) {
			var v = $(obj).combotree("getValue");
			if (v == "" || v == null) {
				return false;
			} else {
				return true;
			}
		}

		if ($(obj).val() == "" || $(obj).val() == null) {
			return false;
		} else {
			return true;
		}
	}
};
