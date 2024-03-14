import Library
class MenuUser:

    def userMenu():
        flag = True
        x = 0
        while flag:
            print("\nSelecciona la opción deseada:\n1) Consultar libros\n2) Solicitar un libro\n3) Devolver un libro\n4) Comprar libro\n5) Salir")
            x = int(input("\nOpción: "))
            switcher = {
                1: MenuUser.consultBook,
                2: MenuUser.askBook,
                3: MenuUser.retBook,
                4: MenuUser.buyBook,
                5: lambda: print("\nRegresando al menú principal..."),
            }
            switcher.get(x, lambda: print("Error. Selecciona una opción válida"))()
            if x == 5:
                flag = False

    def consultBook():
        pt = True
        a = 0
        b = 0
        while pt:
            print("\nSelecciona una opción:\n1) Libros en renta\n2) Libros en venta\n3) Salir")
            a = int(input("\nOpción: "))
            switcher = {
                1: lambda: MenuUser.printAvailableBooks(Library.getBooksList(), True),
                2: lambda: MenuUser.printAvailableBooks(Library.getBooksSell(), False),
                3: lambda: print("\nRegresando al menú anterior..."),
            }
            switcher.get(a, lambda: print("Error. Selecciona una opción válida"))()
            if a == 3:
                pt = False

    def printAvailableBooks(booksList, isRented):
        b = 0
        for book in booksList:
            if (isRented and book.isRented()) or (not isRented and book.isAvailable()):
                b += 1
                if not book.isRented():
                    print(f"\nTítulo: {book.getTitle()}\nAutor: {book.getAuthor()}\nAño de Publicación: {book.getYear()}")
                    print("**************")
        if b == 0:
            print("\nNo hay libros disponibles.")

    def askBook():
        ab = True
        bt = True
        x = 0
        y = 0
        j = 0
        r = 0
        while ab:
            j = 1
            print("\t\nSelecciona el libro deseado:\n")
            for i, book in enumerate(Library.getBooksList()):
                if not book.isRented():
                    print(f"\n{i+1}) Nombre: {book.getTitle()}\n   Autor: {book.getAuthor()}")
                    j += 1
            while bt:
                y = 0
                y = int(input("\nRespuesta: "))
                y -= 1
                if y > len(Library.getBooksList()):
                    print("Error. Ingresa una opción válida.")
                else:
                    bt = False
            book = Library.getBooksList()[y]
            book.setRented(True)
            bt = True
            x = 1
            print("\nSelecciona tu usuario:\n")
            for i, user in enumerate(Library.getUsersList()):
                print(f"\n{i+1}) Nombre: {user.getName()} {user.getLastName()}")
                x += 1
            while bt:
                r = int(input("\nRespuesta: "))
                r -= 1
                if r > len(Library.getUsersList()):
                    print("Error. Selecciona una opción válida.")
                else:
                    bt = False
            user = Library.getUsersList()[r]
            print("\nAgregando libro...")
            user.addBookUser(book)
            print("\nLibro agregado!")
            ab = False

    def retBook():
        op = True
        bt = True
        r = 0
        x = 0
        k = 0
        b = 0
        idBook = 0
        index = 0
        i = 0
        while op:
            x = 1
            print("\nSelecciona tu usuario:\n")
            for i, user in enumerate(Library.getUsersList()):
                print(f"\n{i+1}) Nombre: {user.getName()} {user.getLastName()}")
                x += 1
            while bt:
                r = int(input("\nRespuesta: "))
                r -= 1
                if r > len(Library.getUsersList()):
                    print("Error. Selecciona una opción válida.")
                else:
                    bt = False
            user = Library.getUsersList()[r]
            if user.getRentedBooks().isEmpty():
                print("Error. El usuario seleccionado no tiene ningún libro rentado.")
            else:
                k = 1
                print("\nSelecciona el libro a devolver:")
                for i, book in enumerate(user.getRentedBooks()):
                    print(f"\n{i+1}) Título: {book.getTitle()} Autor: {book.getAuthor()}")
                    k += 1
                bt = True
                while bt:
                    b = int(input("\nRespuesta: "))
                    b -= 1
                    if b > len(user.getRentedBooks()):
                        print("Error. Selecciona una opción válida.")
                    else:
                        bt = False
                print("\nDevolviendo libro...")
                bookRet = user.getRentedBooks()[b]
                idBook = bookRet.getID()
                for books in Library.getBooksList():
                    if books.getID() == idBook:
                        index = Library.getBooksList().index(books)
                        bookDev = Library.getBooksList()[index]
                        bookDev.setRented(False)
                user.getRentedBooks().remove(b)
                print("\nLibro devuelto!\n")
                op = False

    def buyBook():
        pt = True
        o = 0
        p = 0
        x = 0
        y = 0
        inventory = 0
        p = 1
        print("\t\nSelecciona el libro deseado:")
        for i, book in enumerate(Library.getBooksSell()):
            if book.getInventory() > 0:
                print(f"\n{i+1}) Nombre: {book.getTitle()}\n   Autor: {book.getAuthor()}\n   Precio: {book.getPrice()}")
                p += 1
        while pt:
            y = 0
            y = int(input("\nRespuesta: "))
            y -= 1
            if y > len(Library.getBooksList()):
                print("Error. Ingresa una opción válida.")
            else:
                pt = False
        print("\nObteniendo libro...")
        book = Library.getBooksSell()[y]
        inventory = book.getInventory()
        inventory -= 1
        book.setInventory(inventory)
        if book.getInventory() == 0:
            book.setAvailable(False)
        x = 1
        print("\nSelecciona tu usuario:")
        for i, user in enumerate(Library.getUsersList()):
            print(f"\n{i+1}) Nombre: {user.getName()} {user.getLastName()}")
            x += 1
        pt = True
        while pt:
            o = int(input("\nRespuesta: "))
            o -= 1
            if o > len(Library.getUsersList()):
                print("Error. Selecciona una opción válida.")
            else:
                pt = False
        user = Library.getUsersList()[o]
        print("\nComprando libro...")
        user.addSoldBookUser(book)
        print("\nLibro comprado y agregado a tu lista!")
        print("\nGracias por tu preferencia!\n")