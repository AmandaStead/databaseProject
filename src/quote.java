public class quote {
    private int quoteID;
    private int serviceID;
    private int customerID;
    private String quoteDate;
    private double totalCost;

   //Constructors
    public quote() {
    }

    
    public quote(int quoteID, int serviceID, int customerID, String quoteDate, double totalCost) {
        this.quoteID = quoteID;
        this.serviceID = serviceID;
        this.customerID = customerID;
        this.quoteDate = quoteDate;
        this.totalCost = totalCost;
    }

    
    public quote(int serviceID, int customerID, String quoteDate, double totalCost) {
        this.serviceID = serviceID;
        this.customerID = customerID;
        this.quoteDate = quoteDate;
        this.totalCost = totalCost;
    }

    // Getters and setters 

    public int getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(int quoteID) {
        this.quoteID = quoteID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(String quoteDate) {
        this.quoteDate = quoteDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
