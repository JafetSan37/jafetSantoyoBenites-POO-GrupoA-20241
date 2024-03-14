import random
import Library
import Books
import Users
import SaleBooks
class MenuLibrary:
    def libraryMenu(self):
        flag = True
        x = 0
        while flag:
            print("\nSelecciona una opción:\n1) Registrar Libro\n2) Registrar Usuario\n3) Libros\n4) Usuarios\n5) Salir")
            x = int(input("\nOpción: "))
            input()
            if x == 1:
                MenuLibrary.registerBook()
            elif x == 2:
                MenuLibrary.registerUser()
            elif x == 3:
                MenuLibrary.menuBooks()
            elif x == 4:
                MenuLibrary.menuUsers()
            elif x == 5:
                print("\nRegresando al menú principal...")
                flag = False
            else:
                print("Error. Selecciona una opción válida.")

    @staticmethod
    def registerBook():
        number = random.Random()
        flag = True
        opc = 0
        year = 0
        id = 0
        price = 0
        inventory = 0
        title = ""
        author = ""
        while flag:
            print("\nSección:\n1) Renta\n2) Venta\n3) Salir")
            opc = int(input("\nOpción: "))
            input()
            if opc == 1:
                title = input("\nIngresa el título: ")
                author = input("\nIngresa el autor: ")
                year = int(input("\nIngresa el año de publicación: "))
                input()
                print("\nRegistrando libro para renta...")
                id = number.randint(0, 999999)
                book = Books(id, title, author, year)
                print("\nAñadiendo a biblioteca...")
                Library.addBook(book)
                print("\nLibro registrado!")
                flag = False
            elif opc == 2:
                title = input("\nIngresa el título: ")
                author = input("\nIngresa el autor: ")
                year = int(input("\nIngresa el año de publicación: "))
                input()
                price = int(input("\nIngresa el precio de venta: "))
                inventory = int(input("\nIngresa el inventario: "))
                print("\nRegistrando libro para venta...")
                id = number.randint(0, 999999)
                book = SaleBooks(id, title, author, year, price, inventory)
                book.setAvailable(True)
                print("\nAñadiendo a biblioteca...")
                Library.addSellBook(book)
                print("\nLibro registrado!")
                flag = False
            elif opc == 3:
                print("\nRegresando al menú anterior...\n")
                flag = False
            else:
                print("Error. Elige una opción válida.")


    def registerUser():
        number = random.Random()
        sig = True
        opc = 0
        idUser = 0
        cellNumber = 0
        age = 0
        name = ""
        lastName = ""
        address = ""
        while sig:
            print("\nConfirmar:\n1) Sí\n2) No")
            opc = int(input("\nOpción: "))
            input()
            if opc == 1:
                name = input("\nIngresa el nombre: ")
                lastName = input("\nIngresa los apellidos: ")
                address = input("\nIngresa la dirección: ")
                cellNumber = int(input("\nIngresa un número de teléfono: "))
                age = int(input("\nIngresa la edad: "))
                if age < 18:
                    print("Error. El usuario es menor de edad.\nRegresando al menú...")
                else:
                    print("\nRegistrando usuario..")
                    idUser = number.randint(100000, 999999)
                    user = Users(idUser, name, lastName, age, cellNumber, address)
                    rentedBooks = []
                    user.setRentedBooks(rentedBooks)
                    soldBooks = []
                    user.setSoldBooks(soldBooks)
                    print("\nAñadiendo a base de datos...")
                    Library.addUser(user)
                    print("\nUsuario registrado!")
                sig = False
            elif opc == 2:
                print("\nRegresando al menú anterior...\n")
                sig = False
            else:
                print("Error. Elige una opción válida.")
    @staticmethod
    def menuBooks():
        pt = True
        op = True
        st = True
        opc = 0
        b = 0
        j = 0
        k = 0
        y = 0
        r = 0
        a = 0
        year = 0
        inventory = 0
        price = 0.0
        title = ""
        author = ""

        while pt:
            print("\nSelecciona la opción deseada:\n1) Consultar biblioteca (rentas)\n2) Consultar librería (ventas)\n3) Libros disponibles para renta\n4) Libros disponibles en venta\n5) Modificar Libro\n6) Eliminar Libro\n7) Salir")
            opc = int(input("\nOpción: "))
            input()

            if opc == 1:
                for book in Library.getBooksList():
                    print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}".format(book.getID(), book.getTitle(), book.getAuthor(), book.getYear()))
                    print("**************")

            elif opc == 2:
                for book in Library.getBooksSell():
                    print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}\nPrecio: {:.2f}".format(book.getID(), book.getTitle(), book.getAuthor(), book.getYear(), book.getPrice()))
                    print("**************")

            elif opc == 3:
                b = 0
                for books in Library.getBooksList():
                    if books.isRented():
                        b += 1
                for book in Library.getBooksList():
                    if not book.isRented():
                        print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}".format(book.getID(), book.getTitle(), book.getAuthor(), book.getYear()))
                        print("**************")
                    elif b == 0:
                        print("\nNo hay libros disponibles.")

            elif opc == 4:
                b = 0
                for books in Library.getBooksSell():
                    if books.isAvailable():
                        b += 1
                for book in Library.getBooksSell():
                    if book.isAvailable():
                        print("\nID: {}\nTítulo: {}\nAutor: {}\nAño de Publicación: {}\nPrecio: {:.2f}\nInventario: {}".format(book.getID(), book.getTitle(), book.getAuthor(), book.getYear(), book.getPrice(), book.getInventory()))
                        print("**************")
                    elif b == 0:
                        print("\nNo hay libros disponibles.")

            elif opc == 5:
                st = True
                while st:
                    print("\n1) Libros para Renta\n2) Libros para Venta\n3) Salir")
                    a = int(input())
                    input()

                    if a == 1:
                        op = True
                        j = 1
                        print("\t\nSelecciona el libro a modificar:\n")
                        for books in Library.getBooksList():
                            print("\n{} ID: {}\n   Nombre: {}\n   Autor: {}".format(j, books.getID(), books.getTitle(), books.getAuthor()))
                            j += 1
                        while op:
                            y = 0
                            print("\nRespuesta: ", end="")
                            y = int(input())
                            input()
                            y -= 1
                            if y > len(Library.getBooksList()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        op = True
                        book = Library.getBooksList()[y]
                        while op:
                            print("\t\nSelecciona el dato a modificar:\n")
                            print("\n1) Título: {}\n2) Autor: {}\n3) Año de publicación: {}\n4) Salir".format(book.getTitle(), book.getAuthor(), book.getYear()))
                            print("\nRespuesta: ", end="")
                            r = int(input())
                            input()
                            if r == 1:
                                print("\nIngresa el título: ", end="")
                                title = input()
                                print("\nModificando título...")
                                book.setTitle(title)
                                print("\nTítulo modificado!")
                            elif r == 2:
                                print("\nIngresa el autor: ", end="")
                                author = input()
                                print("\nModificando autor...")
                                book.setAuthor(author)
                                print("\nAutor modificado!")
                            elif r == 3:
                                print("\nIngresa el año de publicación: ", end="")
                                year = int(input())
                                input()
                                print("\nModificando año...")
                                book.setYear(year)
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
                        for book in Library.getBooksSell():
                            print("\n{} ID: {}\n   Título: {}\n   Autor: {}".format(k, book.getID(), book.getTitle(), book.getAuthor()))
                            k += 1
                        while op:
                            y = 0
                            print("\nRespuesta: ", end="")
                            y = int(input())
                            input()
                            y -= 1
                            if y > len(Library.getBooksSell()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        op = True
                        book = Library.getBooksSell()[y]
                        while op:
                            print("\t\nSelecciona el dato a modificar:\n")
                            print("\n1) Título: {}\n2) Autor: {}\n3) Año de publicación: {}\n4) Precio de venta: {:.2f}\n5) Inventario: {}\n6) Salir".format(book.getTitle(), book.getAuthor(), book.getYear(), book.getPrice(), book.getInventory()))
                            print("\nRespuesta: ", end="")
                            r = int(input())
                            input()
                            if r == 1:
                                print("\nIngresa el título: ", end="")
                                title = input()
                                print("\nModificando título...")
                                book.setTitle(title)
                                print("\nTítulo modificado!")
                            elif r == 2:
                                print("\nIngresa el autor: ", end="")
                                author = input()
                                print("\nModificando autor...")
                                book.setAuthor(author)
                                print("\nAutor modificado!")
                            elif r == 3:
                                print("\nIngresa el año de publicación: ", end="")
                                year = int(input())
                                input()
                                print("\nModificando año...")
                                book.setYear(year)
                                print("\nAño de publicación modificado!")
                            elif r == 4:
                                print("\nIngresa el precio de venta: ", end="")
                                price = float(input())
                                input()
                                print("\nModificando precio...")
                                book.setPrice(price)
                                print("\nPrecio de venta modificado!")
                            elif r == 5:
                                print("\nIngresa el nuevo inventario: ", end="")
                                inventory = int(input())
                                input()
                                print("\nActualizando inventario...")
                                book.setInventory(inventory)
                                if book.getInventory() == 0:
                                    book.setAvailable(False)
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
                    a = int(input())
                    input()

                    if a == 1:
                        op = True
                        j = 1
                        print("\t\nSelecciona el libro a eliminar:\n")
                        for book in Library.getBooksList():
                            print("\n{} ID: {}\n   Título: {}\n   Autor: {}".format(j, book.getID(), book.getTitle(), book.getAuthor()))
                            j += 1
                        while op:
                            y = 0
                            print("\nRespuesta: ", end="")
                            y = int(input())
                            input()
                            y -= 1
                            if y > len(Library.getBooksList()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        book = Library.getBooksList()[y]
                        if book.isRented():
                            print("Error. El libro fue rentado por un usuario. Favor de retornar el libro antes de borrarlo.")
                        else:
                            print("\nSeguro/a que deseas eliminar este libro?\n1) Sí\n2) No")
                            op = True
                            while op:
                                r = 0
                                print("\nRespuesta: ", end="")
                                r = int(input())
                                input()
                                if r != 1 and r != 2:
                                    print("Error. Selecciona una opción válida.")
                                elif r == 1:
                                    print("Eliminando...")
                                    Library.getBooksList().remove(book)
                                    print("Libro para renta eliminado")
                                    op = False
                                elif r == 2:
                                    print("Cancelando...")
                                    op = False

                    elif a == 2:
                        op = True
                        k = 1
                        print("\t\nSelecciona el libro a eliminar:\n")
                        for book in Library.getBooksSell():
                            print("\n{} ID: {}\n   Título: {}\n   Autor: {}".format(k, book.getID(), book.getTitle(), book.getAuthor()))
                            k += 1
                        while op:
                            y = 0
                            print("\nRespuesta: ", end="")
                            y = int(input())
                            input()
                            y -= 1
                            if y > len(Library.getBooksSell()):
                                print("Error. Ingresa una opción válida.")
                            else:
                                op = False
                        book = Library.getBooksSell()[y]
                        print("\nSeguro/a que deseas eliminar este libro del inventario?\n1) Sí\n2) No")
                        op = True
                        while op:
                            r = 0
                            print("\nRespuesta: ", end="")
                            r = int(input())
                            input()
                            if r != 1 and r != 2:
                                print("Error. Selecciona una opción válida.")
                            elif r == 1:
                                print("Eliminando...")
                                Library.getBooksSell().remove(book)
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
def menuUsers():
    st = True
    op = True
    ag = True
    opc = 0
    b = 0
    i = 0
    y = 0
    r = 0
    cellNumber = 0
    age = 0
    counter = 0
    name = ""
    lastName = ""
    address = ""
    
    while st:
        print("\nSelecciona la opción deseada:\n1) Mostrar Usuarios Registrados\n2) Usuarios con renta de libros\n3) Usuarios con historial de compras\n4) Modificar Usuario\n5) Eliminar Usuario\n6) Salir")
        opc = int(input("\nOpción: "))
        input()
        
        if opc == 1:
            b = 1
            for user in Library.getUsersList():
                print(f"\n{b}) ID: {user.getIDuser()}\n   Nombre: {user.getName()}\n   Apellidos: {user.getLastName()}\n   Teléfono: {user.getCellNumber()}\n   Edad: {user.getAge()}\n   Dirección: {user.getAddress()}")
                print("****************")
                b += 1
        
        elif opc == 2:
            b = 1
            counter = 0
            for users in Library.getUsersList():
                if not users.getRentedBooks():
                    print(f"\n{b}) Nombre: {users.getName()}\n   Apellidos: {users.getLastName()}\n   Edad: {users.getAge()}\n   Libros rentados: {len(users.getRentedBooks())}")
                    print("****************")
                    b += 1
                else:
                    counter += 1
                    if counter == len(Library.getUsersList()):
                        print("\nNo hay usuarios con rentas existentes")
        
        elif opc == 3:
            b = 1
            counter = 0
            for users1 in Library.getUsersList():
                if not users1.getSoldBooks():
                    print(f"\n{b}) Nombre: {users1.getName()}\n   Apellidos: {users1.getLastName()}\n   Edad: {users1.getAge()}\n   Libros comprados: {len(users1.getSoldBooks())}")
                    print("****************")
                    b += 1
                else:
                    counter += 1
                    if counter == len(Library.getUsersList()):
                        print("\nNo existen usuarios con compras efectuadas")
        
        elif opc == 4:
            op = True
            i = 1
            print("\t\nSelecciona el usuario a modificar:\n")
            for users4 in Library.getUsersList():
                print(f"\n{i}) Nombre: {users4.getName()} {users4.getLastName()}")
                i += 1
            
            while op:
                y = 0
                y = int(input("\nRespuesta: "))
                input()
                y -= 1
                if y > len(Library.getUsersList()):
                    print("Error. Ingresa una opción válida.")
                else:
                    op = False
            op = True
            user = Library.getUsersList()[y]
            
            while op:
                print("\t\nSelecciona el dato a modificar:\n")
                print(f"\n1) Nombre: {user.getName()}\n2) Apellidos: {user.getLastName()}\n3) Teléfono: {user.getCellNumber()}\n4) Edad: {user.getAge()}\n5) Dirección: {user.getAddress()}\n6) Salir")
                r = int(input("\nRespuesta: "))
                input()
                
                if r == 1:
                    name = input("\nIngresa el nombre: ")
                    print("\nModificando nombre...")
                    user.setName(name)
                    print("\nNombre modificado!")
                
                elif r == 2:
                    lastName = input("\nIngresa el apellido: ")
                    print("\nModificando apellido...")
                    user.setLastName(lastName)
                    print("\nApellido modificado!")
                
                elif r == 3:
                    cellNumber = int(input("\nIngresa el número: "))
                    input()
                    print("\nModificando teléfono...")
                    user.setCellNumber(cellNumber)
                    print("\nTeléfono modificado!")
                
                elif r == 4:
                    ag = True
                    while ag:
                        age = int(input("\nIngresa la edad: "))
                        input()
                        if age < 18:
                            print("\nError. El usuario no puede ser menor de edad")
                        else:
                            print("\nModificando edad...")
                            user.setAge(age)
                            print("\nEdad modificada!")
                            ag = False
                
                elif r == 5:
                    address = input("\nIngresa la dirección: ")
                    print("\nModificando dirección...")
                    user.setAddress(address)
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
            for users5 in Library.getUsersList():
                print(f"\n{i}) Nombre: {users5.getName()} {users5.getLastName()}")
                i += 1
            
            while op:
                y = 0
                y = int(input("\nRespuesta: "))
                input()
                y -= 1
                if y > len(Library.getUsersList()):
                    print("Error. Ingresa una opción válida.")
                else:
                    op = False
            user = Library.getUsersList()[y]
            
            if not user.getRentedBooks():
                print(f"\nSeguro/a que deseas eliminar a {user.getName()} {user.getLastName()}?\n1) Sí\n2) No")
                op = True
                while op:
                    r = 0
                    r = int(input("\nRespuesta: "))
                    input()
                    if r != 1 and r != 2:
                        print("Error. Selecciona una opción válida.")
                    elif r == 1:
                        print("Eliminando...")
                        Library.getUsersList().remove(user)
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