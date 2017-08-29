<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.hdsx.hmglyh.util.MD5Util"%>
<%@ include file="../public/head.jsp"%>
 <link href="${pageContext.request.contextPath}/css/uploadify.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.uploadify.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/fileUtil.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/calculate2.js"></script>
<title></title>
<title>添加维修作业</title>
<script>
//添加 计划 材料消耗

function delRyTr(obj) {
	$(obj).parentsUntil("tr").parent().remove();
	//reCalculate2();
	reCalculateRygcl();
}

$(function(){

/* 	var jxclxhs = [<s:iterator value="wxzy.cljxxhs" id="cljx" status="status" >'<s:property value="#cljx.lxid" />'<s:if test="wxzy.cljxxhs.size != #status.index+1 ">,</s:if></s:iterator>];
	// 回显 材料 机械 消耗 
	var clxhArr = [];
	var jxxhArr = [];
	$.each(jxclxhs,function(i,d) { 
		if( d.indexOf("002") == 0 ) { // 材料消耗
			clxhArr.push(d);
		}else if(d.indexOf("003") == 0 ){ // 机械消耗
			jxxhArr.push(d);
		}
	});
	
	$("#jhclxh").combotree("setValues",clxhArr);
	$("#jhjxxh").combotree("setValues",jxxhArr); */
}); 

