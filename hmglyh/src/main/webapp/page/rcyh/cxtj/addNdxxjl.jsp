<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加年度学习记录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="./js/addNdxxjl.js"></script>
</head>
<body>
<div data-options="region:'center',border:false" style="padding-top:10px;">
<form id="myForm">
	<table class="tableform2" border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
		<tr>
		<td style="text-align:right">学习单位：</td>
		<td class="left">&nbsp;<input type="text" name="bmname" readonly="readonly" style="border:0px"/></td>
		<input  type="hidden" name="bmcode"/>
		<input type="hidden" name="jlusername"/>
		<input type="hidden" name="jldate"/>
		<input type="hidden" name="nf"/>
		</tr>
		</tr>
		<tr><td style="text-align:right">学习内容：</td>
		<td class="left">&nbsp;<textarea name="xxnr" cols="21" rows="4" class="easyui-validatebox" data-options="required:true" ></textarea></td>
		</tr>
		<tr><td style="text-align:right">人员：</td>
		<td class="left">&nbsp;<textarea name="xxry" cols="21" rows="3" class="easyui-validatebox" data-options="required:true" ></textarea></td>
		</tr>
		<tr><td style="text-align:right">学习地点：</td>
		<td class="left">&nbsp;<input type="text" name="xxdd" class="easyui-validatebox" data-options="required:true"/></td>
		</tr>
		<tr><td style="text-align:right">学习时间：</td>
		<td class="left">&nbsp;<input type="text"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'2011-01-01',maxDate:'%y-{%M+1}-%d'})" name="xxdate" id="xxsj" class="easyui-validatebox" data-options="required:true"/></td>
		</tr>
		<tr><td style="text-align:right">备注：</td>
		<td class="left">&nbsp;<textarea name="bz" cols="21" rows="4"></textarea></td>
		</tr>
	<!-- <a href="javascript:void(0)" id="btnSave"  class="easyui-linkbutton" plain="true" iconCls="save">保存</a> -->
		<!-- <td style="text-align:right"><a href="javascript:void(0)" id="btnSave" class="easyui-linkbutton" plain="true" iconCls="save">保存</a></td> -->
		<tr><td style="text-align:right"><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="btnSave">保存</a></td></tr>
		<!-- <input id="btnSave" type="button" value="保存" /> -->
	</table>
</form>
</div>
</body>
</html>