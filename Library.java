import java.util.ArrayList;

public class Library {
    private ArrayList<Books> booksList = new ArrayList<>();
    private ArrayList<Users> usersList = new ArrayList<>();
    private ArrayList<SaleBooks> booksSell = new ArrayList<>();
    //Getters y Setters de la clase.
    public ArrayList<Books> getBooksList() {
        return booksList;
    }
    public ArrayList<Users> getUsersList() {
        return usersList;
    }
    public ArrayList<SaleBooks> getBooksSell() {
        return booksSell;
    }

    //Métodos para añadir elementos a las listas correspondientes.
    public void addBook(Books book){
        booksList.add(book);
    }
    public void addUser(Users user){
        usersList.add(user);
    }
    public void addSellBook(SaleBooks sellbook){
        booksSell.add(sellbook);
    }
}
