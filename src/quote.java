import java.sql.Timestamp;

public class quote {
    protected int quoteID;
    protected int serviceID;
    protected int customerID;
    protected int offer_id;
    private Timestamp schedulestart;
    private Timestamp scheduleend;
    protected String date;
    protected int totalcost;
    protected String custnote;
    protected String heightFT;
    protected String diameter_width;
    protected String ft_from_house;
    protected String location;
    protected String tree_count;
    protected String clientDecision;
    protected String supplierDecision;
    
    //bills
    protected int id;
    protected int orderid;
    protected double price;
    protected double discount;
    protected double balance;
    protected String status;
    protected Timestamp curdate;
    protected Timestamp generated_date;
    
    
    protected String firstname;
    protected String lastname;
    

    
    

    public quote(Timestamp schedulestart,String date, String custnote, String heightFT, String diameter_width, String ft_from_house, String location, String tree_count) {
       //createquoite 
    	//
        
    	
    	
    	
    	
    	this.schedulestart = schedulestart;
    	this.date = date;
        this.custnote = custnote;
        this.heightFT = heightFT;
        this.diameter_width = diameter_width;
        this.ft_from_house = ft_from_house;
        this.location = location;
        this.tree_count = tree_count;
        
        
        
        
    }
    public quote(int customerID,String firstname,String lastname) {
    	this.customerID=customerID;
    	this.firstname=firstname;
    	this.lastname=lastname;
    }
    public quote(int id,int orderid,double price,double discount,double balance,String status,Timestamp curdate,Timestamp generated_date) {
    	this.id=id;
    	this.orderid=orderid;
    	this.price=price;
    	this.discount=discount;
    	this.balance=balance;
    	this.status=status;
    	this.curdate=curdate;
    	this.generated_date=generated_date;
    }
    
   

    // Getters and setters 

    
    public quote(int quoteID, int customerid, Timestamp schedulestart,Timestamp scheduleend, String date, int totalcost, String custnote, String heightft, String diameter_width, String ft_from_house, String location, String tree_count, String clientDecision, String supplierDecision) {
    	
      	this.quoteID = quoteID;
      	
      	this.customerID = customerid;
      	
      	this.schedulestart = schedulestart;
      	this.scheduleend = scheduleend;
    	this.date = date;
    	this.totalcost = totalcost;
        this.custnote = custnote;
        this.heightFT = heightft;
        this.diameter_width = diameter_width;
        this.ft_from_house = ft_from_house;
        this.location = location;
        this.tree_count = tree_count;
        this.clientDecision = clientDecision;
        this.supplierDecision = supplierDecision;
		// TODO Auto-generated constructor stub
	}




	public quote(int quoteID, String custnote, int totalcost,String clientDecision, String supplierDecision, Timestamp scheduleend) {
		
		this.quoteID = quoteID;
		this.custnote = custnote;
		this.totalcost = totalcost;
		this.clientDecision = clientDecision;
		this.supplierDecision = supplierDecision;
		this.scheduleend = scheduleend;
		
		// TODO Auto-generated constructor stub
	}
	




	



	public quote(int quoteid, Timestamp schedulestart, Timestamp scheduleend,String date, int totalcost, String custnote,
			String heightft, String diameter_width, String ft_from_house, String location, String tree_count,
			String clientDecision, String supplierDecision) {
		// TODO Auto-generated constructor stub
		this.quoteID = quoteid;
      	
      	
      	
      	this.schedulestart = schedulestart;
      	this.scheduleend = scheduleend;
    	this.date = date;
    	this.totalcost = totalcost;
        this.custnote = custnote;
        this.heightFT = heightft;
        this.diameter_width = diameter_width;
        this.ft_from_house = ft_from_house;
        this.location = location;
        this.tree_count = tree_count;
        this.clientDecision = clientDecision;
        this.supplierDecision = supplierDecision;
		
	}

	public quote(int customerID, String firstname, String lastname, String status, Timestamp generated_date,
			Timestamp curdate) {
		
		this.customerID = customerID;
		this.firstname=firstname;
		this.lastname=lastname;
		this.status=status;
		this.generated_date=generated_date;
		this.curdate=curdate;
		
	}
	public quote(String firstname, String lastname, String tree_count, int totalcost, double balance,
			Timestamp scheduleend, String status) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.tree_count = tree_count;
		this.totalcost = totalcost;
		this.balance = balance;
		this.scheduleend = scheduleend;
		this.status = status;
	}
	public String getfirstname() {
		return firstname;
	}
	
	public String getlastname() {
		return lastname;
	}
	
	public int getId() {
	        return id;
	    }

	    public int getOrderid() {
	        return orderid;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public double getDiscount() {
	        return discount;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public Timestamp getgenerated_date() {
	        return generated_date;
	    }

	    public Timestamp getcurdate() {
	        return curdate;
	    }

	    // Setters
	    public void setfirstname(String firstname) {
	    	this.firstname = firstname;
	    }
	    public void setlastname(String lastname) {
	    	this.lastname = lastname;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }

	    public void setOrderid(int orderid) {
	        this.orderid = orderid;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public void setDiscount(double discount) {
	        this.discount = discount;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public void setgenerated_date(Timestamp generated_date) {
	        this.generated_date = generated_date;
	    }

	    public void setcurdate(Timestamp curdate) {
	        this.curdate = curdate;
	    }

	public int getQuoteID() {
        return quoteID;
    }


    public int getCustomerID() {
        return customerID;
    }
    public Timestamp getSchedulestart() {
        return schedulestart;
    }

    public void setSchedulestart(Timestamp schedulestart) {
        this.schedulestart = schedulestart;
    }

    // Getter and Setter for scheduleend
    public Timestamp getScheduleend() {
        return scheduleend;
    }

    public void setScheduleend(Timestamp scheduleend) {
        this.scheduleend = scheduleend;
    }


    public String getDate() {
        return date;
    }

    public int gettotalcost() {
        return totalcost;
    }

    public String getCustnote() {
        return custnote;
    }

    public String getHeightFT() {
        return heightFT;
    }
    public String getdiameter_width() {
    	return diameter_width;
    }
    public String getft_from_house() {
    	return ft_from_house;
    }
    public String getlocation() {
    	return location;
    }
    public String gettree_count() {
    	return tree_count;
    }
    public String getclientDecision() {
    	return clientDecision;
    }
    public String getsupplierDecision() {
    	return supplierDecision;
    }

    // Setter methods
    public void setQuoteID(int quoteID) {
        this.quoteID = quoteID;
    }


    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void settotalcost(int totalcost) {
        this.totalcost = totalcost;
    }

    public void setCustnote(String custnote) {
        this.custnote = custnote;
    }

    public void setHeightFT(String heightFT) {
        this.heightFT = heightFT;
    }
    public void setdiameter_width(String diameter_width) {
        this.diameter_width = diameter_width;
    }
    public void setft_from_house(String ft_from_house) {
        this.ft_from_house = ft_from_house;
    }
    public void setlocation(String location) {
        this.location = location;
    }
    public void settree_count(String tree_count) {
        this.tree_count = tree_count;
    }
    public void setclientDecision(String clientDecision) {
        this.clientDecision = clientDecision;
    }
    public void setsupplierDecision(String supplierDecision) {
        this.supplierDecision = supplierDecision;
}}