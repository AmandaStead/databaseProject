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
 */
@WebServlet("/quoteDAO")
public class quoteDAO 
{
	private static final long serialVersionUID = 1L;
	private static final int customerid = 0;
	public static Object insertquote;
	public static Object insertorderfwork;
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
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trees?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=pass1234");
            System.out.println(connect);
        }
    }
    public List<quote> Statistics() throws SQLException {
        List<quote> Statistics = new ArrayList<quote>();        
        String sql = "SELECT\r\n"
        		+ "    user.firstname,\r\n"
        		+ "    user.lastname,\r\n"
        		+ "    quote.tree_count,\r\n"
        		+ "    quote.totalcost,\r\n"
        		+ "    bills.balance,\r\n"
        		+ "    orderofwork.scheduleend,\r\n"
        		+ "    bills.status\r\n"
        		+ "FROM\r\n"
        		+ "    bills\r\n"
        		+ "JOIN\r\n"
        		+ "    orderofwork ON bills.orderid = orderofwork.quoteid\r\n"
        		+ "JOIN\r\n"
        		+ "    quote ON orderofwork.quoteid = quote.quoteid\r\n"
        		+ "JOIN\r\n"
        		+ "    user ON quote.customerID = user.customerID\r\n"
        		+ "WHERE\r\n"
        		+ "    bills.status = 'pending'"
        		+ "\r\n"
        		+ "\r\n"
        		+ "";  
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {        	
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String tree_count =resultSet.getString("tree_count");
            int totalcost = resultSet.getInt("totalcost");
            double balance =resultSet.getDouble("balance");
            Timestamp scheduleend = resultSet.getTimestamp("scheduleend");
            String status =resultSet.getString("status");
           
          
            
             
             
            quote quotes = new quote(firstname,lastname,tree_count,totalcost,balance,scheduleend,status);
            Statistics.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return Statistics;
    }
    public List<quote> GoodClients() throws SQLException {
        List<quote> GoodClients = new ArrayList<quote>();        
        String sql = "SELECT user.customerid, user.firstname, user.lastname,bills.status,bills.generated_date,bills.curdate \r\n"
        		+ "FROM user \r\n"
        		+ "JOIN quote ON user.customerid = quote.customerid \r\n"
        		+ "JOIN orderofwork ON quote.quoteid = orderofwork.quoteid \r\n"
        		+ "JOIN bills ON orderofwork.quoteid = bills.orderid \r\n"
        		+ "WHERE bills.status = 'paid' \r\n"
        		+ "AND bills.generated_date >= DATE_SUB(NOW(), INTERVAL 1 DAY)\r\n"
        		+ "GROUP BY user.customerid, user.firstname, user.lastname,bills.status,bills.generated_date,bills.curdate \r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "";    
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        	int customerID = resultSet.getInt("customerID");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String status =resultSet.getString("status");
            Timestamp generated_date = resultSet.getTimestamp("generated_date");
            Timestamp curdate = resultSet.getTimestamp("curdate");
            
             
             
            quote quotes = new quote(customerID,firstname,lastname,status,generated_date,curdate);
            GoodClients.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return GoodClients;
    }
    
    public List<quote> BadClients() throws SQLException {
        List<quote> BadClients = new ArrayList<quote>();        
        String sql =  "SELECT user.customerid, user.firstname, user.lastname, bills.status,bills.generated_date, bills.curdate,bills.price,bills.discount,bills.balance \r\n"
        	    
        	+ "FROM user JOIN quote ON user.customerid = quote.customerid JOIN orderofwork ON quote.quoteid = orderofwork.quoteid JOIN \r\n"
        	   +"bills ON orderofwork.quoteid = bills.orderid WHERE bills.status = 'pending' AND bills.generated_date < curdate() - INTERVAL 7 DAY AND bills.price - bills.discount = bills.balance \r\n"
        	+ "GROUP BY user.customerid, user.firstname, user.lastname, bills.status, bills.generated_date, bills.curdate,bills.price,bills.discount,bills.balance"
        	+ "\r\n"
    		+ "\r\n"
    		+ "";


        	      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        	int customerID = resultSet.getInt("customerID");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String status =resultSet.getString("status");
            Timestamp generated_date = resultSet.getTimestamp("generated_date");
            Timestamp curdate = resultSet.getTimestamp("curdate");
            double price = resultSet.getInt("price");
            double discount = resultSet.getInt("discount");
            double balance = resultSet.getDouble("balance");
             
             
            quote quotes = new quote(customerID,firstname,lastname,status,generated_date,curdate,price,discount,balance);
            BadClients.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return BadClients;
    }
    
    
    public List<quote> Bills() throws SQLException {
        List<quote> Bills = new ArrayList<quote>();        
        String sql = "SELECT *\r\n"
        		+ "FROM bills\r\n"
        		+ "WHERE status = 'pending'\r\n"
        		+ "      AND DATEDIFF(CURDATE(), generated_date) > 7;\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        	int id = resultSet.getInt("id");
            
            int orderid = resultSet.getInt("orderid");
            double price = resultSet.getDouble("price");
            double discount = resultSet.getDouble("discount");
            double balance = resultSet.getDouble("balance");
            String status =resultSet.getString("status");
            Timestamp curdate = resultSet.getTimestamp("curdate");
            Timestamp generated_date = resultSet.getTimestamp("generated_date");
             
            quote quotes = new quote(id,orderid,price,discount,balance,status,curdate,generated_date);
            Bills.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return Bills;
    }
    
    
    public List<quote> EasyClients() throws SQLException {
        List<quote> listquote = new ArrayList<quote>();        
        String sql = "SELECT *\r\n"
        		+ "FROM quote\r\n"
        		+ "WHERE (custnote IS NULL OR custnote = '')\r\n"
        		+ "  AND clientdecision = 'agree'\r\n"
        		+ "  AND supplierdecision = 'agree';";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        	int quoteid = resultSet.getInt("quoteid");
            
            int customerid = resultSet.getInt("customerid");
            
            Timestamp schedulestart = resultSet.getTimestamp("schedulestart");
            Timestamp scheduleend = resultSet.getTimestamp("scheduleend");
            String date = resultSet.getString("date");
            int totalcost = resultSet.getInt("totalcost");
            String custnote = resultSet.getString("custnote");
            String heightft = resultSet.getString("heightft"); 
            String diameter_width = resultSet.getString("diameter_width"); 
            String ft_from_house = resultSet.getString("ft_from_house"); 
            String location = resultSet.getString("location");
            String tree_count = resultSet.getString("tree_count");
            String clientDecision = resultSet.getString("clientDecision");
            String supplierDecision = resultSet.getString("supplierDecision");
            

             
            quote quotes = new quote(quoteid,customerid,schedulestart,scheduleend, date, totalcost,custnote, heightft, diameter_width, ft_from_house, location,tree_count,clientDecision, supplierDecision);
            listquote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listquote;
    }
    public List<quote> Onetreequotes() throws SQLException {
        List<quote> listquote = new ArrayList<quote>();        
        String sql = "SELECT *\r\n"
        		+ "FROM quote\r\n"
        		+ "WHERE tree_count = 1 and clientdecision = 'agree' and supplierdecision = 'agree';";       
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        	int quoteid = resultSet.getInt("quoteid");
            
            int customerid = resultSet.getInt("customerid");
            
            Timestamp schedulestart = resultSet.getTimestamp("schedulestart");
            Timestamp scheduleend = resultSet.getTimestamp("scheduleend");
            String date = resultSet.getString("date");
            int totalcost = resultSet.getInt("totalcost");
            String custnote = resultSet.getString("custnote");
            String heightft = resultSet.getString("heightft"); 
            String diameter_width = resultSet.getString("diameter_width"); 
            String ft_from_house = resultSet.getString("ft_from_house"); 
            String location = resultSet.getString("location");
            String tree_count = resultSet.getString("tree_count");
            String clientDecision = resultSet.getString("clientDecision");
            String supplierDecision = resultSet.getString("supplierDecision");
            

             
            quote quotes = new quote(quoteid,customerid,schedulestart,scheduleend, date, totalcost,custnote, heightft, diameter_width, ft_from_house, location,tree_count,clientDecision, supplierDecision);
            listquote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listquote;
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
    
 
        
    public List<quote> listOnequote(HttpServletRequest request) throws SQLException {
    	HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        connect_func(); 

    	int customerIdInt = Integer.parseInt(customerId);

        List<quote> listquote = new ArrayList<quote>();        
        String sql = "SELECT quote.*, user.* from quote inner join user on quote.customerid = user.customerid where quote.customerid = ? ";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setInt(1, customerIdInt);

        ResultSet resultSet = preparedStatement.executeQuery();
         
        
         
        while (resultSet.next()) {
        	int quoteid = resultSet.getInt("quoteid");
            
            int customerid = resultSet.getInt("customerid");
            
            Timestamp schedulestart = resultSet.getTimestamp("schedulestart");
            Timestamp scheduleend = resultSet.getTimestamp("scheduleend");
            String date = resultSet.getString("date");
            int totalcost = resultSet.getInt("totalcost");
            String custnote = resultSet.getString("custnote");
            String heightft = resultSet.getString("heightft"); 
            String diameter_width = resultSet.getString("diameter_width"); 
            String ft_from_house = resultSet.getString("ft_from_house"); 
            String location = resultSet.getString("location");
            String tree_count = resultSet.getString("tree_count");
            String clientDecision = resultSet.getString("clientDecision");
            String supplierDecision = resultSet.getString("supplierDecision");
            

             
            quote quotes = new quote(quoteid,customerid,schedulestart,scheduleend, date, totalcost,custnote, heightft, diameter_width, ft_from_house, location,tree_count,clientDecision, supplierDecision);
            listquote.add(quotes);
        }        
        resultSet.close();
        disconnect();        
        return listquote;
    }
    
    
    
    
    public List<quote> listAllquotes() throws SQLException {
        List<quote> listquote = new ArrayList<quote>();        
        String sql = "SELECT * FROM quote";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
        	int quoteid = resultSet.getInt("quoteid");
            
            int customerid = resultSet.getInt("customerid");
            
            Timestamp schedulestart = resultSet.getTimestamp("schedulestart");
            Timestamp scheduleend = resultSet.getTimestamp("scheduleend");
            String date = resultSet.getString("date");
            int totalcost = resultSet.getInt("totalcost");
            String custnote = resultSet.getString("custnote");
            String heightft = resultSet.getString("heightft"); 
            String diameter_width = resultSet.getString("diameter_width"); 
            String ft_from_house = resultSet.getString("ft_from_house"); 
            String location = resultSet.getString("location");
            String tree_count = resultSet.getString("tree_count");
            String clientDecision = resultSet.getString("clientDecision");
            String supplierDecision = resultSet.getString("supplierDecision");
            

             
            quote quotes = new quote(quoteid,customerid,schedulestart,scheduleend, date, totalcost,custnote, heightft, diameter_width, ft_from_house, location,tree_count,clientDecision, supplierDecision);
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
    
    public void insertorderofwork(orderofwork orderofworks) throws SQLException {
    	connect_func();         
		String sql = "insert into orderofwork(quoteid,price,schedulestart,scheduleend) values (?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, orderofworks.getQuoteId());
			preparedStatement.setInt(2, orderofworks.getPrice());
			preparedStatement.setTimestamp(3, orderofworks.getschedulestart());
			preparedStatement.setTimestamp(4, orderofworks.getschedulend());
			
			
			
			
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    
    
    
    public void insertquote(quote quotes, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        connect_func();

        int customerIdInt = Integer.parseInt(customerId);

        String sql = "insert into quote(quoteid,customerid, schedulestart, scheduleend, date, totalcost, custnote, heightft, diameter_width, ft_from_house, location, tree_count) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, quotes.getQuoteID());
        
        
        // Set the customerid retrieved from the session
        preparedStatement.setInt(2, customerIdInt);
        
        preparedStatement.setTimestamp(3, quotes.getSchedulestart());
        preparedStatement.setTimestamp(4, quotes.getScheduleend());

        preparedStatement.setString(5, quotes.getDate());
        preparedStatement.setInt(6, quotes.gettotalcost());
        preparedStatement.setString(7, quotes.getCustnote());
        preparedStatement.setString(8, quotes.getHeightFT());
        preparedStatement.setString(9, quotes.getdiameter_width());
        preparedStatement.setString(10, quotes.getft_from_house());
        preparedStatement.setString(11, quotes.getlocation());
        preparedStatement.setString(12, quotes.gettree_count());

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
     
    public boolean update(quote quotes) throws SQLException {
        String sql = "update quote set supplierDecision=?,custnote = ?, totalcost=?, scheduleend=? where quoteid=?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        
        
        preparedStatement.setString(1, quotes.getsupplierDecision());
        preparedStatement.setString(2, quotes.getCustnote());
        preparedStatement.setInt(3, quotes.gettotalcost());
        preparedStatement.setTimestamp(4, quotes.getScheduleend());
        preparedStatement.setInt(5, quotes.getQuoteID());
        
        
	
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
        	
            
            int customerID = resultSet.getInt("customerID");
            
            Timestamp schedulestart = resultSet.getTimestamp("schedulestart");
            Timestamp scheduleend = resultSet.getTimestamp("scheduleend");
            String date = resultSet.getString("date");
            int totalcost = resultSet.getInt("totalcost"); 
            String custnote = resultSet.getString("custnote"); 
            String heightFT = resultSet.getString("heightFT"); 
            String diameter_width = resultSet.getString("diameter_width"); 
            String ft_from_house = resultSet.getString("ft_from_house"); 
            String location = resultSet.getString("location"); 
            String tree_count = resultSet.getString("tree_count");
            String clientDecision = resultSet.getString("clientDecision"); 
            String supplierDecision = resultSet.getString("supplierDecision");
          
            quote = new quote(quoteID,customerID,schedulestart,scheduleend, date, totalcost, custnote,  heightFT, diameter_width,ft_from_house, location,tree_count,clientDecision, supplierDecision);
        }
        resultSet.close();
        statement.close();
         
        return quote;
         
      
    }
    
    
    
    public boolean  updateCliendDecision(String clientDecision,String quoteId)  throws SQLException {
    boolean rowUpdated=false;
    String sql = "update quote set clientDecision=? where quoteid=?";
    connect_func();
    
    preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
    
    
    preparedStatement.setString(1, clientDecision);
    preparedStatement.setString(2, quoteId);
   
     rowUpdated = preparedStatement.executeUpdate() > 0;
    preparedStatement.close();	
    		
    		return rowUpdated;
    }
    
    public boolean  updateSupplierDecision(String supplierDecision,String quoteId)  throws SQLException {
        boolean rowUpdated=false;
        String sql = "update quote set supplierDecision=? where quoteid=?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        
        
        preparedStatement.setString(1, supplierDecision);
        preparedStatement.setString(2, quoteId);
       
         rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();	
        		
        		return rowUpdated;
        }
    
    
    
    
    



    

    
    
    

   } 
        
        
      
    
    
    
	
	
