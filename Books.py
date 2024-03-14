class Books:
    def __init__(self, ID, title, author, year):
        self.ID = ID
        self.title = title
        self.author = author
        self.year = year
        self.rented = False
    
    def getID(self):
        return self.ID
    
    def getTitle(self):
        return self.title
    
    def setTitle(self, title):
        self.title = title
    
    def getAuthor(self):
        return self.author
    
    def setAuthor(self, author):
        self.author = author
    
    def getYear(self):
        return self.year
    
    def setYear(self, year):
        self.year = year
    
    def isRented(self):
        return self.rented
    
    def setRented(self, rented):
        self.rented = rented
