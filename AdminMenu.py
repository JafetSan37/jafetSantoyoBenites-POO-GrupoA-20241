from Bank import Bank
from Employee import Employee
from BankAccount import BankAccount
import random

class AdminMenu:
    number = random.Random()

    @staticmethod
    def menuAdministrator():
        flag = True
        while flag:
            print("\t\nSelecciona una opción:\n1) Crear Usuario\n2) Cuentas\n3) Modificar Usuario\n4) Eliminar Usuario\n5) Mostrar Lista de Usuarios y Cuentas\n6) Salir")
            opcion = int(input("\nOpción: "))
            if opcion == 1:
                AdminMenu.createUser()
            elif opcion == 2:
                AdminMenu.menuAccounts()
            elif opcion == 3:
                AdminMenu.modifyUser()
            elif opcion == 4:
                AdminMenu.deleteUser()
            elif opcion == 5:
                AdminMenu.showUserAccountsList()
            elif opcion == 6:
                flag = False
            else:
                print("\nError. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def createUser():
        flag = True
        while flag:
            print("\n1) Crear\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                name = input("\nIngresa el nombre: ")
                lastName = input("\nIngresa el apellido: ")
                print("\nCreando número de cuenta...")
                accountNumber = AdminMenu.number.randint(100000000, 999999999)
                print("Listo!")
                #type = ''
                op = True
                while op:
                    print("\tIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado")
                    type = input("\nTipo: ").upper()
                    if type in ['A', 'B', 'C']:
                        op = False
                    else:
                        print("Error. Ingresa un tipo de cuenta válido ¬¬ -_-")
                print("Creando usuario...")
                employee = Employee(name, lastName)
                print("Creando cuenta y añadiendo...")
                account = BankAccount(accountNumber, type)
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
    def menuAccounts():
        flag = True
        while flag:
            print("\t\nSelecciona una opción:\n1) Agregar cuenta\n2) Modificar tipo de cuenta\n3) Eliminar cuenta\n4) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                accountNumber = AdminMenu.number.randint(100000000, 999999999)
                type = ''
                op = True
                while op:
                    print("\nIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado")
                    type = input("\nTipo: ").upper()
                    if type in ['A', 'B', 'C']:
                        op = False
                    else:
                        print("Error. Ingresa un tipo de cuenta válido ¬¬ -_-")
                account = BankAccount(accountNumber, type)
                print("\t\nAsigne la cuenta al usuario:\n")
                i = 0
                for employee in Bank.getEmployeeList():
                    print(f"{i + 1}) Nombre: {employee.get_name()} {employee.get_last_name()}")
                    i += 1
                """for i, employee in enumerate(Bank.get_employee_list(), 1):
                    print(f"{i}) Nombre: {employee.get_name()} {employee.get_last_name()}")"""
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if 0 <= y < len(Bank.get_employee_list()):
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
                    print(f"{i + 1}) Usuario: {employee.get_name()} {employee.get_last_name()}")
                    i += 1
                """for i, employee in enumerate(Bank.get_employee_list(), 1):
                    print(f"{i}) Usuario: {employee.get_name()} {employee.get_last_name()}")"""
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if 0 <= y < len(Bank.get_employee_list()):
                        op = False
                    else:
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                employee = Bank.get_employee_list()[y]
                print("\nSelecciona la cuenta:\n")
                x = 0
                for account in employee.get_account_list():
                    print(f"{x + 1}) Cuenta: {account.get_account_number()} Tipo: {account.get_type()}")
                    x += 1
                """for x, account in enumerate(employee.get_account_list(), 1):
                    print(f"{x}) Cuenta: {account.get_account_number()} Tipo: {account.get_type()}")"""
                op = True
                while op:
                    z = int(input("\nRespuesta: ")) - 1
                    if z > len(employee.get_account_list()):
                        op = False
                    else:
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                account = employee.get_account_list()[z]
                op = True
                while op:
                    print("\tIngresa el tipo de cuenta:\nA) Cuenta tipo A: Monto máximo permitido $50,000\nB) Cuenta tipo B: Monto máximo permitido $100,000\nC) Cuenta tipo C: Saldo Ilimitado")
                    type = input("\nTipo: ").upper()
                    if type in ['A', 'B', 'C']:
                        op = False
                    else:
                        print("Error. Ingresa un tipo de cuenta válido ¬¬ -_-")
                account.set_type(type)
                print("\nTipo de cuenta actualizada. Regresando al menú...")
            elif opc == 3:
                print("\t\nSelecciona el usuario:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Usuario: {employee.get_name()} {employee.get_last_name()}")
                    i += 1
                """for i, employee in enumerate(Bank.get_employee_list(), 1):
                    print(f"{i}) Usuario: {employee.get_name()} {employee.get_last_name()}")"""
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y < len(Bank.get_employee_list()):
                        op = False
                    else:
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                employee = Bank.get_employee_list()[y]
                print("\nSelecciona la cuenta:\n")
                x = 0
                for account in employee.get_account_list():
                    print(f"{x + 1}) Cuenta: {account.get_account_number()} Tipo: {account.get_type()}")
                    x += 1
                """for x, account in enumerate(employee.get_account_list(), 1):
                    print(f"{x}) Cuenta: {account.get_account_number()} Tipo: {account.get_type()}")"""
                op = True
                while op:
                    z = int(input("\nRespuesta: ")) - 1
                    if z < len(employee.get_account_list()):
                        op = False
                    else:
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                account = employee.get_account_list()[z]
                print("\nSeguro/a que deseas eliminar la cuenta?\n1) Sí\n2) No")
                op = True
                while op:
                    res = int(input("\nRespuesta: "))
                    if res in [1, 2]:
                        if res == 1:
                            print("Eliminando...")
                            employee.delete_account(account)
                            print("Cuenta eliminada")
                        else:
                            print("Cancelando...")
                        op = False
                    else:
                        print("Error. Selecciona una opción válida ¬¬ -_-")
            elif opc == 4:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def modifyUser():
        flag = True
        while flag:
            print("\n1) Modificar\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                print("\t\nSelecciona el usuario:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Nombre: {employee.get_name()} {employee.get_last_name()}")
                    i += 1
                """for i, employee in enumerate(Bank.get_employee_list(), 1):
                    print(f"{i}) Nombre: {employee.get_name()} {employee.get_last_name()}")"""
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y < len(Bank.get_employee_list()):
                        op = False
                    else:
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                modName = input("\nIngresa el nombre: ")
                print("\nModificando...")
                employee = Bank.get_employee_list()[y]
                employee.set_name(modName)
                modLastName = input("\nIngresa el apellido: ")
                print("\nModificando...")
                employee.set_last_name(modLastName)
                print("\nUsuario modificado")
            elif opc == 2:
                print("\n Regresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def deleteUser():
        flag = True
        while flag:
            print("\n1) Eliminar\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                print("\t\nSelecciona el usuario a eliminar:\n")
                i = 0
                for employee in Bank.get_employee_list():
                    print(f"{i + 1}) Nombre: {employee.get_name()} {employee.get_last_name()}")
                    i += 1
                """for i, employee in enumerate(Bank.get_employee_list(), 1):
                    print(f"{i}) Nombre: {employee.get_name()} {employee.get_last_name()}")"""
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y < len(Bank.get_employee_list()):
                        op = False
                    else:
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                employee = Bank.get_employee_list()[y]
                print(f"\nSeguro/a que deseas eliminar a {employee.get_name()} {employee.get_last_name()}?\n1) Sí\n2) No")
                op = True
                while op:
                    res = int(input("\nRespuesta: "))
                    if res in [1, 2]:
                        if res == 1:
                            print("Eliminando...")
                            Bank.get_employee_list().remove(employee)
                            print("Usuario eliminado")
                        else:
                            print("Cancelando...")
                        op = False
                    else:
                        print("Error. Selecciona una opción válida ¬¬ -_-")
            elif opc == 2:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    @staticmethod
    def showUserAccountsList():
        print("\nLista de Usuarios en Sistema:")
        for employee in Bank.get_employee_list():
            print(f"\nNombre: {employee.get_name()}  Apellido: {employee.get_last_name()}")
            for account in employee.get_account_list():
                print(f"Cuenta: {account.get_account_number()} Tipo: {account.get_type()}")