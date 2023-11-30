<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BigClients</title>
</head>
<body>
 <h2>Clients with Highest Tree Count</h2>

    <table border="1">
        <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Customer ID</th>
                <th>Quote ID</th>
                <th>Customer ID</th>
                <th>Tree Count</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${clientList}">
                <tr>
                    <td>${row.firstname}</td>
                    <td>${row.lastname}</td>
                    <td>${row.customerid}</td>
                    <td>${row.quoteid}</td>
                    <td>${row.quote_customerid}</td>
                    <td>${row.tree_count}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
</body>
</html>