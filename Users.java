import java.util.ArrayList;

public class Users {
    private int IDuser;
    private String name;
    private String lastName;
    private long cellNumber;
    private int age;
    private String address;
    private ArrayList<Books> rentedBooks = new ArrayList<>();
    private ArrayList<SaleBooks> soldBooks = new ArrayList<>();
    //Método Constructor de la clase.
    public Users(int IDuser, String name, String lastName, long cellNumber, int age, String address) {
        this.IDuser = IDuser;
        this.name = name;
        this.lastName = lastName;
        this.cellNumber = cellNumber;
        this.age = age;
        this.address = address;
    }
    //Getters y Setters de la clase.
    public int getIDuser() {
        return IDuser;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public long getCellNumber() {
        return cellNumber;
    }
    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public ArrayList<Books> getRentedBooks() {
        return rentedBooks;
    }
    public void setRentedBooks(ArrayList<Books> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }
    public void addBookUser(Books book){
        rentedBooks.add(book);
    }
    public ArrayList<SaleBooks> getSoldBooks() {
        return soldBooks;
    }
    public void setSoldBooks(ArrayList<SaleBooks> soldBooks) {
        this.soldBooks = soldBooks;
    }
    public void addSoldBookUser(SaleBooks book){
        soldBooks.add(book);
    }
}
