public class UserMenu {
    static boolean op;
    //Método principal para el menú de Usuario
    public static void menuUser(){
        boolean flag = true;
        do {
            System.out.println("\nSelecciona la opción deseada:\n1) Agregar dinero\n2) Retirar dinero\n3) Consultar Saldo\n4) Salir");
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
                case 3 ->{
                    consultAmount();
                }
                case 4->{
                    System.out.println("\nRegresando al menú anterior...");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida ¬¬ -_-");
            }
        }while(flag);
    }
    //Menú para agregar dinero
    public static void addMoney(){
        boolean flag = true;
        do {
            System.out.println("\n1) Agregar\n2) Salir");//Esta función permite al usuario regresar al menú anterior si se arrepiente de su elección.
            System.out.print("\nOpción: ");
            int opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    System.out.println("\t\nSelecciona tu usuario:\n");
                    int i = 0;
                    for (Employee employee : Bank.getEmployeeList()){
                        System.out.printf("%d) Usuario: %s %s\n", i + 1, employee.getName(), employee.getLastName());
                        i++;
                    }
                    op = true;
                    int y;
                    do {
                        System.out.print("\nRespuesta: ");
                        y = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        y -= 1;
                        if (y > Bank.getEmployeeList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    } while (op);
                    Employee employee = Bank.getEmployeeList().get(y);
                    System.out.println("\nSelecciona la cuenta:\n");
                    int x = 0;
                    for(BankAccount account:employee.getAccountList()){
                        System.out.printf("%d) Cuenta: %s Tipo: %s\n",x+1,account.getAccountNumber(),account.getType());
                        x++;
                    }
                    op = true;
                    int z;
                    do{
                        System.out.print("\nRespuesta: ");
                        z = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        z -= 1;
                        if(z > employee.getAccountList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    }while(op);
                    BankAccount account = employee.getAccountList().get(z);
                    System.out.print("\nIngresa el monto: ");
                    double amount = Reader.sc.nextDouble();
                    Reader.sc.nextLine();
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
            System.out.println("\n1) Retirar\n2) Salir");
            System.out.print("\nOpción: ");
            int opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    System.out.println("\t\nSelecciona tu usuario:\n");
                    int i = 0;
                    for (Employee employee : Bank.getEmployeeList()){
                        System.out.printf("%d) Usuario: %s %s\n", i + 1, employee.getName(), employee.getLastName());
                        i++;
                    }
                    op = true;
                    int y;
                    do {
                        System.out.print("\nRespuesta: ");
                        y = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        y -= 1;
                        if (y > Bank.getEmployeeList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    } while (op);
                    Employee employee = Bank.getEmployeeList().get(y);
                    System.out.println("\nSelecciona la cuenta:\n");
                    int x = 0;
                    for(BankAccount account:employee.getAccountList()){
                        System.out.printf("%d) Cuenta: %s Tipo: %s Saldo: $ %.2f\n",x+1,account.getAccountNumber(),account.getType(),account.getAmount());
                        x++;
                    }
                    op = true;
                    int z;
                    do{
                        System.out.print("\nRespuesta: ");
                        z = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        z -= 1;
                        if(z > employee.getAccountList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    }while(op);
                    BankAccount account = employee.getAccountList().get(z);
                    System.out.print("\nIngresa el monto: ");
                    double amount = Reader.sc.nextDouble();
                    Reader.sc.nextLine();
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
    //Menú para consultar saldo
    public static void consultAmount(){
        boolean flag = true;
        do {
            System.out.println("\n1) Consultar\n2) Salir");
            System.out.print("\nOpción: ");
            int opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    System.out.println("\t\nSelecciona tu usuario:\n");
                    int i = 0;
                    for (Employee employee : Bank.getEmployeeList()){
                        System.out.printf("%d) Usuario: %s %s\n", i + 1, employee.getName(), employee.getLastName());
                        i++;
                    }
                    op = true;
                    int y;
                    do {
                        System.out.print("\nRespuesta: ");
                        y = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        y -= 1;
                        if (y > Bank.getEmployeeList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    } while (op);
                    Employee employee = Bank.getEmployeeList().get(y);
                    System.out.println("\nSelecciona la cuenta a consultar:\n");
                    int x = 0;
                    for(BankAccount account:employee.getAccountList()){
                        System.out.printf("%d) Cuenta: %s Tipo: %s\n",x+1,account.getAccountNumber(),account.getType());
                        x++;
                    }
                    op = true;
                    int z;
                    do{
                        System.out.print("\nRespuesta: ");
                        z = Reader.sc.nextInt();
                        Reader.sc.nextLine();
                        z -= 1;
                        if(z > employee.getAccountList().size()) System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                        else op = false;
                    }while(op);
                    BankAccount account = employee.getAccountList().get(z);
                    System.out.printf("\nSaldo: $ %.2f\n", account.getAmount());
                }
                case 2 ->{
                    System.out.println("\nRegresando al menú principal...");
                    flag = false;
                }
                default -> System.out.println("Error. Selecciona una opción válida ¬¬ -_-");
            }
        }while(flag);
    }
}