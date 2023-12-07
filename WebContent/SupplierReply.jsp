<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Customer Reply   </title>
</head>
<body>
<%
    String id = (String) request.getAttribute("id");
    String date = (String) request.getAttribute("date");
%>
    <h1>Reply for Quote Dated   <%= date %></h1>

    <form action="supplierquoteedit" method="post">
      

        

        <label for="quoteid">Quoteid:</label>
        <input type="text" name="quoteid" id="quoteid"   value=" <%= id %>" type="hidden"><br>
        
        
        
        
        
         <label for="Decision">'Agree', 'Disagree', or 'Quit':</label>
        <input type='text' name="SupplierDecision" id="SupplierDecision" required><br>
        

 <%
    String dynamicUrl = "https://images.unsplash.com/photo-1444492417251-9c84a5fa18e0?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8b3V0ZG9vcnxlbnwwfHwwfHx8MA%3D%3D";
    String linkText = "View Tree Photos";
%>
        
      

        <input type="submit" value="Submit Value">
        
        <br><a href="<%= dynamicUrl %>" target="_blank"><%= linkText %></a><br>
        
    </form>
</body>
</html>
