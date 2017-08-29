<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加区域划分</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" src="./js/addQyhf2.js"></script>
<style type="text/css">
	.title{
		background-color : #66FFFF;
		height : 25px;
		text-align:left;
	}
</style>
</head>
<body class="easyui-layout">
<div data-options="region:'center'">
<form id="myForm">
	<table width="100%" cellpadding="1" cellspacing="0" border="0">
		<tr><td class="title">自然区划</td></tr>
		<tr><td><table id="zrqh_table" width="95%" align="center">
			<tr><td><span id="zrqh_start"></span>-<input id="zrqh_end" class="easyui-numberbox" style="width:55px;"/></td>
				<td><select id="dj" class="easyui-combobox">
					<option value="一级">一级</option>
					<option value="二级">二级</option>
					<option value="三级">三级</option>
				</select><input type="hidden" id="zrqh_dj" value="一级"/></td>
				<td><a class="easyui-linkbutton" id="zrqh_hf">划分</a></td>
			</tr>
		</table></td></tr>
		<tr><td class="title">公路功能</td></tr>
		<tr><td><table id="glgn_table" width="95%" align="center">
			<tr><td><span id="glgn_start"></span>-<input id="glgn_end" class="easyui-numberbox" style="width:55px;"/></td>
				<td><input type="text" id="glgn_dj"/></td>
				<td><a class="easyui-linkbutton" id="glgn_hf">划分</a></td>
			</tr>
		</table></td></tr>
		<tr><td class="title">交通量</td></tr>
		<tr><td><table id="jtl_table" width="95%" align="center">
			<tr><td><span id="jtl_start"></span>-<input id="jtl_end" class="easyui-numberbox" style="width:55px;"/></td>
				<td><input type="text" id="jtl_dj"/></td>
				<td><a class="easyui-linkbutton" id="jtl_hf">划分</a></td>
			</tr>
		</table></td></tr>
		<tr><td class="title">交通组成</td></tr>
		<tr><td><table id="jtzc_table" width="95%" align="center">
			<tr><td><span id="jtzc_start"></span>-<input id="jtzc_end" class="easyui-numberbox" style="width:55px;"/></td>
				<td><input type="text" id="jtzc_dj"/></td>
				<td><a class="easyui-linkbutton" id="jtzc_hf">划分</a></td>
			</tr>
		</table></td></tr>
		<tr><td class="title">穿越情况</td></tr>
		<tr><td><table id="cyqk_table" width="95%" align="center">
			<tr><td><span id="cyqk_start"></span>-<input id="cyqk_end" class="easyui-numberbox" style="width:55px;"/></td>
				<td><input type="text" id="cyqk_dj"/></td>
				<td><a class="easyui-linkbutton" id="cyqk_hf">划分</a></td>
			</tr>
		</table></td></tr>
		<tr><td class="title">其他</td></tr>
		<tr><td><table id="qt_table" width="95%" align="center">
			<tr><td><span id="qt_start"></span>-<input id="qt_end" class="easyui-numberbox" style="width:55px;"/></td>
				<td><input type="text" id="qt_dj"/></td>
				<td><a class="easyui-linkbutton" id="qt_hf">划分</a></td>
			</tr>
		</table></td></tr>
	</table>
</form>
</div>
<div data-options="region:'south',split:false" style="height:30px;">
	<table width="40%" style="text-align:center;" align="center">
		<tr>
			<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="save">保存</a></td>
			<td><a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="cancle">取消</a></td>
		</tr>
	</table>
</div>
</body>
</html>