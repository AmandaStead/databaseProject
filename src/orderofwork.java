public class orderofwork {
    private int quoteId;
    private String date;
    private int price;

    // Constructors

    public orderofwork() {
    }

    public orderofwork(int quoteId, String date , int price) {
        this.quoteId = quoteId;
        this.date = date;
        this.price = price;
    }

    // Getters and Setters

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
