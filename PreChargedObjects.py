from Employee import Employee
from BankAccount import BankAccount
from Bank import Bank

class PreChargedObjects:
    @staticmethod
    def agregar_elementos():
        employee1 = Employee("Jafet", "Santoyo")
        employee2 = Employee("Alejandro", "Montejano")
        employee3 = Employee("Andrea", "Durán")
        employee4 = Employee("Atziri", "Mancilla")

        account1 = BankAccount(12345, 'A')
        account2 = BankAccount(45678, 'B')
        account3 = BankAccount(65445, 'A')
        account4 = BankAccount(16985, 'C')
        account5 = BankAccount(23784, 'A')
        account6 = BankAccount(79874, 'B')
        account7 = BankAccount(34977, 'C')
        account8 = BankAccount(32467, 'B')

        employee1.add_account(account1)
        employee1.add_account(account2)
        employee2.add_account(account3)
        employee2.add_account(account4)
        employee3.add_account(account5)
        employee3.add_account(account6)
        employee4.add_account(account7)
        employee4.add_account(account8)
        
        Bank.add_accounts_list(account1)
        Bank.add_accounts_list(account2)
        Bank.add_accounts_list(account3)
        Bank.add_accounts_list(account4)
        Bank.add_accounts_list(account5)
        Bank.add_accounts_list(account6)
        Bank.add_accounts_list(account7)
        Bank.add_accounts_list(account8)
        
        Bank.add_employee(employee1)
        Bank.add_employee(employee2)
        Bank.add_employee(employee3)
        Bank.add_employee(employee4)
