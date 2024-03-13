import java.util.ArrayList;

public class Users {
    private int IDuser;
    private String name;
    private String lastName;
    private int age;
    private String address;
    private ArrayList<Books> rentedBooks = new ArrayList<>();

    public Users(int IDuser, String name, String lastName, int age, String address) {
        this.IDuser = IDuser;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Books> getRentedBooks() {
        return rentedBooks;
    }

    public void addBookUser(Books book){
        rentedBooks.add(book);
    }
}
