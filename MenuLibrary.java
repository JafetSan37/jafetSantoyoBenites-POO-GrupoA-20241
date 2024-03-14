import java.util.ArrayList;
import java.util.Random;

public class MenuLibrary {
    public static void libraryMenu(){//Método menú para la sección Librería
        boolean flag = true;
        int x;
        do{
            System.out.println("\nSelecciona una opción:\n1) Registrar Libro\n2) Registrar Usuario\n3) Libros\n4) Usuarios\n5) Salir");
            System.out.print("\nOpción: ");
            x = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (x){
                case 1 -> registerBook();
                case 2 -> registerUser();
                case 3 -> menuBooks();
                case 4 -> menuUsers();
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
        int opc, year, id, price, inventory;
        String title, author;
        do{
            System.out.println("\nSección:\n1) Renta\n2) Venta\n3) Salir");
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
                    System.out.println("\nRegistrando libro para renta...");
                    id = number.nextInt();
                    Books book = new Books(id,title,author,year);
                    System.out.println("\nAñadiendo a biblioteca...");
                    Library.addBook(book);
                    System.out.println("\nLibro registrado!");
                    flag = false;
                }
                case 2 ->{
                    System.out.print("\nIngresa el título: ");
                    title = Reader.sc.nextLine();
                    System.out.print("\nIngresa el autor: ");
                    author = Reader.sc.nextLine();
                    System.out.print("\nIngresa el año de publicación: ");
                    year = Reader.sc.nextInt();
                    Reader.sc.nextLine();
                    System.out.print("\nIngresa el precio de venta: ");
                    price = Reader.sc.nextInt();
                    System.out.print("\nIngresa el inventario: ");
                    inventory = Reader.sc.nextInt();
                    System.out.println("\nRegistrando libro para venta...");
                    id = number.nextInt();
                    SaleBooks book = new SaleBooks(id,title,author,year,price,inventory);
                    book.setAvailable(true);
                    System.out.println("\nAñadiendo a biblioteca...");
                    Library.addSellBook(book);
                    System.out.println("\nLibro registrado!");
                    flag = false;
                }
                case 3 ->{
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
            System.out.println("\nConfirmar:\n1) Sí\n2) No");
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
                        ArrayList<Books> rentedBooks = new ArrayList<>();
                        user.setRentedBooks(rentedBooks);
                        ArrayList<SaleBooks> soldBooks = new ArrayList<>();
                        user.setSoldBooks(soldBooks);
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
        int opc,b,j,k,y,r,a,year,inventory;
        double price;
        String title,author;
        do{
            System.out.println("\nSelecciona la opción deseada:\n1) Consultar biblioteca (rentas)\n2) Consultar librería (ventas)\n3) Libros disponibles para renta\n4) Libros disponibles en venta\n5) Modificar Libro\n6) Eliminar Libro\n7) Salir");
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
                        System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\nPrecio: %.2f\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear(),book.getPrice());
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
                            System.out.printf("\nID: %s\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\nPrecio: %.2f\nInventario: %d\n",book.getID(),book.getTitle(),book.getAuthor(),book.getYear(),book.getPrice(),book.getInventory());
                            System.out.println("**************");
                        }else if(b==0) System.out.println("\nNo hay libros disponibles.");
                    }
                }
                case 5 ->{
                    st = true;
                    do{
                        System.out.println("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir");
                        a = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        switch (a){
                            case 1 ->{
                                op = true;
                                j = 1;
                                System.out.println("\t\nSelecciona el libro a modificar:\n");
                                for (Books books : Library.getBooksList()){
                                    System.out.printf("\n%d) ID: %s\n   Nombre: %s\n   Autor: %s\n",j,books.getID(),books.getTitle(),books.getAuthor());
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
                                op = true;
                                Books book = Library.getBooksList().get(y);
                                do{
                                    System.out.println("\t\nSelecciona el dato a modificar:\n");
                                    System.out.printf("\n1) Título: %s\n2) Autor: %s\n3) Año de publicación: %d\n4) Salir",book.getTitle(),book.getAuthor(),book.getYear());
                                    System.out.print("\nRespuesta: ");
                                    r = Reader.sc.nextInt();
                                    Reader.sc.nextLine();
                                    switch (r){
                                        case 1 ->{
                                            System.out.print("\nIngresa el título: ");
                                            title = Reader.sc.nextLine();
                                            System.out.println("\nModificando título...");
                                            book.setTitle(title);
                                            System.out.println("\nTítulo modificado!");
                                        }
                                        case 2 ->{
                                            System.out.print("\nIngresa el autor: ");
                                            author = Reader.sc.nextLine();
                                            System.out.println("\nModificando autor...");
                                            book.setAuthor(author);
                                            System.out.println("\nAutor modificado!");
                                        }
                                        case 3 ->{
                                            System.out.print("\nIngresa el año de publicación: ");
                                            year = Reader.sc.nextInt();
                                            Reader.sc.nextLine();
                                            System.out.println("\nModificando año...");
                                            book.setYear(year);
                                            System.out.println("\nAño de publicación modificado!");
                                        }
                                        case 4 ->{
                                            System.out.println("\nRegresando al menú anterior...");
                                            op = false;
                                        }
                                        default -> System.out.println("Error. Selecciona una opción válida");
                                    }
                                }while (op);
                            }
                            case 2 ->{
                                op = true;
                                k = 1;
                                System.out.println("\t\nSelecciona el libro a modificar:\n");
                                for (SaleBooks book : Library.getBooksSell()){
                                    System.out.printf("\n%d) ID: %s\n   Título: %s\n   Autor: %s\n",k,book.getID(),book.getTitle(),book.getAuthor());
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
                                op = true;
                                SaleBooks book = Library.getBooksSell().get(y);
                                do{
                                    System.out.println("\t\nSelecciona el dato a modificar:\n");
                                    System.out.printf("\n1) Título: %s\n2) Autor: %s\n3) Año de publicación: %d\n4) Precio de venta: %.2f\n5) Inventario: %d\n6) Salir",book.getTitle(),book.getAuthor(),book.getYear(),book.getPrice(),book.getInventory());
                                    System.out.print("\nRespuesta: ");
                                    r = Reader.sc.nextInt();
                                    Reader.sc.nextLine();
                                    switch (r){
                                        case 1 ->{
                                            System.out.print("\nIngresa el título: ");
                                            title = Reader.sc.nextLine();
                                            System.out.println("\nModificando título...");
                                            book.setTitle(title);
                                            System.out.println("\nTítulo modificado!");
                                        }
                                        case 2 ->{
                                            System.out.print("\nIngresa el autor: ");
                                            author = Reader.sc.nextLine();
                                            System.out.println("\nModificando autor...");
                                            book.setAuthor(author);
                                            System.out.println("\nAutor modificado!");
                                        }
                                        case 3 ->{
                                            System.out.print("\nIngresa el año de publicación: ");
                                            year = Reader.sc.nextInt();
                                            Reader.sc.nextLine();
                                            System.out.println("\nModificando año...");
                                            book.setYear(year);
                                            System.out.println("\nAño de publicación modificado!");
                                        }
                                        case 4 ->{
                                            System.out.print("\nIngresa el precio de venta: ");
                                            price = Reader.sc.nextDouble();
                                            Reader.sc.nextLine();
                                            System.out.println("\nModificando precio...");
                                            book.setPrice(price);
                                            System.out.println("\nPrecio de venta modificado!");
                                        }
                                        case 5 ->{
                                            System.out.print("\nIngresa el nuevo inventario: ");
                                            inventory = Reader.sc.nextInt();
                                            Reader.sc.nextLine();
                                            System.out.println("\nActualizando inventario...");
                                            book.setInventory(inventory);
                                            if(book.getInventory()==0)book.setAvailable(false);
                                            System.out.println("\nInventario actualizado!");
                                        }
                                        case 6 ->{
                                            System.out.println("\nRegresando al menú anterior...");
                                            op = false;
                                        }
                                        default -> System.out.println("Error. Selecciona una opción válida");
                                    }
                                }while (op);
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
                    st = true;
                    do{
                        System.out.println("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir");
                        a = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        switch (a){
                            case 1 ->{
                                op = true;
                                j = 1;
                                System.out.println("\t\nSelecciona el libro a eliminar:\n");
                                for (Books book : Library.getBooksList()){
                                    System.out.printf("\n%d) ID: %s\n   Título: %s\n   Autor: %s\n",j,book.getID(),book.getTitle(),book.getAuthor());
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
                                if (book.isRented()) System.out.println("Error. El libro fue rentado por un usuario. Favor de retornar el libro antes de borrarlo.");
                                else{
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
                            }
                            case 2 ->{
                                op = true;
                                k = 1;
                                System.out.println("\t\nSelecciona el libro a eliminar:\n");
                                for (SaleBooks book : Library.getBooksSell()){
                                    System.out.printf("\n%d) ID: %s\n   Título: %s\n   Autor: %s\n",k,book.getID(),book.getTitle(),book.getAuthor());
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
                case 7 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    pt = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while(pt);
    }
    public static void menuUsers(){
        boolean st = true, op = true, ag = true;
        int opc,b,i,y,r,cellNumber,age,counter;
        String name,lastName,address;
        do{
            System.out.println("\nSelecciona la opción deseada:\n1) Mostrar Usuarios Registrados\n2) Usuarios con renta de libros\n3) Usuarios con historial de compras\n4) Modificar Usuario\n5) Eliminar Usuario\n6) Salir");
            System.out.print("\nOpción: ");
            opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    b=1;
                    for(Users user:Library.getUsersList()){
                        System.out.printf("\n%d) ID: %s\n   Nombre: %s\n   Apellidos: %s\n   Teléfono: %d\n   Edad: %d\n   Dirección: %s\n",b,user.getIDuser(),user.getName(),user.getLastName(),user.getCellNumber(),user.getAge(),user.getAddress());
                        System.out.println("****************");
                        b+=1;
                    }
                }
                case 2 ->{
                    b=1;
                    counter = 0;
                    for(Users users:Library.getUsersList()){
                        if(!users.getRentedBooks().isEmpty()){
                            System.out.printf("\n%d) Nombre: %s\n   Apellidos: %s\n   Edad: %d\n   Libros rentados: %d\n",b,users.getName(),users.getLastName(),users.getAge(),users.getRentedBooks().size());
                            System.out.println("****************");
                            b+=1;
                        }else{
                            counter+=1;
                            if(counter==Library.getUsersList().size()) System.out.println("\nNo hay usuarios con rentas existentes");
                        }
                    }
                }
                case 3 ->{
                    b=1;
                    counter = 0;
                    for(Users users1:Library.getUsersList()){
                        if(!users1.getSoldBooks().isEmpty()){
                            System.out.printf("\n%d) Nombre: %s\n   Apellidos: %s\n   Edad: %d\n   Libros comprados: %d\n",b,users1.getName(),users1.getLastName(),users1.getAge(),users1.getSoldBooks().size());
                            System.out.println("****************");
                            b+=1;
                        }else{
                            counter+=1;
                            if(counter==Library.getUsersList().size()) System.out.println("\nNo existen usuarios con compras efectuadas");
                        }
                    }
                }
                case 4 ->{
                    op = true;
                    i = 1;
                    System.out.println("\t\nSelecciona el usuario a modificar:\n");
                    for (Users users4 : Library.getUsersList()){
                        System.out.printf("\n%d) Nombre: %s %s", i, users4.getName(), users4.getLastName());
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
                    op = true;
                    Users user = Library.getUsersList().get(y);
                    do{
                        System.out.println("\t\nSelecciona el dato a modificar:\n");
                        System.out.printf("\n1) Nombre: %s\n2) Apellidos: %s\n3) Teléfono: %d\n4) Edad: %d\n5) Dirección: %s\n6) Salir",user.getName(),user.getLastName(),user.getCellNumber(),user.getAge(),user.getAddress());
                        System.out.print("\nRespuesta: ");
                        r = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        switch (r){
                            case 1 ->{
                                System.out.print("\nIngresa el nombre: ");
                                name = Reader.sc.nextLine();
                                System.out.println("\nModificando nombre...");
                                user.setName(name);
                                System.out.println("\nNombre modificado!");
                            }
                            case 2 ->{
                                System.out.print("\nIngresa el apellido: ");
                                lastName = Reader.sc.nextLine();
                                System.out.println("\nModificando apellido...");
                                user.setLastName(lastName);
                                System.out.println("\nApellido modificado!");
                            }
                            case 3 ->{
                                System.out.print("\nIngresa el número: ");
                                cellNumber = Reader.sc.nextInt();
                                Reader.sc.nextLine();
                                System.out.println("\nModificando teléfono...");
                                user.setCellNumber(cellNumber);
                                System.out.println("\nTeléfono modificado!");
                            }
                            case 4 ->{
                                ag = true;
                                do {
                                    System.out.print("\nIngresa la edad: ");
                                    age = Reader.sc.nextInt();
                                    Reader.sc.nextLine();
                                    if(age<18) System.out.println("\nError. El usuario no puede ser menor de edad");
                                    else{
                                        System.out.println("\nModificando edad...");
                                        user.setAge(age);
                                        System.out.println("\nEdad modificada!");
                                        ag = false;
                                    }
                                }while (ag);
                            }
                            case 5 ->{
                                System.out.print("\nIngresa la dirección: ");
                                address = Reader.sc.nextLine();
                                System.out.println("\nModificando dirección...");
                                user.setAddress(address);
                                System.out.println("\nDirección modificada!");
                            }
                            case 6 ->{
                                System.out.println("\nRegresando al menú principal...");
                                op = false;
                            }
                            default -> System.out.println("Error. Selecciona una opción válida");
                        }
                    }while (op);
                }
                case 5 ->{
                    op = true;
                    i = 1;
                    System.out.println("\t\nSelecciona el usuario a eliminar:\n");
                    for (Users users5 : Library.getUsersList()){
                        System.out.printf("\n%d) Nombre: %s %s", i, users5.getName(), users5.getLastName());
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
                    if(user.getRentedBooks().isEmpty()) {
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
                            }else{
                                System.out.println("Cancelando...");
                                op = false;
                            }
                        }while (op);
                    }else{
                        System.out.println("\nError. El usuario aún tiene libros rentados. Favor de solicitar los libros de regreso antes de eliminar");
                    }
                }
                case 6 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    st = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while (st);
    }
}