<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activity page</title>
</head>

<center><h1>Welcome! You have been successfully logged in</h1> </center>

 
	<body>
	 <center>
		 <a href="login.jsp"target ="_self" > Logout</a><br><br> 
		 <a href="CreateQuote.jsp"target ="_self" > Request a Quote</a><br><br> 
		 <form action = "userQuoteView">
		<input type = "submit" value = "View your quotes"/>
	</form>
		
	</form>
		
		 <p> Welcome, please select an action! </p>
		 </center>
		 
	<title>All Quotes list</title>
</head>
<body>


		
   <div align="center">
        