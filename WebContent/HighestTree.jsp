<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Highest Tree</title>
</head>
<body>

<div align = "center">
	
	
	
	
	
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	
	

<h1>List Highest Tree</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            
            <tr>
            	<th>id</th>
            	<th>Quoteid</th>
                <th>Size</th>
                <th>Height</th>
                <th>Distance from house</th>
                
            </tr>
            <c:forEach var="trees" items="${HighestTree}">
                <tr style="text-align:center">
                	<td>${trees.id}</td>
                	<td>${trees.quoteid}</td>
                    <td>${trees.size}</td>
                    <td>${trees.height}</td>
                    <td>${trees.distancefromhouse}</td>
                    
            </c:forEach>
            

            
   
	</div>
	</div>

</body>
</html>