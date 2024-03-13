import java.util.Random;

public class SaleBooks {
    Random number = new Random();
    private int ID;
    private String title;
    private String author;
    private int year;
    private int inventory;
    private boolean available = true;

    public SaleBooks(int ID, String title, String author, int year, int inventory) {
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.year = year;
        this.inventory = inventory;
        this.available = available;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        ID = number.nextInt(10000000,99999999);
        this.ID = ID;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
