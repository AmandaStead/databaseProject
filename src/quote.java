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

    
   

    // Getters and setters 

    
    public quote(int quoteID, int serviceid, int customerid, int offer_id,Timestamp schedulestart,Timestamp scheduleend, String date, int totalcost, String custnote, String heightft, String diameter_width, String ft_from_house, String location, String tree_count, String clientDecision, String supplierDecision) {
    	
      	this.quoteID = quoteID;
      	this.serviceID = serviceid;
      	this.customerID = customerid;
      	this.offer_id = offer_id;
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




	public quote(int quoteID, String custnote, int totalcost,String clientDecision, String supplierDecision) {
		
		this.quoteID = quoteID;
		this.custnote = custnote;
		this.totalcost = totalcost;
		this.clientDecision = clientDecision;
		this.supplierDecision = supplierDecision;
		
		// TODO Auto-generated constructor stub
	}
	




	



	public quote(int quoteid, int serviceid, int offer_id, Timestamp schedulestart, Timestamp scheduleend,String date, int totalcost, String custnote,
			String heightft, String diameter_width, String ft_from_house, String location, String tree_count,
			String clientDecision, String supplierDecision) {
		// TODO Auto-generated constructor stub
		this.quoteID = quoteid;
      	this.serviceID = serviceid;
      	
      	this.offer_id = offer_id;
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




	public int getQuoteID() {
        return quoteID;
    }

    public int getServiceID() {
        return serviceID;
    }
    public int getoffer_id() {
        return offer_id;
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

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }
    public void setoffer_id(int offer_id) {
        this.offer_id = offer_id;
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