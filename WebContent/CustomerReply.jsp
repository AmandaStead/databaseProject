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
    
    String schedulestart = request.getParameter("schedulestart");
    String scheduleend = request.getParameter("scheduleend");
    String totalcost = request.getParameter("totalcost");
%>
    <h1>Reply for Quote Dated <%= date %></h1>

   
    <form action="customerquoteedit" method="post">
       
        <input type="hidden" name="quoteid" value="<%= id %>">
        
        
        <label for="customerDecision">'Agree', 'Disagree', or 'Quit':</label>
        <input type='text' name="customerDecision" id="customerDecision" required><br>

       
        <input type="submit" value="Submit Value">
    </form>

   
    <h2>Create Order Of Work</h2>
    <form action="insertorderofwork" method="post">
       
        <input type="hidden" name="quoteid" value="<%= id %>">

        
        <label for="schedulestart">Schedule Start:</label>
        <input type="text" name="schedulestart" id="schedulestart" value="<%= schedulestart %>"><br>

        <label for="scheduleend">Schedule End:</label>
        <input type="text" name="scheduleend" id="scheduleend" value="<%= scheduleend %>"><br>

        <label for="price">Final Price:</label>
        <input type="text" name="price" id="price" value="<%= totalcost %>" required><br>

      
        <input type="submit" value="Agree and Create Order of Work">
    </form>
</body>
</html>
 

