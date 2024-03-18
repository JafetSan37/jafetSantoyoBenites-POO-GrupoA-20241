from Bank import Bank
from BankAccount import BankAccount
from Employee import Employee
import random

class AdminMenu:
    number = random.Random()

    @staticmethod
    def menu_administrator():
        flag = True
        while flag:
            print("\t\nSelecciona una opción:\n1) Crear Usuario\n2) Cuentas\n3) Modificar Usuario\n4) Eliminar Usuario\n5) Mostrar Lista de Usuarios y Cuentas\n6) Salir")
            x = int(input("\nOpción: "))
            if x == 1:
                AdminMenu.create_user()
            elif x == 2:
                AdminMenu.menu_accounts()
            elif x == 3:
                AdminMenu.modify_user()
            elif x == 4:
                AdminMenu.delete_user()
            elif x == 5:
                AdminMenu.show_user_accounts_list()
            elif x == 6:
                flag = False
            else:
                print("\nError. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def create_user():
        flag = True
        while flag:
            print("\n1) Crear\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                name = input("\nIngresa el nombre: ")
                last_name = input("\nIngresa el apellido: ")
                print("\nCreando número de cuenta...")
                account_number = AdminMenu.number.randint(100000000, 999999999)
                print("Listo!")
                op = True
                while op:
                    print("\tIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado")
                    type = input("\nTipo: ").upper()
                    if type in ['A', 'B', 'C']:
                        op = False
                    else:
                        print("Error. Ingresa un tipo de cuenta válido ¬¬ -_-")
                print("Creando usuario...")
                employee = Employee(name, last_name)
                print("Creando cuenta y añadiendo...")
                account = BankAccount(account_number, type)
                Bank.add_accounts_list(account)
                employee.add_account(account)
                Bank.add_employee(employee)
                print("Usuario creado con éxito!")
            elif opc == 2:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def menu_accounts():
        flag = True
        while flag:
            print("\t\nSelecciona una opción:\n1) Agregar cuenta\n2) Modificar tipo de cuenta\n3) Eliminar cuenta\n4) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                account_number = AdminMenu.number.randint(100000000, 999999999)
                op = True
                while op:
                    print("\nIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado")
                    type = input("\nTipo: ").upper()
                    if type in ['A', 'B', 'C']:
                        op = False
                    else:
                        print("Error. Ingresa un tipo de cuenta válido ¬¬ -_-")
                account = BankAccount(account_number, type)
                print("\t\nAsigne la cuenta al usuario:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Nombre: {employee.name} {employee.last_name}")
                    i += 1
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y <= len(Bank.get_employee_list()):
                        op = False
                    else:
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                employee = Bank.get_employee_list()[y]
                employee.add_account(account)
                print("\nCuenta agregada. Regresando al menú...")
            elif opc == 2:
                print("\t\nSelecciona el usuario:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Usuario: {employee.name} {employee.last_name}")
                    i += 1
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(Bank.get_employee_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                employee = Bank.get_employee_list()[y]
                print("\nSelecciona la cuenta:\n")
                x = 0
                for account in employee.account_list:
                    print(f"{x + 1}) Cuenta: {account.account_number} Tipo: {account.type}")
                    x += 1
                op = True
                while op:
                    z = int(input("\nRespuesta: ")) - 1
                    if z > len(employee.account_list):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                account = employee.account_list[z]
                op = True
                while op:
                    print("\tIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado")
                    type = input("\nTipo: ").upper()
                    if type in ['A', 'B', 'C']:
                        op = False
                    else:
                        print("Error. Ingresa un tipo de cuenta válido ¬¬ -_-")
                account.type = type
                print("\nTipo de cuenta actualizada. Regresando al menú...")
            elif opc == 3:
                print("\t\nSelecciona el usuario:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Usuario: {employee.name} {employee.last_name}")
                    i += 1
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(Bank.get_employee_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                employee = Bank.get_employee_list()[y]
                print("\nSelecciona la cuenta:\n")
                x = 0
                for account in employee.account_list:
                    print(f"{x + 1}) Cuenta: {account.account_number} Tipo: {account.type}")
                    x += 1
                op = True
                while op:
                    z = int(input("\nRespuesta: ")) - 1
                    if z > len(employee.account_list):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                account = employee.account_list[z]
                print("\nSeguro/a que deseas eliminar la cuenta?\n1) Sí\n2) No")
                op = True
                while op:
                    res = int(input("\nRespuesta: "))
                    if res != 1 and res != 2:
                        print("Error. Selecciona una opción válida ¬¬ -_-")
                    elif res == 1:
                        print("Eliminando...")
                        employee.delete_account(account)
                        print("Cuenta eliminada")
                        op = False
                    elif res == 2:
                        print("Cancelando...")
                        op = False
            elif opc == 4:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def modify_user():
        flag = True
        while flag:
            print("\n1) Modificar\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                print("\t\nSelecciona el usuario:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Nombre: {employee.name} {employee.last_name}")
                    i += 1
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(Bank.get_employee_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                mod_name = input("\nIngresa el nombre: ")
                print("\nModificando...")
                employee = Bank.get_employee_list()[y]
                employee.name = mod_name
                mod_last_name = input("\nIngresa el apellido: ")
                print("\nModificando...")
                employee.last_name = mod_last_name
                print("\nUsuario modificado")
            elif opc == 2:
                print("\n Regresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def delete_user():
        flag = True
        while flag:
            print("\n1) Eliminar\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                print("\t\nSelecciona el usuario a eliminar:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Nombre: {employee.name} {employee.last_name}")
                    i += 1
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(Bank.get_employee_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                employee = Bank.get_employee_list()[y]
                print(f"\nSeguro/a que deseas eliminar a {employee.name} {employee.last_name}?\n1) Sí\n2) No")
                op = True
                while op:
                    res = int(input("\nRespuesta: "))
                    if res != 1 and res != 2:
                        print("Error. Selecciona una opción válida ¬¬ -_-")
                    elif res == 1:
                        print("Eliminando...")
                        Bank.get_employee_list().remove(employee)
                        print("Usuario eliminado")
                        op = False
                    elif res == 2:
                        print("Cancelando...")
                        op = False
            elif opc == 2:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def show_user_accounts_list():
        print("\nLista de Usuarios en Sistema:")
        for employee in Bank.get_employee_list():
            print(f"\nNombre: {employee.name}  Apellido: {employee.last_name}")
            for account in employee.account_list:
                print(f"Cuenta: {account.account_number} Tipo: {account.type}")
