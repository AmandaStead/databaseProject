<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserView</title>
</head>
<body>

<div align = "center">




	<a href="login.jsp"target ="_self" > logout</a><br><br> 
	
		 
		<title>Your Quotes</title>
</head>
<body>
   <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Your Quotes</h2></caption>
            <tr>
				<th>QuoteID</th>
                <th>ServiceID</th>
                <th>offer_id</th>
                <th>CustomerID</th>
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
                <td><c:out value="${quote.date}" /></td>
                <td><c:out value="${quote.totalcost}" /></td>
                <td><c:out value="${quote.custnote}" /></td>
                <td><c:out value="${quote.heightFT}" /></td>
                <td><c:out value="${quote.diameter_width}" /></td>
                <td><c:out value="${quote.ft_from_house}" /></td>
                <td><c:out value="${quote.location}" /></td>
                <td><c:out value="${quote.tree_count}" /></td>
                <td> <a href="customerreply?id=${quote.quoteID}&date=${quote.date}" target="_self"><input type="button" value="${quote.clientDecision}" /></a></td>
                <td> <a href="supplierreply?id=${quote.quoteID}&date=${quote.date}" target="_self"><input type="button" value="${quote.supplierDecision}" /></a></td>
               
            </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>



</body>
</html>