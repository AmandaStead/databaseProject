<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    String dynamicUrl = "https://images.unsplash.com/photo-1444492417251-9c84a5fa18e0?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8b3V0ZG9vcnxlbnwwfHwwfHx8MA%3D%3D";
    String linkText = "Visit Example Website";
%>

<a href="<%= dynamicUrl %>" target="_blank"><%= linkText %></a>

</body>
</html>