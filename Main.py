class Main:
    @staticmethod
    def main():
        PreChargedObjects.addElements()
        flag = True
        print("\t\nBienvenido!")
        while flag:  # Menú Principal. Se llaman a los otros menús de sus respectivas clases.
            print("\nSelecciona una opción:\n1) Usuario\n2) Librería\n3) Salir")
            opc = int(input("\nOpción: "))
            switcher = {
                1: MenuUser.userMenu,
                2: MenuLibrary.libraryMenu,
                3: lambda: print("\nHasta luego!\n")  # Salir del bucle while
            }
            switcher.get(opc, lambda: print("Error. Selecciona una opción válida."))()

