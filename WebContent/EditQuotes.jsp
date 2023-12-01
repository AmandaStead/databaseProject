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
        <textarea name="custnote" id="custnote" rows="4"></textarea><br>
        
        <label for="supplierDecision">Decision ('Agree', 'Disagree', or 'Quit'):</label>
        <input type="text" name="supplierDecision" id="supplierDecision" required><br>
        
        <label for="scheduleend">Schedule End Date: ('2020-01-04 12:00:00'):</label>
        <input type="text" name="scheduleend" id="scheduleend" required><br>

        <input type="submit" value="Submit Quote">
    </form>

 
