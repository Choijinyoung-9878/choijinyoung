<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="8kb" autoFlush="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
   
  </style>
</head>
 <body>
	<h2>버퍼의 크기 : <%=out.getBufferSize() %></h2>
	<h2>버퍼의 남은 크기 : <%=out.getRemaining() %></h2>
	<%
		for(int i = 0; i <1000; i++){
			out.println("<h2>테스트함 : i = " + i + " 번째에서 남은 버퍼 크기  : " + out.getRemaining()+"<br>");
		}
		
	%>
    
 </body>
</html>