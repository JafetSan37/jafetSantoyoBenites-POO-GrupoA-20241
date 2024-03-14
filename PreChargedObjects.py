import random
import Library
import Books
import SaleBooks
import Users

class PreChargedObjects:
    number = random.Random()

    
    def add_elements():
        # Libros para Renta
        a, b, c, d, e, f = 0, 0, 0, 0, 0, 0
        a = PreChargedObjects.number.randint(100000, 999999)
        book1 = Books(a, "Cazadores de Sombras: Ciudad de Hueso", "Cassandra Clare", 2007)
        book1.set_rented(False)
        b = PreChargedObjects.number.randint(100000, 999999)
        book2 = Books(b, "Caballo de Troya 1: Jerusalén", "J.J. Benítez", 1987)
        book2.set_rented(False)
        c = PreChargedObjects.number.randint(100000, 999999)
        book3 = Books(c, "Amarse con los Ojos Abiertos", "J.Bucay y S.Salinas", 2002)
        book3.set_rented(False)
        d = PreChargedObjects.number.randint(100000, 999999)
        book4 = Books(d, "Harry Potter: La Piedra Filosofal", "J.K. Rowling", 2001)
        book4.set_rented(False)
        e = PreChargedObjects.number.randint(100000, 999999)
        book5 = Books(e, "GOG", "J.J. Benítez", 2017)
        book5.set_rented(False)
        f = PreChargedObjects.number.randint(100000, 999999)
        book6 = Books(f, "Los Cuatro Acuerdos", "Miguel Ruiz", 2000)
        book6.set_rented(False)
        # Añadiendo los libros a la librería
        Library.addBook(book1)
        Library.addBook(book2)
        Library.addBook(book3)
        Library.addBook(book4)
        Library.addBook(book5)
        Library.addBook(book6)
        # Libros para Venta
        h, i, j, k, l, m = 0, 0, 0, 0, 0, 0
        h = PreChargedObjects.number.randint(100000, 999999)
        sellbook1 = SaleBooks(h, "Cazadores de Sombras: Ciudad de Hueso", "Cassandra Clare", 2017, 328, 15)
        sellbook1.setAvailable(True)
        i = PreChargedObjects.number.randint(100000, 999999)
        sellbook2 = SaleBooks(i, "Caballo de Troya 1: Jerusalén", "J.J. Benítez", 2011, 418, 5)
        sellbook2.setAvailable(True)
        j = PreChargedObjects.number.randint(100000, 999999)
        sellbook3 = SaleBooks(j, "Amarse con los Ojos Abiertos", "J.Bucay y S.Salinas", 2019, 345, 12)
        sellbook3.setAvailable(True)
        k = PreChargedObjects.number.randint(100000, 999999)
        sellbook4 = SaleBooks(k, "Harry Potter: La Piedra Filosofal", "J.K. Rowling", 2020, 369, 10)
        sellbook4.setAvailable(True)
        l = PreChargedObjects.number.randint(100000, 999999)
        sellbook5 = SaleBooks(l, "GOG", "J.J. Benítez", 2022, 158, 20)
        sellbook5.setAvailable(True)
        m = PreChargedObjects.number.randint(100000, 999999)
        sellbook6 = SaleBooks(m, "Los Cuatro Acuerdos", "Miguel Ruiz", 2009, 280, 6)
        sellbook6.setAvailable(True)
        # Añadiendo a la librería sección ventas

        Library.addSellBook(sellbook1)
        Library.addSellBook(sellbook2)
        Library.addSellBook(sellbook3)
        Library.addSellBook(sellbook4)
        Library.addSellBook(sellbook5)
        Library.addSellBook(sellbook6)

        # Pre-registered users
        q = PreChargedObjects.number.nextInt(100000, 999999)
        user1 = Users(q, "Jafet", "Santoyo", 512323457, 27, "Calle Ezequiel #78")
        bookRent = []
        bookSale = []
        user1.setRentedBooks(bookRent)
        user1.setSoldBooks(bookSale)

        w = PreChargedObjects.number.nextInt(100000, 999999)
        user2 = Users(w, "Fátima", "Rivera", 512323457, 24, "Calle Fco. Rincón #56")
        bookRent1 = []
        bookSale1 = []
        user2.setRentedBooks(bookRent1)
        user2.setSoldBooks(bookSale1)

        u = PreChargedObjects.number.nextInt(100000, 999999)
        user3 = Users(u, "Andrés", "Benites", 512323457, 21, "Calle Ezequiel #78")
        bookRent2 = []
        bookSale2 = []
        user3.setRentedBooks(bookRent2)
        user3.setSoldBooks(bookSale2)

        r = PreChargedObjects.number.nextInt(100000, 999999)
        user4 = Users(r, "Andrea", "Durán", 512323457, 27, "Calle El Porvenir #39")
        bookRent3 = []
        bookSale3 = []
        user4.setRentedBooks(bookRent3)
        user4.setSoldBooks(bookSale3)

        t = PreChargedObjects.number.nextInt(100000, 999999)
        user5 = Users(t, "Alejandro", "Montejano", 512323457, 24, "Calle Del Río #10")
        bookRent4 = []
        bookSale4 = []
        user5.setRentedBooks(bookRent4)
        user5.setSoldBooks(bookSale4)

        y = PreChargedObjects.number.nextInt(100000, 999999)
        user6 = Users(y, "Atziri", "Mancilla", 512323457, 28, "Calle Hacienda Azul #63")
        bookRent5 = []
        bookSale5 = []
        user6.setRentedBooks(bookRent5)
        user6.setSoldBooks(bookSale5)

        # Adding users to the library list
        # This code snippet is written in Java

        Library.addUser(user1)
        Library.addUser(user2)
        Library.addUser(user3)
        Library.addUser(user4)
        Library.addUser(user5)
        Library.addUser(user6)