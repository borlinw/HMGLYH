var kpid = -1;

var initUpload = function(params){
//	alert(params);
	$('#upload').uploadify({
        'swf'      : YMLib.url + '/js/uploadify/uploadify.swf',    //指定上传控件的主体文件
        'uploader' : YMLib.url+'card/upload.do',    //指定服务器端上传处理文件
        'formData' : params,
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
//        	alert(data+"==="+data.filename+"=="+data.html);
        	$("#showHtml").html(data.html);
        	var list = data.wjdz.split('.');
        	var ex = list[list.length-1];
        	$("#download").html("<a href='"+(YMLib.url+"download/down.do?filePath="+encodeURIComponent(data.wjdz)+"&fileName="+encodeURIComponent("卡片."+ex))+"'>下载卡片</a>");
         },
         'onUploadError' : function(){
        	 YMLib.UI.Show("上传失败",2000);
         }
    });
};

$(function(){
	YMLib.UI.MaskShow("初始化中，请稍后。。。");
//	alert(encodeURIComponent(getQuery("dyid")));
	YMLib.Ajax.POST("card/select.do","kplx="+getQuery("kplx")+"&dyid="+encodeURIComponent(getQuery("dyid")),"json",function(result){
		YMLib.UI.MaskHide();
		if(result.kpid != 0){
			kpid = result.kpid;
			$("#showHtml").html(result.html);
			var list = result.wjdz.split('.');
        	var ex = list[list.length-1];
			$("#download").html("<a href='"+(YMLib.url+"download/down.do?filePath="+encodeURIComponent(result.wjdz)+"&fileName="+encodeURIComponent("卡片."+ex))+"'>下载卡片</a>");
		}
//		var params = "'kplx':"+getQuery("kplx")+",'dyid':'"+encodeURIComponent(getQuery("dyid"))+"','kpid':"+kpid+",'userName':'"+result.userName+"'}";
		var params = {};
		params.kplx = getQuery("kplx");
		params.dyid = getQuery("dyid");
		params.kpid = kpid;
		params.userName = result.userName;
		
//		alert(params);
		initUpload(params);
	},function(){
		YMLib.UI.MaskHide();
		YMLib.UI.Show("查询出错",2000);
//		var params2 = "{'kplx':"+getQuery("kplx")+",'dyid':'"+encodeURIComponent(getQuery("dyid"))+"','kpid':-1,'userName':'admin'}";
		var params2 = {};
		params2.kplx = getQuery("kplx");
		params2.dyid = getQuery("dyid");
		params2.kpid = -1;
		params2.userName = 'admin';
		
//		alert(params2);
		initUpload(params2);
	});
	
	
	
});









