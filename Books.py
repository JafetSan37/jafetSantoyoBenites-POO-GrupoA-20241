class Books:
    def __init__(self, ID, title, author, year):
        self.ID = ID
        self.title = title
        self.author = author
        self.year = year
        self.rented = False

    def get_ID(self):
        return self.ID

    def get_title(self):
        return self.title

    def set_title(self, title):
        self.title = title

    def get_author(self):
        return self.author

    def set_author(self, author):
        self.author = author

    def get_year(self):
        return self.year

    def set_year(self, year):
        self.year = year

    def is_rented(self):
        return self.rented

    def set_rented(self, rented):
        self.rented = rented