<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图片</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/uploadify/uploadify2.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/gis/js/tools.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/gis/page/qhjc/addTpbm.js"></script>
</head>
<body>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:25px;border-left:0px;border-right:0px;border-top:0px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="add">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="cancle">返回</a>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<form id="myForm">
			<table width="90%" align="center" border="1">
				<tr>
					<td width="70">图片编码</td>
					<td width="70">图片描述</td>
					<td width="70">操作</td>
				</tr>
				<c:forEach var="tp" items="${tpList }" varStatus="status">
					<tr>
						<td><a href="javascript:void(0)" onclick="Download('${status.index}')">${tp.tpbm }</a>
							<input type="hidden"name="tpbm" value="${tp.tpbm }"/>
						</td>
						<td><input type="text" name="tpms" value='${tp.tpms }'/></td>
						<td>
							<input type="file" id="upload${status.index}" name="upload"/>
							<input type="hidden" id="cfdz${status.index}" name="cfdz" value='${tp.cfdz }'/>
							<input type="hidden" id="fjmc${status.index}" name="fjmc" value='${tp.fjmc }'/>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</body>
</html>







