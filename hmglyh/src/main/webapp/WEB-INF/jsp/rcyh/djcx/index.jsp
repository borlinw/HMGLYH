<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../public/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>冬季除雪</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rcyh.css" />
</head>
<body>
<div class="djcx_con" style="margin-top: 20px" >
	 <div class="djcx_001">
          <a href="${pageContext.request.contextPath }/page/rcyh/djcx/cxkbGrid.jsp?bmcode=<s:property value='user.bmcode' />" >
	          <div class="djcx_img"><img src="${pageContext.request.contextPath}/images/djcx_001.png" onmouseover="this.src='${pageContext.request.contextPath}/images/djcx_001_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/djcx_001.png'" width="140" height="120" border="0"></div>
	          <div class="djcx_font">冬季除雪快报</div>
          </a>
          <div class="djcx_bg"></div>
     </div>

	 <div class="djcx_002">
          <div class="djcx_bg2"></div>
          <!-- <a href="/hmglyh/ReportServer?reportlet=djcxylb.cpt" > -->
          <a href="${pageContext.request.contextPath }/page/rcyh/djcx/cxylb.jsp" >
	          <div class="djcx_font">除雪一览表</div>
	          <div class="djcx_img"><img src="${pageContext.request.contextPath}/images/djcx_002.png" onmouseover="this.src='${pageContext.request.contextPath}/images/djcx_002_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/djcx_002.png'" width="140" height="120" border="0"></div>
          </a>
     </div>

	 <div class="djcx_003">
          <%-- <a href="/hmglyh/ReportServer?reportlet=cxhzb.cpt&bmcode=<s:property value='user.bmcode' />&username=<s:property value='user.username' />&op=write" > --%>
          <a href="${pageContext.request.contextPath }/page/rcyh/djcx/cxhzb.jsp" >
	          <div class="djcx_img"><img src="${pageContext.request.contextPath}/images/djcx_003.png" onmouseover="this.src='${pageContext.request.contextPath}/images/djcx_003_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/djcx_003.png'" width="140" height="120" border="0"></div>
	          <div class="djcx_font">除雪汇总表</div>
          </a>
          <div class="djcx_bg"></div>
     </div>

	 <div class="djcx_004">
          <div class="djcx_bg2"></div>
          <!-- <a href="/hmglyh/ReportServer?reportlet=cxfyfx1.cpt&op=view"> -->
          <a href="${pageContext.request.contextPath }/page/rcyh/djcx/cxzbfx.jsp" >
	          <div class="djcx_font">除雪费用占比分析</div>
	          <div class="djcx_img"><img src="${pageContext.request.contextPath}/images/djcx_004.png" onmouseover="this.src='${pageContext.request.contextPath}/images/djcx_004_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/djcx_004.png'" width="140" height="120" border="0"></div>
          </a>
     </div>

	 <div class="djcx_005">
          <!-- <a href="/hmglyh/ReportServer?reportlet=cxfyfx2.cpt&op=view"> -->
          <a href="${pageContext.request.contextPath }/page/rcyh/djcx/cxdbfx.jsp" >
	          <div class="djcx_img"><img src="${pageContext.request.contextPath}/images/djcx_005.png" onmouseover="this.src='${pageContext.request.contextPath}/images/djcx_005_hover.png'" onmouseout="this.src='${pageContext.request.contextPath}/images/djcx_005.png'" width="140" height="120" border="0"></div>
	          <div class="djcx_font">除雪费用对比分析</div>
          </a>
          <div class="djcx_bg"></div>
     </div>

</div>
</body>
</html>
