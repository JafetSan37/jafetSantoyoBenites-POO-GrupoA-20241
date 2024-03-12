import java.util.ArrayList;

public class Bank {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static ArrayList<BankAccount> accountsList = new ArrayList<>();

    public static ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public static ArrayList<BankAccount> getAccountsList() {
        return accountsList;
    }

    public static void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public static void addAccountsList(BankAccount account){
        accountsList.add(account);
    }
}
