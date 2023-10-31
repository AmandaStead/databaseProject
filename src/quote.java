public class quote {
    private int quoteID;
    private int serviceID;
    private int customerID;
    private int offer_id;
    private String date;
    private double totalcost;
    private String custnote;
    private String heightFT;
    private String diameter_width;
    private String ft_from_house;
    private String location;
    

    public quote(String date, String custnote, String heightFT, String diameter_width, String ft_from_house, String location) {
        
        
    	
    	
    	this.date = date;
        this.custnote = custnote;
        this.heightFT = heightFT;
        this.diameter_width = diameter_width;
        this.ft_from_house = ft_from_house;
        this.location = location;
        
        
    }

    
   

    // Getters and setters 

    
    public quote(int quoteid2, int serviceid2, int customerid2, int offer_id2, String date2, double totalcost2,
			String custnote2, String heightft2, String diameter_width2, String ft_from_house2, String location2) {
    	
      	this.quoteID = quoteid2;
      	this.serviceID = serviceid2;
      	this.customerID = customerid2;
      	this.offer_id = offer_id2;
    	this.date = date2;
        this.custnote = custnote2;
        this.heightFT = heightft2;
        this.diameter_width = diameter_width2;
        this.ft_from_house = ft_from_house2;
        this.location = location2;
		// TODO Auto-generated constructor stub
	}




	public quote(int quoteid2, String custnote2, double totalcost2) {
		
		this.quoteID = quoteid2;
		this.custnote = custnote2;
		this.totalcost = totalcost2;
		
		// TODO Auto-generated constructor stub
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

    public String getDate() {
        return date;
    }

    public double getTotalCost() {
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

    public void setTotalCost(double totalCost) {
        this.totalcost = totalCost;
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
}
