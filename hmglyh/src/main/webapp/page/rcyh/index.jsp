<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日常养护管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script>
<script type="text/javascript" src="./js/index.js"></script> 
</head>
<body id="index_layout" class="easyui-layout" style="visibility: hidden">
	<div data-options="region:'north',border:false" style="height: 38px;overflow: hidden;text-align:left;font-size:13px;padding-top:5px">
		哈密公路管理局公路养护综合管理系统-日常养护管理系统
	</div>
	<div data-options="region:'west',border:'false'" style="overflow: hidden; width: 130px">
		<ul>
			<li kid="0101" style="display: none;" id="Li_1"><a id="Menu_1" href="javascript:void(0)">首页</a></li>
			<li kid="0102" style="display: none;" id="Li_2"><a id="Menu_2" href="javascript:void(0)">月度计划</a></li>
			<li kid="0103" style="display: none;" id="Li_3"><a id="Menu_3" href="javascript:void(0)">巡道记录</a></li>
			<li kid="0104" style="display: none;" id="Li_4"><a id="Menu_4" href="javascript:void(0)">病害录入</a></li>
			<li kid="0105" style="display: none;" id="Li_5"><a id="Menu_5" href="javascript:void(0)">病害上报</a></li>
			<li kid="0106" style="display: none;" id="Li_6"><a id="Menu_6" href="javascript:void(0)">任务派工</a></li>
			<li kid="0107" style="display: none;" id="Li_7"><a id="Menu_7" href="javascript:void(0)">维修作业</a></li>
			<li kid="0108" style="display: none;" id="Li_8"><a id="Menu_8" href="javascript:void(0)">作业上报</a></li>
			<li kid="0109" style="display: none;" id="Li_9"><a id="Menu_9" href="javascript:void(0)">维修验收</a></li>
			<li kid="0110" style="display: none;" id="Li_10"><a id="Menu_10" href="javascript:void(0)">冬季除雪</a></li>
			<!-- 将11的相关数据赋予“维修整改”，将原11的相关数据（查询统计）赋予12编号 -->
			<li kid="0111" style="display: none;" id="Li_11"><a id="Menu_11" href="javascript:void(0)">维修整改</a></li>
			<li kid="0112" style="display: none;" id="Li_12"><a id="Menu_12" href="javascript:void(0)">查询统计</a></li>
		</ul>
	</div>
	<div id="show" data-options="region:'center',border:'false'" style="margin: 0px; padding: 0px;overflow: hidden">
		<div id="c1" style="width:100%;height:100%;">
		    <iframe id="c1f" name="c1f"  src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c2" style="width:100%;height:100%;display:none">
		    <iframe id="c2f" name="c2f"  src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c3" style="width:100%;height:100%;display:none">
		    <iframe id="c3f" name="c3f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c4" style="width:100%;height:100%;display:none">
		    <iframe id="c4f" name="c4f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c5" style="width:100%;height:100%;display:none">
		    <iframe id="c5f" name="c5f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c6" style="width:100%;height:100%;display:none">
		    <iframe id="c6f" name="c6f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c7" style="width:100%;height:100%;display:none">
		    <iframe id="c7f" name="c7f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c8" style="width:100%;height:100%;display:none">
		    <iframe id="c8f" name="c8f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c9" style="width:100%;height:100%;display:none">
		    <iframe id="c9f" name="c9f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c10" style="width:100%;height:100%;display:none">
		    <iframe id="c10f" name="c10f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<div id="c11" style="width:100%;height:100%;display:none">
		    <iframe id="c11f" name="c11f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
		<!-- 配合“维修整改” -->
		<div id="c12" style="width:100%;height:100%;display:none">
		    <iframe id="c12f" name="c12f"src="" frameborder='0' height='99%' width='100%'></iframe>
		</div>
	</div>
	<div data-options="region:'south',border:false,split:false" style="height: 28px;text-align: center;overflow: hidden;padding-top:5px">
	新疆哈密公路管理局 &nbsp;&nbsp;版权所有&nbsp;&nbsp;&nbsp;&nbsp; 技术支持：恒达时讯科技（北京）有限公司
	</div>
</body>
</html>
