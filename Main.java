public class Main {
    public static void main(String[] args){
        //Objetos previamente creados en la clase Seeder para prueba del programa.
        Seeder.agregarElementos();
        //En main solamente se llaman a los métodos de las clases correspondientes.
        System.out.println("\t\nHola! Bienvenido/a!");
        boolean flag = true;
        //Ciclo para evitar el ingreso de datos erróneos al seleccionar opción.
        do {
            System.out.println("\t\nSelecciona la opción deseada:\n1) Usuario\n2) Administrador\n3) Salir");
            System.out.print("\nOpción: ");
            int x = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (x){
                case 1->{
                    System.out.println("\nBienvenido/a!");
                    UserMenu.menuUser();
                }
                case 2->{
                    System.out.println("\t\nBienvenido, Administrador");
                    AdminMenu.menuAdministrator();
                }
                case 3->{
                    System.out.println("\nHasta luego!");
                    flag = false;
                }
                default -> System.out.println("\nError. Selecciona una opción válida ¬¬ -_-");
            }
        }while(flag);
    }
}
