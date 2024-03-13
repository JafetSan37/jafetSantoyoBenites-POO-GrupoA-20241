import java.util.Random;

public class PreChargedBooks {
    static Random number = new Random();
    public static void addElements(){
        //Libros para Renta
        int a = number.nextInt(100000, 999999);
        Books book1 = new Books(a, "Cazadores de Sombras: Ciudad de Hueso","Cassandra Clare",2007);
        int b = number.nextInt(100000, 999999);
        Books book2 = new Books(b,"Caballo de Troya 1: Jerusalén","J.J. Benítez",1987);
        int c = number.nextInt(100000, 999999);
        Books book3 = new Books(c,"Amarse con los Ojos Abiertos","J.Bucay y S.Salinas",2002);
        int d = number.nextInt(100000, 999999);
        Books book4 = new Books(d, "Harry Potter: La Piedra Filosofal","J.K. Rowling",2001);
        int e = number.nextInt(100000, 999999);
        Books book5 = new Books(e,"GOG","J.J. Benítez",2017);
        int f = number.nextInt(100000, 999999);
        Books book6 = new Books(f,"Los Cuatro Acuerdos","Miguel Ruiz",2000);
        //Añadiendo los libros a la librería
        Library.addBook(book1);
        Library.addBook(book2);
        Library.addBook(book3);
        Library.addBook(book4);
        Library.addBook(book5);
        Library.addBook(book6);
        //Libros para Venta
        int h = number.nextInt(100000, 999999);
        SaleBooks sellbook1 = new SaleBooks(h,"Cazadores de Sombras: Ciudad de Hueso","Cassandra Clare",2007,15);
        int i = number.nextInt(100000, 999999);
        SaleBooks sellbook2 = new SaleBooks(i,"Caballo de Troya 1: Jerusalén","J.J. Benítez",1987,5);
        int j = number.nextInt(100000, 999999);
        SaleBooks sellbook3 = new SaleBooks(j,"Amarse con los Ojos Abiertos","J.Bucay y S.Salinas",2002,12);
        int k = number.nextInt(100000, 999999);
        SaleBooks sellbook4 = new SaleBooks(k, "Harry Potter: La Piedra Filosofal","J.K. Rowling",2001,10);
        int l = number.nextInt(100000, 999999);
        SaleBooks sellbook5 = new SaleBooks(l,"GOG","J.J. Benítez",2017,20);
        int m = number.nextInt(100000, 999999);
        SaleBooks sellbook6 = new SaleBooks(m,"Los Cuatro Acuerdos","Miguel Ruiz",2000,6);
        //Añadiendo a la librería sección ventas
        Library.addSellBook(sellbook1);
        Library.addSellBook(sellbook2);
        Library.addSellBook(sellbook3);
        Library.addSellBook(sellbook4);
        Library.addSellBook(sellbook5);
        Library.addSellBook(sellbook6);
    }
}
