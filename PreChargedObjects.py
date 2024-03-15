import random
from Books import Books
from Library import Library
from SaleBooks import SaleBooks
from Users import Users

import random

class PreChargedObjects:
    def __init__(self):
        self.library = Library()
        self.number = random.Random()

    def add_elements(self):
        # Libros para Renta
        a, b, c, d, e, f = self.number.sample(range(100000, 999999), 6)
        book1 = Books(a, "Cazadores de Sombras: Ciudad de Hueso", "Cassandra Clare", 2007)
        book1.set_rented(False)
        book2 = Books(b, "Caballo de Troya 1: Jerusalén", "J.J. Benítez", 1987)
        book2.set_rented(False)
        book3 = Books(c, "Amarse con los Ojos Abiertos", "J.Bucay y S.Salinas", 2002)
        book3.set_rented(False)
        book4 = Books(d, "Harry Potter: La Piedra Filosofal", "J.K. Rowling", 2001)
        book4.set_rented(False)
        book5 = Books(e, "GOG", "J.J. Benítez", 2017)
        book5.set_rented(False)
        book6 = Books(f, "Los Cuatro Acuerdos", "Miguel Ruiz", 2000)
        book6.set_rented(False)
        # Añadiendo los libros a la librería
        self.library.add_book(book1)
        self.library.add_book(book2)
        self.library.add_book(book3)
        self.library.add_book(book4)
        self.library.add_book(book5)
        self.library.add_book(book6)
        # Libros para Venta
        h, i, j, k, l, m = self.number.sample(range(100000, 999999), 6)
        sellbook1 = SaleBooks(h, "Cazadores de Sombras: Ciudad de Hueso", "Cassandra Clare", 2017, 328, 15)
        sellbook1.set_available(True)
        sellbook2 = SaleBooks(i, "Caballo de Troya 1: Jerusalén", "J.J. Benítez", 2011, 418, 5)
        sellbook2.set_available(True)
        sellbook3 = SaleBooks(j, "Amarse con los Ojos Abiertos", "J.Bucay y S.Salinas", 2019, 345, 12)
        sellbook3.set_available(True)
        sellbook4 = SaleBooks(k, "Harry Potter: La Piedra Filosofal", "J.K. Rowling", 2020, 369, 10)
        sellbook4.set_available(True)
        sellbook5 = SaleBooks(l, "GOG", "J.J. Benítez", 2022, 158, 20)
        sellbook5.set_available(True)
        sellbook6 = SaleBooks(m, "Los Cuatro Acuerdos", "Miguel Ruiz", 2009, 280, 6)
        sellbook6.set_available(True)
        # Añadiendo a la librería sección ventas
        self.library.add_sell_book(sellbook1)
        self.library.add_sell_book(sellbook2)
        self.library.add_sell_book(sellbook3)
        self.library.add_sell_book(sellbook4)
        self.library.add_sell_book(sellbook5)
        self.library.add_sell_book(sellbook6)
        # Usuarios pre-registrados
        q, w, u, r, t, y = self.number.sample(range(100000, 999999), 6)
        user1 = Users(q, "Jafet", "Santoyo", 512323457, 27, "Calle Ezequiel #78")
        #user1.set_rented_books([])
        #user1.set_sold_books([])
        user2 = Users(w, "Fátima", "Rivera", 512323457, 24, "Calle Fco. Rincón #56")
        #user2.set_rented_books([])
        #user2.set_sold_books([])
        user3 = Users(u, "Andrés", "Benites", 512323457, 21, "Calle Ezequiel #78")
        #user3.set_rented_books([])
        #user3.set_sold_books([])
        user4 = Users(r, "Andrea", "Durán", 512323457, 27, "Calle El Porvenir #39")
        #user4.set_rented_books([])
        #user4.set_sold_books([])
        user5 = Users(t, "Alejandro", "Montejano", 512323457, 24, "Calle Del Río #10")
        #user5.set_rented_books([])
        #user5.set_sold_books([])
        user6 = Users(y, "Atziri", "Mancilla", 512323457, 28, "Calle Hacienda Azul #63")
        #user6.set_rented_books([])
        #user6.set_sold_books([])
        # Añadiendo usuarios a la lista de la librería
        self.library.add_user(user1)
        self.library.add_user(user2)
        self.library.add_user(user3)
        self.library.add_user(user4)
        self.library.add_user(user5)
        self.library.add_user(user6)