import random
from Books import Books
from SaleBooks import SaleBooks
from Users import Users
from Library import Library
class MenuLibrary:
    def __init__(self):
        #self.reader = Reader()
        self.library = Library()

    def library_menu(self):
        flag = True
        while flag:
            print("\nSelecciona una opción:\n1) Registrar Libro\n2) Registrar Usuario\n3) Libros\n4) Usuarios\n5) Salir")
            x = int(input("\nOpción: "))
            switcher = {
                1: self.register_book,
                2: self.register_user,
                3: self.menu_books,
                4: self.menu_users,
                5: lambda: print("\nRegresando al menú principal...") or setattr(flag, False)
            }
            func = switcher.get(x, lambda: print("Error. Selecciona una opción válida."))
            func()

    def register_book(self):
        number = random.Random()
        flag = True
        while flag:
            print("\nSección:\n1) Renta\n2) Venta\n3) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                title = input("\nIngresa el título: ")
                author = input("\nIngresa el autor: ")
                year = int(input("\nIngresa el año de publicación: "))
                print("\nRegistrando libro para renta...")
                id = number.randint(0, 999999)
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
                id = number.randint(0, 999999)
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

    def register_user(self):
        number = random.Random()
        sig = True
        while sig:
            print("\nConfirmar:\n1) Sí\n2) No")
            opc = int(input("\nOpción: "))
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
                    rented_books = []
                    user.set_rented_books(rented_books)
                    sold_books = []
                    user.set_sold_books(sold_books)
                    print("\nAñadiendo a base de datos...")
                    self.library.add_user(user)
                    print("\nUsuario registrado!")
                sig = False
            elif opc == 2:
                print("\nRegresando al menú anterior...\n")
                sig = False
            else:
                print("Error. Elige una opción válida.")
    def menu_books(self):
        pt = True
        while pt:
            print("\nSelecciona la opción deseada:\n1) Consultar biblioteca (rentas)\n2) Consultar librería (ventas)\n3) Libros disponibles para renta\n4) Libros disponibles en venta\n5) Modificar Libro\n6) Eliminar Libro\n7) Salir")
            opc = int(input("\nOpción: "))
            if opc == 1:
                for book in self.library.get_books():
                    print(f"\nID: {book.get_ID()}\nTítulo: {book.get_title()}\nAutor: {book.get_author()}\nAño de Publicación: {book.get_year()}")
                    print("**************")
            elif opc == 2:
                for book in self.library.get_sell_books():
                    print(f"\nID: {book.get_id()}\nTítulo: {book.get_title()}\nAutor: {book.get_author()}\nAño de Publicación: {book.get_year()}\nPrecio: {book.get_price():.2f}")
                    print("**************")
            elif opc == 3:
                b = 0
                for book in self.library.get_books():
                    if book.is_rented():
                        b += 1
                for book in self.library.get_books():
                    if not book.is_rented():
                        print(f"\nID: {book.get_ID()}\nTítulo: {book.get_title()}\nAutor: {book.get_author()}\nAño de Publicación: {book.get_year()}")
                        print("**************")
                    elif b == 0:
                        print("\nNo hay libros disponibles.")
            elif opc == 4:
                b = 0
                for book in self.library.get_sell_books():
                    if book.is_available():
                        b += 1
                for book in self.library.get_sell_books():
                    if book.is_available():
                        print(f"\nID: {book.get_id()}\nTítulo: {book.get_title()}\nAutor: {book.get_author()}\nAño de Publicación: {book.get_year()}\nPrecio: {book.get_price():.2f}\nInventario: {book.get_inventory()}")
                        print("**************")
                    elif b == 0:
                        print("\nNo hay libros disponibles.")
            elif opc == 5:
                st = True
                while st:
                    print("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir")
                    a = int(input("\nOpción: "))
                    if a == 1:
                        op = True
                        j = 1
                        print("\t\nSelecciona el libro a modificar:\n")
                        for books in self.library.get_books():
                            print(f"\n{j}) ID: {books.get_ID()}\n   Nombre: {books.get_title()}\n   Autor: {books.get_author()}")
                            j += 1
                        y = 0
                        while op:
                            print("\nRespuesta: ", end="")
                            y = int(input())
                            y -= 1
                            if y > len(self.library.get_books()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        op = True
                        book = self.library.get_books()[y]
                        while op:
                            print("\t\nSelecciona el dato a modificar:")
                            print(f"\n1) Título: {book.get_title()}\n2) Autor: {book.get_author()}\n3) Año de publicación: {book.get_year()}\n4) Salir")
                            print("\nRespuesta: ", end="")
                            r = int(input())
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
                        for book in self.library.get_sell_books():
                            print(f"\n{k}) ID: {book.get_id()}\n   Título: {book.get_title()}\n   Autor: {book.get_author()}")
                            k += 1
                        y = 0
                        while op:
                            print("\nRespuesta: ", end="")
                            y = int(input())
                            y -= 1
                            if y > len(self.library.get_sell_books()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        op = True
                        book = self.library.get_sell_books()[y]
                        while op:
                            print("\t\nSelecciona el dato a modificar:")
                            print(f"\n1) Título: {book.get_title()}\n2) Autor: {book.get_author()}\n3) Año de publicación: {book.get_year()}\n4) Precio de venta: {book.get_price():.2f}\n5) Inventario: {book.get_inventory()}\n6) Salir")
                            print("\nRespuesta: ", end="")
                            r = int(input())
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
                    print("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir")
                    a = int(input("\nOpción: "))
                    if a == 1:
                        op = True
                        j = 1
                        print("\t\nSelecciona el libro a eliminar:")
                        for book in self.library.get_books():
                            print(f"\n{j}) ID: {book.get_ID()}\n   Título: {book.get_title()}\n   Autor: {book.get_author()}")
                            j += 1
                        y = 0
                        while op:
                            print("\nRespuesta: ", end="")
                            y = int(input())
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
                                print("\nRespuesta: ", end="")
                                r = int(input())
                                if r != 1 and r != 2:
                                    print("Error. Selecciona una opción válida.")
                                elif r == 1:
                                    print("\nEliminando...")
                                    self.library.get_books().remove(book)
                                    print("Libro para renta eliminado")
                                    op = False
                                elif r == 2:
                                    print("\nCancelando...")
                                    op = False
                    elif a == 2:
                        op = True
                        k = 1
                        print("\t\nSelecciona el libro a eliminar:\n")
                        for book in self.library.get_sell_books():
                            print(f"\n{k}) ID: {book.get_id()}\n   Título: {book.get_title()}\n   Autor: {book.get_author()}")
                            k += 1
                        y = 0
                        while op:
                            print("\nRespuesta: ", end="")
                            y = int(input())
                            y -= 1
                            if y > len(self.library.get_sell_books()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        book = self.library.get_sell_books()[y]
                        print("\nSeguro/a que deseas eliminar este libro del inventario?\n1) Sí\n2) No")
                        op = True
                        while op:
                            print("\nRespuesta: ", end="")
                            r = int(input())
                            if r != 1 and r != 2:
                                print("Error. Selecciona una opción válida.")
                            elif r == 1:
                                print("\nEliminando...")
                                self.library.get_sell_books().remove(book)
                                print("Libro eliminado del inventario")
                                op = False
                            elif r == 2:
                                print("\nCancelando...")
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
                    print(f"\n{b}) ID: {user.get_IDuser()}\n   Nombre: {user.get_name()}\n   Apellidos: {user.get_lastName()}\n   Teléfono: {user.get_cellNumber()}\n   Edad: {user.get_age()}\n   Dirección: {user.get_address()}")
                    print("****************")
                    b += 1
            elif opc == 2:
                b = 1
                counter = 0
                for users in self.library.get_users():
                    if not users.get_rentedBooks():
                        print(f"\n{b}) Nombre: {users.get_name()}\n   Apellidos: {users.get_lastName()}\n   Edad: {users.get_age()}\n   Libros rentados: {len(users.get_rentedBooks())}")
                        print("****************")
                        b += 1
                    else:
                        counter += 1
                        if counter == len(self.library.get_users_list()):
                            print("\nNo hay usuarios con rentas existentes")
            elif opc == 3:
                b = 1
                counter = 0
                for users1 in self.library.get_users_list():
                    if not users1.get_sold_books():
                        print(f"\n{b}) Nombre: {users1.get_name()}\n   Apellidos: {users1.get_last_name()}\n   Edad: {users1.get_age()}\n   Libros comprados: {len(users1.get_sold_books())}")
                        print("****************")
                        b += 1
                    else:
                        counter += 1
                        if counter == len(self.library.get_users_list()):
                            print("\nNo existen usuarios con compras efectuadas")
            elif opc == 4:
                op = True
                i = 1
                print("\t\nSelecciona el usuario a modificar:\n")
                for users4 in self.library.get_users_list():
                    print(f"\n{i}) Nombre: {users4.get_name()} {users4.get_last_name()}")
                    i += 1
                y = 0
                while op:
                    print("\nRespuesta: ", end="")
                    y = int(input())
                    y -= 1
                    if y > len(self.library.get_users_list()):
                        print("Error. Ingresa una opción válida.")
                    else:
                        op = False
                op = True
                user = self.library.get_users_list()[y]
                while op:
                    print("\t\nSelecciona el dato a modificar:\n")
                    print(f"\n1) Nombre: {user.get_name()}\n2) Apellidos: {user.get_last_name()}\n3) Teléfono: {user.get_cell_number()}\n4) Edad: {user.get_age()}\n5) Dirección: {user.get_address()}\n6) Salir")
                    print("Respuesta: ", end="")
                    r = int(input())
                    if r == 1:
                        name = input("\nIngresa el nombre: ")
                        print("\nModificando nombre...")
                        user.set_name(name)
                        print("\nNombre modificado!")
                    elif r == 2:
                        last_name = input("\nIngresa el apellido: ")
                        print("\nModificando apellido...")
                        user.set_last_name(last_name)
                        print("\nApellido modificado!")
                    elif r == 3:
                        cell_number = int(input("\nIngresa el número: "))
                        print("\nModificando teléfono...")
                        user.set_cell_number(cell_number)
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
                for users5 in self.library.get_users_list():
                    print(f"\n{i}) Nombre: {users5.get_name()} {users5.get_last_name()}")
                    i += 1
                y = 0
                while op:
                    print("\nRespuesta: ", end="")
                    y = int(input())
                    y -= 1
                    if y > len(self.library.get_users_list()):
                        print("Error. Ingresa una opción válida.")
                    else:
                        op = False
                user = self.library.get_users_list()[y]
                if not user.get_rented_books():
                    print(f"\nSeguro/a que deseas eliminar a {user.get_name()} {user.get_last_name()}?\n1) Sí\n2) No")
                    op = True
                    while op:
                        r = 0
                        print("\nRespuesta: ", end="")
                        r = int(input())
                        if r != 1 and r != 2:
                            print("Error. Selecciona una opción válida.")
                        elif r == 1:
                            print("Eliminando...")
                            self.library.get_users_list().remove(user)
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