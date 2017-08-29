<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
	 response.reset();  
	 String path = new String(request.getParameter("path").getBytes("iso-8859-1"),"utf-8");  
	 System.out.println(path);  
	 response.setContentType("application/vnd.ms-excel");  
	 InputStream ips = new FileInputStream(path);  //<---你的excel文件  
	 OutputStream ops = response.getOutputStream();  
	   
	 int data = -1;  
	 while((data = ips.read()) != -1) {  
	   
	 ops.write(data);  
	 }  
	   
	 ops.flush();%>  
</body>
</html>