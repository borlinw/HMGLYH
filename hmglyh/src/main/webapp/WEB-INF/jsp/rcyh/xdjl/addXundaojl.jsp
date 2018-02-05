<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script>
 	
 	var num = $("#bh").find("tr").length+1;
	/**
	function getQshCombobox(){
		var bhid = $("#bhlxtree"+num).combotree("getValue");
	 	if(bhid.match('^04') == '04' 
		|| bhid.match('^05') == '05'
		|| bhid.match('^06') == '06'
		){
	 		var ldcode = $('#ldCombobox').combobox('getValue');
			var szhh0 = $('#szhh0').val();
			var szhh1 = $('#szhh1').val();
			
			if(ldcode == null || ldcode == '') {
				return;
			}
			
			if(szhh0 == null || szhh0 == '' ){
				return;
			}
			
			if(szhh1 == null || szhh1 == '' ){
				return;
			} 
			
			if(bhid.match("^04") == 04 ) {
			//	$('.qlCombobox').combobox('reload',
			//	'/hmglyh/gis/gouzaowu_qlCombobox100.do?ql.roadcode='+ldcode+'&ql.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000));
				$.post('/hmglyh/gis/gouzaowu_qlCombobox100.do?ql.roadcode='+ldcode+'&ql.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000),function(data){
					if(data.length > 0 ) {
						$(".qlCombobox").combobox("loadData",data);
					}else{
						$(".qlCombobox").combobox("clear");
						$(".qlCombobox").combobox("loadData",[]);
					}
				},"json");
			}
			
			if(bhid.match("^05") == 05 ) {
			 //	$('.sdCombobox').combobox('reload',
			 //	'/hmglyh/gis/gouzaowu_sdCombobox100.do?sd.roadcode='+ldcode+'&sd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000));
				$.post('/hmglyh/gis/gouzaowu_sdCombobox100.do?sd.roadcode='+ldcode+'&sd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000),function(data){
					if(data.length > 0 ) {
						$(".sdCombobox").combobox("loadData",data);
					}else{
						$(".sdCombobox").combobox("clear");
						$(".sdCombobox").combobox("loadData",[]);
					}
				},"json");
			}
			
			if(bhid.match("^06") == 06 ) {
				//	$('.hdCombobox').combobox('reload',
				// '/hmglyh/gis/gouzaowu_hdCombobox100.do?hd.roadcode='+ldcode+'&hd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000));
				$.post('/hmglyh/gis/gouzaowu_hdCombobox100.do?hd.roadcode='+ldcode+'&hd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000),function(data){
					if(data.length > 0 ) {
						$(".hdCombobox").combobox("loadData",data);
					}else{
						$(".hdCombobox").combobox("clear");
						$(".hdCombobox").combobox("loadData",[]);
					}
				},"json");
			}
		} 
	}
	
	**/
	
	
 	function addBh(){
 		
		$("#bh").append(
				"<tr id='trlrt" + num + "'>"+
				"<td style='width: 30px; text-align: center;'>"+ num +"</td>"+
				"<td style='width: 130px; text-align: center;'>"+
					"<div style='height:auto;text-align:center' class='datagrid-cell'>"+
						"K<input id='szhh0' onblur='getQshCombobox()' errorInfo='起点桩号KM必填且只能为数字' class='notnull int' type='text' style='width:50px;border:1px solid #ccc;' name='bhjls["+ (num-1) +"].szhhkm'/> +"+
						"<input id='szhh1'  onblur='getQshCombobox()' errorInfo='起点桩号必填且只能数字' class='notnull int' type='text' style='width:50px;border:1px solid #ccc;'  name='bhjls["+ (num-1) +"].szhhm'/>"+
					"</div>"+
				"</td>"+
				"<td style='width: 130px; text-align: center;'>"+
					"<div style='height:auto;text-align:center' class='datagrid-cell'>"+
						"K<input id='ezhh0' onblur='getQshCombobox()' errorInfo='止点桩号KM只能为数字' class='int' type='text' style='width:50px;border:1px solid #ccc;' name='bhjls["+ (num-1) +"].ezhhkm' /> + "+
						"<input id='ezhh1'  onblur='getQshCombobox()' errorInfo='止点桩号M只能为数字' class='int' type='text' style='width:50px;border:1px solid #ccc;' name='bhjls["+ (num-1) +"].ezhhm' /> "+
					"</div>"+
				"</td>"+
				"<td style='width: 30px; text-align: center;'>"+
					"<input style='width:100%;' name='bhjls["+ (num-1) +"].sl'/>"+
				"</td>"+
				"<td style='width: 130px; text-align: center;'>"+
					"<input id='bhlxtree"+num+"' class='easyui-combotree notnull' errorInfo='请选择病害类型'"+
						"  type='text' name='bhjls["+ (num-1) +"].bhid' /> " + 
				"</td>"+
				"<td style='width: 150px; text-align: center;'>"+
					"<input style='width:100%' name='bhjls["+ (num-1) +"].xcczqk' />"+
				"</td>"+
				"<td style='width: 50px; text-align: center;'>"+
					"<select name='bhjls["+ (num-1) +"].isSB'>"+
							"<option value = '1'>是</option>"+
							"<option value = '0'>否</option>"+
					"</select>"+
				"</td>"+
				"<td style='width: 80px; text-align: center;'>"+
					"<s:if test='!show'>"+
					"<input type='button' style='width: 50%; height: 40%' value='删除' onclick='deleteBh("+ num +");'>"+
					"</s:if>"+
				"</td>"+
			"</tr>"
		);
		
		$("#bhlxtree"+num).combotree({
			url: '/hmglyh/template/bhlxtree.json',
			
			
			onBeforeSelect:function(node){
				$('#sldw').html(node.attributes.dw);
			},
			clickNodeForSpan:true,
			onSelect:function(node){
				$('.qshCombobox').combobox('setValue','');
				$('.qshrow').hide();
				if(node.id.match('^04') == '04') { //桥梁
					$('.qlrow').show();
					getQshCombobox();
				}
				
				if(node.id.match('^05') == '05') { //隧道
					$('.sdrow').show();
					getQshCombobox();
				}
			
				if(node.id.match('^06') == '06' ) { // 涵洞
					$('.hdrow').show();
					getQshCombobox();
				}
			}
			
			
		});
		num++;
	}
 	
 	function deleteBh(id) {
		$("#trlrt"+id).remove();
		num--;
		for(var i=1;i<=num;i++){
			$("#bh tr:eq("+ i +") td:eq(0)").empty().append(i);
		}
		
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
		<input type="hidden" name="xcsj.lm" value="<s:property value='xcsj.lm' />">
		<input type="hidden" name="xcsj.lj" value="<s:property value='xcsj.lj' />">
		<input type="hidden" name="xcsj.qsh" value="<s:property value='xcsj.qsh' />">
		<input type="hidden" name="xcsj.yxss" value="<s:property value='xcsj.yxss' />">
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
					<div  style='height:auto; font-weight: normal; font-size: 12px;padding:2px 2px'>
						<s:property value="xcsj.bmname" />
					</div>
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
							<s:property value="xcsj.xscl" />
						</div>
					</s:if>
					<s:else>
						<input style="width:100%" name="xcsj.xscl" value="<s:property value="xcsj.xscl" />" />
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
							<input id="xslx" errorInfo="请选择巡查类型" class="easyui-combobox notnull" name="xcsj.xslx"
								data-options="
								textField:'value',
								valueField:'key',
								<s:if test="update">
									onLoadSuccess:function(){
										$('#xclx').combobox('setValue','<s:property value="xcsj.cxlx" />')
									},
								</s:if>
									panelHeight:'auto',
									url:'${pageContext.request.contextPath}/rcyh/xdjl_lxList.do'
							">
						</s:if>
						<s:else>
							<s:property value="xcsj.xslx" />
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
							<input errorInfo="请选择巡查人" name="xcsj.xcr" class="easyui-combobox notnull"
								data-options="
								<s:if test="xcsj.xcr != null" >
								value:'<s:property value="xcsj.xcr"/>',
								</s:if>
								panelHeight:'auto',
								url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlYhs.do'
							" />
						</s:if>
						<s:else>
							<s:property value="xcsj.xcr"/>
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
						<s:if test="!show">
							<input type="button" value="增加" style="width:50px" onclick="addBh();">
						</s:if>
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
						<s:if test="show">
						
						<s:iterator value="bhjls">
						<tr>
							<td style="width: 30px; text-align: center;">序号</td>
							<td style="width: 130px; text-align: center;"><s:property value="szhhkm" /></td>
							<td style="width: 130px; text-align: center;">止点桩号</td>
							<td style="width: 30px; text-align: center;">数量</td>
							<td style="width: 130px; text-align: center;">病害类型</td>
							<td style="width: 150px; text-align: center;">现场处置情况</td>
							<td style="width: 50px; text-align: center;">是否需要上报</td>
							<td style="width: 80px; text-align: center;">操作</td>
						</tr>
						</s:iterator>
						
						</s:if>
						
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