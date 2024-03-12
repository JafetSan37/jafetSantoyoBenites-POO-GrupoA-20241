public class UserMenu {
    static boolean op;
    public static void menuUser(){
        boolean flag = true;
        do {
            System.out.println("\nSelecciona la opción deseada:\n1) Agregar dinero\n2) Retirar dinero\n3) Consultar Saldo 4) Salir");
            System.out.print("\nOpción: ");
            int x = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (x){
                case 1->{
                    addMoney();
                }
                case 2->{
                    drawMoney();
                }
                case 3 ->{}
                case 4->{
                    System.out.println("\nRegresando al menú anterior...");
                    flag = false;
                }
            }
        }while(flag);

    }
    //Menú para agregar dinero
    public static void addMoney(){
        boolean flag = true;
        do {
            System.out.println("\n1) Agregar\n2) Salir");
            System.out.print("Opción: ");
            int opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    System.out.println("\tSelecciona tu usuario:\n");
                    int i = 0;
                    for (Employee employee : Bank.getEmployeeList()){
                        System.out.printf("\n%d) Usuario: %s %s\n", i + 1, employee.getName(), employee.getLastName());
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
                    int x = 0;
                    for(BankAccount account:employee.getAccountList()){
                        System.out.printf("\n%d) Cuenta: %s Tipo: %s\n",x+1,account.getAccountNumber(),account.getType());
                        x++;
                    }
                    op = true;
                    int z;
                    do{
                        System.out.print("\nRespuesta: ");
                        z = Reader.sc.nextInt() - 1;
                        if(z > employee.getAccountList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    }while(op);
                    BankAccount account = employee.getAccountList().get(z);
                    System.out.print("Ingresa el monto: ");
                    double amount = Reader.sc.nextDouble();
                    account.setAmount(amount);
                    System.out.println("\nMonto actualizado/sin cambios. Regresando al menú...");
                }
                case 2 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida ¬¬ -_-");
            }
        }while(flag);
    }
    //Menú para retirar dinero
    public static void drawMoney(){
        boolean flag = true;
        do {
            System.out.println("\n1) Agregar\n2) Salir");
            System.out.print("Opción: ");
            int opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
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
                    int x = 0;
                    for(BankAccount account:employee.getAccountList()){
                        System.out.printf("\n%d) Cuenta: %s Tipo: %s Saldo: $%f\n",x+1,account.getAccountNumber(),account.getType(),account.getAmount());
                        x++;
                    }
                    op = true;
                    int z;
                    do{
                        System.out.print("\nRespuesta: ");
                        z = Reader.sc.nextInt() - 1;
                        if(z > employee.getAccountList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    }while(op);
                    BankAccount account = employee.getAccountList().get(z);
                    System.out.print("Ingresa el monto: ");
                    double amount = Reader.sc.nextDouble();
                    account.drawMoney(amount);
                    System.out.println("\nMonto actualizado/sin cambios. Regresando al menú...");
                }
                case 2 ->{
                    System.out.println("\nRegresando al menú anterior...");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida ¬¬ -_-");
            }
        }while (flag);
    }
    public static void consultAmount(){
        
    }
}