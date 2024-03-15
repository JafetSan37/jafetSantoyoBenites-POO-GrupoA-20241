class Users:
    def __init__(self, IDuser, name, lastName, cellNumber, age, address):
        self.IDuser = IDuser
        self.name = name
        self.lastName = lastName
        self.cellNumber = cellNumber
        self.age = age
        self.address = address
        self.rentedBooks = []
        self.soldBooks = []

    def get_IDuser(self):
        return self.IDuser

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_lastName(self):
        return self.lastName

    def set_lastName(self, lastName):
        self.lastName = lastName

    def get_age(self):
        return self.age

    def set_age(self, age):
        self.age = age

    def get_cellNumber(self):
        return self.cellNumber

    def set_cellNumber(self, cellNumber):
        self.cellNumber = cellNumber

    def get_address(self):
        return self.address

    def set_address(self, address):
        self.address = address

    def get_rentedBooks(self):
        return self.rentedBooks

    def add_book_user(self, book):
        self.rentedBooks.append(book)

    def get_soldBooks(self):
        return self.soldBooks

    def add_sold_book_user(self, book):
        self.soldBooks.append(book)