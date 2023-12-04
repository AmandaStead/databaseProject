public class tree {
    private int id;
    private int quoteid;
    private double size;
    private double height;
    private double distancefromhouse;

    // Constructors

    public tree() {
    }

    public tree(int id, int quoteid, double size, double height, double distancefromhouse) {
        this.id = id;
        this.quoteid = quoteid;
        this.size = size;
        this.height = height;
        this.distancefromhouse = distancefromhouse;
    }

    // Getters and Setters

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getquoteid() {
        return quoteid;
    }

    public void setquoteid(int quoteid) {
        this.quoteid = quoteid;
    }

    public double getsize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getheight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getdistancefromhouse() {
        return distancefromhouse;
    }

    public void setdistanceFromHouse(double distanceFromHouse) {
        this.distancefromhouse = distanceFromHouse;
    }
}
