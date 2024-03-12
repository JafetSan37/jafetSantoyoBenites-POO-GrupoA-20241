import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastName;
    private ArrayList<BankAccount> accountList = new ArrayList<>();

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    public void setAccountList(ArrayList<BankAccount> accountList) {
        this.accountList = accountList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void getAccountList(Employee employee) {

    }
    public void addAccount(BankAccount Account){
        accountList.add(Account);
    }

    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }
}
