<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>构造物卡片</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/uploadify/uploadify2.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/gis/js/tools.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/page/gis/page/addLswxjl.js"></script>
<style type="text/css">
	table td input{
		width:200px;
	}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:true,split:true" style="height:25px;border-left:0px;border-right:0px;border-top:0px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="ok">确定</a>&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="cancle">取消</a>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<form id="myForm">
			<table width="100%" cellpadding="1" cellspacing="0" border="1">
				<tr><td width="20%">线路</td><td width="80%"><input type="text" name="roadcode" value="${lswxjl.roadcode }" readonly/>
					<input type="hidden" name="id" value="${lswxjl.id }"/>
					<input type="hidden" name="lx" value="${lswxjl.lx }"/>
				</td></tr>
				<tr><td>桩号</td><td><input type="text" name="zh" value="${lswxjl.zh }" 
					<c:if test="${lswxjl.lx == 'ql'||lswxjl.lx == 'hd' }">
						readonly
					</c:if>
				/></td></tr>
				<c:if test="${lswxjl.lx == 'ql' }">
					<tr>
						<td>桥梁名称</td>
						<td>
							<input type="text" name="qlname" value="${lswxjl.qlname }" readonly/>
							<input type="hidden" name="qlcode" value="${lswxjl.qlcode }" readonly/>
						</td>
					</tr>
				</c:if>
				<c:if test="${lswxjl.lx == 'hd' }">
					<tr>
						<td>涵洞编码</td>
						<td>
							<input type="text" name="hdcode" value="${lswxjl.hdcode }" readonly/>
						</td>
					</tr>
				</c:if>
				<tr>
					<td>维修类型</td>
					<td>
						<select id="wxlx" name="wxlx" class="easyui-combobox" data-options="value:'${lswxjl.wxlx }'">
							<option value="日常养护">日常养护</option>
							<option value="桥梁预防性养护">桥梁预防性养护</option>
							<option value="危小桥涵改造">危小桥涵改造</option>
							<option value="危桥改造">危桥改造</option>
						</select>
					</td>
				</tr>
				<tr><td>维修部位</td><td>
					<input type="text" name="wxbw" value="${lswxjl.wxbw }"/>
				</td></tr>
				<tr><td>开工时间</td><td>
					<input type="text"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="kgsj" value="<fmt:formatDate value='${lswxjl.kgsj }' pattern='yyyy-MM-dd'/>"/>
				</td></tr>
				<tr><td>完工时间</td><td>
					<input type="text"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" name="wgsj" value="<fmt:formatDate value='${lswxjl.wgsj }' pattern='yyyy-MM-dd'/>"/>
				</td></tr>
				<tr><td>使用材料</td><td>
					<textarea name="sycl">${lswxjl.sycl }</textarea>
				</td></tr>
				<tr><td>维修工程量</td><td>
					<textarea name="wxgcl">${lswxjl.wxgcl }</textarea>
				</td></tr>
				<tr><td>维修金额</td><td>
					<input type="text" name="wxje" value="${lswxjl.wxje }" class="easyui-validatebox" data-options="validType:'numberDouble'"/>
				</td></tr>
				<tr><td>影像资料</td><td>
					<input type="file" id="upload1" name="upload"/>
					<table id="attachmentTable1">
						<c:forEach var="a" items="${lswxjl.yxzl }">
							<tr>
								<td>
									<a href="javascript:void(0)" onclick="Download('${a.name}','${a.wz }')">${a.name }</a>
									<input type="hidden" name="name" value="${a.name }"/><input type="hidden" name="wz" value="${a.wz }"/>
								</td>
								<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onClick="Delete(this)">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</td></tr>
				<tr><td>后评估情况</td><td>
					<input type="file" id="upload2" name="upload"/>
					<table id="attachmentTable2">
						<c:forEach var="a" items="${lswxjl.hpgqk }">
							<tr>
								<td>
									<a href="javascript:void(0)" onclick="Download('${a.name}','${a.wz }')">${a.name }</a>
									<input type="hidden" name="name" value="${a.name }"/><input type="hidden" name="wz" value="${a.wz }"/>
								</td>
								<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onClick="Delete(this)">删除</a></td>
							</tr>
						</c:forEach>
					</table>
				</td></tr>
			</table>
		</form>	
    </div>
</body>
</html>







