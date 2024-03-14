import java.util.ArrayList;

public class Library {
    private static ArrayList<Books> booksList = new ArrayList<>();
    private static ArrayList<Users> usersList = new ArrayList<>();
    private static ArrayList<SaleBooks> booksSell = new ArrayList<>();
    //Getters y Setters de la clase.
    public static ArrayList<Books> getBooksList() {
        return booksList;
    }
    public static ArrayList<Users> getUsersList() {
        return usersList;
    }
    public static ArrayList<SaleBooks> getBooksSell() {
        return booksSell;
    }
    //Métodos para añadir elementos a las listas correspondientes.
    public static void addBook(Books book){
        booksList.add(book);
    }
    public static void addUser(Users user){
        usersList.add(user);
    }
    public static void addSellBook(SaleBooks sellbook){
        booksSell.add(sellbook);
    }
}
