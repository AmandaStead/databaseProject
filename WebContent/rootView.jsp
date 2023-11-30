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
	
	<form action = "initialize">
		<input type = "submit" value = "Initialize the Database"/>
	</form>
	
	
	
	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	<a href="Statistics.jsp"target ="_self" > Statistics</a><br><br>
	
	

<h1>List all users</h1>
    <div align="center">
        <table border="1" cellpadding="6">
            <caption><h2>List of Users</h2></caption>
            <tr>
            	<th>customerid</th>
                <th>Email</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Adress</th>
                <th>Password</th>
                <th>Birthday</th>
                <th>cc_num</th>
                <th>cc_exp</th>
                <th>cc_cvv</th>
                <th>phone</th>
            </tr>
            <c:forEach var="users" items="${listUser}">
                <tr style="text-align:center">
                	<td><c:out value="${users.customerid}" /></td>
                    <td><c:out value="${users.email}" /></td>
                    <td><c:out value="${users.firstName}" /></td>
                    <td><c:out value="${users.lastName}" /></td>
                    <td><c:out value= "${users.adress_street_num} ${users.adress_street} ${users.adress_city} ${users.adress_state} ${users.adress_zip_code}" /></td>
                    <td><c:out value="${users.password}" /></td>
                    <td><c:out value="${users.birthday}" /></td>
                    <td><c:out value="${users.cc_num}" /></td>
                    <td><c:out value="${users.cc_exp}" /></td>
                    <td><c:out value="${users.cc_cvv}" /></td>
                    <td><c:out value="${users.phone}" /></td>
            </c:forEach>
            

            
   
	</div>
	</div>

</body>
</html>