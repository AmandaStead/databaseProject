public class BigClients {
    protected String firstname;
    protected String lastname;
    protected int customerid;
    protected int quoteid;
    protected int quote_customerid;
    protected String tree_count;

    // Constructors...

    public BigClients(String firstname, String lastname, int customerid, int quoteid, int quote_customerid, String tree_count) {
		// TODO Auto-generated constructor stub
    	
    	
    	
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.customerid = customerid;
    	this.quoteid = quoteid;
    	this.quote_customerid = quote_customerid;
    	this.tree_count = tree_count;
	}

    
    
	public BigClients(String firstname, String lastname) {
		// TODO Auto-generated constructor stub
		this.firstname = firstname;
		this.lastname = lastname;
	}



	// Getter and Setter for firstname
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    // Getter and Setter for lastname
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    // Getter and Setter for customerid
    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    // Getter and Setter for quoteid
    public int getQuoteid() {
        return quoteid;
    }

    public void setQuoteid(int quoteid) {
        this.quoteid = quoteid;
    }

    // Getter and Setter for quote_customerid
    public int getQuote_customerid() {
        return quote_customerid;
    }

    public void setQuote_customerid(int quote_customerid) {
        this.quote_customerid = quote_customerid;
    }

    // Getter and Setter for tree_count
    public String getTree_count() {
        return tree_count;
    }

    public void setTree_count(String tree_count) {
        this.tree_count = tree_count;
    }
}

