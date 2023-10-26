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


public class QuoteControlServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private quoteDAO quoteDAO = new quoteDAO();
	    public QuoteControlServlet()
		{
			
		}
		private String currentUser;
	    private HttpSession session=null;
	    
	    public void init()
	    {
	    	quoteDAO = new quoteDAO();
	    	currentUser= "";
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	    
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.println(action);
	    
	    try {
        	switch(action) {  
        	
        	case "/createquote":
        		createquote(request, response);
        		break;
        	case "/rootPageQuotes":
        		rootPageQuotes(request,response, "");
        		break;
        	case "/listquote": 
                 System.out.println("The action is: listquote");
                 listquote(request, response);           	
                 break;
        	
        	
	    	}
	    	
        	
	    }
	    catch(Exception ex) {
        	System.out.println(ex.getMessage());
	    	}
	    }
        	
	    private void listquote(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        System.out.println("listUser started: 00000000000000000000000000000000000");

	     
	        List<quote> listquote = quoteDAO.listAllquotes();
	        request.setAttribute("listquote", listquote);       
	        RequestDispatcher dispatcher = request.getRequestDispatcher("QuoteList.jsp");       
	        dispatcher.forward(request, response);
	     
	        System.out.println("listQuote finished: 111111111111111111111111111111111111");
	    }
	    	        
	    private void rootPageQuotes(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException, SQLException{
	    	System.out.println("root viewQuotes");
			request.setAttribute("listquote", quoteDAO.listAllquotes());
	    	request.getRequestDispatcher("rootViewQuotes.jsp").forward(request, response);
	    } // Need to make rootViewQuotes.jsp and QuoteList.jsp
	    
	    
	     
	    private void createquote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    	int serviceID = Integer.parseInt(request.getParameter("serviceID"));
	    	int customerID = Integer.parseInt(request.getParameter("customerID"));
	    	String date = request.getParameter("date");
	    	double totalcost = Double.parseDouble(request.getParameter("totalcost"));
	    	String custnote = request.getParameter("custnote");
	    	int heightFT = Integer.parseInt(request.getParameter("heightFT"));
	   	 	
	    	quote quotes = new quote(serviceID, customerID, date, totalcost, custnote, heightFT);
   	 		quoteDAO.insertquote(quotes);
   	 		response.sendRedirect("login.jsp");	}
	   	 	
	   
	
	    

	     
        
	    
	    
	    
	    
	    
}
	        
	        
	    
	        
	        
	        
	    
