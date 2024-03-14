public class MenuUser {
    public static void userMenu(){//Método menú para la sección Usuario.
        boolean flag = true;
        int x;
        do{
            System.out.println("\nSelecciona la opción deseada:\n1) Consultar libros\n2) Solicitar un libro\n3) Devolver un libro\n4) Comprar libro\n5) Salir");
            System.out.print("\nOpción: ");
            x = Reader.sc.nextInt();
            Reader.sc.nextLine();
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
    public static void consultBook(){
        boolean pt = true;
        int a,b;
        do{
            System.out.println("\nSelecciona una opción:\n1) Libros en renta\n2) Libros en venta\n3) Salir");
            a = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (a){
                case 1 ->{
                    b=0;//Ciclo que cuenta los libros disponibles.
                    for(Books books:Library.getBooksList()){
                        if(books.isRented()) b+=1;
                    }
                    for(Books book:Library.getBooksList()){
                        if(!book.isRented()){
                            System.out.printf("\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\n",book.getTitle(),book.getAuthor(),book.getYear());
                            System.out.println("**************");
                        }else if(b==0) System.out.println("\nNo hay libros disponibles.");
                    }
                }
                case 2 ->{
                    b = 0;//Ciclo para contar libros.
                    for(SaleBooks books:Library.getBooksSell()){
                        if(books.isAvailable()) b+=1;
                    }
                    for(SaleBooks book:Library.getBooksSell()){
                        if(book.isAvailable()){
                            System.out.printf("\nTítulo: %s\nAutor: %s\nAño de Publicación: %d\nPrecio: %.2f",book.getTitle(),book.getAuthor(),book.getYear(),book.getPrice());
                            System.out.println("**************");
                        }else if(b==0) System.out.println("\nNo hay libros disponibles.");
                    }
                }
                case 3 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    pt = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida");
            }
        }while (pt);
    }
    public static void askBook(){
        boolean ab = true, bt = true;
        int x,y,j,r;
        do{
            j = 1;
            System.out.println("\t\nSelecciona el libro deseado:\n");
            for (Books books : Library.getBooksList()){
                System.out.printf("\n%d) Nombre: %s\n   Autor: %s",j,books.getTitle(),books.getAuthor());
                j++;
            }
            do {
                y = 0;
                System.out.print("\nRespuesta: ");
                y = Reader.sc.nextInt();
                Reader.sc.nextLine();
                y -= 1;
                if (y > Library.getBooksList().size()) System.out.println("Error. Ingresa una opción válida.");
                else bt = false;
            } while (bt);
            Books book = Library.getBooksList().get(y);
            if(book.isRented()) System.out.println("Error. El libro seleccionado no está disponible por el momento.");
            else{
                bt = true;
                x = 1;
                System.out.println("\nSelecciona tu usuario:\n");
                for(Users user:Library.getUsersList()){
                    System.out.printf("\n%d) Nombre: %s %s",x,user.getName(),user.getLastName());
                    x+=1;
                }
                do{
                    System.out.print("\nRespuesta: ");
                    r = Reader.sc.nextInt();
                    Reader.sc.nextLine();
                    r -= 1;
                    if(r>Library.getUsersList().size()) System.out.println("Error. Selecciona una opción válida.");
                    else bt = false;
                }while (bt);
                Users user = Library.getUsersList().get(r);
                System.out.println("\nAgregando libro...");
                user.addBookUser(book);
                Books book1 = Library.getBooksList().get(r);
                book1.setRented(true);
                System.out.println("\nLibro agregado!");
                ab = false;
            }
        }while (ab);
    }
    public static void retBook(){
        boolean op = true, bt = true;
        int r,x,k,b;
        do{
            x = 1;
            System.out.println("\nSelecciona tu usuario:\n");
            for(Users user:Library.getUsersList()){
                System.out.printf("\n%d) Nombre: %s %s",x,user.getName(),user.getLastName());
                x++;
            }
            do{
                System.out.print("\nRespuesta: ");
                r = Reader.sc.nextInt();
                Reader.sc.nextLine();
                r -= 1;
                if(r>Library.getUsersList().size()) System.out.println("Error. Selecciona una opción válida.");
                else bt = false;
            }while (bt);
            Users user = Library.getUsersList().get(r);
            if(user.getRentedBooks().isEmpty()) System.out.println("Error. El usuario seleccionado no tiene ningún libro rentado.");
            else{
                k=1;
                System.out.println("\nSelecciona el libro a devolver:\n");
                for(Books book:user.getRentedBooks()){
                    System.out.printf("\n%d) Título: %s Autor: %s",k,book.getTitle(),book.getAuthor());
                    k++;
                }
                bt = true;
                do{
                    System.out.print("\nRespuesta: ");
                    b = Reader.sc.nextInt();
                    Reader.sc.nextLine();
                    b -= 1;
                    if(b>user.getRentedBooks().size()) System.out.println("Error. Selecciona una opción válida.");
                    else bt = false;
                }while (bt);
                System.out.println("\nDevolviendo libro...");
                user.getRentedBooks().remove(b);
                Books book = Library.getBooksList().get(b);
                book.setRented(false);
                System.out.println("\nLibro devuelto!\n");
                op = false;
            }
        }while (op);
    }
    public static void buyBook(){
        boolean pt = true;
        int o,p,x,y,inventory;
        p = 1;
        System.out.println("\t\nSelecciona el libro deseado:\n");
        for (SaleBooks books : Library.getBooksSell()){
            if(books.getInventory()>0){
                System.out.printf("\n%d) Nombre: %s\n   Autor: %s\n   Precio: %.2f",p,books.getTitle(),books.getAuthor(),books.getPrice());
                p++;
            }
        }
        do {
            y = 0;
            System.out.print("\nRespuesta: ");
            y = Reader.sc.nextInt();
            Reader.sc.nextLine();
            y -= 1;
            if (y > Library.getBooksList().size()) System.out.println("Error. Ingresa una opción válida.");
            else pt = false;
        } while (pt);
        System.out.println("\nObteniendo libro...");
        SaleBooks book = Library.getBooksSell().get(y);
        inventory = book.getInventory();
        inventory -= 1;
        book.setInventory(inventory);
        if(book.getInventory()==0) book.setAvailable(false);//Quita disponibilidad si se agota el inventario.
        x = 1;
        System.out.println("\nSelecciona tu usuario:\n");
        for(Users user:Library.getUsersList()){
            System.out.printf("\n%d) Nombre: %s %s",x,user.getName(),user.getLastName());
            x+=1;
        }
        pt = true;
        do{
            System.out.print("\nRespuesta: ");
            o = Reader.sc.nextInt();
            Reader.sc.nextLine();
            o -= 1;
            if(o>Library.getUsersList().size()) System.out.println("Error. Selecciona una opción válida.");
            else pt = false;
        }while (pt);
        Users user = Library.getUsersList().get(o);
        System.out.println("\nComprando libro...");
        user.addSoldBookUser(book);
        System.out.println("\nLibro comprado y agregado a tu lista!");
        System.out.println("\nGracias por tu preferencia!\n");
    }
}