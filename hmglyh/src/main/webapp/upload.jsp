<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.hdsx.hmglyh.util.MD5Util"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
      <head>
        <base href="<%=basePath%>">
        <title>Uploadify</title>
      <!--   <link href="css/default.css" rel="stylesheet" type="text/css" /> -->
        <link href="css/uploadify.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/jquery.uploadify.min.js"></script>
        <script type="text/javascript">
        $(function() {
			$('#file_upload').uploadify({
				'formData'     : {
					'timestamp' : '<%=new Date().getTime()%>',
					'token'     : '<%=MD5Util.MD5(new Date().getTime()+"")%>'
				},
				'width':100,
				'height':50,
				'buttonText' : '选择上传图片',
				'fileTypeDesc':'请选择 jgp,jpeg,gif,png 格式的图片', // 貌似不好用
				'debug':false,
				'swf'      : 'uploadify.swf',
				'uploader' : '/hmglyh/up1',
				'fileSizeLimit':'10000mb',
				//'fileTypeExts':'*.jpeg;*.jpg; *.png;*.gif',
				'onUploadSuccess':function(file,data){
					console.log(data);
					alert("上传成功");
				}
			});
		});
        </script>
    </head>
    <body>
   	<h1>Uploadify Demo</h1>
	<form>
		<div id="queue"></div>
		<input id="file_upload" name="file_upload" type="file" multiple="true">
	</form>
    </body>
</html>