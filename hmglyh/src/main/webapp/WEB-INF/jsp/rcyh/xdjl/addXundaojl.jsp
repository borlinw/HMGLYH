<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script>
 	
 	function addBh(){
 		var num = $("#bh").find("tr").length;
 		
		$("#bh").append(
				"<tr id='trlrt" + num + "'>"+
				"<td style='width: 30px; text-align: center;'>"+ num +"</td>"+
				"<td style='width: 130px; text-align: center;'>"+
					"<div style='height:auto;text-align:center' class='datagrid-cell'>"+
						"K<input id='szhh0' onblur='getQshCombobox()' errorInfo='起点桩号KM必填且只能为数字' class='notnull int' type='text' style='width:50px;border:1px solid #ccc;' name='bhjl.szhhkm'/> +"+
						"<input id='szhh1'  onblur='getQshCombobox()' errorInfo='起点桩号必填且只能数字' class='notnull int' type='text' style='width:50px;border:1px solid #ccc;'  name='bhjl.szhhm'/>"+
					"</div>"+
				"</td>"+
				"<td style='width: 130px; text-align: center;'>"+
					"<div style='height:auto;text-align:center' class='datagrid-cell'>"+
						"K<input id='ezhh0' onblur='getQshCombobox()' errorInfo='止点桩号KM只能为数字' class='int' type='text' style='width:50px;border:1px solid #ccc;' name='bhjl.ezhhkm' /> + "+
						"<input id='ezhh1'  onblur='getQshCombobox()' errorInfo='止点桩号M只能为数字' class='int' type='text' style='width:50px;border:1px solid #ccc;' name='bhjl.ezhhm' /> "+
					"</div>"+
				"</td>"+
				"<td style='width: 30px; text-align: center;'>"+
					"<input style='width:100%'/>"+
				"</td>"+
				"<td style='width: 130px; text-align: center;'>"+
					"<input id='bhlxtree"+num+"' class='easyui-combotree notnull' errorInfo='请选择病害类型'"+
						"  type='text' name='bhjl.bhid' /> " + 
				"</td>"+
				"<td style='width: 150px; text-align: center;'>"+
					"<input style='width:100%'/>"+
				"</td>"+
				"<td style='width: 50px; text-align: center;'>"+
					"<select>"+
							"<option value = '是'>是</option>"+
							"<option value = '否'>否</option>"+
					"</select>"+
				"</td>"+
				"<td style='width: 80px; text-align: center;'>"+
					"<input type='button' style='width: 50%; height: 40%' value='删除' onclick='deleteBh("+ num +");'>"+
				"</td>"+
			"</tr>"
		);
		
		$("#bhlxtree"+num).attr();
	}
 	
 	function deleteBh(id) {
		$("#trlrt"+id).remove("data-options","width:'100%', url:'/hmglyh/template/bhlxtree.json' ");
		
	}
 </script>
