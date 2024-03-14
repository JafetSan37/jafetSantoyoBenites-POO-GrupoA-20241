import java.util.ArrayList;
import java.util.Random;

public class PreChargedObjects {
    Library library = new Library();
    Random number = new Random();
    public void addElements(){
        //Libros para Renta
        int a,b,c,d,e,f;
        a = number.nextInt(100000, 999999);
        Books book1 = new Books(a, "Cazadores de Sombras: Ciudad de Hueso","Cassandra Clare",2007);
        book1.setRented(false);
        b = number.nextInt(100000, 999999);
        Books book2 = new Books(b,"Caballo de Troya 1: Jerusalén","J.J. Benítez",1987);
        book2.setRented(false);
        c = number.nextInt(100000, 999999);
        Books book3 = new Books(c,"Amarse con los Ojos Abiertos","J.Bucay y S.Salinas",2002);
        book3.setRented(false);
        d = number.nextInt(100000, 999999);
        Books book4 = new Books(d, "Harry Potter: La Piedra Filosofal","J.K. Rowling",2001);
        book4.setRented(false);
        e = number.nextInt(100000, 999999);
        Books book5 = new Books(e,"GOG","J.J. Benítez",2017);
        book5.setRented(false);
        f = number.nextInt(100000, 999999);
        Books book6 = new Books(f,"Los Cuatro Acuerdos","Miguel Ruiz",2000);
        book6.setRented(false);
        //Añadiendo los libros a la librería
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        //Libros para Venta
        int h,i,j,k,l,m;
        h = number.nextInt(100000, 999999);
        SaleBooks sellbook1 = new SaleBooks(h,"Cazadores de Sombras: Ciudad de Hueso","Cassandra Clare",2017,328,15);
        sellbook1.setAvailable(true);
        i = number.nextInt(100000, 999999);
        SaleBooks sellbook2 = new SaleBooks(i,"Caballo de Troya 1: Jerusalén","J.J. Benítez",2011,418,5);
        sellbook2.setAvailable(true);
        j = number.nextInt(100000, 999999);
        SaleBooks sellbook3 = new SaleBooks(j,"Amarse con los Ojos Abiertos","J.Bucay y S.Salinas",2019,345,12);
        sellbook3.setAvailable(true);
        k = number.nextInt(100000, 999999);
        SaleBooks sellbook4 = new SaleBooks(k, "Harry Potter: La Piedra Filosofal","J.K. Rowling",2020,369,10);
        sellbook4.setAvailable(true);
        l = number.nextInt(100000, 999999);
        SaleBooks sellbook5 = new SaleBooks(l,"GOG","J.J. Benítez",2022,158,20);
        sellbook5.setAvailable(true);
        m = number.nextInt(100000, 999999);
        SaleBooks sellbook6 = new SaleBooks(m,"Los Cuatro Acuerdos","Miguel Ruiz",2009,280,6);
        sellbook6.setAvailable(true);
        //Añadiendo a la librería sección ventas
        library.addSellBook(sellbook1);
        library.addSellBook(sellbook2);
        library.addSellBook(sellbook3);
        library.addSellBook(sellbook4);
        library.addSellBook(sellbook5);
        library.addSellBook(sellbook6);
        //Usuarios pre-registrados
        int q,w,u,r,t,y;
        q = number.nextInt(100000, 999999);
        Users user1 = new Users(q,"Jafet","Santoyo",512323457,27,"Calle Ezequiel #78");
        ArrayList<Books> bookRent = new ArrayList<>();
        ArrayList<SaleBooks> bookSale = new ArrayList<>();
        user1.setRentedBooks(bookRent);
        user1.setSoldBooks(bookSale);
        w = number.nextInt(100000, 999999);
        Users user2 = new Users(w,"Fátima","Rivera",512323457,24,"Calle Fco. Rincón #56");
        ArrayList<Books> bookRent1 = new ArrayList<>();
        ArrayList<SaleBooks> bookSale1 = new ArrayList<>();
        user2.setRentedBooks(bookRent1);
        user2.setSoldBooks(bookSale1);
        u = number.nextInt(100000, 999999);
        Users user3 = new Users(u,"Andrés","Benites",512323457,21,"Calle Ezequiel #78");
        ArrayList<Books> bookRent2 = new ArrayList<>();
        ArrayList<SaleBooks> bookSale2 = new ArrayList<>();
        user3.setRentedBooks(bookRent2);
        user3.setSoldBooks(bookSale2);
        r = number.nextInt(100000, 999999);
        Users user4 = new Users(r,"Andrea","Durán",512323457,27,"Calle El Porvenir #39");
        ArrayList<Books> bookRent3 = new ArrayList<>();
        ArrayList<SaleBooks> bookSale3 = new ArrayList<>();
        user4.setRentedBooks(bookRent3);
        user4.setSoldBooks(bookSale3);
        t = number.nextInt(100000, 999999);
        Users user5 = new Users(t,"Alejandro","Montejano",512323457,24,"Calle Del Río #10");
        ArrayList<Books> bookRent4 = new ArrayList<>();
        ArrayList<SaleBooks> bookSale4 = new ArrayList<>();
        user5.setRentedBooks(bookRent4);
        user5.setSoldBooks(bookSale4);
        y = number.nextInt(100000, 999999);
        Users user6 = new Users(y,"Atziri","Mancilla",512323457,28,"Calle Hacienda Azul #63");
        ArrayList<Books> bookRent5 = new ArrayList<>();
        ArrayList<SaleBooks> bookSale5 = new ArrayList<>();
        user6.setRentedBooks(bookRent5);
        user6.setSoldBooks(bookSale5);
        //Añadiendo usuarios a la lista de la librería
        library.addUser(user1);
        library.addUser(user2);
        library.addUser(user3);
        library.addUser(user4);
        library.addUser(user5);
        library.addUser(user6);
    }
}
