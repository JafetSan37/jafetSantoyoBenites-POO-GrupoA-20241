import java.util.ArrayList;

public class Library { //la clase es andy
    private static ArrayList<Books> booksList = new ArrayList<>();
    private static ArrayList<Users> usersList = new ArrayList<>();
    private static ArrayList<SaleBooks> booksSell = new ArrayList<>();
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

    public static ArrayList<Books> getBooks() { //hacer algo static es como poner el nombre de andy en su bota
        return booksList;
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
