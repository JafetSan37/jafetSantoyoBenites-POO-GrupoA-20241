import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastName;
    private ArrayList<BankAccount> accountList = new ArrayList<>();

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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

    public void addAccount(BankAccount account){
        accountList.add(account);
    }

    public void deleteAccount(BankAccount account){
        accountList.remove(account);
    }

    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }
}
