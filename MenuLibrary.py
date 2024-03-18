import random
from Books import Books
from SaleBooks import SaleBooks
from Users import Users
from Library import Library
class MenuLibrary:
    def __init__(self):
        self.library = Library()

    def library_menu(self):
        flag = True
        while flag:
            print("\nSelecciona una opción:\n1) Registrar Libro\n2) Registrar Usuario\n3) Libros\n4) Usuarios\n5) Salir")
            x = int(input("\nOpción: "))
            try:
                if x == 1:
                    self.register_book()
                elif x == 2:
                    self.register_user()
                elif x == 3:
                    self.menu_books()
                elif x == 4:
                    self.menu_users()
                elif x == 5:
                    print("\nRegresando al menú principal...")
                    flag = False
                else:
                    print("Error. Selecciona una opción válida.")
            except ValueError:
                print("Error. Selecciona una opción válida.")

    def register_book(self):
        number = random.Random()
        flag = True
        while flag:
            print("\nSección:\n1) Renta\n2) Venta\n3) Salir")
            opc = int(input("\nOpción: "))
            try:
                if opc == 1:
                    title = input("\nIngresa el título: ")
                    author = input("\nIngresa el autor: ")
                    year = int(input("\nIngresa el año de publicación: "))
                    print("\nRegistrando libro para renta...")
                    id = number.randint(100000, 999999)
                    book = Books(id, title, author, year)
                    print("\nAñadiendo a biblioteca...")
                    self.library.add_book(book)
                    print("\nLibro registrado!")
                    flag = False
                elif opc == 2:
                    title = input("\nIngresa el título: ")
                    author = input("\nIngresa el autor: ")
                    year = int(input("\nIngresa el año de publicación: "))
                    price = float(input("\nIngresa el precio de venta: "))
                    inventory = int(input("\nIngresa el inventario: "))
                    print("\nRegistrando libro para venta...")
                    id = number.randint(100000, 999999)
                    book = SaleBooks(id, title, author, year, price, inventory)
                    book.set_available(True)
                    print("\nAñadiendo a biblioteca...")
                    self.library.add_sell_book(book)
                    print("\nLibro registrado!")
                    flag = False
                elif opc == 3:
                    print("\nRegresando al menú anterior...\n")
                    flag = False
                else:
                    print("Error. Elige una opción válida.")
            except ValueError:
                print("Error. Elige una opción válida.")

    def register_user(self):
        number = random.Random()
        sig = True
        while sig:
            print("\nConfirmar:\n1) Sí\n2) No")
            opc = int(input("\nOpción: "))
            try:
                if opc == 1:
                    name = input("\nIngresa el nombre: ")
                    last_name = input("\nIngresa los apellidos: ")
                    address = input("\nIngresa la dirección: ")
                    cell_number = int(input("\nIngresa un número de teléfono: "))
                    age = int(input("\nIngresa la edad: "))
                    if age < 18:
                        print("Error. El usuario es menor de edad.\nRegresando al menú...")
                    else:
                        print("\nRegistrando usuario..")
                        id_user = number.randint(100000, 999999)
                        user = Users(id_user, name, last_name, age, cell_number, address)
                        #rented_books = []
                        #user.set_rented_books(rented_books)
                        #sold_books = []
                        #user.set_sold_books(sold_books)
                        print("\nAñadiendo a base de datos...")
                        self.library.add_user(user)
                        print("\nUsuario registrado!")
                    sig = False
                elif opc == 2:
                    print("\nRegresando al menú anterior...\n")
                    sig = False
                else:
                    print("Error. Elige una opción válida.")
            except ValueError:
                print("Error. Elige una opción válida.")
    def menu_books(self):
        pt = True
        while pt:
            print("\nSelecciona la opción deseada:\n1) Consultar biblioteca (rentas)\n2) Consultar librería (ventas)\n3) Libros disponibles para renta\n4) Libros disponibles en venta\n5) Modificar Libro\n6) Eliminar Libro\n7) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                for book in self.library.get_books():
                    print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}".format(book.get_ID(), book.get_title(), book.get_author(), book.get_year()))
                    print("**************")
            elif opc == 2:
                for book in self.library.get_sell_books():
                    print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}\nPrecio: {:.2f}".format(book.get_id(), book.get_title(), book.get_author(), book.get_year(), book.get_price()))
                    print("**************")
            elif opc == 3:
                counter = 0
                for book in self.library.get_books():
                    if not book.is_rented():
                        print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}".format(book.get_ID(), book.get_title(), book.get_author(), book.get_year()))
                        print("**************")
                    else:
                        counter += 1
                if counter == len(self.library.get_books()):
                    print("\nNo hay libros disponibles.")
            elif opc == 4:
                counter = 0
                for book in self.library.get_sell_books():
                    if book.is_available():
                        print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}\nPrecio: {:.2f}\nInventario: {}".format(book.get_id(), book.get_title(), book.get_author(), book.get_year(), book.get_price(), book.get_inventory()))
                        print("**************")
                    else:
                        counter += 1
                if counter == len(self.library.get_sell_books()):
                    print("\nNo hay libros disponibles en existencia.")
            elif opc == 5:
                st = True
                while st:
                    a = int(input("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir\nOpción: "))
                    if a == 1:
                        op = True
                        j = 1
                        print("\t\nSelecciona el libro a modificar:\n")
                        for i, book in enumerate(self.library.get_books(), start=1):
                            print("\n{}) ID: {}\n   Nombre: {}\n   Autor: {}".format(j, book.get_ID(), book.get_title(), book.get_author()))
                            j += 1
                        while op:
                            y = 0
                            y = int(input("\nRespuesta: "))
                            y -= 1
                            if y > len(self.library.get_books()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        op = True
                        book = self.library.get_books()[y]
                        while op:
                            print("\t\nSelecciona el dato a modificar:\n")
                            print("\n1) Título: {}\n2) Autor: {}\n3) Año de publicación: {}\n4) Salir".format(book.get_title(), book.get_author(), book.get_year()))
                            r = int(input("\nRespuesta: "))
                            if r == 1:
                                title = input("\nIngresa el título: ")
                                print("\nModificando título...")
                                book.set_title(title)
                                print("\nTítulo modificado!")
                            elif r == 2:
                                author = input("\nIngresa el autor: ")
                                print("\nModificando autor...")
                                book.set_author(author)
                                print("\nAutor modificado!")
                            elif r == 3:
                                year = int(input("\nIngresa el año de publicación: "))
                                print("\nModificando año...")
                                book.set_year(year)
                                print("\nAño de publicación modificado!")
                            elif r == 4:
                                print("\nRegresando al menú anterior...")
                                op = False
                            else:
                                print("Error. Selecciona una opción válida")
                    elif a == 2:
                        op = True
                        k = 1
                        print("\t\nSelecciona el libro a modificar:\n")
                        for i, book in enumerate(self.library.get_sell_books(), start=1):
                            print("\n{}) ID: {}\n   Título: {}\n   Autor: {}".format(k, book.get_id(), book.get_title(), book.get_author()))
                            k += 1
                        while op:
                            y = 0
                            y = int(input("\nRespuesta: "))
                            y -= 1
                            if y > len(self.library.get_sell_books()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        op = True
                        book = self.library.get_sell_books()[y]
                        while op:
                            print("\t\nSelecciona el dato a modificar:\n")
                            print("\n1) Título: {}\n2) Autor: {}\n3) Año de publicación: {}\n4) Precio de venta: {:.2f}\n5) Inventario: {}\n6) Salir".format(book.get_title(), book.get_author(), book.get_year(), book.get_price(), book.get_inventory()))
                            r = int(input("\nRespuesta: "))
                            if r == 1:
                                title = input("\nIngresa el título: ")
                                print("\nModificando título...")
                                book.set_title(title)
                                print("\nTítulo modificado!")
                            elif r == 2:
                                author = input("\nIngresa el autor: ")
                                print("\nModificando autor...")
                                book.set_author(author)
                                print("\nAutor modificado!")
                            elif r == 3:
                                year = int(input("\nIngresa el año de publicación: "))
                                print("\nModificando año...")
                                book.set_year(year)
                                print("\nAño de publicación modificado!")
                            elif r == 4:
                                price = float(input("\nIngresa el precio de venta: "))
                                print("\nModificando precio...")
                                book.set_price(price)
                                print("\nPrecio de venta modificado!")
                            elif r == 5:
                                inventory = int(input("\nIngresa el nuevo inventario: "))
                                print("\nActualizando inventario...")
                                book.set_inventory(inventory)
                                if book.get_inventory() == 0:
                                    book.set_available(False)
                                elif book.get_inventory() > 0:
                                    book.set_available(True)
                                print("\nInventario actualizado!")
                            elif r == 6:
                                print("\nRegresando al menú anterior...")
                                op = False
                            else:
                                print("Error. Selecciona una opción válida")
                    elif a == 3:
                        print("\nRegresando al menú anterior...")
                        st = False
                    else:
                        print("Error. Selecciona una opción válida.")
            elif opc == 6:
                st = True
                while st:
                    a = int(input("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir\nOpción: "))
                    if a == 1:
                        op = True
                        j = 1
                        print("\t\nSelecciona el libro a eliminar:\n")
                        for i, book in enumerate(self.library.get_books(), start=1):
                            print("\n{}) ID: {}\n   Título: {}\n   Autor: {}".format(j, book.get_ID(), book.get_title(), book.get_author()))
                            j += 1
                        while op:
                            y = 0
                            y = int(input("\nRespuesta: "))
                            y -= 1
                            if y > len(self.library.get_books()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        book = self.library.get_books()[y]
                        if book.is_rented():
                            print("Error. El libro fue rentado por un usuario. Favor de retornar el libro antes de borrarlo.")
                        else:
                            print("\nSeguro/a que deseas eliminar este libro?\n1) Sí\n2) No")
                            op = True
                            while op:
                                r = 0
                                r = int(input("\nRespuesta: "))
                                if r != 1 and r != 2:
                                    print("Error. Selecciona una opción válida.")
                                elif r == 1:
                                    print("Eliminando...")
                                    self.library.get_books().remove(book)
                                    print("Libro para renta eliminado")
                                    op = False
                                elif r == 2:
                                    print("Cancelando...")
                                    op = False
                    elif a == 2:
                        op = True
                        k = 1
                        print("\t\nSelecciona el libro a eliminar:\n")
                        for i, book in enumerate(self.library.get_sell_books(), start=1):
                            print("\n{}) ID: {}\n   Título: {}\n   Autor: {}".format(k, book.get_id(), book.get_title(), book.get_author()))
                            k += 1
                        while op:
                            y = 0
                            y = int(input("\nRespuesta: "))
                            y -= 1
                            if y > len(self.library.get_sell_books()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        book = self.library.get_sell_books()[y]
                        print("\nSeguro/a que deseas eliminar este libro del inventario?\n1) Sí\n2) No")
                        op = True
                        while op:
                            r = 0
                            r = int(input("\nRespuesta: "))
                            if r != 1 and r != 2:
                                print("Error. Selecciona una opción válida.")
                            elif r == 1:
                                print("Eliminando...")
                                self.library.get_sell_books().remove(book)
                                print("Libro eliminado del inventario")
                                op = False
                            elif r == 2:
                                print("Cancelando...")
                                op = False
                    elif a == 3:
                        print("\nRegresando al menú anterior...")
                        st = False
                    else:
                        print("Error. Selecciona una opción válida.")
            elif opc == 7:
                print("\nRegresando al menú anterior...")
                pt = False
            else:
                print("Error. Selecciona una opción válida.")
    def menu_users(self):
        st = True
        while st:
            print("\nSelecciona la opción deseada:\n1) Mostrar Usuarios Registrados\n2) Usuarios con renta de libros\n3) Usuarios con historial de compras\n4) Modificar Usuario\n5) Eliminar Usuario\n6) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                b = 1
                for user in self.library.get_users():
                    print("\n{}) ID: {}\n   Nombre: {}\n   Apellidos: {}\n   Teléfono: {}\n   Edad: {}\n   Dirección: {}".format(b, user.get_IDuser(), user.get_name(), user.get_lastName(), user.get_cellNumber(), user.get_age(), user.get_address()))
                    print("****************")
                    b += 1
            elif opc == 2:
                b = 1
                counter = 0
                for user in self.library.get_users():
                    if user.get_rentedBooks():
                        print("\n{}) Nombre: {}\n   Apellidos: {}\n   Edad: {}\n   Libros rentados: {}".format(b, user.get_name(), user.get_lastName(), user.get_age(), len(user.get_rentedBooks())))
                        print("****************")
                        b += 1
                    else:
                        counter += 1
                        if counter == len(self.library.get_users()):
                            print("\nNo hay usuarios con rentas existentes")
            elif opc == 3:
                b = 1
                counter = 0
                for user in self.library.get_users():
                    if user.get_soldBooks():
                        print("\n{}) Nombre: {}\n   Apellidos: {}\n   Edad: {}\n   Libros comprados: {}".format(b, user.get_name(), user.get_lastName(), user.get_age(), len(user.get_soldBooks())))
                        print("****************")
                        b += 1
                    else:
                        counter += 1
                        if counter == len(self.library.get_users()):
                            print("\nNo existen usuarios con compras efectuadas")
            elif opc == 4:
                op = True
                i = 1
                print("\t\nSelecciona el usuario a modificar:\n")
                for user in self.library.get_users():
                    print("\n{}) Nombre: {} {}".format(i, user.get_name(), user.get_lastName()))
                    i += 1
                while op:
                    y = 0
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(self.library.get_users()):
                        print("Error. Ingresa una opción válida.")
                    else:
                        op = False
                op = True
                user = self.library.get_users()[y]
                while op:
                    print("\t\nSelecciona el dato a modificar:\n")
                    print("\n1) Nombre: {}\n2) Apellidos: {}\n3) Teléfono: {}\n4) Edad: {}\n5) Dirección: {}\n6) Salir".format(user.get_name(), user.get_lastName(), user.get_cellNumber(), user.get_age(), user.get_address()))
                    r = int(input("\nRespuesta: "))
                    if r == 1:
                        name = input("\nIngresa el nombre: ")
                        print("\nModificando nombre...")
                        user.set_name(name)
                        print("\nNombre modificado!")
                    elif r == 2:
                        last_name = input("\nIngresa el apellido: ")
                        print("\nModificando apellido...")
                        user.set_lastName(last_name)
                        print("\nApellido modificado!")
                    elif r == 3:
                        cell_number = int(input("\nIngresa el número: "))
                        print("\nModificando teléfono...")
                        user.set_cellNumber(cell_number)
                        print("\nTeléfono modificado!")
                    elif r == 4:
                        ag = True
                        while ag:
                            age = int(input("\nIngresa la edad: "))
                            if age < 18:
                                print("\nError. El usuario no puede ser menor de edad")
                            else:
                                print("\nModificando edad...")
                                user.set_age(age)
                                print("\nEdad modificada!")
                                ag = False
                    elif r == 5:
                        address = input("\nIngresa la dirección: ")
                        print("\nModificando dirección...")
                        user.set_address(address)
                        print("\nDirección modificada!")
                    elif r == 6:
                        print("\nRegresando al menú principal...")
                        op = False
                    else:
                        print("Error. Selecciona una opción válida")
            elif opc == 5:
                op = True
                i = 1
                print("\t\nSelecciona el usuario a eliminar:\n")
                for user in self.library.get_users():
                    print("\n{}) Nombre: {} {}".format(i, user.get_name(), user.get_lastName()))
                    i += 1
                while op:
                    y = 0
                    y = int(input("\nRespuesta: ")) - 1
                    if y > len(self.library.get_users()):
                        print("Error. Ingresa una opción válida.")
                    else:
                        op = False
                user = self.library.get_users()[y]
                if not user.get_rentedBooks():
                    print("\nSeguro/a que deseas eliminar a {} {}?\n1) Sí\n2) No".format(user.get_name(), user.get_lastName()))
                    op = True
                    while op:
                        r = int(input("\nRespuesta: "))
                        if r != 1 and r != 2:
                            print("Error. Selecciona una opción válida.")
                        elif r == 1:
                            print("Eliminando...")
                            self.library.get_users().remove(user)
                            print("Usuario eliminado")
                            op = False
                        else:
                            print("Cancelando...")
                            op = False
                else:
                    print("\nError. El usuario aún tiene libros rentados. Favor de solicitar los libros de regreso antes de eliminar")
            elif opc == 6:
                print("\nRegresando al menú anterior...")
                st = False
            else:
                print("Error. Selecciona una opción válida.")