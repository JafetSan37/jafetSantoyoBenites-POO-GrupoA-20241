from UserMenu import UserMenu
from AdminMenu import AdminMenu
from PreChargedObjects import PreChargedObjects

# Objetos previamente creados en la clase PreChargedObjects para prueba del programa.
PreChargedObjects.agregar_elementos()

print("\t\nHola! Bienvenido/a!")
flag = True
# Ciclo para evitar el ingreso de datos erróneos al seleccionar opción.
while flag:
    print("\t\nSelecciona la opción deseada:\n1) Usuario\n2) Administrador\n3) Salir")
    x = int(input("\nOpción: "))
    if x == 1:
        print("\nBienvenido/a!")
        UserMenu.menu_user()
    elif x == 2:
        print("\t\nBienvenido, Administrador")
        AdminMenu.menu_administrator()
    elif x == 3:
        print("\nHasta luego!")
        flag = False
    else:
        print("\nError. Selecciona una opción válida ¬¬ -_-")