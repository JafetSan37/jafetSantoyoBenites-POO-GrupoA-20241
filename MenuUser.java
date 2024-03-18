import java.util.ArrayList;

public class MenuUser {
    Library library = new Library();
    Reader reader = new Reader();
    ArrayList<Books> availableBooks = new ArrayList<>();//ArrayList para los libros disponibles para el usuario
    ArrayList<Integer> idAvailableBooks = new ArrayList<>();//ArrayList para almacenar los ID de los libros disponibles

    public void userMenu(){//Método menú para la sección Usuario.
        boolean flag = true;
        int x;
        do{
            System.out.println("\nSelecciona la opción deseada:\n1) Consultar libros\n2) Solicitar un libro\n3) Devolver un libro\n4) Comprar libro\n5) Salir");
            System.out.print("\nOpción: ");
            x = reader.sc.nextInt();
            reader.sc.nextLine();
            switch (x){
                case 1 -> consultBook();
                case 2 -> askBook();
                case 3 -> retBook();
                case 4 -> buyBook();
                case 5 ->{
                    System.out.println("\nRegresando al menú principal...");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida");
            }
        }while (flag);
    }
    //Métodos diseñados para cada sección del menú
    private void consultBook(){
        boolean pt = true;
        int a,counter;
        do{
            System.out.println("\nSelecciona una opción:\n1) Libros en renta\n2) Libros en venta\n3) Salir");
            System.out.print("\nOpción: ");
            a = reader.sc.nextInt();
            reader.sc.nextLine();
            switch (a){
                case 1 ->{
                    counter=0;
                    for(Books book:library.getBooksList()){
                        if(!book.isRented()){
                            System.out.printf("\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getTitle(),book.getAuthor(),book.getYear());
                            System.out.println("**************");
                        }else counter+=1;
                    }
                    if(counter==library.getBooksList().size()) System.out.println("\nNo hay libros disponibles.");
                }
                case 2 ->{
                    counter = 0;
                    for(SaleBooks book:library.getBooksSell()){
                        if(book.isAvailable()){
                            System.out.printf("\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\nPrecio: %.2f\n",book.getTitle(),book.getAuthor(),book.getYear(),book.getPrice());
                            System.out.println("**************");
                        }else counter+=1;
                    }
                    if(counter==library.getBooksSell().size()) System.out.println("\nNo hay libros disponibles en existencia.");
                }
                case 3 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    pt = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida");
            }
        }while (pt);
    }
    public void askBook(){
        boolean ab = true,bt = true;
        int x,y,j,r,counter=0,idBook;
        j = 1;
        System.out.println("\t\nSelecciona el libro deseado:");
        for (Books books : library.getBooksList()){
            if(!books.isRented()){//Condición que revisa si el libro tiene status disponible.
                availableBooks.add(books);//Arreglo que guardará temporalmente los libros disponibles
                System.out.printf("\n%d) Nombre: %s\n   Autor: %s\n",j,books.getTitle(),books.getAuthor()); //Se muestran los libros disponibles al usuario.
                j++;
            }else{
                counter+=1;//Se contabilizan los libros que no están disponibles.
            }
        }
        //Si el total es igual al número de libros de la lista Library, se imprime el siguiente mensaje:
        if(counter==library.getBooksList().size()) System.out.println("\nNo hay libros disponibles para solicitar. Intenta más tarde.");
        else{
            do {
                y = 0;
                System.out.print("\nRespuesta: ");
                y = reader.sc.nextInt();
                reader.sc.nextLine();
                y -= 1;
                if (y > availableBooks.size()) System.out.println("Error. Ingresa una opción válida.");//Comparación con el tamaño del nuevo arreglo, ya que tendrá la cantidad de libros disponibles para rentar.
                else bt = false;
            } while (bt);
            System.out.println("\nSolicitando...");
            Books requiredBook = availableBooks.get(y);//Se obtiene el libro solicitado
            idBook = requiredBook.getID();//Se obtiene el ID del libro solicitado
            //Nuevo ciclo que buscará el libro solicitado en la lista library por el usuario mediante comparación del ID.
            for (Books books:library.getBooksList()){
                if(idBook==books.getID()) books.setRented(true);//Cambia el status del libro en la lista Library.
            }
            bt = true;
            x = 1;
            System.out.println("\nSelecciona tu usuario:");
            for(Users user:library.getUsersList()){
                System.out.printf("\n%d) Nombre: %s %s",x,user.getName(),user.getLastName());
                x+=1;
            }
            do{
                System.out.print("\n\nRespuesta: ");
                r = reader.sc.nextInt();
                reader.sc.nextLine();
                r -= 1;
                if(r>library.getUsersList().size()) System.out.println("Error. Selecciona una opción válida.");
                else bt = false;
            }while (bt);
            Users user = library.getUsersList().get(r);
            availableBooks.clear();//Limpieza del arreglo (eliminando todos los elementos) para próximas consultas.
            System.out.println("\nAgregando libro...");
            user.addBookUser(requiredBook);//Se agrega el libro solicitado a la lista atributo del usuario.
            System.out.println("\nLibro agregado!");
        }
    }
    public void retBook(){
        boolean op = true, bt = true;
        int r,x,k,b,idBook,index,i;
        do{
            x = 1;
            System.out.println("\nSelecciona tu usuario:\n");
            for(Users user:library.getUsersList()){
                System.out.printf("\n%d) Nombre: %s %s",x,user.getName(),user.getLastName());
                x++;
            }
            do{
                System.out.print("\nRespuesta: ");
                r = reader.sc.nextInt();
                reader.sc.nextLine();
                r -= 1;
                if(r>library.getUsersList().size()) System.out.println("Error. Selecciona una opción válida.");
                else bt = false;
            }while (bt);
            Users user = library.getUsersList().get(r);
            if(user.getRentedBooks().isEmpty()){
                System.out.println("Error. El usuario seleccionado no tiene ningún libro rentado.");
                op = false;
            }
            else{
                k=1;
                System.out.println("\nSelecciona el libro a devolver:");
                for(Books book:user.getRentedBooks()){
                    System.out.printf("\n%d) Título: %s Autor: %s\n",k,book.getTitle(),book.getAuthor());
                    k++;
                }
                bt = true;
                do{
                    System.out.print("\nRespuesta: ");
                    b = reader.sc.nextInt();
                    reader.sc.nextLine();
                    b -= 1;
                    if(b>user.getRentedBooks().size()) System.out.println("Error. Selecciona una opción válida.");
                    else bt = false;
                }while (bt);
                System.out.println("\nDevolviendo libro...");
                Books bookRet = user.getRentedBooks().get(b);//Se guarda el libro en un nuevo objeto temporal
                idBook = bookRet.getID();//Obtención de su respectivo ID
                for(Books books:library.getBooksList()){
                    if(books.getID()==idBook) {
                        index = library.getBooksList().indexOf(books);
                        Books bookDev = library.getBooksList().get(index);
                        bookDev.setRented(false);
                    }
                }
                user.getRentedBooks().remove(b);
                System.out.println("\nLibro devuelto!\n");
                op = false;
            }
        }while (op);
    }
    public void buyBook(){
        boolean pt = true;
        int o,p,x,y,inventory,counter=0;
        p = 1;
        System.out.println("\t\nSelecciona el libro deseado:");
        for (SaleBooks books : library.getBooksSell()){
            if(books.isAvailable()){
                System.out.printf("\n%d) Nombre: %s\n   Autor: %s\n   Precio: %.2f\n",p,books.getTitle(),books.getAuthor(),books.getPrice());
                p++;
            }else{
                counter+=1;
            }
        }
        if(counter==library.getBooksSell().size()) System.out.println("\nNo hay libros en existencia. Regresa más tarde");
        else{
            do {
                y = 0;
                System.out.print("\nRespuesta: ");
                y = reader.sc.nextInt();
                reader.sc.nextLine();
                y -= 1;
                if (y > library.getBooksSell().size()) System.out.println("Error. Ingresa una opción válida.");
                else pt = false;
            } while (pt);
            System.out.println("\nObteniendo libro...");
            SaleBooks book = library.getBooksSell().get(y);//Guardado del libro comprado
            inventory = book.getInventory();//Variable inventario
            inventory -= 1;//Se resta el inventario
            book.setInventory(inventory);//Actualización del inventario del libro
            if(book.getInventory()==0) book.setAvailable(false);//Quita disponibilidad si se agota el inventario.
            x = 1;
            System.out.println("\nSelecciona tu usuario:");
            for(Users user:library.getUsersList()){
                System.out.printf("\n%d) Nombre: %s %s",x,user.getName(),user.getLastName());
                x+=1;
            }
            pt = true;
            do{
                System.out.print("\nRespuesta: ");
                o = reader.sc.nextInt();
                reader.sc.nextLine();
                o -= 1;
                if(o>library.getUsersList().size()) System.out.println("Error. Selecciona una opción válida.");
                else pt = false;
            }while (pt);
            Users user = library.getUsersList().get(o);
            System.out.println("\nComprando libro...");
            user.addSoldBookUser(book);
            System.out.println("\nLibro comprado y agregado a tu lista!");
            System.out.println("\nGracias por tu preferencia!\n");
        }
    }
}