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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/quoteDAO")
public class quoteDAO 
{
	private static final long serialVersionUID = 1L;
	public static Object insertquote;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public quoteDAO(){}
	
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
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trees?allowPublicKeyRetrieval=true&useSSL=false&user=John&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from user where email = ?";
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
    
    
    public List<quote> listAllquotes() throws SQLException {
        List<quote> listquote = new ArrayList<quote>();        
        String sql = "SELECT * FROM quote";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int serviceid = resultSet.getInt("serviceid");
            int customerid = resultSet.getInt("customerid");
            String date = resultSet.getString("date");
            double totalcost = resultSet.getDouble("totalcost");
            String custnote = resultSet.getString("custnote");
            int heightft = resultSet.getInt("heightft"); 
            

             
            quote quotes = new quote(serviceid, customerid, date, totalcost, custnote,  heightft);
            listquote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listquote;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insertquote(quote quotes) throws SQLException {
    	connect_func();         
		String sql = "insert into quote(quoteid, serviceid, customerid, date, totalcost,custnote, heightft) values (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, quotes.getQuoteID());
			preparedStatement.setInt(2, quotes.getServiceID());
			preparedStatement.setInt(3, quotes.getCustomerID());
			preparedStatement.setString(4, quotes.getDate());
			preparedStatement.setDouble(5, quotes.getTotalCost());
			preparedStatement.setString(6, quotes.getCustnote());		
			preparedStatement.setInt(7, quotes.getHeightFT());		
			
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean deletequote(int quoteid) throws SQLException {
        String sql = "DELETE FROM quote WHERE quoteid = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, quoteid);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean updatequote(quote quotes) throws SQLException {
        String sql = "update quote set quoteid=?, serviceid=?,customerid = ?,date=?,totalcost =?, custnote=?,heightft=? where quoteid = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, quotes.getQuoteID());
		preparedStatement.setInt(2, quotes.getServiceID());
		preparedStatement.setInt(3, quotes.getCustomerID());
		preparedStatement.setString(4, quotes.getDate());
		preparedStatement.setDouble(5, quotes.getTotalCost());
		preparedStatement.setInt(6, quotes.getHeightFT());		
		
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public quote getQuote(int quoteID) throws SQLException {
    	quote quote = null;
        String sql = "SELECT * FROM quote WHERE quoteid = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, quoteID);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            int serviceID = resultSet.getInt("serviceID");
            int customerID = resultSet.getInt("customerID");
            String date = resultSet.getString("date");
            double totalCost = resultSet.getDouble("totalCost"); 
            String custnote = resultSet.getString("custnote"); 
            int heightFT = resultSet.getInt("heightFT"); 
          
            quote = new quote(serviceID, customerID, date, totalCost, custnote,  heightFT);
        }
        resultSet.close();
        statement.close();
         
        return quote;
         
      
    }
    

    

    
    
    

   } 
        
        
      
    
    
    
	
	


