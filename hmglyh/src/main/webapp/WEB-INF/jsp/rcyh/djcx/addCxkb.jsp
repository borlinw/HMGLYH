<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加/编辑“除雪快报表”信息</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/page/rcyh/js/addCxkb.js"></script>
</head>
<body>

<div class="easyui-layout" data-options="fit:true" >
	<div data-options="region:'south',border:false" style="height:30px;padding-top:0px;text-align: center;">
		<s:if test="toAdd"><input id="btnSave" type="button" value="确定" /></s:if>
		<s:if test="toEdit"><input id="btnSave" type="button" value="确定" /></s:if>
		<input id="close" type="button" value="取消" onclick="parent.$('#add,#view,#edit').window('close')"/>
		<input id="nowBmcode" type="hidden" value="<s:property value='user.bmcode' />"  />
		<s:if test="toEdit">
			<input id="qzzhStrToViewInJsp" type="hidden" value="<s:property value='model.qzzhStr' />" />
		</s:if>
	</div>
	<div data-options="region:'center',border:false" style="padding-top:10px;">
		<table align="center" width="90%" >
			<tr><td colspan="7" style="text-align:center;padding-bottom:10px;" ><font size="6" face="宋体" style="font-weight:bold;" >哈密公路管理局冬季除雪快报</font></td></tr>
			<tr>
				<td colspan="3" style="text-align:left" >
					&nbsp;填报单位：
					<s:if test="toAdd"><s:property value='user.bmname' /></s:if>
					<s:if test="toView"><s:property value='model.bmname' /></s:if>
					<s:if test="toEdit"><s:property value='model.bmname' /></s:if>
				</td>
				<td colspan="4" style="text-align:center" >
					填报日期：
					<s:if test="toAdd">
						<input id="tbdateOfInput" class="easyui-datebox" data-options="required:true" style="width:120px" />
					</s:if>
					<s:if test="toView"><s:property value='model.tbdateStr' /></s:if>
					<s:if test="toEdit"><s:property value='model.tbdateStr' /></s:if>
				</td>
			</tr>
		</table>
		<form id="form">
			<table class="tableform3" border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
				<tr>
					<td colspan="2" style="text-align:center" >路线名称</td>
					<td style="text-align:center;width:125px" >
						<s:if test="toAdd">
							<input id="chooseLd" class="easyui-validatebox" maxlength="100" style="width:98%" />
							<input id="chooseLxname" type="hidden" name="lxname" />
						</s:if>
						<s:if test="toView"><s:property value='model.lxname' /></s:if>
						<s:if test="toEdit">
							<input id="chooseLd" class="easyui-validatebox" maxlength="100" style="width:98%" />
							<input id="chooseLxname" type="hidden" name="lxname" />
							<!-- <input id="chooseLxname" style="width:98%" name="lxname" /> -->
						</s:if>
					</td>
					<td style="text-align:center" >路线编码</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd"><input id="lxbm" name="lxcode" readonly="readonly" ></s:if>
						<s:if test="toView"><s:property value='model.lxcode' /></s:if>
						<s:if test="toEdit"><input id="lxbm" name="lxcode" readonly="readonly" ></s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >温度</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input name="wd" class="easyui-validatebox" maxlength="5" style="width:120px" data-options="required:true,validType:'numberTwo'" />℃</s:if>
						<s:if test="toView"><s:property value='model.wd' />℃</s:if>
						<s:if test="toEdit"><input name="wd" class="easyui-validatebox" maxlength="5" style="width:120px" data-options="required:true,validType:'numberTwo'" />℃</s:if>
					</td>
					<td style="text-align:center" >起止桩号</td>
					<td id="insertQzhhTD" colspan="3" style="text-align:center" >
						<s:if test="toAdd">
							<input id="toAddQzzh" style="width:98%" readonly="readonly" name="qzzh" />
							<input id="toAddQzzhStr" name="qzzhStr" type="hidden" />
							<!-- <input id="toAddQzzhStr" style="width:98%" name="qzzhStr" /> -->
						</s:if>
						<s:if test="toView"><s:property value='model.qzzh' /></s:if>
						<s:if test="toEdit">
							<input id="toAddQzzh" style="width:98%" readonly="readonly" name="qzzh" />
							<input id="toAddQzzhStr" name="qzzhStr" type="hidden" />
							<!-- <input id="toAddQzzhStr" style="width:98%" name="qzzhStr" /> -->
						</s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >降雪时间</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="jxsj" name="jxsj" class="easyui-datetimebox" data-options="required:true,showSeconds:false" value="current" style="width:120px" /></s:if>
						<s:if test="toView"><s:property value='model.jxsjStr' /></s:if>
						<s:if test="toEdit"><input id="jxsj" name="jxsj" class="easyui-datetimebox" data-options="required:true,showSeconds:false" style="width:120px" /></s:if>
					</td>
					<td style="text-align:center" >停雪时间</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="txsj" name="txsj" class="easyui-datetimebox" data-options="required:true,showSeconds:false" value="current" style="width:120px" /></s:if>
						<s:if test="toView"><s:property value='model.txsjStr' /></s:if>
						<s:if test="toEdit"><input id="txsj" name="txsj" class="easyui-datetimebox" data-options="required:true,showSeconds:false" style="width:120px" /></s:if>
					</td>
					<td style="text-align:center" >持续时间（h）</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="cxsj" name="cxsj" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.cxsj' /></s:if>
						<s:if test="toEdit"><input id="cxsj" name="cxsj" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >平均厚度（cm）</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="pjhd" name="pjhd" onchange="countCxl()" onkeyup="changeJxfl()" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.pjhd' /></s:if>
						<s:if test="toEdit"><input id="pjhd" name="pjhd" onchange="countCxl()" onkeyup="changeJxfl()" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
					</td>
					<td style="text-align:center" >降雪分类</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="chooseCxfl" name="cxfl" class="easyui-combobox" style="width:120px" /></s:if>
						<s:if test="toView"><s:property value='model.cxflStr' /></s:if>
						<s:if test="toEdit"><input id="chooseCxfl" name="cxfl" class="easyui-combobox" style="width:120px" /></s:if>
					</td>
					<td style="text-align:center;width:90px;" >除雪里程（km）</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="cxlc" name="cxlc" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.cxlc' /></s:if>
						<s:if test="toEdit"><input id="cxlc" name="cxlc" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >除雪开始时间</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="stime" name="stime" class="easyui-datetimebox" data-options="required:true,showSeconds:false" value="current" style="width:120px" /></s:if>
						<s:if test="toView"><s:property value='model.stimeStr' /></s:if>
						<s:if test="toEdit"><input id="stime" name="stime" class="easyui-datetimebox" data-options="required:true,showSeconds:false" style="width:120px" /></s:if>
					</td>
					<td style="text-align:center" >除雪结束时间</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="etime" name="etime" class="easyui-datetimebox" data-options="required:true,showSeconds:false" value="current" style="width:120px" /></s:if>
						<s:if test="toView"><s:property value='model.etimeStr' /></s:if>
						<s:if test="toEdit"><input id="etime" name="etime" class="easyui-datetimebox" data-options="required:true,showSeconds:false" style="width:120px" /></s:if>
					</td>
					<td style="text-align:center" >除雪时间（h）</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="chuxsj" name="chuxsj" onchange="countRggrAndJxtb()" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.chuxsj' /></s:if>
						<s:if test="toEdit"><input id="chuxsj" name="chuxsj" onchange="countRggrAndJxtb()" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >除雪面积（㎡）</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="cxmj" name="cxmj" onchange="countCxl()" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.cxmj' /></s:if>
						<s:if test="toEdit"><input id="cxmj" name="cxmj" onchange="countCxl()" class="easyui-validatebox" maxlength="100" data-options="required:true,validType:'numberFloatTwo'" /></s:if>
					</td>
					<td style="text-align:center" >除雪量（m³）</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd"><input id="cxl" name="cxl" class="easyui-validatebox" maxlength="100" data-options="required:true" /></s:if>
						<s:if test="toView"><s:property value='model.cxl' /></s:if>
						<s:if test="toEdit"><input id="cxl" name="cxl" class="easyui-validatebox" maxlength="100" data-options="required:true" /></s:if>
					</td>
				</tr>
				<tr>
					<td colspan="7" >工料机消耗</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >名称</td>
					<td style="text-align:center" >数量</td>
					<td style="text-align:center" >单价</td>
					<td colspan="3" style="text-align:center" >费用（元）</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >人工工日</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="rggr" name="rggr" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.rggr' /></s:if>
						<s:if test="toEdit"><input id="rggr" name="rggr" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
					</td>
					<td style="text-align:center" >/</td>
					<td colspan="3" style="text-align:center" >/</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >机械台班</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="jxtb" name="jxtb" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.jxtb' /></s:if>
						<s:if test="toEdit"><input id="jxtb" name="jxtb" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
					</td>
					<td style="text-align:center" >/</td>
					<td colspan="3" style="text-align:center" >/</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >除雪用盐（t）</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="cxyysl" name="cxyysl" onchange="countCxyy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.cxyysl' /></s:if>
						<s:if test="toEdit"><input id="cxyysl" name="cxyysl" onchange="countCxyy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
					</td>
					<td style="text-align:center" >
						<s:if test="toAdd"><input id="cxyydj" name="cxyydj" onchange="countCxyy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.cxyydj' /></s:if>
						<s:if test="toEdit"><input id="cxyydj" name="cxyydj" onchange="countCxyy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd"><input id="cxyyfy" name="cxyyfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
						<s:if test="toView"><s:property value='model.cxyyfy' /></s:if>
						<s:if test="toEdit"><input id="cxyyfy" name="cxyyfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" /></s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >融雪剂（t）</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="rxjsl" name="rxjsl" onchange="countRxj()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.rxjsl' /></s:if>
						<s:if test="toEdit">
							<input id="rxjsl" name="rxjsl" onchange="countRxj()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="rxjdj" name="rxjdj" onchange="countRxj()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.rxjdj' /></s:if>
						<s:if test="toEdit">
							<input id="rxjdj" name="rxjdj" onchange="countRxj()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd">
							<input id="rxjfy" name="rxjfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.rxjfy' /></s:if>
						<s:if test="toEdit">
							<input id="rxjfy" name="rxjfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >滚刷（副）</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="gssl" name="gssl" onchange="countGs()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.gssl' /></s:if>
						<s:if test="toEdit">
							<input id="gssl" name="gssl" onchange="countGs()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="gsdj" name="gsdj" onchange="countGs()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.gsdj' /></s:if>
						<s:if test="toEdit">
							<input id="gsdj" name="gsdj" onchange="countGs()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd">
							<input id="gsfy" name="gsfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.gsfy' /></s:if>
						<s:if test="toEdit">
							<input id="gsfy" name="gsfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >刀片（副）</td>
					<!-- <td style="text-align:center" >修斯除雪车</td> -->
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="dpsl" name="dpsl" onchange="countDp()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.dpsl' /></s:if>
						<s:if test="toEdit">
							<input id="dpsl" name="dpsl" onchange="countDp()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="dpdj" name="dpdj" onchange="countDp()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.dpdj' /></s:if>
						<s:if test="toEdit">
							<input id="dpdj" name="dpdj" onchange="countDp()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd">
							<input id="dpfy" name="dpfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.dpfy' /></s:if>
						<s:if test="toEdit">
							<input id="dpfy" name="dpfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td rowspan="2" style="text-align:center" >油料（L）</td>
					<td style="text-align:center" >汽油 93#</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="qysl" name="qysl" onchange="countQy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.qysl' /></s:if>
						<s:if test="toEdit">
							<input id="qysl" name="qysl" onchange="countQy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="qydj" name="qydj" onchange="countQy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.qydj' /></s:if>
						<s:if test="toEdit">
							<input id="qydj" name="qydj" onchange="countQy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd">
							<input id="qyfy" name="qyfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.qyfy' /></s:if>
						<s:if test="toEdit">
							<input id="qyfy" name="qyfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td style="text-align:center" >柴油 0#</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="cysl" name="cysl" onchange="countCy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.cysl' /></s:if>
						<s:if test="toEdit">
							<input id="cysl" name="cysl" onchange="countCy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="cydj" name="cydj" onchange="countCy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.cydj' /></s:if>
						<s:if test="toEdit">
							<input id="cydj" name="cydj" onchange="countCy()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd">
							<input id="cyfy" name="cyfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.cyfy' /></s:if>
						<s:if test="toEdit">
							<input id="cyfy" name="cyfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >其他</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="qtsl" name="qtsl" onchange="countQt()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.qtsl' /></s:if>
						<s:if test="toEdit">
							<input id="qtsl" name="qtsl" onchange="countQt()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td style="text-align:center" >
						<s:if test="toAdd">
							<input id="qtdj" name="qtdj" onchange="countQt()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
						<s:if test="toView"><s:property value='model.qtdj' /></s:if>
						<s:if test="toEdit">
							<input id="qtdj" name="qtdj" onchange="countQt()" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" />
						</s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						<s:if test="toAdd">
							<input id="qtfy" name="qtfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloat'" />
						</s:if>
						<s:if test="toView"><s:property value='model.qtfy' /></s:if>
						<s:if test="toEdit">
							<input id="qtfy" name="qtfy" class="easyui-validatebox" maxlength="100" data-options="required:false,validType:'numberFloat'" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center" >费用合计（元）</td>
					<td colspan="5" style="text-align:center" >
						<s:if test="toAdd">
							<input id="fyhj" name="fyhj" class="easyui-validatebox" style="width:90%" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" readonly="readonly" value="" />
						</s:if>
						<s:if test="toView"><s:property value='model.fyhj' /></s:if>
						<s:if test="toEdit">
							<input id="fyhj" name="fyhj" class="easyui-validatebox" style="width:90%" maxlength="100" data-options="required:false,validType:'numberFloatTwo'" readonly="readonly" value="" />
						</s:if>
					</td>
				</tr>
				<tr>
					<td style="text-align:center" >备注</td>
					<td colspan="6" style="text-align:left" >
						<s:if test="toAdd">
							<font style="font-weight:bold;" >除雪人数：</font>
							<input id="cxrs" name="cxrs" onchange="countRggr()" class="easyui-validatebox" style="width:40px;" maxlength="5" data-options="required:true,validType:'number'" />
							人。<span id='nzCxrs'></span><br/>
							<font style="font-weight:bold;" >除雪车辆：</font>
							机械车共
							<input id="jxcl" name="jxcl" onchange="countJxtb()" class="easyui-validatebox" style="width:40px;" maxlength="5" data-options="required:true,validType:'number'" />
							辆。
							<span id='nzCxcl' contenteditable='true' style='width: 70%;' >撒盐车1辆、装载机1台、皮卡车1辆。</span><br/>
							<font style="font-weight:bold;" >除雪面积：</font>
							<span id='nzCxmj' contenteditable='true' style='width: 70%;' >（ * ）* = ㎡ （路面宽度*里程）如有不同路段，请分别计算。</span><br/>
							<font style="font-weight:bold;" >除雪量：</font>
							<span id='nzCxl' contenteditable='true' style='width: 70%;' > * = m<sup>3</sup>。</span>
							<!-- <textarea rows="3" cols="30" name="nz" style="width:98%" maxlength="100" ></textarea> -->
						</s:if>
						<s:if test="toView">
							<font style="font-weight:bold;" >除雪人数：</font>
							<s:if test="model.cxrs==null"><s:property value='model.nzCxrs' escape="false" /></s:if>
							<s:if test="model.cxrs!=null"><s:property value='model.cxrs' escape="false" />人。</s:if>
							<br/>
							<font style="font-weight:bold;" >除雪车辆：</font>
							<s:if test="model.jxcl!=null">机械车共<s:property value='model.jxcl' escape="false" />辆。</s:if>
							<s:property value='model.nzCxcl' escape="false" /><br/>
							<font style="font-weight:bold;" >除雪面积：</font>
							<s:property value='model.nzCxmj' escape="false" /><br/>
							<font style="font-weight:bold;" >除雪量：</font>
							<s:property value='model.nzCxl' escape="false" />
						</s:if>
						<s:if test="toEdit">
							<font style="font-weight:bold;" >除雪人数：</font>
							<s:if test="model.cxrs==null"><span id='nzCxrs' contenteditable='true' style='width: 70%;' ><s:property value='model.nzCxrs' /></span><span id='cxrs'></span><br/></s:if>
							<s:if test="model.cxrs!=null"><input id="cxrs" name="cxrs" onchange="countRggr()" class="easyui-validatebox" style="width:40px;" maxlength="5" data-options="required:true,validType:'number'" />人。<span id='nzCxrs'></span><br/></s:if>
							<font style="font-weight:bold;" >除雪车辆：</font>
							<s:if test="model.jxcl!=null">机械车共<input id="jxcl" name="jxcl" onchange="countJxtb()" class="easyui-validatebox" style="width:40px;" maxlength="5" data-options="required:true,validType:'number'" />辆。</span></s:if>
							<span id='nzCxcl' contenteditable='true' style='width: 70%;' ><s:property value='model.nzCxcl' /></span><br/>
							<font style="font-weight:bold;" >除雪面积：</font>
							<span id='nzCxmj' contenteditable='true' style='width: 70%;' ><s:property value='model.nzCxmj' /></span><br/>
							<font style="font-weight:bold;" >除雪量：</font>
							<span id='nzCxl' contenteditable='true' style='width: 70%;' ><s:property value='model.nzCxl' /></span>
						</s:if>
					</td>
				</tr>
			</table class="tableform2" >
			<table align="center" width="90%" >
				<tr>
					<td></td>
					<td colspan="3" style="text-align:left" >
						&nbsp;审核：
						<s:if test="toAdd"><input name="shrxm" class="easyui-validatebox" style="width:120px" maxlength="100" data-options="required:true" /></s:if>
						<s:if test="toView"><s:property value='model.shrxm' /></s:if>
						<s:if test="toEdit"><input name="shrxm" class="easyui-validatebox" style="width:120px" maxlength="100" data-options="required:true" /></s:if>
					</td>
					<td colspan="3" style="text-align:center" >
						填报人：
						<s:if test="toAdd"><s:property value='user.ryname' /></s:if>
						<s:if test="toView"><s:property value='model.tbrxm' /></s:if>
						<s:if test="toEdit"><s:property value='model.tbrxm' /></s:if>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>