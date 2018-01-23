<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<head>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/calculate.js"></script>
<title>维修作业验收</title>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<form id="fm" action="${pageContext.request.contextPath}/rcyh/wxzy_saveYs.do" method="post">
		<div class="datagrid-body">		
			<s:token />
			<input type="hidden" name="zyys.bmcode" value="<s:property value="zyys.bmcode" />" />
			<input type="hidden" name="zyys.ysusername" value="<s:property value="user.username" />" />
			<input type="hidden" name="zyys.ldcode" value="<s:property value="zyys.ldcode" />" />
			<input type="hidden" name="zyys.yhid" value="<s:property value="zyys.yhid" />" />
			<input type="hidden" id="zyyszt" name="zyys.zyyszt" value="<s:property value="zyys.zyyszt" />" />
			<input type="hidden" id="bufenYs" name="bufenYs" value="false" />
			<input type="hidden" name="zyys.ssny" value="<s:property value="zyys.ssny" />" />
			<input  type="hidden" id="dejs" value="<s:property value="zyys.dejs" />" /><!-- 定额基数 -->
			<input  type="hidden" id="srz" value="" /><!-- 用户输入值 -->
			<input  type="hidden" id="xsz" value="" /><!-- 当前显示值 -->
			<table id="mytable" class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
				<tr class="datagrid-row">
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>验收时间</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input name="zyys.ystime" class="easyui-datebox" data-options="
								value:'<s:property value="zyys.ystime" />'
							" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>验收人</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input readonly="readonly"  class="notnull"   value="<s:property value="user.ryname" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>作业单位</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input readonly="readonly"  type="text" class="notnull" value="<s:property value="zyys.bmname" />" >
							<input readonly="readonly"  type="hidden" class="notnull" value="<s:property value="zyys.bmcode" />" >
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>所属路段(养护站路段)</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input  readonly class="notnull" value="<s:property value="zyys.ldname" />"/>
						</div>
					</td>
				</tr>
				
				<tr class="datagrid-row">
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>所属年月</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input readonly="readonly" value="<s:property value="zyys.ssny" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>养护类型</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input readonly="readonly" value="<s:property value="zyys.yhname" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>上报数量</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="sbsl" style="width:100px;" errorInfo="上报数量填写不正确" readonly="readonly" type="text" class="int notnull" name="zyys.sbsl" value="<s:property value="zyys.sbsl" />" >
							<span><s:property value="zyys.dw" /></span>
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>上报工日</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="sbgr" errorInfo="上报工日填写不正确" readonly="readonly" class="int notnull" name="zyys.sbgr" value="<s:property value="zyys.sbgr" />"/>
						</div>
					</td>
				</tr>
				
				<tr class="datagrid-row">
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>路段桩号</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input  name="zyys.ldzh" readonly="readonly" value="<s:property value="zyys.ldzh" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>抽检数量</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input onBlur="ysCalculate(this)"  onfocus="pgslFocus(this)"  style="width:100px;" errorInfo="抽检数量填写不正确"  id="cjsl" class="int notnull" name="zyys.cjsl" value="<s:property value="zyys.cjsl" />" />
							<span><s:property value="zyys.dw" /></span>
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>验收数量</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input onBlur="ysCalculate(this)"  onfocus="pgslFocus(this)"  id="yssl" style="width:100px;" errorInfo="验收数量填写不正确" type="text" class="int notnull" name="zyys.yssl" value="<s:property value="zyys.yssl" />" >
							<span><s:property value="zyys.dw" /></span>
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>合格数量</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input onBlur="ysCalculate(this)"  onfocus="pgslFocus(this)"  id="hgsl" style="width:100px;" errorInfo="合格数量填写不正确"  class="int notnull" name="zyys.hgsl" value="<s:property value="zyys.hgsl" />"/>
							<span><s:property value="zyys.dw" /></span>
						</div>
					</td>
				</tr>
				
				<tr class="datagrid-row">
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>数量符合率</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="slfhl"  errorInfo="数量复合率不正确"  class="double notnull" name="zyys.slfhl" readonly="readonly" value="<s:property value="zyys.slfhl" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>质量合格率</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="zlhgl" readonly="readonly"  error="质量合格率不正确" class="double notnull" name="zyys.zlhgl" value="<s:property value="zyys.zlhgl" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>有效数量</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="yxsl"  errorInfo="有效数量填写不正确" readonly="readonly"  style="width:100px;" type="text" class="double notnull" name="zyys.yxsl" value="<s:property value="zyys.yxsl" />" >
							<span><s:property value="zyys.dw" /></span>
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>有效工日</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="yxgr" errorInfo="有效工日错误" class="double notnull" readonly="readonly" name="zyys.yxgr" value="<s:property value="zyys.yxgr" />"/>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div class="doYs doYs1" style="display:none">
		<center style="margin-top:5px;"><a class="easyui-linkbutton" onclick="$('#fm').submit()" data-options="plain:true">打回返工</a></center>
	</div>
	<div class="doYs doYs2" style="display:none;">
		<center style="margin-top:5px;"><a class="easyui-linkbutton"  onclick="$('#fm').submit()" data-options="plain:true" >部分验收</a></center>
	</div>
	<div class="doYs doYs3" style="display:none;">
		<center style="margin-top:5px;"><a class="easyui-linkbutton"  onclick="$('#fm').submit()" data-options="plain:true" >全部验收</a></center>
	</div>
 </body>
</html>