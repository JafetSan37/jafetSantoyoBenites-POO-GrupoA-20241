from Books import Books
from Library import Library
from MenuLibrary import MenuLibrary
from MenuUser import MenuUser
from PreChargedObjects import PreChargedObjects
from SaleBooks import SaleBooks
from Users import Users

pre_charged_objects = PreChargedObjects()
pre_charged_objects.add_elements()
menu_user = MenuUser()
menu_library = MenuLibrary()
flag = True

print("\t\nBienvenido!")

while flag:
    print("\nSelecciona una opción:\n1) Usuario\n2) Librería\n3) Salir")
    opc = int(input("\nOpción: "))
    
    if opc == 1:
        menu_user.user_menu()
    elif opc == 2:
        menu_library.library_menu()
    elif opc == 3:
        print("\nHasta luego!\n")
        flag = False
    else:
        print("Error. Selecciona una opción válida.")

