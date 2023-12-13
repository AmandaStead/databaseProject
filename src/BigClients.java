import java.sql.Timestamp;

public class BigClients {
    protected String firstname;
    protected String lastname;
    protected int customerid;
    protected int quoteid;
    
    protected String tree_count;
    protected int id;
    protected int price;
    protected Timestamp schedulestart;
    protected Timestamp schedulend;

    // Constructors...

    public BigClients(String firstname, String lastname, int customerid, int quoteid, String tree_count) {
		// TODO Auto-generated constructor stub
    	
    	
    	
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.customerid = customerid;
    	this.quoteid = quoteid;
    	
    	this.tree_count = tree_count;
	}

    
    
	public BigClients(int quoteid,int price,Timestamp schedulestart, Timestamp scheduleend) {
		// TODO Auto-generated constructor stub
		
		this.quoteid = quoteid;
		this.price = price;
		this.schedulestart = schedulestart;
		this.schedulend = scheduleend;
	}



	public BigClients(int customerid, String firstname, String lastname) {
		// TODO Auto-generated constructor stub
		this.customerid = customerid;
		this.firstname = firstname;
		this.lastname = lastname;
	}



	public BigClients(int quoteid, int customerid, String firstname, String lastname) {
		// TODO Auto-generated constructor stub
		this.quoteid = quoteid;
		this.customerid = customerid;
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



    // Getter and Setter for tree_count
    public String getTree_count() {
        return tree_count;
    }

    public void setTree_count(String tree_count) {
        this.tree_count = tree_count;
    }
}

