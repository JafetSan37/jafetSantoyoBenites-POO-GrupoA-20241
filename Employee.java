import java.util.ArrayList;

public class Employee {
    private String name;
    private String lastName;
    private ArrayList<BankAccount> accountList = new ArrayList<>();
    //Método Constructor de la clase
    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    //Getters y setters de la clase
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
    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }
    //Métodos para añadir o eliminar cuentas del atributo ArrayList del empleado
    public void addAccount(BankAccount account){
        accountList.add(account);
    }
    public void deleteAccount(BankAccount account){
        accountList.remove(account);
    }
}
