import java.util.Random;

public class AdminMenu {
    static Random number = new Random();
    static boolean op;
    public static void menuAdministrator(){
        boolean flag = true;
        do {
            System.out.println("\tSelecciona una opción:\n1) Crear Usuario\n2) Cuentas\n3) Modificar Usuario\n4) Borrar Usuario\n5) Mostrar Lista de Usuarios y Cuentas\n6) Salir\n");
            System.out.print("\nOpción: ");
            int x = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (x) {
                case 1 -> {
                    createUser();
                }
                case 2 -> {
                    menuAccounts();
                }
                case 3 -> {
                    modifyUser();
                }
                case 4->{
                    deleteUser();
                }
                case 5 -> {
                    showUserAccountsList();
                }
                case 6->{
                    flag = false;
                }
                default -> System.out.println("\nError. Selecciona una opción válida ¬¬ -_-");
            }
        }while(flag);
    }
    public static void createUser(){
        System.out.print("\nIngresa el nombre: ");
        String name = Reader.sc.nextLine();
        System.out.print("\nIngresa el apellido: ");
        String lastName = Reader.sc.nextLine();
        System.out.println("\nCreando número de cuenta...");
        long accountNumber = number.nextLong(100000000,999999999);
        System.out.println("Listo!");
        char type;
        op = true;
        do {
            System.out.println("\tIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado");
            System.out.print("\nTipo: ");
            type = Reader.sc.next().charAt(0);
            if (type != 'A' && type != 'B' && type != 'C') System.out.println("Error. Ingresa un tipo de cuenta válido ¬¬ -_-");
            else op = false;
        } while (op);
        System.out.println("Creando usuario...");
        Employee employee = new Employee(name, lastName);
        System.out.println("Creando cuenta y añadiendo...");
        BankAccount account = new BankAccount(accountNumber, type);
        Bank.addAccountsList(account);
        employee.addAccount(account);
        Bank.addEmployee(employee);
        System.out.println("Usuario creado con éxito!");
    }
    public static void menuAccounts(){
        boolean flag = true;
        do {
            System.out.println("\tSelecciona una opción:\n1) Agregar cuenta\n2) Modificar tipo de cuenta\n3) Eliminar cuenta\n4) Salir");
            System.out.print("\nOpción: ");
            int opc = Reader.sc.nextInt();
            Reader.sc.nextLine();
            switch (opc){
                case 1 ->{
                    long accountNumber = number.nextLong(100000000,999999999);
                    boolean op = true;
                    char type;
                    op = true;
                    do {
                        System.out.println("\nIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado");
                        System.out.print("\nTipo: ");
                        type = Reader.sc.next().charAt(0);
                        if (type == 'A' || type == 'B' || type == 'C') op = false;
                        else System.out.println("Error. Ingresa un tipo de cuenta válido ¬¬ -_-");
                    } while (op);
                    BankAccount account = new BankAccount(accountNumber,type);
                    int x;
                    System.out.println("\tAsigne la cuenta al usuario:\n ");
                    int i = 0;
                    for (Employee employee : Bank.getEmployeeList()) {
                        System.out.printf("%d) Nombre: %s %s\n", i + 1, employee.getName(), employee.getLastName());
                        i++;
                    }
                    op = true;
                    int y;
                    do {
                        System.out.print("\nRespuesta: ");
                        y = Reader.sc.nextInt() - 1;
                        if (y <= Bank.getEmployeeList().size()) op = false;
                        else System.out.println("Error. Ingresa una opción válida ¬¬ -_-");
                    } while (op);
                    Employee employee = Bank.getEmployeeList().get(y);
                    employee.addAccount(account);
                }
                case 4->{
                    flag = false;
                }
            }
        }while(flag);
    }
    public static void modifyUser(){
        System.out.println("\tSelecciona el usuario:\n ");
        int i = 0;
        for (Employee employee : Bank.getEmployeeList()) {
            System.out.printf("%d) Nombre: %s %s\n", i + 1, employee.getName(), employee.getLastName());
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
        System.out.print("\nIngresa el nombre: ");
        String modName = Reader.sc.nextLine();
        System.out.println("\nModificando...");
        Employee employee = Bank.getEmployeeList().get(y);
        employee.setName(modName);
        System.out.print("\nIngresa el apellido: ");
        String modLastName = Reader.sc.nextLine();
        System.out.println("\nModificando...");
        employee.setLastName(modLastName);
        System.out.println("\nUsuario modificado");
    }
    public static void deleteUser(){
        System.out.println("\tSelecciona el usuario a eliminar:\n");
        int i = 0;
        for (Employee employee : Bank.getEmployeeList()){
            System.out.printf("%d) Nombre: %s %s\n", i+1, employee.getName(), employee.getLastName());
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
        System.out.printf("\nSeguro/a que deseas eliminar a %s %s?\n1) Sí\n2) No", employee.getName(), employee.getLastName());
        op = true;
        do {
            System.out.print("Respuesta: ");
            int res = Reader.sc.nextInt();
            if (res != 1 && res != 2) System.out.println("Error. Selecciona una opción válida ¬¬ -_-");
            else if (res == 1){
                System.out.println("Eliminando...");
                Bank.getEmployeeList().remove(employee);
                System.out.println("Usuario eliminado");
                op = false;
            }else if(res == 2){
                System.out.println("Cancelando...");
                op = false;
            }
        } while (op);
    }
    public static void showUserAccountsList(){
        System.out.println("\nLista de Usuarios en Sistema:");
        for (Employee employee:Bank.getEmployeeList()){
            System.out.printf("\nNombre: %s Apellido: %s \n",employee.getName(), employee.getLastName());
            Employee employee1 = employee;
            for(BankAccount account:employee1.getAccountList()){
                System.out.printf("\nCuenta: %s Tipo: %s\n",account.getAccountNumber(),account.getType());
            }
        }
    }
}
