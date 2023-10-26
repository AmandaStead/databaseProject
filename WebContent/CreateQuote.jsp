<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New Quote</title>
</head>
<body>
    <h1>Create New Quote</h1>

    <form action="createquote" method="post">
        <label for="serviceID">Service ID:</label>
        <input type="text" name="serviceID" id="serviceID" required><br>

        <label for="customerID">Customer ID:</label>
        <input type="text" name="customerID" id="customerID" required><br>

        <label for="date">Date:</label>
        <input type="text" name="date" id="date" required><br>

        <label for="totalCost">Total Cost:</label>
        <input type="text" name="totalCost" id="totalCost" required><br>

        <label for="custnote">Customer Note:</label>
        <textarea name="custnote" id="custnote" rows="4" required></textarea><br>

        <label for="heightFT">Height (in Feet):</label>
        <input type="text" name="heightFT" id="heightFT" required><br>

        <input type="submit" value="Submit Quote">
    </form>
</body>
</html>










