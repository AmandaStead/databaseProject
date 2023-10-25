public class quote {
    private int quoteID;
    private int serviceID;
    private int customerID;
    private String date;
    private double totalCost;
    private String custnote;
    private int heightFT;

    public quote(int serviceID, int customerID, String date, double totalCost, String custnote, int heightFT) {
        this.serviceID = serviceID;
        this.customerID = customerID;
        this.date = date;
        this.totalCost = totalCost;
        this.custnote = custnote;
        this.heightFT = heightFT;
    }

    
   

    // Getters and setters 

    
    public int getQuoteID() {
        return quoteID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getDate() {
        return date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getCustnote() {
        return custnote;
    }

    public int getHeightFT() {
        return heightFT;
    }

    // Setter methods
    public void setQuoteID(int quoteID) {
        this.quoteID = quoteID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setCustnote(String custnote) {
        this.custnote = custnote;
    }

    public void setHeightFT(int heightFT) {
        this.heightFT = heightFT;
    }
}
