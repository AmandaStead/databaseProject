<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
        
        <form action="getQuote" method="post">
            <label for="quoteID">Select Quote:</label>
            <input type='text' name="quoteID" id="quoteID" required><br>
            <!-- Hidden input field to capture the quote ID -->
            <input type="hidden" name="quoteID" id="hiddenQuoteID" value="">
            <input type="submit" value="Submit" name="submitButton" onclick="captureQuoteID()">
        </form>
        
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
                <td><c:out value="${quote.clientDecision}" /></td>
                <td><c:out value="${quote.supplierDecision}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
function captureQuoteID() {
    // Get the quote ID entered by the user
    var quoteID = document.getElementById("quoteID").value;
    
    // Check if the quoteID is empty or null
    if (quoteID) {
        // Set the value of the hidden input field
        document.getElementById("hiddenQuoteID").value = quoteID;
    } else {
        alert("Please enter a valid quote ID.");
    }
}

</script>
</body>
</html>
