public class Main {
    public static void main(String[] args){
        PreChargedObjects.addElements();
        boolean flag = true;
        int opc;
        System.out.println("\t\nBienvenido!");
        do{//Menú Principal. Se llaman a los otros menús de sus respectivas clases.
            System.out.println("\nSelecciona una opción:\n1) Usuario\n2) Librería\n3) Salir");
            System.out.print("\nOpción: ");
            opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    MenuLibrary.libraryMenu();
                }
                case 2 ->{
                    MenuUser.userMenu();
                }
                case 3 ->{
                    System.out.println("\nHasta luego!\n");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida.");
            }
        }while (flag);
    }
}
