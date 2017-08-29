function delZpRow(obj,index){
  		var succ = $(obj).attr("succ");
  		var fileid = $(obj).attr("fid");
  		var zpdz = $(obj).attr("zpdz");
  		
  		var fileButton = $('#file_upload'+index);
  		var ztTd = $("#"+fileid+"-queue"+index);
  		
  		if(succ == "0" ) {  // 1  如果是正在上传 之中 现在 要 取消上传 
  			fileButton.uploadify("cancel",fileid);
  			setTimeout(function(){
			  	$(obj).parentsUntil('.datagrid-row').parent().remove();
			},1000);
  		}else if(succ == "1" ){ 	// 2  如果已经上传成功 要将 服务已经上传的图片删除
  			if( zpdz == "0" ) return;
  			$.ajax({
  				url:"/hmglyh/rcyh/bh_delPic.do",
  				dataType:"json",
  				data:{
  					"zp.zpdz":zpdz
  				},
  				success:function(data){
  					ztTd.html("<span style='color:green;'>删除成功</span>");
  					setTimeout(function(){
  				  		$(obj).parentsUntil('.datagrid-row').parent().remove();
  					},1000);
  				},
  				error:function(){
  					ztTd.html("<span style='color:red;'>删除失败</span>");
  				}
  			});
  		}
  	}	