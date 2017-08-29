<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/remember.js"></script>
<title></title>
<script>
	// gisui
	var gisui = new GisUI({
		isShowToolBar:false
	});
	// 查看寻道记录列表
	// 添加一条巡道记录
	function viewXdjl(){
		$("#yhbg_tt").tabs("close","巡道记录");
		$('#yhbg_tt').tabs('add',{
		    title:'巡道记录',
		    content:"<iframe width='100%' height='100%' style='border:none;margin:0px;padding:0px;overflow-y:hidden;' src='${pageContext.request.contextPath}/rcyh/xdjl_listXdjl.do'></iframe>",
		    closable:true
		});
	}
	
	// 病害上报 查询  当前 部门 下的 所有上报 
	function bhsb(){
		$("#yhbg_tt").tabs("close","病害上报");
		$('#yhbg_tt').tabs('add',{
		    title:'病害上报',
		    content:"<iframe class='mapParentWindow' width='100%' height='100%' style='border:none;margin:0px;padding:0px;overflow-y:hidden;' src='${pageContext.request.contextPath}/rcyh/bh_index.do?fromSb=true'></iframe>",
		    closable:true
		});
	}
	
	// 病害派工
	function bhpg(){
		$("#yhbg_tt").tabs("close","病害派工");
		$('#yhbg_tt').tabs('add',{
		    title:'病害派工',
		    content:"<iframe class='mapParentWindow' id='bhpg_window_iframe' width='100%' height='100%' style='border:none;margin:0px;padding:0px;overflow-y:hidden;' src='${pageContext.request.contextPath}/rcyh/bh_index.do?fromPg=true'></iframe>",
		    closable:true
		});
	}
	
	// 病害维修
	function bhwx(){
		$("#yhbg_tt").tabs("close","作业维修");
		$('#yhbg_tt').tabs('add',{
		    title:'作业维修',
		    content:"<iframe class='mapParentWindow' width='100%' height='100%' style='border:none;margin:0px;padding:0px;overflow-y:hidden;' src='${pageContext.request.contextPath}/rcyh/wxzy_index.do'></iframe>",
		    closable:true
		});
		
	}
	
	// 维修上报
	function wxsb(){
		$("#yhbg_tt").tabs("close","作业上报");
		$('#yhbg_tt').tabs('add',{
		    title:'作业上报',
		    content:"<iframe class='mapParentWindow'  width='100%' height='100%' style='border:none;margin:0px;padding:0px;overflow-y:hidden;' src='${pageContext.request.contextPath}/rcyh/wxzy_wxzy.do'></iframe>",
		    closable:true
		});
	}
	
	// 维修验收
	function wxys(){	
		$("#yhbg_tt").tabs("close","作业验收");
		$('#yhbg_tt').tabs('add',{
		    title:'作业验收',
		    content:"<iframe width='100%' height='100%' style='border:none;margin:0px;padding:0px;overflow-y:hidden;' src='${pageContext.request.contextPath}/rcyh/wxzy_weixiuys.do'></iframe>",
		    closable:true
		});
	}
	
