<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Quote</title>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Quote</h2></caption>
            <tr>
				<th>QuoteID</th>
                <th>ServiceID</th>
                <th>offer_id</th>
                <th>CustomerID</th>
                <th>schedulestart</th>
                <th>scheduleend</th>
                <th>Date</th>
                <th>TotalCost</th>
                <th>CustomerNote</th>
                <th>HeightFT</th>
                <th>diameter_width</th>
                <th>ft_from_house</th>
                <th>location</th>
                <th>tree_count</th>
                <th>clientDecision</th>
                <th>supplierDecision</th>
                

            </tr>

 <c:forEach var="quote" items="${listquote}">
            <tr style="text-align:center">
                <td><c:out value="${quote.quoteID}" /></td>
                <td><c:out value="${quote.serviceID}" /></td>
                <td><c:out value="${quote.customerID}" /></td>
                <td><c:out value="${quote.offer_id}" /></td>
                <td><c:out value="${quote.schedulestart}" /></td>
                <td><c:out value="${quote.scheduleend}" /></td>
                <td><c:out value="${quote.date}" /></td>
                <td><c:out value="${quote.totalcost}" /></td>
                <td><c:out value="${quote.custnote}" /></td>
                <td><c:out value="${quote.heightFT}" /></td>
                <td><c:out value="${quote.diameter_width}" /></td>
                <td><c:out value="${quote.ft_from_house}" /></td>
                <td><c:out value="${quote.location}" /></td>
                <td><c:out value="${quote.tree_count}" /></td>
                <td><c:out value="${quote.clientDecision}" /></td>
                <td><c:out value="${quote.supplierDecision}" /></td>
            </tr>
        </c:forEach>
    </table>

</head>
<body>

</body>
</html>