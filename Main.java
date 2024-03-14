public class Main {
    public static void main(String[] args){
        Reader reader = new Reader();
        MenuUser menuUser = new MenuUser();
        MenuLibrary menuLibrary = new MenuLibrary();
        boolean flag = true;
        int opc;
        System.out.println("\t\nBienvenido!");
        do{//Menú Principal. Se llaman a los otros menús de sus respectivas clases.
            System.out.println("\nSelecciona una opción:\n1) Usuario\n2) Librería\n3) Salir");
            System.out.print("\nOpción: ");
            opc = reader.sc.nextInt();
            reader.sc.nextLine();
            switch (opc){
                case 1 -> menuUser.userMenu();
                case 2 -> menuLibrary.libraryMenu();
                case 3 ->{
                    System.out.println("\nHasta luego!\n");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while (flag);
    }
}
