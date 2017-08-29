<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加区段划分</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/highchart/js/highcharts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/highchart/js/modules/exporting.js"></script>
<script type="text/javascript" src="./js/addQdhf.js"></script>
<style type="text/css">
	#qdTable,#detail{
		text-align:center;
	}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'west',border:true" style="width:300px;border-left:0px;border-button:0px;border-top:0px;">
		<form id="myForm">
			<table border="0" cellspacing="5">
				<tr>
					<td style="text-align:right;">区域：</td>
					<td><span id="ldCode"></span></td>
				</tr>
				<tr>
					<td style="text-align:right;">版本：</td>
					<td><span id="qdbb"></span>
						<input type="hidden" name="bbid"/></td>
				</tr>
				<tr>
					<td style="text-align:right;">路况评定版本：</td>
					<td><select class="easyui-combobox" id="pdbbid" style="width:130px" panelHeight="auto" name="pdbbid"></select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">路况调查版本：</td>
					<td><select class="easyui-combobox" id="dcbbid" style="width:130px" panelHeight="auto" name="dcbbid"></select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">区段划分：</td>
					<td style="width:200px" >K<span id="start"></span>-
						K<input class="easyui-validatebox" id="end" data-options="required:true,validType:'numberFloat'" style="width:30px"/>
						&nbsp;
						<!-- <img style="cursor:pointer;" id="query" src="../images/button_search.png"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="query">查看</a>
						<!-- <img style="cursor:pointer;" id="add" src="../images/button_qdhf.png"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="add">划分</a>
						<table id="append" border="0">
							
						</table>
					</td>
				</tr>
				<tr>
					<td><span id="test"></span></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center;">
						<!-- <input type="button" class="save_button" value="保  存" id="btnSave"/> -->
						<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="btnSave">保存</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',border:true" style="border-left:0px;border-right:0px;border-bottom:0px;">
		<div class="easyui-tabs" fit="true">
			<div title="图表">
				<div id="container">
				</div>
			</div>
			<div title="表格">
				<table border="0" width="800px">
					<tr><td>区段病害分类统计</td></tr>
					<tr><td>
						<table id="qdTable" width="800px" border="1" cellpadding="0" cellspacing="0">
							<tr>
								<td rowspan="3">区段桩号</td>
								<td colspan="3">裂缝类</td>
								<td colspan="3">变形类</td>
								<td colspan="2" rowspan="2">松散类（%）</td>
								<td colspan="2" rowspan="2">其他类（%）</td>
								<td rowspan="3">主导病害</td>
							</tr>
							<tr>
								<td colspan="2">网裂（%）</td>
								<td>单条裂缝（%）</td>
								<td colspan="2">变形（%）</td>
								<td>车辙（%）</td>
							</tr>
							<tr>
								<td>龟裂</td>
								<td>块裂</td>
								<td>纵、横向裂缝</td>
								<td>沉陷</td>
								<td>波浪拥包</td>
								<td>车辙</td>
								<td>坑槽</td>
								<td>松散</td>
								<td>泛油</td>
								<td>修补</td>
							</tr>
						</table>
					</td></tr>
					<tr><td>千米路段病害分类统计</td></tr>
					<tr><td>
						<table id="detail" width="800px" border="1" cellpadding="0" cellspacing="0">
							<tr>
								<td rowspan="3">千米路段桩号</td>
								<td colspan="3">裂缝类</td>
								<td colspan="3">变形类</td>
								<td colspan="2" rowspan="2">松散类（%）</td>
								<td colspan="2" rowspan="2">其他类（%）</td>
								<td rowspan="3">主导病害</td>
							</tr>
							<tr>
								<td colspan="2">网裂（%）</td>
								<td>单条裂缝（%）</td>
								<td colspan="2">变形（%）</td>
								<td>车辙（%）</td>
							</tr>
							<tr>
								<td>龟裂</td>
								<td>块裂</td>
								<td>纵、横向裂缝</td>
								<td>沉陷</td>
								<td>波浪拥包</td>
								<td>车辙</td>
								<td>坑槽</td>
								<td>松散</td>
								<td>泛油</td>
								<td>修补</td>
							</tr>
						</table>
					</td></tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>





