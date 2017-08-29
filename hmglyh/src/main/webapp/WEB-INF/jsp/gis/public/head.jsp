<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <%
     // 获得当前路径以及"直接父路径"的所有Cookie对象,如果没有任何Cookie的话,则返回null  
     Cookie[] cookies = request.getCookies();
    
  	boolean isFound = false;
  	
     // 遍历数组,获得具体的Cookie
     if(cookies == null) {
        //out.print("没有Cookie信息");
    	 Cookie cookie = new Cookie("easyui_theme", "hdstyle");
         cookie.setMaxAge(60*60*24*365);
         request.setAttribute("easyui_theme","hdstyle");
         response.addCookie(cookie);
     } else {
         for(int i=0; i<cookies.length; i++) {
            // 获得具体的Cookie
            Cookie cookie = cookies[i];
            // 获得Cookie的名称
            String name = cookie.getName();
            
            if("easyui_theme".equals(name)) {
            	 String value = cookie.getValue();
            	 request.setAttribute("easyui_theme", value);
            	 isFound = true;
            }
         }
         
         if(!isFound) {
       	  request.setAttribute("easyui_theme","hdstyle");
       /*	  Cookie cookie = new Cookie("easyui_theme", "hdstyle");
             cookie.setMaxAge(60*60*24*365);
             request.setAttribute("easyui_theme","hdstyle");
             response.addCookie(cookie); */
        }
     }
   
    
     
   //  request.setAttribute("gispath",application.getInitParameter("gispath"));
     
 %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/gis/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/gis/js/easyui-1.3.2/themes/${easyui_theme}/easyui2.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/gis/js/easyui-1.3.2/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/easyui-1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/tools.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script>
