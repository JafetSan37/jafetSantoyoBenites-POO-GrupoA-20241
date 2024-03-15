from Library import Library
class MenuUser:
    def __init__(self):
        self.library = Library()
        #self.reader = Reader()

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
                b = 0
                counter = 0
                for book in self.library.get_books():
                    if book.is_rented() == False:
                        print(f"\nTítulo: {book.get_title()}\nAutor: {book.get_author()}\n")
                        print("**************")
                    elif b == 0:
                        counter += 1
                        if counter == len(self.library.get_books()):
                            print("\nNo hay libros disponibles.")
            elif a == 2:
                b = 0
                for book in self.library.get_sell_books():
                    if book.is_available():
                        print(f"\nTítulo: {book.get_title()}\nAutor: {book.get_author()}\nPrecio: {book.get_price()}\n")
                        print("**************")
                    elif b == 0:
                        print("\nNo hay libros disponibles.")
            elif a == 3:
                print("\nRegresando al menú anterior...\n")
                pt = False
            else:
                print("Error. Selecciona una opción válida")

    def ask_book(self):
        ab = True
        while ab:
            j = 1
            print("\t\nSelecciona el libro deseado:\n")
            counter = 0
            for book in self.library.get_books():
                if book.is_rented() == False:
                    print(f"\n{j}) Nombre: {book.get_title()}\n   Autor: {book.get_author()}")
                    j += 1
                else:
                    counter += 1
                    if counter == len(self.library.get_books()):
                        print("\nNo hay libros disponibles, todos han sido rentados. Regresa más tarde.")
            y = int(input("\nRespuesta: ")) - 1
            book = self.library.get_books()[y]
            book.set_rented(True)
            x = 1
            print("\nSelecciona tu usuario:\n")
            for user in self.library.get_users():
                print(f"{x}) Nombre: {user.get_name()} {user.get_lastName()}")
                x += 1
            r = int(input("\nRespuesta: ")) - 1
            user = self.library.get_users()[r]
            print("\nAgregando libro...")
            user.add_book_user(book)
            print("\nLibro agregado!")
            ab = False

    def ret_book(self):
        op = True
        while op:
            x = 1
            print("\nSelecciona tu usuario:\n")
            for user in self.library.get_users():
                print(f"{x}) Nombre: {user.get_name()} {user.get_lastName()}")
                x += 1
            r = int(input("\nRespuesta: ")) - 1
            user = self.library.get_users()[r]
            if user.get_rentedBooks():
                k = 1
                print("\nSelecciona el libro a devolver:")
                for book in user.get_rentedBooks():
                    print(f"\n{k}) Título: {book.get_title()} Autor: {book.get_author()}\n")
                    k += 1
                b = int(input("\nRespuesta: ")) - 1
                book_ret = user.get_rentedBooks()[b]
                id_book = book_ret.get_ID()
                user.get_rentedBooks().remove(b)
                for books in self.library.get_books():
                    if books.get_ID() == id_book:
                        index = self.library.get_books().index(books)
                        book_dev = self.library.get_books()[index]
                        book_dev.set_rented(False)
                print("\nLibro devuelto!\n")
                op = False
            else:
                print("Error. El usuario seleccionado no tiene ningún libro rentado.")

    def buy_book(self):
        pt = True
        p = 1
        print("\t\nSelecciona el libro deseado:")
        for books in self.library.get_books_sell():
            if books.get_inventory() > 0:
                print(f"\n{p}) Nombre: {books.get_title()}\n   Autor: {books.get_author()}\n   Precio: {books.get_price()}\n")
                p += 1
        y = int(input("\nRespuesta: ")) - 1
        book = self.library.get_books_sell()[y]
        inventory = book.get_inventory() - 1
        book.set_inventory(inventory)
        if book.get_inventory() == 0:
            book.set_available(False)
        x = 1
        print("\nSelecciona tu usuario:")
        for user in self.library.get_users_list():
            print(f"\n{x}) Nombre: {user.get_name()} {user.get_last_name()}")
            x += 1
        o = int(input("\nRespuesta: ")) - 1
        user = self.library.get_users_list()[o]
        print("\nComprando libro...\n")
        user.add_sold_book_user(book)
        print("\nLibro comprado y agregado a tu lista!\n")
        print("\nGracias por tu preferencia!\n")
