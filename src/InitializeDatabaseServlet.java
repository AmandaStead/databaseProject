import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class InitializeDatabaseServlet {
	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Check if the user is authorized (in a real application, you should have proper authentication logic)
	        boolean isRootUser = true; // For demonstration purposes, assuming the user is the root user

	        if (isRootUser) {
	            // Database connection parameters
	            String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
	            String jdbcUsername = "your_username";
	            String jdbcPassword = "your_password";

	            try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
	                 Statement statement = connection.createStatement()) {
	                // Delete existing tables (in a real application, you might want to drop tables carefully)
	                statement.executeUpdate("DROP TABLE IF EXISTS Table1, Table2, Table3");

	                // Create new tables
	                statement.executeUpdate("CREATE TABLE Table1 (ID INT PRIMARY KEY, Name VARCHAR(255));");
	                statement.executeUpdate("CREATE TABLE Table2 (ID INT PRIMARY KEY, Description TEXT);");
	                statement.executeUpdate("CREATE TABLE Table3 (ID INT PRIMARY KEY, Value DECIMAL(10, 2));");

	                // Insert sample data
	                statement.executeUpdate("INSERT INTO Table1 (ID, Name) VALUES (1, 'John'), (2, 'Alice'), (3, 'Bob');");
	                statement.executeUpdate("INSERT INTO Table2 (ID, Description) VALUES (1, 'Description 1'), (2, 'Description 2');");
	                statement.executeUpdate("INSERT INTO Table3 (ID, Value) VALUES (1, 100.50), (2, 75.25);");

	                response.getWriter().println("Database initialized successfully.");
	            } catch (Exception e) {
	                e.printStackTrace();
	                response.getWriter().println("Error initializing database: " + e.getMessage());
	            }
	        } else {
	            response.getWriter().println("Unauthorized access.");
	        }
	    
	}
}
