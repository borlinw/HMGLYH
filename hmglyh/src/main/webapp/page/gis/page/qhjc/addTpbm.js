
var initUpload = function(){
	$('input[name=upload]').each(function(i){
		$('#upload'+i).uploadify({
	        'swf'      : YMLib.url + '/js/uploadify/uploadify.swf',    //指定上传控件的主体文件
	        'uploader' : YMLib.url+'card/uploadTp.do',    //指定服务器端上传处理文件
//	        'formData' : params,
	        'auto' : true,
	        'hideButton' : true,
	        'fileObjName'  : 'Upload',
	        'buttonText' : "上传",
//	        'progressData' : "percentage",
//	        'removeCompleted' : true,
	        'height' : 20,
	        'width' : 60,
	        'fileTypeExts' : '*.png;*.jgp;*.gif;*.jpeg;*.bmp',
	        'fileSizeLimit':'50000000',
	        'onUploadSuccess':function(file, _data, response){
	        	YMLib.UI.Show("上传成功",2000);
	        	var data = eval("("+_data+")");
	        	//给附件地址与名称赋值
	        	$("#cfdz"+i).val(data.wz);
	        	$("#fjmc"+i).val(data.name);
	        	
	         },
	         'onUploadError' : function(){
	        	 YMLib.UI.Show("上传失败",2000);
	         },
	         'onInit': function () {            
	        	 $("#upload"+i+"-queue").hide();
	         }
	    });
	});
};

var Download = function(_index){
	if($("#cfdz"+_index).val()){
		filePath = $("#cfdz"+_index).val();
		fileName = $("#fjmc"+_index).val();
		location.href = YMLib.url+"download/down.do?filePath="+encodeURIComponent(filePath)+"&fileName="+encodeURIComponent(fileName);
	}else{
		YMLib.UI.Show("还未上传图片",2000);
	}
};


$(function(){
	initUpload();
	$("#cancle").click(function(){
		location.href = YMLib.url + 'page/gis/page/qhjc/qldqjc.jsp?qlcode='+getQuery("qlcode");
	});
	
	$("#add").click(function(){
		var param = $("#myForm").serialize()+"&qldqjcid="+getQuery("qldqjcid");
		console.info(param);
		
		YMLib.Ajax.POST("qhjc/addTpbm.do",param,"json",function(result){
			if(result){
				YMLib.UI.Show("添加成功",2000);
			}else{
				YMLib.UI.Show("添加失败",2000);
			}
		},function(){
			YMLib.UI.Show("添加失败",2000);
		});
	});
	
	
});