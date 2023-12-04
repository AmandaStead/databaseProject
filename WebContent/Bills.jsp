<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bills</title>
</head>
<body>

<div align = "center">
	
	
	
	
	
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	
	
	

<h1>List Bills</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            
            <tr>
            	  <th>id</th>
                <th>orderid</th>
                <th>price</th>
                <th>discount</th>
                <th>balance</th>
                <th>status</th>
                <th>curdate</th>
                <th>generated_date</th>
               
                
            </tr>
            <c:forEach var="quotes" items="${Bills}">
                <tr style="text-align:center">
                	<td>${quotes.id}</td>
                    <td>${quotes.orderid}</td>
                    <td>${quotes.price}</td>
                    <td>${quotes.discount}</td>
                    <td>${quotes.balance}</td>
                    <td>${quotes.status}</td>
                    <td>${quotes.curdate}</td>
                    <td>${quotes.generated_date}</td>
                    
                    
            </c:forEach>
            

            
   
	</div>
	</div>

</body>
</html>