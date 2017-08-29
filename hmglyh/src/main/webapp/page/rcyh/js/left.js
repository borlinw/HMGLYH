var checkedMenuid = "rcyhYhbg";//记录被点击的div的ID

$(function(){
	//养护办公
	$("#rcyhYhbg").click(function(){
		$("#rcyhYhbg").removeClass("rcyhyhbg");
		$("#rcyhYhbg").addClass("rcyhyhbg2");
		restoreMenu("rcyhYhbg");//参数为当前点击的menu的id
	});
	//月度计划
	$("#rcyhYdjh").click(function(){
		$("#rcyhYdjh").removeClass("rcyhydjh");
		$("#rcyhYdjh").addClass("rcyhydjh2");
		restoreMenu("rcyhYdjh");//参数为当前点击的menu的id
	});
	//冬季除雪
	$("#rcyhDjcx").click(function(){
		$("#rcyhDjcx").removeClass("rcyhdjcx");
		$("#rcyhDjcx").addClass("rcyhdjcx2");
		restoreMenu("rcyhDjcx");//参数为当前点击的menu的id
	});
	//查询统计
	$("#rcyhCxtj").click(function(){
		$("#rcyhCxtj").removeClass("rcyhcxtj");
		$("#rcyhCxtj").addClass("rcyhcxtj2");
		restoreMenu("rcyhCxtj");//参数为当前点击的menu的id
	});
	//维修整改
	$("#rcyhWxzg").click(function(){
		$("#rcyhWxzg").removeClass("rcyhwxzg");
		$("#rcyhWxzg").addClass("rcyhwxzg2");
		restoreMenu("rcyhWxzg");//参数为当前点击的menu的id
	});
	//考勤工资
	$("#rcyhKqzg").click(function(){
		$("#rcyhKqzg").removeClass("rcyhkqgz");
		$("#rcyhKqzg").addClass("rcyhkqgz2");
		restoreMenu("rcyhKqzg");//参数为当前点击的menu的id
	});
	//年度学习
	$("#rcyhNdxx").click(function(){
		$("#rcyhNdxx").removeClass("rcyhndxx");
		$("#rcyhNdxx").addClass("rcyhndxx2");
		restoreMenu("rcyhNdxx");//参数为当前点击的menu的id
	});
	//除雪版本
	$("#rcyhCxbb").click(function(){
		$("#rcyhCxbb").removeClass("rcyhcxbb");
		$("#rcyhCxbb").addClass("rcyhcxbb2");
		restoreMenu("rcyhCxbb");//参数为当前点击的menu的id
	});
});

//还原某被选中的menu（参数为此次被选中的id）
function restoreMenu(_menuId){
	if(checkedMenuid != "" && checkedMenuid != _menuId){
		if(checkedMenuid == "rcyhYhbg"){//养护办公
			$("#rcyhYhbg").removeClass("rcyhyhbg2");
			$("#rcyhYhbg").addClass("rcyhyhbg");
		}else if(checkedMenuid == "rcyhYdjh"){//月度计划
			$("#rcyhYdjh").removeClass("rcyhydjh2");
			$("#rcyhYdjh").addClass("rcyhydjh");
		}else if(checkedMenuid == "rcyhDjcx"){//冬季除雪
			$("#rcyhDjcx").removeClass("rcyhdjcx2");
			$("#rcyhDjcx").addClass("rcyhdjcx");
		}else if(checkedMenuid == "rcyhCxtj"){//查询统计
			$("#rcyhCxtj").removeClass("rcyhcxtj2");
			$("#rcyhCxtj").addClass("rcyhcxtj");
		}else if(checkedMenuid == "rcyhWxzg"){//维修整改
			$("#rcyhWxzg").removeClass("rcyhwxzg2");
			$("#rcyhWxzg").addClass("rcyhwxzg");
		}else if(checkedMenuid == "rcyhKqzg"){//考勤工资
			$("#rcyhKqzg").removeClass("rcyhkqgz2");
			$("#rcyhKqzg").addClass("rcyhkqgz");
		}else if(checkedMenuid == "rcyhNdxx"){//年度学习
			$("#rcyhNdxx").removeClass("rcyhndxx2");
			$("#rcyhNdxx").addClass("rcyhndxx");
		}else if(checkedMenuid == "rcyhCxbb"){//除雪版本
			$("#rcyhCxbb").removeClass("rcyhcxbb2");
			$("#rcyhCxbb").addClass("rcyhcxbb");
		}
	}
	checkedMenuid = _menuId;
}