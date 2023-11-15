<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Quotes</title>
</head>
<body>
    <h1>Edit Quote</h1>

    <!-- Form for editing quote -->
    <form action="editquote" method="post">
        <label for="quoteid">Quote ID:</label>
        <input type="text" name="quoteid" id="quoteid" required><br>
        
        <label for="totalcost">Price Estimate:</label>
        <input type="text" name="totalcost" id="totalcost" required><br>
        
        <label for="custnote">Note:</label>
        <textarea name="custnote" id="custnote" rows="4" required></textarea><br>
        
        <label for="supplierDecision">Decision ('Agree', 'Disagree', or 'Quit'):</label>
        <input type="text" name="supplierDecision" id="supplierDecision" required><br>

        <input type="submit" value="Submit Quote">
    </form>

    <!-- Form for creating order of work -->
    <h2>Create Order Of Work</h2>
    <form action="insertorderofwork" method="post">
        <label for="quoteid">Quote ID:</label>
        <input type="text" name="quoteid" id="quoteid" required><br>

        <label for="date">Date to be Serviced:</label>
        <input type="text" name="date" id="date"><br>
        
        <label for="price">Final Price:</label>
        <input type="text" name="price" id="price" required><br>

        <input type="submit" value="Create Order of Work">
    </form>
</body>
</html>
