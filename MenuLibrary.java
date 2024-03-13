import java.util.Random;

public class MenuLibrary {
    public static void libraryMenu(){
        System.out.println("\nSelecciona una opción:\n1) Registrar Libro\n2) Registrar Usuario\n3) Libros\n4) Usuarios\n5)Salir");
    }
    public void registerBook(){
        Random number = new Random();
        boolean flag = true;
        int opc, year, id;
        String title, author;
        do{
            System.out.println("\nConfirmar:\n1) Sí\n2)No");
            System.out.print("\nOpción: ");
            opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    System.out.print("\nIngresa el título: ");
                    title = Reader.sc.nextLine();
                    System.out.print("\nIngresa el autor: ");
                    author = Reader.sc.nextLine();
                    System.out.print("\nIngresa el año de publicación: ");
                    year = Reader.sc.nextInt();
                    Reader.sc.nextLine();
                    System.out.println("\nRegistrando...");
                    id = number.nextInt();
                    Books book = new Books(id,title,author,year);
                    System.out.println("\nAñadiendo a biblioteca...");
                    Library.addBook(book);
                    System.out.println("\nLibro registrado!");
                    flag = false;
                }
                case 2 ->{
                    System.out.println("\nRegresando al menú anterior...\n");
                    flag = false;
                }
                default -> System.out.println("Error. Elige una opción válida.");
            }
        }while(flag);
    }
    public void registerUser(){
        Random number = new Random();
        boolean sig = true;
        int opc, idUser,age;
        String name, lastName, address;
        do{
            System.out.println("\nConfirmar:\n1) Sí\n2)No");
            System.out.print("\nOpción: ");
            opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    System.out.print("\nIngresa el nombre: ");
                    name = Reader.sc.nextLine();
                    System.out.print("\nIngresa los apellidos: ");
                    lastName = Reader.sc.nextLine();
                    System.out.print("\nIngresa la dirección: ");
                    address = Reader.sc.nextLine();
                    System.out.print("\nIngresa la edad: ");
                    age = Reader.sc.nextInt();
                    if(age < 18){
                        System.out.println("Error. El usuario es menor de edad.\nRegresando al menú...");
                    }else{
                        System.out.println("\nRegistrando usuario..");
                        idUser = number.nextInt();
                        Users user = new Users(idUser,name,lastName,age,address);
                        System.out.println("\nAñadiendo a base de datos...");
                        Library.addUser(user);
                        System.out.println("\nUsuario registrado!");
                    }
                    sig = false;
                }
                case 2 ->{
                    System.out.println("\nRegresando al menú anterior...\n");
                    sig = false;
                }
                default -> System.out.println("Error. Elige una opción válida.");
            }
        }while(sig);
    }
    public void menuBooks(){
        boolean pt = true;
        int opc, i;
        do{
            System.out.println("\nSelecciona la opción deseada:\n1) Consultar biblioteca (rentas)\n2) Consultar librería (ventas)\n3) Libros disponibles para renta\n4) Libros disponibles en venta\n5) Salir");
            System.out.print("\nOpción: ");
            opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    for(Books book:Library.getBooksList()){
                        System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear());
                        System.out.println("**************");
                    }
                }
                case 2 ->{
                    for(SaleBooks book:Library.getBooksSell()){
                        System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear());
                        System.out.println("**************");
                    }
                }
                case 3 ->{
                    for(Books book:Library.getBooksList()){
                        if(book.isRented()){
                            System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear());
                            System.out.println("**************");
                        }
                    }
                }
                case 4 ->{
                    for(SaleBooks book:Library.getBooksSell()){
                        if(book.isAvailable()){
                            System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear());
                            System.out.println("**************");
                        }
                    }
                }
                case 5 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    pt = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while(pt);
    }
    public void menuUsers(){

    }
}
