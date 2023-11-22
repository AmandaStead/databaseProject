<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Reply</title>
</head>
<body>
<%
    String id = (String) request.getAttribute("id");
    String date = (String) request.getAttribute("date");
    String totalcost =  request.getParameter("totalcost");
%>
    <h1>Reply for Quote Dated <%= date %></h1>
    

    
    <form action="customerquoteedit" method="post">
        <!-- Hidden input field to store quoteid -->
        <input type="hidden" name="quoteid" value="<%= id %>">

        
        <label for="customerDecision">'Agree', 'Disagree', or 'Quit':</label>
        <input type='text' name="customerDecision" id="customerDecision" required><br>
        
        
        
        

        
        <input type="submit" value="Submit Value">
    </form>

    
    <h2>Create Order Of Work</h2>
    <form action="insertorderofwork" method="post">
        
        <input type="hidden" name="quoteid" value="<%= id %>">

        
        <label for="date">Date to be Serviced:</label>
        <input type="text" name="date" id="date" value=<%= date %>><br>

         <label for="price">Final Price:</label>
        <input type="text" name="price" id="price" value="<%= totalcost %>" required><br>
        
        <!-- Submit button for creating OrderOfWork -->
        <input type="submit" value="Agree and Create Order of Work">
    </form>
</body>
</html>
