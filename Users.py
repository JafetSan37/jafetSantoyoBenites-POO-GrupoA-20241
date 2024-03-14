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

    def getIDuser(self):
        return self.IDuser

    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    def getLastName(self):
        return self.lastName

    def setLastName(self, lastName):
        self.lastName = lastName

    def getAge(self):
        return self.age

    def setAge(self, age):
        self.age = age

    def getCellNumber(self):
        return self.cellNumber

    def setCellNumber(self, cellNumber):
        self.cellNumber = cellNumber

    def getAddress(self):
        return self.address

    def setAddress(self, address):
        self.address = address

    def getRentedBooks(self):
        return self.rentedBooks

    def setRentedBooks(self, rentedBooks):
        self.rentedBooks = rentedBooks

    def addBookUser(self, book):
        self.rentedBooks.append(book)

    def getSoldBooks(self):
        return self.soldBooks

    def setSoldBooks(self, soldBooks):
        self.soldBooks = soldBooks

    def addSoldBookUser(self, book):
        self.soldBooks.append(book)