import java.sql.Timestamp;

public class orderofwork {
    private int quoteId;
    private int price;
    private Timestamp schedulestart;
    private Timestamp scheduleend;
    

    // Constructors

    public orderofwork() {
    }

    public orderofwork(int quoteId,int price,Timestamp schedulestart,Timestamp scheduleend) {
        this.quoteId = quoteId;
        this.price = price;
        this.schedulestart = schedulestart;
        this.scheduleend = scheduleend;
       
    }

    // Getters and Setters

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public Timestamp getschedulestart() {
        return schedulestart;
    }
    public void setschedulestart(Timestamp schedulestart) {
        this.schedulestart = schedulestart;
    }
    public Timestamp getschedulend() {
        return scheduleend;
    }
    public void setscheduleend(Timestamp scheduleend) {
        this.scheduleend = scheduleend;
    }
    


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // toString method (optional)

    @Override
    public String toString() {
        return "OrderOfWork{" +
                "quoteId=" + quoteId +
                ", schedulestart=" + schedulestart +
                ", scheduleend=" + scheduleend +
                ", price=" + price +
                '}';
    }
}
