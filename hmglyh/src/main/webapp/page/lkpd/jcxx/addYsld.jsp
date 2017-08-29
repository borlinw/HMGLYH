<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加原始路段</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="./js/addYsld.js"></script>
</head>
<body>
<div data-options="region:'center',border:false" style="padding-top:10px;">
<form id="myForm">
	<table class="tableform2" border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
	
		<tr><td style="text-align:right">路线：</td>
		<td class="left">&nbsp;<input type="text" id="lxname" name="lxname" readonly="readonly" style="border:0px; width:170px"/></td>	
			 				   <input type="hidden" id="roadcode" name="roadcode"/>
		</tr>
		</tr>
		<tr><td style="text-align:right">起点桩号：</td>
		<td class="left">&nbsp;<input type="text" id="roadstart" name="roadstart"class="easyui-numberbox" data-options="precision:3" style="width:80px"></td>
		</tr>
		<tr><td style="text-align:right">止点桩号：</td>
		<td class="left">&nbsp;<input type="text" id="roadends" name="roadends" class="easyui-numberbox" data-options="precision:3" style="width:80px"></td>
		</tr>
		<tr><td style="text-align:right">技术等级：</td>
		<td class="left">&nbsp;<select id="jsdj" name="jsdj" panelHeight="auto" style="width:90px">
									<option value="高速">高速</option>   
								    <option value="一级">一级</option>   
								    <option value="二级">二级</option>   
								    <option value="三级">三级</option>   
								    <option value="四级">四级</option>   
							   </select></td>
		</tr>
		<tr><td style="text-align:right">路面类型：</td>
		<td class="left">&nbsp;<select id="lmlx" name="lmlx" panelHeight="auto" style="width:90px">
									<option value="沥青混凝土">沥青混凝土</option>   
								    <option value="水泥路面">水泥路面</option>   
								    <option value="砂石路面">砂石路面</option>   
							   </select></td>
		</tr>
		<tr><td style="text-align:right">宽度：</td>
		<td class="left">&nbsp;<input type="text" id="lmkd" name="lmkd" class="easyui-numberbox" data-options="precision:3" style="width:50px">m</td>
		</tr>
		<tr><td style="text-align:right"><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="btnSave">保存</a></td></tr>
	</table>
</form>
</div>
</body>
</html>