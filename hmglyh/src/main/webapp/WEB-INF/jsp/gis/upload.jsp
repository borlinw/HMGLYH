<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.hdsx.hmglyh.util.MD5Util"%>
<%@ include file="../rcyh/public/head.jsp"%>
 <link href="${pageContext.request.contextPath}/css/uploadify.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.uploadify.min.js"></script>
</head>
<body>
		
		<form>
			<input id="file_upload" name="file_upload" type="file" multiple="true">
		</form>
		
		<div>
			<table>
				<s:if test="m!= null ">
				<img src="<s:property value="m.picUrl"/>/<s:property value="m.zpdz"/>" width="90%" alt="" />
				</s:if>
				<s:else>
					<h5 id="zw">暂无图片</h5>
				</s:else>
			</table>
		</div>
	
	<script>
	  $(function() {
			$('#file_upload').uploadify({
				'formData'     : {
					'timestamp' : '<%=new Date().getTime()%>',
					'token'     : '<%=MD5Util.MD5(new Date().getTime()+"")%>'
				},
				'width':100,
				'height':20,
				'buttonText' : '选择上传图片',
				'fileTypeDesc':'请选择 jgp,jpeg,gif,png 格式的图片', // 貌似不好用
				'debug':false,
				'swf'      : '${pageContext.request.contextPath}/uploadify.swf',
				'uploader' : '${pageContext.request.contextPath}/up1?code=<s:property value="code" />',
				'fileSizeLimit':'1024mb',
				//'fileTypeExts':'*.jpeg;*.jpg; *.png;*.gif',
				'onUploadSuccess':function(file,strData){
					$('#zw').remove();
					var jsonData = eval("(" + strData + ")");
					//alert(jsonData.picUrl);
					//alert(jsonData.rname);
					$("img").remove();
					$("table").append("<img src='"+jsonData.picUrl+"/"+jsonData.rname+"' />");
				}
			});
		});
	</script>
</body>
</html>