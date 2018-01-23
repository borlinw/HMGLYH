<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
</head>
<body class="easyui-layout" fit="true" >
<!-- 正式使用的是page/rcyh下面的那个页面 -->
	<!-- <div data-options="region:'center',border:false,title:'日常养护&nbsp;>>&nbsp;维修整改',iconCls:'home'" style="padding:0px"> -->
	<div id="ma"  class="easyui-tabs" fit="true" border="false">
		<div title="整改通知单" border="false" style="padding:0px">
			<form id="tzdForm">
				<table border="0"  cellspacing="0" cellpadding="0" align="center" width="90%">
					<tr>
						<th colspan="3" style="text-align:center; border-right: 0px; border-left: 0px; border-top: 0px; border-bottom: 0px;font-size:22px" >日常养护作业检查整改通知单</th>
					</tr>
					<tr>
						<td style="border-style:none" colspan="2" >
							填表单位:<input id="tbbmname" name="tbbmname" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" />
						</td>
						<td style="text-align:right;border-style:none" >表 6-11</td>
					</tr>
					<tr
						<td style="border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;" ></td>
						<td style="border-right: 0px; border-left: 0px; border-top: black 1px solid; border-bottom: 0px;" ></td>
						<td style="text-align:right; border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: black 1px solid;" >
							通知单序列号：
							<input name="tzdxlj" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td colspan="3" style="border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: 0px;"  >
							&nbsp;致<span id="lrt"></span>：
							<br/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<span id="bigText" >经巡查、检查发现你单位 ^^^此行中的各种属性需要在JS中拼接之后对该Span重写数据^^^在 ^位置^ 等处，从事的养护作业存在以下问题，请务必 ^要求（立即/尽快）^按本单要求进行整改，并于^^要求完成时间^^前报送整改结果，特此通知。</span>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:right; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: 0px;" >
							检查人：<input id="tbrxm" name="tbrxm" style="border : 0px;" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:right; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" >
							送单时间：<input id="sdtimeStr" name="sdtimeStr" style="border : 0px;" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td style="text-align:center; width: 88px; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" >存在问题</td>
						<td colspan="2" style="border-right: black 1px solid; border-left: 0px; border-top: 0px; border-bottom: black 1px solid;" >
							<br/>
							<div id="czwt" style="width: 95%;height:240px" ></div>
						</td>
					</tr>
					<tr>
						<td style="text-align:center; width: 88px; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" >整改要求：</td>
						<td colspan="2" style="border-right: black 1px solid; border-left: 0px; border-top: 0px; border-bottom: black 1px solid;" >
							<br/>
							<div id="zgyq" style="width: 95%;height:240px" ></div>
						</td>
					</tr>
					<tr height="23px">
						<td colspan="2" style="text-align:left; border-right: 0px; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" >
							接单人：<input id="jdrxm" name="jdrxm" style="border : 0px;" readonly="readonly" />
						</td>
						<td style="text-align:right; border-right: black 1px solid; border-left: 0px; border-top: 0px; border-bottom: black 1px solid;" >
							接单时间： <input id="jdtimeStr" name="jdtimeStr" style="border : 0px;" readonly="readonly" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div title="整改回复单" border="false" style="padding:0px">
			<form id="hfdForm">
				<table border="0" cellspacing="0" cellpadding="0" align="center" width="90%">
					<tr>
						<th colspan="4" style="text-align: center; border-right: 0px; border-left: 0px; border-top: 0px; border-bottom: 0px; font-size: 22px">日常养护作业检查整改回复单</th>
					</tr>
					<tr>
						<td colspan="4" style="text-align: right; border-right: 0px; border-left: 0px; border-top: 0px; border-bottom: 0px;">表6-12</td>
					</tr>
					<tr>
						<td style="border-style: none" colspan="2">
							<p style="text-indent: 2em;">
								养护作业单位:
								<input id="zybmname" name="zybmname" style="border : 0px;" readonly="readonly" />
							</p>
						</td>
						<td colspan="2" style="text-align: right; border-style: none">
							日期：<input id="hfdateStr" name="hfdateStr" style="border : 0px;" readonly="readonly" />
						</td>
					</tr>
					<tr height="25px">
						<td style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">通知单编号：</td>
						<td style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">
							<input id="tzdxlj" name="tzdxlj" style="border : 0px;" readonly="readonly" />
						</td>
						<td style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">通知时间：</td>
						<td style="text-align: center; border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">
							<input id="sdtimeStr" name="sdtimeStr" style="border : 0px;" readonly="readonly" />
						</td>
					</tr>
					<tr height="25px">
						<td style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">要求完成时间：</td>
						<td style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">
							<input id="sxtimeStr" name="sxtimeStr" style="border : 0px;" readonly="readonly" />
						</td>
						<td style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">实际完成时间：</td>
						<td style="text-align: center; border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">
							<input id="sjwctimeStr" name="sjwctimeStr" style="border : 0px;" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td style="text-align: center; width: 88px; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">整改措施</td>
						<td colspan="3" style="border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">
							<br />
							<div id="zgcs" style="width: 95%; height: 200px"></div>
						</td>
					</tr>
					<tr>
						<td style="text-align: center; width: 88px; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">整改结果</td>
						<td colspan="3" style="border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">
							<br />
							<div id="zgjg" style="width: 95%; height: 200px"></div>
						</td>
					</tr>
					<tr>
						<td rowspan="2" style="text-align: center; width: 88px; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: black 1px solid;">检查人审核意见</td>
						<td colspan="3" style="border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">
							<br />
							<div id="jcryj" name="jcryj" style="width: 95%; height: 180px"></div>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align: right; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;">
							签名：<input class="easyui-validatebox" data-options="required:false" style="width: 100px; border : 0px;" readonly="readonly" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>