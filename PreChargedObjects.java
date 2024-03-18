public class PreChargedObjects {

        public static void agregarElementos() {
                Employee employee1 = new Employee("Jafet", "Santoyo");
                Employee employee2 = new Employee("Alejandro", "Montejano");
                Employee employee3 = new Employee("Andrea", "Durán");
                Employee employee4 = new Employee("Atziri", "Mancilla");

                BankAccount account1 = new BankAccount(12345, 'A');
                BankAccount account2 = new BankAccount(45678, 'B');
                BankAccount account3 = new BankAccount(65445, 'A');
                BankAccount account4 = new BankAccount(16985, 'C');
                BankAccount account5 = new BankAccount(23784, 'A');
                BankAccount account6 = new BankAccount(79874, 'B');
                BankAccount account7 = new BankAccount(34977, 'C');
                BankAccount account8 = new BankAccount(32467, 'B');

                employee1.addAccount(account1);
                employee1.addAccount(account2);
                employee2.addAccount(account3);
                employee2.addAccount(account4);
                employee3.addAccount(account5);
                employee3.addAccount(account6);
                employee4.addAccount(account7);
                employee4.addAccount(account8);
                Bank.addAccountsList(account1);
                Bank.addAccountsList(account2);
                Bank.addAccountsList(account3);
                Bank.addAccountsList(account4);
                Bank.addAccountsList(account5);
                Bank.addAccountsList(account6);
                Bank.addAccountsList(account7);
                Bank.addAccountsList(account8);
                Bank.addEmployee(employee1);
                Bank.addEmployee(employee2);
                Bank.addEmployee(employee3);
                Bank.addEmployee(employee4);
        }
}
