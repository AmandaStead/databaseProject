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
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trees?allowPublicKeyRetrieval=true&useSSL=false&user=root&password=pass1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
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
    public boolean database_loginJohn(String email, String password) throws SQLException{
    	try {
    		connect_func("john","pass1234");
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
    
    public List<user> listAllUsers() throws SQLException {
        List<user> listUser = new ArrayList<user>();        
        String sql = "SELECT * FROM User";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int customerid = resultSet.getInt("customerid");
        	String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String birthday = resultSet.getString("birthday");
            String adress_street_num = resultSet.getString("adress_street_num"); 
            String adress_street = resultSet.getString("adress_street"); 
            String adress_city = resultSet.getString("adress_city"); 
            String adress_state = resultSet.getString("adress_state"); 
            String adress_zip_code = resultSet.getString("adress_zip_code"); 
            String cc_num = resultSet.getString("cc_num");
            String cc_exp = resultSet.getString("cc_exp");
            String cc_cvv = resultSet.getString("cc_cvv");
            String phone = resultSet.getString("phone");

             
            user users = new user(customerid,email,firstName, lastName, password, birthday, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code,cc_num,cc_exp,cc_cvv,phone);
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
		String sql = "insert into User(email, firstName, lastName, password, birthday,adress_street_num, adress_street,adress_city,adress_state,adress_zip_code,cc_num,cc_exp,cc_cvv,phone) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?,?,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, users.getEmail());
			preparedStatement.setString(2, users.getFirstName());
			preparedStatement.setString(3, users.getLastName());
			preparedStatement.setString(4, users.getPassword());
			preparedStatement.setString(5, users.getBirthday());
			preparedStatement.setString(6, users.getAdress_street_num());		
			preparedStatement.setString(7, users.getAdress_street());		
			preparedStatement.setString(8, users.getAdress_city());		
			preparedStatement.setString(9, users.getAdress_state());		
			preparedStatement.setString(10, users.getAdress_zip_code());		
			preparedStatement.setString(11, users.getcc_num());
			preparedStatement.setString(12, users.getcc_exp());
			preparedStatement.setString(13, users.getcc_cvv());
			preparedStatement.setString(14, users.getphone());

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
        String sql = "update User set firstName=?, lastName =?,password = ?,birthday=?,adress_street_num =?, adress_street=?,adress_city=?,adress_state=?,adress_zip_code=? where email = ?";
        connect_func();
        
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, users.getEmail());
		preparedStatement.setString(2, users.getFirstName());
		preparedStatement.setString(3, users.getLastName());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getBirthday());
		preparedStatement.setString(6, users.getAdress_street_num());		
		preparedStatement.setString(7, users.getAdress_street());		
		preparedStatement.setString(8, users.getAdress_city());		
		preparedStatement.setString(9, users.getAdress_state());		
		preparedStatement.setString(10, users.getAdress_zip_code());		

        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowUpdated;     
    }
    
    
    public String getCustomerId(String email, String password) throws SQLException {
        String customerId = null;
        String sql = "SELECT customerid FROM user WHERE email = ? AND password = ?";

        try {
            connect_func();
            PreparedStatement preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                customerId = resultSet.getString("customerid");
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

        return customerId;
    }

    
    public user getUser(String email) throws SQLException {
    	user user = null;
        String sql = "SELECT * FROM User WHERE email = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, email);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	int customerid = resultSet.getInt("customerid");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String password = resultSet.getString("password");
            String birthday = resultSet.getString("birthday");
            String adress_street_num = resultSet.getString("adress_street_num"); 
            String adress_street = resultSet.getString("adress_street"); 
            String adress_city = resultSet.getString("adress_city"); 
            String adress_state = resultSet.getString("adress_state"); 
            String adress_zip_code = resultSet.getString("adress_zip_code"); 
            String cc_num = resultSet.getString("cc_num");
            String cc_exp = resultSet.getString("cc_exp");
            String cc_cvv = resultSet.getString("cc_cvv");
            String phone = resultSet.getString("phone");
            user = new user(customerid,email, firstName, lastName, password, birthday, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code,cc_num,cc_exp,cc_cvv,phone);
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
        statement.executeUpdate("drop database if exists trees");
        statement.executeUpdate("create database trees");
        statement.executeUpdate("use trees");
     
        statement.executeUpdate("DROP TABLE IF EXISTS user, quote, bills,QuotesMessages,BillsMessages, orderofwork, note, service, tree");

        

        // Create new tables
        
        statement.executeUpdate("CREATE TABLE if not EXISTS User (customerid INT PRIMARY KEY AUTO_INCREMENT, email VARCHAR(50) NOT NULL, firstname VARCHAR(10), lastName VARCHAR(10) NOT NULL, phone VARCHAR(10), password VARCHAR(20) NOT NULL, birthday DATE NOT NULL, adress_street_num VARCHAR(4), adress_street VARCHAR(30), adress_city VARCHAR(20), adress_state VARCHAR(2), adress_zip_code VARCHAR(5), cc_num VARCHAR(16) DEFAULT 0000, cc_exp DATE, cc_cvv VARCHAR(3));");
        statement.executeUpdate("CREATE TABLE if not EXISTS quote (quoteid INT PRIMARY KEY AUTO_INCREMENT, customerid INT,schedulestart DATETIME,scheduleend DATETIME, date DATE, totalcost DECIMAL(10,2), custnote VARCHAR(50), heightFT INT, diameter_width INT, ft_from_house INT, location VARCHAR(50), tree_count VARCHAR(20), clientDecision VARCHAR(50), supplierDecision VARCHAR(50));");     
        statement.executeUpdate("CREATE TABLE if not EXISTS tree(id INTEGER,quoteid INTEGER,size DOUBLE,height DOUBLE,	distanceFromHouse DOUBLE,PRIMARY KEY(id),FOREIGN KEY(quoteid) REFERENCES quote(quoteid));");
        statement.executeUpdate("CREATE TABLE if not EXISTS QuotesMessages(id INTEGER,customerid INTEGER,quoteid INTEGER,msgtime DATETIME,price DOUBLE,schedulestart DATETIME,scheduleend DATETIME,note VARCHAR(200),PRIMARY KEY(id));");
        statement.executeUpdate("CREATE TABLE if not EXISTS orderofwork(id INT PRIMARY KEY AUTO_INCREMENT,quoteid INTEGER,price DECIMAL(10,2),schedulestart DATETIME,scheduleend DATETIME, FOREIGN KEY(quoteid) REFERENCES quote(quoteid));");
        statement.executeUpdate("CREATE TABLE if not EXISTS Bills (id INTEGER,orderid INTEGER,price DOUBLE,discount DOUBLE,balance DOUBLE,status VARCHAR(20),curdate DATETIME DEFAULT CURRENT_TIMESTAMP,generated_date DATETIME,PRIMARY KEY(id));");
        statement.executeUpdate("CREATE TABLE if not EXISTS BillsMessages(id INTEGER,customerid INTEGER,billid INTEGER,msgtime DATETIME,price DOUBLE,schedulestart DATETIME,scheduleend DATETIME,note VARCHAR(200),PRIMARY KEY(id));");
        
    
      
        
        // Insert data
        
        statement.executeUpdate("INSERT INTO BillsMessages(id,customerid,billid,msgtime,price,schedulestart,scheduleend,note) VALUES('1','1','1','2023-01-01 01:00:00','1000','2023-02-02 04:00:00','2024-01-01 03:00:00','Need to reschedule'),"+
        		 "('2','2','2','2023-02-02 10:00:00','500','2023-03-03 04:00:00','2023-03-10 05:00:00','Call first, yes'),"+
        	        "('3','3','3','2023-04-04 04:00:00','200','2023-05-05 05:00:30','2023-05-05 06:00:00','this time will work'),"+
        	        "('4','4','4','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        	        "('5','5','5','2024-02-02 06:00:00','600','2024-07-07 04:00:00','2024-04-04 03:00:00','this will work'),"+
        	        "('6','6','6','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        	        "('7','7','7','2023-02-02 10:00:00','500','2023-03-03 04:00:00','2023-03-10 05:00:00','Call first, yes'),"+
        	        "('8','8','8','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        	        "('9','9','9','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        	        "('10','10','10','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?');");
        	        
       
        statement.executeUpdate("INSERT INTO Bills(id,orderid,price,discount,balance,status,Generated_Date) VALUES ('1','1','250','50','100','pending','2023-12-20 04:00:00'),"+
        "('2','2','700','150','500','paid','2023-12-04 21:22:00'),"+
        "('3','3','400','80','320','paid','2023-11-05 02:00:00')," +
        "('4','4','500','100','150','paid','2023-10-20 02:00:00'),"+
        "('5','5','1000','300','700','paid','2023-12-04 04:00:00'),"+
        "('6','7','700','100','600','paid','2023-12-02 04:00:00'),"+
        "('7','7','500','100','50','pending','2023-10-15 08:00:00'),"+
        "('8','8','500','100','75','pending','2023-11-23 04:00:00'),"+
        "('9','9','400','100','100','pending','2023-09-20 05:00:00'),"+
        "('10','10','700','200','85','pending','2023-11-12 03:00:00');");
        		
        
        statement.executeUpdate("INSERT INTO QuotesMessages(id,customerid,quoteid,msgtime,price,schedulestart,scheduleend,note) VALUES ('1','1','1','2023-10-26 15:30:00','200','2023-10-26 15:30:00','2023-10-26 15:30:00','this time will work')," +
        "('2','2','2','2023-02-02 10:00:00','500','2023-03-03 04:00:00','2023-03-10 05:00:00','Call first, yes'),"+
        "('3','3','3','2023-04-04 04:00:00','200','2023-05-05 05:00:30','2023-05-05 06:00:00','this time will work'),"+
        "('4','4','4','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        "('5','5','5','2024-02-02 06:00:00','600','2024-07-07 04:00:00','2024-04-04 03:00:00','this will work'),"+
        "('6','6','6','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        "('7','7','7','2023-02-02 10:00:00','500','2023-03-03 04:00:00','2023-03-10 05:00:00','Call first, yes'),"+
        "('8','8','8','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        "('9','9','9','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?'),"+
        "('10','10','10','2024-02-02 01:00:00','250','2024-03-03 05:30:00','2024-06-06 02:00:00','can we do cheaper price?');");
        
        
        
        statement.executeUpdate("INSERT INTO User (email, firstname, lastname, phone, password, birthday, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, cc_num, cc_exp, cc_cvv) VALUES ('susie@gmail.com', 'Susie ', 'Guzman', '5842124561', 'susie1234', '2000-06-27', '1234', 'whatever street', 'detroit', 'MI', '48202','414123541254145', '2020-01-01', '441'), "+
        		"('susie2@gmail.com', 'Susie ', 'Guzman', '5842124561', 'susie1234', '2000-06-27', '1234', 'whatever street', 'detroit', 'MI', '48202','414123541254145', '2020-01-01', '441'),"+
    		 	"('don@gmail.com', 'Don', 'Cummings', '5842124561', 'don123', '1969-03-20', '1000', 'hi street', 'mama', 'MO', '12345','414123541254145', '2020-01-01', '441'),"+
    	 	 	"('margarita@gmail.com', 'Margarita', 'Lawson', '5842124561','margarita1234', '1980-02-02', '1234', 'ivan street', 'tata','CO','12561', '414123541254145', '2020-01-01', '441'),"+
    		 	"('jo@gmail.com', 'Jo', 'Brady', '5842124561', 'jo1234', '2002-02-02', '3214','marko street', 'brat', 'DU', '54321','414123541254145', '2020-01-01', '441'),"+
    		 	"('wallace@gmail.com', 'Wallace', 'Moore','5842124561', 'wallace1234', '1971-06-15', '4500', 'frey street', 'sestra', 'MI', '48202','414123541254145', '2020-01-01', '441'),"+
    		 	"('amelia@gmail.com', 'Amelia', 'Phillips', '5842124561', 'amelia1234', '2000-03-14', '1245', 'm8s street', 'baka', 'IL', '48000','414123541254145', '2020-01-01', '441'),"+
    			"('sophie@gmail.com', 'Sophie', 'Pierce', '5842124561', 'sophie1234', '1999-06-15', '2468', 'yolos street', 'ides', 'CM', '24680','414123541254145', '2020-01-01', '441'),"+
    			"('angelo@gmail.com', 'Angelo', 'Francis', '5842124561', 'angelo1234', '2021-06-14', '4680', 'egypt street', 'lolas', 'DT', '13579','414123541254145', '2020-01-01', '441'),"+
    			"('rudy@gmail.com', 'Rudy', 'Smith', '5842124561', 'rudy1234', '1706-06-05', '1234', 'sign street', 'samo ne tu','MH', '09876','414123541254145', '2020-01-01', '441'),"+
    			"('jeannette@gmail.com', 'Jeannette ', 'Stone', '5842124561', 'jeannette1234', '2001-04-24', '0981', 'snoop street', 'kojik', 'HW', '87654','414123541254145', '2020-01-01', '441'),"+
    			"('john', 'default', 'default','0000000000', 'pass1234', '2020-10-10', '0000', 'Default', 'Default', 'OH', '12345','default', '2020-02-02', '000'),"+
    			"('root', 'default', 'default','0000000000', 'pass1234', '2020-10-10', '0000', 'Default', 'Default', 'OH', '12345', 'default', '2020-02-02', '000');");  
        
	statement.executeUpdate("INSERT INTO quote(quoteid,customerid,schedulestart,scheduleend, date, totalcost, custnote, heightFT, diameter_width, ft_from_house,location, tree_count,clientDecision, supplierDecision) VALUES ('10','10','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '111','Need 3 trees trimmed', '5', '10', 10, 'Right side of house','4', 'agreement','agreement'),"+
        		"('1','1','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '500', '1 tree taken down', '8', '3','8','Front of House', '1', 'agreement','disagree'),"+    
        		"('2','2','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '325', '4 trees removed', '5','2', '8','backyard','1', 'agree','agree')," +
        		"('3','3','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '150', 'Trees trimmed', '3','5','7','driveway','9', 'agreement','agreement')," +
        		"('4','4','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '300', 'Trees trimmed', '12','6','12','driveway','1', 'agree','agree')," +
        		"('5','5','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '400','3 trimmed', '7','4', '8', 'front yard right side','2', 'agreement', 'disagree')," +
        		"('6','6','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '550', '6 trees trimmed', '5','4','17','backyard','6', 'Disagree','agreement')," +
        		"('7','7','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '375', '2 Trees removed and 5 trimmed', '4','5','15','side of house','5', 'agreement','agreement')," +
        		"('8','8','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '100','1 tree trimmed', '6','6','17','side of house','11', 'Disagree','Disagree')," +
        		"('9','9','2020-01-04 12:00:00','2020-01-04 12:00:00','2020-01-01', '190', '1 tree trimmed, 2 removed', '6','2','7','front yard','12','Disagree','agreement');");  
	 statement.executeUpdate("INSERT INTO tree (id, quoteid,size,height,distanceFromHouse) VALUES ('1','1','10','15','25'),"
	      		+ "('2','2','20', '25','50'),"
	      		+ "('3','3','30', '35','15'),"
	      		+ "('4','4','23','40', '45'),"
	      		+ "('5','5','17', '50', '55'),"
	      		+ "('6', '6','32', '60', '65'),"
	      		+ "('7','7','43', '70', '75'),"
	      		+ "('8','8','17','80', '85'),"
	      		+ "('9','9','18','90', '95'),"
	      		+ "('10','10','42','100', '105');");   

	 statement.executeUpdate("INSERT INTO orderofwork(id, quoteid, price,schedulestart,scheduleend) VALUES ('1','1', '111.11', '2023-10-26 15:30:00','2023-10-26 15:30:00')," +
        		"('2','2','222.22','2020-01-02 12:00:30','2020-01-04 12:00:30'),"
        		+ "('3','4','400','2023-12-01 13:00:15','2020-01-03 09:00:30'),"
        		+ "('4','4','444.44','2020-01-04 12:00:00','2020-01-04 15:00:00'),"
        		+ "('5','5','555.55','2023-12-12 10:00:00','2024-1-12 10:00:00'),"
        		+ "('6','6','555.55','2023-12-12 10:00:00','2024-1-12 10:00:00'),"
        		+ "('7','7','555.55','2023-12-12 10:00:00','2024-1-12 10:00:00'),"
        		+ "('8','8','555.55','2023-12-12 10:00:00','2024-1-12 10:00:00'),"
        		+ "('9','9','555.55','2023-12-12 10:00:00','2024-1-12 10:00:00'),"
        		+ "('10','10','555.55','2023-12-12 10:00:00','2024-1-12 10:00:00');");
	  
      		
      
       
     
  }} 
        
        
      
    
    
    
	
	