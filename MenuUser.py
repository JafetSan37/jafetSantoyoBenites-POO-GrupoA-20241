from Library import Library
class MenuUser:
    def __init__(self):
        self.library = Library()
        self.available_books = []

    def user_menu(self):
        flag = True
        while flag:
            print("\nSelecciona la opción deseada:\n1) Consultar libros\n2) Solicitar un libro\n3) Devolver un libro\n4) Comprar libro\n5) Salir")
            x = int(input("\nOpción: "))
            if x == 1:
                self.consult_book()
            elif x == 2:
                self.ask_book()
            elif x == 3:
                self.ret_book()
            elif x == 4:
                self.buy_book()
            elif x == 5:
                print("\nRegresando al menú principal...")
                flag = False
            else:
                print("Error. Selecciona una opción válida")

    def consult_book(self):
        pt = True
        while pt:
            print("\nSelecciona una opción:\n1) Libros en renta\n2) Libros en venta\n3) Salir")
            a = int(input("\nOpción: "))
            if a == 1:
                counter = 0
                for book in self.library.get_books():
                    if not book.is_rented():
                        print("\nTítulo: {}\nAutor: {}\nAño de Publicación: {}".format(book.get_title(), book.get_author(), book.get_year()))
                        print("**************")
                    else:
                        counter += 1
                if counter == len(self.library.get_books()):
                    print("\nNo hay libros disponibles.")
            elif a == 2:
                counter = 0
                for book in self.library.get_sell_books():
                    if book.is_available():
                        print("\nTítulo: {}\nAutor: {}\nAño de Publicación: {}\nPrecio: {:.2f}".format(book.get_title(), book.get_author(), book.get_year(), book.get_price()))
                        print("**************")
                    else:
                        counter += 1
                if counter == len(self.library.get_sell_books()):
                    print("\nNo hay libros disponibles en existencia.")
            elif a == 3:
                print("\nRegresando al menú anterior...")
                pt = False
            else:
                print("Error. Selecciona una opción válida")

    def ask_book(self):
        ab = True
        bt = True
        x = 1
        counter = 0
        print("\t\nSelecciona el libro deseado:")
        for book in self.library.get_books():
            if not book.is_rented():
                self.available_books.append(book)
                print("\n{}) Nombre: {}\n   Autor: {}".format(x, book.get_title(), book.get_author()))
                x += 1
            else:
                counter += 1
        if counter == len(self.library.get_books()):
            print("\nNo hay libros disponibles para solicitar. Intenta más tarde.")
        else:
            while bt:
                y = int(input("\nRespuesta: ")) - 1
                if y > len(self.available_books):
                    print("Error. Ingresa una opción válida.")
                else:
                    bt = False
            print("\nSolicitando...")
            required_book = self.available_books[y]
            id_book = required_book.get_ID()
            for book in self.library.get_books():
                if id_book == book.get_ID():
                    book.set_rented(True)
            bt = True
            x = 1
            print("\nSelecciona tu usuario:")
            for user in self.library.get_users():
                print("\n{}) Nombre: {} {}".format(x, user.get_name(), user.get_lastName()))
                x += 1
            while bt:
                r = int(input("\nRespuesta: ")) - 1
                if r > len(self.library.get_users()):
                    print("Error. Selecciona una opción válida.")
                else:
                    bt = False
            user = self.library.get_users()[r]
            self.available_books.clear()
            print("\nAgregando libro...")
            user.add_book_user(required_book)
            print("\nLibro agregado!")

    def ret_book(self):
        op = True
        bt = True
        while op:
            x = 1
            print("\nSelecciona tu usuario:\n")
            for user in self.library.get_users():
                print("\n{}) Nombre: {} {}".format(x, user.get_name(), user.get_lastName()))
                x += 1
            while bt:
                r = int(input("\nRespuesta: ")) - 1
                if r > len(self.library.get_users()):
                    print("Error. Selecciona una opción válida.")
                else:
                    bt = False
            user = self.library.get_users()[r]
            if user.get_rentedBooks() == []:
                print("Error. El usuario seleccionado no tiene ningún libro rentado.")
                op = False
            else:
                k = 1
                print("\nSelecciona el libro a devolver:")
                for book in user.get_rentedBooks():
                    print("\n{}) Título: {} Autor: {}".format(k, book.get_title(), book.get_author()))
                    k += 1
                bt = True
                while bt:
                    b = int(input("\nRespuesta: ")) - 1
                    if b > len(user.get_rentedBooks()):
                        print("Error. Selecciona una opción válida.")
                    else:
                        bt = False
                print("\nDevolviendo libro...")
                book_ret = user.get_rentedBooks()[b]
                id_book = book_ret.get_ID()
                for book in self.library.get_books():
                    if book.get_ID() == id_book:
                        index = self.library.get_books().index(book)
                        book_dev = self.library.get_books()[index]
                        book_dev.set_rented(False)
                user.get_rentedBooks().remove(book_ret)
                print("\nLibro devuelto!\n")
                op = False

    def buy_book(self):
        pt = True
        p = 1
        counter = 0
        print("\t\nSelecciona el libro deseado:")
        for book in self.library.get_sell_books():
            if book.is_available():
                print("\n{}) Nombre: {}\n   Autor: {}\n   Precio: {:.2f}".format(p, book.get_title(), book.get_author(), book.get_price()))
                p += 1
            else:
                counter += 1
        if counter == len(self.library.get_sell_books()):
            print("\nNo hay libros en existencia. Regresa más tarde")
        else:
            while pt:
                y = int(input("\nRespuesta: ")) - 1
                if y > len(self.library.get_sell_books()):
                    print("Error. Ingresa una opción válida.")
                else:
                    pt = False
            print("\nObteniendo libro...")
            book = self.library.get_sell_books()[y]
            inventory = book.get_inventory()
            inventory -= 1
            book.set_inventory(inventory)
            if book.get_inventory() == 0:
                book.set_available(False)
            x = 1
            print("\nSelecciona tu usuario:")
            for user in self.library.get_users():
                print("\n{}) Nombre: {} {}".format(x, user.get_name(), user.get_lastName()))
                x += 1
            pt = True
            while pt:
                o = int(input("\nRespuesta: ")) - 1
                if o > len(self.library.get_users()):
                    print("Error. Selecciona una opción válida.")
                else:
                    pt = False
            user = self.library.get_users()[o]
            print("\nComprando libro...")
            user.add_sold_book_user(book)
            print("\nLibro comprado y agregado a tu lista!")
            print("\nGracias por tu preferencia!\n")