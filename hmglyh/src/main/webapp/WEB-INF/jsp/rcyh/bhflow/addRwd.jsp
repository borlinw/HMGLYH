<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/calculate.js"></script>
<title>任务派工</title>
</head>
<body>
	
	<form id="fm" method="post"
		<s:if test="add">
			action="${pageContext.request.contextPath}/rcyh/bhflow_saveRwd.do" 
		</s:if>
		<s:if test="update">
			action="${pageContext.request.contextPath}/rcyh/bhflow_saveEditRwd.do" 
		</s:if>
		>
		<s:if test="!show">
			<s:iterator value="bhjls" id="bh" status="status">
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].bhjlid" value="<s:property value="#bh.bhjlid" />" />
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].ldcode" value="<s:property value="#bh.ldcode" />" />
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].xcid" value="<s:property value="#bh.xcid" />" />
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].bhid" value="<s:property value="#bh.bhid" />" />
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].szhhkm" value="<s:property value="#bh.szhhkm" />" />
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].szhhm" value="<s:property value="#bh.szhhm" />" />
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhkm" value="<s:property value="#bh.ezhhkm" />" />
				<input type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhm" value="<s:property value="#bh.ezhhm" />" />
			</s:iterator>
			<input  type="hidden" name="rwd.cjusername" value="<s:property value="rwd.cjusername" />" /> 
			<input  type="hidden" name="rwd.cjtime" value="<s:property value="rwd.cjtime" />" />
			<input  type="hidden" name="bufenYs" value="<s:property value="bufenYs" />" />
			<input  type="hidden" name="fromYdjh" value="<s:property value="fromYdjh" />" />
			<input  type="hidden" name="rwd.fromYdjh" value="<s:property value="fromYdjh" />" />
			<input  type="hidden" name="rwd.rwdid" value="<s:property value="rwd.rwdid" />" />
			<input  type="hidden" id="rgdj" value="<s:property value="rwd.rgdj" />" /><!-- 人工单价 -->
			<input  type="hidden" id="dejs" value="<s:property value="rwd.dejs" />" /><!-- 定额基数 -->
			<input  type="hidden" id="srz" value="<s:property value="rwd.sl" />" /><!-- 用户输入值 -->
			<%-- <input  type="hidden" id="xsz" value="<s:property value="rwd.sl" />" /> --%><!-- 当前显示值 -->
			<input type="hidden" name="rwd.rwbh" value="<s:property value="rwd.rwbh" />" >
		</s:if>		
		<s:token/>
		
		<div class="datagrid-body" style="overflow-x:hidden">
		<table class="form_table datagrid-btable" cellpadding=0 cellspacing=0  id="mytable" >
			<s:if test="(gmap.continue == '' and (!show)) && (!fromYdjh) && (!update)">
				<tr class="datagrid-row">
					<td colspan="8" style="text-align: center">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input  id="pgzt"
						name="rwd.pgzt" class="easyui-combobox"
						data-options=" 
	                    panelHeight:'auto', 
	                    data:[{ 
	                        text:'同意派工', 
	                        value:'1', 
	                        selected:true 
	                        }, 
	                        { 
	                        text:'延期派工', 
	                        value:'2' 
	                        }, 
	                        { 
	                        text:'打回修改', 
	                        value:'4' 
	                        },
	                        { 
	                        text:'取消派工', 
	                        value:'3' 
	                        } 
	                    ], 
	                    onSelect:function(record){ 
	                        if(record.value == '2'){ 
	                            $('#yqts').show(); 
	                        }else { 
	                            $('#yqts').hide(); 
	                        } 
	                        if(record.value == '1' ){
	                        	$('.pgrow').show();
	                        }else{
	                        	$('.pgrow').hide();
	                        }
	                    } 
	                " />
					 </div>
					</td>
				</tr>
			</s:if>
			<s:else>
				<input type="hidden" name="rwd.pgzt" value="1" />
			</s:else>
			<tr class="datagrid-row pgrow">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>创建人</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input readonly="readonly" type="text" value="<s:property value="rwd.cjryname" />" />
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>年月</span>
					</div>
				</td>
				<td colspan="3">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<%-- <input readonly="readonly" type="text" name="rwd.ssny" value="<s:property value="rwd.ssny" />" /> --%>
						<s:if test="!show">
							<input name="rwd.ssny" class="easyui-combobox" data-options="
								url : '/hmglyh/nyb/getNy.do',
								valueField : 'yname',
								textField : 'yname',
								editable:false,
								width:210,
								value:'<s:property value="rwd.ssny" />'
							" />
						</s:if>
						<s:else>
							<input readonly="readonly" type="text" name="rwd.ssny" value="<s:property value="rwd.ssny" />" />
						</s:else>
						
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>受委派部门</span> 
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!show">
				  				<input id="rwdbmcodeid"  type="text"
										name="rwd.bmcode" errorInfo="请选择受委派部门" class="easyui-combobox notnull"
										data-options=" 
					                        url:'${pageContext.request.contextPath}/rcyh/bh_getPgdxs.do', 
					                        textField:'bmname', 
					                        valueField:'bmcode', 
					                        <s:if test="bmcode != null" >
					                        value:'<s:property value="rwd.bmcode" />',
					                        </s:if>
					                        onSelect:function(record){ 
					                         
					                            <s:if test="fromYdjh or update" >
					                           	 $('#ldCombobox').combobox('reload','/hmglyh/lxld/getLxldCombo.do?bmCode='+record.bmcode);
					                         	$('#ldCombobox').combobox('setValue','');
					                            </s:if>
					                       		
					                       
					                        },
					                        onLoadSuccess:function(data){
					                         	<s:if test="fromYdjh" >
					                         	if(data.length > 0 ){
					                         		$('#ldCombobox').combobox('reload','/hmglyh/lxld/getLxldCombo.do?bmCode='+data[0].bmcode);
					                         	}
					                       		</s:if>
					                       		<s:else>
					                       		if(data.length > 0 ) {
					                       			$('#rwdbmcodeid').combobox('setValue','<s:property value="rwd.bmcode" />')
					                       		}
					                       		</s:else>
					                        }
					                    " />
				  		</s:if>
						<s:else>
							<s:property value="rwd.bmname"/>
						</s:else>
	                   </div>
				</td>
			</tr>
			<tr class="datagrid-row pgrow">		
				<s:if test="!fromYdjh">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>病害名称</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!show">
							<s:if test="bufenYs or fromYdjh or update">
								<input id="bhlxtree" class="easyui-combotree notnull" errorInfo="请选择病害类型" data-options="
									width:'100%',
									<%-- url:'${pageContext.request.contextPath}/rcyh/bh_bhlxCombotree.do', --%>
									url:'/hmglyh/template/bhlxtree.json',
									<s:if test="rwd.bhid != null ">
									value:'<s:property value='rwd.bhid' />',
									</s:if>
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
										
										$.post('/hmglyh/rcyh/bh_getXfsx.do?bhjl.bhid='+node.id,function(data){
											$('#xfsx').val(data.result);
										},'json');
										
									}
								" type="text" name="rwd.bhid" />
							</s:if>
							<s:else>
								<input name="rwd.bhid" errorInfo="请选择病害名称" class="easyui-combobox notnull" data-options="
									value:'<s:property value="bhjls[0].bhid" />',
									panelHeight:100,
									data:[
										<s:iterator value="gmap.bhlxs" id="entry" status="status">
												{ value:'<s:property value="#entry.key" />',text:'<s:property value="#entry.value" />'}
												<s:if test="#status.index != gmap.bhlxs.size ">,</s:if>
										</s:iterator>
									],
									onSelect:function(record){
										var bhid = record.value;
										$.post('/hmglyh/rcyh/bh_getWxsx.do?bhjl.bhid='+bhid,function(data){if(data && data.wxsx){$('#weixiusx').val(data.wxsx)}},'json');
									}
									" />
							</s:else>
						</s:if>
						<s:else>
							<s:property value="rwd.bhid"/>
						</s:else>
						</div>
				</td>
				</s:if>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>项目名称</span>
					</div>
				</td>
				<td>
					  <div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show and !update">
								 <input id="xmmcid" type="text" name="rwd.yhid" errorInfo="请选择项目名称" class="easyui-combotree notnull"
									data-options=" 
				                    	<%-- url:'${pageContext.request.contextPath}/rcyh/wxzy_getYhlxTree.do',  --%>
				                    	url:'/hmglyh/template/yhlxtree.json',
				                    	idField:'yhid', 
				                        textField:'yhname', 
				                        <s:if test="bufenYs" >
				                        onLoadSuccess:function(){
				                      	  //$('#xmmcid').combotree('setValue','<s:property value='rwd.yhid' />');
				                        },
										</s:if>
										clickNodeForSpan:true,
										width:150,
										panelWidth:290,
										value:'<s:property value="rwd.yhid" />',
				                        onSelect:function(node){ 
				                           var yhid = node.id;
				                           var bmcode = $('#rwdbmcodeid').combobox('getValue');
				                           rwdCalculate(bmcode,yhid);
				                       }
				               		 "/>
							</s:if>
							<s:else>
								<s:property value="rwd.yhlxname"/>
								<input type="hidden" id="xmmcid" name="rwd.yhid" value="<s:property value="rwd.yhid" />" />
							</s:else>
	               		</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>派工数量</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="pgsl" style="width:50px;" type="text" min="1" errorInfo="派工数量填写不正确" class="int notnull" onfocus="pgslFocus(this)" onblur="pgslBlur(this)" name="rwd.sl" value="<s:property value="rwd.sl" />" />
					<span id="dwSpan"><s:property value="rwd.dw" /></span>
				    </div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>修复时限</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="xfsx" type="text" style="width:50px;" min="1" errorInfo="修复时限填写不正确" class="double" id="weixiusx" name="rwd.xfsx" value="<s:property value="rwd.xfsx" />" /> 天
					</div>
				</td>
				<s:if test="fromYdjh">
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					
					</div>
				</td>
				</s:if>
			</tr>
			<tr class="datagrid-row pgrow">
				
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>工日定额</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="grde" readonly="readonly" type="text" min="1" errorInfo="工日定额填写不正确" class="int notnull" onblur="reCalculate1(this)" name="rwd.grde" value="<s:property value="rwd.grde" />" />
					</div>
				</td>
				
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>计划工日</span>
					</div>
				</td>
				
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input id="jhgr" errorInfo="计划工日填写不正确" class="int notnull" min="1" type="text" name="rwd.jhgr" value="<s:property value="rwd.jhgr" />" />
					</div>
				</td>
				
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>任务单类型</span>
					</div>
				 </td>
				 <td>
				 	<div style='height:auto;text-align:center' class='datagrid-cell'>
				 		<s:if test="fromYdjh">
				 			<input name="rwd.rwdlx" class="easyui-combobox" data-options="
				 				data:[
				 					{
				 						text:'计划',
				 						value:'0901',
				 						selected:'true'
				 					},
				 					{
				 						text:'补充',
				 						value:'0903'
				 					}
				 				],
				 				panelHeight:'auto'
				 			" />
				 		</s:if>
				 		<s:else>
				 			<s:property value="rwd.rwdlxname"/>
							<input type="hidden"  name="rwd.rwdlx" value="<s:property value="rwd.rwdlx" />" />
				 		</s:else>
	                </div>
				</td>
				
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>任务单状态</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<s:property value="rwd.rwdztname"/>
					<input type="hidden"  name="rwd.rwdzt" value="<s:property value="rwd.rwdzt" />" />
	                </div>
				</td>
			</tr>
			<tr class="datagrid-row pgrow">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>路段</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!fromYdjh or (fromYdjh and show)">
							<input  readonly="readonly"  type="text" value='<s:property value="rwd.ldname"/>'/>
							<input name="rwd.ldcode" id="luduan" type="hidden" value="<s:property value="rwd.ldcode" />" />
						</s:if>
						<s:if test="fromYdjh and add">
							<input errorInfo="请选择路段" id="ldCombobox" class="easyui-combobox notnull"  name="rwd.ldcode" data-options="
											textField:'text',
											valueField:'id',
											onLoadSuccess:function(data){
												if(data.length > 0 ) {
													$('#ldCombobox').combobox('setValue',data[0].id);
												}
											},
											onSelect:function(_record){
												getQshCombobox();
												$('#fx').combobox('setValue',_record.fx);
											}
											" />
						</s:if>
						<s:if test="fromYdjh and update">
								<input errorInfo="请选择路段" id="ldCombobox" class="easyui-combobox notnull"  name="rwd.ldcode" data-options="
											url:'/hmglyh/lxld/getLxldCombo.do?bmCode=<s:property value="rwd.bmcode" />',
											textField:'text',
											valueField:'id',
											value:'<s:property value="rwd.ldcode" />',
											onSelect:function(_record){
												getQshCombobox();
												$('#fx').combobox('setValue',_record.fx);
											}
											" />
						</s:if>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>方向</span> 
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<%-- <s:if test="!show"> --%>
								<input type="text" id="fx" readonly name="rwd.tq" value="<s:property value="rwd.tq" />" class="easyui-combobox" 
									data-options="
											textField:'value',
											valueField:'key',
											panelHeight:'auto',
											<s:if test="rwd.tq != null and rwd.tq != '' " >
											value:'<s:property value="rwd.tq" />',
											</s:if>
											url:'${pageContext.request.contextPath}/rcyh/bh_fxList.do'
										"
								 />
						<%-- </s:if>
						<s:else>
							<s:property value="rwd.tq"/>
						</s:else> --%>
					 </div>
				</td>
				
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>起点桩号</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					K <input id="szhh0" class="int notnull" errorInfo="起点桩号KM不能为空且只能为数字" style="width: 70px;" type="text" name="rwd.szhhkm" value="<s:property value="rwd.szhhkm" />" /> 
					  +
					<input id="szhh1" class="int notnull" errorInfo="起点桩号M不能为空且只能为数字" style="width: 70px;" type="text" name="rwd.szhhm" value="<s:property value="rwd.szhhm" />" /> 
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>止点桩号</span> 
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					K<input id="ezhh0" class="int" errorInfo="止点桩号KM只能为数字" style="width: 70px;" type="text"   name="rwd.ezhhkm" value="<s:property value="rwd.ezhhkm" />" /> 
						+
					<input id="ezhh1" class="int" errorInfo="止点桩号M只能数字" style="width: 70px;" type="text" name="rwd.ezhhm" value="<s:property value="rwd.ezhhm" />" /> 
					</div>
				</td>
			</tr>
			<s:if test="rwd.qlcode != null ">
			<tr class="datagrid-row pgrow">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>桥梁</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input name="rwd.qlname" readonly type="text" value="<s:property value="rwd.qlname" />" />
						<input name="rwd.qlcode" type="hidden" value="<s:property value="rwd.qlcode" />" />
					</div>
				</td>
				<td colspan="7">
				</td>
			</tr>
			</s:if>
			<s:if test="rwd.sdcode != null ">
			<tr class="datagrid-row pgrow">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>隧道</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input name="rwd.sdname" type="text" value="<s:property value="rwd.sdname" />" />
						<input name="rwd.sdcode" type="hidden" value="<s:property value="rwd.sdcode" />" />
					</div>
				</td>
				<td colspan="6">
				</td>
			</tr>
			</s:if>
			<s:if test="rwd.hdcode">
			<tr class="datagrid-row pgrow">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<span>涵洞</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input name="rwd.hdname" type="text" value="<s:property value="rwd.hdname" />" />
					<input name="rwd.hdcode" type="hidden" value="<s:property value="rwd.hdcode" />" />
					</div>
				</td>
				<td colspan="6">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					</div>
				</td>
			</tr>
			</s:if>
			
			<!-- 部分验收添加 任务单的时候 选择5公里范围内桥梁 -->
			<s:if test="bufenYs or fromYdjh">
				<tr class="datagrid-row qshrow qlrow" 
					<s:if test="bhjl.qlcode == null or bhjl.qlcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>桥梁名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
								<input name="rwd.qlcode"  class="easyui-combobox qshCombobox qlCombobox" data-options="
									  onSelect:function(){
									 		$('#qlname').val($('.qlCombobox').combobox('getText'));
									  },
									  <s:if test="rwd.qlcode != null " >
									  	url:'/hmglyh/gis/qlCombobox100.do?ql.roadcode=<s:property value="bhjl.ldcode" />&ql.pos=<s:property value="bhjl.pos" />',
									 	onLoadSuccess:function(data){
									 		$('.qlCombobox').combobox('setValue','<s:property value="bhjl.qlcode" />');
									 	}
									  </s:if>
									  <s:else>
									  	onLoadSuccess:function(data){
									 		$('#qlname').val($('.qlCombobox').combobox('getText'));
									 	}
									  </s:else>
									" type="text"  />
								<input id="qlname" type="hidden" name="rwd.qlname" value='<s:property value="rwd.qlname" />' />
							</s:if>
							<s:else>
								<s:property value="rwd.qlname"/>
							</s:else>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
				<tr class="datagrid-row qshrow sdrow" 
					<s:if test="rwd.sdcode == null or rwd.sdcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>隧道名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
								<input name="rwd.sdcode" class="easyui-combobox qshCombobox sdCombobox" data-options="
									onSelect:function(){
									 		$('#sdname').val($('.sdCombobox').combobox('getText'));
									},
								  <s:if test="rwd.sdcode != null " >
								  	url:'/hmglyh/gis/sdCombobox100.do?sd.roadcode=<s:property value="rwd.ldcode" />&sd.pos=<s:property value="rwd.pos" />',
								 	onLoadSuccess:function(data){
								 		$('.sdCombobox').combobox('setValue','<s:property value="rwd.sdcode" />');
								 	}
								  </s:if>
								   <s:else>
									 onLoadSuccess:function(data){
									 	$('#sdname').val($('.sdCombobox').combobox('getText'));
									 }
									</s:else>
							"  />
								<input id="sdname" type="hidden" name="rwd.sdname" value='<s:property value="rwd.sdname" />' />
							</s:if>
							<s:else>
								<s:property value="rwd.sdname"/>
							</s:else>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
				<tr  class="datagrid-row qshrow hdrow"
					<s:if test="rwd.hdcode == null or rwd.hdcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>涵洞名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
								<input name="rwd.hdcode" class="easyui-combobox qshCombobox hdCombobox" data-options="
									onSelect:function(){
									 		$('#hdname').val($('.hdCombobox').combobox('getText'));
									},
								<s:if test="rwd.hdcode != null " >
								  	url:'/hmglyh/gis/hdCombobox100.do?hd.roadcode=<s:property value="rwd.ldcode" />&hd.pos=<s:property value="rwd.pos" />',
								 	onLoadSuccess:function(data){
								 		$('.hdCombobox').combobox('setValue','<s:property value="rwd.hdcode" />');
								 	}
								 </s:if>
								  <s:else>
									 onLoadSuccess:function(data){
									 	$('#hdname').val($('.hdCombobox').combobox('getText'));
									 }
								  </s:else>
							" />
								<input id="hdname" type="hidden" name="rwd.hdname" value='<s:property value="rwd.hdname" />' />
							</s:if>
							<s:else>
								<s:property value="rwd.hdname"/>
							</s:else>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>	
			</s:if>
			
			<s:if test="!show">
			<tr class="datagrid-row pgrow">
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>计划材料消耗</span>
					</div>
				</td>
				<td colspan="2" style="vertical-align:top">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="jhclxh" type="text"	class="easyui-combotree"
					data-options=" 
                   <%--  url:'${pageContext.request.contextPath}/rcyh/wxzy_getGljclTree.do', --%>
                    url:'/hmglyh/template/clgljtree.json',
                    checkbox:true,
                    lines:true,
                    panelHeight:150,
                    panelWidth:250,
                    multiple:true,
                    clickNodeForSpan:true
                " />
               		 <a data-options="plain:true" class="easyui-linkbutton" onclick="addJhclxh()">添加</a>
					</div>
				</td>
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>计划机械消耗</span>
					</div>
				</td>
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="jhjxxh" type="text" class="easyui-combotree"
						data-options=" 
	                   <%--  url:'${pageContext.request.contextPath}/rcyh/wxzy_getGljjxTree.do', --%>
	                    url:'/hmglyh/template/jxgljtree.json',
	                    checkbox:true,
	                    lines:true,
	                    panelHeight:150,
                        panelWidth:250,
	                    multiple:true,
	                   clickNodeForSpan:true
	                " />
               		<a class="easyui-linkbutton" onclick="addJhjxxh()" data-options="plain:true">添加</a>
					 </div>
				</td>
			</tr>
			</s:if>
			<tr class="datagrid-row pgrow">
				<td colspan="4" id="jhclxh_td" style="vertical-align: baseline;">
				  <div style='height:auto;text-align:center' class='datagrid-cell'>
					<div class="jhxh_div datagrid-body" style="" >
						<table id="jhclxhTable" class='mytable' style="width:100%;vertical-align:top">
								<tr class="datagrid-row">
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>材料名称</div>
									</td>
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>编号</div>
									</td>
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>单价</div>
									</td>
									<td>
										<div style='height:auto;text-align:center;width:200px;' class='datagrid-cell'>规格</div>
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
								<s:iterator value="rwd.cls" id="cljxxh" status="status">
										<tr class='mytr data-row'>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<input type='hidden' name='rwd.cls[<s:property value="#status.index" />].lxid' value='<s:property value="#cljxxh.lxid" />' />
													<s:property value="#cljxxh.lxname" />
												</div>
											</td>
											
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
														<s:property value="#cljxxh.bm" />
												</div>
											</td>
											
											<td  >
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<input  class='gljdj' readonly="readonly" name='rwd.cls[<s:property value="#status.index" />].dj' value="<fmt:formatNumber value="${cljxxh.dj}" pattern="0.00" />" type='text' />
												</div>
											</td>
											<td>
												<div style='height:auto;text-align:center;width:200px;white-space:normal;' class='datagrid-cell'>
													<s:property value="#cljxxh.gg" />
												</div>
											</td>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>
													<input desl="<s:property value="#cljxxh.sl" />" name='rwd.cls[<s:property value="#status.index" />].sl' class='gljsl int notnull' onblur="gljslblur(this,'<s:property value="#cljxxh.lxid" />')" type='text' value='<s:property value="#cljxxh.sl" />' style='width:50px;' />
													<s:property value="#cljxxh.dw" />
												</div>
											</td>
											<s:if test="!show">
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<a href="javascript:void(0)" onclick='delRows(this)' >删除</a> 
													</div>
												</td>
											</s:if>
										</tr>
								</s:iterator>
						</table>
				      </div>
					</div>
				</td>
				<td colspan="4" id="jhjxxh_td" style="vertical-align: baseline;">
				  <div style='height:auto;text-align:center' class='datagrid-cell'>
					<div class="jhxh_div datagrid-body" style="">
						<table id="jhjxxhTable" class='mytable' style="width:100%;vertical-align:top">
								<tr class="datagrid-row">
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>机械名称</div>
									</td>
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>编号</div>
									</td>
									<td>
										<div style='height:auto;text-align:center' class='datagrid-cell'>单价</div>
									</td>
									<td>
										<div style='height:auto;text-align:center;width:200px;' class='datagrid-cell'>规格</div>
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
									<s:iterator value="rwd.jxs" id="cljxxh" status="status">
											<tr class='mytr data-row'>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<input type='hidden' name='rwd.jxs[<s:property value="#status.index" />].lxid' value='<s:property value="#cljxxh.lxid" />' />
														<s:property value="#cljxxh.lxname" />
													</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<s:property value="#cljxxh.bm" />
													</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<input  class='gljdj'  readonly="readonly" name='rwd.jxs[<s:property value="#status.index" />].dj' value="<fmt:formatNumber value="${cljxxh.dj}" pattern="0.00" />" type='text' />
													</div>
												</td>
												<td>
													<div style='height:auto;text-align:center;width:200px;white-space:normal;' class='datagrid-cell'>
														<s:property value="#cljxxh.gg" />
													</div>
												</td>
												<td>
													<div style='height:auto;text-align:center' class='datagrid-cell'>
														<input desl="<s:property value="#cljxxh.sl" />" class='gljsl int notnull' name='rwd.jxs[<s:property value="#status.index" />].sl'  onblur="gljslblur(this)" type='text' value='<s:property value="#cljxxh.sl" />' style='width:50px;' />
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
			</tr>
			<tr class="datagrid-row pgrow">
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>计划人工费</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="jhrgf" errorInfo="计划人工费填写不正确" class="money notnull" type="text" name="rwd.rgf" value="<fmt:formatNumber value="${rwd.rgf}" pattern="0.00" />" />
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>计划材料费</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<input id="clfTotal" errorInfo="您输入的材料费有误" class="money notnull" type="text" name="rwd.clf" value="<fmt:formatNumber value="${rwd.clf}" pattern="0.00" />" />
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span>计划机械费</span>
					</div>
				</td>
				<td>
					<div style='height:auto;text-align:center' class='datagrid-cell'>
						<input id="jxfTotal" errorInfo="您输入的机械费有误" class="money notnull" type="text" name="rwd.jxf" value="<fmt:formatNumber value="${rwd.jxf}" pattern="0.00" />" />
					</div>
				</td>
				<td colspan="2">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					</div>
				</td>
			</tr>
		</table>
		</div>
	</form>
	<!-- 	<span id="yqts" style="display:none;" ><input class="notnull int" style="width:150px;" min="1" errorInfo = "请输入延期天数 " value="1"  type="text" name="rwd.date">天之后</span> -->
	<s:if test="!show">
	<!-- 延期派工 -->
	<form class="pgform" id="fm2" method="post"
		<s:if test="!show">
			action="${pageContext.request.contextPath}/rcyh/bhflow_saveRwd.do" 
		</s:if> >
			<input type="hidden" name="rwd.pgzt" value="2" />
			<s:iterator value="bhjls" id="bh" status="status">
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].bhjlid" value="<s:property value="#bh.bhjlid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ldcode" value="<s:property value="#bh.ldcode" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].xcid" value="<s:property value="#bh.xcid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].bhid" value="<s:property value="#bh.bhid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].szhhkm" value="<s:property value="#bh.szhhkm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].szhhm" value="<s:property value="#bh.szhhm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhkm" value="<s:property value="#bh.ezhhkm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhm" value="<s:property value="#bh.ezhhm" />" />
			</s:iterator>
	  <div id="yqts" class="datagrid-body" style="overflow-x:hidden;display:none;">
		<table class="form_table datagrid-btable" cellpadding=0 cellspacing=0  id="mytable" >
			<tr class="datagrid-row">
				<td colspan="8" style="text-align: center">
					<div style='height:auto;text-align:center' class='datagrid-cell'>
					<span><input id="yanqiInput" class="notnull int" style="width:150px;" min="1" errorInfo = "请输入延期天数 " value="1"  type="text" name="rwd.date">天之后</span>
					</div>
				</td>
			</tr>
		</table>
	  </div>
	</form>
	</s:if>		
	<s:if test="!show">
	<!-- 打回修改 -->
	<form  class="pgform" id="fm3" method="post"
		<s:if test="!show">
			action="${pageContext.request.contextPath}/rcyh/bhflow_saveRwd.do" 
		</s:if> >
			<s:iterator value="bhjls" id="bh" status="status">
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].bhjlid" value="<s:property value="#bh.bhjlid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ldcode" value="<s:property value="#bh.ldcode" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].xcid" value="<s:property value="#bh.xcid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].bhid" value="<s:property value="#bh.bhid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].szhhkm" value="<s:property value="#bh.szhhkm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].szhhm" value="<s:property value="#bh.szhhm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhkm" value="<s:property value="#bh.ezhhkm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhm" value="<s:property value="#bh.ezhhm" />" />
			</s:iterator>
			<input type="hidden" name="rwd.pgzt" value="4"/>
	</form>
	</s:if>		
	<s:if test="!show">
	<!-- 取消修改 -->
	<form  class="pgform" id="fm4" method="post"
		<s:if test="!show">
			action="${pageContext.request.contextPath}/rcyh/bhflow_saveRwd.do" 
		</s:if> >
			<s:iterator value="bhjls" id="bh" status="status">
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].bhjlid" value="<s:property value="#bh.bhjlid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ldcode" value="<s:property value="#bh.ldcode" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].xcid" value="<s:property value="#bh.xcid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].bhid" value="<s:property value="#bh.bhid" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].szhhkm" value="<s:property value="#bh.szhhkm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].szhhm" value="<s:property value="#bh.szhhm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhkm" value="<s:property value="#bh.ezhhkm" />" />
				<input  type="hidden" name="bhjls[<s:property value='#status.index' />].ezhhm" value="<s:property value="#bh.ezhhm" />" />
			</s:iterator>
			<input type="hidden" name="rwd.pgzt" value="3" />
	</form>
	</s:if>		
	<s:if test="(!show) and (!update)" >
		<center style='padding-top:5px;'><a class="easyui-linkbutton" data-options="plain:true" onclick="mysubmit()">确认</a></center>
	</s:if>
	<s:if test="update">
			<center style='padding-top:5px;'><a class="easyui-linkbutton" data-options="plain:true" onclick="$('#fm').submit()">更新</a></center>
	</s:if>
	<script>
	function getQshCombobox(){
		var bhid = $("#bhlxtree").combotree("getValue");
	 	if(bhid.match('^04') == '04' 
		|| bhid.match('^05') == '05'
		|| bhid.match('^06') == '06'
		){
	 		//var ldcode = $('#ldCombobox').combobox('getValue');
	 		var ldcode = $("#ldcode").val();
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
	
		function mysubmit(){
			<s:if test="(gmap.continue == '' or gmap.continue == null) && (!fromYdjh) " >
					var pgzt = $("#pgzt").combobox("getValue");
					if(pgzt == "1") {
						$("#fm").submit();
					}
					if(pgzt == "2" ) {
						$("#fm2").submit();
					}
					
					if(pgzt == "3" ) {
						$("#fm4").submit();
					}
					
					if(pgzt == "4" ) {
						$("#fm3").submit();
					}
			</s:if>
			<s:else>
					$("#fm").submit();
			</s:else>
		}
	
		
		$(".pgform").form({
			onSubmit : function() {
				if(validation.checkInt($("#yanqiInput")[0])) {
					$.messager.progress({
						title:"请稍后...",
						text:"请稍后...",
						msg:'一会就好'
					}); 
				}else{
					$.messager.alert("提示",$("#yanqiInput").attr("errorInfo"),"warning");
					return false;
				}
			},
			success : function(str) {
				$.messager.progress("close"); 
				var r = eval('(' + str + ')');
				if(r.isSuccess) {
					$.messager.alert('成功',r.info,'ok',function(r){
						parent.gisui.destroyAllWindows();
					});
				}else{
					$.messager.alert('失败',  r.info, 'warning');
				}
			},
			onLoadError:function(){
				$.messager.progress("close"); 
				$.messager.alert('失败', "服务器似乎除了问题" + r.info, 'warning');
			}
		});
		 <s:if test="show" >
			$("input").attr("readonly","readonly");
		</s:if>
	</script>
</body>
</html>