<title></title>
</head>
<body>
	
	<form id="fm"
		<s:if test="add">
			action="/hmglyh/rcyh/xdjl_saveXdjl.do"
		</s:if>
		<s:if test="update">
			action="/hmglyh/rcyh/xdjl_saveUpdateXdjl.do"
		</s:if>
	method="post">
	<div class="datagrid-body">
		<input type="hidden" name="xcsj.bmcode" value="<s:property value='xcsj.bmcode' />"> 
		<input type="hidden" name="xcsj.xcid" value="<s:property value='xcsj.xcid' />"> 
		<input type="hidden" name="xcsj.username" value="<s:property value='xcsj.username' />">
		<table class="form_table datagrid-btable" cellpadding=0 cellspacing=0>
			<tr class="datagrid-row">
				<td><div style='height: auto; text-align: center' class='datagrid-cell'>巡查时间</div></td>
				<td><div style='height: auto; text-align: center' class='datagrid-cell'>
					<s:if test="!show">
						<input class="easyui-datetimebox" data-options="value:'<s:property value="xcsj.stime" />' " name="xcsj.stime" />
					</s:if>
					<s:else>
						<s:property value="xcsj.stime" />
					</s:else>
					-
					<s:if test="!show">
						<input class="easyui-datetimebox" data-options="value:'<s:property value="xcsj.etime" />' " name="xcsj.etime" />
					</s:if>
					<s:else>
						<s:property value="xcsj.etime" />
					</s:else>
					</div>
				</td>
				
				<td><div readonly="readonly" style='height: auto; text-align: center'class='datagrid-cell'>巡查单位</div></td>
				<td>
					<s:if test="show">
						<div  style='height:auto; font-weight: normal; font-size: 12px;padding:2px 2px'>
							<s:property value="xcsj.bz" />
						</div>
					</s:if>
					<s:else>
						<input style="width:100%" name="xcsj.bz" value="<s:property value="xcsj.bz" />" />
					</s:else>
				</td>
				
			
				<td><div style='height: auto; text-align: center' class='datagrid-cell'>天气</div></td>
				<td>
					<div style='height: auto; text-align: center'  class='datagrid-cell'>
						<s:if test="!show">
							<input id="xctq" errorInfo="请选择天气" class="easyui-combobox notnull" name="xcsj.tq"
								data-options="
								textField:'value',
								valueField:'key',
								<s:if test="update">
									onLoadSuccess:function(){
										$('#xctq').combobox('setValue','<s:property value="xcsj.tq" />')
									},
								</s:if>
									panelHeight:'auto',
									url:'${pageContext.request.contextPath}/rcyh/xdjl_tqList.do'
							">
						</s:if>
						<s:else>
							<s:property value="xcsj.tq" />
						</s:else>
					</div>
				</td>
			</tr>
			<tr class="datagrid-row">
				<td><div readonly="readonly" style='height: auto; text-align: center'class='datagrid-cell'>巡查车辆</div></td>
				<td>
					<s:if test="show">
						<div  style='height:auto; font-weight: normal; font-size: 12px;padding:2px 2px'>
							<s:property value="xcsj.bz" />
						</div>
					</s:if>
					<s:else>
						<input style="width:100%" name="xcsj.bz" value="<s:property value="xcsj.bz" />" />
					</s:else>
				</td>
					<td><div style='height: auto; text-align: center' class='datagrid-cell'>巡查路段</div></td>
				<td>
					<div style='height: auto; text-align: center' class='datagrid-cell'>
					<s:if test="show">
						<s:property value="xcsj.xsld" />
					</s:if>
					<s:else>
						<input id="xcld" errorInfo="请选择巡查路段" class="easyui-combobox notnull" name="xcsj.xsld"
							data-options="
							valueField:'text',
							textField:'text',
							editable:true,
							<s:if test="update">
							onLoadSuccess:function(){
								$('#xcld').combobox('setValue','<s:property value="xcsj.xsld" />')
							},
							</s:if>
								url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlLds.do'
										" />
							</s:else>
					</div>
				</td>
				<td><div readonly="readonly" style='height: auto; text-align: center'class='datagrid-cell'>巡查类型</div></td>
				<td>
					<div style='height: auto; text-align: center'  class='datagrid-cell'>
						<s:if test="!show">
							<input id="xctq" errorInfo="请选择天气" class="easyui-combobox notnull" name="xcsj.tq"
								data-options="
								textField:'value',
								valueField:'key',
								<s:if test="update">
									onLoadSuccess:function(){
										$('#xctq').combobox('setValue','<s:property value="xcsj.tq" />')
									},
								</s:if>
									panelHeight:'auto',
									url:'${pageContext.request.contextPath}/rcyh/xdjl_tqList.do'
							">
						</s:if>
						<s:else>
							<s:property value="xcsj.tq" />
						</s:else>
					</div>
				</td>
			</tr>
			
			
			<tr class="datagrid-row">
				<td><div readonly="readonly" style='height: auto; text-align: center'class='datagrid-cell'>备注</div></td>
				<td colspan="5">
					<s:if test="show">
					<div  style='height:auto; font-weight: normal; font-size: 12px;padding:2px 2px'>
						<s:property value="xcsj.bz" />
					</div>
					</s:if>
					<s:else>
						<input style="width:100%" name="xcsj.bz" value="<s:property value="xcsj.bz" />" />
					</s:else>
				</td>
			</tr>
			<tr class="datagrid-row">
				<td><div style='height: auto; text-align: center' class='datagrid-cell'>巡查人</div></td>
				<td>
					<div style='height: auto; text-align: center' class='datagrid-cell'>
						<s:if test="!show">
							<input errorInfo="请选择记录人" name="xcsj.jlr" class="easyui-combobox notnull"
								data-options="
								<s:if test="xcsj.jlr != null" >
								value:'<s:property value="xcsj.jlr"/>',
								</s:if>
								panelHeight:'auto',
								url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlYhs.do'
							" />
						</s:if>
						<s:else>
							<s:property value="xcsj.jlr"/>
						</s:else>
					</div>
				</td>
				<td><div style='height: auto; text-align: center' class='datagrid-cell'>记录人</div></td>
				<td>
					<div style='height: auto; text-align: center' class='datagrid-cell'>
						<s:if test="!show">
							<input errorInfo="请选择记录人" name="xcsj.jlr" class="easyui-combobox notnull"
								data-options="
								<s:if test="xcsj.jlr != null" >
								value:'<s:property value="xcsj.jlr"/>',
								</s:if>
								panelHeight:'auto',
								url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlYhs.do'
							" />
						</s:if>
						<s:else>
							<s:property value="xcsj.jlr"/>
						</s:else>
					</div>
				</td>
				<td><div style='height: auto; text-align: center' class='datagrid-cell'>负责人</div></td>
				<td>
					<div style='height: auto; text-align: center' class='datagrid-cell'>
					<s:if test="!show">
						<input name="xcsj.fzr" errorInfo="请选择负责人"
							value="<s:property value="user.username" />"
							class="easyui-combobox notnull"
							data-options="
							<s:if test="xcsj.fzr != null" >
							value:'<s:property value="xcsj.fzr"/>',
							</s:if>
							panelHeight:'auto',
							url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlYhs.do'
						" />
					</s:if>
					<s:else>
						<s:property value="xcsj.fzr"/>
					</s:else>
					</div>
				</td>
			</tr>
			
			<tr class="datagrid-row" >
				<td colspan="6">
					<div style='height: auto; text-align: center' class='datagrid-cell'>
						发现问题情况描述、预计工程量
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="增加" style="width:50px" onclick="addBh();">
					</div>
				</td>
			</tr>
			<tr class="datagrid-row" >
				<td colspan="6">
					<table  id="bh" width="100%" style="table-layout:fixed;">
						<tr>
							<td style="width: 30px; text-align: center;">序号</td>
							<td style="width: 130px; text-align: center;">起点桩号</td>
							<td style="width: 130px; text-align: center;">止点桩号</td>
							<td style="width: 30px; text-align: center;">数量</td>
							<td style="width: 130px; text-align: center;">病害类型</td>
							<td style="width: 150px; text-align: center;">现场处置情况</td>
							<td style="width: 50px; text-align: center;">是否需要上报</td>
							<td style="width: 80px; text-align: center;">操作</td>
						</tr>
						<!-- 
						<tr>
							<td style="width: 30px; text-align: center;">1</td>
							<td style="width: 130px; text-align: center;">
								<div style='height:auto;text-align:center' class='datagrid-cell'>
									K<input id="szhh0" onblur="getQshCombobox()" errorInfo="起点桩号KM必填且只能为数字" class="notnull int" type="text" style="width:50px;border:1px solid #ccc;"  name="bhjl.szhhkm"/> +
									<input id="szhh1"  onblur="getQshCombobox()" errorInfo="起点桩号必填且只能数字" class="notnull int" type="text" style="width:50px;border:1px solid #ccc;"  name="bhjl.szhhm"/>
								</div>
							</td>
							<td style="width: 130px; text-align: center;">
								<div style='height:auto;text-align:center' class='datagrid-cell'>
									K<input id="ezhh0" onblur="getQshCombobox()" errorInfo="止点桩号KM只能为数字" class="int" type="text" style="width:50px;border:1px solid #ccc;" name="bhjl.ezhhkm" /> + 
									<input id="ezhh1"  onblur="getQshCombobox()" errorInfo="止点桩号M只能为数字" class="int" type="text" style="width:50px;border:1px solid #ccc;"   name="bhjl.ezhhm" /> 
								</div>
							</td>
							<td style="width: 30px; text-align: center;">
								<input style="width:100%"/>
							</td>
							<td style="width: 130px; text-align: center;">
								<input id="bhlxtree" class="easyui-combotree notnull" errorInfo="请选择病害类型" data-options="
									width:'100%',
									url:'/hmglyh/template/bhlxtree.json'
									" type="text" name="bhjl.bhid" />
							</td>
							<td style="width: 100px; text-align: center;">
								<input style="width:100%"/>
							</td>
							<td style="width: 80px; text-align: center;">
								<select>
  									<option value ="是">是</option>
  									<option value="否">否</option>
								</select>
							</td>
							<td style="width: 80px; text-align: center;">
								<input type="button" style="width: 50%; height: 40%" value="删除">
							</td>
						</tr>
						 -->
					</table>
				</td>
				
			</tr>
			<tr class="datagrid-row">
				<td><div readonly="readonly" style='height: auto; text-align: center'class='datagrid-cell'>图片</div></td>
				<td colspan="5">
					<s:if test="show">
					<div  style='height:auto; font-weight: normal; font-size: 12px;padding:2px 2px'>
						<s:property value="xcsj.bz" />
					</div>
					</s:if>
					<s:else>
						<input style="width:100%" name="xcsj.bz" value="<s:property value="xcsj.bz" />" />
					</s:else>
				</td>
			</tr>
		</table>
	</div>
</form>
	<s:if test="add">
		<center style="padding-top: 5px;">
			<a class="easyui-linkbutton" data-options="plain:true"
				onclick="$('#fm').submit()">保存</a>
		</center>
	</s:if>
	<s:if test="update">
		<center style="padding-top: 5px;">
			<a class="easyui-linkbutton" data-options="plain:true"
				onclick="$('#fm').submit()">更新</a>
		</center>
	</s:if>
	<s:if test="show">
		<center style="padding-top: 5px;">
			<a class="easyui-linkbutton" data-options="plain:true"
				href='${pageContext.request.contextPath}/rcyh/xdjl_exportXdjl.do?xcsj.xcid=<s:property value="xcsj.xcid"/>'>导出</a>
		</center>
	</s:if>
	<script>
	<s:if test="show" >
		$("input").attr("readonly","readonly");
	</s:if>
	
	</script>
</body>
</html>