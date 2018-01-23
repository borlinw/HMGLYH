<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.hdsx.hmglyh.util.MD5Util"%>
<%@ include file="../public/head.jsp"%>
 <link href="${pageContext.request.contextPath}/css/uploadify.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.uploadify.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/fileUtil.js"></script>
<title></title>
</head>
<body>
	<form id="fm" action="<s:if test="add">${pageContext.request.contextPath}/rcyh/bhflow_saveBh.do</s:if><s:if test="update">${pageContext.request.contextPath}/rcyh/bh_saveUpdateBh.do</s:if>" 
		method="post">
		<div class="datagrid-body">
			<input type="hidden" name="bhjl.xcid" value="<s:property value="bhjl.xcid" />" />
			<input type="hidden" name="bhjl.bhjlid" value="<s:property value="bhjl.bhjlid" />" />
			<input type="hidden" name="bhjl.pgzt" value="0" />
			<input type="hidden" name="bhjl.bhwxzt" value="0" />
			<input type="hidden" name="fromXd" value="<s:property value="fromXd" />" />	
			<input type="hidden" name="fromPg" value="<s:property value="fromPg" />" />	
			<input type="hidden" name="fromSb" value="<s:property value="fromSb" />" />	
			
			<table class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
				<tr class="datagrid-row">
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>记录时间</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!show">
							<input class="easyui-datetimebox" name="bhjl.jltime" data-options="
								value:'<s:property value="bhjl.jltime" />'
							" />
						</s:if>
						<s:else>
							<s:property value="bhjl.jltime" />
						</s:else>
						</div>
					</td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>巡视人</div></td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>
						<input  class="combo myCombo" value="<s:property value="bhjl.jlryname" />"/>
						<input type="hidden" name="bhjl.jlusername" value="<s:property value="bhjl.jlusername" />" />
					</div></td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>巡视单位</div></td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>
						<input type="text" class="combo myCombo" value="<s:property value="bhjl.bmname" />">
						<input type="hidden" name="bhjl.bmcode" value="<s:property value="bhjl.bmcode" />">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>病害类型</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
								<input id="bhlxtree" class="easyui-combotree notnull" errorInfo="请选择病害类型" data-options="
									width:'100%',
								<%-- 	url:'${pageContext.request.contextPath}/rcyh/bh_bhlxCombotree.do', --%>
									url:'/hmglyh/template/bhlxtree.json',
									<s:if test="bhjl.bhid != null ">
									value:'<s:property value='bhjl.bhid' />',
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
									}
								" type="text" name="bhjl.bhid" />
							</s:if>
							<s:else>
								<s:property value="bhjl.bhlxname"/>
							</s:else>
						</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>数量</div>
					</td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input name="bhjl.sl"  style="width:50px;" value="<s:property value="bhjl.sl" />" class="int notnull" min="1" errorInfo="病害数量填写不正确" type="text" /><span id="sldw"></span>
						</div>
					</td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>病害上报状态</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:property value="bhjl.bhsbztname" />
							<input type="hidden" name="bhjl.bhsbzt" value="<s:property value="bhjl.bhsbzt" />" > 
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>路段</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
									<input id="ldCombobox" class="easyui-combobox"  name="bhjl.ldcode" data-options="
										url:'${pageContext.request.contextPath}/rcyh/xdjl_xdjlLds.do',
										<s:if test="bhjl.ldcode != null" >
										onLoadSuccess:function(){
											$('#ldCombobox').combobox('select','<s:property value="bhjl.ldcode" />');
										},
										</s:if>
										<s:if test="bhjl.ldcode == null">
											onLoadSuccess:function(){
												var data = $('#ldCombobox').combobox('getData');
												for(var i=0;data.length>i;i++){
													if(data[i].text == '<s:property value="bhjl.ldname" />'){
														$('#ldCombobox').combobox('select',data[i].value);
														return;
													}
												}
											},
										</s:if>
										onSelect:function(_record){
											console.info(_record);
											getQshCombobox();
											$('#fx').combobox('select',_record.fx);
										}
								" />
							</s:if>
							<s:else>
								<s:property value="bhjl.ldcode" />
							</s:else>			
						</div>
					</td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>起点桩号</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							K<input id="szhh0" onblur="getQshCombobox()" errorInfo="起点桩号KM必填且只能为数字" class="notnull int" value="<s:property value="bhjl.szhhkm" />" type="text" style="width:50px;border:1px solid #ccc;"  name="bhjl.szhhkm"/> +
							<input id="szhh1"  onblur="getQshCombobox()" errorInfo="起点桩号必填且只能数字" class="notnull int" value="<s:property value="bhjl.szhhm" />" type="text" style="width:50px;border:1px solid #ccc;"  name="bhjl.szhhm"/>
						</div>
					</td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>止点桩号</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							K<input id="ezhh0" onblur="getQshCombobox()" errorInfo="止点桩号KM只能为数字" class="int" value="<s:property value="bhjl.ezhhkm" />"  type="text" style="width:50px;border:1px solid #ccc;" name="bhjl.ezhhkm" /> + 
							<input id="ezhh1"  onblur="getQshCombobox()" errorInfo="止点桩号M只能为数字" class="int" value="<s:property value="bhjl.ezhhm" />"  type="text" style="width:50px;border:1px solid #ccc;"   name="bhjl.ezhhm" /> 
						</div>
					</td>
				</tr>
				<tr class="datagrid-row">
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>方向</div></td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>
						<s:if test="!show">
							<input name="bhjl.tq" id="fx" errorInfo="请选择方向" class="easyui-combobox notnull"
								data-options="
									textField:'value',
									valueField:'key',
									panelHeight:'auto',
									<s:if test="bhjl.tq != null " >
									value:'<s:property value="bhjl.tq" />',
									</s:if>
									url:'${pageContext.request.contextPath}/rcyh/bh_fxList.do'
								"
							 type="text" />
						</s:if>
						<s:else>
							<s:property value="bhjl.tq" />
						</s:else>
					</div>
					</td>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>位置补充</div></td>
					<td colspan="3">
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input style="width:98%"
								<s:if test="show"> readonly=readonly</s:if>
							 value="<s:property value="bhjl.wzbc" />" class="combo myCombo" type="text" name="bhjl.wzbc" />
						</div>
					</td>
				</tr>
				<tr class="datagrid-row qshrow qlrow" 
					<s:if test="bhjl.qlcode == null or bhjl.qlcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>桥梁名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
								<input name="bhjl.qlcode"  class="easyui-combobox qshCombobox qlCombobox" data-options="
									  onSelect:function(){
									 		$('#qlname').val($('.qlCombobox').combobox('getText'));
									  },
									  <s:if test="bhjl.qlcode != null " >
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
								<input id="qlname" type="hidden" name="bhjl.qlname" value='<s:property value="bhjl.qlname" />' />
							</s:if>
							<s:else>
								<s:property value="bhjl.qlname"/>
							</s:else>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
				<tr class="datagrid-row qshrow sdrow" 
					<s:if test="bhjl.sdcode == null or bhjl.sdcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>隧道名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
								<input name="bhjl.sdcode" class="easyui-combobox qshCombobox sdCombobox" data-options="
									onSelect:function(){
									 		$('#sdname').val($('.sdCombobox').combobox('getText'));
									},
								  <s:if test="bhjl.sdcode != null " >
								  	url:'/hmglyh/gis/sdCombobox100.do?sd.roadcode=<s:property value="bhjl.ldcode" />&sd.pos=<s:property value="bhjl.pos" />',
								 	onLoadSuccess:function(data){
								 		$('.sdCombobox').combobox('setValue','<s:property value="bhjl.sdcode" />');
								 	}
								  </s:if>
								   <s:else>
									 onLoadSuccess:function(data){
									 	$('#sdname').val($('.sdCombobox').combobox('getText'));
									 }
									</s:else>
							"  />
								<input id="sdname" type="hidden" name="bhjl.sdname" value='<s:property value="bhjl.sdname" />' />
							</s:if>
							<s:else>
								<s:property value="bhjl.sdname"/>
							</s:else>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
				<tr  class="datagrid-row qshrow hdrow"
					<s:if test="bhjl.hdcode == null or bhjl.hdcode == '' ">
						style="display:none;" 
					</s:if>
				>
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>涵洞名称</div></td>
					<td>
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<s:if test="!show">
								<input name="bhjl.hdcode" class="easyui-combobox qshCombobox hdCombobox" data-options="
									onSelect:function(){
									 		$('#hdname').val($('.hdCombobox').combobox('getText'));
									},
								<s:if test="bhjl.hdcode != null " >
								  	url:'/hmglyh/gis/hdCombobox100.do?hd.roadcode=<s:property value="bhjl.ldcode" />&hd.pos=<s:property value="bhjl.pos" />',
								 	onLoadSuccess:function(data){
								 		$('.hdCombobox').combobox('setValue','<s:property value="bhjl.hdcode" />');
								 	}
								 </s:if>
								  <s:else>
									 onLoadSuccess:function(data){
									 	$('#hdname').val($('.hdCombobox').combobox('getText'));
									 }
								  </s:else>
							" />
								<input id="hdname" type="hidden" name="bhjl.hdname" value='<s:property value="bhjl.hdname" />' />
							</s:if>
							<s:else>
								<s:property value="bhjl.hdname"/>
							</s:else>
						</div>
					</td>
					<td colspan="6"><div style='height:auto;text-align:center' class='datagrid-cell'></div></td>
				</tr>
				<tr class="datagrid-row">
					<td><div style='height:auto;text-align:center' class='datagrid-cell'>备注说明</div></td>
					<td colspan="5">
						<div style='height:auto;text-align:center' class='datagrid-cell'>
							<input style="width:98%;" value="<s:property value="bhjl.bz" />" class="text" type="text"  name="bhjl.bz" />
						</div>
					</td>
				</tr>
				<s:if test="!show">
					<tr class="datagrid-row">
						<td style="height:200px"><div style='height:auto;text-align:center' class='datagrid-cell'>照片信息及描述</div></td>
						<td colspan="5">
							<div style='height:200px;overflow:auto' class='datagrid-cell'>
								<s:if test="!show">
									<form>
										<div id="queue"></div>
										<input id="file_upload" name="file_upload" type="file" multiple="true" />
									</form>
								</s:if>
								<div class="datagrid-body">
									<table id="picTable" class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
										<tr class="datagrid-row">
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>照片名称</div>
											</td>
											<td>
												<div style='height:auto;text-align:center' class='datagrid-cell'>状态</div>
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
										<s:if test="bhjl.zps != null " >
											<s:iterator value="bhjl.zps" id="zp" status="status">
												<tr class='datagrid-row'>
													<td>
														<div style='text-align:center' class='datagrid-cell'>
															<input style='text-align:center'  readonly='readonly' type='text' name='bhjl.zps[<s:property value="#status.index" />].zpmc' value="<s:property value="#zp.zpmc" />"></input>
															<input type='hidden' name='bhjl.zps[<s:property value="#status.index" />].zpdz' value='<s:property value="#zp.zpdz" />'>
															<input type='hidden' name='bhjl.zps[<s:property value="#status.index" />].ryid' value='0'>
														</div>
													</td>
													<td>
														<div style='text-align:center' class='datagrid-cell'>
															修复前
															<input type='hidden' name='bhjl.zps[<s:property value="#status.index" />].ryid' value='0'>
														</div>
													</td>
													<td>
														<div style='text-align:center' class='datagrid-cell'>
															<input  name='bhjl.zps[<s:property value="#status.index" />].zpdx'  value="<s:property value="#zp.zpdx" />" />
														</div>
													</td>
													<td>
														<div style='text-align:center' class='datagrid-cell'>
															<s:if test="!show">
																<a  href='javascript:void(0)'   zpdz='<s:property value="#zp.zpdz" />' fid='<s:property value="#status.index" />' succ='1' style='color:#blue' onclick=delZpRow(this)>删除</a>
																|
															</s:if>
															<a href='<s:property value="#zp.picUrl" />/<s:property value="#zp.zpdz" />' style='color:blue' target='blank' >查看</a>
														</div>
													</td>
													<td style='width:150px;'>
														<div id='<s:property value="#status.index" />-queue' style='text-align:center' class='datagrid-cell'>
																<span style="color:green">正常</span>
														</div>
													</td>
													<td style='width:150px;'>
														<div  style='text-align:center' class='datagrid-cell'>
															<input  name='bhjl.zps[<s:property value="#status.index" />].zpms'  value="<s:property value="#zp.zpms" />" />
														</div>
													</td>
												</tr>
											</s:iterator>
										</s:if>
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
		<center style="margin-top:5px;">
			<a class="easyui-linkbutton" data-options="plain:true" onclick="$('#fm').submit()">保存</a>
			<a class="easyui-linkbutton" data-options="plain:true" onclick="history.back()">返回</a>
		</center>
    </s:if>
	<s:if test="update">
		<center style="margin-top:5px;">
			<a class="easyui-linkbutton" data-options="plain:true" onclick="$('#fm').submit()">更新</a>
			<a class="easyui-linkbutton" data-options="plain:true" onclick="history.back()">返回</a>
		</center>
    </s:if>

	<script>	
    <s:if test="show" >
		$("input").attr("readonly","readonly");
	</s:if>
	
	
	function getQshCombobox(){
		var bhid = $("#bhlxtree").combotree("getValue");
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
	
    $(function() {
		      var i = 0;
		      $('#file_upload').uploadify({
		          'formData'     : {
		              'timestamp' : '<%=new Date().getTime()%>',
		              'token'     : '<%=MD5Util.MD5(new Date().getTime()+"")%>',
		          },
		          'width':100,
		          'height':20,
		          'buttonText' : '选择上传图片',
		          'fileTypeDesc':'请选择 jgp,jpeg,gif,png 格式的图片', // 貌似不好用
		          'debug':false,
		          'swf'      : '${pageContext.request.contextPath}/uploadify.swf',
		          'uploader' : '${pageContext.request.contextPath}/up',
		          'fileSizeLimit':'5mb',
		          'fileTypeExts':'*.jpeg;*.jpg; *.png;*.gif',
		          'onUploadSuccess':function(file,strData){
		              var jsonData = eval("(" + strData + ")");
		              $("#myfile-"+file.id).val(jsonData.rname);
		              $("#"+file.id + "-pic").css("color","blue"); 
		              $("#"+file.id + "-del").attr("zpdz",jsonData.rname); 
		              $("#"+file.id + "-del").attr("succ","1"); 
		              $("#"+file.id + "-del").css("color","blue"); 
		              $("#"+file.id+"-del").html("删除");
		              $("#"+file.id + "-pic").attr("href",jsonData.picUrl+"/"+jsonData.rname);
		              $("#"+file.id+"-queue").html("<span style='color:green;'>成功</span>");
		          
		          },
		          'onUploadStart':function(file) {
		              var html = "<tr class='datagrid-row'>"+
		              "<td style='width:120px;'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                      "<input style='text-align:center'  readonly='readonly' type='text' name='bhjl.zps["+i+"].zpmc' value="+file.name + "></input>" +  
		                      "<input id='myfile-"+file.id+"' type='hidden' name='bhjl.zps["+i+"].zpdz' value=''>"+
		                  "</div>"+
		              "</td>" +
		              "<td style='width:80px;'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                  		"修复前"+
		                  		"<input type='hidden' type='text' name='bhjl.zps["+i+"].ryid' value='0'>"+
		                  "</div>"+
	              	  "</td>"+
		              "<td style='width:80px;'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                  "<input type='text' readonly='readonly' name='bhjl.zps["+i+"].zpdx' value='" +((file.size / 1204 / 1024) .toFixed(2) )+"MB'>"+
		                  "</div>"+
		              "</td>"+
		              "<td style='width:100px'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                      "<a  id='"+file.id+"-del' zpdz='0' fid='"+file.id+"' succ='0' href='javascript:void(0);'  style='color:#f00' onclick=delZpRow(this)>取消上传</a>"+
		                      "|<a id='"+file.id+"-pic' href='javascript:void(0)' style='color:#ccc' target='blank' >查看</a>"+
		                  "</div>"+
		              "</td>"+
		              "<td style='width:80px;'>"+
		                  "<div id='"+file.id+"-queue' style='text-align:center' class='datagrid-cell'>"+
		                  "</div>"+
		              "</td>"+
		              "<td style='width:150px;'>"+
		             //     "<div style='text-align:center' class='datagrid-cell'>"+
		                	  "<input type='text' name='bhjl.zps["+i+"].zpms' value=''>"+
		              //    "</div>"+
		              "</td>"+
		              "</tr>";
		              $("#picTable").append(html);
		              i++;
		          },
		          'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
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
		              
		              $('#'+file.id + '-queue').html(bytesUploaded + suffixUploaded + ' / ' + bytesTotal + suffixTotal);
		          },
		          'onUploadError' : function(file, errorCode, errorMsg, errorString) {
		              $('#'+file.id + '-queue').html("<span style='color:red'>上传失败</span>");
		          }
		      });
		  });
    	
	      function delZpRow(obj){
		        var succ = $(obj).attr("succ");
		        var fileid = $(obj).attr("fid");
		        var zpdz = $(obj).attr("zpdz");
		        if(succ == "0" ) {  // 1  如果是正在上传 之中 现在 要 取消上传 
		            $('#file_upload').uploadify("cancel",fileid);
		            //$("#"+fileid+"-queue").html("<span style='color:green;'>已取消</span>");
		            setTimeout(function(){
		               $(obj).parentsUntil('.datagrid-row').parent().remove();
		         },2000);
		        }else if(succ == "1" ){     // 2  如果已经上传成功 要将 服务已经上传的图片删除
		            if( zpdz == "0" ) return;
		            $.ajax({
		                url:"/hmglyh/rcyh/bh_delPic.do",
		                dataType:"json",
		                data:{
		                    "zp.zpdz":zpdz
		                },
		                success:function(data){
		                    $("#"+fileid+"-queue").html("<span style='color:green;'>删除成功</span>");
		                    setTimeout(function(){
		                          $(obj).parentsUntil('.datagrid-row').parent().remove();
		                    },2000);
		                },
		                error:function(){
		                    $("#"+fileid+"-queue").html("<span style='color:red;'>删除失败</span>");
		                }
		            });

		        }
	    }    
    
    </script>
</body>
</html>
