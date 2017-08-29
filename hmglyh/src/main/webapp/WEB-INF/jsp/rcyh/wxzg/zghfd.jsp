<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<script type="text/javascript" language="javascript"
	src="${pageContext.request.contextPath}/js/YMLib.js"></script>
<script type="text/javascript" language="javascript"
	src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script>
<script type="text/javascript" language="javascript"
	src="${pageContext.request.contextPath}/page/rcyh/js/zghfd.js"></script>
</head>


<body>


	<div class="easyui-layout" data-options="fit:true">


		<%--     <s:form  id="userform" > 
 

        <input type="hidden" name="username" value="<s:property value="user.username" />"> 
 

        <input type="hidden" name="ryname" value="<s:property value="user.ryname" />"> 
 

        <input type="hidden" name="bmcode" value="<s:property value="user.bmcode" />"> 
 

        <input type="hidden" name="zw" value="<s:property value="user.zw" />"> 
 

        <input type="hidden" name="bmname" value="<s:property value="user.bmname" />"> 
 

        <input type="hidden" name="fzr" value="<s:property value="user.fzr" />"> 
 

        <input type="hidden" name="bmlx" value="<s:property value="user.bmlx" />"> 
 

    </s:form> --%>


		<div data-options="region:'south',border:false"
			style="height: 36px; padding-top: 0px; text-align: center;">


			<s:if test="add">


				<input id="btnSave" type="button" value="确定" />


			</s:if>


			<s:if test="sh">


				<input id="tzdno" type="button" value="整改不合格" />


				<input id="tzdok" type="button" value="整改合格" />


			</s:if>


			<s:if test="fg">


				<input id="btnSave" type="button" value="返工完成" />


			</s:if>


			<!-- <input id="tzdno" type="button" value="整改不合格" style="display : none" /> 
 

        <input id="tzdok" type="button" value="整改合格" style="display : none" /> 
 

        <input id="btnSave" type="button" value="确定" style="display : none" /> -->


			<input id="close" type="button" value="取消"
				onclick="parent.$('#add,#edit,#view').window('close')" />


			<form>


				<input id="action" value="<s:property value='add' />" type="hidden">


				<input id="shAction" value="<s:property value='sh' />" type="hidden">


				<input id="view" value="<s:property value='view' />" type="hidden">


				<input id="fg" value="<s:property value='fg' />" type="hidden">


				<input id="hfdid" value="<s:property value='model.hfdid' />"
					type="hidden"> <input id="tzdid"
					value="<s:property value='model.tzdid' />" type="hidden">


			</form>


		</div>


		<div data-options="region:'center',border:false" style="padding-top: 20px;height:100%;overflow-y:scroll;">


			<form id="form">


				<table border="0" cellspacing="0" cellpadding="0" align="center"
					width="90%">


					<tr>


						<th colspan="4"
							style="text-align: center; border-right: 0px; border-left: 0px; border-top: 0px; border-bottom: 0px; font-size: 22px">日常养护作业检查整改回复单</th>


					</tr>


					<tr>


						<td colspan="4"
							style="text-align: right; border-right: 0px; border-left: 0px; border-top: 0px; border-bottom: 0px;">表
							6-12</td>


					</tr>


					<tr>


						<td style="border-style: none" colspan="2">


							<p style="text-indent: 2em;">


								养护作业单位:


								<s:if test="add">


									<input id="zybmname"
										style="border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
										readonly="readonly" value="<s:property value='user.bmname' />" />


								</s:if>


								<s:if test="sh">


									<input id="zybmname"
										style="border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
										readonly="readonly"
										value="<s:property value='model.zybmname' />" />


								</s:if>


								<s:if test="fg">


									<input id="zybmname"
										style="border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
										readonly="readonly"
										value="<s:property value='model.zybmname' />" />


								</s:if>


								<s:if test="view">


									<input id="zybmname"
										style="border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
										readonly="readonly"
										value="<s:property value='model.zybmname' />" />


								</s:if>


								<!-- <input id="zybmname" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" /> 
 

                            <input id="zybmcode" name="tbbmcode" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px;display:none " readonly="readonly" /> -->


							</p>


						</td>


						<td colspan="2" style="text-align: right; border-style: none">


							日期： <s:if test="add">
								<s:property value="newDateStrToView" />
							</s:if> <s:if test="sh">
								<s:property value="model.hfdateStr" />
							</s:if> <s:if test="fg">
								<s:property value="model.hfdateStr" />
							</s:if> <s:if test="view">
								<s:property value="model.hfdateStr" />
							</s:if>


						</td>


					</tr>


					<tr height="25px">


						<td
							style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">通知单编号：</td>


						<td
							style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">


							<s:if test="add">


								<span id="tzdxlj"></span>


							</s:if> <s:if test="sh">


								<span><s:property value="model.tzdxlj" /></span>


							</s:if> <s:if test="fg">


								<span><s:property value="model.tzdxlj" /></span>


							</s:if> <s:if test="view">


								<span><s:property value="model.tzdxlj" /></span>


							</s:if>


						</td>


						<td
							style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">通知时间：</td>


						<td
							style="text-align: center; border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">


							<s:if test="add">


								<span id="sdtimeStr"></span>


							</s:if> <s:if test="sh">


								<span><s:property value="model.sdtimeStr" /></span>


							</s:if> <s:if test="fg">


								<span><s:property value="model.sdtimeStr" /></span>


							</s:if> <s:if test="view">


								<span><s:property value="model.sdtimeStr" /></span>


							</s:if>


						</td>


					</tr>


					<tr height="25px">


						<td
							style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">要求完成时间：</td>


						<td
							style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">


							<s:if test="add">


								<span id="sxtimeStr"></span>


							</s:if> <s:if test="sh">


								<span><s:property value="model.sxtimeStr" /></span>


							</s:if> <s:if test="fg">


								<span><s:property value="model.sxtimeStr" /></span>


							</s:if> <s:if test="view">


								<span><s:property value="model.sxtimeStr" /></span>


							</s:if>


						</td>


						<td
							style="text-align: center; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">实际完成时间：</td>


						<td
							style="text-align: center; border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">


							<s:if test="add">


								<span id="sjwctimeInputOfSpan"> <input id="sjwctime"
									name="sjwctime" class="easyui-datebox"
									data-options="required:true" style="width: 98%" />


								</span>


							</s:if> <s:if test="sh">


								<span id="sjwcsjStrOfSpan"><s:property
										value="model.sjwctimeStr" /></span>


							</s:if> <s:if test="fg">


								<span id="sjwctimeInputOfSpan"> <input id="sjwctime"
									name="sjwctime" class="easyui-datebox"
									data-options="required:true" style="width: 98%" />


								</span>


							</s:if> <s:if test="view">


								<span id="sjwcsjStrOfSpan"><s:property
										value="model.sjwctimeStr" /></span>


							</s:if>


						</td>


					</tr>


					<tr>


						<td
							style="text-align: center; width: 88px; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">整改措施</td>


						<td colspan="3"
							style="border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">


							<br /> <s:if test="add">


								<div id="zgcs" name="zgcs" contenteditable="true"
									style="width: 95%; height: 200px">整改措施描述</div>


							</s:if> <s:if test="sh">


								<div id="zgcs" name="zgcs" style="width: 95%; height: 200px">
									<s:property value="model.zgcs" />
								</div>


							</s:if> <s:if test="fg">


								<div id="zgcs" name="zgcs" contenteditable="true"
									style="width: 95%; height: 200px">
									<s:property value="model.zgcs" />
								</div>


							</s:if> <s:if test="view">


								<div id="zgcs" name="zgcs" style="width: 95%; height: 200px">
									<s:property value="model.zgcs" />
								</div>


							</s:if>


						</td>


					</tr>


					<tr>


						<td
							style="text-align: center; width: 88px; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">整改结果</td>


						<td colspan="3"
							style="border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">


							<br /> <s:if test="add">


								<div id="zgjg" name="zgjg" contenteditable="true"
									style="width: 95%; height: 240px">整改结果描述</div>


							</s:if> <s:if test="sh">


								<div id="zgjg" name="zgcs" style="width: 95%; height: 200px">
									<s:property value="model.zgjg" />
								</div>


							</s:if> <s:if test="fg">


								<div id="zgjg" name="zgcs" contenteditable="true"
									style="width: 95%; height: 200px">
									<s:property value="model.zgjg" />
								</div>


							</s:if> <s:if test="view">


								<div id="zgjg" name="zgcs" style="width: 95%; height: 200px">
									<s:property value="model.zgjg" />
								</div>


							</s:if>


						</td>


					</tr>


					<tr>


						<td rowspan="2"
							style="text-align: center; width: 88px; border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: black 1px solid;">检查人审核意见</td>


						<td colspan="3"
							style="border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;">


							<br /> <s:if test="add">


								<div name="jcryj" style="width: 95%; height: 180px"></div>


							</s:if> <s:if test="sh">


								<div id="jcryj" contenteditable="true"
									style="width: 95%; height: 180px">
									<s:property value="model.jcryj" />
								</div>


							</s:if> <s:if test="fg">


								<div id="jcryj" style="width: 95%; height: 180px">
									<s:property value="model.jcryj" />
								</div>


							</s:if> <s:if test="view">


								<div id="jcryj" style="width: 95%; height: 180px">
									<s:property value="model.jcryj" />
								</div>


							</s:if>


						</td>


					</tr>


					<tr>


						<td colspan="3"
							style="text-align: right; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;">


							签名： <s:if test="add">


								<input class="easyui-validatebox" data-options="required:false"
									style="width: 100px; border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
									readonly="readonly" />


							</s:if> <s:if test="sh">


								<input id="jcrxm" name="jcrxm" class="easyui-validatebox"
									data-options="required:true"
									style="width: 100px; border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
									value="<s:property value='user.ryname' />" />


							</s:if> <s:if test="fg">


								<input class="easyui-validatebox" data-options="required:false"
									style="width: 100px; border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
									value="<s:property value='model.jcrxm' />" readonly="readonly" />


							</s:if> <s:if test="view">


								<input class="easyui-validatebox" data-options="required:false"
									style="width: 100px; border-left: 0px; border-top: 0px; border-right: 0px; border-bottom: 1px"
									value="<s:property value='model.jcrxm' />" readonly="readonly" />


							</s:if>


						</td>


					</tr>


				</table>


			</form>


		</div>


	</div>


</body>


</html>
