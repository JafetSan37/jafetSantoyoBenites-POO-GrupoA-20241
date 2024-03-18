from UserMenu import UserMenu
from AdminMenu import AdminMenu
from PreChargedObjects import PreChargedObjects
# Llamar al método para agregar elementos previamente creados
pre_charged_objects = PreChargedObjects
pre_charged_objects.agregar_elementos()

print("\t\n¡Hola! ¡Bienvenido/a!")
flag = True

# Ciclo para evitar el ingreso de datos erróneos al seleccionar opción.
while flag:
    print("\t\nSelecciona la opción deseada:\n1) Usuario\n2) Administrador\n3) Salir")
    opcion = int(input("\nOpción: "))
    
    if opcion == 1:
        print("\n¡Bienvenido/a!")
        UserMenu.menu_user()
    elif opcion == 2:
        print("\t\n¡Bienvenido, Administrador!")
        AdminMenu.menuAdministrator()
    elif opcion == 3:
        print("\n¡Hasta luego!")
        flag = False
    else:
        print("\nError. Selecciona una opción válida ¬¬ -_-")