<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statistics</title>
</head>
<body>

<div align = "center">
	
	
	
	
	
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	
	
	

<h1>List Statistics</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            
            <tr>
            	  <th>firstname</th>
                <th>lastname</th>
                <th>tree_count</th>
                <th>totalcost</th>
                <th>balance paid</th>
                <th>scheduleend</th>
                <th>status</th>
               
                
            </tr>
            <c:forEach var="quotes" items="${Statistics}">
                <tr style="text-align:center">
                	<td>${quotes.firstname}</td>
                    <td>${quotes.lastname}</td>
                    <td>${quotes.tree_count}</td>
                    <td>${quotes.totalcost}</td>
                    <td>${quotes.balance}</td>
                    <td>${quotes.scheduleend}</td>
                    <td>${quotes.status}</td>
                    
                    
                    
            </c:forEach>
            

            
   
	</div>
	</div>

</body>
</html>