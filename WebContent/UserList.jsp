<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>All User list</title>
</head>
<body>
   <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of People</h2></caption>
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
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
