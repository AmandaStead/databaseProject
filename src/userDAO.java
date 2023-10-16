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
@WebServlet("/userDAO")
public class userDAO 
{
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public userDAO(){}
	
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
    
    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String birthday = resultSet.getString("birthday");
            String cc_num = resultSet.getString("cc_num");
            String adress_street_num = resultSet.getString("adress_street_num"); 
            String adress_street = resultSet.getString("adress_street"); 
            String adress_city = resultSet.getString("adress_city"); 
            String adress_state = resultSet.getString("adress_state"); 
            String adress_zip_code = resultSet.getString("adress_zip_code"); 
            int cash_bal = resultSet.getInt("cash_bal");
            int PPS_bal = resultSet.getInt("PPS_bal");

             
            user users = new user(email,firstName, lastName, password, birthday, cc_num, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code, cash_bal,PPS_bal);
            listUser.add(users);
        }        
        resultSet.close();
        disconnect();        
        return listUser;
    }
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    public void insert(user users) throws SQLException {
    	connect_func("root","pass1234");         
		String sql = "insert into User(email, firstName, lastName, password, birthday, cc_num, adress_street_num, adress_street,adress_city,adress_state,adress_zip_code,cash_bal,PPS_bal) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getFirstName());
			preparedStatement.setString(3, users.getLastName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getBirthday());
			preparedStatement.setString(6, users.getcc_num());
			preparedStatement.setString(7, users.getAdress_street_num());		
			preparedStatement.setString(8, users.getAdress_street());		
			preparedStatement.setString(9, users.getAdress_city());		
			preparedStatement.setString(10, users.getAdress_state());		
			preparedStatement.setString(11, users.getAdress_zip_code());		
			preparedStatement.setInt(12, users.getCash_bal());		
			preparedStatement.setInt(13, users.getPPS_bal());		

		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    public boolean delete(String email) throws SQLException {
        String sql = "DELETE FROM User WHERE email = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
     
    public boolean update(user users) throws SQLException {
        String sql = "update User set firstName=?, lastName =?,password = ?,birthday=?, cc_num =?, adress_street_num =?, adress_street=?,adress_city=?,adress_state=?,adress_zip_code=?, cash_bal=?, PPS_bal =? where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getBirthday());
		preparedStatement.setString(6, users.getcc_num());
		preparedStatement.setString(7, users.getAdress_street_num());		
		preparedStatement.setString(8, users.getAdress_street());		
		preparedStatement.setString(9, users.getAdress_city());		
		preparedStatement.setString(10, users.getAdress_state());		
		preparedStatement.setString(11, users.getAdress_zip_code());		
		preparedStatement.setInt(12, users.getCash_bal());		
		preparedStatement.setInt(13, users.getPPS_bal());
         
        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    public user getUser(String email) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String birthday = resultSet.getString("birthday");
            String cc_num = resultSet.getString("cc_num");
            String adress_street_num = resultSet.getString("adress_street_num"); 
            String adress_street = resultSet.getString("adress_street"); 
            String adress_city = resultSet.getString("adress_city"); 
            String adress_state = resultSet.getString("adress_state"); 
            String adress_zip_code = resultSet.getString("adress_zip_code"); 
            int cash_bal = resultSet.getInt("cash_bal");
            int PPS_bal = resultSet.getInt("PPS_bal");
            user = new user(email, firstName, lastName, password, birthday, cc_num, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code,cash_bal,PPS_bal);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }
    
    public boolean checkEmail(String email) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE email = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
    	return checks;
    }
    
    public boolean checkPassword(String password) throws SQLException {
    	boolean checks = false;
    	String sql = "SELECT * FROM User WHERE password = ?";
    	connect_func();
    	preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        System.out.println(checks);	
        
        if (resultSet.next()) {
        	checks = true;
        }
        
        System.out.println(checks);
       	return checks;
    }
    
    
    
    public boolean isValid(String email, String password) throws SQLException
    {
    	String sql = "SELECT * FROM User";
    	connect_func();
    	statement = (Statement) connect.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	resultSet.last();
    	
    	int setSize = resultSet.getRow();
    	resultSet.beforeFirst();
    	
    	for(int i = 0; i < setSize; i++)
    	{
    		resultSet.next();
    		if(resultSet.getString("email").equals(email) && resultSet.getString("password").equals(password)) {
    			return true;
    		}		
    	}
    	return false;
    }
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
     
        statement.executeUpdate("DROP TABLE IF EXISTS user, quote, bill, orderofwork, note, service, tree");

        // Create new tables
        
        statement.executeUpdate("CREATE TABLE if not EXISTS user (customerid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(50) NOT NULL, firstname VARCHAR(10), lastName VARCHAR(10) NOT NULL, phonenumber VARCHAR(10), password VARCHAR(20) NOT NULL, birthday DATE NOT NULL, adress_street_num VARCHAR(4), adress_street VARCHAR(30), adress_city VARCHAR(20), adress_state VARCHAR(2), adress_zip_code VARCHAR(5), cash_bal DECIMAL(13,2) DEFAULT 1000, pps_bal DECIMAL(13,2) DEFAULT 0, cc_num VARCHAR(16) DEFAULT 0000, cc_exp DATE, cc_cvv VARCHAR(3));");
        statement.executeUpdate("CREATE TABLE if not EXISTS orderofwork (orderofworkid INT PRIMARY KEY AUTO_INCREMENT, service VARCHAR(50), date DATE, price_estimate DECIMAL(10,2));");
        statement.executeUpdate("CREATE TABLE if not EXISTS quote (quoteid INT PRIMARY KEY AUTO_INCREMENT, orderofworkid INT, customerid INT, date DATE, totalcost DECIMAL(10,2), FOREIGN KEY (customerid) REFERENCES user(customerid));");
        statement.executeUpdate("CREATE TABLE if not EXISTS service (serviceid INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), description VARCHAR(50), price DECIMAL(10,2));");
        statement.executeUpdate("CREATE TABLE if not EXISTS bill (orderofworkid INT, finalprice DECIMAL (10,2), service VARCHAR(50));");
        statement.executeUpdate("CREATE TABLE if not EXISTS note (customerid INT, custnote VARCHAR(50), ownernote VARCHAR(50), FOREIGN KEY (customerid) REFERENCES user(customerid));");
        statement.executeUpdate("CREATE TABLE if not EXISTS tree (treeid INT, pics VARCHAR(50), ft_from_house INT, size_height INT );");
        
        
     
        
        // Insert data
        statement.executeUpdate("INSERT INTO user (email, firstname, lastname, phonenumber, password, birthday, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, cash_bal, pps_bal, cc_num, cc_exp, cc_cvv) VALUES ('susie@gmail.com', 'Susie ', 'Guzman', '5842124561', 'susie1234', '2000-06-27', '1234', 'whatever street', 'detroit', 'MI', '48202', '1000', '1000','414123541254145', '2020-01-01', '441'), "+
        		"('susie@gmail.com', 'Susie ', 'Guzman', '5842124561', 'susie1234', '2000-06-27', '1234', 'whatever street', 'detroit', 'MI', '48202', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    		 	"('don@gmail.com', 'Don', 'Cummings', '5842124561', 'don123', '1969-03-20', '1000', 'hi street', 'mama', 'MO', '12345', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    	 	 	"('margarita@gmail.com', 'Margarita', 'Lawson', '5842124561','margarita1234', '1980-02-02', '1234', 'ivan street', 'tata','CO','12561', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    		 	"('jo@gmail.com', 'Jo', 'Brady', '5842124561', 'jo1234', '2002-02-02', '3214','marko street', 'brat', 'DU', '54321', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    		 	"('wallace@gmail.com', 'Wallace', 'Moore','5842124561', 'wallace1234', '1971-06-15', '4500', 'frey street', 'sestra', 'MI', '48202', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    		 	"('amelia@gmail.com', 'Amelia', 'Phillips', '5842124561', 'amelia1234', '2000-03-14', '1245', 'm8s street', 'baka', 'IL', '48000', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    			"('sophie@gmail.com', 'Sophie', 'Pierce', '5842124561', 'sophie1234', '1999-06-15', '2468', 'yolos street', 'ides', 'CM', '24680', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    			"('angelo@gmail.com', 'Angelo', 'Francis', '5842124561', 'angelo1234', '2021-06-14', '4680', 'egypt street', 'lolas', 'DT', '13579', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    			"('rudy@gmail.com', 'Rudy', 'Smith', '5842124561', 'rudy1234', '1706-06-05', '1234', 'sign street', 'samo ne tu','MH', '09876', '1000', '1000', '414123541254145', '2020-01-01', '441'),"+
    			"('jeannette@gmail.com', 'Jeannette ', 'Stone', '5842124561', 'jeannette1234', '2001-04-24', '0981', 'snoop street', 'kojik', 'HW', '87654', '1000', '1000','414123541254145', '2020-01-01', '441'),"+
    			"('root', 'default', 'default','0000000000', 'pass1234', '2020-10-10', '0000', 'Default', 'Default', 'OH', '12345', '1000', '1000', 'default', '2020-02-02', '000');");  
        statement.executeUpdate("INSERT INTO quote(quoteid, orderofworkid, customerid, date, totalcost) VALUES ('10','10','10','2020-01-01', '111.11'),"+
        		"('1','1','1','2020-01-01', '111.11'),"+    
        		"('2','2','2','2020-01-01', '111.11')," +
        		"('3','3','3','2020-01-01', '111.11')," +
        		"('4','4','4','2020-01-01', '111.11')," +
        		"('5','5','5','2020-01-01', '111.11')," +
        		"('6','6','6','2020-01-01', '111.11')," +
        		"('7','7','7','2020-01-01', '111.11')," +
        		"('8','8','8','2020-01-01', '111.11')," +
        		"('9','9','9','2020-01-01', '111.11');");  
        statement.executeUpdate("INSERT INTO bill(orderofworkid, finalprice, service) VALUES('1', '100', 'TREE TRIM')");
    
    }}
    
   
    
    
    
    
    
	
	

