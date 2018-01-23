<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日常养护 - 查询统计</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rcyh.css" />
</head> 
<body> 
	<!-- <a href="rcyh_zyrwtzd.jsp">日常养护作业任务通知单</a>
	<a href="rcyh_ndxxjl.jsp">养护作业单位年度学习记录表</a>
	<a href="bhxxcx.jsp">病害信息查询</a>
	<a href="rwdxxcx.jsp">任务单信息查询</a>
	<a href="wxzyxxcx.jsp">维修作业信息查询</a>
	<a href="yrwwcqk.jsp">养护作业单位月任务完成情况表</a>
	<a href="scsgjl.jsp">养护作业单位生产施工记录表</a>
	<a href="wcqk.jsp">个人生产任务完成情况一览表</a>
	<a href="gzysd.jsp">日常养护工作验收单表</a>
	<a href="lmlf.jsp">公路养护站沥青路面裂缝修补工程数量统计表</a>
	<a href="lmxb.jsp">公路养护站（道班）沥青路面修补工程数量统计表</a> -->
	<div class="cxtj_con">
		<div class="cxtj_list">
			<a href="${pageContext.request.contextPath}/rcyh/xdjl_xdcx.do">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_014.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_014_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_014.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">巡道记录<br>信息查询</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="${pageContext.request.contextPath}/rcyh/bh_bhcx.do">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_001.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_001_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_001.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">巡道病害<br>信息查询</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="${pageContext.request.contextPath}/rcyh/wxzy_rwdcx.do">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_002.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_002_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_002.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">任务单<br>信息查询</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="${pageContext.request.contextPath}/rcyh/wxzy_wxzycx.do">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_003.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_003_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_003.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">维修作业<br>信息查询</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="rcyh_zyrwtzd.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_004.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_004_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_004.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">日常养护作业<br>任务通知单</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="yrwwcqk.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_005.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_005_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_005.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">月任务<br>完成情况表</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="scsgjl.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_006.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_006_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_006.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">生产施工<br>记录表</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="wcqk.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_007.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_007_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_007.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">个人生产任务<br>完成情况一览表</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="gzysd.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_008.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_008_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_008.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">日常养护工作<br>验收单表</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="lmlf.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_009.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_009_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_009.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">沥青路面裂缝修补<br>工程数量统计表</div>
			</a>
		</div>
		
		<div class="cxtj_list">
			<a href="lmxb.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_010.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_010_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_010.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">沥青路面修补<br>工程数量统计表</div>
			</a>
		</div>
		<%-- <div class="cxtj_list">
			<a href="jassbhcdd.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_011.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_011_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_011.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">交安设施维修传递单</div>
			</a>
		</div>
		<div class="cxtj_list">
			<a href="jasswxslb.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_012.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_012_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_012.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">交安设施维修数量表</div>
			</a>
		</div>
		<div class="cxtj_list">
			<a href="jasswxtjb.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_013.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_013_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_013.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">交安设施维修统计表</div>
			</a>
		</div> --%>
		<div class="cxtj_list">
			<a href="xxbywcqk.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_005.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_005_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_005.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">公路小修保养完成情况表</div>
			</a>
		</div>
		<div class="cxtj_list">
			<a href="qhwxjl.jsp">
				<div class="cxtj_list_img"><img src="${pageContext.request.contextPath}/images/cxtj_003.png" onmouseover="this.src='${pageContext.request.contextPath}/images/cxtj_003_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/cxtj_003.png'" width="86" height="86" border="0"></div>
				<div class="cxtj_list_font">桥涵维修记录表</div>
			</a>
		</div>
	</div>
</body>
</html>
