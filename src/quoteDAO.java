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
    //public List<quote> Allquotes() throws SQLException {
      //  List<quote> quotes = new ArrayList<>();        
        //String sql = "SELECT * FROM quote";      
        //connect_func();      
        //statement = (Statement) connect.createStatement();
        //ResultSet resultSet = statement.executeQuery(sql);
         
        //while (resultSet.next()) {
        	//int quoteid = resultSet.getInt("quoteid");
            //int serviceid = resultSet.getInt("serviceid");
            //int customerid = resultSet.getInt("customerid");
            //String quotedate  = resultSet.getString("quotedate");
            //int totalcost = resultSet.getInt("totalcost");
            
            
            //quote quotelist = new quote(quoteid, serviceid, customerid, quotedate, totalcost);
            //quotes.add(quotelist);
        
        //}  
 
           
        //resultSet.close();
        //disconnect();        
        //return quotes;
        //}

protected void disconnect() throws SQLException {
    if (connect != null && !connect.isClosed()) {
    	connect.close();
    }
}
public void createQuote(quote quote) {
    String sql = "INSERT INTO quote (ServiceID, CustomerID, QuoteDate, TotalCost) VALUES (?, ?, ?, ?)";
    try (PreparedStatement statement = connect.prepareStatement(sql)) {
        statement.setInt(1, quote.getServiceID());
        statement.setInt(2, quote.getCustomerID());
        statement.setString(3, quote.getQuoteDate());
        statement.setDouble(4, quote.getTotalCost());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();}
    }
public quote getQuoteById(int quoteID) {
    String sql = "SELECT * FROM Quote WHERE QuoteID = ?";
    try (PreparedStatement statement = connect.prepareStatement(sql)) {
        statement.setInt(1, quoteID);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return returnData(resultSet);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
private quote returnData(ResultSet resultSet) throws SQLException {
    quote quote = new quote();
    quote.setQuoteID(resultSet.getInt("QuoteID"));
    quote.setServiceID(resultSet.getInt("ServiceID"));
    quote.setCustomerID(resultSet.getInt("CustomerID"));
    quote.setQuoteDate(resultSet.getString("QuoteDate"));
    quote.setTotalCost(resultSet.getDouble("TotalCost"));
    return quote;
}


























}

    
    







