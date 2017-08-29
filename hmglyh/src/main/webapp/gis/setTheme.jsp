<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更换easyui主题</title>
</head>
<body>
	 <%
	 
	 String theme = request.getParameter("theme");
	 request.setAttribute("theme", theme);
	 
    // 获得当前路径以及"直接父路径"的所有Cookie对象,如果没有任何Cookie的话,则返回null  
    Cookie[] cookies = request.getCookies();
    
  	boolean isFound = false;
  	
     // 遍历数组,获得具体的Cookie
     if(cookies == null) {
    	 Cookie cookie = new Cookie("easyui_theme",theme);
         cookie.setMaxAge(60*60*24*365);
         response.addCookie(cookie);
     } else {
         for(int i=0; i<cookies.length; i++) {
            // 获得具体的Cookie
            Cookie cookie = cookies[i];
            // 获得Cookie的名称
            String name = cookie.getName();
            if("easyui_theme".equals(name)) {
            	 cookie.setMaxAge(-1);
            	 response.addCookie(cookie);
            	 Cookie ncookie = new Cookie("easyui_theme",theme);
            	
                 cookie.setMaxAge(60*60*24*365);
                 response.addCookie(ncookie);
            	 isFound = true;
            }
         }
         
         if(!isFound) {
        	 Cookie cookie = new Cookie("easyui_theme",theme);
        //	 cookie.setDomain("/hmglyh/gis");
             cookie.setMaxAge(60*60*24*365);
             response.addCookie(cookie);
         }
     }
   
    
    
 %>
 
  当前主题：${theme} <br> 
<a href="#" onclick="reload()">点击刷新页面</a>
 	<script>
 		function reload(){
 			top.location.reload();
 		}
 	</script>
</body>
</html>