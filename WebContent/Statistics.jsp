<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Table with Buttons</title>
    <style>
        table {
            width: 80%; /* Set the width of the table */
            border-collapse: collapse;
            margin: 20px; /* Add some margin for better appearance */
        }
        th, td {
            padding: 10px; /* Add padding to cells */
            text-align: center; /* Center-align cell content */
            border: 1px solid #ddd; /* Add borders to cells */
        }
        button {
            padding: 5px 10px; /* Add padding to buttons */
        }
    </style>
</head>
<body>

    <h2>Your Company At a Glance</h2>

    
            
                        <form action="ButtonActionServlet" method="post">
                            
                            <br><button type="submit">Big clients</button><br>
                            <br><button type="submit">Easy clients</button><br>
                            <br><button type="submit">Big clients</button><br>
                            <br><button type="submit">One tree quotes</button><br>
                            <br><button type="submit">Prospective clients</button><br>
                            <br><button type="submit">Highest tree</button><br>
                            <br><button type="submit">Overdue bills</button><br>
                            <br><button type="submit">Bad clients</button><br>
                            <br><button type="submit">Good clients</button><br>
                            <br><button type="submit">Statistics</button><br>
                        </form>
                    </td>
                </tr>
          
        </tbody>
    </table>

</body>
</html>