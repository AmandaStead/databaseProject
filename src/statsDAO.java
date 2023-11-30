import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 * @param <BigClients>
 * @param <ClientInfo>
 */
@WebServlet("/statsDAO")
public class statsDAO
{
	private static final long serialVersionUID = 1L;
	private static final int customerid = 0;
	public static Object insertquote;
	public static Object insertorderfwork;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
	public statsDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trees?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","test");
    		String sql = "select * from User where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
	//connect to the database 
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/trees?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }

    public List<BigClients> BigClients() throws SQLException {
        List<BigClients> BigClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        connect_func();
            
            

            // Your SQL query to retrieve the required information
            String sql = "SELECT u.firstname, u.lastname, u.customerid, " +
                         "q.quoteid, q.customerid as quote_customerid, " +
                         "COUNT(t.id) as tree_count " +
                         "FROM user u " +
                         "JOIN quote q ON u.customerid = q.customerid " +
                         "JOIN tree t ON q.quoteid = t.quoteid " +
                         "GROUP BY u.customerid, q.quoteid " +
                         "ORDER BY tree_count DESC " +
                         "LIMIT 1";

            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
            
                
            	String firstname = resultSet.getString("firstname");
            	String lastname = resultSet.getString("lastname");
            	int customerid = resultSet.getInt("customerid");
                int quoteid = resultSet.getInt("quoteid");
                int quote_customerid = resultSet.getInt("quote_customerid");
                String tree_count = resultSet.getString("tree_count");
                
                
                
                BigClients BigClient = new BigClients(firstname,lastname,customerid,quoteid,quote_customerid,tree_count);
                BigClients.add(BigClient);
               
                
            }      
     
            resultSet.close();
            disconnect();        
            return BigClients;
        }
        protected void disconnect() throws SQLException {
            if (connect != null && !connect.isClosed()) {
            	connect.close();
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        




}
    
