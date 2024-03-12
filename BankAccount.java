public class BankAccount {
    private long accountNumber;
    private double amount;
    private char type;
    //Método Constructor de la clase, para dos de sus atributos.
    public BankAccount(long accountNumber, char type) {
        this.accountNumber = accountNumber;
        this.type = type;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }


    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        if (type=='A') setAmountA(amount);
        else if (type=='B') setAmountB(amount);
        else this.amount += amount;
    }

    public void setAmountA(double amount){
        if (this.amount + amount <= 50000) this.amount += amount;
        else System.out.println("No puede tener más de 50,000. Su cuenta es tipo A");
    }

    public void setAmountB(double amount){
        if (this.amount + amount <= 100000) this.amount += amount;
        else System.out.println("No puede tener más de 100,000. Su cuenta es tipo B");
    }

    public void drawMoney(double amount){
        if (type=='A') drawMoneyA(amount);
        else if (type=='B') drawMoneyB(amount);
        else if (type=='C') drawMoneyC(amount);
    }
    public void drawMoneyA(double amount){
        if (this.amount >= 1000 && this.amount - amount >= 1000) this.amount -= amount;
        else System.out.println("Error. Saldo insuficiente o límite alcanzado en la cuenta");
    }

    public void drawMoneyB(double amount){
        if (this.amount >= 5000 && this.amount - amount >= 5000) this.amount -= amount;
        else System.out.println("Error. Saldo insuficiente o límite alcanzado en la cuenta");
    }

    public void drawMoneyC(double amount){
        if (this.amount >= 10000 && this.amount - amount >= 10000) this.amount -= amount;
        else System.out.println("Error. Saldo insuficiente o límite alcanzado en la cuenta");
    }
}
