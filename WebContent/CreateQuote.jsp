<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request a Quote </title>
</head>
<body>

    <h1>Request a Quote, please fill out the information</h1>

    <form action="createquote" method="post">
      
 	
 		
 		
        <label for="date">Today's Date:</label>
        <input type="text" name="date" id="date" required><br>
        
        
        <label for="schedulestart">Start Date and Time: "2000-01-01 10:00:00"</label>
        <input type="text" name="schedulestart" id="schedulestart"><br>
       

        <label for="photo">Upload Photo:</label>
        <input type="file" name="photo" id="photo"><br>
        

        <label for="custnote">Note:</label>
        <textarea name="custnote" id="custnote" rows="4"></textarea><br>

        <label for="heightFT">Height (in Feet):</label>
        <input type="text" name="heightFT" id="heightFT" required><br>
        
         <label for="diameter_width">Diameter_width:</label>
        <input type="text" name="diameter_width" id="diameter_width" required><br>
        
         <label for="ft_from_house">ft_from_house:</label>
        <input type="text" name="ft_from_house" id="ft_from_house" required><br>
        
         <label for="location">location:</label>
        <input type="text" name="location" id="location" required><br>
        
        <label for="tree_count">tree_count:</label>
        <input type="text" name="tree_count" id="tree_count" required><br>

        <input type="submit" value="Submit Quote">
    </form>
</body>
</html>
