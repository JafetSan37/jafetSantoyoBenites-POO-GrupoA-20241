public class UserMenu {
    static boolean op;
    public static void menuUser(){
        boolean flag = true;
        do {
            System.out.println("\nSelecciona la opción deseada:\n1) Agregar dinero\n2) Retirar dinero\n3) Salir");
            System.out.print("\nOpción: ");
            int x = Reader.sc.nextInt();
            switch (x){
                case 1->{
                    addMoney();
                }
                case 2->{
                    drawMoney();
                }
                case 3->{
                    flag = false;
                }
            }
        }while(flag);

    }
    //Menú para agregar dinero
    public static void addMoney(){
        System.out.println("\tSelecciona tu usuario:\n");
        int i = 0;
        for (Employee employee : Bank.getEmployeeList()){
            System.out.printf("%d) Usuario: %s %s\n", i + 1, employee.getName(), employee.getLastName());
            i++;
        }
        op = true;
        int y;
        do {
            System.out.print("\nRespuesta: ");
            y = Reader.sc.nextInt() - 1;
            if (y > Bank.getEmployeeList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
            else op = false;
        } while (op);
        Employee employee = Bank.getEmployeeList().get(y);

        System.out.println("\nSelecciona la cuenta:\n");
        int z;

    }
    //Menú para retirar dinero
    public static void drawMoney(){

    }
}
