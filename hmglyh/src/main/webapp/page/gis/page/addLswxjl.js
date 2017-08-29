
var Download = function(_name,_wz){
	location.href = YMLib.url+"download/down.do?filePath="+encodeURIComponent(_wz)+"&fileName="+encodeURIComponent(_name);
};

var Delete = function(_obj){
	$(_obj).parent().parent().remove();
};

var initUpload = function(){
//	alert(params);
	$('#upload').uploadify({
        'swf'      : YMLib.url + '/js/uploadify/uploadify.swf',    //指定上传控件的主体文件
        'uploader' : YMLib.url+'card/uploadFile.do',    //指定服务器端上传处理文件
        'auto' : true,
        'hideButton' : true,
        'fileObjName'  : 'Upload',
        'buttonText' : "上传卡片",
        'progressData' : "percentage",
        'removeCompleted' : true,
        'height' : 30,
        'width' : 60,
        'fileTypeExts' : '*.xls;*.doc',
        'fileSizeLimit':'50000000',
        'onUploadSuccess':function(file, _data, response){
        	var data = eval("("+_data+")");
        	var html = "<tr><td><a href='javascript:void(0)' onclick='Download('"+data.name+"','"+data.wz+"')'>"+data.name+"</a>"+
					"<input type='hidden' name='name' value='"+data.name+"'/><input type='hidden' name='wz' value='"+data.wz+"'/></td>" +
					"<td><a href='javascript:void(0)' class='easyui-linkbutton' plain='true' onClick='Delete(this)'>删除</a></td></tr>";
        	
        	$("#attachmentTable").append(html);
         },
         'onUploadError' : function(){
        	 YMLib.UI.Show("上传失败",2000);
         }
    });
};


var initButton = function(){
	$("#ok").click(function(){
		var param = $("#myForm").serialize();
		
		YMLib.Ajax.POST("lswxjl/add.do",param,"json",function(result){
			if(result){
				var params = "lx="+getQuery("lx")+"&roadcode="+getQuery("roadcode")+"&wxlx="+getQueryByName("wxlx")+"&qzzh="+getQuery("qzzh");
				location.href = YMLib.url + "page/gis/page/lswxjl.jsp?"+params;
			}else{
				YMLib.UI.Show("添加失败",2000);
			}
		},function(){
			YMLib.UI.Show("添加失败",2000);
		});
	});
	$("#cancle").click(function(){
		var params = "lx="+getQuery("lx")+"&roadcode="+getQuery("roadcode")+"&wxlx="+getQueryByName("wxlx")+"&qzzh="+getQuery("qzzh");
		location.href = YMLib.url + "page/gis/page/lswxjl.jsp?"+params;
	});
};


$(function(){
	initUpload();
	initButton();
});





