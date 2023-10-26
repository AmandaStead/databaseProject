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
	
	<form action = "listquote">
		
	</form>
	<a href="login.jsp"target ="_self" > logout</a><br><br> 

<h1>List all Quotes</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
               <th>Quote ID</th>
            <th>Service ID</th>
            <th>Customer ID</th>
            <th>Date</th>
            <th>Total Cost</th>
            <th>Customer Note</th>
            <th>Height (FT)</th>
            </tr>
            <c:forEach var="quotes" items="${listquote}">
                <tr style="text-align:center">
                    <td><c:out value="${quotes.quoteID}" /></td>
                    <td><c:out value="${quotes.serviceID}" /></td>
                    <td><c:out value="${quotes.customerID}" /></td>
                    <td><c:out value= "${quotes.date}" /></td>
                    <td><c:out value="${quotes.totalCost}" /></td>
                    <td><c:out value="${quotes.custnote}" /></td>
                    <td><c:out value="${quotes.heightFT}"/></td>
                    
            </c:forEach>
        </table>
	</div>
	</div>

</body>
</html>