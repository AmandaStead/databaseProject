<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bad Clients</title>
</head>
<body>

<div align = "center">
	
	
	
	
	
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	
	
	

<h1>List Bad clients</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            
            <tr>
            	  <th>customerid</th>
                <th>firstname</th>
                <th>lastname</th>
                <th>status</th>
                <th>generated_date</th>
                <th>curdate</th>
                
              
               
                
            </tr>
            <c:forEach var="quotes" items="${BadClients}">
                <tr style="text-align:center">
                	<td>${quotes.customerID}</td>
                    <td>${quotes.firstname}</td>
                    <td>${quotes.lastname}</td>
                    <td>${quotes.status}</td>
                    <td>${quotes.generated_date}</td>
                    <td>${quotes.curdate}</td>
                    
                    
                    
            </c:forEach>
            

            
   
	</div>
	</div>

</body>
</html>