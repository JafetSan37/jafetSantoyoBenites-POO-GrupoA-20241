public class SaleBooks {
    private int ID;
    private String title;
    private String author;
    private int year;
    private double price;
    private int inventory;
    private boolean available;
    //Método Constructor de la clase.
    public SaleBooks(int ID, String title, String author, int year, double price, int inventory) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.inventory = inventory;
        this.available = true;
    }
    //Getters y Setters de la clase.
    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getInventory() {
        return inventory;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
}