</script>
</head>
<body>
	
	<%-- <s:debug></s:debug> --%>
	<form id="fm" 
		<s:if test="add">
			<s:if test="ddWxzy">
				action="${pageContext.request.contextPath}/rcyh/wxzy_saveDdWxzy.do"
			</s:if>
			<s:else>
				action="${pageContext.request.contextPath}/rcyh/wxzy_saveWxzy.do"
			</s:else>
		</s:if>
		<s:if test="update">
			action="${pageContext.request.contextPath}/rcyh/wxzy_saveWxzyUpdate.do"
		</s:if>
		 method="post">
		<input type="hidden" name="wxzy.zyid" value="<s:property value="wxzy.zyid" />">
		<input type="hidden" name="wxzy.rwdid" value="<s:property value="wxzy.rwdid" />" />
		<input  type="hidden" id="dejs" value="<s:property value="wxzy.dejs" />" /><!-- 定额基数 -->
		<input  type="hidden" id="srz" value="" /><!-- 用户输入值 -->
		<input  type="hidden" id="xsz" value="" /><!-- 当前显示值 -->
		<input type="hidden" id="yhlxdj" name="wxzy.dj" value="<s:property value="wxzy.dj" />" />
		<s:if test="!ddWxzy">
			<input id="xmmcid" type="hidden" name="wxzy.yhid" value="<s:property value="wxzy.yhid" />" />
		</s:if>
		
		<input id="rwdbmcodeid" type="hidden" name="wxzy.bmcode" value="<s:property value="wxzy.bmcode" />" />
		<div class="datagrid-body" style="overflow-x:hidden">	
			<table id="mytable" class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
			<tr class="datagrid-row">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>记录人</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input name="wxzy.jlusername" type="hidden" value='<s:property value="wxzy.jlusername" />' />
						<s:property value="wxzy.jlryname"/>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>完工时间</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!show">
							<input class="easyui-datetimebox" name="wxzy.wgtime" data-options="
								value:'<s:property value="wxzy.wgtime" />'
							" />
						</s:if>
						<s:else>
							<s:property value="wxzy.wgtime" />
						</s:else>
						
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>作业单位</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input readonly="readonly"  value="<s:property value="wxzy.bmname" />" />
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'></div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>项目名称</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!ddWxzy">
							<input  type="text" readonly="readonly" value="<s:property value="wxzy.yhname" />" >
						</s:if>
						<s:else>
							<%-- <input  type="text" readonly="readonly" value="<s:property value="wxzy.yhname" />" > --%>
							<input id="xmmcid" type="text" name="wxzy.yhid" errorInfo="请选择项目名称" class="easyui-combotree notnull"
									data-options=" 
				                    	<%-- url:'${pageContext.request.contextPath}/rcyh/wxzy_getYhlxTree.do',  --%>
				                    	url:'/hmglyh/template/yhlxtree.json',
				                    	idField:'yhid', 
				                        textField:'yhname', 
				                        clickNodeForSpan:true,
				                        width:150,
										panelWidth:290,
				                        onSelect:function(node){ 
				                           var yhid = node.id;
				                           var bmcode = $('#rwdbmcodeid').val();
				                           rwdCalculate(bmcode,yhid);
				                       } 
				               		 "/>
						</s:else>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>作业数量</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input id="zysl" readonly="readonly" style="width:50px;" class="int notnull" errorInfo="作业数量填写不正确" name="wxzy.sl" value="<s:property value="wxzy.sl" />"/>
						<span id="dwSpan"><s:property value="wxzy.dw" /></span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>工日定额</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input id="grde" readonly="readonly" errorInfo="请填写有效的工日定额" onblur="reCalculate2()" type="text"  class="int notnull"  name="wxzy.grde" value="<s:property value="wxzy.grde" />" />
					</div>
				</td>
				<td>
					<div  style='height:auto;text-align:center' class='datagrid-cell'>工日</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input id="zgr" readonly="readonly" errorInfo="工日填写错误" type="text" class="int notnull"  name="wxzy.jhgr" value="<s:property value="wxzy.jhgr" />" /> 
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>验收状态</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="ddWxzy">
							未验收
						</s:if>
						<s:else>
							<s:property value="wxzy.ysztname" />
							<input type="hidden" name="wxzy.yszt" value="<s:property value="wxzy.yszt" />"  />
						</s:else>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>上报状态</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:property value="wxzy.zysbztname" />
						<input type="hidden" name="wxzy.zysbzt" value="<s:property value="wxzy.zysbzt" />">
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'></div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						
					</div>
				</td>
				
			</tr>
			<tr>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>路段</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="ddWxzy or update">
							<input id="ldCombobox" class="easyui-combobox"  name="wxzy.ldcode" data-options="
										url:'${pageContext.request.contextPath}/lxld/getLxldCombo.do?bmCode=<s:property value="user.bmcode" />',
										textField:'text',
										valueField:'id',
										<s:if test="wxzy.ldcode != null" >
										onLoadSuccess:function(){
											$('#ldCombobox').combobox('setValue','<s:property value="wxzy.ldcode" />');
										}
										</s:if>
										" />
						</s:if>
						<s:else>
							<s:property value="wxzy.ldname"/>
							<input type="hidden" name="wxzy.ldcode" value="<s:property value="wxzy.ldcode" />" />
						</s:else>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>方向
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!show">
							<input type="text" class="easyui-combobox"  data-options="
							<s:if test="update">
							url:'${pageContext.request.contextPath}/rcyh/bh_fxList.do?selectFirst=false',
							</s:if>
							<s:else>
							url:'${pageContext.request.contextPath}/rcyh/bh_fxList.do',
							</s:else>
							panelHeight:'auto',
							textField:'value',
							valueField:'key',
							<s:if test = "wxzy.tq != null " >
							value:'<s:property value="wxzy.tq" />',
							</s:if>
							" type="text"  name="wxzy.tq" />
						</s:if>
						<s:else>
							<s:property value="wxzy.tq" />
						</s:else>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>起点桩号</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					K<input class="int notnull"  errorInfo="起点桩号KM必填且只能为数字" style="width: 70px;" type="text" name="wxzy.szhhkm" value="<s:property value="wxzy.szhhkm" />" /> 
					  +
					 <input class="int notnull" errorInfo="起点桩号M必填且只能为数字" style="width: 70px;" type="text" name="wxzy.szhhm" value="<s:property value="wxzy.szhhm" />" /> 
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>止点桩号</span> 
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					K<input  errorInfo="止点桩号KM只能为数字" class="int" style="width: 70px;" type="text" name="wxzy.ezhhkm" 
					value="<s:if test="wxzy.ezhhkm == -1 "></s:if><s:else><s:property value="wxzy.ezhhkm" /></s:else>" /> 
					  +
					 <input  errorInfo="止点桩号M只能为数字" class="int" style="width: 70px;" type="text" name="wxzy.ezhhm" 
					 value="<s:if test="wxzy.ezhhm == -1 "></s:if><s:else><s:property value="wxzy.ezhhm" /></s:else>" />
					 </div>
				</td>
			</tr>
			
			<tr class="datagrid-row qshrow qlrow" 
					<s:if test="wxzy.qlcode == null or wxzy.qlcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>桥梁名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
								<input type="hidden" name="wxzy.qlname" value="<s:property value="wxzy.qlname" />" />
								<input type="hidden" name="wxzy.qlcode" value="<s:property value="wxzy.qlcode" />" />
								<s:property value="wxzy.qlname"/>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
				<tr class="datagrid-row qshrow sdrow" 
					<s:if test="wxzy.sdcode == null or wxzy.sdcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>隧道名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input type="hidden" name="wxzy.sdname" value="<s:property value="wxzy.sdname" />" />
							<input type="hidden" name="wxzy.sdcode" value="<s:property value="wxzy.sdcode" />" />
							<s:property value="wxzy.sdname"/>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
				<tr  class="datagrid-row qshrow hdrow"
					<s:if test="wxzy.hdcode == null or wxzy.hdcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>涵洞名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input type="hidden" name="wxzy.hdname" value="<s:property value="wxzy.hdname" />" />
							<input type="hidden" name="wxzy.hdcode" value="<s:property value="wxzy.hdcode" />" />
							<s:property value="wxzy.hdname"/>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
			
			<tr>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>备注</div>
				</td>
				<td colspan="7">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input  errorInfo="备注字符超出限制" type="text" class="text" type="text"  name="wxzy.bz" value="<s:property value="wxzy.bz" />" />
					</div>
				</td>
			</tr>
			<tr class="datagrid-row">
				<td colspan="8">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<div class="datagrid-body">
						<table id="rytable" class="form_table datagrid-btable">
							<tr class="datagrid-row">	
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>人员姓名</div>
								</td>
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>人员工程量</div>
								</td>
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>人员工日</div>
								</td>
								<s:if test="!show">
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>操作</div>
									</td>
								</s:if>
								
							</tr>
							<s:iterator value="wxzy.ryzys" id="ry" status="status" >
								<tr class="datagrid-row ry-row">	
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>
											<input type="text" readonly="readonly" class="rynameCls" value="<s:property value="#ry.ryname" />" />
											<input name="wxzy.ryzys[<s:property value="#status.index" />].ryid" type="hidden" class="ryidCls" value="<s:property value="#ry.ryid" />" />
										</div>
									</td>
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>
											<input id="wcgcl" errorInfo="<s:property value="#ry.ryname" />的完成工程量填写错误" name="wxzy.ryzys[<s:property value="#status.index" />].wcgcl" class="rygclCls int notnull" onfocus="pgslFocus(this)" onblur="pgslBlur(this)" type="text" value="<s:property value="#ry.wcgcl" />"/>
										</div>
									</td>
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>
											<input id="wcgr" onblur="rygrBlur()" errorInfo="<s:property value="#ry.ryname" />的完成工日填写错误" name="wxzy.ryzys[<s:property value="#status.index" />].wcgr" class="rygrCls int notnull" type="text" value="<s:property value="#ry.wcgr" />">
										</div>
									</td>
									<s:if test="!show">
										<td>
											<div style='height:auto;text-align:center' class='datagrid-cell'>
												<a href="javascript:void(0)" onclick="delRyTr(this)">删除</a>
											</div>
										</td>
									</s:if>
									
								</tr>
							</s:iterator>
						</table>
					</div>
						<s:if test="!show">
							<a onclick="addPeople()" class="easyui-linkbutton" data-options="plain:true">添加人员</a>
						</s:if>
					</div>
				</td>
			</tr>
			<s:if test="!show">
			<tr class="datagrid-row">
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>材料消耗</span>
					</div>
				</td>
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="jhclxh" type="text"	class="easyui-combotree"
					data-options=" 
                   <%--  url:'${pageContext.request.contextPath}/rcyh/wxzy_getGljclTree.do', --%>
                    url:'/hmglyh/template/clgljtree.json',
                    checkbox:true,
                    lines:true,
                    <s:if test="show">
                    disabled:true,
                    </s:if>
                    multiple:true,
                    panelHeight:150,
                    panelWidth:250,
                    clickNodeForSpan:true
                " />
                	 <s:if test="!show">
						<a data-options="plain:true" class="easyui-linkbutton" onclick="addJhclxh()">添加</a>                	 
                	 </s:if>
					</div>
				</td>
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>机械消耗</span>
					</div>
				</td>
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="jhjxxh" class="easyui-combotree"
						data-options=" 
	                  <%--   url:'${pageContext.request.contextPath}/rcyh/wxzy_getGljjxTree.do', --%>
	                    url:'/hmglyh/template/jxgljtree.json',
	                    checkbox:true,
	                    lines:true,
	                    <s:if test="show">
	                    disabled:true,
	                    </s:if>
	                    multiple:true,
	                    panelHeight:150,
                        panelWidth:250,
	                    clickNodeForSpan:true
	                " />
		                <s:if test="!show">
		                		<a class="easyui-linkbutton" onclick="addJhjxxh()" data-options="plain:true">添加</a>
		                </s:if>
					 </div>
				</td>
			</tr>
			</s:if>
				<tr class="datagrid-row">
					<td colspan="4" id="jhclxh_td" style="vertical-align:top">
						<div style='height:auto;text-align:center' class='datagrid-cell'>
						<div class="jhxh_div datagrid-body" style="display:block;" >
							<table id="jhclxhTable" class='mytable' style="width:100%">
								<tr>
									<td><div style='height:auto;text-align:center' class='datagrid-cell'>材料名称</div></td>
									<td><div style='height:auto;text-align:center' class='datagrid-cell'>编码</div></td>
									<td><div style='height:auto;text-align:center' class='datagrid-cell'>单价</div></td>
									<td><div style='height:auto;text-align:center' class='datagrid-cell'>规格</div></td>
									<td><div style='height:auto;text-align:center' class='datagrid-cell'>数量</div></td>
									<s:if test="!show" >
											<td><div style='height:auto;text-align:center' class='datagrid-cell'>操作</div></td>
									</s:if>
								</tr>
								<s:iterator value="wxzy.cls" id="cljxxh" status="status">
										<tr class='mytr data-row'>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<input type='hidden' name='wxzy.cls[<s:property value="#status.index" />].lxid' value='<s:property value="#cljxxh.lxid" />' />
													<a title="<s:property value="#cljxxh.lxname" />"><s:property value="#cljxxh.lxname" /></a>
												</div>
											</td>
											<td  >
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<s:property value="#cljxxh.bm" />
												</div>
											</td>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<input  class='gljdj' id='<s:property value="cljxxh.lxid" />_td' readonly="readonly" name='wxzy.cls[<s:property value="#status.index" />].dj' value="<fmt:formatNumber value="${cljxxh.dj}" pattern="0.00" />" type='text' />
												</div>
											</td>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<s:property value="#cljxxh.gg" />
												</div>
											</td>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<input desl="<s:property value="#cljxxh.sl" />" errorInfo="材料数量填写不正确" name='wxzy.cls[<s:property value="#status.index" />].sl' class='gljsl int notnull' onblur="gljslblur(this,'<s:property value="#cljxxh.lxid" />')" type='text' desl='0' value='<s:property value="#cljxxh.sl" />' style='width:50px;' />
													<s:property value="#cljxxh.dw" />
												</div>
											</td>
											<s:if test="!show">
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<a href="javascript:void(0)" onclick='delRows(this,"<s:property value="#cljxxh.lxid" />")' >删除</a> 
													</div>
												</td>
											</s:if>
										</tr>
								</s:iterator>
							</table>
						</div>
						</div>
					</td>
					<td colspan="4" id="jhjxxh_td" style="vertical-align:top">
						<div style='height:auto;text-align:center' class='datagrid-cell'>
						<div class="jhxh_div datagrid-body" style="display:block;">
							<table id="jhjxxhTable" class='mytable' style="width:100%">
							<tr>
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>机械名称</div>
								</td>
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>编码</div>
								</td>
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>单价</div>
								</td>
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>规格</div>
								</td>
								<td>
									<div style='height:auto;text-align:center' class='datagrid-cell'>数量</div>
								</td>
								<s:if test="!show">
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>操作</div>
									</td>
								</s:if>
							</tr>
								
								<s:iterator value="wxzy.jxs" id="cljxxh" status="status">
								
										<tr class='mytr data-row'>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<a title="<s:property value="#cljxxh.lxname" />"><s:property value="#cljxxh.lxname" /></a>
													<input type='hidden' name='wxzy.jxs[<s:property value="#status.index" />].lxid' value='<s:property value="#cljxxh.lxid" />' />
												</div>
												</td>
												<td >
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<s:property value="#cljxxh.bm" />
													</div>
												</td>
												<td >
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<input  class='gljdj'  id='<s:property value="cljxxh.lxid" />_td' readonly="readonly" name='wxzy.jxs[<s:property value="#status.index" />].dj' value="<fmt:formatNumber value="${cljxxh.dj}" pattern="0.00" />" type='text' />
													</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<s:property value="#cljxxh.gg" />
													</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<input desl="<s:property value="#cljxxh.sl" />" name='wxzy.jxs[<s:property value="#status.index" />].sl' errorInfo="机械消耗数量填写不正确" class='gljsl int notnull' onblur="gljslblur(this,'<s:property value="#cljxxh.lxid" />')" type='text' desl='0' value='<s:property value="#cljxxh.sl" />' style='width:50px;' />
														<s:property value="#cljxxh.dw" />
													</div>
												</td>
												<s:if test="!show">
													<td>
														<div style='height:auto;text-align:center' class='datagrid-cell'>
															<a href="javascript:void(0)"  onclick='delRows(this,"<s:property value="#cljxxh.lxid" />")'>删除</a>
														</div>
													</td>
												</s:if>
											</tr>
									
								</s:iterator>
							</table>
						</div>
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>人工单价</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="rgdj" readonly="readonly" type="text" value="<fmt:formatNumber value="${wxzy.rgdj}" pattern="0.00" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>人工费(元)</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="rgf"  errorInfo="人工费填写错误" class="money" type="text" name="wxzy.rgf" value="<fmt:formatNumber value="${wxzy.rgf}" pattern="0.00" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>材料费(元)</span>
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input id="clfTotal"  errorInfo="材料费填写错误" class="money" type="text" name="wxzy.clf" value="<fmt:formatNumber value="${wxzy.clf}" pattern="0.00" />" />
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>机械费(元)</span>
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input id="jxfTotal"  errorInfo="机械费填写错误" class="money" type="text" name="wxzy.jxf" value="<fmt:formatNumber value="${wxzy.jxf}" pattern="0.00" />" />
						</div>
					</td>
			</tr>
			<s:if test="!show">
				<tr>
						<td colspan="8">
							<div style='height:auto;text-align:center' class='datagrid-cell'>
									<form>
										<input id="file_upload1" name="file_upload" type="file" multiple="true">
									</form>
								<div class="datagrid-body">
									<table id="picTable1" class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
											<tr class="datagrid-row">
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>图片名称</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>大小</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>操作</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>状态</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>描述</div>
												</td>
											</tr>
											<s:iterator value="wxzy.zps" id="zp" status="status">
												<s:if test="#zp.ryid == 1 ">
													<tr class='datagrid-row'>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<input style='text-align:center'  readonly='readonly' type='text' name='bhjl.zps[<s:property value="#status.index" />].zpmc' value="<s:property value="#zp.zpmc" />"></input>
																<input type='hidden' name='wxzy.zps[<s:property value="#status.index" />].zpdz' value='<s:property value="#zp.zpdz" />'>
																<input type='hidden' name='wxzy.zps[<s:property value="#status.index" />].ryid' value='<s:property value="#zp.ryid" />'>
															</div>
														</td>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<input  name='wxzy.zps[<s:property value="#status.index" />].zpdx'  value="<s:property value="#zp.zpdx" />" />
															</div>
														</td>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<a  href='javascript:void(0)'   zpdz='<s:property value="#zp.zpdz" />' fid='<s:property value="#status.index" />' succ='1' style='color:#blue' onclick='delZpRow(this,1)'>删除</a>
																|<a href='<s:property value="#zp.picUrl" />/<s:property value="#zp.zpdz" />' style='color:blue' target='blank' >查看</a>
															</div>
														</td>
														<td style='width:150px;'>
															<div id='<s:property value="#status.index" />-queue1' style='text-align:center' class='datagrid-cell'>
															<span style="color:green">正常</span>
															</div>
														</td>
														<td style='width:300px;'>
															<div  style='text-align:center' class='datagrid-cell'>
																<input  name='wxzy.zps[<s:property value="#status.index" />].zpms'  value="<s:property value="#zp.zpms" />" />
															</div>
														</td>
													</tr>
												</s:if>
											</s:iterator>
									</table>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="8">
							<div style='height:auto;text-align:center' class='datagrid-cell'>
									<form>
										<input id="file_upload2" name="file_upload" type="file" multiple="true">
									</form>
								<div class="datagrid-body">
									<table id="picTable2" class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
											<tr class="datagrid-row">
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>图片名称</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>大小</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>操作</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>状态</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>描述</div>
												</td>
											</tr>
											<s:iterator value="wxzy.zps" id="zp" status="status">
												<s:if test="#zp.ryid == 2 ">
													<tr class='datagrid-row'>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<input style='text-align:center'  readonly='readonly' type='text' name='bhjl.zps[<s:property value="#status.index" />].zpmc' value="<s:property value="#zp.zpmc" />"></input>
																<input type='hidden' name='wxzy.zps[<s:property value="#status.index" />].zpdz' value='<s:property value="#zp.zpdz" />'>
																<input type='hidden' name='wxzy.zps[<s:property value="#status.index" />].ryid' value='<s:property value="#zp.ryid" />'>
															</div>
														</td>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<input  name='wxzy.zps[<s:property value="#status.index" />].zpdx'  value="<s:property value="#zp.zpdx" />" />
															</div>
														</td>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<a  href='javascript:void(0)'   zpdz='<s:property value="#zp.zpdz" />' fid='<s:property value="#status.index" />' succ='1' style='color:#blue' onclick='delZpRow(this,2)'>删除</a>
																|<a href='<s:property value="#zp.picUrl" />/ywimg/<s:property value="#zp.zpdz" />' style='color:blue' target='blank' >查看</a>
															</div>
														</td>
														<td style='width:150px;'>
															<div id='<s:property value="#status.index" />-queue2' style='text-align:center' class='datagrid-cell'>
															<span style="color:green">正常</span>
															</div>
														</td>
														<td style='width:300px;'>
															<div  style='text-align:center' class='datagrid-cell'>
																<input  name='wxzy.zps[<s:property value="#status.index" />].zpms'  value="<s:property value="#zp.zpms" />" />
															</div>
														</td>
													</tr>
												</s:if>
											</s:iterator>
									</table>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="8">
							<div style='height:auto;text-align:center' class='datagrid-cell'>
									<form>
										<div id="queue"></div>
										<input id="file_upload3" name="file_upload" type="file" multiple="true">
									</form>
								<div class="datagrid-body">
									<table id="picTable3" class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
											<tr class="datagrid-row">
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>图片名称</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>大小</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>操作</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>状态</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>描述</div>
												</td>
											</tr>
											<s:iterator value="wxzy.zps" id="zp" status="status">
												<s:if test="#zp.ryid == 3 ">
													<tr class='datagrid-row'>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<input style='text-align:center'  readonly='readonly' type='text' name='bhjl.zps[<s:property value="#status.index" />].zpmc' value="<s:property value="#zp.zpmc" />"></input>
																<input type='hidden' name='wxzy.zps[<s:property value="#status.index" />].zpdz' value='<s:property value="#zp.zpdz" />'>
																<input type='hidden' name='wxzy.zps[<s:property value="#status.index" />].ryid' value='<s:property value="#zp.ryid" />'>
															</div>
														</td>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<input  name='wxzy.zps[<s:property value="#status.index" />].zpdx'  value="<s:property value="#zp.zpdx" />" />
															</div>
														</td>
														<td>
															<div style='text-align:center' class='datagrid-cell'>
																<a  href='javascript:void(0)'   zpdz='<s:property value="#zp.zpdz" />' fid='<s:property value="#status.index" />' succ='1' style='color:#blue' onclick='delZpRow(this,3)'>删除</a>
																|<a href='<s:property value="#zp.picUrl" />/<s:property value="#zp.zpdz" />' style='color:blue' target='blank' >查看</a>
															</div>
														</td>
														<td style='width:150px;'>
															<div id='<s:property value="#status.index" />-queue3' style='text-align:center' class='datagrid-cell'>
															<span style="color:green">正常</span>
															</div>
														</td>
														<td style='width:300px;'>
															<div  style='text-align:center' class='datagrid-cell'>
																<input  name='wxzy.zps[<s:property value="#status.index" />].zpms'  value="<s:property value="#zp.zpms" />" />
															</div>
														</td>
													</tr>
												</s:if>
											</s:iterator>
									</table>
								</div>
							</div>
						</td>
					</tr>
			</s:if>
		</table>
		</div>
	</form>
	<s:if test="add">
		<center style="padding-top:5px"><a class="easyui-linkbutton" onclick="$('#fm').submit()" data-options="plain:true">保存</a></center>
	</s:if>
	<s:if test="update">
		<center style="padding-top:5px">
		<a class="easyui-linkbutton" onclick="$('#fm').submit()" data-options="plain:true">更新</a>
		</center>
	</s:if>
	
	<script>
	<s:if test="show" >
		$("input").attr("readonly","readonly");
	</s:if>
	
	/* var values = $("input[type='hidden']");
	$.each(values,function(i,d){
		$("body").append("<span>"+$(d).attr("name")+":"+$(d).attr("value")+"</span><br>");
	}); */
	

	
	var uploadSucc = function(file,strData,index){
		var jsonData = eval("(" + strData + ")");
	
		var zpdz = $("#myfile-"+file.id+index);
		var delButton = $("#"+file.id + "-del" + index );
		var picButton = $("#"+file.id + "-pic" + index );
		var ztTD = $("#"+file.id+"-queue"+index);
		
		zpdz.val(jsonData.rname);
		delButton.attr("zpdz",jsonData.rname); 
		delButton.attr("succ","1"); 
		delButton.css("color","blue"); 
		delButton.html("删除");
		picButton.css("color","blue"); 
		picButton.attr("href",jsonData.picUrl+"/"+jsonData.rname);
		ztTD.html("<span style='color:green;'>成功</span>");
	
	}
	var i=0;
	var uploadStart =function(file,index) {
					var zplx = 1;
					if( index == 1 ){ 
						zplx = 1;
					}else if( index == 2 ){
						zplx = 2;
					}else if( index == 3 ){
						zplx = 3;
					}else {
						console.error("uploadStart error!");
						return;
					}
		
					var html = "<tr class='datagrid-row'>"+
					"<td>"+
						"<div style='text-align:center' class='datagrid-cell'>"+
							"<input style='text-align:center'  readonly='readonly' type='text' name='wxzy.zps["+i+"].zpmc' value="+file.name + "></input>" +  
							"<input id='myfile-"+file.id+index+"' type='hidden' name='wxzy.zps["+i+"].zpdz' value=''>"+
							"<input type='hidden' name='wxzy.zps["+i+"].ryid' value='"+zplx+"'>"+
						"</div>"+
					"</td>" +
					"<td>"+
						"<div style='text-align:center' class='datagrid-cell'>"+
						"<input readonly='readonly'  name='wxzy.zps["+i+"].zpdx'  value="+ (	(file.size / 1024 / 1024) .toFixed(2) )+ 'MB' +"></input>"+
						"</div>"+
					"</td>"+
					"<td>"+
						"<div style='text-align:center' class='datagrid-cell'>"+
							"<a  id='"+file.id+"-del"+index+"' zpdz='0' fid='"+file.id+"' succ='0' href='javascript:void(0);'  style='color:#f00' onclick=delZpRow(this,"+index+")>取消上传</a>"+
							"|<a id='"+file.id+"-pic"+index+"' href='javascript:void(0)' style='color:#ccc' target='blank' >查看</a>"+
						"</div>"+
					"</td>"+
					"<td style='width:150px;'>"+
						"<div id='"+file.id+"-queue"+index+"' style='text-align:center' class='datagrid-cell'>"+
						"</div>"+
					"</td>"+
					"<td style='width:300px;'>"+
					"<div style='text-align:center' class='datagrid-cell'>"+
						"<input  type='text' name='wxzy.zps["+i+"].zpms' ></input>"+
					"</div>"+
				"</td>"+
					"</tr>";
					$("#picTable"+index).append(html);
					i++;
	}
	
	var uploadProgress = function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal,index) {
		
		bytesTotal = Math.round(bytesTotal / 1024);
		bytesUploaded = Math.round(bytesUploaded / 1024);
		var suffixTotal   = 'KB';
		var suffixUploaded   = 'KB';
		if (bytesTotal > 1000) {
			bytesTotal = Math.round(bytesTotal / 1000);
			suffixTotal   = 'MB';
		}
		if (bytesUploaded > 1000) {
			bytesUploaded = Math.round(bytesUploaded / 1000);
			suffixUploaded   = 'MB';
		}
		
		bytesTotal = parseInt(bytesTotal);
		bytesUploaded = parseInt(bytesUploaded);
		
		$('#'+file.id + '-queue'+index).html(bytesUploaded + suffixUploaded + ' / ' + bytesTotal + suffixTotal);
    }
	
	var uploadError =  function(file, errorCode, errorMsg, errorString,index) {
					    	$('#'+file.id + '-queue'+index).html("<span style='color:red'>上传失败:"+errorMsg+"</span>");
					   }
	
	
	$(function() {
	  	$('#file_upload1').uploadify({
			'formData'     : {
				'timestamp' : '<%=new Date().getTime()%>',
				'token'     : '<%=MD5Util.MD5(new Date().getTime()+"")%>',
			},
			'buttonText':'上传维修前图片',
			'width':100,
			'height':20,
			'swf'      : '/hmglyh/uploadify.swf',
			'uploader' : '/hmglyh/up',
			//'fileSizeLimit':'5mb',
			//'fileTypeExts':'*.jpeg;*.jpg; *.png;*.gif',
			'onUploadSuccess':function(file,strData){
				uploadSucc(file,strData,1);
			},
			'onUploadStart':function(file){
				uploadStart(file,1);
			},
			'onUploadProgress' :function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal){
				uploadProgress(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal,1);
			},
	        'onUploadError' :function(file, errorCode, errorMsg, errorString){
	        	uploadError(file, errorCode, errorMsg, errorString,1);	
	        }
		});
	  	
	  	$('#file_upload2').uploadify({
			'formData'     : {
				'timestamp' : '<%=new Date().getTime()%>',
				'token'     : '<%=MD5Util.MD5(new Date().getTime()+"")%>',
			},
			'width':100,
			'height':20,
			'swf'      : '/hmglyh/uploadify.swf',
			'uploader' : '/hmglyh/up',
			'buttonText':'上传维修中图片',
			//'fileSizeLimit':'5mb',
			//'fileTypeExts':'*.jpeg;*.jpg; *.png;*.gif',
			'onUploadSuccess':function(file,strData){
				uploadSucc(file,strData,2);
			},
			'onUploadStart':function(file){
				uploadStart(file,2);
			},
			'onUploadProgress' :function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal){
				uploadProgress(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal,2);
			},
	        'onUploadError' :function(file, errorCode, errorMsg, errorString){
	        	uploadError(file, errorCode, errorMsg, errorString,2);	
	        }
		});
	  	
	  	$('#file_upload3').uploadify({
			'formData'     : {
				'timestamp' : '<%=new Date().getTime()%>',
				'token'     : '<%=MD5Util.MD5(new Date().getTime()+"")%>',
			},
			'width':100,
			'height':20,
			'swf'      : '/hmglyh/uploadify.swf',
			'uploader' : '/hmglyh/up',
			'buttonText':'上传维修后图片',
			//'fileSizeLimit':'5mb',
			//'fileTypeExts':'*.jpeg;*.jpg; *.png;*.gif',
			'onUploadSuccess':function(file,strData){
				uploadSucc(file,strData,3);
			},
			'onUploadStart':function(file){
				uploadStart(file,3);
			},
			'onUploadProgress' :function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal){
				uploadProgress(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal,3);
			},
	        'onUploadError' :function(file, errorCode, errorMsg, errorString){
	        	uploadError(file, errorCode, errorMsg, errorString,3);	
	        }
		});
	 });
	
	
	
	function addPeople(){
		parent.gisui.createWindow({
			title:"添加人员",
			id:'addRy',
			iconCls:"icon-page",
			modal:true,
			top:100,
			width:500,
			height:250,
			src:"/hmglyh/rcyh/wxzy_addRys.do"
		});
	}
	
	</script>
</body>
</html>