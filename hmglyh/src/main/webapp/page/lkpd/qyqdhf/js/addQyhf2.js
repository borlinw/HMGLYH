
var state = [false,false,false,false,false,false];

var title = ['zrqh','glgn','jtl','jtzc','cyqk','qt'];

var initCombo = function(){
	$("#dj").combobox({
		onSelect : function(){
			$("#zrqh_dj").val($("#dj").combobox("getValue"));
		}
	});
};

var initPage = function(){
	$("input[id$='_end']").numberbox({
		min : parent.szhh+0.001,
		max : parent.ezhh,
		precision : 3,
		value : parent.ezhh
	});
	$("span[id$='_start']").html(parent.szhh);
};

var initHf = function(_id,_index){
	$("#"+_id+"_hf").click(function(){
		if(!state[_index]){
			if(!$("#"+_id+"_dj").val()){
				YMLib.UI.Show("请填写影响因素",2000);
				return;
			}
			
			var value = $("#"+_id+"_start").html() + "-" + $("#"+_id+"_end").numberbox("getValue") + "-" + _id + "-" + $("#"+_id+"_dj").val();
			var end = $("#"+_id+"_end").numberbox("getValue");
			var html = "<tr><td>K"+$("#"+_id+"_start").html()+"-K"+$("#"+_id+"_end").numberbox("getValue")+"</td>" +
					"<td>"+$("#"+_id+"_dj").val()+"<input type='hidden' name='detail' value='"+value+"'/></td>" + 
					"<td><a class='easyui-linkbutton' onClick=Delete('"+_id+"',"+_index+","+$("#"+_id+"_start").html()+",this)>删除</a></td></tr>";
			$("#"+_id+"_table").append(html);
			
			$("#"+_id+"_start").html(end);
			if(end == parent.ezhh){
				state[_index] = true;
			}else{
				$("#"+_id+"_end").numberbox({
					min : end+0.001,
					max : parent.ezhh,
					precision : 3,
					value : parent.ezhh
				});
			}
		}else{
			YMLib.UI.Show("已经划分完成，不需划分",2000);
		}
	});
};

var Delete = function(_id,_index,_start,obj){
	$(obj).parent().parent().next().remove();
	$(obj).parent().parent().remove();
	state[_index] = false;
	
	$("#"+_id+"_end").numberbox({
		min : _start+0.001,
		max : parent.ezhh,
		precision : 3,
		value : parent.ezhh
	});
	$("#"+_id+"_start").html(_start);
};

var loadData = function(_data){
	for(var i=0;i<_data.length;i++){
		var data = _data[i];
		var value = data.szhh + "-" + data.ezhh + "-" + data.yxys + "-" + data.dj;
		var html = "<tr><td>K"+data.szhh+"-K"+data.ezhh+"</td>" +
		"<td>"+data.dj+"<input type='hidden' name='detail' value='"+value+"'/></td>" + 
		"<td><a class='easyui-linkbutton' onClick=Delete('"+data.yxys+"',"+getIndex(data.yxys)+","+data.szhh+",this)>删除</a></td></tr>";
		$("#"+data.yxys+"_table").append(html);
		$("#"+data.yxys+"_start").html(data.ezhh);
	}
	for(var j=0;j<state.length;j++){
		state[j] = true;
	}
};

var initButton = function(){
	$("#save").click(function(){
		if(!state[0]){
			YMLib.UI.Show("自然区划因素区域划分不完全",2000);
		}else if(!state[1]){
			YMLib.UI.Show("公路功能因素区域划分不完全",2000);
		}else if(!state[2]){
			YMLib.UI.Show("交通量因素区域划分不完全",2000);
		}else if(!state[3]){
			YMLib.UI.Show("交通组成因素区域划分不完全",2000);
		}else if(!state[4]){
			YMLib.UI.Show("穿越情况因素区域划分不完全",2000);
		}else if(!state[5]){
			YMLib.UI.Show("其他因素区域划分不完全",2000);
		}else{
			var params = $("#myForm").serialize()+"&lxCode="+parent.lxCode+"&bmCode="+window.top.loginUserObject.bmcode
			+"&bbid="+parent.$("#bbid").combobox("getValue")+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh;
			YMLib.UI.MaskShow();
			YMLib.Ajax.POST("qyhfb/addQyhfbDetail.do",params,"json",function(result){
				YMLib.UI.MaskHide();
				if(result){
					YMLib.UI.Show("区域划分成功",2000);
					parent.$("#myGrid").datagrid("reload");
					parent.$("#qyhfWindow").window("close");
				}else
					YMLib.UI.Show("区域划分失败",2000);
			},function(){
				YMLib.UI.MaskHide();
				YMLib.UI.Show("区域划分失败",2000);
			});
		}
	});
	
	$("#cancle").click(function(){
		parent.$("#qyhfWindow").window("close");
	});
};

$(function(){
	var params = "lxCode="+parent.lxCode+"&bmCode="+window.top.loginUserObject.bmcode
	+"&bbid="+parent.$("#bbid").combobox("getValue")+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh;
	YMLib.UI.MaskShow();
	YMLib.Ajax.POST("qyhfb/getXxbForUpdate.do",params,"json",function(result){
		YMLib.UI.MaskHide();
		if(result != null && result.length != 0){
			loadData(result);
		}
	},function(){
		YMLib.UI.MaskHide();
	});
	
	initCombo();
	initPage();
	for(var i=0;i<title.length;i++){
		initHf(title[i],i);
	}
	initButton();
});


var getIndex = function(_value){
	for(var i=0;i<title.length;i++){
		if(title[i] == _value)
			return i;
	}
	return -1;
};