</script>
</head>
<body>
	<div id="p-tools">
		<a href="javascript:void(0)" class="icon-mini-refresh" onclick="$('#iframe_tab_xdjl')[0].contentWindow.location.reload()"></a>
	</div>
	<div id="yhbg_tt" style="overflow-y:hidden;min-width:1024px" class="easyui-tabs" data-options="fit:true,onSelect:function(title,index){
		remember.ask(false);
	},onClose:function(){
	   remember.canAsk = true;
	   remember.ask(false);
	}
	">
	    <div title="首页" style="padding:20px;" >
	       		<div class="yhbg2_con">
				<s:if test="mks.mid010101">
			     <div class="yhbg2_001"  onclick="viewXdjl()" >
				      <div class="yhbg2_001_out" onmouseover="this.className='yhbg2_001_hover'" onmouseout="this.className='yhbg2_001_out'">
			                <h1>巡道记录</h1>
			          </div>
			     </div>
			     </s:if>
			     <s:else>
				     <div class="yhbg2_001">
					      <div class="yhbg2_001_grey">
				                <h1>巡道记录</h1>
				          </div>
				     </div>
			     </s:else>
			     
			     <div class="yhbg2_arrow1"></div>
			   
			     <s:if test="mks.mid010102">
			     <div class="yhbg2_002"  onclick="bhsb()">
				      <div class="yhbg2_002_out" onmouseover="this.className='yhbg2_002_hover'" onmouseout="this.className='yhbg2_002_out'">
			                <h2>病害上报</h2>
			                <div class="yhbg2_font">需上报病害数量：</br><span id="num2"><s:property value="bhsbTasks.size()" /></span></div>
			          </div>
			     </div>
			     </s:if>
			     <s:else>
			     <div class="yhbg2_002">
				      <div class="yhbg2_002_grey">
			                <h2>病害上报</h2>
			                <div class="yhbg2_font">需上报病害数量：</br><span>-</span></div>
			          </div>
			     </div>
			     </s:else>
			     
			     <div class="yhbg2_arrow2"></div>
			     
			     <s:if test="mks.mid010103">
			     <div class="yhbg2_003" onclick="bhpg()" >
				      <div class="yhbg2_003_out" onmouseover="this.className='yhbg2_003_hover'" onmouseout="this.className='yhbg2_003_out'">
			                <h3>病害派工</h3>
			                <div class="yhbg2_font">需派工病害数量：</br><span id="num3"><s:property value="bhpgTasks.size()" /></span></div>
			          </div>
			     </div>
			     </s:if>
			     <s:else>
			     <div class="yhbg2_003">
				      <div class="yhbg2_002_grey">
			                <h3>病害派工</h3>
			                <div class="yhbg2_font">需派工病害数量：</br><span>-</span></div>
			          </div>
			     </div>
			     </s:else>
			     
			     <div class="yhbg2_arrow3"></div>
			     
			     <s:if test="mks.mid010104">
			     <div class="yhbg2_004" onclick="bhwx()">
				      <div class="yhbg2_004_out" onmouseover="this.className='yhbg2_004_hover'" onmouseout="this.className='yhbg2_004_out'">
			                <h4>病害维修</h4>
			                <div class="yhbg2_font">需维修病害数量：</br><span id="num4"><s:property value="bhwxTasks.size()" /></span></div>
			          </div>
			     </div>
			     </s:if>
			     <s:else>
			     <div class="yhbg2_004">
				      <div class="yhbg2_002_grey">
			                <h4>病害维修</h4>
			                <div class="yhbg2_font">需维修病害数量：</br><span>-</span></div>
			          </div>
			     </div>
			     </s:else>
			     
			     <div class="yhbg2_arrow4"></div>
			     
			     <s:if test="mks.mid010105">
			     <div class="yhbg2_005"  onclick="wxsb()">
				      <div class="yhbg2_005_out" onmouseover="this.className='yhbg2_005_hover'" onmouseout="this.className='yhbg2_005_out'">
			                <h5>维修上报</h5>
			                <div class="yhbg2_font">需上报作业数量：</br><span id="num5"><s:property value="wxsbTasks.size()" /></span></div>
			          </div>
			     </div>
			     </s:if>
			     <s:else>
			     <div class="yhbg2_005">
				      <div class="yhbg2_002_grey" ">
			                <h5>维修上报</h5>
			                <div class="yhbg2_font">需上报作业数量：</br><span>-</span></div>
			          </div>
			     </div>
			     </s:else>
			     
			     <div class="yhbg2_arrow5"></div>
			     <s:if test="mks.mid010106">
			     <div class="yhbg2_006" onclick="wxys()" >
				      <div class="yhbg2_006_out" onmouseover="this.className='yhbg2_006_hover'" onmouseout="this.className='yhbg2_006_out'">
			                <h6>作业验收</h6>
			                <div class="yhbg2_font">需验收作业数量：</br><span id="num6"><s:property value="wxysTasks.size()" /></span></div>
			          </div>
			     </div>
				 </s:if>
				 <s:else>
				  <div class="yhbg2_006">
				      <div class="yhbg2_002_grey">
			                <h6>作业验收</h6>
			                <div class="yhbg2_font">需验收作业数量：</br><span>-</span></div>
			          </div>
			     </div>
				 </s:else>
			</div>
	    </div>
	</div>	
<script>
	
	var container =  $(".yhbg2_con");
	var body =  $("body");
	var c_h = container.height();
	var c_w = container.width();
	var b_h = body.height();
	var b_w = body.width();
	var c_left = 0;
	var c_top = 0;
	
	if( c_h < b_h ) {
		c_top = ( b_h - c_h ) / 2 ;
	}
	
	if( c_w < b_w ) {
		c_left = ( b_w - c_w ) / 2 ;
	}

	container.css({"position":"absolute","top":c_top+"px","left":c_left+"px"});
</script>
</body>
</html>
