public class user 
{
		protected int customerid;
		protected String password;
	 	protected String email;
	    protected String firstName;
	    protected String lastName;
	    protected String adress_street_num;
	    protected String adress_street;
	    protected String adress_city;
	    protected String adress_state;
	    protected String adress_zip_code;
	    protected String birthday;
	    protected String cc_num;
	    protected String cc_exp;
	    protected String cc_cvv;
	    protected String phone;
	    
	 
	    //constructors
	   
	 
	    public user(String email) 
	    {
	        this.email = email;
	    }
	    
	    public user(int customerid,String email,String firstName, String lastName, String password,String birthday, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code,String cc_num, String cc_exp, String cc_cvv, String phone) 
	    {
	    	this(customerid,firstName,lastName,password,birthday, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code,cc_num, cc_exp, cc_cvv, phone);
	    	this.email = email;
	    }
	 
	
	    public user(int customerid,String firstName, String lastName, String password,String birthday, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code, String cc_num, String cc_exp, String cc_cvv, String phone) 
	    {
	    	this.customerid = customerid;
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.password = password;
	        this.birthday = birthday;
	        this.adress_street_num = adress_street_num;
	        this.adress_street = adress_street;
	        this.adress_city= adress_city;
	        this.adress_state = adress_state;
	        this.adress_zip_code = adress_zip_code;
	        this.cc_num = cc_num;
	        this.cc_exp = cc_exp;
	        this.cc_cvv = cc_cvv;
	        this.phone = phone;
	       
	    }
	    
	   public user(String email, String firstName, String lastName, String password, String birthday,
				String adress_street_num, String adress_street, String adress_city, String adress_state,
				String adress_zip_code,String cc_num, String cc_exp, String cc_cvv, String phone) {
		   	
		   	this.email = email;
		   	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.password = password;
	        this.birthday = birthday;
	        this.adress_street_num = adress_street_num;
	        this.adress_street = adress_street;
	        this.adress_city= adress_city;
	        this.adress_state = adress_state;
	        this.adress_zip_code = adress_zip_code;
	        this.cc_num = cc_num;
	        this.cc_exp = cc_exp;
	        this.cc_cvv = cc_cvv;
	        this.phone = phone;
		}


		//getter and setter methods
	    public int getcustomerid() {
	        return customerid;
	    }
	    public void setcustomerid(int customerid) {
	        this.customerid = customerid;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	  
	    public String getBirthday() {
	    	return birthday;
	    }
	    public void setBirthday(String birthday) {
	    	this.birthday = birthday;
	    }
	    
	    public String getAdress_street_num() {
	        return adress_street_num;
	    }
	    public void setAdress_street_num(String adress_street_num) {
	        this.adress_street_num = adress_street_num;
	    }
	    public String getAdress_street() {
	        return adress_street;
	    }
	    public void setAdress_street(String adress_street) {
	        this.adress_street = adress_street;
	    }
	    public String getAdress_city() {
	        return adress_city;
	    }
	    public void setAdress_city(String adress_city) {
	        this.adress_city = adress_city;
	    }
	    public String getAdress_state() {
	        return adress_state;
	    }
	    public void setAdress_state(String adress_state) {
	        this.adress_state = adress_state;
	    }
	    public String getAdress_zip_code() {
	        return adress_zip_code;
	    }
	    public void setAdress_zip_code(String adress_zip_code) {
	        this.adress_zip_code = adress_zip_code;
	    }


	    public String getcc_num() {
	    	return cc_num;
	    	
	    }
	    public void setcc_num(String cc_num) {
	    	this.cc_num = cc_num;
	    	
	    }
	    public String getcc_exp() {
	    	return cc_exp;
	    }
	    
	    public void setcc_exp(String cc_exp) {
	    	this.cc_exp = cc_exp;
	    	
	    }
	    public String getcc_cvv() {
	    	return cc_cvv;
	    	
	    }
	    public void setcc_cvv(String cc_cvv) {
	    	this.cc_cvv = cc_cvv;
	    	
	    }
	    public String getphone() {
	    	return phone;
	    	
	    }
	    public void setphone(String phone) {
	    	this.phone = phone;
	    	
	    }
	    
	}
