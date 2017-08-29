<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<tr><td>维修类型</td><td>
					<c:if test="${lswxjl.lx == 'lm' }">
						<select name="wxlx">
							<option value="路面">路面</option>
							<option value="沿线设施">沿线设施</option>
						</select>
					</c:if>
					<c:if test="${lswxjl.lx == 'gzw'}">
						<input type="text" name="wxlx" value="${lswxjl.wxlx }" readonly/> 
					</c:if>
				</td></tr>
				<tr><td>线路</td><td><input type="text" name="roadcode" value="${lswxjl.roadcode }" readonly/><input type="hidden" name="id" value="${lswxjl.id }"/></td></tr>
				<tr><td>桩号</td><td><input type="text" name="qzzh" value="${lswxjl.qzzh }" 
					<c:if test="${lswxjl.lx == 'gzw' }">
						readonly
					</c:if>
				/></td></tr>
				<tr><td>年份</td><td><input type="text" name="nf" value="${lswxjl.nf }"/></td></tr>
				<tr><td>工程名称</td><td>
					<textarea name="gcmc">${lswxjl.gcmc }</textarea>
				</td></tr>
				<tr><td>工程概况及方案</td><td>
					<textarea name="gkjfa">${lswxjl.gkjfa }</textarea>
				</td></tr>
				<tr><td>项目实施方案-实施前</td><td>
					<textarea name="ssq">${lswxjl.ssq }</textarea>
				</td></tr>
				<tr><td>项目实施方案-实施后</td><td>
					<textarea name="ssh">${lswxjl.ssh }</textarea>
				</td></tr>
				<tr><td>合同开工完工日期</td><td>
					<textarea name="htrq">${lswxjl.htrq }</textarea>
				</td></tr>
				<tr><td>实际开工完工日期</td><td>
					<textarea name="sjrq">${lswxjl.sjrq }</textarea>
				</td></tr>
				<tr><td>建设单位</td><td>
					<input type="text" name="jsdw" value="${lswxjl.jsdw }"/>
				</td></tr>
				<tr><td>项目执行机构</td><td>
					<input type="text" name="xmzxjg" value="${lswxjl.xmzxjg }"/>
				</td></tr>
				<tr><td>招标代理单位</td><td>
					<input type="text" name="zbdldw" value="${lswxjl.zbdldw }"/>
				</td></tr>
				<tr><td>勘察设计单位</td><td>
					<input type="text" name="kcsjdw" value="${lswxjl.kcsjdw }"/>
				</td></tr>
				<tr><td>监理单位</td><td>
					<input type="text" name="jldw" value="${lswxjl.jldw }"/>
				</td></tr>
				<tr><td>施工单位</td><td>
					<input type="text" name="sgdw" value="${lswxjl.sgdw }"/>
				</td></tr>
				<tr><td>第三方检测单位</td><td>
					<input type="text" name="dsfjcdw" value="${lswxjl.dsfjcdw }"/>
				</td></tr>
				<tr><td>审计单位</td><td>
					<input type="text" name="sjdw" value="${lswxjl.sjdw }"/>
				</td></tr>
				<tr><td>批复文号</td><td>
					<input type="text" name="wh" value="${lswxjl.wh }"/>
				</td></tr>
				<tr><td>批复文件</td><td>
					<input type="file" id="upload" name="upload"/>
					<table id="attachmentTable">
						<c:forEach var="a" items="${lswxjl.attachment }">
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
				<tr><td>决算金额</td><td>
					<input type="text" name="jsje" value="${lswxjl.jsje }"/>
				</td></tr>
				<tr><td>备注</td><td>
					<textarea name="bz">${lswxjl.bz }</textarea>
				</td></tr>
			</table>
		</form>	
    </div>
</body>
</html>







