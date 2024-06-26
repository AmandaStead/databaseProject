<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>All Quotes list</title>
</head>
<body>
   <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Quotes</h2></caption>
            <tr>
				<th>QuoteID</th>
                
                
                <th>CustomerID</th>
                <th>schedulestart</th>
                <th>scheduleend</th>
                <th>Date</th>
                <th>TotalCost</th>
                <th>Note</th>
                <th>HeightFT</th>
                <th>diameter_width</th>
                <th>ft_from_house</th>
                <th>location</th>
                <th>tree_count</th>
                <th>clientDecision</th>
                <th>supplierDecision</th>
                

            </tr>
           
              <a href="EditQuotes.jsp" target="_self">Edit Quotes</a>
              
              <br><a href="ownerView.jsp" target="_self">Return to Dashboard</a><br>
              
              <a href="login.jsp" target="_self">Log Off</a>
        <c:forEach var="quote" items="${listquote}">
            <tr style="text-align:center">
            <td><c:out value="${quote.quoteID}" /></td>
                
                <td><c:out value="${quote.customerID}" /></td>
                
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
                <td> <a href="customerreply?id=${quote.quoteID}&date=${quote.date}&schedulestart=${quote.schedulestart}&scheduleend=${quote.scheduleend}" target="_self"><input type="button" value="${quote.clientDecision}" disabled /></a></td>
                <td> <a href="supplierreply?id=${quote.quoteID}&date=${quote.date}&schedulestart=${quote.schedulestart}&scheduleend=${quote.scheduleend}" target="_self"><input type="button" value="${quote.supplierDecision}" /></a></td>
               
            </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>