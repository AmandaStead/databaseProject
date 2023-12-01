<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>
<body>

<div align = "center">
	
	
	
	
	
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	
	
	

<h1>List Big Clients</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            
            <tr>
            	  <th>First Name</th>
                <th>Last Name</th>
                <th>Customer ID</th>
                <th>Quote ID</th>
                <th>Customer ID</th>
                <th>Tree Count</th>
            </tr>
            <c:forEach var="BigClient" items="${BigClients}">
                <tr style="text-align:center">
                	<td>${BigClient.firstname}</td>
                    <td>${BigClient.lastname}</td>
                    <td>${BigClient.customerid}</td>
                    <td>${BigClient.quoteid}</td>
                    <td>${BigClient.quote_customerid}</td>
                    <td>${BigClient.tree_count}</td>
            </c:forEach>
            

            
   
	</div>
	</div>

</body>
</html>