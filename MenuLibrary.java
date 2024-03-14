import java.util.Random;

public class MenuLibrary {
    public static void libraryMenu(){//Método menú para la sección Librería
        boolean flag = true;
        int x;
        do{
            System.out.println("\nSelecciona una opción:\n1) Registrar Libro\n2) Registrar Usuario\n3) Libros\n4) Usuarios\n5)Salir");
            System.out.print("\nOpción: ");
            x = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (x){
                case 1 ->{
                    registerBook();
                }
                case 2 ->{
                    registerUser();
                }
                case 3 ->{
                    menuBooks();
                }
                case 4 ->{
                    menuUsers();
                }
                case 5 ->{
                    System.out.println("\nRegresando al menú principal...");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while (flag);
    }
    //Métodos diseñados para cada sección del menú
    public static void registerBook(){
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
    public static void registerUser(){
        Random number = new Random();
        boolean sig = true;
        int opc, idUser,cellNumber,age;
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
                    System.out.print("\nIngresa un número de teléfono: ");
                    cellNumber = Reader.sc.nextInt();
                    System.out.print("\nIngresa la edad: ");
                    age = Reader.sc.nextInt();
                    if(age < 18){
                        System.out.println("Error. El usuario es menor de edad.\nRegresando al menú...");
                    }else{
                        System.out.println("\nRegistrando usuario..");
                        idUser = number.nextInt(100000,999999);
                        Users user = new Users(idUser,name,lastName,age,cellNumber,address);
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
    public static void menuBooks(){
        boolean pt = true, op = true, st = true;
        int opc,b,j,k,y,r,a;
        do{
            System.out.println("\nSelecciona la opción deseada:\n1) Consultar biblioteca (rentas)\n2) Consultar librería (ventas)\n3) Libros disponibles para renta\n4) Libros disponibles en venta\n5) Eliminar Libro\n6) Salir");
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
                    b=0;//Ciclo para contar los libros disponibles.
                    for(Books books:Library.getBooksList()){
                        if(books.isRented()) b+=1;
                    }
                    for(Books book:Library.getBooksList()){
                        if(!book.isRented()){
                            System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear());
                            System.out.println("**************");
                        }else if(b==0) System.out.println("\nNo hay libros disponibles.");
                    }
                }
                case 4 ->{
                    b = 0;//Ciclo para contar libros disponibles.
                    for(SaleBooks books:Library.getBooksSell()){
                        if(books.isAvailable()) b+=1;
                    }
                    for(SaleBooks book:Library.getBooksSell()){
                        if(book.isAvailable()){
                            System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear());
                            System.out.println("**************");
                        }else if(b==0) System.out.println("\nNo hay libros disponibles.");
                    }
                }
                case 5 ->{
                    do{
                        System.out.println("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir");
                        a = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        switch (a){
                            case 1 ->{
                                j = 1;
                                System.out.println("\t\nSelecciona el libro a eliminar:\n");
                                for (Books book : Library.getBooksList()){
                                    System.out.printf("\n%d) ID: %s\n   Nombre: %s\n   Autor: %s",j,book.getID(),book.getTitle(),book.getAuthor());
                                    j++;
                                }
                                do {
                                    y = 0;
                                    System.out.print("\nRespuesta: ");
                                    y = Reader.sc.nextInt();
                                    Reader.sc.nextLine();
                                    y -= 1;
                                    if (y > Library.getBooksList().size()) System.out.println("Error. Ingresa una opción válida.");
                                    else op = false;
                                } while (op);
                                Books book = Library.getBooksList().get(y);
                                System.out.println("\nSeguro/a que deseas eliminar este libro?\n1) Sí\n2) No");
                                op = true;
                                do {
                                    r = 0;
                                    System.out.print("\nRespuesta: ");
                                    r = Reader.sc.nextInt();
                                    Reader.sc.nextLine();
                                    if (r != 1 && r != 2) System.out.println("Error. Selecciona una opción válida.");
                                    else if (r == 1){
                                        System.out.println("Eliminando...");
                                        Library.getBooksList().remove(book);
                                        System.out.println("Libro para renta eliminado");
                                        op = false;
                                    }else if(r == 2){
                                        System.out.println("Cancelando...");
                                        op = false;
                                    }
                                } while (op);
                            }
                            case 2 ->{
                                k = 1;
                                System.out.println("\t\nSelecciona el libro a eliminar:\n");
                                for (SaleBooks book : Library.getBooksSell()){
                                    System.out.printf("\n%d) ID: %s\n   Nombre: %s\n   Autor: %s",k,book.getID(),book.getTitle(),book.getAuthor());
                                    k++;
                                }
                                do {
                                    y = 0;
                                    System.out.print("\nRespuesta: ");
                                    y = Reader.sc.nextInt();
                                    Reader.sc.nextLine();
                                    y -= 1;
                                    if (y > Library.getBooksSell().size()) System.out.println("Error. Ingresa una opción válida.");
                                    else op = false;
                                } while (op);
                                SaleBooks book = Library.getBooksSell().get(y);
                                System.out.println("\nSeguro/a que deseas eliminar este libro del inventario?\n1) Sí\n2) No");
                                op = true;
                                do {
                                    r = 0;
                                    System.out.print("\nRespuesta: ");
                                    r = Reader.sc.nextInt();
                                    Reader.sc.nextLine();
                                    if (r != 1 && r != 2) System.out.println("Error. Selecciona una opción válida.");
                                    else if (r == 1){
                                        System.out.println("Eliminando...");
                                        Library.getBooksSell().remove(book);
                                        System.out.println("Libro eliminado del inventario");
                                        op = false;
                                    }else if(r == 2){
                                        System.out.println("Cancelando...");
                                        op = false;
                                    }
                                } while (op);
                            }
                            case 3 ->{
                                System.out.println("\nRegresando al menú anterior...");
                                st = false;
                            }
                            default -> System.out.println("Error. Selecciona una opción válida.");
                        }
                    }while(st);
                }
                case 6 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    pt = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while(pt);
    }
    public static void menuUsers(){
        boolean st = true, op = true;
        int opc,b,i,y,r;
        do{
            System.out.println("\nSelecciona la opción deseada:\n1) Mostrar Usuarios Registrados\n2) Usuarios con renta de libros\n3) Usuarios con historial de compras\n4) Eliminar Usuario\n5) Salir");
            System.out.print("\nOpción: ");
            opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    b=1;
                    for(Users user:Library.getUsersList()){
                        System.out.printf("\n%d) ID: %s\nNombre: %s\n   Apellidos: %s\n   Teléfono: %d\n   Edad: %d\n   Dirección: %s",b,user.getIDuser(),user.getName(),user.getLastName(),user.getCellNumber(),user.getAge(),user.getAddress());
                        System.out.println("****************");
                        b+=1;
                    }
                }
                case 2 ->{
                    b=1;
                    for(Users users:Library.getUsersList()){
                        if(!users.getRentedBooks().isEmpty()){
                            System.out.printf("\n%d) Nombre: %s\n   Apellidos: %s\n   Edad: %d\n   Libros rentados: %d",b,users.getName(),users.getLastName(),users.getAge(),users.getRentedBooks().size());
                            System.out.println("****************");
                            b+=1;
                        }
                    }
                }
                case 3 ->{
                    b=1;
                    for(Users users1:Library.getUsersList()){
                        if(!users1.getRentedBooks().isEmpty()){
                            System.out.printf("\n%d) Nombre: %s\n   Apellidos: %s\n   Edad: %d\n   Libros comprados: %d",b,users1.getName(),users1.getLastName(),users1.getAge(),users1.getSoldBooks().size());
                            System.out.println("****************");
                            b+=1;
                        }
                    }
                }
                case 4 ->{
                    i = 1;
                    System.out.println("\t\nSelecciona el usuario a eliminar:\n");
                    for (Users users2 : Library.getUsersList()){
                        System.out.printf("\n%d) Nombre: %s %s", i, users2.getName(), users2.getLastName());
                        i++;
                    }
                    do {
                        y = 0;
                        System.out.print("\nRespuesta: ");
                        y = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        y -= 1;
                        if (y > Library.getUsersList().size()) System.out.println("Error. Ingresa una opción válida.");
                        else op = false;
                    } while (op);
                    Users user = Library.getUsersList().get(y);
                    if(!user.getSoldBooks().isEmpty()) System.out.println("\nError. El usuario aún tiene libros rentados. Favor de solicitar los libros de regreso antes de eliminar");
                    else{
                        System.out.printf("\nSeguro/a que deseas eliminar a %s %s?\n1) Sí\n2) No",user.getName(),user.getLastName());
                        op = true;
                        do {
                            r = 0;
                            System.out.print("\nRespuesta: ");
                            r = Reader.sc.nextInt();
                            Reader.sc.nextLine();
                            if (r != 1 && r != 2) System.out.println("Error. Selecciona una opción válida.");
                            else if (r == 1){
                                System.out.println("Eliminando...");
                                Library.getUsersList().remove(user);
                                System.out.println("Usuario eliminado");
                                op = false;
                            }else if(r == 2){
                                System.out.println("Cancelando...");
                                op = false;
                            }
                        } while (op);
                    }
                }
                case 5 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    st = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while (st);
    }
}