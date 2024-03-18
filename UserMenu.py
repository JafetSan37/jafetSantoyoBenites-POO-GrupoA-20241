from Bank import Bank

class UserMenu:
    op = False
    
    @classmethod
    def menu_user():
        flag = True
        while flag:
            print("\nSelecciona la opción deseada:\n1) Agregar dinero\n2) Retirar dinero\n3) Consultar Saldo\n4) Salir")
            x = int(input("\nOpción: "))
            if x == 1:
                UserMenu.add_money()
            elif x == 2:
                UserMenu.draw_money()
            elif x == 3:
                UserMenu.consult_amount()
            elif x == 4:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")
    
    def add_money(self):
        flag = True
        while flag:
            print("\n1) Agregar\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                print("\t\nSelecciona tu usuario:\n")
                for i, employee in enumerate(Bank.get_employee_list()):
                    print(f"{i + 1}) Usuario: {employee.get_name()} {employee.get_last_name()}")
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(Bank.get_employee_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                employee = Bank.get_employee_list()[y]
                print("\nSelecciona la cuenta:\n")
                for x, account in enumerate(employee.get_account_list()):
                    print(f"{x + 1}) Cuenta: {account.get_account_number()} Tipo: {account.get_type()}")
                op = True
                while op:
                    z = int(input("\nRespuesta: ")) - 1
                    if z > len(employee.get_account_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                account = employee.get_account_list()[z]
                amount = float(input("\nIngresa el monto: "))
                account.set_amount(amount)
                print("\nMonto actualizado/sin cambios. Regresando al menú...")
            elif opc == 2:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    def draw_money():
        flag = True
        while flag:
            print("\n1) Retirar\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                print("\t\nSelecciona tu usuario:\n")
                for i, employee in enumerate(Bank.get_employee_list()):
                    print(f"{i + 1}) Usuario: {employee.get_name()} {employee.get_last_name()}")
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(Bank.get_employee_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                employee = Bank.get_employee_list()[y]
                print("\nSelecciona la cuenta:\n")
                for x, account in enumerate(employee.get_account_list()):
                    print(f"{x + 1}) Cuenta: {account.get_account_number()} Tipo: {account.get_type()} Saldo: $ {account.get_amount():.2f}")
                op = True
                while op:
                    z = int(input("\nRespuesta: ")) - 1
                    if z > len(employee.get_account_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                account = employee.get_account_list()[z]
                amount = float(input("\nIngresa el monto: "))
                account.draw_money(amount)
                print("\nMonto actualizado/sin cambios. Regresando al menú...")
            elif opc == 2:
                print("\nRegresando al menú anterior...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")

    def consult_amount():
        flag = True
        while flag:
            print("\n1) Consultar\n2) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                print("\t\nSelecciona tu usuario:\n")
                for i, employee in enumerate(Bank.get_employee_list()):
                    print(f"{i + 1}) Usuario: {employee.get_name()} {employee.get_last_name()}")
                op = True
                while op:
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(Bank.get_employee_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                employee = Bank.get_employee_list()[y]
                print("\nSelecciona la cuenta a consultar:\n")
                for x, account in enumerate(employee.get_account_list()):
                    print(f"{x + 1}) Cuenta: {account.get_account_number()} Tipo: {account.get_type()}")
                op = True
                while op:
                    z = int(input("\nRespuesta: ")) - 1
                    if z > len(employee.get_account_list()):
                        print("Error. Ingresa una opción válida ¬¬ -_-")
                    else:
                        op = False
                account = employee.get_account_list()[z]
                print(f"\nSaldo: $ {account.get_amount():.2f}")
            elif opc == 2:
                print("\nRegresando al menú principal...")
                flag = False
            else:
                print("Error. Selecciona una opción válida ¬¬ -_-")